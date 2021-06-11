package com.baidu.browser.sailor.feature;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static final String TAG = "BdSailorFeature";
    public Map<String, d.a.h.b.a.a> mClientsMap = new HashMap();
    public Context mContext;
    public Enum<EnumC0065a> mStatus;

    /* renamed from: com.baidu.browser.sailor.feature.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0065a {
        ENABLE,
        DISABLE
    }

    public a(Context context) {
    }

    public void destroy() {
        this.mContext = null;
        try {
            this.mClientsMap.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void disable() {
        this.mStatus = EnumC0065a.DISABLE;
    }

    public void enable() {
        this.mStatus = EnumC0065a.ENABLE;
    }

    public d.a.h.b.a.a getListenerFromActivity(String str) {
        return this.mClientsMap.get(str);
    }

    public String getName() {
        return TAG;
    }

    public boolean isEnable() {
        return this.mStatus == EnumC0065a.ENABLE;
    }

    public void regActivityResultCallback(String str, d.a.h.b.a.a aVar) {
        if (this.mClientsMap.containsKey(str)) {
            return;
        }
        this.mClientsMap.put(str, aVar);
    }

    public void unregActivityResultCallback(String str) {
        if (this.mClientsMap.containsKey(str)) {
            this.mClientsMap.remove(str);
        }
    }
}
