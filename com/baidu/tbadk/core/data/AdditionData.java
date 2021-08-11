package com.baidu.tbadk.core.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PbPage.AddPost;
/* loaded from: classes6.dex */
public class AdditionData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6760087984237848132L;
    public transient /* synthetic */ FieldHolder $fh;
    public int alreadyCount;
    public long createTime;
    public String lastAdditionContent;
    public long lastAdditionTime;
    public String postId;
    public int totalCount;
    public String warnMsg;

    public AdditionData() {
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

    public void decreaseAlreadyCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.alreadyCount--;
        }
    }

    public int getAlreadyCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.alreadyCount : invokeV.intValue;
    }

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.createTime : invokeV.longValue;
    }

    public String getLastAdditionContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.lastAdditionContent : (String) invokeV.objValue;
    }

    public long getLastAdditionTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.lastAdditionTime : invokeV.longValue;
    }

    public String getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.postId : (String) invokeV.objValue;
    }

    public int getTotalCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.totalCount : invokeV.intValue;
    }

    public String getWarnMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.warnMsg : (String) invokeV.objValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.createTime = jSONObject.optLong("create_time", 0L);
            this.postId = jSONObject.optString("post_id");
            this.totalCount = jSONObject.optInt("total_count", 0);
            this.lastAdditionContent = jSONObject.optString("last_addition_content");
            this.lastAdditionTime = jSONObject.optLong("last_addition_time", 0L);
            this.alreadyCount = jSONObject.optInt("already_count", 0);
            this.warnMsg = jSONObject.optString("warn_msg");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserProtoBuf(AddPost addPost) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, addPost) == null) || addPost == null) {
            return;
        }
        try {
            this.createTime = addPost.create_time.intValue();
            this.postId = addPost.post_id;
            this.totalCount = addPost.total_count.intValue();
            this.lastAdditionContent = addPost.last_addition_content;
            this.lastAdditionTime = addPost.last_addition_time.intValue();
            this.alreadyCount = addPost.already_count.intValue();
            this.warnMsg = addPost.warn_msg;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setAlreadyCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.alreadyCount = i2;
        }
    }

    public void setCreateTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.createTime = j2;
        }
    }

    public void setLastAdditionContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.lastAdditionContent = str;
        }
    }

    public void setLastAdditionTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.lastAdditionTime = j2;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.postId = str;
        }
    }

    public void setTotalCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.totalCount = i2;
        }
    }

    public void setWarnMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.warnMsg = str;
        }
    }
}
