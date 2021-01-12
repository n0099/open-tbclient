package com.baidu.android.imsdk.retrieve.util;

import com.baidu.android.imsdk.utils.LogUtils;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FileMetaUtil {
    private static final String CREATE_TIME = "createTime";
    private static final String ERR_MSG = "errmsg";
    private static final String ERR_NO = "errno";
    private static final String ISFILE = "1";
    private static final String IS_FILE = "isFile";
    private static final String MODIFY_TIME = "modifiedTime";
    private static final String NOTFILE = "0";
    private static final String SIZE = "size";
    private static final String TAG = "FileMetaUtil";
    private static final String ZIP_PATH = "zipPath";

    public static JSONObject makeFileMeta(File file, String str, String str2, String str3, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", str2);
            jSONObject.put("errmsg", str3);
            jSONObject.put(IS_FILE, z ? "1" : "0");
            if (file != null && file.exists() && file.isFile()) {
                jSONObject.put(ZIP_PATH, str);
                jSONObject.put("size", String.valueOf(file.length()));
                jSONObject.put(CREATE_TIME, file.lastModified());
                jSONObject.put(MODIFY_TIME, file.lastModified());
            }
        } catch (Exception e) {
            LogUtils.d(TAG, e.toString());
        }
        return jSONObject;
    }
}
