package com.baidu.browser.sailor.feature;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private Enum<EnumC0066a> VO;
    private Map<String, b> VP = new HashMap();

    /* renamed from: com.baidu.browser.sailor.feature.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    enum EnumC0066a {
        ENABLE,
        DISABLE
    }

    public a(Context context) {
    }

    public void a(String str, b bVar) {
        if (this.VP.containsKey(str)) {
            return;
        }
        this.VP.put(str, bVar);
    }

    public void disable() {
        this.VO = EnumC0066a.DISABLE;
    }

    public void enable() {
        this.VO = EnumC0066a.ENABLE;
    }

    public String getName() {
        return "BdSailorFeature";
    }

    public boolean isEnable() {
        return this.VO == EnumC0066a.ENABLE;
    }
}
