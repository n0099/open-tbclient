package b.o.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f34289a;

    /* renamed from: b  reason: collision with root package name */
    public int f34290b;

    /* renamed from: c  reason: collision with root package name */
    public int f34291c;

    /* renamed from: d  reason: collision with root package name */
    public n4 f34292d;

    /* renamed from: e  reason: collision with root package name */
    public List f34293e;

    /* renamed from: f  reason: collision with root package name */
    public int f34294f;

    /* renamed from: g  reason: collision with root package name */
    public int f34295g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34296h;

    /* renamed from: i  reason: collision with root package name */
    public int f34297i;
    public int j;
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
        this.f34289a = null;
        this.f34290b = 0;
        this.f34291c = 0;
        this.f34293e = new ArrayList();
        this.m = 0;
    }
}
