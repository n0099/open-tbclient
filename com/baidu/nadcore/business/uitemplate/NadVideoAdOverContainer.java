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
import com.baidu.tieba.dh0;
import com.baidu.tieba.eh0;
import com.baidu.tieba.ei0;
import com.baidu.tieba.hi0;
import com.baidu.tieba.ig0;
import com.baidu.tieba.jp0;
import com.baidu.tieba.k11;
import com.baidu.tieba.ml0;
import com.baidu.tieba.nc1;
import com.baidu.tieba.qh0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.r41;
import com.baidu.tieba.rc1;
import com.baidu.tieba.t41;
import com.baidu.tieba.vh0;
import com.baidu.tieba.z31;
/* loaded from: classes2.dex */
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
    public nc1<View> j;
    public FrameLayout k;
    public dh0 l;
    public f m;
    public boolean n;
    public View o;
    public LinearLayout p;
    public SimpleAdInfoView q;
    public boolean r;
    public TextView s;
    public r41 t;
    public Runnable u;
    public final Object v;
    public String w;

    /* loaded from: classes2.dex */
    public interface f {
        int a();

        int getPosition();
    }

    public int getLayoutId() {
        return R.layout.nad_mini_video_detail_ad_item_over_info;
    }

    public final void t(@NonNull AdBaseModel adBaseModel) {
    }

    /* loaded from: classes2.dex */
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
            jp0 jp0Var = adBaseModel.m;
            if (jp0Var != null && jp0Var.a == 0 && !NadVideoAdOverContainer.this.j(str).booleanValue()) {
                qh0.c(str, NadVideoAdOverContainer.this.getContext());
            }
            NadVideoAdOverContainer.this.z(ClogBuilder.LogType.CLICK, this.b, this.a);
            if (NadVideoAdOverContainer.this.h != null) {
                NadVideoAdOverContainer.this.h.onClick(view2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends r41.b {
        public b() {
        }

        @Override // com.baidu.tieba.r41.b
        public void f(long j) {
            NadVideoAdOverContainer.this.C(Math.round((float) ((100000 - j) / 1000)));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NadVideoAdOverContainer.this.t.e();
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class e extends ql0<ig0> {
        public final /* synthetic */ AdBaseModel b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Class cls, AdBaseModel adBaseModel) {
            super(cls);
            this.b = adBaseModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ql0
        public void onEvent(@NonNull ig0 ig0Var) {
            nc1<View> nc1Var = NadVideoAdOverContainer.this.j;
            if (nc1Var != null && nc1Var.getRealView() != null && (NadVideoAdOverContainer.this.j.getRealView() instanceof NadEnhanceButtonDownloadView)) {
                NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = (NadEnhanceButtonDownloadView) NadVideoAdOverContainer.this.j.getRealView();
                if (ig0Var.a == null) {
                    return;
                }
                if (nadEnhanceButtonDownloadView.getDownloadStatus() != AdDownloadStatus.DOWNLOADING) {
                    nadEnhanceButtonDownloadView.performClick();
                }
                AdBaseModel adBaseModel = this.b;
                if (adBaseModel == null) {
                    return;
                }
                eh0.b(adBaseModel.e);
            }
        }
    }

    static {
        new String(x);
    }

    public final void B() {
        ml0.a().unregister(this.v);
    }

    public boolean getHotAreaEnabled() {
        return this.n;
    }

    public final void p() {
        r41 r41Var = new r41(100000L, 1000L);
        r41Var.d(new b());
        this.t = r41Var;
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
        nc1<View> nc1Var = this.j;
        if (nc1Var != null) {
            nc1Var.update(i);
        }
    }

    public final Boolean j(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        if (!ei0.o(str)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf("rewardWebPanel".equals(new vh0(str).a()));
    }

    public final void k(boolean z) {
        this.n = z;
        this.a.setClickable(z);
        this.e.setClickable(z);
        this.q.setClickable(z);
        nc1<View> nc1Var = this.j;
        if (nc1Var != null && nc1Var.getRealView() != null) {
            this.j.getRealView().setClickable(z);
        }
    }

    public final SpannableStringBuilder l(String str) {
        if (getResources() == null) {
            return new SpannableStringBuilder(str);
        }
        return rc1.b(str, 2, this.a, getContext(), ContextCompat.getDrawable(getContext(), R.drawable.nad_tag_icon), (int) getResources().getDimension(R.dimen.nad_dimen_100dp));
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
        dh0 dh0Var = this.l;
        if (dh0Var != null) {
            dh0Var.h(onClickListener);
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
        ml0.a().c(this.v, 1, new e(ig0.class, adBaseModel));
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
        return t41.b(str, "", (int) (((int) (z31.c.e(getContext()) - getResources().getDimension(R.dimen.nad_dimen_15dp))) - getResources().getDimension(R.dimen.nad_dimen_11dp)), textPaint);
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
        nc1<View> nc1Var = this.j;
        if (nc1Var != null) {
            nc1Var.a();
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
        AdEnhanceButtonView adEnhanceButtonView = new AdEnhanceButtonView(hi0.b(), this.k, findViewById);
        this.j = adEnhanceButtonView;
        dh0 dh0Var = new dh0(adBaseModel, adEnhanceButtonView);
        this.l = dh0Var;
        dh0Var.h(this.h);
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
            k11.b(clogBuilder);
        }
    }
}
