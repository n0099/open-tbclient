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
import c.a.a0.h0.f;
import c.a.a0.j.f.d;
import c.a.a0.s.i;
import c.a.a0.s.p;
import c.a.a0.s.r;
import c.a.a0.s.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
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
    public AdImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27483b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27484c;

    /* renamed from: d  reason: collision with root package name */
    public AppCompatRatingBar f27485d;

    /* renamed from: e  reason: collision with root package name */
    public View f27486e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27487f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f27488g;

    /* renamed from: h  reason: collision with root package name */
    public NadMiniVideoDownloadView f27489h;
    public d i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public c l;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public AdImageView q;
    public AdImageView r;
    public t s;
    public SimpleAdInfoView t;
    public LinearLayout u;
    public AdImageView v;
    public TextView w;

    /* loaded from: classes4.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoTailView f27490b;

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
            this.f27490b = portraitVideoTailView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f27490b.i(ClogBuilder.LogType.FREE_CLICK, str, this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f27491b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoTailView f27492c;

        public b(PortraitVideoTailView portraitVideoTailView, r rVar, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoTailView, rVar, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27492c = portraitVideoTailView;
            this.a = rVar;
            this.f27491b = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.a0.g.c.d(this.a.t, this.f27492c.getContext(), null);
                c.a.a0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.FREE_CLICK).n(this.f27491b.f27543f.f1549d).h("morebtn"));
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

    public static boolean b(t tVar) {
        InterceptResult invokeL;
        t.b bVar;
        t.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tVar)) == null) {
            if (tVar == null) {
                return false;
            }
            return (TextUtils.isEmpty(tVar.f1590f) && TextUtils.isEmpty(tVar.f1588d) && ((bVar = tVar.f1591g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = tVar.f1592h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    private void setMoreButton(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, adBaseModel) == null) {
            r rVar = adBaseModel.j.f1560f;
            if (rVar != null && !TextUtils.isEmpty(rVar.r) && !TextUtils.isEmpty(rVar.s)) {
                this.u.setVisibility(0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(f.c.a(getContext(), 17.0f));
                gradientDrawable.setStroke(2, ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f060826));
                this.u.setBackground(gradientDrawable);
                this.u.setOnClickListener(new b(this, rVar, adBaseModel));
                if (!TextUtils.isEmpty(rVar.r)) {
                    this.v.g(rVar.r);
                    this.v.setVisibility(0);
                }
                if (TextUtils.isEmpty(rVar.s)) {
                    return;
                }
                this.w.setText(rVar.s);
                this.w.setVisibility(0);
                return;
            }
            this.u.setVisibility(8);
            this.v.setVisibility(8);
            this.w.setVisibility(8);
        }
    }

    public final void c(AdBaseModel adBaseModel, View view) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, adBaseModel, view) == null) && g(adBaseModel)) {
            String str2 = adBaseModel.j.f1560f.f1564c;
            String str3 = adBaseModel.f27543f.f1548c;
            int id = view.getId();
            if (id == R.id.obfuscated_res_0x7f091ed0) {
                str = "tail_avatar";
            } else if (id == R.id.obfuscated_res_0x7f091eda) {
                str = "tail_name";
            } else if (id == R.id.obfuscated_res_0x7f090680) {
                str2 = adBaseModel.j.f1560f.f1565d;
                str = "button";
            } else {
                str = id == R.id.obfuscated_res_0x7f091edb ? "tail_tag" : id == R.id.obfuscated_res_0x7f0900d2 ? "tail_score" : id == R.id.obfuscated_res_0x7f091ed9 ? "tail_title" : id == R.id.obfuscated_res_0x7f091ed5 ? "tail_popularity" : "hot";
            }
            if ((TextUtils.isEmpty(str2) || "__BTN_SCHEME__".equals(str2)) ? false : true) {
                str3 = str2;
            }
            c.a.a0.g.c.c(str3, getContext());
            i(ClogBuilder.LogType.CLICK, str, adBaseModel);
            c cVar = this.l;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public void d() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (findViewById = findViewById(R.id.obfuscated_res_0x7f091ed7)) == null) {
            return;
        }
        findViewById.setVisibility(8);
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05c6, this);
            setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f06081c));
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            setLayoutParams(layoutParams);
            this.a = (AdImageView) findViewById(R.id.obfuscated_res_0x7f091ed0);
            this.f27483b = (TextView) findViewById(R.id.obfuscated_res_0x7f091eda);
            this.f27484c = (TextView) findViewById(R.id.obfuscated_res_0x7f091edb);
            this.f27486e = findViewById(R.id.obfuscated_res_0x7f0900d2);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091ed8);
            this.f27485d = (AppCompatRatingBar) findViewById(R.id.obfuscated_res_0x7f091ed6);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f091ed5);
            this.f27487f = (TextView) findViewById(R.id.obfuscated_res_0x7f091ed9);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091ed7);
            this.f27488g = (TextView) findViewById(R.id.obfuscated_res_0x7f091ed2);
            this.o = findViewById(R.id.obfuscated_res_0x7f091ed1);
            this.p = findViewById(R.id.obfuscated_res_0x7f090680);
            this.q = (AdImageView) findViewById(R.id.obfuscated_res_0x7f09069e);
            this.r = (AdImageView) findViewById(R.id.obfuscated_res_0x7f0902f0);
            NadMiniVideoDownloadView nadMiniVideoDownloadView = (NadMiniVideoDownloadView) findViewById(R.id.obfuscated_res_0x7f091ed4);
            this.f27489h = nadMiniVideoDownloadView;
            nadMiniVideoDownloadView.setTextSize(12.0f);
            this.f27489h.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06081d));
            int intrinsicHeight = ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080dc4).getIntrinsicHeight();
            ViewGroup.LayoutParams layoutParams2 = this.f27485d.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = intrinsicHeight;
            this.f27485d.setLayoutParams(layoutParams2);
            this.t = (SimpleAdInfoView) findViewById(R.id.obfuscated_res_0x7f090084);
            findViewById.setOnClickListener(this);
            this.a.setOnClickListener(this);
            this.f27483b.setOnClickListener(this);
            this.f27484c.setOnClickListener(this);
            this.f27486e.setOnClickListener(this);
            this.f27487f.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.f27489h.setOnClickListener(this);
            this.u = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09143d);
            this.v = (AdImageView) findViewById(R.id.obfuscated_res_0x7f09143e);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f09143f);
            setOnClickListener(null);
        }
    }

    public final boolean g(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        p pVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, adBaseModel)) == null) ? (adBaseModel == null || adBaseModel.f27543f == null || (pVar = adBaseModel.j) == null || pVar.f1560f == null) ? false : true : invokeL.booleanValue;
    }

    public final void h(AdBaseModel adBaseModel) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, adBaseModel) == null) || adBaseModel == null || (iVar = adBaseModel.f27543f) == null || TextUtils.isEmpty(iVar.f1549d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.s(ClogBuilder.LogType.VIDEO_LP_PV);
        clogBuilder.q(ClogBuilder.Page.PAGE_VIDEO_LANDING);
        clogBuilder.n(adBaseModel.f27543f.f1549d);
        c.a.a0.a0.a.b(clogBuilder);
    }

    public final void i(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, logType, str, adBaseModel) == null) || adBaseModel == null || (iVar = adBaseModel.f27543f) == null || TextUtils.isEmpty(iVar.f1549d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.s(logType);
        clogBuilder.h(str);
        clogBuilder.n(adBaseModel.f27543f.f1549d);
        c.a.a0.a0.a.b(clogBuilder);
    }

    public void j(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) {
            if (!g(adBaseModel)) {
                setVisibility(8);
                return;
            }
            r rVar = adBaseModel.j.f1560f;
            if (rVar != null) {
                f(getContext());
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(getResources().getColor(R.color.obfuscated_res_0x7f060807));
                int a2 = f.c.a(getContext(), 8.0f);
                gradientDrawable.setCornerRadius(a2);
                this.p.setBackground(gradientDrawable);
                this.f27489h.setCornerRadius(a2);
                this.f27489h.setBackground(gradientDrawable);
                this.f27489h.setProgressColor(getResources().getColor(R.color.obfuscated_res_0x7f06081b));
                setVisibility(0);
                if (!TextUtils.isEmpty(rVar.f1563b)) {
                    this.a.g(rVar.f1563b);
                    this.a.setVisibility(0);
                } else {
                    this.a.setVisibility(8);
                }
                if (TextUtils.isEmpty(rVar.a)) {
                    this.f27483b.setVisibility(8);
                } else {
                    this.f27483b.setText(rVar.a, TextView.BufferType.NORMAL);
                    this.f27483b.setVisibility(0);
                }
                if (TextUtils.isEmpty(rVar.f1568g)) {
                    this.f27484c.setVisibility(8);
                } else {
                    this.f27484c.setVisibility(0);
                    this.f27484c.setText(rVar.f1568g);
                }
                t tVar = this.s;
                if (tVar != null) {
                    float f2 = (float) tVar.f1589e;
                    if (f2 <= 0.0f) {
                        this.f27486e.setVisibility(8);
                    } else {
                        this.f27486e.setVisibility(0);
                        this.m.setText(String.valueOf(f2));
                        this.f27485d.setRating(f2);
                    }
                } else {
                    this.f27486e.setVisibility(8);
                }
                if (TextUtils.isEmpty(rVar.i)) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                    this.n.setText(rVar.i);
                }
                if (TextUtils.isEmpty(rVar.f1569h)) {
                    this.f27487f.setVisibility(8);
                } else {
                    this.f27487f.setVisibility(0);
                    this.f27487f.setText(rVar.f1569h, TextView.BufferType.NORMAL);
                }
                if (adBaseModel.f27541d && adBaseModel.f27545h.a == AdOperator.TYPE.DOWNLOAD) {
                    this.p.setVisibility(8);
                    c.a.a0.s.c cVar = adBaseModel.l;
                    if (cVar != null && cVar.f1535e) {
                        this.f27489h.setVisibility(0);
                        this.i = new d(c.a.a0.j.d.a.b(adBaseModel), this.f27489h);
                    } else {
                        this.f27489h.setVisibility(8);
                        this.i = null;
                    }
                } else {
                    this.p.setVisibility(0);
                    if (TextUtils.isEmpty(rVar.f1566e)) {
                        this.f27488g.setText(rVar.f1566e);
                    } else {
                        this.f27488g.setText(getResources().getText(R.string.obfuscated_res_0x7f0f0b57));
                    }
                    this.q.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080db8));
                    this.f27489h.setVisibility(8);
                    if (this.i != null) {
                        this.i = null;
                    }
                }
                if (!b(this.s)) {
                    this.t.setVisibility(8);
                } else {
                    Resources resources = getContext().getResources();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.t.getLayoutParams();
                    layoutParams.leftMargin = resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704d1);
                    layoutParams.rightMargin = resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704d1);
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
            this.r.f(adBaseModel.j.f1557c, 1, 5);
            setTag(adBaseModel);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (view.getId() == R.id.obfuscated_res_0x7f091ed7) {
                View.OnClickListener onClickListener = this.j;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            } else if (view.getId() == R.id.obfuscated_res_0x7f091ed4) {
                d dVar = this.i;
                if (dVar != null) {
                    dVar.p();
                }
            } else {
                c(adBaseModel, view);
                this.k.onClick(view);
            }
        }
    }

    public void setAdInfo(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tVar) == null) {
            this.s = tVar;
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

    public void setPlayerProgressHandler(NadVideoAdOverContainer.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
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
}
