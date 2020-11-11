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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> cCT = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> cCR;
    private boolean cCS;

    static {
        cCT.put("setFillStyle", x.class);
        cCT.put("fillRect", m.class);
        cCT.put("setStrokeStyle", ag.class);
        cCT.put("strokeStyle", an.class);
        cCT.put("setLineCap", aa.class);
        cCT.put("setLineJoin", ac.class);
        cCT.put("setLineWidth", ad.class);
        cCT.put("setLineDash", ab.class);
        cCT.put("setMiterLimit", ae.class);
        cCT.put("strokeRect", am.class);
        cCT.put("moveTo", q.class);
        cCT.put("lineTo", p.class);
        cCT.put("stroke", al.class);
        cCT.put("fill", l.class);
        cCT.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        cCT.put("rect", s.class);
        cCT.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        cCT.put("closePath", h.class);
        cCT.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        cCT.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        cCT.put("quadraticCurveTo", r.class);
        cCT.put("scale", w.class);
        cCT.put(RotateImageAction.ACTION_NAME, u.class);
        cCT.put("translate", aq.class);
        cCT.put("transform", ap.class);
        cCT.put("setTransform", aj.class);
        cCT.put("font", o.class);
        cCT.put("setFontSize", y.class);
        cCT.put("setTextAlign", ah.class);
        cCT.put("setTextBaseline", ai.class);
        cCT.put("fillText", n.class);
        cCT.put("strokeText", ao.class);
        cCT.put("clip", g.class);
        cCT.put("drawImage", k.class);
        cCT.put("save", v.class);
        cCT.put("restore", t.class);
        cCT.put("setShadow", af.class);
        cCT.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.cCR = new ArrayList();
        this.cCS = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = cCT.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.cCR.add(newInstance);
                }
            }
            this.cCS = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> akD() {
        return this.cCR;
    }

    public boolean akE() {
        return this.cCS;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
