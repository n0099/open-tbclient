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
    final /* synthetic */ o afu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.afu = oVar;
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
        cVar = this.afu.afh;
        if (cVar != null) {
            cVar2 = this.afu.afh;
            if (cVar2.IU() != null) {
                popupWindow = this.afu.aff;
                if (popupWindow != null) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    m = this.afu.m(arrayList);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, m));
                    popupWindow2 = this.afu.aff;
                    popupWindow2.dismiss();
                    h hVar = new h();
                    hVar.aeK = 1500L;
                    hVar.d(this.afu.getResources().getString(r.j.reduce_related_thread_recommend));
                    aVar = this.afu.afo;
                    if (aVar != null) {
                        aVar2 = this.afu.afo;
                        cVar3 = this.afu.afh;
                        aVar2.a(arrayList, cVar3);
                    }
                }
            }
        }
    }
}
