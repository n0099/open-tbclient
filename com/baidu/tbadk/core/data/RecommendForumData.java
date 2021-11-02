package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.FrsPage.RecommendForum;
/* loaded from: classes8.dex */
public class RecommendForumData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String mForumImageUrl;
    public String mForumLink;
    public String mForumName;
    public int mMemberNum;
    public String mParam;
    public int mThreadNum;

    public RecommendForumData() {
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

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.mForumName = jSONObject.optString("name");
        this.mForumImageUrl = jSONObject.optString("avatar");
        this.mForumLink = jSONObject.optString("link");
        this.mParam = jSONObject.optString("st_param");
        this.mMemberNum = jSONObject.optInt("member_num");
        this.mThreadNum = jSONObject.optInt("thread_num");
    }

    public void parserProtobuf(RecommendForum recommendForum) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recommendForum) == null) || recommendForum == null) {
            return;
        }
        this.mForumName = recommendForum.name;
        this.mForumImageUrl = recommendForum.avatar;
        this.mForumLink = recommendForum.link;
        this.mParam = recommendForum.st_param;
        this.mMemberNum = recommendForum.member_num.intValue();
        this.mThreadNum = recommendForum.thread_num.intValue();
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
