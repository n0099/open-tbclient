package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStoreOnCache;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes2.dex */
public class BreakpointStoreOnSQLite implements DownloadStore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BreakpointStoreOnSQLite";
    public transient /* synthetic */ FieldHolder $fh;
    public final BreakpointSQLiteHelper helper;
    public final BreakpointStoreOnCache onCache;

    public BreakpointStoreOnSQLite(BreakpointSQLiteHelper breakpointSQLiteHelper, BreakpointStoreOnCache breakpointStoreOnCache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {breakpointSQLiteHelper, breakpointStoreOnCache};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.helper = breakpointSQLiteHelper;
        this.onCache = breakpointStoreOnCache;
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.helper.close();
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @NonNull
    public BreakpointInfo createAndInsert(@NonNull DownloadTask downloadTask) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask)) == null) {
            BreakpointInfo createAndInsert = this.onCache.createAndInsert(downloadTask);
            this.helper.insert(createAndInsert);
            return createAndInsert;
        }
        return (BreakpointInfo) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public BreakpointInfo findAnotherInfoFromCompare(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadTask, breakpointInfo)) == null) ? this.onCache.findAnotherInfoFromCompare(downloadTask, breakpointInfo) : (BreakpointInfo) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public int findOrCreateId(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, downloadTask)) == null) ? this.onCache.findOrCreateId(downloadTask) : invokeL.intValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public BreakpointInfo get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? this.onCache.get(i) : (BreakpointInfo) invokeI.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.onCache.getResponseFilename(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? this.onCache.isFileDirty(i) : invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.onCache.markFileClear(i)) {
                this.helper.markFileClear(i);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.onCache.markFileDirty(i)) {
                this.helper.markFileDirty(i);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(@NonNull BreakpointInfo breakpointInfo, int i, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{breakpointInfo, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.onCache.onSyncToFilesystemSuccess(breakpointInfo, i, j);
            this.helper.updateBlockIncrease(breakpointInfo, i, breakpointInfo.getBlock(i).getCurrentOffset());
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i, @NonNull EndCause endCause, @Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048588, this, i, endCause, exc) == null) {
            this.onCache.onTaskEnd(i, endCause, exc);
            if (endCause == EndCause.COMPLETED) {
                this.helper.removeInfo(i);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.onCache.onTaskStart(i);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public void remove(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.onCache.remove(i);
            this.helper.removeInfo(i);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean update(@NonNull BreakpointInfo breakpointInfo) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, breakpointInfo)) == null) {
            boolean update = this.onCache.update(breakpointInfo);
            this.helper.updateInfo(breakpointInfo);
            String filename = breakpointInfo.getFilename();
            Util.d(TAG, "update " + breakpointInfo);
            if (breakpointInfo.isTaskOnlyProvidedParentPath() && filename != null) {
                this.helper.updateFilename(breakpointInfo.getUrl(), filename);
            }
            return update;
        }
        return invokeL.booleanValue;
    }

    public BreakpointStoreOnSQLite(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BreakpointSQLiteHelper breakpointSQLiteHelper = new BreakpointSQLiteHelper(context.getApplicationContext());
        this.helper = breakpointSQLiteHelper;
        this.onCache = new BreakpointStoreOnCache(breakpointSQLiteHelper.loadToCache(), this.helper.loadDirtyFileList(), this.helper.loadResponseFilenameToMap());
    }
}
