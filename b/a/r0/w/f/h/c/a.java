package b.a.r0.w.f.h.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import b.a.q0.s.g0.f;
import b.a.q0.s.q.d2;
import b.a.r0.w.f.h.d.f;
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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f24898a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f24899b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.w.f.h.d.c f24900c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f24901d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24902e;

    /* renamed from: f  reason: collision with root package name */
    public String f24903f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f24904g;

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f24905h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f24906i;
    public f j;
    public f.g k;

    /* renamed from: b.a.r0.w.f.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1215a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24907e;

        public C1215a(a aVar) {
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
            this.f24907e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean N = this.f24907e.f24901d != null ? this.f24907e.f24901d.N() : false;
                if (this.f24907e.f24900c != null) {
                    if (!N) {
                        this.f24907e.f24900c.v();
                        return;
                    }
                    this.f24907e.f24901d.P();
                    this.f24907e.f24900c.i();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24908a;

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
            this.f24908a = aVar;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f24908a.f24899b == null || this.f24908a.f24900c == null) {
                return;
            }
            this.f24908a.f24900c.d();
            this.f24908a.f24900c.g();
            this.f24908a.f24900c.p(this.f24908a.f24901d.J());
            this.f24908a.f24900c.l(this.f24908a.f24901d.K());
            this.f24908a.f24900c.m(this.f24908a.f24901d.M());
            if (this.f24908a.f24901d != null && this.f24908a.f24901d.getPn() == 0 && this.f24908a.f24900c.e() != null) {
                this.f24908a.f24900c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(this.f24908a.f24901d.J()) == 0) {
                this.f24908a.f24900c.u(this.f24908a.f24899b.getString(R.string.no_data_text), this.f24908a.f24906i, true);
                this.f24908a.f24900c.o(8);
                return;
            }
            this.f24908a.f24900c.h();
            this.f24908a.f24900c.o(0);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f24908a.f24899b == null || this.f24908a.f24900c == null) {
                return;
            }
            this.f24908a.f24900c.d();
            this.f24908a.f24900c.g();
            b.a.r0.w.f.h.d.c cVar = this.f24908a.f24900c;
            if (TextUtils.isEmpty(str)) {
                str = this.f24908a.f24899b.getString(R.string.no_data_text);
            }
            cVar.u(str, this.f24908a.f24906i, true);
            this.f24908a.f24900c.o(8);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24909e;

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
            this.f24909e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24909e.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements b.a.r0.w.f.h.d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24910a;

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
            this.f24910a = aVar;
        }

        @Override // b.a.r0.w.f.h.d.f
        public void a(int i2, String str, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, d2Var) == null) {
                a aVar = this.f24910a;
                aVar.g(aVar.f24899b, d2Var, str);
            }
        }

        @Override // b.a.r0.w.f.h.d.f
        public void b(b.a.r0.w.f.h.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || this.f24910a.f24901d == null || cVar == null || StringUtils.isNull(cVar.f24894a)) {
                return;
            }
            this.f24910a.f24901d.setSortType(cVar.f24894a);
            this.f24910a.f24901d.setLat(cVar.f24895b);
            this.f24910a.f24901d.setLng(cVar.f24896c);
            this.f24910a.f24901d.T(cVar.f24897d);
            this.f24910a.f24901d.Q();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24911e;

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
            this.f24911e = aVar;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f24911e.f24901d == null) {
                return;
            }
            this.f24911e.f24901d.Q();
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
        this.f24902e = false;
        this.f24904g = new C1215a(this);
        this.f24905h = new b(this);
        this.f24906i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
        this.f24899b = tbPageContext;
        this.f24898a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f24901d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f24905h);
        b.a.r0.w.f.h.d.c cVar = new b.a.r0.w.f.h.d.c(this.f24899b);
        this.f24900c = cVar;
        cVar.n(this.j);
        this.f24900c.q(this.k);
        this.f24900c.r(this.f24904g);
        this.f24900c.t();
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24900c.f() : (View) invokeV.objValue;
    }

    public final void g(TbPageContext<?> tbPageContext, d2 d2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, d2Var, str) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.l1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", d2Var.l1().live_id);
        if (!StringUtils.isNull(this.f24903f)) {
            param.param("locate_type", this.f24903f);
        }
        TiebaStatic.log(param);
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = d2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(d2Var.l1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (d2 d2Var2 : this.f24901d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(d2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        b.a.r0.w.f.h.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || (cVar = this.f24900c) == null) {
            return;
        }
        cVar.j(tbPageContext, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.f24901d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.f24901d = null;
            }
            b.a.r0.w.f.h.d.c cVar = this.f24900c;
            if (cVar != null) {
                cVar.k();
                this.f24900c = null;
            }
        }
    }

    public final AlaLiveInfoCoreData j(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, d2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(d2Var.l1());
            alaLiveInfoCoreData.userName = d2Var.J().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f24901d.Q();
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) || StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f24902e = str.equals("16:9");
        }
        this.f24900c.s(this.f24898a, list, str2, str3, this.f24902e, false);
        this.f24901d.setEntryName(str2);
        this.f24901d.setLabelName(str3);
        this.f24901d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f24901d.S(this.f24902e);
        this.f24903f = str2;
    }
}
