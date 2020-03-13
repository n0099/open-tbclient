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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> bht = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> bhr;
    private boolean bhs;

    static {
        bht.put("setFillStyle", x.class);
        bht.put("fillRect", m.class);
        bht.put("setStrokeStyle", ag.class);
        bht.put("strokeStyle", an.class);
        bht.put("setLineCap", aa.class);
        bht.put("setLineJoin", ac.class);
        bht.put("setLineWidth", ad.class);
        bht.put("setLineDash", ab.class);
        bht.put("setMiterLimit", ae.class);
        bht.put("strokeRect", am.class);
        bht.put("moveTo", q.class);
        bht.put("lineTo", p.class);
        bht.put("stroke", al.class);
        bht.put("fill", l.class);
        bht.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        bht.put("rect", s.class);
        bht.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        bht.put("closePath", h.class);
        bht.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        bht.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        bht.put("quadraticCurveTo", r.class);
        bht.put("scale", w.class);
        bht.put(RotateImageAction.ACTION_NAME, u.class);
        bht.put("translate", aq.class);
        bht.put("transform", ap.class);
        bht.put("setTransform", aj.class);
        bht.put("font", o.class);
        bht.put("setFontSize", y.class);
        bht.put("setTextAlign", ah.class);
        bht.put("setTextBaseline", ai.class);
        bht.put("fillText", n.class);
        bht.put("strokeText", ao.class);
        bht.put("clip", g.class);
        bht.put("drawImage", k.class);
        bht.put("save", v.class);
        bht.put("restore", t.class);
        bht.put("setShadow", af.class);
        bht.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.bhr = new ArrayList();
        this.bhs = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = bht.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.bhr.add(newInstance);
                }
            }
            this.bhs = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Ku() {
        return this.bhr;
    }

    public boolean Kv() {
        return this.bhs;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
