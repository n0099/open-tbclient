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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> anH = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> anF;
    private boolean anG;

    static {
        anH.put("setFillStyle", x.class);
        anH.put("fillRect", m.class);
        anH.put("setStrokeStyle", ag.class);
        anH.put("strokeStyle", an.class);
        anH.put("setLineCap", aa.class);
        anH.put("setLineJoin", ac.class);
        anH.put("setLineWidth", ad.class);
        anH.put("setLineDash", ab.class);
        anH.put("setMiterLimit", ae.class);
        anH.put("strokeRect", am.class);
        anH.put("moveTo", q.class);
        anH.put("lineTo", p.class);
        anH.put("stroke", al.class);
        anH.put("fill", l.class);
        anH.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        anH.put("rect", s.class);
        anH.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        anH.put("closePath", h.class);
        anH.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        anH.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        anH.put("quadraticCurveTo", r.class);
        anH.put("scale", w.class);
        anH.put("rotate", u.class);
        anH.put("translate", aq.class);
        anH.put("transform", ap.class);
        anH.put("setTransform", aj.class);
        anH.put("font", o.class);
        anH.put("setFontSize", y.class);
        anH.put("setTextAlign", ah.class);
        anH.put("setTextBaseline", ai.class);
        anH.put("fillText", n.class);
        anH.put("strokeText", ao.class);
        anH.put("clip", com.baidu.swan.apps.canvas.a.a.g.class);
        anH.put("drawImage", k.class);
        anH.put("save", v.class);
        anH.put("restore", t.class);
        anH.put("setShadow", af.class);
        anH.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.anF = new ArrayList();
        this.anG = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = anH.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.e(optJSONArray);
                    this.anF.add(newInstance);
                }
            }
            this.anG = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> yb() {
        return this.anF;
    }

    public boolean yc() {
        return this.anG;
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
