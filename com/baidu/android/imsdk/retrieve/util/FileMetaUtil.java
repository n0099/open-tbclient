package com.baidu.android.imsdk.retrieve.util;

import com.baidu.android.imsdk.utils.LogUtils;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FileMetaUtil {
    public static final String CREATE_TIME = "createTime";
    public static final String ERR_MSG = "errmsg";
    public static final String ERR_NO = "errno";
    public static final String ISFILE = "1";
    public static final String IS_FILE = "isFile";
    public static final String MODIFY_TIME = "modifiedTime";
    public static final String NOTFILE = "0";
    public static final String SIZE = "size";
    public static final String TAG = "FileMetaUtil";
    public static final String ZIP_PATH = "zipPath";

    public static JSONObject makeFileMeta(File file, String str, String str2, String str3, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", str2);
            jSONObject.put("errmsg", str3);
            jSONObject.put(IS_FILE, z ? "1" : "0");
            if (file != null && file.exists() && file.isFile()) {
                jSONObject.put(ZIP_PATH, str);
                jSONObject.put("size", String.valueOf(file.length()));
                jSONObject.put("createTime", file.lastModified());
                jSONObject.put(MODIFY_TIME, file.lastModified());
            }
        } catch (Exception e2) {
            LogUtils.d(TAG, e2.toString());
        }
        return jSONObject;
    }
}
