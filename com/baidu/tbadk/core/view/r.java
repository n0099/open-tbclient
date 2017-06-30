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
    final /* synthetic */ o ako;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.ako = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ao aoVar;
        PopupWindow popupWindow;
        JSONObject l;
        o.a aVar;
        o.a aVar2;
        com.baidu.tbadk.core.data.ao aoVar2;
        aoVar = this.ako.ajS;
        if (aoVar != null) {
            popupWindow = this.ako.ajQ;
            if (popupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                l = this.ako.l(arrayList);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, l));
                this.ako.wt();
                h hVar = new h();
                hVar.aju = 1500L;
                hVar.d(this.ako.getResources().getString(w.l.reduce_related_thread_recommend));
                aVar = this.ako.akb;
                if (aVar != null) {
                    aVar2 = this.ako.akb;
                    aoVar2 = this.ako.ajS;
                    aVar2.a(arrayList, aoVar2);
                }
            }
        }
    }
}
