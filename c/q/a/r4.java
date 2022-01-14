package c.q.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class r4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f30425b;

    /* renamed from: c  reason: collision with root package name */
    public int f30426c;

    /* renamed from: d  reason: collision with root package name */
    public n4 f30427d;

    /* renamed from: e  reason: collision with root package name */
    public List f30428e;

    /* renamed from: f  reason: collision with root package name */
    public int f30429f;

    /* renamed from: g  reason: collision with root package name */
    public int f30430g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30431h;

    /* renamed from: i  reason: collision with root package name */
    public int f30432i;

    /* renamed from: j  reason: collision with root package name */
    public int f30433j;
    public int k;
    public int l;
    public int m;

    public r4() {
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
        this.f30425b = 0;
        this.f30426c = 0;
        this.f30428e = new ArrayList();
        this.m = 0;
    }
}
