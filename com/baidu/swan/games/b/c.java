package com.baidu.swan.games.b;

import android.support.annotation.NonNull;
import com.baidu.android.util.time.DateTimeUtil;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.n.a.b {
    private String chT;
    private String data;
    private String logType;

    public c(@NonNull String str, String str2, String str3, String str4) {
        super(str);
        this.chT = str2;
        this.logType = str3;
        this.data = str4;
    }

    @Override // com.baidu.swan.apps.n.a.b, com.baidu.swan.apps.n.a.a
    public String hu(String str) {
        String str2 = this.chT;
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
                return String.format("%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, this.logType, JSONObject.quote(com.baidu.swan.apps.as.h.getFormatDate(com.baidu.swan.apps.as.h.getCurrDate(), DateTimeUtil.TIME_FORMAT)), JSONObject.quote(this.data));
            case 1:
                return String.format("%s.message = { type:'log',logType:'%s',logs:[%s] };", str, this.logType, JSONObject.quote(this.data));
            case 2:
                return String.format("%s.message = { type:'act',act:'%s' };", str, this.data);
            default:
                return "";
        }
    }

    public static com.baidu.swan.apps.n.a.b eu(boolean z) {
        return new c("sconsole_entirety", "%s.message = { type:'act',act:'%s' };", null, z ? "show" : "hide");
    }

    public static com.baidu.swan.apps.n.a.b bs(String str, String str2) {
        return new c("sconsole_console", "%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, str2);
    }

    public static com.baidu.swan.apps.n.a.b bt(String str, String str2) {
        return new c("sconsole_system", "%s.message = { type:'log',logType:'%s',logs:[%s] };", str, str2);
    }
}
