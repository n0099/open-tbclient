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
    final /* synthetic */ o ajZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.ajZ = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.am amVar;
        PopupWindow popupWindow;
        JSONObject l;
        o.a aVar;
        o.a aVar2;
        com.baidu.tbadk.core.data.am amVar2;
        amVar = this.ajZ.ajI;
        if (amVar != null) {
            popupWindow = this.ajZ.ajG;
            if (popupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                l = this.ajZ.l(arrayList);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, l));
                this.ajZ.ww();
                h hVar = new h();
                hVar.ajk = 1500L;
                hVar.d(this.ajZ.getResources().getString(w.l.reduce_related_thread_recommend));
                aVar = this.ajZ.ajO;
                if (aVar != null) {
                    aVar2 = this.ajZ.ajO;
                    amVar2 = this.ajZ.ajI;
                    aVar2.a(arrayList, amVar2);
                }
            }
        }
    }
}
