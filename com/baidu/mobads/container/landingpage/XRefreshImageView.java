package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class XRefreshImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context context;
    public final Paint paint;
    public RectF rect2;
    public int startAngle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XRefreshImageView(Context context) {
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
        this.startAngle = 0;
        this.rect2 = new RectF();
        this.context = context;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    public static int dip2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int width = getWidth() / 2;
            int dip2px = dip2px(this.context, 15.0f);
            int dip2px2 = dip2px(this.context, 4.0f);
            RectF rectF = this.rect2;
            int i2 = dip2px + 1 + (dip2px2 / 2);
            float f2 = width - i2;
            rectF.left = f2;
            rectF.top = f2;
            float f3 = width + i2;
            rectF.right = f3;
            rectF.bottom = f3;
            this.paint.setColor(-1907998);
            this.paint.setStrokeWidth(dip2px2);
            canvas.drawArc(this.rect2, this.startAngle + 0, 72.0f, false, this.paint);
            this.paint.setColor(-1594427658);
            canvas.drawArc(this.rect2, this.startAngle + 72, 270.0f, false, this.paint);
            int i3 = this.startAngle + 10;
            this.startAngle = i3;
            if (i3 >= 360) {
                this.startAngle = 0;
            }
            super.onDraw(canvas);
            invalidate();
        }
    }
}
