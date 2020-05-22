package com.baidu.live.im;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.t;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.live.data.q aJj;

    public void g(com.baidu.live.data.q qVar) {
        Log.i("i", "@@@ localText imsdmctrl ent");
        CT();
        a(qVar);
    }

    public void a(com.baidu.live.data.q qVar) {
        this.aJj = qVar;
    }

    public void yw() {
        Log.i("i", "@@@ localText imsdmctrl oqt");
        this.aJj = null;
        CU();
    }

    private void CT() {
        Log.i("i", "@@@ localText imsdmctrl reg");
        CustomMessageTask customMessageTask = new CustomMessageTask(2913100, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.o.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    Log.i("i", "@@@ localText imsdmctrl run");
                    o.this.a(customMessage.getData());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void CU() {
        Log.i("i", "@@@ localText imsdmctrl unr");
        MessageManager.getInstance().unRegisterTask(2913100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        Log.i("i", "@@@ localText imsdmctrl onsm");
        if (!AP()) {
            Log.i("i", "@@@ localText imsdmctrl nolg");
            return;
        }
        Log.i("i", "@@@ localText imsdmctrl mt=" + ((int) imSendMsgData.msgType));
        switch (imSendMsgData.msgType) {
            case Opcodes.IAND /* 126 */:
                b(imSendMsgData);
                return;
            default:
                Log.i("i", "@@@ localText imsdmctrl sd");
                MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
                return;
        }
    }

    private void b(ImSendMsgData imSendMsgData) {
        Map<String, Integer> yn = t.yl().yn();
        if (yn != null && yn.containsKey(imSendMsgData.barrageId) && yn.get(imSendMsgData.barrageId).intValue() > 0) {
            imSendMsgData.barrageCardInfo = new com.baidu.live.im.data.b(true, String.valueOf(this.aJj.avj.userId), String.valueOf(this.aJj.mLiveInfo.live_id));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2913101, imSendMsgData));
    }

    private boolean AP() {
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
