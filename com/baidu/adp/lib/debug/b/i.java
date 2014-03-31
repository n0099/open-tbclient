package com.baidu.adp.lib.debug.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.baidu.adp.lib.debug.service.SwitchDebugService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        String str = (String) SwitchDebugService.a.get("update_package_address");
        if (str == null) {
            context = this.a.k;
            Toast makeText = Toast.makeText(context.getApplicationContext(), "更新地址没有配置！！！", 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        context2 = this.a.k;
        context2.startActivity(intent);
    }
}
