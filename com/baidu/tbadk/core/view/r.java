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
    final /* synthetic */ o ajL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.ajL = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.am amVar;
        PopupWindow popupWindow;
        JSONObject l;
        o.a aVar;
        o.a aVar2;
        com.baidu.tbadk.core.data.am amVar2;
        amVar = this.ajL.aju;
        if (amVar != null) {
            popupWindow = this.ajL.ajs;
            if (popupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                l = this.ajL.l(arrayList);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, l));
                this.ajL.wf();
                h hVar = new h();
                hVar.aiW = 1500L;
                hVar.d(this.ajL.getResources().getString(w.l.reduce_related_thread_recommend));
                aVar = this.ajL.ajA;
                if (aVar != null) {
                    aVar2 = this.ajL.ajA;
                    amVar2 = this.ajL.aju;
                    aVar2.a(arrayList, amVar2);
                }
            }
        }
    }
}
