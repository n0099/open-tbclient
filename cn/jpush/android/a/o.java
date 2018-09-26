package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class o {
    private static volatile o a;
    private static final Object b = new Object();
    private ConcurrentHashMap<Long, p> c = new ConcurrentHashMap<>();

    public static o a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new o();
                }
            }
        }
        return a;
    }

    private static p a(JSONObject jSONObject, p pVar) {
        if (pVar == null) {
            return null;
        }
        if (TextUtils.equals(jSONObject.optString("op"), "get")) {
            if (pVar.a != 1) {
                String optString = jSONObject.optString("alias");
                if (optString != null) {
                    pVar.e = optString;
                    return pVar;
                }
                return pVar;
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("tags");
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    return pVar;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
                if (arrayList.size() > 0) {
                    pVar.d.addAll(arrayList);
                    return pVar;
                }
                return pVar;
            } catch (Throwable th) {
                return pVar;
            }
        }
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(Context context, int i, long j) {
        boolean z;
        if (i == 1 || i == 2) {
            long j2 = cn.jiguang.api.i.getLong(context, "TAFreezeEndTime", -1L);
            if (j2 > 1800) {
                j2 = 0;
            }
            long j3 = cn.jiguang.api.i.getLong(context, "TAFreezeSetTime", -1L);
            if (j2 == -1 || j3 == -1) {
                z = false;
            } else if (System.currentTimeMillis() - j3 < 0 || System.currentTimeMillis() - j3 > j2) {
                cn.jiguang.api.i.e(context, "TAFreezeSetTime", -1L);
                cn.jiguang.api.i.e(context, "TAFreezeEndTime", -1L);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                n.a(context, i, cn.jpush.android.api.b.u, j);
                return true;
            }
        }
        return false;
    }

    private boolean a(Context context, p pVar) {
        cn.jpush.a.c a2;
        if (pVar == null) {
            return false;
        }
        if (pVar.a == 1) {
            a2 = n.a(context, pVar.d, pVar.c, pVar.b, pVar.g);
        } else if (pVar.a != 2) {
            return false;
        } else {
            a2 = n.a(context, pVar.e, pVar.c, pVar.a);
        }
        if (a2 != null) {
            if (pVar.h > 200) {
                this.c.remove(Long.valueOf(pVar.c));
                n.a(context, pVar.a, cn.jpush.android.api.b.o, pVar.c);
            } else {
                n.a(context, a2);
                pVar.h++;
                this.c.put(Long.valueOf(pVar.c), pVar);
            }
            return true;
        }
        return false;
    }

    public final int a(long j) {
        p remove = this.c.remove(Long.valueOf(j));
        if (remove != null) {
            return remove.a;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Intent a(Context context, long j, int i, JSONObject jSONObject, Intent intent) {
        boolean z;
        p pVar = this.c.get(Long.valueOf(j));
        this.c.remove(Long.valueOf(j));
        if (pVar == null) {
            return intent;
        }
        if (i == 1 && pVar.h == 0) {
            pVar.h++;
            if (a(context, pVar.a, pVar.c)) {
                z = true;
            } else if (a(context, pVar)) {
                z = true;
            }
            if (z) {
                if (i == 0) {
                    pVar.h = 0;
                    if (pVar.b == 5) {
                        pVar.f = jSONObject.optInt("total", -1);
                        pVar.g = jSONObject.optInt("curr", -1);
                        a(jSONObject, pVar);
                    }
                    if (pVar == null ? false : pVar.g < pVar.f) {
                        pVar.g++;
                        if (a(context, pVar.a, pVar.c) || a(context, pVar)) {
                            return null;
                        }
                    }
                    if (pVar.b != 5) {
                        if (pVar.b == 6 && pVar.a == 1) {
                            intent.putExtra("validated", jSONObject.optBoolean("validated", false));
                            return intent;
                        }
                        return intent;
                    } else if (pVar.a == 1) {
                        if (pVar.d.size() > 0) {
                            intent.putStringArrayListExtra("tags", pVar.d);
                            return intent;
                        }
                        return intent;
                    } else if (pVar.a != 2 || pVar.e == null) {
                        return intent;
                    } else {
                        intent.putExtra("alias", pVar.e);
                        return intent;
                    }
                }
                if (i == 100) {
                    long optLong = jSONObject.optLong("wait", -1L);
                    cn.jpush.android.d.f.c("TagAliasNewProtoRetryHelper", "set tag/alias action will freeze " + optLong + " seconds");
                    if (optLong > 0 && optLong >= 0) {
                        if (optLong > 1800) {
                            optLong = 1800;
                        }
                        cn.jiguang.api.i.e(context, "TAFreezeSetTime", System.currentTimeMillis());
                        cn.jiguang.api.i.e(context, "TAFreezeEndTime", optLong * 1000);
                    }
                }
                if (pVar.a != 0) {
                    switch (i) {
                        case 1:
                        case 2:
                            i = cn.jpush.android.api.b.o;
                            break;
                        case 3:
                            i = cn.jpush.android.api.b.p;
                            break;
                        case 4:
                            i = cn.jpush.android.api.b.q;
                            break;
                        case 5:
                            i = cn.jpush.android.api.b.r;
                            break;
                        case 6:
                            i = cn.jpush.android.api.b.s;
                            break;
                        case 7:
                        case 8:
                            i = cn.jpush.android.api.b.t;
                            break;
                        case 100:
                            i = cn.jpush.android.api.b.u;
                            break;
                    }
                }
                intent.putExtra("tagalias_errorcode", i);
                return intent;
            }
            return null;
        }
        z = false;
        if (z) {
        }
    }

    public final void a(int i, int i2, long j, ArrayList<String> arrayList, String str) {
        this.c.put(Long.valueOf(j), new p(this, i, i2, j, arrayList, str));
    }

    public final boolean a(int i) {
        if (this.c != null && !this.c.isEmpty()) {
            for (Map.Entry<Long, p> entry : this.c.entrySet()) {
                p value = entry.getValue();
                if (value != null && value.a == i) {
                    return false;
                }
            }
        }
        return true;
    }
}
