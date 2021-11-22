package b.a.r0.x0.d2.a.c;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import b.a.r0.x0.d2.a.c.a;
import b.a.r0.x0.d2.a.d.e;
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
public class b implements b.a.r0.x0.d2.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f27220a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f27221b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.x0.d2.a.d.b f27222c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f27223d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, b.a.r0.x0.d2.a.a.c> f27224e;

    /* renamed from: f  reason: collision with root package name */
    public int f27225f;

    /* renamed from: g  reason: collision with root package name */
    public int f27226g;

    /* renamed from: h  reason: collision with root package name */
    public int f27227h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27228i;
    public long j;
    public Handler k;
    public b.a.r0.x0.d2.a.c.a l;
    public a.c m;
    public b.a.e.c.g.a n;

    /* loaded from: classes5.dex */
    public class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27229a;

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
            this.f27229a = bVar;
        }

        @Override // b.a.r0.x0.d2.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) || this.f27229a.f27223d == null || this.f27229a.f27222c == null) {
                return;
            }
            this.f27229a.f27222c.refreshView(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: b.a.r0.x0.d2.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1337b extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27230a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1337b(b bVar, int i2, int i3) {
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
            this.f27230a = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        @Override // b.a.e.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<n> threadList;
            boolean hasMore;
            int i2;
            e eVar;
            b.a.r0.x0.d2.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.f27230a.f27228i = false;
            if (responsedMessage.hasError()) {
                if (this.f27230a.f27222c != null) {
                    this.f27230a.f27222c.showError(this.f27230a.f27225f, this.f27230a.f27226g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.f27230a.f27223d == null) {
                    this.f27230a.f27223d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.f27230a.f27223d == null) {
                    this.f27230a.f27223d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i3 = this.f27230a.f27225f;
            int i4 = this.f27230a.f27226g;
            if (this.f27230a.f27225f == 0 && this.f27230a.f27226g == 0 && !ListUtils.isEmpty(this.f27230a.f27223d) && (eVar = (e) this.f27230a.f27223d.get(0)) != null) {
                i3 = eVar.f27240a;
                Object obj = eVar.f27242c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i4 = aVar.f27204a;
                    }
                }
            }
            String o = this.f27230a.o(i3, i4);
            b.a.r0.x0.d2.a.a.c cVar = (b.a.r0.x0.d2.a.a.c) this.f27230a.f27224e.get(o);
            if (cVar == null) {
                cVar = new b.a.r0.x0.d2.a.a.c();
                this.f27230a.f27224e.put(o, cVar);
                this.f27230a.f27224e.put(o, cVar);
            }
            cVar.f27213e = hasMore;
            cVar.f27214f = this.f27230a.f27227h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.f27230a.f27227h == 0) {
                    if (ListUtils.isEmpty(cVar.f27212d)) {
                        cVar.f27212d = threadList;
                    } else {
                        i2 = cVar.a(threadList);
                        if (this.f27230a.f27222c == null) {
                            this.f27230a.f27222c.refreshView(this.f27230a.f27225f, this.f27230a.f27226g, cVar.f27212d, this.f27230a.f27223d, cVar.f27213e, false, i2);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f27212d.addAll(threadList);
                }
            }
            i2 = -1;
            if (this.f27230a.f27222c == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f27231e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27232f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f27233g;

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
            this.f27233g = bVar;
            this.f27231e = i2;
            this.f27232f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27233g.b(this.f27231e, this.f27232f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f27234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27235f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f27236g;

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
            this.f27236g = bVar;
            this.f27234e = i2;
            this.f27235f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27236g.c(this.f27234e, this.f27235f);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27225f = 0;
        this.f27226g = 0;
        this.f27227h = 0;
        this.f27228i = false;
        this.j = 0L;
        this.k = new Handler();
        this.m = new a(this);
        this.n = new C1337b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.f27220a = context;
        this.f27221b = bdUniqueId;
        this.j = j;
        this.f27224e = new HashMap<>();
        b.a.r0.x0.d2.a.c.a aVar = new b.a.r0.x0.d2.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        r();
        s();
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b.a.r0.m3.f0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, b.a.r0.m3.f0.a.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // b.a.r0.x0.d2.a.d.a
    public e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f27223d)) {
                return null;
            }
            for (e eVar : this.f27223d) {
                if (eVar != null && eVar.f27240a == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    @Override // b.a.r0.x0.d2.a.d.a
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f27228i) {
                this.k.postDelayed(new c(this, i2, i3), 1000L);
                return;
            }
            this.f27225f = i2;
            this.f27226g = i3;
            if (i2 == 0 && i3 == 0) {
                this.l.c(String.valueOf(this.j));
            } else {
                String o = o(i2, i3);
                b.a.r0.x0.d2.a.a.c cVar = this.f27224e.get(o);
                if (cVar == null) {
                    cVar = new b.a.r0.x0.d2.a.a.c();
                    this.f27224e.put(o, cVar);
                }
                cVar.f27209a = o;
                cVar.f27210b = this.f27225f;
                cVar.f27211c = this.f27226g;
                cVar.f27214f = 0;
                cVar.f27213e = true;
            }
            this.f27227h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f27225f, this.f27226g);
            frsGameStrategyRequestMessage.setTag(this.f27221b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f27228i = true;
        }
    }

    @Override // b.a.r0.x0.d2.a.d.a
    public void c(int i2, int i3) {
        b.a.r0.x0.d2.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (this.f27228i) {
                this.k.postDelayed(new d(this, i2, i3), 1000L);
                return;
            }
            this.f27225f = i2;
            if (i2 == 0 && i3 == 0) {
                e n = n(i2);
                if (n != null) {
                    Object obj = n.f27242c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            this.f27226g = aVar.f27204a;
                        }
                    }
                }
            } else {
                this.f27226g = i3;
            }
            String o = o(i2, i3);
            b.a.r0.x0.d2.a.a.c cVar = this.f27224e.get(o);
            if (cVar == null) {
                cVar = new b.a.r0.x0.d2.a.a.c();
                this.f27224e.put(o, cVar);
                cVar.f27213e = true;
                this.f27224e.put(o, cVar);
            }
            int i4 = cVar.f27214f + 1;
            this.f27227h = i4;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i4, this.f27225f, this.f27226g);
            frsGameStrategyRequestMessage.setTag(this.f27221b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f27228i = true;
        }
    }

    @Override // b.a.r0.x0.d2.a.d.a
    public boolean d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            b.a.r0.x0.d2.a.a.c p = p(i2, i3);
            if (p == null || ListUtils.isEmpty(p.f27212d)) {
                return false;
            }
            b.a.r0.x0.d2.a.d.b bVar = this.f27222c;
            if (bVar != null) {
                bVar.refreshView(i2, i3, p.f27212d, this.f27223d, p.f27213e, false, -1);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    @Override // b.a.r0.x0.d2.a.d.a
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.valueOf(this.j) : (String) invokeV.objValue;
    }

    public final e n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f27223d)) {
                return null;
            }
            for (e eVar : this.f27223d) {
                if (eVar != null && eVar.f27240a == i2) {
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

    public b.a.r0.x0.d2.a.a.c p(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) ? this.f27224e.get(o(i2, i3)) : (b.a.r0.x0.d2.a.a.c) invokeII.objValue;
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
            this.n.setTag(this.f27221b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void t(b.a.r0.x0.d2.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f27222c = bVar;
        }
    }
}
