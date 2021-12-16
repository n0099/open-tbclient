package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.b.e;
import c.a.c0.b.g;
import c.a.c0.b.h;
import c.a.c0.d.c;
import c.a.c0.d0.f;
import c.a.c0.g.f.d;
import c.a.c0.p.j;
import c.a.c0.p.l;
import c.a.c0.p.n;
import c.a.c0.p.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uitemplate.SimpleAdInfoView;
import com.baidu.nadcore.widget.view.NadVideoAdOverContainer;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class PortraitVideoTailView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdImageView f38524e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38525f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38526g;

    /* renamed from: h  reason: collision with root package name */
    public AppCompatRatingBar f38527h;

    /* renamed from: i  reason: collision with root package name */
    public View f38528i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f38529j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f38530k;
    public NadMiniVideoDownloadView l;
    public d m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public NadVideoAdOverContainer.e p;
    public b q;
    public TextView r;
    public TextView s;
    public View t;
    public View u;
    public AdImageView v;
    public AdImageView w;
    public p x;
    public SimpleAdInfoView y;

    /* loaded from: classes10.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoTailView f38531b;

        public a(PortraitVideoTailView portraitVideoTailView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoTailView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38531b = portraitVideoTailView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uitemplate.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f38531b.f(ClogBuilder.LogType.FREE_CLICK, str, this.a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortraitVideoTailView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean canShowAppInfoLayout(p pVar) {
        InterceptResult invokeL;
        p.b bVar;
        p.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pVar)) == null) {
            if (pVar == null) {
                return false;
            }
            return (TextUtils.isEmpty(pVar.f1833f) && TextUtils.isEmpty(pVar.f1831d) && ((bVar = pVar.f1834g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = pVar.f1835h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final void b(AdBaseModel adBaseModel, View view) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, adBaseModel, view) == null) && d(adBaseModel)) {
            String str2 = adBaseModel.f38067h.f1808c.f1811c;
            String str3 = adBaseModel.f38063d.a;
            int id = view.getId();
            if (id == e.tail_frame_author_avatar) {
                str = "tail_avatar";
            } else if (id == e.tail_frame_title) {
                str = "tail_name";
            } else if (id == e.command_layout) {
                str2 = adBaseModel.f38067h.f1808c.f1812d;
                str = "button";
            } else if (id == e.tail_frame_trade) {
                str = "tail_tag";
            } else if (id == e.ad_mini_video_detail_rating_bar_root_view) {
                str = "tail_score";
            } else if (id == e.tail_frame_sub_title) {
                str = "tail_title";
            } else {
                str = id == e.tail_frame_popular_text ? "tail_popularity" : ThreadAchievementShareDialogView.HOT_LIST_VIEW_TYPE;
            }
            if ((TextUtils.isEmpty(str2) || "__BTN_SCHEME__".equals(str2)) ? false : true) {
                str3 = str2;
            }
            c.c(str3, getContext());
            f(ClogBuilder.LogType.CLICK, str, adBaseModel);
            NadVideoAdOverContainer.e eVar = this.p;
            if (eVar != null) {
                eVar.a();
            }
            b bVar = this.q;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            removeAllViews();
            LayoutInflater.from(context).inflate(g.nad_portrait_video_tail_view, this);
            setBackgroundColor(getResources().getColor(c.a.c0.b.b.nad_mini_video_ad_tail_frame_bg_color));
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            setLayoutParams(layoutParams);
            this.f38524e = (AdImageView) findViewById(e.tail_frame_author_avatar);
            this.f38525f = (TextView) findViewById(e.tail_frame_title);
            this.f38526g = (TextView) findViewById(e.tail_frame_trade);
            this.f38528i = findViewById(e.ad_mini_video_detail_rating_bar_root_view);
            this.r = (TextView) findViewById(e.tail_frame_scope);
            this.f38527h = (AppCompatRatingBar) findViewById(e.tail_frame_rating_bar);
            this.s = (TextView) findViewById(e.tail_frame_popular_text);
            this.f38529j = (TextView) findViewById(e.tail_frame_sub_title);
            View findViewById = findViewById(e.tail_frame_replay_btn);
            this.f38530k = (TextView) findViewById(e.tail_frame_check_btn_txt);
            this.t = findViewById(e.tail_frame_btn_container);
            this.u = findViewById(e.command_layout);
            this.v = (AdImageView) findViewById(e.common_btn_icon);
            this.w = (AdImageView) findViewById(e.back_blur_img);
            NadMiniVideoDownloadView nadMiniVideoDownloadView = (NadMiniVideoDownloadView) findViewById(e.tail_frame_download_btn_txt);
            this.l = nadMiniVideoDownloadView;
            nadMiniVideoDownloadView.setTextSize(12.0f);
            this.l.setTextColor(getResources().getColor(c.a.c0.b.b.nad_mini_video_ad_tail_frame_download_text_color));
            int intrinsicHeight = ContextCompat.getDrawable(getContext(), c.a.c0.b.d.nad_mini_video_tail_star).getIntrinsicHeight();
            ViewGroup.LayoutParams layoutParams2 = this.f38527h.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = intrinsicHeight;
            this.f38527h.setLayoutParams(layoutParams2);
            this.y = (SimpleAdInfoView) findViewById(e.ad_app_info_view);
            findViewById.setOnClickListener(this);
            this.f38524e.setOnClickListener(this);
            this.f38525f.setOnClickListener(this);
            this.f38526g.setOnClickListener(this);
            this.f38528i.setOnClickListener(this);
            this.f38529j.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.l.setOnClickListener(this);
            setOnClickListener(null);
        }
    }

    public final boolean d(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        l lVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel)) == null) ? (adBaseModel == null || adBaseModel.f38063d == null || (lVar = adBaseModel.f38067h) == null || lVar.f1808c == null) ? false : true : invokeL.booleanValue;
    }

    public final void e(AdBaseModel adBaseModel) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || adBaseModel == null || (jVar = adBaseModel.f38063d) == null || TextUtils.isEmpty(jVar.f1800b)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.r(ClogBuilder.LogType.VIDEO_LP_PV);
        clogBuilder.p(ClogBuilder.Page.PAGE_VIDEO_LANDING);
        clogBuilder.m(adBaseModel.f38063d.f1800b);
        c.a.c0.x.a.b(clogBuilder);
    }

    public final void f(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, logType, str, adBaseModel) == null) || adBaseModel == null || (jVar = adBaseModel.f38063d) == null || TextUtils.isEmpty(jVar.f1800b)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.r(logType);
        clogBuilder.g(str);
        clogBuilder.m(adBaseModel.f38063d.f1800b);
        c.a.c0.x.a.b(clogBuilder);
    }

    public void hideReplayBtn() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (findViewById = findViewById(e.tail_frame_replay_btn)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void hideTailFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (view.getId() == e.tail_frame_replay_btn) {
                View.OnClickListener onClickListener = this.n;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            } else if (view.getId() == e.tail_frame_download_btn_txt) {
                d dVar = this.m;
                if (dVar != null) {
                    dVar.o();
                }
            } else {
                b(adBaseModel, view);
                this.o.onClick(view);
            }
        }
    }

    public void setAdInfo(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.x = pVar;
        }
    }

    public void setOnAdClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void setOnReplayClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void setOnTailJumpHandler(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.q = bVar;
        }
    }

    public void setPlayerProgressHandler(NadVideoAdOverContainer.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
        }
    }

    public void setUbsClickHandler(NadVideoAdOverContainer.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.p = eVar;
        }
    }

    public void showReplayBtn() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (findViewById = findViewById(e.tail_frame_replay_btn)) == null) {
            return;
        }
        findViewById.setVisibility(0);
    }

    public void showTailFrame(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, adBaseModel) == null) {
            if (!d(adBaseModel)) {
                setVisibility(8);
                return;
            }
            n nVar = adBaseModel.f38067h.f1808c;
            if (nVar != null) {
                c(getContext());
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(getResources().getColor(c.a.c0.b.b.nad_enhancement_btn_bg_color));
                int a2 = f.c.a(getContext(), 8.0f);
                gradientDrawable.setCornerRadius(a2);
                this.u.setBackground(gradientDrawable);
                this.l.setCornerRadius(a2);
                this.l.setBackground(gradientDrawable);
                this.l.setProgressColor(getResources().getColor(c.a.c0.b.b.nad_mini_video_ad_download_progress_color));
                setVisibility(0);
                if (!TextUtils.isEmpty(nVar.f1810b)) {
                    this.f38524e.displayImage(nVar.f1810b);
                    this.f38524e.setVisibility(0);
                } else {
                    this.f38524e.setVisibility(8);
                }
                if (TextUtils.isEmpty(nVar.a)) {
                    this.f38525f.setVisibility(8);
                } else {
                    this.f38525f.setText(nVar.a, TextView.BufferType.NORMAL);
                    this.f38525f.setVisibility(0);
                }
                if (TextUtils.isEmpty(nVar.f1815g)) {
                    this.f38526g.setVisibility(8);
                } else {
                    this.f38526g.setVisibility(0);
                    this.f38526g.setText(nVar.f1815g);
                }
                p pVar = this.x;
                if (pVar != null) {
                    float f2 = (float) pVar.f1832e;
                    if (f2 <= 0.0f) {
                        this.f38528i.setVisibility(8);
                    } else {
                        this.f38528i.setVisibility(0);
                        this.r.setText(String.valueOf(f2));
                        this.f38527h.setRating(f2);
                    }
                } else {
                    this.f38528i.setVisibility(8);
                }
                if (TextUtils.isEmpty(nVar.f1817i)) {
                    this.s.setVisibility(8);
                } else {
                    this.s.setVisibility(0);
                    this.s.setText(nVar.f1817i);
                }
                if (TextUtils.isEmpty(nVar.f1816h)) {
                    this.f38529j.setVisibility(8);
                } else {
                    this.f38529j.setVisibility(0);
                    this.f38529j.setText(nVar.f1816h, TextView.BufferType.NORMAL);
                }
                if (adBaseModel.f38062c && adBaseModel.f38065f.a == AdOperator.TYPE.DOWNLOAD) {
                    this.u.setVisibility(8);
                    c.a.c0.p.c cVar = adBaseModel.f38068i;
                    if (cVar != null && cVar.f1788d) {
                        this.l.setVisibility(0);
                        this.m = new d(c.a.c0.g.d.a.b(adBaseModel), this.l);
                    } else {
                        this.l.setVisibility(8);
                        this.m = null;
                    }
                } else {
                    this.u.setVisibility(0);
                    if (TextUtils.isEmpty(nVar.f1813e)) {
                        this.f38530k.setText(nVar.f1813e);
                    } else {
                        this.f38530k.setText(getResources().getText(h.nad_command_btn_text));
                    }
                    this.v.setImageDrawable(ContextCompat.getDrawable(getContext(), c.a.c0.b.d.nad_mini_video_ad_pop_command));
                    this.l.setVisibility(8);
                    if (this.m != null) {
                        this.m = null;
                    }
                }
                if (!canShowAppInfoLayout(this.x)) {
                    this.y.setVisibility(8);
                } else {
                    Resources resources = getContext().getResources();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.y.getLayoutParams();
                    layoutParams.leftMargin = resources.getDimensionPixelOffset(c.a.c0.b.c.nad_dimen_15dp);
                    layoutParams.rightMargin = resources.getDimensionPixelOffset(c.a.c0.b.c.nad_dimen_15dp);
                    this.y.setLayoutParams(layoutParams);
                    this.y.setAdInfo(this.x);
                    this.y.setVisibility(0);
                    this.y.setAfterListener(new a(this, adBaseModel));
                }
                e(adBaseModel);
            } else {
                setVisibility(8);
            }
            this.w.displayBlurBackground(adBaseModel.f38067h.f1807b, 1, 5);
            setTag(adBaseModel);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortraitVideoTailView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortraitVideoTailView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
