package com.baidu.tbadk.aladin.a;

import android.content.ComponentName;
import android.content.Intent;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private String a;
    private Intent b;
    private String c;
    private String d;
    private int e = 0;

    public b(a aVar) {
        if (aVar != null) {
            this.a = aVar.b();
        }
    }

    public boolean a() {
        HashMap<String, String> a;
        if (this.a == null || (a = a(this.a.split("&"))) == null) {
            return false;
        }
        for (Map.Entry<String, String> entry : a.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    if ("intent".equals(key)) {
                        a(value);
                    } else if (!"t".equals(key) && "callback".equals(key)) {
                        this.d = value;
                        d();
                    }
                }
            }
        }
        return (this.b == null || this.c == null) ? false : true;
    }

    private void a(String str) {
        String[] split;
        boolean z;
        boolean z2;
        int i;
        if (str != null && (split = str.split(";")) != null) {
            this.b = new Intent();
            int length = split.length;
            int i2 = 0;
            boolean z3 = false;
            boolean z4 = false;
            while (i2 < length) {
                String[] split2 = split[i2].split("=");
                if (split2 != null && split2.length == 2) {
                    String str2 = split2[0];
                    String str3 = split2[1];
                    if ("action".equals(str2)) {
                        if ("com.baidu.tieba.VIEW".equals(str3)) {
                            this.b.setAction(str3);
                            z = z3;
                            z2 = true;
                            i2++;
                            z4 = z2;
                            z3 = z;
                        }
                    } else {
                        if ("launchFlags".equals(str2)) {
                            try {
                                i = Integer.parseInt(str3.startsWith("0x") ? str3.substring(2) : str3, 16);
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                i = 0;
                            }
                            this.b.setFlags(i);
                            z = z3;
                            z2 = z4;
                        } else if ("component".equals(str2)) {
                            try {
                                if (".service.WebNativeReceiver".equals(ComponentName.unflattenFromString(str3).getShortClassName())) {
                                    z = true;
                                    z2 = z4;
                                }
                            } catch (Exception e2) {
                                z = z3;
                                z2 = z4;
                            }
                        } else if (str2 != null && str3 != null) {
                            if (str2.indexOf(".") >= 0) {
                                str2 = str2.substring(str2.indexOf(".") + 1);
                            }
                            this.b.putExtra(str2, str3);
                        }
                        i2++;
                        z4 = z2;
                        z3 = z;
                    }
                }
                z = z3;
                z2 = z4;
                i2++;
                z4 = z2;
                z3 = z;
            }
            if (!z3 || !z4) {
                this.b = null;
            }
        }
    }

    private void d() {
        if (this.d != null) {
            this.c = String.valueOf(this.d) + "({\"error\":" + this.e + "})";
        }
    }

    private HashMap<String, String> a(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            HashMap<String, String> hashMap = new HashMap<>(strArr.length);
            for (String str : strArr) {
                String[] split = str.split("=");
                if (split != null && split.length == 2) {
                    String str2 = split[0];
                    String str3 = split[1];
                    if (str2 != null && str3 != null) {
                        try {
                            hashMap.put(str2, URLDecoder.decode(str3, "UTF-8"));
                        } catch (Exception e) {
                        }
                    }
                }
            }
            return hashMap;
        }
        return null;
    }

    public Intent b() {
        return this.b;
    }

    public String c() {
        if (this.c == null) {
            d();
        }
        return this.c;
    }

    public void a(int i) {
        this.e = i;
        d();
    }
}
