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
    public float[] f2662a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2663b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2664c;

    /* renamed from: d  reason: collision with root package name */
    public int f2665d;

    /* renamed from: e  reason: collision with root package name */
    public int f2666e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2667f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2668g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2669h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2670i;

    /* renamed from: j  reason: collision with root package name */
    public int f2671j;
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
        this.f2662a = new float[8];
        this.f2669h = false;
        this.f2670i = true;
        this.f2671j = b.f2656a;
        this.k = 1.0f;
        this.o = false;
    }
}
