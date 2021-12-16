package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes10.dex */
public class RotateProgressBar extends ProgressBar {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIMATION_RESOLUTION = 200;
    public static final int INCREMENT = 30;
    public static final int MAX_DEGREE = 360;
    public static final int MAX_LEVEL = 10000;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable mCurrentDrawable;
    public int mDegree;
    public int mFrameDuration;
    public long mLastDrawTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotateProgressBar(Context context, AttributeSet attributeSet, int i2) {
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
        this.mDegree = 0;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mFrameDuration = 200;
            try {
                Field declaredField = ProgressBar.class.getDeclaredField("mDuration");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    this.mFrameDuration = (int) ((declaredField.getInt(this) / 12.0f) + 0.5f);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable) == null) {
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            synchronized (this) {
                Drawable drawable = this.mCurrentDrawable;
                if (drawable != null) {
                    drawable.draw(canvas);
                    long uptimeMillis = SystemClock.uptimeMillis() - this.mLastDrawTime;
                    if (uptimeMillis < this.mFrameDuration) {
                        postInvalidateDelayed(this.mFrameDuration - uptimeMillis);
                    } else {
                        this.mLastDrawTime = SystemClock.uptimeMillis();
                        int i2 = this.mDegree + 30;
                        this.mDegree = i2;
                        if (i2 >= 360) {
                            this.mDegree = 0;
                        }
                        drawable.setLevel((int) ((this.mDegree * 10000) / 360.0f));
                        postInvalidateDelayed(this.mFrameDuration);
                    }
                }
            }
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            synchronized (this) {
                super.setIndeterminate(z);
                if (z) {
                    this.mCurrentDrawable = getIndeterminateDrawable();
                }
            }
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminateDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) {
            synchronized (this) {
                super.setIndeterminateDrawable(drawable);
                if (isIndeterminate()) {
                    this.mCurrentDrawable = drawable;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotateProgressBar(Context context, AttributeSet attributeSet) {
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
        this.mDegree = 0;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotateProgressBar(Context context) {
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
        this.mDegree = 0;
        a();
    }
}
