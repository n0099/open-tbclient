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
import com.baidu.live.noble.data.b;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.log.LogConfig;
/* loaded from: classes10.dex */
public class NewNobleUserListFragment extends BaseFragment {
    private String aOA;
    private String bwh;
    private b bxA;
    private long bxB;
    private e bxy;
    private com.baidu.live.noble.d.b bxz;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a bxC = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void OS() {
            NewNobleUserListFragment.this.OT();
        }
    };
    private final e.a bxD = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.bxA = bVar;
            if (NewNobleUserListFragment.this.bxz != null) {
                NewNobleUserListFragment.this.bxz.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.bxB = 5L;
                NewNobleUserListFragment.this.bf(NewNobleUserListFragment.this.bxB);
                return;
            }
            if (bVar.bxK <= 0) {
                NewNobleUserListFragment.this.bxB = 5L;
            } else {
                NewNobleUserListFragment.this.bxB = bVar.bxK;
            }
            NewNobleUserListFragment.this.bf(NewNobleUserListFragment.this.bxB);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.bxB = 5L;
            NewNobleUserListFragment.this.bf(NewNobleUserListFragment.this.bxB);
            if (NewNobleUserListFragment.this.bxz != null && NewNobleUserListFragment.this.bxA == null) {
                NewNobleUserListFragment.this.bxz.cK(true);
            }
        }
    };
    private final Runnable bxE = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.OT();
        }
    };

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.bxz = new com.baidu.live.noble.d.b(getPageContext(), this.mLiveId, this.bwh, this.mIsHost);
        this.bxz.a(this.bxC);
        return this.bxz.getRootView();
    }

    private void initData(Bundle bundle) {
        this.bxy = new e(getPageContext(), this.bxD);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.bwh = bundle.getString("anchor_id");
            this.aOA = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.bwh = arguments.getString("anchor_id");
        this.aOA = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && isAdded()) {
            OT();
        } else {
            OR();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bxz != null) {
            this.bxz.a(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.bwh);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aOA);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OT() {
        if (this.bxy != null) {
            this.bxy.aC(this.bwh, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(long j) {
        if (this.mHandler != null && this.bxE != null) {
            this.mHandler.removeCallbacks(this.bxE);
            this.mHandler.postDelayed(this.bxE, 1000 * j);
        }
    }

    private void OR() {
        if (this.mHandler != null && this.bxE != null) {
            this.mHandler.removeCallbacks(this.bxE);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bxy != null) {
            this.bxy.onDestroy();
        }
        OR();
    }
}
