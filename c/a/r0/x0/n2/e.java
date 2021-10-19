package c.a.r0.x0.n2;

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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f27499a;

    /* renamed from: b  reason: collision with root package name */
    public LongSparseArray<Integer> f27500b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.x0.x1.c f27501c;

    /* renamed from: d  reason: collision with root package name */
    public d f27502d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.x0.o2.f f27503e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f27504f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f27505g;

        public a(e eVar, c.a.r0.x0.o2.f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27503e = fVar;
            this.f27504f = str;
            this.f27505g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.x0.o2.f fVar = this.f27503e;
                if (fVar != null) {
                    fVar.n(this.f27504f, this.f27505g);
                }
                TiebaStatic.log(new StatisticItem("c13982").param("fid", this.f27505g).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public e() {
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
        this.f27499a = null;
        this.f27499a = new f();
        this.f27500b = new LongSparseArray<>();
    }

    public int a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            if (j2 == 0) {
                return 0;
            }
            Integer num = this.f27500b.get(j2);
            if (num == null) {
                this.f27500b.put(j2, 1);
                return 1;
            }
            this.f27500b.put(j2, Integer.valueOf(num.intValue() + 1));
            return num.intValue() + 1;
        }
        return invokeJ.intValue;
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || j2 == 0) {
            return;
        }
        this.f27500b.remove(j2);
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.f27499a.b(str, str2);
        }
    }

    public void d() {
        c.a.r0.x0.x1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cVar = this.f27501c) == null) {
            return;
        }
        cVar.m();
    }

    public f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27499a : (f) invokeV.objValue;
    }

    public void f(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, str2) == null) && activity != null && this.f27502d.c()) {
            if (this.f27501c == null) {
                this.f27501c = new c.a.r0.x0.x1.c(activity, R.id.frs_guide_delete_forum_tip);
            }
            this.f27501c.p(str);
            this.f27501c.q(str2);
            this.f27501c.r();
        }
    }

    public boolean g(String str, String str2) {
        InterceptResult invokeLL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (fVar = this.f27499a) == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - fVar.f(str, str2);
            if (currentTimeMillis < 3600000) {
                return false;
            }
            if (this.f27499a.e(str, str2) <= 3 || currentTimeMillis >= 2592000000L) {
                long c2 = this.f27499a.c(str, str2);
                if (c2 == 0 || System.currentTimeMillis() - c2 > 604800000) {
                    return this.f27499a.d(str, str2);
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void h(Activity activity, String str, String str2, String str3, c.a.r0.x0.o2.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048583, this, activity, str, str2, str3, fVar) == null) || activity == null) {
            return;
        }
        if (this.f27501c == null) {
            this.f27501c = new c.a.r0.x0.x1.c(activity, R.id.frs_guide_tip);
        }
        if (!StringUtils.isNull(str3)) {
            this.f27501c.n(str3);
        }
        this.f27501c.o(new a(this, fVar, str, str2));
        this.f27501c.s();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27499a = null;
        this.f27502d = new d(str, str2);
    }
}
