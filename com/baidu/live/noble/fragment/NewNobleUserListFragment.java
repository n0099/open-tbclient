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
/* loaded from: classes11.dex */
public class NewNobleUserListFragment extends BaseFragment {
    private String aPa;
    private String bvS;
    private e bxi;
    private b bxj;
    private com.baidu.live.noble.data.b bxk;
    private long bxl;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a bxm = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void Rl() {
            NewNobleUserListFragment.this.Rm();
        }
    };
    private final e.a bxn = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.bxk = bVar;
            if (NewNobleUserListFragment.this.bxj != null) {
                NewNobleUserListFragment.this.bxj.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.bxl = 5L;
                NewNobleUserListFragment.this.bb(NewNobleUserListFragment.this.bxl);
                return;
            }
            if (bVar.bxu <= 0) {
                NewNobleUserListFragment.this.bxl = 5L;
            } else {
                NewNobleUserListFragment.this.bxl = bVar.bxu;
            }
            NewNobleUserListFragment.this.bb(NewNobleUserListFragment.this.bxl);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.bxl = 5L;
            NewNobleUserListFragment.this.bb(NewNobleUserListFragment.this.bxl);
            if (NewNobleUserListFragment.this.bxj != null && NewNobleUserListFragment.this.bxk == null) {
                NewNobleUserListFragment.this.bxj.cF(true);
            }
        }
    };
    private final Runnable bxo = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.Rm();
        }
    };

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.bxj = new b(getPageContext(), this.mLiveId, this.bvS, this.mIsHost);
        this.bxj.a(this.bxm);
        return this.bxj.getRootView();
    }

    private void initData(Bundle bundle) {
        this.bxi = new e(getPageContext(), this.bxn);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.bvS = bundle.getString("anchor_id");
            this.aPa = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.bvS = arguments.getString("anchor_id");
        this.aPa = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && isAdded()) {
            Rm();
        } else {
            Rk();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bxj != null) {
            this.bxj.a(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.bvS);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aPa);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rm() {
        if (this.bxi != null) {
            this.bxi.aD(this.bvS, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(long j) {
        if (this.mHandler != null && this.bxo != null) {
            this.mHandler.removeCallbacks(this.bxo);
            this.mHandler.postDelayed(this.bxo, 1000 * j);
        }
    }

    private void Rk() {
        if (this.mHandler != null && this.bxo != null) {
            this.mHandler.removeCallbacks(this.bxo);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bxi != null) {
            this.bxi.onDestroy();
        }
        Rk();
    }
}
