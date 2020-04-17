package com.baidu.live.im;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.s;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class o {
    private com.baidu.live.data.n aDE;

    public void g(com.baidu.live.data.n nVar) {
        Log.i("i", "@@@ localText imsdmctrl ent");
        Bx();
        a(nVar);
    }

    public void a(com.baidu.live.data.n nVar) {
        this.aDE = nVar;
    }

    public void xj() {
        Log.i("i", "@@@ localText imsdmctrl oqt");
        this.aDE = null;
        By();
    }

    public void release() {
        xj();
    }

    private void Bx() {
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

    private void By() {
        Log.i("i", "@@@ localText imsdmctrl unr");
        MessageManager.getInstance().unRegisterTask(2913100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        Log.i("i", "@@@ localText imsdmctrl onsm");
        if (!zA()) {
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
        Map<String, Integer> wX = s.wV().wX();
        if (wX != null && wX.containsKey(imSendMsgData.barrageId) && wX.get(imSendMsgData.barrageId).intValue() > 0) {
            imSendMsgData.barrageCardInfo = new com.baidu.live.im.data.b(true, String.valueOf(this.aDE.aqe.userId), String.valueOf(this.aDE.mLiveInfo.live_id));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2913101, imSendMsgData));
    }

    private boolean zA() {
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
