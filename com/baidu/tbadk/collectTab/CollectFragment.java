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
    public boolean f11979e = false;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f11980f = new a(2000994);

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
                collectFragment.G0(collectFragment.D0());
                CollectFragment collectFragment2 = CollectFragment.this;
                if (collectFragment2.f11979e) {
                    return;
                }
                collectFragment2.H0(false, collectFragment2.D0());
            }
        }
    }

    public abstract int D0();

    public abstract boolean E0();

    public boolean F0() {
        return this.f11979e;
    }

    public void G0(int i2) {
        Bundle bundle = new Bundle();
        boolean z = !E0() && j.z();
        this.f11979e = z;
        bundle.putBoolean("is_enable_edit", z);
        bundle.putInt("fragment_type", i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022209, bundle));
    }

    public void H0(boolean z, int i2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", z);
        bundle.putInt("fragment_type", i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        registerListener(this.f11980f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        MessageManager.getInstance().unRegisterListener(this.f11980f);
    }
}
