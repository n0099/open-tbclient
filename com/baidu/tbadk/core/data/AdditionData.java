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
/* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.alreadyCount;
        }
        return invokeV.intValue;
    }

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.createTime;
        }
        return invokeV.longValue;
    }

    public String getLastAdditionContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.lastAdditionContent;
        }
        return (String) invokeV.objValue;
    }

    public long getLastAdditionTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.lastAdditionTime;
        }
        return invokeV.longValue;
    }

    public String getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.postId;
        }
        return (String) invokeV.objValue;
    }

    public int getTotalCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.totalCount;
        }
        return invokeV.intValue;
    }

    public String getWarnMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.warnMsg;
        }
        return (String) invokeV.objValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) != null) || jSONObject == null) {
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
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserProtoBuf(AddPost addPost) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, addPost) != null) || addPost == null) {
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
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setAlreadyCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.alreadyCount = i;
        }
    }

    public void setCreateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.createTime = j;
        }
    }

    public void setLastAdditionContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.lastAdditionContent = str;
        }
    }

    public void setLastAdditionTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.lastAdditionTime = j;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.postId = str;
        }
    }

    public void setTotalCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.totalCount = i;
        }
    }

    public void setWarnMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.warnMsg = str;
        }
    }
}
