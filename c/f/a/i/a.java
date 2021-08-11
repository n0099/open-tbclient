package c.f.a.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.webmanager.b;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.webmanager.JavaBridgeObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f32095f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f32096g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Object> f32097a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, Set<String>> f32098b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32099c;

    /* renamed from: d  reason: collision with root package name */
    public String f32100d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, String> f32101e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1490694257, "Lc/f/a/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1490694257, "Lc/f/a/i/a;");
                return;
            }
        }
        f32095f = ApollonConstants.DEBUG & false;
        f32096g = b.f38141c.toLowerCase();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32097a = new HashMap<>();
        this.f32098b = new HashMap<>();
        this.f32099c = false;
        this.f32101e = new HashMap();
    }

    public final Class<?> a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            Class<?> cls = obj.getClass();
            if (cls == Integer.class) {
                return Integer.TYPE;
            }
            if (cls == Boolean.class) {
                return Boolean.TYPE;
            }
            return String.class;
        }
        return (Class) invokeL.objValue;
    }

    public final String b(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error", i2);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("msg", str);
                }
                if (i2 == 0 && str2 != null) {
                    jSONObject.put("result", str2);
                }
            } catch (JSONException e2) {
                if (f32095f) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeILL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f32101e.clear();
        }
    }

    public void d(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, str) == null) {
            if (f32095f) {
                String str2 = "addJavascriptInterface to map: <" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj + ">";
            }
            if (obj == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f32097a.put(str, obj);
            this.f32100d = null;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f32097a.remove(str);
            this.f32100d = null;
            if (f32095f) {
                String str2 = "removeJavascriptInterface from map: " + str;
            }
        }
    }

    public void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f32099c = true;
        this.f32101e.put(str, str2);
    }

    @SuppressLint({"NewApi"})
    public final void g(StringBuilder sb, Object obj, String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, sb, obj, str) == null) {
            if (sb != null && obj != null && !TextUtils.isEmpty(str)) {
                Class<?> cls = obj.getClass();
                if (f32095f) {
                    sb.append("if(typeof(window." + str + ")!='undefined'){");
                    sb.append("console.log('window." + str + " is exist!!');}else{");
                } else {
                    sb.append("if(typeof(window." + str + ")=='undefined'){");
                }
                sb.append("window.");
                sb.append(str);
                sb.append("={");
                Method[] methods = cls.getMethods();
                HashSet hashSet = new HashSet();
                for (Method method : methods) {
                    String name = method.getName();
                    if (!name.endsWith(b.f38147i) && !n(name) && !hashSet.contains(name)) {
                        hashSet.add(name);
                        sb.append(name);
                        sb.append(":function(){");
                        if (method.getReturnType() != Void.TYPE) {
                            sb.append("return ");
                        }
                        sb.append("prompt('");
                        sb.append(f32096g);
                        sb.append("'+");
                        sb.append("JSON.stringify({");
                        sb.append("obj");
                        sb.append(":'");
                        sb.append(str);
                        sb.append("',");
                        sb.append(WebChromeClient.KEY_FUNCTION_NAME);
                        sb.append(":'");
                        sb.append(name);
                        sb.append("',");
                        sb.append("args");
                        sb.append(":Array.prototype.slice.call(arguments)");
                        sb.append("})");
                        sb.append(");");
                        sb.append("},");
                    }
                }
                this.f32098b.put(str, hashSet);
                int length = sb.length() - 1;
                if (sb.charAt(length) == ',') {
                    sb.deleteCharAt(length);
                }
                sb.append("};");
                sb.append("}");
            } else if (f32095f) {
                String str2 = "script=" + ((Object) sb);
                String str3 = "obj=" + obj + ", interfaceName=" + str;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f8 A[Catch: InvocationTargetException -> 0x011e, IllegalAccessException -> 0x0127, IllegalArgumentException -> 0x0130, NoSuchMethodException -> 0x015c, TryCatch #2 {IllegalAccessException -> 0x0127, IllegalArgumentException -> 0x0130, NoSuchMethodException -> 0x015c, InvocationTargetException -> 0x011e, blocks: (B:36:0x00c9, B:38:0x00d3, B:41:0x00e7, B:49:0x00fc, B:51:0x0100, B:53:0x0112, B:54:0x011a, B:48:0x00f8), top: B:91:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0100 A[Catch: InvocationTargetException -> 0x011e, IllegalAccessException -> 0x0127, IllegalArgumentException -> 0x0130, NoSuchMethodException -> 0x015c, TryCatch #2 {IllegalAccessException -> 0x0127, IllegalArgumentException -> 0x0130, NoSuchMethodException -> 0x015c, InvocationTargetException -> 0x011e, blocks: (B:36:0x00c9, B:38:0x00d3, B:41:0x00e7, B:49:0x00fc, B:51:0x0100, B:53:0x0112, B:54:0x011a, B:48:0x00f8), top: B:91:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0112 A[Catch: InvocationTargetException -> 0x011e, IllegalAccessException -> 0x0127, IllegalArgumentException -> 0x0130, NoSuchMethodException -> 0x015c, TryCatch #2 {IllegalAccessException -> 0x0127, IllegalArgumentException -> 0x0130, NoSuchMethodException -> 0x015c, InvocationTargetException -> 0x011e, blocks: (B:36:0x00c9, B:38:0x00d3, B:41:0x00e7, B:49:0x00fc, B:51:0x0100, B:53:0x0112, B:54:0x011a, B:48:0x00f8), top: B:91:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011a A[Catch: InvocationTargetException -> 0x011e, IllegalAccessException -> 0x0127, IllegalArgumentException -> 0x0130, NoSuchMethodException -> 0x015c, TRY_LEAVE, TryCatch #2 {IllegalAccessException -> 0x0127, IllegalArgumentException -> 0x0130, NoSuchMethodException -> 0x015c, InvocationTargetException -> 0x011e, blocks: (B:36:0x00c9, B:38:0x00d3, B:41:0x00e7, B:49:0x00fc, B:51:0x0100, B:53:0x0112, B:54:0x011a, B:48:0x00f8), top: B:91:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0158  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h(JsPromptResult jsPromptResult, boolean z, JavaBridgeObject javaBridgeObject) {
        InterceptResult invokeCommon;
        Class<?>[] clsArr;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{jsPromptResult, Boolean.valueOf(z), javaBridgeObject})) == null) {
            Object obj = this.f32097a.get(javaBridgeObject.obj);
            if (obj == null) {
                if (f32095f) {
                    String str = "not exist js interface:" + javaBridgeObject.obj;
                }
                if (z) {
                    jsPromptResult.confirm(b(101, "interface:" + javaBridgeObject.obj + " not found!", null));
                } else {
                    jsPromptResult.cancel();
                }
                return true;
            } else if (javaBridgeObject.args == null && javaBridgeObject.func == null) {
                if (f32095f) {
                    String str2 = "interface query: found for " + obj;
                }
                if (z) {
                    jsPromptResult.confirm(b(0, "interface:" + obj + " found!", Boolean.TRUE.toString()));
                } else {
                    jsPromptResult.cancel();
                }
                return true;
            } else {
                Object[] objArr = javaBridgeObject.args;
                int length = objArr != null ? objArr.length : 0;
                if (length > 0) {
                    clsArr = new Class[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        clsArr[i2] = a(javaBridgeObject.args[i2]);
                        if (f32095f) {
                            String str3 = "type:" + clsArr[i2].getName();
                        }
                    }
                } else {
                    clsArr = null;
                }
                try {
                    Object invoke = l(javaBridgeObject.obj, javaBridgeObject.func) ? obj.getClass().getMethod(javaBridgeObject.func, clsArr).invoke(obj, javaBridgeObject.args) : null;
                    if (invoke != null && invoke.getClass() != Void.TYPE) {
                        z2 = false;
                        String obj2 = !z2 ? "" : invoke.toString();
                        if (f32095f) {
                            String str4 = "called ok: " + obj2;
                        }
                        if (!z) {
                            jsPromptResult.confirm(b(0, null, obj2));
                        } else {
                            jsPromptResult.confirm(obj2);
                        }
                        return true;
                    }
                    z2 = true;
                    if (!z2) {
                    }
                    if (f32095f) {
                    }
                    if (!z) {
                    }
                    return true;
                } catch (IllegalAccessException e2) {
                    if (f32095f) {
                        e2.printStackTrace();
                        return false;
                    }
                    if (z) {
                        jsPromptResult.confirm(b(100, javaBridgeObject.func + " call failed!", null));
                    } else {
                        jsPromptResult.cancel();
                    }
                    return true;
                } catch (IllegalArgumentException e3) {
                    if (f32095f) {
                        e3.printStackTrace();
                        return false;
                    }
                    if (z) {
                    }
                    return true;
                } catch (NoSuchMethodException unused) {
                    if (f32095f) {
                        StringBuilder sb = new StringBuilder(javaBridgeObject.func);
                        sb.append("(");
                        if (length > 0) {
                            sb.append("'");
                            sb.append(javaBridgeObject.args[0]);
                            sb.append("'");
                            for (int i3 = 1; i3 < length; i3++) {
                                sb.append(",'");
                                sb.append(javaBridgeObject.args[i3]);
                                sb.append("'");
                            }
                        }
                        sb.append(SmallTailInfo.EMOTION_SUFFIX);
                    }
                    if (z) {
                        jsPromptResult.confirm(b(102, javaBridgeObject.func + " not found, check the method name or arguments.", null));
                    } else {
                        jsPromptResult.cancel();
                    }
                    return true;
                } catch (InvocationTargetException e4) {
                    if (f32095f) {
                        e4.printStackTrace();
                        return false;
                    }
                    if (z) {
                    }
                    return true;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    public boolean i(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        String substring;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, jsPromptResult)) == null) {
            if (f32095f) {
                String str4 = "handle url: " + str;
                String str5 = "handle msg: " + str2;
            }
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2.startsWith(b.f38141c)) {
                substring = str2.substring(9);
                z = true;
            } else if (!str2.startsWith(b.f38141c.toLowerCase())) {
                return false;
            } else {
                substring = str2.substring(9);
                z = false;
            }
            try {
                JavaBridgeObject javaBridgeObject = (JavaBridgeObject) JsonUtils.fromJson(substring, JavaBridgeObject.class);
                if (f32095f && javaBridgeObject != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(javaBridgeObject.obj);
                    sb.append(".");
                    sb.append(javaBridgeObject.func);
                    sb.append("(");
                    if (javaBridgeObject.args.length > 0) {
                        sb.append("\"");
                        sb.append(javaBridgeObject.args[0]);
                        sb.append("\"");
                        for (int i2 = 1; i2 < javaBridgeObject.args.length; i2++) {
                            sb.append(",\"");
                            sb.append(javaBridgeObject.args[i2]);
                            sb.append("\"");
                        }
                    }
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                    LogUtil.i(b.f38140b, "call: " + sb.toString());
                }
                if (javaBridgeObject != null) {
                    return h(jsPromptResult, z, javaBridgeObject);
                }
                return true;
            } catch (JSONException e2) {
                if (f32095f) {
                    e2.printStackTrace();
                }
                jsPromptResult.cancel();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.f32099c && !TextUtils.isEmpty(this.f32100d)) {
                return this.f32100d;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:");
            sb.append("(function JsAddJavascriptInterface_(){");
            for (String str : this.f32097a.keySet()) {
                try {
                    g(sb, this.f32097a.get(str), str);
                } catch (JSONException unused) {
                    boolean z = f32095f;
                }
            }
            for (String str2 : this.f32101e.values()) {
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str2);
                }
            }
            this.f32099c = false;
            if (f32095f) {
                sb.append("console.log('addJavascript done!');");
            }
            sb.append("}");
            sb.append(")()");
            this.f32100d = sb.toString();
            if (f32095f) {
                String str3 = "getImpactedJsString : " + this.f32100d;
            }
            return this.f32100d;
        }
        return (String) invokeV.objValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f32101e.remove(str);
    }

    public final boolean l(String str, String str2) {
        InterceptResult invokeLL;
        HashMap<String, Set<String>> hashMap;
        Set<String> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (hashMap = this.f32098b) == null || hashMap.size() < 1 || (set = this.f32098b.get(str)) == null) {
                return false;
            }
            return set.contains(str2);
        }
        return invokeLL.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f32097a.clear();
            this.f32100d = null;
        }
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (Method method : Object.class.getMethods()) {
                if (str.equals(method.getName())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
