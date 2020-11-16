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
/* loaded from: classes7.dex */
public class b extends a {
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> cBj = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> cBh;
    private boolean cBi;

    static {
        cBj.put("setFillStyle", x.class);
        cBj.put("fillRect", m.class);
        cBj.put("setStrokeStyle", ag.class);
        cBj.put("strokeStyle", an.class);
        cBj.put("setLineCap", aa.class);
        cBj.put("setLineJoin", ac.class);
        cBj.put("setLineWidth", ad.class);
        cBj.put("setLineDash", ab.class);
        cBj.put("setMiterLimit", ae.class);
        cBj.put("strokeRect", am.class);
        cBj.put("moveTo", q.class);
        cBj.put("lineTo", p.class);
        cBj.put("stroke", al.class);
        cBj.put("fill", l.class);
        cBj.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        cBj.put("rect", s.class);
        cBj.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        cBj.put("closePath", h.class);
        cBj.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        cBj.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        cBj.put("quadraticCurveTo", r.class);
        cBj.put("scale", w.class);
        cBj.put(RotateImageAction.ACTION_NAME, u.class);
        cBj.put("translate", aq.class);
        cBj.put("transform", ap.class);
        cBj.put("setTransform", aj.class);
        cBj.put("font", o.class);
        cBj.put("setFontSize", y.class);
        cBj.put("setTextAlign", ah.class);
        cBj.put("setTextBaseline", ai.class);
        cBj.put("fillText", n.class);
        cBj.put("strokeText", ao.class);
        cBj.put("clip", g.class);
        cBj.put("drawImage", k.class);
        cBj.put("save", v.class);
        cBj.put("restore", t.class);
        cBj.put("setShadow", af.class);
        cBj.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.cBh = new ArrayList();
        this.cBi = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = cBj.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.cBh.add(newInstance);
                }
            }
            this.cBi = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> ajV() {
        return this.cBh;
    }

    public boolean ajW() {
        return this.cBi;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
