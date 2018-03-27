package com.baidu.location.c;

import android.app.ActivityManager;
import android.content.Context;
import android.location.Location;
import android.net.http.Headers;
import android.os.Environment;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.tbadk.TbConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.sina.weibo.sdk.component.WidgetRequestParam;
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
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static e aCl = null;
    public static String f = "0";
    private Handler aCv;
    private int k = 1;
    private double l = 0.699999988079071d;
    private String m = "3G|4G";
    private int n = 1;
    private int o = 307200;
    private int p = 15;
    private int q = 1;
    private double aBO = 3.5d;
    private double aCm = 3.0d;
    private double t = 0.5d;
    private int u = 300;
    private int v = 60;
    private int w = 0;
    private int x = 60;
    private int y = 0;
    private long z = 0;
    private a aCn = null;
    private boolean B = false;
    private boolean C = false;
    private int aCo = 0;
    private float aCp = 0.0f;
    private float aCq = 0.0f;
    private long aCr = 0;
    private int aCs = 500;
    long a = 0;
    Location aCt = null;
    Location aBL = null;
    StringBuilder aCu = null;
    long e = 0;
    private byte[] aCw = new byte[4];
    private byte[] K = null;
    private int L = 0;
    private List<Byte> M = null;
    private boolean N = false;
    int g = 0;
    double h = 116.22345545d;
    double aCx = 40.245667323d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends com.baidu.location.h.f {
        String a = null;

        public a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.h.f
        public void a() {
            this.h = "http://loc.map.baidu.com/cc.php";
            String encode = Jni.encode(this.a);
            this.a = null;
            this.k.put(WidgetRequestParam.REQ_PARAM_COMMENT_TOPIC, encode);
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
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    private e() {
        this.aCv = null;
        this.aCv = new Handler();
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
            httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "close");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
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
            this.M.add(Byte.valueOf(a2[i2]));
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
                    this.aBO = jSONObject.getDouble("spsh");
                }
                if (jSONObject.has("acsh")) {
                    this.aCm = jSONObject.getDouble("acsh");
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
                j();
            } catch (JSONException e) {
            }
        }
    }

    private void d() {
        String[] split = (0 == 0 ? "6.2.3" : null).split("\\.");
        int length = split.length;
        this.aCw[0] = 0;
        this.aCw[1] = 0;
        this.aCw[2] = 0;
        this.aCw[3] = 0;
        if (length >= 4) {
            length = 4;
        }
        for (int i = 0; i < length; i++) {
            try {
                this.aCw[i] = (byte) (Integer.valueOf(split[i]).intValue() & 255);
            } catch (Exception e) {
            }
        }
        this.K = a(com.baidu.location.h.c.c + ":" + com.baidu.location.h.c.vn().b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Location location) {
        e(location);
        g();
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

    private void e(Location location) {
        if (System.currentTimeMillis() - this.a < this.aCs || location == null) {
            return;
        }
        if (location != null && location.hasSpeed() && location.getSpeed() > this.aCp) {
            this.aCp = location.getSpeed();
        }
        try {
            if (this.M == null) {
                this.M = new ArrayList();
                h();
                f(location);
            } else {
                g(location);
            }
        } catch (Exception e) {
        }
        this.L++;
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
                if (this.aCp < this.t) {
                    this.C = true;
                    this.aCo = 0;
                    this.aCo += this.p;
                    return true;
                }
                return true;
            } else if (this.aCp >= this.t) {
                this.aCo = 0;
                this.C = false;
                return true;
            } else {
                this.aCo += this.p;
                if (this.aCo <= this.u || System.currentTimeMillis() - this.aCr > this.v * 1000) {
                    return true;
                }
            }
        } else if (this.aCp >= this.aBO || this.aCq >= this.aCm) {
            this.B = true;
            return true;
        } else if (this.w == 1 && System.currentTimeMillis() - this.aCr > this.x * 1000) {
            return true;
        }
        return false;
    }

    private void f() {
        this.M = null;
        this.e = 0L;
        this.L = 0;
        this.aCt = null;
        this.aBL = null;
        this.aCp = 0.0f;
        this.aCq = 0.0f;
    }

    private void f(Location location) {
        this.e = System.currentTimeMillis();
        b((int) (this.e / 1000));
        b((int) (location.getLongitude() * 1000000.0d));
        b((int) (location.getLatitude() * 1000000.0d));
        char c = location.hasBearing() ? (char) 0 : (char) 1;
        char c2 = location.hasSpeed() ? (char) 0 : (char) 1;
        if (c > 0) {
            this.M.add((byte) 32);
        } else {
            this.M.add(Byte.valueOf((byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & (-33))));
        }
        if (c2 > 0) {
            this.M.add(Byte.MIN_VALUE);
        } else {
            this.M.add(Byte.valueOf((byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & Byte.MAX_VALUE)));
        }
        this.aCt = location;
    }

    private void g() {
        if (this.e == 0 || System.currentTimeMillis() - this.e < this.p * 1000) {
            return;
        }
        if (com.baidu.location.f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
            f();
        } else if (this.n == 1 && !e()) {
            f();
        } else if (!a(com.baidu.location.h.c.c, com.baidu.location.f.getServiceContext())) {
            f();
        } else if (this.M != null) {
            int size = this.M.size();
            this.M.set(0, Byte.valueOf((byte) (size & 255)));
            this.M.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
            this.M.set(3, Byte.valueOf((byte) (this.L & 255)));
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = this.M.get(i).byteValue();
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
            this.aCr = System.currentTimeMillis();
        }
    }

    private void g(Location location) {
        if (location == null) {
            return;
        }
        int longitude = (int) ((location.getLongitude() - this.aCt.getLongitude()) * 100000.0d);
        int latitude = (int) ((location.getLatitude() - this.aCt.getLatitude()) * 100000.0d);
        char c = location.hasBearing() ? (char) 0 : (char) 1;
        char c2 = location.hasSpeed() ? (char) 0 : (char) 1;
        char c3 = longitude > 0 ? (char) 0 : (char) 1;
        int abs = Math.abs(longitude);
        char c4 = latitude > 0 ? (char) 0 : (char) 1;
        int abs2 = Math.abs(latitude);
        if (this.L > 1) {
            this.aBL = null;
            this.aBL = this.aCt;
        }
        this.aCt = location;
        if (this.aCt != null && this.aBL != null && this.aCt.getTime() > this.aBL.getTime() && this.aCt.getTime() - this.aBL.getTime() < TbConfig.NOTIFY_SOUND_INTERVAL) {
            long time = this.aCt.getTime() - this.aBL.getTime();
            float[] fArr = new float[2];
            Location.distanceBetween(this.aCt.getAltitude(), this.aCt.getLongitude(), this.aBL.getLatitude(), this.aBL.getLongitude(), fArr);
            double speed = (2.0f * (fArr[0] - (this.aBL.getSpeed() * ((float) time)))) / ((float) (time * time));
            if (speed > this.aCq) {
                this.aCq = (float) speed;
            }
        }
        this.M.add(Byte.valueOf((byte) (abs & 255)));
        this.M.add(Byte.valueOf((byte) (abs2 & 255)));
        if (c > 0) {
            byte b = c4 > 0 ? (byte) 96 : (byte) 32;
            if (c3 > 0) {
                b = (byte) (b | Byte.MIN_VALUE);
            }
            this.M.add(Byte.valueOf(b));
        } else {
            byte bearing = (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & 31);
            if (c4 > 0) {
                bearing = (byte) (bearing | 64);
            }
            if (c3 > 0) {
                bearing = (byte) (bearing | Byte.MIN_VALUE);
            }
            this.M.add(Byte.valueOf(bearing));
        }
        if (c2 > 0) {
            this.M.add(Byte.MIN_VALUE);
        } else {
            this.M.add(Byte.valueOf((byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & Byte.MAX_VALUE)));
        }
    }

    private void h() {
        this.M.add((byte) 0);
        this.M.add((byte) 0);
        if (f.equals("0")) {
            this.M.add((byte) 110);
        } else {
            this.M.add((byte) 126);
        }
        this.M.add((byte) 0);
        this.M.add(Byte.valueOf(this.aCw[0]));
        this.M.add(Byte.valueOf(this.aCw[1]));
        this.M.add(Byte.valueOf(this.aCw[2]));
        this.M.add(Byte.valueOf(this.aCw[3]));
        int length = this.K.length;
        this.M.add(Byte.valueOf((byte) ((length + 1) & 255)));
        for (int i = 0; i < length; i++) {
            this.M.add(Byte.valueOf(this.K[i]));
        }
    }

    private void i() {
        if (System.currentTimeMillis() - this.z > 86400000) {
            if (this.aCn == null) {
                this.aCn = new a();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(com.baidu.location.h.c.vn().a(false));
            stringBuffer.append(com.baidu.location.a.a.un().c());
            this.aCn.a(stringBuffer.toString());
        }
        j();
    }

    private void j() {
    }

    public static e uG() {
        if (aCl == null) {
            aCl = new e();
        }
        return aCl;
    }

    public void b() {
        if (this.N) {
            this.N = false;
            f();
        }
    }

    public void c(Location location) {
        if (!this.N) {
            c();
        }
        if (this.k == 1 && b.uD().f() < this.l * 100.0d && this.m.contains(com.baidu.location.f.c.a(com.baidu.location.f.c.vd().e()))) {
            if (this.n != 1 || this.y <= this.o) {
                this.aCv.post(new j(this, location));
            }
        }
    }
}
