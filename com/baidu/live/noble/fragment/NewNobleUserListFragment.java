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
    private String aNa;
    private String buH;
    private e bvY;
    private b bvZ;
    private com.baidu.live.noble.data.b bwa;
    private long bwb;
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final b.a bwc = new b.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.1
        @Override // com.baidu.live.noble.d.b.a
        public void OP() {
            NewNobleUserListFragment.this.OQ();
        }
    };
    private final e.a bwd = new e.a() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.2
        @Override // com.baidu.live.noble.c.e.a
        public void a(com.baidu.live.noble.data.b bVar) {
            NewNobleUserListFragment.this.bwa = bVar;
            if (NewNobleUserListFragment.this.bvZ != null) {
                NewNobleUserListFragment.this.bvZ.b(bVar);
            }
            if (bVar == null) {
                NewNobleUserListFragment.this.bwb = 5L;
                NewNobleUserListFragment.this.bf(NewNobleUserListFragment.this.bwb);
                return;
            }
            if (bVar.bwk <= 0) {
                NewNobleUserListFragment.this.bwb = 5L;
            } else {
                NewNobleUserListFragment.this.bwb = bVar.bwk;
            }
            NewNobleUserListFragment.this.bf(NewNobleUserListFragment.this.bwb);
        }

        @Override // com.baidu.live.noble.c.e.a
        public void onFail(int i, String str) {
            BdUtilHelper.showToast(NewNobleUserListFragment.this.getPageContext().getPageActivity(), str);
            NewNobleUserListFragment.this.bwb = 5L;
            NewNobleUserListFragment.this.bf(NewNobleUserListFragment.this.bwb);
            if (NewNobleUserListFragment.this.bvZ != null && NewNobleUserListFragment.this.bwa == null) {
                NewNobleUserListFragment.this.bvZ.cK(true);
            }
        }
    };
    private final Runnable bwe = new Runnable() { // from class: com.baidu.live.noble.fragment.NewNobleUserListFragment.3
        @Override // java.lang.Runnable
        public void run() {
            NewNobleUserListFragment.this.OQ();
        }
    };

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData(bundle);
        this.bvZ = new b(getPageContext(), this.mLiveId, this.buH, this.mIsHost);
        this.bvZ.a(this.bwc);
        return this.bvZ.getRootView();
    }

    private void initData(Bundle bundle) {
        this.bvY = new e(getPageContext(), this.bwd);
        Bundle arguments = getArguments();
        if (bundle != null) {
            this.mLiveId = bundle.getString("live_id");
            this.buH = bundle.getString("anchor_id");
            this.aNa = bundle.getString(LogConfig.LOG_GIFT_ID);
            this.mTabId = bundle.getInt("tab_id");
            this.mIsHost = bundle.getBoolean("is_host");
            return;
        }
        this.mLiveId = arguments.getString("live_id");
        this.buH = arguments.getString("anchor_id");
        this.aNa = arguments.getString(LogConfig.LOG_GIFT_ID);
        this.mTabId = arguments.getInt("tab_id");
        this.mIsHost = arguments.getBoolean("is_host");
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && isAdded()) {
            OQ();
        } else {
            OO();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.bvZ != null) {
            this.bvZ.a(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("live_id", this.mLiveId);
        bundle.putString("anchor_id", this.buH);
        bundle.putString(LogConfig.LOG_GIFT_ID, this.aNa);
        bundle.putInt("tab_id", this.mTabId);
        bundle.putBoolean("is_host", this.mIsHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OQ() {
        if (this.bvY != null) {
            this.bvY.aC(this.buH, this.mLiveId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(long j) {
        if (this.mHandler != null && this.bwe != null) {
            this.mHandler.removeCallbacks(this.bwe);
            this.mHandler.postDelayed(this.bwe, 1000 * j);
        }
    }

    private void OO() {
        if (this.mHandler != null && this.bwe != null) {
            this.mHandler.removeCallbacks(this.bwe);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bvY != null) {
            this.bvY.onDestroy();
        }
        OO();
    }
}
