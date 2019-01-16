package com.baidu.browser.sailor.feature;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private Enum<EnumC0066a> VX;
    private Map<String, b> VY = new HashMap();

    /* renamed from: com.baidu.browser.sailor.feature.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    enum EnumC0066a {
        ENABLE,
        DISABLE
    }

    public a(Context context) {
    }

    public void a(String str, b bVar) {
        if (this.VY.containsKey(str)) {
            return;
        }
        this.VY.put(str, bVar);
    }

    public void disable() {
        this.VX = EnumC0066a.DISABLE;
    }

    public void enable() {
        this.VX = EnumC0066a.ENABLE;
    }

    public String getName() {
        return "BdSailorFeature";
    }

    public boolean isEnable() {
        return this.VX == EnumC0066a.ENABLE;
    }
}
