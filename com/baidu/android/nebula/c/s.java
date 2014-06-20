package com.baidu.android.nebula.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BroadcastReceiver {
    final /* synthetic */ i a;

    private s(i iVar) {
        this.a = iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(i iVar, t tVar) {
        this(iVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        boolean z = true;
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED") || TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_REMOVED")) {
            if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED")) {
                u b = j.b(context, schemeSpecificPart);
                if (b != null) {
                    if (booleanExtra) {
                        b.a(f.UPDATE);
                    } else {
                        b.a(f.INSERT);
                    }
                    nVar3 = this.a.b;
                    nVar3.a(b);
                    nVar4 = this.a.e;
                    nVar4.a(b);
                }
                z = false;
            } else {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_REMOVED") && !booleanExtra) {
                    nVar = this.a.b;
                    u b2 = nVar.b(schemeSpecificPart);
                    if (b2 != null) {
                        b2.a(f.DELETE);
                        nVar2 = this.a.e;
                        nVar2.a(b2);
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
