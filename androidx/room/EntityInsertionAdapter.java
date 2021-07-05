package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {roomDatabase};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((RoomDatabase) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t);

    public final void insert(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            SupportSQLiteStatement acquire = acquire();
            try {
                bind(acquire, t);
                acquire.executeInsert();
            } finally {
                release(acquire);
            }
        }
    }

    public final long insertAndReturnId(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, t)) == null) {
            SupportSQLiteStatement acquire = acquire();
            try {
                bind(acquire, t);
                return acquire.executeInsert();
            } finally {
                release(acquire);
            }
        }
        return invokeL.longValue;
    }

    public final long[] insertAndReturnIdsArray(Collection<T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) {
            SupportSQLiteStatement acquire = acquire();
            try {
                long[] jArr = new long[collection.size()];
                int i2 = 0;
                for (T t : collection) {
                    bind(acquire, t);
                    jArr[i2] = acquire.executeInsert();
                    i2++;
                }
                return jArr;
            } finally {
                release(acquire);
            }
        }
        return (long[]) invokeL.objValue;
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, collection)) == null) {
            SupportSQLiteStatement acquire = acquire();
            try {
                Long[] lArr = new Long[collection.size()];
                int i2 = 0;
                for (T t : collection) {
                    bind(acquire, t);
                    lArr[i2] = Long.valueOf(acquire.executeInsert());
                    i2++;
                }
                return lArr;
            } finally {
                release(acquire);
            }
        }
        return (Long[]) invokeL.objValue;
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, tArr)) == null) {
            SupportSQLiteStatement acquire = acquire();
            try {
                ArrayList arrayList = new ArrayList(tArr.length);
                int i2 = 0;
                for (T t : tArr) {
                    bind(acquire, t);
                    arrayList.add(i2, Long.valueOf(acquire.executeInsert()));
                    i2++;
                }
                return arrayList;
            } finally {
                release(acquire);
            }
        }
        return (List) invokeL.objValue;
    }

    public final void insert(T[] tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tArr) == null) {
            SupportSQLiteStatement acquire = acquire();
            try {
                for (T t : tArr) {
                    bind(acquire, t);
                    acquire.executeInsert();
                }
            } finally {
                release(acquire);
            }
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tArr)) == null) {
            SupportSQLiteStatement acquire = acquire();
            try {
                long[] jArr = new long[tArr.length];
                int i2 = 0;
                for (T t : tArr) {
                    bind(acquire, t);
                    jArr[i2] = acquire.executeInsert();
                    i2++;
                }
                return jArr;
            } finally {
                release(acquire);
            }
        }
        return (long[]) invokeL.objValue;
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tArr)) == null) {
            SupportSQLiteStatement acquire = acquire();
            try {
                Long[] lArr = new Long[tArr.length];
                int i2 = 0;
                for (T t : tArr) {
                    bind(acquire, t);
                    lArr[i2] = Long.valueOf(acquire.executeInsert());
                    i2++;
                }
                return lArr;
            } finally {
                release(acquire);
            }
        }
        return (Long[]) invokeL.objValue;
    }

    public final List<Long> insertAndReturnIdsList(Collection<T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, collection)) == null) {
            SupportSQLiteStatement acquire = acquire();
            try {
                ArrayList arrayList = new ArrayList(collection.size());
                int i2 = 0;
                for (T t : collection) {
                    bind(acquire, t);
                    arrayList.add(i2, Long.valueOf(acquire.executeInsert()));
                    i2++;
                }
                return arrayList;
            } finally {
                release(acquire);
            }
        }
        return (List) invokeL.objValue;
    }

    public final void insert(Iterable<T> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iterable) == null) {
            SupportSQLiteStatement acquire = acquire();
            try {
                for (T t : iterable) {
                    bind(acquire, t);
                    acquire.executeInsert();
                }
            } finally {
                release(acquire);
            }
        }
    }
}
