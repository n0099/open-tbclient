package com.baidu.searchbox.bddownload.core.breakpoint;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.IdentifiedTask;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class BreakpointStoreOnCache implements DownloadStore {
    public static final int FIRST_ID = 1;
    public final List<Integer> fileDirtyList;
    @NonNull
    public final KeyToIdMap keyToIdMap;
    public final HashMap<String, String> responseFilenameMap;
    public final List<Integer> sortedOccupiedIds;
    public final SparseArray<BreakpointInfo> storedInfos;
    public final SparseArray<IdentifiedTask> unStoredTasks;

    public BreakpointStoreOnCache() {
        this(new SparseArray(), new ArrayList(), new HashMap());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        r1 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int allocateId() {
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i2 = 1;
            if (i4 >= this.sortedOccupiedIds.size()) {
                break;
            }
            Integer num = this.sortedOccupiedIds.get(i4);
            if (num == null) {
                i3 = i5 + 1;
                break;
            }
            int intValue = num.intValue();
            if (i5 != 0) {
                int i6 = i5 + 1;
                if (intValue != i6) {
                    i3 = i6;
                    break;
                }
            } else if (intValue != 1) {
                i3 = 1;
                break;
            }
            i4++;
            i5 = intValue;
        }
        if (i3 != 0) {
            i2 = i3;
        } else if (!this.sortedOccupiedIds.isEmpty()) {
            i2 = 1 + this.sortedOccupiedIds.get(this.sortedOccupiedIds.size() - 1).intValue();
            i4 = this.sortedOccupiedIds.size();
        }
        this.sortedOccupiedIds.add(i4, Integer.valueOf(i2));
        return i2;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @NonNull
    public BreakpointInfo createAndInsert(@NonNull DownloadTask downloadTask) {
        int id = downloadTask.getId();
        BreakpointInfo breakpointInfo = new BreakpointInfo(id, downloadTask.getUrl(), downloadTask.getParentFile(), downloadTask.getFilename());
        synchronized (this) {
            this.storedInfos.put(id, breakpointInfo);
            this.unStoredTasks.remove(id);
        }
        return breakpointInfo;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public BreakpointInfo findAnotherInfoFromCompare(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        SparseArray<BreakpointInfo> clone;
        synchronized (this) {
            clone = this.storedInfos.clone();
        }
        int size = clone.size();
        for (int i2 = 0; i2 < size; i2++) {
            BreakpointInfo valueAt = clone.valueAt(i2);
            if (valueAt != breakpointInfo && valueAt.isSameFrom(downloadTask)) {
                return valueAt;
            }
        }
        return null;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public synchronized int findOrCreateId(@NonNull DownloadTask downloadTask) {
        Integer num = this.keyToIdMap.get(downloadTask);
        if (num != null) {
            return num.intValue();
        }
        int size = this.storedInfos.size();
        for (int i2 = 0; i2 < size; i2++) {
            BreakpointInfo valueAt = this.storedInfos.valueAt(i2);
            if (valueAt != null && valueAt.isSameFrom(downloadTask)) {
                return valueAt.id;
            }
        }
        int size2 = this.unStoredTasks.size();
        for (int i3 = 0; i3 < size2; i3++) {
            IdentifiedTask valueAt2 = this.unStoredTasks.valueAt(i3);
            if (valueAt2 != null && valueAt2.compareIgnoreId(downloadTask)) {
                return valueAt2.getId();
            }
        }
        int allocateId = allocateId();
        this.unStoredTasks.put(allocateId, downloadTask.mock(allocateId));
        this.keyToIdMap.add(downloadTask, allocateId);
        return allocateId;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public BreakpointInfo get(int i2) {
        return this.storedInfos.get(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    @Nullable
    public BreakpointInfo getAfterCompleted(int i2) {
        return null;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public String getResponseFilename(String str) {
        return this.responseFilenameMap.get(str);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i2) {
        return this.fileDirtyList.contains(Integer.valueOf(i2));
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        return true;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i2) {
        boolean remove;
        synchronized (this.fileDirtyList) {
            remove = this.fileDirtyList.remove(Integer.valueOf(i2));
        }
        return remove;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i2) {
        if (this.fileDirtyList.contains(Integer.valueOf(i2))) {
            return false;
        }
        synchronized (this.fileDirtyList) {
            if (this.fileDirtyList.contains(Integer.valueOf(i2))) {
                return false;
            }
            this.fileDirtyList.add(Integer.valueOf(i2));
            return true;
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(@NonNull BreakpointInfo breakpointInfo, int i2, long j) throws IOException {
        BreakpointInfo breakpointInfo2 = this.storedInfos.get(breakpointInfo.id);
        if (breakpointInfo == breakpointInfo2) {
            breakpointInfo2.getBlock(i2).increaseCurrentOffset(j);
            return;
        }
        throw new IOException("Info not on store!");
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i2, @NonNull EndCause endCause, @Nullable Exception exc) {
        if (endCause == EndCause.COMPLETED) {
            remove(i2);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i2) {
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public synchronized void remove(int i2) {
        this.storedInfos.remove(i2);
        if (this.unStoredTasks.get(i2) == null) {
            this.sortedOccupiedIds.remove(Integer.valueOf(i2));
        }
        this.keyToIdMap.remove(i2);
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean update(@NonNull BreakpointInfo breakpointInfo) {
        String filename = breakpointInfo.getFilename();
        if (breakpointInfo.isTaskOnlyProvidedParentPath() && filename != null) {
            this.responseFilenameMap.put(breakpointInfo.getUrl(), filename);
        }
        BreakpointInfo breakpointInfo2 = this.storedInfos.get(breakpointInfo.id);
        if (breakpointInfo2 != null) {
            if (breakpointInfo2 == breakpointInfo) {
                return true;
            }
            synchronized (this) {
                this.storedInfos.put(breakpointInfo.id, breakpointInfo.copy());
            }
            return true;
        }
        return false;
    }

    public BreakpointStoreOnCache(SparseArray<BreakpointInfo> sparseArray, List<Integer> list, HashMap<String, String> hashMap, SparseArray<IdentifiedTask> sparseArray2, List<Integer> list2, KeyToIdMap keyToIdMap) {
        this.unStoredTasks = sparseArray2;
        this.fileDirtyList = list;
        this.storedInfos = sparseArray;
        this.responseFilenameMap = hashMap;
        this.sortedOccupiedIds = list2;
        this.keyToIdMap = keyToIdMap;
    }

    public BreakpointStoreOnCache(SparseArray<BreakpointInfo> sparseArray, List<Integer> list, HashMap<String, String> hashMap) {
        this.unStoredTasks = new SparseArray<>();
        this.storedInfos = sparseArray;
        this.fileDirtyList = list;
        this.responseFilenameMap = hashMap;
        this.keyToIdMap = new KeyToIdMap();
        int size = sparseArray.size();
        this.sortedOccupiedIds = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.sortedOccupiedIds.add(Integer.valueOf(sparseArray.valueAt(i2).id));
        }
        Collections.sort(this.sortedOccupiedIds);
    }
}
