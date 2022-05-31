package com.baidu.nadcore.video.videoplayer.ui.full;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.nw0;
import com.repackage.y01;
import java.util.Locale;
/* loaded from: classes2.dex */
public class BdVideoCacheView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int e;
    public static final int f;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public BdVideoLoadingView b;
    public TextView c;
    public TextView d;

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
        y01.c(18.0f);
        y01.c(22.0f);
        e = y01.d(200.0f);
        f = y01.d(200.0f);
        y01.d(10.0f);
        y01.d(25.0f);
        y01.d(6.0f);
        y01.d(8.0f);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            float f2 = i;
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
            BdVideoLoadingView bdVideoLoadingView = new BdVideoLoadingView(this.a);
            this.b = bdVideoLoadingView;
            addView(bdVideoLoadingView, layoutParams);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i != 0) {
                this.b.clearAnimation();
                this.b.d();
            } else if (!this.b.b()) {
                this.b.c();
            }
            setVisibility(i);
            this.b.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            super.onMeasure(i, i2);
            setMeasuredDimension(e, f);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i != 0) {
                nw0.a("onWindowVisibilityChanged(" + i + SmallTailInfo.EMOTION_SUFFIX);
                setVisibility(4);
            }
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.requestLayout();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void setCacheHint(int i) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && this.c.getVisibility() == 0) {
            if (i < 10) {
                str = "   " + i;
            } else if (i < 100) {
                str = " " + i;
            } else {
                str = "";
            }
            this.c.setText(str + "%");
        }
    }

    public void setLoadingAnimListener(BdVideoLoadingView.a aVar) {
        BdVideoLoadingView bdVideoLoadingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || (bdVideoLoadingView = this.b) == null) {
            return;
        }
        bdVideoLoadingView.setLoadingAnimListener(aVar);
    }

    public void setSpeedHint(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.d.setText(a(i));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = context;
        b();
    }
}
