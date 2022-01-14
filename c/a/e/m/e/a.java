package c.a.e.m.e;

import c.a.t0.x1.o.h.b;
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
public class a implements c.a.t0.x1.o.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f3457e;

    /* renamed from: f  reason: collision with root package name */
    public String f3458f;

    /* renamed from: g  reason: collision with root package name */
    public String f3459g;

    /* renamed from: h  reason: collision with root package name */
    public String f3460h;

    /* renamed from: i  reason: collision with root package name */
    public String f3461i;

    /* renamed from: j  reason: collision with root package name */
    public int f3462j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public boolean r;
    public int s;
    public int t;
    public ArrayList<String> u;
    public ArrayList<String> v;
    public b.a w;

    public a() {
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
        this.f3457e = 3;
        this.u = new ArrayList<>();
        this.v = new ArrayList<>();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3457e : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (StringUtils.isNull(this.o)) {
                return TbadkCoreApplication.getInst().getResources().getString(R.string.check_detail);
            }
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3457e == 2 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (a() != 0) {
                return a() == 1 && (str = this.l) != null && (str.startsWith("http://") || this.l.startsWith("https://"));
            }
            String str2 = this.k;
            return str2 != null && (str2.startsWith("http://") || this.k.startsWith("https://"));
        }
        return invokeV.booleanValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f3457e = i2;
        }
    }

    @Override // c.a.t0.x1.o.h.b
    public b.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.w == null) {
                b.a aVar = new b.a();
                this.w = aVar;
                aVar.f25163c = this.u;
                aVar.f25164d = this.v;
            }
            return this.w;
        }
        return (b.a) invokeV.objValue;
    }
}
