package com.baidu.nadcore.video.videoplayer.ui.full;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.e0.a.d.b;
import c.a.c0.s.v0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.videoplayer.ui.loading.BdVideoLoadingView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes10.dex */
public class BdVideoCacheView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final int f38369h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f38370i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f38371e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38372f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38373g;
    public BdVideoLoadingView mLoadingView;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1166351532, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdVideoCacheView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1166351532, "Lcom/baidu/nadcore/video/videoplayer/ui/full/BdVideoCacheView;");
                return;
            }
        }
        b.c(18.0f);
        b.c(22.0f);
        f38369h = b.d(200.0f);
        f38370i = b.d(200.0f);
        b.d(10.0f);
        b.d(25.0f);
        b.d(6.0f);
        b.d(8.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdVideoCacheView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            float f2 = i2;
            String str = " KB/s";
            if (f2 >= 1024.0f) {
                f2 /= 1024.0f;
                if (f2 >= 1024.0f) {
                    f2 /= 1024.0f;
                    str = " MB/s";
                }
            }
            return String.format(Locale.getDefault(), "%.2f", Float.valueOf(f2)) + str;
        }
        return (String) invokeI.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            BdVideoLoadingView bdVideoLoadingView = new BdVideoLoadingView(this.f38371e);
            this.mLoadingView = bdVideoLoadingView;
            addView(bdVideoLoadingView, layoutParams);
        }
    }

    public void hideLoadingView() {
        BdVideoLoadingView bdVideoLoadingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdVideoLoadingView = this.mLoadingView) == null) {
            return;
        }
        bdVideoLoadingView.stopAnimation();
        this.mLoadingView.setVisibility(4);
    }

    public boolean isLoadingAnimRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BdVideoLoadingView bdVideoLoadingView = this.mLoadingView;
            if (bdVideoLoadingView != null) {
                return bdVideoLoadingView.isRunning();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(f38369h, f38370i);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 != 0) {
                h.a("onWindowVisibilityChanged(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
                setVisibility(4);
            }
            super.onWindowVisibilityChanged(i2);
        }
    }

    public void removeLoadingAnimListener() {
        BdVideoLoadingView bdVideoLoadingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdVideoLoadingView = this.mLoadingView) == null) {
            return;
        }
        bdVideoLoadingView.removeLoadingAnimListener();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.requestLayout();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void setCacheHint(int i2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && this.f38372f.getVisibility() == 0) {
            if (i2 < 10) {
                str = "   " + i2;
            } else if (i2 < 100) {
                str = " " + i2;
            } else {
                str = "";
            }
            this.f38372f.setText(str + "%");
        }
    }

    public void setLoadingAnimListener(BdVideoLoadingView.a aVar) {
        BdVideoLoadingView bdVideoLoadingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || (bdVideoLoadingView = this.mLoadingView) == null) {
            return;
        }
        bdVideoLoadingView.setLoadingAnimListener(aVar);
    }

    public void setSpeedHint(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f38373g.setText(a(i2));
        }
    }

    public void startCacheRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 != 0) {
                this.mLoadingView.clearAnimation();
                this.mLoadingView.stopAnimation();
            } else if (!this.mLoadingView.isRunning()) {
                this.mLoadingView.startAnimation();
            }
            setVisibility(i2);
            this.mLoadingView.setVisibility(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdVideoCacheView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f38371e = context;
        b();
    }
}
