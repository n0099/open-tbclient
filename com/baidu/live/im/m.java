package com.baidu.live.im;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.gift.z;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.Map;
/* loaded from: classes4.dex */
public class m {
    private w aFN;

    public void g(w wVar) {
        Log.i("i", "@@@ localText imsdmctrl ent");
        Np();
        a(wVar);
    }

    public void a(w wVar) {
        this.aFN = wVar;
    }

    public void IB() {
        Log.i("i", "@@@ localText imsdmctrl oqt");
        this.aFN = null;
        Nq();
    }

    private void Np() {
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

    private void Nq() {
        Log.i("i", "@@@ localText imsdmctrl unr");
        MessageManager.getInstance().unRegisterTask(2913100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        Log.i("i", "@@@ localText imsdmctrl onsm");
        if (!Le()) {
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
        Map<String, Integer> Ik = z.Ii().Ik();
        if (Ik != null && Ik.containsKey(imSendMsgData.barrageId) && Ik.get(imSendMsgData.barrageId).intValue() > 0) {
            imSendMsgData.barrageCardInfo = new com.baidu.live.im.data.d(true, String.valueOf(this.aFN.aJV.userId), String.valueOf(this.aFN.mLiveInfo.live_id));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2913101, imSendMsgData));
        MessageManager.getInstance().sendMessage(new CustomMessage(2501069, imSendMsgData));
    }

    private boolean Le() {
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
