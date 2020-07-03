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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> bTC = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> bTA;
    private boolean bTB;

    static {
        bTC.put("setFillStyle", x.class);
        bTC.put("fillRect", m.class);
        bTC.put("setStrokeStyle", ag.class);
        bTC.put("strokeStyle", an.class);
        bTC.put("setLineCap", aa.class);
        bTC.put("setLineJoin", ac.class);
        bTC.put("setLineWidth", ad.class);
        bTC.put("setLineDash", ab.class);
        bTC.put("setMiterLimit", ae.class);
        bTC.put("strokeRect", am.class);
        bTC.put("moveTo", q.class);
        bTC.put("lineTo", p.class);
        bTC.put("stroke", al.class);
        bTC.put("fill", l.class);
        bTC.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        bTC.put("rect", s.class);
        bTC.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        bTC.put("closePath", h.class);
        bTC.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        bTC.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        bTC.put("quadraticCurveTo", r.class);
        bTC.put("scale", w.class);
        bTC.put(RotateImageAction.ACTION_NAME, u.class);
        bTC.put("translate", aq.class);
        bTC.put("transform", ap.class);
        bTC.put("setTransform", aj.class);
        bTC.put("font", o.class);
        bTC.put("setFontSize", y.class);
        bTC.put("setTextAlign", ah.class);
        bTC.put("setTextBaseline", ai.class);
        bTC.put("fillText", n.class);
        bTC.put("strokeText", ao.class);
        bTC.put("clip", g.class);
        bTC.put("drawImage", k.class);
        bTC.put("save", v.class);
        bTC.put("restore", t.class);
        bTC.put("setShadow", af.class);
        bTC.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.bTA = new ArrayList();
        this.bTB = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = bTC.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.bTA.add(newInstance);
                }
            }
            this.bTB = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Wc() {
        return this.bTA;
    }

    public boolean Wd() {
        return this.bTB;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
