package com.baidu.searchbox.bddownload.core.breakpoint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.download.DownloadStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class BreakpointInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<BlockInfo> blockInfoList;
    public boolean chunked;
    public String etag;
    public final DownloadStrategy.FilenameHolder filenameHolder;
    public final int id;
    public String mimeType;
    @NonNull
    public final File parentFile;
    @Nullable
    public File targetFile;
    public final boolean taskOnlyProvidedParentPath;
    public final String url;

    public BreakpointInfo(int i2, @NonNull String str, @NonNull File file, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, file, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.id = i2;
        this.url = str;
        this.parentFile = file;
        this.blockInfoList = new ArrayList();
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, blockInfo) == null) {
            this.blockInfoList.add(blockInfo);
        }
    }

    public BreakpointInfo copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BreakpointInfo breakpointInfo = new BreakpointInfo(this.id, this.url, this.parentFile, this.filenameHolder.get(), this.taskOnlyProvidedParentPath);
            breakpointInfo.chunked = this.chunked;
            for (BlockInfo blockInfo : this.blockInfoList) {
                breakpointInfo.blockInfoList.add(blockInfo.copy());
            }
            return breakpointInfo;
        }
        return (BreakpointInfo) invokeV.objValue;
    }

    public BreakpointInfo copyWithReplaceId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            BreakpointInfo breakpointInfo = new BreakpointInfo(i2, this.url, this.parentFile, this.filenameHolder.get(), this.taskOnlyProvidedParentPath);
            breakpointInfo.chunked = this.chunked;
            for (BlockInfo blockInfo : this.blockInfoList) {
                breakpointInfo.blockInfoList.add(blockInfo.copy());
            }
            return breakpointInfo;
        }
        return (BreakpointInfo) invokeI.objValue;
    }

    public BreakpointInfo copyWithReplaceIdAndUrl(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, str)) == null) {
            BreakpointInfo breakpointInfo = new BreakpointInfo(i2, str, this.parentFile, this.filenameHolder.get(), this.taskOnlyProvidedParentPath);
            breakpointInfo.chunked = this.chunked;
            for (BlockInfo blockInfo : this.blockInfoList) {
                breakpointInfo.blockInfoList.add(blockInfo.copy());
            }
            return breakpointInfo;
        }
        return (BreakpointInfo) invokeIL.objValue;
    }

    public BlockInfo getBlock(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.blockInfoList.get(i2) : (BlockInfo) invokeI.objValue;
    }

    public int getBlockCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.blockInfoList.size() : invokeV.intValue;
    }

    @Nullable
    public String getEtag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.etag : (String) invokeV.objValue;
    }

    @Nullable
    public File getFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = this.filenameHolder.get();
            if (str == null) {
                return null;
            }
            if (this.targetFile == null) {
                this.targetFile = new File(this.parentFile, str);
            }
            return this.targetFile;
        }
        return (File) invokeV.objValue;
    }

    @Nullable
    public String getFilename() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.filenameHolder.get() : (String) invokeV.objValue;
    }

    public DownloadStrategy.FilenameHolder getFilenameHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.filenameHolder : (DownloadStrategy.FilenameHolder) invokeV.objValue;
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.id : invokeV.intValue;
    }

    public long getLastLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? getTotalLength() - getTotalOffset() : invokeV.longValue;
    }

    @Nullable
    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mimeType : (String) invokeV.objValue;
    }

    @NonNull
    public File getParentFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.parentFile : (File) invokeV.objValue;
    }

    public long getTotalLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (isChunked()) {
                return getTotalOffset();
            }
            long j2 = 0;
            Iterator it = ((ArrayList) ((ArrayList) this.blockInfoList).clone()).iterator();
            while (it.hasNext()) {
                j2 += ((BlockInfo) it.next()).getContentLength();
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public long getTotalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ArrayList arrayList = (ArrayList) ((ArrayList) this.blockInfoList).clone();
            int size = arrayList.size();
            long j2 = 0;
            for (int i2 = 0; i2 < size; i2++) {
                j2 += ((BlockInfo) arrayList.get(i2)).getCurrentOffset();
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public boolean isChunked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.chunked : invokeV.booleanValue;
    }

    public boolean isLastBlock(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) ? i2 == this.blockInfoList.size() - 1 : invokeI.booleanValue;
    }

    public boolean isSameFrom(DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, downloadTask)) == null) {
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
        return invokeL.booleanValue;
    }

    public boolean isSingleBlock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.blockInfoList.size() == 1 : invokeV.booleanValue;
    }

    public boolean isTaskOnlyProvidedParentPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.taskOnlyProvidedParentPath : invokeV.booleanValue;
    }

    public void resetBlockInfos() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.blockInfoList.clear();
        }
    }

    public void resetInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.blockInfoList.clear();
            this.etag = null;
        }
    }

    public void reuseBlocks(BreakpointInfo breakpointInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, breakpointInfo) == null) {
            this.blockInfoList.clear();
            this.blockInfoList.addAll(breakpointInfo.blockInfoList);
        }
    }

    public void setChunked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.chunked = z;
        }
    }

    public void setEtag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.etag = str;
        }
    }

    public void setMimeType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.mimeType = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return "id[" + this.id + "] url[" + this.url + "] etag[" + this.etag + "] taskOnlyProvidedParentPath[" + this.taskOnlyProvidedParentPath + "] parent path[" + this.parentFile + "] filename[" + this.filenameHolder.get() + "] block(s):" + this.blockInfoList.toString();
        }
        return (String) invokeV.objValue;
    }

    public BreakpointInfo(int i2, @NonNull String str, @NonNull File file, @Nullable String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, file, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.id = i2;
        this.url = str;
        this.parentFile = file;
        this.blockInfoList = new ArrayList();
        if (Util.isEmpty(str2)) {
            this.filenameHolder = new DownloadStrategy.FilenameHolder();
        } else {
            this.filenameHolder = new DownloadStrategy.FilenameHolder(str2);
        }
        this.taskOnlyProvidedParentPath = z;
    }
}
