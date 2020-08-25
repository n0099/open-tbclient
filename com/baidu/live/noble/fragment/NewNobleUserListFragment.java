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
    private String aHi;
    private String ber;
    private b bfA;
    private com.baidu.live.noble.data.b bfB;
    private long bfC;
    private e bfz;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a bfD = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void LT() {
            NewNobleUserListFragment.this.LR();
        }
    };
    private final e.a bfE = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.bfB = bVar;
            if (NewNobleUserListFragment.this.bfA != null) {
                NewNobleUserListFragment.this.bfA.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.bfC = 5L;
                NewNobleUserListFragment.this.ap(NewNobleUserListFragment.this.bfC);
                return;
            }
            if (bVar.bfP <= 0) {
                NewNobleUserListFragment.this.bfC = 5L;
            } else {
                NewNobleUserListFragment.this.bfC = bVar.bfP;
            }
            NewNobleUserListFragment.this.ap(NewNobleUserListFragment.this.bfC);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.bfC = 5L;
            NewNobleUserListFragment.this.ap(NewNobleUserListFragment.this.bfC);
            if (NewNobleUserListFragment.this.bfA != null && NewNobleUserListFragment.this.bfB == null) {
                NewNobleUserListFragment.this.bfA.cf(true);
            }
        }
    };
    private final Runnable bfF = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.LR();
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.bfA = new b(getPageContext(), this.mLiveId, this.ber, this.mIsHost);
        this.bfA.a(this.bfD);
        return this.bfA.getRootView();
    }

    private void initData(Bundle bundle) {
        this.bfz = new e(getPageContext(), this.bfE);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.ber = bundle.getString("anchor_id");
            this.aHi = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.ber = arguments.getString("anchor_id");
        this.aHi = arguments.getString(LogConfig.LOG_GIFT_ID);
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
        if (this.bfA != null) {
            this.bfA.a(configuration);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.ber);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aHi);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LR() {
        if (this.bfz != null) {
            this.bfz.ax(this.ber, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(long j) {
        if (this.mHandler != null && this.bfF != null) {
            this.mHandler.removeCallbacks(this.bfF);
            this.mHandler.postDelayed(this.bfF, 1000 * j);
        }
    }

    private void LS() {
        if (this.mHandler != null && this.bfF != null) {
            this.mHandler.removeCallbacks(this.bfF);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bfz != null) {
            this.bfz.onDestroy();
        }
        LS();
    }
}
