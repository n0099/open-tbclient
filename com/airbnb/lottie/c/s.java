package com.airbnb.lottie.c;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.airbnb.lottie.model.layer.Layer;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes4.dex */
public class s {
    public static Layer d(com.airbnb.lottie.e eVar) {
        Rect be = eVar.be();
        return new Layer(Collections.emptyList(), eVar, "__container", -1L, Layer.LayerType.PreComp, -1L, null, Collections.emptyList(), new com.airbnb.lottie.model.a.l(), 0, 0, 0, 0.0f, 0.0f, be.width(), be.height(), null, null, Collections.emptyList(), Layer.MatteType.None, null);
    }

    public static Layer q(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        String nextString;
        long j;
        Layer.LayerType layerType;
        String str;
        String str2 = "UNSET";
        Layer.LayerType layerType2 = null;
        String str3 = null;
        long j2 = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        long j3 = -1;
        float f = 1.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        String str4 = null;
        Layer.MatteType matteType = Layer.MatteType.None;
        com.airbnb.lottie.model.a.l lVar = null;
        com.airbnb.lottie.model.a.j jVar = null;
        com.airbnb.lottie.model.a.k kVar = null;
        com.airbnb.lottie.model.a.b bVar = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -995424086:
                    if (nextName.equals("parent")) {
                        c = 4;
                        break;
                    }
                    break;
                case -903568142:
                    if (nextName.equals("shapes")) {
                        c = 11;
                        break;
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c = 17;
                        break;
                    }
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c = 16;
                        break;
                    }
                    break;
                case 3177:
                    if (nextName.equals(Config.CELL_LOCATION)) {
                        c = 21;
                        break;
                    }
                    break;
                case 3233:
                    if (nextName.equals("ef")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 3367:
                    if (nextName.equals(TableDefine.UserInfoColumns.COLUMN_IP)) {
                        c = 18;
                        break;
                    }
                    break;
                case 3432:
                    if (nextName.equals("ks")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c = 19;
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals(Config.STAT_SDK_CHANNEL)) {
                        c = 7;
                        break;
                    }
                    break;
                case 3669:
                    if (nextName.equals(IXAdRequestInfo.SCREEN_HEIGHT)) {
                        c = 6;
                        break;
                    }
                    break;
                case 3679:
                    if (nextName.equals("sr")) {
                        c = 14;
                        break;
                    }
                    break;
                case 3681:
                    if (nextName.equals("st")) {
                        c = 15;
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3705:
                    if (nextName.equals(IXAdRequestInfo.MAX_TITLE_LENGTH)) {
                        c = 20;
                        break;
                    }
                    break;
                case 3712:
                    if (nextName.equals(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP)) {
                        c = '\t';
                        break;
                    }
                    break;
                case 3717:
                    if (nextName.equals(Config.EXCEPTION_CRASH_CHANNEL)) {
                        c = 3;
                        break;
                    }
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        c = 1;
                        break;
                    }
                    break;
                case 108390670:
                    if (nextName.equals("refId")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1441620890:
                    if (nextName.equals("masksProperties")) {
                        c = '\n';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    j = j2;
                    layerType = layerType2;
                    str = jsonReader.nextString();
                    nextString = str4;
                    break;
                case 1:
                    j = jsonReader.nextInt();
                    nextString = str4;
                    layerType = layerType2;
                    str = str2;
                    break;
                case 2:
                    str3 = jsonReader.nextString();
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    if (nextInt < Layer.LayerType.Unknown.ordinal()) {
                        j = j2;
                        layerType = Layer.LayerType.values()[nextInt];
                        str = str2;
                        nextString = str4;
                        break;
                    } else {
                        j = j2;
                        layerType = Layer.LayerType.Unknown;
                        str = str2;
                        nextString = str4;
                        break;
                    }
                case 4:
                    j3 = jsonReader.nextInt();
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case 5:
                    i = (int) (jsonReader.nextInt() * com.airbnb.lottie.d.f.dK());
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case 6:
                    i2 = (int) (jsonReader.nextInt() * com.airbnb.lottie.d.f.dK());
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case 7:
                    i3 = Color.parseColor(jsonReader.nextString());
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case '\b':
                    lVar = c.e(jsonReader, eVar);
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case '\t':
                    matteType = Layer.MatteType.values()[jsonReader.nextInt()];
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case '\n':
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(u.r(jsonReader, eVar));
                    }
                    jsonReader.endArray();
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.airbnb.lottie.model.content.b m = g.m(jsonReader, eVar);
                        if (m != null) {
                            arrayList2.add(m);
                        }
                    }
                    jsonReader.endArray();
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case '\f':
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        char c2 = 65535;
                        switch (nextName2.hashCode()) {
                            case 97:
                                if (nextName2.equals(Config.APP_VERSION_CODE)) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 100:
                                if (nextName2.equals("d")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                jVar = d.k(jsonReader, eVar);
                                break;
                            case 1:
                                jsonReader.beginArray();
                                if (jsonReader.hasNext()) {
                                    kVar = b.c(jsonReader, eVar);
                                }
                                while (jsonReader.hasNext()) {
                                    jsonReader.skipValue();
                                }
                                jsonReader.endArray();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case '\r':
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            char c3 = 65535;
                            switch (nextName3.hashCode()) {
                                case 3519:
                                    if (nextName3.equals("nm")) {
                                        c3 = 0;
                                        break;
                                    }
                                    break;
                            }
                            switch (c3) {
                                case 0:
                                    arrayList3.add(jsonReader.nextString());
                                    break;
                                default:
                                    jsonReader.skipValue();
                                    break;
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    eVar.G("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList3);
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case 14:
                    f = (float) jsonReader.nextDouble();
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case 15:
                    f2 = (float) jsonReader.nextDouble();
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case 16:
                    i4 = (int) (jsonReader.nextInt() * com.airbnb.lottie.d.f.dK());
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case 17:
                    i5 = (int) (jsonReader.nextInt() * com.airbnb.lottie.d.f.dK());
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case 18:
                    f3 = (float) jsonReader.nextDouble();
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    nextString = str4;
                    break;
                case 19:
                    f4 = (float) jsonReader.nextDouble();
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    nextString = str4;
                    break;
                case 20:
                    bVar = d.a(jsonReader, eVar, false);
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                case 21:
                    nextString = jsonReader.nextString();
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
                default:
                    jsonReader.skipValue();
                    nextString = str4;
                    j = j2;
                    layerType = layerType2;
                    str = str2;
                    break;
            }
            str4 = nextString;
            j2 = j;
            layerType2 = layerType;
            str2 = str;
        }
        jsonReader.endObject();
        float f5 = f3 / f;
        float f6 = f4 / f;
        ArrayList arrayList4 = new ArrayList();
        if (f5 > 0.0f) {
            arrayList4.add(new com.airbnb.lottie.e.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(f5)));
        }
        if (f6 <= 0.0f) {
            f6 = eVar.bh();
        }
        arrayList4.add(new com.airbnb.lottie.e.a(eVar, Float.valueOf(1.0f), Float.valueOf(1.0f), null, f5, Float.valueOf(f6)));
        arrayList4.add(new com.airbnb.lottie.e.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, f6, Float.valueOf(Float.MAX_VALUE)));
        if (str2.endsWith(".ai") || "ai".equals(str4)) {
            eVar.G("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList2, eVar, str2, j2, layerType2, j3, str3, arrayList, lVar, i, i2, i3, f, f2, i4, i5, jVar, kVar, arrayList4, matteType, bVar);
    }
}
