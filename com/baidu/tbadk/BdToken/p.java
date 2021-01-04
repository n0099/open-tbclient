package com.baidu.tbadk.BdToken;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private static p eHc;
    private b eHb;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.BdToken.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (p.this.eHb != null && customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.e) && ((com.baidu.tieba.tbadkCore.writeModel.e) data).isSuccess) {
                    p.this.blz();
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tbadk.BdToken.p.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
            }
        }
    };

    public static p bly() {
        if (eHc == null) {
            synchronized (p.class) {
                if (eHc == null) {
                    eHc = new p();
                }
            }
        }
        return eHc;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.mAccountChangedListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public void q(b bVar) {
        this.eHb = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blz() {
        if (this.eHb != null && this.eHb.getActivityId() != 0 && this.eHb.bkD() != 0 && this.eHb.getTaskType() == 9) {
            try {
                String valueOf = String.valueOf(this.eHb.getActivityId());
                String valueOf2 = String.valueOf(this.eHb.bkD());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(valueOf, valueOf2);
                CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
                completeTaskReqMsg.completeId = jSONObject.toString();
                JSONObject a2 = com.baidu.tbadk.BdToken.completeTask.c.a(null, this.eHb.getActivityId(), this.eHb.bkD(), this.eHb.getToken());
                if (a2 != null) {
                    completeTaskReqMsg.setToken(a2.toString());
                }
                completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
                MessageManager.getInstance().sendMessage(completeTaskReqMsg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
