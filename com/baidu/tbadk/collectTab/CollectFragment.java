package com.baidu.tbadk.collectTab;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes3.dex */
public abstract class CollectFragment extends BaseFragment {
    protected boolean ajT = false;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.collectTab.CollectFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                CollectFragment.this.bN(CollectFragment.this.getType());
                if (!CollectFragment.this.ajT) {
                    CollectFragment.this.b(false, CollectFragment.this.getType());
                }
            }
        }
    };

    public abstract int getType();

    public abstract boolean wd();

    public boolean wc() {
        return this.ajT;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bN(int i) {
        Bundle bundle = new Bundle();
        this.ajT = !wd() && j.kV();
        bundle.putBoolean("is_enable_edit", this.ajT);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022209, bundle));
    }

    protected void b(boolean z, int i) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", z);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }
}
