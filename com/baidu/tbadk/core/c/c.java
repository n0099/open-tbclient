package com.baidu.tbadk.core.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class c implements i {
    private final m TD;
    private final HashMap<String, Method> TE = new HashMap<>();

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tbadk.core.c.c */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public c(m mVar) {
        this.TD = mVar;
        q(getClass());
        if (this.TE.isEmpty()) {
            throw new IllegalStateException("No native methods found!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.TD.getContext();
    }

    protected void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            d.cC("sendResponseToJS got empty callbackId.");
            return;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("errNo", "0");
        hashMap.put("errMsg", ImagesInvalidReceiver.SUCCESS);
        if (jSONObject != null) {
            hashMap.put("data", jSONObject);
        }
        this.TD.a(n.b(str, hashMap));
    }

    @Override // com.baidu.tbadk.core.c.i
    public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Object invoke;
        Method method = this.TE.get(str);
        if (method != null) {
            p pVar = (p) method.getAnnotation(p.class);
            String optString = jSONObject2.optString("callbackId");
            try {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (!pVar.sC()) {
                    if (parameterTypes.length == 2) {
                        invoke = method.invoke(this, optString, jSONObject);
                    } else if (parameterTypes.length == 1) {
                        invoke = method.invoke(this, jSONObject);
                    } else if (parameterTypes.length == 0) {
                        d.cC("native method " + getClass().getSimpleName() + ":" + pVar.value() + " ignored all parameters.");
                        invoke = method.invoke(this, new Object[0]);
                    } else {
                        a(str, jSONObject2, "500", "parameters too much!");
                        return;
                    }
                    if (!TextUtils.isEmpty(optString)) {
                        c(optString, (JSONObject) invoke);
                        return;
                    }
                    return;
                } else if (parameterTypes.length != 2) {
                    if (parameterTypes.length == 1) {
                        method.invoke(this, jSONObject);
                        if (!TextUtils.isEmpty(optString)) {
                            c(optString, null);
                            return;
                        }
                        return;
                    } else if (parameterTypes.length == 0) {
                        d.cC("native method " + getClass().getSimpleName() + ":" + pVar.value() + " ignored all parameters.");
                        method.invoke(this, new Object[0]);
                        if (!TextUtils.isEmpty(optString)) {
                            c(optString, null);
                            return;
                        }
                        return;
                    } else {
                        a(str, jSONObject2, "500", "parameters too much!");
                        return;
                    }
                } else {
                    method.invoke(this, optString, jSONObject);
                    return;
                }
            } catch (IllegalAccessException e) {
                d.cC("native method call error:" + e.getMessage());
                a(str, jSONObject2, "501", "IllegalAccessException:" + e.getMessage());
                return;
            } catch (InvocationTargetException e2) {
                d.cC("native method call error:" + e2.getMessage());
                a(str, jSONObject2, "502", "InvocationTargetException:" + e2.getMessage());
                return;
            } catch (Exception e3) {
                d.cC("native method call error:" + e3.getMessage());
                a(str, jSONObject2, "503", "Native call exception:" + e3.getMessage());
                return;
            }
        }
        a(str, jSONObject2, "403", "method " + str + " not exists");
    }

    private void a(String str, JSONObject jSONObject, String str2, String str3) {
        String optString = jSONObject.optString("callbackId");
        if (TextUtils.isEmpty(optString)) {
            d.cC("method " + str + " not found!");
            return;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("errNo", str2);
        hashMap.put("errMsg", str3);
        this.TD.a(n.b(optString, hashMap));
    }

    private void q(Class<? extends c> cls) {
        Method[] declaredMethods;
        for (Method method : cls.getDeclaredMethods()) {
            p pVar = (p) method.getAnnotation(p.class);
            if (pVar != null) {
                String value = pVar.value();
                if (TextUtils.isEmpty(value)) {
                    value = null;
                }
                if (pVar.sC() && !Void.TYPE.equals(method.getReturnType())) {
                    throw new IllegalArgumentException("Method with async flag should return void.");
                }
                if (TextUtils.isEmpty(value)) {
                    value = method.getName();
                }
                method.setAccessible(true);
                this.TE.put(value, method);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && superclass != cls) {
            q(superclass);
        }
    }
}
