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
/* loaded from: classes3.dex */
public class b extends a {
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> cch = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> ccf;
    private boolean ccg;

    static {
        cch.put("setFillStyle", x.class);
        cch.put("fillRect", m.class);
        cch.put("setStrokeStyle", ag.class);
        cch.put("strokeStyle", an.class);
        cch.put("setLineCap", aa.class);
        cch.put("setLineJoin", ac.class);
        cch.put("setLineWidth", ad.class);
        cch.put("setLineDash", ab.class);
        cch.put("setMiterLimit", ae.class);
        cch.put("strokeRect", am.class);
        cch.put("moveTo", q.class);
        cch.put("lineTo", p.class);
        cch.put("stroke", al.class);
        cch.put("fill", l.class);
        cch.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        cch.put("rect", s.class);
        cch.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        cch.put("closePath", h.class);
        cch.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        cch.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        cch.put("quadraticCurveTo", r.class);
        cch.put("scale", w.class);
        cch.put(RotateImageAction.ACTION_NAME, u.class);
        cch.put("translate", aq.class);
        cch.put("transform", ap.class);
        cch.put("setTransform", aj.class);
        cch.put("font", o.class);
        cch.put("setFontSize", y.class);
        cch.put("setTextAlign", ah.class);
        cch.put("setTextBaseline", ai.class);
        cch.put("fillText", n.class);
        cch.put("strokeText", ao.class);
        cch.put("clip", g.class);
        cch.put("drawImage", k.class);
        cch.put("save", v.class);
        cch.put("restore", t.class);
        cch.put("setShadow", af.class);
        cch.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.ccf = new ArrayList();
        this.ccg = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = cch.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.ccf.add(newInstance);
                }
            }
            this.ccg = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> ady() {
        return this.ccf;
    }

    public boolean adz() {
        return this.ccg;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
