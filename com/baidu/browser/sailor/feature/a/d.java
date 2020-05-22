package com.baidu.browser.sailor.feature.a;

import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes11.dex */
public final class d {
    public static File a(String str) {
        if (WebKitFactory.getContext() == null) {
            return null;
        }
        File externalFilesDir = WebKitFactory.getContext().getExternalFilesDir("DCIM/Camera");
        externalFilesDir.mkdirs();
        Date date = new Date(System.currentTimeMillis());
        if ("lightapp.device.MEDIA_TYPE.IMAGE".equals(str)) {
            return new File(externalFilesDir, "LightappPhoto-" + new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss").format(date) + ".jpg");
        }
        return new File(externalFilesDir, "LightappVideo-" + new SimpleDateFormat("'VID'_yyyyMMdd_HHmmss").format(date) + ".mp4");
    }
}
