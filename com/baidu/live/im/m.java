package com.baidu.live.im;

import android.text.TextUtils;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.r;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class m {
    private com.baidu.live.data.m ald;

    public void g(com.baidu.live.data.m mVar) {
        wI();
        a(mVar);
    }

    public void a(com.baidu.live.data.m mVar) {
        this.ald = mVar;
    }

    public void sL() {
        this.ald = null;
        wJ();
    }

    public void release() {
        sL();
    }

    private void wI() {
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

    private void wJ() {
        MessageManager.getInstance().unRegisterTask(2913100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (uX()) {
            switch (imSendMsgData.msgType) {
                case Opcodes.IAND /* 126 */:
                    b(imSendMsgData);
                    return;
                default:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
                    return;
            }
        }
    }

    private void b(ImSendMsgData imSendMsgData) {
        Map<String, Integer> sz = r.sx().sz();
        if (sz != null && sz.containsKey(imSendMsgData.barrageId) && sz.get(imSendMsgData.barrageId).intValue() > 0) {
            imSendMsgData.barrageCardInfo = new com.baidu.live.im.data.b(true, String.valueOf(this.ald.XQ.userId), String.valueOf(this.ald.mLiveInfo.live_id));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2913101, imSendMsgData));
    }

    private boolean uX() {
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
