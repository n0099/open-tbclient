package b.a.f0.c;

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
    public String f2868e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f2869f;

    /* renamed from: g  reason: collision with root package name */
    public int f2870g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f2871h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f2872i;
    public boolean j;
    public g k;
    public boolean l;
    public JSONObject m;
    public String n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-898441378, "Lb/a/f0/c/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-898441378, "Lb/a/f0/c/g;");
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
        this.f2868e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f2870g = -1;
        this.j = false;
        this.l = false;
        this.f2868e = str;
        this.f2869f = uri;
        this.f2871h = j.c(uri);
        this.f2872i = j.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public g clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Uri uri = this.f2869f;
            g gVar = new g(uri, this.f2868e, j.c(uri), (HashMap) this.f2872i.clone());
            gVar.k = this;
            gVar.l = this.l;
            gVar.n = this.n;
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Uri uri = this.f2869f;
            if (uri != null) {
                if (j.d(uri) && (path = this.f2869f.getPath()) != null && path.length() > 1) {
                    return this.f2869f.getPath().substring(1);
                }
                return this.f2869f.getHost() + this.f2869f.getPath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public HashMap<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2872i : (HashMap) invokeV.objValue;
    }

    public String e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (this.f2871h != null) {
                if (z) {
                    this.f2870g++;
                }
                int i2 = this.f2870g;
                String[] strArr = this.f2871h;
                if (i2 < strArr.length) {
                    return strArr[i2];
                }
                return null;
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public Uri f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2869f : (Uri) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void h(String str, String str2) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) || (uri = this.f2869f) == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.f2869f = parse;
        this.f2871h = j.c(parse);
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.j = z;
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
        this.f2868e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f2870g = -1;
        this.j = false;
        this.l = false;
        this.f2869f = uri;
        this.f2868e = str;
        this.f2871h = strArr;
        this.f2872i = hashMap;
    }
}
