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
import com.baidu.tieba.bz0;
import com.baidu.tieba.hf0;
import com.baidu.tieba.j11;
import com.baidu.tieba.jh0;
import com.baidu.tieba.k71;
import com.baidu.tieba.k81;
import com.baidu.tieba.ke0;
import com.baidu.tieba.l81;
import com.baidu.tieba.m11;
import com.baidu.tieba.m81;
import com.baidu.tieba.nn0;
import com.baidu.tieba.qe0;
import com.baidu.tieba.r81;
import com.baidu.tieba.sm0;
import com.baidu.tieba.u11;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static final int g = u11.c.a(hf0.b(), 15.0f);
    public l81 a;
    public m81 b;
    public r81 c;
    public jh0 d;
    public GestureDetector e;
    public boolean f;

    public View getView() {
        return this;
    }

    public void setViewDownloadListener(k81 k81Var) {
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
    public class b implements r81.d {
        public b() {
        }

        @Override // com.baidu.tieba.r81.d
        public void a(List<sm0.a> list) {
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
        jh0 jh0Var = this.d;
        if (jh0Var != null) {
            jh0Var.j();
            this.d = null;
        }
    }

    public final void c() {
        View findViewById = findViewById(R.id.nad_base_delete_id);
        if (findViewById != null) {
            k71.a(this, findViewById, g);
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

    public void setVideoMediaListener(m81 m81Var) {
        this.b = m81Var;
    }

    public void setViewStatChangeListener(l81 l81Var) {
        this.a = l81Var;
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

    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i, nn0 nn0Var) {
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
        l81 l81Var = this.a;
        if (l81Var != null) {
            l81Var.c(adBaseModel);
        }
        bz0.e(new ClogBuilder().y(ClogBuilder.LogType.SHOW).p(adBaseModel.f.d));
        adBaseModel.a = true;
    }

    public void e() {
        AdBaseModel adBaseModel;
        nn0 nn0Var;
        if ((getTag() instanceof AdBaseModel) && (nn0Var = (adBaseModel = (AdBaseModel) getTag()).p) != null && !nn0Var.g) {
            l81 l81Var = this.a;
            if (l81Var != null) {
                l81Var.a(adBaseModel);
            }
            bz0.e(new ClogBuilder().y(ClogBuilder.LogType.CLOSE).p(adBaseModel.f.d));
            return;
        }
        if (this.c == null) {
            if (!(getTag() instanceof AdBaseModel)) {
                return;
            }
            this.c = new r81(getContext(), (AdBaseModel) getTag());
        }
        this.c.h(new b());
        m11.b(this.c);
    }

    public void onClick(View view2) {
        if (!this.f || !(getTag() instanceof AdBaseModel)) {
            return;
        }
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        if (TextUtils.isEmpty(adBaseModel.f.c)) {
            return;
        }
        j11.g(adBaseModel);
        qe0.c(j11.b(adBaseModel, adBaseModel.f.c), getContext());
        ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.CLICK).i(ClogBuilder.Area.HOTAREA).p(adBaseModel.f.d);
        ke0 ke0Var = adBaseModel.q;
        if (ke0Var != null) {
            p.m(ke0Var.a());
        }
        bz0.e(p);
        l81 l81Var = this.a;
        if (l81Var != null) {
            l81Var.b(adBaseModel);
        }
        adBaseModel.b = true;
    }
}
