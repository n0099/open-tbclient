package com.baidu.nadcore.widget.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedVideoBaseView;
import com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView;
import com.baidu.nadcore.widget.uitemplate.NadRewardOperateView;
import com.baidu.tieba.R;
import com.baidu.tieba.ac1;
import com.baidu.tieba.bq0;
import com.baidu.tieba.gc1;
import com.baidu.tieba.hc1;
import com.baidu.tieba.ip0;
import com.baidu.tieba.js0;
import com.baidu.tieba.nk0;
import com.baidu.tieba.u41;
import com.baidu.tieba.zb1;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class NadRewardBaseView extends AdFeedVideoBaseView {
    public WeakReference<Activity> j;
    public int k;
    public int l;
    public NadRewardOperateView m;
    public NadRewardCountDownView n;
    public hc1 o;
    public boolean p;

    @Override // com.baidu.nadcore.widget.feed.AdFeedVideoBaseView, com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void c() {
    }

    public abstract void m(LayoutInflater layoutInflater, bq0 bq0Var);

    public abstract void n(Context context);

    public abstract void r(AdBaseModel adBaseModel);

    public abstract void s(AdBaseModel adBaseModel);

    /* loaded from: classes2.dex */
    public class a implements gc1.d {
        public a() {
        }

        @Override // com.baidu.tieba.gc1.d
        public void a(List<ip0.a> list) {
            Toast.makeText(NadRewardBaseView.this.getContext(), (int) R.string.nad_dislike_reduce_recommend, 0).show();
            NadRewardBaseView.this.p = true;
        }
    }

    public NadRewardBaseView(Context context) {
        this(context, null);
    }

    public void k(Context context) {
        n(context);
    }

    public void q(AdBaseModel adBaseModel) {
        NadRewardCountDownView nadRewardCountDownView = (NadRewardCountDownView) findViewById(R.id.nad_reward_skip_btn);
        this.n = nadRewardCountDownView;
        if (nadRewardCountDownView == null) {
            return;
        }
        nadRewardCountDownView.update(adBaseModel);
    }

    public void setRewardMediaListener(hc1 hc1Var) {
        this.o = hc1Var;
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedVideoBaseView, com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        super.update(adBaseModel);
        r(adBaseModel);
        q(adBaseModel);
        p(adBaseModel);
        s(adBaseModel);
        requestFocus();
    }

    public NadRewardBaseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView, android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        super.onVisibilityChanged(view2, i);
        if (i == 0) {
            l();
        }
    }

    public NadRewardBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadRewardBaseView(Context context, AttributeSet attributeSet, int i, bq0 bq0Var) {
        super(context, attributeSet, i, bq0Var);
        setFocusable(true);
        setFocusableInTouchMode(true);
        m(LayoutInflater.from(context), bq0Var);
        k(context);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void g() {
        if (this.p) {
            Toast.makeText(getContext(), (int) R.string.nad_dislike_reduce_repeat, 0).show();
            if (this.d != null) {
                this.d = null;
                return;
            }
            return;
        }
        if (this.d == null) {
            if (!(getTag() instanceof AdBaseModel)) {
                return;
            }
            this.d = new gc1(getContext(), (AdBaseModel) getTag());
        }
        this.d.h(new a());
        this.d.i();
    }

    public void j() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        js0 js0Var = this.i;
        if (js0Var != null) {
            js0Var.release();
            this.i = null;
        }
        nk0 nk0Var = this.e;
        if (nk0Var != null) {
            nk0Var.k();
            this.e = null;
        }
        if (this.m != null) {
            this.m = null;
        }
        NadRewardCountDownView nadRewardCountDownView = this.n;
        if (nadRewardCountDownView != null) {
            nadRewardCountDownView.s();
            this.n = null;
        }
        WeakReference<Activity> weakReference = this.j;
        if (weakReference != null && weakReference.get() != null) {
            this.j.get().setRequestedOrientation(this.k);
            o();
        }
    }

    public void l() {
        WeakReference<Activity> weakReference = this.j;
        if (weakReference != null && weakReference.get() != null) {
            u41.a(this.j.get().getWindow());
        }
    }

    public final void o() {
        WeakReference<Activity> weakReference = this.j;
        if (weakReference != null && weakReference.get() != null) {
            View decorView = this.j.get().getWindow().getDecorView();
            decorView.setSystemUiVisibility(this.l);
            decorView.requestLayout();
        }
    }

    public final void p(AdBaseModel adBaseModel) {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.reward_ad_operate_view);
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
        if (this.m == null) {
            this.m = new NadRewardOperateView(getContext());
        }
        this.m.update(adBaseModel);
        this.m.d(viewGroup);
        zb1 zb1Var = this.c;
        if (zb1Var != null) {
            this.m.setViewDownloadListener(zb1Var);
        }
        ac1 ac1Var = this.a;
        if (ac1Var != null) {
            this.m.setFeedListener(ac1Var);
        }
    }
}
