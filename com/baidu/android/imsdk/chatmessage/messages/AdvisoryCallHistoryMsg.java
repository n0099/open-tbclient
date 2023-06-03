package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.download.manager.DownloadManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AdvisoryCallHistoryMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<AdvisoryCallHistoryMsg> CREATOR;
    public static final String TAG = "AdvisoryCallHistoryMsg";
    public static final int VIDEO_TYPE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String mFromTips;
    public long mFromUid;
    public int mMediaType;
    public String mRoomId;
    public String mToTips;
    public long mToUid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-463295781, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryCallHistoryMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-463295781, "Lcom/baidu/android/imsdk/chatmessage/messages/AdvisoryCallHistoryMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<AdvisoryCallHistoryMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.AdvisoryCallHistoryMsg.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdvisoryCallHistoryMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new AdvisoryCallHistoryMsg(parcel);
                }
                return (AdvisoryCallHistoryMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AdvisoryCallHistoryMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new AdvisoryCallHistoryMsg[i];
                }
                return (AdvisoryCallHistoryMsg[]) invokeI.objValue;
            }
        };
    }

    public AdvisoryCallHistoryMsg() {
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
        setMsgType(47);
    }

    public String getFromTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mFromTips;
        }
        return (String) invokeV.objValue;
    }

    public long getFromUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mFromUid;
        }
        return invokeV.longValue;
    }

    public int getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mMediaType;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mMediaType == 2) {
                return "[视频通话]";
            }
            return "[音频通话]";
        }
        return (String) invokeV.objValue;
    }

    public String getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mRoomId;
        }
        return (String) invokeV.objValue;
    }

    public String getToTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mToTips;
        }
        return (String) invokeV.objValue;
    }

    public long getToUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mToUid;
        }
        return invokeV.longValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvisoryCallHistoryMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mMediaType = parcel.readInt();
        this.mFromUid = parcel.readLong();
        this.mFromTips = parcel.readString();
        this.mToUid = parcel.readLong();
        this.mToTips = parcel.readString();
        this.mRoomId = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!TextUtils.isEmpty(this.mjsonContent)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mjsonContent);
                    this.mMediaType = jSONObject.optInt(DownloadManager.COLUMN_MEDIA_TYPE);
                    this.mRoomId = jSONObject.optString("room_id");
                    JSONObject optJSONObject = jSONObject.optJSONObject("from");
                    if (optJSONObject != null) {
                        this.mFromUid = optJSONObject.optLong("uid");
                        this.mFromTips = optJSONObject.optString("tips");
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("to");
                    if (optJSONObject2 != null) {
                        this.mToUid = optJSONObject2.optLong("uid");
                        this.mToTips = optJSONObject2.optString("tips");
                    }
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean setJsonContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2.put("uid", this.mFromUid);
                jSONObject2.put("tips", this.mFromTips);
                jSONObject3.put("uid", this.mToUid);
                jSONObject3.put("tips", this.mToTips);
                jSONObject.put(DownloadManager.COLUMN_MEDIA_TYPE, this.mMediaType);
                jSONObject.put("room_id", this.mRoomId);
                jSONObject.put("from", jSONObject2);
                jSONObject.put("to", jSONObject3);
                return setMsgContent(jSONObject.toString());
            } catch (JSONException unused) {
                LogUtils.e(TAG, "content error!");
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setFromTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mFromTips = str;
        }
    }

    public void setFromUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.mFromUid = j;
        }
    }

    public void setMediaType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mMediaType = i;
        }
    }

    public void setRoomId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mRoomId = str;
        }
    }

    public void setToTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mToTips = str;
        }
    }

    public void setToUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.mToUid = j;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mMediaType);
            parcel.writeLong(this.mFromUid);
            parcel.writeString(this.mFromTips);
            parcel.writeLong(this.mToUid);
            parcel.writeString(this.mToTips);
            parcel.writeString(this.mRoomId);
        }
    }
}
