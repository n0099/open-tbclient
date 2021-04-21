package com.baidu.ala.view;

import android.content.Intent;
import android.net.Uri;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.c.c.g.c;
import d.b.i0.r.s.a;
import d.b.i0.s.d.d;
/* loaded from: classes.dex */
public class AlaLivePushRemindDialog {
    public TbPageContext mPageContext;
    public c msgRemindListener;

    public AlaLivePushRemindDialog(TbPageContext tbPageContext) {
        c cVar = new c(104102) { // from class: com.baidu.ala.view.AlaLivePushRemindDialog.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if ((socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) && ((ResponseUpdateMaskInfoMessage) socketResponsedMessage).getError() == 0) {
                    d.d().E(300);
                    d.d().C(true);
                    d.d().G(true);
                    d.d().H(true);
                    d.d().B(true);
                    d.d().K(true);
                    d.d().D(true);
                    AlaLivePushRemindDialog.this.jumpSystemPermissionSetting();
                }
            }
        };
        this.msgRemindListener = cVar;
        this.mPageContext = tbPageContext;
        tbPageContext.registerListener(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpSystemPermissionSetting() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName()));
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            this.mPageContext.getPageActivity().startActivity(intent);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openMsgRemind() {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(14);
        requestUpdateMaskInfoMessage.setSettingMask(true);
        this.mPageContext.sendMessage(requestUpdateMaskInfoMessage);
    }

    public void showDialog(final boolean z) {
        a aVar = new a(this.mPageContext.getPageActivity());
        aVar.setAutoNight(false);
        aVar.setTitle(R.string.ala_live_push_remind);
        aVar.setPositiveButton(R.string.ala_live_push_remind_open, new a.e() { // from class: com.baidu.ala.view.AlaLivePushRemindDialog.2
            @Override // d.b.i0.r.s.a.e
            public void onClick(a aVar2) {
                TiebaStatic.log("c12670");
                AlaLivePushRemindDialog.this.openMsgRemind();
                aVar2.dismiss();
                if (z) {
                    AlaAttentionManager.getInstance().showAttentionSucceedTip(AlaLivePushRemindDialog.this.mPageContext);
                }
            }
        });
        aVar.setNegativeButton(R.string.ala_live_push_remind_close, new a.e() { // from class: com.baidu.ala.view.AlaLivePushRemindDialog.3
            @Override // d.b.i0.r.s.a.e
            public void onClick(a aVar2) {
                TiebaStatic.log("c12671");
                aVar2.dismiss();
                if (z) {
                    AlaAttentionManager.getInstance().showAttentionSucceedTip(AlaLivePushRemindDialog.this.mPageContext);
                }
            }
        });
        aVar.create(this.mPageContext).show();
        TiebaStatic.log("c12669");
    }
}
