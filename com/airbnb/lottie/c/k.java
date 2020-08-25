package com.airbnb.lottie.c;

import android.util.JsonReader;
import java.io.IOException;
/* loaded from: classes18.dex */
class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.c a(JsonReader jsonReader) throws IOException {
        String str = null;
        float f = 0.0f;
        jsonReader.beginObject();
        String str2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1866931350:
                    if (nextName.equals("fFamily")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1408684838:
                    if (nextName.equals("ascent")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1294566165:
                    if (nextName.equals("fStyle")) {
                        c = 2;
                        break;
                    }
                    break;
                case 96619537:
                    if (nextName.equals("fName")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str3 = jsonReader.nextString();
                    break;
                case 1:
                    str2 = jsonReader.nextString();
                    break;
                case 2:
                    str = jsonReader.nextString();
                    break;
                case 3:
                    f = (float) jsonReader.nextDouble();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.airbnb.lottie.model.c(str3, str2, str, f);
    }
}
