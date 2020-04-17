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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> bFR = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> bFP;
    private boolean bFQ;

    static {
        bFR.put("setFillStyle", x.class);
        bFR.put("fillRect", m.class);
        bFR.put("setStrokeStyle", ag.class);
        bFR.put("strokeStyle", an.class);
        bFR.put("setLineCap", aa.class);
        bFR.put("setLineJoin", ac.class);
        bFR.put("setLineWidth", ad.class);
        bFR.put("setLineDash", ab.class);
        bFR.put("setMiterLimit", ae.class);
        bFR.put("strokeRect", am.class);
        bFR.put("moveTo", q.class);
        bFR.put("lineTo", p.class);
        bFR.put("stroke", al.class);
        bFR.put("fill", l.class);
        bFR.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        bFR.put("rect", s.class);
        bFR.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        bFR.put("closePath", h.class);
        bFR.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        bFR.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        bFR.put("quadraticCurveTo", r.class);
        bFR.put("scale", w.class);
        bFR.put(RotateImageAction.ACTION_NAME, u.class);
        bFR.put("translate", aq.class);
        bFR.put("transform", ap.class);
        bFR.put("setTransform", aj.class);
        bFR.put("font", o.class);
        bFR.put("setFontSize", y.class);
        bFR.put("setTextAlign", ah.class);
        bFR.put("setTextBaseline", ai.class);
        bFR.put("fillText", n.class);
        bFR.put("strokeText", ao.class);
        bFR.put("clip", g.class);
        bFR.put("drawImage", k.class);
        bFR.put("save", v.class);
        bFR.put("restore", t.class);
        bFR.put("setShadow", af.class);
        bFR.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.bFP = new ArrayList();
        this.bFQ = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = bFR.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.bFP.add(newInstance);
                }
            }
            this.bFQ = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Sl() {
        return this.bFP;
    }

    public boolean Sm() {
        return this.bFQ;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
