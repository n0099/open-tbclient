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
/* loaded from: classes7.dex */
public class NewNobleUserListFragment extends BaseFragment {
    private String aHk;
    private String beu;
    private e bfB;
    private b bfC;
    private com.baidu.live.noble.data.b bfD;
    private long bfE;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a bfF = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void LT() {
            NewNobleUserListFragment.this.LR();
        }
    };
    private final e.a bfG = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.bfD = bVar;
            if (NewNobleUserListFragment.this.bfC != null) {
                NewNobleUserListFragment.this.bfC.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.bfE = 5L;
                NewNobleUserListFragment.this.ap(NewNobleUserListFragment.this.bfE);
                return;
            }
            if (bVar.bfR <= 0) {
                NewNobleUserListFragment.this.bfE = 5L;
            } else {
                NewNobleUserListFragment.this.bfE = bVar.bfR;
            }
            NewNobleUserListFragment.this.ap(NewNobleUserListFragment.this.bfE);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.bfE = 5L;
            NewNobleUserListFragment.this.ap(NewNobleUserListFragment.this.bfE);
            if (NewNobleUserListFragment.this.bfC != null && NewNobleUserListFragment.this.bfD == null) {
                NewNobleUserListFragment.this.bfC.cf(true);
            }
        }
    };
    private final Runnable bfH = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.LR();
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.bfC = new b(getPageContext(), this.mLiveId, this.beu, this.mIsHost);
        this.bfC.a(this.bfF);
        return this.bfC.getRootView();
    }

    private void initData(Bundle bundle) {
        this.bfB = new e(getPageContext(), this.bfG);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.beu = bundle.getString("anchor_id");
            this.aHk = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.beu = arguments.getString("anchor_id");
        this.aHk = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && isAdded()) {
            LR();
        } else {
            LS();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bfC != null) {
            this.bfC.a(configuration);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.beu);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aHk);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LR() {
        if (this.bfB != null) {
            this.bfB.ax(this.beu, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(long j) {
        if (this.mHandler != null && this.bfH != null) {
            this.mHandler.removeCallbacks(this.bfH);
            this.mHandler.postDelayed(this.bfH, 1000 * j);
        }
    }

    private void LS() {
        if (this.mHandler != null && this.bfH != null) {
            this.mHandler.removeCallbacks(this.bfH);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bfB != null) {
            this.bfB.onDestroy();
        }
        LS();
    }
}
