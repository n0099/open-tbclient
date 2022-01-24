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
    public int f30453b;

    /* renamed from: c  reason: collision with root package name */
    public int f30454c;

    /* renamed from: d  reason: collision with root package name */
    public n4 f30455d;

    /* renamed from: e  reason: collision with root package name */
    public List f30456e;

    /* renamed from: f  reason: collision with root package name */
    public int f30457f;

    /* renamed from: g  reason: collision with root package name */
    public int f30458g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30459h;

    /* renamed from: i  reason: collision with root package name */
    public int f30460i;

    /* renamed from: j  reason: collision with root package name */
    public int f30461j;
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
        this.f30453b = 0;
        this.f30454c = 0;
        this.f30456e = new ArrayList();
        this.m = 0;
    }
}
