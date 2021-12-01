package c.a.r0.d4;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import c.a.d.f.p.j;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f16626b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.s.g0.a f16627c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.s.s.d f16628d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<k> f16629e;

    /* renamed from: f  reason: collision with root package name */
    public long f16630f;

    /* renamed from: g  reason: collision with root package name */
    public UserBlockSetModel f16631g;

    /* renamed from: h  reason: collision with root package name */
    public UserBlockInfoModel f16632h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f16633i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f16634j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f16635k;

    /* loaded from: classes5.dex */
    public class a implements c.a.q0.n.a<String> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.n.a
        /* renamed from: b */
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.k();
                c.a.r0.d4.a.f((ViewGroup) this.a.a.getPageActivity().findViewById(16908290), str, true);
            }
        }

        @Override // c.a.q0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.a.k();
                c.a.r0.d4.a.f((ViewGroup) this.a.a.getPageActivity().findViewById(16908290), str, false);
            }
        }
    }

    /* renamed from: c.a.r0.d4.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1004b implements c.a.q0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1004b(b bVar) {
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
            this.a = bVar;
        }

        @Override // c.a.q0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.a.a == null) {
                return;
            }
            this.a.a.showToast(str);
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
                    this.a.m(i2, permissionList);
                } else if (this.a.a != null) {
                    this.a.a.showToast(R.string.error_unkown_try_again);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16636e;

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
            this.f16636e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (((k) ListUtils.getItem(this.f16636e.f16629e, i2)) != null) {
                    this.f16636e.f16628d.r(true);
                }
                this.f16636e.f16628d.h(i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16637e;

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
            this.f16637e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16637e.f16628d.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16638e;

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
            this.f16638e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16638e.f16628d.d();
                if (this.f16638e.f16629e == null || !j.z() || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return;
                }
                Iterator it = this.f16638e.f16629e.iterator();
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
                this.f16638e.o();
                this.f16638e.f16631g.C(this.f16638e.f16630f, i2, i3, i4);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16639e;

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
            this.f16639e = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f16639e.f16626b);
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
        this.f16633i = new c(this);
        this.f16634j = new d(this);
        this.f16635k = new e(this);
        this.a = tbPageContext;
        this.f16626b = bdUniqueId;
        UserBlockSetModel userBlockSetModel = new UserBlockSetModel(tbPageContext, bdUniqueId);
        this.f16631g = userBlockSetModel;
        userBlockSetModel.D(new a(this));
        UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(tbPageContext, bdUniqueId);
        this.f16632h = userBlockInfoModel;
        userBlockInfoModel.D(new C1004b(this));
    }

    public final String j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public final void k() {
        c.a.q0.s.g0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f16627c) == null) {
            return;
        }
        aVar.h(false);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16630f = -1L;
            c.a.q0.s.g0.a aVar = this.f16627c;
            if (aVar != null) {
                aVar.h(false);
            }
            c.a.q0.s.s.d dVar = this.f16628d;
            if (dVar != null) {
                dVar.d();
            }
            UserBlockInfoModel userBlockInfoModel = this.f16632h;
            if (userBlockInfoModel != null) {
                userBlockInfoModel.onDestroy();
            }
            UserBlockSetModel userBlockSetModel = this.f16631g;
            if (userBlockSetModel != null) {
                userBlockSetModel.onDestroy();
            }
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, this.f16626b);
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f16626b);
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
            this.f16629e = arrayList;
            if (i2 == 1) {
                arrayList.add(new k(j(R.string.block_follow), z2, "1"));
                this.f16629e.add(new k(j(R.string.block_action), z3, "2"));
                this.f16629e.add(new k(j(R.string.block_message), z, "3"));
            } else {
                arrayList.add(new k(j(R.string.block_commit), z3, "2"));
                this.f16629e.add(new k(j(R.string.block_message), z, "3"));
            }
            c.a.q0.s.s.d dVar = new c.a.q0.s.s.d(this.a);
            this.f16628d = dVar;
            dVar.l(R.string.block_user_title);
            this.f16628d.k(this.f16629e, this.f16633i);
            this.f16628d.q(R.string.done, this.f16635k);
            this.f16628d.p(R.string.cancel, this.f16634j);
            c.a.q0.s.s.d dVar2 = this.f16628d;
            dVar2.c();
            dVar2.n();
        }
    }

    public void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f16630f = j2;
            this.f16632h.C(j2);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f16627c == null) {
                c.a.q0.s.g0.a aVar = new c.a.q0.s.g0.a(this.a);
                this.f16627c = aVar;
                aVar.e(new f(this));
            }
            this.f16627c.h(true);
        }
    }
}
