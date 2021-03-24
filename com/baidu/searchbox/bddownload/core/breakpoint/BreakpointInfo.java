package com.baidu.searchbox.bddownload.core.breakpoint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.download.DownloadStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class BreakpointInfo {
    public final List<BlockInfo> blockInfoList = new ArrayList();
    public boolean chunked;
    public String etag;
    public final DownloadStrategy.FilenameHolder filenameHolder;
    public final int id;
    @NonNull
    public final File parentFile;
    @Nullable
    public File targetFile;
    public final boolean taskOnlyProvidedParentPath;
    public final String url;

    public BreakpointInfo(int i, @NonNull String str, @NonNull File file, @Nullable String str2) {
        this.id = i;
        this.url = str;
        this.parentFile = file;
        if (Util.isEmpty(str2)) {
            this.filenameHolder = new DownloadStrategy.FilenameHolder();
            this.taskOnlyProvidedParentPath = true;
            return;
        }
        this.filenameHolder = new DownloadStrategy.FilenameHolder(str2);
        this.taskOnlyProvidedParentPath = false;
        this.targetFile = new File(file, str2);
    }

    public void addBlock(BlockInfo blockInfo) {
        this.blockInfoList.add(blockInfo);
    }

    public BreakpointInfo copy() {
        BreakpointInfo breakpointInfo = new BreakpointInfo(this.id, this.url, this.parentFile, this.filenameHolder.get(), this.taskOnlyProvidedParentPath);
        breakpointInfo.chunked = this.chunked;
        for (BlockInfo blockInfo : this.blockInfoList) {
            breakpointInfo.blockInfoList.add(blockInfo.copy());
        }
        return breakpointInfo;
    }

    public BreakpointInfo copyWithReplaceId(int i) {
        BreakpointInfo breakpointInfo = new BreakpointInfo(i, this.url, this.parentFile, this.filenameHolder.get(), this.taskOnlyProvidedParentPath);
        breakpointInfo.chunked = this.chunked;
        for (BlockInfo blockInfo : this.blockInfoList) {
            breakpointInfo.blockInfoList.add(blockInfo.copy());
        }
        return breakpointInfo;
    }

    public BreakpointInfo copyWithReplaceIdAndUrl(int i, String str) {
        BreakpointInfo breakpointInfo = new BreakpointInfo(i, str, this.parentFile, this.filenameHolder.get(), this.taskOnlyProvidedParentPath);
        breakpointInfo.chunked = this.chunked;
        for (BlockInfo blockInfo : this.blockInfoList) {
            breakpointInfo.blockInfoList.add(blockInfo.copy());
        }
        return breakpointInfo;
    }

    public BlockInfo getBlock(int i) {
        return this.blockInfoList.get(i);
    }

    public int getBlockCount() {
        return this.blockInfoList.size();
    }

    @Nullable
    public String getEtag() {
        return this.etag;
    }

    @Nullable
    public File getFile() {
        String str = this.filenameHolder.get();
        if (str == null) {
            return null;
        }
        if (this.targetFile == null) {
            this.targetFile = new File(this.parentFile, str);
        }
        return this.targetFile;
    }

    @Nullable
    public String getFilename() {
        return this.filenameHolder.get();
    }

    public DownloadStrategy.FilenameHolder getFilenameHolder() {
        return this.filenameHolder;
    }

    public int getId() {
        return this.id;
    }

    public long getLastLength() {
        return getTotalLength() - getTotalOffset();
    }

    @NonNull
    public File getParentFile() {
        return this.parentFile;
    }

    public long getTotalLength() {
        if (isChunked()) {
            return getTotalOffset();
        }
        long j = 0;
        Iterator it = ((ArrayList) ((ArrayList) this.blockInfoList).clone()).iterator();
        while (it.hasNext()) {
            j += ((BlockInfo) it.next()).getContentLength();
        }
        return j;
    }

    public long getTotalOffset() {
        ArrayList arrayList = (ArrayList) ((ArrayList) this.blockInfoList).clone();
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            j += ((BlockInfo) arrayList.get(i)).getCurrentOffset();
        }
        return j;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public boolean isLastBlock(int i) {
        return i == this.blockInfoList.size() - 1;
    }

    public boolean isSameFrom(DownloadTask downloadTask) {
        if (this.parentFile.equals(downloadTask.getParentFile()) && this.url.equals(downloadTask.getUrl())) {
            String filename = downloadTask.getFilename();
            if (filename == null || !filename.equals(this.filenameHolder.get())) {
                if (this.taskOnlyProvidedParentPath && downloadTask.isFilenameFromResponse()) {
                    return filename == null || filename.equals(this.filenameHolder.get());
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isSingleBlock() {
        return this.blockInfoList.size() == 1;
    }

    public boolean isTaskOnlyProvidedParentPath() {
        return this.taskOnlyProvidedParentPath;
    }

    public void resetBlockInfos() {
        this.blockInfoList.clear();
    }

    public void resetInfo() {
        this.blockInfoList.clear();
        this.etag = null;
    }

    public void reuseBlocks(BreakpointInfo breakpointInfo) {
        this.blockInfoList.clear();
        this.blockInfoList.addAll(breakpointInfo.blockInfoList);
    }

    public void setChunked(boolean z) {
        this.chunked = z;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public String toString() {
        return "id[" + this.id + "] url[" + this.url + "] etag[" + this.etag + "] taskOnlyProvidedParentPath[" + this.taskOnlyProvidedParentPath + "] parent path[" + this.parentFile + "] filename[" + this.filenameHolder.get() + "] block(s):" + this.blockInfoList.toString();
    }

    public BreakpointInfo(int i, @NonNull String str, @NonNull File file, @Nullable String str2, boolean z) {
        this.id = i;
        this.url = str;
        this.parentFile = file;
        if (Util.isEmpty(str2)) {
            this.filenameHolder = new DownloadStrategy.FilenameHolder();
        } else {
            this.filenameHolder = new DownloadStrategy.FilenameHolder(str2);
        }
        this.taskOnlyProvidedParentPath = z;
    }
}
