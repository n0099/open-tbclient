package com.baidu.platform.comapi;

import android.content.Context;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.engine.NAEngine;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class a {
    static boolean a = false;
    private NAEngine b;

    public boolean a() {
        a = false;
        return true;
    }

    public boolean a(Context context) {
        a = false;
        this.b = new NAEngine();
        boolean a2 = NAEngine.a(context, (String) null);
        if (a2) {
            return a2;
        }
        com.baidu.platform.comapi.e.a.a().a("engine_init_failed");
        return false;
    }

    public void b() {
        if (a) {
            a();
        }
        MessageProxy.destroy();
        NAEngine.b();
    }
}
