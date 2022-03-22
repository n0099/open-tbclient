package c.a.p0.f1.u1.a.c;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.p0.f1.u1.a.c.a;
import c.a.p0.f1.u1.a.d.e;
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
public class b implements c.a.p0.f1.u1.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f14698b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.f1.u1.a.d.b f14699c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f14700d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, c.a.p0.f1.u1.a.a.c> f14701e;

    /* renamed from: f  reason: collision with root package name */
    public int f14702f;

    /* renamed from: g  reason: collision with root package name */
    public int f14703g;

    /* renamed from: h  reason: collision with root package name */
    public int f14704h;
    public boolean i;
    public long j;
    public Handler k;
    public c.a.p0.f1.u1.a.c.a l;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.f1.u1.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) || this.a.f14700d == null || this.a.f14699c == null) {
                return;
            }
            this.a.f14699c.a(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: c.a.p0.f1.u1.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1114b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1114b(b bVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            int i;
            e eVar;
            c.a.p0.f1.u1.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.a.i = false;
            if (responsedMessage.hasError()) {
                if (this.a.f14699c != null) {
                    this.a.f14699c.b(this.a.f14702f, this.a.f14703g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.a.f14700d == null) {
                    this.a.f14700d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.a.f14700d == null) {
                    this.a.f14700d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i2 = this.a.f14702f;
            int i3 = this.a.f14703g;
            if (this.a.f14702f == 0 && this.a.f14703g == 0 && !ListUtils.isEmpty(this.a.f14700d) && (eVar = (e) this.a.f14700d.get(0)) != null) {
                i2 = eVar.a;
                Object obj = eVar.f14714c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i3 = aVar.a;
                    }
                }
            }
            String p = this.a.p(i2, i3);
            c.a.p0.f1.u1.a.a.c cVar = (c.a.p0.f1.u1.a.a.c) this.a.f14701e.get(p);
            if (cVar == null) {
                cVar = new c.a.p0.f1.u1.a.a.c();
                this.a.f14701e.put(p, cVar);
                this.a.f14701e.put(p, cVar);
            }
            cVar.f14694e = hasMore;
            cVar.f14695f = this.a.f14704h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.a.f14704h == 0) {
                    if (ListUtils.isEmpty(cVar.f14693d)) {
                        cVar.f14693d = threadList;
                    } else {
                        i = cVar.a(threadList);
                        if (this.a.f14699c == null) {
                            this.a.f14699c.a(this.a.f14702f, this.a.f14703g, cVar.f14693d, this.a.f14700d, cVar.f14694e, false, i);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f14693d.addAll(threadList);
                }
            }
            i = -1;
            if (this.a.f14699c == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f14705b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f14706c;

        public c(b bVar, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14706c = bVar;
            this.a = i;
            this.f14705b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14706c.b(this.a, this.f14705b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f14707b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f14708c;

        public d(b bVar, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14708c = bVar;
            this.a = i;
            this.f14707b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14708c.d(this.a, this.f14707b);
            }
        }
    }

    public b(Context context, BdUniqueId bdUniqueId, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14702f = 0;
        this.f14703g = 0;
        this.f14704h = 0;
        this.i = false;
        this.j = 0L;
        this.k = new Handler();
        this.m = new a(this);
        this.n = new C1114b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.a = context;
        this.f14698b = bdUniqueId;
        this.j = j;
        this.f14701e = new HashMap<>();
        c.a.p0.f1.u1.a.c.a aVar = new c.a.p0.f1.u1.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        s();
        t();
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.p0.a4.g0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, c.a.p0.a4.g0.a.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // c.a.p0.f1.u1.a.d.a
    public e a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (ListUtils.isEmpty(this.f14700d)) {
                return null;
            }
            for (e eVar : this.f14700d) {
                if (eVar != null && eVar.a == i) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    @Override // c.a.p0.f1.u1.a.d.a
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            if (this.i) {
                this.k.postDelayed(new c(this, i, i2), 1000L);
                return;
            }
            this.f14702f = i;
            this.f14703g = i2;
            if (i == 0 && i2 == 0) {
                this.l.c(String.valueOf(this.j));
            } else {
                String p = p(i, i2);
                c.a.p0.f1.u1.a.a.c cVar = this.f14701e.get(p);
                if (cVar == null) {
                    cVar = new c.a.p0.f1.u1.a.a.c();
                    this.f14701e.put(p, cVar);
                }
                cVar.a = p;
                cVar.f14691b = this.f14702f;
                cVar.f14692c = this.f14703g;
                cVar.f14695f = 0;
                cVar.f14694e = true;
            }
            this.f14704h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f14702f, this.f14703g);
            frsGameStrategyRequestMessage.setTag(this.f14698b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.i = true;
        }
    }

    @Override // c.a.p0.f1.u1.a.d.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.valueOf(this.j) : (String) invokeV.objValue;
    }

    @Override // c.a.p0.f1.u1.a.d.a
    public void d(int i, int i2) {
        c.a.p0.f1.u1.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            if (this.i) {
                this.k.postDelayed(new d(this, i, i2), 1000L);
                return;
            }
            this.f14702f = i;
            if (i == 0 && i2 == 0) {
                e o = o(i);
                if (o != null) {
                    Object obj = o.f14714c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            this.f14703g = aVar.a;
                        }
                    }
                }
            } else {
                this.f14703g = i2;
            }
            String p = p(i, i2);
            c.a.p0.f1.u1.a.a.c cVar = this.f14701e.get(p);
            if (cVar == null) {
                cVar = new c.a.p0.f1.u1.a.a.c();
                this.f14701e.put(p, cVar);
                cVar.f14694e = true;
                this.f14701e.put(p, cVar);
            }
            int i3 = cVar.f14695f + 1;
            this.f14704h = i3;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i3, this.f14702f, this.f14703g);
            frsGameStrategyRequestMessage.setTag(this.f14698b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.i = true;
        }
    }

    @Override // c.a.p0.f1.u1.a.d.a
    public boolean e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
            c.a.p0.f1.u1.a.a.c q = q(i, i2);
            if (q == null || ListUtils.isEmpty(q.f14693d)) {
                return false;
            }
            c.a.p0.f1.u1.a.d.b bVar = this.f14699c;
            if (bVar != null) {
                bVar.a(i, i2, q.f14693d, this.f14700d, q.f14694e, false, -1);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    public final e o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (ListUtils.isEmpty(this.f14700d)) {
                return null;
            }
            for (e eVar : this.f14700d) {
                if (eVar != null && eVar.a == i) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    public final String p(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            return i + "_" + i2;
        }
        return (String) invokeII.objValue;
    }

    public c.a.p0.f1.u1.a.a.c q(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i, i2)) == null) ? this.f14701e.get(p(i, i2)) : (c.a.p0.f1.u1.a.a.c) invokeII.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k.removeCallbacksAndMessages(null);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.setTag(this.f14698b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void u(c.a.p0.f1.u1.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f14699c = bVar;
        }
    }
}
