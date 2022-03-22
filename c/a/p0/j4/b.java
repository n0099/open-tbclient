package c.a.p0.j4;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import c.a.d.f.p.l;
import c.a.o0.r.t.n;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f15908b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.r.l0.a f15909c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.r.t.f f15910d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f15911e;

    /* renamed from: f  reason: collision with root package name */
    public long f15912f;

    /* renamed from: g  reason: collision with root package name */
    public UserBlockSetModel f15913g;

    /* renamed from: h  reason: collision with root package name */
    public UserBlockInfoModel f15914h;
    public AdapterView.OnItemClickListener i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes2.dex */
    public class a implements c.a.o0.m.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.m.a
        /* renamed from: b */
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.k();
                c.a.p0.j4.a.f((ViewGroup) this.a.a.getPageActivity().findViewById(16908290), str, true);
            }
        }

        @Override // c.a.o0.m.a
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.k();
                c.a.p0.j4.a.f((ViewGroup) this.a.a.getPageActivity().findViewById(16908290), str, false);
            }
        }
    }

    /* renamed from: c.a.p0.j4.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1191b implements c.a.o0.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1191b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.o0.m.a
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) || this.a.a == null) {
                return;
            }
            this.a.a.showToast(str);
        }

        @Override // c.a.o0.m.a
        public void onSuccess(Object obj) {
            int i;
            PermissionList permissionList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (obj instanceof DataRes) {
                    DataRes dataRes = (DataRes) obj;
                    i = dataRes.is_black_white.intValue();
                    permissionList = dataRes.perm_list;
                } else {
                    i = 0;
                    permissionList = null;
                }
                if (permissionList != null) {
                    this.a.m(i, permissionList);
                } else if (this.a.a != null) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0598);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (((n) ListUtils.getItem(this.a.f15911e, i)) != null) {
                    this.a.f15910d.r(true);
                }
                this.a.f15910d.h(i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f15910d.d();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f15910d.d();
                if (this.a.f15911e == null || !l.z() || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return;
                }
                Iterator it = this.a.f15911e.iterator();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    n nVar = (n) it.next();
                    if (nVar.d() && "1".equals(nVar.b())) {
                        i = 1;
                    } else if (nVar.d() && "2".equals(nVar.b())) {
                        i2 = 1;
                    } else if (nVar.d() && "3".equals(nVar.b())) {
                        i3 = 1;
                    }
                }
                this.a.o();
                this.a.f15913g.E(this.a.f15912f, i, i2, i3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.a.f15908b);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
        this.a = tbPageContext;
        this.f15908b = bdUniqueId;
        UserBlockSetModel userBlockSetModel = new UserBlockSetModel(tbPageContext, bdUniqueId);
        this.f15913g = userBlockSetModel;
        userBlockSetModel.F(new a(this));
        UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(tbPageContext, bdUniqueId);
        this.f15914h = userBlockInfoModel;
        userBlockInfoModel.F(new C1191b(this));
    }

    public final String j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public final void k() {
        c.a.o0.r.l0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f15909c) == null) {
            return;
        }
        aVar.h(false);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15912f = -1L;
            c.a.o0.r.l0.a aVar = this.f15909c;
            if (aVar != null) {
                aVar.h(false);
            }
            c.a.o0.r.t.f fVar = this.f15910d;
            if (fVar != null) {
                fVar.d();
            }
            UserBlockInfoModel userBlockInfoModel = this.f15914h;
            if (userBlockInfoModel != null) {
                userBlockInfoModel.onDestroy();
            }
            UserBlockSetModel userBlockSetModel = this.f15913g;
            if (userBlockSetModel != null) {
                userBlockSetModel.onDestroy();
            }
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, this.f15908b);
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f15908b);
        }
    }

    public final void m(int i, PermissionList permissionList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, permissionList) == null) {
            boolean z = false;
            boolean z2 = permissionList != null && permissionList.follow.intValue() == 1;
            boolean z3 = permissionList != null && permissionList.interact.intValue() == 1;
            if (permissionList != null && permissionList.chat.intValue() == 1) {
                z = true;
            }
            ArrayList<n> arrayList = new ArrayList<>();
            this.f15911e = arrayList;
            if (i == 1) {
                arrayList.add(new n(j(R.string.obfuscated_res_0x7f0f030d), z2, "1"));
                this.f15911e.add(new n(j(R.string.obfuscated_res_0x7f0f0308), z3, "2"));
                this.f15911e.add(new n(j(R.string.obfuscated_res_0x7f0f030e), z, "3"));
            } else {
                arrayList.add(new n(j(R.string.obfuscated_res_0x7f0f030c), z3, "2"));
                this.f15911e.add(new n(j(R.string.obfuscated_res_0x7f0f030e), z, "3"));
            }
            c.a.o0.r.t.f fVar = new c.a.o0.r.t.f(this.a);
            this.f15910d = fVar;
            fVar.l(R.string.obfuscated_res_0x7f0f0315);
            this.f15910d.k(this.f15911e, this.i);
            this.f15910d.q(R.string.obfuscated_res_0x7f0f04e0, this.k);
            this.f15910d.p(R.string.obfuscated_res_0x7f0f036c, this.j);
            c.a.o0.r.t.f fVar2 = this.f15910d;
            fVar2.c();
            fVar2.n();
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f15912f = j;
            this.f15914h.E(j);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f15909c == null) {
                c.a.o0.r.l0.a aVar = new c.a.o0.r.l0.a(this.a);
                this.f15909c = aVar;
                aVar.e(new f(this));
            }
            this.f15909c.h(true);
        }
    }
}
