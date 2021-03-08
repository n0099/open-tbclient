package com.baidu.live.im;

import android.text.TextUtils;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.gift.z;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Map;
/* loaded from: classes10.dex */
public class m {
    private ab aED;

    public void g(ab abVar) {
        Ku();
        a(abVar);
    }

    public void a(ab abVar) {
        this.aED = abVar;
    }

    public void FB() {
        this.aED = null;
        Kv();
    }

    private void Ku() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913100, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.m.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    m.this.b(customMessage.getData());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Kv() {
        MessageManager.getInstance().unRegisterTask(2913100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (Ic()) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), a.h.ala_create_no_network);
            }
            switch (imSendMsgData.msgType) {
                case Opcodes.IAND /* 126 */:
                    a(imSendMsgData);
                    return;
                default:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
                    return;
            }
        }
    }

    private void a(ImSendMsgData imSendMsgData) {
        Map<String, Integer> Fj = z.Fh().Fj();
        if (Fj != null && Fj.containsKey(imSendMsgData.barrageId)) {
            if (Fj.get(imSendMsgData.barrageId).intValue() > 0) {
                imSendMsgData.barrageCardInfo = new com.baidu.live.im.data.d(true, String.valueOf(this.aED.aJD.userId), String.valueOf(this.aED.mLiveInfo.live_id));
                imSendMsgData.isUseCard = true;
            } else {
                imSendMsgData.isUseCard = false;
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2913101, imSendMsgData));
        MessageManager.getInstance().sendMessage(new CustomMessage(2501069, imSendMsgData));
    }

    private boolean Ic() {
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), a.h.sdk_not_login);
            return false;
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), a.h.sdk_username_empty);
            return false;
        } else {
            return true;
        }
    }
}
