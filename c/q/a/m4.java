package c.q.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class m4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f29030b;

    /* renamed from: c  reason: collision with root package name */
    public int f29031c;

    /* renamed from: d  reason: collision with root package name */
    public i4 f29032d;

    /* renamed from: e  reason: collision with root package name */
    public List f29033e;

    /* renamed from: f  reason: collision with root package name */
    public int f29034f;

    /* renamed from: g  reason: collision with root package name */
    public int f29035g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29036h;

    /* renamed from: i  reason: collision with root package name */
    public int f29037i;

    /* renamed from: j  reason: collision with root package name */
    public int f29038j;
    public int k;
    public int l;
    public int m;

    public m4() {
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
        this.a = null;
        this.f29030b = 0;
        this.f29031c = 0;
        this.f29033e = new ArrayList();
        this.m = 0;
    }
}
