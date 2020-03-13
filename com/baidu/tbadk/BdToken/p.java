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
    private static p cIM;
    private b cIL;
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tbadk.BdToken.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (p.this.cIL != null && customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                    p.this.ayb();
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

    public static p aya() {
        if (cIM == null) {
            synchronized (p.class) {
                if (cIM == null) {
                    cIM = new p();
                }
            }
        }
        return cIM;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.mLikeForumListener.setTag(bdUniqueId);
        this.mAccountChangedListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    public void q(b bVar) {
        this.cIL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayb() {
        if (this.cIL != null && this.cIL.getActivityId() != 0 && this.cIL.axj() != 0 && this.cIL.getTaskType() == 9) {
            try {
                String valueOf = String.valueOf(this.cIL.getActivityId());
                String valueOf2 = String.valueOf(this.cIL.axj());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(valueOf, valueOf2);
                CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
                completeTaskReqMsg.completeId = jSONObject.toString();
                JSONObject a = com.baidu.tbadk.BdToken.completeTask.c.a(null, this.cIL.getActivityId(), this.cIL.axj(), this.cIL.getToken());
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
