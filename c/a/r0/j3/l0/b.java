package c.a.r0.j3.l0;

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
    public Rect f20960a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f20961b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f20962c;

    /* renamed from: d  reason: collision with root package name */
    public Context f20963d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f20964e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20965f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20966g;

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
        this.f20963d = context;
        this.f20962c = new Rect();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f20963d.getResources().getDisplayMetrics();
            this.f20962c.set(0, 0, this.f20961b.getWidth(), this.f20961b.getHeight());
            canvas.drawBitmap(this.f20961b, this.f20962c, this.f20960a, (Paint) null);
        }
    }
}
