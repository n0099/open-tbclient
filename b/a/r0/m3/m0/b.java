package b.a.r0.m3.m0;

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
    public Rect f22555a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f22556b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f22557c;

    /* renamed from: d  reason: collision with root package name */
    public Context f22558d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f22559e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22560f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22561g;

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
        this.f22558d = context;
        this.f22557c = new Rect();
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.f22558d.getResources().getDisplayMetrics();
            this.f22557c.set(0, 0, this.f22556b.getWidth(), this.f22556b.getHeight());
            canvas.drawBitmap(this.f22556b, this.f22557c, this.f22555a, (Paint) null);
        }
    }
}
