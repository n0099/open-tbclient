package com.baidu.nadcore.business.uitemplate;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.core.content.ContextCompat;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.bs0;
import com.baidu.tieba.dm0;
import com.baidu.tieba.ds0;
import com.baidu.tieba.fs0;
import com.baidu.tieba.g61;
import com.baidu.tieba.mr0;
import com.baidu.tieba.qm0;
import com.baidu.tieba.r31;
import com.baidu.tieba.ur0;
import com.baidu.tieba.xj0;
/* loaded from: classes3.dex */
public class PortraitVideoTailView extends FrameLayout implements View.OnClickListener {
    public AdImageView a;
    public TextView b;
    public TextView c;
    public AppCompatRatingBar d;
    public View e;
    public TextView f;
    public TextView g;
    public NadMiniVideoDownloadView h;
    public qm0 i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public c l;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public AdImageView q;
    public AdImageView r;
    public fs0 s;
    public SimpleAdInfoView t;
    public LinearLayout u;
    public AdImageView v;
    public TextView w;

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    public void setPlayerProgressHandler(NadVideoAdOverContainer.f fVar) {
    }

    /* loaded from: classes3.dex */
    public class a implements SimpleAdInfoView.c {
        public final /* synthetic */ AdBaseModel a;

        public a(AdBaseModel adBaseModel) {
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            PortraitVideoTailView.this.i(ClogBuilder.LogType.FREE_CLICK, str, this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ ds0 a;
        public final /* synthetic */ AdBaseModel b;

        public b(ds0 ds0Var, AdBaseModel adBaseModel) {
            this.a = ds0Var;
            this.b = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            xj0.d(this.a.y, PortraitVideoTailView.this.getContext(), null);
            r31.b(new ClogBuilder().y(ClogBuilder.LogType.FREE_CLICK).p(this.b.f.d).j("morebtn"));
        }
    }

    public PortraitVideoTailView(Context context) {
        super(context);
    }

    public static boolean b(fs0 fs0Var) {
        fs0.b bVar;
        fs0.a aVar;
        if (fs0Var == null) {
            return false;
        }
        if (TextUtils.isEmpty(fs0Var.f) && TextUtils.isEmpty(fs0Var.d) && (((bVar = fs0Var.g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = fs0Var.h) == null || TextUtils.isEmpty(aVar.a)))) {
            return false;
        }
        return true;
    }

    public final boolean g(AdBaseModel adBaseModel) {
        bs0 bs0Var;
        if (adBaseModel != null && adBaseModel.f != null && (bs0Var = adBaseModel.j) != null && bs0Var.i != null) {
            return true;
        }
        return false;
    }

    public final void h(AdBaseModel adBaseModel) {
        ur0 ur0Var;
        if (adBaseModel != null && (ur0Var = adBaseModel.f) != null && !TextUtils.isEmpty(ur0Var.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.VIDEO_LP_PV);
            clogBuilder.u(ClogBuilder.Page.PAGE_VIDEO_LANDING);
            clogBuilder.p(adBaseModel.f.d);
            r31.b(clogBuilder);
        }
    }

    public void setAdInfo(fs0 fs0Var) {
        this.s = fs0Var;
    }

    public void setOnAdClickListener(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void setOnReplayClickListener(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void setOnTailJumpHandler(c cVar) {
        this.l = cVar;
    }

    public PortraitVideoTailView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PortraitVideoTailView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void i(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        ur0 ur0Var;
        if (adBaseModel != null && (ur0Var = adBaseModel.f) != null && !TextUtils.isEmpty(ur0Var.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.j(str);
            clogBuilder.p(adBaseModel.f.d);
            r31.b(clogBuilder);
        }
    }

    private void setMoreButton(AdBaseModel adBaseModel) {
        ds0 ds0Var = adBaseModel.j.i;
        if (ds0Var != null && !TextUtils.isEmpty(ds0Var.w) && !TextUtils.isEmpty(ds0Var.x)) {
            this.u.setVisibility(0);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(g61.c.a(getContext(), 17.0f));
            gradientDrawable.setStroke(2, ContextCompat.getColor(getContext(), R.color.nad_portrait_tail_frame_more_btn_border));
            this.u.setBackground(gradientDrawable);
            this.u.setOnClickListener(new b(ds0Var, adBaseModel));
            if (!TextUtils.isEmpty(ds0Var.w)) {
                this.v.o(ds0Var.w);
                this.v.setVisibility(0);
            }
            if (!TextUtils.isEmpty(ds0Var.x)) {
                this.w.setText(ds0Var.x);
                this.w.setVisibility(0);
                return;
            }
            return;
        }
        this.u.setVisibility(8);
        this.v.setVisibility(8);
        this.w.setVisibility(8);
    }

    public final void c(AdBaseModel adBaseModel, View view2) {
        String str;
        boolean z;
        if (!g(adBaseModel)) {
            return;
        }
        String str2 = adBaseModel.j.i.e;
        String str3 = adBaseModel.f.c;
        int id = view2.getId();
        if (id == R.id.tail_frame_author_avatar) {
            str = "tail_avatar";
        } else if (id == R.id.tail_frame_title) {
            str = "tail_name";
        } else if (id == R.id.command_layout) {
            str2 = adBaseModel.j.i.f;
            str = NativeConstants.ID_BUTTON;
        } else if (id == R.id.tail_frame_trade) {
            str = "tail_tag";
        } else if (id == R.id.ad_mini_video_detail_rating_bar_root_view) {
            str = "tail_score";
        } else if (id == R.id.tail_frame_sub_title) {
            str = "tail_title";
        } else if (id == R.id.tail_frame_popular_text) {
            str = "tail_popularity";
        } else {
            str = "hot";
        }
        if (!TextUtils.isEmpty(str2) && !"__BTN_SCHEME__".equals(str2)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str3 = str2;
        }
        xj0.c(str3, getContext());
        i(ClogBuilder.LogType.CLICK, str, adBaseModel);
        c cVar = this.l;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        View findViewById = findViewById(R.id.tail_frame_replay_btn);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public void e() {
        setVisibility(8);
    }

    public final void f(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.nad_portrait_video_tail_view, this);
        setBackgroundColor(getResources().getColor(R.color.nad_mini_video_ad_tail_frame_bg_color));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        setLayoutParams(layoutParams);
        this.a = (AdImageView) findViewById(R.id.tail_frame_author_avatar);
        this.b = (TextView) findViewById(R.id.tail_frame_title);
        this.c = (TextView) findViewById(R.id.tail_frame_trade);
        this.e = findViewById(R.id.ad_mini_video_detail_rating_bar_root_view);
        this.m = (TextView) findViewById(R.id.tail_frame_scope);
        this.d = (AppCompatRatingBar) findViewById(R.id.tail_frame_rating_bar);
        this.n = (TextView) findViewById(R.id.tail_frame_popular_text);
        this.f = (TextView) findViewById(R.id.tail_frame_sub_title);
        View findViewById = findViewById(R.id.tail_frame_replay_btn);
        this.g = (TextView) findViewById(R.id.tail_frame_check_btn_txt);
        this.o = findViewById(R.id.tail_frame_btn_container);
        this.p = findViewById(R.id.command_layout);
        this.q = (AdImageView) findViewById(R.id.common_btn_icon);
        this.r = (AdImageView) findViewById(R.id.back_blur_img);
        NadMiniVideoDownloadView nadMiniVideoDownloadView = (NadMiniVideoDownloadView) findViewById(R.id.tail_frame_download_btn_txt);
        this.h = nadMiniVideoDownloadView;
        nadMiniVideoDownloadView.setTextSize(12.0f);
        this.h.setTextColor(getResources().getColor(R.color.nad_mini_video_ad_tail_frame_download_text_color));
        int intrinsicHeight = ContextCompat.getDrawable(getContext(), R.drawable.nad_mini_video_tail_star).getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams2 = this.d.getLayoutParams();
        layoutParams2.width = -2;
        layoutParams2.height = intrinsicHeight;
        this.d.setLayoutParams(layoutParams2);
        this.t = (SimpleAdInfoView) findViewById(R.id.ad_app_info_view);
        findViewById.setOnClickListener(this);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.u = (LinearLayout) findViewById(R.id.more_btn_container);
        this.v = (AdImageView) findViewById(R.id.more_btn_icon);
        this.w = (TextView) findViewById(R.id.more_btn_text);
        setOnClickListener(null);
    }

    public void j(@NonNull AdBaseModel adBaseModel) {
        if (!g(adBaseModel)) {
            setVisibility(8);
            return;
        }
        ds0 ds0Var = adBaseModel.j.i;
        if (ds0Var != null) {
            f(getContext());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(getResources().getColor(R.color.nad_enhancement_btn_bg_color));
            int a2 = g61.c.a(getContext(), 8.0f);
            gradientDrawable.setCornerRadius(a2);
            this.p.setBackground(gradientDrawable);
            this.h.setCornerRadius(a2);
            this.h.setBackground(gradientDrawable);
            this.h.setProgressColor(getResources().getColor(R.color.nad_mini_video_ad_download_progress_color));
            setVisibility(0);
            if (!TextUtils.isEmpty(ds0Var.d)) {
                this.a.o(ds0Var.d);
                this.a.setVisibility(0);
            } else {
                this.a.setVisibility(8);
            }
            if (TextUtils.isEmpty(ds0Var.c)) {
                this.b.setVisibility(8);
            } else {
                this.b.setText(ds0Var.c, TextView.BufferType.NORMAL);
                this.b.setVisibility(0);
            }
            if (TextUtils.isEmpty(ds0Var.k)) {
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
                this.c.setText(ds0Var.k);
            }
            fs0 fs0Var = this.s;
            if (fs0Var != null) {
                float f = (float) fs0Var.e;
                if (f <= 0.0f) {
                    this.e.setVisibility(8);
                } else {
                    this.e.setVisibility(0);
                    this.m.setText(String.valueOf(f));
                    this.d.setRating(f);
                }
            } else {
                this.e.setVisibility(8);
            }
            if (TextUtils.isEmpty(ds0Var.n)) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.n.setText(ds0Var.n);
            }
            if (TextUtils.isEmpty(ds0Var.l)) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.f.setText(ds0Var.l, TextView.BufferType.NORMAL);
            }
            if (adBaseModel.d && adBaseModel.h.a == AdOperator.TYPE.DOWNLOAD) {
                this.p.setVisibility(8);
                mr0 mr0Var = adBaseModel.l;
                if (mr0Var != null && mr0Var.e) {
                    this.h.setVisibility(0);
                    this.i = new qm0(dm0.c(adBaseModel), this.h);
                } else {
                    this.h.setVisibility(8);
                    this.i = null;
                }
            } else {
                this.p.setVisibility(0);
                if (TextUtils.isEmpty(ds0Var.g)) {
                    this.g.setText(ds0Var.g);
                } else {
                    this.g.setText(getResources().getText(R.string.nad_command_btn_text));
                }
                this.q.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.nad_mini_video_ad_pop_command));
                this.h.setVisibility(8);
                if (this.i != null) {
                    this.i = null;
                }
            }
            if (!b(this.s)) {
                this.t.setVisibility(8);
            } else {
                Resources resources = getContext().getResources();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.t.getLayoutParams();
                layoutParams.leftMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
                layoutParams.rightMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
                this.t.setLayoutParams(layoutParams);
                this.t.setAdInfo(this.s);
                this.t.setVisibility(0);
                this.t.setAfterListener(new a(adBaseModel));
            }
            setMoreButton(adBaseModel);
            h(adBaseModel);
        } else {
            setVisibility(8);
        }
        this.r.n(adBaseModel.j.d, 1, 5);
        setTag(adBaseModel);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        if (view2.getId() == R.id.tail_frame_replay_btn) {
            View.OnClickListener onClickListener = this.j;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        } else if (view2.getId() == R.id.tail_frame_download_btn_txt) {
            qm0 qm0Var = this.i;
            if (qm0Var != null) {
                qm0Var.m();
            }
        } else {
            c(adBaseModel, view2);
            View.OnClickListener onClickListener2 = this.k;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view2);
            }
        }
    }
}
