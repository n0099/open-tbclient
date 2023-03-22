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
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.cc1;
import com.baidu.tieba.ep0;
import com.baidu.tieba.fp0;
import com.baidu.tieba.hi0;
import com.baidu.tieba.jk0;
import com.baidu.tieba.k11;
import com.baidu.tieba.kh0;
import com.baidu.tieba.nk0;
import com.baidu.tieba.p31;
import com.baidu.tieba.qh0;
import com.baidu.tieba.r31;
import com.baidu.tieba.va1;
import com.baidu.tieba.vb1;
import com.baidu.tieba.wb1;
import com.baidu.tieba.wj0;
import com.baidu.tieba.xb1;
import com.baidu.tieba.xp0;
import com.baidu.tieba.z31;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static final int h = z31.c.a(hi0.b(), 15.0f);
    public wb1 a;
    public xb1 b;
    public vb1 c;
    public cc1 d;
    public jk0 e;
    public GestureDetector f;
    public boolean g;

    public View getView() {
        return this;
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdFeedBaseView.this.g();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements cc1.d {
        public b() {
        }

        @Override // com.baidu.tieba.cc1.d
        public void a(List<ep0.a> list) {
            Toast.makeText(AdFeedBaseView.this.getContext(), (int) R.string.nad_dislike_reduce_recommend, 0).show();
            AdFeedBaseView.this.setVisibility(8);
            AdFeedBaseView adFeedBaseView = AdFeedBaseView.this;
            if (adFeedBaseView.a == null || !(adFeedBaseView.getTag() instanceof AdBaseModel)) {
                return;
            }
            AdFeedBaseView.this.a.a((AdBaseModel) AdFeedBaseView.this.getTag());
        }
    }

    /* loaded from: classes2.dex */
    public class c implements nk0 {
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ wj0 b;

        public c(AdBaseModel adBaseModel, wj0 wj0Var) {
            this.a = adBaseModel;
            this.b = wj0Var;
        }

        @Override // com.baidu.tieba.nk0
        public void a(AdDownloadStatus adDownloadStatus) {
            int i = d.a[adDownloadStatus.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            AdFeedBaseView adFeedBaseView = AdFeedBaseView.this;
                            if (adFeedBaseView.c != null && adFeedBaseView.e(this.a)) {
                                AdFeedBaseView.this.c.a(this.a);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    AdFeedBaseView adFeedBaseView2 = AdFeedBaseView.this;
                    if (adFeedBaseView2.c != null && adFeedBaseView2.e(this.a)) {
                        AdFeedBaseView.this.c.e(this.a);
                        return;
                    }
                    return;
                }
                AdFeedBaseView adFeedBaseView3 = AdFeedBaseView.this;
                if (adFeedBaseView3.c != null && adFeedBaseView3.e(this.a)) {
                    AdFeedBaseView.this.c.d(this.a);
                    return;
                }
                return;
            }
            AdFeedBaseView adFeedBaseView4 = AdFeedBaseView.this;
            if (adFeedBaseView4.c != null && adFeedBaseView4.e(this.a)) {
                AdFeedBaseView.this.c.f(this.a, this.b.i);
            }
        }

        @Override // com.baidu.tieba.nk0
        public void b(AdDownloadCode adDownloadCode) {
            boolean z;
            boolean z2 = true;
            if (adDownloadCode != AdDownloadCode.ERROR_FAST_CLICK) {
                z = true;
            } else {
                z = false;
            }
            if (AdFeedBaseView.this.c == null) {
                z2 = false;
            }
            if ((z & z2) && AdFeedBaseView.this.e(this.a)) {
                AdFeedBaseView.this.c.b(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {
        public e() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            AdFeedBaseView.this.g = true;
            return super.onDown(motionEvent);
        }

        public /* synthetic */ e(AdFeedBaseView adFeedBaseView, a aVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AdFeedBaseView.this.g = false;
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AdFeedBaseView.this.g = false;
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    public void c() {
        jk0 jk0Var = this.e;
        if (jk0Var != null) {
            jk0Var.k();
            this.e = null;
        }
    }

    public final void d() {
        View findViewById = findViewById(R.id.nad_base_delete_id);
        if (findViewById != null) {
            va1.a(this, findViewById, h);
            findViewById.setOnClickListener(new a());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public AdFeedBaseView(@NonNull Context context) {
        super(context);
        this.g = true;
    }

    public final boolean e(AdBaseModel adBaseModel) {
        fp0 fp0Var;
        if (adBaseModel == null || (fp0Var = adBaseModel.l) == null) {
            return false;
        }
        return fp0Var.e;
    }

    public final void h(@NonNull AdBaseModel adBaseModel) {
        fp0 fp0Var = adBaseModel.l;
        if (fp0Var != null && fp0Var.e) {
            wj0 c2 = wj0.c(adBaseModel);
            this.e = new jk0(c2);
            vb1 vb1Var = this.c;
            if (vb1Var != null) {
                vb1Var.c(adBaseModel);
            }
            this.e.o(new c(adBaseModel, c2));
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view2) {
        super.onViewAdded(view2);
        if (view2.getVisibility() == 0) {
            f();
            d();
        }
    }

    public void setVideoMediaListener(xb1 xb1Var) {
        this.b = xb1Var;
    }

    public void setViewDownloadListener(vb1 vb1Var) {
        this.c = vb1Var;
    }

    public void setViewStatChangeListener(wb1 wb1Var) {
        this.a = wb1Var;
    }

    public void update(@NonNull AdBaseModel adBaseModel) {
        setTag(adBaseModel);
        this.d = new cc1(getContext(), adBaseModel);
        h(adBaseModel);
        if (getVisibility() != 0) {
            setVisibility(0);
        }
    }

    public AdFeedBaseView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        super.onVisibilityChanged(view2, i);
        if (i == 0) {
            f();
        }
    }

    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i, xp0 xp0Var) {
        super(context, attributeSet, i);
        this.g = true;
        setOnClickListener(this);
        this.f = new GestureDetector(getContext(), new e(this, null));
    }

    public final void f() {
        if (!(getTag() instanceof AdBaseModel)) {
            return;
        }
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        if (adBaseModel.a) {
            return;
        }
        wb1 wb1Var = this.a;
        if (wb1Var != null) {
            wb1Var.c(adBaseModel);
        }
        k11.b(new ClogBuilder().y(ClogBuilder.LogType.SHOW).p(adBaseModel.f.d));
        adBaseModel.a = true;
    }

    public void g() {
        AdBaseModel adBaseModel;
        xp0 xp0Var;
        if ((getTag() instanceof AdBaseModel) && (xp0Var = (adBaseModel = (AdBaseModel) getTag()).p) != null && !xp0Var.m) {
            wb1 wb1Var = this.a;
            if (wb1Var != null) {
                wb1Var.a(adBaseModel);
            }
            k11.b(new ClogBuilder().y(ClogBuilder.LogType.CLOSE).p(adBaseModel.f.d));
            return;
        }
        if (this.d == null) {
            if (!(getTag() instanceof AdBaseModel)) {
                return;
            }
            this.d = new cc1(getContext(), (AdBaseModel) getTag());
        }
        this.d.h(new b());
        r31.b(this.d);
    }

    public void onClick(View view2) {
        if (!this.g || !(getTag() instanceof AdBaseModel)) {
            return;
        }
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        if (TextUtils.isEmpty(adBaseModel.f.c)) {
            return;
        }
        p31.e(adBaseModel);
        qh0.c(p31.b(adBaseModel, adBaseModel.f.c), getContext());
        ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.CLICK).i(ClogBuilder.Area.HOTAREA).p(adBaseModel.f.d);
        kh0 kh0Var = adBaseModel.q;
        if (kh0Var != null) {
            p.m(kh0Var.a());
        }
        k11.b(p);
        wb1 wb1Var = this.a;
        if (wb1Var != null) {
            wb1Var.b(adBaseModel);
        }
        adBaseModel.b = true;
    }
}
