package c.a.o0.r.m0.b;

import c.a.d.f.q.h;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f10731b;

    /* renamed from: c  reason: collision with root package name */
    public int f10732c;

    /* renamed from: d  reason: collision with root package name */
    public String f10733d;

    public a() {
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
        this.f10731b = null;
        this.f10732c = 0;
        this.f10733d = null;
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            switch (i) {
                case 1:
                    return h.a(R.string.obfuscated_res_0x7f0f150d);
                case 2:
                    return h.a(R.string.obfuscated_res_0x7f0f1512);
                case 3:
                    return h.a(R.string.obfuscated_res_0x7f0f0c15);
                case 4:
                    return h.a(R.string.obfuscated_res_0x7f0f1510);
                case 5:
                    return h.a(R.string.obfuscated_res_0x7f0f150e);
                case 6:
                    return h.a(R.string.obfuscated_res_0x7f0f1511);
                case 7:
                    return h.a(R.string.obfuscated_res_0x7f0f150f);
                default:
                    return "";
            }
        }
        return (String) invokeI.objValue;
    }
}
