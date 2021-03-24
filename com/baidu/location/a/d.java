package com.baidu.location.a;

import android.app.ActivityManager;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.location.Jni;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
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
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static String f6480f = "0";
    public static d j;
    public Handler I;
    public int k = 1;
    public double l = 0.699999988079071d;
    public String m = "3G|4G";
    public int n = 1;
    public int o = 307200;
    public int p = 15;
    public int q = 1;
    public double r = 3.5d;
    public double s = 3.0d;
    public double t = 0.5d;
    public int u = 300;
    public int v = 60;
    public int w = 0;
    public int x = 60;
    public int y = 0;
    public long z = 0;
    public a A = null;
    public boolean B = false;
    public boolean C = false;
    public int D = 0;
    public float E = 0.0f;
    public float F = 0.0f;
    public long G = 0;
    public int H = 500;

    /* renamed from: a  reason: collision with root package name */
    public long f6481a = 0;

    /* renamed from: b  reason: collision with root package name */
    public Location f6482b = null;

    /* renamed from: c  reason: collision with root package name */
    public Location f6483c = null;

    /* renamed from: d  reason: collision with root package name */
    public StringBuilder f6484d = null;

    /* renamed from: e  reason: collision with root package name */
    public long f6485e = 0;
    public byte[] J = new byte[4];
    public byte[] K = null;
    public int L = 0;
    public List<Byte> M = null;
    public boolean N = false;

    /* renamed from: g  reason: collision with root package name */
    public int f6486g = 0;

    /* renamed from: h  reason: collision with root package name */
    public double f6487h = 116.22345545d;
    public double i = 40.245667323d;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.location.d.e {

        /* renamed from: a  reason: collision with root package name */
        public String f6488a = null;

        public a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.d.e
        public void a() {
            this.f6705h = "http://loc.map.baidu.com/cc.php";
            String encode = Jni.encode(this.f6488a);
            this.f6488a = null;
            this.k.put(IXAdRequestInfo.COST_NAME, encode);
        }

        public void a(String str) {
            this.f6488a = str;
            e();
        }

        @Override // com.baidu.location.d.e
        public void a(boolean z) {
            String str;
            if (z && (str = this.j) != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("prod", com.baidu.location.d.b.f6676d);
                    jSONObject.put(Config.DEVICE_UPTIME, System.currentTimeMillis());
                    d.this.e(jSONObject.toString());
                } catch (Exception unused) {
                }
            }
            Map<String, Object> map = this.k;
            if (map != null) {
                map.clear();
            }
        }
    }

    public d() {
        this.I = null;
        this.I = new Handler();
    }

    public static d a() {
        if (j == null) {
            j = new d();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(File file, String str) {
        String uuid = UUID.randomUUID().toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "utf-8");
            httpURLConnection.setRequestProperty("connection", IntentConfig.CLOSE);
            httpURLConnection.setRequestProperty("Content-Type", IMAudioTransRequest.CONTENT_TYPE + ";boundary=" + uuid);
            if (file == null || !file.exists()) {
                return "0";
            }
            OutputStream outputStream = httpURLConnection.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("--");
            stringBuffer.append(uuid);
            stringBuffer.append(Part.CRLF);
            stringBuffer.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + file.getName() + "\"" + Part.CRLF);
            StringBuilder sb = new StringBuilder();
            sb.append("Content-Type: application/octet-stream; charset=utf-8");
            sb.append(Part.CRLF);
            stringBuffer.append(sb.toString());
            stringBuffer.append(Part.CRLF);
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
            dataOutputStream.write(Part.CRLF.getBytes());
            dataOutputStream.write(("--" + uuid + "--" + Part.CRLF).getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            outputStream.close();
            httpURLConnection.disconnect();
            int i = this.y + 400;
            this.y = i;
            c(i);
            return responseCode == 200 ? "1" : "0";
        } catch (MalformedURLException | IOException unused) {
            return "0";
        }
    }

    private boolean a(String str, Context context) {
        boolean z = false;
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(str)) {
                        int i = runningAppProcessInfo.importance;
                        if (i == 200 || i == 100) {
                            z = true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return z;
    }

    private byte[] a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & (-16777216)) >> 24)};
    }

    private byte[] a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2++;
        }
        bArr[i2] = nextInt;
        bArr[i2 + 1] = nextInt2;
        return bArr;
    }

    private String b(String str) {
        Calendar calendar = Calendar.getInstance();
        return String.format(str, Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
    }

    private void b(int i) {
        byte[] a2 = a(i);
        for (int i2 = 0; i2 < 4; i2++) {
            this.M.add(Byte.valueOf(a2[i2]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Location location) {
        c(location);
        h();
    }

    private void c() {
        if (this.N) {
            return;
        }
        this.N = true;
        d(com.baidu.location.d.b.f6676d);
        j();
        d();
    }

    private void c(int i) {
        if (i == 0) {
            return;
        }
        try {
            File file = new File(com.baidu.location.d.i.f6712a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.d.i.f6712a);
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
            byte[] bytes2 = (b("%d_%02d_%02d") + ":" + i).getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    private void c(Location location) {
        if (System.currentTimeMillis() - this.f6481a < this.H || location == null) {
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
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("on")) {
                    this.k = jSONObject.getInt("on");
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
                if (jSONObject.has(Config.DEVICE_UPTIME)) {
                    this.z = jSONObject.getLong(Config.DEVICE_UPTIME);
                }
                k();
            } catch (JSONException unused) {
            }
        }
    }

    private void d() {
        String[] split = "7.6.3".split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        int length = split.length;
        byte[] bArr = this.J;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        if (length >= 4) {
            length = 4;
        }
        for (int i = 0; i < length; i++) {
            try {
                this.J[i] = (byte) (Integer.valueOf(split[i]).intValue() & 255);
            } catch (Exception unused) {
            }
        }
        this.K = a(com.baidu.location.d.b.f6676d + ":" + com.baidu.location.d.b.a().f6682b);
    }

    private void d(Location location) {
        byte b2;
        this.f6485e = System.currentTimeMillis();
        b((int) (location.getTime() / 1000));
        b((int) (location.getLongitude() * 1000000.0d));
        b((int) (location.getLatitude() * 1000000.0d));
        int i = !location.hasBearing();
        int i2 = !location.hasSpeed();
        this.M.add(Byte.valueOf(i > 0 ? (byte) 32 : (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & (-33))));
        if (i2 > 0) {
            b2 = ByteCompanionObject.MIN_VALUE;
        } else {
            double speed = location.getSpeed();
            Double.isNaN(speed);
            b2 = (byte) (((byte) (((int) ((speed * 3.6d) / 4.0d)) & 255)) & ByteCompanionObject.MAX_VALUE);
        }
        this.M.add(Byte.valueOf(b2));
        this.f6482b = location;
    }

    private void d(String str) {
        try {
            File file = new File(com.baidu.location.d.i.f6712a + "/grtcf.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                int readInt = randomAccessFile.readInt();
                randomAccessFile.seek(8L);
                int readInt2 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile.read(bArr, 0, readInt2);
                String str2 = new String(bArr);
                int i = 1;
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
                    if (i > readInt) {
                        break;
                    }
                    randomAccessFile.seek(i * 2048);
                    int readInt3 = randomAccessFile.readInt();
                    byte[] bArr2 = new byte[readInt3];
                    randomAccessFile.read(bArr2, 0, readInt3);
                    String str3 = new String(bArr2);
                    if (str != null && str3.contains(str)) {
                        c(str3);
                        break;
                    }
                    i++;
                }
                randomAccessFile.close();
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0104, code lost:
        if (r8 > 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x011a, code lost:
        if (r8 > 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011c, code lost:
        r2 = (byte) (r2 | kotlin.jvm.internal.ByteCompanionObject.MIN_VALUE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(Location location) {
        byte bearing;
        if (location == null) {
            return;
        }
        int longitude = (int) ((location.getLongitude() - this.f6482b.getLongitude()) * 1000000.0d);
        int latitude = (int) ((location.getLatitude() - this.f6482b.getLatitude()) * 1000000.0d);
        int i = !location.hasBearing();
        int i2 = !location.hasSpeed();
        char c2 = longitude > 0 ? (char) 0 : (char) 1;
        int abs = Math.abs(longitude);
        char c3 = latitude > 0 ? (char) 0 : (char) 1;
        int abs2 = Math.abs(latitude);
        if (this.L > 1) {
            this.f6483c = null;
            this.f6483c = this.f6482b;
        }
        this.f6482b = location;
        if (location != null && this.f6483c != null && location.getTime() > this.f6483c.getTime() && this.f6482b.getTime() - this.f6483c.getTime() < 5000) {
            long time = this.f6482b.getTime() - this.f6483c.getTime();
            float[] fArr = new float[2];
            Location.distanceBetween(this.f6482b.getAltitude(), this.f6482b.getLongitude(), this.f6483c.getLatitude(), this.f6483c.getLongitude(), fArr);
            double speed = ((fArr[0] - (this.f6483c.getSpeed() * ((float) time))) * 2.0f) / ((float) (time * time));
            if (speed > this.F) {
                this.F = (float) speed;
            }
        }
        this.M.add(Byte.valueOf((byte) (abs & 255)));
        this.M.add(Byte.valueOf((byte) ((abs & 65280) >> 8)));
        this.M.add(Byte.valueOf((byte) (abs2 & 255)));
        this.M.add(Byte.valueOf((byte) ((abs2 & 65280) >> 8)));
        if (i > 0) {
            bearing = c3 > 0 ? (byte) 96 : (byte) 32;
        } else {
            bearing = (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & 31);
            if (c3 > 0) {
                bearing = (byte) (bearing | 64);
            }
        }
        this.M.add(Byte.valueOf(bearing));
        if (i2 > 0) {
            this.M.add(Byte.valueOf((byte) ByteCompanionObject.MIN_VALUE));
            return;
        }
        double speed2 = location.getSpeed();
        Double.isNaN(speed2);
        this.M.add(Byte.valueOf((byte) (((byte) (((int) ((speed2 * 3.6d) / 4.0d)) & 255)) & ByteCompanionObject.MAX_VALUE)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        try {
            File file = new File(com.baidu.location.d.i.f6712a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.d.i.f6712a);
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
            int i = 1;
            while (i <= readInt) {
                randomAccessFile2.seek(i * 2048);
                int readInt2 = randomAccessFile2.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile2.read(bArr, 0, readInt2);
                if (new String(bArr).contains(com.baidu.location.d.b.f6676d)) {
                    break;
                }
                i++;
            }
            if (i >= readInt) {
                randomAccessFile2.seek(2L);
                randomAccessFile2.writeInt(i);
            }
            randomAccessFile2.seek(i * 2048);
            byte[] bytes2 = str.getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    private boolean e() {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileChannel fileChannel = null;
        FileLock fileLock = null;
        fileChannel = null;
        RandomAccessFile randomAccessFile2 = null;
        boolean z = false;
        try {
            try {
                File file = new File(com.baidu.location.d.j.g() + File.separator + "gflk.dat");
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

    private boolean f() {
        if (this.B) {
            if (this.C) {
                if (this.E < this.t) {
                    int i = this.D + this.p;
                    this.D = i;
                    if (i > this.u && System.currentTimeMillis() - this.G <= this.v * 1000) {
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

    private void g() {
        this.M = null;
        this.f6485e = 0L;
        this.L = 0;
        this.f6482b = null;
        this.f6483c = null;
        this.E = 0.0f;
        this.F = 0.0f;
    }

    private void h() {
        if (this.f6485e == 0 || System.currentTimeMillis() - this.f6485e < this.p * 1000) {
            return;
        }
        if (com.baidu.location.f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
            g();
        } else if (this.n == 1 && !f()) {
            g();
        } else {
            if (com.baidu.location.d.b.f6676d.equals("com.ubercab.driver")) {
                if (e()) {
                    g();
                    return;
                }
            } else if (!a(com.baidu.location.d.b.f6676d, com.baidu.location.f.getServiceContext())) {
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
                for (int i = 0; i < size; i++) {
                    bArr[i] = this.M.get(i).byteValue();
                }
                File file = new File(com.baidu.location.d.j.i(), "baidu/tempdata");
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
        this.M.add((byte) 0);
        this.M.add((byte) 0);
        if (f6480f.equals("0")) {
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
        for (int i = 0; i < length; i++) {
            this.M.add(Byte.valueOf(this.K[i]));
        }
    }

    private void j() {
        if (System.currentTimeMillis() - this.z > 86400000) {
            if (this.A == null) {
                this.A = new a();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(com.baidu.location.d.b.a().a(false));
            stringBuffer.append(com.baidu.location.a.a.a().c());
            this.A.a(stringBuffer.toString());
        }
        k();
    }

    private void k() {
    }

    public void a(Location location) {
        if (!this.N) {
            c();
        }
        if (this.k == 1 && this.m.contains(com.baidu.location.b.d.a(com.baidu.location.b.b.a().e()))) {
            if (this.n != 1 || this.y <= this.o) {
                this.I.post(new e(this, location));
            }
        }
    }

    public void b() {
        if (this.N) {
            this.N = false;
            g();
        }
    }
}
