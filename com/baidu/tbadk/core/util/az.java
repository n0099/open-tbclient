package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import java.io.File;
/* loaded from: classes.dex */
public final class az {
    public static void a(Activity activity) {
        try {
            if (!w.a()) {
                if (activity instanceof com.baidu.tbadk.a) {
                    ((com.baidu.tbadk.a) activity).showToast(w.b());
                } else if (activity instanceof com.baidu.tbadk.core.e) {
                    ((com.baidu.tbadk.core.e) activity).a(w.b());
                }
            } else {
                File f = w.f("camera.jpg");
                if (f != null) {
                    Uri fromFile = Uri.fromFile(f);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    activity.startActivityForResult(intent, 12001);
                } else if (activity instanceof com.baidu.tbadk.a) {
                    ((com.baidu.tbadk.a) activity).showToast(activity.getString(com.baidu.tbadk.l.error_sd_error));
                } else if (activity instanceof com.baidu.tbadk.core.e) {
                    ((com.baidu.tbadk.core.e) activity).a(activity.getString(com.baidu.tbadk.l.error_sd_error));
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("WriteUtil", "takePhoto", "error = " + e.getMessage());
        }
    }

    public static void a(Activity activity, String str) {
        String str2;
        try {
            if (!w.a()) {
                if (activity instanceof com.baidu.tbadk.a) {
                    ((com.baidu.tbadk.a) activity).showToast(w.b());
                    return;
                } else if (activity instanceof com.baidu.tbadk.core.e) {
                    ((com.baidu.tbadk.core.e) activity).a(w.b());
                    return;
                } else {
                    return;
                }
            }
            boolean z = false;
            if (w.a(w.a + "/" + com.baidu.tbadk.core.data.n.f() + "/cameras")) {
                File file = new File(String.valueOf(str2) + "/" + str);
                if (!file.exists()) {
                    z = file.createNewFile();
                } else {
                    z = true;
                }
                if (z) {
                    Uri fromFile = Uri.fromFile(file);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", fromFile);
                    activity.startActivityForResult(intent, 12001);
                }
            }
            if (!z) {
                if (activity instanceof com.baidu.tbadk.a) {
                    ((com.baidu.tbadk.a) activity).showToast(activity.getString(com.baidu.tbadk.l.error_sd_error));
                } else if (activity instanceof com.baidu.tbadk.core.e) {
                    ((com.baidu.tbadk.core.e) activity).a(activity.getString(com.baidu.tbadk.l.error_sd_error));
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("WriteUtil", "takePhoto", "error = " + e.getMessage());
        }
    }

    public static void b(Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            activity.startActivityForResult(intent, 12002);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("WriteUtil", "getAlbumImage", "error = " + e.getMessage());
        }
    }
}
