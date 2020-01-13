package com.baidu.minivideo.plugin.capture.bean;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.minivideo.plugin.capture.Application;
import com.baidu.minivideo.plugin.capture.utils.FileUtils;
import com.baidu.minivideo.plugin.capture.utils.StringUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class FaceItem implements Jsonable {
    public static final String DIR_STICKER = "sticker";
    private static final String DIR_UGC_DEFAULT = "ugccapture";
    public static final String NONE = "none";
    public static final int STICKER_TYPE_DUAR = 2;
    public static final int STICKER_TYPE_DUAR_LOCAL = 3;
    public static final int STICKER_TYPE_FU = 1;
    private static String sFolder;
    public String bgurl;
    public String file;
    public String filterId;
    public String id;
    protected String mLoadingFile;
    protected String mResFile;
    private boolean mResLoaded;
    public String musicId;
    public String name;
    public String sk;
    public String tip;

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("name", this.name);
            jSONObject.put("bgurl", this.bgurl);
            jSONObject.put("file", this.file);
            jSONObject.put("sk", this.sk);
            jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_TIP, this.tip);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public boolean parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.id = jSONObject.optString("id");
            this.name = jSONObject.optString("name");
            this.bgurl = jSONObject.optString("bgurl");
            this.file = jSONObject.optString("file");
            this.sk = jSONObject.optString("sk");
            this.tip = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_TIP);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optString("id");
            this.name = jSONObject.optString("name");
            this.bgurl = jSONObject.optString("bgurl");
            this.file = jSONObject.optString("file");
            this.sk = jSONObject.optString("sk");
            this.musicId = jSONObject.optString("music_id");
            this.tip = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_TIP);
            this.filterId = jSONObject.optString("filter_id");
            this.mResFile = jSONObject.optString("mResFile");
            this.mLoadingFile = jSONObject.optString("mLoadingFile");
            if (TextUtils.isEmpty(this.mResFile) && TextUtils.isEmpty(this.sk)) {
                this.mResFile = "none";
            }
        }
        checkResFile();
        getFolder();
        getLoadingFile();
    }

    public String getFilePath() {
        if (TextUtils.isEmpty(this.mResFile)) {
            if (TextUtils.isEmpty(this.sk) && TextUtils.isEmpty(this.mResFile)) {
                return "none";
            }
            this.mResFile = getFolder() + File.separator + generateResFileName();
        }
        return this.mResFile;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String generateResFileName() {
        int lastIndexOf;
        int indexOf;
        String str = null;
        try {
            str = Uri.parse(this.file).getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str) && (indexOf = this.file.indexOf(63)) > 0) {
            str = this.file.substring(0, indexOf);
        }
        if (str != null && (lastIndexOf = str.lastIndexOf(46)) > 1) {
            str = str.substring(0, lastIndexOf);
        }
        if (TextUtils.isEmpty(str)) {
            str = this.file;
        }
        return this.sk + StringUtils.encodeUrl(str);
    }

    public static String getFolder() {
        if (TextUtils.isEmpty(sFolder)) {
            sFolder = getPrivateCaptureRootChildDir("sticker").getAbsolutePath();
        }
        return sFolder;
    }

    public static File getBaiDuUgcCacheFile() {
        File file = new File(FileUtils.isSDMounted() ? Application.get().getExternalFilesDir(null) : null, DIR_UGC_DEFAULT);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getPrivateCaptureRootChildDir(String str) {
        File file = new File(getBaiDuUgcCacheFile().getAbsolutePath(), str);
        if (file.exists() || file.mkdirs()) {
        }
        return file;
    }

    public String getLoadingFile() {
        if (TextUtils.isEmpty(this.mLoadingFile)) {
            this.mLoadingFile = getFilePath();
        }
        return this.mLoadingFile;
    }

    public boolean onResLoaded(String str) {
        checkResFile();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkResFile() {
        this.mResLoaded = "none".equals(getFilePath()) || FileUtils.getExistFile(new File(getFilePath()));
    }
}
