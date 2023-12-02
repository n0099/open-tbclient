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
import com.baidu.tieba.dz0;
import com.baidu.tieba.hf0;
import com.baidu.tieba.jh0;
import com.baidu.tieba.ke0;
import com.baidu.tieba.l11;
import com.baidu.tieba.m71;
import com.baidu.tieba.m81;
import com.baidu.tieba.n81;
import com.baidu.tieba.o11;
import com.baidu.tieba.o81;
import com.baidu.tieba.on0;
import com.baidu.tieba.qe0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.v81;
import com.baidu.tieba.w11;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static final int g = w11.c.a(hf0.b(), 15.0f);
    public n81 a;
    public o81 b;
    public v81 c;
    public jh0 d;
    public GestureDetector e;
    public boolean f;

    public View getView() {
        return this;
    }

    public void setViewDownloadListener(m81 m81Var) {
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
    public class b implements v81.d {
        public b() {
        }

        @Override // com.baidu.tieba.v81.d
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
            m71.a(this, findViewById, g);
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
        this(context, null);
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

    public void setVideoMediaListener(o81 o81Var) {
        this.b = o81Var;
    }

    public void setViewStatChangeListener(n81 n81Var) {
        this.a = n81Var;
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

    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i, on0 on0Var) {
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
        n81 n81Var = this.a;
        if (n81Var != null) {
            n81Var.c(adBaseModel);
        }
        dz0.e(new ClogBuilder().y(ClogBuilder.LogType.SHOW).p(adBaseModel.f.d));
        adBaseModel.a = true;
    }

    public void e() {
        AdBaseModel adBaseModel;
        on0 on0Var;
        if ((getTag() instanceof AdBaseModel) && (on0Var = (adBaseModel = (AdBaseModel) getTag()).p) != null && !on0Var.g) {
            n81 n81Var = this.a;
            if (n81Var != null) {
                n81Var.a(adBaseModel);
            }
            dz0.e(new ClogBuilder().y(ClogBuilder.LogType.CLOSE).p(adBaseModel.f.d));
            return;
        }
        if (this.c == null) {
            if (!(getTag() instanceof AdBaseModel)) {
                return;
            }
            this.c = new v81(getContext(), (AdBaseModel) getTag());
        }
        this.c.h(new b());
        o11.b(this.c);
    }

    public void onClick(View view2) {
        if (!this.f || !(getTag() instanceof AdBaseModel)) {
            return;
        }
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        if (TextUtils.isEmpty(adBaseModel.f.c)) {
            return;
        }
        l11.g(adBaseModel);
        qe0.c(l11.b(adBaseModel, adBaseModel.f.c), getContext());
        ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.CLICK).i(ClogBuilder.Area.HOTAREA).p(adBaseModel.f.d);
        ke0 ke0Var = adBaseModel.q;
        if (ke0Var != null) {
            p.m(ke0Var.a());
        }
        dz0.e(p);
        n81 n81Var = this.a;
        if (n81Var != null) {
            n81Var.b(adBaseModel);
        }
        adBaseModel.b = true;
    }
}
