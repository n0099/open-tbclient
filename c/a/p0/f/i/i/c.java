package c.a.p0.f.i.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f10525a;

    /* renamed from: b  reason: collision with root package name */
    public int f10526b;

    /* renamed from: c  reason: collision with root package name */
    public int f10527c;

    /* renamed from: d  reason: collision with root package name */
    public int f10528d;

    /* renamed from: e  reason: collision with root package name */
    public int f10529e;

    /* renamed from: f  reason: collision with root package name */
    public int f10530f;

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
        this.f10525a = i2;
        this.f10526b = i3;
        this.f10527c = i4;
        this.f10528d = i5;
    }
}
