package com.baidu.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.Address;
import com.baidu.location.e.k;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class BDLocation implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_COOR_TYPE_BD09LL = "bd09";
    public static final String BDLOCATION_COOR_TYPE_BD09MC = "bd09mc";
    public static final String BDLOCATION_COOR_TYPE_GCJ02 = "gcj02";
    public static final String BDLOCATION_COOR_TYPE_GCJ03 = "gcj03";
    public static final String BDLOCATION_COOR_TYPE_WGS84 = "wgs84";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final String BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU = "bd_beidou";
    public static final String BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM = "system";
    public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
    public static final Parcelable.Creator<BDLocation> CREATOR;
    public static final int GPS_ACCURACY_BAD = 3;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_MID = 2;
    public static final int GPS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_RECTIFY_INDOOR = 1;
    public static final int GPS_RECTIFY_NONE = 0;
    public static final int GPS_RECTIFY_OUTDOOR = 2;
    public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
    public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
    public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
    public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
    public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
    public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
    public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
    public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
    public static final int INDOOR_NETWORK_STATE_HIGH = 2;
    public static final int INDOOR_NETWORK_STATE_LOW = 0;
    public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int MOCK_GPS_PROBABILITY_HIGH = 3;
    public static final int MOCK_GPS_PROBABILITY_LOW = 1;
    public static final int MOCK_GPS_PROBABILITY_MIDDLE = 2;
    public static final int MOCK_GPS_PROBABILITY_UNKNOW = -1;
    public static final int MOCK_GPS_PROBABILITY_ZERO = 0;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TYPE_BMS_HD_LOCATION = 602;
    public static final int TYPE_CLOSE_LOCATION_SERVICE_SWITCH_FAIL = 69;
    public static final int TYPE_HD_LOCATION = 601;
    public static final int TYPE_NO_PERMISSION_AND_CLOSE_SWITCH_FAIL = 71;
    public static final int TYPE_NO_PERMISSION_LOCATION_FAIL = 70;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerCheckKeyError = 505;
    public static final int TypeServerDecryptError = 162;
    public static final int TypeServerError = 167;
    public static final int USER_INDDOR_TRUE = 1;
    public static final int USER_INDOOR_FALSE = 0;
    public static final int USER_INDOOR_UNKNOW = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public double C;
    public boolean D;
    public int E;
    public int F;
    public String G;
    public int H;
    public String I;
    public int J;
    public int K;
    public int L;
    public int M;
    public String N;
    public String O;
    public String P;
    public int Q;
    public List<Poi> R;
    public String S;

    /* renamed from: T  reason: collision with root package name */
    public String f1039T;
    public String U;
    public Bundle V;
    public int W;
    public int X;
    public long Y;
    public String Z;
    public int a;
    public String aa;
    public double ab;
    public double ac;
    public boolean ad;
    public PoiRegion ae;
    public float af;
    public double ag;
    public int ah;
    public int ai;
    public BDLocation aj;
    public Bundle ak;
    public String al;
    public long am;
    public String b;
    public double c;
    public double d;
    public boolean e;
    public double f;
    public boolean g;
    public float h;
    public boolean i;
    public float j;
    public String k;
    public float l;
    public int m;
    public float n;
    public boolean o;
    public int p;
    public float q;
    public String r;
    public boolean s;
    public String t;
    public String u;
    public String v;
    public String w;
    public boolean x;
    public Address y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(902208952, "Lcom/baidu/location/BDLocation;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(902208952, "Lcom/baidu/location/BDLocation;");
                return;
            }
        }
        CREATOR = new a();
    }

    public BDLocation() {
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
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = new Address.Builder().build();
        this.z = null;
        this.A = null;
        this.B = null;
        this.D = false;
        this.E = 0;
        this.F = 1;
        this.G = null;
        this.I = "";
        this.J = -1;
        this.K = 0;
        this.L = 2;
        this.M = 0;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = -1;
        this.R = null;
        this.S = null;
        this.f1039T = null;
        this.U = null;
        this.V = new Bundle();
        this.W = 0;
        this.X = 0;
        this.Y = 0L;
        this.Z = null;
        this.aa = null;
        this.ab = Double.MIN_VALUE;
        this.ac = Double.MIN_VALUE;
        this.ad = false;
        this.ae = null;
        this.af = -1.0f;
        this.ag = -1.0d;
        this.ah = 0;
        this.ai = -1;
        this.ak = null;
        this.al = null;
        this.am = -1L;
    }

    public BDLocation(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = new Address.Builder().build();
        this.z = null;
        this.A = null;
        this.B = null;
        this.D = false;
        this.E = 0;
        this.F = 1;
        this.G = null;
        this.I = "";
        this.J = -1;
        this.K = 0;
        this.L = 2;
        this.M = 0;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = -1;
        this.R = null;
        this.S = null;
        this.f1039T = null;
        this.U = null;
        this.V = new Bundle();
        this.W = 0;
        this.X = 0;
        this.Y = 0L;
        this.Z = null;
        this.aa = null;
        this.ab = Double.MIN_VALUE;
        this.ac = Double.MIN_VALUE;
        this.ad = false;
        this.ae = null;
        this.af = -1.0f;
        this.ag = -1.0d;
        this.ah = 0;
        this.ai = -1;
        this.ak = null;
        this.al = null;
        this.am = -1L;
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.am = parcel.readLong();
        this.c = parcel.readDouble();
        this.d = parcel.readDouble();
        this.f = parcel.readDouble();
        this.h = parcel.readFloat();
        this.j = parcel.readFloat();
        this.k = parcel.readString();
        this.l = parcel.readFloat();
        this.m = parcel.readInt();
        this.n = parcel.readFloat();
        this.p = parcel.readInt();
        this.q = parcel.readFloat();
        this.z = parcel.readString();
        this.E = parcel.readInt();
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readDouble();
        this.G = parcel.readString();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        parcel.readString();
        String readString7 = parcel.readString();
        String readString8 = parcel.readString();
        this.y = new Address.Builder().country(readString7).countryCode(readString8).province(readString).city(readString2).cityCode(readString6).district(readString3).street(readString4).streetNumber(readString5).adcode(parcel.readString()).town(parcel.readString()).build();
        boolean[] zArr = new boolean[8];
        this.H = parcel.readInt();
        this.I = parcel.readString();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.F = parcel.readInt();
        this.S = parcel.readString();
        this.J = parcel.readInt();
        this.K = parcel.readInt();
        this.L = parcel.readInt();
        this.M = parcel.readInt();
        this.N = parcel.readString();
        this.O = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readInt();
        this.W = parcel.readInt();
        this.f1039T = parcel.readString();
        this.X = parcel.readInt();
        this.U = parcel.readString();
        this.Z = parcel.readString();
        this.aa = parcel.readString();
        this.Y = parcel.readLong();
        this.ab = parcel.readDouble();
        this.ac = parcel.readDouble();
        this.af = parcel.readFloat();
        this.ag = parcel.readDouble();
        this.ah = parcel.readInt();
        this.ai = parcel.readInt();
        this.r = parcel.readString();
        this.al = parcel.readString();
        try {
            this.aj = (BDLocation) parcel.readParcelable(BDLocation.class.getClassLoader());
        } catch (Exception e) {
            this.aj = null;
            e.printStackTrace();
        }
        try {
            parcel.readBooleanArray(zArr);
            this.e = zArr[0];
            this.g = zArr[1];
            this.i = zArr[2];
            this.o = zArr[3];
            this.s = zArr[4];
            this.x = zArr[5];
            this.D = zArr[6];
            this.ad = zArr[7];
        } catch (Exception unused) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            parcel.readList(arrayList, Poi.class.getClassLoader());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (arrayList.size() == 0) {
            this.R = null;
        } else {
            this.R = arrayList;
        }
        try {
            this.V = parcel.readBundle();
        } catch (Exception e3) {
            e3.printStackTrace();
            this.V = new Bundle();
        }
        try {
            this.ak = parcel.readBundle();
        } catch (Exception e4) {
            e4.printStackTrace();
            this.ak = new Bundle();
        }
        try {
            this.ae = (PoiRegion) parcel.readParcelable(PoiRegion.class.getClassLoader());
        } catch (Exception e5) {
            this.ae = null;
            e5.printStackTrace();
        }
    }

    public /* synthetic */ BDLocation(Parcel parcel, a aVar) {
        this(parcel);
    }

    public BDLocation(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bDLocation};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.a = 0;
        ArrayList arrayList = null;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = new Address.Builder().build();
        this.z = null;
        this.A = null;
        this.B = null;
        this.D = false;
        this.E = 0;
        this.F = 1;
        this.G = null;
        this.I = "";
        this.J = -1;
        this.K = 0;
        this.L = 2;
        this.M = 0;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = -1;
        this.R = null;
        this.S = null;
        this.f1039T = null;
        this.U = null;
        this.V = new Bundle();
        this.W = 0;
        this.X = 0;
        this.Y = 0L;
        this.Z = null;
        this.aa = null;
        this.ab = Double.MIN_VALUE;
        this.ac = Double.MIN_VALUE;
        this.ad = false;
        this.ae = null;
        this.af = -1.0f;
        this.ag = -1.0d;
        this.ah = 0;
        this.ai = -1;
        this.ak = null;
        this.al = null;
        this.am = -1L;
        this.a = bDLocation.a;
        this.b = bDLocation.b;
        this.am = bDLocation.am;
        this.c = bDLocation.c;
        this.d = bDLocation.d;
        this.e = bDLocation.e;
        this.f = bDLocation.f;
        this.g = bDLocation.g;
        this.h = bDLocation.h;
        this.i = bDLocation.i;
        this.j = bDLocation.j;
        this.k = bDLocation.k;
        this.l = bDLocation.l;
        this.m = bDLocation.m;
        this.n = bDLocation.n;
        this.o = bDLocation.o;
        this.p = bDLocation.p;
        this.q = bDLocation.q;
        this.r = bDLocation.r;
        this.s = bDLocation.s;
        this.t = bDLocation.t;
        this.x = bDLocation.x;
        this.y = new Address.Builder().country(bDLocation.y.country).countryCode(bDLocation.y.countryCode).province(bDLocation.y.province).city(bDLocation.y.city).cityCode(bDLocation.y.cityCode).district(bDLocation.y.district).street(bDLocation.y.street).streetNumber(bDLocation.y.streetNumber).adcode(bDLocation.y.adcode).town(bDLocation.y.town).build();
        this.z = bDLocation.z;
        this.A = bDLocation.A;
        this.B = bDLocation.B;
        this.C = bDLocation.C;
        this.F = bDLocation.F;
        this.E = bDLocation.E;
        this.D = bDLocation.D;
        this.G = bDLocation.G;
        this.H = bDLocation.H;
        this.I = bDLocation.I;
        this.u = bDLocation.u;
        this.v = bDLocation.v;
        this.w = bDLocation.w;
        this.J = bDLocation.J;
        this.K = bDLocation.K;
        this.L = bDLocation.K;
        this.M = bDLocation.M;
        this.N = bDLocation.N;
        this.O = bDLocation.O;
        this.P = bDLocation.P;
        this.Q = bDLocation.Q;
        this.W = bDLocation.W;
        this.U = bDLocation.U;
        this.Z = bDLocation.Z;
        this.aa = bDLocation.aa;
        this.ab = bDLocation.ab;
        this.ac = bDLocation.ac;
        this.Y = bDLocation.Y;
        this.ag = bDLocation.ag;
        this.ah = bDLocation.ah;
        this.ai = bDLocation.ai;
        this.aj = bDLocation.aj;
        this.f1039T = bDLocation.f1039T;
        if (bDLocation.R != null) {
            arrayList = new ArrayList();
            for (int i3 = 0; i3 < bDLocation.R.size(); i3++) {
                Poi poi = bDLocation.R.get(i3);
                arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank(), poi.getTags(), poi.getAddr()));
            }
        }
        this.R = arrayList;
        this.S = bDLocation.S;
        this.V = bDLocation.V;
        this.X = bDLocation.X;
        this.ad = bDLocation.ad;
        this.ae = bDLocation.ae;
        this.af = bDLocation.af;
        this.ak = bDLocation.ak;
        this.al = bDLocation.al;
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x04b2 A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0505 A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x051e A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x053d A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0556 A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x056f A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0588 A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0598 A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x069b A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x06a5 A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TRY_LEAVE, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x06af A[Catch: Exception -> 0x06bf, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x06bb A[Catch: Exception -> 0x06bf, Error -> 0x07a9, TRY_LEAVE, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x06d1 A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x06e1 A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TRY_LEAVE, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0712 A[Catch: all -> 0x0715, TRY_LEAVE, TryCatch #14 {all -> 0x0715, blocks: (B:321:0x06eb, B:323:0x06f1, B:325:0x06f7, B:327:0x06fb, B:329:0x0712), top: B:395:0x06eb }] */
    /* JADX WARN: Removed duplicated region for block: B:375:0x05c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0722 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:415:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x023b A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02a4 A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02ba A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0301 A[Catch: Exception -> 0x07a5, Error -> 0x07a9, TryCatch #9 {Error -> 0x07a9, blocks: (B:9:0x00c3, B:10:0x00c5, B:13:0x00fd, B:15:0x0155, B:16:0x015e, B:18:0x0166, B:19:0x016f, B:21:0x0175, B:22:0x0181, B:23:0x0185, B:26:0x018c, B:27:0x0191, B:30:0x01a0, B:32:0x01cf, B:33:0x01d6, B:35:0x01dc, B:36:0x01e7, B:38:0x01ed, B:39:0x01f4, B:41:0x01fa, B:42:0x0205, B:45:0x020f, B:47:0x021d, B:49:0x0229, B:50:0x022c, B:52:0x0233, B:54:0x023b, B:55:0x024d, B:57:0x0253, B:59:0x0272, B:61:0x027e, B:63:0x0284, B:65:0x028d, B:66:0x029a, B:67:0x029c, B:69:0x02a4, B:71:0x02b0, B:72:0x02b2, B:74:0x02ba, B:76:0x02c8, B:78:0x02d0, B:80:0x02d8, B:82:0x02e0, B:84:0x02e9, B:86:0x02f2, B:87:0x02f9, B:89:0x0301, B:91:0x030d, B:93:0x0312, B:96:0x031a, B:100:0x0326, B:102:0x032e, B:104:0x0336, B:106:0x033e, B:108:0x0346, B:110:0x034e, B:112:0x0356, B:114:0x035e, B:116:0x0366, B:118:0x036e, B:120:0x037a, B:122:0x0382, B:124:0x038d, B:126:0x0396, B:128:0x03a2, B:130:0x03ab, B:132:0x03b7, B:134:0x03bf, B:136:0x03c7, B:138:0x03d0, B:219:0x04b2, B:222:0x04fd, B:224:0x0505, B:226:0x0513, B:227:0x0516, B:229:0x051e, B:231:0x052a, B:232:0x0535, B:234:0x053d, B:236:0x054b, B:237:0x054e, B:239:0x0556, B:241:0x0564, B:242:0x0567, B:244:0x056f, B:246:0x057d, B:247:0x0580, B:249:0x0588, B:250:0x0590, B:252:0x0598, B:254:0x05a4, B:255:0x05a8, B:258:0x05b1, B:259:0x05bb, B:261:0x05c3, B:263:0x05d1, B:265:0x05e1, B:268:0x05e9, B:269:0x05ec, B:271:0x05f5, B:272:0x0607, B:274:0x060f, B:275:0x0617, B:277:0x061f, B:278:0x0627, B:280:0x062f, B:281:0x0638, B:283:0x0640, B:285:0x0650, B:287:0x065a, B:289:0x065e, B:291:0x066c, B:293:0x0674, B:295:0x0680, B:296:0x0684, B:297:0x0689, B:302:0x0693, B:304:0x069b, B:306:0x06a9, B:308:0x06af, B:309:0x06bb, B:310:0x06bf, B:313:0x06c6, B:315:0x06d1, B:316:0x06d9, B:318:0x06e1, B:333:0x0717, B:334:0x071a, B:343:0x0750, B:305:0x06a5, B:301:0x0690, B:142:0x03fa, B:144:0x0405, B:148:0x040e, B:154:0x041b, B:162:0x0428, B:170:0x0435, B:178:0x0445, B:186:0x0455, B:194:0x0465, B:202:0x0477, B:216:0x049a, B:221:0x04f0, B:351:0x0764, B:352:0x0769), top: B:371:0x00c3 }] */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BDLocation(String str) {
        ?? r3;
        boolean z;
        Exception exc;
        String str2;
        String str3;
        JSONObject jSONObject;
        boolean z2;
        Exception exc2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        boolean z3;
        String str17;
        String str18;
        String str19;
        String str20;
        int i;
        int i2;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String string;
        String str26;
        String[] split;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65541, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = new Address.Builder().build();
        this.z = null;
        this.A = null;
        this.B = null;
        this.D = false;
        this.E = 0;
        this.F = 1;
        this.G = null;
        this.I = "";
        this.J = -1;
        this.K = 0;
        this.L = 2;
        this.M = 0;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = -1;
        this.R = null;
        this.S = null;
        this.f1039T = null;
        this.U = null;
        this.V = new Bundle();
        this.W = 0;
        this.X = 0;
        this.Y = 0L;
        this.Z = null;
        this.aa = null;
        this.ab = Double.MIN_VALUE;
        this.ac = Double.MIN_VALUE;
        this.ad = false;
        this.ae = null;
        this.af = -1.0f;
        this.ag = -1.0d;
        this.ah = 0;
        this.ai = -1;
        this.ak = null;
        this.al = null;
        this.am = -1L;
        if (str == null || str.equals("")) {
            return;
        }
        try {
            try {
            } catch (Exception e) {
                z = false;
                exc = e;
            }
        } catch (Error e2) {
            e2.printStackTrace();
            r3 = 0;
            this.a = r3;
            this.s = r3;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("result");
            int parseInt = Integer.parseInt(jSONObject3.getString("error"));
            setLocType(parseInt);
            setTime(jSONObject3.getString("time"));
            if (parseInt == 61) {
                JSONObject jSONObject4 = jSONObject2.getJSONObject("content");
                JSONObject jSONObject5 = jSONObject4.getJSONObject(Config.EVENT_HEAT_POINT);
                setLatitude(Double.parseDouble(jSONObject5.getString("y")));
                setLongitude(Double.parseDouble(jSONObject5.getString("x")));
                setRadius(Float.parseFloat(jSONObject4.getString("radius")));
                setSpeed(Float.parseFloat(jSONObject4.getString("s")));
                setDirection(Float.parseFloat(jSONObject4.getString("d")));
                setSatelliteNumber(Integer.parseInt(jSONObject4.getString("n")));
                if (jSONObject4.has("is_mock")) {
                    setMockGpsStrategy(jSONObject4.getInt("is_mock"));
                }
                if (jSONObject4.has("h")) {
                    try {
                        setAltitude(jSONObject4.getDouble("h"));
                    } catch (Exception unused) {
                    }
                }
                try {
                    if (jSONObject4.has("in_cn")) {
                        setLocationWhere(Integer.parseInt(jSONObject4.getString("in_cn")));
                    } else {
                        setLocationWhere(1);
                    }
                } catch (Exception unused2) {
                }
                if (this.F != 0) {
                    setCoorType("gcj02");
                    return;
                }
                str2 = "wgs84";
            } else {
                str2 = "gcj02";
                if (parseInt == 161) {
                    JSONObject jSONObject6 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject7 = jSONObject6.getJSONObject(Config.EVENT_HEAT_POINT);
                    setLatitude(Double.parseDouble(jSONObject7.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject7.getString("x")));
                    setRadius(Float.parseFloat(jSONObject6.getString("radius")));
                    if (jSONObject6.has("traffic")) {
                        setTraffic(jSONObject6.getString("traffic"));
                    }
                    if (jSONObject6.has("traffic_prop")) {
                        setTrafficConfidence(Float.parseFloat(jSONObject6.optString("traffic_prop")));
                    }
                    if (jSONObject6.has("is_station")) {
                        setIsTrafficStation(jSONObject6.optInt("is_station"));
                    }
                    if (jSONObject6.has("traffic_skip_prop")) {
                        setTrafficSkipProb(Float.parseFloat(jSONObject6.optString("traffic_skip_prop")));
                    }
                    if (jSONObject6.has("sema")) {
                        JSONObject jSONObject8 = jSONObject6.getJSONObject("sema");
                        if (jSONObject8.has("aptag")) {
                            String string2 = jSONObject8.getString("aptag");
                            if (TextUtils.isEmpty(string2)) {
                                str3 = "";
                                this.u = str3;
                                if (jSONObject8.has("aptagd")) {
                                    JSONArray jSONArray = jSONObject8.getJSONObject("aptagd").getJSONArray("pois");
                                    ArrayList arrayList = new ArrayList();
                                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                                        JSONObject jSONObject9 = jSONArray.getJSONObject(i5);
                                        arrayList.add(new Poi(jSONObject9.getString("pid"), jSONObject9.getString("pname"), jSONObject9.getDouble("pr"), jSONObject9.has("tags") ? jSONObject9.getString("tags") : str3, jSONObject9.has(DuPaBInfoMsg.B_ADDR) ? jSONObject9.getString(DuPaBInfoMsg.B_ADDR) : str3));
                                    }
                                    this.R = arrayList;
                                }
                                if (jSONObject8.has("poiregion")) {
                                    String string3 = jSONObject8.getString("poiregion");
                                    if (!TextUtils.isEmpty(string3)) {
                                        this.v = string3;
                                    }
                                }
                                if (jSONObject8.has("poi_regions")) {
                                    JSONObject jSONObject10 = jSONObject8.getJSONObject("poi_regions");
                                    this.ae = new PoiRegion(jSONObject10.has("direction_desc") ? jSONObject10.getString("direction_desc") : str3, jSONObject10.has("name") ? jSONObject10.getString("name") : str3, jSONObject10.has("tag") ? jSONObject10.getString("tag") : str3);
                                }
                                if (jSONObject8.has("regular")) {
                                    String string4 = jSONObject8.getString("regular");
                                    if (!TextUtils.isEmpty(string4)) {
                                        this.w = string4;
                                    }
                                }
                            } else {
                                this.u = string2;
                            }
                        }
                        str3 = "";
                        if (jSONObject8.has("aptagd")) {
                        }
                        if (jSONObject8.has("poiregion")) {
                        }
                        if (jSONObject8.has("poi_regions")) {
                        }
                        if (jSONObject8.has("regular")) {
                        }
                    } else {
                        str3 = "";
                    }
                    if (jSONObject6.has(DuPaBInfoMsg.B_ADDR)) {
                        try {
                            jSONObject = jSONObject6.getJSONObject(DuPaBInfoMsg.B_ADDR);
                            z2 = true;
                        } catch (Exception unused3) {
                            jSONObject = null;
                            z2 = false;
                        }
                        if (jSONObject != null) {
                            String string5 = jSONObject.has("city") ? jSONObject.getString("city") : str3;
                            str20 = jSONObject.has("city_code") ? jSONObject.getString("city_code") : str3;
                            str14 = jSONObject.has("country") ? jSONObject.getString("country") : str3;
                            String string6 = jSONObject.has("country_code") ? jSONObject.getString("country_code") : str3;
                            if (jSONObject.has("province")) {
                                str25 = jSONObject.getString("province");
                                str24 = string5;
                            } else {
                                str24 = string5;
                                str25 = str3;
                            }
                            String string7 = jSONObject.has("district") ? jSONObject.getString("district") : str3;
                            String string8 = jSONObject.has("street") ? jSONObject.getString("street") : str3;
                            String string9 = jSONObject.has("street_number") ? jSONObject.getString("street_number") : str3;
                            String string10 = jSONObject.has("adcode") ? jSONObject.getString("adcode") : str3;
                            if (jSONObject.has("town")) {
                                str4 = string8;
                                str17 = "x";
                                str18 = jSONObject.getString("town");
                                str15 = string6;
                                str7 = string7;
                                z3 = z2;
                            } else {
                                str15 = string6;
                                str7 = string7;
                                str4 = string8;
                                str17 = "x";
                                z3 = z2;
                                str18 = null;
                            }
                            str19 = str25;
                            str8 = string9;
                            String str27 = string10;
                            str12 = str24;
                            str13 = "y";
                            str16 = str27;
                        } else {
                            try {
                                String[] split2 = jSONObject6.getString(DuPaBInfoMsg.B_ADDR).split(",");
                                int length = split2.length;
                                if (length > 0) {
                                    str5 = split2[0];
                                    i = 1;
                                } else {
                                    i = 1;
                                    str5 = null;
                                }
                                if (length > i) {
                                    try {
                                        str6 = split2[i];
                                        i2 = 2;
                                    } catch (Exception e3) {
                                        exc2 = e3;
                                        str4 = null;
                                        str6 = null;
                                        str7 = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = str6;
                                        str13 = "y";
                                        str14 = str10;
                                        str15 = str11;
                                        str16 = null;
                                        z3 = false;
                                        str17 = "x";
                                        str18 = null;
                                        String str28 = str9;
                                        str19 = str5;
                                        str20 = str28;
                                        if (z3) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("acc")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.F == 0 ? "wgs84" : "gcj02");
                                        if (jSONObject6.has("navi")) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    i2 = 2;
                                    str6 = null;
                                }
                                if (length > i2) {
                                    try {
                                        str7 = split2[i2];
                                    } catch (Exception e4) {
                                        exc2 = e4;
                                        str4 = null;
                                        str7 = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = str6;
                                        str13 = "y";
                                        str14 = str10;
                                        str15 = str11;
                                        str16 = null;
                                        z3 = false;
                                        str17 = "x";
                                        str18 = null;
                                        String str282 = str9;
                                        str19 = str5;
                                        str20 = str282;
                                        if (z3) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("acc")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.F == 0 ? "wgs84" : "gcj02");
                                        if (jSONObject6.has("navi")) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str7 = null;
                                }
                                if (length > 3) {
                                    try {
                                        str4 = split2[3];
                                    } catch (Exception e5) {
                                        exc2 = e5;
                                        str4 = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = str6;
                                        str13 = "y";
                                        str14 = str10;
                                        str15 = str11;
                                        str16 = null;
                                        z3 = false;
                                        str17 = "x";
                                        str18 = null;
                                        String str2822 = str9;
                                        str19 = str5;
                                        str20 = str2822;
                                        if (z3) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("acc")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.F == 0 ? "wgs84" : "gcj02");
                                        if (jSONObject6.has("navi")) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                            str26 = str23;
                                            try {
                                                if (string.contains(str26)) {
                                                    intValue = Integer.valueOf(split[0]).intValue();
                                                    Integer.valueOf(split[1]).intValue();
                                                    if (intValue > 0) {
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                            }
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str4 = null;
                                }
                                if (length > 4) {
                                    try {
                                        str8 = split2[4];
                                    } catch (Exception e6) {
                                        exc2 = e6;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = str6;
                                        str13 = "y";
                                        str14 = str10;
                                        str15 = str11;
                                        str16 = null;
                                        z3 = false;
                                        str17 = "x";
                                        str18 = null;
                                        String str28222 = str9;
                                        str19 = str5;
                                        str20 = str28222;
                                        if (z3) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("acc")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.F == 0 ? "wgs84" : "gcj02");
                                        if (jSONObject6.has("navi")) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str8 = null;
                                }
                                if (length > 5) {
                                    try {
                                        str9 = split2[5];
                                        str21 = str4;
                                    } catch (Exception e7) {
                                        exc2 = e7;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = str6;
                                        str13 = "y";
                                        str14 = str10;
                                        str15 = str11;
                                        str16 = null;
                                        z3 = false;
                                        str17 = "x";
                                        str18 = null;
                                        String str282222 = str9;
                                        str19 = str5;
                                        str20 = str282222;
                                        if (z3) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("acc")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.F == 0 ? "wgs84" : "gcj02");
                                        if (jSONObject6.has("navi")) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str21 = str4;
                                    str9 = null;
                                }
                                if (length > 6) {
                                    try {
                                        str10 = split2[6];
                                    } catch (Exception e8) {
                                        str4 = str21;
                                        exc2 = e8;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = str6;
                                        str13 = "y";
                                        str14 = str10;
                                        str15 = str11;
                                        str16 = null;
                                        z3 = false;
                                        str17 = "x";
                                        str18 = null;
                                        String str2822222 = str9;
                                        str19 = str5;
                                        str20 = str2822222;
                                        if (z3) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("acc")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.F == 0 ? "wgs84" : "gcj02");
                                        if (jSONObject6.has("navi")) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str10 = null;
                                }
                                if (length > 7) {
                                    try {
                                        str11 = split2[7];
                                    } catch (Exception e9) {
                                        str4 = str21;
                                        exc2 = e9;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = str6;
                                        str13 = "y";
                                        str14 = str10;
                                        str15 = str11;
                                        str16 = null;
                                        z3 = false;
                                        str17 = "x";
                                        str18 = null;
                                        String str28222222 = str9;
                                        str19 = str5;
                                        str20 = str28222222;
                                        if (z3) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("acc")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.F == 0 ? "wgs84" : "gcj02");
                                        if (jSONObject6.has("navi")) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str11 = null;
                                }
                                if (length > 8) {
                                    try {
                                        str22 = split2[8];
                                    } catch (Exception e10) {
                                        str4 = str21;
                                        exc2 = e10;
                                        exc2.printStackTrace();
                                        str12 = str6;
                                        str13 = "y";
                                        str14 = str10;
                                        str15 = str11;
                                        str16 = null;
                                        z3 = false;
                                        str17 = "x";
                                        str18 = null;
                                        String str282222222 = str9;
                                        str19 = str5;
                                        str20 = str282222222;
                                        if (z3) {
                                        }
                                        if (jSONObject6.has("floor")) {
                                        }
                                        if (jSONObject6.has("indoor")) {
                                        }
                                        if (jSONObject6.has("loctp")) {
                                        }
                                        if (jSONObject6.has("bldgid")) {
                                        }
                                        if (jSONObject6.has("bldg")) {
                                        }
                                        if (jSONObject6.has("acc")) {
                                        }
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.F == 0 ? "wgs84" : "gcj02");
                                        if (jSONObject6.has("navi")) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str22 = null;
                                }
                                str4 = str21;
                                str12 = str6;
                                str13 = "y";
                                str14 = str10;
                                z3 = true;
                                str16 = str22;
                                str15 = str11;
                            } catch (Exception e11) {
                                exc2 = e11;
                                str4 = null;
                                str5 = null;
                            }
                            str17 = "x";
                            str18 = null;
                            String str2822222222 = str9;
                            str19 = str5;
                            str20 = str2822222222;
                        }
                        if (z3) {
                            str23 = ",";
                            this.y = new Address.Builder().country(str14).countryCode(str15).province(str19).city(str12).cityCode(str20).district(str7).street(str4).streetNumber(str8).adcode(str16).town(str18).build();
                            this.s = true;
                        } else {
                            str23 = ",";
                        }
                    } else {
                        str23 = ",";
                        str17 = "x";
                        str13 = "y";
                        this.s = false;
                        setAddrStr(null);
                    }
                    if (jSONObject6.has("floor")) {
                        String string11 = jSONObject6.getString("floor");
                        this.z = string11;
                        if (TextUtils.isEmpty(string11)) {
                            this.z = null;
                        }
                    }
                    if (jSONObject6.has("indoor")) {
                        String string12 = jSONObject6.getString("indoor");
                        if (!TextUtils.isEmpty(string12)) {
                            setUserIndoorState(Integer.valueOf(string12).intValue());
                        }
                    }
                    if (jSONObject6.has("loctp")) {
                        String string13 = jSONObject6.getString("loctp");
                        this.G = string13;
                        if (TextUtils.isEmpty(string13)) {
                            this.G = null;
                        }
                    }
                    if (jSONObject6.has("bldgid")) {
                        String string14 = jSONObject6.getString("bldgid");
                        this.A = string14;
                        if (TextUtils.isEmpty(string14)) {
                            this.A = null;
                        }
                    }
                    if (jSONObject6.has("bldg")) {
                        String string15 = jSONObject6.getString("bldg");
                        this.B = string15;
                        if (TextUtils.isEmpty(string15)) {
                            this.B = null;
                        }
                    }
                    if (jSONObject6.has("acc")) {
                        this.C = jSONObject6.getDouble("acc");
                    }
                    if (jSONObject6.has("ibav")) {
                        String string16 = jSONObject6.getString("ibav");
                        if (!TextUtils.isEmpty(string16) && !string16.equals("0")) {
                            this.E = Integer.valueOf(string16).intValue();
                        }
                        this.E = 0;
                    }
                    if (jSONObject6.has("indoorflags")) {
                        try {
                            JSONObject jSONObject11 = jSONObject6.getJSONObject("indoorflags");
                            if (jSONObject11.has(DnsModel.AREA_KEY)) {
                                int intValue2 = Integer.valueOf(jSONObject11.getString(DnsModel.AREA_KEY)).intValue();
                                if (intValue2 == 0) {
                                    setIndoorLocationSurpport(2);
                                } else if (intValue2 == 1) {
                                    setIndoorLocationSurpport(1);
                                }
                            }
                            if (jSONObject11.has("support")) {
                                setIndoorLocationSource(Integer.valueOf(jSONObject11.getString("support")).intValue());
                            }
                            if (jSONObject11.has("inbldg")) {
                                this.N = jSONObject11.getString("inbldg");
                            }
                            if (jSONObject11.has("inbldgid")) {
                                this.O = jSONObject11.getString("inbldgid");
                            }
                            if (jSONObject11.has("polygon")) {
                                setIndoorSurpportPolygon(jSONObject11.getString("polygon"));
                            }
                            if (jSONObject11.has("ret_fields")) {
                                try {
                                    for (String str29 : jSONObject11.getString("ret_fields").split(WebChromeClient.PARAM_SEPARATOR)) {
                                        String[] split3 = str29.split("=");
                                        if (split3 != null && split3.length >= 2) {
                                            this.V.putString(split3[0], split3[1]);
                                        }
                                    }
                                } catch (Exception unused4) {
                                }
                            }
                            if (jSONObject11.has("inout_ble")) {
                                int optInt = jSONObject11.optInt("inout_ble");
                                setInOutStatus(optInt);
                                if (optInt == 1) {
                                    setIsInIndoorPark(true);
                                } else {
                                    setIsInIndoorPark(false);
                                }
                            } else {
                                setInOutStatus(-1);
                            }
                        } catch (Exception e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (jSONObject6.has("gpscs")) {
                        setGpsCheckStatus(jSONObject6.getInt("gpscs"));
                    } else {
                        setGpsCheckStatus(0);
                    }
                    try {
                        if (jSONObject6.has("in_cn")) {
                            setLocationWhere(Integer.parseInt(jSONObject6.getString("in_cn")));
                        } else {
                            setLocationWhere(1);
                        }
                    } catch (Exception unused5) {
                    }
                    setCoorType(this.F == 0 ? "wgs84" : "gcj02");
                    if (jSONObject6.has("navi")) {
                        this.Z = jSONObject6.getString("navi");
                    }
                    if (jSONObject6.has("navi_client") && (string = jSONObject6.getString("navi_client")) != null) {
                        str26 = str23;
                        if (string.contains(str26) && (split = string.split(str26)) != null && split.length >= 2) {
                            intValue = Integer.valueOf(split[0]).intValue();
                            Integer.valueOf(split[1]).intValue();
                            if (intValue > 0) {
                                this.ad = true;
                            }
                        }
                    }
                    if (jSONObject6.has("nrl_point")) {
                        try {
                            JSONObject jSONObject12 = jSONObject6.getJSONObject("nrl_point");
                            String str30 = str17;
                            if (jSONObject12.has(str30)) {
                                String str31 = str13;
                                if (jSONObject12.has(str31)) {
                                    this.ab = Double.parseDouble(jSONObject12.getString(str31));
                                    this.ac = Double.parseDouble(jSONObject12.getString(str30));
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable unused6) {
                            this.ab = Double.MIN_VALUE;
                            this.ac = Double.MIN_VALUE;
                            return;
                        }
                    }
                    return;
                }
                if (parseInt != 66 && parseInt != 68) {
                    if (parseInt == 167) {
                        setLocationWhere(2);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject13 = jSONObject2.getJSONObject("content");
                JSONObject jSONObject14 = jSONObject13.getJSONObject(Config.EVENT_HEAT_POINT);
                setLatitude(Double.parseDouble(jSONObject14.getString("y")));
                setLongitude(Double.parseDouble(jSONObject14.getString("x")));
                setRadius(Float.parseFloat(jSONObject13.getString("radius")));
                a(Boolean.valueOf(Boolean.parseBoolean(jSONObject13.getString("isCellChanged"))));
            }
            setCoorType(str2);
        } catch (Exception e13) {
            exc = e13;
            z = false;
            exc.printStackTrace();
            r3 = z;
            this.a = r3;
            this.s = r3;
        }
    }

    private void a(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, bool) == null) {
            this.x = bool.booleanValue();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public double getAcc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.C : invokeV.doubleValue;
    }

    public String getAdCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.y.adcode : (String) invokeV.objValue;
    }

    public String getAddrStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.y.address : (String) invokeV.objValue;
    }

    public Address getAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.y : (Address) invokeV.objValue;
    }

    public double getAltitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : invokeV.doubleValue;
    }

    public String getBuildingID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public String getBuildingName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public String getCity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.y.city : (String) invokeV.objValue;
    }

    public String getCityCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.y.cityCode : (String) invokeV.objValue;
    }

    public String getCoorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public String getCountry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.y.country : (String) invokeV.objValue;
    }

    public String getCountryCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.y.countryCode : (String) invokeV.objValue;
    }

    public long getDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.Y : invokeV.longValue;
    }

    @Deprecated
    public float getDerect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.q : invokeV.floatValue;
    }

    public float getDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.q : invokeV.floatValue;
    }

    public double getDisToRealLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.ag : invokeV.doubleValue;
    }

    public String getDistrict() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.y.district : (String) invokeV.objValue;
    }

    public Bundle getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.ak : (Bundle) invokeV.objValue;
    }

    public Location getExtraLocation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            Bundle bundle = this.V;
            if (bundle != null) {
                Parcelable parcelable = bundle.getParcelable(str);
                if (parcelable instanceof Location) {
                    return (Location) parcelable;
                }
                return null;
            }
            return null;
        }
        return (Location) invokeL.objValue;
    }

    public String getFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.z : (String) invokeV.objValue;
    }

    public double[] getFusionLocInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? this.V.getDoubleArray(str) : (double[]) invokeL.objValue;
    }

    public String getGnssProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.al : (String) invokeV.objValue;
    }

    public int getGpsAccuracyStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.W : invokeV.intValue;
    }

    public float getGpsBiasProb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.af : invokeV.floatValue;
    }

    public int getGpsCheckStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.X : invokeV.intValue;
    }

    public int getInOutStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.Q : invokeV.intValue;
    }

    public int getIndoorLocationSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.M : invokeV.intValue;
    }

    public int getIndoorLocationSurpport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.K : invokeV.intValue;
    }

    public String getIndoorLocationSurpportBuidlingID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.O : (String) invokeV.objValue;
    }

    public String getIndoorLocationSurpportBuidlingName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.N : (String) invokeV.objValue;
    }

    public int getIndoorNetworkState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.L : invokeV.intValue;
    }

    public String getIndoorSurpportPolygon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    public double getLatitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.c : invokeV.doubleValue;
    }

    public int getLocType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.a : invokeV.intValue;
    }

    public String getLocTypeDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.S : (String) invokeV.objValue;
    }

    public String getLocationDescribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public String getLocationID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f1039T : (String) invokeV.objValue;
    }

    public int getLocationWhere() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.F : invokeV.intValue;
    }

    public double getLongitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.d : invokeV.doubleValue;
    }

    public int getMockGpsProbability() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.ai : invokeV.intValue;
    }

    public int getMockGpsStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.ah : invokeV.intValue;
    }

    public String getNetworkLocationType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.G : (String) invokeV.objValue;
    }

    public double getNrlLat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.ab : invokeV.doubleValue;
    }

    public double getNrlLon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.ac : invokeV.doubleValue;
    }

    public String getNrlResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.Z : (String) invokeV.objValue;
    }

    public int getOperators() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.H : invokeV.intValue;
    }

    public List<Poi> getPoiList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.R : (List) invokeV.objValue;
    }

    public PoiRegion getPoiRegion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.ae : (PoiRegion) invokeV.objValue;
    }

    public String getProvince() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.y.province : (String) invokeV.objValue;
    }

    public float getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.j : invokeV.floatValue;
    }

    public BDLocation getReallLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (getMockGpsStrategy() > 0) {
                return this.aj;
            }
            return null;
        }
        return (BDLocation) invokeV.objValue;
    }

    public String getRetFields(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) ? this.V.getString(str) : (String) invokeL.objValue;
    }

    public String getRoadLocString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.U : (String) invokeV.objValue;
    }

    public int getSatelliteNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            this.o = true;
            return this.p;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public String getSemaAptag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public float getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.h : invokeV.floatValue;
    }

    public String getStreet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.y.street : (String) invokeV.objValue;
    }

    public String getStreetNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.y.streetNumber : (String) invokeV.objValue;
    }

    public String getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public long getTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.am : invokeV.longValue;
    }

    public String getTown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.y.town : (String) invokeV.objValue;
    }

    public String getTraffic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public float getTrafficConfidence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.l : invokeV.floatValue;
    }

    public float getTrafficSkipProb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.n : invokeV.floatValue;
    }

    public int getUserIndoorState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.J : invokeV.intValue;
    }

    public String getVdrJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            Bundle bundle = this.V;
            if (bundle == null || !bundle.containsKey("vdr")) {
                return null;
            }
            return this.V.getString("vdr");
        }
        return (String) invokeV.objValue;
    }

    public String getViaductResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.aa : (String) invokeV.objValue;
    }

    public boolean hasAddr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean hasAltitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public boolean hasRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public boolean hasSateNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean hasSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public boolean isCellChangeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public boolean isInIndoorPark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.ad : invokeV.booleanValue;
    }

    public boolean isIndoorLocMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean isNrlAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? (this.ac == Double.MIN_VALUE || this.ab == Double.MIN_VALUE) ? false : true : invokeV.booleanValue;
    }

    public int isParkAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.E : invokeV.intValue;
    }

    public int isTrafficStation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.m : invokeV.intValue;
    }

    public void setAcc(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{Double.valueOf(d)}) == null) {
            this.C = d;
        }
    }

    public void setAddr(Address address) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048656, this, address) == null) || address == null) {
            return;
        }
        this.y = address;
        this.s = true;
    }

    public void setAddrStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
            this.t = str;
            this.s = str != null;
        }
    }

    public void setAltitude(double d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{Double.valueOf(d)}) == null) || d >= 9999.0d) {
            return;
        }
        this.f = d;
        this.e = true;
    }

    public void setBuildingID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, str) == null) {
            this.A = str;
        }
    }

    public void setBuildingName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            this.B = str;
        }
    }

    public void setCoorType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
            this.r = str;
        }
    }

    public void setDelayTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048662, this, j) == null) {
            this.Y = j;
        }
    }

    public void setDirection(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048663, this, f) == null) {
            this.q = f;
        }
    }

    public void setDisToRealLocation(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048664, this, new Object[]{Double.valueOf(d)}) == null) {
            this.ag = d;
        }
    }

    public void setExtraLocation(String str, Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048665, this, str, location) == null) {
            if (this.V == null) {
                this.V = new Bundle();
            }
            this.V.putParcelable(str, location);
        }
    }

    public void setExtrainfo(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, bundle) == null) {
            this.ak = bundle == null ? null : new Bundle(bundle);
        }
    }

    public void setFloor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
            this.z = str;
        }
    }

    public void setFusionLocInfo(String str, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048668, this, str, dArr) == null) {
            if (this.V == null) {
                this.V = new Bundle();
            }
            this.V.putDoubleArray(str, dArr);
        }
    }

    public void setGnssProvider(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, str) == null) {
            this.al = str;
        }
    }

    public void setGpsAccuracyStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048670, this, i) == null) {
            this.W = i;
        }
    }

    public void setGpsBiasProb(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048671, this, f) == null) {
            this.af = f;
        }
    }

    public void setGpsCheckStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048672, this, i) == null) {
            this.X = i;
        }
    }

    public void setInOutStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i) == null) {
            this.Q = i;
        }
    }

    public void setIndoorLocMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            this.D = z;
        }
    }

    public void setIndoorLocationSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048675, this, i) == null) {
            this.M = i;
        }
    }

    public void setIndoorLocationSurpport(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048676, this, i) == null) {
            this.K = i;
        }
    }

    public void setIndoorNetworkState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048677, this, i) == null) {
            this.L = i;
        }
    }

    public void setIndoorSurpportPolygon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, str) == null) {
            this.P = str;
        }
    }

    public void setIsInIndoorPark(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            this.ad = z;
        }
    }

    public void setIsTrafficStation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048680, this, i) == null) {
            this.m = i;
        }
    }

    public void setLatitude(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048681, this, new Object[]{Double.valueOf(d)}) == null) {
            this.c = d;
        }
    }

    public void setLocType(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i) == null) {
            this.a = i;
            if (i != 66) {
                if (i != 67) {
                    if (i == 161) {
                        str = "NetWork location successful!";
                    } else if (i == 162) {
                        str = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
                    } else if (i == 167) {
                        str = "NetWork location failed because baidu location service can not caculate the location!";
                    } else if (i != 505) {
                        switch (i) {
                            case 61:
                                setLocTypeDescription("GPS location successful!");
                                setUserIndoorState(0);
                                setGnssProvider("system");
                                return;
                            case 62:
                                str = "Location failed beacuse we can not get any loc information!";
                                break;
                            case 63:
                                break;
                            default:
                                switch (i) {
                                    case 69:
                                        str = "Location failed because the location service switch is not on";
                                        break;
                                    case 70:
                                        str = "Location failed because the location permission is not enabled";
                                        break;
                                    case 71:
                                        str = "Location failed because the location service switch is not on and the location permission is not enabled";
                                        break;
                                    default:
                                        str = "UnKnown!";
                                        break;
                                }
                        }
                    } else {
                        str = "NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !";
                    }
                }
                str = "Offline location failed, please check the net (wifi/cell)!";
            } else {
                str = "Offline location successful!";
            }
            setLocTypeDescription(str);
        }
    }

    public void setLocTypeDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, str) == null) {
            this.S = str;
        }
    }

    public void setLocationDescribe(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            this.u = str;
        }
    }

    public void setLocationID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, str) == null) {
            this.f1039T = str;
        }
    }

    public void setLocationWhere(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048686, this, i) == null) {
            this.F = i;
        }
    }

    public void setLongitude(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048687, this, new Object[]{Double.valueOf(d)}) == null) {
            this.d = d;
        }
    }

    public void setMockGpsProbability(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048688, this, i) == null) {
            this.ai = i;
        }
    }

    public void setMockGpsStrategy(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048689, this, i) == null) {
            this.ah = i;
        }
    }

    public void setNetworkLocationType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, str) == null) {
            this.G = str;
        }
    }

    public void setNrlData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, str) == null) {
            this.Z = str;
        }
    }

    public void setOperators(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048692, this, i) == null) {
            this.H = i;
        }
    }

    public void setParkAvailable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048693, this, i) == null) {
            this.E = i;
        }
    }

    public void setPoiList(List<Poi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, list) == null) {
            this.R = list;
        }
    }

    public void setPoiRegion(PoiRegion poiRegion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, poiRegion) == null) {
            this.ae = poiRegion;
        }
    }

    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048696, this, f) == null) {
            this.j = f;
            this.i = true;
        }
    }

    public void setReallLocation(BDLocation bDLocation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048697, this, bDLocation) == null) || getMockGpsStrategy() <= 0) {
            return;
        }
        this.aj = bDLocation;
    }

    public void setRetFields(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048698, this, str, str2) == null) {
            if (this.V == null) {
                this.V = new Bundle();
            }
            this.V.putString(str, str2);
        }
    }

    public void setRoadLocString(float f, float f2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048699, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), str}) == null) {
            String format = ((double) f) > 0.001d ? String.format("%.2f", Float.valueOf(f)) : "";
            String format2 = ((double) f2) > 0.001d ? String.format("%.2f", Float.valueOf(f2)) : "";
            String str2 = this.Z;
            if (str2 != null) {
                String format3 = String.format(Locale.US, "%s|%s,%s", str2, format, format2);
                this.U = format3;
                String str3 = this.aa;
                if (str3 != null) {
                    this.U = String.format(Locale.US, "%s|%s", format3, str3);
                }
            }
            if (str != null) {
                this.U = String.format(Locale.US, "%s|%s", this.U, str);
            }
        }
    }

    public void setSatelliteNumber(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048700, this, i) == null) {
            this.p = i;
        }
    }

    public void setSpeed(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048701, this, f) == null) {
            this.h = f;
            this.g = true;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, str) == null) {
            this.b = str;
            setLocationID(k.a(str));
        }
    }

    public void setTimeStamp(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048703, this, j) == null) {
            this.am = j;
        }
    }

    public void setTraffic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, str) == null) {
            this.k = str;
        }
    }

    public void setTrafficConfidence(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048705, this, f) == null) {
            this.l = f;
        }
    }

    public void setTrafficSkipProb(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048706, this, f) == null) {
            this.n = f;
        }
    }

    public void setUserIndoorState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048707, this, i) == null) {
            this.J = i;
        }
    }

    public void setVdrJsonValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, str) == null) {
            if (this.V == null) {
                this.V = new Bundle();
            }
            this.V.putString("vdr", str);
        }
    }

    public void setViaductData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, str) == null) {
            this.aa = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            return "&loctype=" + getLocType() + "&lat=" + getLatitude() + "&lon=" + getLongitude() + "&radius=" + getRadius() + "&biasprob=" + getGpsBiasProb() + "&extrainfo=" + getExtraInfo();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048711, this, parcel, i) == null) {
            parcel.writeInt(this.a);
            parcel.writeString(this.b);
            parcel.writeLong(this.am);
            parcel.writeDouble(this.c);
            parcel.writeDouble(this.d);
            parcel.writeDouble(this.f);
            parcel.writeFloat(this.h);
            parcel.writeFloat(this.j);
            parcel.writeString(this.k);
            parcel.writeFloat(this.l);
            parcel.writeInt(this.m);
            parcel.writeFloat(this.n);
            parcel.writeInt(this.p);
            parcel.writeFloat(this.q);
            parcel.writeString(this.z);
            parcel.writeInt(this.E);
            parcel.writeString(this.A);
            parcel.writeString(this.B);
            parcel.writeDouble(this.C);
            parcel.writeString(this.G);
            parcel.writeString(this.y.province);
            parcel.writeString(this.y.city);
            parcel.writeString(this.y.district);
            parcel.writeString(this.y.street);
            parcel.writeString(this.y.streetNumber);
            parcel.writeString(this.y.cityCode);
            parcel.writeString(this.y.address);
            parcel.writeString(this.y.country);
            parcel.writeString(this.y.countryCode);
            parcel.writeString(this.y.adcode);
            parcel.writeString(this.y.town);
            parcel.writeInt(this.H);
            parcel.writeString(this.I);
            parcel.writeString(this.u);
            parcel.writeString(this.v);
            parcel.writeString(this.w);
            parcel.writeInt(this.F);
            parcel.writeString(this.S);
            parcel.writeInt(this.J);
            parcel.writeInt(this.K);
            parcel.writeInt(this.L);
            parcel.writeInt(this.M);
            parcel.writeString(this.N);
            parcel.writeString(this.O);
            parcel.writeString(this.P);
            parcel.writeInt(this.Q);
            parcel.writeInt(this.W);
            parcel.writeString(this.f1039T);
            parcel.writeInt(this.X);
            parcel.writeString(this.U);
            parcel.writeString(this.Z);
            parcel.writeString(this.aa);
            parcel.writeLong(this.Y);
            parcel.writeDouble(this.ab);
            parcel.writeDouble(this.ac);
            parcel.writeFloat(this.af);
            parcel.writeDouble(this.ag);
            parcel.writeInt(this.ah);
            parcel.writeInt(this.ai);
            parcel.writeString(this.r);
            parcel.writeString(this.al);
            parcel.writeParcelable(this.aj, i);
            parcel.writeBooleanArray(new boolean[]{this.e, this.g, this.i, this.o, this.s, this.x, this.D, this.ad});
            parcel.writeList(this.R);
            parcel.writeBundle(this.V);
            parcel.writeBundle(this.ak);
            parcel.writeParcelable(this.ae, i);
        }
    }
}
