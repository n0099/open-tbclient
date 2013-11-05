package com.baidu.android.nebula.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f636a;

    private h(e eVar) {
        this.f636a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(e eVar, f fVar) {
        this(eVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        boolean z = true;
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED") || TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_REMOVED")) {
            if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED")) {
                a b = k.b(context, schemeSpecificPart);
                if (b != null) {
                    if (booleanExtra) {
                        b.a(b.UPDATE);
                    } else {
                        b.a(b.INSERT);
                    }
                    sVar3 = this.f636a.b;
                    sVar3.a(b);
                    sVar4 = this.f636a.e;
                    sVar4.a(b);
                }
                z = false;
            } else {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_REMOVED") && !booleanExtra) {
                    sVar = this.f636a.b;
                    a b2 = sVar.b(schemeSpecificPart);
                    if (b2 != null) {
                        b2.a(b.DELETE);
                        sVar2 = this.f636a.e;
                        sVar2.a(b2);
                    }
                }
                z = false;
            }
            if (z) {
                this.f636a.i();
            }
        }
    }
}
