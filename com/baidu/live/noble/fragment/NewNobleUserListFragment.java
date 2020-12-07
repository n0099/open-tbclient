package com.baidu.live.noble.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.noble.c.e;
import com.baidu.live.noble.d.b;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.log.LogConfig;
/* loaded from: classes4.dex */
public class NewNobleUserListFragment extends BaseFragment {
    private String aOt;
    private String brl;
    private long bsA;
    private e bsx;
    private b bsy;
    private com.baidu.live.noble.data.b bsz;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a bsB = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void Qi() {
            NewNobleUserListFragment.this.Mf();
        }
    };
    private final e.a bsC = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.bsz = bVar;
            if (NewNobleUserListFragment.this.bsy != null) {
                NewNobleUserListFragment.this.bsy.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.bsA = 5L;
                NewNobleUserListFragment.this.bb(NewNobleUserListFragment.this.bsA);
                return;
            }
            if (bVar.bsJ <= 0) {
                NewNobleUserListFragment.this.bsA = 5L;
            } else {
                NewNobleUserListFragment.this.bsA = bVar.bsJ;
            }
            NewNobleUserListFragment.this.bb(NewNobleUserListFragment.this.bsA);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.bsA = 5L;
            NewNobleUserListFragment.this.bb(NewNobleUserListFragment.this.bsA);
            if (NewNobleUserListFragment.this.bsy != null && NewNobleUserListFragment.this.bsz == null) {
                NewNobleUserListFragment.this.bsy.cC(true);
            }
        }
    };
    private final Runnable bsD = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.Mf();
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.bsy = new b(getPageContext(), this.mLiveId, this.brl, this.mIsHost);
        this.bsy.a(this.bsB);
        return this.bsy.getRootView();
    }

    private void initData(Bundle bundle) {
        this.bsx = new e(getPageContext(), this.bsC);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.brl = bundle.getString("anchor_id");
            this.aOt = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.brl = arguments.getString("anchor_id");
        this.aOt = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && isAdded()) {
            Mf();
        } else {
            Qh();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bsy != null) {
            this.bsy.a(configuration);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.brl);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aOt);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mf() {
        if (this.bsx != null) {
            this.bsx.aF(this.brl, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(long j) {
        if (this.mHandler != null && this.bsD != null) {
            this.mHandler.removeCallbacks(this.bsD);
            this.mHandler.postDelayed(this.bsD, 1000 * j);
        }
    }

    private void Qh() {
        if (this.mHandler != null && this.bsD != null) {
            this.mHandler.removeCallbacks(this.bsD);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bsx != null) {
            this.bsx.onDestroy();
        }
        Qh();
    }
}
