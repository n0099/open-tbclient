package com.baidu.tbadk.core.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    private final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        this.a = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.setFlags(270532608);
        this.a.startActivity(intent);
    }
}
