package com.baidu.swan.pms;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import com.baidu.swan.pms.c.d.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public static synchronized void a(com.baidu.swan.pms.c.d.c cVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (cVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (TextUtils.isEmpty(cVar.getBundleId())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "bundleId为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(cVar);
                    if (gVar.bcf() != null) {
                        a2.putAll(gVar.bcf());
                    }
                    gVar.ank();
                    d.bcc().axR().a(com.baidu.swan.pms.c.e.bcy(), a2, gVar.bcg(), new com.baidu.swan.pms.c.b.b(gVar, cVar));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.b bVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (bVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (bVar.bcX() == null || bVar.bcX().isEmpty()) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "pkg List为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(bVar);
                    if (gVar.bcf() != null) {
                        a2.putAll(gVar.bcf());
                    }
                    JSONObject b2 = com.baidu.swan.pms.c.b.b(bVar);
                    if (b2 == null) {
                        gVar.b(new com.baidu.swan.pms.model.a(2100, "构造请求body失败"));
                    } else {
                        if (gVar.bch() != null) {
                            try {
                                for (Map.Entry<String, String> entry : gVar.bch().entrySet()) {
                                    b2.put(entry.getKey(), entry.getValue());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gVar.ank();
                        d.bcc().axR().a(com.baidu.swan.pms.c.e.bcA(), a2, gVar.bcg(), b2, new com.baidu.swan.pms.c.b.a(gVar, bVar));
                    }
                }
            }
        }
    }

    public static synchronized void a(f fVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (fVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else if (TextUtils.isEmpty(fVar.getBundleId())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(fVar.bdf())) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(fVar);
                    if (gVar.bcf() != null) {
                        a2.putAll(gVar.bcf());
                    }
                    gVar.ank();
                    d.bcc().axR().a(com.baidu.swan.pms.c.e.bcy(), a2, gVar.bcg(), new com.baidu.swan.pms.c.b.d(gVar, fVar));
                }
            }
        }
    }

    public static synchronized void a(h hVar, g gVar) {
        synchronized (c.class) {
            a(hVar, gVar, null);
        }
    }

    public static synchronized void a(h hVar, g gVar, g gVar2) {
        synchronized (c.class) {
            a(hVar, gVar, gVar2, null);
        }
    }

    public static synchronized void a(h hVar, g gVar, g gVar2, @Nullable com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (hVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else {
                    com.baidu.swan.pms.node.c<JSONArray> atG = aVar == null ? null : aVar.atG();
                    g atF = aVar == null ? null : aVar.atF();
                    HashMap hashMap = new HashMap();
                    if (gVar.bcf() != null) {
                        hashMap.putAll(gVar.bcf());
                    }
                    gVar.ank();
                    d.bcc().axR().a(com.baidu.swan.pms.c.e.bcz(), hashMap, gVar.bcg(), a(atG, (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(gVar, hVar, gVar2, atF));
                }
            }
        }
    }

    public static synchronized void a(com.baidu.swan.pms.d.a.a aVar) {
        synchronized (c.class) {
            if (aVar != null) {
                g atF = aVar.atF();
                if (atF != null) {
                    com.baidu.swan.pms.c.d.g atH = aVar.atH();
                    if (atH == null) {
                        atF.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                    } else {
                        Map<String, String> bcf = atF.bcf();
                        Map<String, String> hashMap = atF.bcf() != null ? new HashMap<>(bcf) : bcf;
                        atF.ank();
                        d.bcc().axR().a(com.baidu.swan.pms.c.e.bcz(), hashMap, atF.bcg(), a(aVar.atG(), (com.baidu.swan.pms.node.c<JSONObject>) null), new com.baidu.swan.pms.c.b.e(atF, atH, null, atF));
                    }
                }
            }
        }
    }

    private static JSONObject a(@Nullable com.baidu.swan.pms.node.c<JSONArray> cVar, @Nullable com.baidu.swan.pms.node.c<JSONObject> cVar2) {
        return com.baidu.swan.pms.node.f.b(cVar, cVar2);
    }

    public static synchronized void a(com.baidu.swan.pms.c.d.d dVar, g gVar) {
        synchronized (c.class) {
            if (gVar != null) {
                if (dVar == null) {
                    gVar.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else {
                    HashMap<String, String> a2 = com.baidu.swan.pms.c.b.a(dVar);
                    if (gVar.bcf() != null) {
                        a2.putAll(gVar.bcf());
                    }
                    gVar.ank();
                    d.bcc().axR().a(com.baidu.swan.pms.c.e.bcB(), a2, gVar.bcg(), new com.baidu.swan.pms.c.b.c(gVar, dVar));
                }
            }
        }
    }

    public static synchronized boolean xz(String str) {
        boolean xz;
        synchronized (c.class) {
            xz = com.baidu.swan.pms.c.a.d.d.bcJ().xz(str);
        }
        return xz;
    }

    public static synchronized boolean xA(String str) {
        boolean xA;
        synchronized (c.class) {
            xA = com.baidu.swan.pms.c.a.d.d.bcJ().xA(str);
        }
        return xA;
    }
}
