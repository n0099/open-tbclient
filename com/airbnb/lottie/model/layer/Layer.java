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
    private final String kV;
    private final com.airbnb.lottie.e kg;
    private final float lk;
    private final List<Mask> my;
    private final List<com.airbnb.lottie.model.content.b> np;
    private final l ow;
    private final long pg;
    private final LayerType ph;
    private final long pi;
    @Nullable
    private final String pj;
    private final int pl;
    private final int po;
    private final int pp;
    private final float pq;
    private final int pr;
    private final int pt;
    @Nullable
    private final j pu;
    @Nullable
    private final k pv;
    @Nullable
    private final com.airbnb.lottie.model.a.b pw;
    private final List<com.airbnb.lottie.a.a<Float>> px;
    private final MatteType py;

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
        this.np = list;
        this.kg = eVar;
        this.kV = str;
        this.pg = j;
        this.ph = layerType;
        this.pi = j2;
        this.pj = str2;
        this.my = list2;
        this.ow = lVar;
        this.pl = i;
        this.po = i2;
        this.pp = i3;
        this.pq = f;
        this.lk = f2;
        this.pr = i4;
        this.pt = i5;
        this.pu = jVar;
        this.pv = kVar;
        this.px = list3;
        this.py = matteType;
        this.pw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e bx() {
        return this.kg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float dp() {
        return this.pq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float bC() {
        return this.lk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.a.a<Float>> dq() {
        return this.px;
    }

    public long getId() {
        return this.pg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.kV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.pj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dr() {
        return this.pr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ds() {
        return this.pt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> bY() {
        return this.my;
    }

    public LayerType dt() {
        return this.ph;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType du() {
        return this.py;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dv() {
        return this.pi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> cj() {
        return this.np;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l dd() {
        return this.ow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.pp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dw() {
        return this.po;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dx() {
        return this.pl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j dy() {
        return this.pu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k dz() {
        return this.pv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b dA() {
        return this.pw;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer g = this.kg.g(dv());
        if (g != null) {
            sb.append("\t\tParents: ").append(g.getName());
            Layer g2 = this.kg.g(g.dv());
            while (g2 != null) {
                sb.append("->").append(g2.getName());
                g2 = this.kg.g(g2.dv());
            }
            sb.append(str).append("\n");
        }
        if (!bY().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(bY().size()).append("\n");
        }
        if (dx() != 0 && dw() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(dx()), Integer.valueOf(dw()), Integer.valueOf(getSolidColor())));
        }
        if (!this.np.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (com.airbnb.lottie.model.content.b bVar : this.np) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static Layer k(com.airbnb.lottie.e eVar) {
            Rect bounds = eVar.getBounds();
            return new Layer(Collections.emptyList(), eVar, "root", -1L, LayerType.PreComp, -1L, null, Collections.emptyList(), l.a.cD(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), MatteType.None, null);
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
                i = (int) (jSONObject.optInt(TbConfig.SW_APID) * eVar.bp());
                i2 = (int) (jSONObject.optInt("sh") * eVar.bp());
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
            float optDouble2 = ((float) jSONObject.optDouble(TimeDisplaySetting.START_SHOW_TIME)) / eVar.bo();
            if (layerType2 == LayerType.PreComp) {
                i4 = (int) (jSONObject.optInt("w") * eVar.bp());
                i5 = (int) (jSONObject.optInt("h") * eVar.bp());
            }
            float optLong3 = ((float) jSONObject.optLong("ip")) / optDouble;
            float optLong4 = ((float) jSONObject.optLong(com.baidu.fsg.base.statistics.j.d)) / optDouble;
            ArrayList arrayList3 = new ArrayList();
            if (optLong3 > 0.0f) {
                arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(optLong3)));
            }
            float bj = (optLong4 > 0.0f ? optLong4 : (float) eVar.bj()) + 1.0f;
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(1.0f), Float.valueOf(1.0f), null, optLong3, Float.valueOf(bj)));
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, bj, Float.valueOf(Float.MAX_VALUE)));
            com.airbnb.lottie.model.a.b bVar = null;
            if (jSONObject.has("tm")) {
                bVar = b.a.a(jSONObject.optJSONObject("tm"), eVar, false);
            }
            return new Layer(arrayList2, eVar, optString, optLong, layerType2, optLong2, optString2, arrayList, n, i, i2, i3, optDouble, optDouble2, i4, i5, jVar, kVar, arrayList3, matteType, bVar);
        }
    }
}
