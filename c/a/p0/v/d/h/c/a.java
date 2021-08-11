package c.a.p0.v.d.h.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import c.a.o0.s.f0.f;
import c.a.o0.s.q.c2;
import c.a.p0.v.d.h.d.f;
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
    public boolean f25056a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f25057b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.v.d.h.d.c f25058c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f25059d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25060e;

    /* renamed from: f  reason: collision with root package name */
    public String f25061f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f25062g;

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f25063h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f25064i;

    /* renamed from: j  reason: collision with root package name */
    public f f25065j;
    public f.g k;

    /* renamed from: c.a.p0.v.d.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1172a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25066e;

        public C1172a(a aVar) {
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
            this.f25066e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean N = this.f25066e.f25059d != null ? this.f25066e.f25059d.N() : false;
                if (this.f25066e.f25058c != null) {
                    if (!N) {
                        this.f25066e.f25058c.v();
                        return;
                    }
                    this.f25066e.f25059d.P();
                    this.f25066e.f25058c.i();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25067a;

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
            this.f25067a = aVar;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f25067a.f25057b == null || this.f25067a.f25058c == null) {
                return;
            }
            this.f25067a.f25058c.d();
            this.f25067a.f25058c.g();
            this.f25067a.f25058c.p(this.f25067a.f25059d.J());
            this.f25067a.f25058c.l(this.f25067a.f25059d.K());
            this.f25067a.f25058c.m(this.f25067a.f25059d.M());
            if (this.f25067a.f25059d != null && this.f25067a.f25059d.getPn() == 0 && this.f25067a.f25058c.e() != null) {
                this.f25067a.f25058c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(this.f25067a.f25059d.J()) == 0) {
                this.f25067a.f25058c.u(this.f25067a.f25057b.getString(R.string.no_data_text), this.f25067a.f25064i, true);
                this.f25067a.f25058c.o(8);
                return;
            }
            this.f25067a.f25058c.h();
            this.f25067a.f25058c.o(0);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f25067a.f25057b == null || this.f25067a.f25058c == null) {
                return;
            }
            this.f25067a.f25058c.d();
            this.f25067a.f25058c.g();
            c.a.p0.v.d.h.d.c cVar = this.f25067a.f25058c;
            if (TextUtils.isEmpty(str)) {
                str = this.f25067a.f25057b.getString(R.string.no_data_text);
            }
            cVar.u(str, this.f25067a.f25064i, true);
            this.f25067a.f25058c.o(8);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25068e;

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
            this.f25068e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25068e.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.p0.v.d.h.d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25069a;

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
            this.f25069a = aVar;
        }

        @Override // c.a.p0.v.d.h.d.f
        public void a(int i2, String str, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, c2Var) == null) {
                a aVar = this.f25069a;
                aVar.g(aVar.f25057b, c2Var, str);
            }
        }

        @Override // c.a.p0.v.d.h.d.f
        public void b(c.a.p0.v.d.h.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || this.f25069a.f25059d == null || cVar == null || StringUtils.isNull(cVar.f25052a)) {
                return;
            }
            this.f25069a.f25059d.setSortType(cVar.f25052a);
            this.f25069a.f25059d.setLat(cVar.f25053b);
            this.f25069a.f25059d.setLng(cVar.f25054c);
            this.f25069a.f25059d.T(cVar.f25055d);
            this.f25069a.f25059d.Q();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25070e;

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
            this.f25070e = aVar;
        }

        @Override // c.a.o0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f25070e.f25059d == null) {
                return;
            }
            this.f25070e.f25059d.Q();
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
        this.f25060e = false;
        this.f25062g = new C1172a(this);
        this.f25063h = new b(this);
        this.f25064i = new c(this);
        this.f25065j = new d(this);
        this.k = new e(this);
        this.f25057b = tbPageContext;
        this.f25056a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f25059d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f25063h);
        c.a.p0.v.d.h.d.c cVar = new c.a.p0.v.d.h.d.c(this.f25057b);
        this.f25058c = cVar;
        cVar.n(this.f25065j);
        this.f25058c.q(this.k);
        this.f25058c.r(this.f25062g);
        this.f25058c.t();
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25058c.f() : (View) invokeV.objValue;
    }

    public final void g(TbPageContext<?> tbPageContext, c2 c2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, c2Var, str) == null) || tbPageContext == null || c2Var == null || c2Var.J() == null || c2Var.j1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", c2Var.j1().live_id);
        if (!StringUtils.isNull(this.f25061f)) {
            param.param("locate_type", this.f25061f);
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
        for (c2 c2Var2 : this.f25059d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(c2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        c.a.p0.v.d.h.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || (cVar = this.f25058c) == null) {
            return;
        }
        cVar.j(tbPageContext, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.f25059d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.f25059d = null;
            }
            c.a.p0.v.d.h.d.c cVar = this.f25058c;
            if (cVar != null) {
                cVar.k();
                this.f25058c = null;
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
            this.f25059d.Q();
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) || StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f25060e = str.equals("16:9");
        }
        this.f25058c.s(this.f25056a, list, str2, str3, this.f25060e, false);
        this.f25059d.setEntryName(str2);
        this.f25059d.setLabelName(str3);
        this.f25059d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f25059d.S(this.f25060e);
        this.f25061f = str2;
    }
}
