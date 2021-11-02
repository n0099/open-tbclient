package b.a.r0.l3.m0;

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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Rect f20705a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f20706b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f20707c;

    /* renamed from: d  reason: collision with root package name */
    public Context f20708d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f20709e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20710f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20711g;

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
        this.f20708d = context;
        this.f20707c = new Rect();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f20708d.getResources().getDisplayMetrics();
            this.f20707c.set(0, 0, this.f20706b.getWidth(), this.f20706b.getHeight());
            canvas.drawBitmap(this.f20706b, this.f20707c, this.f20705a, (Paint) null);
        }
    }
}
