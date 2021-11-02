package com.baidu.minivideo.plugin.capture.bean;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.Application;
import com.baidu.minivideo.plugin.capture.utils.FileUtils;
import com.baidu.minivideo.plugin.capture.utils.StringUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class FaceItem implements Jsonable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIR_STICKER = "sticker";
    public static final String DIR_UGC_DEFAULT = "ugccapture";
    public static final String NONE = "none";
    public static final int STICKER_TYPE_DUAR = 2;
    public static final int STICKER_TYPE_DUAR_LOCAL = 3;
    public static final int STICKER_TYPE_FU = 1;
    public static String sFolder;
    public transient /* synthetic */ FieldHolder $fh;
    public String bgurl;
    public String file;
    public String filterId;
    public String id;
    public String mLoadingFile;
    public String mResFile;
    public boolean mResLoaded;
    public String musicId;
    public String name;
    public String sk;
    public String tip;

    public FaceItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static File getBaiDuUgcCacheFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File file = new File(FileUtils.isSDMounted() ? Application.get().getExternalFilesDir(null) : null, DIR_UGC_DEFAULT);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static String getFolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (TextUtils.isEmpty(sFolder)) {
                sFolder = getPrivateCaptureRootChildDir(DIR_STICKER).getAbsolutePath();
            }
            return sFolder;
        }
        return (String) invokeV.objValue;
    }

    public static File getPrivateCaptureRootChildDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            File file = new File(getBaiDuUgcCacheFile().getAbsolutePath(), str);
            if (file.exists() || file.mkdirs()) {
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public void checkResFile() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mResLoaded = "none".equals(getFilePath()) || FileUtils.getExistFile(new File(getFilePath()));
        }
    }

    public String generateResFileName() {
        String str;
        int lastIndexOf;
        int indexOf;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                str = Uri.parse(this.file).getPath();
            } catch (Exception e2) {
                e2.printStackTrace();
                str = null;
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
        return (String) invokeV.objValue;
    }

    public String getFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.mResFile)) {
                if (TextUtils.isEmpty(this.sk) && TextUtils.isEmpty(this.mResFile)) {
                    return "none";
                }
                String generateResFileName = generateResFileName();
                String folder = getFolder();
                this.mResFile = folder + File.separator + generateResFileName;
            }
            return this.mResFile;
        }
        return (String) invokeV.objValue;
    }

    public String getLoadingFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.mLoadingFile)) {
                this.mLoadingFile = getFilePath();
            }
            return this.mLoadingFile;
        }
        return (String) invokeV.objValue;
    }

    public boolean onResLoaded(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            checkResFile();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public boolean parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.id = jSONObject.optString("id");
                this.name = jSONObject.optString("name");
                this.bgurl = jSONObject.optString("bgurl");
                this.file = jSONObject.optString("file");
                this.sk = jSONObject.optString(ContentUtil.RESULT_KEY_SK);
                this.tip = jSONObject.optString("tip");
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.id);
                jSONObject.put("name", this.name);
                jSONObject.put("bgurl", this.bgurl);
                jSONObject.put("file", this.file);
                jSONObject.put(ContentUtil.RESULT_KEY_SK, this.sk);
                jSONObject.put("tip", this.tip);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void parse(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (jSONObject != null) {
                this.id = jSONObject.optString("id");
                this.name = jSONObject.optString("name");
                this.bgurl = jSONObject.optString("bgurl");
                this.file = jSONObject.optString("file");
                this.sk = jSONObject.optString(ContentUtil.RESULT_KEY_SK);
                this.musicId = jSONObject.optString("music_id");
                this.tip = jSONObject.optString("tip");
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
    }
}
