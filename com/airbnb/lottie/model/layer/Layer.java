package com.airbnb.lottie.model.layer;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.Mask;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
    private final com.airbnb.lottie.e np;
    private final String oc;
    private final float ou;
    private final List<Mask> pJ;
    private final List<com.airbnb.lottie.model.content.b> qv;
    private final l rA;
    private final List<com.airbnb.lottie.a.a<Float>> sA;
    private final MatteType sB;
    private final long sk;
    private final LayerType sl;
    private final long sm;
    @Nullable
    private final String so;
    private final int sq;
    private final int sr;
    private final int ss;
    private final float su;
    private final int sv;
    private final int sw;
    @Nullable
    private final j sx;
    @Nullable
    private final k sy;
    @Nullable
    private final com.airbnb.lottie.model.a.b sz;

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
        this.qv = list;
        this.np = eVar;
        this.oc = str;
        this.sk = j;
        this.sl = layerType;
        this.sm = j2;
        this.so = str2;
        this.pJ = list2;
        this.rA = lVar;
        this.sq = i;
        this.sr = i2;
        this.ss = i3;
        this.su = f;
        this.ou = f2;
        this.sv = i4;
        this.sw = i5;
        this.sx = jVar;
        this.sy = kVar;
        this.sA = list3;
        this.sB = matteType;
        this.sz = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e cT() {
        return this.np;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float eL() {
        return this.su;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float cY() {
        return this.ou;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.a.a<Float>> eM() {
        return this.sA;
    }

    public long getId() {
        return this.sk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.oc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.so;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eN() {
        return this.sv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eO() {
        return this.sw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> du() {
        return this.pJ;
    }

    public LayerType eP() {
        return this.sl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType eQ() {
        return this.sB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eR() {
        return this.sm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> dF() {
        return this.qv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l ez() {
        return this.rA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.ss;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eS() {
        return this.sr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eT() {
        return this.sq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j eU() {
        return this.sx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k eV() {
        return this.sy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b eW() {
        return this.sz;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer l = this.np.l(eR());
        if (l != null) {
            sb.append("\t\tParents: ").append(l.getName());
            Layer l2 = this.np.l(l.eR());
            while (l2 != null) {
                sb.append("->").append(l2.getName());
                l2 = this.np.l(l2.eR());
            }
            sb.append(str).append("\n");
        }
        if (!du().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(du().size()).append("\n");
        }
        if (eT() != 0 && eS() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(eT()), Integer.valueOf(eS()), Integer.valueOf(getSolidColor())));
        }
        if (!this.qv.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (com.airbnb.lottie.model.content.b bVar : this.qv) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static Layer k(com.airbnb.lottie.e eVar) {
            Rect bounds = eVar.getBounds();
            return new Layer(Collections.emptyList(), eVar, "root", -1L, LayerType.PreComp, -1L, null, Collections.emptyList(), l.a.dZ(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), MatteType.None, null);
        }

        public static Layer C(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            LayerType layerType;
            String optString = jSONObject.optString("nm");
            String optString2 = jSONObject.optString("refId");
            if (optString.endsWith(".ai") || jSONObject.optString(Config.CELL_LOCATION, "").equals("ai")) {
                eVar.V("Convert your Illustrator layers to shape layers.");
            }
            long optLong = jSONObject.optLong("ind");
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int optInt = jSONObject.optInt(Config.EXCEPTION_CRASH_CHANNEL, -1);
            if (optInt < LayerType.Unknown.ordinal()) {
                layerType = LayerType.values()[optInt];
            } else {
                layerType = LayerType.Unknown;
            }
            if (layerType == LayerType.Text && !com.airbnb.lottie.c.f.a(eVar, 4, 8, 0)) {
                layerType = LayerType.Unknown;
                eVar.V("Text is only supported on bodymovin >= 4.8.0");
            }
            LayerType layerType2 = layerType;
            long optLong2 = jSONObject.optLong("parent", -1L);
            if (layerType2 == LayerType.Solid) {
                i = (int) (jSONObject.optInt(TbConfig.SW_APID) * eVar.cL());
                i2 = (int) (jSONObject.optInt("sh") * eVar.cL());
                i3 = Color.parseColor(jSONObject.optString(Config.STAT_SDK_CHANNEL));
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
            JSONObject optJSONObject = jSONObject.optJSONObject("t");
            if (optJSONObject != null) {
                jVar = j.a.l(optJSONObject.optJSONObject("d"), eVar);
                kVar = k.a.m(optJSONObject.optJSONArray(Config.APP_VERSION_CODE).optJSONObject(0), eVar);
            }
            if (jSONObject.has("ef")) {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ef");
                String[] strArr = new String[optJSONArray3.length()];
                for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                    strArr[i8] = optJSONArray3.optJSONObject(i8).optString("nm");
                }
                eVar.V("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + Arrays.toString(strArr));
            }
            float optDouble = (float) jSONObject.optDouble("sr", 1.0d);
            float optDouble2 = ((float) jSONObject.optDouble("st")) / eVar.cK();
            if (layerType2 == LayerType.PreComp) {
                i4 = (int) (jSONObject.optInt(Config.DEVICE_WIDTH) * eVar.cL());
                i5 = (int) (jSONObject.optInt("h") * eVar.cL());
            }
            float optLong3 = ((float) jSONObject.optLong("ip")) / optDouble;
            float optLong4 = ((float) jSONObject.optLong("op")) / optDouble;
            ArrayList arrayList3 = new ArrayList();
            if (optLong3 > 0.0f) {
                arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(optLong3)));
            }
            float cF = (optLong4 > 0.0f ? optLong4 : (float) eVar.cF()) + 1.0f;
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(1.0f), Float.valueOf(1.0f), null, optLong3, Float.valueOf(cF)));
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, cF, Float.valueOf(Float.MAX_VALUE)));
            com.airbnb.lottie.model.a.b bVar = null;
            if (jSONObject.has("tm")) {
                bVar = b.a.a(jSONObject.optJSONObject("tm"), eVar, false);
            }
            return new Layer(arrayList2, eVar, optString, optLong, layerType2, optLong2, optString2, arrayList, n, i, i2, i3, optDouble, optDouble2, i4, i5, jVar, kVar, arrayList3, matteType, bVar);
        }
    }
}
