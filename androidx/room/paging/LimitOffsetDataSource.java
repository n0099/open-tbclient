package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mCountQuery;
    public final RoomDatabase mDb;
    public final boolean mInTransaction;
    public final String mLimitOffsetQuery;
    public final InvalidationTracker.Observer mObserver;
    public final RoomSQLiteQuery mSourceQuery;

    public abstract List<T> convertRows(Cursor cursor);

    public LimitOffsetDataSource(RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean z, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {roomDatabase, roomSQLiteQuery, Boolean.valueOf(z), strArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDb = roomDatabase;
        this.mSourceQuery = roomSQLiteQuery;
        this.mInTransaction = z;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + this.mSourceQuery.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + this.mSourceQuery.getSql() + " ) LIMIT ? OFFSET ?";
        this.mObserver = new InvalidationTracker.Observer(this, strArr) { // from class: androidx.room.paging.LimitOffsetDataSource.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LimitOffsetDataSource this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(strArr);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, strArr};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super((String[]) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@NonNull Set<String> set) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, set) == null) {
                    this.this$0.invalidate();
                }
            }
        };
        roomDatabase.getInvalidationTracker().addWeakObserver(this.mObserver);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LimitOffsetDataSource(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z, String... strArr) {
        this(roomDatabase, RoomSQLiteQuery.copyFrom(supportSQLiteQuery), z, strArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {roomDatabase, supportSQLiteQuery, Boolean.valueOf(z), strArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((RoomDatabase) objArr2[0], (RoomSQLiteQuery) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (String[]) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public int countItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
            acquire.copyArgumentsFrom(this.mSourceQuery);
            Cursor query = this.mDb.query(acquire);
            try {
                if (!query.moveToFirst()) {
                    return 0;
                }
                return query.getInt(0);
            } finally {
                query.close();
                acquire.release();
            }
        }
        return invokeV.intValue;
    }

    public boolean isInvalid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.mDb.getInvalidationTracker().refreshVersionsSync();
            return super.isInvalid();
        }
        return invokeV.booleanValue;
    }

    public void loadInitial(@NonNull PositionalDataSource.LoadInitialParams loadInitialParams, @NonNull PositionalDataSource.LoadInitialCallback<T> loadInitialCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, loadInitialParams, loadInitialCallback) == null) {
            int countItems = countItems();
            if (countItems == 0) {
                loadInitialCallback.onResult(Collections.emptyList(), 0, 0);
                return;
            }
            int computeInitialLoadPosition = computeInitialLoadPosition(loadInitialParams, countItems);
            int computeInitialLoadSize = computeInitialLoadSize(loadInitialParams, computeInitialLoadPosition, countItems);
            List<T> loadRange = loadRange(computeInitialLoadPosition, computeInitialLoadSize);
            if (loadRange != null && loadRange.size() == computeInitialLoadSize) {
                loadInitialCallback.onResult(loadRange, computeInitialLoadPosition, countItems);
            } else {
                invalidate();
            }
        }
    }

    @Nullable
    public List<T> loadRange(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
            acquire.copyArgumentsFrom(this.mSourceQuery);
            acquire.bindLong(acquire.getArgCount() - 1, i2);
            acquire.bindLong(acquire.getArgCount(), i);
            if (this.mInTransaction) {
                this.mDb.beginTransaction();
                Cursor cursor = null;
                try {
                    cursor = this.mDb.query(acquire);
                    List<T> convertRows = convertRows(cursor);
                    this.mDb.setTransactionSuccessful();
                    return convertRows;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                    this.mDb.endTransaction();
                    acquire.release();
                }
            }
            Cursor query = this.mDb.query(acquire);
            try {
                return convertRows(query);
            } finally {
                query.close();
                acquire.release();
            }
        }
        return (List) invokeII.objValue;
    }

    public void loadRange(@NonNull PositionalDataSource.LoadRangeParams loadRangeParams, @NonNull PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, loadRangeParams, loadRangeCallback) == null) {
            List<T> loadRange = loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize);
            if (loadRange != null) {
                loadRangeCallback.onResult(loadRange);
            } else {
                invalidate();
            }
        }
    }
}
