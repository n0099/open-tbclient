package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.adp.R;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ c hm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.hm = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String str;
        Context context2;
        context = this.hm.mContext;
        String editable = ((EditText) ((Activity) context).findViewById(R.id.switch_lcs_reOnline_lcs_address)).getText().toString();
        if (editable != null && editable.length() != 0) {
            if (!editable.startsWith("ws://")) {
                c.hl = "ws://" + editable;
            } else {
                c.hl = editable;
            }
        }
        str = c.hl;
        com.baidu.adp.framework.client.socket.l.setUrl(str);
        BdSocketLinkService.init();
        BdSocketLinkService.close(-1, "Closed by Debug View");
        BdSocketLinkService.startService(true, "Restart by Debug View");
        context2 = this.hm.mContext;
        Toast.makeText(context2, R.string.lcsReOnlineSucc, 1).show();
    }
}
