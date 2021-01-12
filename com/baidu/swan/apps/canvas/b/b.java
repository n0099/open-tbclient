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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> cIk = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> cIi;
    private boolean cIj;

    static {
        cIk.put("setFillStyle", x.class);
        cIk.put("fillRect", m.class);
        cIk.put("setStrokeStyle", ag.class);
        cIk.put("strokeStyle", an.class);
        cIk.put("setLineCap", aa.class);
        cIk.put("setLineJoin", ac.class);
        cIk.put("setLineWidth", ad.class);
        cIk.put("setLineDash", ab.class);
        cIk.put("setMiterLimit", ae.class);
        cIk.put("strokeRect", am.class);
        cIk.put("moveTo", q.class);
        cIk.put("lineTo", p.class);
        cIk.put("stroke", al.class);
        cIk.put("fill", l.class);
        cIk.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        cIk.put("rect", s.class);
        cIk.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        cIk.put("closePath", h.class);
        cIk.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        cIk.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        cIk.put("quadraticCurveTo", r.class);
        cIk.put("scale", w.class);
        cIk.put(RotateImageAction.ACTION_NAME, u.class);
        cIk.put("translate", aq.class);
        cIk.put("transform", ap.class);
        cIk.put("setTransform", aj.class);
        cIk.put("font", o.class);
        cIk.put("setFontSize", y.class);
        cIk.put("setTextAlign", ah.class);
        cIk.put("setTextBaseline", ai.class);
        cIk.put("fillText", n.class);
        cIk.put("strokeText", ao.class);
        cIk.put("clip", g.class);
        cIk.put("drawImage", k.class);
        cIk.put("save", v.class);
        cIk.put("restore", t.class);
        cIk.put("setShadow", af.class);
        cIk.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.cIi = new ArrayList();
        this.cIj = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = cIk.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.cIi.add(newInstance);
                }
            }
            this.cIj = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> akt() {
        return this.cIi;
    }

    public boolean aku() {
        return this.cIj;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
