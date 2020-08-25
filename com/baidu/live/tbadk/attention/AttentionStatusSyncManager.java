package com.baidu.live.tbadk.attention;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
/* loaded from: classes7.dex */
public class AttentionStatusSyncManager {
    private final CustomMessageListener attentionStatusChangeListener;
    private IAttentionStatusCallBack mCallBack;

    public static AttentionStatusSyncManager getInstance() {
        return InstanceHolder.sInst;
    }

    private AttentionStatusSyncManager() {
        this.attentionStatusChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.live.tbadk.attention.AttentionStatusSyncManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage updateAttentionMessage;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && !updateAttentionMessage.comeFromHost && updateAttentionMessage.getData().isSucc && AttentionStatusSyncManager.this.mCallBack != null) {
                    AttentionStatusSyncManager.this.mCallBack.updateFromSDK(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().status);
                }
            }
        };
        registerListenerFromSDK();
    }

    private void registerListenerFromSDK() {
        MessageManager.getInstance().registerListener(this.attentionStatusChangeListener);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        this.mCallBack = iAttentionStatusCallBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class InstanceHolder {
        private static final AttentionStatusSyncManager sInst = new AttentionStatusSyncManager();

        private InstanceHolder() {
        }
    }
}
