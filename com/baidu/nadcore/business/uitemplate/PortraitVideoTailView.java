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
import androidx.core.view.InputDeviceCompat;
import c.a.c0.d.e;
import c.a.c0.d.g;
import c.a.c0.d.h;
import c.a.c0.g0.f;
import c.a.c0.j.f.d;
import c.a.c0.s.i;
import c.a.c0.s.l;
import c.a.c0.s.n;
import c.a.c0.s.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
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
    public TextView A;

    /* renamed from: e  reason: collision with root package name */
    public AdImageView f36960e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f36961f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f36962g;

    /* renamed from: h  reason: collision with root package name */
    public AppCompatRatingBar f36963h;

    /* renamed from: i  reason: collision with root package name */
    public View f36964i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f36965j;
    public TextView k;
    public NadMiniVideoDownloadView l;
    public d m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public c p;
    public TextView q;
    public TextView r;
    public View s;
    public View t;
    public AdImageView u;
    public AdImageView v;
    public p w;
    public SimpleAdInfoView x;
    public LinearLayout y;
    public AdImageView z;

    /* loaded from: classes10.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoTailView f36966b;

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
            this.f36966b = portraitVideoTailView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f36966b.f(ClogBuilder.LogType.FREE_CLICK, str, this.a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f36967e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f36968f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoTailView f36969g;

        public b(PortraitVideoTailView portraitVideoTailView, n nVar, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoTailView, nVar, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36969g = portraitVideoTailView;
            this.f36967e = nVar;
            this.f36968f = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.c0.f.d.d(this.f36967e.t, this.f36969g.getContext(), null);
                c.a.c0.a0.a.b(new ClogBuilder().r(ClogBuilder.LogType.FREE_CLICK).m(this.f36968f.f37016d.f2233b).g("morebtn"));
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface c {
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
            return (TextUtils.isEmpty(pVar.f2270f) && TextUtils.isEmpty(pVar.f2268d) && ((bVar = pVar.f2271g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = pVar.f2272h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    private void setMoreButton(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, adBaseModel) == null) {
            n nVar = adBaseModel.f37020h.f2242c;
            if (nVar != null && !TextUtils.isEmpty(nVar.r) && !TextUtils.isEmpty(nVar.s)) {
                this.y.setVisibility(0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(f.c.a(getContext(), 17.0f));
                gradientDrawable.setStroke(2, ContextCompat.getColor(getContext(), c.a.c0.d.b.nad_portrait_tail_frame_more_btn_border));
                this.y.setBackground(gradientDrawable);
                this.y.setOnClickListener(new b(this, nVar, adBaseModel));
                if (!TextUtils.isEmpty(nVar.r)) {
                    this.z.displayImage(nVar.r);
                    this.z.setVisibility(0);
                }
                if (TextUtils.isEmpty(nVar.s)) {
                    return;
                }
                this.A.setText(nVar.s);
                this.A.setVisibility(0);
                return;
            }
            this.y.setVisibility(8);
            this.z.setVisibility(8);
            this.A.setVisibility(8);
        }
    }

    public final void b(AdBaseModel adBaseModel, View view) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, adBaseModel, view) == null) && d(adBaseModel)) {
            String str2 = adBaseModel.f37020h.f2242c.f2245c;
            String str3 = adBaseModel.f37016d.a;
            int id = view.getId();
            if (id == e.tail_frame_author_avatar) {
                str = "tail_avatar";
            } else if (id == e.tail_frame_title) {
                str = "tail_name";
            } else if (id == e.command_layout) {
                str2 = adBaseModel.f37020h.f2242c.f2246d;
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
            c.a.c0.f.d.c(str3, getContext());
            f(ClogBuilder.LogType.CLICK, str, adBaseModel);
            c cVar = this.p;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            removeAllViews();
            LayoutInflater.from(context).inflate(g.nad_portrait_video_tail_view, this);
            setBackgroundColor(getResources().getColor(c.a.c0.d.b.nad_mini_video_ad_tail_frame_bg_color));
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            setLayoutParams(layoutParams);
            this.f36960e = (AdImageView) findViewById(e.tail_frame_author_avatar);
            this.f36961f = (TextView) findViewById(e.tail_frame_title);
            this.f36962g = (TextView) findViewById(e.tail_frame_trade);
            this.f36964i = findViewById(e.ad_mini_video_detail_rating_bar_root_view);
            this.q = (TextView) findViewById(e.tail_frame_scope);
            this.f36963h = (AppCompatRatingBar) findViewById(e.tail_frame_rating_bar);
            this.r = (TextView) findViewById(e.tail_frame_popular_text);
            this.f36965j = (TextView) findViewById(e.tail_frame_sub_title);
            View findViewById = findViewById(e.tail_frame_replay_btn);
            this.k = (TextView) findViewById(e.tail_frame_check_btn_txt);
            this.s = findViewById(e.tail_frame_btn_container);
            this.t = findViewById(e.command_layout);
            this.u = (AdImageView) findViewById(e.common_btn_icon);
            this.v = (AdImageView) findViewById(e.back_blur_img);
            NadMiniVideoDownloadView nadMiniVideoDownloadView = (NadMiniVideoDownloadView) findViewById(e.tail_frame_download_btn_txt);
            this.l = nadMiniVideoDownloadView;
            nadMiniVideoDownloadView.setTextSize(12.0f);
            this.l.setTextColor(getResources().getColor(c.a.c0.d.b.nad_mini_video_ad_tail_frame_download_text_color));
            int intrinsicHeight = ContextCompat.getDrawable(getContext(), c.a.c0.d.d.nad_mini_video_tail_star).getIntrinsicHeight();
            ViewGroup.LayoutParams layoutParams2 = this.f36963h.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = intrinsicHeight;
            this.f36963h.setLayoutParams(layoutParams2);
            this.x = (SimpleAdInfoView) findViewById(e.ad_app_info_view);
            findViewById.setOnClickListener(this);
            this.f36960e.setOnClickListener(this);
            this.f36961f.setOnClickListener(this);
            this.f36962g.setOnClickListener(this);
            this.f36964i.setOnClickListener(this);
            this.f36965j.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.y = (LinearLayout) findViewById(e.more_btn_container);
            this.z = (AdImageView) findViewById(e.more_btn_icon);
            this.A = (TextView) findViewById(e.more_btn_text);
            setOnClickListener(null);
        }
    }

    public final boolean d(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        l lVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel)) == null) ? (adBaseModel == null || adBaseModel.f37016d == null || (lVar = adBaseModel.f37020h) == null || lVar.f2242c == null) ? false : true : invokeL.booleanValue;
    }

    public final void e(AdBaseModel adBaseModel) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || adBaseModel == null || (iVar = adBaseModel.f37016d) == null || TextUtils.isEmpty(iVar.f2233b)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.r(ClogBuilder.LogType.VIDEO_LP_PV);
        clogBuilder.p(ClogBuilder.Page.PAGE_VIDEO_LANDING);
        clogBuilder.m(adBaseModel.f37016d.f2233b);
        c.a.c0.a0.a.b(clogBuilder);
    }

    public final void f(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, logType, str, adBaseModel) == null) || adBaseModel == null || (iVar = adBaseModel.f37016d) == null || TextUtils.isEmpty(iVar.f2233b)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.r(logType);
        clogBuilder.g(str);
        clogBuilder.m(adBaseModel.f37016d.f2233b);
        c.a.c0.a0.a.b(clogBuilder);
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
            this.w = pVar;
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

    public void setOnTailJumpHandler(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.p = cVar;
        }
    }

    public void setPlayerProgressHandler(NadVideoAdOverContainer.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
        }
    }

    public void showReplayBtn() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (findViewById = findViewById(e.tail_frame_replay_btn)) == null) {
            return;
        }
        findViewById.setVisibility(0);
    }

    public void showTailFrame(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, adBaseModel) == null) {
            if (!d(adBaseModel)) {
                setVisibility(8);
                return;
            }
            n nVar = adBaseModel.f37020h.f2242c;
            if (nVar != null) {
                c(getContext());
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(getResources().getColor(c.a.c0.d.b.nad_enhancement_btn_bg_color));
                int a2 = f.c.a(getContext(), 8.0f);
                gradientDrawable.setCornerRadius(a2);
                this.t.setBackground(gradientDrawable);
                this.l.setCornerRadius(a2);
                this.l.setBackground(gradientDrawable);
                this.l.setProgressColor(getResources().getColor(c.a.c0.d.b.nad_mini_video_ad_download_progress_color));
                setVisibility(0);
                if (!TextUtils.isEmpty(nVar.f2244b)) {
                    this.f36960e.displayImage(nVar.f2244b);
                    this.f36960e.setVisibility(0);
                } else {
                    this.f36960e.setVisibility(8);
                }
                if (TextUtils.isEmpty(nVar.a)) {
                    this.f36961f.setVisibility(8);
                } else {
                    this.f36961f.setText(nVar.a, TextView.BufferType.NORMAL);
                    this.f36961f.setVisibility(0);
                }
                if (TextUtils.isEmpty(nVar.f2249g)) {
                    this.f36962g.setVisibility(8);
                } else {
                    this.f36962g.setVisibility(0);
                    this.f36962g.setText(nVar.f2249g);
                }
                p pVar = this.w;
                if (pVar != null) {
                    float f2 = (float) pVar.f2269e;
                    if (f2 <= 0.0f) {
                        this.f36964i.setVisibility(8);
                    } else {
                        this.f36964i.setVisibility(0);
                        this.q.setText(String.valueOf(f2));
                        this.f36963h.setRating(f2);
                    }
                } else {
                    this.f36964i.setVisibility(8);
                }
                if (TextUtils.isEmpty(nVar.f2251i)) {
                    this.r.setVisibility(8);
                } else {
                    this.r.setVisibility(0);
                    this.r.setText(nVar.f2251i);
                }
                if (TextUtils.isEmpty(nVar.f2250h)) {
                    this.f36965j.setVisibility(8);
                } else {
                    this.f36965j.setVisibility(0);
                    this.f36965j.setText(nVar.f2250h, TextView.BufferType.NORMAL);
                }
                if (adBaseModel.f37015c && adBaseModel.f37018f.a == AdOperator.TYPE.DOWNLOAD) {
                    this.t.setVisibility(8);
                    c.a.c0.s.c cVar = adBaseModel.f37021i;
                    if (cVar != null && cVar.f2223d) {
                        this.l.setVisibility(0);
                        this.m = new d(c.a.c0.j.d.a.b(adBaseModel), this.l);
                    } else {
                        this.l.setVisibility(8);
                        this.m = null;
                    }
                } else {
                    this.t.setVisibility(0);
                    if (TextUtils.isEmpty(nVar.f2247e)) {
                        this.k.setText(nVar.f2247e);
                    } else {
                        this.k.setText(getResources().getText(h.nad_command_btn_text));
                    }
                    this.u.setImageDrawable(ContextCompat.getDrawable(getContext(), c.a.c0.d.d.nad_mini_video_ad_pop_command));
                    this.l.setVisibility(8);
                    if (this.m != null) {
                        this.m = null;
                    }
                }
                if (!canShowAppInfoLayout(this.w)) {
                    this.x.setVisibility(8);
                } else {
                    Resources resources = getContext().getResources();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.x.getLayoutParams();
                    layoutParams.leftMargin = resources.getDimensionPixelOffset(c.a.c0.d.c.nad_dimen_15dp);
                    layoutParams.rightMargin = resources.getDimensionPixelOffset(c.a.c0.d.c.nad_dimen_15dp);
                    this.x.setLayoutParams(layoutParams);
                    this.x.setAdInfo(this.w);
                    this.x.setVisibility(0);
                    this.x.setAfterListener(new a(this, adBaseModel));
                }
                setMoreButton(adBaseModel);
                e(adBaseModel);
            } else {
                setVisibility(8);
            }
            this.v.displayBlurBackground(adBaseModel.f37020h.f2241b, 1, 5);
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
