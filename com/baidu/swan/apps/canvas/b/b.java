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
/* loaded from: classes25.dex */
public class b extends a {
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> cIf = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> cId;
    private boolean cIe;

    static {
        cIf.put("setFillStyle", x.class);
        cIf.put("fillRect", m.class);
        cIf.put("setStrokeStyle", ag.class);
        cIf.put("strokeStyle", an.class);
        cIf.put("setLineCap", aa.class);
        cIf.put("setLineJoin", ac.class);
        cIf.put("setLineWidth", ad.class);
        cIf.put("setLineDash", ab.class);
        cIf.put("setMiterLimit", ae.class);
        cIf.put("strokeRect", am.class);
        cIf.put("moveTo", q.class);
        cIf.put("lineTo", p.class);
        cIf.put("stroke", al.class);
        cIf.put("fill", l.class);
        cIf.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        cIf.put("rect", s.class);
        cIf.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        cIf.put("closePath", h.class);
        cIf.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        cIf.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        cIf.put("quadraticCurveTo", r.class);
        cIf.put("scale", w.class);
        cIf.put(RotateImageAction.ACTION_NAME, u.class);
        cIf.put("translate", aq.class);
        cIf.put("transform", ap.class);
        cIf.put("setTransform", aj.class);
        cIf.put("font", o.class);
        cIf.put("setFontSize", y.class);
        cIf.put("setTextAlign", ah.class);
        cIf.put("setTextBaseline", ai.class);
        cIf.put("fillText", n.class);
        cIf.put("strokeText", ao.class);
        cIf.put("clip", g.class);
        cIf.put("drawImage", k.class);
        cIf.put("save", v.class);
        cIf.put("restore", t.class);
        cIf.put("setShadow", af.class);
        cIf.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.cId = new ArrayList();
        this.cIe = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = cIf.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.cId.add(newInstance);
                }
            }
            this.cIe = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> and() {
        return this.cId;
    }

    public boolean ane() {
        return this.cIe;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
