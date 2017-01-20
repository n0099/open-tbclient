package com.baidu.tbadk.core.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.r;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ o aeH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.aeH = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.data.c cVar;
        com.baidu.tieba.card.data.c cVar2;
        PopupWindow popupWindow;
        JSONObject m;
        PopupWindow popupWindow2;
        o.a aVar;
        o.a aVar2;
        com.baidu.tieba.card.data.c cVar3;
        cVar = this.aeH.aes;
        if (cVar != null) {
            cVar2 = this.aeH.aes;
            if (cVar2.Ji() != null) {
                popupWindow = this.aeH.aeq;
                if (popupWindow != null) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    m = this.aeH.m(arrayList);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, m));
                    popupWindow2 = this.aeH.aeq;
                    popupWindow2.dismiss();
                    h hVar = new h();
                    hVar.adV = 1500L;
                    hVar.d(this.aeH.getResources().getString(r.l.reduce_related_thread_recommend));
                    aVar = this.aeH.aez;
                    if (aVar != null) {
                        aVar2 = this.aeH.aez;
                        cVar3 = this.aeH.aes;
                        aVar2.a(arrayList, cVar3);
                    }
                }
            }
        }
    }
}
