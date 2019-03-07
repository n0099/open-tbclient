package com.baidu.swan.games.c;

import android.support.annotation.NonNull;
import com.baidu.sapi2.views.SmsLoginView;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends com.baidu.swan.apps.m.a.b {
    private String baW;
    private String baX;
    private String data;

    public b(@NonNull String str, String str2, String str3, String str4) {
        super(str);
        this.baW = str2;
        this.baX = str3;
        this.data = str4;
    }

    @Override // com.baidu.swan.apps.m.a.b, com.baidu.swan.apps.m.a.a
    public String eB(String str) {
        String str2 = this.baW;
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
                return String.format("%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, this.baX, JSONObject.quote(com.baidu.swan.apps.an.e.a(com.baidu.swan.apps.an.e.LQ(), "yyyy-MM-dd HH:mm:ss")), JSONObject.quote(this.data));
            case 1:
                return String.format("%s.message = { type:'log',logType:'%s',logs:[%s] };", str, this.baX, JSONObject.quote(this.data));
            case 2:
                return String.format("%s.message = { type:'act',act:'%s' };", str, this.data);
            default:
                return "";
        }
    }

    public static com.baidu.swan.apps.m.a.b cu(boolean z) {
        return new b("sconsole_entirety", "%s.message = { type:'act',act:'%s' };", null, z ? SmsLoginView.StatEvent.LOGIN_SHOW : "hide");
    }

    public static com.baidu.swan.apps.m.a.b aO(String str, String str2) {
        return new b("sconsole_console", "%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, str2);
    }

    public static com.baidu.swan.apps.m.a.b aP(String str, String str2) {
        return new b("sconsole_system", "%s.message = { type:'log',logType:'%s',logs:[%s] };", str, str2);
    }
}
