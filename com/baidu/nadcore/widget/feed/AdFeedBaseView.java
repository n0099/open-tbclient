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
import c.a.a0.h0.f;
import c.a.a0.j.f.j;
import c.a.a0.l0.h;
import c.a.a0.l0.t.a;
import c.a.a0.s.b;
import c.a.a0.s.s;
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
import java.util.List;
/* loaded from: classes4.dex */
public abstract class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final int f27779h;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.a0.l0.r.b a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.a0.l0.r.c f27780b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.a0.l0.r.a f27781c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.a0.l0.t.a f27782d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.a0.j.f.d f27783e;

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f27784f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27785g;

    /* loaded from: classes4.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.d {
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

        @Override // c.a.a0.l0.t.a.d
        public void a(List<b.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Toast.makeText(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0b6f, 0).show();
                this.a.setVisibility(8);
                AdFeedBaseView adFeedBaseView = this.a;
                if (adFeedBaseView.a == null || !(adFeedBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.a.a.a((AdBaseModel) this.a.getTag());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f27786b;

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
            this.f27786b = adFeedBaseView;
            this.a = adBaseModel;
        }

        @Override // c.a.a0.j.f.j
        public void a(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f27786b;
                if (adFeedBaseView.f27781c == null || !adFeedBaseView.e(aVar, this.a)) {
                    return;
                }
                this.f27786b.f27781c.e(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void b(c.a.a0.j.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                AdFeedBaseView adFeedBaseView = this.f27786b;
                if (adFeedBaseView.f27781c == null || !adFeedBaseView.e(aVar, this.a)) {
                    return;
                }
                this.f27786b.f27781c.c(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void c(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f27786b;
                if (adFeedBaseView.f27781c == null || !adFeedBaseView.e(aVar, this.a)) {
                    return;
                }
                this.f27786b.f27781c.a(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void d(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f27786b;
                if (adFeedBaseView.f27781c == null || !adFeedBaseView.e(aVar, this.a)) {
                    return;
                }
                this.f27786b.f27781c.c(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void e(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f27786b;
                if (adFeedBaseView.f27781c == null || !adFeedBaseView.e(aVar, this.a)) {
                    return;
                }
                this.f27786b.f27781c.a(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void f(c.a.a0.j.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                AdFeedBaseView adFeedBaseView = this.f27786b;
                if (adFeedBaseView.f27781c == null || !adFeedBaseView.e(aVar, this.a)) {
                    return;
                }
                this.f27786b.f27781c.g(this.a, f2);
            }
        }

        @Override // c.a.a0.j.f.j
        public void g(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f27786b;
                if (adFeedBaseView.f27781c == null || !adFeedBaseView.e(aVar, this.a)) {
                    return;
                }
                this.f27786b.f27781c.b(this.a);
            }
        }

        @Override // c.a.a0.j.f.j
        public void h(c.a.a0.j.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f27786b;
                if (adFeedBaseView.f27781c == null || !adFeedBaseView.e(aVar, this.a)) {
                    return;
                }
                this.f27786b.f27781c.f(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.f27785g = true;
                return super.onDown(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.a.f27785g = false;
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.a.f27785g = false;
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
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
        f27779h = f.c.a(c.a.a0.h.a.b(), 15.0f);
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
        this.f27785g = true;
    }

    public void c() {
        c.a.a0.j.f.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.f27783e) == null) {
            return;
        }
        dVar.n();
        this.f27783e = null;
    }

    public final void d() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (findViewById = findViewById(R.id.obfuscated_res_0x7f0914a2)) == null) {
            return;
        }
        h.a(this, findViewById, f27779h);
        findViewById.setOnClickListener(new a(this));
    }

    public final boolean e(c.a.a0.j.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.a0.s.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.l) == null || !TextUtils.equals(aVar.f1250g, cVar.f1533c) || !TextUtils.equals(aVar.d(), cVar.f1534d)) ? false : true : invokeLL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (adBaseModel.a) {
                return;
            }
            c.a.a0.l0.r.b bVar = this.a;
            if (bVar != null) {
                bVar.c(adBaseModel);
            }
            c.a.a0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.SHOW).n(adBaseModel.f27543f.f1549d));
            adBaseModel.a = true;
        }
    }

    public void g() {
        AdBaseModel adBaseModel;
        s sVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if ((getTag() instanceof AdBaseModel) && (sVar = (adBaseModel = (AdBaseModel) getTag()).p) != null && !sVar.m) {
                c.a.a0.l0.r.b bVar = this.a;
                if (bVar != null) {
                    bVar.a(adBaseModel);
                }
                c.a.a0.a0.a.b(new ClogBuilder().s(ClogBuilder.LogType.CLOSE).n(adBaseModel.f27543f.f1549d));
                return;
            }
            if (this.f27782d == null) {
                if (!(getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.f27782d = new c.a.a0.l0.t.a(getContext(), (AdBaseModel) getTag());
            }
            this.f27782d.h(new b(this));
            c.a.a0.h0.a.b(this.f27782d);
        }
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void h(@NonNull AdBaseModel adBaseModel) {
        c.a.a0.s.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) && (cVar = adBaseModel.l) != null && cVar.f1535e) {
            this.f27783e = new c.a.a0.j.f.d(c.a.a0.j.d.a.b(adBaseModel));
            c.a.a0.l0.r.a aVar = this.f27781c;
            if (aVar != null) {
                aVar.d(adBaseModel);
            }
            this.f27783e.r(new c(this, adBaseModel));
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

    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) && this.f27785g && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (TextUtils.isEmpty(adBaseModel.f27543f.f1548c)) {
                return;
            }
            c.a.a0.g0.a.e(adBaseModel);
            c.a.a0.g.c.c(c.a.a0.g0.a.b(adBaseModel, adBaseModel.f27543f.f1548c), getContext());
            ClogBuilder n = new ClogBuilder().s(ClogBuilder.LogType.CLICK).g(ClogBuilder.Area.HOTAREA).n(adBaseModel.f27543f.f1549d);
            c.a.a0.f.a aVar = adBaseModel.q;
            if (aVar != null) {
                n.k(aVar.a());
            }
            c.a.a0.a0.a.b(n);
            c.a.a0.l0.r.b bVar = this.a;
            if (bVar != null) {
                bVar.b(adBaseModel);
            }
            adBaseModel.f27539b = true;
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
            this.f27784f.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            super.onViewAdded(view);
            if (view.getVisibility() == 0) {
                f();
                d();
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, view, i) == null) {
            super.onVisibilityChanged(view, i);
            if (i == 0) {
                f();
            }
        }
    }

    public void setVideoMediaListener(c.a.a0.l0.r.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            this.f27780b = cVar;
        }
    }

    public void setViewDownloadListener(c.a.a0.l0.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.f27781c = aVar;
        }
    }

    public void setViewStatChangeListener(c.a.a0.l0.r.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, adBaseModel) == null) {
            setTag(adBaseModel);
            this.f27782d = new c.a.a0.l0.t.a(getContext(), adBaseModel);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i, s sVar) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), sVar};
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
        this.f27785g = true;
        setOnClickListener(this);
        this.f27784f = new GestureDetector(getContext(), new d(this, null));
    }
}
