package com.baidu.tbadk.core.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ o ajB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.ajB = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.an anVar;
        PopupWindow popupWindow;
        JSONObject l;
        o.a aVar;
        o.a aVar2;
        com.baidu.tbadk.core.data.an anVar2;
        anVar = this.ajB.ajk;
        if (anVar != null) {
            popupWindow = this.ajB.aji;
            if (popupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                l = this.ajB.l(arrayList);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, l));
                this.ajB.wc();
                h hVar = new h();
                hVar.aiM = 1500L;
                hVar.d(this.ajB.getResources().getString(w.l.reduce_related_thread_recommend));
                aVar = this.ajB.ajq;
                if (aVar != null) {
                    aVar2 = this.ajB.ajq;
                    anVar2 = this.ajB.ajk;
                    aVar2.a(arrayList, anVar2);
                }
            }
        }
    }
}
