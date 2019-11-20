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
    private static p bRU;
    private b bRT;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.BdToken.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (p.this.bRT != null && customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                    p.this.aeA();
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

    public static p aez() {
        if (bRU == null) {
            synchronized (p.class) {
                if (bRU == null) {
                    bRU = new p();
                }
            }
        }
        return bRU;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.mAccountChangedListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public void q(b bVar) {
        this.bRT = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeA() {
        if (this.bRT != null && this.bRT.getActivityId() != 0 && this.bRT.adH() != 0 && this.bRT.getTaskType() == 9) {
            try {
                String valueOf = String.valueOf(this.bRT.getActivityId());
                String valueOf2 = String.valueOf(this.bRT.adH());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(valueOf, valueOf2);
                CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
                completeTaskReqMsg.completeId = jSONObject.toString();
                completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
                MessageManager.getInstance().sendMessage(completeTaskReqMsg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
