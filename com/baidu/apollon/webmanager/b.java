package com.baidu.apollon.webmanager;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f33716b = "JsJavaBridge";

    /* renamed from: c  reason: collision with root package name */
    public static final String f33717c = "BdWallet:";

    /* renamed from: d  reason: collision with root package name */
    public static final String f33718d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f33719e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f33720f = 101;

    /* renamed from: g  reason: collision with root package name */
    public static final int f33721g = 102;

    /* renamed from: h  reason: collision with root package name */
    public static final int f33722h = 100;

    /* renamed from: i  reason: collision with root package name */
    public static final String f33723i = "Local";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public final HashMap<String, Object> f33724j;

    /* renamed from: k  reason: collision with root package name */
    public final HashMap<String, Set<String>> f33725k;
    public boolean l;
    public String m;
    public final Map<String, String> n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(570021169, "Lcom/baidu/apollon/webmanager/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(570021169, "Lcom/baidu/apollon/webmanager/b;");
                return;
            }
        }
        a = ApollonConstants.DEBUG & false;
        f33718d = f33717c.toLowerCase();
    }

    public b() {
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
        this.f33724j = new HashMap<>();
        this.f33725k = new HashMap<>();
        this.l = false;
        this.n = new HashMap();
    }

    public void a(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str) == null) {
            if (a) {
                String str2 = "addJavascriptInterface to map: <" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj + ">";
            }
            if (obj == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f33724j.put(str, obj);
            this.m = null;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.n.remove(str);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f33724j.clear();
            this.m = null;
        }
    }

    private boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
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

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.l && !TextUtils.isEmpty(this.m)) {
                return this.m;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:");
            sb.append("(function JsAddJavascriptInterface_(){");
            for (String str : this.f33724j.keySet()) {
                try {
                    a(sb, this.f33724j.get(str), str);
                } catch (JSONException unused) {
                    boolean z = a;
                }
            }
            for (String str2 : this.n.values()) {
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str2);
                }
            }
            this.l = false;
            if (a) {
                sb.append("console.log('addJavascript done!');");
            }
            sb.append("}");
            sb.append(")()");
            this.m = sb.toString();
            if (a) {
                String str3 = "getImpactedJsString : " + this.m;
            }
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f33724j.remove(str);
            this.m = null;
            if (a) {
                String str2 = "removeJavascriptInterface from map: " + str;
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.l = true;
        this.n.put(str, str2);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.n.clear();
        }
    }

    public boolean a(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        String substring;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, jsPromptResult)) == null) {
            if (a) {
                String str4 = "handle url: " + str;
                String str5 = "handle msg: " + str2;
            }
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2.startsWith(f33717c)) {
                substring = str2.substring(9);
                z = true;
            } else if (!str2.startsWith(f33717c.toLowerCase())) {
                return false;
            } else {
                substring = str2.substring(9);
                z = false;
            }
            try {
                JavaBridgeObject javaBridgeObject = (JavaBridgeObject) JsonUtils.fromJson(substring, JavaBridgeObject.class);
                if (a && javaBridgeObject != null) {
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
                    LogUtil.i(f33716b, "call: " + sb.toString());
                }
                if (javaBridgeObject != null) {
                    return a(jsPromptResult, z, javaBridgeObject);
                }
                return true;
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                jsPromptResult.cancel();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    private boolean b(String str, String str2) {
        InterceptResult invokeLL;
        HashMap<String, Set<String>> hashMap;
        Set<String> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (hashMap = this.f33725k) == null || hashMap.size() < 1 || (set = this.f33725k.get(str)) == null) {
                return false;
            }
            return set.contains(str2);
        }
        return invokeLL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    private void a(StringBuilder sb, Object obj, String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, sb, obj, str) == null) {
            if (sb != null && obj != null && !TextUtils.isEmpty(str)) {
                Class<?> cls = obj.getClass();
                if (a) {
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
                    if (!name.endsWith(f33723i) && !c(name) && !hashSet.contains(name)) {
                        hashSet.add(name);
                        sb.append(name);
                        sb.append(":function(){");
                        if (method.getReturnType() != Void.TYPE) {
                            sb.append("return ");
                        }
                        sb.append("prompt('");
                        sb.append(f33718d);
                        sb.append("'+");
                        sb.append("JSON.stringify({");
                        sb.append("obj");
                        sb.append(":'");
                        sb.append(str);
                        sb.append("',");
                        sb.append("func");
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
                this.f33725k.put(str, hashSet);
                int length = sb.length() - 1;
                if (sb.charAt(length) == ',') {
                    sb.deleteCharAt(length);
                }
                sb.append("};");
                sb.append("}");
            } else if (a) {
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
    private boolean a(JsPromptResult jsPromptResult, boolean z, JavaBridgeObject javaBridgeObject) {
        InterceptResult invokeCommon;
        Class<?>[] clsArr;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{jsPromptResult, Boolean.valueOf(z), javaBridgeObject})) == null) {
            Object obj = this.f33724j.get(javaBridgeObject.obj);
            if (obj == null) {
                if (a) {
                    String str = "not exist js interface:" + javaBridgeObject.obj;
                }
                if (z) {
                    jsPromptResult.confirm(a(101, "interface:" + javaBridgeObject.obj + " not found!", (String) null));
                } else {
                    jsPromptResult.cancel();
                }
                return true;
            } else if (javaBridgeObject.args == null && javaBridgeObject.func == null) {
                if (a) {
                    String str2 = "interface query: found for " + obj;
                }
                if (z) {
                    jsPromptResult.confirm(a(0, "interface:" + obj + " found!", Boolean.TRUE.toString()));
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
                        if (a) {
                            String str3 = "type:" + clsArr[i2].getName();
                        }
                    }
                } else {
                    clsArr = null;
                }
                try {
                    Object invoke = b(javaBridgeObject.obj, javaBridgeObject.func) ? obj.getClass().getMethod(javaBridgeObject.func, clsArr).invoke(obj, javaBridgeObject.args) : null;
                    if (invoke != null && invoke.getClass() != Void.TYPE) {
                        z2 = false;
                        String obj2 = !z2 ? "" : invoke.toString();
                        if (a) {
                            String str4 = "called ok: " + obj2;
                        }
                        if (!z) {
                            jsPromptResult.confirm(a(0, (String) null, obj2));
                        } else {
                            jsPromptResult.confirm(obj2);
                        }
                        return true;
                    }
                    z2 = true;
                    if (!z2) {
                    }
                    if (a) {
                    }
                    if (!z) {
                    }
                    return true;
                } catch (IllegalAccessException e2) {
                    if (a) {
                        e2.printStackTrace();
                        return false;
                    }
                    if (z) {
                        jsPromptResult.confirm(a(100, javaBridgeObject.func + " call failed!", (String) null));
                    } else {
                        jsPromptResult.cancel();
                    }
                    return true;
                } catch (IllegalArgumentException e3) {
                    if (a) {
                        e3.printStackTrace();
                        return false;
                    }
                    if (z) {
                    }
                    return true;
                } catch (NoSuchMethodException unused) {
                    if (a) {
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
                        jsPromptResult.confirm(a(102, javaBridgeObject.func + " not found, check the method name or arguments.", (String) null));
                    } else {
                        jsPromptResult.cancel();
                    }
                    return true;
                } catch (InvocationTargetException e4) {
                    if (a) {
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

    private String a(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65539, this, i2, str, str2)) == null) {
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
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeILL.objValue;
    }

    private Class<?> a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, obj)) == null) {
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
}
