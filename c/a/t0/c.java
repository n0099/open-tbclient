package c.a.t0;

import android.content.Context;
import c.a.s0.i.a;
import c.a.t0.w3.j0.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.i.a f15235b;

    /* renamed from: c  reason: collision with root package name */
    public b f15236c;

    /* renamed from: d  reason: collision with root package name */
    public MarkData f15237d;

    /* renamed from: e  reason: collision with root package name */
    public final a.InterfaceC0851a f15238e;

    /* loaded from: classes7.dex */
    public class a implements a.InterfaceC0851a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.s0.i.a.InterfaceC0851a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (z2) {
                        c.a.d.f.p.n.N(this.a.a, this.a.a.getString(R.string.add_mark));
                    } else {
                        c.a.d.f.p.n.N(this.a.a, this.a.a.getString(R.string.remove_mark));
                    }
                    if (this.a.f15236c != null) {
                        this.a.f15236c.a(z2);
                    }
                    if (this.a.f15237d != null) {
                        l lVar = new l();
                        lVar.a = this.a.f15237d.getThreadId();
                        lVar.f24847b = z2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921603, lVar));
                        return;
                    }
                    return;
                }
                c.a.d.f.p.n.N(this.a.a, this.a.a.getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z);
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15235b = null;
        this.f15238e = new a(this);
        this.a = context;
        if (context instanceof BaseActivity) {
            this.f15235b = c.a.s0.i.a.b((BaseActivity) context);
        } else if (context instanceof BaseFragmentActivity) {
            this.f15235b = c.a.s0.i.a.c((BaseFragmentActivity) context);
        }
        c.a.s0.i.a aVar = this.f15235b;
        if (aVar != null) {
            aVar.j(this.f15238e);
        }
    }

    public void d() {
        c.a.s0.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f15235b) == null) {
            return;
        }
        aVar.a();
        this.f15235b.h(true);
    }

    public void e() {
        c.a.s0.i.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (aVar = this.f15235b) != null && aVar.e()) {
            this.f15235b.d();
            this.f15235b.h(false);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.s0.i.a aVar = this.f15235b;
            if (aVar != null) {
                return aVar.e();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(boolean z) {
        c.a.s0.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (aVar = this.f15235b) == null) {
            return;
        }
        aVar.h(z);
    }

    public void h(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, markData) == null) {
            this.f15237d = markData;
            c.a.s0.i.a aVar = this.f15235b;
            if (aVar != null) {
                aVar.i(markData);
            }
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f15236c = bVar;
        }
    }
}
