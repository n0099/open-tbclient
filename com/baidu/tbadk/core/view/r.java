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
    final /* synthetic */ o akn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.akn = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.al alVar;
        PopupWindow popupWindow;
        JSONObject l;
        o.a aVar;
        o.a aVar2;
        com.baidu.tbadk.core.data.al alVar2;
        alVar = this.akn.ajW;
        if (alVar != null) {
            popupWindow = this.akn.ajU;
            if (popupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                l = this.akn.l(arrayList);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, l));
                this.akn.wS();
                h hVar = new h();
                hVar.ajy = 1500L;
                hVar.d(this.akn.getResources().getString(w.l.reduce_related_thread_recommend));
                aVar = this.akn.akc;
                if (aVar != null) {
                    aVar2 = this.akn.akc;
                    alVar2 = this.akn.ajW;
                    aVar2.a(arrayList, alVar2);
                }
            }
        }
    }
}
