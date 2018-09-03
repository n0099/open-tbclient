package com.baidu.location.a;

import android.app.ActivityManager;
import android.content.Context;
import android.location.Location;
import android.net.http.Headers;
import android.os.Environment;
import android.os.Handler;
import com.baidu.ar.util.IoUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.location.Jni;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
import java.util.Random;
import java.util.UUID;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static d VY = null;
    public static String f = "0";
    private Handler Wi;
    private int k = 1;
    private double l = 0.699999988079071d;
    private String m = "3G|4G";
    private int n = 1;
    private int o = 307200;
    private int p = 15;
    private int q = 1;
    private double VZ = 3.5d;
    private double Wa = 3.0d;
    private double Wb = 0.5d;
    private int u = 300;
    private int v = 60;
    private int w = 0;
    private int x = 60;
    private int y = 0;
    private long z = 0;
    private a Wc = null;
    private boolean B = false;
    private boolean C = false;
    private int D = 0;
    private float Wd = 0.0f;
    private float We = 0.0f;
    private long G = 0;
    private int H = 500;
    long a = 0;
    Location Wf = null;
    Location Wg = null;
    StringBuilder Wh = null;
    long e = 0;
    private byte[] Wj = new byte[4];
    private byte[] Wk = null;
    private int L = 0;
    private List<Byte> Wl = null;
    private boolean N = false;
    int g = 0;
    double h = 116.22345545d;
    double Wm = 40.245667323d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends com.baidu.location.d.e {
        String a = null;

        public a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.d.e
        public void a() {
            this.h = "http://loc.map.baidu.com/cc.php";
            String encode = Jni.encode(this.a);
            this.a = null;
            this.k.put("q", encode);
        }

        public void a(String str) {
            this.a = str;
            e();
        }

        @Override // com.baidu.location.d.e
        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    jSONObject.put("prod", com.baidu.location.d.b.d);
                    jSONObject.put("uptime", System.currentTimeMillis());
                    d.this.e(jSONObject.toString());
                } catch (Exception e) {
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    private d() {
        this.Wi = null;
        this.Wi = new Handler();
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
            httpURLConnection.setRequestProperty("Charset", IoUtils.UTF_8);
            httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, IntentConfig.CLOSE);
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
            if (file != null && file.exists()) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("--");
                stringBuffer.append(uuid);
                stringBuffer.append(SystemInfoUtil.LINE_END);
                stringBuffer.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + file.getName() + "\"" + SystemInfoUtil.LINE_END);
                stringBuffer.append("Content-Type: application/octet-stream; charset=utf-8" + SystemInfoUtil.LINE_END);
                stringBuffer.append(SystemInfoUtil.LINE_END);
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
                dataOutputStream.write(SystemInfoUtil.LINE_END.getBytes());
                dataOutputStream.write(("--" + uuid + "--" + SystemInfoUtil.LINE_END).getBytes());
                dataOutputStream.flush();
                dataOutputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                outputStream.close();
                httpURLConnection.disconnect();
                this.y += HttpStatus.SC_BAD_REQUEST;
                c(this.y);
                if (responseCode == 200) {
                    return "1";
                }
            }
        } catch (MalformedURLException e) {
        } catch (IOException e2) {
        }
        return "0";
    }

    private boolean a(String str, Context context) {
        boolean z;
        boolean z2 = false;
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(str)) {
                        int i = runningAppProcessInfo.importance;
                        if (i == 200 || i == 100) {
                            z = true;
                            z2 = z;
                        }
                    }
                    z = z2;
                    z2 = z;
                }
            }
        } catch (Exception e) {
        }
        return z2;
    }

    private byte[] a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) (((-16777216) & i) >> 24)};
    }

    private byte[] a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2++;
        }
        int i3 = i2 + 1;
        bArr[i2] = nextInt;
        int i4 = i3 + 1;
        bArr[i3] = nextInt2;
        return bArr;
    }

    private String b(String str) {
        Calendar calendar = Calendar.getInstance();
        return String.format(str, Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
    }

    private void b(int i) {
        byte[] a2 = a(i);
        for (int i2 = 0; i2 < 4; i2++) {
            this.Wl.add(Byte.valueOf(a2[i2]));
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
        d(com.baidu.location.d.b.d);
        j();
        d();
    }

    private void c(int i) {
        if (i == 0) {
            return;
        }
        try {
            File file = new File(com.baidu.location.d.f.a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.d.f.a);
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
            byte[] bytes2 = (b("%d_%02d_%02d") + SystemInfoUtil.COLON + i).getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception e) {
        }
    }

    private void c(Location location) {
        if (System.currentTimeMillis() - this.a < this.H || location == null) {
            return;
        }
        if (location != null && location.hasSpeed() && location.getSpeed() > this.Wd) {
            this.Wd = location.getSpeed();
        }
        try {
            if (this.Wl == null) {
                this.Wl = new ArrayList();
                i();
                d(location);
            } else {
                e(location);
            }
        } catch (Exception e) {
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
                    this.VZ = jSONObject.getDouble("spsh");
                }
                if (jSONObject.has("acsh")) {
                    this.Wa = jSONObject.getDouble("acsh");
                }
                if (jSONObject.has("stspsh")) {
                    this.Wb = jSONObject.getDouble("stspsh");
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
            } catch (JSONException e) {
            }
        }
    }

    private void d() {
        String[] split = (0 == 0 ? "7.4.2" : null).split("\\.");
        int length = split.length;
        this.Wj[0] = 0;
        this.Wj[1] = 0;
        this.Wj[2] = 0;
        this.Wj[3] = 0;
        if (length >= 4) {
            length = 4;
        }
        for (int i = 0; i < length; i++) {
            try {
                this.Wj[i] = (byte) (Integer.valueOf(split[i]).intValue() & 255);
            } catch (Exception e) {
            }
        }
        this.Wk = a(com.baidu.location.d.b.d + SystemInfoUtil.COLON + com.baidu.location.d.b.qN().b);
    }

    private void d(Location location) {
        this.e = System.currentTimeMillis();
        b((int) (location.getTime() / 1000));
        b((int) (location.getLongitude() * 1000000.0d));
        b((int) (location.getLatitude() * 1000000.0d));
        char c = location.hasBearing() ? (char) 0 : (char) 1;
        char c2 = location.hasSpeed() ? (char) 0 : (char) 1;
        if (c > 0) {
            this.Wl.add((byte) 32);
        } else {
            this.Wl.add(Byte.valueOf((byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & (-33))));
        }
        if (c2 > 0) {
            this.Wl.add(Byte.MIN_VALUE);
        } else {
            this.Wl.add(Byte.valueOf((byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & Byte.MAX_VALUE)));
        }
        this.Wf = location;
    }

    private void d(String str) {
        int i = 1;
        try {
            File file = new File(com.baidu.location.d.f.a + "/grtcf.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                int readInt = randomAccessFile.readInt();
                randomAccessFile.seek(8L);
                int readInt2 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile.read(bArr, 0, readInt2);
                String str2 = new String(bArr);
                if (str2.contains(b("%d_%02d_%02d")) && str2.contains(SystemInfoUtil.COLON)) {
                    try {
                        String[] split = str2.split(SystemInfoUtil.COLON);
                        if (split.length > 1) {
                            this.y = Integer.valueOf(split[1]).intValue();
                        }
                    } catch (Exception e) {
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
        } catch (Exception e2) {
        }
    }

    private void e(Location location) {
        if (location == null) {
            return;
        }
        int longitude = (int) ((location.getLongitude() - this.Wf.getLongitude()) * 1000000.0d);
        int latitude = (int) ((location.getLatitude() - this.Wf.getLatitude()) * 1000000.0d);
        char c = location.hasBearing() ? (char) 0 : (char) 1;
        char c2 = location.hasSpeed() ? (char) 0 : (char) 1;
        char c3 = longitude > 0 ? (char) 0 : (char) 1;
        int abs = Math.abs(longitude);
        char c4 = latitude > 0 ? (char) 0 : (char) 1;
        int abs2 = Math.abs(latitude);
        if (this.L > 1) {
            this.Wg = null;
            this.Wg = this.Wf;
        }
        this.Wf = location;
        if (this.Wf != null && this.Wg != null && this.Wf.getTime() > this.Wg.getTime() && this.Wf.getTime() - this.Wg.getTime() < TbConfig.NOTIFY_SOUND_INTERVAL) {
            long time = this.Wf.getTime() - this.Wg.getTime();
            float[] fArr = new float[2];
            Location.distanceBetween(this.Wf.getAltitude(), this.Wf.getLongitude(), this.Wg.getLatitude(), this.Wg.getLongitude(), fArr);
            double speed = (2.0f * (fArr[0] - (this.Wg.getSpeed() * ((float) time)))) / ((float) (time * time));
            if (speed > this.We) {
                this.We = (float) speed;
            }
        }
        this.Wl.add(Byte.valueOf((byte) (abs & 255)));
        this.Wl.add(Byte.valueOf((byte) ((65280 & abs) >> 8)));
        this.Wl.add(Byte.valueOf((byte) (abs2 & 255)));
        this.Wl.add(Byte.valueOf((byte) ((65280 & abs2) >> 8)));
        if (c > 0) {
            byte b = c4 > 0 ? (byte) 96 : (byte) 32;
            if (c3 > 0) {
                b = (byte) (b | Byte.MIN_VALUE);
            }
            this.Wl.add(Byte.valueOf(b));
        } else {
            byte bearing = (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & 31);
            if (c4 > 0) {
                bearing = (byte) (bearing | 64);
            }
            if (c3 > 0) {
                bearing = (byte) (bearing | Byte.MIN_VALUE);
            }
            this.Wl.add(Byte.valueOf(bearing));
        }
        if (c2 > 0) {
            this.Wl.add(Byte.MIN_VALUE);
        } else {
            this.Wl.add(Byte.valueOf((byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & Byte.MAX_VALUE)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        try {
            File file = new File(com.baidu.location.d.f.a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.d.f.a);
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
                if (new String(bArr).contains(com.baidu.location.d.b.d)) {
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
        } catch (Exception e) {
        }
    }

    private boolean e() {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel;
        FileLock fileLock = null;
        FileChannel fileChannel2 = null;
        FileLock fileLock2 = null;
        boolean z = false;
        try {
            File file = new File(com.baidu.location.d.g.g() + File.separator + "gflk.dat");
            if (!file.exists()) {
                file.createNewFile();
            }
            if (0 == 0) {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileChannel = randomAccessFile.getChannel();
                    try {
                        fileLock = fileChannel.tryLock();
                    } catch (Exception e) {
                        z = true;
                    } catch (Throwable th) {
                        th = th;
                        if (0 != 0) {
                            try {
                                fileLock2.release();
                            } catch (Exception e2) {
                                throw th;
                            }
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    if (0 != 0) {
                        try {
                            fileLock2.release();
                        } catch (Exception e4) {
                        }
                    }
                    if (0 != 0) {
                        fileChannel2.close();
                    }
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            } else {
                randomAccessFile = null;
                fileChannel = null;
            }
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception e5) {
                }
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Exception e6) {
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            fileChannel = null;
        }
        return z;
    }

    private boolean f() {
        if (this.B) {
            if (!this.C) {
                if (this.Wd < this.Wb) {
                    this.C = true;
                    this.D = 0;
                    this.D += this.p;
                    return true;
                }
                return true;
            } else if (this.Wd >= this.Wb) {
                this.D = 0;
                this.C = false;
                return true;
            } else {
                this.D += this.p;
                if (this.D <= this.u || System.currentTimeMillis() - this.G > this.v * 1000) {
                    return true;
                }
            }
        } else if (this.Wd >= this.VZ || this.We >= this.Wa) {
            this.B = true;
            return true;
        } else if (this.w == 1 && System.currentTimeMillis() - this.G > this.x * 1000) {
            return true;
        }
        return false;
    }

    private void g() {
        this.Wl = null;
        this.e = 0L;
        this.L = 0;
        this.Wf = null;
        this.Wg = null;
        this.Wd = 0.0f;
        this.We = 0.0f;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.baidu.location.a.d$2] */
    private void h() {
        if (this.e == 0 || System.currentTimeMillis() - this.e < this.p * 1000) {
            return;
        }
        if (com.baidu.location.f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
            g();
        } else if (this.n == 1 && !f()) {
            g();
        } else {
            if (com.baidu.location.d.b.d.equals("com.ubercab.driver")) {
                if (e()) {
                    g();
                    return;
                }
            } else if (!a(com.baidu.location.d.b.d, com.baidu.location.f.getServiceContext())) {
                g();
                return;
            }
            if (this.Wl != null) {
                int size = this.Wl.size();
                this.Wl.set(0, Byte.valueOf((byte) (size & 255)));
                this.Wl.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
                this.Wl.set(3, Byte.valueOf((byte) (this.L & 255)));
                byte[] bArr = new byte[size];
                for (int i = 0; i < size; i++) {
                    bArr[i] = this.Wl.get(i).byteValue();
                }
                if (Environment.getExternalStorageState().equals("mounted")) {
                    File file = new File(Environment.getExternalStorageDirectory(), "baidu/tempdata");
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
                            new Thread() { // from class: com.baidu.location.a.d.2
                                @Override // java.lang.Thread, java.lang.Runnable
                                public void run() {
                                    d.this.a(new File(Environment.getExternalStorageDirectory() + "/baidu/tempdata", "intime.dat"), "http://itsdata.map.baidu.com/long-conn-gps/sdk.php");
                                }
                            }.start();
                        } catch (Exception e) {
                        }
                    }
                }
                g();
                this.G = System.currentTimeMillis();
            }
        }
    }

    private void i() {
        this.Wl.add((byte) 0);
        this.Wl.add((byte) 0);
        if (f.equals("0")) {
            this.Wl.add((byte) -82);
        } else {
            this.Wl.add((byte) -66);
        }
        this.Wl.add((byte) 0);
        this.Wl.add(Byte.valueOf(this.Wj[0]));
        this.Wl.add(Byte.valueOf(this.Wj[1]));
        this.Wl.add(Byte.valueOf(this.Wj[2]));
        this.Wl.add(Byte.valueOf(this.Wj[3]));
        int length = this.Wk.length;
        this.Wl.add(Byte.valueOf((byte) ((length + 1) & 255)));
        for (int i = 0; i < length; i++) {
            this.Wl.add(Byte.valueOf(this.Wk[i]));
        }
    }

    private void j() {
        if (System.currentTimeMillis() - this.z > 86400000) {
            if (this.Wc == null) {
                this.Wc = new a();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(com.baidu.location.d.b.qN().ad(false));
            stringBuffer.append(com.baidu.location.a.a.qk().c());
            this.Wc.a(stringBuffer.toString());
        }
        k();
    }

    private void k() {
    }

    public static d qn() {
        if (VY == null) {
            VY = new d();
        }
        return VY;
    }

    public void a(final Location location) {
        if (!this.N) {
            c();
        }
        if (this.k == 1 && this.m.contains(com.baidu.location.b.c.a(com.baidu.location.b.b.qB().e()))) {
            if (this.n != 1 || this.y <= this.o) {
                this.Wi.post(new Runnable() { // from class: com.baidu.location.a.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.b(location);
                    }
                });
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
