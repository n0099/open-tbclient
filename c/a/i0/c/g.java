package c.a.i0.c;

import android.net.Uri;
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
    public String f3931e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f3932f;

    /* renamed from: g  reason: collision with root package name */
    public int f3933g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f3934h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f3935i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3936j;
    public g k;
    public boolean l;
    public JSONObject m;
    public String n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-32881694, "Lc/a/i0/c/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-32881694, "Lc/a/i0/c/g;");
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
        this.f3931e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f3933g = -1;
        this.f3936j = false;
        this.l = false;
        this.f3931e = str;
        this.f3932f = uri;
        this.f3934h = j.c(uri);
        this.f3935i = j.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public g clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Uri uri = this.f3932f;
            g gVar = new g(uri, this.f3931e, j.c(uri), (HashMap) this.f3935i.clone());
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
            Uri uri = this.f3932f;
            if (uri != null) {
                if (j.d(uri) && (path = this.f3932f.getPath()) != null && path.length() > 1) {
                    return this.f3932f.getPath().substring(1);
                }
                return this.f3932f.getHost() + this.f3932f.getPath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public HashMap<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3935i : (HashMap) invokeV.objValue;
    }

    public String e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (this.f3934h != null) {
                if (z) {
                    this.f3933g++;
                }
                int i2 = this.f3933g;
                String[] strArr = this.f3934h;
                if (i2 < strArr.length) {
                    return strArr[i2];
                }
                return null;
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3936j : invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || (uri = this.f3932f) == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.f3932f = parse;
        this.f3934h = j.c(parse);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f3936j = z;
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
        this.f3931e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f3933g = -1;
        this.f3936j = false;
        this.l = false;
        this.f3932f = uri;
        this.f3931e = str;
        this.f3934h = strArr;
        this.f3935i = hashMap;
    }
}
