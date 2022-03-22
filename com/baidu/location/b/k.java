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
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;
    public static long j = 12000;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25951b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f25952c;

    /* renamed from: d  reason: collision with root package name */
    public LocationClient f25953d;

    /* renamed from: e  reason: collision with root package name */
    public a f25954e;

    /* renamed from: f  reason: collision with root package name */
    public List<b> f25955f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25956g;

    /* renamed from: h  reason: collision with root package name */
    public long f25957h;
    public BDLocation i;
    public f k;
    public boolean l;

    /* renamed from: com.baidu.location.b.k$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k kVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, looper};
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
            this.a = kVar;
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
                if (this.a.l) {
                    this.a.f25954e.removeCallbacks(this.a.k);
                    this.a.l = false;
                }
                if (this.a.f25955f == null || this.a.f25955f.size() <= 0) {
                    return;
                }
                Iterator it = this.a.f25955f.iterator();
                while (it.hasNext()) {
                    try {
                        b bVar = (b) it.next();
                        if (bVar.b() != null) {
                            this.a.f25952c.loadUrl("javascript:" + bVar.b() + "('" + str + "')");
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
                        if (this.a.f25955f != null) {
                            this.a.f25955f.add(bVar);
                        }
                        if (this.a.f25953d == null) {
                            return;
                        }
                        if (this.a.f25953d.requestLocation() != 0) {
                            long currentTimeMillis = System.currentTimeMillis() - this.a.f25957h;
                            if (this.a.i != null && currentTimeMillis <= 10000) {
                                Message obtainMessage = this.a.f25954e.obtainMessage(2);
                                obtainMessage.obj = this.a.i;
                                obtainMessage.sendToTarget();
                                z = false;
                                if (z) {
                                    return;
                                }
                                if (this.a.l) {
                                    this.a.f25954e.removeCallbacks(this.a.k);
                                    this.a.l = false;
                                }
                                if (this.a.k == null) {
                                    k kVar = this.a;
                                    kVar.k = new f(kVar, null);
                                }
                                this.a.f25954e.postDelayed(this.a.k, k.j);
                                this.a.l = true;
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
                        if (this.a.f25955f == null) {
                            this.a.f25955f = new ArrayList();
                        } else {
                            this.a.f25955f.clear();
                        }
                        this.a.f25953d.registerLocationListener(this.a.a);
                        return;
                    case 4:
                        if (this.a.f25955f != null) {
                            this.a.f25955f.clear();
                            this.a.f25955f = null;
                        }
                        this.a.f25953d.unRegisterLocationListener(this.a.a);
                        this.a.f25957h = 0L;
                        this.a.i = null;
                        if (this.a.k != null && this.a.l) {
                            this.a.f25954e.removeCallbacks(this.a.k);
                        }
                        this.a.l = false;
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

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* renamed from: b  reason: collision with root package name */
        public String f25958b;

        /* renamed from: c  reason: collision with root package name */
        public String f25959c;

        /* renamed from: d  reason: collision with root package name */
        public long f25960d;

        public b(k kVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
            this.f25958b = null;
            this.f25959c = null;
            this.f25960d = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("action")) {
                    this.f25958b = jSONObject.getString("action");
                }
                if (jSONObject.has(WebChromeClient.KEY_ARG_CALLBACK)) {
                    this.f25959c = jSONObject.getString(WebChromeClient.KEY_ARG_CALLBACK);
                }
                if (jSONObject.has("timeout")) {
                    long j = jSONObject.getLong("timeout");
                    if (j >= 1000) {
                        long unused = k.j = j;
                    }
                }
                this.f25960d = System.currentTimeMillis();
            } catch (Exception unused2) {
                this.f25958b = null;
                this.f25959c = null;
            }
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25958b : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25959c : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final k a;
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
            a = new k(null);
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public d(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        public /* synthetic */ d(k kVar, AnonymousClass1 anonymousClass1) {
            this(kVar);
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && this.a.f25956g) {
                b bVar = new b(this.a, str);
                if (bVar.a() == null || !bVar.a().equals("requestLoc") || this.a.f25954e == null) {
                    return;
                }
                Message obtainMessage = this.a.f25954e.obtainMessage(1);
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

    /* loaded from: classes4.dex */
    public class e extends BDAbstractLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public e(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Message obtainMessage;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) && this.a.f25956g && bDLocation != null) {
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
                    this.a.f25957h = System.currentTimeMillis();
                    this.a.i = new BDLocation(bDLocation2);
                    obtainMessage = this.a.f25954e.obtainMessage(2);
                    obtainMessage.obj = bDLocation2;
                } else {
                    obtainMessage = this.a.f25954e.obtainMessage(5);
                }
                obtainMessage.sendToTarget();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public f(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        public /* synthetic */ f(k kVar, AnonymousClass1 anonymousClass1) {
            this(kVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l = false;
                this.a.f25954e.obtainMessage(6).sendToTarget();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25951b = null;
        this.f25953d = null;
        this.a = new e(this);
        this.f25954e = null;
        this.f25955f = null;
        this.f25956g = false;
        this.f25957h = 0L;
        this.i = null;
        this.k = null;
        this.l = false;
    }

    public /* synthetic */ k(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c.a : (k) invokeV.objValue;
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
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, webView, locationClient) == null) || this.f25956g || Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return;
        }
        this.f25951b = context;
        this.f25952c = webView;
        this.f25953d = locationClient;
        a aVar = new a(this, Looper.getMainLooper());
        this.f25954e = aVar;
        aVar.obtainMessage(3).sendToTarget();
        webView.getSettings().setJavaScriptEnabled(true);
        a(this.f25952c);
        this.f25956g = true;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f25956g) {
            this.f25954e.obtainMessage(4).sendToTarget();
            this.f25956g = false;
        }
    }
}
