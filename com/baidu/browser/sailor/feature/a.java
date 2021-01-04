package com.baidu.browser.sailor.feature;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    private static final String TAG = "BdSailorFeature";
    private Map<String, b> mClientsMap = new HashMap();
    protected Context mContext;
    private Enum<EnumC0086a> mStatus;

    /* renamed from: com.baidu.browser.sailor.feature.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    enum EnumC0086a {
        ENABLE,
        DISABLE
    }

    public a(Context context) {
    }

    public void destroy() {
        this.mContext = null;
        try {
            this.mClientsMap.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disable() {
        this.mStatus = EnumC0086a.DISABLE;
    }

    public void enable() {
        this.mStatus = EnumC0086a.ENABLE;
    }

    public b getListenerFromActivity(String str) {
        return this.mClientsMap.get(str);
    }

    public String getName() {
        return TAG;
    }

    public boolean isEnable() {
        return this.mStatus == EnumC0086a.ENABLE;
    }

    public void regActivityResultCallback(String str, b bVar) {
        if (this.mClientsMap.containsKey(str)) {
            return;
        }
        this.mClientsMap.put(str, bVar);
    }

    public void unregActivityResultCallback(String str) {
        if (this.mClientsMap.containsKey(str)) {
            this.mClientsMap.remove(str);
        }
    }
}
