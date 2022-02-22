package c.a.u0.z3.n0;

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
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f26293b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f26294c;

    /* renamed from: d  reason: collision with root package name */
    public Context f26295d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f26296e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26297f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26298g;

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
        this.f26295d = context;
        this.f26294c = new Rect();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f26295d.getResources().getDisplayMetrics();
            this.f26294c.set(0, 0, this.f26293b.getWidth(), this.f26293b.getHeight());
            canvas.drawBitmap(this.f26293b, this.f26294c, this.a, (Paint) null);
        }
    }
}
