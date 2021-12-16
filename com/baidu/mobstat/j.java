package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class j implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m a;

    public j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        l lVar = new l();
        this.a = new m(lVar, str);
        File databasePath = lVar.getDatabasePath(".confd");
        if (databasePath == null || !databasePath.canWrite()) {
            return;
        }
        a(str2);
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            this.a.a(str);
        }
    }

    public abstract long a(String str, String str2);

    public abstract ArrayList<i> a(int i2, int i3);

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.b() : invokeV.intValue;
    }

    public abstract boolean b(long j2);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                try {
                    this.a.close();
                } catch (Exception e2) {
                    bb.c().b(e2);
                }
            }
        }
    }

    public synchronized boolean a() {
        InterceptResult invokeV;
        boolean a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                try {
                    a = this.a.a();
                } catch (Exception e2) {
                    bb.c().b(e2);
                    return false;
                }
            }
            return a;
        }
        return invokeV.booleanValue;
    }

    public Cursor a(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, str, i2, i3)) == null) {
            return this.a.a(null, null, null, null, null, str + " desc", i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2);
        }
        return (Cursor) invokeLII.objValue;
    }

    public Cursor a(String str, String str2, String str3, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048579, this, str, str2, str3, i2)) == null) {
            String str4 = str + "=? ";
            String[] strArr = {str2};
            return this.a.a(null, str4, strArr, null, null, str3 + " desc", i2 + "");
        }
        return (Cursor) invokeLLLI.objValue;
    }

    public long a(ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, contentValues)) == null) ? this.a.a((String) null, contentValues) : invokeL.longValue;
    }

    public boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(j2);
            sb.append("");
            return this.a.a("_id=? ", new String[]{sb.toString()}) > 0;
        }
        return invokeJ.booleanValue;
    }
}
