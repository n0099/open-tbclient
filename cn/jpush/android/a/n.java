package cn.jpush.android.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.service.ServiceInterface;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class n {
    private static ConcurrentLinkedQueue<Long> a = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public static long a(Context context, String str, int i, long j) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("code", cn.jpush.android.api.b.j);
            long optLong = i == 0 ? jSONObject.optLong("sequence") : j;
            Intent intent = new Intent();
            intent.addCategory(cn.jpush.android.a.c);
            intent.putExtra("proto_type", i);
            intent.setPackage(context.getPackageName());
            if (i == 0) {
                intent.setAction("cn.jpush.android.intent.TAG_ALIAS_CALLBACK");
            } else {
                intent.setAction("cn.jpush.android.intent.RECEIVE_MESSAGE");
                if (i == 1) {
                    intent.putExtra(PushMessageHelper.MESSAGE_TYPE, 1);
                } else {
                    intent.putExtra(PushMessageHelper.MESSAGE_TYPE, 2);
                }
            }
            intent.putExtra("tagalias_errorcode", optInt);
            intent.putExtra("tagalias_seqid", optLong);
            Intent a2 = o.a().a(context, optLong, optInt, jSONObject, intent);
            if (a2 != null) {
                context.sendBroadcast(a2);
                return optLong;
            }
            return optLong;
        } catch (Throwable th) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static cn.jpush.a.c a(Context context, String str, long j, int i) {
        if (i == 2 || i == 3 || i == 5) {
            try {
                JSONObject a2 = a(i);
                if (i == 2) {
                    if (TextUtils.isEmpty(str)) {
                        cn.jpush.android.d.f.d("TagAliasHelper", "alias was empty. Give up action.");
                        a(context, 2, cn.jpush.android.api.b.b, j);
                        return null;
                    } else if (!a(context, 2, str, j)) {
                        return null;
                    } else {
                        a2.put("alias", str);
                    }
                }
                String jSONObject = a2.toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    return new cn.jpush.a.c(1, 29, j, cn.jiguang.api.e.getAppKey(), jSONObject);
                }
            } catch (Throwable th) {
            }
            return null;
        }
        a(context, 2, cn.jpush.android.api.b.j, j);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static cn.jpush.a.c a(Context context, List<String> list, long j, int i, int i2) {
        if (i != 0) {
            try {
                JSONObject a2 = a(i);
                if (i == 1 || i == 2 || i == 3 || i == 6) {
                    if (list == null || list.isEmpty()) {
                        cn.jpush.android.d.f.d("TagAliasHelper", "tags was empty. Give up action.");
                        a(context, 1, cn.jpush.android.api.b.b, j);
                        return null;
                    }
                    HashSet hashSet = new HashSet(list);
                    if (!a(context, 1, hashSet, j)) {
                        return null;
                    }
                    String b = b(hashSet);
                    if (!b(context, b, j, 1)) {
                        return null;
                    }
                    if (i != 6) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str : list) {
                            jSONArray.put(str);
                        }
                        a2.put("tags", jSONArray);
                    } else if (TextUtils.isEmpty(b)) {
                        cn.jpush.android.d.f.d("TagAliasHelper", "stags was empty. Give up action.");
                        a(context, 1, cn.jpush.android.api.b.b, j);
                        return null;
                    } else {
                        a2.put("tags", b);
                    }
                }
                if (i == 5) {
                    if (i2 == -1) {
                        i2 = 1;
                    }
                    a2.put("curr", i2);
                }
                String jSONObject = a2.toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    return new cn.jpush.a.c(1, 28, j, cn.jiguang.api.e.getAppKey(), jSONObject);
                }
            } catch (Throwable th) {
            }
            return null;
        }
        a(context, 1, cn.jpush.android.api.b.j, j);
        return null;
    }

    private static cn.jpush.a.c a(Context context, List<String> list, String str, long j) {
        HashSet hashSet = list != null ? new HashSet(list) : null;
        if (str == null || a(context, 0, str, j)) {
            if (hashSet == null || a(context, 0, hashSet, j)) {
                String b = b(hashSet);
                if (b(context, b, j, 0)) {
                    if (b == null && str == null) {
                        cn.jpush.android.d.f.d("TagAliasHelper", "NULL alias and tags. Give up action.");
                        a(context, 0, cn.jpush.android.api.b.b, j);
                        return null;
                    }
                    cn.jpush.android.d.f.a("TagAliasHelper", "action:setAliasAndTags - alias:" + str + ", tags:" + b);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("platform", Config.APP_VERSION_CODE);
                        if (str != null) {
                            jSONObject.put("alias", str);
                        }
                        if (hashSet != null) {
                            jSONObject.put("tags", b);
                        }
                        String jSONObject2 = jSONObject.toString();
                        if (!TextUtils.isEmpty(jSONObject2)) {
                            return new cn.jpush.a.c(4, 10, j, cn.jiguang.api.e.getAppKey(), jSONObject2);
                        }
                    } catch (Throwable th) {
                        a(context, 0, cn.jpush.android.api.b.j, j);
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static Set<String> a(Set<String> set) {
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        Iterator<String> it = set.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedHashSet;
            }
            String next = it.next();
            if (TextUtils.isEmpty(next) || !cn.jpush.android.d.h.a(next)) {
                cn.jpush.android.d.f.d("TagAliasHelper", "Invalid tag : " + next);
                i = i2;
            } else {
                linkedHashSet.add(next);
                i = i2 + 1;
                if (i >= 1000) {
                    cn.jpush.android.d.f.c("TagAliasHelper", "The lenght of tags maybe more than 1000.");
                    return linkedHashSet;
                }
            }
        }
    }

    private static JSONObject a(int i) {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", Config.APP_VERSION_CODE);
        switch (i) {
            case 1:
                str = "add";
                break;
            case 2:
                str = "set";
                break;
            case 3:
                str = "del";
                break;
            case 4:
                str = "clean";
                break;
            case 5:
                str = "get";
                break;
            case 6:
                str = "valid";
                break;
            default:
                str = null;
                break;
        }
        jSONObject.put("op", str);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, int i, int i2, long j) {
        try {
            Intent intent = new Intent();
            intent.addCategory(context.getPackageName());
            intent.setPackage(context.getPackageName());
            if (i == 0) {
                intent.setAction("cn.jpush.android.intent.TAG_ALIAS_CALLBACK");
            } else {
                intent.setAction("cn.jpush.android.intent.RECEIVE_MESSAGE");
                if (i == 1) {
                    intent.putExtra(PushMessageHelper.MESSAGE_TYPE, 1);
                } else {
                    intent.putExtra(PushMessageHelper.MESSAGE_TYPE, 2);
                }
            }
            intent.putExtra("tagalias_errorcode", i2);
            intent.putExtra("tagalias_seqid", j);
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            cn.jpush.android.d.f.c("TagAliasHelper", "NotifyTagAliasError:" + th.getMessage());
        }
    }

    public static void a(Context context, int i, String str, int i2, int i3) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        a(context, str, (Set<String>) null, new cn.jpush.android.api.a(i, str, System.currentTimeMillis(), 2, i3));
    }

    public static void a(Context context, int i, Set<String> set, int i2, int i3) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        a(context, (String) null, set, new cn.jpush.android.api.a(i, set, System.currentTimeMillis(), 1, i3));
    }

    public static void a(Context context, Bundle bundle) {
        char c;
        String string = bundle.getString("alias");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("tags");
        long j = bundle.getLong("seq_id", 0L);
        int i = 0;
        int i2 = 0;
        try {
            i = Integer.parseInt(bundle.getString("proto_type"));
        } catch (Throwable th) {
            a(context, 0, cn.jpush.android.api.b.j, j);
        }
        try {
            i2 = Integer.parseInt(bundle.getString("protoaction_type"));
        } catch (Throwable th2) {
            a(context, i, cn.jpush.android.api.b.j, j);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (a.size() < 10) {
            a.offer(Long.valueOf(currentTimeMillis));
            c = 0;
        } else {
            long longValue = currentTimeMillis - a.element().longValue();
            if (longValue < 0) {
                a.clear();
                c = 2;
            } else if (longValue > ErrDef.Feature.WEIGHT) {
                while (a.size() >= 10) {
                    a.poll();
                }
                a.offer(Long.valueOf(currentTimeMillis));
                c = 0;
            } else {
                c = 1;
            }
        }
        if (c != 0) {
            a(context, i, c == 1 ? cn.jpush.android.api.b.l : cn.jpush.android.api.b.n, j);
            return;
        }
        o.a();
        if (o.a(context, i, j)) {
            a(context, i, cn.jpush.android.api.b.u, j);
            return;
        }
        cn.jpush.a.c cVar = null;
        if (i == 0) {
            cVar = a(context, stringArrayList, string, j);
        } else if (i == 1) {
            cVar = a(context, stringArrayList, j, i2, -1);
        } else if (i == 2) {
            cVar = a(context, string, j, i2);
        }
        if (cVar != null && (i == 1 || i == 2)) {
            if (!o.a().a(i)) {
                a(context, i, i == 1 ? cn.jpush.android.api.b.v : cn.jpush.android.api.b.w, j);
                return;
            }
            o.a().a(i, i2, j, stringArrayList, string);
        }
        a(context, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, cn.jpush.a.c cVar) {
        cn.jpush.android.d.f.a("TagAliasHelper", "tagalias:" + cVar);
        if (cVar != null) {
            f.a(context).a(cVar, HttpConstants.HTTP_CONNECT_TIMEOUT);
        }
    }

    public static void a(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback, int i, int i2) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        a(context, str, set, new cn.jpush.android.api.a(str, set, tagAliasCallback, System.currentTimeMillis(), 0, 0));
    }

    private static void a(Context context, String str, Set<String> set, cn.jpush.android.api.a aVar) {
        long by = cn.jiguang.api.e.by();
        if (aVar != null) {
            cn.jpush.android.service.f.a().a(context, Long.valueOf(by), aVar);
        }
        if (ServiceInterface.d(context)) {
            cn.jpush.android.service.f.a().a(context, cn.jpush.android.api.b.m, by, aVar);
            return;
        }
        Context applicationContext = !(context instanceof Application) ? context.getApplicationContext() : context;
        if (!cn.jpush.android.a.a(applicationContext)) {
            cn.jpush.android.service.f.a().a(applicationContext, cn.jpush.android.api.b.j, by, aVar);
            return;
        }
        if (aVar.e == 0) {
            cn.jpush.android.service.f.a().a(applicationContext);
        }
        ServiceInterface.a(applicationContext, str, set, by, aVar);
    }

    private static boolean a(Context context, int i, String str, long j) {
        int b = cn.jpush.android.d.h.b(str);
        if (b != 0) {
            cn.jpush.android.d.f.a("TagAliasHelper", "Invalid alias: " + str + ", will not set alias this time.");
            a(context, i, b, j);
            return false;
        }
        return true;
    }

    private static boolean a(Context context, int i, Set<String> set, long j) {
        int a2 = cn.jpush.android.d.h.a(set);
        if (a2 != 0) {
            cn.jpush.android.d.f.a("TagAliasHelper", "Invalid tags, will not set tags this time.");
            a(context, i, a2, j);
            return false;
        }
        return true;
    }

    public static String b(Set<String> set) {
        int i;
        String str = null;
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return "";
        }
        int i2 = 0;
        for (String str2 : set) {
            if (TextUtils.isEmpty(str2) || !cn.jpush.android.d.h.a(str2)) {
                cn.jpush.android.d.f.d("TagAliasHelper", "Invalid tag: " + str2);
                i = i2;
            } else {
                str = str == null ? str2 : str + "," + str2;
                i = i2 + 1;
                if (i >= 1000) {
                    return str;
                }
            }
            str = str;
            i2 = i;
        }
        return str;
    }

    private static boolean b(Context context, String str, long j, int i) {
        if (str != null) {
            String replaceAll = str.replaceAll(",", "");
            boolean z = i != 0;
            int length = !TextUtils.isEmpty(replaceAll) ? replaceAll.getBytes().length + 0 : 0;
            if (!(z ? length <= 5000 : length <= 7000)) {
                a(context, i, cn.jpush.android.api.b.i, j);
                cn.jpush.android.d.f.c("TagAliasHelper", "The length of tags should be less than " + (i != 0 ? 5000 : 7000) + " bytes.");
                return false;
            }
        }
        return true;
    }
}
