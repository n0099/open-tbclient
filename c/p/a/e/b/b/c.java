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
    public final SQLiteDatabase f34954a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34955b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f34956c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f34957d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f34958e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f34959f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f34960g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f34961h;

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
        this.f34954a = sQLiteDatabase;
        this.f34955b = str;
        this.f34956c = strArr;
        this.f34957d = strArr2;
    }

    public SQLiteStatement a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f34958e == null) {
                SQLiteStatement compileStatement = this.f34954a.compileStatement(g.a("INSERT INTO ", this.f34955b, this.f34956c));
                synchronized (this) {
                    if (this.f34958e == null) {
                        this.f34958e = compileStatement;
                    }
                }
                if (this.f34958e != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f34958e;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f34960g == null) {
                SQLiteStatement compileStatement = this.f34954a.compileStatement(g.b(this.f34955b, this.f34957d));
                synchronized (this) {
                    if (this.f34960g == null) {
                        this.f34960g = compileStatement;
                    }
                }
                if (this.f34960g != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f34960g;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f34959f == null) {
                SQLiteStatement compileStatement = this.f34954a.compileStatement(g.c(this.f34955b, this.f34956c, this.f34957d));
                synchronized (this) {
                    if (this.f34959f == null) {
                        this.f34959f = compileStatement;
                    }
                }
                if (this.f34959f != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f34959f;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f34961h == null) {
                SQLiteStatement compileStatement = this.f34954a.compileStatement(g.i(this.f34955b, this.f34956c, this.f34957d));
                synchronized (this) {
                    if (this.f34961h == null) {
                        this.f34961h = compileStatement;
                    }
                }
                if (this.f34961h != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f34961h;
        }
        return (SQLiteStatement) invokeV.objValue;
    }
}
