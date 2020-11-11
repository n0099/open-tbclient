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
    private String aNj;
    private String bnP;
    private e bpa;
    private b bpb;
    private com.baidu.live.noble.data.b bpc;
    private long bpd;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a bpe = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void Oy() {
            NewNobleUserListFragment.this.KM();
        }
    };
    private final e.a bpf = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.bpc = bVar;
            if (NewNobleUserListFragment.this.bpb != null) {
                NewNobleUserListFragment.this.bpb.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.bpd = 5L;
                NewNobleUserListFragment.this.aD(NewNobleUserListFragment.this.bpd);
                return;
            }
            if (bVar.bpm <= 0) {
                NewNobleUserListFragment.this.bpd = 5L;
            } else {
                NewNobleUserListFragment.this.bpd = bVar.bpm;
            }
            NewNobleUserListFragment.this.aD(NewNobleUserListFragment.this.bpd);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.bpd = 5L;
            NewNobleUserListFragment.this.aD(NewNobleUserListFragment.this.bpd);
            if (NewNobleUserListFragment.this.bpb != null && NewNobleUserListFragment.this.bpc == null) {
                NewNobleUserListFragment.this.bpb.cm(true);
            }
        }
    };
    private final Runnable bpg = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.KM();
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.bpb = new b(getPageContext(), this.mLiveId, this.bnP, this.mIsHost);
        this.bpb.a(this.bpe);
        return this.bpb.getRootView();
    }

    private void initData(Bundle bundle) {
        this.bpa = new e(getPageContext(), this.bpf);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.bnP = bundle.getString("anchor_id");
            this.aNj = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.bnP = arguments.getString("anchor_id");
        this.aNj = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && isAdded()) {
            KM();
        } else {
            Ox();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bpb != null) {
            this.bpb.a(configuration);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.bnP);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aNj);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KM() {
        if (this.bpa != null) {
            this.bpa.aC(this.bnP, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(long j) {
        if (this.mHandler != null && this.bpg != null) {
            this.mHandler.removeCallbacks(this.bpg);
            this.mHandler.postDelayed(this.bpg, 1000 * j);
        }
    }

    private void Ox() {
        if (this.mHandler != null && this.bpg != null) {
            this.mHandler.removeCallbacks(this.bpg);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bpa != null) {
            this.bpa.onDestroy();
        }
        Ox();
    }
}
