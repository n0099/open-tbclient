package com.baidu.tbadk.core.view;

import android.widget.PopupWindow;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    final /* synthetic */ o afB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(o oVar, int i) {
        super(i);
        this.afB = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.afB.afo;
        if (popupWindow != null) {
            popupWindow2 = this.afB.afo;
            popupWindow2.dismiss();
        }
    }
}
