package c.a.r0.w.f.h.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import c.a.q0.s.f0.f;
import c.a.q0.s.q.d2;
import c.a.r0.w.f.h.d.f;
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
    public boolean f26065a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f26066b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.w.f.h.d.c f26067c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f26068d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26069e;

    /* renamed from: f  reason: collision with root package name */
    public String f26070f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f26071g;

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f26072h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f26073i;

    /* renamed from: j  reason: collision with root package name */
    public f f26074j;
    public f.g k;

    /* renamed from: c.a.r0.w.f.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1214a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26075e;

        public C1214a(a aVar) {
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
            this.f26075e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean N = this.f26075e.f26068d != null ? this.f26075e.f26068d.N() : false;
                if (this.f26075e.f26067c != null) {
                    if (!N) {
                        this.f26075e.f26067c.v();
                        return;
                    }
                    this.f26075e.f26068d.P();
                    this.f26075e.f26067c.i();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26076a;

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
            this.f26076a = aVar;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f26076a.f26066b == null || this.f26076a.f26067c == null) {
                return;
            }
            this.f26076a.f26067c.d();
            this.f26076a.f26067c.g();
            this.f26076a.f26067c.p(this.f26076a.f26068d.J());
            this.f26076a.f26067c.l(this.f26076a.f26068d.K());
            this.f26076a.f26067c.m(this.f26076a.f26068d.M());
            if (this.f26076a.f26068d != null && this.f26076a.f26068d.getPn() == 0 && this.f26076a.f26067c.e() != null) {
                this.f26076a.f26067c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(this.f26076a.f26068d.J()) == 0) {
                this.f26076a.f26067c.u(this.f26076a.f26066b.getString(R.string.no_data_text), this.f26076a.f26073i, true);
                this.f26076a.f26067c.o(8);
                return;
            }
            this.f26076a.f26067c.h();
            this.f26076a.f26067c.o(0);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f26076a.f26066b == null || this.f26076a.f26067c == null) {
                return;
            }
            this.f26076a.f26067c.d();
            this.f26076a.f26067c.g();
            c.a.r0.w.f.h.d.c cVar = this.f26076a.f26067c;
            if (TextUtils.isEmpty(str)) {
                str = this.f26076a.f26066b.getString(R.string.no_data_text);
            }
            cVar.u(str, this.f26076a.f26073i, true);
            this.f26076a.f26067c.o(8);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26077e;

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
            this.f26077e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26077e.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c.a.r0.w.f.h.d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26078a;

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
            this.f26078a = aVar;
        }

        @Override // c.a.r0.w.f.h.d.f
        public void a(int i2, String str, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, d2Var) == null) {
                a aVar = this.f26078a;
                aVar.g(aVar.f26066b, d2Var, str);
            }
        }

        @Override // c.a.r0.w.f.h.d.f
        public void b(c.a.r0.w.f.h.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || this.f26078a.f26068d == null || cVar == null || StringUtils.isNull(cVar.f26061a)) {
                return;
            }
            this.f26078a.f26068d.setSortType(cVar.f26061a);
            this.f26078a.f26068d.setLat(cVar.f26062b);
            this.f26078a.f26068d.setLng(cVar.f26063c);
            this.f26078a.f26068d.T(cVar.f26064d);
            this.f26078a.f26068d.Q();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26079e;

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
            this.f26079e = aVar;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f26079e.f26068d == null) {
                return;
            }
            this.f26079e.f26068d.Q();
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
        this.f26069e = false;
        this.f26071g = new C1214a(this);
        this.f26072h = new b(this);
        this.f26073i = new c(this);
        this.f26074j = new d(this);
        this.k = new e(this);
        this.f26066b = tbPageContext;
        this.f26065a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f26068d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f26072h);
        c.a.r0.w.f.h.d.c cVar = new c.a.r0.w.f.h.d.c(this.f26066b);
        this.f26067c = cVar;
        cVar.n(this.f26074j);
        this.f26067c.q(this.k);
        this.f26067c.r(this.f26071g);
        this.f26067c.t();
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26067c.f() : (View) invokeV.objValue;
    }

    public final void g(TbPageContext<?> tbPageContext, d2 d2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, d2Var, str) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.l1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", d2Var.l1().live_id);
        if (!StringUtils.isNull(this.f26070f)) {
            param.param("locate_type", this.f26070f);
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
        for (d2 d2Var2 : this.f26068d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(d2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        c.a.r0.w.f.h.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || (cVar = this.f26067c) == null) {
            return;
        }
        cVar.j(tbPageContext, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.f26068d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.f26068d = null;
            }
            c.a.r0.w.f.h.d.c cVar = this.f26067c;
            if (cVar != null) {
                cVar.k();
                this.f26067c = null;
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
            this.f26068d.Q();
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) || StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f26069e = str.equals("16:9");
        }
        this.f26067c.s(this.f26065a, list, str2, str3, this.f26069e, false);
        this.f26068d.setEntryName(str2);
        this.f26068d.setLabelName(str3);
        this.f26068d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f26068d.S(this.f26069e);
        this.f26070f = str2;
    }
}
