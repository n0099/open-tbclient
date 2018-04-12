package com.baidu.location.c;

import com.baidu.tieba.model.ReportUserInfoModel;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static d OA = null;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private String e = null;
    private String f = null;
    private String g = "loc.map.baidu.com";
    private String h = "dns.map.baidu.com";
    private int i = 0;
    private a OB = new a();

    /* loaded from: classes.dex */
    private class a extends com.baidu.location.h.f {
        private boolean b = false;

        public a() {
        }

        @Override // com.baidu.location.h.f
        public void a() {
            if (d.this.h.equals("dns.map.baidu.com") || System.currentTimeMillis() - d.this.b > 720000) {
                switch (com.baidu.location.f.c.nJ().g()) {
                    case 1:
                        d.this.h = "111.13.100.247";
                        break;
                    case 2:
                        d.this.h = "111.206.37.190";
                        break;
                    case 3:
                        d.this.h = "180.97.33.196";
                        break;
                    default:
                        d.this.h = "dns.map.baidu.com";
                        break;
                }
            }
            this.h = "http://" + d.this.h + ":80/remotedns?pid=lbs-geolocation";
        }

        @Override // com.baidu.location.h.f
        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    if (jSONObject.getInt("errno") == 0 && jSONObject.has("data")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("data");
                        JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                        JSONObject jSONObject3 = jSONArray.getJSONObject(1);
                        String string = jSONObject2.has("loc.map.baidu.com") ? jSONObject2.getJSONArray("loc.map.baidu.com").getJSONObject(0).getString("ip") : null;
                        String string2 = jSONObject3.has("dns.map.baidu.com") ? jSONObject3.getJSONArray("dns.map.baidu.com").getJSONObject(0).getString("ip") : null;
                        if (string != null && string2 != null) {
                            d.this.h = string2;
                            d.this.g = string;
                        }
                        if (jSONObject.has("switch")) {
                            d.this.i = jSONObject.getInt("switch");
                        }
                        d.this.b = System.currentTimeMillis();
                        c();
                    }
                } catch (Exception e) {
                }
            }
            this.b = false;
        }

        void b() {
            if (this.b) {
                return;
            }
            this.b = true;
            d();
        }

        void c() {
            String str;
            InetAddress inetAddress;
            if (System.currentTimeMillis() - d.this.d < 1200000) {
                d.this.d();
                return;
            }
            try {
                str = (String) Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).getMethod("get", String.class).invoke(null, "net.dns1");
            } catch (Exception e) {
                str = null;
            }
            try {
                inetAddress = InetAddress.getByName("loc.map.baidu.com");
            } catch (Exception e2) {
                inetAddress = null;
            }
            if (inetAddress == null || inetAddress.getHostAddress() == null || str == null || "".equals(str)) {
                return;
            }
            d.this.e = str;
            d.this.f = inetAddress.getHostAddress();
            d.this.d = System.currentTimeMillis();
            d.this.d();
        }
    }

    private d() {
        e();
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("dnsServer")) {
                this.e = jSONObject.getString("dnsServer");
            }
            if (jSONObject.has("locServer")) {
                this.f = jSONObject.getString("locServer");
            }
            if (jSONObject.has("address")) {
                this.g = jSONObject.getString("address");
            }
            if (jSONObject.has("locServer")) {
                this.h = jSONObject.getString("dnsServerIp");
            }
            if (jSONObject.has("DnsProxyTime")) {
                this.b = jSONObject.getLong("DnsProxyTime");
            }
            if (jSONObject.has("DnsExtraTime")) {
                this.c = jSONObject.getLong("DnsExtraTime");
            }
            if (jSONObject.has("DnsExtraUpdateTime")) {
                this.d = jSONObject.getLong("DnsExtraUpdateTime");
            }
            if (jSONObject.has(com.baidu.fsg.biometrics.base.b.c.l)) {
                this.i = jSONObject.getInt(com.baidu.fsg.biometrics.base.b.c.l);
            }
        } catch (Exception e) {
        }
    }

    private String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.e != null) {
                jSONObject.put("dnsServer", this.e);
            }
            if (this.f != null) {
                jSONObject.put("locServer", this.f);
            }
            if (this.g != null) {
                jSONObject.put("address", this.g);
            }
            if (this.h != null) {
                jSONObject.put("dnsServerIp", this.h);
            }
            jSONObject.put("DnsProxyTime", this.b);
            jSONObject.put("DnsExtraTime", this.c);
            jSONObject.put("DnsExtraUpdateTime", this.d);
            jSONObject.put(com.baidu.fsg.biometrics.base.b.c.l, this.i);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
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
            randomAccessFile2.seek(800L);
            String c = c();
            if (c != null) {
                randomAccessFile2.writeBoolean(true);
                byte[] bytes2 = c.getBytes();
                randomAccessFile2.writeInt(bytes2.length);
                randomAccessFile2.write(bytes2);
            } else {
                randomAccessFile2.writeBoolean(false);
            }
            randomAccessFile2.close();
        } catch (Error e) {
        } catch (Exception e2) {
        }
    }

    private void e() {
        try {
            File file = new File(com.baidu.location.h.h.a + "/grtcf.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(800L);
                if (randomAccessFile.readBoolean()) {
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    a(new String(bArr));
                }
                randomAccessFile.close();
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
    }

    public static d nl() {
        if (OA == null) {
            OA = new d();
        }
        return OA;
    }

    public String b() {
        String str = "loc.map.baidu.com";
        if (this.i == 1 && System.currentTimeMillis() - this.b < 360000) {
            str = this.g;
        }
        if (System.currentTimeMillis() - this.b > ReportUserInfoModel.TIME_INTERVAL) {
            this.OB.b();
        }
        return str;
    }
}
