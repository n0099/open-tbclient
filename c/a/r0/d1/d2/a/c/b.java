package c.a.r0.d1.d2.a.c;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.r0.d1.d2.a.c.a;
import c.a.r0.d1.d2.a.d.e;
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
/* loaded from: classes5.dex */
public class b implements c.a.r0.d1.d2.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f15412b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.d1.d2.a.d.b f15413c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f15414d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, c.a.r0.d1.d2.a.a.c> f15415e;

    /* renamed from: f  reason: collision with root package name */
    public int f15416f;

    /* renamed from: g  reason: collision with root package name */
    public int f15417g;

    /* renamed from: h  reason: collision with root package name */
    public int f15418h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15419i;

    /* renamed from: j  reason: collision with root package name */
    public long f15420j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f15421k;
    public c.a.r0.d1.d2.a.c.a l;
    public a.c m;
    public c.a.d.c.g.a n;

    /* loaded from: classes5.dex */
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

        @Override // c.a.r0.d1.d2.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) || this.a.f15414d == null || this.a.f15413c == null) {
                return;
            }
            this.a.f15413c.refreshView(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: c.a.r0.d1.d2.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0938b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0938b(b bVar, int i2, int i3) {
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
            c.a.r0.d1.d2.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.a.f15419i = false;
            if (responsedMessage.hasError()) {
                if (this.a.f15413c != null) {
                    this.a.f15413c.showError(this.a.f15416f, this.a.f15417g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.a.f15414d == null) {
                    this.a.f15414d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.a.f15414d == null) {
                    this.a.f15414d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i3 = this.a.f15416f;
            int i4 = this.a.f15417g;
            if (this.a.f15416f == 0 && this.a.f15417g == 0 && !ListUtils.isEmpty(this.a.f15414d) && (eVar = (e) this.a.f15414d.get(0)) != null) {
                i3 = eVar.a;
                Object obj = eVar.f15433c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i4 = aVar.a;
                    }
                }
            }
            String o = this.a.o(i3, i4);
            c.a.r0.d1.d2.a.a.c cVar = (c.a.r0.d1.d2.a.a.c) this.a.f15415e.get(o);
            if (cVar == null) {
                cVar = new c.a.r0.d1.d2.a.a.c();
                this.a.f15415e.put(o, cVar);
                this.a.f15415e.put(o, cVar);
            }
            cVar.f15408e = hasMore;
            cVar.f15409f = this.a.f15418h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.a.f15418h == 0) {
                    if (ListUtils.isEmpty(cVar.f15407d)) {
                        cVar.f15407d = threadList;
                    } else {
                        i2 = cVar.a(threadList);
                        if (this.a.f15413c == null) {
                            this.a.f15413c.refreshView(this.a.f15416f, this.a.f15417g, cVar.f15407d, this.a.f15414d, cVar.f15408e, false, i2);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f15407d.addAll(threadList);
                }
            }
            i2 = -1;
            if (this.a.f15413c == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f15422e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f15423f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f15424g;

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
            this.f15424g = bVar;
            this.f15422e = i2;
            this.f15423f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15424g.b(this.f15422e, this.f15423f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f15425e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f15426f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f15427g;

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
            this.f15427g = bVar;
            this.f15425e = i2;
            this.f15426f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15427g.c(this.f15425e, this.f15426f);
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
        this.f15416f = 0;
        this.f15417g = 0;
        this.f15418h = 0;
        this.f15419i = false;
        this.f15420j = 0L;
        this.f15421k = new Handler();
        this.m = new a(this);
        this.n = new C0938b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.a = context;
        this.f15412b = bdUniqueId;
        this.f15420j = j2;
        this.f15415e = new HashMap<>();
        c.a.r0.d1.d2.a.c.a aVar = new c.a.r0.d1.d2.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        r();
        s();
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.r0.t3.f0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, c.a.r0.t3.f0.a.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // c.a.r0.d1.d2.a.d.a
    public e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f15414d)) {
                return null;
            }
            for (e eVar : this.f15414d) {
                if (eVar != null && eVar.a == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    @Override // c.a.r0.d1.d2.a.d.a
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f15419i) {
                this.f15421k.postDelayed(new c(this, i2, i3), 1000L);
                return;
            }
            this.f15416f = i2;
            this.f15417g = i3;
            if (i2 == 0 && i3 == 0) {
                this.l.c(String.valueOf(this.f15420j));
            } else {
                String o = o(i2, i3);
                c.a.r0.d1.d2.a.a.c cVar = this.f15415e.get(o);
                if (cVar == null) {
                    cVar = new c.a.r0.d1.d2.a.a.c();
                    this.f15415e.put(o, cVar);
                }
                cVar.a = o;
                cVar.f15405b = this.f15416f;
                cVar.f15406c = this.f15417g;
                cVar.f15409f = 0;
                cVar.f15408e = true;
            }
            this.f15418h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.f15420j, 0, this.f15416f, this.f15417g);
            frsGameStrategyRequestMessage.setTag(this.f15412b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f15419i = true;
        }
    }

    @Override // c.a.r0.d1.d2.a.d.a
    public void c(int i2, int i3) {
        c.a.r0.d1.d2.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (this.f15419i) {
                this.f15421k.postDelayed(new d(this, i2, i3), 1000L);
                return;
            }
            this.f15416f = i2;
            if (i2 == 0 && i3 == 0) {
                e n = n(i2);
                if (n != null) {
                    Object obj = n.f15433c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            this.f15417g = aVar.a;
                        }
                    }
                }
            } else {
                this.f15417g = i3;
            }
            String o = o(i2, i3);
            c.a.r0.d1.d2.a.a.c cVar = this.f15415e.get(o);
            if (cVar == null) {
                cVar = new c.a.r0.d1.d2.a.a.c();
                this.f15415e.put(o, cVar);
                cVar.f15408e = true;
                this.f15415e.put(o, cVar);
            }
            int i4 = cVar.f15409f + 1;
            this.f15418h = i4;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.f15420j, i4, this.f15416f, this.f15417g);
            frsGameStrategyRequestMessage.setTag(this.f15412b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f15419i = true;
        }
    }

    @Override // c.a.r0.d1.d2.a.d.a
    public boolean d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            c.a.r0.d1.d2.a.a.c p = p(i2, i3);
            if (p == null || ListUtils.isEmpty(p.f15407d)) {
                return false;
            }
            c.a.r0.d1.d2.a.d.b bVar = this.f15413c;
            if (bVar != null) {
                bVar.refreshView(i2, i3, p.f15407d, this.f15414d, p.f15408e, false, -1);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    @Override // c.a.r0.d1.d2.a.d.a
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.valueOf(this.f15420j) : (String) invokeV.objValue;
    }

    public final e n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f15414d)) {
                return null;
            }
            for (e eVar : this.f15414d) {
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

    public c.a.r0.d1.d2.a.a.c p(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) ? this.f15415e.get(o(i2, i3)) : (c.a.r0.d1.d2.a.a.c) invokeII.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f15421k.removeCallbacksAndMessages(null);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.setTag(this.f15412b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void t(c.a.r0.d1.d2.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f15413c = bVar;
        }
    }
}
