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
/* loaded from: classes11.dex */
public abstract class CollectFragment extends BaseFragment {
    protected boolean dFo = false;
    private final CustomMessageListener dFp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tbadk.collectTab.CollectFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                CollectFragment.this.kj(CollectFragment.this.getType());
                if (!CollectFragment.this.dFo) {
                    CollectFragment.this.p(false, CollectFragment.this.getType());
                }
            }
        }
    };

    public abstract boolean aPx();

    public abstract int getType();

    public boolean aPw() {
        return this.dFo;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        registerListener(this.dFp);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        MessageManager.getInstance().unRegisterListener(this.dFp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kj(int i) {
        Bundle bundle = new Bundle();
        this.dFo = !aPx() && j.isNetWorkAvailable();
        bundle.putBoolean("is_enable_edit", this.dFo);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ENABLE, bundle));
    }

    protected void p(boolean z, int i) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", z);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ACTION, bundle));
    }
}
