package com.baidu.swan.apps.core.prefetch.image.config.image;

import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import com.baidu.android.util.media.WebpUtils;
import com.baidu.tieba.ka2;
import com.baidu.tieba.v92;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SystemStrategyImpl implements v92 {
    public final List<String> a = new ArrayList<String>() { // from class: com.baidu.swan.apps.core.prefetch.image.config.image.SystemStrategyImpl.1
        {
            add("png");
            add("jpg");
            add("jpeg");
            add(WebpUtils.TYPE_IMG_WEBP);
            add("bmp");
            add("gif");
        }
    };

    @NonNull
    public String toString() {
        return "SystemStrategyImpl";
    }

    @Override // com.baidu.tieba.v92
    public boolean a(@NonNull ka2.a aVar) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(aVar.d());
        aVar.a(MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl));
        return this.a.contains(fileExtensionFromUrl);
    }
}
