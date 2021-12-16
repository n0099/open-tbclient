package com.baidu.nadcore.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import c.a.c0.h0.n;
import c.a.c0.h0.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class CustomSlidingPanelLayout extends SlidingPaneLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean F;
    public boolean G;
    public double H;
    public SlideInterceptor I;
    public WeakReference<Activity> J;
    public n K;

    /* loaded from: classes10.dex */
    public class a implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomSlidingPanelLayout a;

        public a(CustomSlidingPanelLayout customSlidingPanelLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {customSlidingPanelLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = customSlidingPanelLayout;
        }

        @Override // c.a.c0.h0.n
        public void onTranslucent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.setActivityIsTranslucent(z);
                if (this.a.K != null) {
                    this.a.K.onTranslucent(z);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomSlidingPanelLayout a;

        public b(CustomSlidingPanelLayout customSlidingPanelLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {customSlidingPanelLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = customSlidingPanelLayout;
        }

        @Override // c.a.c0.h0.n
        public void onTranslucent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.setActivityIsTranslucent(z);
                if (this.a.K != null) {
                    this.a.K.onTranslucent(z);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomSlidingPanelLayout(Context context) {
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
        this.F = true;
        this.G = false;
        this.H = 1.0d;
        init();
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout
    public void attachActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, activity) == null) || Build.VERSION.SDK_INT < 21 || activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return;
        }
        this.J = new WeakReference<>(activity);
        activity.getWindow().getDecorView().setBackgroundColor(0);
        if (this.G) {
            return;
        }
        convertActivityFromTranslucent();
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout
    public void convertActivityFromTranslucent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            WeakReference<Activity> weakReference = this.J;
            if (weakReference != null && weakReference.get() != null) {
                w.c(this.J.get(), new b(this));
                return;
            }
            n nVar = this.K;
            if (nVar != null) {
                nVar.onTranslucent(true);
            }
        }
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout
    public void convertActivityToTranslucent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WeakReference<Activity> weakReference = this.J;
            if (weakReference != null && weakReference.get() != null) {
                w.d(this.J.get(), new a(this));
                return;
            }
            n nVar = this.K;
            if (nVar != null) {
                nVar.onTranslucent(false);
            }
        }
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout
    public void forceActivityTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.G = z;
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setCanSlideRegionFactor(this.H);
            setActivityIsTranslucent(true);
        }
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (motionEvent.getPointerCount() > 1) {
                return false;
            }
            if (MotionEventCompat.getActionMasked(motionEvent) == 2) {
                if (!this.F) {
                    return false;
                }
                try {
                    if (this.I != null) {
                        if (!this.I.isSlidable(motionEvent)) {
                            return false;
                        }
                    }
                } catch (AbstractMethodError e2) {
                    e2.printStackTrace();
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setCanSlidable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.F = z;
        }
    }

    public void setNightMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    public void setOnTransparentListener(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar) == null) {
            this.K = nVar;
        }
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, slideInterceptor) == null) {
            this.I = slideInterceptor;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet) {
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
        this.F = true;
        this.G = false;
        this.H = 1.0d;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.F = true;
        this.G = false;
        this.H = 1.0d;
        init();
    }
}
