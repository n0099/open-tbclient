package com.baidu.tbadk.collectTab;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes24.dex */
public abstract class CollectFragment extends BaseFragment {
    protected boolean exa = false;
    private final CustomMessageListener exb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tbadk.collectTab.CollectFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                CollectFragment.this.nL(CollectFragment.this.getType());
                if (!CollectFragment.this.exa) {
                    CollectFragment.this.q(false, CollectFragment.this.getType());
                }
            }
        }
    };

    public abstract boolean bjE();

    public abstract int getType();

    public boolean bjD() {
        return this.exa;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        registerListener(this.exb);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        MessageManager.getInstance().unRegisterListener(this.exb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nL(int i) {
        Bundle bundle = new Bundle();
        this.exa = !bjE() && j.isNetWorkAvailable();
        bundle.putBoolean("is_enable_edit", this.exa);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ENABLE, bundle));
    }

    protected void q(boolean z, int i) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", z);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }
}
