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
import com.repackage.a41;
import com.repackage.ag0;
import com.repackage.ei0;
import com.repackage.f41;
import com.repackage.fm0;
import com.repackage.gg0;
import com.repackage.gm0;
import com.repackage.pi0;
import com.repackage.rx0;
import com.repackage.rz0;
import com.repackage.tz0;
import com.repackage.vi0;
import com.repackage.xg0;
import com.repackage.y31;
import com.repackage.ym0;
import com.repackage.z21;
import com.repackage.z31;
import com.repackage.zz0;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static /* synthetic */ Interceptable $ic;
    public static final int h;
    public transient /* synthetic */ FieldHolder $fh;
    public z31 a;
    public a41 b;
    public y31 c;
    public f41 d;
    public pi0 e;
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
    public class b implements f41.d {
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

        @Override // com.repackage.f41.d
        public void a(List<fm0.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Toast.makeText(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0b8a, 0).show();
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
    public class c implements vi0 {
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

        @Override // com.repackage.vi0
        public void a(ei0 ei0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ei0Var) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ei0Var, this.a)) {
                    return;
                }
                this.b.c.e(this.a);
            }
        }

        @Override // com.repackage.vi0
        public void b(ei0 ei0Var, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ei0Var, adDownloadCode) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ei0Var, this.a)) {
                    return;
                }
                this.b.c.c(this.a);
            }
        }

        @Override // com.repackage.vi0
        public void c(ei0 ei0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ei0Var) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ei0Var, this.a)) {
                    return;
                }
                this.b.c.a(this.a);
            }
        }

        @Override // com.repackage.vi0
        public void d(ei0 ei0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, ei0Var) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ei0Var, this.a)) {
                    return;
                }
                this.b.c.c(this.a);
            }
        }

        @Override // com.repackage.vi0
        public void e(ei0 ei0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, ei0Var) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ei0Var, this.a)) {
                    return;
                }
                this.b.c.a(this.a);
            }
        }

        @Override // com.repackage.vi0
        public void f(ei0 ei0Var, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, ei0Var, f) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ei0Var, this.a)) {
                    return;
                }
                this.b.c.g(this.a, f);
            }
        }

        @Override // com.repackage.vi0
        public void g(ei0 ei0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, ei0Var) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ei0Var, this.a)) {
                    return;
                }
                this.b.c.b(this.a);
            }
        }

        @Override // com.repackage.vi0
        public void h(ei0 ei0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, ei0Var) == null) {
                AdFeedBaseView adFeedBaseView = this.b;
                if (adFeedBaseView.c == null || !adFeedBaseView.e(ei0Var, this.a)) {
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
        h = zz0.c.a(xg0.b(), 15.0f);
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
        pi0 pi0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (pi0Var = this.e) == null) {
            return;
        }
        pi0Var.j();
        this.e = null;
    }

    public final void d() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (findViewById = findViewById(R.id.obfuscated_res_0x7f091479)) == null) {
            return;
        }
        z21.a(this, findViewById, h);
        findViewById.setOnClickListener(new a(this));
    }

    public final boolean e(ei0 ei0Var, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        gm0 gm0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ei0Var, adBaseModel)) == null) ? (ei0Var == null || adBaseModel == null || (gm0Var = adBaseModel.l) == null || !TextUtils.equals(ei0Var.g, gm0Var.c) || !TextUtils.equals(ei0Var.d(), gm0Var.d)) ? false : true : invokeLL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (adBaseModel.a) {
                return;
            }
            z31 z31Var = this.a;
            if (z31Var != null) {
                z31Var.c(adBaseModel);
            }
            rx0.c(new ClogBuilder().w(ClogBuilder.LogType.SHOW).n(adBaseModel.f.d));
            adBaseModel.a = true;
        }
    }

    public void g() {
        AdBaseModel adBaseModel;
        ym0 ym0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if ((getTag() instanceof AdBaseModel) && (ym0Var = (adBaseModel = (AdBaseModel) getTag()).p) != null && !ym0Var.m) {
                z31 z31Var = this.a;
                if (z31Var != null) {
                    z31Var.a(adBaseModel);
                }
                rx0.c(new ClogBuilder().w(ClogBuilder.LogType.CLOSE).n(adBaseModel.f.d));
                return;
            }
            if (this.d == null) {
                if (!(getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.d = new f41(getContext(), (AdBaseModel) getTag());
            }
            this.d.h(new b(this));
            tz0.b(this.d);
        }
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void h(@NonNull AdBaseModel adBaseModel) {
        gm0 gm0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) && (gm0Var = adBaseModel.l) != null && gm0Var.e) {
            this.e = new pi0(ei0.b(adBaseModel));
            y31 y31Var = this.c;
            if (y31Var != null) {
                y31Var.d(adBaseModel);
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
            rz0.e(adBaseModel);
            gg0.c(rz0.b(adBaseModel, adBaseModel.f.c), getContext());
            ClogBuilder n = new ClogBuilder().w(ClogBuilder.LogType.CLICK).g(ClogBuilder.Area.HOTAREA).n(adBaseModel.f.d);
            ag0 ag0Var = adBaseModel.q;
            if (ag0Var != null) {
                n.k(ag0Var.a());
            }
            rx0.c(n);
            z31 z31Var = this.a;
            if (z31Var != null) {
                z31Var.b(adBaseModel);
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

    public void setVideoMediaListener(a41 a41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, a41Var) == null) {
            this.b = a41Var;
        }
    }

    public void setViewDownloadListener(y31 y31Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, y31Var) == null) {
            this.c = y31Var;
        }
    }

    public void setViewStatChangeListener(z31 z31Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, z31Var) == null) {
            this.a = z31Var;
        }
    }

    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, adBaseModel) == null) {
            setTag(adBaseModel);
            this.d = new f41(getContext(), adBaseModel);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (ym0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i, ym0 ym0Var) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), ym0Var};
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
