package c.a.q0.i3.l0;

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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Rect f20384a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f20385b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f20386c;

    /* renamed from: d  reason: collision with root package name */
    public Context f20387d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f20388e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20389f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20390g;

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
        this.f20387d = context;
        this.f20386c = new Rect();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f20387d.getResources().getDisplayMetrics();
            this.f20386c.set(0, 0, this.f20385b.getWidth(), this.f20385b.getHeight());
            canvas.drawBitmap(this.f20385b, this.f20386c, this.f20384a, (Paint) null);
        }
    }
}
