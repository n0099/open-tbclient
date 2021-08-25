package c.a.q0;

import android.content.Context;
import c.a.p0.i.a;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f16535a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.i.a f16536b;

    /* renamed from: c  reason: collision with root package name */
    public b f16537c;

    /* renamed from: d  reason: collision with root package name */
    public MarkData f16538d;

    /* renamed from: e  reason: collision with root package name */
    public final a.InterfaceC0671a f16539e;

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0671a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f16540a;

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
            this.f16540a = cVar;
        }

        @Override // c.a.p0.i.a.InterfaceC0671a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (z2) {
                        c.a.e.e.p.l.M(this.f16540a.f16535a, this.f16540a.f16535a.getString(R.string.add_mark));
                    } else {
                        c.a.e.e.p.l.M(this.f16540a.f16535a, this.f16540a.f16535a.getString(R.string.remove_mark));
                    }
                    if (this.f16540a.f16537c != null) {
                        this.f16540a.f16537c.a(z2);
                    }
                    if (this.f16540a.f16538d != null) {
                        c.a.q0.i3.i0.l lVar = new c.a.q0.i3.i0.l();
                        lVar.f20292a = this.f16540a.f16538d.getThreadId();
                        lVar.f20293b = z2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921603, lVar));
                        return;
                    }
                    return;
                }
                c.a.e.e.p.l.M(this.f16540a.f16535a, this.f16540a.f16535a.getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f16536b = null;
        this.f16539e = new a(this);
        this.f16535a = context;
        if (context instanceof BaseActivity) {
            this.f16536b = c.a.p0.i.a.b((BaseActivity) context);
        } else if (context instanceof BaseFragmentActivity) {
            this.f16536b = c.a.p0.i.a.c((BaseFragmentActivity) context);
        }
        c.a.p0.i.a aVar = this.f16536b;
        if (aVar != null) {
            aVar.j(this.f16539e);
        }
    }

    public void d() {
        c.a.p0.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f16536b) == null) {
            return;
        }
        aVar.a();
        this.f16536b.h(true);
    }

    public void e() {
        c.a.p0.i.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (aVar = this.f16536b) != null && aVar.e()) {
            this.f16536b.d();
            this.f16536b.h(false);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.i.a aVar = this.f16536b;
            if (aVar != null) {
                return aVar.e();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(boolean z) {
        c.a.p0.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (aVar = this.f16536b) == null) {
            return;
        }
        aVar.h(z);
    }

    public void h(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, markData) == null) {
            this.f16538d = markData;
            c.a.p0.i.a aVar = this.f16536b;
            if (aVar != null) {
                aVar.i(markData);
            }
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f16537c = bVar;
        }
    }
}
