package com.baidu.platform.comapi;

import android.content.Context;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.engine.NAEngine;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static boolean f4181a = false;

    /* renamed from: b  reason: collision with root package name */
    private NAEngine f4182b;

    public boolean a() {
        f4181a = false;
        return true;
    }

    public boolean a(Context context) {
        f4181a = false;
        this.f4182b = new NAEngine();
        boolean a2 = NAEngine.a(context, (String) null);
        if (a2) {
            return a2;
        }
        com.baidu.platform.comapi.e.a.a().a("engine_init_failed");
        return false;
    }

    public void b() {
        if (f4181a) {
            a();
        }
        MessageProxy.destroy();
        NAEngine.b();
    }
}
