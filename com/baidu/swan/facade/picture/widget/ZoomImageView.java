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
/* loaded from: classes9.dex */
public class ZoomImageView extends BdImageViewTouch {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;
    public float t;
    public float u;
    public a v;
    public b w;

    /* loaded from: classes9.dex */
    public interface a {
        void a(Drawable drawable);

        void b(Bitmap bitmap);
    }

    /* loaded from: classes9.dex */
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
        this.s = false;
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = null;
        this.w = null;
    }

    public boolean hasSetBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean isGifSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouch
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            b bVar = this.w;
            boolean c2 = bVar != null ? bVar.c(this, motionEvent, motionEvent2, f2, f3) : false;
            return !c2 ? super.onFling(motionEvent, motionEvent2, f2, f3) : c2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouch
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            b bVar = this.w;
            boolean b2 = bVar != null ? bVar.b(this, motionEvent, motionEvent2, f2, f3) : false;
            return !b2 ? super.onScroll(motionEvent, motionEvent2, f2, f3) : b2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void panBy(double d2, double d3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)}) == null) {
            b bVar = this.w;
            if (bVar != null ? bVar.a(this, d2, d3) : false) {
                return;
            }
            super.panBy(d2, d3);
        }
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bitmap) == null) {
            a aVar = this.v;
            if (aVar != null) {
                aVar.b(bitmap);
            }
            super.setImageBitmap(bitmap, null, this.t, this.u);
            this.s = bitmap != null;
        }
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, drawable) == null) {
            a aVar = this.v;
            if (aVar != null) {
                aVar.a(drawable);
            }
            super.setImageDrawable(drawable, null, this.t, this.u);
            this.s = drawable != null;
        }
    }

    public void setOnSetImageBitmapListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.v = aVar;
        }
    }

    public void setOnUpdateRectListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.w = bVar;
        }
    }

    public void setZoomRange(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.u = f3;
            this.t = f2;
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
        this.s = false;
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = null;
        this.w = null;
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
        this.s = false;
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = null;
        this.w = null;
    }
}
