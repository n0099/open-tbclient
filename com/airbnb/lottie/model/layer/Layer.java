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
    private final String nX;
    private final com.airbnb.lottie.e nj;
    private final float on;
    private final List<Mask> pE;
    private final List<com.airbnb.lottie.model.content.b> qr;
    private final l rw;
    private final long sg;
    private final LayerType sh;
    private final long si;
    @Nullable
    private final String sj;
    private final int sk;
    private final int sl;
    private final int sm;
    private final float so;
    private final int sq;
    private final int sr;
    @Nullable
    private final j ss;
    @Nullable
    private final k su;
    @Nullable
    private final com.airbnb.lottie.model.a.b sv;
    private final List<com.airbnb.lottie.a.a<Float>> sw;
    private final MatteType sx;

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
        this.qr = list;
        this.nj = eVar;
        this.nX = str;
        this.sg = j;
        this.sh = layerType;
        this.si = j2;
        this.sj = str2;
        this.pE = list2;
        this.rw = lVar;
        this.sk = i;
        this.sl = i2;
        this.sm = i3;
        this.so = f;
        this.on = f2;
        this.sq = i4;
        this.sr = i5;
        this.ss = jVar;
        this.su = kVar;
        this.sw = list3;
        this.sx = matteType;
        this.sv = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e cS() {
        return this.nj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float eK() {
        return this.so;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float cX() {
        return this.on;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.a.a<Float>> eL() {
        return this.sw;
    }

    public long getId() {
        return this.sg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.nX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.sj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eM() {
        return this.sq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eN() {
        return this.sr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> dt() {
        return this.pE;
    }

    public LayerType eO() {
        return this.sh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType eP() {
        return this.sx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long eQ() {
        return this.si;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> dE() {
        return this.qr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l ey() {
        return this.rw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.sm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eR() {
        return this.sl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eS() {
        return this.sk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j eT() {
        return this.ss;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k eU() {
        return this.su;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b eV() {
        return this.sv;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer j = this.nj.j(eQ());
        if (j != null) {
            sb.append("\t\tParents: ").append(j.getName());
            Layer j2 = this.nj.j(j.eQ());
            while (j2 != null) {
                sb.append("->").append(j2.getName());
                j2 = this.nj.j(j2.eQ());
            }
            sb.append(str).append("\n");
        }
        if (!dt().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(dt().size()).append("\n");
        }
        if (eS() != 0 && eR() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(eS()), Integer.valueOf(eR()), Integer.valueOf(getSolidColor())));
        }
        if (!this.qr.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (com.airbnb.lottie.model.content.b bVar : this.qr) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static Layer k(com.airbnb.lottie.e eVar) {
            Rect bounds = eVar.getBounds();
            return new Layer(Collections.emptyList(), eVar, "root", -1L, LayerType.PreComp, -1L, null, Collections.emptyList(), l.a.dY(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), MatteType.None, null);
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
                i = (int) (jSONObject.optInt(TbConfig.SW_APID) * eVar.cK());
                i2 = (int) (jSONObject.optInt("sh") * eVar.cK());
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
            float optDouble2 = ((float) jSONObject.optDouble("st")) / eVar.cJ();
            if (layerType2 == LayerType.PreComp) {
                i4 = (int) (jSONObject.optInt(Config.DEVICE_WIDTH) * eVar.cK());
                i5 = (int) (jSONObject.optInt("h") * eVar.cK());
            }
            float optLong3 = ((float) jSONObject.optLong("ip")) / optDouble;
            float optLong4 = ((float) jSONObject.optLong(Config.OPERATOR)) / optDouble;
            ArrayList arrayList3 = new ArrayList();
            if (optLong3 > 0.0f) {
                arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(optLong3)));
            }
            float cE = (optLong4 > 0.0f ? optLong4 : (float) eVar.cE()) + 1.0f;
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(1.0f), Float.valueOf(1.0f), null, optLong3, Float.valueOf(cE)));
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, cE, Float.valueOf(Float.MAX_VALUE)));
            com.airbnb.lottie.model.a.b bVar = null;
            if (jSONObject.has("tm")) {
                bVar = b.a.a(jSONObject.optJSONObject("tm"), eVar, false);
            }
            return new Layer(arrayList2, eVar, optString, optLong, layerType2, optLong2, optString2, arrayList, n, i, i2, i3, optDouble, optDouble2, i4, i5, jVar, kVar, arrayList3, matteType, bVar);
        }
    }
}
