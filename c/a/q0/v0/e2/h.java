package c.a.q0.v0.e2;

import android.text.TextUtils;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class h extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c2 f26005h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26006i;

    /* renamed from: j  reason: collision with root package name */
    public String f26007j;
    public PraiseModel k;
    public final CustomMessageListener l;

    /* loaded from: classes4.dex */
    public class a implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f26008a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26008a = hVar;
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f26008a.f26006i) {
                    int i2 = 1;
                    if (this.f26008a.f26005h != null && this.f26008a.f26005h.J0().getIsLike() == 1) {
                        i2 = 0;
                    }
                    this.f26008a.h(i2);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i2, String str) {
            FrsFragment frsFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (frsFragment = this.f26008a.f26011b) == null || frsFragment.getPageContext() == null || !this.f26008a.f26006i || TextUtils.isEmpty(str)) {
                return;
            }
            if (AntiHelper.m(i2, str)) {
                AntiHelper.u(this.f26008a.f26011b.getPageContext().getPageActivity(), str);
            } else {
                this.f26008a.f26011b.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f26009a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26009a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c2)) {
                c2 c2Var = (c2) customResponsedMessage.getData();
                this.f26009a.f26007j = c2Var.f0();
                if (TextUtils.isEmpty(this.f26009a.f26007j) || c2Var.J0() == null) {
                    return;
                }
                this.f26009a.h(c2Var.J0().getIsLike());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b bVar = new b(this, 2004004);
        this.l = bVar;
        this.f26011b.registerListener(bVar);
        this.k = e();
    }

    public final PraiseModel e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.k == null) {
                this.k = new PraiseModel(this.f26011b.getPageContext(), new a(this));
            }
            return this.k;
        }
        return (PraiseModel) invokeV.objValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f26006i = z;
        }
    }

    public void g(c2 c2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, c2Var, i2) == null) || c2Var == null) {
            return;
        }
        if (i2 == 1) {
            PraiseData J0 = c2Var.J0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (J0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i2);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    c2Var.c4(praiseData);
                    return;
                }
                c2Var.J0().getUser().add(0, metaData);
                c2Var.J0().setNum(c2Var.J0().getNum() + 1);
                c2Var.J0().setIsLike(i2);
            }
        } else if (c2Var.J0() != null) {
            c2Var.J0().setIsLike(i2);
            c2Var.J0().setNum(c2Var.J0().getNum() - 1);
            ArrayList<MetaData> user = c2Var.J0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        c2Var.J0().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    public void h(int i2) {
        FrsViewData frsViewData;
        ArrayList<c.a.e.l.e.n> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (frsViewData = this.f26011b.getFrsViewData()) == null || this.f26010a == null || (threadList = frsViewData.getThreadList()) == null) {
            return;
        }
        Iterator<c.a.e.l.e.n> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.e.l.e.n next = it.next();
            if (next instanceof b2) {
                c2 c2Var = ((b2) next).w;
                if (c2Var == this.f26005h) {
                    g(c2Var, i2);
                    this.f26005h = null;
                    break;
                } else if (c2Var.f0() != null && c2Var.f0().equals(this.f26007j)) {
                    g(c2Var, i2);
                    this.f26007j = null;
                    break;
                }
            }
        }
        this.f26010a.W().h(threadList, frsViewData);
        this.f26010a.W().notifyDataSetChanged();
    }
}
