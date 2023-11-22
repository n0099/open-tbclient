package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.YyExt;
/* loaded from: classes4.dex */
public class YyExtData implements Serializable, Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<YyExtData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String feedId;
    public boolean isYyGame;
    public String liveId;
    public String mIconUrl;
    public String mRankShow;
    public String mSid;
    public String mSsid;
    public String mTemplateId;
    public String mYyUid;
    public String streamInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<YyExtData> {
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
        public YyExtData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new YyExtData(parcel);
            }
            return (YyExtData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public YyExtData[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new YyExtData[i];
            }
            return (YyExtData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(610856360, "Lcom/baidu/tbadk/core/data/YyExtData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(610856360, "Lcom/baidu/tbadk/core/data/YyExtData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public YyExtData() {
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

    public YyExtData(Parcel parcel) {
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
        this.mSid = parcel.readString();
        this.mSsid = parcel.readString();
        this.mTemplateId = parcel.readString();
        this.mYyUid = parcel.readString();
        this.isYyGame = parcel.readByte() == 1;
        this.mRankShow = parcel.readString();
        this.mIconUrl = parcel.readString();
        this.streamInfo = parcel.readString();
    }

    public void parseProtoBuf(YyExt yyExt) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yyExt) != null) || yyExt == null) {
            return;
        }
        this.mSid = yyExt.sid;
        this.mSsid = yyExt.ssid;
        this.mTemplateId = yyExt.template_id;
        this.mYyUid = yyExt.yy_uid;
        boolean z = true;
        if (yyExt.is_yy_game.intValue() != 1) {
            z = false;
        }
        this.isYyGame = z;
        this.mRankShow = yyExt.rank_show;
        this.mIconUrl = yyExt.icon_url;
        this.streamInfo = yyExt.stream_info;
        this.feedId = yyExt.feed_id;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.mSid = jSONObject.optString("sid");
        this.mSsid = jSONObject.optString(YyLiveRoomConfig.KEY_SSID);
        this.mTemplateId = jSONObject.optString("template_id");
        this.mYyUid = jSONObject.optString("yy_uid");
        boolean z = true;
        if (jSONObject.optInt("is_yy_game") != 1) {
            z = false;
        }
        this.isYyGame = z;
        this.mRankShow = jSONObject.optString("rank_show");
        this.mIconUrl = jSONObject.optString("icon_url");
        this.streamInfo = jSONObject.optString("stream_info");
        this.feedId = jSONObject.optString("feed_id");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
            parcel.writeString(this.mSid);
            parcel.writeString(this.mSsid);
            parcel.writeString(this.mTemplateId);
            parcel.writeString(this.mYyUid);
            parcel.writeByte(this.isYyGame ? (byte) 1 : (byte) 0);
            parcel.writeString(this.mRankShow);
            parcel.writeString(this.mIconUrl);
            parcel.writeString(this.streamInfo);
        }
    }
}
