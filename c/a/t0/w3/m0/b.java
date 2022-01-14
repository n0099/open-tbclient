package c.a.t0.w3.m0;

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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f24920b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f24921c;

    /* renamed from: d  reason: collision with root package name */
    public Context f24922d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f24923e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24924f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24925g;

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
        this.f24922d = context;
        this.f24921c = new Rect();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f24922d.getResources().getDisplayMetrics();
            this.f24921c.set(0, 0, this.f24920b.getWidth(), this.f24920b.getHeight());
            canvas.drawBitmap(this.f24920b, this.f24921c, this.a, (Paint) null);
        }
    }
}
