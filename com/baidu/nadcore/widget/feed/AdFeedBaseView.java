package com.baidu.nadcore.widget.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bh0;
import com.repackage.c41;
import com.repackage.cn0;
import com.repackage.d01;
import com.repackage.d31;
import com.repackage.d41;
import com.repackage.e41;
import com.repackage.eg0;
import com.repackage.ii0;
import com.repackage.j41;
import com.repackage.jm0;
import com.repackage.kg0;
import com.repackage.km0;
import com.repackage.ti0;
import com.repackage.vx0;
import com.repackage.vz0;
import com.repackage.xz0;
import com.repackage.zi0;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static /* synthetic */ Interceptable $ic;
    public static final int h;
    public transient /* synthetic */ FieldHolder $fh;
    public d41 a;
    public e41 b;
    public c41 c;
    public j41 d;
    public ti0 e;
    public GestureDetector f;
    public boolean g;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdFeedBaseView a;

        public a(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adFeedBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements j41.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdFeedBaseView a;

        public b(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adFeedBaseView;
        }

        @Override // com.repackage.j41.d
        public void a(List<jm0.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Toast.makeText(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0b8e, 0).show();
                this.a.setVisibility(8);
                AdFeedBaseView adFeedBaseView = this.a;
                if (adFeedBaseView.a == null || !(adFeedBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.a.a.a((AdBaseModel) this.a.getTag());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements zi0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ AdFeedBaseView b;

        public c(AdFeedBaseView adFeedBaseView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adFeedBaseView;
            this.a = adBaseModel;
        }

        @Override // com.repackage.zi0
        public void a(ii0 ii0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ii0Var) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ii0Var, this.a)) {
                    return;
                }
                this.b.c.e(this.a);
            }
        }

        @Override // com.repackage.zi0
        public void b(ii0 ii0Var, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ii0Var, adDownloadCode) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ii0Var, this.a)) {
                    return;
                }
                this.b.c.c(this.a);
            }
        }

        @Override // com.repackage.zi0
        public void c(ii0 ii0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ii0Var) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ii0Var, this.a)) {
                    return;
                }
                this.b.c.a(this.a);
            }
        }

        @Override // com.repackage.zi0
        public void d(ii0 ii0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, ii0Var) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ii0Var, this.a)) {
                    return;
                }
                this.b.c.c(this.a);
            }
        }

        @Override // com.repackage.zi0
        public void e(ii0 ii0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, ii0Var) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ii0Var, this.a)) {
                    return;
                }
                this.b.c.a(this.a);
            }
        }

        @Override // com.repackage.zi0
        public void f(ii0 ii0Var, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, ii0Var, f) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ii0Var, this.a)) {
                    return;
                }
                this.b.c.g(this.a, f);
            }
        }

        @Override // com.repackage.zi0
        public void g(ii0 ii0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, ii0Var) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ii0Var, this.a)) {
                    return;
                }
                this.b.c.b(this.a);
            }
        }

        @Override // com.repackage.zi0
        public void h(ii0 ii0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, ii0Var) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ii0Var, this.a)) {
                    return;
                }
                this.b.c.f(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdFeedBaseView a;

        public d(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adFeedBaseView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.a.g = true;
                return super.onDown(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.g = false;
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.g = false;
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ d(AdFeedBaseView adFeedBaseView, a aVar) {
            this(adFeedBaseView);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1776047025, "Lcom/baidu/nadcore/widget/feed/AdFeedBaseView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1776047025, "Lcom/baidu/nadcore/widget/feed/AdFeedBaseView;");
                return;
            }
        }
        h = d01.c.a(bh0.b(), 15.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = true;
    }

    public void c() {
        ti0 ti0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ti0Var = this.e) == null) {
            return;
        }
        ti0Var.j();
        this.e = null;
    }

    public final void d() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (findViewById = findViewById(R.id.obfuscated_res_0x7f09146b)) == null) {
            return;
        }
        d31.a(this, findViewById, h);
        findViewById.setOnClickListener(new a(this));
    }

    public final boolean e(ii0 ii0Var, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        km0 km0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ii0Var, adBaseModel)) == null) ? (ii0Var == null || adBaseModel == null || (km0Var = adBaseModel.l) == null || !TextUtils.equals(ii0Var.g, km0Var.c) || !TextUtils.equals(ii0Var.d(), km0Var.d)) ? false : true : invokeLL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (adBaseModel.a) {
                return;
            }
            d41 d41Var = this.a;
            if (d41Var != null) {
                d41Var.c(adBaseModel);
            }
            vx0.c(new ClogBuilder().w(ClogBuilder.LogType.SHOW).n(adBaseModel.f.d));
            adBaseModel.a = true;
        }
    }

    public void g() {
        AdBaseModel adBaseModel;
        cn0 cn0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if ((getTag() instanceof AdBaseModel) && (cn0Var = (adBaseModel = (AdBaseModel) getTag()).p) != null && !cn0Var.m) {
                d41 d41Var = this.a;
                if (d41Var != null) {
                    d41Var.a(adBaseModel);
                }
                vx0.c(new ClogBuilder().w(ClogBuilder.LogType.CLOSE).n(adBaseModel.f.d));
                return;
            }
            if (this.d == null) {
                if (!(getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.d = new j41(getContext(), (AdBaseModel) getTag());
            }
            this.d.h(new b(this));
            xz0.b(this.d);
        }
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void h(@NonNull AdBaseModel adBaseModel) {
        km0 km0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) && (km0Var = adBaseModel.l) != null && km0Var.e) {
            this.e = new ti0(ii0.b(adBaseModel));
            c41 c41Var = this.c;
            if (c41Var != null) {
                c41Var.d(adBaseModel);
            }
            this.e.n(new c(this, adBaseModel));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            f();
        }
    }

    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && this.g && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (TextUtils.isEmpty(adBaseModel.f.c)) {
                return;
            }
            vz0.e(adBaseModel);
            kg0.c(vz0.b(adBaseModel, adBaseModel.f.c), getContext());
            ClogBuilder n = new ClogBuilder().w(ClogBuilder.LogType.CLICK).g(ClogBuilder.Area.HOTAREA).n(adBaseModel.f.d);
            eg0 eg0Var = adBaseModel.q;
            if (eg0Var != null) {
                n.k(eg0Var.a());
            }
            vx0.c(n);
            d41 d41Var = this.a;
            if (d41Var != null) {
                d41Var.b(adBaseModel);
            }
            adBaseModel.b = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            c();
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            this.f.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            super.onViewAdded(view2);
            if (view2.getVisibility() == 0) {
                f();
                d();
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, view2, i) == null) {
            super.onVisibilityChanged(view2, i);
            if (i == 0) {
                f();
            }
        }
    }

    public void setVideoMediaListener(e41 e41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, e41Var) == null) {
            this.b = e41Var;
        }
    }

    public void setViewDownloadListener(c41 c41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, c41Var) == null) {
            this.c = c41Var;
        }
    }

    public void setViewStatChangeListener(d41 d41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, d41Var) == null) {
            this.a = d41Var;
        }
    }

    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, adBaseModel) == null) {
            setTag(adBaseModel);
            this.d = new j41(getContext(), adBaseModel);
            h(adBaseModel);
            if (getVisibility() != 0) {
                setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (cn0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i, cn0 cn0Var) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), cn0Var};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.g = true;
        setOnClickListener(this);
        this.f = new GestureDetector(getContext(), new d(this, null));
    }
}
