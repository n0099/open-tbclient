package com.baidu.location.b;

import android.app.ActivityManager;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.Jni;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f34997f = "0";

    /* renamed from: j  reason: collision with root package name */
    public static d f34998j;
    public transient /* synthetic */ FieldHolder $fh;
    public a A;
    public boolean B;
    public boolean C;
    public int D;
    public float E;
    public float F;
    public long G;
    public int H;
    public Handler I;
    public byte[] J;
    public byte[] K;
    public int L;
    public List<Byte> M;
    public boolean N;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public Location f34999b;

    /* renamed from: c  reason: collision with root package name */
    public Location f35000c;

    /* renamed from: d  reason: collision with root package name */
    public StringBuilder f35001d;

    /* renamed from: e  reason: collision with root package name */
    public long f35002e;

    /* renamed from: g  reason: collision with root package name */
    public int f35003g;

    /* renamed from: h  reason: collision with root package name */
    public double f35004h;

    /* renamed from: i  reason: collision with root package name */
    public double f35005i;
    public int k;
    public double l;
    public String m;
    public int n;
    public int o;
    public int p;
    public int q;
    public double r;
    public double s;
    public double t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public long z;

    /* loaded from: classes10.dex */
    public class a extends com.baidu.location.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f35006b;

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
            this.f35006b = dVar;
            this.a = null;
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35185h = "http://loc.map.baidu.com/cc.php";
                String encode = Jni.encode(this.a);
                this.a = null;
                this.k.put("q", encode);
            }
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a = str;
                b(v.a().c());
            }
        }

        @Override // com.baidu.location.e.e
        public void a(boolean z) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (z && (str = this.f35187j) != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.put("prod", com.baidu.location.e.b.f35159e);
                        jSONObject.put("uptime", System.currentTimeMillis());
                        this.f35006b.e(jSONObject.toString());
                    } catch (Exception unused) {
                    }
                }
                Map<String, Object> map = this.k;
                if (map != null) {
                    map.clear();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037723376, "Lcom/baidu/location/b/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037723376, "Lcom/baidu/location/b/d;");
        }
    }

    public d() {
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
        this.k = 1;
        this.l = 0.699999988079071d;
        this.m = "3G|4G";
        this.n = 1;
        this.o = 307200;
        this.p = 15;
        this.q = 1;
        this.r = 3.5d;
        this.s = 3.0d;
        this.t = 0.5d;
        this.u = 300;
        this.v = 60;
        this.w = 0;
        this.x = 60;
        this.y = 0;
        this.z = 0L;
        this.A = null;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = 0L;
        this.H = 500;
        this.a = 0L;
        this.f34999b = null;
        this.f35000c = null;
        this.f35001d = null;
        this.f35002e = 0L;
        this.I = null;
        this.J = new byte[4];
        this.K = null;
        this.L = 0;
        this.M = null;
        this.N = false;
        this.f35003g = 0;
        this.f35004h = 116.22345545d;
        this.f35005i = 40.245667323d;
        this.I = new Handler();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f34998j == null) {
                f34998j = new d();
            }
            return f34998j;
        }
        return (d) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, file, str)) == null) {
            String uuid = UUID.randomUUID().toString();
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "utf-8");
                httpsURLConnection.setRequestProperty("connection", IntentConfig.CLOSE);
                httpsURLConnection.setRequestProperty("Content-Type", IMAudioTransRequest.CONTENT_TYPE + ";boundary=" + uuid);
                if (file == null || !file.exists()) {
                    return "0";
                }
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("--");
                stringBuffer.append(uuid);
                stringBuffer.append("\r\n");
                stringBuffer.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + file.getName() + "\"\r\n");
                StringBuilder sb = new StringBuilder();
                sb.append("Content-Type: application/octet-stream; charset=utf-8");
                sb.append("\r\n");
                stringBuffer.append(sb.toString());
                stringBuffer.append("\r\n");
                dataOutputStream.write(stringBuffer.toString().getBytes());
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                dataOutputStream.write("\r\n".getBytes());
                dataOutputStream.write(("--" + uuid + "--\r\n").getBytes());
                dataOutputStream.flush();
                dataOutputStream.close();
                int responseCode = httpsURLConnection.getResponseCode();
                outputStream.close();
                httpsURLConnection.disconnect();
                int i2 = this.y + 400;
                this.y = i2;
                c(i2);
                return responseCode == 200 ? "1" : "0";
            } catch (MalformedURLException | IOException unused) {
                return "0";
            }
        }
        return (String) invokeLL.objValue;
    }

    private boolean a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, context)) == null) {
            boolean z = false;
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.processName.equals(str)) {
                            int i2 = runningAppProcessInfo.importance;
                            if (i2 == 200 || i2 == 100) {
                                z = true;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    private byte[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) ? new byte[]{(byte) (i2 & 255), (byte) ((65280 & i2) >> 8), (byte) ((16711680 & i2) >> 16), (byte) ((i2 & (-16777216)) >> 24)} : (byte[]) invokeI.objValue;
    }

    private byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            if (str == null) {
                return null;
            }
            byte[] bytes = str.getBytes();
            byte nextInt = (byte) new Random().nextInt(255);
            byte nextInt2 = (byte) new Random().nextInt(255);
            byte[] bArr = new byte[bytes.length + 2];
            int length = bytes.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                bArr[i3] = (byte) (bytes[i2] ^ nextInt);
                i2++;
                i3++;
            }
            bArr[i3] = nextInt;
            bArr[i3 + 1] = nextInt2;
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            Calendar calendar = Calendar.getInstance();
            return String.format(str, Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        }
        return (String) invokeL.objValue;
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
            byte[] a2 = a(i2);
            for (int i3 = 0; i3 < 4; i3++) {
                this.M.add(Byte.valueOf(a2[i3]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, location) == null) {
            c(location);
            h();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || this.N) {
            return;
        }
        this.N = true;
        d(com.baidu.location.e.b.f35159e);
        j();
        d();
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65550, this, i2) == null) || i2 == 0) {
            return;
        }
        try {
            File file = new File(com.baidu.location.e.j.a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.e.j.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                randomAccessFile.writeInt(0);
                randomAccessFile.seek(8L);
                byte[] bytes = "1980_01_01:0".getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes);
                randomAccessFile.seek(200L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.seek(800L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(8L);
            byte[] bytes2 = (b("%d_%02d_%02d") + ":" + i2).getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    private void c(Location location) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, location) == null) || System.currentTimeMillis() - this.a < this.H || location == null) {
            return;
        }
        if (location != null && location.hasSpeed() && location.getSpeed() > this.E) {
            this.E = location.getSpeed();
        }
        try {
            if (this.M == null) {
                this.M = new ArrayList();
                i();
                d(location);
            } else {
                e(location);
            }
        } catch (Exception unused) {
        }
        this.L++;
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, str) == null) || str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                this.k = jSONObject.getInt(DebugKt.DEBUG_PROPERTY_VALUE_ON);
            }
            if (jSONObject.has("bash")) {
                this.l = jSONObject.getDouble("bash");
            }
            if (jSONObject.has("net")) {
                this.m = jSONObject.getString("net");
            }
            if (jSONObject.has("tcon")) {
                this.n = jSONObject.getInt("tcon");
            }
            if (jSONObject.has("tcsh")) {
                this.o = jSONObject.getInt("tcsh");
            }
            if (jSONObject.has("per")) {
                this.p = jSONObject.getInt("per");
            }
            if (jSONObject.has("chdron")) {
                this.q = jSONObject.getInt("chdron");
            }
            if (jSONObject.has("spsh")) {
                this.r = jSONObject.getDouble("spsh");
            }
            if (jSONObject.has("acsh")) {
                this.s = jSONObject.getDouble("acsh");
            }
            if (jSONObject.has("stspsh")) {
                this.t = jSONObject.getDouble("stspsh");
            }
            if (jSONObject.has("drstsh")) {
                this.u = jSONObject.getInt("drstsh");
            }
            if (jSONObject.has("stper")) {
                this.v = jSONObject.getInt("stper");
            }
            if (jSONObject.has("nondron")) {
                this.w = jSONObject.getInt("nondron");
            }
            if (jSONObject.has("nondrper")) {
                this.x = jSONObject.getInt("nondrper");
            }
            if (jSONObject.has("uptime")) {
                this.z = jSONObject.getLong("uptime");
            }
            k();
        } catch (JSONException unused) {
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            String[] split = "7.9.3".split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            int length = split.length;
            byte[] bArr = this.J;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            bArr[3] = 0;
            if (length >= 4) {
                length = 4;
            }
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    this.J[i2] = (byte) (Integer.valueOf(split[i2]).intValue() & 255);
                } catch (Exception unused) {
                }
            }
            this.K = a(com.baidu.location.e.b.f35159e + ":" + com.baidu.location.e.b.a().f35166c);
        }
    }

    private void d(Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, location) == null) {
            this.f35002e = System.currentTimeMillis();
            b((int) (location.getTime() / 1000));
            b((int) (location.getLongitude() * 1000000.0d));
            b((int) (location.getLatitude() * 1000000.0d));
            int i2 = !location.hasBearing();
            int i3 = !location.hasSpeed();
            this.M.add(Byte.valueOf(i2 > 0 ? (byte) 32 : (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & (-33))));
            this.M.add(Byte.valueOf(i3 > 0 ? Byte.MIN_VALUE : (byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & ByteCompanionObject.MAX_VALUE)));
            this.f34999b = location;
        }
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, str) == null) {
            try {
                File file = new File(com.baidu.location.e.j.a + "/grtcf.dat");
                if (file.exists()) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(2L);
                    int readInt = randomAccessFile.readInt();
                    randomAccessFile.seek(8L);
                    int readInt2 = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt2];
                    randomAccessFile.read(bArr, 0, readInt2);
                    String str2 = new String(bArr);
                    int i2 = 1;
                    if (str2.contains(b("%d_%02d_%02d")) && str2.contains(":")) {
                        try {
                            String[] split = str2.split(":");
                            if (split.length > 1) {
                                this.y = Integer.valueOf(split[1]).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                    while (true) {
                        if (i2 > readInt) {
                            break;
                        }
                        randomAccessFile.seek(i2 * 2048);
                        int readInt3 = randomAccessFile.readInt();
                        byte[] bArr2 = new byte[readInt3];
                        randomAccessFile.read(bArr2, 0, readInt3);
                        String str3 = new String(bArr2);
                        if (str != null && str3.contains(str)) {
                            c(str3);
                            break;
                        }
                        i2++;
                    }
                    randomAccessFile.close();
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0108, code lost:
        if (r8 > 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x011e, code lost:
        if (r8 > 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0120, code lost:
        r2 = (byte) (r2 | Byte.MIN_VALUE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(Location location) {
        byte bearing;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, this, location) == null) || location == null) {
            return;
        }
        int longitude = (int) ((location.getLongitude() - this.f34999b.getLongitude()) * 1000000.0d);
        int latitude = (int) ((location.getLatitude() - this.f34999b.getLatitude()) * 1000000.0d);
        int i2 = !location.hasBearing();
        int i3 = !location.hasSpeed();
        char c2 = longitude > 0 ? (char) 0 : (char) 1;
        int abs = Math.abs(longitude);
        char c3 = latitude > 0 ? (char) 0 : (char) 1;
        int abs2 = Math.abs(latitude);
        if (this.L > 1) {
            this.f35000c = null;
            this.f35000c = this.f34999b;
        }
        this.f34999b = location;
        if (location != null && this.f35000c != null && location.getTime() > this.f35000c.getTime() && this.f34999b.getTime() - this.f35000c.getTime() < 5000) {
            long time = this.f34999b.getTime() - this.f35000c.getTime();
            float[] fArr = new float[2];
            Location.distanceBetween(this.f34999b.getAltitude(), this.f34999b.getLongitude(), this.f35000c.getLatitude(), this.f35000c.getLongitude(), fArr);
            double speed = ((fArr[0] - (this.f35000c.getSpeed() * ((float) time))) * 2.0f) / ((float) (time * time));
            if (speed > this.F) {
                this.F = (float) speed;
            }
        }
        this.M.add(Byte.valueOf((byte) (abs & 255)));
        this.M.add(Byte.valueOf((byte) ((abs & 65280) >> 8)));
        this.M.add(Byte.valueOf((byte) (abs2 & 255)));
        this.M.add(Byte.valueOf((byte) ((abs2 & 65280) >> 8)));
        if (i2 > 0) {
            bearing = c3 > 0 ? (byte) 96 : (byte) 32;
        } else {
            bearing = (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & 31);
            if (c3 > 0) {
                bearing = (byte) (bearing | 64);
            }
        }
        this.M.add(Byte.valueOf(bearing));
        if (i3 > 0) {
            this.M.add(Byte.MIN_VALUE);
        } else {
            this.M.add(Byte.valueOf((byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & ByteCompanionObject.MAX_VALUE)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, str) == null) {
            try {
                File file = new File(com.baidu.location.e.j.a + "/grtcf.dat");
                if (!file.exists()) {
                    File file2 = new File(com.baidu.location.e.j.a);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file.createNewFile()) {
                        return;
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(2L);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.seek(8L);
                    byte[] bytes = "1980_01_01:0".getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes);
                    randomAccessFile.seek(200L);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.seek(800L);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                }
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                randomAccessFile2.seek(2L);
                int readInt = randomAccessFile2.readInt();
                int i2 = 1;
                while (i2 <= readInt) {
                    randomAccessFile2.seek(i2 * 2048);
                    int readInt2 = randomAccessFile2.readInt();
                    byte[] bArr = new byte[readInt2];
                    randomAccessFile2.read(bArr, 0, readInt2);
                    if (new String(bArr).contains(com.baidu.location.e.b.f35159e)) {
                        break;
                    }
                    i2++;
                }
                if (i2 >= readInt) {
                    randomAccessFile2.seek(2L);
                    randomAccessFile2.writeInt(i2);
                }
                randomAccessFile2.seek(i2 * 2048);
                byte[] bytes2 = str.getBytes();
                randomAccessFile2.writeInt(bytes2.length);
                randomAccessFile2.write(bytes2);
                randomAccessFile2.close();
            } catch (Exception unused) {
            }
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            FileChannel fileChannel = null;
            FileLock fileLock = null;
            fileChannel = null;
            RandomAccessFile randomAccessFile2 = null;
            boolean z = false;
            try {
                try {
                    File file = new File(com.baidu.location.e.k.i() + File.separator + "gflk.dat");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Exception unused) {
                }
                try {
                    channel = randomAccessFile.getChannel();
                } catch (Exception unused2) {
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
            try {
                fileLock = channel.tryLock();
            } catch (Exception unused4) {
                z = true;
            } catch (Throwable th3) {
                th = th3;
                fileChannel = channel;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (Exception unused5) {
                        throw th;
                    }
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
            if (fileLock != null) {
                fileLock.release();
            }
            if (channel != null) {
                channel.close();
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            if (this.B) {
                if (this.C) {
                    if (this.E < this.t) {
                        int i2 = this.D + this.p;
                        this.D = i2;
                        if (i2 > this.u && System.currentTimeMillis() - this.G <= this.v * 1000) {
                            return false;
                        }
                    } else {
                        this.D = 0;
                        this.C = false;
                    }
                } else if (this.E < this.t) {
                    this.C = true;
                    this.D = 0;
                    this.D = 0 + this.p;
                }
            } else if (this.E >= this.r || this.F >= this.s) {
                this.B = true;
            } else if (this.w != 1 || System.currentTimeMillis() - this.G <= this.x * 1000) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.M = null;
            this.f35002e = 0L;
            this.L = 0;
            this.f34999b = null;
            this.f35000c = null;
            this.E = 0.0f;
            this.F = 0.0f;
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || this.f35002e == 0 || System.currentTimeMillis() - this.f35002e < this.p * 1000) {
            return;
        }
        if (com.baidu.location.f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
            g();
        } else if (this.n == 1 && !f()) {
            g();
        } else {
            if (com.baidu.location.e.b.f35159e.equals("com.ubercab.driver")) {
                if (e()) {
                    g();
                    return;
                }
            } else if (!a(com.baidu.location.e.b.f35159e, com.baidu.location.f.getServiceContext())) {
                g();
                return;
            }
            List<Byte> list = this.M;
            if (list != null) {
                int size = list.size();
                this.M.set(0, Byte.valueOf((byte) (size & 255)));
                this.M.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
                this.M.set(3, Byte.valueOf((byte) (this.L & 255)));
                byte[] bArr = new byte[size];
                for (int i2 = 0; i2 < size; i2++) {
                    bArr[i2] = this.M.get(i2).byteValue();
                }
                File file = new File(com.baidu.location.e.k.k(), "baidu/tempdata");
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (file.exists()) {
                    File file2 = new File(file, "intime.dat");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        new f(this).start();
                    } catch (Exception unused) {
                    }
                }
                g();
                this.G = System.currentTimeMillis();
            }
        }
    }

    private void i() {
        List<Byte> list;
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            this.M.add((byte) 0);
            this.M.add((byte) 0);
            if (f34997f.equals("0")) {
                list = this.M;
                b2 = -82;
            } else {
                list = this.M;
                b2 = -66;
            }
            list.add(Byte.valueOf(b2));
            this.M.add((byte) 0);
            this.M.add(Byte.valueOf(this.J[0]));
            this.M.add(Byte.valueOf(this.J[1]));
            this.M.add(Byte.valueOf(this.J[2]));
            this.M.add(Byte.valueOf(this.J[3]));
            int length = this.K.length;
            this.M.add(Byte.valueOf((byte) ((length + 1) & 255)));
            for (int i2 = 0; i2 < length; i2++) {
                this.M.add(Byte.valueOf(this.K[i2]));
            }
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (System.currentTimeMillis() - this.z > 86400000) {
                if (this.A == null) {
                    this.A = new a(this);
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(com.baidu.location.e.b.a().a(false));
                stringBuffer.append(com.baidu.location.b.a.a().c());
                this.A.a(stringBuffer.toString());
            }
            k();
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
        }
    }

    public void a(Location location) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
            if (!this.N) {
                c();
            }
            if (this.k == 1 && this.m.contains(com.baidu.location.c.d.a(com.baidu.location.c.b.a().e()))) {
                if (this.n != 1 || this.y <= this.o) {
                    this.I.post(new e(this, location));
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.N) {
            this.N = false;
            g();
        }
    }
}
