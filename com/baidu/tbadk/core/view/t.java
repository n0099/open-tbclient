package com.baidu.tbadk.core.view;

import android.widget.PopupWindow;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ o agb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(o oVar, int i) {
        super(i);
        this.agb = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.agb.afM;
        if (popupWindow != null) {
            popupWindow2 = this.agb.afM;
            popupWindow2.dismiss();
        }
    }
}
