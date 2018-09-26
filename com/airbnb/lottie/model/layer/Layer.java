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
    private final com.airbnb.lottie.e my;
    private final float nF;
    private final String nq;
    private final List<Mask> oQ;
    private final List<com.airbnb.lottie.model.content.b> pH;
    private final l qM;
    private final int rA;
    private final int rB;
    private final float rC;
    private final int rD;
    private final int rE;
    @Nullable
    private final j rF;
    @Nullable
    private final k rG;
    @Nullable
    private final com.airbnb.lottie.model.a.b rH;
    private final List<com.airbnb.lottie.a.a<Float>> rI;
    private final MatteType rJ;
    private final long rv;
    private final LayerType rw;
    private final long rx;
    @Nullable
    private final String ry;
    private final int rz;

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
        this.pH = list;
        this.my = eVar;
        this.nq = str;
        this.rv = j;
        this.rw = layerType;
        this.rx = j2;
        this.ry = str2;
        this.oQ = list2;
        this.qM = lVar;
        this.rz = i;
        this.rA = i2;
        this.rB = i3;
        this.rC = f;
        this.nF = f2;
        this.rD = i4;
        this.rE = i5;
        this.rF = jVar;
        this.rG = kVar;
        this.rI = list3;
        this.rJ = matteType;
        this.rH = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e cC() {
        return this.my;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float eu() {
        return this.rC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float cH() {
        return this.nF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.a.a<Float>> ev() {
        return this.rI;
    }

    public long getId() {
        return this.rv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.nq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.ry;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ew() {
        return this.rD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ex() {
        return this.rE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> dd() {
        return this.oQ;
    }

    public LayerType ey() {
        return this.rw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType ez() {
        return this.rJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eA() {
        return this.rx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: do  reason: not valid java name */
    public List<com.airbnb.lottie.model.content.b> m7do() {
        return this.pH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l ei() {
        return this.qM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.rB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eB() {
        return this.rA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eC() {
        return this.rz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j eD() {
        return this.rF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k eE() {
        return this.rG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b eF() {
        return this.rH;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer j = this.my.j(eA());
        if (j != null) {
            sb.append("\t\tParents: ").append(j.getName());
            Layer j2 = this.my.j(j.eA());
            while (j2 != null) {
                sb.append("->").append(j2.getName());
                j2 = this.my.j(j2.eA());
            }
            sb.append(str).append("\n");
        }
        if (!dd().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(dd().size()).append("\n");
        }
        if (eC() != 0 && eB() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(eC()), Integer.valueOf(eB()), Integer.valueOf(getSolidColor())));
        }
        if (!this.pH.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (com.airbnb.lottie.model.content.b bVar : this.pH) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static Layer k(com.airbnb.lottie.e eVar) {
            Rect bounds = eVar.getBounds();
            return new Layer(Collections.emptyList(), eVar, "root", -1L, LayerType.PreComp, -1L, null, Collections.emptyList(), l.a.dI(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), MatteType.None, null);
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
                i = (int) (jSONObject.optInt(TbConfig.SW_APID) * eVar.cu());
                i2 = (int) (jSONObject.optInt("sh") * eVar.cu());
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
            float optDouble2 = ((float) jSONObject.optDouble("st")) / eVar.ct();
            if (layerType2 == LayerType.PreComp) {
                i4 = (int) (jSONObject.optInt(Config.DEVICE_WIDTH) * eVar.cu());
                i5 = (int) (jSONObject.optInt("h") * eVar.cu());
            }
            float optLong3 = ((float) jSONObject.optLong("ip")) / optDouble;
            float optLong4 = ((float) jSONObject.optLong("op")) / optDouble;
            ArrayList arrayList3 = new ArrayList();
            if (optLong3 > 0.0f) {
                arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(optLong3)));
            }
            float co = (optLong4 > 0.0f ? optLong4 : (float) eVar.co()) + 1.0f;
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(1.0f), Float.valueOf(1.0f), null, optLong3, Float.valueOf(co)));
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, co, Float.valueOf(Float.MAX_VALUE)));
            com.airbnb.lottie.model.a.b bVar = null;
            if (jSONObject.has("tm")) {
                bVar = b.a.a(jSONObject.optJSONObject("tm"), eVar, false);
            }
            return new Layer(arrayList2, eVar, optString, optLong, layerType2, optLong2, optString2, arrayList, n, i, i2, i3, optDouble, optDouble2, i4, i5, jVar, kVar, arrayList3, matteType, bVar);
        }
    }
}
