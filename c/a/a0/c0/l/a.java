package c.a.a0.c0.l;

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
    public final ArrayList<String> f1058b;

    /* renamed from: c  reason: collision with root package name */
    public final StringBuilder f1059c;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f1058b = new ArrayList<>();
        this.f1059c = new StringBuilder();
    }

    public static a g(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, column)) == null) ? i(column.field, column.stringValue()) : (a) invokeL.objValue;
    }

    public static a h(c.a.a0.c0.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            a aVar = new a();
            aVar.f(null, bVar, " = ?");
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static a i(c.a.a0.c0.b bVar, Object obj) {
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
            for (int i = 1; i < columnArr.length; i++) {
                g2.b(columnArr[i].field, columnArr[i].stringValue());
            }
            return g2;
        }
        return (a) invokeL.objValue;
    }

    public a a(String str, c.a.a0.c0.b bVar, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, bVar, str2)) == null) {
            this.a = true;
            this.f1059c.append(" AND ");
            f(str, bVar, str2);
            return this;
        }
        return (a) invokeLLL.objValue;
    }

    public a b(c.a.a0.c0.b bVar, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, obj)) == null) {
            c(null, bVar, obj);
            return this;
        }
        return (a) invokeLL.objValue;
    }

    public a c(String str, c.a.a0.c0.b bVar, Object obj) {
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
                this.f1058b.add(String.valueOf(obj));
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public String[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String[] strArr = new String[this.f1058b.size()];
            for (int i = 0; i < this.f1058b.size(); i++) {
                strArr[i] = this.f1058b.get(i);
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    public final void f(String str, c.a.a0.c0.b bVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, bVar, str2) == null) {
            if (bVar != null) {
                if (str != null) {
                    this.f1059c.append(str);
                    this.f1059c.append(".");
                }
                this.f1059c.append(bVar.f1052b);
                if (str2.charAt(0) != ' ') {
                    this.f1059c.append(" ");
                }
            } else if (str != null) {
                throw new IllegalArgumentException("prefix should be null when field is null");
            }
            this.f1059c.append(str2);
        }
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) this.f1059c);
            if (this.a) {
                sb.insert(0, "(");
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            sb.insert(0, " WHERE ");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) this.f1059c);
            if (this.a) {
                sb.insert(0, "(");
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
