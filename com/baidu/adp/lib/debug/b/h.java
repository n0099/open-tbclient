package com.baidu.adp.lib.debug.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.baidu.adp.lib.debug.service.SwitchDebugService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f469a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.f469a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        String str = (String) SwitchDebugService.f477a.get("update_package_address");
        if (str == null) {
            context = this.f469a.k;
            Toast makeText = Toast.makeText(context.getApplicationContext(), "更新地址没有配置！！！", 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        context2 = this.f469a.k;
        context2.startActivity(intent);
    }
}
