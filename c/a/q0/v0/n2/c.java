package c.a.q0.v0.n2;

import c.a.p0.s.s.a;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f26712a;

    /* renamed from: b  reason: collision with root package name */
    public b f26713b;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f26714a;

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

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
                    }
                }
            }

            @Override // c.a.p0.s.s.a.e
            public void onClick(c.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        /* renamed from: c.a.q0.v0.n2.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1249b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PopInfo f26715e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f26716f;

            public C1249b(b bVar, PopInfo popInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, popInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26716f = bVar;
                this.f26715e = popInfo;
            }

            @Override // c.a.p0.s.s.a.e
            public void onClick(c.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    UrlManager.getInstance().dealOneLink(this.f26716f.f26714a.f26712a.getPageContext(), new String[]{this.f26715e.ahead_url});
                    if (aVar == null) {
                        return;
                    }
                    aVar.dismiss();
                }
            }
        }

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26714a = cVar;
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                c.a.p0.s.r.a.f();
                c.a.e.e.d.l<String> g2 = c.a.p0.s.r.a.g("tb.enter_frs_dialog_list");
                String encode = URLEncoder.encode(this.f26714a.f26712a.getFrsViewData().getForum().getName());
                if (g2.get(encode) == null) {
                    g2.g(encode, "1");
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) && bool.booleanValue() && this.f26714a.c() && this.f26714a.f26712a.isAdded()) {
                PopInfo popInfo = this.f26714a.f26712a.getFrsViewData().enterFrsDialogInfo;
                c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f26714a.f26712a.getActivity());
                aVar.setTitle(popInfo.title);
                aVar.setMessage(popInfo.v_title);
                aVar.isShowTitleAndMessage();
                aVar.setNegativeButton(popInfo.ok_info, new a(this));
                aVar.setPositiveButton(popInfo.ahead_info, new C1249b(this, popInfo));
                aVar.create(this.f26714a.f26712a.getPageContext()).show();
            }
        }
    }

    public c(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26712a = frsFragment;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PopInfo popInfo = this.f26712a.getFrsViewData().enterFrsDialogInfo;
            return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.f26712a.getFrsViewData().enterFrsDialogInfo.if_pop.intValue() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || !TbadkCoreApplication.isLogin() || (frsFragment = this.f26712a) == null || frsFragment.getFrsViewData() == null || this.f26712a.getFrsViewData().getForum() == null || StringUtils.isNull(this.f26712a.getFrsViewData().getForum().getName()) || this.f26712a.getFrsViewData().enterFrsDialogInfo == null || !c() || this.f26713b != null) {
            return;
        }
        b bVar = new b(this, null);
        this.f26713b = bVar;
        bVar.execute(new Void[0]);
    }
}
