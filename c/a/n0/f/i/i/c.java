package c.a.n0.f.i.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f10243a;

    /* renamed from: b  reason: collision with root package name */
    public int f10244b;

    /* renamed from: c  reason: collision with root package name */
    public int f10245c;

    /* renamed from: d  reason: collision with root package name */
    public int f10246d;

    /* renamed from: e  reason: collision with root package name */
    public int f10247e;

    /* renamed from: f  reason: collision with root package name */
    public int f10248f;

    public c(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10243a = i2;
        this.f10244b = i3;
        this.f10245c = i4;
        this.f10246d = i5;
    }
}
