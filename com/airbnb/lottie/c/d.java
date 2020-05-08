package com.airbnb.lottie.c;

import android.support.annotation.Nullable;
import android.util.JsonReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public static com.airbnb.lottie.model.a.b f(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return a(jsonReader, eVar, true);
    }

    public static com.airbnb.lottie.model.a.b a(JsonReader jsonReader, com.airbnb.lottie.e eVar, boolean z) throws IOException {
        return new com.airbnb.lottie.model.a.b(a(jsonReader, z ? com.airbnb.lottie.d.f.jk() : 1.0f, eVar, i.Ft));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.d g(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.model.a.d(a(jsonReader, eVar, o.Fv));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.f h(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.model.a.f(a(jsonReader, com.airbnb.lottie.d.f.jk(), eVar, y.Fz));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.g i(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.model.a.g(a(jsonReader, eVar, ac.FA));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.h j(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.model.a.h(a(jsonReader, com.airbnb.lottie.d.f.jk(), eVar, ad.FB));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.j k(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.model.a.j(a(jsonReader, eVar, h.Fs));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.a l(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.model.a.a(a(jsonReader, eVar, f.Fr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.c a(JsonReader jsonReader, com.airbnb.lottie.e eVar, int i) throws IOException {
        return new com.airbnb.lottie.model.a.c(a(jsonReader, eVar, new l(i)));
    }

    @Nullable
    private static <T> List<com.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, com.airbnb.lottie.e eVar, aj<T> ajVar) throws IOException {
        return r.a(jsonReader, eVar, 1.0f, ajVar);
    }

    @Nullable
    private static <T> List<com.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, float f, com.airbnb.lottie.e eVar, aj<T> ajVar) throws IOException {
        return r.a(jsonReader, eVar, f, ajVar);
    }
}
