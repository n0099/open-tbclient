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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> cMa = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> cLY;
    private boolean cLZ;

    static {
        cMa.put("setFillStyle", x.class);
        cMa.put("fillRect", m.class);
        cMa.put("setStrokeStyle", ag.class);
        cMa.put("strokeStyle", an.class);
        cMa.put("setLineCap", aa.class);
        cMa.put("setLineJoin", ac.class);
        cMa.put("setLineWidth", ad.class);
        cMa.put("setLineDash", ab.class);
        cMa.put("setMiterLimit", ae.class);
        cMa.put("strokeRect", am.class);
        cMa.put("moveTo", q.class);
        cMa.put("lineTo", p.class);
        cMa.put("stroke", al.class);
        cMa.put("fill", l.class);
        cMa.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        cMa.put("rect", s.class);
        cMa.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        cMa.put("closePath", h.class);
        cMa.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        cMa.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        cMa.put("quadraticCurveTo", r.class);
        cMa.put("scale", w.class);
        cMa.put(RotateImageAction.ACTION_NAME, u.class);
        cMa.put("translate", aq.class);
        cMa.put("transform", ap.class);
        cMa.put("setTransform", aj.class);
        cMa.put("font", o.class);
        cMa.put("setFontSize", y.class);
        cMa.put("setTextAlign", ah.class);
        cMa.put("setTextBaseline", ai.class);
        cMa.put("fillText", n.class);
        cMa.put("strokeText", ao.class);
        cMa.put("clip", g.class);
        cMa.put("drawImage", k.class);
        cMa.put("save", v.class);
        cMa.put("restore", t.class);
        cMa.put("setShadow", af.class);
        cMa.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.cLY = new ArrayList();
        this.cLZ = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = cMa.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.cLY.add(newInstance);
                }
            }
            this.cLZ = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> akU() {
        return this.cLY;
    }

    public boolean akV() {
        return this.cLZ;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
