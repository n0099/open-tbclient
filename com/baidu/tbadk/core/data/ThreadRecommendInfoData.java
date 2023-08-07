package com.baidu.tbadk.core.data;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
import tbclient.ThreadRecommendInfo;
/* loaded from: classes4.dex */
public class ThreadRecommendInfoData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUSINESS_TYPE_CONTENT_COLLECTION = 1;
    public static final String QUERY_ALBUM_TYPE = "album_type";
    public transient /* synthetic */ FieldHolder $fh;
    public int albumType;
    public ThemeColorInfo backgroundColor;
    public String businessId;
    public int businessType;
    public String forumAvatar;
    public String forumName;
    public String jumpIcon;
    public String jumpLink;
    public String jumpText;
    public ThemeColorInfo jumpTextColor;
    public String recommendIcon;
    public String recommendReason;
    public ThemeColorInfo recommendReasonColor;
    public String recommendTail;
    public long recommendTopicId;
    public String recommendType;
    public ThemeColorInfo recommendTypeColor;
    public int showNum;
    public String showType;
    public ThemeColorInfo stripColor;

    public ThreadRecommendInfoData() {
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
        this.albumType = -1;
    }

    public boolean isValidData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.recommendReason) && !TextUtils.isEmpty(this.recommendType)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void parseJumpLinkAlbumType(@Nullable String str) {
        Uri parse;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, str) == null) && !TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            this.albumType = JavaTypesHelper.toInt(parse.getQueryParameter(QUERY_ALBUM_TYPE), -1);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            try {
                this.forumAvatar = jSONObject.optString("forum_avatar");
                this.forumName = jSONObject.optString("forum_name");
                this.showNum = jSONObject.optInt("show_num");
                this.showType = jSONObject.optString(RecordVideoActivityConfig.SHOW_TYPE);
                this.recommendReason = jSONObject.optString("recommend_reason");
                this.recommendTopicId = jSONObject.optLong("topic_id");
                this.jumpLink = jSONObject.optString("jump_link");
                this.businessType = jSONObject.optInt("business_type");
                this.businessId = jSONObject.optString("business_id");
                this.jumpIcon = jSONObject.optString("jump_icon");
                this.jumpText = jSONObject.optString("jump_text");
                parseJumpLinkAlbumType(this.jumpLink);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void parseProto(ThreadRecommendInfo threadRecommendInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadRecommendInfo) != null) || threadRecommendInfo == null) {
            return;
        }
        this.forumAvatar = threadRecommendInfo.forum_avatar;
        this.forumName = threadRecommendInfo.forum_name;
        this.showNum = threadRecommendInfo.show_num.intValue();
        this.showType = threadRecommendInfo.show_type;
        this.recommendReason = threadRecommendInfo.recommend_reason;
        this.recommendTopicId = threadRecommendInfo.topic_id.longValue();
        this.recommendType = threadRecommendInfo.recommend_type;
        this.recommendTail = threadRecommendInfo.recommend_tail;
        this.recommendIcon = threadRecommendInfo.recommend_icon;
        this.recommendTypeColor = threadRecommendInfo.recommend_type_color;
        this.recommendReasonColor = threadRecommendInfo.recommend_reason_color;
        this.stripColor = threadRecommendInfo.strip_color;
        this.backgroundColor = threadRecommendInfo.background_color;
        this.jumpTextColor = threadRecommendInfo.jump_text_color;
        this.jumpLink = threadRecommendInfo.jump_link;
        this.businessType = threadRecommendInfo.business_type.intValue();
        this.businessId = threadRecommendInfo.business_id;
        this.jumpIcon = threadRecommendInfo.jump_icon;
        this.jumpText = threadRecommendInfo.jump_text;
        parseJumpLinkAlbumType(this.jumpLink);
    }
}
