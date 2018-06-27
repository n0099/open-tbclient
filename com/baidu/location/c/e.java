package com.baidu.location.c;

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
public class e {
    private static e WH = null;
    public static String f = "0";
    private Handler WP;
    private int k = 1;
    private double l = 0.699999988079071d;
    private String m = "3G|4G";
    private int n = 1;
    private int o = 307200;
    private int p = 15;
    private int q = 1;
    private double Wk = 3.5d;
    private double WI = 3.0d;
    private double WJ = 0.5d;
    private int u = 300;
    private int v = 60;
    private int w = 0;
    private int x = 60;
    private int y = 0;
    private long z = 0;
    private a WK = null;
    private boolean B = false;
    private boolean C = false;
    private int D = 0;
    private float WL = 0.0f;
    private float WM = 0.0f;
    private long G = 0;
    private int H = 500;
    long a = 0;
    Location WN = null;
    Location Wh = null;
    StringBuilder WO = null;
    long e = 0;
    private byte[] WQ = new byte[4];
    private byte[] WR = null;
    private int L = 0;
    private List<Byte> WS = null;
    private boolean N = false;
    int g = 0;
    double h = 116.22345545d;
    double WT = 40.245667323d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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
            this.k.put("q", encode);
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
        this.WP = null;
        this.WP = new Handler();
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
            this.WS.add(Byte.valueOf(a2[i2]));
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
            byte[] bytes2 = (b("%d_%02d_%02d") + SystemInfoUtil.COLON + i).getBytes();
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
                    this.Wk = jSONObject.getDouble("spsh");
                }
                if (jSONObject.has("acsh")) {
                    this.WI = jSONObject.getDouble("acsh");
                }
                if (jSONObject.has("stspsh")) {
                    this.WJ = jSONObject.getDouble("stspsh");
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
        this.WQ[0] = 0;
        this.WQ[1] = 0;
        this.WQ[2] = 0;
        this.WQ[3] = 0;
        if (length >= 4) {
            length = 4;
        }
        for (int i = 0; i < length; i++) {
            try {
                this.WQ[i] = (byte) (Integer.valueOf(split[i]).intValue() & 255);
            } catch (Exception e) {
            }
        }
        this.WR = a(com.baidu.location.h.c.c + SystemInfoUtil.COLON + com.baidu.location.h.c.rf().b);
    }

    private void d(Location location) {
        if (System.currentTimeMillis() - this.a < this.H || location == null) {
            return;
        }
        if (location != null && location.hasSpeed() && location.getSpeed() > this.WL) {
            this.WL = location.getSpeed();
        }
        try {
            if (this.WS == null) {
                this.WS = new ArrayList();
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
        this.e = System.currentTimeMillis();
        b((int) (this.e / 1000));
        b((int) (location.getLongitude() * 1000000.0d));
        b((int) (location.getLatitude() * 1000000.0d));
        char c = location.hasBearing() ? (char) 0 : (char) 1;
        char c2 = location.hasSpeed() ? (char) 0 : (char) 1;
        if (c > 0) {
            this.WS.add((byte) 32);
        } else {
            this.WS.add(Byte.valueOf((byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & (-33))));
        }
        if (c2 > 0) {
            this.WS.add(Byte.MIN_VALUE);
        } else {
            this.WS.add(Byte.valueOf((byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & Byte.MAX_VALUE)));
        }
        this.WN = location;
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
                if (this.WL < this.WJ) {
                    this.C = true;
                    this.D = 0;
                    this.D += this.p;
                    return true;
                }
                return true;
            } else if (this.WL >= this.WJ) {
                this.D = 0;
                this.C = false;
                return true;
            } else {
                this.D += this.p;
                if (this.D <= this.u || System.currentTimeMillis() - this.G > this.v * 1000) {
                    return true;
                }
            }
        } else if (this.WL >= this.Wk || this.WM >= this.WI) {
            this.B = true;
            return true;
        } else if (this.w == 1 && System.currentTimeMillis() - this.G > this.x * 1000) {
            return true;
        }
        return false;
    }

    private void f() {
        this.WS = null;
        this.e = 0L;
        this.L = 0;
        this.WN = null;
        this.Wh = null;
        this.WL = 0.0f;
        this.WM = 0.0f;
    }

    private void f(Location location) {
        if (location == null) {
            return;
        }
        int longitude = (int) ((location.getLongitude() - this.WN.getLongitude()) * 100000.0d);
        int latitude = (int) ((location.getLatitude() - this.WN.getLatitude()) * 100000.0d);
        char c = location.hasBearing() ? (char) 0 : (char) 1;
        char c2 = location.hasSpeed() ? (char) 0 : (char) 1;
        char c3 = longitude > 0 ? (char) 0 : (char) 1;
        int abs = Math.abs(longitude);
        char c4 = latitude > 0 ? (char) 0 : (char) 1;
        int abs2 = Math.abs(latitude);
        if (this.L > 1) {
            this.Wh = null;
            this.Wh = this.WN;
        }
        this.WN = location;
        if (this.WN != null && this.Wh != null && this.WN.getTime() > this.Wh.getTime() && this.WN.getTime() - this.Wh.getTime() < TbConfig.NOTIFY_SOUND_INTERVAL) {
            long time = this.WN.getTime() - this.Wh.getTime();
            float[] fArr = new float[2];
            Location.distanceBetween(this.WN.getAltitude(), this.WN.getLongitude(), this.Wh.getLatitude(), this.Wh.getLongitude(), fArr);
            double speed = (2.0f * (fArr[0] - (this.Wh.getSpeed() * ((float) time)))) / ((float) (time * time));
            if (speed > this.WM) {
                this.WM = (float) speed;
            }
        }
        this.WS.add(Byte.valueOf((byte) (abs & 255)));
        this.WS.add(Byte.valueOf((byte) (abs2 & 255)));
        if (c > 0) {
            byte b = c4 > 0 ? (byte) 96 : (byte) 32;
            if (c3 > 0) {
                b = (byte) (b | Byte.MIN_VALUE);
            }
            this.WS.add(Byte.valueOf(b));
        } else {
            byte bearing = (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & 31);
            if (c4 > 0) {
                bearing = (byte) (bearing | 64);
            }
            if (c3 > 0) {
                bearing = (byte) (bearing | Byte.MIN_VALUE);
            }
            this.WS.add(Byte.valueOf(bearing));
        }
        if (c2 > 0) {
            this.WS.add(Byte.MIN_VALUE);
        } else {
            this.WS.add(Byte.valueOf((byte) (((byte) (((int) ((location.getSpeed() * 3.6d) / 4.0d)) & 255)) & Byte.MAX_VALUE)));
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
        } else if (!a(com.baidu.location.h.c.c, com.baidu.location.f.getServiceContext())) {
            f();
        } else if (this.WS != null) {
            int size = this.WS.size();
            this.WS.set(0, Byte.valueOf((byte) (size & 255)));
            this.WS.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
            this.WS.set(3, Byte.valueOf((byte) (this.L & 255)));
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = this.WS.get(i).byteValue();
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
            this.G = System.currentTimeMillis();
        }
    }

    private void h() {
        this.WS.add((byte) 0);
        this.WS.add((byte) 0);
        if (f.equals("0")) {
            this.WS.add((byte) 110);
        } else {
            this.WS.add((byte) 126);
        }
        this.WS.add((byte) 0);
        this.WS.add(Byte.valueOf(this.WQ[0]));
        this.WS.add(Byte.valueOf(this.WQ[1]));
        this.WS.add(Byte.valueOf(this.WQ[2]));
        this.WS.add(Byte.valueOf(this.WQ[3]));
        int length = this.WR.length;
        this.WS.add(Byte.valueOf((byte) ((length + 1) & 255)));
        for (int i = 0; i < length; i++) {
            this.WS.add(Byte.valueOf(this.WR[i]));
        }
    }

    private void i() {
        if (System.currentTimeMillis() - this.z > 86400000) {
            if (this.WK == null) {
                this.WK = new a();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(com.baidu.location.h.c.rf().a(false));
            stringBuffer.append(com.baidu.location.a.a.qg().c());
            this.WK.a(stringBuffer.toString());
        }
        j();
    }

    private void j() {
    }

    public static e qy() {
        if (WH == null) {
            WH = new e();
        }
        return WH;
    }

    public void b() {
        if (this.N) {
            this.N = false;
            f();
        }
    }

    public void b(Location location) {
        if (!this.N) {
            c();
        }
        if (this.k == 1 && b.qv().f() < this.l * 100.0d && this.m.contains(com.baidu.location.f.c.a(com.baidu.location.f.c.qV().e()))) {
            if (this.n != 1 || this.y <= this.o) {
                this.WP.post(new j(this, location));
            }
        }
    }
}
