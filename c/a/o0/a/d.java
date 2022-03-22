package c.a.o0.a;

import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.d0.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<List<c.a.o0.a.c>> f9618b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<c.a.o0.a.c> f9619c;

    /* renamed from: d  reason: collision with root package name */
    public f f9620d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f9621e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9622f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9623g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f9624h;
    public c.a.o0.a.d0.d i;
    public c.a.o0.a.b0.c j;
    public c.a.o0.a.c0.b k;
    public int l;
    public long m;
    public int n;
    public long o;
    public boolean p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public c.a.o0.a.b0.a<c.a.o0.a.b0.b> t;
    public c.a.o0.m.b u;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.f9622f = true;
                if (this.a.f9619c.isEmpty()) {
                    return;
                }
                Iterator it = this.a.f9619c.iterator();
                while (it.hasNext()) {
                    this.a.m((c.a.o0.a.c) it.next());
                }
                this.a.f9619c.clear();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                this.a.q();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                this.a.f9623g = true;
                this.a.q();
            }
        }
    }

    /* renamed from: c.a.o0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0779d implements c.a.o0.a.b0.a<c.a.o0.a.b0.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public C0779d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.b0.a
        /* renamed from: b */
        public void a(c.a.o0.a.b0.b bVar) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null || (activeCenterData = bVar.f9606g) == null || activeCenterData.mission == null) {
                return;
            }
            c.a.o0.a.c cVar = new c.a.o0.a.c();
            cVar.O(bVar.f9606g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            this.a.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.m.a
        /* renamed from: c */
        public void onSuccess(c.a.o0.a.b0.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
                return;
            }
            this.a.n(bVar.b());
        }

        @Override // c.a.o0.m.a
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.a.o0.m.b<c.a.o0.a.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.m.b
        /* renamed from: b */
        public void a(c.a.o0.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
                return;
            }
            c.a.o0.a.c w = this.a.w(cVar);
            if (w != null && w.z) {
                w.R();
                this.a.U(w);
                return;
            }
            o.b().h(w);
            if (w != null && w.x() == 7) {
                w.H();
                int F = w.F();
                int w2 = w.w();
                if (F <= 1 || F <= w2) {
                    this.a.I(w);
                } else {
                    this.a.U(w);
                }
            } else if (w == null || w.x() != 8) {
                this.a.I(cVar);
            } else {
                this.a.I(w);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends BdAsyncTask<c.a.o0.a.c, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(c.a.o0.a.c... cVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
                if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
                    return null;
                }
                c.a.o0.a.a.g().a(cVarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes2.dex */
    public class h extends BdAsyncTask<List<c.a.o0.a.c>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<c.a.o0.a.c>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                    return null;
                }
                c.a.o0.a.a.g().b(listArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes2.dex */
    public class i extends BdAsyncTask<c.a.o0.a.c, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(c.a.o0.a.c... cVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
                if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
                    return null;
                }
                c.a.o0.a.a.g().e(cVarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes2.dex */
    public class j extends BdAsyncTask<Pair<c.a.o0.a.c, c.a.o0.a.c>, Integer, Pair<c.a.o0.a.c, c.a.o0.a.c>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<c.a.o0.a.c, c.a.o0.a.c> doInBackground(Pair<c.a.o0.a.c, c.a.o0.a.c>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                    return null;
                }
                Pair<c.a.o0.a.c, c.a.o0.a.c> pair = pairArr[0];
                c.a.o0.a.c cVar = (c.a.o0.a.c) pair.first;
                c.a.o0.a.c cVar2 = (c.a.o0.a.c) pair.second;
                if (cVar2 != null) {
                    c.a.o0.a.a.g().e(cVar2);
                }
                if (cVar != null) {
                    c.a.o0.a.a.g().a(cVar);
                    return pair;
                }
                return pair;
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<c.a.o0.a.c, c.a.o0.a.c> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) || pair == null) {
                return;
            }
            c.a.o0.a.c cVar = (c.a.o0.a.c) pair.first;
            c.a.o0.a.c cVar2 = (c.a.o0.a.c) pair.second;
            if (cVar2 != null) {
                this.a.v(cVar2);
            }
            if (cVar != null) {
                this.a.L(cVar);
            }
        }

        public /* synthetic */ j(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes2.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<c.a.o0.a.c>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public k(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<c.a.o0.a.c> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<c.a.o0.a.c> linkedList = new LinkedList<>();
                linkedList.addAll(c.a.o0.a.a.g().f());
                Iterator<c.a.o0.a.c> it = linkedList.iterator();
                while (it.hasNext()) {
                    c.a.o0.a.c next = it.next();
                    if (next != null && next.M()) {
                        c.a.o0.a.a.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.n0();
                        c.a.o0.a.a.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<c.a.o0.a.c> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<c.a.o0.a.c> it = linkedList.iterator();
                    while (it.hasNext()) {
                        c.a.o0.a.c next = it.next();
                        if (next.h() != null) {
                            this.a.L(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }

        public /* synthetic */ k(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes2.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(448271877, "Lc/a/o0/a/d$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(448271877, "Lc/a/o0/a/d$l;");
                    return;
                }
            }
            a = new d(null);
        }
    }

    /* loaded from: classes2.dex */
    public class m extends BdAsyncTask<c.a.o0.a.c, Integer, c.a.o0.a.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public m(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public c.a.o0.a.c doInBackground(c.a.o0.a.c... cVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
                if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
                    return null;
                }
                c.a.o0.a.c cVar = cVarArr[0];
                c.a.o0.a.a.g().i(cVar);
                return cVar;
            }
            return (c.a.o0.a.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(c.a.o0.a.c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) && cVar != null && cVar.z) {
                cVar.z = false;
                d dVar = this.a;
                dVar.R(dVar.l, this.a.m);
            }
        }

        public /* synthetic */ m(d dVar, a aVar) {
            this(dVar);
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static final d y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? l.a : (d) invokeV.objValue;
    }

    public boolean A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<c.a.o0.a.c> list = this.f9618b.get(i2);
            return (list == null || list.isEmpty()) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !s() : invokeV.booleanValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbadkCoreApplication.getInst().isMainProcess(true) : invokeV.booleanValue;
    }

    public final boolean D(c.a.o0.a.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            int[] h2 = cVar.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<c.a.o0.a.c> list = this.f9618b.get(i2);
                if (list == null) {
                    return false;
                }
                for (c.a.o0.a.c cVar2 : list) {
                    if (cVar2 != null && cVar2.d() == cVar.d() && cVar2.q() == cVar.q()) {
                        if (cVar2.M()) {
                            J(cVar, cVar2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return !TbSingleton.getInstance().isNewUserRedPackageShowed() && UbsABTestHelper.isRedPackageShowSecondTime() && c.a.o0.r.j0.b.k().l("app_restart_times", 0) > 1;
        }
        return invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f9621e.compareAndSet(true, false);
            this.f9620d.f(0);
            this.f9620d.h(0L);
            this.f9620d.g(0L);
            c.a.o0.a.d0.d dVar = this.i;
            if (dVar != null) {
                dVar.m();
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            List<c.a.o0.a.c> list = this.f9618b.get(c.a.o0.a.c.W);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (c.a.o0.a.c cVar : list) {
                Iterator<c.a.o0.a.i> it = cVar.n().iterator();
                while (it.hasNext()) {
                    c.a.o0.a.i next = it.next();
                    if (next instanceof c.a.o0.a.m) {
                        c.a.o0.a.m mVar = (c.a.o0.a.m) next;
                        if (!next.e()) {
                            mVar.i();
                            z = true;
                        }
                    }
                }
            }
            if (!z || this.f9621e.get()) {
                return;
            }
            this.f9620d.f(c.a.o0.a.c.W);
            this.f9621e.compareAndSet(false, true);
            synchronized (this.f9621e) {
                this.f9621e.notify();
            }
        }
    }

    public final void I(c.a.o0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            v(cVar);
            new i(this, null).execute(cVar);
        }
    }

    public final void J(c.a.o0.a.c cVar, c.a.o0.a.c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, cVar, cVar2) == null) {
            v(cVar2);
            new j(this, null).execute(new Pair(cVar, cVar2));
        }
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.j != null && C() && this.f9623g) {
                this.j.f(B(), E(), 1);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void L(c.a.o0.a.c cVar) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            for (int i2 : cVar.h()) {
                List<c.a.o0.a.c> list = this.f9618b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(cVar);
                    this.f9618b.put(i2, linkedList);
                } else {
                    list.add(cVar);
                }
            }
        }
    }

    public void M(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && C()) {
            this.n = i2;
            long j3 = this.m;
            if (j3 > 0 && this.l > 0 && (j2 == 0 || j2 != j3)) {
                T(this.l, this.m);
                this.m = 0L;
                this.l = 0;
            }
            O();
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.p = z;
        }
    }

    public void O() {
        int i2;
        List<c.a.o0.a.c> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && C() && this.f9622f && (list = this.f9618b.get((i2 = c.a.o0.a.c.W))) != null && !list.isEmpty()) {
            boolean z = false;
            for (c.a.o0.a.c cVar : list) {
                if (cVar.x() == 8) {
                    Iterator<c.a.o0.a.i> it = cVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        c.a.o0.a.i next = it.next();
                        c.a.o0.a.c c2 = next.c();
                        if (c2 != null && (next instanceof c.a.o0.a.m) && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                            ((c.a.o0.a.m) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        c.a.o0.a.m mVar = new c.a.o0.a.m(cVar);
                        mVar.g(0L);
                        mVar.f(false);
                        cVar.a(mVar);
                    }
                }
            }
            this.f9620d.f(i2);
            this.f9621e.compareAndSet(false, true);
            synchronized (this.f9621e) {
                this.f9621e.notify();
            }
        }
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && C() && i2 != 0 && this.f9622f) {
            this.l = i2;
            List<c.a.o0.a.c> list = this.f9618b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (c.a.o0.a.c cVar : list) {
                if (cVar.x() == 4) {
                    Iterator<c.a.o0.a.i> it = cVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        c.a.o0.a.i next = it.next();
                        if ((next instanceof c.a.o0.a.j) && next.c().d() == cVar.d() && next.c().q() == cVar.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        c.a.o0.a.j jVar = new c.a.o0.a.j(cVar);
                        jVar.g(0L);
                        jVar.f(false);
                        cVar.a(jVar);
                    }
                }
            }
            this.f9620d.f(i2);
            this.f9621e.compareAndSet(false, true);
            synchronized (this.f9621e) {
                this.f9621e.notify();
            }
        }
    }

    public void Q(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && C() && i2 != 0 && j2 != 0 && this.f9622f) {
            this.l = i2;
            List<c.a.o0.a.c> list = this.f9618b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (c.a.o0.a.c cVar : list) {
                if (cVar.x() == 2) {
                    Iterator<c.a.o0.a.i> it = cVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        c.a.o0.a.i next = it.next();
                        if ((next instanceof c.a.o0.a.k) && next.c().d() == cVar.d() && next.c().q() == cVar.q() && ((c.a.o0.a.k) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        c.a.o0.a.k kVar = new c.a.o0.a.k(cVar, j2);
                        kVar.g(0L);
                        kVar.f(false);
                        kVar.h(cVar.w());
                        cVar.a(kVar);
                    }
                }
            }
            this.f9620d.f(i2);
            this.f9620d.g(j2);
            this.f9621e.compareAndSet(false, true);
            synchronized (this.f9621e) {
                this.f9621e.notify();
            }
        }
    }

    public void R(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && C() && i2 != 0 && j2 != 0 && this.f9622f) {
            this.l = i2;
            List<c.a.o0.a.c> list = this.f9618b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (c.a.o0.a.c cVar : list) {
                if (cVar.x() == 1) {
                    p(cVar, j2);
                } else if (cVar.x() == 7 && !cVar.J(j2)) {
                    o(cVar, j2);
                }
            }
            this.f9620d.f(i2);
            this.f9620d.h(j2);
            this.m = j2;
            this.f9621e.compareAndSet(false, true);
            synchronized (this.f9621e) {
                this.f9621e.notify();
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a.scheduleWithFixedDelay(this.f9620d, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    public void T(int i2, long j2) {
        List<c.a.o0.a.c> list;
        c.a.o0.a.l lVar;
        c.a.o0.a.c c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (list = this.f9618b.get(i2)) == null || list.isEmpty()) {
            return;
        }
        for (c.a.o0.a.c cVar : list) {
            if (cVar.x() == 7) {
                Iterator<c.a.o0.a.i> it = cVar.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        c.a.o0.a.i next = it.next();
                        if ((next instanceof c.a.o0.a.l) && (c2 = (lVar = (c.a.o0.a.l) next).c()) != null && lVar.i() == j2 && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void U(c.a.o0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) {
            V(cVar);
            new m(this, null).execute(cVar);
        }
    }

    public final void V(c.a.o0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) || cVar == null) {
            return;
        }
        int x = cVar.x();
        Iterator<c.a.o0.a.i> it = cVar.n().iterator();
        while (it.hasNext()) {
            c.a.o0.a.i next = it.next();
            if (next != null && next.c() != null) {
                c.a.o0.a.c c2 = next.c();
                if (c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    if (x == 7 && (next instanceof c.a.o0.a.l)) {
                        ((c.a.o0.a.l) next).f(true);
                    } else if (x == 1 && (next instanceof n)) {
                        ((n) next).f(true);
                    }
                }
            }
        }
        cVar.c0(false);
    }

    public void m(c.a.o0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) || cVar == null) {
            return;
        }
        if (cVar.x() == 9) {
            q.c().f(cVar);
        } else if (!this.f9622f) {
            this.f9619c.add(cVar);
        } else if (D(cVar)) {
        } else {
            L(cVar);
            new g(this, null).execute(cVar);
        }
    }

    public void n(List<c.a.o0.a.c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f9622f) {
            this.f9619c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (c.a.o0.a.c cVar : list) {
            if (cVar != null) {
                if (cVar.x() == 9) {
                    q.c().f(cVar);
                } else if (!D(cVar)) {
                    L(cVar);
                    arrayList.add(cVar);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(c.a.o0.a.c cVar, long j2) {
        boolean z;
        c.a.o0.a.l lVar;
        c.a.o0.a.c c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, cVar, j2) == null) {
            Iterator<c.a.o0.a.i> it = cVar.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                c.a.o0.a.i next = it.next();
                if ((next instanceof c.a.o0.a.l) && (c2 = (lVar = (c.a.o0.a.l) next).c()) != null && lVar.i() == j2 && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            c.a.o0.a.l lVar2 = new c.a.o0.a.l(cVar, j2);
            lVar2.g(0L);
            lVar2.f(false);
            lVar2.h(cVar.w());
            cVar.a(lVar2);
        }
    }

    public final void p(c.a.o0.a.c cVar, long j2) {
        boolean z;
        n nVar;
        c.a.o0.a.c c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048601, this, cVar, j2) == null) {
            Iterator<c.a.o0.a.i> it = cVar.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                c.a.o0.a.i next = it.next();
                if ((next instanceof n) && (c2 = (nVar = (n) next).c()) != null && nVar.i() == j2 && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            n nVar2 = new n(cVar, j2);
            nVar2.g(0L);
            nVar2.f(false);
            nVar2.h(cVar.w());
            cVar.a(nVar2);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.j != null && C() && this.f9623g) {
            if (!t() || F()) {
                this.j.f(B(), E(), 0);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.k != null && C()) {
            this.k.d();
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? UtilHelper.isSameDay(c.a.o0.r.j0.b.k().m("pref_key_last_active_config", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? UtilHelper.isSameDay(z(), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? UtilHelper.isSameDay(c.a.o0.r.j0.b.k().m("pref_key_last_popup_time", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void v(c.a.o0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, cVar) == null) || cVar == null) {
            return;
        }
        Iterator<c.a.o0.a.i> it = cVar.n().iterator();
        while (it.hasNext()) {
            c.a.o0.a.i next = it.next();
            if (next != null && next.c() != null) {
                c.a.o0.a.c c2 = next.c();
                if (c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.f9618b.size(); i2++) {
            List<c.a.o0.a.c> valueAt = this.f9618b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<c.a.o0.a.c> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    c.a.o0.a.c next2 = it2.next();
                    if (next2 != null && next2.d() == cVar.d() && next2.q() == cVar.q()) {
                        it2.remove();
                    }
                }
            }
        }
        c.a.o0.a.b.a("deleteActivityMissionInfoDataInMemory-->activityId=" + cVar.d() + ",missionId=" + cVar.q());
    }

    public final c.a.o0.a.c w(c.a.o0.a.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, cVar)) == null) {
            if (cVar == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.f9618b.size(); i2++) {
                List<c.a.o0.a.c> valueAt = this.f9618b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (c.a.o0.a.c cVar2 : valueAt) {
                        if (cVar2 != null && cVar2.d() == cVar.d() && cVar2.q() == cVar.q()) {
                            return cVar2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (c.a.o0.a.c) invokeL.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.n : invokeV.intValue;
    }

    public final long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            long m2 = c.a.o0.r.j0.b.k().m("pref_key_active_config_info", 0L);
            this.o = m2;
            return m2;
        }
        return invokeV.longValue;
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int a;

        /* renamed from: b  reason: collision with root package name */
        public volatile long f9625b;

        /* renamed from: c  reason: collision with root package name */
        public volatile long f9626c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f9627d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9628e;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9628e = dVar;
            this.f9627d = false;
        }

        public final void a(c.a.o0.a.c cVar, d.C0780d c0780d) {
            ArrayList<c.a.o0.a.i> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, c0780d) == null) || cVar == null || c0780d == null || (n = cVar.n()) == null) {
                return;
            }
            Iterator<c.a.o0.a.i> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                c.a.o0.a.i next = it.next();
                if (next instanceof n) {
                    n nVar = (n) next;
                    if (this.f9625b != 0 && nVar.i() == this.f9625b && !next.e()) {
                        this.f9627d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().I() >= next.c().A()) {
                                c0780d.b(next);
                            }
                        }
                        c0780d.c(cVar);
                    }
                } else if (next instanceof c.a.o0.a.l) {
                    c.a.o0.a.l lVar = (c.a.o0.a.l) next;
                    if (!cVar.L() && lVar.d() == cVar.w()) {
                        if (this.f9625b != 0 && lVar.i() == this.f9625b && !next.e()) {
                            this.f9627d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.f9625b != 0 && lVar.i() == this.f9625b && !next.e()) {
                            if (next.b() >= cVar.f()) {
                                next.f(true);
                                cVar.I();
                            }
                            c0780d.c(cVar);
                        }
                        int l = cVar.l();
                        int A = cVar.A();
                        long f2 = cVar.f() * cVar.A();
                        if (this.f9625b != 0 && lVar.i() == this.f9625b) {
                            next.e();
                        }
                        if (i >= f2 && l >= A) {
                            c0780d.a(cVar);
                            cVar.c0(true);
                        }
                    }
                } else if (next instanceof c.a.o0.a.k) {
                    if (this.f9626c != 0 && ((c.a.o0.a.k) next).i() == this.f9626c && !next.e()) {
                        this.f9627d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().G() >= next.c().p()) {
                                c0780d.b(next);
                            }
                        }
                    }
                } else if ((next instanceof c.a.o0.a.j) && !next.e()) {
                    this.f9627d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        c0780d.b(next);
                    }
                }
            }
        }

        public final void b(c.a.o0.a.c cVar, d.C0780d c0780d) {
            ArrayList<c.a.o0.a.i> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, c0780d) == null) || cVar == null || c0780d == null || (n = cVar.n()) == null) {
                return;
            }
            Iterator<c.a.o0.a.i> it = n.iterator();
            while (it.hasNext()) {
                c.a.o0.a.i next = it.next();
                if ((next instanceof c.a.o0.a.m) && !((c.a.o0.a.m) next).j() && !next.e()) {
                    this.f9627d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        c0780d.a(cVar);
                    }
                    c0780d.c(cVar);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f9627d = true;
                List<c.a.o0.a.c> list = (List) this.f9628e.f9618b.get(c.a.o0.a.c.W);
                List<c.a.o0.a.c> list2 = (List) this.f9628e.f9618b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.f9628e.f9621e.compareAndSet(true, false);
                    return;
                }
                d.C0780d c0780d = new d.C0780d();
                c0780d.a = new LinkedList();
                c0780d.f9644b = new LinkedList();
                c0780d.f9645c = new LinkedList();
                d(list, c0780d);
                e(list2, c0780d);
                if (this.f9627d) {
                    this.f9628e.f9621e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(c0780d.f9645c)) {
                    c.a.o0.a.a.g().k(c0780d.f9645c);
                }
                if (ListUtils.isEmpty(c0780d.a) && ListUtils.isEmpty(c0780d.f9644b)) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, c0780d));
            }
        }

        public final void d(List<c.a.o0.a.c> list, d.C0780d c0780d) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, c0780d) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (c.a.o0.a.c cVar : list) {
                b(cVar, c0780d);
            }
        }

        public final void e(List<c.a.o0.a.c> list, d.C0780d c0780d) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, c0780d) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (c.a.o0.a.c cVar : list) {
                a(cVar, c0780d);
            }
        }

        public synchronized void f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                synchronized (this) {
                    this.a = i;
                }
            }
        }

        public synchronized void g(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
                synchronized (this) {
                    this.f9626c = j;
                }
            }
        }

        public synchronized void h(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                synchronized (this) {
                    this.f9625b = j;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (this.a == 0 || !this.f9628e.f9621e.get()) {
                    synchronized (this.f9628e.f9621e) {
                        try {
                            this.f9628e.f9621e.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                c();
            }
        }

        public /* synthetic */ f(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d() {
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
        this.a = Executors.newSingleThreadScheduledExecutor();
        this.f9618b = new SparseArray<>();
        this.f9619c = new LinkedList<>();
        this.f9620d = new f(this, null);
        this.f9621e = new AtomicBoolean(false);
        this.f9622f = false;
        this.f9623g = false;
        this.p = false;
        this.q = new a(this, 2921391);
        this.r = new b(this, 2001011);
        this.s = new c(this, 2001371);
        this.t = new C0779d(this);
        this.u = new e(this);
        BdUniqueId gen = BdUniqueId.gen();
        this.f9624h = gen;
        c.a.o0.a.d0.d dVar = new c.a.o0.a.d0.d(gen);
        this.i = dVar;
        dVar.w(this.u);
        c.a.o0.a.b0.c cVar = new c.a.o0.a.b0.c(this.f9624h);
        this.j = cVar;
        cVar.g(this.t);
        this.k = new c.a.o0.a.c0.b(this.f9624h);
        this.s.setTag(this.f9624h);
        MessageManager.getInstance().registerListener(this.s);
        this.r.setTag(this.f9624h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setPriority(Integer.MIN_VALUE);
        this.q.setTag(this.f9624h);
        MessageManager.getInstance().registerListener(this.q);
        c.a.o0.r.i0.a.e().f();
        q.c().d(this.f9624h);
        S();
        if (C()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
