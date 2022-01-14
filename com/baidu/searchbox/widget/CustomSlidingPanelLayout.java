package com.baidu.searchbox.widget;

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
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class CustomSlidingPanelLayout extends SlidingPaneLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCanSlide;
    public boolean mForceActivityTransparent;
    public OnTranslucentListener mListener;
    public boolean mNightMode;
    public SlideInterceptor mSlideInterceptor;
    public double mSlideRegionFactor;
    public WeakReference<Activity> mTopActivity;

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
        this.mCanSlide = true;
        this.mForceActivityTransparent = false;
        this.mSlideRegionFactor = 1.0d;
        init();
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout
    public void attachActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, activity) == null) || Build.VERSION.SDK_INT < 21 || activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return;
        }
        this.mTopActivity = new WeakReference<>(activity);
        activity.getWindow().getDecorView().setBackgroundColor(0);
        if (this.mForceActivityTransparent) {
            return;
        }
        convertActivityFromTranslucent();
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout
    public void convertActivityFromTranslucent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            WeakReference<Activity> weakReference = this.mTopActivity;
            if (weakReference != null && weakReference.get() != null) {
                SlideUtil.convertFromTranslucent(this.mTopActivity.get(), new OnTranslucentListener(this) { // from class: com.baidu.searchbox.widget.CustomSlidingPanelLayout.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CustomSlidingPanelLayout this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.searchbox.widget.OnTranslucentListener
                    public void onTranslucent(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            this.this$0.setActivityIsTranslucent(z);
                            if (this.this$0.mListener != null) {
                                this.this$0.mListener.onTranslucent(z);
                            }
                        }
                    }
                });
                return;
            }
            OnTranslucentListener onTranslucentListener = this.mListener;
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(true);
            }
        }
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout
    public void convertActivityToTranslucent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WeakReference<Activity> weakReference = this.mTopActivity;
            if (weakReference != null && weakReference.get() != null) {
                SlideUtil.convertToTranslucent(this.mTopActivity.get(), new OnTranslucentListener(this) { // from class: com.baidu.searchbox.widget.CustomSlidingPanelLayout.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CustomSlidingPanelLayout this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.searchbox.widget.OnTranslucentListener
                    public void onTranslucent(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            this.this$0.setActivityIsTranslucent(z);
                            if (this.this$0.mListener != null) {
                                this.this$0.mListener.onTranslucent(z);
                            }
                        }
                    }
                });
                return;
            }
            OnTranslucentListener onTranslucentListener = this.mListener;
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(false);
            }
        }
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout
    public void forceActivityTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mForceActivityTransparent = z;
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setCanSlideRegionFactor(this.mSlideRegionFactor);
            setActivityIsTranslucent(true);
        }
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (motionEvent.getPointerCount() > 1) {
                return false;
            }
            if (MotionEventCompat.getActionMasked(motionEvent) == 2) {
                if (!this.mCanSlide) {
                    return false;
                }
                try {
                    if (this.mSlideInterceptor != null) {
                        if (!this.mSlideInterceptor.isSlidable(motionEvent)) {
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
            this.mCanSlide = z;
        }
    }

    public void setNightMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mNightMode = z;
        }
    }

    public void setOnTransparentListener(OnTranslucentListener onTranslucentListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onTranslucentListener) == null) {
            this.mListener = onTranslucentListener;
        }
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, slideInterceptor) == null) {
            this.mSlideInterceptor = slideInterceptor;
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
        this.mCanSlide = true;
        this.mForceActivityTransparent = false;
        this.mSlideRegionFactor = 1.0d;
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
        this.mCanSlide = true;
        this.mForceActivityTransparent = false;
        this.mSlideRegionFactor = 1.0d;
        init();
    }
}
