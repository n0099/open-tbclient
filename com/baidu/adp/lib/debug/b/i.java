package com.baidu.adp.lib.debug.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.baidu.adp.lib.debug.service.SwitchDebugService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ c hm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.hm = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        String str = (String) SwitchDebugService.customConfig.get("update_package_address");
        if (str == null) {
            context = this.hm.mContext;
            Toast makeText = Toast.makeText(context.getApplicationContext(), "更新地址没有配置！！！", 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        context2 = this.hm.mContext;
        context2.startActivity(intent);
    }
}
