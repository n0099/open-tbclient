package com.airbnb.lottie.model.layer;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.Mask;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.TbConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Layer {
    private static final String TAG = Layer.class.getSimpleName();
    private final com.airbnb.lottie.e jX;
    private final String kN;
    private final float lc;
    private final List<Mask> mn;
    private final List<com.airbnb.lottie.model.content.b> ne;
    private final long oU;
    private final LayerType oV;
    private final long oW;
    @Nullable
    private final String oX;
    private final int oY;
    private final int oZ;
    private final l oj;
    private final int pa;
    private final float pd;
    private final int pe;
    private final int pf;
    @Nullable
    private final j pg;
    @Nullable
    private final k ph;
    @Nullable
    private final com.airbnb.lottie.model.a.b pi;
    private final List<com.airbnb.lottie.a.a<Float>> pj;
    private final MatteType pl;

    /* loaded from: classes2.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    private Layer(List<com.airbnb.lottie.model.content.b> list, com.airbnb.lottie.e eVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.airbnb.lottie.a.a<Float>> list3, MatteType matteType, @Nullable com.airbnb.lottie.model.a.b bVar) {
        this.ne = list;
        this.jX = eVar;
        this.kN = str;
        this.oU = j;
        this.oV = layerType;
        this.oW = j2;
        this.oX = str2;
        this.mn = list2;
        this.oj = lVar;
        this.oY = i;
        this.oZ = i2;
        this.pa = i3;
        this.pd = f;
        this.lc = f2;
        this.pe = i4;
        this.pf = i5;
        this.pg = jVar;
        this.ph = kVar;
        this.pj = list3;
        this.pl = matteType;
        this.pi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e bv() {
        return this.jX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float dn() {
        return this.pd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float bA() {
        return this.lc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: do  reason: not valid java name */
    public List<com.airbnb.lottie.a.a<Float>> m6do() {
        return this.pj;
    }

    public long getId() {
        return this.oU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.kN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.oX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dp() {
        return this.pe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dq() {
        return this.pf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> bW() {
        return this.mn;
    }

    public LayerType dr() {
        return this.oV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType ds() {
        return this.pl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dt() {
        return this.oW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> ch() {
        return this.ne;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l db() {
        return this.oj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.pa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int du() {
        return this.oZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dv() {
        return this.oY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j dw() {
        return this.pg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k dx() {
        return this.ph;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b dy() {
        return this.pi;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer g = this.jX.g(dt());
        if (g != null) {
            sb.append("\t\tParents: ").append(g.getName());
            Layer g2 = this.jX.g(g.dt());
            while (g2 != null) {
                sb.append("->").append(g2.getName());
                g2 = this.jX.g(g2.dt());
            }
            sb.append(str).append("\n");
        }
        if (!bW().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(bW().size()).append("\n");
        }
        if (dv() != 0 && du() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(dv()), Integer.valueOf(du()), Integer.valueOf(getSolidColor())));
        }
        if (!this.ne.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (com.airbnb.lottie.model.content.b bVar : this.ne) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static Layer k(com.airbnb.lottie.e eVar) {
            Rect bounds = eVar.getBounds();
            return new Layer(Collections.emptyList(), eVar, "root", -1L, LayerType.PreComp, -1L, null, Collections.emptyList(), l.a.cB(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), MatteType.None, null);
        }

        public static Layer C(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            LayerType layerType;
            String optString = jSONObject.optString("nm");
            String optString2 = jSONObject.optString("refId");
            if (optString.endsWith(".ai") || jSONObject.optString("cl", "").equals("ai")) {
                eVar.E("Convert your Illustrator layers to shape layers.");
            }
            long optLong = jSONObject.optLong("ind");
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int optInt = jSONObject.optInt("ty", -1);
            if (optInt < LayerType.Unknown.ordinal()) {
                layerType = LayerType.values()[optInt];
            } else {
                layerType = LayerType.Unknown;
            }
            if (layerType == LayerType.Text && !com.airbnb.lottie.c.f.a(eVar, 4, 8, 0)) {
                layerType = LayerType.Unknown;
                eVar.E("Text is only supported on bodymovin >= 4.8.0");
            }
            LayerType layerType2 = layerType;
            long optLong2 = jSONObject.optLong("parent", -1L);
            if (layerType2 == LayerType.Solid) {
                i = (int) (jSONObject.optInt(TbConfig.SW_APID) * eVar.bn());
                i2 = (int) (jSONObject.optInt("sh") * eVar.bn());
                i3 = Color.parseColor(jSONObject.optString("sc"));
            }
            l n = l.a.n(jSONObject.optJSONObject("ks"), eVar);
            MatteType matteType = MatteType.values()[jSONObject.optInt(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP)];
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("masksProperties");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    arrayList.add(Mask.a.r(optJSONArray.optJSONObject(i6), eVar));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("shapes");
            if (optJSONArray2 != null) {
                for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                    com.airbnb.lottie.model.content.b w = com.airbnb.lottie.model.content.j.w(optJSONArray2.optJSONObject(i7), eVar);
                    if (w != null) {
                        arrayList2.add(w);
                    }
                }
            }
            j jVar = null;
            k kVar = null;
            JSONObject optJSONObject = jSONObject.optJSONObject(Info.kBaiduTimeKey);
            if (optJSONObject != null) {
                jVar = j.a.l(optJSONObject.optJSONObject("d"), eVar);
                kVar = k.a.m(optJSONObject.optJSONArray("a").optJSONObject(0), eVar);
            }
            if (jSONObject.has("ef")) {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ef");
                String[] strArr = new String[optJSONArray3.length()];
                for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                    strArr[i8] = optJSONArray3.optJSONObject(i8).optString("nm");
                }
                eVar.E("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + Arrays.toString(strArr));
            }
            float optDouble = (float) jSONObject.optDouble("sr", 1.0d);
            float optDouble2 = ((float) jSONObject.optDouble(TimeDisplaySetting.START_SHOW_TIME)) / eVar.bm();
            if (layerType2 == LayerType.PreComp) {
                i4 = (int) (jSONObject.optInt("w") * eVar.bn());
                i5 = (int) (jSONObject.optInt("h") * eVar.bn());
            }
            float optLong3 = ((float) jSONObject.optLong("ip")) / optDouble;
            float optLong4 = ((float) jSONObject.optLong(com.baidu.fsg.base.statistics.j.d)) / optDouble;
            ArrayList arrayList3 = new ArrayList();
            if (optLong3 > 0.0f) {
                arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(optLong3)));
            }
            float bh = (optLong4 > 0.0f ? optLong4 : (float) eVar.bh()) + 1.0f;
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(1.0f), Float.valueOf(1.0f), null, optLong3, Float.valueOf(bh)));
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, bh, Float.valueOf(Float.MAX_VALUE)));
            com.airbnb.lottie.model.a.b bVar = null;
            if (jSONObject.has("tm")) {
                bVar = b.a.a(jSONObject.optJSONObject("tm"), eVar, false);
            }
            return new Layer(arrayList2, eVar, optString, optLong, layerType2, optLong2, optString2, arrayList, n, i, i2, i3, optDouble, optDouble2, i4, i5, jVar, kVar, arrayList3, matteType, bVar);
        }
    }
}
