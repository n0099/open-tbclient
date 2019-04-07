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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> amt = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> amr;
    private boolean ams;

    static {
        amt.put("setFillStyle", x.class);
        amt.put("fillRect", m.class);
        amt.put("setStrokeStyle", ag.class);
        amt.put("strokeStyle", an.class);
        amt.put("setLineCap", aa.class);
        amt.put("setLineJoin", ac.class);
        amt.put("setLineWidth", ad.class);
        amt.put("setLineDash", ab.class);
        amt.put("setMiterLimit", ae.class);
        amt.put("strokeRect", am.class);
        amt.put("moveTo", q.class);
        amt.put("lineTo", p.class);
        amt.put("stroke", al.class);
        amt.put("fill", l.class);
        amt.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        amt.put("rect", s.class);
        amt.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        amt.put("closePath", h.class);
        amt.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        amt.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        amt.put("quadraticCurveTo", r.class);
        amt.put("scale", w.class);
        amt.put("rotate", u.class);
        amt.put("translate", aq.class);
        amt.put("transform", ap.class);
        amt.put("setTransform", aj.class);
        amt.put("font", o.class);
        amt.put("setFontSize", y.class);
        amt.put("setTextAlign", ah.class);
        amt.put("setTextBaseline", ai.class);
        amt.put("fillText", n.class);
        amt.put("strokeText", ao.class);
        amt.put("clip", com.baidu.swan.apps.canvas.a.a.g.class);
        amt.put("drawImage", k.class);
        amt.put("save", v.class);
        amt.put("restore", t.class);
        amt.put("setShadow", af.class);
        amt.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.amr = new ArrayList();
        this.ams = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = amt.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.g(optJSONArray);
                    this.amr.add(newInstance);
                }
            }
            this.ams = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> wB() {
        return this.amr;
    }

    public boolean wC() {
        return this.ams;
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
