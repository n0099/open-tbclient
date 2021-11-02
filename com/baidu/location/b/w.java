package com.baidu.location.b;

import android.location.Location;
import android.net.wifi.ScanResult;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.Jni;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public static w A;
    public static long C;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<String> f39073b;

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<String> f39074c;

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<String> f39075d;

    /* renamed from: e  reason: collision with root package name */
    public static String f39076e;

    /* renamed from: f  reason: collision with root package name */
    public static String f39077f;

    /* renamed from: g  reason: collision with root package name */
    public static String f39078g;

    /* renamed from: h  reason: collision with root package name */
    public static String f39079h;

    /* renamed from: i  reason: collision with root package name */
    public static String f39080i;
    public static File j;
    public static int k;
    public static int l;
    public static int m;
    public static int n;
    public static double o;
    public static double p;
    public static double q;
    public static double r;
    public static int s;
    public static int t;
    public static int u;
    public static Location v;
    public static Location w;
    public static Location x;
    public static com.baidu.location.c.h y;
    public transient /* synthetic */ FieldHolder $fh;
    public int B;

    /* renamed from: a  reason: collision with root package name */
    public long f39081a;
    public a z;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.location.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f39082a;

        /* renamed from: b  reason: collision with root package name */
        public int f39083b;

        /* renamed from: c  reason: collision with root package name */
        public int f39084c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ w f39085d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f39086e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f39087f;

        public a(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39085d = wVar;
            this.f39082a = false;
            this.f39083b = 0;
            this.f39084c = 0;
            this.f39086e = new ArrayList<>();
            this.f39087f = true;
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.e
        public void a() {
            Map<String, Object> map;
            StringBuilder sb;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39203h = com.baidu.location.e.k.e();
                if (this.f39083b != 1) {
                    this.f39203h = com.baidu.location.e.k.g();
                }
                this.f39204i = 2;
                if (this.f39086e != null) {
                    for (int i2 = 0; i2 < this.f39086e.size(); i2++) {
                        if (this.f39083b == 1) {
                            map = this.k;
                            sb = new StringBuilder();
                            str = "cldc[";
                        } else {
                            map = this.k;
                            sb = new StringBuilder();
                            str = "cltr[";
                        }
                        sb.append(str);
                        sb.append(i2);
                        sb.append(PreferencesUtil.RIGHT_MOUNT);
                        map.put(sb.toString(), this.f39086e.get(i2));
                    }
                    this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
                    if (this.f39083b != 1) {
                        this.k.put("qt", "cltrg");
                    }
                }
            }
        }

        @Override // com.baidu.location.e.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z && this.j != null) {
                    ArrayList<String> arrayList = this.f39086e;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(this.j);
                        if (jSONObject.has("ison") && jSONObject.getInt("ison") == 0) {
                            this.f39087f = false;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                Map<String, Object> map = this.k;
                if (map != null) {
                    map.clear();
                }
                this.f39082a = false;
            }
        }

        public synchronized void b() {
            ExecutorService c2;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    if (this.f39082a) {
                        return;
                    }
                    if (com.baidu.location.e.e.p > 4 && this.f39084c < com.baidu.location.e.e.p) {
                        this.f39084c++;
                        return;
                    }
                    this.f39084c = 0;
                    this.f39082a = true;
                    this.f39083b = 0;
                    try {
                        if (this.f39086e == null || this.f39086e.size() < 1) {
                            if (this.f39086e == null) {
                                this.f39086e = new ArrayList<>();
                            }
                            this.f39083b = 0;
                            int i2 = 0;
                            while (true) {
                                String str3 = null;
                                String b2 = this.f39083b < 2 ? w.b() : null;
                                if (b2 == null && this.f39083b != 1 && this.f39087f) {
                                    this.f39083b = 2;
                                    try {
                                        str3 = g.a();
                                    } catch (Exception unused) {
                                    }
                                } else {
                                    this.f39083b = 1;
                                    str3 = b2;
                                }
                                if (str3 == null) {
                                    break;
                                } else if (!str3.contains("err!")) {
                                    this.f39086e.add(str3);
                                    i2 += str3.length();
                                    if (i2 >= com.baidu.location.e.a.f39171i) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (this.f39086e == null || this.f39086e.size() < 1) {
                            if (this.f39086e != null) {
                                this.f39086e.clear();
                            }
                            this.f39082a = false;
                            return;
                        }
                        if (this.f39083b != 1) {
                            c2 = v.a().c();
                            if (c2 != null) {
                                str2 = com.baidu.location.e.k.g();
                                a(c2, str2);
                            } else {
                                str = com.baidu.location.e.k.g();
                                b(str);
                            }
                        } else {
                            c2 = v.a().c();
                            if (c2 != null) {
                                str2 = com.baidu.location.e.k.f39220f;
                                a(c2, str2);
                            } else {
                                str = com.baidu.location.e.k.f39220f;
                                b(str);
                            }
                        }
                    } catch (Exception unused2) {
                        if (this.f39086e != null) {
                            this.f39086e.clear();
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037723965, "Lcom/baidu/location/b/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037723965, "Lcom/baidu/location/b/w;");
                return;
            }
        }
        f39073b = new ArrayList<>();
        f39074c = new ArrayList<>();
        f39075d = new ArrayList<>();
        f39076e = com.baidu.location.e.j.f39213a + "/yo.dat";
        f39077f = com.baidu.location.e.j.f39213a + "/yoh.dat";
        f39078g = com.baidu.location.e.j.f39213a + "/yom.dat";
        f39079h = com.baidu.location.e.j.f39213a + "/yol.dat";
        f39080i = com.baidu.location.e.j.f39213a + "/yor.dat";
        j = null;
        k = 8;
        l = 8;
        m = 16;
        n = 1024;
        o = 0.0d;
        p = 0.1d;
        q = 30.0d;
        r = 100.0d;
        s = 0;
        t = 64;
        u = 128;
        v = null;
        w = null;
        x = null;
        y = null;
        A = null;
        C = 0L;
    }

    public w() {
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
        this.z = null;
        this.B = 0;
        this.f39081a = 0L;
        this.z = new a(this);
        this.B = 0;
    }

    public static synchronized int a(List<String> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, list, i2)) == null) {
            synchronized (w.class) {
                if (list != null && i2 <= 256) {
                    if (i2 >= 0) {
                        try {
                            if (j == null) {
                                File file = new File(f39076e);
                                j = file;
                                if (!file.exists()) {
                                    j = null;
                                    return -2;
                                }
                            }
                            RandomAccessFile randomAccessFile = new RandomAccessFile(j, "rw");
                            if (randomAccessFile.length() < 1) {
                                randomAccessFile.close();
                                return -3;
                            }
                            long j2 = i2;
                            randomAccessFile.seek(j2);
                            int readInt = randomAccessFile.readInt();
                            int readInt2 = randomAccessFile.readInt();
                            int readInt3 = randomAccessFile.readInt();
                            int readInt4 = randomAccessFile.readInt();
                            long readLong = randomAccessFile.readLong();
                            long j3 = readLong;
                            if (a(readInt, readInt2, readInt3, readInt4, readLong)) {
                                int i3 = 1;
                                if (readInt2 >= 1) {
                                    byte[] bArr = new byte[n];
                                    int i4 = k;
                                    while (i4 > 0 && readInt2 > 0) {
                                        byte[] bArr2 = bArr;
                                        long j4 = j3;
                                        randomAccessFile.seek(((((readInt + readInt2) - i3) % readInt3) * readInt4) + j4);
                                        int readInt5 = randomAccessFile.readInt();
                                        if (readInt5 > 0 && readInt5 < readInt4) {
                                            randomAccessFile.read(bArr2, 0, readInt5);
                                            int i5 = readInt5 - 1;
                                            if (bArr2[i5] == 0) {
                                                list.add(new String(bArr2, 0, i5));
                                            }
                                        }
                                        i4--;
                                        readInt2--;
                                        j3 = j4;
                                        bArr = bArr2;
                                        i3 = 1;
                                    }
                                    randomAccessFile.seek(j2);
                                    randomAccessFile.writeInt(readInt);
                                    randomAccessFile.writeInt(readInt2);
                                    randomAccessFile.writeInt(readInt3);
                                    randomAccessFile.writeInt(readInt4);
                                    randomAccessFile.writeLong(j3);
                                    randomAccessFile.close();
                                    return k - i4;
                                }
                            }
                            randomAccessFile.close();
                            return -4;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return -5;
                        }
                    }
                }
                return -1;
            }
        }
        return invokeLI.intValue;
    }

    public static synchronized w a() {
        InterceptResult invokeV;
        w wVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (w.class) {
                if (A == null) {
                    A = new w();
                }
                wVar = A;
            }
            return wVar;
        }
        return (w) invokeV.objValue;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        String str;
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            String str2 = null;
            if (i2 == 1) {
                str = f39077f;
                arrayList = f39073b;
            } else if (i2 == 2) {
                str = f39078g;
                arrayList = f39074c;
            } else {
                if (i2 == 3) {
                    str = f39079h;
                } else if (i2 != 4) {
                    return null;
                } else {
                    str = f39080i;
                }
                arrayList = f39075d;
            }
            if (arrayList == null) {
                return null;
            }
            if (arrayList.size() < 1) {
                a(str, arrayList);
            }
            synchronized (w.class) {
                int size = arrayList.size();
                if (size > 0) {
                    int i3 = size - 1;
                    try {
                        String str3 = arrayList.get(i3);
                        try {
                            arrayList.remove(i3);
                        } catch (Exception unused) {
                        }
                        str2 = str3;
                    } catch (Exception unused2) {
                    }
                }
            }
            return str2;
        }
        return (String) invokeI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
        if (r15 != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0020, code lost:
        if (r15 != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d2 A[EDGE_INSN: B:55:0x00d2->B:44:0x00d2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i2, boolean z) {
        String str;
        ArrayList<String> arrayList;
        File file;
        int size;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) {
            return;
        }
        try {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        str = f39079h;
                    } else if (i2 != 4) {
                        return;
                    } else {
                        str = f39080i;
                        if (!z) {
                            return;
                        }
                    }
                    arrayList = f39075d;
                    file = new File(str);
                    if (!file.exists()) {
                        d(str);
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(4L);
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    int readInt4 = randomAccessFile.readInt();
                    int readInt5 = randomAccessFile.readInt();
                    size = arrayList.size();
                    while (true) {
                        i3 = 0;
                        if (size <= l) {
                            break;
                        }
                        if (z) {
                            readInt5++;
                        }
                        if (readInt3 >= readInt) {
                            if (!z) {
                                i3 = 1;
                                break;
                            }
                            randomAccessFile.seek((readInt4 * readInt2) + 128);
                            byte[] bytes = (arrayList.get(0) + (char) 0).getBytes();
                            randomAccessFile.writeInt(bytes.length);
                            randomAccessFile.write(bytes, 0, bytes.length);
                            arrayList.remove(0);
                            int i4 = readInt4 + 1;
                            if (i4 <= readInt3) {
                                i3 = i4;
                            }
                            readInt4 = i3;
                        } else {
                            randomAccessFile.seek((readInt2 * readInt3) + 128);
                            byte[] bytes2 = (arrayList.get(0) + (char) 0).getBytes();
                            randomAccessFile.writeInt(bytes2.length);
                            randomAccessFile.write(bytes2, 0, bytes2.length);
                            arrayList.remove(0);
                            readInt3++;
                        }
                        size--;
                    }
                    randomAccessFile.seek(12L);
                    randomAccessFile.writeInt(readInt3);
                    randomAccessFile.writeInt(readInt4);
                    randomAccessFile.writeInt(readInt5);
                    randomAccessFile.close();
                    if (i3 == 0 || i2 >= 4) {
                        return;
                    }
                    a(i2 + 1, true);
                    return;
                }
                str = f39078g;
                arrayList = f39074c;
                file = new File(str);
                if (!file.exists()) {
                }
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                randomAccessFile2.seek(4L);
                int readInt6 = randomAccessFile2.readInt();
                int readInt22 = randomAccessFile2.readInt();
                int readInt32 = randomAccessFile2.readInt();
                int readInt42 = randomAccessFile2.readInt();
                int readInt52 = randomAccessFile2.readInt();
                size = arrayList.size();
                while (true) {
                    i3 = 0;
                    if (size <= l) {
                    }
                    size--;
                }
                randomAccessFile2.seek(12L);
                randomAccessFile2.writeInt(readInt32);
                randomAccessFile2.writeInt(readInt42);
                randomAccessFile2.writeInt(readInt52);
                randomAccessFile2.close();
                if (i3 == 0) {
                    return;
                }
                return;
            }
            str = f39077f;
            if (z) {
                return;
            }
            RandomAccessFile randomAccessFile22 = new RandomAccessFile(file, "rw");
            randomAccessFile22.seek(4L);
            int readInt62 = randomAccessFile22.readInt();
            int readInt222 = randomAccessFile22.readInt();
            int readInt322 = randomAccessFile22.readInt();
            int readInt422 = randomAccessFile22.readInt();
            int readInt522 = randomAccessFile22.readInt();
            size = arrayList.size();
            while (true) {
                i3 = 0;
                if (size <= l) {
                }
                size--;
            }
            randomAccessFile22.seek(12L);
            randomAccessFile22.writeInt(readInt322);
            randomAccessFile22.writeInt(readInt422);
            randomAccessFile22.writeInt(readInt522);
            randomAccessFile22.close();
            if (i3 == 0) {
            }
        } catch (Exception unused) {
            return;
        }
        arrayList = f39073b;
        file = new File(str);
        if (!file.exists()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.baidu.location.c.a aVar, com.baidu.location.c.h hVar, Location location, String str) {
        StringBuilder sb;
        String a2;
        StringBuilder sb2;
        String a3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, aVar, hVar, location, str) != null) {
            return;
        }
        if ((com.baidu.location.e.k.v == 3 && !a(location, hVar) && !a(location, false)) || aVar == null || aVar.c()) {
            return;
        }
        if (aVar != null && aVar.a()) {
            if (!a(location, hVar)) {
                hVar = null;
            }
            String a4 = com.baidu.location.e.k.a(aVar, hVar, location, str, 1);
            if (a4 != null) {
                a(Jni.encode(a4));
                w = location;
                v = location;
                if (hVar != null) {
                    y = hVar;
                }
            }
        } else if (hVar != null && hVar.l() && a(location, hVar)) {
            if (!a(location) && !com.baidu.location.c.b.a().d()) {
                sb2 = new StringBuilder();
                sb2.append("&cfr=1");
            } else if (a(location) || !com.baidu.location.c.b.a().d()) {
                if (com.baidu.location.c.b.a().d()) {
                    sb2 = new StringBuilder();
                    sb2.append("&cfr=2");
                }
                a3 = com.baidu.location.e.k.a(aVar, hVar, location, str, 2);
                if (a3 == null) {
                    b(Jni.encode(a3));
                    x = location;
                    v = location;
                    if (hVar != null) {
                        y = hVar;
                        return;
                    }
                    return;
                }
                return;
            } else {
                sb2 = new StringBuilder();
                sb2.append("&cfr=3");
            }
            sb2.append(str);
            str = sb2.toString();
            a3 = com.baidu.location.e.k.a(aVar, hVar, location, str, 2);
            if (a3 == null) {
            }
        } else {
            if (a(location) || com.baidu.location.c.b.a().d()) {
                if (!a(location) && com.baidu.location.c.b.a().d()) {
                    str = "&cfr=3" + str;
                } else if (com.baidu.location.c.b.a().d()) {
                    sb = new StringBuilder();
                    sb.append("&cfr=2");
                }
                if (!a(location, hVar)) {
                    hVar = null;
                }
                if ((aVar == null || hVar != null) && (a2 = com.baidu.location.e.k.a(aVar, hVar, location, str, 3)) != null) {
                    c(Jni.encode(a2));
                    v = location;
                    if (hVar == null) {
                        y = hVar;
                        return;
                    }
                    return;
                }
                return;
            }
            sb = new StringBuilder();
            sb.append("&cfr=1");
            sb.append(str);
            str = sb.toString();
            if (!a(location, hVar)) {
            }
            if (aVar == null) {
            }
            c(Jni.encode(a2));
            v = location;
            if (hVar == null) {
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            e(str);
        }
    }

    public static boolean a(int i2, int i3, int i4, int i5, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j2)})) == null) ? i2 >= 0 && i2 < i4 && i3 >= 0 && i3 <= i4 && i4 >= 0 && i4 <= 1024 && i5 >= 128 && i5 <= 1024 : invokeCommon.booleanValue;
    }

    public static boolean a(Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, location)) == null) {
            if (location == null) {
                return false;
            }
            Location location2 = w;
            if (location2 == null || v == null) {
                w = location;
                return true;
            }
            double distanceTo = location.distanceTo(location2);
            return ((double) location.distanceTo(v)) > (((((double) com.baidu.location.e.k.T) * distanceTo) * distanceTo) + (((double) com.baidu.location.e.k.U) * distanceTo)) + ((double) com.baidu.location.e.k.V);
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Location location, com.baidu.location.c.h hVar) {
        InterceptResult invokeLL;
        List<ScanResult> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, location, hVar)) == null) {
            boolean z = false;
            if (location != null && hVar != null && (list = hVar.f39133a) != null && !list.isEmpty()) {
                if (hVar.b(y)) {
                    return false;
                }
                z = true;
                if (x == null) {
                    x = location;
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Location location, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, location, z)) == null) ? com.baidu.location.c.e.a(v, location, z) : invokeLZ.booleanValue;
    }

    public static boolean a(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, list)) == null) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(8L);
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    byte[] bArr = new byte[n];
                    int i2 = l + 1;
                    boolean z = false;
                    while (i2 > 0 && readInt2 > 0) {
                        if (readInt2 < readInt3) {
                            readInt3 = 0;
                        }
                        try {
                            randomAccessFile.seek(((readInt2 - 1) * readInt) + 128);
                            int readInt4 = randomAccessFile.readInt();
                            if (readInt4 > 0 && readInt4 < readInt) {
                                randomAccessFile.read(bArr, 0, readInt4);
                                int i3 = readInt4 - 1;
                                if (bArr[i3] == 0) {
                                    list.add(0, new String(bArr, 0, i3));
                                    z = true;
                                }
                            }
                            i2--;
                            readInt2--;
                        } catch (Exception unused) {
                            return z;
                        }
                    }
                    randomAccessFile.seek(12L);
                    randomAccessFile.writeInt(readInt2);
                    randomAccessFile.writeInt(readInt3);
                    randomAccessFile.close();
                    return z;
                } catch (Exception unused2) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? f() : (String) invokeV.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            e(str);
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            e(str);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            l = 0;
            a(1, false);
            a(2, false);
            a(3, false);
            l = 8;
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    return;
                }
                File file2 = new File(com.baidu.location.e.j.f39213a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    file = null;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeInt(32);
                randomAccessFile.writeInt(2048);
                randomAccessFile.writeInt(1040);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            File file = new File(f39078g);
            String str = null;
            if (file.exists()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(20L);
                    int readInt = randomAccessFile.readInt();
                    if (readInt > 128) {
                        String str2 = "&p1=" + readInt;
                        try {
                            randomAccessFile.seek(20L);
                            randomAccessFile.writeInt(0);
                            randomAccessFile.close();
                            return str2;
                        } catch (Exception unused) {
                            str = str2;
                        }
                    } else {
                        randomAccessFile.close();
                    }
                } catch (Exception unused2) {
                }
            }
            File file2 = new File(f39079h);
            if (file2.exists()) {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                    randomAccessFile2.seek(20L);
                    int readInt2 = randomAccessFile2.readInt();
                    if (readInt2 > 256) {
                        String str3 = "&p2=" + readInt2;
                        try {
                            randomAccessFile2.seek(20L);
                            randomAccessFile2.writeInt(0);
                            randomAccessFile2.close();
                            return str3;
                        } catch (Exception unused3) {
                            str = str3;
                        }
                    } else {
                        randomAccessFile2.close();
                    }
                } catch (Exception unused4) {
                }
            }
            File file3 = new File(f39080i);
            if (file3.exists()) {
                try {
                    RandomAccessFile randomAccessFile3 = new RandomAccessFile(file3, "rw");
                    randomAccessFile3.seek(20L);
                    int readInt3 = randomAccessFile3.readInt();
                    if (readInt3 > 512) {
                        String str4 = "&p3=" + readInt3;
                        try {
                            randomAccessFile3.seek(20L);
                            randomAccessFile3.writeInt(0);
                            randomAccessFile3.close();
                            return str4;
                        } catch (Exception unused5) {
                            str = str4;
                        }
                    } else {
                        randomAccessFile3.close();
                    }
                } catch (Exception unused6) {
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static synchronized void e(String str) {
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            synchronized (w.class) {
                if (str.contains("err!")) {
                    return;
                }
                int i2 = com.baidu.location.e.k.q;
                if (i2 == 1) {
                    arrayList = f39073b;
                } else if (i2 == 2) {
                    arrayList = f39074c;
                } else if (i2 != 3) {
                    return;
                } else {
                    arrayList = f39075d;
                }
                if (arrayList == null) {
                    return;
                }
                if (arrayList.size() <= m) {
                    arrayList.add(str);
                }
                if (arrayList.size() >= m) {
                    a(i2, false);
                }
                while (arrayList.size() > m) {
                    arrayList.remove(0);
                }
            }
        }
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            String str = null;
            for (int i2 = 1; i2 < 5; i2++) {
                str = a(i2);
                if (str != null) {
                    return str;
                }
            }
            a(f39075d, t);
            if (f39075d.size() > 0) {
                str = f39075d.get(0);
                f39075d.remove(0);
            }
            if (str != null) {
                return str;
            }
            a(f39075d, s);
            if (f39075d.size() > 0) {
                str = f39075d.get(0);
                f39075d.remove(0);
            }
            if (str != null) {
                return str;
            }
            a(f39075d, u);
            if (f39075d.size() > 0) {
                String str2 = f39075d.get(0);
                f39075d.remove(0);
                return str2;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && com.baidu.location.c.i.i() && !com.baidu.location.e.k.b()) {
            this.z.b();
        }
    }
}
