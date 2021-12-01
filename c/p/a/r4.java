package c.p.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class r4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f30898b;

    /* renamed from: c  reason: collision with root package name */
    public int f30899c;

    /* renamed from: d  reason: collision with root package name */
    public n4 f30900d;

    /* renamed from: e  reason: collision with root package name */
    public List f30901e;

    /* renamed from: f  reason: collision with root package name */
    public int f30902f;

    /* renamed from: g  reason: collision with root package name */
    public int f30903g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30904h;

    /* renamed from: i  reason: collision with root package name */
    public int f30905i;

    /* renamed from: j  reason: collision with root package name */
    public int f30906j;

    /* renamed from: k  reason: collision with root package name */
    public int f30907k;
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
        this.f30898b = 0;
        this.f30899c = 0;
        this.f30901e = new ArrayList();
        this.m = 0;
    }
}
