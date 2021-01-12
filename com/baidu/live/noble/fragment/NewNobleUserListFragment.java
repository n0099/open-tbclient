package com.baidu.live.noble.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.noble.c.e;
import com.baidu.live.noble.d.b;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.log.LogConfig;
/* loaded from: classes10.dex */
public class NewNobleUserListFragment extends BaseFragment {
    private String aKn;
    private String bre;
    private e bsu;
    private b bsv;
    private com.baidu.live.noble.data.b bsw;
    private long bsx;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a bsy = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void Nq() {
            NewNobleUserListFragment.this.Nr();
        }
    };
    private final e.a bsz = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.bsw = bVar;
            if (NewNobleUserListFragment.this.bsv != null) {
                NewNobleUserListFragment.this.bsv.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.bsx = 5L;
                NewNobleUserListFragment.this.bb(NewNobleUserListFragment.this.bsx);
                return;
            }
            if (bVar.bsG <= 0) {
                NewNobleUserListFragment.this.bsx = 5L;
            } else {
                NewNobleUserListFragment.this.bsx = bVar.bsG;
            }
            NewNobleUserListFragment.this.bb(NewNobleUserListFragment.this.bsx);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.bsx = 5L;
            NewNobleUserListFragment.this.bb(NewNobleUserListFragment.this.bsx);
            if (NewNobleUserListFragment.this.bsv != null && NewNobleUserListFragment.this.bsw == null) {
                NewNobleUserListFragment.this.bsv.cB(true);
            }
        }
    };
    private final Runnable bsA = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.Nr();
        }
    };

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.bsv = new b(getPageContext(), this.mLiveId, this.bre, this.mIsHost);
        this.bsv.a(this.bsy);
        return this.bsv.getRootView();
    }

    private void initData(Bundle bundle) {
        this.bsu = new e(getPageContext(), this.bsz);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.bre = bundle.getString("anchor_id");
            this.aKn = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.bre = arguments.getString("anchor_id");
        this.aKn = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && isAdded()) {
            Nr();
        } else {
            Np();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bsv != null) {
            this.bsv.a(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.bre);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aKn);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nr() {
        if (this.bsu != null) {
            this.bsu.aC(this.bre, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(long j) {
        if (this.mHandler != null && this.bsA != null) {
            this.mHandler.removeCallbacks(this.bsA);
            this.mHandler.postDelayed(this.bsA, 1000 * j);
        }
    }

    private void Np() {
        if (this.mHandler != null && this.bsA != null) {
            this.mHandler.removeCallbacks(this.bsA);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bsu != null) {
            this.bsu.onDestroy();
        }
        Np();
    }
}
