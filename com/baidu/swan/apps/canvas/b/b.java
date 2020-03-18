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
/* loaded from: classes11.dex */
public class b extends a {
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> bhG = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> bhE;
    private boolean bhF;

    static {
        bhG.put("setFillStyle", x.class);
        bhG.put("fillRect", m.class);
        bhG.put("setStrokeStyle", ag.class);
        bhG.put("strokeStyle", an.class);
        bhG.put("setLineCap", aa.class);
        bhG.put("setLineJoin", ac.class);
        bhG.put("setLineWidth", ad.class);
        bhG.put("setLineDash", ab.class);
        bhG.put("setMiterLimit", ae.class);
        bhG.put("strokeRect", am.class);
        bhG.put("moveTo", q.class);
        bhG.put("lineTo", p.class);
        bhG.put("stroke", al.class);
        bhG.put("fill", l.class);
        bhG.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        bhG.put("rect", s.class);
        bhG.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        bhG.put("closePath", h.class);
        bhG.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        bhG.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        bhG.put("quadraticCurveTo", r.class);
        bhG.put("scale", w.class);
        bhG.put(RotateImageAction.ACTION_NAME, u.class);
        bhG.put("translate", aq.class);
        bhG.put("transform", ap.class);
        bhG.put("setTransform", aj.class);
        bhG.put("font", o.class);
        bhG.put("setFontSize", y.class);
        bhG.put("setTextAlign", ah.class);
        bhG.put("setTextBaseline", ai.class);
        bhG.put("fillText", n.class);
        bhG.put("strokeText", ao.class);
        bhG.put("clip", g.class);
        bhG.put("drawImage", k.class);
        bhG.put("save", v.class);
        bhG.put("restore", t.class);
        bhG.put("setShadow", af.class);
        bhG.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.bhE = new ArrayList();
        this.bhF = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = bhG.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.bhE.add(newInstance);
                }
            }
            this.bhF = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Kx() {
        return this.bhE;
    }

    public boolean Ky() {
        return this.bhF;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
