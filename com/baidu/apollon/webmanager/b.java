package com.baidu.apollon.webmanager;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JsPromptResult;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.sdk.WebChromeClient;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f4160b = "JsJavaBridge";

    /* renamed from: e  reason: collision with root package name */
    public static final int f4163e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f4164f = 101;

    /* renamed from: g  reason: collision with root package name */
    public static final int f4165g = 102;

    /* renamed from: h  reason: collision with root package name */
    public static final int f4166h = 100;

    /* renamed from: i  reason: collision with root package name */
    public static final String f4167i = "Local";
    public String m;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4159a = ApollonConstants.DEBUG & false;

    /* renamed from: c  reason: collision with root package name */
    public static final String f4161c = "BdWallet:";

    /* renamed from: d  reason: collision with root package name */
    public static final String f4162d = f4161c.toLowerCase();
    public final HashMap<String, Object> j = new HashMap<>();
    public final HashMap<String, Set<String>> k = new HashMap<>();
    public boolean l = false;
    public final Map<String, String> n = new HashMap();

    public void a(Object obj, String str) {
        if (f4159a) {
            Log.i(f4160b, "addJavascriptInterface to map: <" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj + ">");
        }
        if (obj == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.j.put(str, obj);
        this.m = null;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.n.remove(str);
    }

    public void c() {
        this.j.clear();
        this.m = null;
    }

    private boolean c(String str) {
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

    public String b() {
        if (!this.l && !TextUtils.isEmpty(this.m)) {
            return this.m;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:");
        sb.append("(function JsAddJavascriptInterface_(){");
        for (String str : this.j.keySet()) {
            try {
                a(sb, this.j.get(str), str);
            } catch (JSONException e2) {
                if (f4159a) {
                    Log.e(f4160b, "", e2);
                }
            }
        }
        for (String str2 : this.n.values()) {
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
        }
        this.l = false;
        if (f4159a) {
            sb.append("console.log('addJavascript done!');");
        }
        sb.append("}");
        sb.append(")()");
        this.m = sb.toString();
        if (f4159a) {
            Log.i(f4160b, "getImpactedJsString : " + this.m);
        }
        return this.m;
    }

    public void a(String str) {
        this.j.remove(str);
        this.m = null;
        if (f4159a) {
            Log.i(f4160b, "removeJavascriptInterface from map: " + str);
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.l = true;
        this.n.put(str, str2);
    }

    public void a() {
        this.n.clear();
    }

    public boolean a(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        String substring;
        boolean z;
        if (f4159a) {
            Log.i(f4160b, "handle url: " + str);
            Log.i(f4160b, "handle msg: " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.startsWith(f4161c)) {
            substring = str2.substring(9);
            z = true;
        } else if (!str2.startsWith(f4161c.toLowerCase())) {
            return false;
        } else {
            substring = str2.substring(9);
            z = false;
        }
        try {
            JavaBridgeObject javaBridgeObject = (JavaBridgeObject) JsonUtils.fromJson(substring, JavaBridgeObject.class);
            if (f4159a && javaBridgeObject != null) {
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
                LogUtil.i(f4160b, "call: " + sb.toString());
            }
            if (javaBridgeObject != null) {
                return a(jsPromptResult, z, javaBridgeObject);
            }
            return true;
        } catch (JSONException e2) {
            if (f4159a) {
                e2.printStackTrace();
            }
            jsPromptResult.cancel();
            return true;
        }
    }

    private boolean b(String str, String str2) {
        HashMap<String, Set<String>> hashMap;
        Set<String> set;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (hashMap = this.k) == null || hashMap.size() < 1 || (set = this.k.get(str)) == null) {
            return false;
        }
        return set.contains(str2);
    }

    @SuppressLint({"NewApi"})
    private void a(StringBuilder sb, Object obj, String str) throws JSONException {
        if (sb != null && obj != null && !TextUtils.isEmpty(str)) {
            Class<?> cls = obj.getClass();
            if (f4159a) {
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
                if (!name.endsWith(f4167i) && !c(name) && !hashSet.contains(name)) {
                    hashSet.add(name);
                    sb.append(name);
                    sb.append(":function(){");
                    if (method.getReturnType() != Void.TYPE) {
                        sb.append("return ");
                    }
                    sb.append("prompt('");
                    sb.append(f4162d);
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
            this.k.put(str, hashSet);
            int length = sb.length() - 1;
            if (sb.charAt(length) == ',') {
                sb.deleteCharAt(length);
            }
            sb.append("};");
            sb.append("}");
        } else if (f4159a) {
            Log.e(f4160b, "createJsScript: invalid params:");
            Log.e(f4160b, "script=" + ((Object) sb));
            Log.e(f4160b, "obj=" + obj + ", interfaceName=" + str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0102 A[Catch: InvocationTargetException -> 0x012c, IllegalAccessException -> 0x0135, IllegalArgumentException -> 0x013e, NoSuchMethodException -> 0x016a, TryCatch #2 {IllegalAccessException -> 0x0135, IllegalArgumentException -> 0x013e, NoSuchMethodException -> 0x016a, InvocationTargetException -> 0x012c, blocks: (B:34:0x00d3, B:36:0x00dd, B:39:0x00f1, B:47:0x0106, B:49:0x010a, B:51:0x0120, B:52:0x0128, B:46:0x0102), top: B:85:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010a A[Catch: InvocationTargetException -> 0x012c, IllegalAccessException -> 0x0135, IllegalArgumentException -> 0x013e, NoSuchMethodException -> 0x016a, TryCatch #2 {IllegalAccessException -> 0x0135, IllegalArgumentException -> 0x013e, NoSuchMethodException -> 0x016a, InvocationTargetException -> 0x012c, blocks: (B:34:0x00d3, B:36:0x00dd, B:39:0x00f1, B:47:0x0106, B:49:0x010a, B:51:0x0120, B:52:0x0128, B:46:0x0102), top: B:85:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0120 A[Catch: InvocationTargetException -> 0x012c, IllegalAccessException -> 0x0135, IllegalArgumentException -> 0x013e, NoSuchMethodException -> 0x016a, TryCatch #2 {IllegalAccessException -> 0x0135, IllegalArgumentException -> 0x013e, NoSuchMethodException -> 0x016a, InvocationTargetException -> 0x012c, blocks: (B:34:0x00d3, B:36:0x00dd, B:39:0x00f1, B:47:0x0106, B:49:0x010a, B:51:0x0120, B:52:0x0128, B:46:0x0102), top: B:85:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0128 A[Catch: InvocationTargetException -> 0x012c, IllegalAccessException -> 0x0135, IllegalArgumentException -> 0x013e, NoSuchMethodException -> 0x016a, TRY_LEAVE, TryCatch #2 {IllegalAccessException -> 0x0135, IllegalArgumentException -> 0x013e, NoSuchMethodException -> 0x016a, InvocationTargetException -> 0x012c, blocks: (B:34:0x00d3, B:36:0x00dd, B:39:0x00f1, B:47:0x0106, B:49:0x010a, B:51:0x0120, B:52:0x0128, B:46:0x0102), top: B:85:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0166  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(JsPromptResult jsPromptResult, boolean z, JavaBridgeObject javaBridgeObject) {
        Class<?>[] clsArr;
        boolean z2;
        Object obj = this.j.get(javaBridgeObject.obj);
        if (obj == null) {
            if (f4159a) {
                Log.e(f4160b, "not exist js interface:" + javaBridgeObject.obj);
            }
            if (z) {
                jsPromptResult.confirm(a(101, "interface:" + javaBridgeObject.obj + " not found!", (String) null));
            } else {
                jsPromptResult.cancel();
            }
            return true;
        } else if (javaBridgeObject.args == null && javaBridgeObject.func == null) {
            if (f4159a) {
                Log.d(f4160b, "interface query: found for " + obj);
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
                    if (f4159a) {
                        Log.d(f4160b, "type:" + clsArr[i2].getName());
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
                    if (f4159a) {
                        Log.i(f4160b, "called ok: " + obj2);
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
                if (f4159a) {
                }
                if (!z) {
                }
                return true;
            } catch (IllegalAccessException e2) {
                if (f4159a) {
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
                if (f4159a) {
                    e3.printStackTrace();
                    return false;
                }
                if (z) {
                }
                return true;
            } catch (NoSuchMethodException unused) {
                if (f4159a) {
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
                if (f4159a) {
                    e4.printStackTrace();
                    return false;
                }
                if (z) {
                }
                return true;
            }
        }
    }

    private String a(int i2, String str, String str2) {
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
            if (f4159a) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    private Class<?> a(Object obj) {
        Class<?> cls = obj.getClass();
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return String.class;
    }
}
