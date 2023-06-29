package com.baidu.nadcore.business.uitemplate;

import android.content.Context;
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
import com.baidu.tieba.a71;
import com.baidu.tieba.ck0;
import com.baidu.tieba.g61;
import com.baidu.tieba.kj0;
import com.baidu.tieba.lj0;
import com.baidu.tieba.lk0;
import com.baidu.tieba.ok0;
import com.baidu.tieba.pi0;
import com.baidu.tieba.qr0;
import com.baidu.tieba.r31;
import com.baidu.tieba.tn0;
import com.baidu.tieba.ue1;
import com.baidu.tieba.xj0;
import com.baidu.tieba.xn0;
import com.baidu.tieba.y61;
import com.baidu.tieba.ye1;
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
    public ue1<View> j;
    public FrameLayout k;
    public kj0 l;
    public f m;
    public boolean n;
    public View o;
    public LinearLayout p;
    public SimpleAdInfoView q;
    public boolean r;
    public TextView s;
    public y61 t;
    public Runnable u;
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

    public final void t(@NonNull AdBaseModel adBaseModel) {
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
            if (NadVideoAdOverContainer.this.v()) {
                return;
            }
            AdBaseModel adBaseModel = this.a;
            String str = adBaseModel.f.c;
            qr0 qr0Var = adBaseModel.m;
            if (qr0Var != null && qr0Var.a == 0 && !NadVideoAdOverContainer.this.j(str).booleanValue()) {
                xj0.c(str, NadVideoAdOverContainer.this.getContext());
            }
            NadVideoAdOverContainer.this.z(ClogBuilder.LogType.CLICK, this.b, this.a);
            if (NadVideoAdOverContainer.this.h != null) {
                NadVideoAdOverContainer.this.h.onClick(view2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends y61.b {
        public b() {
        }

        @Override // com.baidu.tieba.y61.b
        public void f(long j) {
            NadVideoAdOverContainer.this.C(Math.round((float) ((100000 - j) / 1000)));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NadVideoAdOverContainer.this.t.e();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ String b;

        public d(AdBaseModel adBaseModel, String str) {
            this.a = adBaseModel;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((LinearLayout.LayoutParams) NadVideoAdOverContainer.this.e.getLayoutParams()).rightMargin = (int) NadVideoAdOverContainer.this.getResources().getDimension(R.dimen.nad_dimen_8dp);
            NadVideoAdOverContainer.this.d.setBackgroundResource(0);
            NadVideoAdOverContainer.this.d.setPadding(0, 0, 0, 0);
            NadVideoAdOverContainer.this.e.setText(NadVideoAdOverContainer.this.m(String.format("@%s", this.a.f.e), NadVideoAdOverContainer.this.e.getPaint()));
            NadVideoAdOverContainer.this.d.requestLayout();
            NadVideoAdOverContainer.this.a.setText(NadVideoAdOverContainer.this.l(this.b));
        }
    }

    /* loaded from: classes3.dex */
    public class e extends xn0<pi0> {
        public final /* synthetic */ AdBaseModel b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Class cls, AdBaseModel adBaseModel) {
            super(cls);
            this.b = adBaseModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xn0
        public void onEvent(@NonNull pi0 pi0Var) {
            ue1<View> ue1Var = NadVideoAdOverContainer.this.j;
            if (ue1Var != null && ue1Var.getRealView() != null && (NadVideoAdOverContainer.this.j.getRealView() instanceof NadEnhanceButtonDownloadView)) {
                NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = (NadEnhanceButtonDownloadView) NadVideoAdOverContainer.this.j.getRealView();
                if (pi0Var.a == null) {
                    return;
                }
                if (nadEnhanceButtonDownloadView.getDownloadStatus() != AdDownloadStatus.DOWNLOADING) {
                    nadEnhanceButtonDownloadView.performClick();
                }
                AdBaseModel adBaseModel = this.b;
                if (adBaseModel == null) {
                    return;
                }
                lj0.b(adBaseModel.e);
            }
        }
    }

    static {
        new String(x);
    }

    public final void B() {
        tn0.a().unregister(this.v);
    }

    public boolean getHotAreaEnabled() {
        return this.n;
    }

    public final void p() {
        y61 y61Var = new y61(100000L, 1000L);
        y61Var.d(new b());
        this.t = y61Var;
        c cVar = new c();
        this.u = cVar;
        post(cVar);
    }

    public boolean v() {
        if (this.f.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void y() {
        removeCallbacks(this.u);
        B();
    }

    public NadVideoAdOverContainer(Context context) {
        super(context);
        this.h = null;
        this.n = true;
        this.v = new Object();
        this.w = "";
        n(context);
    }

    public void A(boolean z) {
        Object tag = getTag();
        if (!(tag instanceof AdBaseModel)) {
            this.f.e();
            setAdOverInfoVisiblity(true);
            k(true);
        } else if (z) {
            this.f.j((AdBaseModel) tag);
            setAdOverInfoVisiblity(false);
            k(false);
        } else {
            this.f.e();
            setAdOverInfoVisiblity(true);
            k(true);
        }
    }

    public void C(int i) {
        ue1<View> ue1Var = this.j;
        if (ue1Var != null) {
            ue1Var.update(i);
        }
    }

    public final Boolean j(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        if (!lk0.o(str)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf("rewardWebPanel".equals(new ck0(str).a()));
    }

    public final void k(boolean z) {
        this.n = z;
        this.a.setClickable(z);
        this.e.setClickable(z);
        this.q.setClickable(z);
        ue1<View> ue1Var = this.j;
        if (ue1Var != null && ue1Var.getRealView() != null) {
            this.j.getRealView().setClickable(z);
        }
    }

    public final SpannableStringBuilder l(String str) {
        if (getResources() == null) {
            return new SpannableStringBuilder(str);
        }
        return ye1.b(str, 2, this.a, getContext(), ContextCompat.getDrawable(getContext(), R.drawable.nad_tag_icon), (int) getResources().getDimension(R.dimen.nad_dimen_100dp));
    }

    public final void o(@NonNull AdBaseModel adBaseModel) {
        int i;
        View findViewById = findViewById(R.id.nad_video_btn_placeholder);
        if (adBaseModel.d) {
            i = 0;
        } else {
            i = 8;
        }
        findViewById.setVisibility(i);
        q(adBaseModel);
        this.k.setVisibility(0);
        p();
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
        if (!u(adBaseModel)) {
            setVisibility(8);
            return;
        }
        setTag(adBaseModel);
        setVisibility(0);
        o(adBaseModel);
        w(adBaseModel);
        i();
        r(adBaseModel);
        t(adBaseModel);
        x(adBaseModel);
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
        kj0 kj0Var = this.l;
        if (kj0Var != null) {
            kj0Var.h(onClickListener);
        }
    }

    public void setOverLayInfoVisible(boolean z) {
        setAdInfoVisible(z);
    }

    public void setPlayerProgressHandler(f fVar) {
        this.m = fVar;
    }

    public final boolean u(AdBaseModel adBaseModel) {
        if (adBaseModel != null && adBaseModel.f != null) {
            return true;
        }
        return false;
    }

    public final void w(@NonNull AdBaseModel adBaseModel) {
        String str = adBaseModel.f.g;
        if (str == null) {
            str = "";
        }
        this.a.post(new d(adBaseModel, str));
    }

    public final void x(AdBaseModel adBaseModel) {
        tn0.a().c(this.v, 1, new e(pi0.class, adBaseModel));
    }

    public NadVideoAdOverContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = null;
        this.n = true;
        this.v = new Object();
        this.w = "";
        n(context);
    }

    public final String m(@Nullable String str, @Nullable TextPaint textPaint) {
        return a71.b(str, "", (int) (((int) (g61.c.e(getContext()) - getResources().getDimension(R.dimen.nad_dimen_15dp))) - getResources().getDimension(R.dimen.nad_dimen_11dp)), textPaint);
    }

    public View.OnClickListener s(@NonNull AdBaseModel adBaseModel, String str) {
        return new a(adBaseModel, str);
    }

    public NadVideoAdOverContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = null;
        this.n = true;
        this.v = new Object();
        this.w = "";
        n(context);
    }

    public final void i() {
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
            this.b.o(adBaseModel.f.f);
        } else if (!TextUtils.isEmpty(adBaseModel.f.e)) {
            this.b.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setText(adBaseModel.f.e);
        } else {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
        }
    }

    public void n(Context context) {
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

    public final void q(@NonNull AdBaseModel adBaseModel) {
        ue1<View> ue1Var = this.j;
        if (ue1Var != null) {
            ue1Var.a();
            this.k.setVisibility(8);
            this.j = null;
        }
        if (adBaseModel.m == null) {
            return;
        }
        View findViewById = findViewById(R.id.nad_video_btn_placeholder);
        findViewById.setVisibility(0);
        this.k.setVisibility(0);
        if (this.k.getChildCount() > 0) {
            this.k.removeAllViews();
        }
        AdEnhanceButtonView adEnhanceButtonView = new AdEnhanceButtonView(ok0.b(), this.k, findViewById);
        this.j = adEnhanceButtonView;
        kj0 kj0Var = new kj0(adBaseModel, adEnhanceButtonView);
        this.l = kj0Var;
        kj0Var.h(this.h);
        this.j.setEnhanceBtnListener(this.l);
        this.j.setData(adBaseModel.m);
        this.j.setBtnIconNightModeEnable(false);
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

    public final void r(@NonNull AdBaseModel adBaseModel) {
        this.a.setOnClickListener(s(adBaseModel, ClogBuilder.Area.TITTLE.type));
        TextView textView = this.c;
        if (textView != null) {
            textView.setOnClickListener(s(adBaseModel, ClogBuilder.Area.AVATAR.type));
        }
        AdImageView adImageView = this.b;
        if (adImageView != null) {
            adImageView.setOnClickListener(s(adBaseModel, ClogBuilder.Area.AVATAR.type));
        }
        this.e.setOnClickListener(s(adBaseModel, ClogBuilder.Area.NAME.type));
    }

    public void z(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
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
            r31.b(clogBuilder);
        }
    }
}
