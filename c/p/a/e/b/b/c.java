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
    public final SQLiteDatabase f34848a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34849b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f34850c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f34851d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f34852e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f34853f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f34854g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f34855h;

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
        this.f34848a = sQLiteDatabase;
        this.f34849b = str;
        this.f34850c = strArr;
        this.f34851d = strArr2;
    }

    public SQLiteStatement a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f34852e == null) {
                SQLiteStatement compileStatement = this.f34848a.compileStatement(g.a("INSERT INTO ", this.f34849b, this.f34850c));
                synchronized (this) {
                    if (this.f34852e == null) {
                        this.f34852e = compileStatement;
                    }
                }
                if (this.f34852e != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f34852e;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f34854g == null) {
                SQLiteStatement compileStatement = this.f34848a.compileStatement(g.b(this.f34849b, this.f34851d));
                synchronized (this) {
                    if (this.f34854g == null) {
                        this.f34854g = compileStatement;
                    }
                }
                if (this.f34854g != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f34854g;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f34853f == null) {
                SQLiteStatement compileStatement = this.f34848a.compileStatement(g.c(this.f34849b, this.f34850c, this.f34851d));
                synchronized (this) {
                    if (this.f34853f == null) {
                        this.f34853f = compileStatement;
                    }
                }
                if (this.f34853f != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f34853f;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f34855h == null) {
                SQLiteStatement compileStatement = this.f34848a.compileStatement(g.i(this.f34849b, this.f34850c, this.f34851d));
                synchronized (this) {
                    if (this.f34855h == null) {
                        this.f34855h = compileStatement;
                    }
                }
                if (this.f34855h != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f34855h;
        }
        return (SQLiteStatement) invokeV.objValue;
    }
}
