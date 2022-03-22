package c.a.p0;

import android.content.Context;
import c.a.o0.h.a;
import c.a.p0.a4.k0.l;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.h.a f12846b;

    /* renamed from: c  reason: collision with root package name */
    public b f12847c;

    /* renamed from: d  reason: collision with root package name */
    public MarkData f12848d;

    /* renamed from: e  reason: collision with root package name */
    public final a.InterfaceC0810a f12849e;

    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0810a {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.o0.h.a.InterfaceC0810a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (z2) {
                        c.a.d.f.p.n.N(this.a.a, this.a.a.getString(R.string.obfuscated_res_0x7f0f00cc));
                    } else {
                        c.a.d.f.p.n.N(this.a.a, this.a.a.getString(R.string.obfuscated_res_0x7f0f0f80));
                    }
                    if (this.a.f12847c != null) {
                        this.a.f12847c.a(z2);
                    }
                    if (this.a.f12848d != null) {
                        l lVar = new l();
                        lVar.a = this.a.f12848d.getThreadId();
                        lVar.f12245b = z2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921603, lVar));
                        return;
                    }
                    return;
                }
                c.a.d.f.p.n.N(this.a.a, this.a.a.getString(R.string.obfuscated_res_0x7f0f1486));
            }
        }
    }

    /* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12846b = null;
        this.f12849e = new a(this);
        this.a = context;
        if (context instanceof BaseActivity) {
            this.f12846b = c.a.o0.h.a.b((BaseActivity) context);
        } else if (context instanceof BaseFragmentActivity) {
            this.f12846b = c.a.o0.h.a.c((BaseFragmentActivity) context);
        }
        c.a.o0.h.a aVar = this.f12846b;
        if (aVar != null) {
            aVar.j(this.f12849e);
        }
    }

    public void d() {
        c.a.o0.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f12846b) == null) {
            return;
        }
        aVar.a();
        this.f12846b.h(true);
    }

    public void e() {
        c.a.o0.h.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (aVar = this.f12846b) != null && aVar.e()) {
            this.f12846b.d();
            this.f12846b.h(false);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.o0.h.a aVar = this.f12846b;
            if (aVar != null) {
                return aVar.e();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(boolean z) {
        c.a.o0.h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (aVar = this.f12846b) == null) {
            return;
        }
        aVar.h(z);
    }

    public void h(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, markData) == null) {
            this.f12848d = markData;
            c.a.o0.h.a aVar = this.f12846b;
            if (aVar != null) {
                aVar.i(markData);
            }
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f12847c = bVar;
        }
    }
}
