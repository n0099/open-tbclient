package com.baidu.searchbox.bddownload.core.breakpoint;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.IdentifiedTask;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class BreakpointStoreOnCache implements DownloadStore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_ID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Integer> fileDirtyList;
    @NonNull
    public final KeyToIdMap keyToIdMap;
    public final HashMap<String, String> responseFilenameMap;
    public final List<Integer> sortedOccupiedIds;
    public final SparseArray<BreakpointInfo> storedInfos;
    public final SparseArray<IdentifiedTask> unStoredTasks;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BreakpointStoreOnCache() {
        this(new SparseArray(), new ArrayList(), new HashMap());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((SparseArray) objArr[0], (List) objArr[1], (HashMap) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        r1 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int allocateId() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    i = 1;
                    if (i3 >= this.sortedOccupiedIds.size()) {
                        break;
                    }
                    Integer num = this.sortedOccupiedIds.get(i3);
                    if (num == null) {
                        i2 = i4 + 1;
                        break;
                    }
                    int intValue = num.intValue();
                    if (i4 != 0) {
                        int i5 = i4 + 1;
                        if (intValue != i5) {
                            i2 = i5;
                            break;
                        }
                    } else if (intValue != 1) {
                        i2 = 1;
                        break;
                    }
                    i3++;
                    i4 = intValue;
                }
                if (i2 != 0) {
                    i = i2;
                } else if (!this.sortedOccupiedIds.isEmpty()) {
                    i = 1 + this.sortedOccupiedIds.get(this.sortedOccupiedIds.size() - 1).intValue();
                    i3 = this.sortedOccupiedIds.size();
                }
                this.sortedOccupiedIds.add(i3, Integer.valueOf(i));
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @NonNull
    public BreakpointInfo createAndInsert(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask)) == null) {
            int id = downloadTask.getId();
            BreakpointInfo breakpointInfo = new BreakpointInfo(id, downloadTask.getUrl(), downloadTask.getParentFile(), downloadTask.getFilename());
            synchronized (this) {
                this.storedInfos.put(id, breakpointInfo);
                this.unStoredTasks.remove(id);
            }
            return breakpointInfo;
        }
        return (BreakpointInfo) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public BreakpointInfo findAnotherInfoFromCompare(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        InterceptResult invokeLL;
        SparseArray<BreakpointInfo> clone;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, breakpointInfo)) == null) {
            synchronized (this) {
                clone = this.storedInfos.clone();
            }
            int size = clone.size();
            for (int i = 0; i < size; i++) {
                BreakpointInfo valueAt = clone.valueAt(i);
                if (valueAt != breakpointInfo && valueAt.isSameFrom(downloadTask)) {
                    return valueAt;
                }
            }
            return null;
        }
        return (BreakpointInfo) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public synchronized int findOrCreateId(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, downloadTask)) == null) {
            synchronized (this) {
                Integer num = this.keyToIdMap.get(downloadTask);
                if (num != null) {
                    return num.intValue();
                }
                int size = this.storedInfos.size();
                for (int i = 0; i < size; i++) {
                    BreakpointInfo valueAt = this.storedInfos.valueAt(i);
                    if (valueAt != null && valueAt.isSameFrom(downloadTask)) {
                        return valueAt.id;
                    }
                }
                int size2 = this.unStoredTasks.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    IdentifiedTask valueAt2 = this.unStoredTasks.valueAt(i2);
                    if (valueAt2 != null && valueAt2.compareIgnoreId(downloadTask)) {
                        return valueAt2.getId();
                    }
                }
                int allocateId = allocateId();
                this.unStoredTasks.put(allocateId, downloadTask.mock(allocateId));
                this.keyToIdMap.add(downloadTask, allocateId);
                return allocateId;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public BreakpointInfo get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? this.storedInfos.get(i) : (BreakpointInfo) invokeI.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    @Nullable
    public BreakpointInfo getAfterCompleted(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return null;
        }
        return (BreakpointInfo) invokeI.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public String getResponseFilename(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.responseFilenameMap.get(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? this.fileDirtyList.contains(Integer.valueOf(i)) : invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i) {
        InterceptResult invokeI;
        boolean remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            synchronized (this.fileDirtyList) {
                remove = this.fileDirtyList.remove(Integer.valueOf(i));
            }
            return remove;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.fileDirtyList.contains(Integer.valueOf(i))) {
                return false;
            }
            synchronized (this.fileDirtyList) {
                if (this.fileDirtyList.contains(Integer.valueOf(i))) {
                    return false;
                }
                this.fileDirtyList.add(Integer.valueOf(i));
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(@NonNull BreakpointInfo breakpointInfo, int i, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{breakpointInfo, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            BreakpointInfo breakpointInfo2 = this.storedInfos.get(breakpointInfo.id);
            if (breakpointInfo == breakpointInfo2) {
                breakpointInfo2.getBlock(i).increaseCurrentOffset(j);
                return;
            }
            throw new IOException("Info not on store!");
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i, @NonNull EndCause endCause, @Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048588, this, i, endCause, exc) == null) && endCause == EndCause.COMPLETED) {
            remove(i);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public synchronized void remove(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            synchronized (this) {
                this.storedInfos.remove(i);
                if (this.unStoredTasks.get(i) == null) {
                    this.sortedOccupiedIds.remove(Integer.valueOf(i));
                }
                this.keyToIdMap.remove(i);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean update(@NonNull BreakpointInfo breakpointInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, breakpointInfo)) == null) {
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
        return invokeL.booleanValue;
    }

    public BreakpointStoreOnCache(SparseArray<BreakpointInfo> sparseArray, List<Integer> list, HashMap<String, String> hashMap, SparseArray<IdentifiedTask> sparseArray2, List<Integer> list2, KeyToIdMap keyToIdMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sparseArray, list, hashMap, sparseArray2, list2, keyToIdMap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.unStoredTasks = sparseArray2;
        this.fileDirtyList = list;
        this.storedInfos = sparseArray;
        this.responseFilenameMap = hashMap;
        this.sortedOccupiedIds = list2;
        this.keyToIdMap = keyToIdMap;
    }

    public BreakpointStoreOnCache(SparseArray<BreakpointInfo> sparseArray, List<Integer> list, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sparseArray, list, hashMap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.unStoredTasks = new SparseArray<>();
        this.storedInfos = sparseArray;
        this.fileDirtyList = list;
        this.responseFilenameMap = hashMap;
        this.keyToIdMap = new KeyToIdMap();
        int size = sparseArray.size();
        this.sortedOccupiedIds = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.sortedOccupiedIds.add(Integer.valueOf(sparseArray.valueAt(i3).id));
        }
        Collections.sort(this.sortedOccupiedIds);
    }
}
