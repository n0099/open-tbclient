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
import c.a.d0.d.e;
import c.a.d0.d.g;
import c.a.d0.d.h;
import c.a.d0.h0.f;
import c.a.d0.j.f.d;
import c.a.d0.s.i;
import c.a.d0.s.p;
import c.a.d0.s.r;
import c.a.d0.s.t;
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
    public AdImageView f37200e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37201f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f37202g;

    /* renamed from: h  reason: collision with root package name */
    public AppCompatRatingBar f37203h;

    /* renamed from: i  reason: collision with root package name */
    public View f37204i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f37205j;
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
    public t w;
    public SimpleAdInfoView x;
    public LinearLayout y;
    public AdImageView z;

    /* loaded from: classes10.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoTailView f37206b;

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
            this.f37206b = portraitVideoTailView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f37206b.f(ClogBuilder.LogType.FREE_CLICK, str, this.a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f37207e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f37208f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoTailView f37209g;

        public b(PortraitVideoTailView portraitVideoTailView, r rVar, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoTailView, rVar, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37209g = portraitVideoTailView;
            this.f37207e = rVar;
            this.f37208f = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d0.f.d.d(this.f37207e.t, this.f37209g.getContext(), null);
                c.a.d0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.FREE_CLICK).n(this.f37208f.f37258f.f3093d).h("morebtn"));
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

    public static boolean canShowAppInfoLayout(t tVar) {
        InterceptResult invokeL;
        t.b bVar;
        t.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tVar)) == null) {
            if (tVar == null) {
                return false;
            }
            return (TextUtils.isEmpty(tVar.f3141f) && TextUtils.isEmpty(tVar.f3139d) && ((bVar = tVar.f3142g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = tVar.f3143h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    private void setMoreButton(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, adBaseModel) == null) {
            r rVar = adBaseModel.f37262j.f3106f;
            if (rVar != null && !TextUtils.isEmpty(rVar.r) && !TextUtils.isEmpty(rVar.s)) {
                this.y.setVisibility(0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(f.c.a(getContext(), 17.0f));
                gradientDrawable.setStroke(2, ContextCompat.getColor(getContext(), c.a.d0.d.b.nad_portrait_tail_frame_more_btn_border));
                this.y.setBackground(gradientDrawable);
                this.y.setOnClickListener(new b(this, rVar, adBaseModel));
                if (!TextUtils.isEmpty(rVar.r)) {
                    this.z.displayImage(rVar.r);
                    this.z.setVisibility(0);
                }
                if (TextUtils.isEmpty(rVar.s)) {
                    return;
                }
                this.A.setText(rVar.s);
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
            String str2 = adBaseModel.f37262j.f3106f.f3110c;
            String str3 = adBaseModel.f37258f.f3092c;
            int id = view.getId();
            if (id == e.tail_frame_author_avatar) {
                str = "tail_avatar";
            } else if (id == e.tail_frame_title) {
                str = "tail_name";
            } else if (id == e.command_layout) {
                str2 = adBaseModel.f37262j.f3106f.f3111d;
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
            c.a.d0.f.d.c(str3, getContext());
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
            setBackgroundColor(getResources().getColor(c.a.d0.d.b.nad_mini_video_ad_tail_frame_bg_color));
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            setLayoutParams(layoutParams);
            this.f37200e = (AdImageView) findViewById(e.tail_frame_author_avatar);
            this.f37201f = (TextView) findViewById(e.tail_frame_title);
            this.f37202g = (TextView) findViewById(e.tail_frame_trade);
            this.f37204i = findViewById(e.ad_mini_video_detail_rating_bar_root_view);
            this.q = (TextView) findViewById(e.tail_frame_scope);
            this.f37203h = (AppCompatRatingBar) findViewById(e.tail_frame_rating_bar);
            this.r = (TextView) findViewById(e.tail_frame_popular_text);
            this.f37205j = (TextView) findViewById(e.tail_frame_sub_title);
            View findViewById = findViewById(e.tail_frame_replay_btn);
            this.k = (TextView) findViewById(e.tail_frame_check_btn_txt);
            this.s = findViewById(e.tail_frame_btn_container);
            this.t = findViewById(e.command_layout);
            this.u = (AdImageView) findViewById(e.common_btn_icon);
            this.v = (AdImageView) findViewById(e.back_blur_img);
            NadMiniVideoDownloadView nadMiniVideoDownloadView = (NadMiniVideoDownloadView) findViewById(e.tail_frame_download_btn_txt);
            this.l = nadMiniVideoDownloadView;
            nadMiniVideoDownloadView.setTextSize(12.0f);
            this.l.setTextColor(getResources().getColor(c.a.d0.d.b.nad_mini_video_ad_tail_frame_download_text_color));
            int intrinsicHeight = ContextCompat.getDrawable(getContext(), c.a.d0.d.d.nad_mini_video_tail_star).getIntrinsicHeight();
            ViewGroup.LayoutParams layoutParams2 = this.f37203h.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = intrinsicHeight;
            this.f37203h.setLayoutParams(layoutParams2);
            this.x = (SimpleAdInfoView) findViewById(e.ad_app_info_view);
            findViewById.setOnClickListener(this);
            this.f37200e.setOnClickListener(this);
            this.f37201f.setOnClickListener(this);
            this.f37202g.setOnClickListener(this);
            this.f37204i.setOnClickListener(this);
            this.f37205j.setOnClickListener(this);
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
        p pVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel)) == null) ? (adBaseModel == null || adBaseModel.f37258f == null || (pVar = adBaseModel.f37262j) == null || pVar.f3106f == null) ? false : true : invokeL.booleanValue;
    }

    public final void e(AdBaseModel adBaseModel) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || adBaseModel == null || (iVar = adBaseModel.f37258f) == null || TextUtils.isEmpty(iVar.f3093d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.s(ClogBuilder.LogType.VIDEO_LP_PV);
        clogBuilder.q(ClogBuilder.Page.PAGE_VIDEO_LANDING);
        clogBuilder.n(adBaseModel.f37258f.f3093d);
        c.a.d0.a0.a.b(clogBuilder);
    }

    public final void f(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, logType, str, adBaseModel) == null) || adBaseModel == null || (iVar = adBaseModel.f37258f) == null || TextUtils.isEmpty(iVar.f3093d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.s(logType);
        clogBuilder.h(str);
        clogBuilder.n(adBaseModel.f37258f.f3093d);
        c.a.d0.a0.a.b(clogBuilder);
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

    public void setAdInfo(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tVar) == null) {
            this.w = tVar;
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
            r rVar = adBaseModel.f37262j.f3106f;
            if (rVar != null) {
                c(getContext());
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(getResources().getColor(c.a.d0.d.b.nad_enhancement_btn_bg_color));
                int a2 = f.c.a(getContext(), 8.0f);
                gradientDrawable.setCornerRadius(a2);
                this.t.setBackground(gradientDrawable);
                this.l.setCornerRadius(a2);
                this.l.setBackground(gradientDrawable);
                this.l.setProgressColor(getResources().getColor(c.a.d0.d.b.nad_mini_video_ad_download_progress_color));
                setVisibility(0);
                if (!TextUtils.isEmpty(rVar.f3109b)) {
                    this.f37200e.displayImage(rVar.f3109b);
                    this.f37200e.setVisibility(0);
                } else {
                    this.f37200e.setVisibility(8);
                }
                if (TextUtils.isEmpty(rVar.a)) {
                    this.f37201f.setVisibility(8);
                } else {
                    this.f37201f.setText(rVar.a, TextView.BufferType.NORMAL);
                    this.f37201f.setVisibility(0);
                }
                if (TextUtils.isEmpty(rVar.f3114g)) {
                    this.f37202g.setVisibility(8);
                } else {
                    this.f37202g.setVisibility(0);
                    this.f37202g.setText(rVar.f3114g);
                }
                t tVar = this.w;
                if (tVar != null) {
                    float f2 = (float) tVar.f3140e;
                    if (f2 <= 0.0f) {
                        this.f37204i.setVisibility(8);
                    } else {
                        this.f37204i.setVisibility(0);
                        this.q.setText(String.valueOf(f2));
                        this.f37203h.setRating(f2);
                    }
                } else {
                    this.f37204i.setVisibility(8);
                }
                if (TextUtils.isEmpty(rVar.f3116i)) {
                    this.r.setVisibility(8);
                } else {
                    this.r.setVisibility(0);
                    this.r.setText(rVar.f3116i);
                }
                if (TextUtils.isEmpty(rVar.f3115h)) {
                    this.f37205j.setVisibility(8);
                } else {
                    this.f37205j.setVisibility(0);
                    this.f37205j.setText(rVar.f3115h, TextView.BufferType.NORMAL);
                }
                if (adBaseModel.f37256d && adBaseModel.f37260h.a == AdOperator.TYPE.DOWNLOAD) {
                    this.t.setVisibility(8);
                    c.a.d0.s.c cVar = adBaseModel.l;
                    if (cVar != null && cVar.f3078e) {
                        this.l.setVisibility(0);
                        this.m = new d(c.a.d0.j.d.a.b(adBaseModel), this.l);
                    } else {
                        this.l.setVisibility(8);
                        this.m = null;
                    }
                } else {
                    this.t.setVisibility(0);
                    if (TextUtils.isEmpty(rVar.f3112e)) {
                        this.k.setText(rVar.f3112e);
                    } else {
                        this.k.setText(getResources().getText(h.nad_command_btn_text));
                    }
                    this.u.setImageDrawable(ContextCompat.getDrawable(getContext(), c.a.d0.d.d.nad_mini_video_ad_pop_command));
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
                    layoutParams.leftMargin = resources.getDimensionPixelOffset(c.a.d0.d.c.nad_dimen_15dp);
                    layoutParams.rightMargin = resources.getDimensionPixelOffset(c.a.d0.d.c.nad_dimen_15dp);
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
            this.v.displayBlurBackground(adBaseModel.f37262j.f3103c, 1, 5);
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
