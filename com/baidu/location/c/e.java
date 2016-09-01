package com.baidu.location.c;

import android.app.ActivityManager;
import android.content.Context;
import android.location.Location;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import com.baidu.location.Jni;
import com.baidu.tbadk.TbConfig;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.apache.http.entity.mime.MIME;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static e Ju = null;
    public static String f = "0";
    private Handler JB;
    private int k = 1;
    private double Io = 0.699999988079071d;
    private String m = "3G|4G";
    private int n = 1;
    private int o = 307200;
    private int p = 15;
    private int q = 1;
    private double IX = 3.5d;
    private double Jv = 3.0d;
    private double Jw = 0.5d;
    private int u = 300;
    private int v = 60;
    private int w = 0;
    private int x = 60;
    private int y = 0;
    private long z = 0;
    private a Jx = null;
    private boolean B = false;
    private boolean C = false;
    private int D = 0;
    private float Jy = 0.0f;
    private float F = 0.0f;
    private long Jz = 0;
    private int H = 500;
    long a = 0;
    Location b = null;
    Location c = null;
    StringBuilder JA = null;
    long e = 0;
    private byte[] JC = new byte[4];
    private byte[] JD = null;
    private int L = 0;
    private List<Byte> JE = null;
    private boolean N = false;
    int g = 0;
    double JF = 116.22345545d;
    double i = 40.245667323d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends com.baidu.location.h.f {
        String a = null;

        public a() {
            this.LI = new HashMap();
        }

        @Override // com.baidu.location.h.f
        public void a() {
            this.h = "http://loc.map.baidu.com/cc.php";
            String encode = Jni.encode(this.a);
            this.a = null;
            this.LI.put("q", encode);
        }

        public void a(String str) {
            this.a = str;
            e();
        }

        @Override // com.baidu.location.h.f
        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    jSONObject.put("prod", com.baidu.location.h.c.c);
                    jSONObject.put("uptime", System.currentTimeMillis());
                    e.this.e(jSONObject.toString());
                } catch (Exception e) {
                }
            }
            if (this.LI != null) {
                this.LI.clear();
            }
        }
    }

    private e() {
        this.JB = null;
        this.JB = new Handler();
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
            httpURLConnection.setRequestProperty("Charset", "utf-8");
            httpURLConnection.setRequestProperty("connection", IntentConfig.CLOSE);
            httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data;boundary=" + uuid);
            if (file != null && file.exists()) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("--");
                stringBuffer.append(uuid);
                stringBuffer.append("\r\n");
                stringBuffer.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + file.getName() + "\"\r\n");
                stringBuffer.append("Content-Type: application/octet-stream; charset=utf-8\r\n");
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
                int responseCode = httpURLConnection.getResponseCode();
                outputStream.close();
                httpURLConnection.disconnect();
                this.y += 400;
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

    private byte[] a(int i) {
        return new byte[]{(byte) (i & MotionEventCompat.ACTION_MASK), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) (((-16777216) & i) >> 24)};
    }

    private byte[] a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(MotionEventCompat.ACTION_MASK);
        byte nextInt2 = (byte) new Random().nextInt(MotionEventCompat.ACTION_MASK);
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
            this.JE.add(Byte.valueOf(a2[i2]));
        }
    }

    private void c() {
        if (this.N) {
            return;
        }
        this.N = true;
        d(com.baidu.location.h.c.c);
        i();
        d();
    }

    private void c(int i) {
        if (i == 0) {
            return;
        }
        try {
            File file = new File(com.baidu.location.h.h.a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.h.h.a);
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
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Location location) {
        d(location);
        g();
    }

    private void c(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("on")) {
                    this.k = jSONObject.getInt("on");
                }
                if (jSONObject.has("bash")) {
                    this.Io = jSONObject.getDouble("bash");
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
                    this.IX = jSONObject.getDouble("spsh");
                }
                if (jSONObject.has("acsh")) {
                    this.Jv = jSONObject.getDouble("acsh");
                }
                if (jSONObject.has("stspsh")) {
                    this.Jw = jSONObject.getDouble("stspsh");
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
                j();
            } catch (JSONException e) {
            }
        }
    }

    private void d() {
        String[] split = (0 == 0 ? "6.2.3" : null).split("\\.");
        int length = split.length;
        this.JC[0] = 0;
        this.JC[1] = 0;
        this.JC[2] = 0;
        this.JC[3] = 0;
        if (length >= 4) {
            length = 4;
        }
        for (int i = 0; i < length; i++) {
            try {
                this.JC[i] = (byte) (Integer.valueOf(split[i]).intValue() & MotionEventCompat.ACTION_MASK);
            } catch (Exception e) {
            }
        }
        this.JD = a(com.baidu.location.h.c.c + ":" + com.baidu.location.h.c.nm().b);
    }

    private void d(Location location) {
        if (System.currentTimeMillis() - this.a < this.H || location == null) {
            return;
        }
        if (location != null && location.hasSpeed() && location.getSpeed() > this.Jy) {
            this.Jy = location.getSpeed();
        }
        try {
            if (this.JE == null) {
                this.JE = new ArrayList();
                h();
                e(location);
            } else {
                f(location);
            }
        } catch (Exception e) {
        }
        this.L++;
    }

    private void d(String str) {
        int i = 1;
        try {
            File file = new File(com.baidu.location.h.h.a + "/grtcf.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                int readInt = randomAccessFile.readInt();
                randomAccessFile.seek(8L);
                int readInt2 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile.read(bArr, 0, readInt2);
                String str2 = new String(bArr);
                if (str2.contains(b("%d_%02d_%02d")) && str2.contains(":")) {
                    try {
                        String[] split = str2.split(":");
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

    private boolean d(String str, Context context) {
        boolean z;
        boolean z2 = false;
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
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

    private void e(Location location) {
        this.e = System.currentTimeMillis();
        b((int) (this.e / 1000));
        b((int) (location.getLongitude() * 1000000.0d));
        b((int) (location.getLatitude() * 1000000.0d));
        char c = location.hasBearing() ? (char) 0 : (char) 1;
        char c2 = location.hasSpeed() ? (char) 0 : (char) 1;
        if (c > 0) {
            this.JE.add((byte) 32);
        } else {
            this.JE.add(Byte.valueOf((byte) (((byte) (((int) (location.getBearing() / 15.0f)) & MotionEventCompat.ACTION_MASK)) & (-33))));
        }
        if (c2 > 0) {
            this.JE.add(Byte.MIN_VALUE);
        } else {
            this.JE.add(Byte.valueOf((byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & MotionEventCompat.ACTION_MASK)) & Byte.MAX_VALUE)));
        }
        this.b = location;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        try {
            File file = new File(com.baidu.location.h.h.a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.h.h.a);
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
                if (new String(bArr).contains(com.baidu.location.h.c.c)) {
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
        if (this.B) {
            if (!this.C) {
                if (this.Jy < this.Jw) {
                    this.C = true;
                    this.D = 0;
                    this.D += this.p;
                    return true;
                }
                return true;
            } else if (this.Jy >= this.Jw) {
                this.D = 0;
                this.C = false;
                return true;
            } else {
                this.D += this.p;
                if (this.D <= this.u || System.currentTimeMillis() - this.Jz > this.v * 1000) {
                    return true;
                }
            }
        } else if (this.Jy >= this.IX || this.F >= this.Jv) {
            this.B = true;
            return true;
        } else if (this.w == 1 && System.currentTimeMillis() - this.Jz > this.x * 1000) {
            return true;
        }
        return false;
    }

    private void f() {
        this.JE = null;
        this.e = 0L;
        this.L = 0;
        this.b = null;
        this.c = null;
        this.Jy = 0.0f;
        this.F = 0.0f;
    }

    private void f(Location location) {
        if (location == null) {
            return;
        }
        int longitude = (int) ((location.getLongitude() - this.b.getLongitude()) * 100000.0d);
        int latitude = (int) ((location.getLatitude() - this.b.getLatitude()) * 100000.0d);
        char c = location.hasBearing() ? (char) 0 : (char) 1;
        char c2 = location.hasSpeed() ? (char) 0 : (char) 1;
        char c3 = longitude > 0 ? (char) 0 : (char) 1;
        int abs = Math.abs(longitude);
        char c4 = latitude > 0 ? (char) 0 : (char) 1;
        int abs2 = Math.abs(latitude);
        if (this.L > 1) {
            this.c = null;
            this.c = this.b;
        }
        this.b = location;
        if (this.b != null && this.c != null && this.b.getTime() > this.c.getTime() && this.b.getTime() - this.c.getTime() < TbConfig.NOTIFY_SOUND_INTERVAL) {
            long time = this.b.getTime() - this.c.getTime();
            float[] fArr = new float[2];
            Location.distanceBetween(this.b.getAltitude(), this.b.getLongitude(), this.c.getLatitude(), this.c.getLongitude(), fArr);
            double speed = (2.0f * (fArr[0] - (this.c.getSpeed() * ((float) time)))) / ((float) (time * time));
            if (speed > this.F) {
                this.F = (float) speed;
            }
        }
        this.JE.add(Byte.valueOf((byte) (abs & MotionEventCompat.ACTION_MASK)));
        this.JE.add(Byte.valueOf((byte) (abs2 & MotionEventCompat.ACTION_MASK)));
        if (c > 0) {
            byte b = c4 > 0 ? (byte) 96 : (byte) 32;
            if (c3 > 0) {
                b = (byte) (b | Byte.MIN_VALUE);
            }
            this.JE.add(Byte.valueOf(b));
        } else {
            byte bearing = (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & MotionEventCompat.ACTION_MASK)) & 31);
            if (c4 > 0) {
                bearing = (byte) (bearing | 64);
            }
            if (c3 > 0) {
                bearing = (byte) (bearing | Byte.MIN_VALUE);
            }
            this.JE.add(Byte.valueOf(bearing));
        }
        if (c2 > 0) {
            this.JE.add(Byte.MIN_VALUE);
        } else {
            this.JE.add(Byte.valueOf((byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & MotionEventCompat.ACTION_MASK)) & Byte.MAX_VALUE)));
        }
    }

    private void g() {
        if (this.e == 0 || System.currentTimeMillis() - this.e < this.p * 1000) {
            return;
        }
        if (com.baidu.location.f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
            f();
        } else if (this.n == 1 && !e()) {
            f();
        } else if (!d(com.baidu.location.h.c.c, com.baidu.location.f.getServiceContext())) {
            f();
        } else if (this.JE != null) {
            int size = this.JE.size();
            this.JE.set(0, Byte.valueOf((byte) (size & MotionEventCompat.ACTION_MASK)));
            this.JE.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
            this.JE.set(3, Byte.valueOf((byte) (this.L & MotionEventCompat.ACTION_MASK)));
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = this.JE.get(i).byteValue();
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
                        new k(this).start();
                    } catch (Exception e) {
                    }
                }
            }
            f();
            this.Jz = System.currentTimeMillis();
        }
    }

    private void h() {
        this.JE.add((byte) 0);
        this.JE.add((byte) 0);
        if (f.equals("0")) {
            this.JE.add((byte) 110);
        } else {
            this.JE.add((byte) 126);
        }
        this.JE.add((byte) 0);
        this.JE.add(Byte.valueOf(this.JC[0]));
        this.JE.add(Byte.valueOf(this.JC[1]));
        this.JE.add(Byte.valueOf(this.JC[2]));
        this.JE.add(Byte.valueOf(this.JC[3]));
        int length = this.JD.length;
        this.JE.add(Byte.valueOf((byte) ((length + 1) & MotionEventCompat.ACTION_MASK)));
        for (int i = 0; i < length; i++) {
            this.JE.add(Byte.valueOf(this.JD[i]));
        }
    }

    private void i() {
        if (System.currentTimeMillis() - this.z > 86400000) {
            if (this.Jx == null) {
                this.Jx = new a();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(com.baidu.location.h.c.nm().a(false));
            stringBuffer.append(com.baidu.location.a.a.mn().c());
            this.Jx.a(stringBuffer.toString());
        }
        j();
    }

    private void j() {
    }

    public static e mF() {
        if (Ju == null) {
            Ju = new e();
        }
        return Ju;
    }

    public void a(Location location) {
        if (!this.N) {
            c();
        }
        if (this.k == 1 && b.mC().f() < this.Io * 100.0d && this.m.contains(com.baidu.location.f.c.a(com.baidu.location.f.c.nc().e()))) {
            if (this.n != 1 || this.y <= this.o) {
                this.JB.post(new j(this, location));
            }
        }
    }

    public void b() {
        if (this.N) {
            this.N = false;
            f();
        }
    }
}
