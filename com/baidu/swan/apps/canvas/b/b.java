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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> coy = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> cow;
    private boolean cox;

    static {
        coy.put("setFillStyle", x.class);
        coy.put("fillRect", m.class);
        coy.put("setStrokeStyle", ag.class);
        coy.put("strokeStyle", an.class);
        coy.put("setLineCap", aa.class);
        coy.put("setLineJoin", ac.class);
        coy.put("setLineWidth", ad.class);
        coy.put("setLineDash", ab.class);
        coy.put("setMiterLimit", ae.class);
        coy.put("strokeRect", am.class);
        coy.put("moveTo", q.class);
        coy.put("lineTo", p.class);
        coy.put("stroke", al.class);
        coy.put("fill", l.class);
        coy.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        coy.put("rect", s.class);
        coy.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        coy.put("closePath", h.class);
        coy.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        coy.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        coy.put("quadraticCurveTo", r.class);
        coy.put("scale", w.class);
        coy.put(RotateImageAction.ACTION_NAME, u.class);
        coy.put("translate", aq.class);
        coy.put("transform", ap.class);
        coy.put("setTransform", aj.class);
        coy.put("font", o.class);
        coy.put("setFontSize", y.class);
        coy.put("setTextAlign", ah.class);
        coy.put("setTextBaseline", ai.class);
        coy.put("fillText", n.class);
        coy.put("strokeText", ao.class);
        coy.put("clip", g.class);
        coy.put("drawImage", k.class);
        coy.put("save", v.class);
        coy.put("restore", t.class);
        coy.put("setShadow", af.class);
        coy.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.cow = new ArrayList();
        this.cox = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = coy.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.cow.add(newInstance);
                }
            }
            this.cox = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> agj() {
        return this.cow;
    }

    public boolean agk() {
        return this.cox;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
