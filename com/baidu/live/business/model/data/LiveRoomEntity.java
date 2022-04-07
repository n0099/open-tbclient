package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveRoomEntity implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<LiveRoomEntity> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int audienceCount;
    public int autoPlay;
    public String cmd;
    public String cover;
    public String feedId;
    public String grExt;
    public LiveHostInfo hostInfo;
    public LeftLableInfo leftLabel;
    public int liveStatus;
    public boolean needLogShow;
    public String nid;
    public String playUrl;
    public RightLableInfo rightLabel;
    public String roomId;
    public int showTpl;
    public LiveStatInfo statInfo;
    public int templateId;
    public String title;
    public String videoScreen;

    /* loaded from: classes2.dex */
    public class a implements Parcelable.Creator<LiveRoomEntity> {
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
        public LiveRoomEntity createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new LiveRoomEntity(parcel) : (LiveRoomEntity) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LiveRoomEntity[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new LiveRoomEntity[i] : (LiveRoomEntity[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-405535092, "Lcom/baidu/live/business/model/data/LiveRoomEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-405535092, "Lcom/baidu/live/business/model/data/LiveRoomEntity;");
                return;
            }
        }
        CREATOR = new a();
    }

    public LiveRoomEntity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.needLogShow = true;
    }

    public boolean canAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.autoPlay == 1 && !TextUtils.isEmpty(this.playUrl) : invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isDateLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "7".equals(String.valueOf(this.templateId)) : invokeV.booleanValue;
    }

    public boolean isHorizontalScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "1".equals(this.videoScreen) : invokeV.booleanValue;
    }

    public boolean isYYShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "6".equals(String.valueOf(this.templateId)) : invokeV.booleanValue;
    }

    public void parseSearchJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.nid = jSONObject.optString("nid");
        this.feedId = jSONObject.optString("feed_id");
        this.title = jSONObject.optString("title");
        this.roomId = jSONObject.optString("room_id");
        this.audienceCount = jSONObject.optInt("audience_count");
        this.liveStatus = jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.cover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
        this.cmd = jSONObject.optString("cmd");
        this.showTpl = jSONObject.optInt("show_tpl");
        JSONObject optJSONObject = jSONObject.optJSONObject("host");
        if (optJSONObject != null) {
            LiveHostInfo liveHostInfo = new LiveHostInfo();
            this.hostInfo = liveHostInfo;
            liveHostInfo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("left_label");
        if (optJSONObject2 != null) {
            LeftLableInfo leftLableInfo = new LeftLableInfo();
            this.leftLabel = leftLableInfo;
            leftLableInfo.parserJson(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("right_label");
        if (optJSONObject3 != null) {
            RightLableInfo rightLableInfo = new RightLableInfo();
            this.rightLabel = rightLableInfo;
            rightLableInfo.parserJson(optJSONObject3);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("stat");
        if (optJSONObject4 != null) {
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.statInfo = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("gr_ext");
        if (optJSONObject5 != null) {
            this.grExt = optJSONObject5.toString();
        } else {
            this.grExt = "";
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.nid = jSONObject.optString("nid");
        this.feedId = jSONObject.optString("feed_id");
        this.roomId = jSONObject.optString("room_id");
        this.title = jSONObject.optString("title");
        this.cover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
        this.liveStatus = jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.audienceCount = jSONObject.optInt("audience_count");
        this.cmd = jSONObject.optString("cmd");
        this.showTpl = jSONObject.optInt("show_tpl");
        this.templateId = jSONObject.optInt("template_id");
        this.playUrl = jSONObject.optString("play_url");
        this.autoPlay = jSONObject.optInt("auto_play");
        this.videoScreen = jSONObject.optString("screen");
        JSONObject optJSONObject = jSONObject.optJSONObject("host");
        if (optJSONObject != null) {
            LiveHostInfo liveHostInfo = new LiveHostInfo();
            this.hostInfo = liveHostInfo;
            liveHostInfo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("left_label");
        if (optJSONObject2 != null) {
            LeftLableInfo leftLableInfo = new LeftLableInfo();
            this.leftLabel = leftLableInfo;
            leftLableInfo.parserJson(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("right_label");
        if (optJSONObject3 != null) {
            RightLableInfo rightLableInfo = new RightLableInfo();
            this.rightLabel = rightLableInfo;
            rightLableInfo.parserJson(optJSONObject3);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("stat");
        if (optJSONObject4 != null) {
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.statInfo = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("gr_ext");
        if (optJSONObject5 != null) {
            this.grExt = optJSONObject5.toString();
        } else {
            this.grExt = "";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i) == null) {
            parcel.writeString(this.nid);
            parcel.writeString(this.feedId);
            parcel.writeString(this.roomId);
            parcel.writeString(this.title);
            parcel.writeString(this.cover);
            parcel.writeInt(this.liveStatus);
            parcel.writeInt(this.audienceCount);
            parcel.writeString(this.cmd);
            parcel.writeInt(this.showTpl);
            parcel.writeInt(this.templateId);
            parcel.writeString(this.playUrl);
            parcel.writeInt(this.autoPlay);
            parcel.writeString(this.videoScreen);
            parcel.writeParcelable(this.hostInfo, i);
            parcel.writeParcelable(this.leftLabel, i);
            parcel.writeParcelable(this.rightLabel, i);
            parcel.writeParcelable(this.statInfo, i);
            parcel.writeByte(this.needLogShow ? (byte) 1 : (byte) 0);
            parcel.writeString(this.grExt);
        }
    }

    public LiveRoomEntity(Parcel parcel) {
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
        this.needLogShow = true;
        this.nid = parcel.readString();
        this.feedId = parcel.readString();
        this.roomId = parcel.readString();
        this.title = parcel.readString();
        this.cover = parcel.readString();
        this.liveStatus = parcel.readInt();
        this.audienceCount = parcel.readInt();
        this.cmd = parcel.readString();
        this.showTpl = parcel.readInt();
        this.templateId = parcel.readInt();
        this.playUrl = parcel.readString();
        this.autoPlay = parcel.readInt();
        this.videoScreen = parcel.readString();
        this.hostInfo = (LiveHostInfo) parcel.readParcelable(LiveHostInfo.class.getClassLoader());
        this.leftLabel = (LeftLableInfo) parcel.readParcelable(LeftLableInfo.class.getClassLoader());
        this.rightLabel = (RightLableInfo) parcel.readParcelable(RightLableInfo.class.getClassLoader());
        this.statInfo = (LiveStatInfo) parcel.readParcelable(LiveStatInfo.class.getClassLoader());
        this.needLogShow = parcel.readByte() == 1;
        this.grExt = parcel.readString();
    }
}
