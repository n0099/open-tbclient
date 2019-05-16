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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> amG = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> amE;
    private boolean amF;

    static {
        amG.put("setFillStyle", x.class);
        amG.put("fillRect", m.class);
        amG.put("setStrokeStyle", ag.class);
        amG.put("strokeStyle", an.class);
        amG.put("setLineCap", aa.class);
        amG.put("setLineJoin", ac.class);
        amG.put("setLineWidth", ad.class);
        amG.put("setLineDash", ab.class);
        amG.put("setMiterLimit", ae.class);
        amG.put("strokeRect", am.class);
        amG.put("moveTo", q.class);
        amG.put("lineTo", p.class);
        amG.put("stroke", al.class);
        amG.put("fill", l.class);
        amG.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        amG.put("rect", s.class);
        amG.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        amG.put("closePath", h.class);
        amG.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        amG.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        amG.put("quadraticCurveTo", r.class);
        amG.put("scale", w.class);
        amG.put("rotate", u.class);
        amG.put("translate", aq.class);
        amG.put("transform", ap.class);
        amG.put("setTransform", aj.class);
        amG.put("font", o.class);
        amG.put("setFontSize", y.class);
        amG.put("setTextAlign", ah.class);
        amG.put("setTextBaseline", ai.class);
        amG.put("fillText", n.class);
        amG.put("strokeText", ao.class);
        amG.put("clip", com.baidu.swan.apps.canvas.a.a.g.class);
        amG.put("drawImage", k.class);
        amG.put("save", v.class);
        amG.put("restore", t.class);
        amG.put("setShadow", af.class);
        amG.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.amE = new ArrayList();
        this.amF = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = amG.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.e(optJSONArray);
                    this.amE.add(newInstance);
                }
            }
            this.amF = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> xt() {
        return this.amE;
    }

    public boolean xu() {
        return this.amF;
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
