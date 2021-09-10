package c.p.a.d.b;

import android.net.http.Headers;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.p.a.d.b.c;
import c.p.a.d.b.d;
import c.p.a.d.b.g;
import c.p.a.d.e;
import c.p.a.d.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f34663a;

    /* renamed from: b  reason: collision with root package name */
    public c.f f34664b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f34665c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f34666d;

    /* loaded from: classes4.dex */
    public class a implements g.InterfaceC1530g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f34667a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f34668b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.p.a.b.a.c.b f34669c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f34670d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.f f34671e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f34672f;

        public a(f fVar, int i2, String str, c.p.a.b.a.c.b bVar, long j2, g.f fVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2), str, bVar, Long.valueOf(j2), fVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34672f = fVar;
            this.f34667a = i2;
            this.f34668b = str;
            this.f34669c = bVar;
            this.f34670d = j2;
            this.f34671e = fVar2;
        }

        @Override // c.p.a.d.b.g.InterfaceC1530g
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f34672f.g(this.f34667a, this.f34668b, j2, this.f34669c, this.f34670d, this.f34671e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.f f34673e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f34674f;

        public b(f fVar, g.f fVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, fVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34674f = fVar;
            this.f34673e = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34674f.f34665c.get()) {
                return;
            }
            this.f34674f.f34665c.set(true);
            this.f34673e.a();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.p.a.e.b.o.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.InterfaceC1530g f34675a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f34676b;

        public c(f fVar, g.InterfaceC1530g interfaceC1530g) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, interfaceC1530g};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34676b = fVar;
            this.f34675a = interfaceC1530g;
        }

        @Override // c.p.a.e.b.o.l
        public void a(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || this.f34676b.f34665c.get()) {
                return;
            }
            this.f34676b.f34665c.set(true);
            long b2 = this.f34676b.b(map);
            if (b2 > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("apk_size", Long.valueOf(b2));
                    jSONObject.putOpt("available_space", Long.valueOf(f.t()));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.f34675a.a(b2);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(f fVar, c.p.a.b.a.c.b bVar, g.f fVar2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar, fVar2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.f f34677e;

        public e(f fVar, g.f fVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, fVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34677e = fVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34677e.a();
            }
        }
    }

    /* renamed from: c.p.a.d.b.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1529f implements d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1529f(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c.p.a.d.b.a.c f34678a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements c.p.a.d.b.a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.p.a.b.a.c.b f34679a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ i f34680b;

            public a(g gVar, c.p.a.b.a.c.b bVar, i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, bVar, iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34679a = bVar;
                this.f34680b = iVar;
            }

            @Override // c.p.a.d.b.a.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.p.a.d.b.a.c unused = g.f34678a = null;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pause_optimise_type", "apk_size");
                        jSONObject.putOpt("pause_optimise_action", "confirm");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.c.a().r("pause_optimise", jSONObject, this.f34679a);
                }
            }

            @Override // c.p.a.d.b.a.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.p.a.d.b.a.c unused = g.f34678a = null;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pause_optimise_type", "apk_size");
                        jSONObject.putOpt("pause_optimise_action", QueryResponse.Options.CANCEL);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.c.a().r("pause_optimise", jSONObject, this.f34679a);
                    this.f34680b.a(this.f34679a);
                }
            }
        }

        public g() {
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

        public static c.p.a.d.b.a.c c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f34678a : (c.p.a.d.b.a.c) invokeV.objValue;
        }

        public static String e(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j2)) == null) {
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                if (j2 >= 1073741824) {
                    return (j2 / 1073741824) + "G";
                } else if (j2 >= 1048576) {
                    return (j2 / 1048576) + "M";
                } else {
                    return decimalFormat.format(((float) j2) / 1048576.0f) + "M";
                }
            }
            return (String) invokeJ.objValue;
        }

        @Override // c.p.a.d.b.f.j
        public boolean a(c.p.a.b.a.c.b bVar, int i2, i iVar) {
            InterceptResult invokeLIL;
            DownloadInfo d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, bVar, i2, iVar)) == null) {
                if (bVar == null || bVar.e0() || !f(bVar) || (d2 = c.p.a.d.h.b(null).d(bVar.a())) == null) {
                    return false;
                }
                long b2 = c.p.a.d.b.k.b(d2.getId(), d2.getCurBytes(), d2.getTotalBytes());
                long totalBytes = d2.getTotalBytes();
                if (b2 <= 0 || totalBytes <= 0 || totalBytes > b(bVar.s())) {
                    return false;
                }
                f34678a = new a(this, bVar, iVar);
                TTDelegateActivity.a(bVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", e(totalBytes - b2)), "继续", "暂停");
                bVar.c1(true);
                return true;
            }
            return invokeLIL.booleanValue;
        }

        public final int b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? c.p.a.e.b.j.a.d(i2).b("pause_optimise_apk_size", 100) * 1024 * 1024 : invokeI.intValue;
        }

        public final boolean f(c.p.a.b.a.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) ? h.k.c(aVar).b("pause_optimise_apk_size_switch", 0) == 1 && aVar.q() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c.p.a.d.b.a.c f34681a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements c.p.a.d.b.a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.p.a.b.a.c.b f34682a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ i f34683b;

            public a(h hVar, c.p.a.b.a.c.b bVar, i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, bVar, iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34682a = bVar;
                this.f34683b = iVar;
            }

            @Override // c.p.a.d.b.a.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.p.a.d.b.a.c unused = h.f34681a = null;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pause_optimise_type", "download_percent");
                        jSONObject.putOpt("pause_optimise_action", "confirm");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.c.a().r("pause_optimise", jSONObject, this.f34682a);
                }
            }

            @Override // c.p.a.d.b.a.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.p.a.d.b.a.c unused = h.f34681a = null;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pause_optimise_type", "download_percent");
                        jSONObject.putOpt("pause_optimise_action", QueryResponse.Options.CANCEL);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.c.a().r("pause_optimise", jSONObject, this.f34682a);
                    this.f34683b.a(this.f34682a);
                }
            }
        }

        public h() {
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

        public static c.p.a.d.b.a.c c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f34681a : (c.p.a.d.b.a.c) invokeV.objValue;
        }

        @Override // c.p.a.d.b.f.j
        public boolean a(c.p.a.b.a.c.b bVar, int i2, i iVar) {
            InterceptResult invokeLIL;
            DownloadInfo d2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, bVar, i2, iVar)) == null) {
                if (bVar == null || bVar.f0() || !e(bVar) || (d2 = c.p.a.d.h.b(null).d(bVar.a())) == null) {
                    return false;
                }
                long curBytes = d2.getCurBytes();
                long totalBytes = d2.getTotalBytes();
                if (curBytes > 0 && totalBytes > 0) {
                    int a2 = c.p.a.d.b.k.a(d2.getId(), (int) ((curBytes * 100) / totalBytes));
                    if (a2 > b(bVar.s())) {
                        f34681a = new a(this, bVar, iVar);
                        TTDelegateActivity.b(bVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(a2)), "继续", "暂停");
                        bVar.d1(true);
                        return true;
                    }
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }

        public final int b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? c.p.a.e.b.j.a.d(i2).b("pause_optimise_download_percent", 50) : invokeI.intValue;
        }

        public final boolean e(c.p.a.b.a.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) ? h.k.c(aVar).b("pause_optimise_download_percent_switch", 0) == 1 && aVar.q() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface i {
        void a(c.p.a.b.a.c.b bVar);
    }

    /* loaded from: classes4.dex */
    public interface j {
        boolean a(c.p.a.b.a.c.b bVar, int i2, i iVar);
    }

    /* loaded from: classes4.dex */
    public class k implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
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

        @Override // c.p.a.d.b.f.j
        public boolean a(c.p.a.b.a.c.b bVar, int i2, i iVar) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, bVar, i2, iVar)) == null) {
                if (bVar != null && c(bVar.s())) {
                    if (System.currentTimeMillis() - bVar.Q() <= b(bVar.s())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "mistake_click");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        e.c.a().r("pause_optimise", jSONObject, bVar);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }

        public final long b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? c.p.a.e.b.j.a.d(i2).b("pause_optimise_mistake_click_interval", 300) : invokeI.longValue;
        }

        public final boolean c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? c.p.a.e.b.j.a.d(i2).b("pause_optimise_mistake_click_interval_switch", 0) == 1 : invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static l f34684b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<j> f34685a;

        public l() {
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
            ArrayList arrayList = new ArrayList();
            this.f34685a = arrayList;
            arrayList.add(new k());
            this.f34685a.add(new m());
            this.f34685a.add(new h());
            this.f34685a.add(new g());
        }

        public static l a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f34684b == null) {
                    synchronized (l.class) {
                        if (f34684b == null) {
                            f34684b = new l();
                        }
                    }
                }
                return f34684b;
            }
            return (l) invokeV.objValue;
        }

        public void b(c.p.a.b.a.c.b bVar, int i2, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, iVar) == null) {
                List<j> list = this.f34685a;
                if (list != null && list.size() != 0 && bVar != null) {
                    DownloadInfo d2 = c.p.a.d.h.b(null).d(bVar.a());
                    if (d2 != null && "application/vnd.android.package-archive".equals(d2.getMimeType())) {
                        boolean z = c.p.a.e.b.j.a.d(bVar.s()).b("pause_optimise_switch", 0) == 1;
                        for (j jVar : this.f34685a) {
                            if (z || (jVar instanceof m)) {
                                if (jVar.a(bVar, i2, iVar)) {
                                    return;
                                }
                            }
                        }
                        iVar.a(bVar);
                        return;
                    }
                    iVar.a(bVar);
                    return;
                }
                iVar.a(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
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

        @Override // c.p.a.d.b.f.j
        public boolean a(c.p.a.b.a.c.b bVar, int i2, i iVar) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, bVar, i2, iVar)) == null) {
                if (bVar == null) {
                    return false;
                }
                return n.d(bVar, c.p.a.d.h.b(null).d(bVar.a()), i2, iVar);
            }
            return invokeLIL.booleanValue;
        }
    }

    public f(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34665c = new AtomicBoolean(false);
        this.f34666d = new AtomicBoolean(false);
        this.f34663a = handler;
    }

    public static JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("clean_space_install_params", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void e(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2) == null) && h.k.r(i2) && c.p.a.d.b.l.y() != null && c.p.a.d.b.l.y().b()) {
            c.p.a.d.b.l.y().c();
        }
    }

    public static void h(c.p.a.b.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) {
            long t = t();
            if (c.p.a.d.b.l.y() != null) {
                c.p.a.d.b.l.y().e();
            }
            d.C1526d.a();
            d.C1526d.e();
            if (h.k.s(bVar.s())) {
                d.C1526d.b(c.p.a.d.b.l.a());
            }
            long t2 = t();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(t2 - t));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            e.c.a().r("clean_quite_finish", jSONObject, bVar);
        }
    }

    public static boolean p(DownloadInfo downloadInfo, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, downloadInfo, j2)) == null) {
            int id = downloadInfo.getId();
            boolean z = false;
            if (h.k.r(id)) {
                if (c.p.a.d.b.l.y() != null && (z = c.p.a.d.b.l.y().a(id, downloadInfo.getUrl(), false, j2))) {
                    d.e.a().e(downloadInfo.getUrl(), new C1529f(downloadInfo));
                }
                return z;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (c.p.a.d.b.l.y() != null) {
                return c.p.a.d.b.l.y().a();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? h.r.d(0L) : invokeV.longValue;
    }

    public final long b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            if (map != null && map.size() != 0) {
                try {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String value = entry.getValue();
                        if (Headers.CONTENT_LEN.equalsIgnoreCase(entry.getKey())) {
                            return Long.parseLong(value);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public void f(int i2, long j2, long j3, g.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), fVar}) == null) {
            this.f34666d.set(false);
            if (fVar == null) {
                return;
            }
            if (h.k.r(i2) && h.k.q(i2)) {
                long l2 = h.k.l(i2);
                this.f34665c.set(false);
                String a2 = this.f34664b.f34622b.a();
                c.p.a.b.a.c.b o = c.g.e().o(a2);
                if (o == null) {
                    c.f fVar2 = this.f34664b;
                    o = new c.p.a.b.a.c.b(fVar2.f34622b, fVar2.f34623c, fVar2.f34624d, 0);
                    c.g.e().j(o);
                }
                c.p.a.b.a.c.b bVar = o;
                bVar.A0(false);
                if (c.p.a.d.b.l.y() != null) {
                    c.p.a.d.b.l.y().a(bVar.b());
                }
                d.e.a().d(bVar.a());
                boolean o2 = h.k.o(i2);
                if (j3 > 0) {
                    g(i2, a2, j3, bVar, j2, fVar);
                } else if (o2) {
                    l(a2, bVar, new a(this, i2, a2, bVar, j2, fVar));
                } else {
                    l2 = 0;
                }
                this.f34663a.postDelayed(new b(this, fVar), l2);
                return;
            }
            fVar.a();
        }
    }

    public final void g(int i2, String str, long j2, c.p.a.b.a.c.b bVar, long j3, g.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), bVar, Long.valueOf(j3), fVar}) == null) {
            this.f34665c.set(true);
            boolean z = false;
            if (j2 > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("apk_size", Long.valueOf(j2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                long longValue = (Double.valueOf((h.k.a(i2) + 1.0d) * j2).longValue() + h.k.f(i2)) - j3;
                long t = t();
                if (t < longValue) {
                    i(bVar, jSONObject, longValue, t);
                    h(bVar);
                    long t2 = t();
                    if (t2 < longValue) {
                        bVar.w0(true);
                        String a2 = bVar.a();
                        d.e.a().e(a2, new d(this, bVar, fVar, a2));
                        z = o(i2, bVar, str, longValue);
                        if (z) {
                            bVar.A0(true);
                        }
                    } else {
                        r(bVar, jSONObject, t, t2);
                    }
                }
            }
            if (z) {
                return;
            }
            this.f34663a.post(new e(this, fVar));
        }
    }

    public final void i(c.p.a.b.a.c.b bVar, JSONObject jSONObject, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, jSONObject, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            try {
                jSONObject.putOpt("available_space", Long.valueOf(j3));
                jSONObject.putOpt("apk_download_need_size", Long.valueOf(j2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            e.c.a().r("clean_space_no_enough_for_download", jSONObject, bVar);
        }
    }

    public void j(c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f34664b = fVar;
        }
    }

    public final void l(String str, c.p.a.b.a.c.b bVar, g.InterfaceC1530g interfaceC1530g) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, bVar, interfaceC1530g) == null) || interfaceC1530g == null) {
            return;
        }
        c.p.a.e.b.o.b.b.c(str, new c(this, interfaceC1530g));
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f34666d.set(z);
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f34666d.get() : invokeV.booleanValue;
    }

    public final boolean o(int i2, @NonNull c.p.a.b.a.c.b bVar, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), bVar, str, Long.valueOf(j2)})) == null) {
            if (h.k.r(i2)) {
                if (c.p.a.d.b.l.y() != null) {
                    return c.p.a.d.b.l.y().a(i2, str, true, j2);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("show_dialog_result", 3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                e.c.a().r("cleanspace_window_show", jSONObject, bVar);
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void r(c.p.a.b.a.c.b bVar, JSONObject jSONObject, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{bVar, jSONObject, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            bVar.Y0("1");
            c.j.b().c(bVar);
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(j3 - j2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            e.c.a().r("cleanspace_download_after_quite_clean", jSONObject, bVar);
        }
    }
}
