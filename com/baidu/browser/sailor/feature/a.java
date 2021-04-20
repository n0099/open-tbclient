package com.baidu.browser.sailor.feature;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static final String TAG = "BdSailorFeature";
    public Map<String, d.b.h.b.c.a> mClientsMap = new HashMap();
    public Context mContext;
    public Enum<EnumC0064a> mStatus;

    /* renamed from: com.baidu.browser.sailor.feature.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0064a {
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
        this.mStatus = EnumC0064a.DISABLE;
    }

    public void enable() {
        this.mStatus = EnumC0064a.ENABLE;
    }

    public d.b.h.b.c.a getListenerFromActivity(String str) {
        return this.mClientsMap.get(str);
    }

    public String getName() {
        return TAG;
    }

    public boolean isEnable() {
        return this.mStatus == EnumC0064a.ENABLE;
    }

    public void regActivityResultCallback(String str, d.b.h.b.c.a aVar) {
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
