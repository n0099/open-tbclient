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
import com.baidu.tieba.an0;
import com.baidu.tieba.az0;
import com.baidu.tieba.ih0;
import com.baidu.tieba.jn0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.nn0;
import com.baidu.tieba.pe0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.t11;
import com.baidu.tieba.vg0;
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
    public ih0 i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public c l;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public AdImageView q;
    public AdImageView r;
    public nn0 s;
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
            PortraitVideoTailView.this.h(ClogBuilder.LogType.FREE_CLICK, str, this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ ln0 a;
        public final /* synthetic */ AdBaseModel b;

        public b(ln0 ln0Var, AdBaseModel adBaseModel) {
            this.a = ln0Var;
            this.b = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            pe0.d(this.a.z, PortraitVideoTailView.this.getContext(), null);
            az0.e(new ClogBuilder().y(ClogBuilder.LogType.FREE_CLICK).p(this.b.f.d).j("morebtn"));
        }
    }

    public PortraitVideoTailView(Context context) {
        super(context);
    }

    public static boolean b(nn0 nn0Var) {
        nn0.c cVar;
        nn0.b bVar;
        if (nn0Var == null) {
            return false;
        }
        if (TextUtils.isEmpty(nn0Var.f) && TextUtils.isEmpty(nn0Var.d) && (((cVar = nn0Var.g) == null || TextUtils.isEmpty(cVar.a)) && ((bVar = nn0Var.h) == null || TextUtils.isEmpty(bVar.a)))) {
            return false;
        }
        return true;
    }

    public final boolean f(AdBaseModel adBaseModel) {
        jn0 jn0Var;
        if (adBaseModel != null && adBaseModel.f != null && (jn0Var = adBaseModel.j) != null && jn0Var.i != null) {
            return true;
        }
        return false;
    }

    public final void g(AdBaseModel adBaseModel) {
        an0 an0Var;
        if (adBaseModel != null && (an0Var = adBaseModel.f) != null && !TextUtils.isEmpty(an0Var.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.VIDEO_LP_PV);
            clogBuilder.u(ClogBuilder.Page.PAGE_VIDEO_LANDING);
            clogBuilder.p(adBaseModel.f.d);
            az0.e(clogBuilder);
        }
    }

    public void setAdInfo(nn0 nn0Var) {
        this.s = nn0Var;
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

    public final void h(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        an0 an0Var;
        if (adBaseModel != null && (an0Var = adBaseModel.f) != null && !TextUtils.isEmpty(an0Var.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.j(str);
            clogBuilder.p(adBaseModel.f.d);
            az0.e(clogBuilder);
        }
    }

    private void setMoreButton(AdBaseModel adBaseModel) {
        ln0 ln0Var = adBaseModel.j.i;
        if (ln0Var != null && !TextUtils.isEmpty(ln0Var.x) && !TextUtils.isEmpty(ln0Var.y)) {
            this.u.setVisibility(0);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(t11.c.a(getContext(), 17.0f));
            gradientDrawable.setStroke(2, ContextCompat.getColor(getContext(), R.color.nad_portrait_tail_frame_more_btn_border));
            this.u.setBackground(gradientDrawable);
            this.u.setOnClickListener(new b(ln0Var, adBaseModel));
            if (!TextUtils.isEmpty(ln0Var.x)) {
                this.v.r(ln0Var.x);
                this.v.setVisibility(0);
            }
            if (!TextUtils.isEmpty(ln0Var.y)) {
                this.w.setText(ln0Var.y);
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
        if (!f(adBaseModel)) {
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
            str2 = adBaseModel.j.i.g;
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
        pe0.c(str3, getContext());
        h(ClogBuilder.LogType.CLICK, str, adBaseModel);
        c cVar = this.l;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        setVisibility(8);
    }

    public final void e(Context context) {
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

    public void i(@NonNull AdBaseModel adBaseModel) {
        if (!f(adBaseModel)) {
            setVisibility(8);
            return;
        }
        ln0 ln0Var = adBaseModel.j.i;
        if (ln0Var != null) {
            e(getContext());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(getResources().getColor(R.color.nad_enhancement_btn_bg_color));
            int a2 = t11.c.a(getContext(), 8.0f);
            gradientDrawable.setCornerRadius(a2);
            this.p.setBackground(gradientDrawable);
            this.h.setCornerRadius(a2);
            this.h.setBackground(gradientDrawable);
            this.h.setProgressColor(getResources().getColor(R.color.nad_mini_video_ad_download_progress_color));
            setVisibility(0);
            if (!TextUtils.isEmpty(ln0Var.d)) {
                this.a.r(ln0Var.d);
                this.a.setVisibility(0);
            } else {
                this.a.setVisibility(8);
            }
            if (TextUtils.isEmpty(ln0Var.c)) {
                this.b.setVisibility(8);
            } else {
                this.b.setText(ln0Var.c, TextView.BufferType.NORMAL);
                this.b.setVisibility(0);
            }
            if (TextUtils.isEmpty(ln0Var.l)) {
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
                this.c.setText(ln0Var.l);
            }
            nn0 nn0Var = this.s;
            if (nn0Var != null) {
                float f = (float) nn0Var.e;
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
            if (TextUtils.isEmpty(ln0Var.o)) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.n.setText(ln0Var.o);
            }
            if (TextUtils.isEmpty(ln0Var.m)) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.f.setText(ln0Var.m, TextView.BufferType.NORMAL);
            }
            if (adBaseModel.d && adBaseModel.h.a == AdOperator.TYPE.DOWNLOAD) {
                this.p.setVisibility(8);
                sm0 sm0Var = adBaseModel.l;
                if (sm0Var != null && sm0Var.e) {
                    this.h.setVisibility(0);
                    this.i = new ih0(vg0.c(adBaseModel), this.h);
                } else {
                    this.h.setVisibility(8);
                    this.i = null;
                }
            } else {
                this.p.setVisibility(0);
                if (TextUtils.isEmpty(ln0Var.h)) {
                    this.g.setText(ln0Var.h);
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
            g(adBaseModel);
        } else {
            setVisibility(8);
        }
        this.r.b(adBaseModel.j.d, 1, 5);
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
            ih0 ih0Var = this.i;
            if (ih0Var != null) {
                ih0Var.m();
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
