package com.baidu.searchbox.ng.ai.apps.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public final class AiAppAssetUtils {
    private static final String TAG = "AssetUtils";

    private AiAppAssetUtils() {
    }

    public static boolean exists(Context context, String str) {
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            try {
                InputStream open = context.getAssets().open(str, 0);
                z = true;
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return z;
    }

    public static boolean extractFolderFromAsset(AssetManager assetManager, String str, String str2) {
        String[] list;
        boolean z = false;
        try {
            for (String str3 : assetManager.list(str)) {
                String str4 = str + File.separator + str3;
                String[] list2 = assetManager.list(str4);
                if (list2 == null || list2.length == 0) {
                    z = extractFileFromAsset(assetManager, str4, str2 + File.separator + str3);
                } else {
                    z = extractFolderFromAsset(assetManager, str4, str2 + File.separator + str3);
                }
                if (!z) {
                    break;
                }
            }
        } catch (IOException e) {
        }
        return z;
    }

    public static boolean extractFileFromAsset(AssetManager assetManager, String str, String str2) {
        boolean z = false;
        try {
            z = AiAppStreamUtils.streamToFile(assetManager.open(str, 0), new File(str2));
            if (!z) {
                new File(str2).delete();
            }
        } catch (IOException e) {
        }
        return z;
    }

    public static String loadAssetsFile(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        String str2 = null;
        try {
            inputStream = context.getAssets().open(str);
            if (inputStream != null) {
                try {
                    str2 = AiAppStreamUtils.streamToString(inputStream);
                    AiAppsFileUtils.closeSafely(inputStream);
                } catch (IOException e) {
                    AiAppsFileUtils.closeSafely(inputStream);
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    AiAppsFileUtils.closeSafely(inputStream);
                    throw th;
                }
            } else {
                AiAppsFileUtils.closeSafely(inputStream);
            }
        } catch (IOException e2) {
            inputStream = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
        }
        return str2;
    }
}
