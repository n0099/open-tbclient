package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t);

    @Override // androidx.room.SharedSQLiteStatement
    public abstract String createQuery();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {roomDatabase};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((RoomDatabase) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final int handleMultiple(Iterable<T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iterable)) == null) {
            SupportSQLiteStatement acquire = acquire();
            int i = 0;
            try {
                for (T t : iterable) {
                    bind(acquire, t);
                    i += acquire.executeUpdateDelete();
                }
                return i;
            } finally {
                release(acquire);
            }
        }
        return invokeL.intValue;
    }

    public final int handle(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            SupportSQLiteStatement acquire = acquire();
            try {
                bind(acquire, t);
                return acquire.executeUpdateDelete();
            } finally {
                release(acquire);
            }
        }
        return invokeL.intValue;
    }

    public final int handleMultiple(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tArr)) == null) {
            SupportSQLiteStatement acquire = acquire();
            try {
                int i = 0;
                for (T t : tArr) {
                    bind(acquire, t);
                    i += acquire.executeUpdateDelete();
                }
                return i;
            } finally {
                release(acquire);
            }
        }
        return invokeL.intValue;
    }
}
