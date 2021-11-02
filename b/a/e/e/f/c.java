package b.a.e.e.f;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f1734d = "_crashtime";

    /* renamed from: e  reason: collision with root package name */
    public static String f1735e = "_crashtype";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f1736a;

    /* renamed from: b  reason: collision with root package name */
    public int f1737b;

    /* renamed from: c  reason: collision with root package name */
    public b f1738c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1082311388, "Lb/a/e/e/f/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1082311388, "Lb/a/e/e/f/c;");
        }
    }

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1736a = 0;
        this.f1737b = 0;
        this.f1738c = null;
        if (bVar != null) {
            this.f1738c = bVar;
            if (bVar.d() > 0 && this.f1738c.c() != null) {
                int e2 = e();
                this.f1736a = e2;
                if (e2 == -1) {
                    g();
                }
            }
            if (!bVar.h()) {
                this.f1737b = f();
            }
            this.f1738c.a(this.f1737b, true);
            return;
        }
        throw new InvalidParameterException("SwitchHolder data is null");
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        String[] g2;
        String[] c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str != null && this.f1738c.d() > 0) {
                if (this.f1738c.c() != null) {
                    for (String str2 : this.f1738c.c()) {
                        if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                            int i2 = this.f1736a + 1;
                            this.f1736a = i2;
                            j(i2);
                            if (this.f1736a >= this.f1738c.d()) {
                                k(this.f1738c.f());
                                this.f1737b = this.f1738c.f();
                                b bVar = this.f1738c;
                                bVar.a(bVar.f(), false);
                            }
                            return true;
                        }
                    }
                }
                if (this.f1738c.g() != null) {
                    for (String str3 : this.f1738c.g()) {
                        if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                            int i3 = this.f1736a + 1;
                            this.f1736a = i3;
                            j(i3);
                            if (this.f1736a >= this.f1738c.d()) {
                                k(this.f1738c.f());
                                this.f1737b = this.f1738c.f();
                                b bVar2 = this.f1738c;
                                bVar2.a(bVar2.f(), false);
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1738c : (b) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1738c.b() : invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1738c.e() : (String) invokeV.objValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
            return sharedPreferences.getInt(this.f1738c.e() + f1734d, -1);
        }
        return invokeV.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
            return sharedPreferences.getInt(this.f1738c.e() + f1735e, this.f1738c.b());
        }
        return invokeV.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f1736a = 0;
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1737b : invokeV.intValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f1736a = i2;
        }
    }

    public boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.f1738c.d() >= 0 && this.f1736a >= this.f1738c.d() + 2) {
                i2 = this.f1738c.f();
            }
            if (i2 == this.f1737b) {
                return false;
            }
            this.f1737b = i2;
            this.f1738c.a(i2, false);
            k(i2);
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            edit.putInt(this.f1738c.e() + f1734d, i2);
            edit.commit();
        }
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            edit.putInt(this.f1738c.e() + f1735e, i2);
            edit.commit();
        }
    }
}
