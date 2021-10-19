package c.a.r0.x0.s1.a.c;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.r0.x0.s1.a.c.a;
import c.a.r0.x0.s1.a.d.e;
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
/* loaded from: classes4.dex */
public class b implements c.a.r0.x0.s1.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f27970a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f27971b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.x0.s1.a.d.b f27972c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f27973d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, c.a.r0.x0.s1.a.a.c> f27974e;

    /* renamed from: f  reason: collision with root package name */
    public int f27975f;

    /* renamed from: g  reason: collision with root package name */
    public int f27976g;

    /* renamed from: h  reason: collision with root package name */
    public int f27977h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27978i;

    /* renamed from: j  reason: collision with root package name */
    public long f27979j;
    public Handler k;
    public c.a.r0.x0.s1.a.c.a l;
    public a.c m;
    public c.a.e.c.g.a n;

    /* loaded from: classes4.dex */
    public class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27980a;

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
            this.f27980a = bVar;
        }

        @Override // c.a.r0.x0.s1.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) || this.f27980a.f27973d == null || this.f27980a.f27972c == null) {
                return;
            }
            this.f27980a.f27972c.refreshView(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: c.a.r0.x0.s1.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1316b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27981a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1316b(b bVar, int i2, int i3) {
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
            this.f27981a = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        @Override // c.a.e.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<n> threadList;
            boolean hasMore;
            int i2;
            e eVar;
            c.a.r0.x0.s1.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.f27981a.f27978i = false;
            if (responsedMessage.hasError()) {
                if (this.f27981a.f27972c != null) {
                    this.f27981a.f27972c.showError(this.f27981a.f27975f, this.f27981a.f27976g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.f27981a.f27973d == null) {
                    this.f27981a.f27973d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.f27981a.f27973d == null) {
                    this.f27981a.f27973d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i3 = this.f27981a.f27975f;
            int i4 = this.f27981a.f27976g;
            if (this.f27981a.f27975f == 0 && this.f27981a.f27976g == 0 && !ListUtils.isEmpty(this.f27981a.f27973d) && (eVar = (e) this.f27981a.f27973d.get(0)) != null) {
                i3 = eVar.f27992a;
                Object obj = eVar.f27994c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i4 = aVar.f27954a;
                    }
                }
            }
            String o = this.f27981a.o(i3, i4);
            c.a.r0.x0.s1.a.a.c cVar = (c.a.r0.x0.s1.a.a.c) this.f27981a.f27974e.get(o);
            if (cVar == null) {
                cVar = new c.a.r0.x0.s1.a.a.c();
                this.f27981a.f27974e.put(o, cVar);
                this.f27981a.f27974e.put(o, cVar);
            }
            cVar.f27963e = hasMore;
            cVar.f27964f = this.f27981a.f27977h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.f27981a.f27977h == 0) {
                    if (ListUtils.isEmpty(cVar.f27962d)) {
                        cVar.f27962d = threadList;
                    } else {
                        i2 = cVar.a(threadList);
                        if (this.f27981a.f27972c == null) {
                            this.f27981a.f27972c.refreshView(this.f27981a.f27975f, this.f27981a.f27976g, cVar.f27962d, this.f27981a.f27973d, cVar.f27963e, false, i2);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f27962d.addAll(threadList);
                }
            }
            i2 = -1;
            if (this.f27981a.f27972c == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f27982e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27983f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f27984g;

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
            this.f27984g = bVar;
            this.f27982e = i2;
            this.f27983f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27984g.b(this.f27982e, this.f27983f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f27985e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27986f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f27987g;

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
            this.f27987g = bVar;
            this.f27985e = i2;
            this.f27986f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27987g.c(this.f27985e, this.f27986f);
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
        this.f27975f = 0;
        this.f27976g = 0;
        this.f27977h = 0;
        this.f27978i = false;
        this.f27979j = 0L;
        this.k = new Handler();
        this.m = new a(this);
        this.n = new C1316b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.f27970a = context;
        this.f27971b = bdUniqueId;
        this.f27979j = j2;
        this.f27974e = new HashMap<>();
        c.a.r0.x0.s1.a.c.a aVar = new c.a.r0.x0.s1.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        r();
        s();
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.r0.k3.e0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, c.a.r0.k3.e0.a.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // c.a.r0.x0.s1.a.d.a
    public e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f27973d)) {
                return null;
            }
            for (e eVar : this.f27973d) {
                if (eVar != null && eVar.f27992a == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    @Override // c.a.r0.x0.s1.a.d.a
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f27978i) {
                this.k.postDelayed(new c(this, i2, i3), 1000L);
                return;
            }
            this.f27975f = i2;
            this.f27976g = i3;
            if (i2 == 0 && i3 == 0) {
                this.l.c(String.valueOf(this.f27979j));
            } else {
                String o = o(i2, i3);
                c.a.r0.x0.s1.a.a.c cVar = this.f27974e.get(o);
                if (cVar == null) {
                    cVar = new c.a.r0.x0.s1.a.a.c();
                    this.f27974e.put(o, cVar);
                }
                cVar.f27959a = o;
                cVar.f27960b = this.f27975f;
                cVar.f27961c = this.f27976g;
                cVar.f27964f = 0;
                cVar.f27963e = true;
            }
            this.f27977h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.f27979j, 0, this.f27975f, this.f27976g);
            frsGameStrategyRequestMessage.setTag(this.f27971b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f27978i = true;
        }
    }

    @Override // c.a.r0.x0.s1.a.d.a
    public void c(int i2, int i3) {
        c.a.r0.x0.s1.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (this.f27978i) {
                this.k.postDelayed(new d(this, i2, i3), 1000L);
                return;
            }
            this.f27975f = i2;
            if (i2 == 0 && i3 == 0) {
                e n = n(i2);
                if (n != null) {
                    Object obj = n.f27994c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            this.f27976g = aVar.f27954a;
                        }
                    }
                }
            } else {
                this.f27976g = i3;
            }
            String o = o(i2, i3);
            c.a.r0.x0.s1.a.a.c cVar = this.f27974e.get(o);
            if (cVar == null) {
                cVar = new c.a.r0.x0.s1.a.a.c();
                this.f27974e.put(o, cVar);
                cVar.f27963e = true;
                this.f27974e.put(o, cVar);
            }
            int i4 = cVar.f27964f + 1;
            this.f27977h = i4;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.f27979j, i4, this.f27975f, this.f27976g);
            frsGameStrategyRequestMessage.setTag(this.f27971b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f27978i = true;
        }
    }

    @Override // c.a.r0.x0.s1.a.d.a
    public boolean d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            c.a.r0.x0.s1.a.a.c p = p(i2, i3);
            if (p == null || ListUtils.isEmpty(p.f27962d)) {
                return false;
            }
            c.a.r0.x0.s1.a.d.b bVar = this.f27972c;
            if (bVar != null) {
                bVar.refreshView(i2, i3, p.f27962d, this.f27973d, p.f27963e, false, -1);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    @Override // c.a.r0.x0.s1.a.d.a
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.valueOf(this.f27979j) : (String) invokeV.objValue;
    }

    public final e n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f27973d)) {
                return null;
            }
            for (e eVar : this.f27973d) {
                if (eVar != null && eVar.f27992a == i2) {
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

    public c.a.r0.x0.s1.a.a.c p(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) ? this.f27974e.get(o(i2, i3)) : (c.a.r0.x0.s1.a.a.c) invokeII.objValue;
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
            this.n.setTag(this.f27971b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void t(c.a.r0.x0.s1.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f27972c = bVar;
        }
    }
}
