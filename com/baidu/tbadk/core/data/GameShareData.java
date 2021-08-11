package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GameShareData implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<GameShareData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String gameComment;
    public String gameDescription;
    public String gameIconUrl;
    public String gameName;
    public float gameScore;
    public String headBgUrl;
    public String shareQRCodeUrl;
    public String userName;
    public String userPortrait;
    public float userScore;

    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<GameShareData> {
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
        public GameShareData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new GameShareData(parcel) : (GameShareData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GameShareData[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new GameShareData[i2] : (GameShareData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1473429252, "Lcom/baidu/tbadk/core/data/GameShareData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1473429252, "Lcom/baidu/tbadk/core/data/GameShareData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public GameShareData() {
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

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.gameIconUrl = jSONObject.optString("barIconUrl");
        this.gameName = jSONObject.optString("barName");
        this.gameDescription = jSONObject.optString("barDescribe");
        this.gameScore = (float) jSONObject.optDouble("score");
        this.userName = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
        this.userPortrait = jSONObject.optString("avastar");
        this.userScore = (float) jSONObject.optDouble("userScore");
        this.gameComment = jSONObject.optString("content");
        this.shareQRCodeUrl = jSONObject.optString("qrCodeUrl");
        this.headBgUrl = jSONObject.optString("headBgUrl");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i2) == null) {
            parcel.writeString(this.gameIconUrl);
            parcel.writeString(this.gameName);
            parcel.writeString(this.gameDescription);
            parcel.writeFloat(this.gameScore);
            parcel.writeString(this.userName);
            parcel.writeString(this.userPortrait);
            parcel.writeFloat(this.userScore);
            parcel.writeString(this.gameComment);
            parcel.writeString(this.shareQRCodeUrl);
            parcel.writeString(this.headBgUrl);
        }
    }

    public GameShareData(Parcel parcel) {
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
        this.gameIconUrl = parcel.readString();
        this.gameName = parcel.readString();
        this.gameDescription = parcel.readString();
        this.gameScore = parcel.readFloat();
        this.userName = parcel.readString();
        this.userPortrait = parcel.readString();
        this.userScore = parcel.readFloat();
        this.gameComment = parcel.readString();
        this.shareQRCodeUrl = parcel.readString();
        this.headBgUrl = parcel.readString();
    }
}
