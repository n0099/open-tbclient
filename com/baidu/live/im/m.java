package com.baidu.live.im;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.r;
import com.baidu.live.gift.t;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Map;
/* loaded from: classes7.dex */
public class m {
    private r aAh;

    public void g(r rVar) {
        Log.i("i", "@@@ localText imsdmctrl ent");
        Jq();
        a(rVar);
    }

    public void a(r rVar) {
        this.aAh = rVar;
    }

    public void Fb() {
        Log.i("i", "@@@ localText imsdmctrl oqt");
        this.aAh = null;
        Jr();
    }

    private void Jq() {
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

    private void Jr() {
        Log.i("i", "@@@ localText imsdmctrl unr");
        MessageManager.getInstance().unRegisterTask(2913100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        Log.i("i", "@@@ localText imsdmctrl onsm");
        if (!Hu()) {
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
        Map<String, Integer> ES = t.EQ().ES();
        if (ES != null && ES.containsKey(imSendMsgData.barrageId) && ES.get(imSendMsgData.barrageId).intValue() > 0) {
            imSendMsgData.barrageCardInfo = new com.baidu.live.im.data.b(true, String.valueOf(this.aAh.aDE.userId), String.valueOf(this.aAh.mLiveInfo.live_id));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2913101, imSendMsgData));
    }

    private boolean Hu() {
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
