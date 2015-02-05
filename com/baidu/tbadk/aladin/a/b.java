package com.baidu.tbadk.aladin.a;

import android.content.ComponentName;
import android.content.Intent;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private String Au;
    private int errorCode = 0;
    private Intent intent;
    private String response;
    private String url;

    public b(a aVar) {
        if (aVar != null) {
            this.url = aVar.getUrl();
        }
    }

    public boolean kP() {
        HashMap<String, String> i;
        if (this.url == null || (i = i(this.url.split("&"))) == null) {
            return false;
        }
        for (Map.Entry<String, String> entry : i.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    if ("intent".equals(key)) {
                        bw(value);
                    } else if (!"t".equals(key) && "callback".equals(key)) {
                        this.Au = value;
                        kQ();
                    }
                }
            }
        }
        return (this.intent == null || this.response == null) ? false : true;
    }

    private void bw(String str) {
        String[] split;
        boolean z;
        boolean z2;
        int i;
        if (str != null && (split = str.split(";")) != null) {
            this.intent = new Intent();
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
                            this.intent.setAction(str3);
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
                            this.intent.setFlags(i);
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
                            this.intent.putExtra(str2, str3);
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
                this.intent = null;
            }
        }
    }

    private void kQ() {
        if (this.Au != null) {
            this.response = String.valueOf(this.Au) + "({\"error\":" + this.errorCode + "})";
        }
    }

    private HashMap<String, String> i(String[] strArr) {
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

    public Intent getIntent() {
        return this.intent;
    }

    public String getResponse() {
        if (this.response == null) {
            kQ();
        }
        return this.response;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
        kQ();
    }
}
