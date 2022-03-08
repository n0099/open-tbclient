package c.a.r0.a0.f.h.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import c.a.q0.r.l0.f;
import c.a.q0.r.r.e2;
import c.a.r0.a0.f.h.d.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f14500b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.a0.f.h.d.c f14501c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f14502d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14503e;

    /* renamed from: f  reason: collision with root package name */
    public String f14504f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f14505g;

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f14506h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f14507i;

    /* renamed from: j  reason: collision with root package name */
    public f f14508j;
    public f.g k;

    /* renamed from: c.a.r0.a0.f.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0930a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14509e;

        public C0930a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14509e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean N = this.f14509e.f14502d != null ? this.f14509e.f14502d.N() : false;
                if (this.f14509e.f14501c != null) {
                    if (!N) {
                        this.f14509e.f14501c.v();
                        return;
                    }
                    this.f14509e.f14502d.P();
                    this.f14509e.f14501c.i();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.f14500b == null || this.a.f14501c == null) {
                return;
            }
            this.a.f14501c.d();
            this.a.f14501c.g();
            this.a.f14501c.p(this.a.f14502d.J());
            this.a.f14501c.l(this.a.f14502d.K());
            this.a.f14501c.m(this.a.f14502d.M());
            if (this.a.f14502d != null && this.a.f14502d.getPn() == 0 && this.a.f14501c.e() != null) {
                this.a.f14501c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(this.a.f14502d.J()) == 0) {
                this.a.f14501c.u(this.a.f14500b.getString(R.string.no_data_text), this.a.f14507i, true);
                this.a.f14501c.o(8);
                return;
            }
            this.a.f14501c.h();
            this.a.f14501c.o(0);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.a.f14500b == null || this.a.f14501c == null) {
                return;
            }
            this.a.f14501c.d();
            this.a.f14501c.g();
            c.a.r0.a0.f.h.d.c cVar = this.a.f14501c;
            if (TextUtils.isEmpty(str)) {
                str = this.a.f14500b.getString(R.string.no_data_text);
            }
            cVar.u(str, this.a.f14507i, true);
            this.a.f14501c.o(8);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14510e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14510e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14510e.k();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.a.r0.a0.f.h.d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.r0.a0.f.h.d.f
        public void a(int i2, String str, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, e2Var) == null) {
                a aVar = this.a;
                aVar.g(aVar.f14500b, e2Var, str);
            }
        }

        @Override // c.a.r0.a0.f.h.d.f
        public void b(c.a.r0.a0.f.h.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || this.a.f14502d == null || cVar == null || StringUtils.isNull(cVar.a)) {
                return;
            }
            this.a.f14502d.setSortType(cVar.a);
            this.a.f14502d.setLat(cVar.f14497b);
            this.a.f14502d.setLng(cVar.f14498c);
            this.a.f14502d.T(cVar.f14499d);
            this.a.f14502d.Q();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14511e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14511e = aVar;
        }

        @Override // c.a.q0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f14511e.f14502d == null) {
                return;
            }
            this.f14511e.f14502d.Q();
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14503e = false;
        this.f14505g = new C0930a(this);
        this.f14506h = new b(this);
        this.f14507i = new c(this);
        this.f14508j = new d(this);
        this.k = new e(this);
        this.f14500b = tbPageContext;
        this.a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f14502d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f14506h);
        c.a.r0.a0.f.h.d.c cVar = new c.a.r0.a0.f.h.d.c(this.f14500b);
        this.f14501c = cVar;
        cVar.n(this.f14508j);
        this.f14501c.q(this.k);
        this.f14501c.r(this.f14505g);
        this.f14501c.t();
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14501c.f() : (View) invokeV.objValue;
    }

    public final void g(TbPageContext<?> tbPageContext, e2 e2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, e2Var, str) == null) || tbPageContext == null || e2Var == null || e2Var.J() == null || e2Var.p1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", e2Var.p1().live_id);
        if (!StringUtils.isNull(this.f14504f)) {
            param.param("locate_type", this.f14504f);
        }
        TiebaStatic.log(param);
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = e2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(e2Var.p1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (e2 e2Var2 : this.f14502d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(e2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        c.a.r0.a0.f.h.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || (cVar = this.f14501c) == null) {
            return;
        }
        cVar.j(tbPageContext, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.f14502d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.f14502d = null;
            }
            c.a.r0.a0.f.h.d.c cVar = this.f14501c;
            if (cVar != null) {
                cVar.k();
                this.f14501c = null;
            }
        }
    }

    public final AlaLiveInfoCoreData j(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, e2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(e2Var.p1());
            alaLiveInfoCoreData.userName = e2Var.J().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f14502d.Q();
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) || StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f14503e = str.equals("16:9");
        }
        this.f14501c.s(this.a, list, str2, str3, this.f14503e, false);
        this.f14502d.setEntryName(str2);
        this.f14502d.setLabelName(str3);
        this.f14502d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f14502d.S(this.f14503e);
        this.f14504f = str2;
    }
}
