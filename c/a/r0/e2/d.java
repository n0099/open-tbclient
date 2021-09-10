package c.a.r0.e2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.r0.r0.t;
import c.a.r0.r0.v;
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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f17259g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NewFaceSyncUploadModel f17260a;

    /* renamed from: b  reason: collision with root package name */
    public NewFaceSyncDownloadModel f17261b;

    /* renamed from: c  reason: collision with root package name */
    public NewFaceGroupDownloadModel f17262c;

    /* renamed from: d  reason: collision with root package name */
    public v f17263d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17264e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17265f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f17266e;

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
            this.f17266e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<MyEmotionGroupData> f2;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (f2 = c.a.r0.e2.c.i().f()) == null) {
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
            this.f17266e.f17260a.w(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.r0.e2.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f17267a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GetCloudFaceGroupMessage f17268e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f17269f;

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
                this.f17269f = bVar;
                this.f17268e = getCloudFaceGroupMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17269f.f17267a.f17263d.f(this.f17268e.getCollectEmotionList());
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
            this.f17267a = dVar;
        }

        @Override // c.a.r0.e2.e.a
        public void a(GetCloudFaceGroupMessage getCloudFaceGroupMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getCloudFaceGroupMessage) == null) {
                if (getCloudFaceGroupMessage == null) {
                    this.f17267a.f17265f = false;
                    this.f17267a.f17264e = false;
                    return;
                }
                if (getCloudFaceGroupMessage.getCollectUpdateTime() <= d.k()) {
                    this.f17267a.f17265f = false;
                    if (getCloudFaceGroupMessage.getCollectUpdateTime() < d.k()) {
                        new UserCollectModel().w();
                    }
                    t.s().n();
                } else if (getCloudFaceGroupMessage.getCollectEmotionList() == null) {
                    this.f17267a.f17265f = false;
                } else {
                    c.a.r0.e2.a.b().a(new a(this, getCloudFaceGroupMessage));
                }
                if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() <= d.l()) {
                    this.f17267a.f17264e = false;
                    if (getCloudFaceGroupMessage.getFaceGroupUpdateTime() < d.l()) {
                        this.f17267a.w();
                    }
                    c.a.r0.e2.c.i().e();
                } else if (getCloudFaceGroupMessage.getFaceGroupData() != null) {
                    this.f17267a.p(getCloudFaceGroupMessage.getFaceGroupData());
                } else {
                    this.f17267a.f17264e = false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f17270e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f17271f;

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
            this.f17271f = dVar;
            this.f17270e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.e2.c.i().b(true);
                List<MyEmotionGroupData> f2 = c.a.r0.e2.c.i().f();
                ArrayList arrayList = new ArrayList();
                if (f2 != null) {
                    for (MyEmotionGroupData myEmotionGroupData : f2) {
                        arrayList.add(myEmotionGroupData.getGroupId());
                    }
                }
                this.f17271f.h(this.f17270e, arrayList);
            }
        }
    }

    /* renamed from: c.a.r0.e2.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0840d implements c.a.r0.e2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f17272a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f17273b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f17274c;

        public C0840d(d dVar, AtomicInteger atomicInteger, List list) {
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
            this.f17274c = dVar;
            this.f17272a = atomicInteger;
            this.f17273b = list;
        }

        @Override // c.a.r0.e2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f17272a.decrementAndGet() == 0) {
                this.f17274c.q(this.f17273b);
            }
        }

        @Override // c.a.r0.e2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.r0.e2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.f17272a.decrementAndGet() == 0) {
                this.f17274c.q(this.f17273b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f17275e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f17276f;

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
            this.f17276f = dVar;
            this.f17275e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17276f.q(this.f17275e);
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
        this.f17260a = new NewFaceSyncUploadModel();
        this.f17261b = new NewFaceSyncDownloadModel();
        this.f17262c = new NewFaceGroupDownloadModel();
        this.f17263d = new v();
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
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            return j2.l("face_collect_update_time" + j(), 0L);
        }
        return invokeV.longValue;
    }

    public static long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            return j2.l("face_group_update_time" + j(), 0L);
        }
        return invokeV.longValue;
    }

    public static d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f17259g == null) {
                synchronized (d.class) {
                    if (f17259g == null) {
                        f17259g = new d();
                    }
                }
            }
            return f17259g;
        }
        return (d) invokeV.objValue;
    }

    public static void s(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65548, null, j2) == null) {
            c.a.q0.s.d0.b j3 = c.a.q0.s.d0.b.j();
            j3.w("face_collect_update_time" + j(), j2);
        }
    }

    public static void t(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65549, null, j2) == null) {
            c.a.q0.s.d0.b j3 = c.a.q0.s.d0.b.j();
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
                    c.a.r0.e2.c.i().c(arrayList, false);
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
                        this.f17262c.w(str2, Boolean.FALSE, new C0840d(this, atomicInteger, list));
                    }
                    return;
                }
                r(list);
                return;
            }
            this.f17264e = false;
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17265f : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17264e : invokeV.booleanValue;
    }

    public final void p(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            c.a.r0.e2.a.b().a(new c(this, list));
        }
    }

    public final void q(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (c.a.r0.e2.c.i().j(list, false)) {
                t(System.currentTimeMillis());
            }
            this.f17264e = false;
        }
    }

    public final void r(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (l.C()) {
                c.a.r0.e2.a.b().a(new e(this, list));
            } else {
                q(list);
            }
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f17265f = z;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f17264e = true;
            this.f17265f = true;
            this.f17261b.w(new b(this));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.r0.e2.a.b().a(new a(this));
        }
    }
}
