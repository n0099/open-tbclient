package b.a.q0.a;

import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.a.d0.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f12455a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<List<b.a.q0.a.c>> f12456b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<b.a.q0.a.c> f12457c;

    /* renamed from: d  reason: collision with root package name */
    public f f12458d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f12459e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12460f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12461g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f12462h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.a.d0.d f12463i;
    public b.a.q0.a.b0.c j;
    public b.a.q0.a.c0.b k;
    public int l;
    public long m;
    public int n;
    public long o;
    public boolean p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public b.a.q0.a.b0.a<b.a.q0.a.b0.b> t;
    public b.a.q0.n.b u;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f12464a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f12464a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f12464a.f12460f = true;
                if (this.f12464a.f12457c.isEmpty()) {
                    return;
                }
                Iterator it = this.f12464a.f12457c.iterator();
                while (it.hasNext()) {
                    this.f12464a.m((b.a.q0.a.c) it.next());
                }
                this.f12464a.f12457c.clear();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f12465a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f12465a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                this.f12465a.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f12466a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f12466a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                this.f12466a.f12461g = true;
                this.f12466a.q();
            }
        }
    }

    /* renamed from: b.a.q0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0669d implements b.a.q0.a.b0.a<b.a.q0.a.b0.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f12467a;

        public C0669d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12467a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.a.b0.a
        /* renamed from: b */
        public void a(b.a.q0.a.b0.b bVar) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null || (activeCenterData = bVar.f12436g) == null || activeCenterData.mission == null) {
                return;
            }
            b.a.q0.a.c cVar = new b.a.q0.a.c();
            cVar.O(bVar.f12436g.mission);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            this.f12467a.n(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.n.a
        /* renamed from: c */
        public void onSuccess(b.a.q0.a.b0.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
                return;
            }
            this.f12467a.n(bVar.b());
        }

        @Override // b.a.q0.n.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.a.q0.n.b<b.a.q0.a.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f12468a;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12468a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.n.b
        /* renamed from: b */
        public void a(b.a.q0.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
                return;
            }
            b.a.q0.a.c w = this.f12468a.w(cVar);
            if (w != null && w.z) {
                w.R();
                this.f12468a.T(w);
                return;
            }
            o.b().h(w);
            if (w != null && w.x() == 7) {
                w.H();
                int F = w.F();
                int w2 = w.w();
                if (F <= 1 || F <= w2) {
                    this.f12468a.H(w);
                } else {
                    this.f12468a.T(w);
                }
            } else if (w == null || w.x() != 8) {
                this.f12468a.H(cVar);
            } else {
                this.f12468a.H(w);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends BdAsyncTask<b.a.q0.a.c, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(b.a.q0.a.c... cVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
                if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
                    return null;
                }
                b.a.q0.a.a.g().a(cVarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public class h extends BdAsyncTask<List<b.a.q0.a.c>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<b.a.q0.a.c>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr == null || listArr.length <= 0 || listArr[0] == null) {
                    return null;
                }
                b.a.q0.a.a.g().b(listArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends BdAsyncTask<b.a.q0.a.c, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(b.a.q0.a.c... cVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
                if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
                    return null;
                }
                b.a.q0.a.a.g().e(cVarArr[0]);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public class j extends BdAsyncTask<Pair<b.a.q0.a.c, b.a.q0.a.c>, Integer, Pair<b.a.q0.a.c, b.a.q0.a.c>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f12474a;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12474a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<b.a.q0.a.c, b.a.q0.a.c> doInBackground(Pair<b.a.q0.a.c, b.a.q0.a.c>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                    return null;
                }
                Pair<b.a.q0.a.c, b.a.q0.a.c> pair = pairArr[0];
                b.a.q0.a.c cVar = (b.a.q0.a.c) pair.first;
                b.a.q0.a.c cVar2 = (b.a.q0.a.c) pair.second;
                if (cVar2 != null) {
                    b.a.q0.a.a.g().e(cVar2);
                }
                if (cVar != null) {
                    b.a.q0.a.a.g().a(cVar);
                    return pair;
                }
                return pair;
            }
            return (Pair) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<b.a.q0.a.c, b.a.q0.a.c> pair) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) || pair == null) {
                return;
            }
            b.a.q0.a.c cVar = (b.a.q0.a.c) pair.first;
            b.a.q0.a.c cVar2 = (b.a.q0.a.c) pair.second;
            if (cVar2 != null) {
                this.f12474a.v(cVar2);
            }
            if (cVar != null) {
                this.f12474a.K(cVar);
            }
        }

        public /* synthetic */ j(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<b.a.q0.a.c>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f12475a;

        public k(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12475a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<b.a.q0.a.c> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<b.a.q0.a.c> linkedList = new LinkedList<>();
                linkedList.addAll(b.a.q0.a.a.g().f());
                Iterator<b.a.q0.a.c> it = linkedList.iterator();
                while (it.hasNext()) {
                    b.a.q0.a.c next = it.next();
                    if (next != null && next.M()) {
                        b.a.q0.a.a.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.n0();
                        b.a.q0.a.a.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<b.a.q0.a.c> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<b.a.q0.a.c> it = linkedList.iterator();
                    while (it.hasNext()) {
                        b.a.q0.a.c next = it.next();
                        if (next.h() != null) {
                            this.f12475a.K(next);
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

    /* loaded from: classes4.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f12476a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1421733254, "Lb/a/q0/a/d$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1421733254, "Lb/a/q0/a/d$l;");
                    return;
                }
            }
            f12476a = new d(null);
        }
    }

    /* loaded from: classes4.dex */
    public class m extends BdAsyncTask<b.a.q0.a.c, Integer, b.a.q0.a.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f12477a;

        public m(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12477a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public b.a.q0.a.c doInBackground(b.a.q0.a.c... cVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
                if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
                    return null;
                }
                b.a.q0.a.c cVar = cVarArr[0];
                b.a.q0.a.a.g().i(cVar);
                return cVar;
            }
            return (b.a.q0.a.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(b.a.q0.a.c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) && cVar != null && cVar.z) {
                cVar.z = false;
                d dVar = this.f12477a;
                dVar.Q(dVar.l, this.f12477a.m);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? l.f12476a : (d) invokeV.objValue;
    }

    public boolean A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<b.a.q0.a.c> list = this.f12456b.get(i2);
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

    public final boolean D(b.a.q0.a.c cVar) {
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
                List<b.a.q0.a.c> list = this.f12456b.get(i2);
                if (list == null) {
                    return false;
                }
                for (b.a.q0.a.c cVar2 : list) {
                    if (cVar2 != null && cVar2.d() == cVar.d() && cVar2.q() == cVar.q()) {
                        if (cVar2.M()) {
                            I(cVar, cVar2);
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

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f12459e.compareAndSet(true, false);
            this.f12458d.f(0);
            this.f12458d.h(0L);
            this.f12458d.g(0L);
            b.a.q0.a.d0.d dVar = this.f12463i;
            if (dVar != null) {
                dVar.m();
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            List<b.a.q0.a.c> list = this.f12456b.get(b.a.q0.a.c.W);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (b.a.q0.a.c cVar : list) {
                Iterator<b.a.q0.a.i> it = cVar.n().iterator();
                while (it.hasNext()) {
                    b.a.q0.a.i next = it.next();
                    if (next instanceof b.a.q0.a.m) {
                        b.a.q0.a.m mVar = (b.a.q0.a.m) next;
                        if (!next.e()) {
                            mVar.i();
                            z = true;
                        }
                    }
                }
            }
            if (!z || this.f12459e.get()) {
                return;
            }
            this.f12458d.f(b.a.q0.a.c.W);
            this.f12459e.compareAndSet(false, true);
            synchronized (this.f12459e) {
                this.f12459e.notify();
            }
        }
    }

    public final void H(b.a.q0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            v(cVar);
            new i(this, null).execute(cVar);
        }
    }

    public final void I(b.a.q0.a.c cVar, b.a.q0.a.c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, cVar2) == null) {
            v(cVar2);
            new j(this, null).execute(new Pair(cVar, cVar2));
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null && C()) {
                this.j.f(B(), E(), 1);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void K(b.a.q0.a.c cVar) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            for (int i2 : cVar.h()) {
                List<b.a.q0.a.c> list = this.f12456b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(cVar);
                    this.f12456b.put(i2, linkedList);
                } else {
                    list.add(cVar);
                }
            }
        }
    }

    public void L(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && C()) {
            this.n = i2;
            long j3 = this.m;
            if (j3 > 0 && this.l > 0 && (j2 == 0 || j2 != j3)) {
                S(this.l, this.m);
                this.m = 0L;
                this.l = 0;
            }
            N();
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.p = z;
        }
    }

    public void N() {
        int i2;
        List<b.a.q0.a.c> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && C() && this.f12460f && (list = this.f12456b.get((i2 = b.a.q0.a.c.W))) != null && !list.isEmpty()) {
            boolean z = false;
            for (b.a.q0.a.c cVar : list) {
                if (cVar.x() == 8) {
                    Iterator<b.a.q0.a.i> it = cVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b.a.q0.a.i next = it.next();
                        b.a.q0.a.c c2 = next.c();
                        if (c2 != null && (next instanceof b.a.q0.a.m) && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                            ((b.a.q0.a.m) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        b.a.q0.a.m mVar = new b.a.q0.a.m(cVar);
                        mVar.g(0L);
                        mVar.f(false);
                        cVar.a(mVar);
                    }
                }
            }
            this.f12458d.f(i2);
            this.f12459e.compareAndSet(false, true);
            synchronized (this.f12459e) {
                this.f12459e.notify();
            }
        }
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i2) == null) && C() && i2 != 0 && this.f12460f) {
            this.l = i2;
            List<b.a.q0.a.c> list = this.f12456b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (b.a.q0.a.c cVar : list) {
                if (cVar.x() == 4) {
                    Iterator<b.a.q0.a.i> it = cVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b.a.q0.a.i next = it.next();
                        if ((next instanceof b.a.q0.a.j) && next.c().d() == cVar.d() && next.c().q() == cVar.q()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        b.a.q0.a.j jVar = new b.a.q0.a.j(cVar);
                        jVar.g(0L);
                        jVar.f(false);
                        cVar.a(jVar);
                    }
                }
            }
            this.f12458d.f(i2);
            this.f12459e.compareAndSet(false, true);
            synchronized (this.f12459e) {
                this.f12459e.notify();
            }
        }
    }

    public void P(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && C() && i2 != 0 && j2 != 0 && this.f12460f) {
            this.l = i2;
            List<b.a.q0.a.c> list = this.f12456b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            boolean z = false;
            for (b.a.q0.a.c cVar : list) {
                if (cVar.x() == 2) {
                    Iterator<b.a.q0.a.i> it = cVar.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b.a.q0.a.i next = it.next();
                        if ((next instanceof b.a.q0.a.k) && next.c().d() == cVar.d() && next.c().q() == cVar.q() && ((b.a.q0.a.k) next).i() == j2) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        b.a.q0.a.k kVar = new b.a.q0.a.k(cVar, j2);
                        kVar.g(0L);
                        kVar.f(false);
                        kVar.h(cVar.w());
                        cVar.a(kVar);
                    }
                }
            }
            this.f12458d.f(i2);
            this.f12458d.g(j2);
            this.f12459e.compareAndSet(false, true);
            synchronized (this.f12459e) {
                this.f12459e.notify();
            }
        }
    }

    public void Q(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && C() && i2 != 0 && j2 != 0 && this.f12460f) {
            this.l = i2;
            List<b.a.q0.a.c> list = this.f12456b.get(i2);
            if (list == null || list.isEmpty()) {
                return;
            }
            for (b.a.q0.a.c cVar : list) {
                if (cVar.x() == 1) {
                    p(cVar, j2);
                } else if (cVar.x() == 7 && !cVar.J(j2)) {
                    o(cVar, j2);
                }
            }
            this.f12458d.f(i2);
            this.f12458d.h(j2);
            this.m = j2;
            this.f12459e.compareAndSet(false, true);
            synchronized (this.f12459e) {
                this.f12459e.notify();
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f12455a.scheduleWithFixedDelay(this.f12458d, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    public void S(int i2, long j2) {
        List<b.a.q0.a.c> list;
        b.a.q0.a.l lVar;
        b.a.q0.a.c c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (list = this.f12456b.get(i2)) == null || list.isEmpty()) {
            return;
        }
        for (b.a.q0.a.c cVar : list) {
            if (cVar.x() == 7) {
                Iterator<b.a.q0.a.i> it = cVar.n().iterator();
                while (true) {
                    if (it.hasNext()) {
                        b.a.q0.a.i next = it.next();
                        if ((next instanceof b.a.q0.a.l) && (c2 = (lVar = (b.a.q0.a.l) next).c()) != null && lVar.i() == j2 && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                            next.f(true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void T(b.a.q0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            U(cVar);
            new m(this, null).execute(cVar);
        }
    }

    public final void U(b.a.q0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) || cVar == null) {
            return;
        }
        int x = cVar.x();
        Iterator<b.a.q0.a.i> it = cVar.n().iterator();
        while (it.hasNext()) {
            b.a.q0.a.i next = it.next();
            if (next != null && next.c() != null) {
                b.a.q0.a.c c2 = next.c();
                if (c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    if (x == 7 && (next instanceof b.a.q0.a.l)) {
                        ((b.a.q0.a.l) next).f(true);
                    } else if (x == 1 && (next instanceof n)) {
                        ((n) next).f(true);
                    }
                }
            }
        }
        cVar.c0(false);
    }

    public void m(b.a.q0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) || cVar == null) {
            return;
        }
        if (cVar.x() == 9) {
            q.c().f(cVar);
        } else if (!this.f12460f) {
            this.f12457c.add(cVar);
        } else if (D(cVar)) {
        } else {
            K(cVar);
            new g(this, null).execute(cVar);
        }
    }

    public void n(List<b.a.q0.a.c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f12460f) {
            this.f12457c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b.a.q0.a.c cVar : list) {
            if (cVar != null) {
                if (cVar.x() == 9) {
                    q.c().f(cVar);
                } else if (!D(cVar)) {
                    K(cVar);
                    arrayList.add(cVar);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public final void o(b.a.q0.a.c cVar, long j2) {
        boolean z;
        b.a.q0.a.l lVar;
        b.a.q0.a.c c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, cVar, j2) == null) {
            Iterator<b.a.q0.a.i> it = cVar.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                b.a.q0.a.i next = it.next();
                if ((next instanceof b.a.q0.a.l) && (c2 = (lVar = (b.a.q0.a.l) next).c()) != null && lVar.i() == j2 && c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            b.a.q0.a.l lVar2 = new b.a.q0.a.l(cVar, j2);
            lVar2.g(0L);
            lVar2.f(false);
            lVar2.h(cVar.w());
            cVar.a(lVar2);
        }
    }

    public final void p(b.a.q0.a.c cVar, long j2) {
        boolean z;
        n nVar;
        b.a.q0.a.c c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, cVar, j2) == null) {
            Iterator<b.a.q0.a.i> it = cVar.n().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                b.a.q0.a.i next = it.next();
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
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.j != null && C() && this.f12461g && !t()) {
            this.j.f(B(), E(), 0);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.k != null && C()) {
            this.k.d();
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? UtilHelper.isSameDay(b.a.q0.s.e0.b.j().l("pref_key_last_active_config", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? UtilHelper.isSameDay(z(), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? UtilHelper.isSameDay(b.a.q0.s.e0.b.j().l("pref_key_last_popup_time", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void v(b.a.q0.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, cVar) == null) || cVar == null) {
            return;
        }
        Iterator<b.a.q0.a.i> it = cVar.n().iterator();
        while (it.hasNext()) {
            b.a.q0.a.i next = it.next();
            if (next != null && next.c() != null) {
                b.a.q0.a.c c2 = next.c();
                if (c2.d() == cVar.d() && c2.q() == cVar.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.f12456b.size(); i2++) {
            List<b.a.q0.a.c> valueAt = this.f12456b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<b.a.q0.a.c> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    b.a.q0.a.c next2 = it2.next();
                    if (next2 != null && next2.d() == cVar.d() && next2.q() == cVar.q()) {
                        it2.remove();
                    }
                }
            }
        }
        b.a.q0.a.b.a("deleteActivityMissionInfoDataInMemory-->activityId=" + cVar.d() + ",missionId=" + cVar.q());
    }

    public final b.a.q0.a.c w(b.a.q0.a.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, cVar)) == null) {
            if (cVar == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.f12456b.size(); i2++) {
                List<b.a.q0.a.c> valueAt = this.f12456b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (b.a.q0.a.c cVar2 : valueAt) {
                        if (cVar2 != null && cVar2.d() == cVar.d() && cVar2.q() == cVar.q()) {
                            return cVar2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (b.a.q0.a.c) invokeL.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.n : invokeV.intValue;
    }

    public final long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            long l2 = b.a.q0.s.e0.b.j().l("pref_key_active_config_info", 0L);
            this.o = l2;
            return l2;
        }
        return invokeV.longValue;
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public volatile int f12469e;

        /* renamed from: f  reason: collision with root package name */
        public volatile long f12470f;

        /* renamed from: g  reason: collision with root package name */
        public volatile long f12471g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f12472h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f12473i;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12473i = dVar;
            this.f12472h = false;
        }

        public final void a(b.a.q0.a.c cVar, d.C0670d c0670d) {
            ArrayList<b.a.q0.a.i> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, cVar, c0670d) == null) || cVar == null || c0670d == null || (n = cVar.n()) == null) {
                return;
            }
            Iterator<b.a.q0.a.i> it = n.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                b.a.q0.a.i next = it.next();
                if (next instanceof n) {
                    n nVar = (n) next;
                    if (this.f12470f != 0 && nVar.i() == this.f12470f && !next.e()) {
                        this.f12472h = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().I() >= next.c().A()) {
                                c0670d.b(next);
                            }
                        }
                        c0670d.c(cVar);
                    }
                } else if (next instanceof b.a.q0.a.l) {
                    b.a.q0.a.l lVar = (b.a.q0.a.l) next;
                    if (!cVar.L() && lVar.d() == cVar.w()) {
                        if (this.f12470f != 0 && lVar.i() == this.f12470f && !next.e()) {
                            this.f12472h = false;
                            next.a(1);
                        }
                        i2 = (int) (i2 + next.b());
                        if (this.f12470f != 0 && lVar.i() == this.f12470f && !next.e()) {
                            if (next.b() >= cVar.f()) {
                                next.f(true);
                                cVar.I();
                            }
                            c0670d.c(cVar);
                        }
                        int l = cVar.l();
                        int A = cVar.A();
                        long f2 = cVar.f() * cVar.A();
                        if (this.f12470f != 0 && lVar.i() == this.f12470f) {
                            next.e();
                        }
                        if (i2 >= f2 && l >= A) {
                            c0670d.a(cVar);
                            cVar.c0(true);
                        }
                    }
                } else if (next instanceof b.a.q0.a.k) {
                    if (this.f12471g != 0 && ((b.a.q0.a.k) next).i() == this.f12471g && !next.e()) {
                        this.f12472h = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().G() >= next.c().p()) {
                                c0670d.b(next);
                            }
                        }
                    }
                } else if ((next instanceof b.a.q0.a.j) && !next.e()) {
                    this.f12472h = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        c0670d.b(next);
                    }
                }
            }
        }

        public final void b(b.a.q0.a.c cVar, d.C0670d c0670d) {
            ArrayList<b.a.q0.a.i> n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, c0670d) == null) || cVar == null || c0670d == null || (n = cVar.n()) == null) {
                return;
            }
            Iterator<b.a.q0.a.i> it = n.iterator();
            while (it.hasNext()) {
                b.a.q0.a.i next = it.next();
                if ((next instanceof b.a.q0.a.m) && !((b.a.q0.a.m) next).j() && !next.e()) {
                    this.f12472h = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        c0670d.a(cVar);
                    }
                    c0670d.c(cVar);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f12472h = true;
                List<b.a.q0.a.c> list = (List) this.f12473i.f12456b.get(b.a.q0.a.c.W);
                List<b.a.q0.a.c> list2 = (List) this.f12473i.f12456b.get(this.f12469e);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.f12473i.f12459e.compareAndSet(true, false);
                    return;
                }
                d.C0670d c0670d = new d.C0670d();
                c0670d.f12496a = new LinkedList();
                c0670d.f12497b = new LinkedList();
                c0670d.f12498c = new LinkedList();
                d(list, c0670d);
                e(list2, c0670d);
                if (this.f12472h) {
                    this.f12473i.f12459e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(c0670d.f12498c)) {
                    b.a.q0.a.a.g().k(c0670d.f12498c);
                }
                if (ListUtils.isEmpty(c0670d.f12496a) && ListUtils.isEmpty(c0670d.f12497b)) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, c0670d));
            }
        }

        public final void d(List<b.a.q0.a.c> list, d.C0670d c0670d) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, c0670d) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (b.a.q0.a.c cVar : list) {
                b(cVar, c0670d);
            }
        }

        public final void e(List<b.a.q0.a.c> list, d.C0670d c0670d) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, list, c0670d) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (b.a.q0.a.c cVar : list) {
                a(cVar, c0670d);
            }
        }

        public synchronized void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                synchronized (this) {
                    this.f12469e = i2;
                }
            }
        }

        public synchronized void g(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
                synchronized (this) {
                    this.f12471g = j;
                }
            }
        }

        public synchronized void h(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                synchronized (this) {
                    this.f12470f = j;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (this.f12469e == 0 || !this.f12473i.f12459e.get()) {
                    synchronized (this.f12473i.f12459e) {
                        try {
                            this.f12473i.f12459e.wait();
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
        this.f12455a = Executors.newSingleThreadScheduledExecutor();
        this.f12456b = new SparseArray<>();
        this.f12457c = new LinkedList<>();
        this.f12458d = new f(this, null);
        this.f12459e = new AtomicBoolean(false);
        this.f12460f = false;
        this.f12461g = false;
        this.p = false;
        this.q = new a(this, 2921391);
        this.r = new b(this, 2001011);
        this.s = new c(this, 2001371);
        this.t = new C0669d(this);
        this.u = new e(this);
        BdUniqueId gen = BdUniqueId.gen();
        this.f12462h = gen;
        b.a.q0.a.d0.d dVar = new b.a.q0.a.d0.d(gen);
        this.f12463i = dVar;
        dVar.w(this.u);
        b.a.q0.a.b0.c cVar = new b.a.q0.a.b0.c(this.f12462h);
        this.j = cVar;
        cVar.g(this.t);
        this.k = new b.a.q0.a.c0.b(this.f12462h);
        this.s.setTag(this.f12462h);
        MessageManager.getInstance().registerListener(this.s);
        this.r.setTag(this.f12462h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setPriority(Integer.MIN_VALUE);
        this.q.setTag(this.f12462h);
        MessageManager.getInstance().registerListener(this.q);
        b.a.q0.s.d0.a.e().f();
        q.c().d(this.f12462h);
        R();
        if (C()) {
            new k(this, null).execute(new Void[0]);
        }
    }
}
