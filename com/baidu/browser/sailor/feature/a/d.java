package com.baidu.browser.sailor.feature.a;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.lightapp.BdLightappConstants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes9.dex */
public final class d {
    public static final String a = Environment.getExternalStorageDirectory() + "/DCIM/Camera";
    public static final String b = Environment.getExternalStorageDirectory() + "/baidu/SearchBox/com.baidu.searchbox.plugins.xsearch/lightapp_rec";

    public static Uri a(File file) {
        if (file != null) {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("_data", file.getAbsolutePath());
            return BdSailor.getInstance().getAppContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        return null;
    }

    public static File a(File file, String str) {
        File file2;
        if (com.baidu.browser.sailor.util.b.a()) {
            File file3 = new File(Environment.getExternalStorageDirectory(), "/baidu/SearchBox/com.baidu.searchbox.plugins.xsearch");
            file2 = com.baidu.browser.sailor.util.b.a(file3) ? new File(file3, "lightapp_rec") : null;
        } else {
            File file4 = new File(file, BdLightappConstants.PLUGIN_PACKAGE_NAME);
            com.baidu.browser.sailor.util.b.a(file4);
            file2 = new File(file4, "lightapp_rec");
        }
        if (file2 == null || !com.baidu.browser.sailor.util.b.a(file2)) {
            return null;
        }
        return new File(file2, str);
    }

    public static File a(String str) {
        File file = new File(a);
        file.mkdirs();
        Date date = new Date(System.currentTimeMillis());
        if ("lightapp.device.MEDIA_TYPE.IMAGE".equals(str)) {
            return new File(file, "LightappPhoto-" + new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss").format(date) + ".jpg");
        }
        return new File(file, "LightappVideo-" + new SimpleDateFormat("'VID'_yyyyMMdd_HHmmss").format(date) + ".mp4");
    }

    public static boolean a(File file, File file2) {
        File file3 = new File(file, BdLightappConstants.PLUGIN_PACKAGE_NAME);
        File file4 = new File(Environment.getExternalStorageDirectory(), "/baidu/SearchBox/com.baidu.searchbox.plugins.xsearch");
        String absolutePath = file2.getAbsolutePath();
        return absolutePath.startsWith(file3.getAbsolutePath()) || absolutePath.startsWith(file4.getAbsolutePath());
    }
}
