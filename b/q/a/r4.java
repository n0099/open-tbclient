package b.q.a;

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
    public int[] f33455a;

    /* renamed from: b  reason: collision with root package name */
    public int f33456b;

    /* renamed from: c  reason: collision with root package name */
    public int f33457c;

    /* renamed from: d  reason: collision with root package name */
    public n4 f33458d;

    /* renamed from: e  reason: collision with root package name */
    public List f33459e;

    /* renamed from: f  reason: collision with root package name */
    public int f33460f;

    /* renamed from: g  reason: collision with root package name */
    public int f33461g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33462h;

    /* renamed from: i  reason: collision with root package name */
    public int f33463i;
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
        this.f33455a = null;
        this.f33456b = 0;
        this.f33457c = 0;
        this.f33459e = new ArrayList();
        this.m = 0;
    }
}
