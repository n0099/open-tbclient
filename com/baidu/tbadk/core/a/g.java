package com.baidu.tbadk.core.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context) {
        this.val$context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.setFlags(270532608);
        this.val$context.startActivity(intent);
    }
}
