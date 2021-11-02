package b.a.r0.s0;

import android.text.TextUtils;
import b.a.q0.x.p.a;
import b.a.r0.s0.p;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class q extends b.a.q0.x.p.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static q f23368f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<b.a.q0.x.p.c> f23369e;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f23370a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(q qVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, Integer.valueOf(i2)};
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
            this.f23370a = qVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001444) {
                Object data = customResponsedMessage.getData();
                if (data == null || !(data instanceof SingleBarEmotionRecommendData)) {
                    this.f23370a.g(null);
                    return;
                }
                SingleBarEmotionRecommendData singleBarEmotionRecommendData = (SingleBarEmotionRecommendData) data;
                LinkedList linkedList = new LinkedList();
                if (singleBarEmotionRecommendData == null || TextUtils.isEmpty(singleBarEmotionRecommendData.pkg_id) || TextUtils.isEmpty(singleBarEmotionRecommendData.cover)) {
                    this.f23370a.g(null);
                    return;
                }
                linkedList.add(singleBarEmotionRecommendData);
                this.f23370a.g(linkedList);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements p.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.r0.s0.p.b
        public void a(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
                MessageManager.getInstance().runTask(2004603, (Class) null);
            }
        }
    }

    public q() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static q f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f23368f == null) {
                synchronized (q.class) {
                    if (f23368f == null) {
                        f23368f = new q();
                    }
                }
            }
            return f23368f;
        }
        return (q) invokeV.objValue;
    }

    @Override // b.a.q0.x.p.a
    public void b(a.InterfaceC0714a interfaceC0714a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, interfaceC0714a) == null) && FileHelper.checkSD() && this.f23369e != null) {
            for (int i2 = 0; i2 < this.f23369e.size(); i2++) {
                p pVar = (p) this.f23369e.get(i2);
                if (pVar.t() && b.a.r0.f2.c.i().g(pVar.f()) == null && interfaceC0714a != null) {
                    interfaceC0714a.a(pVar);
                }
            }
        }
    }

    @Override // b.a.q0.x.p.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // b.a.q0.x.p.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(new a(this, 2001444));
        }
    }

    public final synchronized void g(List<b.a.r0.r0.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            synchronized (this) {
                if (list != null) {
                    if (!list.isEmpty()) {
                        if (this.f23369e != null) {
                            this.f23369e = null;
                        }
                        LinkedList<b.a.q0.x.p.c> linkedList = new LinkedList<>();
                        boolean z = false;
                        for (b.a.r0.r0.c.b bVar : list) {
                            if (bVar != null && !StringUtils.isNull(bVar.getGroupId()) && bVar.IsValid()) {
                                p pVar = new p(bVar);
                                linkedList.add(pVar);
                                z = pVar.u(bVar, new b(this));
                            }
                        }
                        this.f23369e = linkedList;
                        if (z) {
                            MessageManager.getInstance().runTask(2004603, (Class) null);
                        }
                    }
                }
                if (this.f23369e != null) {
                    this.f23369e = null;
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                }
            }
        }
    }
}
