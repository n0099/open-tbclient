package b.a.r0.u0.a;

import b.a.r0.c4.a;
import b.a.r0.u0.a.c;
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
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f23973a;

    /* renamed from: b  reason: collision with root package name */
    public RemoveFansController f23974b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.u0.a.c f23975c;

    /* renamed from: d  reason: collision with root package name */
    public PersonInfoMoreDialog f23976d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.c4.a f23977e;

    /* renamed from: f  reason: collision with root package name */
    public e f23978f;

    /* loaded from: classes5.dex */
    public class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23979a;

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
            this.f23979a = dVar;
        }

        @Override // b.a.r0.u0.a.c.b
        public void a(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) || this.f23979a.f23978f == null) {
                return;
            }
            this.f23979a.f23978f.b(i2, str, z, 0, 0L);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23980a;

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
            this.f23980a = dVar;
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i2, String str, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j), Boolean.valueOf(z)}) == null) || this.f23980a.f23978f == null) {
                return;
            }
            this.f23980a.f23978f.b(i2, str, z, 1, j);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23981a;

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
            this.f23981a = dVar;
        }

        @Override // b.a.r0.c4.a.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23981a.f23976d.dismiss();
                if (this.f23981a.f23978f != null) {
                    this.f23981a.f23978f.a();
                }
                this.f23981a.f23975c.d();
            }
        }
    }

    /* renamed from: b.a.r0.u0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1164d implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f23982a;

        public C1164d(d dVar) {
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
            this.f23982a = dVar;
        }

        @Override // b.a.r0.c4.a.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23982a.f23976d == null) {
                return;
            }
            this.f23982a.f23976d.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b(int i2, String str, boolean z, int i3, long j);
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
        this.f23973a = tbPageContext;
        b.a.r0.u0.a.c cVar = new b.a.r0.u0.a.c(tbPageContext, bdUniqueId);
        this.f23975c = cVar;
        cVar.e(new a(this));
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, bdUniqueId);
        this.f23974b = removeFansController;
        removeFansController.setResultCallBack(new b(this));
    }

    public void d() {
        b.a.r0.c4.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f23977e) == null) {
            return;
        }
        aVar.e();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h();
        }
    }

    public void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f23974b.removeFans(j);
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f23978f = eVar;
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f23976d == null) {
                b.a.r0.c4.a aVar = new b.a.r0.c4.a(this.f23973a.getContext());
                this.f23977e = aVar;
                aVar.h(this.f23973a.getString(R.string.confirm_remove_all_forbidden_fans));
                ArrayList arrayList = new ArrayList();
                a.b bVar = new a.b(this.f23973a.getString(R.string.confirm), this.f23977e);
                bVar.h(new c(this));
                arrayList.add(bVar);
                this.f23977e.g(new C1164d(this));
                this.f23977e.f(arrayList);
                PersonInfoMoreDialog personInfoMoreDialog = new PersonInfoMoreDialog(this.f23973a.getPageActivity(), this.f23977e.b());
                this.f23976d = personInfoMoreDialog;
                personInfoMoreDialog.setWindowDimAmount(0.7f);
            }
            this.f23976d.show();
        }
    }
}
