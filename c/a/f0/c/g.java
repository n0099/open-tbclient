package c.a.f0.c;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f3435e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f3436f;

    /* renamed from: g  reason: collision with root package name */
    public int f3437g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f3438h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f3439i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3440j;
    public g k;
    public boolean l;
    public JSONObject m;
    public String n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1599574559, "Lc/a/f0/c/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1599574559, "Lc/a/f0/c/g;");
                return;
            }
        }
        String str = c.b() + "://";
    }

    public g(Uri uri, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3435e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f3437g = -1;
        this.f3440j = false;
        this.l = false;
        this.f3435e = str;
        this.f3436f = uri;
        this.f3438h = j.c(uri);
        this.f3439i = j.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public g clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Uri uri = this.f3436f;
            g gVar = new g(uri, this.f3435e, j.c(uri), (HashMap) this.f3439i.clone());
            gVar.k = this;
            gVar.l = this.l;
            gVar.n = this.n;
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Uri uri = this.f3436f;
            if (uri != null) {
                if (j.d(uri) && (path = this.f3436f.getPath()) != null && path.length() > 1) {
                    return this.f3436f.getPath().substring(1);
                }
                return this.f3436f.getHost() + this.f3436f.getPath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public HashMap<String, String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3439i : (HashMap) invokeV.objValue;
    }

    public String g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (this.f3438h != null) {
                if (z) {
                    this.f3437g++;
                }
                int i2 = this.f3437g;
                String[] strArr = this.f3438h;
                if (i2 < strArr.length) {
                    return strArr[i2];
                }
                return null;
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public Uri h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3436f : (Uri) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3440j : invokeV.booleanValue;
    }

    public void j(String str, String str2) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) || (uri = this.f3436f) == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.f3436f = parse;
        this.f3438h = j.c(parse);
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f3440j = z;
        }
    }

    public g(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, str, strArr, hashMap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f3435e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f3437g = -1;
        this.f3440j = false;
        this.l = false;
        this.f3436f = uri;
        this.f3435e = str;
        this.f3438h = strArr;
        this.f3439i = hashMap;
    }
}
