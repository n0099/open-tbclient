package c.a.b0.c0.l;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<String> f1407b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1408c;

    /* renamed from: d  reason: collision with root package name */
    public final StringBuilder f1409d;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f1407b = new ArrayList<>();
        this.f1408c = false;
        this.f1409d = new StringBuilder();
    }

    public static a g(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, column)) == null) ? i(column.field, column.stringValue()) : (a) invokeL.objValue;
    }

    public static a h(c.a.b0.c0.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            a aVar = new a();
            aVar.f(null, bVar, " = ?");
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static a i(c.a.b0.c0.b bVar, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bVar, obj)) == null) {
            a h2 = h(bVar);
            h2.d(obj);
            return h2;
        }
        return (a) invokeLL.objValue;
    }

    public static a j(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, columnArr)) == null) {
            a g2 = g(columnArr[0]);
            for (int i2 = 1; i2 < columnArr.length; i2++) {
                g2.b(columnArr[i2].field, columnArr[i2].stringValue());
            }
            return g2;
        }
        return (a) invokeL.objValue;
    }

    public a a(String str, c.a.b0.c0.b bVar, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, bVar, str2)) == null) {
            this.a = true;
            this.f1409d.append(" AND ");
            f(str, bVar, str2);
            return this;
        }
        return (a) invokeLLL.objValue;
    }

    public a b(c.a.b0.c0.b bVar, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, obj)) == null) {
            c(null, bVar, obj);
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public a c(String str, c.a.b0.c0.b bVar, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar, obj)) == null) {
            a(str, bVar, " = ?");
            d(obj);
            return this;
        }
        return (a) invokeLLL.objValue;
    }

    public a d(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, objArr)) == null) {
            for (Object obj : objArr) {
                this.f1407b.add(String.valueOf(obj));
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public String[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String[] strArr = new String[this.f1407b.size()];
            for (int i2 = 0; i2 < this.f1407b.size(); i2++) {
                strArr[i2] = this.f1407b.get(i2);
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    public final void f(String str, c.a.b0.c0.b bVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, bVar, str2) == null) {
            if (bVar != null) {
                if (str != null) {
                    this.f1409d.append(str);
                    this.f1409d.append(".");
                }
                this.f1409d.append(bVar.f1401b);
                if (str2.charAt(0) != ' ') {
                    this.f1409d.append(" ");
                }
            } else if (str != null) {
                throw new IllegalArgumentException("prefix should be null when field is null");
            }
            this.f1409d.append(str2);
        }
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.f1408c) {
                if (this.a) {
                    this.f1409d.insert(0, "(");
                    this.f1409d.append(SmallTailInfo.EMOTION_SUFFIX);
                    this.f1408c = true;
                }
                this.f1409d.insert(0, " WHERE ");
                return this.f1409d.toString();
            }
            throw new IllegalArgumentException("sql() should only be called once");
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.f1408c) {
                if (this.a) {
                    this.f1409d.insert(0, "(");
                    this.f1409d.append(SmallTailInfo.EMOTION_SUFFIX);
                    this.f1408c = true;
                }
                return this.f1409d.toString();
            }
            throw new IllegalArgumentException("sqlApi() should only be called once");
        }
        return (String) invokeV.objValue;
    }
}
