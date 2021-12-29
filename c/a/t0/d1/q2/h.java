package c.a.t0.d1.q2;

import android.text.TextUtils;
import c.a.s0.s.q.c2;
import c.a.s0.s.q.d2;
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
/* loaded from: classes7.dex */
public class h extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public d2 f16776h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16777i;

    /* renamed from: j  reason: collision with root package name */
    public String f16778j;

    /* renamed from: k  reason: collision with root package name */
    public PraiseModel f16779k;
    public final CustomMessageListener l;

    /* loaded from: classes7.dex */
    public class a implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

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
            this.a = hVar;
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.f16777i) {
                    int i2 = 1;
                    if (this.a.f16776h != null && this.a.f16776h.M0().getIsLike() == 1) {
                        i2 = 0;
                    }
                    this.a.h(i2);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i2, String str) {
            FrsFragment frsFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (frsFragment = this.a.f16780b) == null || frsFragment.getPageContext() == null || !this.a.f16777i || TextUtils.isEmpty(str)) {
                return;
            }
            if (AntiHelper.m(i2, str)) {
                AntiHelper.u(this.a.f16780b.getPageContext().getPageActivity(), str);
            } else {
                this.a.f16780b.showToast(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

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
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d2)) {
                d2 d2Var = (d2) customResponsedMessage.getData();
                this.a.f16778j = d2Var.g0();
                if (TextUtils.isEmpty(this.a.f16778j) || d2Var.M0() == null) {
                    return;
                }
                this.a.h(d2Var.M0().getIsLike());
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
        this.f16780b.registerListener(bVar);
        this.f16779k = e();
    }

    public final PraiseModel e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f16779k == null) {
                this.f16779k = new PraiseModel(this.f16780b.getPageContext(), new a(this));
            }
            return this.f16779k;
        }
        return (PraiseModel) invokeV.objValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f16777i = z;
        }
    }

    public void g(d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, d2Var, i2) == null) || d2Var == null) {
            return;
        }
        if (i2 == 1) {
            PraiseData M0 = d2Var.M0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (M0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i2);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    d2Var.q4(praiseData);
                    return;
                }
                d2Var.M0().getUser().add(0, metaData);
                d2Var.M0().setNum(d2Var.M0().getNum() + 1);
                d2Var.M0().setIsLike(i2);
            }
        } else if (d2Var.M0() != null) {
            d2Var.M0().setIsLike(i2);
            d2Var.M0().setNum(d2Var.M0().getNum() - 1);
            ArrayList<MetaData> user = d2Var.M0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        d2Var.M0().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    public void h(int i2) {
        FrsViewData frsViewData;
        ArrayList<c.a.d.n.e.n> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (frsViewData = this.f16780b.getFrsViewData()) == null || this.a == null || (threadList = frsViewData.getThreadList()) == null) {
            return;
        }
        Iterator<c.a.d.n.e.n> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.a.d.n.e.n next = it.next();
            if (next instanceof c2) {
                d2 d2Var = ((c2) next).w;
                if (d2Var == this.f16776h) {
                    g(d2Var, i2);
                    this.f16776h = null;
                    break;
                } else if (d2Var.g0() != null && d2Var.g0().equals(this.f16778j)) {
                    g(d2Var, i2);
                    this.f16778j = null;
                    break;
                }
            }
        }
        this.a.V().h(threadList, frsViewData);
        this.a.V().notifyDataSetChanged();
    }
}
