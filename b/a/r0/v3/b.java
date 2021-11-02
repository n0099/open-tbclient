package b.a.r0.v3;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import b.a.e.e.p.j;
import b.a.q0.s.s.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.userblock.UserBlockInfoModel;
import com.baidu.tieba.userblock.UserBlockSetModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.GetUserBlackInfo.DataRes;
import tbclient.PermissionList;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f24467a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f24468b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.q0.s.g0.a f24469c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.q0.s.s.d f24470d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<k> f24471e;

    /* renamed from: f  reason: collision with root package name */
    public long f24472f;

    /* renamed from: g  reason: collision with root package name */
    public UserBlockSetModel f24473g;

    /* renamed from: h  reason: collision with root package name */
    public UserBlockInfoModel f24474h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f24475i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements b.a.q0.n.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f24476a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24476a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.n.a
        /* renamed from: b */
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f24476a.k();
                b.a.r0.v3.a.f((ViewGroup) this.f24476a.f24467a.getPageActivity().findViewById(16908290), str, true);
            }
        }

        @Override // b.a.q0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f24476a.k();
                b.a.r0.v3.a.f((ViewGroup) this.f24476a.f24467a.getPageActivity().findViewById(16908290), str, false);
            }
        }
    }

    /* renamed from: b.a.r0.v3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1195b implements b.a.q0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f24477a;

        public C1195b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24477a = bVar;
        }

        @Override // b.a.q0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.f24477a.f24467a == null) {
                return;
            }
            this.f24477a.f24467a.showToast(str);
        }

        @Override // b.a.q0.n.a
        public void onSuccess(Object obj) {
            int i2;
            PermissionList permissionList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (obj instanceof DataRes) {
                    DataRes dataRes = (DataRes) obj;
                    i2 = dataRes.is_black_white.intValue();
                    permissionList = dataRes.perm_list;
                } else {
                    i2 = 0;
                    permissionList = null;
                }
                if (permissionList != null) {
                    this.f24477a.m(i2, permissionList);
                } else if (this.f24477a.f24467a != null) {
                    this.f24477a.f24467a.showToast(R.string.error_unkown_try_again);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24478e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24478e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (((k) ListUtils.getItem(this.f24478e.f24471e, i2)) != null) {
                    this.f24478e.f24470d.r(true);
                }
                this.f24478e.f24470d.h(i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24479e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24479e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24479e.f24470d.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24480e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24480e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24480e.f24470d.d();
                if (this.f24480e.f24471e == null || !j.z() || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return;
                }
                Iterator it = this.f24480e.f24471e.iterator();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (it.hasNext()) {
                    k kVar = (k) it.next();
                    if (kVar.d() && "1".equals(kVar.b())) {
                        i2 = 1;
                    } else if (kVar.d() && "2".equals(kVar.b())) {
                        i3 = 1;
                    } else if (kVar.d() && "3".equals(kVar.b())) {
                        i4 = 1;
                    }
                }
                this.f24480e.o();
                this.f24480e.f24473g.C(this.f24480e.f24472f, i2, i3, i4);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24481e;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24481e = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f24481e.f24468b);
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f24475i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
        this.f24467a = tbPageContext;
        this.f24468b = bdUniqueId;
        UserBlockSetModel userBlockSetModel = new UserBlockSetModel(tbPageContext, bdUniqueId);
        this.f24473g = userBlockSetModel;
        userBlockSetModel.D(new a(this));
        UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(tbPageContext, bdUniqueId);
        this.f24474h = userBlockInfoModel;
        userBlockInfoModel.D(new C1195b(this));
    }

    public final String j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public final void k() {
        b.a.q0.s.g0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f24469c) == null) {
            return;
        }
        aVar.h(false);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f24472f = -1L;
            b.a.q0.s.g0.a aVar = this.f24469c;
            if (aVar != null) {
                aVar.h(false);
            }
            b.a.q0.s.s.d dVar = this.f24470d;
            if (dVar != null) {
                dVar.d();
            }
            UserBlockInfoModel userBlockInfoModel = this.f24474h;
            if (userBlockInfoModel != null) {
                userBlockInfoModel.onDestroy();
            }
            UserBlockSetModel userBlockSetModel = this.f24473g;
            if (userBlockSetModel != null) {
                userBlockSetModel.onDestroy();
            }
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, this.f24468b);
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f24468b);
        }
    }

    public final void m(int i2, PermissionList permissionList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, permissionList) == null) {
            boolean z = false;
            boolean z2 = permissionList != null && permissionList.follow.intValue() == 1;
            boolean z3 = permissionList != null && permissionList.interact.intValue() == 1;
            if (permissionList != null && permissionList.chat.intValue() == 1) {
                z = true;
            }
            ArrayList<k> arrayList = new ArrayList<>();
            this.f24471e = arrayList;
            if (i2 == 1) {
                arrayList.add(new k(j(R.string.block_follow), z2, "1"));
                this.f24471e.add(new k(j(R.string.block_action), z3, "2"));
                this.f24471e.add(new k(j(R.string.block_message), z, "3"));
            } else {
                arrayList.add(new k(j(R.string.block_commit), z3, "2"));
                this.f24471e.add(new k(j(R.string.block_message), z, "3"));
            }
            b.a.q0.s.s.d dVar = new b.a.q0.s.s.d(this.f24467a);
            this.f24470d = dVar;
            dVar.l(R.string.block_user_title);
            this.f24470d.k(this.f24471e, this.f24475i);
            this.f24470d.q(R.string.done, this.k);
            this.f24470d.p(R.string.cancel, this.j);
            b.a.q0.s.s.d dVar2 = this.f24470d;
            dVar2.c();
            dVar2.n();
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f24472f = j;
            this.f24474h.C(j);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f24469c == null) {
                b.a.q0.s.g0.a aVar = new b.a.q0.s.g0.a(this.f24467a);
                this.f24469c = aVar;
                aVar.e(new f(this));
            }
            this.f24469c.h(true);
        }
    }
}
