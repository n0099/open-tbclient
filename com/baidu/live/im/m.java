package com.baidu.live.im;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.u;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Map;
/* loaded from: classes4.dex */
public class m {
    private u aDU;

    public void i(u uVar) {
        Log.i("i", "@@@ localText imsdmctrl ent");
        La();
        a(uVar);
    }

    public void a(u uVar) {
        this.aDU = uVar;
    }

    public void Gx() {
        Log.i("i", "@@@ localText imsdmctrl oqt");
        this.aDU = null;
        Lb();
    }

    private void La() {
        Log.i("i", "@@@ localText imsdmctrl reg");
        CustomMessageTask customMessageTask = new CustomMessageTask(2913100, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.m.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    Log.i("i", "@@@ localText imsdmctrl run");
                    m.this.b(customMessage.getData());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Lb() {
        Log.i("i", "@@@ localText imsdmctrl unr");
        MessageManager.getInstance().unRegisterTask(2913100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        Log.i("i", "@@@ localText imsdmctrl onsm");
        if (!IS()) {
            Log.i("i", "@@@ localText imsdmctrl nolg");
            return;
        }
        Log.i("i", "@@@ localText imsdmctrl mt=" + ((int) imSendMsgData.msgType));
        switch (imSendMsgData.msgType) {
            case Opcodes.IAND /* 126 */:
                a(imSendMsgData);
                return;
            default:
                Log.i("i", "@@@ localText imsdmctrl sd");
                MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
                return;
        }
    }

    private void a(ImSendMsgData imSendMsgData) {
        Map<String, Integer> Gi = com.baidu.live.gift.u.Gg().Gi();
        if (Gi != null && Gi.containsKey(imSendMsgData.barrageId) && Gi.get(imSendMsgData.barrageId).intValue() > 0) {
            imSendMsgData.barrageCardInfo = new com.baidu.live.im.data.b(true, String.valueOf(this.aDU.aHD.userId), String.valueOf(this.aDU.mLiveInfo.live_id));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2913101, imSendMsgData));
        MessageManager.getInstance().sendMessage(new CustomMessage(2501069, imSendMsgData));
    }

    private boolean IS() {
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
