package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import com.baidu.minivideo.a.a;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.minivideo.plugin.capture.utils.FileUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class DuFaceItem extends FaceItem {
    private static final boolean ADJUST_ZIP = false;
    public int arType = 10;

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem
    public String getLoadingFile() {
        if (TextUtils.isEmpty(this.mLoadingFile)) {
            this.mLoadingFile = getFilePath();
            if (!this.mLoadingFile.endsWith(".zip")) {
                this.mLoadingFile += ".zip";
            }
        }
        return this.mLoadingFile;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem
    public boolean onResLoaded(String str) {
        boolean z;
        Exception e;
        try {
            FileUtils.unzipFile(new File(str), getFilePath());
            z = a.em(getFilePath());
            if (!z) {
            }
            if (!z) {
                LogUtils.d("DuFaceData", getFilePath() + " not verify");
                FileUtils.deleteDir(new File(getFilePath()));
            }
        } catch (Exception e2) {
            z = false;
            e = e2;
        }
        try {
            deleteFile(str);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            deleteFile(getFilePath());
            checkResFile();
            return z;
        }
        checkResFile();
        return z;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.arType = jSONObject.optInt("sub_type");
        }
        super.parse(jSONObject);
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem, com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        try {
            json.put("sub_type", this.arType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    private boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return FileUtils.delete(new File(str));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem
    public String getFilePath() {
        if (TextUtils.isEmpty(this.mResFile)) {
            if (TextUtils.isEmpty(this.sk) && TextUtils.isEmpty(this.mResFile)) {
                return "none";
            }
            this.mResFile = getFolder() + File.separator + generateResFileName();
        }
        return this.mResFile;
    }
}
