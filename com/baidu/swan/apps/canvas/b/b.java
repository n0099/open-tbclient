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
/* loaded from: classes11.dex */
public class b extends a {
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> bhr = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> bhp;
    private boolean bhq;

    static {
        bhr.put("setFillStyle", x.class);
        bhr.put("fillRect", m.class);
        bhr.put("setStrokeStyle", ag.class);
        bhr.put("strokeStyle", an.class);
        bhr.put("setLineCap", aa.class);
        bhr.put("setLineJoin", ac.class);
        bhr.put("setLineWidth", ad.class);
        bhr.put("setLineDash", ab.class);
        bhr.put("setMiterLimit", ae.class);
        bhr.put("strokeRect", am.class);
        bhr.put("moveTo", q.class);
        bhr.put("lineTo", p.class);
        bhr.put("stroke", al.class);
        bhr.put("fill", l.class);
        bhr.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        bhr.put("rect", s.class);
        bhr.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        bhr.put("closePath", h.class);
        bhr.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        bhr.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        bhr.put("quadraticCurveTo", r.class);
        bhr.put("scale", w.class);
        bhr.put(RotateImageAction.ACTION_NAME, u.class);
        bhr.put("translate", aq.class);
        bhr.put("transform", ap.class);
        bhr.put("setTransform", aj.class);
        bhr.put("font", o.class);
        bhr.put("setFontSize", y.class);
        bhr.put("setTextAlign", ah.class);
        bhr.put("setTextBaseline", ai.class);
        bhr.put("fillText", n.class);
        bhr.put("strokeText", ao.class);
        bhr.put("clip", g.class);
        bhr.put("drawImage", k.class);
        bhr.put("save", v.class);
        bhr.put("restore", t.class);
        bhr.put("setShadow", af.class);
        bhr.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.bhp = new ArrayList();
        this.bhq = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = bhr.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.bhp.add(newInstance);
                }
            }
            this.bhq = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Ks() {
        return this.bhp;
    }

    public boolean Kt() {
        return this.bhq;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
