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
import c.a.b0.h0.f;
import c.a.b0.j.f.d;
import c.a.b0.s.i;
import c.a.b0.s.p;
import c.a.b0.s.r;
import c.a.b0.s.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PortraitVideoTailView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;

    /* renamed from: e  reason: collision with root package name */
    public AdImageView f35603e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35604f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35605g;

    /* renamed from: h  reason: collision with root package name */
    public AppCompatRatingBar f35606h;

    /* renamed from: i  reason: collision with root package name */
    public View f35607i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f35608j;
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

    /* loaded from: classes4.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoTailView f35609b;

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
            this.f35609b = portraitVideoTailView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f35609b.f(ClogBuilder.LogType.FREE_CLICK, str, this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f35610e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f35611f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoTailView f35612g;

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
            this.f35612g = portraitVideoTailView;
            this.f35610e = rVar;
            this.f35611f = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.b0.f.c.d(this.f35610e.t, this.f35612g.getContext(), null);
                c.a.b0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.FREE_CLICK).n(this.f35611f.f35661f.f1923d).h("morebtn"));
            }
        }
    }

    /* loaded from: classes4.dex */
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
            return (TextUtils.isEmpty(tVar.f1971f) && TextUtils.isEmpty(tVar.f1969d) && ((bVar = tVar.f1972g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = tVar.f1973h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    private void setMoreButton(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, adBaseModel) == null) {
            r rVar = adBaseModel.f35665j.f1936f;
            if (rVar != null && !TextUtils.isEmpty(rVar.r) && !TextUtils.isEmpty(rVar.s)) {
                this.y.setVisibility(0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(f.c.a(getContext(), 17.0f));
                gradientDrawable.setStroke(2, ContextCompat.getColor(getContext(), R.color.nad_portrait_tail_frame_more_btn_border));
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
            String str2 = adBaseModel.f35665j.f1936f.f1940c;
            String str3 = adBaseModel.f35661f.f1922c;
            int id = view.getId();
            if (id == R.id.tail_frame_author_avatar) {
                str = "tail_avatar";
            } else if (id == R.id.tail_frame_title) {
                str = "tail_name";
            } else if (id == R.id.command_layout) {
                str2 = adBaseModel.f35665j.f1936f.f1941d;
                str = "button";
            } else {
                str = id == R.id.tail_frame_trade ? "tail_tag" : id == R.id.ad_mini_video_detail_rating_bar_root_view ? "tail_score" : id == R.id.tail_frame_sub_title ? "tail_title" : id == R.id.tail_frame_popular_text ? "tail_popularity" : ThreadAchievementShareDialogView.HOT_LIST_VIEW_TYPE;
            }
            if ((TextUtils.isEmpty(str2) || "__BTN_SCHEME__".equals(str2)) ? false : true) {
                str3 = str2;
            }
            c.a.b0.f.c.c(str3, getContext());
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
            LayoutInflater.from(context).inflate(R.layout.nad_portrait_video_tail_view, this);
            setBackgroundColor(getResources().getColor(R.color.nad_mini_video_ad_tail_frame_bg_color));
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            setLayoutParams(layoutParams);
            this.f35603e = (AdImageView) findViewById(R.id.tail_frame_author_avatar);
            this.f35604f = (TextView) findViewById(R.id.tail_frame_title);
            this.f35605g = (TextView) findViewById(R.id.tail_frame_trade);
            this.f35607i = findViewById(R.id.ad_mini_video_detail_rating_bar_root_view);
            this.q = (TextView) findViewById(R.id.tail_frame_scope);
            this.f35606h = (AppCompatRatingBar) findViewById(R.id.tail_frame_rating_bar);
            this.r = (TextView) findViewById(R.id.tail_frame_popular_text);
            this.f35608j = (TextView) findViewById(R.id.tail_frame_sub_title);
            View findViewById = findViewById(R.id.tail_frame_replay_btn);
            this.k = (TextView) findViewById(R.id.tail_frame_check_btn_txt);
            this.s = findViewById(R.id.tail_frame_btn_container);
            this.t = findViewById(R.id.command_layout);
            this.u = (AdImageView) findViewById(R.id.common_btn_icon);
            this.v = (AdImageView) findViewById(R.id.back_blur_img);
            NadMiniVideoDownloadView nadMiniVideoDownloadView = (NadMiniVideoDownloadView) findViewById(R.id.tail_frame_download_btn_txt);
            this.l = nadMiniVideoDownloadView;
            nadMiniVideoDownloadView.setTextSize(12.0f);
            this.l.setTextColor(getResources().getColor(R.color.nad_mini_video_ad_tail_frame_download_text_color));
            int intrinsicHeight = ContextCompat.getDrawable(getContext(), R.drawable.nad_mini_video_tail_star).getIntrinsicHeight();
            ViewGroup.LayoutParams layoutParams2 = this.f35606h.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = intrinsicHeight;
            this.f35606h.setLayoutParams(layoutParams2);
            this.x = (SimpleAdInfoView) findViewById(R.id.ad_app_info_view);
            findViewById.setOnClickListener(this);
            this.f35603e.setOnClickListener(this);
            this.f35604f.setOnClickListener(this);
            this.f35605g.setOnClickListener(this);
            this.f35607i.setOnClickListener(this);
            this.f35608j.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.y = (LinearLayout) findViewById(R.id.more_btn_container);
            this.z = (AdImageView) findViewById(R.id.more_btn_icon);
            this.A = (TextView) findViewById(R.id.more_btn_text);
            setOnClickListener(null);
        }
    }

    public final boolean d(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        p pVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel)) == null) ? (adBaseModel == null || adBaseModel.f35661f == null || (pVar = adBaseModel.f35665j) == null || pVar.f1936f == null) ? false : true : invokeL.booleanValue;
    }

    public final void e(AdBaseModel adBaseModel) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || adBaseModel == null || (iVar = adBaseModel.f35661f) == null || TextUtils.isEmpty(iVar.f1923d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.s(ClogBuilder.LogType.VIDEO_LP_PV);
        clogBuilder.q(ClogBuilder.Page.PAGE_VIDEO_LANDING);
        clogBuilder.n(adBaseModel.f35661f.f1923d);
        c.a.b0.a0.a.b(clogBuilder);
    }

    public final void f(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, logType, str, adBaseModel) == null) || adBaseModel == null || (iVar = adBaseModel.f35661f) == null || TextUtils.isEmpty(iVar.f1923d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.s(logType);
        clogBuilder.h(str);
        clogBuilder.n(adBaseModel.f35661f.f1923d);
        c.a.b0.a0.a.b(clogBuilder);
    }

    public void hideReplayBtn() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (findViewById = findViewById(R.id.tail_frame_replay_btn)) == null) {
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
            if (view.getId() == R.id.tail_frame_replay_btn) {
                View.OnClickListener onClickListener = this.n;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            } else if (view.getId() == R.id.tail_frame_download_btn_txt) {
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (findViewById = findViewById(R.id.tail_frame_replay_btn)) == null) {
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
            r rVar = adBaseModel.f35665j.f1936f;
            if (rVar != null) {
                c(getContext());
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(getResources().getColor(R.color.nad_enhancement_btn_bg_color));
                int a2 = f.c.a(getContext(), 8.0f);
                gradientDrawable.setCornerRadius(a2);
                this.t.setBackground(gradientDrawable);
                this.l.setCornerRadius(a2);
                this.l.setBackground(gradientDrawable);
                this.l.setProgressColor(getResources().getColor(R.color.nad_mini_video_ad_download_progress_color));
                setVisibility(0);
                if (!TextUtils.isEmpty(rVar.f1939b)) {
                    this.f35603e.displayImage(rVar.f1939b);
                    this.f35603e.setVisibility(0);
                } else {
                    this.f35603e.setVisibility(8);
                }
                if (TextUtils.isEmpty(rVar.a)) {
                    this.f35604f.setVisibility(8);
                } else {
                    this.f35604f.setText(rVar.a, TextView.BufferType.NORMAL);
                    this.f35604f.setVisibility(0);
                }
                if (TextUtils.isEmpty(rVar.f1944g)) {
                    this.f35605g.setVisibility(8);
                } else {
                    this.f35605g.setVisibility(0);
                    this.f35605g.setText(rVar.f1944g);
                }
                t tVar = this.w;
                if (tVar != null) {
                    float f2 = (float) tVar.f1970e;
                    if (f2 <= 0.0f) {
                        this.f35607i.setVisibility(8);
                    } else {
                        this.f35607i.setVisibility(0);
                        this.q.setText(String.valueOf(f2));
                        this.f35606h.setRating(f2);
                    }
                } else {
                    this.f35607i.setVisibility(8);
                }
                if (TextUtils.isEmpty(rVar.f1946i)) {
                    this.r.setVisibility(8);
                } else {
                    this.r.setVisibility(0);
                    this.r.setText(rVar.f1946i);
                }
                if (TextUtils.isEmpty(rVar.f1945h)) {
                    this.f35608j.setVisibility(8);
                } else {
                    this.f35608j.setVisibility(0);
                    this.f35608j.setText(rVar.f1945h, TextView.BufferType.NORMAL);
                }
                if (adBaseModel.f35659d && adBaseModel.f35663h.a == AdOperator.TYPE.DOWNLOAD) {
                    this.t.setVisibility(8);
                    c.a.b0.s.c cVar = adBaseModel.l;
                    if (cVar != null && cVar.f1908e) {
                        this.l.setVisibility(0);
                        this.m = new d(c.a.b0.j.d.a.b(adBaseModel), this.l);
                    } else {
                        this.l.setVisibility(8);
                        this.m = null;
                    }
                } else {
                    this.t.setVisibility(0);
                    if (TextUtils.isEmpty(rVar.f1942e)) {
                        this.k.setText(rVar.f1942e);
                    } else {
                        this.k.setText(getResources().getText(R.string.nad_command_btn_text));
                    }
                    this.u.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.nad_mini_video_ad_pop_command));
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
                    layoutParams.leftMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
                    layoutParams.rightMargin = resources.getDimensionPixelOffset(R.dimen.nad_dimen_15dp);
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
            this.v.displayBlurBackground(adBaseModel.f35665j.f1933c, 1, 5);
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
