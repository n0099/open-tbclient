package com.baidu.tbadk.collectTab;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.BaseFragment;
import d.a.c.e.p.j;
/* loaded from: classes3.dex */
public abstract class CollectFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public boolean f12733e = false;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f12734f = new a(2000994);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                CollectFragment collectFragment = CollectFragment.this;
                collectFragment.H0(collectFragment.E0());
                CollectFragment collectFragment2 = CollectFragment.this;
                if (collectFragment2.f12733e) {
                    return;
                }
                collectFragment2.I0(false, collectFragment2.E0());
            }
        }
    }

    public abstract int E0();

    public abstract boolean F0();

    public boolean G0() {
        return this.f12733e;
    }

    public void H0(int i2) {
        Bundle bundle = new Bundle();
        boolean z = !F0() && j.z();
        this.f12733e = z;
        bundle.putBoolean("is_enable_edit", z);
        bundle.putInt("fragment_type", i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022209, bundle));
    }

    public void I0(boolean z, int i2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", z);
        bundle.putInt("fragment_type", i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        registerListener(this.f12734f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        MessageManager.getInstance().unRegisterListener(this.f12734f);
    }
}
