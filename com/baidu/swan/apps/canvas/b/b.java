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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> bdc = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> bda;
    private boolean bdb;

    static {
        bdc.put("setFillStyle", x.class);
        bdc.put("fillRect", m.class);
        bdc.put("setStrokeStyle", ag.class);
        bdc.put("strokeStyle", an.class);
        bdc.put("setLineCap", aa.class);
        bdc.put("setLineJoin", ac.class);
        bdc.put("setLineWidth", ad.class);
        bdc.put("setLineDash", ab.class);
        bdc.put("setMiterLimit", ae.class);
        bdc.put("strokeRect", am.class);
        bdc.put("moveTo", q.class);
        bdc.put("lineTo", p.class);
        bdc.put("stroke", al.class);
        bdc.put("fill", l.class);
        bdc.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        bdc.put("rect", s.class);
        bdc.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        bdc.put("closePath", h.class);
        bdc.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        bdc.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        bdc.put("quadraticCurveTo", r.class);
        bdc.put("scale", w.class);
        bdc.put(RotateImageAction.ACTION_NAME, u.class);
        bdc.put("translate", aq.class);
        bdc.put("transform", ap.class);
        bdc.put("setTransform", aj.class);
        bdc.put("font", o.class);
        bdc.put("setFontSize", y.class);
        bdc.put("setTextAlign", ah.class);
        bdc.put("setTextBaseline", ai.class);
        bdc.put("fillText", n.class);
        bdc.put("strokeText", ao.class);
        bdc.put("clip", g.class);
        bdc.put("drawImage", k.class);
        bdc.put("save", v.class);
        bdc.put("restore", t.class);
        bdc.put("setShadow", af.class);
        bdc.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.bda = new ArrayList();
        this.bdb = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = bdc.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.bda.add(newInstance);
                }
            }
            this.bdb = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Id() {
        return this.bda;
    }

    public boolean Ie() {
        return this.bdb;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
