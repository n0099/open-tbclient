package c.a.r0.v.f.h.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import c.a.q0.s.f0.f;
import c.a.q0.s.q.d2;
import c.a.r0.v.f.h.d.f;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f25890a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f25891b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.v.f.h.d.c f25892c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f25893d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25894e;

    /* renamed from: f  reason: collision with root package name */
    public String f25895f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f25896g;

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f25897h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f25898i;

    /* renamed from: j  reason: collision with root package name */
    public f f25899j;
    public f.g k;

    /* renamed from: c.a.r0.v.f.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1205a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25900e;

        public C1205a(a aVar) {
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
            this.f25900e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean N = this.f25900e.f25893d != null ? this.f25900e.f25893d.N() : false;
                if (this.f25900e.f25892c != null) {
                    if (!N) {
                        this.f25900e.f25892c.v();
                        return;
                    }
                    this.f25900e.f25893d.P();
                    this.f25900e.f25892c.i();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25901a;

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
            this.f25901a = aVar;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f25901a.f25891b == null || this.f25901a.f25892c == null) {
                return;
            }
            this.f25901a.f25892c.d();
            this.f25901a.f25892c.g();
            this.f25901a.f25892c.p(this.f25901a.f25893d.J());
            this.f25901a.f25892c.l(this.f25901a.f25893d.K());
            this.f25901a.f25892c.m(this.f25901a.f25893d.M());
            if (this.f25901a.f25893d != null && this.f25901a.f25893d.getPn() == 0 && this.f25901a.f25892c.e() != null) {
                this.f25901a.f25892c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(this.f25901a.f25893d.J()) == 0) {
                this.f25901a.f25892c.u(this.f25901a.f25891b.getString(R.string.no_data_text), this.f25901a.f25898i, true);
                this.f25901a.f25892c.o(8);
                return;
            }
            this.f25901a.f25892c.h();
            this.f25901a.f25892c.o(0);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f25901a.f25891b == null || this.f25901a.f25892c == null) {
                return;
            }
            this.f25901a.f25892c.d();
            this.f25901a.f25892c.g();
            c.a.r0.v.f.h.d.c cVar = this.f25901a.f25892c;
            if (TextUtils.isEmpty(str)) {
                str = this.f25901a.f25891b.getString(R.string.no_data_text);
            }
            cVar.u(str, this.f25901a.f25898i, true);
            this.f25901a.f25892c.o(8);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25902e;

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
            this.f25902e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25902e.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c.a.r0.v.f.h.d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25903a;

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
            this.f25903a = aVar;
        }

        @Override // c.a.r0.v.f.h.d.f
        public void a(int i2, String str, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, d2Var) == null) {
                a aVar = this.f25903a;
                aVar.g(aVar.f25891b, d2Var, str);
            }
        }

        @Override // c.a.r0.v.f.h.d.f
        public void b(c.a.r0.v.f.h.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || this.f25903a.f25893d == null || cVar == null || StringUtils.isNull(cVar.f25886a)) {
                return;
            }
            this.f25903a.f25893d.setSortType(cVar.f25886a);
            this.f25903a.f25893d.setLat(cVar.f25887b);
            this.f25903a.f25893d.setLng(cVar.f25888c);
            this.f25903a.f25893d.T(cVar.f25889d);
            this.f25903a.f25893d.Q();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25904e;

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
            this.f25904e = aVar;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f25904e.f25893d == null) {
                return;
            }
            this.f25904e.f25893d.Q();
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
        this.f25894e = false;
        this.f25896g = new C1205a(this);
        this.f25897h = new b(this);
        this.f25898i = new c(this);
        this.f25899j = new d(this);
        this.k = new e(this);
        this.f25891b = tbPageContext;
        this.f25890a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f25893d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f25897h);
        c.a.r0.v.f.h.d.c cVar = new c.a.r0.v.f.h.d.c(this.f25891b);
        this.f25892c = cVar;
        cVar.n(this.f25899j);
        this.f25892c.q(this.k);
        this.f25892c.r(this.f25896g);
        this.f25892c.t();
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25892c.f() : (View) invokeV.objValue;
    }

    public final void g(TbPageContext<?> tbPageContext, d2 d2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, d2Var, str) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.l1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", d2Var.l1().live_id);
        if (!StringUtils.isNull(this.f25895f)) {
            param.param("locate_type", this.f25895f);
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
        for (d2 d2Var2 : this.f25893d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(d2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        c.a.r0.v.f.h.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || (cVar = this.f25892c) == null) {
            return;
        }
        cVar.j(tbPageContext, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.f25893d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.f25893d = null;
            }
            c.a.r0.v.f.h.d.c cVar = this.f25892c;
            if (cVar != null) {
                cVar.k();
                this.f25892c = null;
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
            this.f25893d.Q();
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) || StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f25894e = str.equals("16:9");
        }
        this.f25892c.s(this.f25890a, list, str2, str3, this.f25894e, false);
        this.f25893d.setEntryName(str2);
        this.f25893d.setLabelName(str3);
        this.f25893d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f25893d.S(this.f25894e);
        this.f25895f = str2;
    }
}
