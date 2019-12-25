package com.baidu.live.im;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.q;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Map;
/* loaded from: classes2.dex */
public class m {
    private com.baidu.live.data.k aio;

    public void f(com.baidu.live.data.k kVar) {
        uN();
        a(kVar);
    }

    public void a(com.baidu.live.data.k kVar) {
        this.aio = kVar;
    }

    public void th() {
        this.aio = null;
        uO();
    }

    public void release() {
        th();
    }

    private void uN() {
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

    private void uO() {
        MessageManager.getInstance().unRegisterTask(2913100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (tq()) {
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
        Map<String, Integer> rm = q.rk().rm();
        if (rm != null && rm.containsKey(imSendMsgData.barrageId) && rm.get(imSendMsgData.barrageId).intValue() > 0) {
            imSendMsgData.barrageCardInfo = new com.baidu.live.im.data.b(true, String.valueOf(this.aio.VP.userId), String.valueOf(this.aio.mLiveInfo.live_id));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2913101, imSendMsgData));
    }

    private boolean tq() {
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
