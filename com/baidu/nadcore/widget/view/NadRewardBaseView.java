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
import com.baidu.tieba.dr0;
import com.baidu.tieba.fd1;
import com.baidu.tieba.gd1;
import com.baidu.tieba.i71;
import com.baidu.tieba.ju0;
import com.baidu.tieba.md1;
import com.baidu.tieba.nd1;
import com.baidu.tieba.ul0;
import com.baidu.tieba.yr0;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class NadRewardBaseView extends AdFeedVideoBaseView {
    public WeakReference<Activity> j;
    public int k;
    public int l;
    public NadRewardOperateView m;
    public NadRewardCountDownView n;
    public nd1 o;
    public boolean p;

    @Override // com.baidu.nadcore.widget.feed.AdFeedVideoBaseView, com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void c() {
    }

    public abstract void m(LayoutInflater layoutInflater, yr0 yr0Var);

    public abstract void n(Context context);

    public abstract void r(AdBaseModel adBaseModel);

    public abstract void s(AdBaseModel adBaseModel);

    /* loaded from: classes3.dex */
    public class a implements md1.d {
        public a() {
        }

        @Override // com.baidu.tieba.md1.d
        public void a(List<dr0.a> list) {
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

    public void setRewardMediaListener(nd1 nd1Var) {
        this.o = nd1Var;
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

    public NadRewardBaseView(Context context, AttributeSet attributeSet, int i, yr0 yr0Var) {
        super(context, attributeSet, i, yr0Var);
        setFocusable(true);
        setFocusableInTouchMode(true);
        m(LayoutInflater.from(context), yr0Var);
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
            this.d = new md1(getContext(), (AdBaseModel) getTag());
        }
        this.d.h(new a());
        this.d.i();
    }

    public void j() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        ju0 ju0Var = this.i;
        if (ju0Var != null) {
            ju0Var.release();
            this.i = null;
        }
        ul0 ul0Var = this.e;
        if (ul0Var != null) {
            ul0Var.j();
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
            i71.a(this.j.get().getWindow());
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
        fd1 fd1Var = this.c;
        if (fd1Var != null) {
            this.m.setViewDownloadListener(fd1Var);
        }
        gd1 gd1Var = this.a;
        if (gd1Var != null) {
            this.m.setFeedListener(gd1Var);
        }
    }
}
