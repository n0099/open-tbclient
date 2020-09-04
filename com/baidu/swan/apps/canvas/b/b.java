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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> cag = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> cae;
    private boolean caf;

    static {
        cag.put("setFillStyle", x.class);
        cag.put("fillRect", m.class);
        cag.put("setStrokeStyle", ag.class);
        cag.put("strokeStyle", an.class);
        cag.put("setLineCap", aa.class);
        cag.put("setLineJoin", ac.class);
        cag.put("setLineWidth", ad.class);
        cag.put("setLineDash", ab.class);
        cag.put("setMiterLimit", ae.class);
        cag.put("strokeRect", am.class);
        cag.put("moveTo", q.class);
        cag.put("lineTo", p.class);
        cag.put("stroke", al.class);
        cag.put("fill", l.class);
        cag.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        cag.put("rect", s.class);
        cag.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        cag.put("closePath", h.class);
        cag.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        cag.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        cag.put("quadraticCurveTo", r.class);
        cag.put("scale", w.class);
        cag.put(RotateImageAction.ACTION_NAME, u.class);
        cag.put("translate", aq.class);
        cag.put("transform", ap.class);
        cag.put("setTransform", aj.class);
        cag.put("font", o.class);
        cag.put("setFontSize", y.class);
        cag.put("setTextAlign", ah.class);
        cag.put("setTextBaseline", ai.class);
        cag.put("fillText", n.class);
        cag.put("strokeText", ao.class);
        cag.put("clip", g.class);
        cag.put("drawImage", k.class);
        cag.put("save", v.class);
        cag.put("restore", t.class);
        cag.put("setShadow", af.class);
        cag.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.cae = new ArrayList();
        this.caf = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = cag.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.cae.add(newInstance);
                }
            }
            this.caf = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> acP() {
        return this.cae;
    }

    public boolean acQ() {
        return this.caf;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
