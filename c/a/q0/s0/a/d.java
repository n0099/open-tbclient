package c.a.q0.s0.a;

import c.a.q0.a4.a;
import c.a.q0.s0.a.c;
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
    public TbPageContext f24267a;

    /* renamed from: b  reason: collision with root package name */
    public RemoveFansController f24268b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.s0.a.c f24269c;

    /* renamed from: d  reason: collision with root package name */
    public PersonInfoMoreDialog f24270d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.a4.a f24271e;

    /* renamed from: f  reason: collision with root package name */
    public e f24272f;

    /* loaded from: classes3.dex */
    public class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24273a;

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
            this.f24273a = dVar;
        }

        @Override // c.a.q0.s0.a.c.b
        public void a(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) || this.f24273a.f24272f == null) {
                return;
            }
            this.f24273a.f24272f.b(i2, str, z, 0, 0L);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24274a;

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
            this.f24274a = dVar;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i2, String str, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), Boolean.valueOf(z)}) == null) || this.f24274a.f24272f == null) {
                return;
            }
            this.f24274a.f24272f.b(i2, str, z, 1, j2);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24275a;

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
            this.f24275a = dVar;
        }

        @Override // c.a.q0.a4.a.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24275a.f24270d.dismiss();
                if (this.f24275a.f24272f != null) {
                    this.f24275a.f24272f.a();
                }
                this.f24275a.f24269c.d();
            }
        }
    }

    /* renamed from: c.a.q0.s0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1120d implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f24276a;

        public C1120d(d dVar) {
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
            this.f24276a = dVar;
        }

        @Override // c.a.q0.a4.a.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f24276a.f24270d == null) {
                return;
            }
            this.f24276a.f24270d.dismiss();
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
        this.f24267a = tbPageContext;
        c.a.q0.s0.a.c cVar = new c.a.q0.s0.a.c(tbPageContext, bdUniqueId);
        this.f24269c = cVar;
        cVar.e(new a(this));
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, bdUniqueId);
        this.f24268b = removeFansController;
        removeFansController.setResultCallBack(new b(this));
    }

    public void d() {
        c.a.q0.a4.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f24271e) == null) {
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
            this.f24268b.removeFans(j2);
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f24272f = eVar;
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f24270d == null) {
                c.a.q0.a4.a aVar = new c.a.q0.a4.a(this.f24267a.getContext());
                this.f24271e = aVar;
                aVar.i(this.f24267a.getString(R.string.confirm_remove_all_forbidden_fans));
                ArrayList arrayList = new ArrayList();
                a.b bVar = new a.b(this.f24267a.getString(R.string.confirm), this.f24271e);
                bVar.h(new c(this));
                arrayList.add(bVar);
                this.f24271e.h(new C1120d(this));
                this.f24271e.g(arrayList);
                PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(this.f24267a.getPageActivity(), this.f24271e.b());
                this.f24270d = personInfoMoreDialog;
                personInfoMoreDialog.setWindowDimAmount(0.7f);
            }
            this.f24270d.show();
        }
    }
}
