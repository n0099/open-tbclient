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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> cKA = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> cKy;
    private boolean cKz;

    static {
        cKA.put("setFillStyle", x.class);
        cKA.put("fillRect", m.class);
        cKA.put("setStrokeStyle", ag.class);
        cKA.put("strokeStyle", an.class);
        cKA.put("setLineCap", aa.class);
        cKA.put("setLineJoin", ac.class);
        cKA.put("setLineWidth", ad.class);
        cKA.put("setLineDash", ab.class);
        cKA.put("setMiterLimit", ae.class);
        cKA.put("strokeRect", am.class);
        cKA.put("moveTo", q.class);
        cKA.put("lineTo", p.class);
        cKA.put("stroke", al.class);
        cKA.put("fill", l.class);
        cKA.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        cKA.put("rect", s.class);
        cKA.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        cKA.put("closePath", h.class);
        cKA.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        cKA.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        cKA.put("quadraticCurveTo", r.class);
        cKA.put("scale", w.class);
        cKA.put(RotateImageAction.ACTION_NAME, u.class);
        cKA.put("translate", aq.class);
        cKA.put("transform", ap.class);
        cKA.put("setTransform", aj.class);
        cKA.put("font", o.class);
        cKA.put("setFontSize", y.class);
        cKA.put("setTextAlign", ah.class);
        cKA.put("setTextBaseline", ai.class);
        cKA.put("fillText", n.class);
        cKA.put("strokeText", ao.class);
        cKA.put("clip", g.class);
        cKA.put("drawImage", k.class);
        cKA.put("save", v.class);
        cKA.put("restore", t.class);
        cKA.put("setShadow", af.class);
        cKA.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.cKy = new ArrayList();
        this.cKz = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = cKA.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.cKy.add(newInstance);
                }
            }
            this.cKz = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> akR() {
        return this.cKy;
    }

    public boolean akS() {
        return this.cKz;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
