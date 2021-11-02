package b.a.r0.x0.c2.a.c;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import b.a.r0.x0.c2.a.c.a;
import b.a.r0.x0.c2.a.d.e;
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
public class b implements b.a.r0.x0.c2.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f25635a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f25636b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.x0.c2.a.d.b f25637c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f25638d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, b.a.r0.x0.c2.a.a.c> f25639e;

    /* renamed from: f  reason: collision with root package name */
    public int f25640f;

    /* renamed from: g  reason: collision with root package name */
    public int f25641g;

    /* renamed from: h  reason: collision with root package name */
    public int f25642h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25643i;
    public long j;
    public Handler k;
    public b.a.r0.x0.c2.a.c.a l;
    public a.c m;
    public b.a.e.c.g.a n;

    /* loaded from: classes5.dex */
    public class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25644a;

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
            this.f25644a = bVar;
        }

        @Override // b.a.r0.x0.c2.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) || this.f25644a.f25638d == null || this.f25644a.f25637c == null) {
                return;
            }
            this.f25644a.f25637c.refreshView(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: b.a.r0.x0.c2.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1264b extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25645a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1264b(b bVar, int i2, int i3) {
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
            this.f25645a = bVar;
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
            b.a.r0.x0.c2.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.f25645a.f25643i = false;
            if (responsedMessage.hasError()) {
                if (this.f25645a.f25637c != null) {
                    this.f25645a.f25637c.showError(this.f25645a.f25640f, this.f25645a.f25641g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.f25645a.f25638d == null) {
                    this.f25645a.f25638d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.f25645a.f25638d == null) {
                    this.f25645a.f25638d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i3 = this.f25645a.f25640f;
            int i4 = this.f25645a.f25641g;
            if (this.f25645a.f25640f == 0 && this.f25645a.f25641g == 0 && !ListUtils.isEmpty(this.f25645a.f25638d) && (eVar = (e) this.f25645a.f25638d.get(0)) != null) {
                i3 = eVar.f25655a;
                Object obj = eVar.f25657c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i4 = aVar.f25619a;
                    }
                }
            }
            String o = this.f25645a.o(i3, i4);
            b.a.r0.x0.c2.a.a.c cVar = (b.a.r0.x0.c2.a.a.c) this.f25645a.f25639e.get(o);
            if (cVar == null) {
                cVar = new b.a.r0.x0.c2.a.a.c();
                this.f25645a.f25639e.put(o, cVar);
                this.f25645a.f25639e.put(o, cVar);
            }
            cVar.f25628e = hasMore;
            cVar.f25629f = this.f25645a.f25642h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.f25645a.f25642h == 0) {
                    if (ListUtils.isEmpty(cVar.f25627d)) {
                        cVar.f25627d = threadList;
                    } else {
                        i2 = cVar.a(threadList);
                        if (this.f25645a.f25637c == null) {
                            this.f25645a.f25637c.refreshView(this.f25645a.f25640f, this.f25645a.f25641g, cVar.f25627d, this.f25645a.f25638d, cVar.f25628e, false, i2);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f25627d.addAll(threadList);
                }
            }
            i2 = -1;
            if (this.f25645a.f25637c == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f25646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f25647f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f25648g;

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
            this.f25648g = bVar;
            this.f25646e = i2;
            this.f25647f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25648g.b(this.f25646e, this.f25647f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f25649e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f25650f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f25651g;

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
            this.f25651g = bVar;
            this.f25649e = i2;
            this.f25650f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25651g.c(this.f25649e, this.f25650f);
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
        this.f25640f = 0;
        this.f25641g = 0;
        this.f25642h = 0;
        this.f25643i = false;
        this.j = 0L;
        this.k = new Handler();
        this.m = new a(this);
        this.n = new C1264b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.f25635a = context;
        this.f25636b = bdUniqueId;
        this.j = j;
        this.f25639e = new HashMap<>();
        b.a.r0.x0.c2.a.c.a aVar = new b.a.r0.x0.c2.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        r();
        s();
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b.a.r0.l3.f0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, b.a.r0.l3.f0.a.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // b.a.r0.x0.c2.a.d.a
    public e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f25638d)) {
                return null;
            }
            for (e eVar : this.f25638d) {
                if (eVar != null && eVar.f25655a == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    @Override // b.a.r0.x0.c2.a.d.a
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f25643i) {
                this.k.postDelayed(new c(this, i2, i3), 1000L);
                return;
            }
            this.f25640f = i2;
            this.f25641g = i3;
            if (i2 == 0 && i3 == 0) {
                this.l.c(String.valueOf(this.j));
            } else {
                String o = o(i2, i3);
                b.a.r0.x0.c2.a.a.c cVar = this.f25639e.get(o);
                if (cVar == null) {
                    cVar = new b.a.r0.x0.c2.a.a.c();
                    this.f25639e.put(o, cVar);
                }
                cVar.f25624a = o;
                cVar.f25625b = this.f25640f;
                cVar.f25626c = this.f25641g;
                cVar.f25629f = 0;
                cVar.f25628e = true;
            }
            this.f25642h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, 0, this.f25640f, this.f25641g);
            frsGameStrategyRequestMessage.setTag(this.f25636b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f25643i = true;
        }
    }

    @Override // b.a.r0.x0.c2.a.d.a
    public void c(int i2, int i3) {
        b.a.r0.x0.c2.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (this.f25643i) {
                this.k.postDelayed(new d(this, i2, i3), 1000L);
                return;
            }
            this.f25640f = i2;
            if (i2 == 0 && i3 == 0) {
                e n = n(i2);
                if (n != null) {
                    Object obj = n.f25657c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            this.f25641g = aVar.f25619a;
                        }
                    }
                }
            } else {
                this.f25641g = i3;
            }
            String o = o(i2, i3);
            b.a.r0.x0.c2.a.a.c cVar = this.f25639e.get(o);
            if (cVar == null) {
                cVar = new b.a.r0.x0.c2.a.a.c();
                this.f25639e.put(o, cVar);
                cVar.f25628e = true;
                this.f25639e.put(o, cVar);
            }
            int i4 = cVar.f25629f + 1;
            this.f25642h = i4;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.j, i4, this.f25640f, this.f25641g);
            frsGameStrategyRequestMessage.setTag(this.f25636b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f25643i = true;
        }
    }

    @Override // b.a.r0.x0.c2.a.d.a
    public boolean d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            b.a.r0.x0.c2.a.a.c p = p(i2, i3);
            if (p == null || ListUtils.isEmpty(p.f25627d)) {
                return false;
            }
            b.a.r0.x0.c2.a.d.b bVar = this.f25637c;
            if (bVar != null) {
                bVar.refreshView(i2, i3, p.f25627d, this.f25638d, p.f25628e, false, -1);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    @Override // b.a.r0.x0.c2.a.d.a
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.valueOf(this.j) : (String) invokeV.objValue;
    }

    public final e n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f25638d)) {
                return null;
            }
            for (e eVar : this.f25638d) {
                if (eVar != null && eVar.f25655a == i2) {
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

    public b.a.r0.x0.c2.a.a.c p(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) ? this.f25639e.get(o(i2, i3)) : (b.a.r0.x0.c2.a.a.c) invokeII.objValue;
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
            this.n.setTag(this.f25636b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void t(b.a.r0.x0.c2.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f25637c = bVar;
        }
    }
}
