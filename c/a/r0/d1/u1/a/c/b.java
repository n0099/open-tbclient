package c.a.r0.d1.u1.a.c;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.r0.d1.u1.a.c.a;
import c.a.r0.d1.u1.a.d.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyHttpResponseMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategyRequestMessage;
import com.baidu.tieba.frs.game.strategy.message.FrsGameStrategySocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements c.a.r0.d1.u1.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f16502b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.d1.u1.a.d.b f16503c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f16504d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, c.a.r0.d1.u1.a.a.c> f16505e;

    /* renamed from: f  reason: collision with root package name */
    public int f16506f;

    /* renamed from: g  reason: collision with root package name */
    public int f16507g;

    /* renamed from: h  reason: collision with root package name */
    public int f16508h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16509i;

    /* renamed from: j  reason: collision with root package name */
    public long f16510j;
    public Handler k;
    public c.a.r0.d1.u1.a.c.a l;
    public a.c m;
    public c.a.d.c.g.a n;

    /* loaded from: classes2.dex */
    public class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.r0.d1.u1.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) || this.a.f16504d == null || this.a.f16503c == null) {
                return;
            }
            this.a.f16503c.refreshView(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: c.a.r0.d1.u1.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1055b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1055b(b bVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        @Override // c.a.d.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<n> threadList;
            boolean hasMore;
            int i2;
            e eVar;
            c.a.r0.d1.u1.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.a.f16509i = false;
            if (responsedMessage.hasError()) {
                if (this.a.f16503c != null) {
                    this.a.f16503c.showError(this.a.f16506f, this.a.f16507g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.a.f16504d == null) {
                    this.a.f16504d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.a.f16504d == null) {
                    this.a.f16504d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i3 = this.a.f16506f;
            int i4 = this.a.f16507g;
            if (this.a.f16506f == 0 && this.a.f16507g == 0 && !ListUtils.isEmpty(this.a.f16504d) && (eVar = (e) this.a.f16504d.get(0)) != null) {
                i3 = eVar.a;
                Object obj = eVar.f16522c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i4 = aVar.a;
                    }
                }
            }
            String o = this.a.o(i3, i4);
            c.a.r0.d1.u1.a.a.c cVar = (c.a.r0.d1.u1.a.a.c) this.a.f16505e.get(o);
            if (cVar == null) {
                cVar = new c.a.r0.d1.u1.a.a.c();
                this.a.f16505e.put(o, cVar);
                this.a.f16505e.put(o, cVar);
            }
            cVar.f16498e = hasMore;
            cVar.f16499f = this.a.f16508h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.a.f16508h == 0) {
                    if (ListUtils.isEmpty(cVar.f16497d)) {
                        cVar.f16497d = threadList;
                    } else {
                        i2 = cVar.a(threadList);
                        if (this.a.f16503c == null) {
                            this.a.f16503c.refreshView(this.a.f16506f, this.a.f16507g, cVar.f16497d, this.a.f16504d, cVar.f16498e, false, i2);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f16497d.addAll(threadList);
                }
            }
            i2 = -1;
            if (this.a.f16503c == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f16511e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16512f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f16513g;

        public c(b bVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16513g = bVar;
            this.f16511e = i2;
            this.f16512f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16513g.b(this.f16511e, this.f16512f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f16514e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16515f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f16516g;

        public d(b bVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16516g = bVar;
            this.f16514e = i2;
            this.f16515f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16516g.c(this.f16514e, this.f16515f);
            }
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Long.valueOf(j2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16506f = 0;
        this.f16507g = 0;
        this.f16508h = 0;
        this.f16509i = false;
        this.f16510j = 0L;
        this.k = new Handler();
        this.m = new a(this);
        this.n = new C1055b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.a = context;
        this.f16502b = bdUniqueId;
        this.f16510j = j2;
        this.f16505e = new HashMap<>();
        c.a.r0.d1.u1.a.c.a aVar = new c.a.r0.d1.u1.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        r();
        s();
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.r0.y3.g0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, c.a.r0.y3.g0.a.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // c.a.r0.d1.u1.a.d.a
    public e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f16504d)) {
                return null;
            }
            for (e eVar : this.f16504d) {
                if (eVar != null && eVar.a == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    @Override // c.a.r0.d1.u1.a.d.a
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f16509i) {
                this.k.postDelayed(new c(this, i2, i3), 1000L);
                return;
            }
            this.f16506f = i2;
            this.f16507g = i3;
            if (i2 == 0 && i3 == 0) {
                this.l.c(String.valueOf(this.f16510j));
            } else {
                String o = o(i2, i3);
                c.a.r0.d1.u1.a.a.c cVar = this.f16505e.get(o);
                if (cVar == null) {
                    cVar = new c.a.r0.d1.u1.a.a.c();
                    this.f16505e.put(o, cVar);
                }
                cVar.a = o;
                cVar.f16495b = this.f16506f;
                cVar.f16496c = this.f16507g;
                cVar.f16499f = 0;
                cVar.f16498e = true;
            }
            this.f16508h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.f16510j, 0, this.f16506f, this.f16507g);
            frsGameStrategyRequestMessage.setTag(this.f16502b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f16509i = true;
        }
    }

    @Override // c.a.r0.d1.u1.a.d.a
    public void c(int i2, int i3) {
        c.a.r0.d1.u1.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (this.f16509i) {
                this.k.postDelayed(new d(this, i2, i3), 1000L);
                return;
            }
            this.f16506f = i2;
            if (i2 == 0 && i3 == 0) {
                e n = n(i2);
                if (n != null) {
                    Object obj = n.f16522c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            this.f16507g = aVar.a;
                        }
                    }
                }
            } else {
                this.f16507g = i3;
            }
            String o = o(i2, i3);
            c.a.r0.d1.u1.a.a.c cVar = this.f16505e.get(o);
            if (cVar == null) {
                cVar = new c.a.r0.d1.u1.a.a.c();
                this.f16505e.put(o, cVar);
                cVar.f16498e = true;
                this.f16505e.put(o, cVar);
            }
            int i4 = cVar.f16499f + 1;
            this.f16508h = i4;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.f16510j, i4, this.f16506f, this.f16507g);
            frsGameStrategyRequestMessage.setTag(this.f16502b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f16509i = true;
        }
    }

    @Override // c.a.r0.d1.u1.a.d.a
    public boolean d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            c.a.r0.d1.u1.a.a.c p = p(i2, i3);
            if (p == null || ListUtils.isEmpty(p.f16497d)) {
                return false;
            }
            c.a.r0.d1.u1.a.d.b bVar = this.f16503c;
            if (bVar != null) {
                bVar.refreshView(i2, i3, p.f16497d, this.f16504d, p.f16498e, false, -1);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    @Override // c.a.r0.d1.u1.a.d.a
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.valueOf(this.f16510j) : (String) invokeV.objValue;
    }

    public final e n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f16504d)) {
                return null;
            }
            for (e eVar : this.f16504d) {
                if (eVar != null && eVar.a == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    public final String o(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
            return i2 + "_" + i3;
        }
        return (String) invokeII.objValue;
    }

    public c.a.r0.d1.u1.a.a.c p(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) ? this.f16505e.get(o(i2, i3)) : (c.a.r0.d1.u1.a.a.c) invokeII.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k.removeCallbacksAndMessages(null);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.setTag(this.f16502b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void t(c.a.r0.d1.u1.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f16503c = bVar;
        }
    }
}
