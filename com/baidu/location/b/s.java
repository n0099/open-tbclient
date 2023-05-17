package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public static final double[] a;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, c> b;
    public HashMap<String, String> c;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static s a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(820179492, "Lcom/baidu/location/b/s$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(820179492, "Lcom/baidu/location/b/s$a;");
                    return;
                }
            }
            a = new s();
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public double b;
        public final /* synthetic */ s c;

        public b(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sVar;
            this.a = 0;
            this.b = 0.0d;
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;
        public boolean b;
        public boolean c;
        public long d;
        public int e;
        public int f;
        public ArrayList<String> g;
        public ArrayList<Integer> h;
        public int i;
        public double j;
        public double k;
        public double l;
        public int m;
        public int n;
        public b o;

        public c(s sVar, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
            a(i, i2);
            this.i = 0;
            this.j = 0.0d;
            this.k = 0.0d;
            this.l = 0.0d;
            this.m = 0;
            this.n = 0;
            this.o = new b(sVar);
        }

        private b a(int i, double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Double.valueOf(d)})) == null) {
                b a = a(s.a);
                d = (d < -1.0E9d || 1.0E9d < d) ? 0.0d : 0.0d;
                int i2 = (int) d;
                a.a += (i * 604800) + i2;
                a.b = d - i2;
                return a;
            }
            return (b) invokeCommon.objValue;
        }

        private b a(double[] dArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, dArr)) == null) {
                int[] iArr = {1, 32, 60, 91, 121, Cea708Decoder.COMMAND_DF0, 182, 213, GDiffPatcher.COPY_UBYTE_UBYTE, 274, 305, 335};
                b bVar = new b(this.a);
                int i = 0;
                int i2 = (int) dArr[0];
                int i3 = (int) dArr[1];
                int i4 = (int) dArr[2];
                if (i2 >= 1970 && 2099 >= i2 && i3 >= 1 && 12 >= i3) {
                    int i5 = (((((i2 - 1970) * 365) + ((i2 - 1969) / 4)) + iArr[i3 - 1]) + i4) - 2;
                    if (i2 % 4 == 0 && i3 >= 3) {
                        i = 1;
                    }
                    int floor = (int) Math.floor(dArr[5]);
                    bVar.a = ((i5 + i) * 86400) + (((int) dArr[3]) * 3600) + (((int) dArr[4]) * 60) + floor;
                    bVar.b = dArr[5] - floor;
                }
                return bVar;
            }
            return (b) invokeL.objValue;
        }

        @TargetApi(24)
        private String a(GnssNavigationMessage gnssNavigationMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, gnssNavigationMessage)) == null) {
                StringBuilder sb = new StringBuilder();
                byte[] data = gnssNavigationMessage.getData();
                int length = data.length;
                for (int i = 0; i < length; i++) {
                    sb.append(String.format("%8s", Integer.toBinaryString(data[i] & 255)).replace(WebvttCueParser.CHAR_SPACE, TransactionIdCreater.FILL_BYTE));
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(65541, this) != null) {
                return;
            }
            if (this.g.size() != 0) {
                for (int i = 0; i < this.g.size(); i++) {
                    if (!this.g.get(i).contains("None")) {
                    }
                }
                z = true;
                if (z) {
                    this.c = false;
                    return;
                } else {
                    this.c = true;
                    return;
                }
            }
            z = false;
            if (z) {
            }
        }

        private void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(65542, this, i, i2) == null) {
                int i3 = this.f;
                int i4 = 5;
                if (i3 != 257 && i3 != 769) {
                    i4 = i3 != 1537 ? i3 != 1281 ? i3 != 1282 ? 0 : 10 : 3 : 6;
                }
                ArrayList<String> arrayList = this.g;
                if (arrayList != null) {
                    arrayList.clear();
                } else {
                    this.g = new ArrayList<>();
                }
                ArrayList<Integer> arrayList2 = this.h;
                if (arrayList2 != null) {
                    arrayList2.clear();
                } else {
                    this.h = new ArrayList<>();
                }
                for (int i5 = 0; i5 < i4; i5++) {
                    this.g.add("None");
                }
                this.e = i;
                this.f = i2;
                this.b = false;
                this.c = false;
                this.d = 0L;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(24)
        public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(65543, this, gnssNavigationMessage, j) == null) {
                int type = gnssNavigationMessage.getType();
                int svid = gnssNavigationMessage.getSvid();
                int submessageId = gnssNavigationMessage.getSubmessageId();
                byte[] data = gnssNavigationMessage.getData();
                if (j - this.d > IMLikeRequest.TIME_INTERVAL || this.b || this.g.size() == 0 || type != this.f || svid != this.e) {
                    a(svid, type);
                }
                if ((type == 1282 || type == 1281) && !b()) {
                    a(svid, type);
                }
                if (this.g.size() == 0) {
                    return;
                }
                boolean z = true;
                int i = this.f == 1537 ? 0 : 1;
                if (this.f == 1282) {
                    if (submessageId != 1) {
                        return;
                    }
                    e(b(gnssNavigationMessage));
                    submessageId = this.m;
                }
                int i2 = submessageId - i;
                if (i2 >= this.g.size()) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (byte b : data) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append((int) b);
                }
                this.g.set(i2, sb.toString());
                if (type == 1281 || type == 1282) {
                    this.h.add(Integer.valueOf(i2));
                }
                if (this.f == 1537) {
                    a(a(gnssNavigationMessage));
                }
                a();
                this.d = j;
            }
        }

        private void a(String str) {
            StringBuilder sb;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
                char charAt = str.charAt(0);
                char charAt2 = str.charAt(120);
                if (charAt == '1' && charAt2 == '0') {
                    sb = new StringBuilder();
                    sb.append(str.substring(2, 18));
                    i = 234;
                } else if (charAt != '0' || charAt2 != '1') {
                    return;
                } else {
                    sb = new StringBuilder();
                    sb.append(str.substring(2, 114));
                    i = 138;
                }
                sb.append(str.substring(122, i));
                String sb2 = sb.toString();
                int parseInt = Integer.parseInt(sb2.substring(0, 6), 2);
                if (parseInt == 0) {
                    b(sb2);
                } else if (parseInt == 1) {
                    c(sb2);
                } else if (parseInt == 4) {
                    d(sb2);
                }
            }
        }

        @TargetApi(24)
        private String b(GnssNavigationMessage gnssNavigationMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, gnssNavigationMessage)) == null) {
                StringBuilder sb = new StringBuilder();
                byte[] data = gnssNavigationMessage.getData();
                int length = data.length;
                for (int i = 0; i < length; i++) {
                    String replace = String.format("%8s", Integer.toBinaryString(data[i] & 255)).replace(WebvttCueParser.CHAR_SPACE, TransactionIdCreater.FILL_BYTE);
                    if (i % 4 == 0) {
                        replace = replace.substring(2, 8);
                    }
                    sb.append(replace);
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        private void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
                this.i = Integer.parseInt(str.substring(96, 108), 2);
                this.j = Long.parseLong(str.substring(108, 128), 2);
            }
        }

        private boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
                if (this.h == null) {
                    return false;
                }
                for (int i = 0; i < this.h.size(); i++) {
                    if (this.h.get(i).intValue() != i) {
                        return false;
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.c) {
                    if (this.f == 1537) {
                        d();
                    }
                    sb.append(this.o.a);
                    sb.append('|');
                    boolean z = true;
                    for (int i = 0; i < this.g.size(); i++) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(',');
                        }
                        sb.append(this.g.get(i));
                    }
                    this.b = true;
                    return sb.toString();
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        private void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65550, this, str) == null) {
                this.k = Long.parseLong(str.substring(16, 30), 2) * 60.0d;
            }
        }

        private void d() {
            b a;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65551, this) == null) {
                b a2 = a(this.i, this.j);
                double d = ((a.a - a2.a) + a(this.i, this.k).b) - a2.b;
                if (d <= 302400.0d) {
                    if (d < -302400.0d) {
                        i = this.i + 1;
                    }
                    this.o = a(this.i, this.l);
                    this.n = this.i + 1024;
                }
                i = this.i - 1;
                this.i = i;
                this.o = a(this.i, this.l);
                this.n = this.i + 1024;
            }
        }

        private void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65552, this, str) == null) {
                this.l = Long.parseLong(str.substring(54, 68), 2) * 60;
            }
        }

        private void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65553, this, str) == null) {
                this.m = Integer.parseInt(str.substring(42, 46), 2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037723841, "Lcom/baidu/location/b/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037723841, "Lcom/baidu/location/b/s;");
                return;
            }
        }
        a = new double[]{1999.0d, 8.0d, 22.0d, 0.0d, 0.0d, 0.0d};
    }

    public s() {
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
        this.b = new HashMap<>();
        this.c = new HashMap<>();
    }

    public static s a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (s) invokeV.objValue;
    }

    @TargetApi(24)
    public void a(GnssNavigationMessage gnssNavigationMessage, long j) {
        HashMap<String, c> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, gnssNavigationMessage, j) == null) {
            int svid = gnssNavigationMessage.getSvid();
            int type = gnssNavigationMessage.getType();
            String str = (type != 257 ? type != 769 ? type != 1537 ? type != 1281 ? type != 1282 ? "none" : "CT" : "CO" : ExifInterface.LONGITUDE_EAST : "R" : "G") + svid;
            if (str.contains("none") || (hashMap = this.b) == null) {
                return;
            }
            if (!hashMap.containsKey(str)) {
                this.b.put(str, new c(this, svid, type));
            }
            this.b.get(str).a(gnssNavigationMessage, j);
        }
    }

    public ArrayList<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (Map.Entry<String, c> entry : this.b.entrySet()) {
                String key = entry.getKey();
                String c2 = entry.getValue().c();
                if (c2 != null && c2.length() != 0) {
                    if (!this.c.containsKey(key)) {
                        this.c.put(key, c2);
                    } else if (c2.substring(0, 100).equals(this.c.get(key).substring(0, 100))) {
                    }
                    arrayList.add(key + '|' + c2);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
