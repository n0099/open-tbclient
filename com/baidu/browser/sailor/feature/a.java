package com.baidu.browser.sailor.feature;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private Enum<EnumC0066a> VM;
    private Map<String, b> VN = new HashMap();

    /* renamed from: com.baidu.browser.sailor.feature.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    enum EnumC0066a {
        ENABLE,
        DISABLE
    }

    public a(Context context) {
    }

    public void a(String str, b bVar) {
        if (this.VN.containsKey(str)) {
            return;
        }
        this.VN.put(str, bVar);
    }

    public void disable() {
        this.VM = EnumC0066a.DISABLE;
    }

    public void enable() {
        this.VM = EnumC0066a.ENABLE;
    }

    public String getName() {
        return "BdSailorFeature";
    }

    public boolean isEnable() {
        return this.VM == EnumC0066a.ENABLE;
    }
}
