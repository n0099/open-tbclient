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
    final /* synthetic */ o agb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.agb = oVar;
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
        cVar = this.agb.afO;
        if (cVar != null) {
            cVar2 = this.agb.afO;
            if (cVar2.Jz() != null) {
                popupWindow = this.agb.afM;
                if (popupWindow != null) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    m = this.agb.m(arrayList);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, m));
                    popupWindow2 = this.agb.afM;
                    popupWindow2.dismiss();
                    h hVar = new h();
                    hVar.afr = 1500L;
                    hVar.d(this.agb.getResources().getString(r.j.reduce_related_thread_recommend));
                    aVar = this.agb.afV;
                    if (aVar != null) {
                        aVar2 = this.agb.afV;
                        cVar3 = this.agb.afO;
                        aVar2.a(arrayList, cVar3);
                    }
                }
            }
        }
    }
}
