package com.baidu.platform.comapi;

import android.content.Context;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.engine.NAEngine;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static boolean f2817a = false;
    private NAEngine b;

    public boolean a() {
        f2817a = false;
        return true;
    }

    public boolean a(Context context) {
        f2817a = false;
        this.b = new NAEngine();
        boolean a2 = NAEngine.a(context, (String) null);
        if (a2) {
            return a2;
        }
        com.baidu.platform.comapi.e.a.a().a("engine_init_failed");
        return false;
    }

    public void b() {
        if (f2817a) {
            a();
        }
        MessageProxy.destroy();
        NAEngine.b();
    }
}
