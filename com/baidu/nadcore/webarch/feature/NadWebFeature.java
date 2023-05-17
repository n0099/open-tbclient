package com.baidu.nadcore.webarch.feature;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class NadWebFeature {
    public STATUS a;

    /* loaded from: classes3.dex */
    public enum STATUS {
        ENABLE,
        DISABLE
    }

    public String b() {
        return "NadWebFeature";
    }

    public NadWebFeature(Context context) {
        new HashMap();
    }

    public void a() {
        this.a = STATUS.ENABLE;
    }

    public boolean c() {
        if (this.a == STATUS.ENABLE) {
            return true;
        }
        return false;
    }
}
