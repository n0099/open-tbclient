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
/* loaded from: classes3.dex */
public class NewNobleUserListFragment extends BaseFragment {
    private String aWr;
    private long aXA;
    private e aXx;
    private b aXy;
    private com.baidu.live.noble.data.b aXz;
    private String ayw;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a aXB = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void FC() {
            NewNobleUserListFragment.this.FA();
        }
    };
    private final e.a aXC = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.aXz = bVar;
            if (NewNobleUserListFragment.this.aXy != null) {
                NewNobleUserListFragment.this.aXy.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.aXA = 5L;
                NewNobleUserListFragment.this.ao(NewNobleUserListFragment.this.aXA);
                return;
            }
            if (bVar.aXN <= 0) {
                NewNobleUserListFragment.this.aXA = 5L;
            } else {
                NewNobleUserListFragment.this.aXA = bVar.aXN;
            }
            NewNobleUserListFragment.this.ao(NewNobleUserListFragment.this.aXA);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.aXA = 5L;
            NewNobleUserListFragment.this.ao(NewNobleUserListFragment.this.aXA);
            if (NewNobleUserListFragment.this.aXy != null && NewNobleUserListFragment.this.aXz == null) {
                NewNobleUserListFragment.this.aXy.bU(true);
            }
        }
    };
    private final Runnable aXD = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.FA();
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.aXy = new b(getPageContext(), this.mLiveId, this.aWr, this.mIsHost);
        this.aXy.a(this.aXB);
        return this.aXy.getRootView();
    }

    private void initData(Bundle bundle) {
        this.aXx = new e(getPageContext(), this.aXC);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.aWr = bundle.getString("anchor_id");
            this.ayw = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.aWr = arguments.getString("anchor_id");
        this.ayw = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && isAdded()) {
            FA();
        } else {
            FB();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aXy != null) {
            this.aXy.a(configuration);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.aWr);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.ayw);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        if (this.aXx != null) {
            this.aXx.at(this.aWr, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(long j) {
        if (this.mHandler != null && this.aXD != null) {
            this.mHandler.removeCallbacks(this.aXD);
            this.mHandler.postDelayed(this.aXD, 1000 * j);
        }
    }

    private void FB() {
        if (this.mHandler != null && this.aXD != null) {
            this.mHandler.removeCallbacks(this.aXD);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aXx != null) {
            this.aXx.onDestroy();
        }
        FB();
    }
}
