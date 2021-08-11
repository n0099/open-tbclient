package com.baidu.android.imrtc.send;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BIMInviteRtcInfo extends BIMRtcInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<BIMInviteRtcInfo> CREATOR;
    public static final String TAG = "IMInviteRtcInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public List<BIMInviteUser> mInviteUsers;
    public int mMediaType;
    public int mRtcRoomType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-402093932, "Lcom/baidu/android/imrtc/send/BIMInviteRtcInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-402093932, "Lcom/baidu/android/imrtc/send/BIMInviteRtcInfo;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<BIMInviteRtcInfo>() { // from class: com.baidu.android.imrtc.send.BIMInviteRtcInfo.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BIMInviteRtcInfo createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new BIMInviteRtcInfo(parcel) : (BIMInviteRtcInfo) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BIMInviteRtcInfo[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new BIMInviteRtcInfo[i2] : (BIMInviteRtcInfo[]) invokeI.objValue;
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BIMInviteRtcInfo(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mInviteUsers = new ArrayList();
        this.mRtcRoomType = parcel.readInt();
        this.mMediaType = parcel.readInt();
        this.mRtcExt = parcel.readString();
        this.mInviteUsers = parcel.createTypedArrayList(BIMInviteUser.CREATOR);
    }

    public List<BIMInviteUser> getBIMInviteUsers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mInviteUsers : (List) invokeV.objValue;
    }

    public int getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMediaType : invokeV.intValue;
    }

    public int getRtcRoomType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRtcRoomType : invokeV.intValue;
    }

    public void setBIMInviteUsers(@NonNull List<BIMInviteUser> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.mInviteUsers.clear();
            this.mInviteUsers.addAll(list);
        }
    }

    public void setMediaType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mMediaType = i2;
        }
    }

    public void setRtcRoomType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mRtcRoomType = i2;
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i2, String str, String str2) {
        InterceptResult invokeILL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, str, str2)) == null) {
            BIMInviteRtcInfo bIMInviteRtcInfo = new BIMInviteRtcInfo(super.toRtcInfo(i2, str, str2));
            try {
                JSONObject jSONObject = new JSONObject(str2);
                bIMInviteRtcInfo.setMediaType(jSONObject.optInt("media_type"));
                bIMInviteRtcInfo.setRtcRoomType(jSONObject.optInt("rtc_room_type"));
                optJSONArray = jSONObject.optJSONArray("user_list");
            } catch (Exception e2) {
                LogUtils.e("IMInviteRtcInfo", "BIMInviteRtcInfo toRtcInfo Exception ", e2);
            }
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    BIMInviteUser bIMInviteUser = new BIMInviteUser();
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i3);
                    bIMInviteUser.appId = jSONObject2.optLong("appid");
                    bIMInviteUser.uk = jSONObject2.optLong("uk");
                    bIMInviteUser.cuid = jSONObject2.optString("cuid");
                    bIMInviteUser.thirdUserId = jSONObject2.optString("third_userid");
                    bIMInviteUser.appVersion = jSONObject2.optString("app_version");
                    arrayList.add(bIMInviteUser);
                }
                bIMInviteRtcInfo.setBIMInviteUsers(arrayList);
                return bIMInviteRtcInfo;
            }
            return bIMInviteRtcInfo;
        }
        return (BIMRtcInfo) invokeILL.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
                jSONObject.put("rtc_appid", RtcUtility.getRtcAppId(this.mContext));
                jSONObject.put(RtcUtility.KEY_RTC_ROOM_TOKEN, RtcUtility.getRtcRoomToken(this.mContext));
                jSONObject.put(RtcUtility.KEY_RTC_ROOM_NAME, RtcUtility.getRtcRoomName(this.mContext));
                jSONObject.put("rtc_room_desc", RtcUtility.getRtcRoomDes(this.mContext));
                jSONObject.put("rtc_room_type", this.mRtcRoomType);
                jSONObject.put("media_type", this.mMediaType);
                JSONArray jSONArray = new JSONArray();
                for (BIMInviteUser bIMInviteUser : this.mInviteUsers) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("appid", bIMInviteUser.appId);
                    jSONObject2.put("uk", bIMInviteUser.uk);
                    jSONObject2.put("cuid", bIMInviteUser.cuid);
                    jSONObject2.put("third_userid", IMJni.transBDUID(bIMInviteUser.thirdUserId));
                    jSONObject2.put("app_version", bIMInviteUser.appVersion);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("user_list", jSONArray);
                LogUtils.d("IMInviteRtcInfo", "IMInviteRtcInfo :" + jSONObject.toString());
                return jSONObject.toString();
            } catch (Exception e2) {
                LogUtils.e("IMInviteRtcInfo", "IMInviteRtcInfo Exception ", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "BIMInviteRtcInfo{" + super.toString() + ", mRtcRoomType=" + this.mRtcRoomType + ", mMediaType=" + this.mMediaType + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.mRtcRoomType);
            parcel.writeInt(this.mMediaType);
            parcel.writeString(this.mRtcExt);
            parcel.writeTypedList(this.mInviteUsers);
        }
    }

    /* loaded from: classes4.dex */
    public static class BIMInviteUser implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<BIMInviteUser> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public long appId;
        public String appVersion;
        public String cuid;
        public String thirdUserId;
        public long uk;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1121128766, "Lcom/baidu/android/imrtc/send/BIMInviteRtcInfo$BIMInviteUser;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1121128766, "Lcom/baidu/android/imrtc/send/BIMInviteRtcInfo$BIMInviteUser;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<BIMInviteUser>() { // from class: com.baidu.android.imrtc.send.BIMInviteRtcInfo.BIMInviteUser.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public BIMInviteUser createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new BIMInviteUser(parcel) : (BIMInviteUser) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public BIMInviteUser[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new BIMInviteUser[i2] : (BIMInviteUser[]) invokeI.objValue;
                }
            };
        }

        public BIMInviteUser(Parcel parcel) {
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
            this.appId = parcel.readLong();
            this.uk = parcel.readLong();
            this.cuid = parcel.readString();
            this.thirdUserId = parcel.readString();
            this.appVersion = parcel.readString();
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

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
                parcel.writeLong(this.appId);
                parcel.writeLong(this.uk);
                parcel.writeString(this.cuid);
                parcel.writeString(this.thirdUserId);
                parcel.writeString(this.appVersion);
            }
        }

        public BIMInviteUser() {
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
    }

    public BIMInviteRtcInfo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mInviteUsers = new ArrayList();
        this.mContext = context;
    }

    public BIMInviteRtcInfo(BIMRtcInfo bIMRtcInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bIMRtcInfo};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mInviteUsers = new ArrayList();
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }
}
