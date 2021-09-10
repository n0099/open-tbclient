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
    public final SQLiteDatabase f35063a;

    /* renamed from: b  reason: collision with root package name */
    public final String f35064b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f35065c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f35066d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f35067e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f35068f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f35069g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f35070h;

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
        this.f35063a = sQLiteDatabase;
        this.f35064b = str;
        this.f35065c = strArr;
        this.f35066d = strArr2;
    }

    public SQLiteStatement a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f35067e == null) {
                SQLiteStatement compileStatement = this.f35063a.compileStatement(g.a("INSERT INTO ", this.f35064b, this.f35065c));
                synchronized (this) {
                    if (this.f35067e == null) {
                        this.f35067e = compileStatement;
                    }
                }
                if (this.f35067e != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f35067e;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f35069g == null) {
                SQLiteStatement compileStatement = this.f35063a.compileStatement(g.b(this.f35064b, this.f35066d));
                synchronized (this) {
                    if (this.f35069g == null) {
                        this.f35069g = compileStatement;
                    }
                }
                if (this.f35069g != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f35069g;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f35068f == null) {
                SQLiteStatement compileStatement = this.f35063a.compileStatement(g.c(this.f35064b, this.f35065c, this.f35066d));
                synchronized (this) {
                    if (this.f35068f == null) {
                        this.f35068f = compileStatement;
                    }
                }
                if (this.f35068f != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f35068f;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f35070h == null) {
                SQLiteStatement compileStatement = this.f35063a.compileStatement(g.i(this.f35064b, this.f35065c, this.f35066d));
                synchronized (this) {
                    if (this.f35070h == null) {
                        this.f35070h = compileStatement;
                    }
                }
                if (this.f35070h != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f35070h;
        }
        return (SQLiteStatement) invokeV.objValue;
    }
}
