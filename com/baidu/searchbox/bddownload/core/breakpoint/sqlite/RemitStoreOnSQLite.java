package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor;
import com.baidu.searchbox.bddownload.core.cause.EndCause;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public class RemitStoreOnSQLite implements RemitSyncExecutor.RemitAgent, DownloadStore {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final BreakpointStoreOnSQLite onSQLiteWrapper;
    @NonNull
    public final RemitSyncToDBHelper remitHelper;
    @NonNull
    public final BreakpointSQLiteHelper sqLiteHelper;
    @NonNull
    public final DownloadStore sqliteCache;

    public RemitStoreOnSQLite(@NonNull BreakpointStoreOnSQLite breakpointStoreOnSQLite) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {breakpointStoreOnSQLite};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.remitHelper = new RemitSyncToDBHelper(this);
        this.onSQLiteWrapper = breakpointStoreOnSQLite;
        this.sqliteCache = breakpointStoreOnSQLite.onCache;
        this.sqLiteHelper = breakpointStoreOnSQLite.helper;
    }

    public static void setRemitToDBDelayMillis(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            BreakpointStore breakpointStore = BdDownload.with().breakpointStore();
            if (breakpointStore instanceof RemitStoreOnSQLite) {
                ((RemitStoreOnSQLite) breakpointStore).remitHelper.delayMillis = Math.max(0, i2);
                return;
            }
            throw new IllegalStateException("The current store is " + breakpointStore + " not RemitStoreOnSQLite!");
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @NonNull
    public BreakpointInfo createAndInsert(@NonNull DownloadTask downloadTask) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadTask)) == null) {
            if (this.remitHelper.isNotFreeToDatabase(downloadTask.getId())) {
                return this.sqliteCache.createAndInsert(downloadTask);
            }
            return this.onSQLiteWrapper.createAndInsert(downloadTask);
        }
        return (BreakpointInfo) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public BreakpointInfo findAnotherInfoFromCompare(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask, breakpointInfo)) == null) ? this.onSQLiteWrapper.findAnotherInfoFromCompare(downloadTask, breakpointInfo) : (BreakpointInfo) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public int findOrCreateId(@NonNull DownloadTask downloadTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadTask)) == null) ? this.onSQLiteWrapper.findOrCreateId(downloadTask) : invokeL.intValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public BreakpointInfo get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.onSQLiteWrapper.get(i2) : (BreakpointInfo) invokeI.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    @Nullable
    public BreakpointInfo getAfterCompleted(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return null;
        }
        return (BreakpointInfo) invokeI.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    @Nullable
    public String getResponseFilename(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.onSQLiteWrapper.getResponseFilename(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isFileDirty(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? this.onSQLiteWrapper.isFileDirty(i2) : invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean isOnlyMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileClear(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.onSQLiteWrapper.markFileClear(i2) : invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public boolean markFileDirty(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? this.onSQLiteWrapper.markFileDirty(i2) : invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onSyncToFilesystemSuccess(@NonNull BreakpointInfo breakpointInfo, int i2, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{breakpointInfo, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (this.remitHelper.isNotFreeToDatabase(breakpointInfo.getId())) {
                this.sqliteCache.onSyncToFilesystemSuccess(breakpointInfo, i2, j2);
            } else {
                this.onSQLiteWrapper.onSyncToFilesystemSuccess(breakpointInfo, i2, j2);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskEnd(int i2, @NonNull EndCause endCause, @Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i2, endCause, exc) == null) {
            this.sqliteCache.onTaskEnd(i2, endCause, exc);
            if (endCause == EndCause.COMPLETED) {
                this.remitHelper.discard(i2);
            } else {
                this.remitHelper.endAndEnsureToDB(i2);
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore
    public void onTaskStart(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.onSQLiteWrapper.onTaskStart(i2);
            this.remitHelper.onTaskStart(i2);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public void remove(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.sqliteCache.remove(i2);
            this.remitHelper.discard(i2);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor.RemitAgent
    public void removeInfo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.sqLiteHelper.removeInfo(i2);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(List<Integer> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            SQLiteDatabase writableDatabase = this.sqLiteHelper.getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                for (Integer num : list) {
                    syncCacheToDB(num.intValue());
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStore
    public boolean update(@NonNull BreakpointInfo breakpointInfo) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, breakpointInfo)) == null) {
            if (this.remitHelper.isNotFreeToDatabase(breakpointInfo.getId())) {
                return this.sqliteCache.update(breakpointInfo);
            }
            return this.onSQLiteWrapper.update(breakpointInfo);
        }
        return invokeL.booleanValue;
    }

    public RemitStoreOnSQLite(@NonNull RemitSyncToDBHelper remitSyncToDBHelper, @NonNull BreakpointStoreOnSQLite breakpointStoreOnSQLite, @NonNull DownloadStore downloadStore, @NonNull BreakpointSQLiteHelper breakpointSQLiteHelper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {remitSyncToDBHelper, breakpointStoreOnSQLite, downloadStore, breakpointSQLiteHelper};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.remitHelper = remitSyncToDBHelper;
        this.onSQLiteWrapper = breakpointStoreOnSQLite;
        this.sqliteCache = downloadStore;
        this.sqLiteHelper = breakpointSQLiteHelper;
    }

    @Override // com.baidu.searchbox.bddownload.core.breakpoint.sqlite.RemitSyncExecutor.RemitAgent
    public void syncCacheToDB(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.sqLiteHelper.removeInfo(i2);
            BreakpointInfo breakpointInfo = this.sqliteCache.get(i2);
            if (breakpointInfo == null || breakpointInfo.getFilename() == null || breakpointInfo.getTotalOffset() <= 0) {
                return;
            }
            this.sqLiteHelper.insert(breakpointInfo);
        }
    }
}
