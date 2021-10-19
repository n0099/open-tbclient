package c.p.a.e.b.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import c.p.a.e.b.l.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f35090a;

    /* renamed from: b  reason: collision with root package name */
    public final String f35091b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f35092c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f35093d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f35094e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f35095f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f35096g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f35097h;

    public c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase, str, strArr, strArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35090a = sQLiteDatabase;
        this.f35091b = str;
        this.f35092c = strArr;
        this.f35093d = strArr2;
    }

    public SQLiteStatement a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f35094e == null) {
                SQLiteStatement compileStatement = this.f35090a.compileStatement(g.a("INSERT INTO ", this.f35091b, this.f35092c));
                synchronized (this) {
                    if (this.f35094e == null) {
                        this.f35094e = compileStatement;
                    }
                }
                if (this.f35094e != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f35094e;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f35096g == null) {
                SQLiteStatement compileStatement = this.f35090a.compileStatement(g.b(this.f35091b, this.f35093d));
                synchronized (this) {
                    if (this.f35096g == null) {
                        this.f35096g = compileStatement;
                    }
                }
                if (this.f35096g != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f35096g;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f35095f == null) {
                SQLiteStatement compileStatement = this.f35090a.compileStatement(g.c(this.f35091b, this.f35092c, this.f35093d));
                synchronized (this) {
                    if (this.f35095f == null) {
                        this.f35095f = compileStatement;
                    }
                }
                if (this.f35095f != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f35095f;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f35097h == null) {
                SQLiteStatement compileStatement = this.f35090a.compileStatement(g.i(this.f35091b, this.f35092c, this.f35093d));
                synchronized (this) {
                    if (this.f35097h == null) {
                        this.f35097h = compileStatement;
                    }
                }
                if (this.f35097h != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f35097h;
        }
        return (SQLiteStatement) invokeV.objValue;
    }
}
