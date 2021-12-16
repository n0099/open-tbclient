package c.a.s0.n2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.s0.y0.t;
import c.a.s0.y0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncDownloadModel;
import com.baidu.tieba.newfaceshop.NewFaceSyncUploadModel;
import com.baidu.tieba.newfaceshop.message.GetCloudFaceGroupMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f19890g;
    public transient /* synthetic */ FieldHolder $fh;
    public NewFaceSyncUploadModel a;

    /* renamed from: b  reason: collision with root package name */
    public NewFaceSyncDownloadModel f19891b;

    /* renamed from: c  reason: collision with root package name */
    public NewFaceGroupDownloadModel f19892c;

    /* renamed from: d  reason: collision with root package name */
    public v f19893d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19894e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19895f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19896e;

        public a(d dVar) {
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
            this.f19896e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<MyEmotionGroupData> f2;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (f2 = c.a.s0.n2.c.i().f()) == null) {
                return;
            }
            if (f2.isEmpty()) {
                str = UserCollectModel.ALL_DELETE;
            } else {
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                for (int i3 = 0; i3 < f2.size() && i2 < 30; i3++) {
                    MyEmotionGroupData myEmotionGroupData = f2.get(i3);
                    if (myEmotionGroupData != null) {
                        sb.append(myEmotionGroupData.getGroupId());
                        if (i3 < f2.size() - 1) {
                            sb.append("_");
                        }
                        i2++;
                    }
                }
                str = sb.toString();
            }
            this.f19896e.a.w(str);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.s0.n2.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GetCloudFaceGroupMessage f19897e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f19898f;

            public a(b bVar, GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, getCloudFaceGroupMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19898f = bVar;
                this.f19897e = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f19898f.a.f19893d.f(this.f19897e.getCollectEmotionList());
                }
            }
        }

        public b(d dVar) {
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
            this.a = dVar;
        }

        @Override // c.a.s0.n2.e.a
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getCloudFaceGroupMessage) == null) {
                if (getCloudFaceGroupMessage == null) {
                    this.a.f19895f = false;
                    this.a.f19894e = false;
                    return;
                }
                if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.k()) {
                    this.a.f19895f = false;
                    if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.k()) {
                        new UserCollectModel().w();
                    }
                    t.s().n();
                } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                    this.a.f19895f = false;
                } else {
                    c.a.s0.n2.a.b().a(new a(this, getCloudFaceGroupMessage));
                }
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.l()) {
                    this.a.f19894e = false;
                    if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.l()) {
                        this.a.w();
                    }
                    c.a.s0.n2.c.i().e();
                } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                    this.a.p(getCloudFaceGroupMessage.getFaceGroupData());
                } else {
                    this.a.f19894e = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f19899e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f19900f;

        public c(d dVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19900f = dVar;
            this.f19899e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.n2.c.i().b(true);
                List<MyEmotionGroupData> f2 = c.a.s0.n2.c.i().f();
                ArrayList arrayList = new ArrayList();
                if (f2 != null) {
                    for (MyEmotionGroupData myEmotionGroupData : f2) {
                        arrayList.add(myEmotionGroupData.getGroupId());
                    }
                }
                this.f19900f.h(this.f19899e, arrayList);
            }
        }
    }

    /* renamed from: c.a.s0.n2.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1205d implements c.a.s0.n2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicInteger a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f19901b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f19902c;

        public C1205d(d dVar, AtomicInteger atomicInteger, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, atomicInteger, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19902c = dVar;
            this.a = atomicInteger;
            this.f19901b = list;
        }

        @Override // c.a.s0.n2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.a.decrementAndGet() == 0) {
                this.f19902c.q(this.f19901b);
            }
        }

        @Override // c.a.s0.n2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.s0.n2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.a.decrementAndGet() == 0) {
                this.f19902c.q(this.f19901b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f19903e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f19904f;

        public e(d dVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19904f = dVar;
            this.f19903e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19904f.q(this.f19903e);
            }
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
        this.a = new NewFaceSyncUploadModel();
        this.f19891b = new NewFaceSyncDownloadModel();
        this.f19892c = new NewFaceGroupDownloadModel();
        this.f19893d = new v();
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? TbadkCoreApplication.getCurrentAccount() == null ? "" : String.valueOf(Math.abs(TbadkCoreApplication.getCurrentAccount().hashCode())) : (String) invokeV.objValue;
    }

    public static long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            c.a.r0.s.g0.b j2 = c.a.r0.s.g0.b.j();
            return j2.l("face_collect_update_time" + j(), 0L);
        }
        return invokeV.longValue;
    }

    public static long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            c.a.r0.s.g0.b j2 = c.a.r0.s.g0.b.j();
            return j2.l("face_group_update_time" + j(), 0L);
        }
        return invokeV.longValue;
    }

    public static d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f19890g == null) {
                synchronized (d.class) {
                    if (f19890g == null) {
                        f19890g = new d();
                    }
                }
            }
            return f19890g;
        }
        return (d) invokeV.objValue;
    }

    public static void s(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65548, null, j2) == null) {
            c.a.r0.s.g0.b j3 = c.a.r0.s.g0.b.j();
            j3.w("face_collect_update_time" + j(), j2);
        }
    }

    public static void t(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65549, null, j2) == null) {
            c.a.r0.s.g0.b j3 = c.a.r0.s.g0.b.j();
            j3.w("face_group_update_time" + j(), j2);
        }
    }

    public final void h(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, list2) == null) {
            if (list2 != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str) && !list.contains(str)) {
                        arrayList.add(str);
                    }
                }
                if (!arrayList.isEmpty()) {
                    c.a.s0.n2.c.i().c(arrayList, false);
                }
            }
            i(list, list2);
        }
    }

    public final void i(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList();
                for (String str : list) {
                    if (!list2.contains(str)) {
                        arrayList.add(str);
                    }
                }
                if (!arrayList.isEmpty()) {
                    AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
                    for (String str2 : arrayList) {
                        this.f19892c.w(str2, Boolean.FALSE, new C1205d(this, atomicInteger, list));
                    }
                    return;
                }
                r(list);
                return;
            }
            this.f19894e = false;
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19895f : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19894e : invokeV.booleanValue;
    }

    public final void p(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            c.a.s0.n2.a.b().a(new c(this, list));
        }
    }

    public final void q(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (c.a.s0.n2.c.i().j(list, false)) {
                t(System.currentTimeMillis());
            }
            this.f19894e = false;
        }
    }

    public final void r(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (m.B()) {
                c.a.s0.n2.a.b().a(new e(this, list));
            } else {
                q(list);
            }
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f19895f = z;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f19894e = true;
            this.f19895f = true;
            this.f19891b.w(new b(this));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.s0.n2.a.b().a(new a(this));
        }
    }
}
