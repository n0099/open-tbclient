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
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class BDLocation implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
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
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
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
    public int A;
    public String B;
    public int C;
    public String D;
    public int E;
    public int F;
    public int G;
    public int H;
    public String I;
    public String J;
    public String K;
    public List<Poi> L;
    public String M;
    public String N;
    public String O;
    public Bundle P;
    public int Q;
    public int R;
    public long S;
    public String T;
    public double U;
    public double V;
    public boolean W;

    /* renamed from: a  reason: collision with root package name */
    public int f40731a;

    /* renamed from: b  reason: collision with root package name */
    public String f40732b;

    /* renamed from: c  reason: collision with root package name */
    public double f40733c;

    /* renamed from: d  reason: collision with root package name */
    public double f40734d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40735e;

    /* renamed from: f  reason: collision with root package name */
    public double f40736f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40737g;

    /* renamed from: h  reason: collision with root package name */
    public float f40738h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40739i;

    /* renamed from: j  reason: collision with root package name */
    public float f40740j;
    public boolean k;
    public int l;
    public float m;
    public String n;
    public boolean o;
    public String p;
    public String q;
    public String r;
    public String s;
    public boolean t;
    public Address u;
    public String v;
    public String w;
    public String x;
    public boolean y;
    public int z;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40731a = 0;
        this.f40732b = null;
        this.f40733c = Double.MIN_VALUE;
        this.f40734d = Double.MIN_VALUE;
        this.f40735e = false;
        this.f40736f = Double.MIN_VALUE;
        this.f40737g = false;
        this.f40738h = 0.0f;
        this.f40739i = false;
        this.f40740j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address.Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = new Bundle();
        this.Q = 0;
        this.R = 0;
        this.S = 0L;
        this.T = null;
        this.U = Double.MIN_VALUE;
        this.V = Double.MIN_VALUE;
        this.W = false;
    }

    public BDLocation(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f40731a = 0;
        this.f40732b = null;
        this.f40733c = Double.MIN_VALUE;
        this.f40734d = Double.MIN_VALUE;
        this.f40735e = false;
        this.f40736f = Double.MIN_VALUE;
        this.f40737g = false;
        this.f40738h = 0.0f;
        this.f40739i = false;
        this.f40740j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address.Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = new Bundle();
        this.Q = 0;
        this.R = 0;
        this.S = 0L;
        this.T = null;
        this.U = Double.MIN_VALUE;
        this.V = Double.MIN_VALUE;
        this.W = false;
        this.f40731a = parcel.readInt();
        this.f40732b = parcel.readString();
        this.f40733c = parcel.readDouble();
        this.f40734d = parcel.readDouble();
        this.f40736f = parcel.readDouble();
        this.f40738h = parcel.readFloat();
        this.f40740j = parcel.readFloat();
        this.l = parcel.readInt();
        this.m = parcel.readFloat();
        this.v = parcel.readString();
        this.z = parcel.readInt();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.B = parcel.readString();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        parcel.readString();
        String readString7 = parcel.readString();
        this.u = new Address.Builder().country(readString7).countryCode(parcel.readString()).province(readString).city(readString2).cityCode(readString6).district(readString3).street(readString4).streetNumber(readString5).adcode(parcel.readString()).build();
        boolean[] zArr = new boolean[8];
        this.C = parcel.readInt();
        this.D = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.A = parcel.readInt();
        this.M = parcel.readString();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readInt();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.Q = parcel.readInt();
        this.N = parcel.readString();
        this.R = parcel.readInt();
        this.O = parcel.readString();
        this.T = parcel.readString();
        this.S = parcel.readLong();
        this.U = parcel.readDouble();
        this.V = parcel.readDouble();
        try {
            parcel.readBooleanArray(zArr);
            this.f40735e = zArr[0];
            this.f40737g = zArr[1];
            this.f40739i = zArr[2];
            this.k = zArr[3];
            this.o = zArr[4];
            this.t = zArr[5];
            this.y = zArr[6];
            this.W = zArr[7];
        } catch (Exception unused) {
        }
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, Poi.class.getClassLoader());
        if (arrayList.size() == 0) {
            this.L = null;
        } else {
            this.L = arrayList;
        }
        try {
            this.P = parcel.readBundle();
        } catch (Exception e2) {
            e2.printStackTrace();
            this.P = new Bundle();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f40731a = 0;
        ArrayList arrayList = null;
        this.f40732b = null;
        this.f40733c = Double.MIN_VALUE;
        this.f40734d = Double.MIN_VALUE;
        this.f40735e = false;
        this.f40736f = Double.MIN_VALUE;
        this.f40737g = false;
        this.f40738h = 0.0f;
        this.f40739i = false;
        this.f40740j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address.Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = new Bundle();
        this.Q = 0;
        this.R = 0;
        this.S = 0L;
        this.T = null;
        this.U = Double.MIN_VALUE;
        this.V = Double.MIN_VALUE;
        this.W = false;
        this.f40731a = bDLocation.f40731a;
        this.f40732b = bDLocation.f40732b;
        this.f40733c = bDLocation.f40733c;
        this.f40734d = bDLocation.f40734d;
        this.f40735e = bDLocation.f40735e;
        this.f40736f = bDLocation.f40736f;
        this.f40737g = bDLocation.f40737g;
        this.f40738h = bDLocation.f40738h;
        this.f40739i = bDLocation.f40739i;
        this.f40740j = bDLocation.f40740j;
        this.k = bDLocation.k;
        this.l = bDLocation.l;
        this.m = bDLocation.m;
        this.n = bDLocation.n;
        this.o = bDLocation.o;
        this.p = bDLocation.p;
        this.t = bDLocation.t;
        this.u = new Address.Builder().country(bDLocation.u.country).countryCode(bDLocation.u.countryCode).province(bDLocation.u.province).city(bDLocation.u.city).cityCode(bDLocation.u.cityCode).district(bDLocation.u.district).street(bDLocation.u.street).streetNumber(bDLocation.u.streetNumber).adcode(bDLocation.u.adcode).build();
        this.v = bDLocation.v;
        this.w = bDLocation.w;
        this.x = bDLocation.x;
        this.A = bDLocation.A;
        this.z = bDLocation.z;
        this.y = bDLocation.y;
        this.B = bDLocation.B;
        this.C = bDLocation.C;
        this.D = bDLocation.D;
        this.q = bDLocation.q;
        this.r = bDLocation.r;
        this.s = bDLocation.s;
        this.E = bDLocation.E;
        this.F = bDLocation.F;
        this.G = bDLocation.F;
        this.H = bDLocation.H;
        this.I = bDLocation.I;
        this.J = bDLocation.J;
        this.K = bDLocation.K;
        this.Q = bDLocation.Q;
        this.O = bDLocation.O;
        this.U = bDLocation.U;
        this.V = bDLocation.V;
        this.S = bDLocation.S;
        this.N = bDLocation.N;
        if (bDLocation.L != null) {
            arrayList = new ArrayList();
            for (int i4 = 0; i4 < bDLocation.L.size(); i4++) {
                Poi poi = bDLocation.L.get(i4);
                arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank()));
            }
        }
        this.L = arrayList;
        this.M = bDLocation.M;
        this.P = bDLocation.P;
        this.R = bDLocation.R;
        this.W = bDLocation.W;
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x03b2 A[Catch: Exception -> 0x065c, Error -> 0x0660, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03f8 A[Catch: Exception -> 0x065c, Error -> 0x0660, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x040f A[Catch: Exception -> 0x065c, Error -> 0x0660, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x042c A[Catch: Exception -> 0x065c, Error -> 0x0660, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0445 A[Catch: Exception -> 0x065c, Error -> 0x0660, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x045e A[Catch: Exception -> 0x065c, Error -> 0x0660, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0477 A[Catch: Exception -> 0x065c, Error -> 0x0660, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0556 A[Catch: Exception -> 0x065c, Error -> 0x0660, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0560 A[Catch: Exception -> 0x065c, Error -> 0x0660, TRY_LEAVE, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x056a A[Catch: Exception -> 0x057a, Error -> 0x0660, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0576 A[Catch: Exception -> 0x057a, Error -> 0x0660, TRY_LEAVE, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0590 A[Catch: Exception -> 0x065c, Error -> 0x0660, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x05a0 A[Catch: Exception -> 0x065c, Error -> 0x0660, TRY_LEAVE, TryCatch #8 {Error -> 0x0660, blocks: (B:9:0x00a3, B:10:0x00a5, B:13:0x00e2, B:15:0x013c, B:16:0x0145, B:18:0x014b, B:19:0x0157, B:20:0x015b, B:23:0x0162, B:24:0x0167, B:27:0x0171, B:29:0x01a4, B:31:0x01ae, B:33:0x01b8, B:34:0x01bb, B:35:0x01bd, B:37:0x01c3, B:38:0x01d3, B:40:0x01d9, B:41:0x01fe, B:43:0x0205, B:45:0x020d, B:47:0x0219, B:48:0x021b, B:50:0x0223, B:52:0x022f, B:54:0x0234, B:57:0x023e, B:61:0x0248, B:63:0x0250, B:65:0x0259, B:67:0x0261, B:69:0x026a, B:71:0x0272, B:73:0x027b, B:75:0x0283, B:77:0x028c, B:79:0x0294, B:81:0x029d, B:83:0x02a5, B:85:0x02ae, B:87:0x02b8, B:89:0x02c7, B:91:0x02cf, B:93:0x02da, B:95:0x02e2, B:173:0x03b2, B:175:0x03f0, B:177:0x03f8, B:179:0x0404, B:180:0x0407, B:182:0x040f, B:184:0x0419, B:185:0x0424, B:187:0x042c, B:189:0x043a, B:190:0x043d, B:192:0x0445, B:194:0x0453, B:195:0x0456, B:197:0x045e, B:199:0x046c, B:200:0x046f, B:202:0x0477, B:204:0x0483, B:205:0x0487, B:208:0x0490, B:209:0x049a, B:211:0x04a2, B:213:0x04b0, B:215:0x04c0, B:218:0x04c8, B:219:0x04cb, B:221:0x04d3, B:222:0x04e4, B:224:0x04ec, B:225:0x04f4, B:227:0x04fc, B:228:0x0504, B:230:0x050c, B:231:0x0515, B:233:0x051d, B:235:0x052d, B:239:0x0545, B:244:0x054e, B:246:0x0556, B:248:0x0564, B:250:0x056a, B:251:0x0576, B:252:0x057a, B:255:0x0581, B:257:0x0588, B:259:0x0590, B:260:0x0598, B:262:0x05a0, B:272:0x05ce, B:273:0x05d1, B:282:0x0605, B:247:0x0560, B:243:0x054b, B:98:0x02ff, B:100:0x030a, B:104:0x0313, B:110:0x0320, B:118:0x032d, B:126:0x033a, B:134:0x034a, B:142:0x0357, B:150:0x0367, B:158:0x0379, B:171:0x039d, B:174:0x03e7, B:290:0x0619, B:291:0x061e), top: B:325:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x05ae A[Catch: all -> 0x05cc, TryCatch #6 {all -> 0x05cc, blocks: (B:264:0x05a8, B:266:0x05ae, B:268:0x05c9), top: B:321:0x05a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x05d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x04a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:349:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [int, boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BDLocation(String str) {
        boolean z;
        Exception exc;
        ?? r3;
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
        String str17;
        String str18;
        String str19;
        String str20;
        int i2;
        int i3;
        String str21;
        String str22;
        String str23;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        this.f40731a = 0;
        this.f40732b = null;
        this.f40733c = Double.MIN_VALUE;
        this.f40734d = Double.MIN_VALUE;
        this.f40735e = false;
        this.f40736f = Double.MIN_VALUE;
        this.f40737g = false;
        this.f40738h = 0.0f;
        this.f40739i = false;
        this.f40740j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Address.Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = new Bundle();
        this.Q = 0;
        this.R = 0;
        this.S = 0L;
        this.T = null;
        this.U = Double.MIN_VALUE;
        this.V = Double.MIN_VALUE;
        this.W = false;
        if (str == null) {
            return;
        }
        String str24 = "";
        if (str.equals(str24)) {
            return;
        }
        try {
            try {
            } catch (Error e2) {
                e2.printStackTrace();
                r3 = 0;
                this.f40731a = r3;
                this.o = r3;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("result");
                int parseInt = Integer.parseInt(jSONObject3.getString("error"));
                setLocType(parseInt);
                setTime(jSONObject3.getString("time"));
                if (parseInt == 61) {
                    JSONObject jSONObject4 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject5.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject5.getString("x")));
                    setRadius(Float.parseFloat(jSONObject4.getString("radius")));
                    setSpeed(Float.parseFloat(jSONObject4.getString("s")));
                    setDirection(Float.parseFloat(jSONObject4.getString("d")));
                    setSatelliteNumber(Integer.parseInt(jSONObject4.getString("n")));
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
                    if (this.A != 0) {
                        setCoorType("gcj02");
                        return;
                    }
                    str2 = CoordinateType.WGS84;
                } else if (parseInt == 161) {
                    JSONObject jSONObject6 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject7 = jSONObject6.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject7.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject7.getString("x")));
                    setRadius(Float.parseFloat(jSONObject6.getString("radius")));
                    if (jSONObject6.has("sema")) {
                        JSONObject jSONObject8 = jSONObject6.getJSONObject("sema");
                        if (jSONObject8.has("aptag")) {
                            String string2 = jSONObject8.getString("aptag");
                            if (TextUtils.isEmpty(string2)) {
                                this.q = str24;
                            } else {
                                this.q = string2;
                            }
                        }
                        if (jSONObject8.has("aptagd")) {
                            JSONArray jSONArray = jSONObject8.getJSONObject("aptagd").getJSONArray("pois");
                            ArrayList arrayList = new ArrayList();
                            int i6 = 0;
                            while (i6 < jSONArray.length()) {
                                JSONObject jSONObject9 = jSONArray.getJSONObject(i6);
                                arrayList.add(new Poi(jSONObject9.getString("pid"), jSONObject9.getString("pname"), jSONObject9.getDouble("pr")));
                                i6++;
                                str24 = str24;
                            }
                            str3 = str24;
                            this.L = arrayList;
                        } else {
                            str3 = str24;
                        }
                        if (jSONObject8.has("poiregion")) {
                            String string3 = jSONObject8.getString("poiregion");
                            if (!TextUtils.isEmpty(string3)) {
                                this.r = string3;
                            }
                        }
                        if (jSONObject8.has("regular")) {
                            String string4 = jSONObject8.getString("regular");
                            if (!TextUtils.isEmpty(string4)) {
                                this.s = string4;
                            }
                        }
                    } else {
                        str3 = str24;
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
                            str18 = jSONObject.has("country") ? jSONObject.getString("country") : str3;
                            str15 = jSONObject.has("country_code") ? jSONObject.getString("country_code") : str3;
                            str17 = jSONObject.has("province") ? jSONObject.getString("province") : str3;
                            String string6 = jSONObject.has("district") ? jSONObject.getString("district") : str3;
                            if (jSONObject.has("street")) {
                                str19 = jSONObject.getString("street");
                                str23 = string5;
                            } else {
                                str23 = string5;
                                str19 = str3;
                            }
                            String string7 = jSONObject.has("street_number") ? jSONObject.getString("street_number") : str3;
                            if (jSONObject.has("adcode")) {
                                String string8 = jSONObject.getString("adcode");
                                str14 = string6;
                                str9 = string7;
                                str16 = string8;
                                str13 = str23;
                                str12 = "y";
                            } else {
                                str14 = string6;
                                str13 = str23;
                                str9 = string7;
                                str12 = "y";
                                str16 = str3;
                            }
                        } else {
                            try {
                                String[] split = jSONObject6.getString(DuPaBInfoMsg.B_ADDR).split(",");
                                int length = split.length;
                                if (length > 0) {
                                    str5 = split[0];
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                    str5 = null;
                                }
                                if (length > i2) {
                                    try {
                                        str6 = split[i2];
                                        i3 = 2;
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
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str25 = str10;
                                        str19 = str4;
                                        str20 = str25;
                                        if (z2) {
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
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                                        if (jSONObject6.has("navi")) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    i3 = 2;
                                    str6 = null;
                                }
                                if (length > i3) {
                                    try {
                                        str7 = split[i3];
                                    } catch (Exception e4) {
                                        exc2 = e4;
                                        str4 = null;
                                        str7 = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str252 = str10;
                                        str19 = str4;
                                        str20 = str252;
                                        if (z2) {
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
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
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
                                        str4 = split[3];
                                    } catch (Exception e5) {
                                        exc2 = e5;
                                        str4 = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str2522 = str10;
                                        str19 = str4;
                                        str20 = str2522;
                                        if (z2) {
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
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                                        if (jSONObject6.has("navi")) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                            try {
                                                if (string.contains(",")) {
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
                                        str9 = split[4];
                                    } catch (Exception e6) {
                                        exc2 = e6;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str25222 = str10;
                                        str19 = str4;
                                        str20 = str25222;
                                        if (z2) {
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
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                                        if (jSONObject6.has("navi")) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str9 = null;
                                }
                                if (length > 5) {
                                    try {
                                        str10 = split[5];
                                    } catch (Exception e7) {
                                        exc2 = e7;
                                        str8 = null;
                                        str10 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str252222 = str10;
                                        str19 = str4;
                                        str20 = str252222;
                                        if (z2) {
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
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
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
                                if (length > 6) {
                                    try {
                                        str8 = split[6];
                                        str21 = str4;
                                    } catch (Exception e8) {
                                        exc2 = e8;
                                        str8 = null;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str2522222 = str10;
                                        str19 = str4;
                                        str20 = str2522222;
                                        if (z2) {
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
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                                        if (jSONObject6.has("navi")) {
                                        }
                                        if (jSONObject6.has("navi_client")) {
                                        }
                                        if (jSONObject6.has("nrl_point")) {
                                        }
                                    }
                                } else {
                                    str21 = str4;
                                    str8 = null;
                                }
                                if (length > 7) {
                                    try {
                                        str11 = split[7];
                                    } catch (Exception e9) {
                                        exc2 = e9;
                                        str4 = str21;
                                        str11 = null;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str25222222 = str10;
                                        str19 = str4;
                                        str20 = str25222222;
                                        if (z2) {
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
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
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
                                        str22 = split[8];
                                    } catch (Exception e10) {
                                        exc2 = e10;
                                        str4 = str21;
                                        exc2.printStackTrace();
                                        str12 = "y";
                                        str13 = str6;
                                        str14 = str7;
                                        str15 = str11;
                                        str16 = null;
                                        str17 = str5;
                                        str18 = str8;
                                        z2 = false;
                                        String str252222222 = str10;
                                        str19 = str4;
                                        str20 = str252222222;
                                        if (z2) {
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
                                        if (jSONObject6.has("ibav")) {
                                        }
                                        if (jSONObject6.has("indoorflags")) {
                                        }
                                        if (jSONObject6.has("gpscs")) {
                                        }
                                        if (jSONObject6.has("in_cn")) {
                                        }
                                        setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
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
                                str14 = str7;
                                str20 = str10;
                                str19 = str21;
                                str12 = "y";
                                str17 = str5;
                                str18 = str8;
                                z2 = true;
                                str16 = str22;
                                str13 = str6;
                                str15 = str11;
                            } catch (Exception e11) {
                                exc2 = e11;
                                str4 = null;
                                str5 = null;
                            }
                        }
                        if (z2) {
                            this.u = new Address.Builder().country(str18).countryCode(str15).province(str17).city(str13).cityCode(str20).district(str14).street(str19).streetNumber(str9).adcode(str16).build();
                            this.o = true;
                        }
                    } else {
                        str12 = "y";
                        this.o = false;
                        setAddrStr(null);
                    }
                    if (jSONObject6.has("floor")) {
                        String string9 = jSONObject6.getString("floor");
                        this.v = string9;
                        if (TextUtils.isEmpty(string9)) {
                            this.v = null;
                        }
                    }
                    if (jSONObject6.has("indoor")) {
                        String string10 = jSONObject6.getString("indoor");
                        if (!TextUtils.isEmpty(string10)) {
                            setUserIndoorState(Integer.valueOf(string10).intValue());
                        }
                    }
                    if (jSONObject6.has("loctp")) {
                        String string11 = jSONObject6.getString("loctp");
                        this.B = string11;
                        if (TextUtils.isEmpty(string11)) {
                            this.B = null;
                        }
                    }
                    if (jSONObject6.has("bldgid")) {
                        String string12 = jSONObject6.getString("bldgid");
                        this.w = string12;
                        if (TextUtils.isEmpty(string12)) {
                            this.w = null;
                        }
                    }
                    if (jSONObject6.has("bldg")) {
                        String string13 = jSONObject6.getString("bldg");
                        this.x = string13;
                        if (TextUtils.isEmpty(string13)) {
                            this.x = null;
                        }
                    }
                    if (jSONObject6.has("ibav")) {
                        String string14 = jSONObject6.getString("ibav");
                        if (!TextUtils.isEmpty(string14) && !string14.equals("0")) {
                            this.z = Integer.valueOf(string14).intValue();
                        }
                        this.z = 0;
                    }
                    if (jSONObject6.has("indoorflags")) {
                        try {
                            JSONObject jSONObject10 = jSONObject6.getJSONObject("indoorflags");
                            if (jSONObject10.has(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA)) {
                                int intValue = Integer.valueOf(jSONObject10.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA)).intValue();
                                if (intValue == 0) {
                                    setIndoorLocationSurpport(2);
                                } else if (intValue == 1) {
                                    setIndoorLocationSurpport(1);
                                }
                            }
                            if (jSONObject10.has("support")) {
                                setIndoorLocationSource(Integer.valueOf(jSONObject10.getString("support")).intValue());
                            }
                            if (jSONObject10.has("inbldg")) {
                                this.I = jSONObject10.getString("inbldg");
                            }
                            if (jSONObject10.has("inbldgid")) {
                                this.J = jSONObject10.getString("inbldgid");
                            }
                            if (jSONObject10.has("polygon")) {
                                setIndoorSurpportPolygon(jSONObject10.getString("polygon"));
                            }
                            if (jSONObject10.has("ret_fields")) {
                                try {
                                    for (String str26 : jSONObject10.getString("ret_fields").split("\\|")) {
                                        String[] split2 = str26.split("=");
                                        this.P.putString(split2[0], split2[1]);
                                    }
                                } catch (Exception e12) {
                                    e12.printStackTrace();
                                }
                            }
                        } catch (Exception e13) {
                            e13.printStackTrace();
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
                    } catch (Exception unused4) {
                    }
                    setCoorType(this.A == 0 ? CoordinateType.WGS84 : "gcj02");
                    if (jSONObject6.has("navi")) {
                        this.T = jSONObject6.getString("navi");
                    }
                    if (jSONObject6.has("navi_client") && (string = jSONObject6.getString("navi_client")) != null) {
                        if (string.contains(",")) {
                            String[] split3 = string.split(",");
                            int intValue2 = Integer.valueOf(split3[0]).intValue();
                            Integer.valueOf(split3[1]).intValue();
                            if (intValue2 > 0) {
                                this.W = true;
                            }
                        }
                    }
                    if (jSONObject6.has("nrl_point")) {
                        try {
                            JSONObject jSONObject11 = jSONObject6.getJSONObject("nrl_point");
                            if (jSONObject11.has("x")) {
                                String str27 = str12;
                                if (jSONObject11.has(str27)) {
                                    this.U = Double.parseDouble(jSONObject11.getString(str27));
                                    this.V = Double.parseDouble(jSONObject11.getString("x"));
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable unused5) {
                            this.U = Double.MIN_VALUE;
                            this.V = Double.MIN_VALUE;
                            return;
                        }
                    }
                    return;
                } else {
                    str2 = "gcj02";
                    if (parseInt != 66 && parseInt != 68) {
                        if (parseInt == 167) {
                            setLocationWhere(2);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject12 = jSONObject2.getJSONObject("content");
                    JSONObject jSONObject13 = jSONObject12.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject13.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject13.getString("x")));
                    setRadius(Float.parseFloat(jSONObject12.getString("radius")));
                    a(Boolean.valueOf(Boolean.parseBoolean(jSONObject12.getString("isCellChanged"))));
                }
                setCoorType(str2);
            } catch (Exception e14) {
                exc = e14;
                z = false;
                exc.printStackTrace();
                r3 = z;
                this.f40731a = r3;
                this.o = r3;
            }
        } catch (Exception e15) {
            z = false;
            exc = e15;
        }
    }

    private void a(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, bool) == null) {
            this.t = bool.booleanValue();
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

    public String getAdCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u.adcode : (String) invokeV.objValue;
    }

    public String getAddrStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.u.address : (String) invokeV.objValue;
    }

    public Address getAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.u : (Address) invokeV.objValue;
    }

    public double getAltitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40736f : invokeV.doubleValue;
    }

    public String getBuildingID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public String getBuildingName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public String getCity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.u.city : (String) invokeV.objValue;
    }

    public String getCityCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.u.cityCode : (String) invokeV.objValue;
    }

    public String getCoorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public String getCountry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.u.country : (String) invokeV.objValue;
    }

    public String getCountryCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.u.countryCode : (String) invokeV.objValue;
    }

    public long getDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.S : invokeV.longValue;
    }

    @Deprecated
    public float getDerect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.m : invokeV.floatValue;
    }

    public float getDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m : invokeV.floatValue;
    }

    public String getDistrict() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.u.district : (String) invokeV.objValue;
    }

    public Location getExtraLocation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            Bundle bundle = this.P;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    public double[] getFusionLocInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? this.P.getDoubleArray(str) : (double[]) invokeL.objValue;
    }

    public int getGpsAccuracyStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.Q : invokeV.intValue;
    }

    public int getGpsCheckStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.R : invokeV.intValue;
    }

    public int getIndoorLocationSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.H : invokeV.intValue;
    }

    public int getIndoorLocationSurpport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.F : invokeV.intValue;
    }

    public String getIndoorLocationSurpportBuidlingID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.J : (String) invokeV.objValue;
    }

    public String getIndoorLocationSurpportBuidlingName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.I : (String) invokeV.objValue;
    }

    public int getIndoorNetworkState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.G : invokeV.intValue;
    }

    public String getIndoorSurpportPolygon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.K : (String) invokeV.objValue;
    }

    public double getLatitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f40733c : invokeV.doubleValue;
    }

    public int getLocType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f40731a : invokeV.intValue;
    }

    public String getLocTypeDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.M : (String) invokeV.objValue;
    }

    public String getLocationDescribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public String getLocationID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.N : (String) invokeV.objValue;
    }

    public int getLocationWhere() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.A : invokeV.intValue;
    }

    public double getLongitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f40734d : invokeV.doubleValue;
    }

    public String getNetworkLocationType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public double getNrlLat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.U : invokeV.doubleValue;
    }

    public double getNrlLon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.V : invokeV.doubleValue;
    }

    public String getNrlResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.T : (String) invokeV.objValue;
    }

    public int getOperators() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.C : invokeV.intValue;
    }

    public List<Poi> getPoiList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.L : (List) invokeV.objValue;
    }

    public String getProvince() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.u.province : (String) invokeV.objValue;
    }

    public float getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f40740j : invokeV.floatValue;
    }

    public String getRetFields(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) ? this.P.getString(str) : (String) invokeL.objValue;
    }

    public String getRoadLocString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.O : (String) invokeV.objValue;
    }

    public int getSatelliteNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            this.k = true;
            return this.l;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public String getSemaAptag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public float getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f40738h : invokeV.floatValue;
    }

    public String getStreet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.u.street : (String) invokeV.objValue;
    }

    public String getStreetNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.u.streetNumber : (String) invokeV.objValue;
    }

    public String getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f40732b : (String) invokeV.objValue;
    }

    public int getUserIndoorState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.E : invokeV.intValue;
    }

    public String getVdrJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            Bundle bundle = this.P;
            if (bundle == null || !bundle.containsKey("vdr")) {
                return null;
            }
            return this.P.getString("vdr");
        }
        return (String) invokeV.objValue;
    }

    public boolean hasAddr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean hasAltitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.f40735e : invokeV.booleanValue;
    }

    public boolean hasRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.f40739i : invokeV.booleanValue;
    }

    public boolean hasSateNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean hasSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.f40737g : invokeV.booleanValue;
    }

    public boolean isCellChangeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean isInIndoorPark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.W : invokeV.booleanValue;
    }

    public boolean isIndoorLocMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public boolean isNrlAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? (this.V == Double.MIN_VALUE || this.U == Double.MIN_VALUE) ? false : true : invokeV.booleanValue;
    }

    public int isParkAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.z : invokeV.intValue;
    }

    public void setAddr(Address address) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, address) == null) || address == null) {
            return;
        }
        this.u = address;
        this.o = true;
    }

    public void setAddrStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.p = str;
            this.o = str != null;
        }
    }

    public void setAltitude(double d2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{Double.valueOf(d2)}) == null) || d2 >= 9999.0d) {
            return;
        }
        this.f40736f = d2;
        this.f40735e = true;
    }

    public void setBuildingID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.w = str;
        }
    }

    public void setBuildingName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.x = str;
        }
    }

    public void setCoorType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.n = str;
        }
    }

    public void setDelayTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048644, this, j2) == null) {
            this.S = j2;
        }
    }

    public void setDirection(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048645, this, f2) == null) {
            this.m = f2;
        }
    }

    public void setExtraLocation(String str, Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048646, this, str, location) == null) {
            if (this.P == null) {
                this.P = new Bundle();
            }
            this.P.putParcelable(str, location);
        }
    }

    public void setFloor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            this.v = str;
        }
    }

    public void setFusionLocInfo(String str, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048648, this, str, dArr) == null) {
            if (this.P == null) {
                this.P = new Bundle();
            }
            this.P.putDoubleArray(str, dArr);
        }
    }

    public void setGpsAccuracyStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i2) == null) {
            this.Q = i2;
        }
    }

    public void setGpsCheckStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            this.R = i2;
        }
    }

    public void setIndoorLocMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
            this.y = z;
        }
    }

    public void setIndoorLocationSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            this.H = i2;
        }
    }

    public void setIndoorLocationSurpport(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            this.F = i2;
        }
    }

    public void setIndoorNetworkState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            this.G = i2;
        }
    }

    public void setIndoorSurpportPolygon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, str) == null) {
            this.K = str;
        }
    }

    public void setLatitude(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048656, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f40733c = d2;
        }
    }

    public void setLocType(int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            this.f40731a = i2;
            if (i2 != 66) {
                if (i2 != 67) {
                    if (i2 == 161) {
                        str = "NetWork location successful!";
                    } else if (i2 == 162) {
                        str = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
                    } else if (i2 == 167) {
                        str = "NetWork location failed because baidu location service can not caculate the location!";
                    } else if (i2 != 505) {
                        switch (i2) {
                            case 61:
                                setLocTypeDescription("GPS location successful!");
                                setUserIndoorState(0);
                                return;
                            case 62:
                                str = "Location failed beacuse we can not get any loc information!";
                                break;
                            case 63:
                                break;
                            default:
                                str = "UnKnown!";
                                break;
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
        if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
            this.M = str;
        }
    }

    public void setLocationDescribe(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, str) == null) {
            this.q = str;
        }
    }

    public void setLocationID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            this.N = str;
        }
    }

    public void setLocationWhere(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i2) == null) {
            this.A = i2;
        }
    }

    public void setLongitude(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048662, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f40734d = d2;
        }
    }

    public void setNetworkLocationType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, str) == null) {
            this.B = str;
        }
    }

    public void setNrlData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
            this.T = str;
        }
    }

    public void setOperators(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i2) == null) {
            this.C = i2;
        }
    }

    public void setParkAvailable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048666, this, i2) == null) {
            this.z = i2;
        }
    }

    public void setPoiList(List<Poi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, list) == null) {
            this.L = list;
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048668, this, f2) == null) {
            this.f40740j = f2;
            this.f40739i = true;
        }
    }

    public void setRetFields(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048669, this, str, str2) == null) {
            if (this.P == null) {
                this.P = new Bundle();
            }
            this.P.putString(str, str2);
        }
    }

    public void setRoadLocString(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048670, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            String format = ((double) f2) > 0.001d ? String.format("%.2f", Float.valueOf(f2)) : "";
            String format2 = ((double) f3) > 0.001d ? String.format("%.2f", Float.valueOf(f3)) : "";
            String str = this.T;
            if (str != null) {
                this.O = String.format(Locale.US, "%s|%s,%s", str, format, format2);
            }
        }
    }

    public void setSatelliteNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048671, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048672, this, f2) == null) {
            this.f40738h = f2;
            this.f40737g = true;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, str) == null) {
            this.f40732b = str;
            setLocationID(k.a(str));
        }
    }

    public void setUserIndoorState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048674, this, i2) == null) {
            this.E = i2;
        }
    }

    public void setVdrJsonValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, str) == null) {
            if (this.P == null) {
                this.P = new Bundle();
            }
            this.P.putString("vdr", str);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048676, this, parcel, i2) == null) {
            parcel.writeInt(this.f40731a);
            parcel.writeString(this.f40732b);
            parcel.writeDouble(this.f40733c);
            parcel.writeDouble(this.f40734d);
            parcel.writeDouble(this.f40736f);
            parcel.writeFloat(this.f40738h);
            parcel.writeFloat(this.f40740j);
            parcel.writeInt(this.l);
            parcel.writeFloat(this.m);
            parcel.writeString(this.v);
            parcel.writeInt(this.z);
            parcel.writeString(this.w);
            parcel.writeString(this.x);
            parcel.writeString(this.B);
            parcel.writeString(this.u.province);
            parcel.writeString(this.u.city);
            parcel.writeString(this.u.district);
            parcel.writeString(this.u.street);
            parcel.writeString(this.u.streetNumber);
            parcel.writeString(this.u.cityCode);
            parcel.writeString(this.u.address);
            parcel.writeString(this.u.country);
            parcel.writeString(this.u.countryCode);
            parcel.writeString(this.u.adcode);
            parcel.writeInt(this.C);
            parcel.writeString(this.D);
            parcel.writeString(this.q);
            parcel.writeString(this.r);
            parcel.writeString(this.s);
            parcel.writeInt(this.A);
            parcel.writeString(this.M);
            parcel.writeInt(this.E);
            parcel.writeInt(this.F);
            parcel.writeInt(this.G);
            parcel.writeInt(this.H);
            parcel.writeString(this.I);
            parcel.writeString(this.J);
            parcel.writeString(this.K);
            parcel.writeInt(this.Q);
            parcel.writeString(this.N);
            parcel.writeInt(this.R);
            parcel.writeString(this.O);
            parcel.writeString(this.T);
            parcel.writeLong(this.S);
            parcel.writeDouble(this.U);
            parcel.writeDouble(this.V);
            parcel.writeBooleanArray(new boolean[]{this.f40735e, this.f40737g, this.f40739i, this.k, this.o, this.t, this.y, this.W});
            parcel.writeList(this.L);
            parcel.writeBundle(this.P);
        }
    }
}
