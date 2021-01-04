package com.airbnb.lottie.c;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static com.airbnb.lottie.model.a.b f(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return a(jsonReader, dVar, true);
    }

    public static com.airbnb.lottie.model.a.b a(JsonReader jsonReader, com.airbnb.lottie.d dVar, boolean z) throws IOException {
        return new com.airbnb.lottie.model.a.b(a(jsonReader, z ? com.airbnb.lottie.d.f.kA() : 1.0f, dVar, i.Ht));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.d g(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.model.a.d(a(jsonReader, dVar, o.Hv));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.f h(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.model.a.f(a(jsonReader, com.airbnb.lottie.d.f.kA(), dVar, y.Hz));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.g i(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.model.a.g(a(jsonReader, dVar, ac.HA));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.h j(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.model.a.h(a(jsonReader, com.airbnb.lottie.d.f.kA(), dVar, ad.HB));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.j k(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.model.a.j(a(jsonReader, dVar, h.Hs));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.a l(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.model.a.a(a(jsonReader, dVar, f.Hr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.c a(JsonReader jsonReader, com.airbnb.lottie.d dVar, int i) throws IOException {
        return new com.airbnb.lottie.model.a.c(a(jsonReader, dVar, new l(i)));
    }

    @Nullable
    private static <T> List<com.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, com.airbnb.lottie.d dVar, aj<T> ajVar) throws IOException {
        return r.a(jsonReader, dVar, 1.0f, ajVar);
    }

    @Nullable
    private static <T> List<com.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, float f, com.airbnb.lottie.d dVar, aj<T> ajVar) throws IOException {
        return r.a(jsonReader, dVar, f, ajVar);
    }
}
