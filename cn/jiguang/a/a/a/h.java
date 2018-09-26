package cn.jiguang.a.a.a;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import cn.jiguang.d.d.aa;
import cn.jiguang.g.l;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h extends Thread {
    private static final Object i = new Object();
    private int a;
    private Context b;
    private String d;
    private String e;
    private String f;
    private int g;
    private WifiManager jM;
    private boolean[] jN;

    private h(WifiManager wifiManager, String str, String str2, String str3, Context context, int i2, int i3) {
        this.g = 2;
        this.jM = wifiManager;
        this.a = i2;
        this.b = context;
        this.g = i3;
        this.d = str2;
        this.e = str3;
        this.f = str;
        if (i3 == 2) {
            this.jN = new boolean[3];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(WifiManager wifiManager, String str, String str2, String str3, Context context, int i2, int i3, byte b) {
        this(wifiManager, str, str2, str3, context, 300, 2);
    }

    private static b D(String str) {
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        b bVar = new b();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= bytes.length - 1) {
                break;
            }
            i4++;
            if (bytes[i4] == 32) {
                if (i4 - i3 > 1) {
                    String str2 = new String(bytes, i3, i4 - i3);
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 == 3) {
                                    bVar.d(str2);
                                    break;
                                }
                            } else {
                                bVar.c(str2);
                            }
                        } else {
                            bVar.b(str2);
                        }
                    } else {
                        bVar.a(str2);
                    }
                    i2++;
                }
                i3 = i4 + 1;
            }
        }
        return bVar;
    }

    private ArrayList<b> a(String str) {
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        ArrayList<b> arrayList;
        Process process2 = null;
        try {
            process = c.B("cat /proc/net/arp");
            if (process == null) {
                if (process != null) {
                    process.destroy();
                }
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                try {
                    try {
                        bufferedReader.readLine();
                        arrayList = new ArrayList<>();
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    try {
                                        b D = D(readLine);
                                        if (D != null && D.b().equals("0x2") && !str.equals(D.a()) && !D.c().equals("00:00:00:00:00:00")) {
                                            arrayList.add(D);
                                        }
                                    } catch (Exception e) {
                                    }
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e2) {
                                    }
                                }
                            } catch (IOException e3) {
                                process2 = process;
                                bufferedReader2 = bufferedReader;
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e4) {
                                    }
                                }
                                if (process2 != null) {
                                    process2.destroy();
                                    return arrayList;
                                }
                                return arrayList;
                            }
                        }
                        bufferedReader.close();
                        if (process != null) {
                            process.destroy();
                            return arrayList;
                        }
                        return arrayList;
                    } catch (IOException e5) {
                        arrayList = null;
                        process2 = process;
                        bufferedReader2 = bufferedReader;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (IOException e7) {
                arrayList = null;
                process2 = process;
                bufferedReader2 = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (IOException e8) {
            bufferedReader2 = null;
            arrayList = null;
        } catch (Throwable th3) {
            th = th3;
            process = null;
            bufferedReader = null;
        }
    }

    private JSONObject a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, ArrayList<b> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            aa.a(this.b, jSONObject, "mac_list");
            jSONObject.put("ssid", str);
            jSONObject.put("bssid", str2);
            jSONObject.put("local_ip", str3);
            jSONObject.put("local_mac", str4);
            jSONObject.put("netmask", str5);
            JSONArray jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(str6)) {
                jSONArray.put(str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                jSONArray.put(str7);
            }
            jSONObject.put("dns", jSONArray);
            jSONObject.put("gateway", str8);
            jSONObject.put("dhcp", str9);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ip", next.a());
                jSONObject2.put("mac", next.c());
                jSONArray2.put(jSONObject2);
            }
            jSONObject.put("data", jSONArray2);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        DhcpInfo dhcpInfo = this.jM.getDhcpInfo();
        if (dhcpInfo == null) {
            return;
        }
        byte[] a = c.a(dhcpInfo.ipAddress);
        String a2 = c.a(dhcpInfo.ipAddress);
        String str = TextUtils.equals(a2, "0.0.0.0") ? "" : a2;
        String b = cn.jiguang.g.a.b(this.b, "");
        String a3 = c.a(dhcpInfo.netmask);
        String str2 = TextUtils.equals(a3, "0.0.0.0") ? "" : a3;
        String a4 = c.a(dhcpInfo.dns1);
        if (TextUtils.equals(a4, "0.0.0.0")) {
            a4 = "";
        }
        String a5 = c.a(dhcpInfo.dns2);
        if (TextUtils.equals(a5, "0.0.0.0")) {
            a5 = "";
        }
        String a6 = c.a(dhcpInfo.gateway);
        if (TextUtils.equals(a6, "0.0.0.0")) {
            a6 = "";
        }
        String a7 = c.a(dhcpInfo.serverAddress);
        if (TextUtils.equals(a7, "0.0.0.0")) {
            a7 = "";
        }
        l lVar = new l();
        try {
            if (this.g == 2) {
                for (int i2 = 0; i2 < 3; i2++) {
                    this.jN[i2] = false;
                    int i3 = (i2 * 85) + 0;
                    cn.jiguang.api.e.a(new f(new d(a7, this.a), a, i3, i3 + 85, new j(this, new l(), i2)), new int[0]);
                }
                synchronized (i) {
                    while (true) {
                        boolean z = false;
                        boolean[] zArr = this.jN;
                        int length = zArr.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                break;
                            } else if (!zArr[i4]) {
                                z = true;
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (!z) {
                            break;
                        }
                        try {
                            i.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
            } else {
                new d(a7, this.a).a(a, 0, 255);
            }
        } catch (Exception e2) {
        }
        lVar.a("ping");
        ArrayList<b> arrayList = null;
        try {
            arrayList = a(a7);
        } catch (Exception e3) {
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            aa.a(this.b, a(this.e, this.d, str, b, str2, a4, a5, a6, a7, arrayList), new i(this));
        }
        c.c(2);
    }
}
