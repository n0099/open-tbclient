package com.baidu.swan.apps.core.prefetch.image.config.image;

import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import com.baidu.android.util.media.WebpUtils;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.cg2;
import com.baidu.tieba.nf2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SystemStrategyImpl implements nf2 {
    public final List<String> a = new ArrayList<String>() { // from class: com.baidu.swan.apps.core.prefetch.image.config.image.SystemStrategyImpl.1
        {
            add("png");
            add("jpg");
            add("jpeg");
            add(WebpUtils.TYPE_IMG_WEBP);
            add("bmp");
            add(NativeConstants.TYPE_GIF);
        }
    };

    @NonNull
    public String toString() {
        return "SystemStrategyImpl";
    }

    @Override // com.baidu.tieba.nf2
    public boolean a(@NonNull cg2.a aVar) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(aVar.d());
        aVar.a(MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl));
        return this.a.contains(fileExtensionFromUrl);
    }
}
