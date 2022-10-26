package com.baidu.mobstat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class j implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l a;

    public abstract long a(String str, String str2);

    public abstract ArrayList a(int i, int i2);

    public abstract boolean b(long j);

    public j(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.a = new l(context, str);
            if (context.getDatabasePath(y.e) != null) {
                a(str2);
            }
        } catch (Exception unused) {
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            this.a.a(str);
        }
    }

    public long a(ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, contentValues)) == null) {
            return this.a.a((String) null, contentValues);
        }
        return invokeL.longValue;
    }

    public Cursor a(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, str, i, i2)) == null) {
            return this.a.a(null, null, null, null, null, str + " desc", i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i);
        }
        return (Cursor) invokeLII.objValue;
    }

    public Cursor a(String str, String str2, String str3, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048579, this, str, str2, str3, i)) == null) {
            String str4 = str + "=? ";
            String[] strArr = {str2};
            return this.a.a(null, str4, strArr, null, null, str3 + " desc", i + "");
        }
        return (Cursor) invokeLLLI.objValue;
    }

    public synchronized boolean a() {
        InterceptResult invokeV;
        boolean a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                try {
                    a = this.a.a();
                } catch (Exception e) {
                    ba.c().b(e);
                    return false;
                }
            }
            return a;
        }
        return invokeV.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.b();
        }
        return invokeV.intValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                try {
                    this.a.close();
                } catch (Exception e) {
                    ba.c().b(e);
                }
            }
        }
    }

    public boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            if (this.a.a("_id=? ", new String[]{j + ""}) > 0) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }
}
