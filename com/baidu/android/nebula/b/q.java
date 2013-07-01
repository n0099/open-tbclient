package com.baidu.android.nebula.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f270a;

    private q(c cVar) {
        this.f270a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(c cVar, t tVar) {
        this(cVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        boolean z = true;
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED") || TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_REMOVED")) {
            if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED")) {
                u b = f.b(context, schemeSpecificPart);
                if (b != null) {
                    if (booleanExtra) {
                        b.a(r.UPDATE);
                    } else {
                        b.a(r.INSERT);
                    }
                    jVar3 = this.f270a.b;
                    jVar3.a(b);
                    jVar4 = this.f270a.e;
                    jVar4.a(b);
                }
                z = false;
            } else {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_REMOVED") && !booleanExtra) {
                    jVar = this.f270a.b;
                    u b2 = jVar.b(schemeSpecificPart);
                    if (b2 != null) {
                        b2.a(r.DELETE);
                        jVar2 = this.f270a.e;
                        jVar2.a(b2);
                    }
                }
                z = false;
            }
            if (z) {
                this.f270a.i();
            }
        }
    }
}
