package b.a.r0.f2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.r0.s0.t;
import b.a.r0.s0.v;
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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f16409g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NewFaceSyncUploadModel f16410a;

    /* renamed from: b  reason: collision with root package name */
    public NewFaceSyncDownloadModel f16411b;

    /* renamed from: c  reason: collision with root package name */
    public NewFaceGroupDownloadModel f16412c;

    /* renamed from: d  reason: collision with root package name */
    public v f16413d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16414e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16415f;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f16416e;

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
            this.f16416e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<MyEmotionGroupData> f2;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (f2 = b.a.r0.f2.c.i().f()) == null) {
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
            this.f16416e.f16410a.w(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.r0.f2.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f16417a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GetCloudFaceGroupMessage f16418e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f16419f;

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
                this.f16419f = bVar;
                this.f16418e = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16419f.f16417a.f16413d.f(this.f16418e.getCollectEmotionList());
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
            this.f16417a = dVar;
        }

        @Override // b.a.r0.f2.e.a
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getCloudFaceGroupMessage) == null) {
                if (getCloudFaceGroupMessage == null) {
                    this.f16417a.f16415f = false;
                    this.f16417a.f16414e = false;
                    return;
                }
                if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.k()) {
                    this.f16417a.f16415f = false;
                    if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.k()) {
                        new UserCollectModel().w();
                    }
                    t.s().n();
                } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                    this.f16417a.f16415f = false;
                } else {
                    b.a.r0.f2.a.b().a(new a(this, getCloudFaceGroupMessage));
                }
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.l()) {
                    this.f16417a.f16414e = false;
                    if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.l()) {
                        this.f16417a.w();
                    }
                    b.a.r0.f2.c.i().e();
                } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                    this.f16417a.p(getCloudFaceGroupMessage.getFaceGroupData());
                } else {
                    this.f16417a.f16414e = false;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f16420e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f16421f;

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
            this.f16421f = dVar;
            this.f16420e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.r0.f2.c.i().b(true);
                List<MyEmotionGroupData> f2 = b.a.r0.f2.c.i().f();
                ArrayList arrayList = new ArrayList();
                if (f2 != null) {
                    for (MyEmotionGroupData myEmotionGroupData : f2) {
                        arrayList.add(myEmotionGroupData.getGroupId());
                    }
                }
                this.f16421f.h(this.f16420e, arrayList);
            }
        }
    }

    /* renamed from: b.a.r0.f2.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0842d implements b.a.r0.f2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f16422a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f16423b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f16424c;

        public C0842d(d dVar, AtomicInteger atomicInteger, List list) {
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
            this.f16424c = dVar;
            this.f16422a = atomicInteger;
            this.f16423b = list;
        }

        @Override // b.a.r0.f2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f16422a.decrementAndGet() == 0) {
                this.f16424c.q(this.f16423b);
            }
        }

        @Override // b.a.r0.f2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // b.a.r0.f2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.f16422a.decrementAndGet() == 0) {
                this.f16424c.q(this.f16423b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f16425e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f16426f;

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
            this.f16426f = dVar;
            this.f16425e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16426f.q(this.f16425e);
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
        this.f16410a = new NewFaceSyncUploadModel();
        this.f16411b = new NewFaceSyncDownloadModel();
        this.f16412c = new NewFaceGroupDownloadModel();
        this.f16413d = new v();
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
            b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
            return j.l("face_collect_update_time" + j(), 0L);
        }
        return invokeV.longValue;
    }

    public static long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
            return j.l("face_group_update_time" + j(), 0L);
        }
        return invokeV.longValue;
    }

    public static d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f16409g == null) {
                synchronized (d.class) {
                    if (f16409g == null) {
                        f16409g = new d();
                    }
                }
            }
            return f16409g;
        }
        return (d) invokeV.objValue;
    }

    public static void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65548, null, j) == null) {
            b.a.q0.s.e0.b j2 = b.a.q0.s.e0.b.j();
            j2.w("face_collect_update_time" + j(), j);
        }
    }

    public static void t(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65549, null, j) == null) {
            b.a.q0.s.e0.b j2 = b.a.q0.s.e0.b.j();
            j2.w("face_group_update_time" + j(), j);
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
                    b.a.r0.f2.c.i().c(arrayList, false);
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
                        this.f16412c.w(str2, Boolean.FALSE, new C0842d(this, atomicInteger, list));
                    }
                    return;
                }
                r(list);
                return;
            }
            this.f16414e = false;
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16415f : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16414e : invokeV.booleanValue;
    }

    public final void p(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            b.a.r0.f2.a.b().a(new c(this, list));
        }
    }

    public final void q(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (b.a.r0.f2.c.i().j(list, false)) {
                t(System.currentTimeMillis());
            }
            this.f16414e = false;
        }
    }

    public final void r(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (l.C()) {
                b.a.r0.f2.a.b().a(new e(this, list));
            } else {
                q(list);
            }
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f16415f = z;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f16414e = true;
            this.f16415f = true;
            this.f16411b.w(new b(this));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b.a.r0.f2.a.b().a(new a(this));
        }
    }
}
