package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PublishProgressEntity implements Jsonable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mProgress;
    public String mVideoCover;
    public String mVideoPath;
    public int showWhere;
    public int type;

    /* loaded from: classes4.dex */
    public interface ShowWhere {
        public static final int SHOW_FOLLOW = 2;
        public static final int SHOW_HOME_INDEX = 1;
    }

    /* loaded from: classes4.dex */
    public interface Type {
        public static final int PUBLISH_FAIL = 2;
        public static final int PUBLISH_PROGRESS = 4;
        public static final int PUBLISH_START = 1;
        public static final int PUBLISH_SUCCESS = 3;
    }

    public PublishProgressEntity() {
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
        this.showWhere = 2;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PublishProgressEntity) {
                PublishProgressEntity publishProgressEntity = (PublishProgressEntity) obj;
                if (this.mProgress == publishProgressEntity.mProgress && this.type == publishProgressEntity.type && this.showWhere == publishProgressEntity.showWhere) {
                    String str = this.mVideoCover;
                    if (str == null ? publishProgressEntity.mVideoCover == null : str.equals(publishProgressEntity.mVideoCover)) {
                        String str2 = this.mVideoPath;
                        String str3 = publishProgressEntity.mVideoPath;
                        return str2 != null ? str2.equals(str3) : str3 == null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.mVideoCover;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.mVideoPath;
            return ((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.mProgress) * 31) + this.type) * 31) + this.showWhere;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public boolean parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mVideoCover = jSONObject.optString("mVideoCover");
                this.mVideoPath = jSONObject.optString("mVideoPath");
                this.mProgress = jSONObject.optInt("mProgress");
                this.type = jSONObject.optInt("type");
                this.showWhere = jSONObject.optInt("showWhere");
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mVideoCover", this.mVideoCover);
                jSONObject.put("mVideoPath", this.mVideoPath);
                jSONObject.put("mProgress", this.mProgress);
                jSONObject.put("type", this.type);
                jSONObject.put("showWhere", this.showWhere);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
