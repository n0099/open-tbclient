package c.a.s0.a0.f.h.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import c.a.r0.s.i0.f;
import c.a.r0.s.r.d2;
import c.a.s0.a0.f.h.d.f;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f14536b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.a0.f.h.d.c f14537c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f14538d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14539e;

    /* renamed from: f  reason: collision with root package name */
    public String f14540f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f14541g;

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f14542h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f14543i;

    /* renamed from: j  reason: collision with root package name */
    public f f14544j;

    /* renamed from: k  reason: collision with root package name */
    public f.g f14545k;

    /* renamed from: c.a.s0.a0.f.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0895a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14546e;

        public C0895a(a aVar) {
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
            this.f14546e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean N = this.f14546e.f14538d != null ? this.f14546e.f14538d.N() : false;
                if (this.f14546e.f14537c != null) {
                    if (!N) {
                        this.f14546e.f14537c.v();
                        return;
                    }
                    this.f14546e.f14538d.P();
                    this.f14546e.f14537c.i();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.f14536b == null || this.a.f14537c == null) {
                return;
            }
            this.a.f14537c.d();
            this.a.f14537c.g();
            this.a.f14537c.p(this.a.f14538d.J());
            this.a.f14537c.l(this.a.f14538d.K());
            this.a.f14537c.m(this.a.f14538d.M());
            if (this.a.f14538d != null && this.a.f14538d.getPn() == 0 && this.a.f14537c.e() != null) {
                this.a.f14537c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(this.a.f14538d.J()) == 0) {
                this.a.f14537c.u(this.a.f14536b.getString(R.string.no_data_text), this.a.f14543i, true);
                this.a.f14537c.o(8);
                return;
            }
            this.a.f14537c.h();
            this.a.f14537c.o(0);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.a.f14536b == null || this.a.f14537c == null) {
                return;
            }
            this.a.f14537c.d();
            this.a.f14537c.g();
            c.a.s0.a0.f.h.d.c cVar = this.a.f14537c;
            if (TextUtils.isEmpty(str)) {
                str = this.a.f14536b.getString(R.string.no_data_text);
            }
            cVar.u(str, this.a.f14543i, true);
            this.a.f14537c.o(8);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14547e;

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
            this.f14547e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14547e.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements c.a.s0.a0.f.h.d.f {
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

        @Override // c.a.s0.a0.f.h.d.f
        public void a(int i2, String str, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, d2Var) == null) {
                a aVar = this.a;
                aVar.g(aVar.f14536b, d2Var, str);
            }
        }

        @Override // c.a.s0.a0.f.h.d.f
        public void b(c.a.s0.a0.f.h.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || this.a.f14538d == null || cVar == null || StringUtils.isNull(cVar.a)) {
                return;
            }
            this.a.f14538d.setSortType(cVar.a);
            this.a.f14538d.setLat(cVar.f14533b);
            this.a.f14538d.setLng(cVar.f14534c);
            this.a.f14538d.T(cVar.f14535d);
            this.a.f14538d.Q();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14548e;

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
            this.f14548e = aVar;
        }

        @Override // c.a.r0.s.i0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f14548e.f14538d == null) {
                return;
            }
            this.f14548e.f14538d.Q();
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
        this.f14539e = false;
        this.f14541g = new C0895a(this);
        this.f14542h = new b(this);
        this.f14543i = new c(this);
        this.f14544j = new d(this);
        this.f14545k = new e(this);
        this.f14536b = tbPageContext;
        this.a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f14538d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f14542h);
        c.a.s0.a0.f.h.d.c cVar = new c.a.s0.a0.f.h.d.c(this.f14536b);
        this.f14537c = cVar;
        cVar.n(this.f14544j);
        this.f14537c.q(this.f14545k);
        this.f14537c.r(this.f14541g);
        this.f14537c.t();
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14537c.f() : (View) invokeV.objValue;
    }

    public final void g(TbPageContext<?> tbPageContext, d2 d2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, d2Var, str) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.o1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", d2Var.o1().live_id);
        if (!StringUtils.isNull(this.f14540f)) {
            param.param("locate_type", this.f14540f);
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
        alaLiveInfoCoreData.fillWithInfoData(d2Var.o1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (d2 d2Var2 : this.f14538d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(d2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        c.a.s0.a0.f.h.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || (cVar = this.f14537c) == null) {
            return;
        }
        cVar.j(tbPageContext, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.f14538d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.f14538d = null;
            }
            c.a.s0.a0.f.h.d.c cVar = this.f14537c;
            if (cVar != null) {
                cVar.k();
                this.f14537c = null;
            }
        }
    }

    public final AlaLiveInfoCoreData j(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, d2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(d2Var.o1());
            alaLiveInfoCoreData.userName = d2Var.J().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f14538d.Q();
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) || StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f14539e = str.equals("16:9");
        }
        this.f14537c.s(this.a, list, str2, str3, this.f14539e, false);
        this.f14538d.setEntryName(str2);
        this.f14538d.setLabelName(str3);
        this.f14538d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f14538d.S(this.f14539e);
        this.f14540f = str2;
    }
}
