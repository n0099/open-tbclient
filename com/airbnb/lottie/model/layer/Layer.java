package com.airbnb.lottie.model.layer;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.Mask;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
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
    private final com.airbnb.lottie.e kI;
    private final float lN;
    private final String lx;
    private final List<com.airbnb.lottie.model.content.b> nR;
    private final List<Mask> nc;
    private final l oY;
    private final long pO;
    private final LayerType pP;
    private final long pQ;
    @Nullable
    private final String pR;
    private final int pS;
    private final int pT;
    private final int pU;
    private final float pV;
    private final int pW;
    private final int pX;
    @Nullable
    private final j pY;
    @Nullable
    private final k pZ;
    @Nullable
    private final com.airbnb.lottie.model.a.b qa;
    private final List<com.airbnb.lottie.a.a<Float>> qb;
    private final MatteType qc;

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
        this.nR = list;
        this.kI = eVar;
        this.lx = str;
        this.pO = j;
        this.pP = layerType;
        this.pQ = j2;
        this.pR = str2;
        this.nc = list2;
        this.oY = lVar;
        this.pS = i;
        this.pT = i2;
        this.pU = i3;
        this.pV = f;
        this.lN = f2;
        this.pW = i4;
        this.pX = i5;
        this.pY = jVar;
        this.pZ = kVar;
        this.qb = list3;
        this.qc = matteType;
        this.qa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e bQ() {
        return this.kI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float dL() {
        return this.pV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float bV() {
        return this.lN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.a.a<Float>> dM() {
        return this.qb;
    }

    public long getId() {
        return this.pO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.lx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.pR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dN() {
        return this.pW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dO() {
        return this.pX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> cs() {
        return this.nc;
    }

    public LayerType dP() {
        return this.pP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType dQ() {
        return this.qc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dR() {
        return this.pQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> cE() {
        return this.nR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l dz() {
        return this.oY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.pU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dS() {
        return this.pT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dT() {
        return this.pS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j dU() {
        return this.pY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k dV() {
        return this.pZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b dW() {
        return this.qa;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer g = this.kI.g(dR());
        if (g != null) {
            sb.append("\t\tParents: ").append(g.getName());
            Layer g2 = this.kI.g(g.dR());
            while (g2 != null) {
                sb.append("->").append(g2.getName());
                g2 = this.kI.g(g2.dR());
            }
            sb.append(str).append("\n");
        }
        if (!cs().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(cs().size()).append("\n");
        }
        if (dT() != 0 && dS() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(dT()), Integer.valueOf(dS()), Integer.valueOf(getSolidColor())));
        }
        if (!this.nR.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (com.airbnb.lottie.model.content.b bVar : this.nR) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static Layer k(com.airbnb.lottie.e eVar) {
            Rect bz = eVar.bz();
            return new Layer(Collections.emptyList(), eVar, "root", -1L, LayerType.PreComp, -1L, null, Collections.emptyList(), l.a.cY(), 0, 0, 0, 0.0f, 0.0f, bz.width(), bz.height(), null, null, Collections.emptyList(), MatteType.None, null);
        }

        public static Layer C(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            LayerType layerType;
            String optString = jSONObject.optString("nm");
            String optString2 = jSONObject.optString("refId");
            if (optString.endsWith(".ai") || jSONObject.optString(Config.CELL_LOCATION, "").equals("ai")) {
                eVar.E("Convert your Illustrator layers to shape layers.");
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
                eVar.E("Text is only supported on bodymovin >= 4.8.0");
            }
            LayerType layerType2 = layerType;
            long optLong2 = jSONObject.optLong("parent", -1L);
            if (layerType2 == LayerType.Solid) {
                i = (int) (jSONObject.optInt("sw") * eVar.bI());
                i2 = (int) (jSONObject.optInt(IXAdRequestInfo.SCREEN_HEIGHT) * eVar.bI());
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
                eVar.E("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + Arrays.toString(strArr));
            }
            float optDouble = (float) jSONObject.optDouble("sr", 1.0d);
            float optDouble2 = ((float) jSONObject.optDouble("st")) / eVar.bH();
            if (layerType2 == LayerType.PreComp) {
                i4 = (int) (jSONObject.optInt("w") * eVar.bI());
                i5 = (int) (jSONObject.optInt("h") * eVar.bI());
            }
            float optLong3 = ((float) jSONObject.optLong("ip")) / optDouble;
            float optLong4 = ((float) jSONObject.optLong(Config.OPERATOR)) / optDouble;
            ArrayList arrayList3 = new ArrayList();
            if (optLong3 > 0.0f) {
                arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(optLong3)));
            }
            float bC = (optLong4 > 0.0f ? optLong4 : (float) eVar.bC()) + 1.0f;
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(1.0f), Float.valueOf(1.0f), null, optLong3, Float.valueOf(bC)));
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, bC, Float.valueOf(Float.MAX_VALUE)));
            com.airbnb.lottie.model.a.b bVar = null;
            if (jSONObject.has(IXAdRequestInfo.MAX_TITLE_LENGTH)) {
                bVar = b.a.a(jSONObject.optJSONObject(IXAdRequestInfo.MAX_TITLE_LENGTH), eVar, false);
            }
            return new Layer(arrayList2, eVar, optString, optLong, layerType2, optLong2, optString2, arrayList, n, i, i2, i3, optDouble, optDouble2, i4, i5, jVar, kVar, arrayList3, matteType, bVar);
        }
    }
}
