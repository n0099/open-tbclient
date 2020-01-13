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
    private static p cEG;
    private b cEF;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.BdToken.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (p.this.cEF != null && customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                    p.this.avM();
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

    public static p avL() {
        if (cEG == null) {
            synchronized (p.class) {
                if (cEG == null) {
                    cEG = new p();
                }
            }
        }
        return cEG;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.mAccountChangedListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public void q(b bVar) {
        this.cEF = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avM() {
        if (this.cEF != null && this.cEF.getActivityId() != 0 && this.cEF.auT() != 0 && this.cEF.getTaskType() == 9) {
            try {
                String valueOf = String.valueOf(this.cEF.getActivityId());
                String valueOf2 = String.valueOf(this.cEF.auT());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(valueOf, valueOf2);
                CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
                completeTaskReqMsg.completeId = jSONObject.toString();
                JSONObject a = com.baidu.tbadk.BdToken.completeTask.c.a(null, this.cEF.getActivityId(), this.cEF.auT(), this.cEF.getToken());
                if (a != null) {
                    completeTaskReqMsg.setToken(a.toString());
                }
                completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
                MessageManager.getInstance().sendMessage(completeTaskReqMsg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
