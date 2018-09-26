package cn.jiguang.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.appsearchlib.Info;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e {
    private static final Pattern e = Pattern.compile("^[A-Za-z][A-Za-z0-9_]*[.]+([A-Za-z][A-Za-z0-9_:.]*)*$");
    private static final Pattern f = Pattern.compile("^zygote[0-9]*$");
    public String a;
    private String b;
    private String c;
    private String d;

    private static int a(LinkedList<String> linkedList, String str, int i) {
        int indexOf = linkedList.indexOf(str);
        if (indexOf == -1) {
            indexOf = linkedList.indexOf(str.toLowerCase(Locale.ENGLISH));
        }
        return indexOf == -1 ? i : indexOf;
    }

    public static Map<String, Integer> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, str.split("\\s+"));
        int size = linkedList.size() - 1;
        HashMap hashMap = new HashMap();
        int a = a(linkedList, "USER", 0);
        int a2 = a(linkedList, "PID", 1);
        int a3 = a(linkedList, "PPID", 2);
        int a4 = a(linkedList, "NAME", size);
        if (a == 0 && a2 == 1 && a3 == 2 && a4 == size) {
            return null;
        }
        return hashMap;
    }

    public static e b(String str, Map<String, Integer> map) {
        String[] split;
        int length;
        if (!TextUtils.isEmpty(str) && (length = (split = str.split("\\s+")).length) >= 3) {
            try {
                e eVar = new e();
                if (map == null || map.isEmpty()) {
                    eVar.b = split[0];
                    eVar.c = split[1];
                    eVar.d = split[2];
                    eVar.a = split[length - 1];
                } else {
                    eVar.b = split[map.get("USER").intValue()];
                    eVar.c = split[map.get("PID").intValue()];
                    eVar.d = split[map.get("PPID").intValue()];
                    eVar.a = split[map.get("NAME").intValue()];
                }
                return eVar;
            } catch (Throwable th) {
                Log.w("AppStatUtils", "parse ps printString err, " + th.getMessage());
                return null;
            }
        }
        return null;
    }

    public final JSONObject a(int i) {
        try {
            return new JSONObject().put("uid", this.b).put(Info.kBaiduPIDKey, this.c).put("ppid", this.d).put("proc_name", i.a(this.a, 128));
        } catch (JSONException e2) {
            return null;
        }
    }

    public final boolean a() {
        return this.d.equals("0") || this.d.equals("1") || this.d.equals("2");
    }

    public final boolean b() {
        return f.matcher(this.a).matches();
    }

    public final String toString() {
        return "ProcessInfo{user='" + this.b + "', pid='" + this.c + "', ppid='" + this.d + "', procName='" + this.a + "'}";
    }
}
