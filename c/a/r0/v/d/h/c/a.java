package c.a.r0.v.d.h.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import c.a.q0.s.f0.f;
import c.a.q0.s.q.d2;
import c.a.r0.v.d.h.d.f;
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
    public boolean f25867a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f25868b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.v.d.h.d.c f25869c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f25870d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25871e;

    /* renamed from: f  reason: collision with root package name */
    public String f25872f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f25873g;

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f25874h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f25875i;

    /* renamed from: j  reason: collision with root package name */
    public f f25876j;
    public f.g k;

    /* renamed from: c.a.r0.v.d.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1207a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25877e;

        public C1207a(a aVar) {
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
            this.f25877e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean N = this.f25877e.f25870d != null ? this.f25877e.f25870d.N() : false;
                if (this.f25877e.f25869c != null) {
                    if (!N) {
                        this.f25877e.f25869c.v();
                        return;
                    }
                    this.f25877e.f25870d.P();
                    this.f25877e.f25869c.i();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25878a;

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
            this.f25878a = aVar;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f25878a.f25868b == null || this.f25878a.f25869c == null) {
                return;
            }
            this.f25878a.f25869c.d();
            this.f25878a.f25869c.g();
            this.f25878a.f25869c.p(this.f25878a.f25870d.J());
            this.f25878a.f25869c.l(this.f25878a.f25870d.K());
            this.f25878a.f25869c.m(this.f25878a.f25870d.M());
            if (this.f25878a.f25870d != null && this.f25878a.f25870d.getPn() == 0 && this.f25878a.f25869c.e() != null) {
                this.f25878a.f25869c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(this.f25878a.f25870d.J()) == 0) {
                this.f25878a.f25869c.u(this.f25878a.f25868b.getString(R.string.no_data_text), this.f25878a.f25875i, true);
                this.f25878a.f25869c.o(8);
                return;
            }
            this.f25878a.f25869c.h();
            this.f25878a.f25869c.o(0);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f25878a.f25868b == null || this.f25878a.f25869c == null) {
                return;
            }
            this.f25878a.f25869c.d();
            this.f25878a.f25869c.g();
            c.a.r0.v.d.h.d.c cVar = this.f25878a.f25869c;
            if (TextUtils.isEmpty(str)) {
                str = this.f25878a.f25868b.getString(R.string.no_data_text);
            }
            cVar.u(str, this.f25878a.f25875i, true);
            this.f25878a.f25869c.o(8);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25879e;

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
            this.f25879e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25879e.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c.a.r0.v.d.h.d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25880a;

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
            this.f25880a = aVar;
        }

        @Override // c.a.r0.v.d.h.d.f
        public void a(int i2, String str, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, d2Var) == null) {
                a aVar = this.f25880a;
                aVar.g(aVar.f25868b, d2Var, str);
            }
        }

        @Override // c.a.r0.v.d.h.d.f
        public void b(c.a.r0.v.d.h.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || this.f25880a.f25870d == null || cVar == null || StringUtils.isNull(cVar.f25863a)) {
                return;
            }
            this.f25880a.f25870d.setSortType(cVar.f25863a);
            this.f25880a.f25870d.setLat(cVar.f25864b);
            this.f25880a.f25870d.setLng(cVar.f25865c);
            this.f25880a.f25870d.T(cVar.f25866d);
            this.f25880a.f25870d.Q();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25881e;

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
            this.f25881e = aVar;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f25881e.f25870d == null) {
                return;
            }
            this.f25881e.f25870d.Q();
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
        this.f25871e = false;
        this.f25873g = new C1207a(this);
        this.f25874h = new b(this);
        this.f25875i = new c(this);
        this.f25876j = new d(this);
        this.k = new e(this);
        this.f25868b = tbPageContext;
        this.f25867a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f25870d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f25874h);
        c.a.r0.v.d.h.d.c cVar = new c.a.r0.v.d.h.d.c(this.f25868b);
        this.f25869c = cVar;
        cVar.n(this.f25876j);
        this.f25869c.q(this.k);
        this.f25869c.r(this.f25873g);
        this.f25869c.t();
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25869c.f() : (View) invokeV.objValue;
    }

    public final void g(TbPageContext<?> tbPageContext, d2 d2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, d2Var, str) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.l1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", d2Var.l1().live_id);
        if (!StringUtils.isNull(this.f25872f)) {
            param.param("locate_type", this.f25872f);
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
        for (d2 d2Var2 : this.f25870d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(d2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        c.a.r0.v.d.h.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || (cVar = this.f25869c) == null) {
            return;
        }
        cVar.j(tbPageContext, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.f25870d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.f25870d = null;
            }
            c.a.r0.v.d.h.d.c cVar = this.f25869c;
            if (cVar != null) {
                cVar.k();
                this.f25869c = null;
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
            this.f25870d.Q();
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) || StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f25871e = str.equals("16:9");
        }
        this.f25869c.s(this.f25867a, list, str2, str3, this.f25871e, false);
        this.f25870d.setEntryName(str2);
        this.f25870d.setLabelName(str3);
        this.f25870d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f25870d.S(this.f25871e);
        this.f25872f = str2;
    }
}
