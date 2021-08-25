package c.a.e.f.a;

import android.graphics.Matrix;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float[] f2720a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2721b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2722c;

    /* renamed from: d  reason: collision with root package name */
    public int f2723d;

    /* renamed from: e  reason: collision with root package name */
    public int f2724e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2725f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2726g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2727h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2728i;

    /* renamed from: j  reason: collision with root package name */
    public int f2729j;
    public float k;
    public Matrix l;
    public int m;
    public boolean n;
    public boolean o;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2720a = new float[8];
        this.f2727h = false;
        this.f2728i = true;
        this.f2729j = b.f2714a;
        this.k = 1.0f;
        this.o = false;
    }
}
