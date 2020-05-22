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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> bOO = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> bOM;
    private boolean bON;

    static {
        bOO.put("setFillStyle", x.class);
        bOO.put("fillRect", m.class);
        bOO.put("setStrokeStyle", ag.class);
        bOO.put("strokeStyle", an.class);
        bOO.put("setLineCap", aa.class);
        bOO.put("setLineJoin", ac.class);
        bOO.put("setLineWidth", ad.class);
        bOO.put("setLineDash", ab.class);
        bOO.put("setMiterLimit", ae.class);
        bOO.put("strokeRect", am.class);
        bOO.put("moveTo", q.class);
        bOO.put("lineTo", p.class);
        bOO.put("stroke", al.class);
        bOO.put("fill", l.class);
        bOO.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        bOO.put("rect", s.class);
        bOO.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        bOO.put("closePath", h.class);
        bOO.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        bOO.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        bOO.put("quadraticCurveTo", r.class);
        bOO.put("scale", w.class);
        bOO.put(RotateImageAction.ACTION_NAME, u.class);
        bOO.put("translate", aq.class);
        bOO.put("transform", ap.class);
        bOO.put("setTransform", aj.class);
        bOO.put("font", o.class);
        bOO.put("setFontSize", y.class);
        bOO.put("setTextAlign", ah.class);
        bOO.put("setTextBaseline", ai.class);
        bOO.put("fillText", n.class);
        bOO.put("strokeText", ao.class);
        bOO.put("clip", g.class);
        bOO.put("drawImage", k.class);
        bOO.put("save", v.class);
        bOO.put("restore", t.class);
        bOO.put("setShadow", af.class);
        bOO.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.bOM = new ArrayList();
        this.bON = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = bOO.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.bOM.add(newInstance);
                }
            }
            this.bON = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> UW() {
        return this.bOM;
    }

    public boolean UX() {
        return this.bON;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
