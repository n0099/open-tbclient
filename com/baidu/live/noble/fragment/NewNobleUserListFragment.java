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
    private String aIB;
    private String bhk;
    private e bit;
    private b biu;
    private com.baidu.live.noble.data.b biv;
    private long biw;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a bix = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void Mw() {
            NewNobleUserListFragment.this.Mu();
        }
    };
    private final e.a biy = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.biv = bVar;
            if (NewNobleUserListFragment.this.biu != null) {
                NewNobleUserListFragment.this.biu.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.biw = 5L;
                NewNobleUserListFragment.this.ap(NewNobleUserListFragment.this.biw);
                return;
            }
            if (bVar.biJ <= 0) {
                NewNobleUserListFragment.this.biw = 5L;
            } else {
                NewNobleUserListFragment.this.biw = bVar.biJ;
            }
            NewNobleUserListFragment.this.ap(NewNobleUserListFragment.this.biw);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.biw = 5L;
            NewNobleUserListFragment.this.ap(NewNobleUserListFragment.this.biw);
            if (NewNobleUserListFragment.this.biu != null && NewNobleUserListFragment.this.biv == null) {
                NewNobleUserListFragment.this.biu.cg(true);
            }
        }
    };
    private final Runnable biz = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.Mu();
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.biu = new b(getPageContext(), this.mLiveId, this.bhk, this.mIsHost);
        this.biu.a(this.bix);
        return this.biu.getRootView();
    }

    private void initData(Bundle bundle) {
        this.bit = new e(getPageContext(), this.biy);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.bhk = bundle.getString("anchor_id");
            this.aIB = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.bhk = arguments.getString("anchor_id");
        this.aIB = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && isAdded()) {
            Mu();
        } else {
            Mv();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.biu != null) {
            this.biu.a(configuration);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.bhk);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aIB);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mu() {
        if (this.bit != null) {
            this.bit.ax(this.bhk, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(long j) {
        if (this.mHandler != null && this.biz != null) {
            this.mHandler.removeCallbacks(this.biz);
            this.mHandler.postDelayed(this.biz, 1000 * j);
        }
    }

    private void Mv() {
        if (this.mHandler != null && this.biz != null) {
            this.mHandler.removeCallbacks(this.biz);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bit != null) {
            this.bit.onDestroy();
        }
        Mv();
    }
}
