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
/* loaded from: classes7.dex */
public class b extends a {
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> bUu = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> bUs;
    private boolean bUt;

    static {
        bUu.put("setFillStyle", x.class);
        bUu.put("fillRect", m.class);
        bUu.put("setStrokeStyle", ag.class);
        bUu.put("strokeStyle", an.class);
        bUu.put("setLineCap", aa.class);
        bUu.put("setLineJoin", ac.class);
        bUu.put("setLineWidth", ad.class);
        bUu.put("setLineDash", ab.class);
        bUu.put("setMiterLimit", ae.class);
        bUu.put("strokeRect", am.class);
        bUu.put("moveTo", q.class);
        bUu.put("lineTo", p.class);
        bUu.put("stroke", al.class);
        bUu.put("fill", l.class);
        bUu.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        bUu.put("rect", s.class);
        bUu.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        bUu.put("closePath", h.class);
        bUu.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        bUu.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        bUu.put("quadraticCurveTo", r.class);
        bUu.put("scale", w.class);
        bUu.put(RotateImageAction.ACTION_NAME, u.class);
        bUu.put("translate", aq.class);
        bUu.put("transform", ap.class);
        bUu.put("setTransform", aj.class);
        bUu.put("font", o.class);
        bUu.put("setFontSize", y.class);
        bUu.put("setTextAlign", ah.class);
        bUu.put("setTextBaseline", ai.class);
        bUu.put("fillText", n.class);
        bUu.put("strokeText", ao.class);
        bUu.put("clip", g.class);
        bUu.put("drawImage", k.class);
        bUu.put("save", v.class);
        bUu.put("restore", t.class);
        bUu.put("setShadow", af.class);
        bUu.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.bUs = new ArrayList();
        this.bUt = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = bUu.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.bUs.add(newInstance);
                }
            }
            this.bUt = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> WJ() {
        return this.bUs;
    }

    public boolean WK() {
        return this.bUt;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
