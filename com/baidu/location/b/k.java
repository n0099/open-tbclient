package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static long f41154j = 12000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f41155a;

    /* renamed from: b  reason: collision with root package name */
    public Context f41156b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f41157c;

    /* renamed from: d  reason: collision with root package name */
    public LocationClient f41158d;

    /* renamed from: e  reason: collision with root package name */
    public a f41159e;

    /* renamed from: f  reason: collision with root package name */
    public List<b> f41160f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41161g;

    /* renamed from: h  reason: collision with root package name */
    public long f41162h;

    /* renamed from: i  reason: collision with root package name */
    public BDLocation f41163i;
    public f k;
    public boolean l;

    /* renamed from: com.baidu.location.b.k$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f41164a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k kVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, looper};
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
            this.f41164a = kVar;
        }

        private String a(BDLocation bDLocation) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bDLocation)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("latitude", bDLocation.getLatitude());
                    jSONObject.put("longitude", bDLocation.getLongitude());
                    jSONObject.put("radius", bDLocation.getRadius());
                    jSONObject.put("errorcode", 1);
                    if (bDLocation.hasAltitude()) {
                        jSONObject.put("altitude", bDLocation.getAltitude());
                    }
                    if (bDLocation.hasSpeed()) {
                        jSONObject.put("speed", bDLocation.getSpeed() / 3.6f);
                    }
                    if (bDLocation.getLocType() == 61) {
                        jSONObject.put("direction", bDLocation.getDirection());
                    }
                    if (bDLocation.getBuildingName() != null) {
                        jSONObject.put("buildingname", bDLocation.getBuildingName());
                    }
                    if (bDLocation.getBuildingID() != null) {
                        jSONObject.put("buildingid", bDLocation.getBuildingID());
                    }
                    if (bDLocation.getFloor() != null) {
                        jSONObject.put("floor", bDLocation.getFloor());
                    }
                    return jSONObject.toString();
                } catch (Exception unused) {
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        private void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
                if (this.f41164a.l) {
                    this.f41164a.f41159e.removeCallbacks(this.f41164a.k);
                    this.f41164a.l = false;
                }
                if (this.f41164a.f41160f == null || this.f41164a.f41160f.size() <= 0) {
                    return;
                }
                Iterator it = this.f41164a.f41160f.iterator();
                while (it.hasNext()) {
                    try {
                        b bVar = (b) it.next();
                        if (bVar.b() != null) {
                            this.f41164a.f41157c.loadUrl("javascript:" + bVar.b() + "('" + str + "')");
                        }
                        it.remove();
                    } catch (Exception unused) {
                        return;
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                String str = null;
                switch (message.what) {
                    case 1:
                        b bVar = (b) message.obj;
                        if (this.f41164a.f41160f != null) {
                            this.f41164a.f41160f.add(bVar);
                        }
                        if (this.f41164a.f41158d == null) {
                            return;
                        }
                        if (this.f41164a.f41158d.requestLocation() != 0) {
                            long currentTimeMillis = System.currentTimeMillis() - this.f41164a.f41162h;
                            if (this.f41164a.f41163i != null && currentTimeMillis <= 10000) {
                                Message obtainMessage = this.f41164a.f41159e.obtainMessage(2);
                                obtainMessage.obj = this.f41164a.f41163i;
                                obtainMessage.sendToTarget();
                                z = false;
                                if (z) {
                                    return;
                                }
                                if (this.f41164a.l) {
                                    this.f41164a.f41159e.removeCallbacks(this.f41164a.k);
                                    this.f41164a.l = false;
                                }
                                if (this.f41164a.k == null) {
                                    k kVar = this.f41164a;
                                    kVar.k = new f(kVar, null);
                                }
                                this.f41164a.f41159e.postDelayed(this.f41164a.k, k.f41154j);
                                this.f41164a.l = true;
                                return;
                            }
                        }
                        z = true;
                        if (z) {
                        }
                        break;
                    case 2:
                        a(a((BDLocation) message.obj));
                        return;
                    case 3:
                        if (this.f41164a.f41160f == null) {
                            this.f41164a.f41160f = new ArrayList();
                        } else {
                            this.f41164a.f41160f.clear();
                        }
                        this.f41164a.f41158d.registerLocationListener(this.f41164a.f41155a);
                        return;
                    case 4:
                        if (this.f41164a.f41160f != null) {
                            this.f41164a.f41160f.clear();
                            this.f41164a.f41160f = null;
                        }
                        this.f41164a.f41158d.unRegisterLocationListener(this.f41164a.f41155a);
                        this.f41164a.f41162h = 0L;
                        this.f41164a.f41163i = null;
                        if (this.f41164a.k != null && this.f41164a.l) {
                            this.f41164a.f41159e.removeCallbacks(this.f41164a.k);
                        }
                        this.f41164a.l = false;
                        return;
                    case 5:
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errorcode", 0);
                            str = jSONObject.toString();
                        } catch (Exception unused) {
                        }
                        if (str == null) {
                            return;
                        }
                        break;
                    case 6:
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("errorcode", 2);
                            str = jSONObject2.toString();
                        } catch (Exception unused2) {
                        }
                        if (str == null) {
                            return;
                        }
                        break;
                    default:
                        return;
                }
                a(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f41165a;

        /* renamed from: b  reason: collision with root package name */
        public String f41166b;

        /* renamed from: c  reason: collision with root package name */
        public String f41167c;

        /* renamed from: d  reason: collision with root package name */
        public long f41168d;

        public b(k kVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41165a = kVar;
            this.f41166b = null;
            this.f41167c = null;
            this.f41168d = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("action")) {
                    this.f41166b = jSONObject.getString("action");
                }
                if (jSONObject.has("callback")) {
                    this.f41167c = jSONObject.getString("callback");
                }
                if (jSONObject.has("timeout")) {
                    long j2 = jSONObject.getLong("timeout");
                    if (j2 >= 1000) {
                        long unused = k.f41154j = j2;
                    }
                }
                this.f41168d = System.currentTimeMillis();
            } catch (Exception unused2) {
                this.f41166b = null;
                this.f41167c = null;
            }
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41166b : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41167c : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final k f41169a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(819941226, "Lcom/baidu/location/b/k$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(819941226, "Lcom/baidu/location/b/k$c;");
                    return;
                }
            }
            f41169a = new k(null);
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f41170a;

        public d(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41170a = kVar;
        }

        public /* synthetic */ d(k kVar, AnonymousClass1 anonymousClass1) {
            this(kVar);
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && this.f41170a.f41161g) {
                b bVar = new b(this.f41170a, str);
                if (bVar.a() == null || !bVar.a().equals("requestLoc") || this.f41170a.f41159e == null) {
                    return;
                }
                Message obtainMessage = this.f41170a.f41159e.obtainMessage(1);
                obtainMessage.obj = bVar;
                obtainMessage.sendToTarget();
            }
        }

        @JavascriptInterface
        public void showLog(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends BDAbstractLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f41171a;

        public e(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41171a = kVar;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Message obtainMessage;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) && this.f41171a.f41161g && bDLocation != null) {
                BDLocation bDLocation2 = new BDLocation(bDLocation);
                int locType = bDLocation2.getLocType();
                String coorType = bDLocation2.getCoorType();
                if (locType == 61 || locType == 161 || locType == 66) {
                    if (coorType != null) {
                        if (coorType.equals("gcj02")) {
                            bDLocation2 = LocationClient.getBDLocationInCoorType(bDLocation2, "gcj2wgs");
                        } else {
                            if (coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                                str = BDLocation.BDLOCATION_BD09_TO_GCJ02;
                            } else if (coorType.equals("bd09ll")) {
                                str = BDLocation.BDLOCATION_BD09LL_TO_GCJ02;
                            }
                            bDLocation2 = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation2, str), "gcj2wgs");
                        }
                    }
                    this.f41171a.f41162h = System.currentTimeMillis();
                    this.f41171a.f41163i = new BDLocation(bDLocation2);
                    obtainMessage = this.f41171a.f41159e.obtainMessage(2);
                    obtainMessage.obj = bDLocation2;
                } else {
                    obtainMessage = this.f41171a.f41159e.obtainMessage(5);
                }
                obtainMessage.sendToTarget();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f41172a;

        public f(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41172a = kVar;
        }

        public /* synthetic */ f(k kVar, AnonymousClass1 anonymousClass1) {
            this(kVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41172a.l = false;
                this.f41172a.f41159e.obtainMessage(6).sendToTarget();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037723593, "Lcom/baidu/location/b/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037723593, "Lcom/baidu/location/b/k;");
        }
    }

    public k() {
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
        this.f41156b = null;
        this.f41158d = null;
        this.f41155a = new e(this);
        this.f41159e = null;
        this.f41160f = null;
        this.f41161g = false;
        this.f41162h = 0L;
        this.f41163i = null;
        this.k = null;
        this.l = false;
    }

    public /* synthetic */ k(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c.f41169a : (k) invokeV.objValue;
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    private void a(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, webView) == null) {
            webView.addJavascriptInterface(new d(this, null), "BaiduLocAssistant");
        }
    }

    public void a(Context context, WebView webView, LocationClient locationClient) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, webView, locationClient) == null) || this.f41161g || Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return;
        }
        this.f41156b = context;
        this.f41157c = webView;
        this.f41158d = locationClient;
        a aVar = new a(this, Looper.getMainLooper());
        this.f41159e = aVar;
        aVar.obtainMessage(3).sendToTarget();
        webView.getSettings().setJavaScriptEnabled(true);
        a(this.f41157c);
        this.f41161g = true;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f41161g) {
            this.f41159e.obtainMessage(4).sendToTarget();
            this.f41161g = false;
        }
    }
}
