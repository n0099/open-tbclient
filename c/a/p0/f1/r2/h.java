package c.a.p0.f1.r2;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i a;

    /* renamed from: b  reason: collision with root package name */
    public LongSparseArray<Integer> f14481b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.f1.z1.c f14482c;

    /* renamed from: d  reason: collision with root package name */
    public g f14483d;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.f1.s2.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f14484b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f14485c;

        public a(h hVar, c.a.p0.f1.s2.f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f14484b = str;
            this.f14485c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.f1.s2.f fVar = this.a;
                if (fVar != null) {
                    fVar.o(this.f14484b, this.f14485c);
                }
                TiebaStatic.log(new StatisticItem("c13982").param("fid", this.f14485c).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public h() {
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
        this.a = new i();
        this.f14481b = new LongSparseArray<>();
    }

    public int a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (j == 0) {
                return 0;
            }
            Integer num = this.f14481b.get(j);
            if (num == null) {
                this.f14481b.put(j, 1);
                return 1;
            }
            this.f14481b.put(j, Integer.valueOf(num.intValue() + 1));
            return num.intValue() + 1;
        }
        return invokeJ.intValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || j == 0) {
            return;
        }
        this.f14481b.remove(j);
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.a.b(str, str2);
        }
    }

    public void d() {
        c.a.p0.f1.z1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f14482c) == null) {
            return;
        }
        cVar.m();
    }

    public i e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (i) invokeV.objValue;
    }

    public void f(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, str2) == null) && activity != null && this.f14483d.c()) {
            if (this.f14482c == null) {
                this.f14482c = new c.a.p0.f1.z1.c(activity, R.id.obfuscated_res_0x7f090b1d);
            }
            this.f14482c.p(str);
            this.f14482c.q(str2);
            this.f14482c.r();
        }
    }

    public boolean g(String str, String str2) {
        InterceptResult invokeLL;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (iVar = this.a) == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - iVar.f(str, str2);
            if (currentTimeMillis < 3600000) {
                return false;
            }
            if (this.a.e(str, str2) <= 3 || currentTimeMillis >= 2592000000L) {
                long c2 = this.a.c(str, str2);
                if (c2 == 0 || System.currentTimeMillis() - c2 > 604800000) {
                    return this.a.d(str, str2);
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void h(Activity activity, String str, String str2, String str3, c.a.p0.f1.s2.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048583, this, activity, str, str2, str3, fVar) == null) || activity == null) {
            return;
        }
        if (this.f14482c == null) {
            this.f14482c = new c.a.p0.f1.z1.c(activity, R.id.obfuscated_res_0x7f090b21);
        }
        if (!StringUtils.isNull(str3)) {
            this.f14482c.n(str3);
        }
        this.f14482c.o(new a(this, fVar, str, str2));
        this.f14482c.s();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f14483d = new g(str, str2);
    }
}
