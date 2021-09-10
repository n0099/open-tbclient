package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.CustomerServiceMenu;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f42431a = "g";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RoleOptions f42432b;

    /* renamed from: c  reason: collision with root package name */
    public DisplayOptions f42433c;

    /* renamed from: d  reason: collision with root package name */
    public BlockingQueue<SyncResponseResult> f42434d;

    /* renamed from: e  reason: collision with root package name */
    public i f42435e;

    /* renamed from: f  reason: collision with root package name */
    public String f42436f;

    /* renamed from: g  reason: collision with root package name */
    public String f42437g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.c.a f42438h;

    /* renamed from: i  reason: collision with root package name */
    public HandlerThread f42439i;

    /* renamed from: j  reason: collision with root package name */
    public b f42440j;
    public volatile int k;
    public k l;
    public boolean m;
    public float n;
    public long o;
    public int p;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final g f42441a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(544755655, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/g$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(544755655, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/g$a;");
                    return;
                }
            }
            f42441a = new g(null);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f42442a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42442a = gVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 100000:
                        SyncResponseResult b2 = this.f42442a.b((String) message.obj);
                        if (b2 == null) {
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(g.f42431a, "parser response data is null");
                            return;
                        }
                        this.f42442a.a(b2);
                        this.f42442a.j();
                        this.f42442a.b(b2);
                        return;
                    case CustomerServiceMenu.TRANSFER_RECORD /* 100001 */:
                        this.f42442a.k();
                        return;
                    default:
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(g.f42431a, "Undefined message type");
                        return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-178203868, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-178203868, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/g;");
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42434d = new LinkedBlockingQueue();
        this.f42436f = String.valueOf(0);
        this.f42437g = String.valueOf(0);
        this.f42438h = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
        this.k = 0;
        this.m = false;
        this.n = 0.0f;
        this.o = 0L;
        this.p = 0;
    }

    public /* synthetic */ g(h hVar) {
        this();
    }

    private f a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) {
            if (this.f42432b == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "RoleOptions is null");
                return null;
            }
            f fVar = new f();
            fVar.a(this.f42432b.getOrderId());
            fVar.b(this.f42432b.getDriverId());
            fVar.c(this.f42432b.getUserId());
            fVar.a(i2);
            if (this.m) {
                this.f42436f = String.valueOf(0);
                this.f42437g = String.valueOf(0);
            }
            fVar.d(this.f42436f);
            fVar.e(this.f42437g);
            return fVar;
        }
        return (f) invokeI.objValue;
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.f42441a : (g) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SyncResponseResult syncResponseResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, syncResponseResult) == null) {
            if (this.f42434d == null) {
                this.f42434d = new LinkedBlockingQueue();
            }
            if (this.m) {
                this.m = false;
                this.f42434d.clear();
            }
            try {
                this.f42434d.put(syncResponseResult);
            } catch (InterruptedException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "InterruptedException happened when put item into queue", e2);
                Thread.currentThread().interrupt();
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.c.a aVar = this.f42438h;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "HttpClient cannot be null");
            } else {
                aVar.a(str, new h(this));
            }
        }
    }

    private void a(String str, SyncResponseResult syncResponseResult) {
        LatLng latLng;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, str, syncResponseResult) == null) {
            String[] split = str.split(";");
            if (split.length == 0) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "There's no section route data");
                return;
            }
            String[] split2 = split[0].split(",");
            if (2 != split2.length) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "Section start position latlng invalid: " + split[0]);
                return;
            }
            LatLng latLng2 = null;
            try {
                latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
            } catch (NumberFormatException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "Get startPosition failed", e2);
                latLng = null;
            }
            for (int i2 = 1; i2 < split.length; i2++) {
                RouteLineInfo.RouteSectionInfo routeSectionInfo = new RouteLineInfo.RouteSectionInfo();
                routeSectionInfo.a(latLng);
                String[] split3 = split[i2].split(",");
                if (2 != split3.length) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "Section position latlng invalid: " + split[i2]);
                } else {
                    try {
                        latLng2 = new LatLng(Double.valueOf(split3[1]).doubleValue(), Double.valueOf(split3[0]).doubleValue());
                    } catch (NumberFormatException e3) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "Get endPosition failed", e3);
                    }
                    routeSectionInfo.b(latLng2);
                    syncResponseResult.a().a(routeSectionInfo);
                    latLng = latLng2;
                }
            }
        }
    }

    private void a(JSONArray jSONArray, SyncResponseResult syncResponseResult) {
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, jSONArray, syncResponseResult) == null) {
            JSONObject optJSONObject = jSONArray.optJSONObject(jSONArray.length() - 1);
            if (optJSONObject == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "Invalid driver position data");
                return;
            }
            syncResponseResult.c().setTimeStamp(optJSONObject.optString("t"));
            String optString = optJSONObject.optString("p");
            if (optString == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "No position info data");
                return;
            }
            String[] split = optString.split(";");
            if (split.length == 0) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "Position info array is empty");
                return;
            }
            int i2 = 0;
            String[] split2 = split[0].split(",");
            if (2 != split2.length) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "Position latlng invalid");
                return;
            }
            LatLng latLng = null;
            try {
                latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
            } catch (NumberFormatException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "Get driver position failed", e2);
            }
            syncResponseResult.c().setPoint(latLng);
            double d3 = 0.0d;
            try {
                d2 = Double.valueOf(split[1]).doubleValue();
            } catch (NumberFormatException e3) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "Get angle failed", e3);
                d2 = 0.0d;
            }
            syncResponseResult.c().setAngle(d2);
            try {
                d3 = Double.valueOf(split[2]).doubleValue();
            } catch (NumberFormatException e4) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "Get speed failed", e4);
            }
            syncResponseResult.c().setSpeed(d3);
            try {
                i2 = Integer.valueOf(split[3]).intValue();
            } catch (NumberFormatException e5) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "Get orderStateInPosition failed", e5);
            }
            syncResponseResult.c().setOrderStateInPosition(i2);
        }
    }

    private void a(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, jSONObject, syncResponseResult) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE);
            if (optJSONObject != null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "parser route data");
                b(optJSONObject, syncResponseResult);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("traffic");
            if (optJSONObject2 != null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "parser traffic data");
                c(optJSONObject2, syncResponseResult);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("positions");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                this.l.c(2004, SynchronizationConstants.LBS_STATUS_MESSAGE_QUERY_TRACK_DRIVER_POSITION_FAILED);
            } else {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "parser driver position data");
                a(optJSONArray, syncResponseResult);
            }
            String optString = jSONObject.optString("run");
            if (!TextUtils.isEmpty(optString)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "parser travelled distance and elapsed time data");
                c(optString, syncResponseResult);
            }
            String optString2 = jSONObject.optString("remain");
            if (!TextUtils.isEmpty(optString2)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "parser remain distance and estimated time data");
                d(optString2, syncResponseResult);
            }
            syncResponseResult.a(jSONObject.optInt("s"));
            syncResponseResult.a(jSONObject.optString("mtime"));
            syncResponseResult.b(jSONObject.optString("ext"));
        }
    }

    private boolean a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, jSONObject)) == null) {
            if (jSONObject == null || !jSONObject.has("status")) {
                k kVar = this.l;
                if (kVar != null) {
                    kVar.c(2003, SynchronizationConstants.LBS_STATUS_MESSAGE_QUERY_TRACK_ROUTE_FAILED);
                }
                return false;
            }
            int optInt = jSONObject.optInt("status");
            String optString = jSONObject.optString("message");
            if (optInt != 0) {
                k kVar2 = this.l;
                if (kVar2 != null) {
                    kVar2.c(optInt, optString);
                }
                return false;
            }
            k kVar3 = this.l;
            if (kVar3 != null) {
                kVar3.b(optInt, optString);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static /* synthetic */ int b(g gVar) {
        int i2 = gVar.k;
        gVar.k = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SyncResponseResult b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "Response result is null");
                return null;
            }
            SyncResponseResult syncResponseResult = new SyncResponseResult();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!a(jSONObject)) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "Response result is invalid");
                    return null;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    a(optJSONObject, syncResponseResult);
                    return syncResponseResult;
                }
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "No route and traffic and driver data");
                return null;
            } catch (JSONException unused) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "JSONException happened when parser");
                return null;
            }
        }
        return (SyncResponseResult) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SyncResponseResult syncResponseResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, syncResponseResult) == null) {
            float d2 = syncResponseResult.d();
            long e2 = syncResponseResult.e();
            int i2 = this.p;
            if (1 == i2 || 2 == i2 || 4 == i2) {
                if (this.p != 1 && this.m) {
                    this.n = 0.0f;
                    this.o = 0L;
                    e2 = 0;
                    d2 = 0.0f;
                }
                if (0.0f != d2) {
                    this.n = d2;
                }
                if (0 != e2) {
                    this.o = e2;
                }
            } else {
                this.n = 0.0f;
                this.o = 0L;
            }
            k kVar = this.l;
            if (kVar != null) {
                kVar.a(this.n, this.o);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0077 A[LOOP:1: B:28:0x0073->B:30:0x0077, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(String str, SyncResponseResult syncResponseResult) {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, this, str, syncResponseResult) == null) {
            String[] split = str.split(";");
            if (split.length == 0) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "There's no section traffic data");
                return;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (String str2 : split) {
                String[] split2 = str2.split(",");
                if (3 != split2.length) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "section traffic data is invalid: " + str2);
                } else {
                    try {
                        i2 = Integer.valueOf(split2[0]).intValue();
                        try {
                            i3 = Integer.valueOf(split2[1]).intValue();
                        } catch (NumberFormatException e2) {
                            e = e2;
                            i3 = 0;
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "Get traffic status info failed", e);
                            i4 = 0;
                            while (i5 < i2 + i3) {
                            }
                            syncResponseResult.b().a(arrayList);
                        }
                    } catch (NumberFormatException e3) {
                        e = e3;
                        i2 = 0;
                    }
                    try {
                        i4 = Integer.valueOf(split2[2]).intValue();
                    } catch (NumberFormatException e4) {
                        e = e4;
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "Get traffic status info failed", e);
                        i4 = 0;
                        while (i5 < i2 + i3) {
                        }
                        syncResponseResult.b().a(arrayList);
                    }
                    for (i5 = i2; i5 < i2 + i3; i5++) {
                        arrayList.add(Integer.valueOf(i4));
                    }
                    syncResponseResult.b().a(arrayList);
                }
            }
        }
    }

    private void b(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, this, jSONObject, syncResponseResult) == null) {
            syncResponseResult.a().a(jSONObject.optInt("c") != 0);
            this.f42436f = jSONObject.optString("f");
            syncResponseResult.a().a(this.f42436f);
            String optString = jSONObject.optString("d");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            a(optString, syncResponseResult);
        }
    }

    private void c(String str, SyncResponseResult syncResponseResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, this, str, syncResponseResult) == null) {
            String[] split = str.split(";");
            if (2 != split.length) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "The travelled data is null or invalid");
                return;
            }
            float f2 = 0.0f;
            try {
                f2 = Float.valueOf(split[0]).floatValue();
            } catch (NumberFormatException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "Get travelledDistance failed", e2);
            }
            syncResponseResult.a(f2);
            long j2 = 0;
            try {
                j2 = Long.valueOf(split[1]).longValue();
            } catch (NumberFormatException e3) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "Get elapsedTime failed", e3);
            }
            syncResponseResult.a(j2);
        }
    }

    private void c(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, jSONObject, syncResponseResult) == null) {
            syncResponseResult.b().a(jSONObject.optInt("c") != 0);
            this.f42437g = jSONObject.optString("f");
            syncResponseResult.b().a(this.f42437g);
            String optString = jSONObject.optString("d");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            b(optString, syncResponseResult);
        }
    }

    private void d(String str, SyncResponseResult syncResponseResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, this, str, syncResponseResult) == null) {
            String[] split = str.split(";");
            if (2 != split.length) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42431a, "The remain data is null or invalid: ");
                return;
            }
            float f2 = 0.0f;
            try {
                f2 = Float.valueOf(split[0]).floatValue();
            } catch (NumberFormatException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "Get remainDistance failed", e2);
            }
            syncResponseResult.b(f2);
            long j2 = 0;
            try {
                j2 = Long.valueOf(split[1]).longValue();
            } catch (NumberFormatException e3) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(f42431a, "Get estimatedTime failed", e3);
            }
            syncResponseResult.b(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || (iVar = this.f42435e) == null) {
            return;
        }
        iVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65564, this) == null) || (iVar = this.f42435e) == null) {
            return;
        }
        iVar.b();
    }

    public void a(int i2, boolean z) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.m = z;
            this.p = i2;
            f a2 = a(i2);
            if (a2 == null) {
                str = f42431a;
                str2 = "Data request option is null";
            } else {
                String a3 = new m(a2).a();
                if (a3 != null) {
                    a(a3);
                    return;
                } else {
                    str = f42431a;
                    str2 = "send url string is null";
                }
            }
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, str2);
        }
    }

    public synchronized void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            synchronized (this) {
                if (this.f42433c != null) {
                    this.f42433c.setStartPositionInfoWindowView(view);
                    return;
                }
                if (this.l != null) {
                    this.l.c(1004, SynchronizationConstants.LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID);
                }
            }
        }
    }

    public synchronized void a(DisplayOptions displayOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, displayOptions) == null) {
            synchronized (this) {
                this.f42433c = displayOptions;
            }
        }
    }

    public synchronized void a(RoleOptions roleOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, roleOptions) == null) {
            synchronized (this) {
                this.f42432b = roleOptions;
            }
        }
    }

    public void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.f42435e = iVar;
        }
    }

    public void a(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            this.l = kVar;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            HandlerThread handlerThread = new HandlerThread("SyncDataStorage");
            this.f42439i = handlerThread;
            handlerThread.start();
            this.f42440j = new b(this, this.f42439i.getLooper());
        }
    }

    public synchronized void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            synchronized (this) {
                if (this.f42433c != null) {
                    this.f42433c.setEndPositionInfoWindowView(view);
                    return;
                }
                if (this.l != null) {
                    this.l.c(1004, SynchronizationConstants.LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f42435e == null) {
            return;
        }
        this.f42435e = null;
    }

    public synchronized void c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            synchronized (this) {
                if (this.f42433c != null) {
                    this.f42433c.setCarInfoWindowView(view);
                    return;
                }
                if (this.l != null) {
                    this.l.c(1004, SynchronizationConstants.LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID);
                }
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : invokeV.intValue;
    }

    public RoleOptions e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f42432b : (RoleOptions) invokeV.objValue;
    }

    public DisplayOptions f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f42433c : (DisplayOptions) invokeV.objValue;
    }

    public BlockingQueue<SyncResponseResult> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f42434d : (BlockingQueue) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m = false;
            this.n = 0.0f;
            this.o = 0L;
            this.f42440j.removeCallbacksAndMessages(null);
            this.f42439i.quit();
        }
    }
}
