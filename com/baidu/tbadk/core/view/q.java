package com.baidu.tbadk.core.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ o afB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.afB = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.c cVar;
        com.baidu.tieba.card.data.c cVar2;
        PopupWindow popupWindow;
        JSONObject selectedResultJsonObj;
        PopupWindow popupWindow2;
        cVar = this.afB.afq;
        if (cVar != null) {
            cVar2 = this.afB.afq;
            if (cVar2.Jv() != null) {
                popupWindow = this.afB.afo;
                if (popupWindow == null) {
                    return;
                }
                selectedResultJsonObj = this.afB.getSelectedResultJsonObj();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, selectedResultJsonObj));
                popupWindow2 = this.afB.afo;
                popupWindow2.dismiss();
                h hVar = new h();
                hVar.aeT = 1500L;
                hVar.d(this.afB.getResources().getString(r.j.reduce_related_thread_recommend));
            }
        }
    }
}
