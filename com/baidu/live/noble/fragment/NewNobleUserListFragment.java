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
    private String aLy;
    private String bme;
    private e bnp;
    private b bnq;
    private com.baidu.live.noble.data.b bnr;
    private long bns;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a bnt = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void NP() {
            NewNobleUserListFragment.this.Kd();
        }
    };
    private final e.a bnu = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.bnr = bVar;
            if (NewNobleUserListFragment.this.bnq != null) {
                NewNobleUserListFragment.this.bnq.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.bns = 5L;
                NewNobleUserListFragment.this.aD(NewNobleUserListFragment.this.bns);
                return;
            }
            if (bVar.bnB <= 0) {
                NewNobleUserListFragment.this.bns = 5L;
            } else {
                NewNobleUserListFragment.this.bns = bVar.bnB;
            }
            NewNobleUserListFragment.this.aD(NewNobleUserListFragment.this.bns);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.bns = 5L;
            NewNobleUserListFragment.this.aD(NewNobleUserListFragment.this.bns);
            if (NewNobleUserListFragment.this.bnq != null && NewNobleUserListFragment.this.bnr == null) {
                NewNobleUserListFragment.this.bnq.co(true);
            }
        }
    };
    private final Runnable bnv = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.Kd();
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.bnq = new b(getPageContext(), this.mLiveId, this.bme, this.mIsHost);
        this.bnq.a(this.bnt);
        return this.bnq.getRootView();
    }

    private void initData(Bundle bundle) {
        this.bnp = new e(getPageContext(), this.bnu);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.bme = bundle.getString("anchor_id");
            this.aLy = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.bme = arguments.getString("anchor_id");
        this.aLy = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && isAdded()) {
            Kd();
        } else {
            NO();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bnq != null) {
            this.bnq.a(configuration);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.bme);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aLy);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd() {
        if (this.bnp != null) {
            this.bnp.aB(this.bme, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(long j) {
        if (this.mHandler != null && this.bnv != null) {
            this.mHandler.removeCallbacks(this.bnv);
            this.mHandler.postDelayed(this.bnv, 1000 * j);
        }
    }

    private void NO() {
        if (this.mHandler != null && this.bnv != null) {
            this.mHandler.removeCallbacks(this.bnv);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bnp != null) {
            this.bnp.onDestroy();
        }
        NO();
    }
}
