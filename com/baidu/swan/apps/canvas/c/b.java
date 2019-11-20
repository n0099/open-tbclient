package com.baidu.swan.apps.canvas.c;

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
/* loaded from: classes2.dex */
public class b extends a {
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> aGG = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> aGE;
    private boolean aGF;

    static {
        aGG.put("setFillStyle", x.class);
        aGG.put("fillRect", m.class);
        aGG.put("setStrokeStyle", ag.class);
        aGG.put("strokeStyle", an.class);
        aGG.put("setLineCap", aa.class);
        aGG.put("setLineJoin", ac.class);
        aGG.put("setLineWidth", ad.class);
        aGG.put("setLineDash", ab.class);
        aGG.put("setMiterLimit", ae.class);
        aGG.put("strokeRect", am.class);
        aGG.put("moveTo", q.class);
        aGG.put("lineTo", p.class);
        aGG.put("stroke", al.class);
        aGG.put("fill", l.class);
        aGG.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        aGG.put("rect", s.class);
        aGG.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        aGG.put("closePath", h.class);
        aGG.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        aGG.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        aGG.put("quadraticCurveTo", r.class);
        aGG.put("scale", w.class);
        aGG.put(RotateImageAction.ACTION_NAME, u.class);
        aGG.put("translate", aq.class);
        aGG.put("transform", ap.class);
        aGG.put("setTransform", aj.class);
        aGG.put("font", o.class);
        aGG.put("setFontSize", y.class);
        aGG.put("setTextAlign", ah.class);
        aGG.put("setTextBaseline", ai.class);
        aGG.put("fillText", n.class);
        aGG.put("strokeText", ao.class);
        aGG.put("clip", com.baidu.swan.apps.canvas.a.a.g.class);
        aGG.put("drawImage", k.class);
        aGG.put("save", v.class);
        aGG.put("restore", t.class);
        aGG.put("setShadow", af.class);
        aGG.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.aGE = new ArrayList();
        this.aGF = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = aGG.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.aGE.add(newInstance);
                }
            }
            this.aGF = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> CX() {
        return this.aGE;
    }

    public boolean CY() {
        return this.aGF;
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
