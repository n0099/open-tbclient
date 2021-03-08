package com.baidu.live.lottie.c;

import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
        if (r6.equals("gs") != false) goto L16;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.live.lottie.model.content.b m(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        String str;
        com.baidu.live.lottie.model.content.b v;
        boolean z;
        char c = 2;
        jsonReader.beginObject();
        int i = 2;
        while (true) {
            if (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                switch (nextName.hashCode()) {
                    case 100:
                        if (nextName.equals("d")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 3717:
                        if (nextName.equals(Config.EXCEPTION_CRASH_CHANNEL)) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        str = jsonReader.nextString();
                        break;
                    case true:
                        i = jsonReader.nextInt();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else {
                str = null;
            }
        }
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3270:
                if (str.equals("fl")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3295:
                if (str.equals("gf")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3307:
                if (str.equals("gr")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3308:
                break;
            case 3488:
                if (str.equals("mm")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 3633:
                if (str.equals("rc")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3646:
                if (str.equals("rp")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 3669:
                if (str.equals("sh")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 3679:
                if (str.equals("sr")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3705:
                if (str.equals(IXAdRequestInfo.MAX_TITLE_LENGTH)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 3710:
                if (str.equals("tr")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                v = af.x(jsonReader, eVar);
                break;
            case 1:
                v = ah.z(jsonReader, eVar);
                break;
            case 2:
                v = n.p(jsonReader, eVar);
                break;
            case 3:
                v = ae.w(jsonReader, eVar);
                break;
            case 4:
                v = m.o(jsonReader, eVar);
                break;
            case 5:
                v = c.e(jsonReader, eVar);
                break;
            case 6:
                v = ag.y(jsonReader, eVar);
                break;
            case 7:
                v = e.b(jsonReader, eVar, i);
                break;
            case '\b':
                v = aa.u(jsonReader, eVar);
                break;
            case '\t':
                v = ai.A(jsonReader, eVar);
                break;
            case '\n':
                v = z.t(jsonReader, eVar);
                break;
            case 11:
                v = v.j(jsonReader);
                eVar.bg("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case '\f':
                v = ab.v(jsonReader, eVar);
                break;
            default:
                Log.w("LOTTIE", "Unknown shape type " + str);
                v = null;
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return v;
    }
}
