package com.baidu.nadcore.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d41;
import com.repackage.e41;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class CustomSlidingPanelLayout extends SlidingPaneLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean B;
    public boolean C;
    public double D;
    public SlideInterceptor E;
    public WeakReference<Activity> F;
    public d41 G;

    /* loaded from: classes2.dex */
    public class a implements d41 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = customSlidingPanelLayout;
        }

        @Override // com.repackage.d41
        public void onTranslucent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.setActivityIsTranslucent(z);
                if (this.a.G != null) {
                    this.a.G.onTranslucent(z);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d41 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = customSlidingPanelLayout;
        }

        @Override // com.repackage.d41
        public void onTranslucent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.setActivityIsTranslucent(z);
                if (this.a.G != null) {
                    this.a.G.onTranslucent(z);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = true;
        this.C = false;
        this.D = 1.0d;
        L();
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setCanSlideRegionFactor(this.D);
            setActivityIsTranslucent(true);
        }
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout
    public void m(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || Build.VERSION.SDK_INT < 21 || activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return;
        }
        this.F = new WeakReference<>(activity);
        activity.getWindow().getDecorView().setBackgroundColor(0);
        if (this.C) {
            return;
        }
        q();
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent.getPointerCount() > 1) {
                return false;
            }
            if (MotionEventCompat.getActionMasked(motionEvent) == 2) {
                if (!this.B) {
                    return false;
                }
                try {
                    if (this.E != null) {
                        if (!this.E.isSlidable(motionEvent)) {
                            return false;
                        }
                    }
                } catch (AbstractMethodError e) {
                    e.printStackTrace();
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            WeakReference<Activity> weakReference = this.F;
            if (weakReference != null && weakReference.get() != null) {
                e41.c(this.F.get(), new b(this));
                return;
            }
            d41 d41Var = this.G;
            if (d41Var != null) {
                d41Var.onTranslucent(true);
            }
        }
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            WeakReference<Activity> weakReference = this.F;
            if (weakReference != null && weakReference.get() != null) {
                e41.d(this.F.get(), new a(this));
                return;
            }
            d41 d41Var = this.G;
            if (d41Var != null) {
                d41Var.onTranslucent(false);
            }
        }
    }

    public void setCanSlidable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.B = z;
        }
    }

    public void setNightMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public void setOnTransparentListener(d41 d41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, d41Var) == null) {
            this.G = d41Var;
        }
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, slideInterceptor) == null) {
            this.E = slideInterceptor;
        }
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.C = z;
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
        this.B = true;
        this.C = false;
        this.D = 1.0d;
        L();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.B = true;
        this.C = false;
        this.D = 1.0d;
        L();
    }
}
