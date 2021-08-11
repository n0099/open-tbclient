package c.a.p0.i3.k0;

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
    public Rect f20051a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f20052b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f20053c;

    /* renamed from: d  reason: collision with root package name */
    public Context f20054d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f20055e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20056f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20057g;

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
        this.f20054d = context;
        this.f20053c = new Rect();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f20054d.getResources().getDisplayMetrics();
            this.f20053c.set(0, 0, this.f20052b.getWidth(), this.f20052b.getHeight());
            canvas.drawBitmap(this.f20052b, this.f20053c, this.f20051a, (Paint) null);
        }
    }
}
