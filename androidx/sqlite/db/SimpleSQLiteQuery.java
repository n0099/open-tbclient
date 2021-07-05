package androidx.sqlite.db;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final Object[] mBindArgs;
    public final String mQuery;

    public SimpleSQLiteQuery(String str, @Nullable Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {str, objArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mQuery = str;
        this.mBindArgs = objArr;
    }

    public static void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, supportSQLiteProgram, objArr) == null) || objArr == null) {
            return;
        }
        int length = objArr.length;
        int i2 = 0;
        while (i2 < length) {
            Object obj = objArr[i2];
            i2++;
            bind(supportSQLiteProgram, i2, obj);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, supportSQLiteProgram) == null) {
            bind(supportSQLiteProgram, this.mBindArgs);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object[] objArr = this.mBindArgs;
            if (objArr == null) {
                return 0;
            }
            return objArr.length;
        }
        return invokeV.intValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mQuery : (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleSQLiteQuery(String str) {
        this(str, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Object[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void bind(SupportSQLiteProgram supportSQLiteProgram, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, supportSQLiteProgram, i2, obj) == null) {
            if (obj == null) {
                supportSQLiteProgram.bindNull(i2);
            } else if (obj instanceof byte[]) {
                supportSQLiteProgram.bindBlob(i2, (byte[]) obj);
            } else if (obj instanceof Float) {
                supportSQLiteProgram.bindDouble(i2, ((Float) obj).floatValue());
            } else if (obj instanceof Double) {
                supportSQLiteProgram.bindDouble(i2, ((Double) obj).doubleValue());
            } else if (obj instanceof Long) {
                supportSQLiteProgram.bindLong(i2, ((Long) obj).longValue());
            } else if (obj instanceof Integer) {
                supportSQLiteProgram.bindLong(i2, ((Integer) obj).intValue());
            } else if (obj instanceof Short) {
                supportSQLiteProgram.bindLong(i2, ((Short) obj).shortValue());
            } else if (obj instanceof Byte) {
                supportSQLiteProgram.bindLong(i2, ((Byte) obj).byteValue());
            } else if (obj instanceof String) {
                supportSQLiteProgram.bindString(i2, (String) obj);
            } else if (obj instanceof Boolean) {
                supportSQLiteProgram.bindLong(i2, ((Boolean) obj).booleanValue() ? 1L : 0L);
            } else {
                throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i2 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
            }
        }
    }
}
