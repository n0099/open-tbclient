package c.a.r0.u0.a;

import c.a.r0.c4.a;
import c.a.r0.u0.a.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonInfoMoreDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25129a;

    /* renamed from: b  reason: collision with root package name */
    public RemoveFansController f25130b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.u0.a.c f25131c;

    /* renamed from: d  reason: collision with root package name */
    public PersonInfoMoreDialog f25132d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.c4.a f25133e;

    /* renamed from: f  reason: collision with root package name */
    public e f25134f;

    /* loaded from: classes3.dex */
    public class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25135a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25135a = dVar;
        }

        @Override // c.a.r0.u0.a.c.b
        public void a(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) || this.f25135a.f25134f == null) {
                return;
            }
            this.f25135a.f25134f.b(i2, str, z, 0, 0L);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25136a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25136a = dVar;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i2, String str, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), Boolean.valueOf(z)}) == null) || this.f25136a.f25134f == null) {
                return;
            }
            this.f25136a.f25134f.b(i2, str, z, 1, j2);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25137a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25137a = dVar;
        }

        @Override // c.a.r0.c4.a.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25137a.f25132d.dismiss();
                if (this.f25137a.f25134f != null) {
                    this.f25137a.f25134f.a();
                }
                this.f25137a.f25131c.d();
            }
        }
    }

    /* renamed from: c.a.r0.u0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1165d implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f25138a;

        public C1165d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25138a = dVar;
        }

        @Override // c.a.r0.c4.a.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25138a.f25132d == null) {
                return;
            }
            this.f25138a.f25132d.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();

        void b(int i2, String str, boolean z, int i3, long j2);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25129a = tbPageContext;
        c.a.r0.u0.a.c cVar = new c.a.r0.u0.a.c(tbPageContext, bdUniqueId);
        this.f25131c = cVar;
        cVar.e(new a(this));
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, bdUniqueId);
        this.f25130b = removeFansController;
        removeFansController.setResultCallBack(new b(this));
    }

    public void d() {
        c.a.r0.c4.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f25133e) == null) {
            return;
        }
        aVar.f();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h();
        }
    }

    public void f(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f25130b.removeFans(j2);
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f25134f = eVar;
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f25132d == null) {
                c.a.r0.c4.a aVar = new c.a.r0.c4.a(this.f25129a.getContext());
                this.f25133e = aVar;
                aVar.i(this.f25129a.getString(R.string.confirm_remove_all_forbidden_fans));
                ArrayList arrayList = new ArrayList();
                a.b bVar = new a.b(this.f25129a.getString(R.string.confirm), this.f25133e);
                bVar.h(new c(this));
                arrayList.add(bVar);
                this.f25133e.h(new C1165d(this));
                this.f25133e.g(arrayList);
                PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(this.f25129a.getPageActivity(), this.f25133e.b());
                this.f25132d = personInfoMoreDialog;
                personInfoMoreDialog.setWindowDimAmount(0.7f);
            }
            this.f25132d.show();
        }
    }
}
