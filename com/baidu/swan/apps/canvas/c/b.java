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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> aGY = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> aGW;
    private boolean aGX;

    static {
        aGY.put("setFillStyle", x.class);
        aGY.put("fillRect", m.class);
        aGY.put("setStrokeStyle", ag.class);
        aGY.put("strokeStyle", an.class);
        aGY.put("setLineCap", aa.class);
        aGY.put("setLineJoin", ac.class);
        aGY.put("setLineWidth", ad.class);
        aGY.put("setLineDash", ab.class);
        aGY.put("setMiterLimit", ae.class);
        aGY.put("strokeRect", am.class);
        aGY.put("moveTo", q.class);
        aGY.put("lineTo", p.class);
        aGY.put("stroke", al.class);
        aGY.put("fill", l.class);
        aGY.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        aGY.put("rect", s.class);
        aGY.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        aGY.put("closePath", h.class);
        aGY.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        aGY.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        aGY.put("quadraticCurveTo", r.class);
        aGY.put("scale", w.class);
        aGY.put(RotateImageAction.ACTION_NAME, u.class);
        aGY.put("translate", aq.class);
        aGY.put("transform", ap.class);
        aGY.put("setTransform", aj.class);
        aGY.put("font", o.class);
        aGY.put("setFontSize", y.class);
        aGY.put("setTextAlign", ah.class);
        aGY.put("setTextBaseline", ai.class);
        aGY.put("fillText", n.class);
        aGY.put("strokeText", ao.class);
        aGY.put("clip", com.baidu.swan.apps.canvas.a.a.g.class);
        aGY.put("drawImage", k.class);
        aGY.put("save", v.class);
        aGY.put("restore", t.class);
        aGY.put("setShadow", af.class);
        aGY.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.aGW = new ArrayList();
        this.aGX = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = aGY.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.aGW.add(newInstance);
                }
            }
            this.aGX = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> CW() {
        return this.aGW;
    }

    public boolean CX() {
        return this.aGX;
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
