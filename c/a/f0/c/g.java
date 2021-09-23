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
    public String f3427e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f3428f;

    /* renamed from: g  reason: collision with root package name */
    public int f3429g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f3430h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f3431i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3432j;
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
        this.f3427e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f3429g = -1;
        this.f3432j = false;
        this.l = false;
        this.f3427e = str;
        this.f3428f = uri;
        this.f3430h = j.c(uri);
        this.f3431i = j.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d */
    public g clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Uri uri = this.f3428f;
            g gVar = new g(uri, this.f3427e, j.c(uri), (HashMap) this.f3431i.clone());
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
            Uri uri = this.f3428f;
            if (uri != null) {
                if (j.d(uri) && (path = this.f3428f.getPath()) != null && path.length() > 1) {
                    return this.f3428f.getPath().substring(1);
                }
                return this.f3428f.getHost() + this.f3428f.getPath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public HashMap<String, String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3431i : (HashMap) invokeV.objValue;
    }

    public String g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (this.f3430h != null) {
                if (z) {
                    this.f3429g++;
                }
                int i2 = this.f3429g;
                String[] strArr = this.f3430h;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3428f : (Uri) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3432j : invokeV.booleanValue;
    }

    public void j(String str, String str2) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) || (uri = this.f3428f) == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.f3428f = parse;
        this.f3430h = j.c(parse);
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f3432j = z;
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
        this.f3427e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f3429g = -1;
        this.f3432j = false;
        this.l = false;
        this.f3428f = uri;
        this.f3427e = str;
        this.f3430h = strArr;
        this.f3431i = hashMap;
    }
}
