package c.a.f0.c;

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
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Uri f2937b;

    /* renamed from: c  reason: collision with root package name */
    public int f2938c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f2939d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f2940e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2941f;

    /* renamed from: g  reason: collision with root package name */
    public g f2942g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2943h;
    public JSONObject i;
    public String j;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f2938c = -1;
        this.f2941f = false;
        this.f2943h = false;
        this.a = str;
        this.f2937b = uri;
        this.f2939d = j.c(uri);
        this.f2940e = j.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public g clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Uri uri = this.f2937b;
            g gVar = new g(uri, this.a, j.c(uri), (HashMap) this.f2940e.clone());
            gVar.f2942g = this;
            gVar.f2943h = this.f2943h;
            gVar.j = this.j;
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Uri uri = this.f2937b;
            if (uri != null) {
                if (j.d(uri) && (path = this.f2937b.getPath()) != null && path.length() > 1) {
                    return this.f2937b.getPath().substring(1);
                }
                return this.f2937b.getHost() + this.f2937b.getPath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public HashMap<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2940e : (HashMap) invokeV.objValue;
    }

    public String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (this.f2939d != null) {
                if (z) {
                    this.f2938c++;
                }
                int i = this.f2938c;
                String[] strArr = this.f2939d;
                if (i < strArr.length) {
                    return strArr[i];
                }
                return null;
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2941f : invokeV.booleanValue;
    }

    public void f(String str, String str2) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || (uri = this.f2937b) == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.f2937b = parse;
        this.f2939d = j.c(parse);
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f2941f = z;
        }
    }

    public g(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, str, strArr, hashMap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f2938c = -1;
        this.f2941f = false;
        this.f2943h = false;
        this.f2937b = uri;
        this.a = str;
        this.f2939d = strArr;
        this.f2940e = hashMap;
    }
}
