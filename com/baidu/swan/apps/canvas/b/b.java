package com.baidu.swan.apps.canvas.b;

import com.baidu.live.tbadk.img.effect.RotateImageAction;
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
import com.baidu.swan.apps.canvas.a.a.g;
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
/* loaded from: classes8.dex */
public class b extends a {
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> cac = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> caa;
    private boolean cab;

    static {
        cac.put("setFillStyle", x.class);
        cac.put("fillRect", m.class);
        cac.put("setStrokeStyle", ag.class);
        cac.put("strokeStyle", an.class);
        cac.put("setLineCap", aa.class);
        cac.put("setLineJoin", ac.class);
        cac.put("setLineWidth", ad.class);
        cac.put("setLineDash", ab.class);
        cac.put("setMiterLimit", ae.class);
        cac.put("strokeRect", am.class);
        cac.put("moveTo", q.class);
        cac.put("lineTo", p.class);
        cac.put("stroke", al.class);
        cac.put("fill", l.class);
        cac.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        cac.put("rect", s.class);
        cac.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        cac.put("closePath", h.class);
        cac.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        cac.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        cac.put("quadraticCurveTo", r.class);
        cac.put("scale", w.class);
        cac.put(RotateImageAction.ACTION_NAME, u.class);
        cac.put("translate", aq.class);
        cac.put("transform", ap.class);
        cac.put("setTransform", aj.class);
        cac.put("font", o.class);
        cac.put("setFontSize", y.class);
        cac.put("setTextAlign", ah.class);
        cac.put("setTextBaseline", ai.class);
        cac.put("fillText", n.class);
        cac.put("strokeText", ao.class);
        cac.put("clip", g.class);
        cac.put("drawImage", k.class);
        cac.put("save", v.class);
        cac.put("restore", t.class);
        cac.put("setShadow", af.class);
        cac.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.caa = new ArrayList();
        this.cab = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = cac.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.caa.add(newInstance);
                }
            }
            this.cab = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> acP() {
        return this.caa;
    }

    public boolean acQ() {
        return this.cab;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
