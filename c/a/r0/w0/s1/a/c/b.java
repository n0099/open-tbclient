package c.a.r0.w0.s1.a.c;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.r0.w0.s1.a.c.a;
import c.a.r0.w0.s1.a.d.e;
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
public class b implements c.a.r0.w0.s1.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f27774a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f27775b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.w0.s1.a.d.b f27776c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f27777d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, c.a.r0.w0.s1.a.a.c> f27778e;

    /* renamed from: f  reason: collision with root package name */
    public int f27779f;

    /* renamed from: g  reason: collision with root package name */
    public int f27780g;

    /* renamed from: h  reason: collision with root package name */
    public int f27781h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27782i;

    /* renamed from: j  reason: collision with root package name */
    public long f27783j;
    public Handler k;
    public c.a.r0.w0.s1.a.c.a l;
    public a.c m;
    public c.a.e.c.g.a n;

    /* loaded from: classes4.dex */
    public class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27784a;

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
            this.f27784a = bVar;
        }

        @Override // c.a.r0.w0.s1.a.c.a.c
        public void a(List<e> list, List<n> list2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, list, list2, z) == null) || this.f27784a.f27777d == null || this.f27784a.f27776c == null) {
                return;
            }
            this.f27784a.f27776c.refreshView(0, 0, list2, list, z, true, -1);
        }
    }

    /* renamed from: c.a.r0.w0.s1.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1309b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27785a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1309b(b bVar, int i2, int i3) {
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
            this.f27785a = bVar;
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
            c.a.r0.w0.s1.a.a.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.f27785a.f27782i = false;
            if (responsedMessage.hasError()) {
                if (this.f27785a.f27776c != null) {
                    this.f27785a.f27776c.showError(this.f27785a.f27779f, this.f27785a.f27780g, responsedMessage.getErrorString());
                    return;
                }
                return;
            }
            if (responsedMessage instanceof FrsGameStrategySocketResponseMessage) {
                FrsGameStrategySocketResponseMessage frsGameStrategySocketResponseMessage = (FrsGameStrategySocketResponseMessage) responsedMessage;
                if (this.f27785a.f27777d == null) {
                    this.f27785a.f27777d = frsGameStrategySocketResponseMessage.getTabList();
                }
                threadList = frsGameStrategySocketResponseMessage.getThreadList();
                hasMore = frsGameStrategySocketResponseMessage.hasMore();
            } else if (!(responsedMessage instanceof FrsGameStrategyHttpResponseMessage)) {
                return;
            } else {
                FrsGameStrategyHttpResponseMessage frsGameStrategyHttpResponseMessage = (FrsGameStrategyHttpResponseMessage) responsedMessage;
                if (this.f27785a.f27777d == null) {
                    this.f27785a.f27777d = frsGameStrategyHttpResponseMessage.getTabList();
                }
                threadList = frsGameStrategyHttpResponseMessage.getThreadList();
                hasMore = frsGameStrategyHttpResponseMessage.hasMore();
            }
            int i3 = this.f27785a.f27779f;
            int i4 = this.f27785a.f27780g;
            if (this.f27785a.f27779f == 0 && this.f27785a.f27780g == 0 && !ListUtils.isEmpty(this.f27785a.f27777d) && (eVar = (e) this.f27785a.f27777d.get(0)) != null) {
                i3 = eVar.f27796a;
                Object obj = eVar.f27798c;
                if (obj instanceof LabelDataList) {
                    LabelDataList labelDataList = (LabelDataList) obj;
                    if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                        i4 = aVar.f27758a;
                    }
                }
            }
            String o = this.f27785a.o(i3, i4);
            c.a.r0.w0.s1.a.a.c cVar = (c.a.r0.w0.s1.a.a.c) this.f27785a.f27778e.get(o);
            if (cVar == null) {
                cVar = new c.a.r0.w0.s1.a.a.c();
                this.f27785a.f27778e.put(o, cVar);
                this.f27785a.f27778e.put(o, cVar);
            }
            cVar.f27767e = hasMore;
            cVar.f27768f = this.f27785a.f27781h;
            if (!ListUtils.isEmpty(threadList)) {
                if (this.f27785a.f27781h == 0) {
                    if (ListUtils.isEmpty(cVar.f27766d)) {
                        cVar.f27766d = threadList;
                    } else {
                        i2 = cVar.a(threadList);
                        if (this.f27785a.f27776c == null) {
                            this.f27785a.f27776c.refreshView(this.f27785a.f27779f, this.f27785a.f27780g, cVar.f27766d, this.f27785a.f27777d, cVar.f27767e, false, i2);
                            return;
                        }
                        return;
                    }
                } else {
                    cVar.f27766d.addAll(threadList);
                }
            }
            i2 = -1;
            if (this.f27785a.f27776c == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f27786e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27787f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f27788g;

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
            this.f27788g = bVar;
            this.f27786e = i2;
            this.f27787f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27788g.b(this.f27786e, this.f27787f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f27789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f27790f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f27791g;

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
            this.f27791g = bVar;
            this.f27789e = i2;
            this.f27790f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27791g.c(this.f27789e, this.f27790f);
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
        this.f27779f = 0;
        this.f27780g = 0;
        this.f27781h = 0;
        this.f27782i = false;
        this.f27783j = 0L;
        this.k = new Handler();
        this.m = new a(this);
        this.n = new C1309b(this, CmdConfigHttp.CMD_FRS_GAME_STRATEGY, 309478);
        this.f27774a = context;
        this.f27775b = bdUniqueId;
        this.f27783j = j2;
        this.f27778e = new HashMap<>();
        c.a.r0.w0.s1.a.c.a aVar = new c.a.r0.w0.s1.a.c.a();
        this.l = aVar;
        aVar.e(this.m);
        r();
        s();
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            c.a.r0.j3.d0.a.h(309478, FrsGameStrategySocketResponseMessage.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_GAME_STRATEGY, c.a.r0.j3.d0.a.a("c/f/game/gameForumGuideTab", 309478));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(FrsGameStrategyHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // c.a.r0.w0.s1.a.d.a
    public e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f27777d)) {
                return null;
            }
            for (e eVar : this.f27777d) {
                if (eVar != null && eVar.f27796a == i2) {
                    return eVar;
                }
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    @Override // c.a.r0.w0.s1.a.d.a
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f27782i) {
                this.k.postDelayed(new c(this, i2, i3), 1000L);
                return;
            }
            this.f27779f = i2;
            this.f27780g = i3;
            if (i2 == 0 && i3 == 0) {
                this.l.c(String.valueOf(this.f27783j));
            } else {
                String o = o(i2, i3);
                c.a.r0.w0.s1.a.a.c cVar = this.f27778e.get(o);
                if (cVar == null) {
                    cVar = new c.a.r0.w0.s1.a.a.c();
                    this.f27778e.put(o, cVar);
                }
                cVar.f27763a = o;
                cVar.f27764b = this.f27779f;
                cVar.f27765c = this.f27780g;
                cVar.f27768f = 0;
                cVar.f27767e = true;
            }
            this.f27781h = 0;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.f27783j, 0, this.f27779f, this.f27780g);
            frsGameStrategyRequestMessage.setTag(this.f27775b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f27782i = true;
        }
    }

    @Override // c.a.r0.w0.s1.a.d.a
    public void c(int i2, int i3) {
        c.a.r0.w0.s1.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (this.f27782i) {
                this.k.postDelayed(new d(this, i2, i3), 1000L);
                return;
            }
            this.f27779f = i2;
            if (i2 == 0 && i3 == 0) {
                e n = n(i2);
                if (n != null) {
                    Object obj = n.f27798c;
                    if (obj instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) obj;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            this.f27780g = aVar.f27758a;
                        }
                    }
                }
            } else {
                this.f27780g = i3;
            }
            String o = o(i2, i3);
            c.a.r0.w0.s1.a.a.c cVar = this.f27778e.get(o);
            if (cVar == null) {
                cVar = new c.a.r0.w0.s1.a.a.c();
                this.f27778e.put(o, cVar);
                cVar.f27767e = true;
                this.f27778e.put(o, cVar);
            }
            int i4 = cVar.f27768f + 1;
            this.f27781h = i4;
            FrsGameStrategyRequestMessage frsGameStrategyRequestMessage = new FrsGameStrategyRequestMessage(this.f27783j, i4, this.f27779f, this.f27780g);
            frsGameStrategyRequestMessage.setTag(this.f27775b);
            MessageManager.getInstance().sendMessage(frsGameStrategyRequestMessage);
            this.f27782i = true;
        }
    }

    @Override // c.a.r0.w0.s1.a.d.a
    public boolean d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            c.a.r0.w0.s1.a.a.c p = p(i2, i3);
            if (p == null || ListUtils.isEmpty(p.f27766d)) {
                return false;
            }
            c.a.r0.w0.s1.a.d.b bVar = this.f27776c;
            if (bVar != null) {
                bVar.refreshView(i2, i3, p.f27766d, this.f27777d, p.f27767e, false, -1);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    @Override // c.a.r0.w0.s1.a.d.a
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.valueOf(this.f27783j) : (String) invokeV.objValue;
    }

    public final e n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f27777d)) {
                return null;
            }
            for (e eVar : this.f27777d) {
                if (eVar != null && eVar.f27796a == i2) {
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

    public c.a.r0.w0.s1.a.a.c p(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) ? this.f27778e.get(o(i2, i3)) : (c.a.r0.w0.s1.a.a.c) invokeII.objValue;
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
            this.n.setTag(this.f27775b);
            MessageManager.getInstance().registerListener(this.n);
        }
    }

    public void t(c.a.r0.w0.s1.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f27776c = bVar;
        }
    }
}
