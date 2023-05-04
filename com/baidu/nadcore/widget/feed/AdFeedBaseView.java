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
import com.baidu.tieba.ac1;
import com.baidu.tieba.ak0;
import com.baidu.tieba.bc1;
import com.baidu.tieba.bq0;
import com.baidu.tieba.d41;
import com.baidu.tieba.gc1;
import com.baidu.tieba.ip0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.li0;
import com.baidu.tieba.nk0;
import com.baidu.tieba.o11;
import com.baidu.tieba.oh0;
import com.baidu.tieba.rk0;
import com.baidu.tieba.t31;
import com.baidu.tieba.uh0;
import com.baidu.tieba.v31;
import com.baidu.tieba.za1;
import com.baidu.tieba.zb1;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static final int h = d41.c.a(li0.b(), 15.0f);
    public ac1 a;
    public bc1 b;
    public zb1 c;
    public gc1 d;
    public nk0 e;
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
    public class b implements gc1.d {
        public b() {
        }

        @Override // com.baidu.tieba.gc1.d
        public void a(List<ip0.a> list) {
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
    public class c implements rk0 {
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ ak0 b;

        public c(AdBaseModel adBaseModel, ak0 ak0Var) {
            this.a = adBaseModel;
            this.b = ak0Var;
        }

        @Override // com.baidu.tieba.rk0
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

        @Override // com.baidu.tieba.rk0
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
        nk0 nk0Var = this.e;
        if (nk0Var != null) {
            nk0Var.k();
            this.e = null;
        }
    }

    public final void d() {
        View findViewById = findViewById(R.id.nad_base_delete_id);
        if (findViewById != null) {
            za1.a(this, findViewById, h);
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
        jp0 jp0Var;
        if (adBaseModel == null || (jp0Var = adBaseModel.l) == null) {
            return false;
        }
        return jp0Var.e;
    }

    public final void h(@NonNull AdBaseModel adBaseModel) {
        jp0 jp0Var = adBaseModel.l;
        if (jp0Var != null && jp0Var.e) {
            ak0 c2 = ak0.c(adBaseModel);
            this.e = new nk0(c2);
            zb1 zb1Var = this.c;
            if (zb1Var != null) {
                zb1Var.c(adBaseModel);
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

    public void setVideoMediaListener(bc1 bc1Var) {
        this.b = bc1Var;
    }

    public void setViewDownloadListener(zb1 zb1Var) {
        this.c = zb1Var;
    }

    public void setViewStatChangeListener(ac1 ac1Var) {
        this.a = ac1Var;
    }

    public void update(@NonNull AdBaseModel adBaseModel) {
        setTag(adBaseModel);
        this.d = new gc1(getContext(), adBaseModel);
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

    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i, bq0 bq0Var) {
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
        ac1 ac1Var = this.a;
        if (ac1Var != null) {
            ac1Var.c(adBaseModel);
        }
        o11.b(new ClogBuilder().y(ClogBuilder.LogType.SHOW).p(adBaseModel.f.d));
        adBaseModel.a = true;
    }

    public void g() {
        AdBaseModel adBaseModel;
        bq0 bq0Var;
        if ((getTag() instanceof AdBaseModel) && (bq0Var = (adBaseModel = (AdBaseModel) getTag()).p) != null && !bq0Var.m) {
            ac1 ac1Var = this.a;
            if (ac1Var != null) {
                ac1Var.a(adBaseModel);
            }
            o11.b(new ClogBuilder().y(ClogBuilder.LogType.CLOSE).p(adBaseModel.f.d));
            return;
        }
        if (this.d == null) {
            if (!(getTag() instanceof AdBaseModel)) {
                return;
            }
            this.d = new gc1(getContext(), (AdBaseModel) getTag());
        }
        this.d.h(new b());
        v31.b(this.d);
    }

    public void onClick(View view2) {
        if (!this.g || !(getTag() instanceof AdBaseModel)) {
            return;
        }
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        if (TextUtils.isEmpty(adBaseModel.f.c)) {
            return;
        }
        t31.e(adBaseModel);
        uh0.c(t31.b(adBaseModel, adBaseModel.f.c), getContext());
        ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.CLICK).i(ClogBuilder.Area.HOTAREA).p(adBaseModel.f.d);
        oh0 oh0Var = adBaseModel.q;
        if (oh0Var != null) {
            p.m(oh0Var.a());
        }
        o11.b(p);
        ac1 ac1Var = this.a;
        if (ac1Var != null) {
            ac1Var.b(adBaseModel);
        }
        adBaseModel.b = true;
    }
}
