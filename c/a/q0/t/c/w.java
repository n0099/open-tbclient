package c.a.q0.t.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f14755a;

    /* renamed from: b  reason: collision with root package name */
    public String f14756b;

    /* renamed from: c  reason: collision with root package name */
    public String f14757c;

    /* renamed from: d  reason: collision with root package name */
    public int f14758d;

    /* renamed from: e  reason: collision with root package name */
    public int f14759e;

    /* renamed from: f  reason: collision with root package name */
    public int f14760f;

    /* renamed from: g  reason: collision with root package name */
    public int f14761g;

    /* renamed from: h  reason: collision with root package name */
    public int f14762h;

    public w() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
