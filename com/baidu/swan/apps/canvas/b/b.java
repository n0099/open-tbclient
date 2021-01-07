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
/* loaded from: classes9.dex */
public class b extends a {
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> cMW = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> cMU;
    private boolean cMV;

    static {
        cMW.put("setFillStyle", x.class);
        cMW.put("fillRect", m.class);
        cMW.put("setStrokeStyle", ag.class);
        cMW.put("strokeStyle", an.class);
        cMW.put("setLineCap", aa.class);
        cMW.put("setLineJoin", ac.class);
        cMW.put("setLineWidth", ad.class);
        cMW.put("setLineDash", ab.class);
        cMW.put("setMiterLimit", ae.class);
        cMW.put("strokeRect", am.class);
        cMW.put("moveTo", q.class);
        cMW.put("lineTo", p.class);
        cMW.put("stroke", al.class);
        cMW.put("fill", l.class);
        cMW.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        cMW.put("rect", s.class);
        cMW.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        cMW.put("closePath", h.class);
        cMW.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        cMW.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        cMW.put("quadraticCurveTo", r.class);
        cMW.put("scale", w.class);
        cMW.put(RotateImageAction.ACTION_NAME, u.class);
        cMW.put("translate", aq.class);
        cMW.put("transform", ap.class);
        cMW.put("setTransform", aj.class);
        cMW.put("font", o.class);
        cMW.put("setFontSize", y.class);
        cMW.put("setTextAlign", ah.class);
        cMW.put("setTextBaseline", ai.class);
        cMW.put("fillText", n.class);
        cMW.put("strokeText", ao.class);
        cMW.put("clip", g.class);
        cMW.put("drawImage", k.class);
        cMW.put("save", v.class);
        cMW.put("restore", t.class);
        cMW.put("setShadow", af.class);
        cMW.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.cMU = new ArrayList();
        this.cMV = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = cMW.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.cMU.add(newInstance);
                }
            }
            this.cMV = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> aon() {
        return this.cMU;
    }

    public boolean aoo() {
        return this.cMV;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
