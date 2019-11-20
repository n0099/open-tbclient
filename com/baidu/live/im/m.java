package com.baidu.live.im;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Map;
/* loaded from: classes6.dex */
public class m {
    private com.baidu.live.data.i aaj;

    public void f(com.baidu.live.data.i iVar) {
        sU();
        b(iVar);
    }

    public void b(com.baidu.live.data.i iVar) {
        this.aaj = iVar;
    }

    public void rt() {
        this.aaj = null;
        sV();
    }

    public void release() {
        rt();
    }

    private void sU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913100, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.m.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    m.this.a(customMessage.getData());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void sV() {
        MessageManager.getInstance().unRegisterTask(2913100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (rB()) {
            switch (imSendMsgData.msgType) {
                case 126:
                    b(imSendMsgData);
                    return;
                default:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
                    return;
            }
        }
    }

    private void b(ImSendMsgData imSendMsgData) {
        Map<String, Integer> pK = com.baidu.live.gift.o.pI().pK();
        if (pK != null && pK.containsKey(imSendMsgData.barrageId) && pK.get(imSendMsgData.barrageId).intValue() > 0) {
            imSendMsgData.barrageCardInfo = new com.baidu.live.im.data.b(true, String.valueOf(this.aaj.OR.userId), String.valueOf(this.aaj.mLiveInfo.live_id));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2913101, imSendMsgData));
    }

    private boolean rB() {
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), a.i.sdk_not_login);
            return false;
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), a.i.sdk_username_empty);
            return false;
        } else {
            return true;
        }
    }
}
