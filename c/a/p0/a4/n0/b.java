package c.a.p0.a4.n0;

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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f12307b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f12308c;

    /* renamed from: d  reason: collision with root package name */
    public Context f12309d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f12310e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12311f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12312g;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12309d = context;
        this.f12308c = new Rect();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f12309d.getResources().getDisplayMetrics();
            this.f12308c.set(0, 0, this.f12307b.getWidth(), this.f12307b.getHeight());
            canvas.drawBitmap(this.f12307b, this.f12308c, this.a, (Paint) null);
        }
    }
}
