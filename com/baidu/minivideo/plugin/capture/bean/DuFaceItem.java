package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import com.baidu.minivideo.arface.ARControllerProxy;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.minivideo.plugin.capture.utils.FileUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DuFaceItem extends FaceItem {
    public static final boolean ADJUST_ZIP = false;
    public int arType = 10;

    private boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return FileUtils.delete(new File(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem
    public String getFilePath() {
        if (TextUtils.isEmpty(this.mResFile)) {
            if (TextUtils.isEmpty(this.sk) && TextUtils.isEmpty(this.mResFile)) {
                return "none";
            }
            String generateResFileName = generateResFileName();
            String folder = FaceItem.getFolder();
            this.mResFile = folder + File.separator + generateResFileName;
        }
        return this.mResFile;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem
    public String getLoadingFile() {
        if (TextUtils.isEmpty(this.mLoadingFile)) {
            String filePath = getFilePath();
            this.mLoadingFile = filePath;
            if (!filePath.endsWith(".zip")) {
                this.mLoadingFile += ".zip";
            }
        }
        return this.mLoadingFile;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem
    public boolean onResLoaded(String str) {
        boolean z;
        boolean z2 = false;
        try {
            FileUtils.unzipFile(new File(str), getFilePath());
            z = ARControllerProxy.verifyStickPath(getFilePath());
            if (!z) {
                LogUtils.d("DuFaceData", getFilePath() + " not verify");
                FileUtils.deleteDir(new File(getFilePath()));
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            deleteFile(str);
        } catch (Exception e3) {
            e = e3;
            z2 = z;
            e.printStackTrace();
            deleteFile(getFilePath());
            z = z2;
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
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return json;
    }
}
