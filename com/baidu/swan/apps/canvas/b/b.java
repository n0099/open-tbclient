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
/* loaded from: classes10.dex */
public class b extends a {
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> cxa = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> cwY;
    private boolean cwZ;

    static {
        cxa.put("setFillStyle", x.class);
        cxa.put("fillRect", m.class);
        cxa.put("setStrokeStyle", ag.class);
        cxa.put("strokeStyle", an.class);
        cxa.put("setLineCap", aa.class);
        cxa.put("setLineJoin", ac.class);
        cxa.put("setLineWidth", ad.class);
        cxa.put("setLineDash", ab.class);
        cxa.put("setMiterLimit", ae.class);
        cxa.put("strokeRect", am.class);
        cxa.put("moveTo", q.class);
        cxa.put("lineTo", p.class);
        cxa.put("stroke", al.class);
        cxa.put("fill", l.class);
        cxa.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        cxa.put("rect", s.class);
        cxa.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        cxa.put("closePath", h.class);
        cxa.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        cxa.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        cxa.put("quadraticCurveTo", r.class);
        cxa.put("scale", w.class);
        cxa.put(RotateImageAction.ACTION_NAME, u.class);
        cxa.put("translate", aq.class);
        cxa.put("transform", ap.class);
        cxa.put("setTransform", aj.class);
        cxa.put("font", o.class);
        cxa.put("setFontSize", y.class);
        cxa.put("setTextAlign", ah.class);
        cxa.put("setTextBaseline", ai.class);
        cxa.put("fillText", n.class);
        cxa.put("strokeText", ao.class);
        cxa.put("clip", g.class);
        cxa.put("drawImage", k.class);
        cxa.put("save", v.class);
        cxa.put("restore", t.class);
        cxa.put("setShadow", af.class);
        cxa.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.cwY = new ArrayList();
        this.cwZ = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = cxa.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.cwY.add(newInstance);
                }
            }
            this.cwZ = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> aid() {
        return this.cwY;
    }

    public boolean aie() {
        return this.cwZ;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
