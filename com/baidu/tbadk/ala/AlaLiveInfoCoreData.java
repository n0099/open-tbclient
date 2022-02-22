package com.baidu.tbadk.ala;

import c.a.t0.s.r.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
/* loaded from: classes11.dex */
public class AlaLiveInfoCoreData extends p implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 5768965545624138312L;
    public transient /* synthetic */ FieldHolder $fh;
    public long audienceCount;
    public long groupID;
    public String hslUrl;
    public String liveCover;
    public long liveID;
    public int liveStatus;
    public String liveTitle;
    public int liveType;
    public String mediaPic;
    public String rtmpUrl;
    public int screenDirection;
    public String sessionID;
    public long threadId;
    public long userID;
    public AlaLiveUserInfoData userInfo;
    public String userName;

    public AlaLiveInfoCoreData() {
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

    public void fillWithInfoData(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, alaInfoData) == null) || alaInfoData == null) {
            return;
        }
        this.liveID = alaInfoData.live_id;
        AlaUserInfoData alaUserInfoData = alaInfoData.user_info;
        if (alaUserInfoData != null) {
            this.userName = alaUserInfoData.user_name;
        }
        if (alaInfoData.user_info != null) {
            if (this.userInfo == null) {
                this.userInfo = new AlaLiveUserInfoData();
            }
            this.userInfo.convertFromAlaUserInfoData(alaInfoData.user_info);
        }
        this.groupID = alaInfoData.group_id;
        this.sessionID = alaInfoData.session_id;
        this.liveTitle = alaInfoData.description;
        this.liveCover = alaInfoData.cover;
        this.rtmpUrl = alaInfoData.rtmp_url;
        this.hslUrl = alaInfoData.hls_url;
        this.audienceCount = alaInfoData.audience_count;
        this.liveType = alaInfoData.live_type;
        this.screenDirection = alaInfoData.screen_direction;
        this.liveStatus = alaInfoData.live_status;
        this.mediaPic = alaInfoData.media_pic;
        this.threadId = alaInfoData.thread_id;
    }

    @Override // c.a.t0.s.r.p
    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    public void parserProtoBuf(AlaLiveInfo alaLiveInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, alaLiveInfo) == null) || alaLiveInfo == null) {
            return;
        }
        this.liveID = alaLiveInfo.live_id.longValue();
        AlaUserInfo alaUserInfo = alaLiveInfo.user_info;
        if (alaUserInfo != null) {
            this.userID = alaUserInfo.ala_id.longValue();
            this.userName = alaLiveInfo.user_info.user_name;
            if (this.userInfo == null) {
                this.userInfo = new AlaLiveUserInfoData();
            }
            this.userInfo.parserProtoBuf(alaLiveInfo.user_info);
        }
        this.groupID = alaLiveInfo.group_id.longValue();
        this.sessionID = alaLiveInfo.session_id;
        this.liveTitle = alaLiveInfo.description;
        this.liveCover = alaLiveInfo.cover;
        this.rtmpUrl = alaLiveInfo.rtmp_url;
        this.hslUrl = alaLiveInfo.hls_url;
        this.audienceCount = alaLiveInfo.audience_count.intValue();
        this.liveType = alaLiveInfo.live_type.intValue();
        this.screenDirection = alaLiveInfo.screen_direction.intValue();
        this.liveStatus = alaLiveInfo.live_status.intValue();
        this.mediaPic = alaLiveInfo.media_pic;
        this.threadId = alaLiveInfo.thread_id.longValue();
    }
}
