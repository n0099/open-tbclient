package com.baidu.nadcore.business.uitemplate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.nadcore.business.uitemplate.PortraitVideoTailView;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.be0;
import com.baidu.tieba.d91;
import com.baidu.tieba.dz0;
import com.baidu.tieba.gd0;
import com.baidu.tieba.h91;
import com.baidu.tieba.hf0;
import com.baidu.tieba.in0;
import com.baidu.tieba.qe0;
import com.baidu.tieba.r21;
import com.baidu.tieba.ti0;
import com.baidu.tieba.u21;
import com.baidu.tieba.w11;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xm0;
/* loaded from: classes3.dex */
public class NadVideoAdOverContainer extends RelativeLayout {
    public static final char[] x = {21704};
    public TextView a;
    public AdImageView b;
    public TextView c;
    public LinearLayout d;
    public TextView e;
    public PortraitVideoTailView f;
    public RelativeLayout g;
    public View.OnClickListener h;
    public LinearLayout i;
    public d91<View> j;
    public FrameLayout k;
    public be0 l;
    public f m;
    public boolean n;
    public View o;
    public LinearLayout p;
    public SimpleAdInfoView q;
    public boolean r;
    public TextView s;
    public r21 t;
    public boolean u;
    public final Object v;
    public String w;

    /* loaded from: classes3.dex */
    public interface f {
        int a();

        int getPosition();
    }

    public int getLayoutId() {
        return R.layout.nad_mini_video_detail_ad_item_over_info;
    }

    public final void x(@NonNull AdBaseModel adBaseModel) {
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ String b;

        public a(AdBaseModel adBaseModel, String str) {
            this.a = adBaseModel;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (NadVideoAdOverContainer.this.z()) {
                return;
            }
            AdBaseModel adBaseModel = this.a;
            String str = adBaseModel.f.c;
            xm0 xm0Var = adBaseModel.m;
            if (xm0Var != null && !xm0Var.d) {
                qe0.c(str, NadVideoAdOverContainer.this.getContext());
            }
            NadVideoAdOverContainer.this.D(ClogBuilder.LogType.CLICK, this.b, this.a);
            if (NadVideoAdOverContainer.this.h != null) {
                NadVideoAdOverContainer.this.h.onClick(view2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends r21.b {
        public b() {
        }

        @Override // com.baidu.tieba.r21.b
        public void f(long j) {
            int round = Math.round((float) ((100000 - j) / 1000));
            if (NadVideoAdOverContainer.this.u) {
                NadVideoAdOverContainer.this.t.a();
                NadVideoAdOverContainer.this.t = null;
                return;
            }
            NadVideoAdOverContainer.this.H(round);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends be0 {
        public c(AdBaseModel adBaseModel, View view2) {
            super(adBaseModel, view2);
        }

        @Override // com.baidu.tieba.b91
        public void d() {
            NadVideoAdOverContainer.this.u = true;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public d(AdBaseModel adBaseModel, boolean z, String str) {
            this.a = adBaseModel;
            this.b = z;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            CharSequence charSequence;
            ((LinearLayout.LayoutParams) NadVideoAdOverContainer.this.e.getLayoutParams()).rightMargin = (int) NadVideoAdOverContainer.this.getResources().getDimension(R.dimen.nad_dimen_8dp);
            NadVideoAdOverContainer.this.d.setBackgroundResource(0);
            NadVideoAdOverContainer.this.d.setPadding(0, 0, 0, 0);
            TextView textView = NadVideoAdOverContainer.this.e;
            NadVideoAdOverContainer nadVideoAdOverContainer = NadVideoAdOverContainer.this;
            textView.setText(nadVideoAdOverContainer.p(nadVideoAdOverContainer.n(this.a.f.e), NadVideoAdOverContainer.this.e.getPaint()));
            NadVideoAdOverContainer.this.d.requestLayout();
            TextView textView2 = NadVideoAdOverContainer.this.a;
            if (!this.b) {
                charSequence = this.c;
            } else {
                charSequence = NadVideoAdOverContainer.this.o(this.c);
            }
            textView2.setText(charSequence);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends xi0<gd0> {
        public e(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi0
        public void onEvent(@NonNull gd0 gd0Var) {
            d91<View> d91Var = NadVideoAdOverContainer.this.j;
            if (d91Var != null && d91Var.getRealView() != null && (NadVideoAdOverContainer.this.j.getRealView() instanceof NadEnhanceButtonDownloadView)) {
                NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = (NadEnhanceButtonDownloadView) NadVideoAdOverContainer.this.j.getRealView();
                if (gd0Var.a != null && nadEnhanceButtonDownloadView.getDownloadStatus() != AdDownloadStatus.DOWNLOADING) {
                    nadEnhanceButtonDownloadView.performClick();
                }
            }
        }
    }

    static {
        new String(x);
    }

    public void C() {
        setVisibility(8);
        r21 r21Var = this.t;
        if (r21Var != null) {
            r21Var.a();
            this.t = null;
        }
        d91<View> d91Var = this.j;
        if (d91Var != null) {
            d91Var.a();
        }
        G();
    }

    public final void G() {
        ti0.a().a(this.v);
    }

    public boolean getHotAreaEnabled() {
        return this.n;
    }

    public final void t() {
        r21 r21Var = new r21(100000L, 1000L);
        r21Var.d(new b());
        this.t = r21Var;
        r21Var.e();
    }

    public boolean z() {
        if (this.f.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public NadVideoAdOverContainer(Context context) {
        super(context);
        this.h = null;
        this.n = true;
        this.v = new Object();
        this.w = "";
        r(context);
    }

    public final void A(@NonNull AdBaseModel adBaseModel) {
        boolean E = E(adBaseModel);
        String str = adBaseModel.f.g;
        if (str == null) {
            str = "";
        }
        this.a.post(new d(adBaseModel, E, str));
    }

    public final void B(AdBaseModel adBaseModel) {
        ti0.a().d(this.v, 1, new e(gd0.class));
    }

    public final boolean E(@NonNull AdBaseModel adBaseModel) {
        if (adBaseModel instanceof in0) {
            in0 in0Var = (in0) adBaseModel;
            if (in0Var.n() != null) {
                return TextUtils.isEmpty(in0Var.n().b());
            }
            return true;
        }
        return true;
    }

    public void F(boolean z) {
        Object tag = getTag();
        if (!(tag instanceof AdBaseModel)) {
            this.f.d();
            setAdOverInfoVisiblity(true);
            m(true);
        } else if (z) {
            this.f.i((AdBaseModel) tag);
            setAdOverInfoVisiblity(false);
            m(false);
        } else {
            this.f.d();
            setAdOverInfoVisiblity(true);
            m(true);
        }
    }

    public void H(int i) {
        d91<View> d91Var = this.j;
        if (d91Var != null) {
            d91Var.update(i);
        }
    }

    public final void m(boolean z) {
        this.n = z;
        this.a.setClickable(z);
        this.e.setClickable(z);
        this.q.setClickable(z);
        d91<View> d91Var = this.j;
        if (d91Var != null && d91Var.getRealView() != null) {
            this.j.getRealView().setClickable(z);
        }
    }

    public String n(String str) {
        return String.format("@%s", str);
    }

    public float q(Drawable drawable) {
        return drawable.getIntrinsicHeight();
    }

    public final void s(@NonNull AdBaseModel adBaseModel) {
        int i;
        View findViewById = findViewById(R.id.nad_video_btn_placeholder);
        if (adBaseModel.d) {
            i = 0;
        } else {
            i = 8;
        }
        findViewById.setVisibility(i);
        u(adBaseModel);
        this.k.setVisibility(0);
        t();
    }

    public void setAdOverInfoVisiblity(boolean z) {
        if (z) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(4);
        }
    }

    public void setAlsLogPage(String str) {
        this.w = str;
    }

    public void setBottomLineHeight(int i) {
        View view2 = this.o;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = i;
            this.o.setLayoutParams(layoutParams);
        }
    }

    public void setData(AdBaseModel adBaseModel) {
        this.u = false;
        if (!y(adBaseModel)) {
            setVisibility(8);
            return;
        }
        setTag(adBaseModel);
        setVisibility(0);
        s(adBaseModel);
        A(adBaseModel);
        k();
        v(adBaseModel);
        x(adBaseModel);
        B(adBaseModel);
    }

    public void setFeedbackBtnVisibility(boolean z) {
        int i;
        TextView textView = this.s;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public void setOnNewTailFrameReplayClickListener(View.OnClickListener onClickListener) {
        this.f.setOnReplayClickListener(onClickListener);
    }

    public void setOnNewTailJumpHandler(PortraitVideoTailView.c cVar) {
        this.f.setOnTailJumpHandler(cVar);
    }

    public void setOnUiClickListener(View.OnClickListener onClickListener) {
        this.h = onClickListener;
        PortraitVideoTailView portraitVideoTailView = this.f;
        if (portraitVideoTailView != null) {
            portraitVideoTailView.setOnAdClickListener(onClickListener);
        }
        be0 be0Var = this.l;
        if (be0Var != null) {
            be0Var.h(onClickListener);
        }
    }

    public void setOverLayInfoVisible(boolean z) {
        setAdInfoVisible(z);
    }

    public void setPlayerProgressHandler(f fVar) {
        this.m = fVar;
    }

    public final boolean y(AdBaseModel adBaseModel) {
        if (adBaseModel != null && adBaseModel.f != null) {
            return true;
        }
        return false;
    }

    public NadVideoAdOverContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = null;
        this.n = true;
        this.v = new Object();
        this.w = "";
        r(context);
    }

    public final String p(@Nullable String str, @Nullable TextPaint textPaint) {
        return u21.b(str, "", (int) (((int) (w11.c.e(getContext()) - getResources().getDimension(R.dimen.nad_dimen_15dp))) - getResources().getDimension(R.dimen.nad_dimen_11dp)), textPaint);
    }

    public View.OnClickListener w(@NonNull AdBaseModel adBaseModel, String str) {
        return new a(adBaseModel, str);
    }

    public NadVideoAdOverContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = null;
        this.n = true;
        this.v = new Object();
        this.w = "";
        r(context);
    }

    public d91<View> l(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view2) {
        return new AdEnhanceButtonView(context, viewGroup, view2);
    }

    public void D(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        if (adBaseModel != null && !TextUtils.isEmpty(adBaseModel.f.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.j(str);
            clogBuilder.v(this.w);
            f fVar = this.m;
            if (fVar != null) {
                clogBuilder.k(String.valueOf(fVar.getPosition()));
                clogBuilder.l(String.valueOf(this.m.a()));
            }
            clogBuilder.p(adBaseModel.f.d);
            dz0.e(clogBuilder);
        }
    }

    public final void k() {
        if (!(getTag() instanceof AdBaseModel)) {
            return;
        }
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        if (adBaseModel.f == null) {
            return;
        }
        if (this.b.getParent() instanceof View) {
            ((View) this.b.getParent()).setVisibility(0);
        }
        if (!TextUtils.isEmpty(adBaseModel.f.f)) {
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            this.b.u(adBaseModel.f.f);
        } else if (!TextUtils.isEmpty(adBaseModel.f.e)) {
            this.b.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setText(adBaseModel.f.e);
        } else {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
        }
    }

    public final SpannableStringBuilder o(String str) {
        if (getResources() == null) {
            return new SpannableStringBuilder(str);
        }
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.nad_tag_icon);
        float dimension = getResources().getDimension(R.dimen.nad_dimen_100dp);
        return h91.b(str, 2, this.a, getContext(), drawable, (int) dimension, q(drawable) / drawable.getIntrinsicHeight());
    }

    public final void v(@NonNull AdBaseModel adBaseModel) {
        this.a.setOnClickListener(w(adBaseModel, ClogBuilder.Area.TITTLE.type));
        TextView textView = this.c;
        if (textView != null) {
            textView.setOnClickListener(w(adBaseModel, ClogBuilder.Area.AVATAR.type));
        }
        AdImageView adImageView = this.b;
        if (adImageView != null) {
            adImageView.setOnClickListener(w(adBaseModel, ClogBuilder.Area.AVATAR.type));
        }
        this.e.setOnClickListener(w(adBaseModel, ClogBuilder.Area.NAME.type));
    }

    public void r(Context context) {
        LayoutInflater.from(context).inflate(getLayoutId(), this);
        this.a = (TextView) findViewById(R.id.nad_video_title);
        this.d = (LinearLayout) findViewById(R.id.nad_author_container);
        this.e = (TextView) findViewById(R.id.nad_mini_author_name);
        this.f = (PortraitVideoTailView) findViewById(R.id.ad_mini_video_tail_frame_view_new);
        this.g = (RelativeLayout) findViewById(R.id.ad_mini_video_info_view);
        this.i = (LinearLayout) findViewById(R.id.nad_right_vertical_container);
        this.k = (FrameLayout) findViewById(R.id.ad_transition_btn_view);
        this.o = findViewById(R.id.nad_bottom_line);
        this.p = (LinearLayout) findViewById(R.id.nad_mini_video_recommend_tag);
        this.q = (SimpleAdInfoView) findViewById(R.id.nad_app_info_container);
        this.s = (TextView) findViewById(R.id.nad_base_delete_id);
        this.b = (AdImageView) findViewById(R.id.ad_author_avatar);
        this.c = (TextView) findViewById(R.id.ad_author_avatar_txt);
    }

    public void setAdInfoVisible(boolean z) {
        int i = 8;
        if (z) {
            this.o.setVisibility(0);
            if (this.j != null) {
                this.k.setVisibility(0);
            }
            this.a.setVisibility(0);
            this.d.setVisibility(0);
            this.p.setVisibility(0);
            SimpleAdInfoView simpleAdInfoView = this.q;
            if (this.r) {
                i = 0;
            }
            simpleAdInfoView.setVisibility(i);
            return;
        }
        this.o.setVisibility(4);
        if (this.j != null) {
            this.k.setVisibility(4);
        }
        this.a.setVisibility(4);
        this.d.setVisibility(4);
        this.p.setVisibility(4);
        SimpleAdInfoView simpleAdInfoView2 = this.q;
        if (this.r) {
            i = 4;
        }
        simpleAdInfoView2.setVisibility(i);
    }

    public final void u(@NonNull AdBaseModel adBaseModel) {
        d91<View> d91Var = this.j;
        if (d91Var != null) {
            d91Var.a();
            this.k.setVisibility(8);
            this.j = null;
        }
        xm0 xm0Var = adBaseModel.m;
        if (xm0Var == null) {
            this.u = true;
            return;
        }
        if (xm0Var.o == null) {
            this.u = true;
        }
        View findViewById = findViewById(R.id.nad_video_btn_placeholder);
        findViewById.setVisibility(0);
        this.k.setVisibility(0);
        if (this.k.getChildCount() > 0) {
            this.k.removeAllViews();
        }
        d91<View> l = l(hf0.b(), this.k, findViewById);
        this.j = l;
        c cVar = new c(adBaseModel, (View) l);
        this.l = cVar;
        cVar.h(this.h);
        this.j.setEnhanceBtnListener(this.l);
        this.j.setData(adBaseModel.m);
        this.j.setBtnIconNightModeEnable(false);
    }
}
