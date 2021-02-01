package com.baidu.live.lottie.c;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    public static com.baidu.live.lottie.model.a.b f(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        return a(jsonReader, eVar, true);
    }

    public static com.baidu.live.lottie.model.a.b a(JsonReader jsonReader, com.baidu.live.lottie.e eVar, boolean z) throws IOException {
        return new com.baidu.live.lottie.model.a.b(a(jsonReader, z ? com.baidu.live.lottie.d.f.kz() : 1.0f, eVar, i.buA));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.live.lottie.model.a.d g(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        return new com.baidu.live.lottie.model.a.d(a(jsonReader, eVar, o.buB));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.live.lottie.model.a.f h(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        return new com.baidu.live.lottie.model.a.f(a(jsonReader, com.baidu.live.lottie.d.f.kz(), eVar, y.buD));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.live.lottie.model.a.g i(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        return new com.baidu.live.lottie.model.a.g(a(jsonReader, eVar, ac.buE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.live.lottie.model.a.h j(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        return new com.baidu.live.lottie.model.a.h(a(jsonReader, com.baidu.live.lottie.d.f.kz(), eVar, ad.buF));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.live.lottie.model.a.j k(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        return new com.baidu.live.lottie.model.a.j(a(jsonReader, eVar, h.buz));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.live.lottie.model.a.a l(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        return new com.baidu.live.lottie.model.a.a(a(jsonReader, eVar, f.buy));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.live.lottie.model.a.c a(JsonReader jsonReader, com.baidu.live.lottie.e eVar, int i) throws IOException {
        return new com.baidu.live.lottie.model.a.c(a(jsonReader, eVar, new l(i)));
    }

    @Nullable
    private static <T> List<com.baidu.live.lottie.e.a<T>> a(JsonReader jsonReader, com.baidu.live.lottie.e eVar, aj<T> ajVar) throws IOException {
        return r.a(jsonReader, eVar, 1.0f, ajVar);
    }

    @Nullable
    private static <T> List<com.baidu.live.lottie.e.a<T>> a(JsonReader jsonReader, float f, com.baidu.live.lottie.e eVar, aj<T> ajVar) throws IOException {
        return r.a(jsonReader, eVar, f, ajVar);
    }
}
