package com.baidu.swan.apps.canvas.c;

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
    private static Map<String, Class<? extends com.baidu.swan.apps.canvas.a.a.a>> anj = new HashMap();
    private List<com.baidu.swan.apps.canvas.a.a.a> anh;
    private boolean ani;

    static {
        anj.put("setFillStyle", x.class);
        anj.put("fillRect", m.class);
        anj.put("setStrokeStyle", ag.class);
        anj.put("strokeStyle", an.class);
        anj.put("setLineCap", aa.class);
        anj.put("setLineJoin", ac.class);
        anj.put("setLineWidth", ad.class);
        anj.put("setLineDash", ab.class);
        anj.put("setMiterLimit", ae.class);
        anj.put("strokeRect", am.class);
        anj.put("moveTo", q.class);
        anj.put("lineTo", p.class);
        anj.put("stroke", al.class);
        anj.put("fill", l.class);
        anj.put("beginPath", com.baidu.swan.apps.canvas.a.a.d.class);
        anj.put("rect", s.class);
        anj.put("clearRect", com.baidu.swan.apps.canvas.a.a.f.class);
        anj.put("closePath", h.class);
        anj.put("arc", com.baidu.swan.apps.canvas.a.a.c.class);
        anj.put("bezierCurveTo", com.baidu.swan.apps.canvas.a.a.e.class);
        anj.put("quadraticCurveTo", r.class);
        anj.put("scale", w.class);
        anj.put("rotate", u.class);
        anj.put("translate", aq.class);
        anj.put("transform", ap.class);
        anj.put("setTransform", aj.class);
        anj.put("font", o.class);
        anj.put("setFontSize", y.class);
        anj.put("setTextAlign", ah.class);
        anj.put("setTextBaseline", ai.class);
        anj.put("fillText", n.class);
        anj.put("strokeText", ao.class);
        anj.put("clip", com.baidu.swan.apps.canvas.a.a.g.class);
        anj.put("drawImage", k.class);
        anj.put("save", v.class);
        anj.put("restore", t.class);
        anj.put("setShadow", af.class);
        anj.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.anh = new ArrayList();
        this.ani = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString("actions"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends com.baidu.swan.apps.canvas.a.a.a> cls = anj.get(optString);
                if (cls != null) {
                    com.baidu.swan.apps.canvas.a.a.a newInstance = cls.newInstance();
                    newInstance.e(optJSONArray);
                    this.anh.add(newInstance);
                }
            }
            this.ani = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> xX() {
        return this.anh;
    }

    public boolean xY() {
        return this.ani;
    }

    @Override // com.baidu.swan.apps.canvas.c.a, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return super.isValid();
    }
}
