package c.a.e.m.e;

import c.a.p0.b2.o.h.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements c.a.p0.b2.o.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f2691b;

    /* renamed from: c  reason: collision with root package name */
    public String f2692c;

    /* renamed from: d  reason: collision with root package name */
    public String f2693d;

    /* renamed from: e  reason: collision with root package name */
    public String f2694e;

    /* renamed from: f  reason: collision with root package name */
    public int f2695f;

    /* renamed from: g  reason: collision with root package name */
    public String f2696g;

    /* renamed from: h  reason: collision with root package name */
    public String f2697h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public int p;
    public ArrayList<String> q;
    public ArrayList<String> r;
    public b.a s;

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
        this.a = 3;
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (StringUtils.isNull(this.k)) {
                return TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03a9);
            }
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a == 2 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (a() != 0) {
                return a() == 1 && (str = this.f2697h) != null && (str.startsWith("http://") || this.f2697h.startsWith("https://"));
            }
            String str2 = this.f2696g;
            return str2 != null && (str2.startsWith("http://") || this.f2696g.startsWith("https://"));
        }
        return invokeV.booleanValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a = i;
        }
    }

    @Override // c.a.p0.b2.o.h.b
    public b.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.s == null) {
                b.a aVar = new b.a();
                this.s = aVar;
                aVar.f12509c = this.q;
                aVar.f12510d = this.r;
            }
            return this.s;
        }
        return (b.a) invokeV.objValue;
    }
}
