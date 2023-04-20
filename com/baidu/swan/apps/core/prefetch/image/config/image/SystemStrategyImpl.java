package com.baidu.swan.apps.core.prefetch.image.config.image;

import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.bc2;
import com.baidu.tieba.qc2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SystemStrategyImpl implements bc2 {
    public final List<String> a = new ArrayList<String>() { // from class: com.baidu.swan.apps.core.prefetch.image.config.image.SystemStrategyImpl.1
        {
            add("png");
            add("jpg");
            add("jpeg");
            add("webp");
            add("bmp");
            add(NativeConstants.TYPE_GIF);
        }
    };

    @NonNull
    public String toString() {
        return "SystemStrategyImpl";
    }

    @Override // com.baidu.tieba.bc2
    public boolean a(@NonNull qc2.a aVar) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(aVar.d());
        aVar.a(MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl));
        return this.a.contains(fileExtensionFromUrl);
    }
}
