package com.baidu.ala.view;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class AlaLivePushRemindDialog {
    private TbPageContext mPageContext;
    private c msgRemindListener = new c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.ala.view.AlaLivePushRemindDialog.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if ((socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) && ((ResponseUpdateMaskInfoMessage) socketResponsedMessage).getError() == 0) {
                d.aqY().jl(300);
                d.aqY().eK(true);
                d.aqY().eL(true);
                d.aqY().eJ(true);
                d.aqY().eB(true);
                d.aqY().eC(true);
                d.aqY().eA(true);
                AlaLivePushRemindDialog.this.jumpSystemPermissionSetting();
            }
        }
    };

    public AlaLivePushRemindDialog(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.msgRemindListener);
    }

    public void showDialog(final boolean z) {
        a aVar = new a(this.mPageContext.getPageActivity());
        aVar.setAutoNight(false);
        aVar.hS(R.string.ala_live_push_remind);
        aVar.a(R.string.ala_live_push_remind_open, new a.b() { // from class: com.baidu.ala.view.AlaLivePushRemindDialog.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(a aVar2) {
                TiebaStatic.log("c12670");
                AlaLivePushRemindDialog.this.openMsgRemind();
                aVar2.dismiss();
                if (z) {
                    AlaAttentionManager.getInstance().showAttentionSucceedTip(AlaLivePushRemindDialog.this.mPageContext);
                }
            }
        });
        aVar.b(R.string.ala_live_push_remind_close, new a.b() { // from class: com.baidu.ala.view.AlaLivePushRemindDialog.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(a aVar2) {
                TiebaStatic.log("c12671");
                aVar2.dismiss();
                if (z) {
                    AlaAttentionManager.getInstance().showAttentionSucceedTip(AlaLivePushRemindDialog.this.mPageContext);
                }
            }
        });
        aVar.b(this.mPageContext).akM();
        TiebaStatic.log("c12669");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpSystemPermissionSetting() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName()));
            intent.setFlags(268435456);
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
}
