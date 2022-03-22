package c.m.a;

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
    public int f23498b;

    /* renamed from: c  reason: collision with root package name */
    public int f23499c;

    /* renamed from: d  reason: collision with root package name */
    public i4 f23500d;

    /* renamed from: e  reason: collision with root package name */
    public List f23501e;

    /* renamed from: f  reason: collision with root package name */
    public int f23502f;

    /* renamed from: g  reason: collision with root package name */
    public int f23503g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23504h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    public m4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f23498b = 0;
        this.f23499c = 0;
        this.f23501e = new ArrayList();
        this.m = 0;
    }
}
