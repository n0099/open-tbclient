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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> bhs = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> bhq;
    private boolean bhr;

    static {
        bhs.put("setFillStyle", x.class);
        bhs.put("fillRect", m.class);
        bhs.put("setStrokeStyle", ag.class);
        bhs.put("strokeStyle", an.class);
        bhs.put("setLineCap", aa.class);
        bhs.put("setLineJoin", ac.class);
        bhs.put("setLineWidth", ad.class);
        bhs.put("setLineDash", ab.class);
        bhs.put("setMiterLimit", ae.class);
        bhs.put("strokeRect", am.class);
        bhs.put("moveTo", q.class);
        bhs.put("lineTo", p.class);
        bhs.put("stroke", al.class);
        bhs.put("fill", l.class);
        bhs.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        bhs.put("rect", s.class);
        bhs.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        bhs.put("closePath", h.class);
        bhs.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        bhs.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        bhs.put("quadraticCurveTo", r.class);
        bhs.put("scale", w.class);
        bhs.put(RotateImageAction.ACTION_NAME, u.class);
        bhs.put("translate", aq.class);
        bhs.put("transform", ap.class);
        bhs.put("setTransform", aj.class);
        bhs.put("font", o.class);
        bhs.put("setFontSize", y.class);
        bhs.put("setTextAlign", ah.class);
        bhs.put("setTextBaseline", ai.class);
        bhs.put("fillText", n.class);
        bhs.put("strokeText", ao.class);
        bhs.put("clip", g.class);
        bhs.put("drawImage", k.class);
        bhs.put("save", v.class);
        bhs.put("restore", t.class);
        bhs.put("setShadow", af.class);
        bhs.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.bhq = new ArrayList();
        this.bhr = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = bhs.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.parseJson(optJSONArray);
                    this.bhq.add(newInstance);
                }
            }
            this.bhr = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Ku() {
        return this.bhq;
    }

    public boolean Kv() {
        return this.bhr;
    }

    @Override // com.baidu.swan.apps.canvas.b.a, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
