package com.baidu.swan.games.c;

import android.support.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.event.a.b {
    private String daM;
    private String data;
    private String logType;

    public c(@NonNull String str, String str2, String str3, String str4) {
        super(str);
        this.daM = str2;
        this.logType = str3;
        this.data = str4;
    }

    @Override // com.baidu.swan.apps.event.a.b, com.baidu.swan.apps.event.a.a
    public String kl(String str) {
        String str2 = this.daM;
        char c = 65535;
        switch (str2.hashCode()) {
            case -2011830027:
                if (str2.equals("%s.message = { type:'act',act:'%s' };")) {
                    c = 2;
                    break;
                }
                break;
            case -774049378:
                if (str2.equals("%s.message = { type:'log',logType:'%s',logs:[%s, %s] };")) {
                    c = 0;
                    break;
                }
                break;
            case 2080164540:
                if (str2.equals("%s.message = { type:'log',logType:'%s',logs:[%s] };")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return String.format("%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, this.logType, JSONObject.quote(com.baidu.swan.apps.aq.i.a(com.baidu.swan.apps.aq.i.auw(), "yyyy-MM-dd HH:mm:ss")), JSONObject.quote(this.data));
            case 1:
                return String.format("%s.message = { type:'log',logType:'%s',logs:[%s] };", str, this.logType, JSONObject.quote(this.data));
            case 2:
                return String.format("%s.message = { type:'act',act:'%s' };", str, this.data);
            default:
                return "";
        }
    }

    public static com.baidu.swan.apps.event.a.b fP(boolean z) {
        return new c("sconsole_entirety", "%s.message = { type:'act',act:'%s' };", null, z ? "show" : "hide");
    }

    public static com.baidu.swan.apps.event.a.b ci(String str, String str2) {
        return new c("sconsole_console", "%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, str2);
    }

    public static com.baidu.swan.apps.event.a.b cj(String str, String str2) {
        return new c("sconsole_system", "%s.message = { type:'log',logType:'%s',logs:[%s] };", str, str2);
    }
}
