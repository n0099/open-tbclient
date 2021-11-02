package b.a.r0;

import android.content.Context;
import b.a.q0.i.a;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f15082a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.q0.i.a f15083b;

    /* renamed from: c  reason: collision with root package name */
    public b f15084c;

    /* renamed from: d  reason: collision with root package name */
    public MarkData f15085d;

    /* renamed from: e  reason: collision with root package name */
    public final a.InterfaceC0664a f15086e;

    /* loaded from: classes4.dex */
    public class a implements a.InterfaceC0664a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f15087a;

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
            this.f15087a = cVar;
        }

        @Override // b.a.q0.i.a.InterfaceC0664a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (z2) {
                        b.a.e.e.p.l.M(this.f15087a.f15082a, this.f15087a.f15082a.getString(R.string.add_mark));
                    } else {
                        b.a.e.e.p.l.M(this.f15087a.f15082a, this.f15087a.f15082a.getString(R.string.remove_mark));
                    }
                    if (this.f15087a.f15084c != null) {
                        this.f15087a.f15084c.a(z2);
                    }
                    if (this.f15087a.f15085d != null) {
                        b.a.r0.l3.j0.l lVar = new b.a.r0.l3.j0.l();
                        lVar.f20618a = this.f15087a.f15085d.getThreadId();
                        lVar.f20619b = z2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921603, lVar));
                        return;
                    }
                    return;
                }
                b.a.e.e.p.l.M(this.f15087a.f15082a, this.f15087a.f15082a.getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f15083b = null;
        this.f15086e = new a(this);
        this.f15082a = context;
        if (context instanceof BaseActivity) {
            this.f15083b = b.a.q0.i.a.b((BaseActivity) context);
        } else if (context instanceof BaseFragmentActivity) {
            this.f15083b = b.a.q0.i.a.c((BaseFragmentActivity) context);
        }
        b.a.q0.i.a aVar = this.f15083b;
        if (aVar != null) {
            aVar.j(this.f15086e);
        }
    }

    public void d() {
        b.a.q0.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f15083b) == null) {
            return;
        }
        aVar.a();
        this.f15083b.h(true);
    }

    public void e() {
        b.a.q0.i.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (aVar = this.f15083b) != null && aVar.e()) {
            this.f15083b.d();
            this.f15083b.h(false);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.q0.i.a aVar = this.f15083b;
            if (aVar != null) {
                return aVar.e();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(boolean z) {
        b.a.q0.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (aVar = this.f15083b) == null) {
            return;
        }
        aVar.h(z);
    }

    public void h(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, markData) == null) {
            this.f15085d = markData;
            b.a.q0.i.a aVar = this.f15083b;
            if (aVar != null) {
                aVar.i(markData);
            }
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f15084c = bVar;
        }
    }
}
