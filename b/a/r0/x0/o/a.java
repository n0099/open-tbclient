package b.a.r0.x0.o;

import b.a.e.f.d.l;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.FrsHotTopic.FrsHotTopicListData;
import com.baidu.tieba.frs.FrsHotTopic.FrsLinkHashMap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f27592b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsLinkHashMap<String, Long> f27593a;

    /* renamed from: b.a.r0.x0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1352a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27594a;

        public C1352a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27594a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            FrsHotTopicListData frsHotTopicListData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                b.a.q0.s.r.a.f();
                l<String> h2 = b.a.q0.s.r.a.h("tb.frs_hottopic", "");
                if (h2 != null) {
                    String str = h2.get("hot_topic_key");
                    if (!StringUtils.isNull(str) && (frsHotTopicListData = (FrsHotTopicListData) OrmObject.objectWithJsonStr(str, FrsHotTopicListData.class)) != null) {
                        this.f27594a.f27593a = frsHotTopicListData.mSceneMap;
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27595a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27595a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                b.a.q0.s.r.a.f();
                l<String> h2 = b.a.q0.s.r.a.h("tb.frs_hottopic", "");
                if (h2 == null) {
                    return null;
                }
                FrsHotTopicListData frsHotTopicListData = new FrsHotTopicListData();
                frsHotTopicListData.mSceneMap = this.f27595a.f27593a;
                String jsonStrWithObject = OrmObject.jsonStrWithObject(frsHotTopicListData);
                if (!StringUtils.isNull(jsonStrWithObject)) {
                    h2.g("hot_topic_key", jsonStrWithObject);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f27592b == null) {
                synchronized (a.class) {
                    if (f27592b == null) {
                        f27592b = new a();
                    }
                }
            }
            return f27592b;
        }
        return (a) invokeV.objValue;
    }

    public boolean c(String str, long j) {
        InterceptResult invokeLJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j)) == null) {
            if (this.f27593a == null) {
                this.f27593a = new FrsLinkHashMap<>();
                e(str, j);
            }
            if (StringUtils.isNull(str) || this.f27593a.isEmpty()) {
                return false;
            }
            Iterator<Map.Entry<String, Long>> it = this.f27593a.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Map.Entry<String, Long> next = it.next();
                if (next != null && str.equals(next.getKey())) {
                    z = true;
                    break;
                }
            }
            if (z && this.f27593a.get(str).longValue() == j) {
                return false;
            }
            this.f27593a.put(str, Long.valueOf(j));
            f();
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public final void e(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            C1352a c1352a = new C1352a(this);
            c1352a.setPriority(3);
            c1352a.execute(new Void[0]);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b bVar = new b(this);
            bVar.setPriority(3);
            bVar.execute(new Void[0]);
        }
    }
}
