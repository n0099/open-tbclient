package c.a.r0.t3.m0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f23898b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f23899c;

    /* renamed from: d  reason: collision with root package name */
    public Context f23900d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f23901e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23902f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23903g;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23900d = context;
        this.f23899c = new Rect();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f23900d.getResources().getDisplayMetrics();
            this.f23899c.set(0, 0, this.f23898b.getWidth(), this.f23898b.getHeight());
            canvas.drawBitmap(this.f23898b, this.f23899c, this.a, (Paint) null);
        }
    }
}
