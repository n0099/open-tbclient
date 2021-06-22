package com.baidu.swan.apps.core.prefetch.image.config.image;

import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import d.a.m0.a.h0.o.h.d.b.a;
import d.a.m0.a.h0.o.h.g.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SystemStrategyImpl implements a {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f10883a = new ArrayList<String>() { // from class: com.baidu.swan.apps.core.prefetch.image.config.image.SystemStrategyImpl.1
        {
            add("png");
            add("jpg");
            add("jpeg");
            add("webp");
            add("bmp");
            add("gif");
        }
    };

    @Override // d.a.m0.a.h0.o.h.d.b.a
    public boolean a(@NonNull g gVar) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(gVar.d());
        gVar.a(MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl));
        return this.f10883a.contains(fileExtensionFromUrl);
    }

    @NonNull
    public String toString() {
        return "SystemStrategyImpl";
    }
}
