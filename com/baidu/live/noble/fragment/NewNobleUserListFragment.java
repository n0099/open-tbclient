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
    private String aLF;
    private String bla;
    private e bmg;
    private b bmh;
    private com.baidu.live.noble.data.b bmi;
    private long bmj;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a bmk = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void NB() {
            NewNobleUserListFragment.this.Nz();
        }
    };
    private final e.a bml = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.bmi = bVar;
            if (NewNobleUserListFragment.this.bmh != null) {
                NewNobleUserListFragment.this.bmh.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.bmj = 5L;
                NewNobleUserListFragment.this.aq(NewNobleUserListFragment.this.bmj);
                return;
            }
            if (bVar.bmw <= 0) {
                NewNobleUserListFragment.this.bmj = 5L;
            } else {
                NewNobleUserListFragment.this.bmj = bVar.bmw;
            }
            NewNobleUserListFragment.this.aq(NewNobleUserListFragment.this.bmj);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.bmj = 5L;
            NewNobleUserListFragment.this.aq(NewNobleUserListFragment.this.bmj);
            if (NewNobleUserListFragment.this.bmh != null && NewNobleUserListFragment.this.bmi == null) {
                NewNobleUserListFragment.this.bmh.cj(true);
            }
        }
    };
    private final Runnable bmm = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.Nz();
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.bmh = new b(getPageContext(), this.mLiveId, this.bla, this.mIsHost);
        this.bmh.a(this.bmk);
        return this.bmh.getRootView();
    }

    private void initData(Bundle bundle) {
        this.bmg = new e(getPageContext(), this.bml);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.bla = bundle.getString("anchor_id");
            this.aLF = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.bla = arguments.getString("anchor_id");
        this.aLF = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && isAdded()) {
            Nz();
        } else {
            NA();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bmh != null) {
            this.bmh.a(configuration);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.bla);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aLF);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nz() {
        if (this.bmg != null) {
            this.bmg.aA(this.bla, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(long j) {
        if (this.mHandler != null && this.bmm != null) {
            this.mHandler.removeCallbacks(this.bmm);
            this.mHandler.postDelayed(this.bmm, 1000 * j);
        }
    }

    private void NA() {
        if (this.mHandler != null && this.bmm != null) {
            this.mHandler.removeCallbacks(this.bmm);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bmg != null) {
            this.bmg.onDestroy();
        }
        NA();
    }
}
