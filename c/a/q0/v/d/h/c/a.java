package c.a.q0.v.d.h.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import c.a.p0.s.f0.f;
import c.a.p0.s.q.c2;
import c.a.q0.v.d.h.d.f;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f25389a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f25390b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.v.d.h.d.c f25391c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f25392d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25393e;

    /* renamed from: f  reason: collision with root package name */
    public String f25394f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f25395g;

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f25396h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f25397i;

    /* renamed from: j  reason: collision with root package name */
    public f f25398j;
    public f.g k;

    /* renamed from: c.a.q0.v.d.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1183a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25399e;

        public C1183a(a aVar) {
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
            this.f25399e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean N = this.f25399e.f25392d != null ? this.f25399e.f25392d.N() : false;
                if (this.f25399e.f25391c != null) {
                    if (!N) {
                        this.f25399e.f25391c.v();
                        return;
                    }
                    this.f25399e.f25392d.P();
                    this.f25399e.f25391c.i();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25400a;

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
            this.f25400a = aVar;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f25400a.f25390b == null || this.f25400a.f25391c == null) {
                return;
            }
            this.f25400a.f25391c.d();
            this.f25400a.f25391c.g();
            this.f25400a.f25391c.p(this.f25400a.f25392d.J());
            this.f25400a.f25391c.l(this.f25400a.f25392d.K());
            this.f25400a.f25391c.m(this.f25400a.f25392d.M());
            if (this.f25400a.f25392d != null && this.f25400a.f25392d.getPn() == 0 && this.f25400a.f25391c.e() != null) {
                this.f25400a.f25391c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(this.f25400a.f25392d.J()) == 0) {
                this.f25400a.f25391c.u(this.f25400a.f25390b.getString(R.string.no_data_text), this.f25400a.f25397i, true);
                this.f25400a.f25391c.o(8);
                return;
            }
            this.f25400a.f25391c.h();
            this.f25400a.f25391c.o(0);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f25400a.f25390b == null || this.f25400a.f25391c == null) {
                return;
            }
            this.f25400a.f25391c.d();
            this.f25400a.f25391c.g();
            c.a.q0.v.d.h.d.c cVar = this.f25400a.f25391c;
            if (TextUtils.isEmpty(str)) {
                str = this.f25400a.f25390b.getString(R.string.no_data_text);
            }
            cVar.u(str, this.f25400a.f25397i, true);
            this.f25400a.f25391c.o(8);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25401e;

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
            this.f25401e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25401e.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.q0.v.d.h.d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25402a;

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
            this.f25402a = aVar;
        }

        @Override // c.a.q0.v.d.h.d.f
        public void a(int i2, String str, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, c2Var) == null) {
                a aVar = this.f25402a;
                aVar.g(aVar.f25390b, c2Var, str);
            }
        }

        @Override // c.a.q0.v.d.h.d.f
        public void b(c.a.q0.v.d.h.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || this.f25402a.f25392d == null || cVar == null || StringUtils.isNull(cVar.f25385a)) {
                return;
            }
            this.f25402a.f25392d.setSortType(cVar.f25385a);
            this.f25402a.f25392d.setLat(cVar.f25386b);
            this.f25402a.f25392d.setLng(cVar.f25387c);
            this.f25402a.f25392d.T(cVar.f25388d);
            this.f25402a.f25392d.Q();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25403e;

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
            this.f25403e = aVar;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f25403e.f25392d == null) {
                return;
            }
            this.f25403e.f25392d.Q();
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
        this.f25393e = false;
        this.f25395g = new C1183a(this);
        this.f25396h = new b(this);
        this.f25397i = new c(this);
        this.f25398j = new d(this);
        this.k = new e(this);
        this.f25390b = tbPageContext;
        this.f25389a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f25392d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f25396h);
        c.a.q0.v.d.h.d.c cVar = new c.a.q0.v.d.h.d.c(this.f25390b);
        this.f25391c = cVar;
        cVar.n(this.f25398j);
        this.f25391c.q(this.k);
        this.f25391c.r(this.f25395g);
        this.f25391c.t();
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25391c.f() : (View) invokeV.objValue;
    }

    public final void g(TbPageContext<?> tbPageContext, c2 c2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, c2Var, str) == null) || tbPageContext == null || c2Var == null || c2Var.J() == null || c2Var.j1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", c2Var.j1().live_id);
        if (!StringUtils.isNull(this.f25394f)) {
            param.param("locate_type", this.f25394f);
        }
        TiebaStatic.log(param);
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = c2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(c2Var.j1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (c2 c2Var2 : this.f25392d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(c2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        c.a.q0.v.d.h.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || (cVar = this.f25391c) == null) {
            return;
        }
        cVar.j(tbPageContext, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.f25392d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.f25392d = null;
            }
            c.a.q0.v.d.h.d.c cVar = this.f25391c;
            if (cVar != null) {
                cVar.k();
                this.f25391c = null;
            }
        }
    }

    public final AlaLiveInfoCoreData j(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(c2Var.j1());
            alaLiveInfoCoreData.userName = c2Var.J().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f25392d.Q();
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) || StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f25393e = str.equals("16:9");
        }
        this.f25391c.s(this.f25389a, list, str2, str3, this.f25393e, false);
        this.f25392d.setEntryName(str2);
        this.f25392d.setLabelName(str3);
        this.f25392d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f25392d.S(this.f25393e);
        this.f25394f = str2;
    }
}
