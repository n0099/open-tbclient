package com.baidu.nadcore.widget.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.am0;
import com.baidu.tieba.c11;
import com.baidu.tieba.jy0;
import com.baidu.tieba.pe0;
import com.baidu.tieba.r01;
import com.baidu.tieba.rg0;
import com.baidu.tieba.s61;
import com.baidu.tieba.s71;
import com.baidu.tieba.sd0;
import com.baidu.tieba.t71;
import com.baidu.tieba.u01;
import com.baidu.tieba.u71;
import com.baidu.tieba.vm0;
import com.baidu.tieba.yd0;
import com.baidu.tieba.z71;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static final int g = c11.c.a(pe0.b(), 15.0f);
    public t71 a;
    public u71 b;
    public z71 c;
    public rg0 d;
    public GestureDetector e;
    public boolean f;

    public View getView() {
        return this;
    }

    public void setViewDownloadListener(s71 s71Var) {
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdFeedBaseView.this.e();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements z71.d {
        public b() {
        }

        @Override // com.baidu.tieba.z71.d
        public void a(List<am0.a> list) {
            Toast.makeText(AdFeedBaseView.this.getContext(), (int) R.string.nad_dislike_reduce_recommend, 0).show();
            AdFeedBaseView.this.setVisibility(8);
            AdFeedBaseView adFeedBaseView = AdFeedBaseView.this;
            if (adFeedBaseView.a == null || !(adFeedBaseView.getTag() instanceof AdBaseModel)) {
                return;
            }
            AdFeedBaseView.this.a.a((AdBaseModel) AdFeedBaseView.this.getTag());
        }
    }

    /* loaded from: classes3.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            AdFeedBaseView.this.f = true;
            return super.onDown(motionEvent);
        }

        public /* synthetic */ c(AdFeedBaseView adFeedBaseView, a aVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AdFeedBaseView.this.f = false;
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AdFeedBaseView.this.f = false;
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    public void b() {
        rg0 rg0Var = this.d;
        if (rg0Var != null) {
            rg0Var.j();
            this.d = null;
        }
    }

    public final void c() {
        View findViewById = findViewById(R.id.nad_base_delete_id);
        if (findViewById != null) {
            s61.a(this, findViewById, g);
            findViewById.setOnClickListener(new a());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public AdFeedBaseView(@NonNull Context context) {
        super(context);
        this.f = true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.e.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view2) {
        super.onViewAdded(view2);
        if (view2.getVisibility() == 0) {
            d();
            c();
        }
    }

    public void setVideoMediaListener(u71 u71Var) {
        this.b = u71Var;
    }

    public void setViewStatChangeListener(t71 t71Var) {
        this.a = t71Var;
    }

    public AdFeedBaseView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        super.onVisibilityChanged(view2, i);
        if (i == 0) {
            d();
        }
    }

    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i, vm0 vm0Var) {
        super(context, attributeSet, i);
        this.f = true;
        setOnClickListener(this);
        this.e = new GestureDetector(getContext(), new c(this, null));
    }

    public final void d() {
        if (!(getTag() instanceof AdBaseModel)) {
            return;
        }
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        if (adBaseModel.a) {
            return;
        }
        t71 t71Var = this.a;
        if (t71Var != null) {
            t71Var.c(adBaseModel);
        }
        jy0.e(new ClogBuilder().y(ClogBuilder.LogType.SHOW).p(adBaseModel.f.d));
        adBaseModel.a = true;
    }

    public void e() {
        AdBaseModel adBaseModel;
        vm0 vm0Var;
        if ((getTag() instanceof AdBaseModel) && (vm0Var = (adBaseModel = (AdBaseModel) getTag()).p) != null && !vm0Var.g) {
            t71 t71Var = this.a;
            if (t71Var != null) {
                t71Var.a(adBaseModel);
            }
            jy0.e(new ClogBuilder().y(ClogBuilder.LogType.CLOSE).p(adBaseModel.f.d));
            return;
        }
        if (this.c == null) {
            if (!(getTag() instanceof AdBaseModel)) {
                return;
            }
            this.c = new z71(getContext(), (AdBaseModel) getTag());
        }
        this.c.h(new b());
        u01.b(this.c);
    }

    public void onClick(View view2) {
        if (!this.f || !(getTag() instanceof AdBaseModel)) {
            return;
        }
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        if (TextUtils.isEmpty(adBaseModel.f.c)) {
            return;
        }
        r01.g(adBaseModel);
        yd0.c(r01.b(adBaseModel, adBaseModel.f.c), getContext());
        ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.CLICK).i(ClogBuilder.Area.HOTAREA).p(adBaseModel.f.d);
        sd0 sd0Var = adBaseModel.q;
        if (sd0Var != null) {
            p.m(sd0Var.a());
        }
        jy0.e(p);
        t71 t71Var = this.a;
        if (t71Var != null) {
            t71Var.b(adBaseModel);
        }
        adBaseModel.b = true;
    }
}
