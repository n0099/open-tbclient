package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes5.dex */
public class YyExtData implements Serializable, Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<YyExtData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isYyGame;
    public String liveId;
    public String mIconUrl;
    public String mRankShow;
    public String mSid;
    public String mSsid;
    public String mTemplateId;
    public String mYyUid;
    public String streamInfo;

    /* loaded from: classes5.dex */
    public static class a implements Parcelable.Creator<YyExtData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public YyExtData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new YyExtData(parcel) : (YyExtData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public YyExtData[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new YyExtData[i2] : (YyExtData[]) invokeI.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void parseProtoBuf(YyExt yyExt) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yyExt) == null) || yyExt == null) {
            return;
        }
        this.mSid = yyExt.sid;
        this.mSsid = yyExt.ssid;
        this.mTemplateId = yyExt.template_id;
        this.mYyUid = yyExt.yy_uid;
        this.isYyGame = yyExt.is_yy_game.intValue() == 1;
        this.mRankShow = yyExt.rank_show;
        this.mIconUrl = yyExt.icon_url;
        this.streamInfo = yyExt.stream_info;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.mSid = jSONObject.optString("sid");
        this.mSsid = jSONObject.optString("ssid");
        this.mTemplateId = jSONObject.optString("template_id");
        this.mYyUid = jSONObject.optString("yy_uid");
        this.isYyGame = jSONObject.optInt("is_yy_game") == 1;
        this.mRankShow = jSONObject.optString("rank_show");
        this.mIconUrl = jSONObject.optString("icon_url");
        this.streamInfo = jSONObject.optString("stream_info");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i2) == null) {
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

    public YyExtData(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
