package c.a.e.e.f;

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
    public static String f2253d = "_crashtime";

    /* renamed from: e  reason: collision with root package name */
    public static String f2254e = "_crashtype";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f2255a;

    /* renamed from: b  reason: collision with root package name */
    public int f2256b;

    /* renamed from: c  reason: collision with root package name */
    public b f2257c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1211394107, "Lc/a/e/e/f/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1211394107, "Lc/a/e/e/f/c;");
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
        this.f2255a = 0;
        this.f2256b = 0;
        this.f2257c = null;
        if (bVar != null) {
            this.f2257c = bVar;
            if (bVar.d() > 0 && this.f2257c.c() != null) {
                int f2 = f();
                this.f2255a = f2;
                if (f2 == -1) {
                    h();
                }
            }
            if (!bVar.h()) {
                this.f2256b = g();
            }
            this.f2257c.a(this.f2256b, true);
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
            if (str != null && this.f2257c.d() > 0) {
                if (this.f2257c.c() != null) {
                    for (String str2 : this.f2257c.c()) {
                        if (!TextUtils.isEmpty(str2) && str.indexOf(str2) != -1) {
                            int i2 = this.f2255a + 1;
                            this.f2255a = i2;
                            k(i2);
                            if (this.f2255a >= this.f2257c.d()) {
                                l(this.f2257c.f());
                                this.f2256b = this.f2257c.f();
                                b bVar = this.f2257c;
                                bVar.a(bVar.f(), false);
                            }
                            return true;
                        }
                    }
                }
                if (this.f2257c.g() != null) {
                    for (String str3 : this.f2257c.g()) {
                        if (!TextUtils.isEmpty(str3) && str.equals(str3)) {
                            int i3 = this.f2255a + 1;
                            this.f2255a = i3;
                            k(i3);
                            if (this.f2255a >= this.f2257c.d()) {
                                l(this.f2257c.f());
                                this.f2256b = this.f2257c.f();
                                b bVar2 = this.f2257c;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2257c : (b) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2257c.b() : invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2257c.e() : (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2256b : invokeV.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
            return sharedPreferences.getInt(this.f2257c.e() + f2253d, -1);
        }
        return invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SharedPreferences sharedPreferences = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0);
            return sharedPreferences.getInt(this.f2257c.e() + f2254e, this.f2257c.b());
        }
        return invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f2255a = 0;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f2255a = i2;
        }
    }

    public boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.f2257c.d() >= 0 && this.f2255a >= this.f2257c.d() + 2) {
                i2 = this.f2257c.f();
            }
            if (i2 == this.f2256b) {
                return false;
            }
            this.f2256b = i2;
            this.f2257c.a(i2, false);
            l(i2);
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            edit.putInt(this.f2257c.e() + f2253d, i2);
            edit.commit();
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences("adp_feature_switch", 0).edit();
            edit.putInt(this.f2257c.e() + f2254e, i2);
            edit.commit();
        }
    }
}
