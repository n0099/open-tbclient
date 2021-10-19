package c.a.r0.k3.l0;

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
    public Rect f21138a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f21139b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f21140c;

    /* renamed from: d  reason: collision with root package name */
    public Context f21141d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f21142e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21143f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21144g;

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
        this.f21141d = context;
        this.f21140c = new Rect();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f21141d.getResources().getDisplayMetrics();
            this.f21140c.set(0, 0, this.f21139b.getWidth(), this.f21139b.getHeight());
            canvas.drawBitmap(this.f21139b, this.f21140c, this.f21138a, (Paint) null);
        }
    }
}
