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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bo0;
import com.repackage.ck0;
import com.repackage.ez0;
import com.repackage.io0;
import com.repackage.ko0;
import com.repackage.m11;
import com.repackage.mo0;
import com.repackage.rj0;
import com.repackage.th0;
import com.repackage.tn0;
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
    public ck0 i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public c l;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public AdImageView q;
    public AdImageView r;
    public mo0 s;
    public SimpleAdInfoView t;
    public LinearLayout u;
    public AdImageView v;
    public TextView w;

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
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.i(ClogBuilder.LogType.FREE_CLICK, str, this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ko0 a;
        public final /* synthetic */ AdBaseModel b;
        public final /* synthetic */ PortraitVideoTailView c;

        public b(PortraitVideoTailView portraitVideoTailView, ko0 ko0Var, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoTailView, ko0Var, adBaseModel};
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
            this.a = ko0Var;
            this.b = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                th0.d(this.a.t, this.c.getContext(), null);
                ez0.c(new ClogBuilder().w(ClogBuilder.LogType.FREE_CLICK).n(this.b.f.d).h("morebtn"));
            }
        }
    }

    /* loaded from: classes2.dex */
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

    public static boolean b(mo0 mo0Var) {
        InterceptResult invokeL;
        mo0.b bVar;
        mo0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mo0Var)) == null) {
            if (mo0Var == null) {
                return false;
            }
            return (TextUtils.isEmpty(mo0Var.f) && TextUtils.isEmpty(mo0Var.d) && ((bVar = mo0Var.g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = mo0Var.h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    private void setMoreButton(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, adBaseModel) == null) {
            ko0 ko0Var = adBaseModel.j.f;
            if (ko0Var != null && !TextUtils.isEmpty(ko0Var.r) && !TextUtils.isEmpty(ko0Var.s)) {
                this.u.setVisibility(0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(m11.c.a(getContext(), 17.0f));
                gradientDrawable.setStroke(2, ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f06083e));
                this.u.setBackground(gradientDrawable);
                this.u.setOnClickListener(new b(this, ko0Var, adBaseModel));
                if (!TextUtils.isEmpty(ko0Var.r)) {
                    this.v.n(ko0Var.r);
                    this.v.setVisibility(0);
                }
                if (TextUtils.isEmpty(ko0Var.s)) {
                    return;
                }
                this.w.setText(ko0Var.s);
                this.w.setVisibility(0);
                return;
            }
            this.u.setVisibility(8);
            this.v.setVisibility(8);
            this.w.setVisibility(8);
        }
    }

    public final void c(AdBaseModel adBaseModel, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, adBaseModel, view2) == null) && g(adBaseModel)) {
            String str2 = adBaseModel.j.f.c;
            String str3 = adBaseModel.f.c;
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091f15) {
                str = "tail_avatar";
            } else if (id == R.id.obfuscated_res_0x7f091f1f) {
                str = "tail_name";
            } else if (id == R.id.obfuscated_res_0x7f090685) {
                str2 = adBaseModel.j.f.d;
                str = NativeConstants.ID_BUTTON;
            } else {
                str = id == R.id.obfuscated_res_0x7f091f20 ? "tail_tag" : id == R.id.obfuscated_res_0x7f0900d1 ? "tail_score" : id == R.id.obfuscated_res_0x7f091f1e ? "tail_title" : id == R.id.obfuscated_res_0x7f091f1a ? "tail_popularity" : "hot";
            }
            if ((TextUtils.isEmpty(str2) || "__BTN_SCHEME__".equals(str2)) ? false : true) {
                str3 = str2;
            }
            th0.c(str3, getContext());
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (findViewById = findViewById(R.id.obfuscated_res_0x7f091f1c)) == null) {
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05bb, this);
            setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060834));
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            setLayoutParams(layoutParams);
            this.a = (AdImageView) findViewById(R.id.obfuscated_res_0x7f091f15);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091f1f);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091f20);
            this.e = findViewById(R.id.obfuscated_res_0x7f0900d1);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091f1d);
            this.d = (AppCompatRatingBar) findViewById(R.id.obfuscated_res_0x7f091f1b);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f091f1a);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091f1e);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091f1c);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091f17);
            this.o = findViewById(R.id.obfuscated_res_0x7f091f16);
            this.p = findViewById(R.id.obfuscated_res_0x7f090685);
            this.q = (AdImageView) findViewById(R.id.obfuscated_res_0x7f0906a2);
            this.r = (AdImageView) findViewById(R.id.obfuscated_res_0x7f0902f4);
            NadMiniVideoDownloadView nadMiniVideoDownloadView = (NadMiniVideoDownloadView) findViewById(R.id.obfuscated_res_0x7f091f19);
            this.h = nadMiniVideoDownloadView;
            nadMiniVideoDownloadView.setTextSize(12.0f);
            this.h.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060835));
            int intrinsicHeight = ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080dea).getIntrinsicHeight();
            ViewGroup.LayoutParams layoutParams2 = this.d.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = intrinsicHeight;
            this.d.setLayoutParams(layoutParams2);
            this.t = (SimpleAdInfoView) findViewById(R.id.obfuscated_res_0x7f090083);
            findViewById.setOnClickListener(this);
            this.a.setOnClickListener(this);
            this.b.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.h.setOnClickListener(this);
            this.u = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09144e);
            this.v = (AdImageView) findViewById(R.id.obfuscated_res_0x7f09144f);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f091450);
            setOnClickListener(null);
        }
    }

    public final boolean g(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        io0 io0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, adBaseModel)) == null) ? (adBaseModel == null || adBaseModel.f == null || (io0Var = adBaseModel.j) == null || io0Var.f == null) ? false : true : invokeL.booleanValue;
    }

    public final void h(AdBaseModel adBaseModel) {
        bo0 bo0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, adBaseModel) == null) || adBaseModel == null || (bo0Var = adBaseModel.f) == null || TextUtils.isEmpty(bo0Var.d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(ClogBuilder.LogType.VIDEO_LP_PV);
        clogBuilder.s(ClogBuilder.Page.PAGE_VIDEO_LANDING);
        clogBuilder.n(adBaseModel.f.d);
        ez0.c(clogBuilder);
    }

    public final void i(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        bo0 bo0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, logType, str, adBaseModel) == null) || adBaseModel == null || (bo0Var = adBaseModel.f) == null || TextUtils.isEmpty(bo0Var.d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(logType);
        clogBuilder.h(str);
        clogBuilder.n(adBaseModel.f.d);
        ez0.c(clogBuilder);
    }

    public void j(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) {
            if (!g(adBaseModel)) {
                setVisibility(8);
                return;
            }
            ko0 ko0Var = adBaseModel.j.f;
            if (ko0Var != null) {
                f(getContext());
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(getResources().getColor(R.color.obfuscated_res_0x7f06081a));
                int a2 = m11.c.a(getContext(), 8.0f);
                gradientDrawable.setCornerRadius(a2);
                this.p.setBackground(gradientDrawable);
                this.h.setCornerRadius(a2);
                this.h.setBackground(gradientDrawable);
                this.h.setProgressColor(getResources().getColor(R.color.obfuscated_res_0x7f060833));
                setVisibility(0);
                if (!TextUtils.isEmpty(ko0Var.b)) {
                    this.a.n(ko0Var.b);
                    this.a.setVisibility(0);
                } else {
                    this.a.setVisibility(8);
                }
                if (TextUtils.isEmpty(ko0Var.a)) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setText(ko0Var.a, TextView.BufferType.NORMAL);
                    this.b.setVisibility(0);
                }
                if (TextUtils.isEmpty(ko0Var.g)) {
                    this.c.setVisibility(8);
                } else {
                    this.c.setVisibility(0);
                    this.c.setText(ko0Var.g);
                }
                mo0 mo0Var = this.s;
                if (mo0Var != null) {
                    float f = (float) mo0Var.e;
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
                if (TextUtils.isEmpty(ko0Var.i)) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                    this.n.setText(ko0Var.i);
                }
                if (TextUtils.isEmpty(ko0Var.h)) {
                    this.f.setVisibility(8);
                } else {
                    this.f.setVisibility(0);
                    this.f.setText(ko0Var.h, TextView.BufferType.NORMAL);
                }
                if (adBaseModel.d && adBaseModel.h.a == AdOperator.TYPE.DOWNLOAD) {
                    this.p.setVisibility(8);
                    tn0 tn0Var = adBaseModel.l;
                    if (tn0Var != null && tn0Var.e) {
                        this.h.setVisibility(0);
                        this.i = new ck0(rj0.b(adBaseModel), this.h);
                    } else {
                        this.h.setVisibility(8);
                        this.i = null;
                    }
                } else {
                    this.p.setVisibility(0);
                    if (TextUtils.isEmpty(ko0Var.e)) {
                        this.g.setText(ko0Var.e);
                    } else {
                        this.g.setText(getResources().getText(R.string.obfuscated_res_0x7f0f0b6c));
                    }
                    this.q.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080dde));
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
                    layoutParams.leftMargin = resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704dc);
                    layoutParams.rightMargin = resources.getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704dc);
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
            this.r.m(adBaseModel.j.c, 1, 5);
            setTag(adBaseModel);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (view2.getId() == R.id.obfuscated_res_0x7f091f1c) {
                View.OnClickListener onClickListener = this.j;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f19) {
                ck0 ck0Var = this.i;
                if (ck0Var != null) {
                    ck0Var.l();
                }
            } else {
                c(adBaseModel, view2);
                this.k.onClick(view2);
            }
        }
    }

    public void setAdInfo(mo0 mo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mo0Var) == null) {
            this.s = mo0Var;
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
