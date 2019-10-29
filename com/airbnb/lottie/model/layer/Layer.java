package com.airbnb.lottie.model.layer;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.Mask;
import com.baidu.android.imsdk.db.TableDefine;
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
    private final String dZ;
    private final com.airbnb.lottie.e dk;
    private final float eo;
    private final List<Mask> fz;
    private final List<com.airbnb.lottie.model.content.b> gn;
    private final long hZ;
    private final l hs;
    private final LayerType ia;
    private final long ib;
    @Nullable
    private final String ic;
    private final int ie;

    /* renamed from: if  reason: not valid java name */
    private final int f2if;
    private final int ig;
    private final float ih;
    private final int ii;
    private final int ij;
    @Nullable
    private final j ik;
    @Nullable
    private final k il;
    @Nullable
    private final com.airbnb.lottie.model.a.b im;
    private final List<com.airbnb.lottie.a.a<Float>> io;
    private final MatteType iq;

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
        this.gn = list;
        this.dk = eVar;
        this.dZ = str;
        this.hZ = j;
        this.ia = layerType;
        this.ib = j2;
        this.ic = str2;
        this.fz = list2;
        this.hs = lVar;
        this.ie = i;
        this.f2if = i2;
        this.ig = i3;
        this.ih = f;
        this.eo = f2;
        this.ii = i4;
        this.ij = i5;
        this.ik = jVar;
        this.il = kVar;
        this.io = list3;
        this.iq = matteType;
        this.im = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e bj() {
        return this.dk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float de() {
        return this.ih;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float bo() {
        return this.eo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.a.a<Float>> df() {
        return this.io;
    }

    public long getId() {
        return this.hZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.dZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.ic;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dg() {
        return this.ii;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dh() {
        return this.ij;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> bL() {
        return this.fz;
    }

    public LayerType di() {
        return this.ia;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType dj() {
        return this.iq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dk() {
        return this.ib;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> bX() {
        return this.gn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l cS() {
        return this.hs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.ig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dl() {
        return this.f2if;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dm() {
        return this.ie;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j dn() {
        return this.ik;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: do  reason: not valid java name */
    public k m6do() {
        return this.il;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.a.b dp() {
        return this.im;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer g = this.dk.g(dk());
        if (g != null) {
            sb.append("\t\tParents: ").append(g.getName());
            Layer g2 = this.dk.g(g.dk());
            while (g2 != null) {
                sb.append("->").append(g2.getName());
                g2 = this.dk.g(g2.dk());
            }
            sb.append(str).append("\n");
        }
        if (!bL().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(bL().size()).append("\n");
        }
        if (dm() != 0 && dl() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(dm()), Integer.valueOf(dl()), Integer.valueOf(getSolidColor())));
        }
        if (!this.gn.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (com.airbnb.lottie.model.content.b bVar : this.gn) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static Layer k(com.airbnb.lottie.e eVar) {
            Rect aS = eVar.aS();
            return new Layer(Collections.emptyList(), eVar, "root", -1L, LayerType.PreComp, -1L, null, Collections.emptyList(), l.a.cr(), 0, 0, 0, 0.0f, 0.0f, aS.width(), aS.height(), null, null, Collections.emptyList(), MatteType.None, null);
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
                i = (int) (jSONObject.optInt("sw") * eVar.bb());
                i2 = (int) (jSONObject.optInt(IXAdRequestInfo.SCREEN_HEIGHT) * eVar.bb());
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
            float optDouble2 = ((float) jSONObject.optDouble("st")) / eVar.ba();
            if (layerType2 == LayerType.PreComp) {
                i4 = (int) (jSONObject.optInt("w") * eVar.bb());
                i5 = (int) (jSONObject.optInt("h") * eVar.bb());
            }
            float optLong3 = ((float) jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_IP)) / optDouble;
            float optLong4 = ((float) jSONObject.optLong("op")) / optDouble;
            ArrayList arrayList3 = new ArrayList();
            if (optLong3 > 0.0f) {
                arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(optLong3)));
            }
            float aV = (optLong4 > 0.0f ? optLong4 : (float) eVar.aV()) + 1.0f;
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(1.0f), Float.valueOf(1.0f), null, optLong3, Float.valueOf(aV)));
            arrayList3.add(new com.airbnb.lottie.a.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, aV, Float.valueOf(Float.MAX_VALUE)));
            com.airbnb.lottie.model.a.b bVar = null;
            if (jSONObject.has(IXAdRequestInfo.MAX_TITLE_LENGTH)) {
                bVar = b.a.a(jSONObject.optJSONObject(IXAdRequestInfo.MAX_TITLE_LENGTH), eVar, false);
            }
            return new Layer(arrayList2, eVar, optString, optLong, layerType2, optLong2, optString2, arrayList, n, i, i2, i3, optDouble, optDouble2, i4, i5, jVar, kVar, arrayList3, matteType, bVar);
        }
    }
}
