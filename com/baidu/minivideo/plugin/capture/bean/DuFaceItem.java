package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.minivideo.plugin.capture.utils.FileUtils;
import com.baidu.tieba.ad0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DuFaceItem extends FaceItem {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean ADJUST_ZIP = false;
    public transient /* synthetic */ FieldHolder $fh;
    public int arType;

    public DuFaceItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.arType = 10;
    }

    private boolean deleteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
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
        return invokeL.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem
    public String getFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem
    public String getLoadingFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.mLoadingFile)) {
                String filePath = getFilePath();
                this.mLoadingFile = filePath;
                if (!filePath.endsWith(".zip")) {
                    this.mLoadingFile += ".zip";
                }
            }
            return this.mLoadingFile;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem
    public boolean onResLoaded(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z2 = false;
            try {
                FileUtils.unzipFile(new File(str), getFilePath());
                z = ad0.k1(getFilePath());
                if (!z) {
                    LogUtils.d("DuFaceData", getFilePath() + " not verify");
                    FileUtils.deleteDir(new File(getFilePath()));
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                deleteFile(str);
            } catch (Exception e2) {
                e = e2;
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
        return invokeL.booleanValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem
    public void parse(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            if (jSONObject != null) {
                this.arType = jSONObject.optInt("sub_type");
            }
            super.parse(jSONObject);
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.FaceItem, com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject json = super.toJson();
            try {
                json.put("sub_type", this.arType);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
