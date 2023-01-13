package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tieba.ms4;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.AlaStageDislikeInfo;
/* loaded from: classes3.dex */
public class AlaInfoData implements Serializable, Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<AlaInfoData> CREATOR;
    public static final int FRS_STAGE_TYPE_AD = 0;
    public static final int FRS_STAGE_TYPE_COMMON = 1;
    public static final int LIVE_STATUS_LIVE_ON = 1;
    public static final int LIVE_STATUS_RECORD = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String appId;
    public int audience_count;
    public String cover;
    public String description;
    public transient SparseArray<String> dislikeInfo;
    public double distance;
    public int duration;
    public String forumUserLiveMsg;
    public String friendRoomName;
    public int friendRoomStatus;
    public int frsLiveStageType;
    public long group_id;
    public boolean haveRedpkg;
    public String hls_url;
    public boolean isChushou;
    public transient ms4 label;
    public String label_name;
    public boolean liveStageForceTop;
    public String liveStagePicUrl;
    public long live_id;
    public int live_status;
    public int live_type;
    public transient AlaChallengeInfoData mChallengeInfoData;
    public String mCoverWide;
    public YyExtData mYyExtData;
    public String media_id;
    public String media_pic;
    public String media_subtitle;
    public String media_url;
    public int openRecomDuration;
    public int openRecomFans;
    public int openRecomLocation;
    public int openRecomReason;
    public String recomReason;
    public long roomId;
    public String routeType;
    public String rtmp_url;
    public int screen_direction;
    public String session_id;
    public transient AlaShareInfoData share_info;
    public String tag;
    public String thirdLiveType;
    public String thirdRoomId;
    public long thread_id;
    public transient AlaUserInfoData user_info;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<AlaInfoData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AlaInfoData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new AlaInfoData(parcel);
            }
            return (AlaInfoData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AlaInfoData[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new AlaInfoData[i];
            }
            return (AlaInfoData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1851477755, "Lcom/baidu/tbadk/core/data/AlaInfoData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1851477755, "Lcom/baidu/tbadk/core/data/AlaInfoData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public AlaInfoData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean isLegalYYLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            YyExtData yyExtData = this.mYyExtData;
            if (yyExtData != null && !yi.isEmpty(yyExtData.mSid) && !yi.isEmpty(this.mYyExtData.mSsid)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isVertialLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.screen_direction == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public AlaInfoData(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.live_id = parcel.readLong();
        this.live_status = parcel.readInt();
        this.mYyExtData = (YyExtData) parcel.readParcelable(YyExtData.class.getClassLoader());
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            this.live_id = jSONObject.optLong("live_id");
            this.cover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            this.session_id = jSONObject.optString("session_id");
            this.rtmp_url = jSONObject.optString("rtmp_url");
            this.hls_url = jSONObject.optString("hls_url");
            this.group_id = jSONObject.optLong("group_id");
            this.media_url = jSONObject.optString("media_url");
            this.media_pic = jSONObject.optString("media_pic");
            this.media_id = jSONObject.optString("media_id");
            this.media_subtitle = jSONObject.optString("media_subtitle");
            this.description = jSONObject.optString("description");
            AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
            this.user_info = alaUserInfoData;
            alaUserInfoData.parserJson(jSONObject.optJSONObject("user_info"));
            AlaShareInfoData alaShareInfoData = new AlaShareInfoData();
            this.share_info = alaShareInfoData;
            alaShareInfoData.parserJson(jSONObject.optJSONObject("share_info"));
            this.live_status = jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
            this.duration = jSONObject.optInt("duration");
            this.audience_count = jSONObject.optInt("audience_count");
            this.live_type = jSONObject.optInt("live_type");
            this.screen_direction = jSONObject.optInt("screen_direction");
            this.label_name = jSONObject.optString("label_name");
            this.distance = jSONObject.optDouble("distance");
            this.appId = jSONObject.optString("third_app_id");
            this.thread_id = jSONObject.optLong("thread_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("label");
            if (optJSONObject != null) {
                ms4 ms4Var = new ms4();
                this.label = ms4Var;
                ms4Var.a(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("stage_dislike_info");
            boolean z = false;
            if (optJSONArray != null) {
                if (this.dislikeInfo == null) {
                    this.dislikeInfo = new SparseArray<>();
                }
                this.dislikeInfo.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (optJSONArray.optJSONObject(i) != null) {
                        this.dislikeInfo.put(jSONObject.optInt("dislike_id"), jSONObject.optString("dislike_reason"));
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("challenge_info");
            if (optJSONObject2 != null) {
                AlaChallengeInfoData alaChallengeInfoData = new AlaChallengeInfoData();
                this.mChallengeInfoData = alaChallengeInfoData;
                alaChallengeInfoData.parserJson(optJSONObject2);
            }
            this.frsLiveStageType = jSONObject.optInt("frs_toplive_type");
            this.liveStagePicUrl = jSONObject.optString("frs_toplive_pic");
            if (jSONObject.optInt("frs_toplive_force", 0) == 1) {
                z = true;
            }
            this.liveStageForceTop = z;
            this.haveRedpkg = "1".equals(jSONObject.optString("red_packet", ""));
            this.isChushou = "1".equals(jSONObject.optString("live_from", ""));
            this.thirdLiveType = jSONObject.optString("third_live_type");
            this.thirdRoomId = jSONObject.optString("third_room_id", "");
            this.routeType = jSONObject.optString("router_type", "");
            this.tag = jSONObject.optString("tag");
            this.recomReason = jSONObject.optString("recom_reason");
            this.openRecomReason = jSONObject.optInt("open_recom_reason");
            this.openRecomLocation = jSONObject.optInt("open_recom_location");
            this.openRecomFans = jSONObject.optInt("open_recom_fans");
            this.openRecomDuration = jSONObject.optInt("open_recom_duration");
            this.roomId = jSONObject.optLong("room_id");
            this.friendRoomStatus = jSONObject.optInt("room_status");
            this.friendRoomName = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
            this.forumUserLiveMsg = jSONObject.optString("forum_user_live_msg");
            this.mCoverWide = jSONObject.optString("cover_wide");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("yy_ext");
            if (optJSONObject3 != null) {
                YyExtData yyExtData = new YyExtData();
                this.mYyExtData = yyExtData;
                yyExtData.parserJson(optJSONObject3);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserProtobuf(AlaLiveInfo alaLiveInfo) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, alaLiveInfo) != null) || alaLiveInfo == null) {
            return;
        }
        try {
            this.live_id = alaLiveInfo.live_id.longValue();
            this.cover = alaLiveInfo.cover;
            this.session_id = alaLiveInfo.session_id;
            this.rtmp_url = alaLiveInfo.rtmp_url;
            this.hls_url = alaLiveInfo.hls_url;
            this.group_id = alaLiveInfo.group_id.longValue();
            this.media_url = alaLiveInfo.media_url;
            this.media_pic = alaLiveInfo.media_pic;
            this.media_id = alaLiveInfo.media_id;
            this.media_subtitle = alaLiveInfo.media_subtitle;
            this.description = alaLiveInfo.description;
            AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
            this.user_info = alaUserInfoData;
            alaUserInfoData.parserProtobuf(alaLiveInfo.user_info);
            AlaShareInfoData alaShareInfoData = new AlaShareInfoData();
            this.share_info = alaShareInfoData;
            alaShareInfoData.G(alaLiveInfo.share_info);
            this.live_status = alaLiveInfo.live_status.intValue();
            this.duration = alaLiveInfo.duration.intValue();
            this.audience_count = alaLiveInfo.audience_count.intValue();
            this.live_type = alaLiveInfo.live_type.intValue();
            this.screen_direction = alaLiveInfo.screen_direction.intValue();
            this.label_name = alaLiveInfo.label_name;
            this.distance = alaLiveInfo.distance.longValue();
            this.appId = alaLiveInfo.third_app_id;
            this.thread_id = alaLiveInfo.thread_id.longValue();
            boolean z2 = false;
            if (alaLiveInfo.stage_dislike_info != null) {
                if (this.dislikeInfo == null) {
                    this.dislikeInfo = new SparseArray<>();
                }
                this.dislikeInfo.clear();
                for (int i = 0; i < alaLiveInfo.stage_dislike_info.size(); i++) {
                    AlaStageDislikeInfo alaStageDislikeInfo = alaLiveInfo.stage_dislike_info.get(i);
                    if (alaStageDislikeInfo != null) {
                        this.dislikeInfo.put(alaStageDislikeInfo.dislike_id.intValue(), alaStageDislikeInfo.dislike_reason);
                    }
                }
            }
            AlaChallengeInfoData alaChallengeInfoData = new AlaChallengeInfoData();
            this.mChallengeInfoData = alaChallengeInfoData;
            alaChallengeInfoData.parserProtobuf(alaLiveInfo.challenge_info);
            this.frsLiveStageType = alaLiveInfo.frs_toplive_type.intValue();
            this.liveStagePicUrl = alaLiveInfo.frs_toplive_pic;
            if (alaLiveInfo.frs_toplive_force.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.liveStageForceTop = z;
            if (alaLiveInfo.live_from.intValue() == 1) {
                z2 = true;
            }
            this.isChushou = z2;
            this.thirdLiveType = alaLiveInfo.third_live_type;
            this.thirdRoomId = alaLiveInfo.third_room_id;
            this.routeType = alaLiveInfo.router_type;
            this.recomReason = alaLiveInfo.recom_reason;
            this.openRecomReason = alaLiveInfo.open_recom_reason.intValue();
            this.openRecomLocation = alaLiveInfo.open_recom_location.intValue();
            this.openRecomFans = alaLiveInfo.open_recom_fans.intValue();
            this.openRecomDuration = alaLiveInfo.open_recom_duration.intValue();
            this.roomId = alaLiveInfo.room_id.longValue();
            this.friendRoomStatus = alaLiveInfo.room_status.intValue();
            this.friendRoomName = alaLiveInfo.room_name;
            this.forumUserLiveMsg = alaLiveInfo.forum_user_live_msg;
            this.mCoverWide = alaLiveInfo.cover_wide;
            if (alaLiveInfo.yy_ext != null) {
                YyExtData yyExtData = new YyExtData();
                this.mYyExtData = yyExtData;
                yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, parcel, i) == null) {
            parcel.writeLong(this.live_id);
            parcel.writeInt(this.live_status);
            parcel.writeParcelable(this.mYyExtData, i);
        }
    }
}
