package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.gp0;
import com.baidu.tieba.hl0;
import com.baidu.tieba.kk0;
import com.baidu.tieba.l11;
import com.baidu.tieba.ok0;
import com.baidu.tieba.qk0;
import com.baidu.tieba.rh0;
import com.baidu.tieba.u41;
import com.baidu.tieba.wb1;
import com.baidu.tieba.xb1;
import com.baidu.tieba.xj0;
import com.baidu.tieba.zp0;
/* loaded from: classes2.dex */
public class NadRewardOperateView extends FrameLayout {
    public xb1 a;
    public wb1 b;
    public AdImageView c;
    public SimpleFeedAdInfoView d;
    public RelativeLayout e;
    public TextView f;
    public TextView g;
    public TextView h;
    public kk0 i;

    /* loaded from: classes2.dex */
    public class a implements SimpleAdInfoView.c {
        public final /* synthetic */ AdBaseModel a;

        public a(AdBaseModel adBaseModel) {
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            NadRewardOperateView.this.e(this.a, str);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (NadRewardOperateView.this.i != null) {
                NadRewardOperateView.this.i.m();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ok0 {
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ xj0 b;

        public c(AdBaseModel adBaseModel, xj0 xj0Var) {
            this.a = adBaseModel;
            this.b = xj0Var;
        }

        @Override // com.baidu.tieba.ok0
        public void a(AdDownloadStatus adDownloadStatus) {
            int i = e.a[adDownloadStatus.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            NadRewardOperateView nadRewardOperateView = NadRewardOperateView.this;
                            if (nadRewardOperateView.b != null && nadRewardOperateView.h(this.a)) {
                                NadRewardOperateView.this.b.a(this.a);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    NadRewardOperateView nadRewardOperateView2 = NadRewardOperateView.this;
                    if (nadRewardOperateView2.b != null && nadRewardOperateView2.h(this.a)) {
                        NadRewardOperateView.this.b.e(this.a);
                        return;
                    }
                    return;
                }
                NadRewardOperateView nadRewardOperateView3 = NadRewardOperateView.this;
                if (nadRewardOperateView3.b != null && nadRewardOperateView3.h(this.a)) {
                    NadRewardOperateView.this.b.d(this.a);
                    return;
                }
                return;
            }
            NadRewardOperateView nadRewardOperateView4 = NadRewardOperateView.this;
            if (nadRewardOperateView4.b != null && nadRewardOperateView4.h(this.a)) {
                NadRewardOperateView.this.b.f(this.a, this.b.i);
            }
        }

        @Override // com.baidu.tieba.ok0
        public void b(AdDownloadCode adDownloadCode) {
            boolean z;
            boolean z2 = true;
            if (adDownloadCode != AdDownloadCode.ERROR_FAST_CLICK) {
                z = true;
            } else {
                z = false;
            }
            if (NadRewardOperateView.this.b == null) {
                z2 = false;
            }
            if ((z & z2) && NadRewardOperateView.this.h(this.a)) {
                NadRewardOperateView.this.b.b(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public final /* synthetic */ AdBaseModel a;

        public d(AdBaseModel adBaseModel) {
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            rh0.c(this.a.h.d, NadRewardOperateView.this.getContext());
            l11.b(new ClogBuilder().y(ClogBuilder.LogType.CLICK).p(this.a.f.d));
            xb1 xb1Var = NadRewardOperateView.this.a;
            if (xb1Var != null) {
                xb1Var.b(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class e {
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

    public NadRewardOperateView(@NonNull Context context) {
        this(context, null);
    }

    public void d(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this);
        }
        if (!j()) {
            viewGroup.setVisibility(8);
            return;
        }
        viewGroup.addView(this);
        viewGroup.setVisibility(0);
    }

    public final void f(View view2) {
        if (view2 == null) {
            return;
        }
        u41.a(view2.getContext(), view2, 6.0f);
    }

    public final boolean h(AdBaseModel adBaseModel) {
        gp0 gp0Var;
        if (adBaseModel == null || (gp0Var = adBaseModel.l) == null) {
            return false;
        }
        return gp0Var.e;
    }

    public final void k(AdBaseModel adBaseModel) {
        if (this.c == null) {
            return;
        }
        zp0 zp0Var = adBaseModel.i;
        if (zp0Var != null && !TextUtils.isEmpty(zp0Var.b)) {
            this.c.o(adBaseModel.i.b);
        } else if (!TextUtils.isEmpty(adBaseModel.f.f)) {
            this.c.o(adBaseModel.f.f);
        }
    }

    public final void l(AdBaseModel adBaseModel) {
        if (this.d == null) {
            return;
        }
        if (!i()) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        this.d.update(adBaseModel);
        this.d.setAfterListener(new a(adBaseModel));
    }

    public void setFeedListener(xb1 xb1Var) {
        this.a = xb1Var;
    }

    public void setViewDownloadListener(wb1 wb1Var) {
        this.b = wb1Var;
    }

    public void update(AdBaseModel adBaseModel) {
        setTag(adBaseModel);
        if (!j()) {
            setVisibility(8);
            return;
        }
        k(adBaseModel);
        l(adBaseModel);
        m(adBaseModel);
        o(adBaseModel);
        n(adBaseModel);
        setVisibility(0);
    }

    public NadRewardOperateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void e(AdBaseModel adBaseModel, String str) {
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.z(ClogBuilder.LogType.FREE_CLICK.type);
        clogBuilder.u(ClogBuilder.Page.REWARD_VIDEO);
        if (!TextUtils.isEmpty(str)) {
            clogBuilder.j(str);
        }
        if (adBaseModel != null && !TextUtils.isEmpty(adBaseModel.f.d)) {
            clogBuilder.p(adBaseModel.f.d);
        }
        l11.b(clogBuilder);
    }

    public NadRewardOperateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public final void g() {
        LayoutInflater.from(getContext()).inflate(R.layout.nad_reward_operate_view, (ViewGroup) this, true);
        this.c = (AdImageView) findViewById(R.id.nad_reward_ad_app_icon);
        this.d = (SimpleFeedAdInfoView) findViewById(R.id.reward_ad_operate_app_info_view);
        this.f = (TextView) findViewById(R.id.reward_ad_operate_command_app_name);
        this.g = (TextView) findViewById(R.id.reward_ad_operate_command_app_title);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.reward_ad_operate_progress_button);
        this.e = relativeLayout;
        f(relativeLayout);
        TextView textView = (TextView) findViewById(R.id.reward_ad_operate_command_button);
        this.h = textView;
        f(textView);
    }

    public final boolean i() {
        AdBaseModel adBaseModel;
        gp0 gp0Var;
        if (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || (gp0Var = adBaseModel.l) == null || !gp0Var.e) {
            return false;
        }
        return true;
    }

    public final boolean j() {
        AdBaseModel adBaseModel;
        if (!(getTag() instanceof AdBaseModel) || (adBaseModel = (AdBaseModel) getTag()) == null || adBaseModel.h == null) {
            return false;
        }
        return true;
    }

    public final void m(AdBaseModel adBaseModel) {
        int i;
        AdOperator.a aVar;
        if (this.f == null) {
            return;
        }
        if (i() && adBaseModel.i != null) {
            this.f.setVisibility(8);
            return;
        }
        if (adBaseModel.b) {
            i = R.color.NAD_FC4;
        } else {
            i = R.color.NAD_FC1;
        }
        this.f.setTextColor(getContext().getResources().getColor(i));
        String str = null;
        AdOperator adOperator = adBaseModel.h;
        if (adOperator != null && (aVar = adOperator.b) != null) {
            str = aVar.a;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f.setVisibility(0);
            this.f.setText(str);
        } else {
            this.f.setVisibility(8);
        }
        String str2 = adBaseModel.f.g;
        if (!TextUtils.isEmpty(str2)) {
            this.g.setVisibility(0);
            this.g.setText(str2);
            return;
        }
        this.g.setVisibility(8);
    }

    public final void n(AdBaseModel adBaseModel) {
        if (this.h != null && adBaseModel.h != null) {
            if (i()) {
                this.h.setVisibility(8);
                return;
            }
            this.h.setTextColor(getContext().getResources().getColor(R.color.NAD_FC13));
            if (this.h.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) this.h.getBackground()).setColor(getContext().getResources().getColor(R.color.NAD_GC52));
                ((GradientDrawable) this.h.getBackground()).setStroke(2, getContext().getResources().getColor(R.color.NAD_GC53));
            } else {
                this.h.setBackground(getContext().getResources().getDrawable(R.drawable.nad_progress_button_bg));
            }
            if (!TextUtils.isEmpty(adBaseModel.h.c)) {
                this.h.setText(adBaseModel.h.c);
            }
            if (!TextUtils.isEmpty(adBaseModel.h.d)) {
                this.h.setVisibility(0);
                this.h.setOnClickListener(new d(adBaseModel));
                return;
            }
            this.h.setVisibility(8);
        }
    }

    public final void o(AdBaseModel adBaseModel) {
        if (this.e == null) {
            return;
        }
        if (!i()) {
            this.e.setVisibility(8);
            return;
        }
        qk0<?> a2 = hl0.a(this.e, IDownloadViewCreator.ViewType.REWARD_DOWNLOAD_VIEW);
        this.e.setVisibility(0);
        xj0 c2 = xj0.c(adBaseModel);
        this.i = new kk0(c2, a2);
        this.e.setOnClickListener(new b());
        wb1 wb1Var = this.b;
        if (wb1Var != null) {
            wb1Var.c(adBaseModel);
        }
        this.i.o(new c(adBaseModel, c2));
    }
}
