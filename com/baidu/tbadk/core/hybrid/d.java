package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.hybrid.a;
import com.sina.weibo.sdk.constant.WBConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class d implements h {
    private final HashMap<String, Method> evA = new HashMap<>();
    private final l evz;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tbadk.core.hybrid.d */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public d(l lVar) {
        this.evz = lVar;
        t(getClass());
        if (this.evA.isEmpty()) {
            throw new IllegalStateException("No native methods found!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.evz.getContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessage(Message<?> message) {
        a.C0551a.sendMessage(message);
    }

    protected void n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.debug("sendResponseToJS got empty callbackId.");
            return;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("errNo", "0");
        hashMap.put("errMsg", "success");
        if (jSONObject != null) {
            hashMap.put("data", jSONObject);
        }
        this.evz.a(m.m(str, hashMap));
    }

    @Override // com.baidu.tbadk.core.hybrid.h
    public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Object invoke;
        Method method = this.evA.get(str);
        if (method != null) {
            o oVar = (o) method.getAnnotation(o.class);
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            try {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (!oVar.blz()) {
                    if (parameterTypes.length == 2) {
                        invoke = method.invoke(this, optString, jSONObject);
                    } else if (parameterTypes.length == 1) {
                        invoke = method.invoke(this, jSONObject);
                    } else if (parameterTypes.length == 0) {
                        e.debug("native method " + getClass().getSimpleName() + ":" + oVar.value() + " ignored all parameters.");
                        invoke = method.invoke(this, new Object[0]);
                    } else {
                        a(str, jSONObject2, "500", "parameters too much!");
                        return;
                    }
                    if (!TextUtils.isEmpty(optString)) {
                        n(optString, (JSONObject) invoke);
                        return;
                    }
                    return;
                } else if (parameterTypes.length != 2) {
                    if (parameterTypes.length == 1) {
                        method.invoke(this, jSONObject);
                        if (!TextUtils.isEmpty(optString)) {
                            n(optString, null);
                            return;
                        }
                        return;
                    } else if (parameterTypes.length == 0) {
                        e.debug("native method " + getClass().getSimpleName() + ":" + oVar.value() + " ignored all parameters.");
                        method.invoke(this, new Object[0]);
                        if (!TextUtils.isEmpty(optString)) {
                            n(optString, null);
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
                e.debug("native method call error:" + e.getMessage());
                a(str, jSONObject2, TbEnum.SystemMessage.EVENT_ID_UPLOAD_STAT, "IllegalAccessException:" + e.getMessage());
                return;
            } catch (InvocationTargetException e2) {
                e.debug("native method call error:" + e2.getMessage());
                a(str, jSONObject2, TbEnum.SystemMessage.EVENT_ID_PLUGIN_CONFIG_SYNC, "InvocationTargetException:" + e2.getMessage());
                return;
            } catch (Exception e3) {
                e.debug("native method call error:" + e3.getMessage());
                a(str, jSONObject2, TbEnum.SystemMessage.EVENT_ID_OFFLINE_DEBUG, "Native call exception:" + e3.getMessage());
                return;
            }
        }
        a(str, jSONObject2, "403", "method " + str + " not exists");
    }

    private void a(String str, JSONObject jSONObject, String str2, String str3) {
        String optString = jSONObject.optString(WBConstants.SHARE_CALLBACK_ID);
        if (TextUtils.isEmpty(optString)) {
            e.debug("method " + str + " not found!");
            return;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("errNo", str2);
        hashMap.put("errMsg", str3);
        this.evz.a(m.m(optString, hashMap));
    }

    private void t(Class<? extends d> cls) {
        Method[] declaredMethods;
        for (Method method : cls.getDeclaredMethods()) {
            o oVar = (o) method.getAnnotation(o.class);
            if (oVar != null) {
                String value = oVar.value();
                if (TextUtils.isEmpty(value)) {
                    value = null;
                }
                if (oVar.blz() && !Void.TYPE.equals(method.getReturnType())) {
                    throw new IllegalArgumentException("Method with async flag should return void.");
                }
                if (TextUtils.isEmpty(value)) {
                    value = method.getName();
                }
                method.setAccessible(true);
                this.evA.put(value, method);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && superclass != cls) {
            t(superclass);
        }
    }
}
