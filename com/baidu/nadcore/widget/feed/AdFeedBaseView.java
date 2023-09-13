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
import com.baidu.tieba.cj0;
import com.baidu.tieba.er0;
import com.baidu.tieba.f61;
import com.baidu.tieba.fr0;
import com.baidu.tieba.gc1;
import com.baidu.tieba.gd1;
import com.baidu.tieba.hd1;
import com.baidu.tieba.i61;
import com.baidu.tieba.id1;
import com.baidu.tieba.il0;
import com.baidu.tieba.nd1;
import com.baidu.tieba.q61;
import com.baidu.tieba.tj0;
import com.baidu.tieba.vl0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.x31;
import com.baidu.tieba.zl0;
import com.baidu.tieba.zr0;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static final int h = q61.c.a(tj0.b(), 15.0f);
    public hd1 a;
    public id1 b;
    public gd1 c;
    public nd1 d;
    public vl0 e;
    public GestureDetector f;
    public boolean g;

    public View getView() {
        return this;
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdFeedBaseView.this.g();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements nd1.d {
        public b() {
        }

        @Override // com.baidu.tieba.nd1.d
        public void a(List<er0.a> list) {
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
    public class c implements zl0 {
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ il0 b;

        public c(AdBaseModel adBaseModel, il0 il0Var) {
            this.a = adBaseModel;
            this.b = il0Var;
        }

        @Override // com.baidu.tieba.zl0
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

        @Override // com.baidu.tieba.zl0
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        vl0 vl0Var = this.e;
        if (vl0Var != null) {
            vl0Var.j();
            this.e = null;
        }
    }

    public final void d() {
        View findViewById = findViewById(R.id.nad_base_delete_id);
        if (findViewById != null) {
            gc1.a(this, findViewById, h);
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
        fr0 fr0Var;
        if (adBaseModel == null || (fr0Var = adBaseModel.l) == null) {
            return false;
        }
        return fr0Var.e;
    }

    public final void h(@NonNull AdBaseModel adBaseModel) {
        fr0 fr0Var = adBaseModel.l;
        if (fr0Var != null && fr0Var.e) {
            il0 c2 = il0.c(adBaseModel);
            this.e = new vl0(c2);
            gd1 gd1Var = this.c;
            if (gd1Var != null) {
                gd1Var.c(adBaseModel);
            }
            this.e.n(new c(adBaseModel, c2));
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

    public void setVideoMediaListener(id1 id1Var) {
        this.b = id1Var;
    }

    public void setViewDownloadListener(gd1 gd1Var) {
        this.c = gd1Var;
    }

    public void setViewStatChangeListener(hd1 hd1Var) {
        this.a = hd1Var;
    }

    public void update(@NonNull AdBaseModel adBaseModel) {
        setTag(adBaseModel);
        this.d = new nd1(getContext(), adBaseModel);
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

    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i, zr0 zr0Var) {
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
        hd1 hd1Var = this.a;
        if (hd1Var != null) {
            hd1Var.c(adBaseModel);
        }
        x31.e(new ClogBuilder().y(ClogBuilder.LogType.SHOW).p(adBaseModel.f.d));
        adBaseModel.a = true;
    }

    public void g() {
        AdBaseModel adBaseModel;
        zr0 zr0Var;
        if ((getTag() instanceof AdBaseModel) && (zr0Var = (adBaseModel = (AdBaseModel) getTag()).p) != null && !zr0Var.m) {
            hd1 hd1Var = this.a;
            if (hd1Var != null) {
                hd1Var.a(adBaseModel);
            }
            x31.e(new ClogBuilder().y(ClogBuilder.LogType.CLOSE).p(adBaseModel.f.d));
            return;
        }
        if (this.d == null) {
            if (!(getTag() instanceof AdBaseModel)) {
                return;
            }
            this.d = new nd1(getContext(), (AdBaseModel) getTag());
        }
        this.d.h(new b());
        i61.b(this.d);
    }

    public void onClick(View view2) {
        if (!this.g || !(getTag() instanceof AdBaseModel)) {
            return;
        }
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        if (TextUtils.isEmpty(adBaseModel.f.c)) {
            return;
        }
        f61.g(adBaseModel);
        cj0.c(f61.b(adBaseModel, adBaseModel.f.c), getContext());
        ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.CLICK).i(ClogBuilder.Area.HOTAREA).p(adBaseModel.f.d);
        wi0 wi0Var = adBaseModel.q;
        if (wi0Var != null) {
            p.m(wi0Var.a());
        }
        x31.e(p);
        hd1 hd1Var = this.a;
        if (hd1Var != null) {
            hd1Var.b(adBaseModel);
        }
        adBaseModel.b = true;
    }
}
