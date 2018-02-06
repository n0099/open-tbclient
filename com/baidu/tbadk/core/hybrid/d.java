package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.hybrid.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class d implements i {
    private final m aSY;
    private final HashMap<String, Method> aSZ = new HashMap<>();

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tbadk.core.hybrid.d */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public d(m mVar) {
        this.aSY = mVar;
        i(getClass());
        if (this.aSZ.isEmpty()) {
            throw new IllegalStateException("No native methods found!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.aSY.getContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessage(Message<?> message) {
        a.C0097a.sendMessage(message);
    }

    protected void b(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.dn("sendResponseToJS got empty callbackId.");
            return;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("errNo", "0");
        hashMap.put("errMsg", ImagesInvalidReceiver.SUCCESS);
        if (jSONObject != null) {
            hashMap.put("data", jSONObject);
        }
        this.aSY.a(n.c(str, hashMap));
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Object invoke;
        Method method = this.aSZ.get(str);
        if (method != null) {
            p pVar = (p) method.getAnnotation(p.class);
            String optString = jSONObject2.optString("callbackId");
            try {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (!pVar.BC()) {
                    if (parameterTypes.length == 2) {
                        invoke = method.invoke(this, optString, jSONObject);
                    } else if (parameterTypes.length == 1) {
                        invoke = method.invoke(this, jSONObject);
                    } else if (parameterTypes.length == 0) {
                        e.dn("native method " + getClass().getSimpleName() + ":" + pVar.value() + " ignored all parameters.");
                        invoke = method.invoke(this, new Object[0]);
                    } else {
                        a(str, jSONObject2, "500", "parameters too much!");
                        return;
                    }
                    if (!TextUtils.isEmpty(optString)) {
                        b(optString, (JSONObject) invoke);
                        return;
                    }
                    return;
                } else if (parameterTypes.length != 2) {
                    if (parameterTypes.length == 1) {
                        method.invoke(this, jSONObject);
                        if (!TextUtils.isEmpty(optString)) {
                            b(optString, null);
                            return;
                        }
                        return;
                    } else if (parameterTypes.length == 0) {
                        e.dn("native method " + getClass().getSimpleName() + ":" + pVar.value() + " ignored all parameters.");
                        method.invoke(this, new Object[0]);
                        if (!TextUtils.isEmpty(optString)) {
                            b(optString, null);
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
                e.dn("native method call error:" + e.getMessage());
                a(str, jSONObject2, "501", "IllegalAccessException:" + e.getMessage());
                return;
            } catch (InvocationTargetException e2) {
                e.dn("native method call error:" + e2.getMessage());
                a(str, jSONObject2, "502", "InvocationTargetException:" + e2.getMessage());
                return;
            } catch (Exception e3) {
                e.dn("native method call error:" + e3.getMessage());
                a(str, jSONObject2, "503", "Native call exception:" + e3.getMessage());
                return;
            }
        }
        a(str, jSONObject2, "403", "method " + str + " not exists");
    }

    private void a(String str, JSONObject jSONObject, String str2, String str3) {
        String optString = jSONObject.optString("callbackId");
        if (TextUtils.isEmpty(optString)) {
            e.dn("method " + str + " not found!");
            return;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("errNo", str2);
        hashMap.put("errMsg", str3);
        this.aSY.a(n.c(optString, hashMap));
    }

    private void i(Class<? extends d> cls) {
        Method[] declaredMethods;
        for (Method method : cls.getDeclaredMethods()) {
            p pVar = (p) method.getAnnotation(p.class);
            if (pVar != null) {
                String value = pVar.value();
                if (TextUtils.isEmpty(value)) {
                    value = null;
                }
                if (pVar.BC() && !Void.TYPE.equals(method.getReturnType())) {
                    throw new IllegalArgumentException("Method with async flag should return void.");
                }
                if (TextUtils.isEmpty(value)) {
                    value = method.getName();
                }
                method.setAccessible(true);
                this.aSZ.put(value, method);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && superclass != cls) {
            i(superclass);
        }
    }
}
