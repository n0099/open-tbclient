package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class XfordView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f40537a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f40538b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f40539c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f40540d;

    /* renamed from: e  reason: collision with root package name */
    public Xfermode f40541e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XfordView(Context context) {
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
        this.f40537a = null;
        this.f40538b = null;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.f40538b == null) {
                Paint paint = new Paint();
                this.f40538b = paint;
                paint.setColor(1711276032);
            }
            if (this.f40537a == null) {
                this.f40537a = BitmapFactory.decodeResource(getResources(), R.drawable.sapi_liveness_recog_face_mask);
            }
            if (this.f40541e == null) {
                this.f40541e = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onDetachedFromWindow();
            Bitmap bitmap = this.f40537a;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f40537a.recycle();
                this.f40537a = null;
            }
            System.gc();
            this.f40541e = null;
            this.f40539c = null;
            this.f40540d = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.sapi_liveness_face_round_height);
            int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.sapi_liveness_face_round_width);
            int width = (getWidth() - dimensionPixelSize2) / 2;
            int height = (getHeight() - dimensionPixelSize) / 2;
            if (this.f40540d == null) {
                this.f40540d = new Rect(width, height, dimensionPixelSize2 + width, dimensionPixelSize + height);
            }
            if (this.f40539c == null) {
                this.f40539c = new Rect(0, 0, this.f40537a.getWidth(), this.f40537a.getHeight());
            }
            canvas.drawBitmap(this.f40537a, this.f40539c, this.f40540d, this.f40538b);
            this.f40538b.setXfermode(this.f40541e);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f40538b);
            this.f40538b.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        }
    }

    public void setBgPaintColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f40538b == null) {
                this.f40538b = new Paint();
            }
            this.f40538b.setColor(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XfordView(Context context, AttributeSet attributeSet) {
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
        this.f40537a = null;
        this.f40538b = null;
        a();
    }
}
