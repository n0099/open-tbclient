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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> amu = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> ams;
    private boolean amt;

    static {
        amu.put("setFillStyle", x.class);
        amu.put("fillRect", m.class);
        amu.put("setStrokeStyle", ag.class);
        amu.put("strokeStyle", an.class);
        amu.put("setLineCap", aa.class);
        amu.put("setLineJoin", ac.class);
        amu.put("setLineWidth", ad.class);
        amu.put("setLineDash", ab.class);
        amu.put("setMiterLimit", ae.class);
        amu.put("strokeRect", am.class);
        amu.put("moveTo", q.class);
        amu.put("lineTo", p.class);
        amu.put("stroke", al.class);
        amu.put("fill", l.class);
        amu.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        amu.put("rect", s.class);
        amu.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        amu.put("closePath", h.class);
        amu.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        amu.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        amu.put("quadraticCurveTo", r.class);
        amu.put("scale", w.class);
        amu.put("rotate", u.class);
        amu.put("translate", aq.class);
        amu.put("transform", ap.class);
        amu.put("setTransform", aj.class);
        amu.put("font", o.class);
        amu.put("setFontSize", y.class);
        amu.put("setTextAlign", ah.class);
        amu.put("setTextBaseline", ai.class);
        amu.put("fillText", n.class);
        amu.put("strokeText", ao.class);
        amu.put("clip", com.baidu.swan.apps.canvas.a.a.g.class);
        amu.put("drawImage", k.class);
        amu.put("save", v.class);
        amu.put("restore", t.class);
        amu.put("setShadow", af.class);
        amu.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.ams = new ArrayList();
        this.amt = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = amu.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.g(optJSONArray);
                    this.ams.add(newInstance);
                }
            }
            this.amt = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> wB() {
        return this.ams;
    }

    public boolean wC() {
        return this.amt;
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
