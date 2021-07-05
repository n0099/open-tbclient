package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class HotTopicBussinessData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1827556427330154557L;
    public transient /* synthetic */ FieldHolder $fh;
    public long mFollowNum;
    public String mForumAbstract;
    public String mForumAvatar;
    public long mForumId;
    public String mForumName;
    public int mIsGlobalBlock;
    public boolean mIsLiked;
    public long mPostNum;
    public long mThreadNum;
    public String mTopicName;

    public HotTopicBussinessData(long j, String str, String str2, String str3, long j2, long j3, long j4, boolean z, String str4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str, str2, str3, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), str4, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mForumId = 0L;
        this.mForumName = null;
        this.mForumAvatar = null;
        this.mForumAbstract = null;
        this.mThreadNum = 0L;
        this.mPostNum = 0L;
        this.mFollowNum = 0L;
        this.mIsLiked = false;
        this.mIsGlobalBlock = 0;
        this.mForumId = j;
        this.mForumName = str;
        this.mForumAvatar = str2;
        this.mForumAbstract = str3;
        this.mThreadNum = j2;
        this.mPostNum = j3;
        this.mFollowNum = j4;
        this.mIsLiked = z;
        this.mTopicName = str4;
        this.mIsGlobalBlock = i2;
    }

    public String getForumAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mForumAvatar : (String) invokeV.objValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mForumId : invokeV.longValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mForumName : (String) invokeV.objValue;
    }

    public void setForumAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mForumAvatar = str;
        }
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.mForumId = j;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mForumName = str;
        }
    }

    public HotTopicBussinessData(long j, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mForumId = 0L;
        this.mForumName = null;
        this.mForumAvatar = null;
        this.mForumAbstract = null;
        this.mThreadNum = 0L;
        this.mPostNum = 0L;
        this.mFollowNum = 0L;
        this.mIsLiked = false;
        this.mIsGlobalBlock = 0;
        this.mForumId = j;
        this.mForumName = str;
        this.mTopicName = str2;
        this.mIsGlobalBlock = i2;
    }

    public HotTopicBussinessData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mForumId = 0L;
        this.mForumName = null;
        this.mForumAvatar = null;
        this.mForumAbstract = null;
        this.mThreadNum = 0L;
        this.mPostNum = 0L;
        this.mFollowNum = 0L;
        this.mIsLiked = false;
        this.mIsGlobalBlock = 0;
    }
}
