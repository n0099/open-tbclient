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
    private String aMj;
    private String bmv;
    private e bnH;
    private b bnI;
    private com.baidu.live.noble.data.b bnJ;
    private long bnK;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a bnL = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void NY() {
            NewNobleUserListFragment.this.Km();
        }
    };
    private final e.a bnM = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.bnJ = bVar;
            if (NewNobleUserListFragment.this.bnI != null) {
                NewNobleUserListFragment.this.bnI.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.bnK = 5L;
                NewNobleUserListFragment.this.ar(NewNobleUserListFragment.this.bnK);
                return;
            }
            if (bVar.bnT <= 0) {
                NewNobleUserListFragment.this.bnK = 5L;
            } else {
                NewNobleUserListFragment.this.bnK = bVar.bnT;
            }
            NewNobleUserListFragment.this.ar(NewNobleUserListFragment.this.bnK);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.bnK = 5L;
            NewNobleUserListFragment.this.ar(NewNobleUserListFragment.this.bnK);
            if (NewNobleUserListFragment.this.bnI != null && NewNobleUserListFragment.this.bnJ == null) {
                NewNobleUserListFragment.this.bnI.cl(true);
            }
        }
    };
    private final Runnable bnN = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.Km();
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.bnI = new b(getPageContext(), this.mLiveId, this.bmv, this.mIsHost);
        this.bnI.a(this.bnL);
        return this.bnI.getRootView();
    }

    private void initData(Bundle bundle) {
        this.bnH = new e(getPageContext(), this.bnM);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.bmv = bundle.getString("anchor_id");
            this.aMj = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.bmv = arguments.getString("anchor_id");
        this.aMj = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && isAdded()) {
            Km();
        } else {
            NX();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bnI != null) {
            this.bnI.a(configuration);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.bmv);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aMj);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km() {
        if (this.bnH != null) {
            this.bnH.aB(this.bmv, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(long j) {
        if (this.mHandler != null && this.bnN != null) {
            this.mHandler.removeCallbacks(this.bnN);
            this.mHandler.postDelayed(this.bnN, 1000 * j);
        }
    }

    private void NX() {
        if (this.mHandler != null && this.bnN != null) {
            this.mHandler.removeCallbacks(this.bnN);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bnH != null) {
            this.bnH.onDestroy();
        }
        NX();
    }
}
