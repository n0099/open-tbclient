package c.a.s0.d1.d2.a.c;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.s0.d1.d2.a.c.a;
import c.a.s0.d1.d2.a.d.e;
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
/* loaded from: classes7.dex */
public class b implements c.a.s0.d1.d2.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f15822b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.d1.d2.a.d.b f15823c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f15824d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, c.a.s0.d1.d2.a.a.c> f15825e;

    /* renamed from: f  reason: collision with root package name */
    public int f15826f;

    /* renamed from: g  reason: collision with root package name */
    public int f15827g;

    /* renamed from: h  reason: collision with root package name */
    public int f15828h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15829i;

    /* renamed from: j  reason: collision with root package name */
    public long f15830j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f15831k;
    public c.a.s0.d1.d2.a.c.a l;
    public a.c m;
    public c.a.d.c.g.a n;

    /* loaded from: classes7.dex */
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

        @Override // c.a.s0.d1.d2.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) || this.a.f15824d == null || this.a.f15823c == null) {
                return;
            }
            this.a.f15823c.refreshView(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: c.a.s0.d1.d2.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0980b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0980b(b bVar, int i2, int i3) {
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
            c.a.s0.d1.d2.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.a.f15829i = false;
            if (responsedMessage.hasError()) {
                if (this.a.f15823c != null) {
                    this.a.f15823c.showError(this.a.f15826f, this.a.f15827g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.a.f15824d == null) {
                    this.a.f15824d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.a.f15824d == null) {
                    this.a.f15824d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i3 = this.a.f15826f;
            int i4 = this.a.f15827g;
            if (this.a.f15826f == 0 && this.a.f15827g == 0 && !ListUtils.isEmpty(this.a.f15824d) && (eVar = (e) this.a.f15824d.get(0)) != null) {
                i3 = eVar.a;
                Object obj = eVar.f15843c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i4 = aVar.a;
                    }
                }
            }
            String o = this.a.o(i3, i4);
            c.a.s0.d1.d2.a.a.c cVar = (c.a.s0.d1.d2.a.a.c) this.a.f15825e.get(o);
            if (cVar == null) {
                cVar = new c.a.s0.d1.d2.a.a.c();
                this.a.f15825e.put(o, cVar);
                this.a.f15825e.put(o, cVar);
            }
            cVar.f15818e = hasMore;
            cVar.f15819f = this.a.f15828h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.a.f15828h == 0) {
                    if (ListUtils.isEmpty(cVar.f15817d)) {
                        cVar.f15817d = threadList;
                    } else {
                        i2 = cVar.a(threadList);
                        if (this.a.f15823c == null) {
                            this.a.f15823c.refreshView(this.a.f15826f, this.a.f15827g, cVar.f15817d, this.a.f15824d, cVar.f15818e, false, i2);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f15817d.addAll(threadList);
                }
            }
            i2 = -1;
            if (this.a.f15823c == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f15832e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f15833f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f15834g;

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
            this.f15834g = bVar;
            this.f15832e = i2;
            this.f15833f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15834g.b(this.f15832e, this.f15833f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f15835e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f15836f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f15837g;

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
            this.f15837g = bVar;
            this.f15835e = i2;
            this.f15836f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15837g.c(this.f15835e, this.f15836f);
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
        this.f15826f = 0;
        this.f15827g = 0;
        this.f15828h = 0;
        this.f15829i = false;
        this.f15830j = 0L;
        this.f15831k = new Handler();
        this.m = new a(this);
        this.n = new C0980b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.a = context;
        this.f15822b = bdUniqueId;
        this.f15830j = j2;
        this.f15825e = new HashMap<>();
        c.a.s0.d1.d2.a.c.a aVar = new c.a.s0.d1.d2.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        r();
        s();
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.s0.v3.f0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, c.a.s0.v3.f0.a.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // c.a.s0.d1.d2.a.d.a
    public e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f15824d)) {
                return null;
            }
            for (e eVar : this.f15824d) {
                if (eVar != null && eVar.a == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    @Override // c.a.s0.d1.d2.a.d.a
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f15829i) {
                this.f15831k.postDelayed(new c(this, i2, i3), 1000L);
                return;
            }
            this.f15826f = i2;
            this.f15827g = i3;
            if (i2 == 0 && i3 == 0) {
                this.l.c(String.valueOf(this.f15830j));
            } else {
                String o = o(i2, i3);
                c.a.s0.d1.d2.a.a.c cVar = this.f15825e.get(o);
                if (cVar == null) {
                    cVar = new c.a.s0.d1.d2.a.a.c();
                    this.f15825e.put(o, cVar);
                }
                cVar.a = o;
                cVar.f15815b = this.f15826f;
                cVar.f15816c = this.f15827g;
                cVar.f15819f = 0;
                cVar.f15818e = true;
            }
            this.f15828h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.f15830j, 0, this.f15826f, this.f15827g);
            frsGameStrategyRequestMessage.setTag(this.f15822b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f15829i = true;
        }
    }

    @Override // c.a.s0.d1.d2.a.d.a
    public void c(int i2, int i3) {
        c.a.s0.d1.d2.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (this.f15829i) {
                this.f15831k.postDelayed(new d(this, i2, i3), 1000L);
                return;
            }
            this.f15826f = i2;
            if (i2 == 0 && i3 == 0) {
                e n = n(i2);
                if (n != null) {
                    Object obj = n.f15843c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            this.f15827g = aVar.a;
                        }
                    }
                }
            } else {
                this.f15827g = i3;
            }
            String o = o(i2, i3);
            c.a.s0.d1.d2.a.a.c cVar = this.f15825e.get(o);
            if (cVar == null) {
                cVar = new c.a.s0.d1.d2.a.a.c();
                this.f15825e.put(o, cVar);
                cVar.f15818e = true;
                this.f15825e.put(o, cVar);
            }
            int i4 = cVar.f15819f + 1;
            this.f15828h = i4;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.f15830j, i4, this.f15826f, this.f15827g);
            frsGameStrategyRequestMessage.setTag(this.f15822b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f15829i = true;
        }
    }

    @Override // c.a.s0.d1.d2.a.d.a
    public boolean d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            c.a.s0.d1.d2.a.a.c p = p(i2, i3);
            if (p == null || ListUtils.isEmpty(p.f15817d)) {
                return false;
            }
            c.a.s0.d1.d2.a.d.b bVar = this.f15823c;
            if (bVar != null) {
                bVar.refreshView(i2, i3, p.f15817d, this.f15824d, p.f15818e, false, -1);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    @Override // c.a.s0.d1.d2.a.d.a
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.valueOf(this.f15830j) : (String) invokeV.objValue;
    }

    public final e n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f15824d)) {
                return null;
            }
            for (e eVar : this.f15824d) {
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

    public c.a.s0.d1.d2.a.a.c p(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) ? this.f15825e.get(o(i2, i3)) : (c.a.s0.d1.d2.a.a.c) invokeII.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f15831k.removeCallbacksAndMessages(null);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.setTag(this.f15822b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void t(c.a.s0.d1.d2.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f15823c = bVar;
        }
    }
}
