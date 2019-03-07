package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.canvas.a.a.aa;
import com.baidu.swan.apps.canvas.a.a.ab;
import com.baidu.swan.apps.canvas.a.a.ac;
import com.baidu.swan.apps.canvas.a.a.ad;
import com.baidu.swan.apps.canvas.a.a.ae;
import com.baidu.swan.apps.canvas.a.a.af;
import com.baidu.swan.apps.canvas.a.a.ag;
import com.baidu.swan.apps.canvas.a.a.ah;
import com.baidu.swan.apps.canvas.a.a.ai;
import com.baidu.swan.apps.canvas.a.a.aj;
import com.baidu.swan.apps.canvas.a.a.al;
import com.baidu.swan.apps.canvas.a.a.am;
import com.baidu.swan.apps.canvas.a.a.an;
import com.baidu.swan.apps.canvas.a.a.ao;
import com.baidu.swan.apps.canvas.a.a.ap;
import com.baidu.swan.apps.canvas.a.a.aq;
import com.baidu.swan.apps.canvas.a.a.h;
import com.baidu.swan.apps.canvas.a.a.k;
import com.baidu.swan.apps.canvas.a.a.l;
import com.baidu.swan.apps.canvas.a.a.m;
import com.baidu.swan.apps.canvas.a.a.n;
import com.baidu.swan.apps.canvas.a.a.o;
import com.baidu.swan.apps.canvas.a.a.p;
import com.baidu.swan.apps.canvas.a.a.q;
import com.baidu.swan.apps.canvas.a.a.r;
import com.baidu.swan.apps.canvas.a.a.s;
import com.baidu.swan.apps.canvas.a.a.t;
import com.baidu.swan.apps.canvas.a.a.u;
import com.baidu.swan.apps.canvas.a.a.v;
import com.baidu.swan.apps.canvas.a.a.w;
import com.baidu.swan.apps.canvas.a.a.x;
import com.baidu.swan.apps.canvas.a.a.y;
import com.baidu.swan.apps.canvas.a.a.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends a {
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> amo = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> amm;
    private boolean amn;

    static {
        amo.put("setFillStyle", x.class);
        amo.put("fillRect", m.class);
        amo.put("setStrokeStyle", ag.class);
        amo.put("strokeStyle", an.class);
        amo.put("setLineCap", aa.class);
        amo.put("setLineJoin", ac.class);
        amo.put("setLineWidth", ad.class);
        amo.put("setLineDash", ab.class);
        amo.put("setMiterLimit", ae.class);
        amo.put("strokeRect", am.class);
        amo.put("moveTo", q.class);
        amo.put("lineTo", p.class);
        amo.put("stroke", al.class);
        amo.put("fill", l.class);
        amo.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        amo.put("rect", s.class);
        amo.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        amo.put("closePath", h.class);
        amo.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        amo.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        amo.put("quadraticCurveTo", r.class);
        amo.put("scale", w.class);
        amo.put("rotate", u.class);
        amo.put("translate", aq.class);
        amo.put("transform", ap.class);
        amo.put("setTransform", aj.class);
        amo.put("font", o.class);
        amo.put("setFontSize", y.class);
        amo.put("setTextAlign", ah.class);
        amo.put("setTextBaseline", ai.class);
        amo.put("fillText", n.class);
        amo.put("strokeText", ao.class);
        amo.put("clip", com.baidu.swan.apps.canvas.a.a.g.class);
        amo.put("drawImage", k.class);
        amo.put("save", v.class);
        amo.put("restore", t.class);
        amo.put("setShadow", af.class);
        amo.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.amm = new ArrayList();
        this.amn = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = amo.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.g(optJSONArray);
                    this.amm.add(newInstance);
                }
            }
            this.amn = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.c.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> wC() {
        return this.amm;
    }

    public boolean wD() {
        return this.amn;
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
