package com.baidu.swan.facade.picture.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ZoomImageView extends BdImageViewTouch {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean N;
    public float O;
    public float P;
    public a Q;
    public b R;

    /* loaded from: classes4.dex */
    public interface a {
        void a(Drawable drawable);

        void b(Bitmap bitmap);
    }

    /* loaded from: classes4.dex */
    public interface b {
        boolean a(ZoomImageView zoomImageView, double d2, double d3);

        boolean b(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

        boolean c(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomImageView(Context context) {
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
        this.N = false;
        this.O = -1.0f;
        this.P = -1.0f;
        this.Q = null;
        this.R = null;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouch
    public boolean H(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            b bVar = this.R;
            boolean c2 = bVar != null ? bVar.c(this, motionEvent, motionEvent2, f2, f3) : false;
            return !c2 ? super.H(motionEvent, motionEvent2, f2, f3) : c2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouch
    public boolean I(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            b bVar = this.R;
            boolean b2 = bVar != null ? bVar.b(this, motionEvent, motionEvent2, f2, f3) : false;
            return !b2 ? super.I(motionEvent, motionEvent2, f2, f3) : b2;
        }
        return invokeCommon.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.N : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
            a aVar = this.Q;
            if (aVar != null) {
                aVar.b(bitmap);
            }
            super.setImageBitmap(bitmap, null, this.O, this.P);
            this.N = bitmap != null;
        }
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) {
            a aVar = this.Q;
            if (aVar != null) {
                aVar.a(drawable);
            }
            super.setImageDrawable(drawable, null, this.O, this.P);
            this.N = drawable != null;
        }
    }

    public void setOnSetImageBitmapListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.Q = aVar;
        }
    }

    public void setOnUpdateRectListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.R = bVar;
        }
    }

    public void setZoomRange(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.P = f3;
            this.O = f2;
        }
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void t(double d2, double d3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)}) == null) {
            b bVar = this.R;
            if (bVar != null ? bVar.a(this, d2, d3) : false) {
                return;
            }
            super.t(d2, d3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomImageView(Context context, AttributeSet attributeSet) {
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
        this.N = false;
        this.O = -1.0f;
        this.P = -1.0f;
        this.Q = null;
        this.R = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomImageView(Context context, AttributeSet attributeSet, int i2) {
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
        this.N = false;
        this.O = -1.0f;
        this.P = -1.0f;
        this.Q = null;
        this.R = null;
    }
}
