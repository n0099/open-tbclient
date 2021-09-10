package c.a.r0.r0;

import android.text.TextUtils;
import c.a.q0.x.p.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class u extends c.a.q0.x.p.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static u f24370g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<c.a.q0.x.p.c> f24371e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f24372f;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u f24373a;

        /* renamed from: c.a.r0.r0.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1130a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f24374e;

            public RunnableC1130a(a aVar) {
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
                this.f24374e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f24374e.f24373a.g();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u uVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, Integer.valueOf(i2)};
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
            this.f24373a = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f24373a.d();
                new Thread(new RunnableC1130a(this)).start();
            }
        }
    }

    public u() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24372f = new a(this, 2005016);
        MessageManager.getInstance().registerListener(this.f24372f);
    }

    public static u e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f24370g == null) {
                synchronized (u.class) {
                    if (f24370g == null) {
                        f24370g = new u();
                    }
                }
            }
            return f24370g;
        }
        return (u) invokeV.objValue;
    }

    @Override // c.a.q0.x.p.a
    public void b(a.InterfaceC0717a interfaceC0717a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, interfaceC0717a) == null) && FileHelper.checkSD()) {
            LinkedList<c.a.q0.x.p.c> linkedList = this.f24371e;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<c.a.q0.x.p.c> it = this.f24371e.iterator();
                while (it.hasNext()) {
                    c.a.q0.x.p.c next = it.next();
                    if (interfaceC0717a != null) {
                        interfaceC0717a.a(next);
                    }
                }
                return;
            }
            this.f24371e = new LinkedList<>();
            s sVar = new s();
            this.f24371e.add(sVar);
            if (interfaceC0717a != null) {
                interfaceC0717a.a(sVar);
            }
        }
    }

    @Override // c.a.q0.x.p.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // c.a.q0.x.p.a
    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        List<CollectEmotionData> n = g.k().n(TbadkCoreApplication.getCurrentAccount());
        if (n != null && n.size() != 0) {
            int size = (n == null || n.size() == 0) ? 0 : n.size() - 1;
            StatisticItem statisticItem = new StatisticItem("c12224");
            statisticItem.param("obj_param1", size);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            return;
        }
        CollectEmotionData collectEmotionData = new CollectEmotionData();
        collectEmotionData.pid = "setting_icon";
        collectEmotionData.orderId = 301;
        collectEmotionData.sharpText = c.a.q0.c0.d.f12799d;
        collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
        g.k().a(collectEmotionData);
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.groupId = c.a.q0.c0.d.a();
        emotionGroupData.groupName = "用户收藏表情";
        emotionGroupData.groupDesc = "用户收藏表情";
        emotionGroupData.emotionsCount = 301;
        emotionGroupData.status = 1;
        emotionGroupData.downloadUrl = "";
        g.k().f(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
        g.k().e(emotionGroupData);
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            LinkedList<c.a.q0.x.p.c> linkedList = this.f24371e;
            if (linkedList == null) {
                return false;
            }
            Iterator<c.a.q0.x.p.c> it = linkedList.iterator();
            while (it.hasNext()) {
                c.a.q0.x.p.c next = it.next();
                if (next instanceof s) {
                    return ((s) next).u(str);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.f24371e == null) {
                    return;
                }
                Iterator<c.a.q0.x.p.c> it = this.f24371e.iterator();
                while (it.hasNext()) {
                    c.a.q0.x.p.c next = it.next();
                    if (next instanceof s) {
                        ((s) next).w();
                    }
                }
            }
        }
    }
}
