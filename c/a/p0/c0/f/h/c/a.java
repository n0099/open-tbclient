package c.a.p0.c0.f.h.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import c.a.o0.r.l0.f;
import c.a.p0.c0.f.h.d.f;
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
import com.baidu.tbadk.core.data.ThreadData;
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
    public TbPageContext f13120b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.c0.f.h.d.c f13121c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f13122d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13123e;

    /* renamed from: f  reason: collision with root package name */
    public String f13124f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f13125g;

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f13126h;
    public View.OnClickListener i;
    public f j;
    public f.g k;

    /* renamed from: c.a.p0.c0.f.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0987a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0987a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean P = this.a.f13122d != null ? this.a.f13122d.P() : false;
                if (this.a.f13121c != null) {
                    if (!P) {
                        this.a.f13121c.v();
                        return;
                    }
                    this.a.f13122d.R();
                    this.a.f13121c.i();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.f13120b == null || this.a.f13121c == null) {
                return;
            }
            this.a.f13121c.d();
            this.a.f13121c.g();
            this.a.f13121c.p(this.a.f13122d.L());
            this.a.f13121c.l(this.a.f13122d.M());
            this.a.f13121c.m(this.a.f13122d.O());
            if (this.a.f13122d != null && this.a.f13122d.getPn() == 0 && this.a.f13121c.e() != null) {
                this.a.f13121c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(this.a.f13122d.L()) == 0) {
                this.a.f13121c.u(this.a.f13120b.getString(R.string.obfuscated_res_0x7f0f0c2d), this.a.i, true);
                this.a.f13121c.o(8);
                return;
            }
            this.a.f13121c.h();
            this.a.f13121c.o(0);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || this.a.f13120b == null || this.a.f13121c == null) {
                return;
            }
            this.a.f13121c.d();
            this.a.f13121c.g();
            c.a.p0.c0.f.h.d.c cVar = this.a.f13121c;
            if (TextUtils.isEmpty(str)) {
                str = this.a.f13120b.getString(R.string.obfuscated_res_0x7f0f0c2d);
            }
            cVar.u(str, this.a.i, true);
            this.a.f13121c.o(8);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.a.p0.c0.f.h.d.f {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.p0.c0.f.h.d.f
        public void a(int i, String str, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, threadData) == null) {
                a aVar = this.a;
                aVar.g(aVar.f13120b, threadData, str);
            }
        }

        @Override // c.a.p0.c0.f.h.d.f
        public void b(c.a.p0.c0.f.h.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || this.a.f13122d == null || cVar == null || StringUtils.isNull(cVar.a)) {
                return;
            }
            this.a.f13122d.setSortType(cVar.a);
            this.a.f13122d.setLat(cVar.f13117b);
            this.a.f13122d.setLng(cVar.f13118c);
            this.a.f13122d.V(cVar.f13119d);
            this.a.f13122d.S();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.f13122d == null) {
                return;
            }
            this.a.f13122d.S();
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13123e = false;
        this.f13125g = new C0987a(this);
        this.f13126h = new b(this);
        this.i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
        this.f13120b = tbPageContext;
        this.a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f13122d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.T(this.f13126h);
        c.a.p0.c0.f.h.d.c cVar = new c.a.p0.c0.f.h.d.c(this.f13120b);
        this.f13121c = cVar;
        cVar.n(this.j);
        this.f13121c.q(this.k);
        this.f13121c.r(this.f13125g);
        this.f13121c.t();
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13121c.f() : (View) invokeV.objValue;
    }

    public final void g(TbPageContext<?> tbPageContext, ThreadData threadData, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, threadData, str) == null) || tbPageContext == null || threadData == null || threadData.getAuthor() == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", threadData.getThreadAlaInfo().live_id);
        if (!StringUtils.isNull(this.f13124f)) {
            param.param("locate_type", this.f13124f);
        }
        TiebaStatic.log(param);
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = threadData.getAuthor().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (ThreadData threadData2 : this.f13122d.N()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(threadData2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i) {
        c.a.p0.c0.f.h.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || (cVar = this.f13121c) == null) {
            return;
        }
        cVar.j(tbPageContext, i);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.f13122d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.f13122d = null;
            }
            c.a.p0.c0.f.h.d.c cVar = this.f13121c;
            if (cVar != null) {
                cVar.k();
                this.f13121c = null;
            }
        }
    }

    public final AlaLiveInfoCoreData j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, threadData)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            alaLiveInfoCoreData.userName = threadData.getAuthor().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f13122d.S();
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) || StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f13123e = str.equals("16:9");
        }
        this.f13121c.s(this.a, list, str2, str3, this.f13123e, false);
        this.f13122d.setEntryName(str2);
        this.f13122d.setLabelName(str3);
        this.f13122d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f13122d.U(this.f13123e);
        this.f13124f = str2;
    }
}
