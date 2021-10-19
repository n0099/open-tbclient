package c.a.r0.u3;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import c.a.e.e.p.j;
import c.a.q0.s.s.k;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25265a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f25266b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.s.f0.a f25267c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.s.s.d f25268d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<k> f25269e;

    /* renamed from: f  reason: collision with root package name */
    public long f25270f;

    /* renamed from: g  reason: collision with root package name */
    public UserBlockSetModel f25271g;

    /* renamed from: h  reason: collision with root package name */
    public UserBlockInfoModel f25272h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f25273i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f25274j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.n.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25275a;

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
            this.f25275a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.n.a
        /* renamed from: b */
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f25275a.k();
                c.a.r0.u3.a.f((ViewGroup) this.f25275a.f25265a.getPageActivity().findViewById(16908290), str, true);
            }
        }

        @Override // c.a.q0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f25275a.k();
                c.a.r0.u3.a.f((ViewGroup) this.f25275a.f25265a.getPageActivity().findViewById(16908290), str, false);
            }
        }
    }

    /* renamed from: c.a.r0.u3.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1173b implements c.a.q0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25276a;

        public C1173b(b bVar) {
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
            this.f25276a = bVar;
        }

        @Override // c.a.q0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.f25276a.f25265a == null) {
                return;
            }
            this.f25276a.f25265a.showToast(str);
        }

        @Override // c.a.q0.n.a
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
                    this.f25276a.m(i2, permissionList);
                } else if (this.f25276a.f25265a != null) {
                    this.f25276a.f25265a.showToast(R.string.error_unkown_try_again);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25277e;

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
            this.f25277e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (((k) ListUtils.getItem(this.f25277e.f25269e, i2)) != null) {
                    this.f25277e.f25268d.r(true);
                }
                this.f25277e.f25268d.h(i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25278e;

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
            this.f25278e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25278e.f25268d.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25279e;

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
            this.f25279e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25279e.f25268d.d();
                if (this.f25279e.f25269e == null || !j.z() || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return;
                }
                Iterator it = this.f25279e.f25269e.iterator();
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
                this.f25279e.o();
                this.f25279e.f25271g.C(this.f25279e.f25270f, i2, i3, i4);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25280e;

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
            this.f25280e = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f25280e.f25266b);
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
        this.f25273i = new c(this);
        this.f25274j = new d(this);
        this.k = new e(this);
        this.f25265a = tbPageContext;
        this.f25266b = bdUniqueId;
        UserBlockSetModel userBlockSetModel = new UserBlockSetModel(tbPageContext, bdUniqueId);
        this.f25271g = userBlockSetModel;
        userBlockSetModel.D(new a(this));
        UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(tbPageContext, bdUniqueId);
        this.f25272h = userBlockInfoModel;
        userBlockInfoModel.D(new C1173b(this));
    }

    public final String j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public final void k() {
        c.a.q0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f25267c) == null) {
            return;
        }
        aVar.h(false);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25270f = -1L;
            c.a.q0.s.f0.a aVar = this.f25267c;
            if (aVar != null) {
                aVar.h(false);
            }
            c.a.q0.s.s.d dVar = this.f25268d;
            if (dVar != null) {
                dVar.d();
            }
            UserBlockInfoModel userBlockInfoModel = this.f25272h;
            if (userBlockInfoModel != null) {
                userBlockInfoModel.onDestroy();
            }
            UserBlockSetModel userBlockSetModel = this.f25271g;
            if (userBlockSetModel != null) {
                userBlockSetModel.onDestroy();
            }
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, this.f25266b);
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f25266b);
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
            this.f25269e = arrayList;
            if (i2 == 1) {
                arrayList.add(new k(j(R.string.block_follow), z2, "1"));
                this.f25269e.add(new k(j(R.string.block_action), z3, "2"));
                this.f25269e.add(new k(j(R.string.block_message), z, "3"));
            } else {
                arrayList.add(new k(j(R.string.block_commit), z3, "2"));
                this.f25269e.add(new k(j(R.string.block_message), z, "3"));
            }
            c.a.q0.s.s.d dVar = new c.a.q0.s.s.d(this.f25265a);
            this.f25268d = dVar;
            dVar.l(R.string.block_user_title);
            this.f25268d.k(this.f25269e, this.f25273i);
            this.f25268d.q(R.string.done, this.k);
            this.f25268d.p(R.string.cancel, this.f25274j);
            c.a.q0.s.s.d dVar2 = this.f25268d;
            dVar2.c();
            dVar2.n();
        }
    }

    public void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f25270f = j2;
            this.f25272h.C(j2);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f25267c == null) {
                c.a.q0.s.f0.a aVar = new c.a.q0.s.f0.a(this.f25265a);
                this.f25267c = aVar;
                aVar.e(new f(this));
            }
            this.f25267c.h(true);
        }
    }
}
