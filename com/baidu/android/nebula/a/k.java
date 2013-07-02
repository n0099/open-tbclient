package com.baidu.android.nebula.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BroadcastReceiver {
    final /* synthetic */ h a;

    private k(h hVar) {
        this.a = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(h hVar, i iVar) {
        this(hVar);
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
                a b = g.b(context, schemeSpecificPart);
                if (b != null) {
                    if (booleanExtra) {
                        b.a(b.UPDATE);
                    } else {
                        b.a(b.INSERT);
                    }
                    sVar3 = this.a.b;
                    sVar3.a(b);
                    sVar4 = this.a.e;
                    sVar4.a(b);
                }
                z = false;
            } else {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_REMOVED") && !booleanExtra) {
                    sVar = this.a.b;
                    a b2 = sVar.b(schemeSpecificPart);
                    if (b2 != null) {
                        b2.a(b.DELETE);
                        sVar2 = this.a.e;
                        sVar2.a(b2);
                    }
                }
                z = false;
            }
            if (z) {
                this.a.i();
            }
        }
    }
}
