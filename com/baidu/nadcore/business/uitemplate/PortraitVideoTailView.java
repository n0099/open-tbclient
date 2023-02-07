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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.ar0;
import com.baidu.tieba.b51;
import com.baidu.tieba.cl0;
import com.baidu.tieba.cr0;
import com.baidu.tieba.er0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.n21;
import com.baidu.tieba.pl0;
import com.baidu.tieba.tq0;
import com.baidu.tieba.wi0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PortraitVideoTailView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdImageView a;
    public TextView b;
    public TextView c;
    public AppCompatRatingBar d;
    public View e;
    public TextView f;
    public TextView g;
    public NadMiniVideoDownloadView h;
    public pl0 i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public c l;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public AdImageView q;
    public AdImageView r;
    public er0 s;
    public SimpleAdInfoView t;
    public LinearLayout u;
    public AdImageView v;
    public TextView w;

    /* loaded from: classes2.dex */
    public interface c {
        void a();
    }

    public void setPlayerProgressHandler(NadVideoAdOverContainer.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ PortraitVideoTailView b;

        public a(PortraitVideoTailView portraitVideoTailView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoTailView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = portraitVideoTailView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.b.i(ClogBuilder.LogType.FREE_CLICK, str, this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr0 a;
        public final /* synthetic */ AdBaseModel b;
        public final /* synthetic */ PortraitVideoTailView c;

        public b(PortraitVideoTailView portraitVideoTailView, cr0 cr0Var, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoTailView, cr0Var, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = portraitVideoTailView;
            this.a = cr0Var;
            this.b = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                wi0.d(this.a.y, this.c.getContext(), null);
                n21.b(new ClogBuilder().y(ClogBuilder.LogType.FREE_CLICK).p(this.b.f.d).j("morebtn"));
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean b(er0 er0Var) {
        InterceptResult invokeL;
        er0.b bVar;
        er0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, er0Var)) == null) {
            if (er0Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(er0Var.f) && TextUtils.isEmpty(er0Var.d) && (((bVar = er0Var.g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = er0Var.h) == null || TextUtils.isEmpty(aVar.a)))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void h(AdBaseModel adBaseModel) {
        tq0 tq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, adBaseModel) == null) && adBaseModel != null && (tq0Var = adBaseModel.f) != null && !TextUtils.isEmpty(tq0Var.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.VIDEO_LP_PV);
            clogBuilder.u(ClogBuilder.Page.PAGE_VIDEO_LANDING);
            clogBuilder.p(adBaseModel.f.d);
            n21.b(clogBuilder);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (view2.getId() == R.id.tail_frame_replay_btn) {
                View.OnClickListener onClickListener = this.j;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
            } else if (view2.getId() == R.id.tail_frame_download_btn_txt) {
                pl0 pl0Var = this.i;
                if (pl0Var != null) {
                    pl0Var.m();
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortraitVideoTailView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortraitVideoTailView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private void setMoreButton(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, adBaseModel) == null) {
            cr0 cr0Var = adBaseModel.j.h;
            if (cr0Var != null && !TextUtils.isEmpty(cr0Var.w) && !TextUtils.isEmpty(cr0Var.x)) {
                this.u.setVisibility(0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(b51.c.a(getContext(), 17.0f));
                gradientDrawable.setStroke(2, ContextCompat.getColor(getContext(), R.color.nad_portrait_tail_frame_more_btn_border));
                this.u.setBackground(gradientDrawable);
                this.u.setOnClickListener(new b(this, cr0Var, adBaseModel));
                if (!TextUtils.isEmpty(cr0Var.w)) {
                    this.v.g(cr0Var.w);
                    this.v.setVisibility(0);
                }
                if (!TextUtils.isEmpty(cr0Var.x)) {
                    this.w.setText(cr0Var.x);
                    this.w.setVisibility(0);
                    return;
                }
                return;
            }
            this.u.setVisibility(8);
            this.v.setVisibility(8);
            this.w.setVisibility(8);
        }
    }

    public final void c(AdBaseModel adBaseModel, View view2) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, adBaseModel, view2) != null) || !g(adBaseModel)) {
            return;
        }
        String str2 = adBaseModel.j.h.e;
        String str3 = adBaseModel.f.c;
        int id = view2.getId();
        if (id == R.id.tail_frame_author_avatar) {
            str = "tail_avatar";
        } else if (id == R.id.tail_frame_title) {
            str = "tail_name";
        } else if (id == R.id.command_layout) {
            str2 = adBaseModel.j.h.f;
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
        wi0.c(str3, getContext());
        i(ClogBuilder.LogType.CLICK, str, adBaseModel);
        c cVar = this.l;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        View findViewById;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (findViewById = findViewById(R.id.tail_frame_replay_btn)) != null) {
            findViewById.setVisibility(8);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(8);
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
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
    }

    public final boolean g(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        ar0 ar0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, adBaseModel)) == null) {
            if (adBaseModel != null && adBaseModel.f != null && (ar0Var = adBaseModel.j) != null && ar0Var.h != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAdInfo(er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, er0Var) == null) {
            this.s = er0Var;
        }
    }

    public void setOnAdClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.k = onClickListener;
        }
    }

    public void setOnReplayClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }

    public void setOnTailJumpHandler(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.l = cVar;
        }
    }

    public final void i(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        tq0 tq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, logType, str, adBaseModel) == null) && adBaseModel != null && (tq0Var = adBaseModel.f) != null && !TextUtils.isEmpty(tq0Var.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.j(str);
            clogBuilder.p(adBaseModel.f.d);
            n21.b(clogBuilder);
        }
    }

    public void j(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) {
            if (!g(adBaseModel)) {
                setVisibility(8);
                return;
            }
            cr0 cr0Var = adBaseModel.j.h;
            if (cr0Var != null) {
                f(getContext());
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(getResources().getColor(R.color.nad_enhancement_btn_bg_color));
                int a2 = b51.c.a(getContext(), 8.0f);
                gradientDrawable.setCornerRadius(a2);
                this.p.setBackground(gradientDrawable);
                this.h.setCornerRadius(a2);
                this.h.setBackground(gradientDrawable);
                this.h.setProgressColor(getResources().getColor(R.color.nad_mini_video_ad_download_progress_color));
                setVisibility(0);
                if (!TextUtils.isEmpty(cr0Var.d)) {
                    this.a.g(cr0Var.d);
                    this.a.setVisibility(0);
                } else {
                    this.a.setVisibility(8);
                }
                if (TextUtils.isEmpty(cr0Var.c)) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setText(cr0Var.c, TextView.BufferType.NORMAL);
                    this.b.setVisibility(0);
                }
                if (TextUtils.isEmpty(cr0Var.k)) {
                    this.c.setVisibility(8);
                } else {
                    this.c.setVisibility(0);
                    this.c.setText(cr0Var.k);
                }
                er0 er0Var = this.s;
                if (er0Var != null) {
                    float f = (float) er0Var.e;
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
                if (TextUtils.isEmpty(cr0Var.n)) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                    this.n.setText(cr0Var.n);
                }
                if (TextUtils.isEmpty(cr0Var.l)) {
                    this.f.setVisibility(8);
                } else {
                    this.f.setVisibility(0);
                    this.f.setText(cr0Var.l, TextView.BufferType.NORMAL);
                }
                if (adBaseModel.d && adBaseModel.h.a == AdOperator.TYPE.DOWNLOAD) {
                    this.p.setVisibility(8);
                    lq0 lq0Var = adBaseModel.l;
                    if (lq0Var != null && lq0Var.e) {
                        this.h.setVisibility(0);
                        this.i = new pl0(cl0.c(adBaseModel), this.h);
                    } else {
                        this.h.setVisibility(8);
                        this.i = null;
                    }
                } else {
                    this.p.setVisibility(0);
                    if (TextUtils.isEmpty(cr0Var.g)) {
                        this.g.setText(cr0Var.g);
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
                    this.t.setAfterListener(new a(this, adBaseModel));
                }
                setMoreButton(adBaseModel);
                h(adBaseModel);
            } else {
                setVisibility(8);
            }
            this.r.f(adBaseModel.j.d, 1, 5);
            setTag(adBaseModel);
        }
    }
}
