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
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.tieba.ci0;
import com.baidu.tieba.cl0;
import com.baidu.tieba.h01;
import com.baidu.tieba.ii0;
import com.baidu.tieba.l21;
import com.baidu.tieba.lk0;
import com.baidu.tieba.m61;
import com.baidu.tieba.m71;
import com.baidu.tieba.mp0;
import com.baidu.tieba.n21;
import com.baidu.tieba.n71;
import com.baidu.tieba.o71;
import com.baidu.tieba.t21;
import com.baidu.tieba.t71;
import com.baidu.tieba.to0;
import com.baidu.tieba.uo0;
import com.baidu.tieba.yk0;
import com.baidu.tieba.zi0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static /* synthetic */ Interceptable $ic;
    public static final int h;
    public transient /* synthetic */ FieldHolder $fh;
    public n71 a;
    public o71 b;
    public m71 c;
    public t71 d;
    public yk0 e;
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
    public class b implements t71.d {
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

        @Override // com.baidu.tieba.t71.d
        public void a(List<to0.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Toast.makeText(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0bad, 0).show();
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
    public class c implements cl0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ lk0 b;
        public final /* synthetic */ AdFeedBaseView c;

        public c(AdFeedBaseView adFeedBaseView, AdBaseModel adBaseModel, lk0 lk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView, adBaseModel, lk0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = adFeedBaseView;
            this.a = adBaseModel;
            this.b = lk0Var;
        }

        @Override // com.baidu.tieba.cl0
        public void a(AdDownloadStatus adDownloadStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, adDownloadStatus) == null) {
                int i = d.a[adDownloadStatus.ordinal()];
                if (i == 1) {
                    AdFeedBaseView adFeedBaseView = this.c;
                    if (adFeedBaseView.c == null || !adFeedBaseView.e(this.a)) {
                        return;
                    }
                    this.c.c.f(this.a, this.b.i);
                } else if (i == 2) {
                    AdFeedBaseView adFeedBaseView2 = this.c;
                    if (adFeedBaseView2.c == null || !adFeedBaseView2.e(this.a)) {
                        return;
                    }
                    this.c.c.d(this.a);
                } else if (i == 3) {
                    AdFeedBaseView adFeedBaseView3 = this.c;
                    if (adFeedBaseView3.c == null || !adFeedBaseView3.e(this.a)) {
                        return;
                    }
                    this.c.c.e(this.a);
                } else if (i != 4) {
                } else {
                    AdFeedBaseView adFeedBaseView4 = this.c;
                    if (adFeedBaseView4.c == null || !adFeedBaseView4.e(this.a)) {
                        return;
                    }
                    this.c.c.a(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.cl0
        public void b(AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) {
                if ((!(adDownloadCode != AdDownloadCode.ERROR_FAST_CLICK) || !(this.c.c != null)) || !this.c.e(this.a)) {
                    return;
                }
                this.c.c.b(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1679155569, "Lcom/baidu/nadcore/widget/feed/AdFeedBaseView$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1679155569, "Lcom/baidu/nadcore/widget/feed/AdFeedBaseView$d;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdFeedBaseView a;

        public e(AdFeedBaseView adFeedBaseView) {
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

        public /* synthetic */ e(AdFeedBaseView adFeedBaseView, a aVar) {
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
        h = t21.c.a(zi0.b(), 15.0f);
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
        yk0 yk0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (yk0Var = this.e) == null) {
            return;
        }
        yk0Var.k();
        this.e = null;
    }

    public final void d() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (findViewById = findViewById(R.id.obfuscated_res_0x7f0915d3)) == null) {
            return;
        }
        m61.a(this, findViewById, h);
        findViewById.setOnClickListener(new a(this));
    }

    public final boolean e(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        uo0 uo0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel)) == null) {
            if (adBaseModel == null || (uo0Var = adBaseModel.l) == null) {
                return false;
            }
            return uo0Var.e;
        }
        return invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (adBaseModel.a) {
                return;
            }
            n71 n71Var = this.a;
            if (n71Var != null) {
                n71Var.c(adBaseModel);
            }
            h01.b(new ClogBuilder().y(ClogBuilder.LogType.SHOW).p(adBaseModel.f.d));
            adBaseModel.a = true;
        }
    }

    public void g() {
        AdBaseModel adBaseModel;
        mp0 mp0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if ((getTag() instanceof AdBaseModel) && (mp0Var = (adBaseModel = (AdBaseModel) getTag()).p) != null && !mp0Var.m) {
                n71 n71Var = this.a;
                if (n71Var != null) {
                    n71Var.a(adBaseModel);
                }
                h01.b(new ClogBuilder().y(ClogBuilder.LogType.CLOSE).p(adBaseModel.f.d));
                return;
            }
            if (this.d == null) {
                if (!(getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.d = new t71(getContext(), (AdBaseModel) getTag());
            }
            this.d.h(new b(this));
            n21.b(this.d);
        }
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void h(@NonNull AdBaseModel adBaseModel) {
        uo0 uo0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) && (uo0Var = adBaseModel.l) != null && uo0Var.e) {
            lk0 c2 = lk0.c(adBaseModel);
            this.e = new yk0(c2);
            m71 m71Var = this.c;
            if (m71Var != null) {
                m71Var.c(adBaseModel);
            }
            this.e.o(new c(this, adBaseModel, c2));
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
            l21.e(adBaseModel);
            ii0.c(l21.b(adBaseModel, adBaseModel.f.c), getContext());
            ClogBuilder p = new ClogBuilder().y(ClogBuilder.LogType.CLICK).i(ClogBuilder.Area.HOTAREA).p(adBaseModel.f.d);
            ci0 ci0Var = adBaseModel.q;
            if (ci0Var != null) {
                p.m(ci0Var.a());
            }
            h01.b(p);
            n71 n71Var = this.a;
            if (n71Var != null) {
                n71Var.b(adBaseModel);
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

    public void setVideoMediaListener(o71 o71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, o71Var) == null) {
            this.b = o71Var;
        }
    }

    public void setViewDownloadListener(m71 m71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, m71Var) == null) {
            this.c = m71Var;
        }
    }

    public void setViewStatChangeListener(n71 n71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, n71Var) == null) {
            this.a = n71Var;
        }
    }

    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, adBaseModel) == null) {
            setTag(adBaseModel);
            this.d = new t71(getContext(), adBaseModel);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (mp0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i, mp0 mp0Var) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), mp0Var};
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
        this.f = new GestureDetector(getContext(), new e(this, null));
    }
}
