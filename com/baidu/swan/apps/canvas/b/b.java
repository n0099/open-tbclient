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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> bcn = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> bcl;
    private boolean bcm;

    static {
        bcn.put("setFillStyle", x.class);
        bcn.put("fillRect", m.class);
        bcn.put("setStrokeStyle", ag.class);
        bcn.put("strokeStyle", an.class);
        bcn.put("setLineCap", aa.class);
        bcn.put("setLineJoin", ac.class);
        bcn.put("setLineWidth", ad.class);
        bcn.put("setLineDash", ab.class);
        bcn.put("setMiterLimit", ae.class);
        bcn.put("strokeRect", am.class);
        bcn.put("moveTo", q.class);
        bcn.put("lineTo", p.class);
        bcn.put("stroke", al.class);
        bcn.put("fill", l.class);
        bcn.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        bcn.put("rect", s.class);
        bcn.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        bcn.put("closePath", h.class);
        bcn.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        bcn.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        bcn.put("quadraticCurveTo", r.class);
        bcn.put("scale", w.class);
        bcn.put(RotateImageAction.ACTION_NAME, u.class);
        bcn.put("translate", aq.class);
        bcn.put("transform", ap.class);
        bcn.put("setTransform", aj.class);
        bcn.put("font", o.class);
        bcn.put("setFontSize", y.class);
        bcn.put("setTextAlign", ah.class);
        bcn.put("setTextBaseline", ai.class);
        bcn.put("fillText", n.class);
        bcn.put("strokeText", ao.class);
        bcn.put("clip", g.class);
        bcn.put("drawImage", k.class);
        bcn.put("save", v.class);
        bcn.put("restore", t.class);
        bcn.put("setShadow", af.class);
        bcn.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.bcl = new ArrayList();
        this.bcm = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = bcn.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.bcl.add(newInstance);
                }
            }
            this.bcm = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> HH() {
        return this.bcl;
    }

    public boolean HI() {
        return this.bcm;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
