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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> bFW = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> bFU;
    private boolean bFV;

    static {
        bFW.put("setFillStyle", x.class);
        bFW.put("fillRect", m.class);
        bFW.put("setStrokeStyle", ag.class);
        bFW.put("strokeStyle", an.class);
        bFW.put("setLineCap", aa.class);
        bFW.put("setLineJoin", ac.class);
        bFW.put("setLineWidth", ad.class);
        bFW.put("setLineDash", ab.class);
        bFW.put("setMiterLimit", ae.class);
        bFW.put("strokeRect", am.class);
        bFW.put("moveTo", q.class);
        bFW.put("lineTo", p.class);
        bFW.put("stroke", al.class);
        bFW.put("fill", l.class);
        bFW.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        bFW.put("rect", s.class);
        bFW.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        bFW.put("closePath", h.class);
        bFW.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        bFW.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        bFW.put("quadraticCurveTo", r.class);
        bFW.put("scale", w.class);
        bFW.put(RotateImageAction.ACTION_NAME, u.class);
        bFW.put("translate", aq.class);
        bFW.put("transform", ap.class);
        bFW.put("setTransform", aj.class);
        bFW.put("font", o.class);
        bFW.put("setFontSize", y.class);
        bFW.put("setTextAlign", ah.class);
        bFW.put("setTextBaseline", ai.class);
        bFW.put("fillText", n.class);
        bFW.put("strokeText", ao.class);
        bFW.put("clip", g.class);
        bFW.put("drawImage", k.class);
        bFW.put("save", v.class);
        bFW.put("restore", t.class);
        bFW.put("setShadow", af.class);
        bFW.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.bFU = new ArrayList();
        this.bFV = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = bFW.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.bFU.add(newInstance);
                }
            }
            this.bFV = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Sk() {
        return this.bFU;
    }

    public boolean Sl() {
        return this.bFV;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
