package b.a.r0.s0;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import b.a.r0.s0.t;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public t f23420a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f23421b;

    /* loaded from: classes5.dex */
    public class a implements t.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f23422e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f23423f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ v f23424g;

        public a(v vVar, List list, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, list, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23424g = vVar;
            this.f23422e = list;
            this.f23423f = map;
        }

        @Override // b.a.r0.s0.t.l
        public void onResult(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                this.f23424g.d(this.f23422e, this.f23423f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f23425e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f23426f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ v f23427g;

        /* loaded from: classes5.dex */
        public class a implements t.l {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f23428e;

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
                this.f23428e = bVar;
            }

            @Override // b.a.r0.s0.t.l
            public void onResult(int i2, int i3, int i4) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                    b bVar = this.f23428e;
                    bVar.f23427g.g(bVar.f23426f);
                }
            }
        }

        public b(v vVar, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23427g = vVar;
            this.f23425e = list;
            this.f23426f = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23427g.f23420a.h(this.f23425e, false, new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements t.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.r0.s0.t.l
        public void onResult(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                if (i3 > 0) {
                    BdLog.e("NewFaceSyncUtil setCollectUpdateTime reSortLocalFace Called:" + System.currentTimeMillis());
                    b.a.r0.f2.d.s(System.currentTimeMillis());
                }
                b.a.r0.f2.d.m().u(false);
            }
        }
    }

    public v() {
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
        this.f23420a = t.s();
        this.f23421b = new Handler(Looper.getMainLooper());
    }

    public final void d(List<CollectEmotionData> list, Map<String, CollectEmotionData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, map) == null) {
            ArrayList<CollectEmotionData> arrayList = new ArrayList();
            for (CollectEmotionData collectEmotionData : list) {
                if (collectEmotionData != null && !map.containsKey(collectEmotionData.pid) && !TextUtils.isEmpty(collectEmotionData.picUrl)) {
                    arrayList.add(collectEmotionData);
                }
            }
            if (!arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (CollectEmotionData collectEmotionData2 : arrayList) {
                    b.a.q0.d0.c cVar = new b.a.q0.d0.c();
                    cVar.f12030f = collectEmotionData2.pkgId;
                    cVar.f12025a = collectEmotionData2.pid;
                    cVar.f12028d = collectEmotionData2.picUrl;
                    cVar.f12026b = collectEmotionData2.width;
                    cVar.f12027c = collectEmotionData2.height;
                    cVar.f12029e = collectEmotionData2.thumbnail;
                    arrayList2.add(cVar);
                }
                this.f23421b.post(new b(this, arrayList2, list));
                return;
            }
            g(list);
        }
    }

    public final void e(List<CollectEmotionData> list, List<CollectEmotionData> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, CollectEmotionData> h2 = h(list2);
            Map<String, CollectEmotionData> h3 = h(list);
            for (Map.Entry<String, CollectEmotionData> entry : h2.entrySet()) {
                if (!h3.containsKey(entry.getKey())) {
                    arrayList.add(entry.getValue());
                }
            }
            if (!arrayList.isEmpty()) {
                this.f23420a.l(arrayList, false, new a(this, list, h2));
            } else {
                d(list, h2);
            }
        }
    }

    public void f(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            t.s().k(true);
            List<CollectEmotionData> n = g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
            for (CollectEmotionData collectEmotionData : n) {
                String o = t.o(collectEmotionData.pid, false);
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(o);
                collectEmotionData.imageFileInfo = imageFileInfo;
            }
            BdLog.e("NewFaceSyncUtil MergeCollectFace Called CloudList:");
            Iterator<CollectEmotionData> it = list.iterator();
            while (it.hasNext()) {
                BdLog.e("NewFaceSyncUtil Cloud data:" + it.next().pkgId);
            }
            BdLog.e("NewFaceSyncUtil MergeCollectFace Called localList:");
            Iterator<CollectEmotionData> it2 = n.iterator();
            while (it2.hasNext()) {
                BdLog.e("NewFaceSyncUtil Local data:" + it2.next().pkgId);
            }
            e(list, n);
        }
    }

    public final void g(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f23420a.t(list, false, new c(this));
        }
    }

    public final Map<String, CollectEmotionData> h(List<CollectEmotionData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (list != null) {
                for (CollectEmotionData collectEmotionData : list) {
                    if (collectEmotionData != null && !TextUtils.isEmpty(collectEmotionData.pid)) {
                        hashMap.put(collectEmotionData.pid, collectEmotionData);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
