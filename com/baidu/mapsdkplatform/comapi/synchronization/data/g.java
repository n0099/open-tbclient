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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "g";
    public transient /* synthetic */ FieldHolder $fh;
    public RoleOptions b;
    public DisplayOptions c;
    public BlockingQueue<SyncResponseResult> d;
    public i e;
    public String f;
    public String g;
    public com.baidu.mapsdkplatform.comapi.synchronization.c.a h;
    public HandlerThread i;
    public b j;
    public volatile int k;
    public k l;
    public boolean m;
    public float n;
    public long o;
    public int p;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final g a;
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
            a = new g(null);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 100000:
                        SyncResponseResult b = this.a.b((String) message.obj);
                        if (b == null) {
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(g.a, "parser response data is null");
                            return;
                        }
                        this.a.a(b);
                        this.a.j();
                        this.a.b(b);
                        return;
                    case 100001:
                        this.a.k();
                        return;
                    default:
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(g.a, "Undefined message type");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new LinkedBlockingQueue();
        this.f = String.valueOf(0);
        this.g = String.valueOf(0);
        this.h = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
        this.k = 0;
        this.m = false;
        this.n = 0.0f;
        this.o = 0L;
        this.p = 0;
    }

    public /* synthetic */ g(h hVar) {
        this();
    }

    private f a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i)) == null) {
            if (this.b == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "RoleOptions is null");
                return null;
            }
            f fVar = new f();
            fVar.a(this.b.getOrderId());
            fVar.b(this.b.getDriverId());
            fVar.c(this.b.getUserId());
            fVar.a(i);
            if (this.m) {
                this.f = String.valueOf(0);
                this.g = String.valueOf(0);
            }
            fVar.d(this.f);
            fVar.e(this.g);
            return fVar;
        }
        return (f) invokeI.objValue;
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.a : (g) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SyncResponseResult syncResponseResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, syncResponseResult) == null) {
            if (this.d == null) {
                this.d = new LinkedBlockingQueue();
            }
            if (this.m) {
                this.m = false;
                this.d.clear();
            }
            try {
                this.d.put(syncResponseResult);
            } catch (InterruptedException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "InterruptedException happened when put item into queue", e);
                Thread.currentThread().interrupt();
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.c.a aVar = this.h;
            if (aVar == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "HttpClient cannot be null");
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
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There's no section route data");
                return;
            }
            String[] split2 = split[0].split(",");
            if (2 != split2.length) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Section start position latlng invalid: " + split[0]);
                return;
            }
            LatLng latLng2 = null;
            try {
                latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
            } catch (NumberFormatException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get startPosition failed", e);
                latLng = null;
            }
            for (int i = 1; i < split.length; i++) {
                RouteLineInfo.RouteSectionInfo routeSectionInfo = new RouteLineInfo.RouteSectionInfo();
                routeSectionInfo.a(latLng);
                String[] split3 = split[i].split(",");
                if (2 != split3.length) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Section position latlng invalid: " + split[i]);
                } else {
                    try {
                        latLng2 = new LatLng(Double.valueOf(split3[1]).doubleValue(), Double.valueOf(split3[0]).doubleValue());
                    } catch (NumberFormatException e2) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get endPosition failed", e2);
                    }
                    routeSectionInfo.b(latLng2);
                    syncResponseResult.a().a(routeSectionInfo);
                    latLng = latLng2;
                }
            }
        }
    }

    private void a(JSONArray jSONArray, SyncResponseResult syncResponseResult) {
        double d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, jSONArray, syncResponseResult) == null) {
            JSONObject optJSONObject = jSONArray.optJSONObject(jSONArray.length() - 1);
            if (optJSONObject == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Invalid driver position data");
                return;
            }
            syncResponseResult.c().setTimeStamp(optJSONObject.optString("t"));
            String optString = optJSONObject.optString("p");
            if (optString == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No position info data");
                return;
            }
            String[] split = optString.split(";");
            if (split.length == 0) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Position info array is empty");
                return;
            }
            int i = 0;
            String[] split2 = split[0].split(",");
            if (2 != split2.length) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Position latlng invalid");
                return;
            }
            LatLng latLng = null;
            try {
                latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
            } catch (NumberFormatException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get driver position failed", e);
            }
            syncResponseResult.c().setPoint(latLng);
            double d2 = 0.0d;
            try {
                d = Double.valueOf(split[1]).doubleValue();
            } catch (NumberFormatException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get angle failed", e2);
                d = 0.0d;
            }
            syncResponseResult.c().setAngle(d);
            try {
                d2 = Double.valueOf(split[2]).doubleValue();
            } catch (NumberFormatException e3) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get speed failed", e3);
            }
            syncResponseResult.c().setSpeed(d2);
            try {
                i = Integer.valueOf(split[3]).intValue();
            } catch (NumberFormatException e4) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get orderStateInPosition failed", e4);
            }
            syncResponseResult.c().setOrderStateInPosition(i);
        }
    }

    private void a(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, jSONObject, syncResponseResult) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject != null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "parser route data");
                b(optJSONObject, syncResponseResult);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("traffic");
            if (optJSONObject2 != null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "parser traffic data");
                c(optJSONObject2, syncResponseResult);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("positions");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                this.l.c(2004, SynchronizationConstants.LBS_STATUS_MESSAGE_QUERY_TRACK_DRIVER_POSITION_FAILED);
            } else {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "parser driver position data");
                a(optJSONArray, syncResponseResult);
            }
            String optString = jSONObject.optString("run");
            if (!TextUtils.isEmpty(optString)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "parser travelled distance and elapsed time data");
                c(optString, syncResponseResult);
            }
            String optString2 = jSONObject.optString("remain");
            if (!TextUtils.isEmpty(optString2)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "parser remain distance and estimated time data");
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
        int i = gVar.k;
        gVar.k = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SyncResponseResult b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Response result is null");
                return null;
            }
            SyncResponseResult syncResponseResult = new SyncResponseResult();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!a(jSONObject)) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Response result is invalid");
                    return null;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    a(optJSONObject, syncResponseResult);
                    return syncResponseResult;
                }
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No route and traffic and driver data");
                return null;
            } catch (JSONException unused) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "JSONException happened when parser");
                return null;
            }
        }
        return (SyncResponseResult) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SyncResponseResult syncResponseResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, syncResponseResult) == null) {
            float d = syncResponseResult.d();
            long e = syncResponseResult.e();
            int i = this.p;
            if (1 == i || 2 == i || 4 == i) {
                if (this.p != 1 && this.m) {
                    this.n = 0.0f;
                    this.o = 0L;
                    e = 0;
                    d = 0.0f;
                }
                if (0.0f != d) {
                    this.n = d;
                }
                if (0 != e) {
                    this.o = e;
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
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, this, str, syncResponseResult) == null) {
            String[] split = str.split(";");
            if (split.length == 0) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There's no section traffic data");
                return;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (String str2 : split) {
                String[] split2 = str2.split(",");
                if (3 != split2.length) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "section traffic data is invalid: " + str2);
                } else {
                    try {
                        i = Integer.valueOf(split2[0]).intValue();
                        try {
                            i2 = Integer.valueOf(split2[1]).intValue();
                        } catch (NumberFormatException e) {
                            e = e;
                            i2 = 0;
                            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get traffic status info failed", e);
                            i3 = 0;
                            while (i4 < i + i2) {
                            }
                            syncResponseResult.b().a(arrayList);
                        }
                    } catch (NumberFormatException e2) {
                        e = e2;
                        i = 0;
                    }
                    try {
                        i3 = Integer.valueOf(split2[2]).intValue();
                    } catch (NumberFormatException e3) {
                        e = e3;
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get traffic status info failed", e);
                        i3 = 0;
                        while (i4 < i + i2) {
                        }
                        syncResponseResult.b().a(arrayList);
                    }
                    for (i4 = i; i4 < i + i2; i4++) {
                        arrayList.add(Integer.valueOf(i3));
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
            this.f = jSONObject.optString("f");
            syncResponseResult.a().a(this.f);
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
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The travelled data is null or invalid");
                return;
            }
            float f = 0.0f;
            try {
                f = Float.valueOf(split[0]).floatValue();
            } catch (NumberFormatException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get travelledDistance failed", e);
            }
            syncResponseResult.a(f);
            long j = 0;
            try {
                j = Long.valueOf(split[1]).longValue();
            } catch (NumberFormatException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get elapsedTime failed", e2);
            }
            syncResponseResult.a(j);
        }
    }

    private void c(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, jSONObject, syncResponseResult) == null) {
            syncResponseResult.b().a(jSONObject.optInt("c") != 0);
            this.g = jSONObject.optString("f");
            syncResponseResult.b().a(this.g);
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
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The remain data is null or invalid: ");
                return;
            }
            float f = 0.0f;
            try {
                f = Float.valueOf(split[0]).floatValue();
            } catch (NumberFormatException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get remainDistance failed", e);
            }
            syncResponseResult.b(f);
            long j = 0;
            try {
                j = Long.valueOf(split[1]).longValue();
            } catch (NumberFormatException e2) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get estimatedTime failed", e2);
            }
            syncResponseResult.b(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || (iVar = this.e) == null) {
            return;
        }
        iVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65564, this) == null) || (iVar = this.e) == null) {
            return;
        }
        iVar.b();
    }

    public void a(int i, boolean z) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.m = z;
            this.p = i;
            f a2 = a(i);
            if (a2 == null) {
                str = a;
                str2 = "Data request option is null";
            } else {
                String a3 = new m(a2).a();
                if (a3 != null) {
                    a(a3);
                    return;
                } else {
                    str = a;
                    str2 = "send url string is null";
                }
            }
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, str2);
        }
    }

    public synchronized void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.c.setStartPositionInfoWindowView(view2);
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
                this.c = displayOptions;
            }
        }
    }

    public synchronized void a(RoleOptions roleOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, roleOptions) == null) {
            synchronized (this) {
                this.b = roleOptions;
            }
        }
    }

    public void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
            this.e = iVar;
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
            this.i = handlerThread;
            handlerThread.start();
            this.j = new b(this, this.i.getLooper());
        }
    }

    public synchronized void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.c.setEndPositionInfoWindowView(view2);
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.e == null) {
            return;
        }
        this.e = null;
    }

    public synchronized void c(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.c.setCarInfoWindowView(view2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b : (RoleOptions) invokeV.objValue;
    }

    public DisplayOptions f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c : (DisplayOptions) invokeV.objValue;
    }

    public BlockingQueue<SyncResponseResult> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.d : (BlockingQueue) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m = false;
            this.n = 0.0f;
            this.o = 0L;
            this.j.removeCallbacksAndMessages(null);
            this.i.quit();
        }
    }
}
