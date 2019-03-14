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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> amp = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> amn;
    private boolean amo;

    static {
        amp.put("setFillStyle", x.class);
        amp.put("fillRect", m.class);
        amp.put("setStrokeStyle", ag.class);
        amp.put("strokeStyle", an.class);
        amp.put("setLineCap", aa.class);
        amp.put("setLineJoin", ac.class);
        amp.put("setLineWidth", ad.class);
        amp.put("setLineDash", ab.class);
        amp.put("setMiterLimit", ae.class);
        amp.put("strokeRect", am.class);
        amp.put("moveTo", q.class);
        amp.put("lineTo", p.class);
        amp.put("stroke", al.class);
        amp.put("fill", l.class);
        amp.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        amp.put("rect", s.class);
        amp.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        amp.put("closePath", h.class);
        amp.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        amp.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        amp.put("quadraticCurveTo", r.class);
        amp.put("scale", w.class);
        amp.put("rotate", u.class);
        amp.put("translate", aq.class);
        amp.put("transform", ap.class);
        amp.put("setTransform", aj.class);
        amp.put("font", o.class);
        amp.put("setFontSize", y.class);
        amp.put("setTextAlign", ah.class);
        amp.put("setTextBaseline", ai.class);
        amp.put("fillText", n.class);
        amp.put("strokeText", ao.class);
        amp.put("clip", com.baidu.swan.apps.canvas.a.a.g.class);
        amp.put("drawImage", k.class);
        amp.put("save", v.class);
        amp.put("restore", t.class);
        amp.put("setShadow", af.class);
        amp.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.amn = new ArrayList();
        this.amo = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = amp.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.g(optJSONArray);
                    this.amn.add(newInstance);
                }
            }
            this.amo = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> wC() {
        return this.amn;
    }

    public boolean wD() {
        return this.amo;
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
