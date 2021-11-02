package com.baidu.android.imsdk.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBManualMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class QuickReply implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<QuickReply> CREATOR;
    public static final int MENU_TYPE = 1;
    public static final String TAG = "QuickReply";
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ReplyContent> mButtonList;
    public String mMenuName;
    public long mPaId;
    public String mPaName;
    public long mRefreshTime;
    public long mStatus;
    public long mTimeStamp;
    public long mType;
    public long mVersionId;

    /* loaded from: classes6.dex */
    public static class Act implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<Act> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String mCallBackKey;
        public int mIsCallBack;
        public int mType;
        public String mValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1889368952, "Lcom/baidu/android/imsdk/pubaccount/QuickReply$Act;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1889368952, "Lcom/baidu/android/imsdk/pubaccount/QuickReply$Act;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<Act>() { // from class: com.baidu.android.imsdk.pubaccount.QuickReply.Act.1
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
                public Act createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new Act(parcel) : (Act) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Act[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new Act[i2] : (Act[]) invokeI.objValue;
                }
            };
        }

        public Act() {
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

        public String getCallBackKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCallBackKey : (String) invokeV.objValue;
        }

        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mType : invokeV.intValue;
        }

        public String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mValue : (String) invokeV.objValue;
        }

        public int isCallBack() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mIsCallBack : invokeV.intValue;
        }

        public void setCallBack(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                this.mIsCallBack = i2;
            }
        }

        public void setCallBackKey(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.mCallBackKey = str;
            }
        }

        public void setType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                this.mType = i2;
            }
        }

        public void setValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.mValue = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i2) == null) {
                parcel.writeInt(this.mType);
                parcel.writeString(this.mValue);
                parcel.writeInt(this.mIsCallBack);
                parcel.writeString(this.mCallBackKey);
            }
        }

        public Act(Parcel parcel) {
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
            this.mType = parcel.readInt();
            this.mValue = parcel.readString();
            this.mIsCallBack = parcel.readInt();
            this.mCallBackKey = parcel.readString();
        }
    }

    /* loaded from: classes6.dex */
    public static class ReplyContent implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<ReplyContent> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public Act mAct;
        public String mName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(113162045, "Lcom/baidu/android/imsdk/pubaccount/QuickReply$ReplyContent;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(113162045, "Lcom/baidu/android/imsdk/pubaccount/QuickReply$ReplyContent;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<ReplyContent>() { // from class: com.baidu.android.imsdk.pubaccount.QuickReply.ReplyContent.1
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
                public ReplyContent createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new ReplyContent(parcel) : (ReplyContent) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ReplyContent[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new ReplyContent[i2] : (ReplyContent[]) invokeI.objValue;
                }
            };
        }

        public ReplyContent() {
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

        public Act getAct() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAct : (Act) invokeV.objValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mName : (String) invokeV.objValue;
        }

        public void setAct(Act act) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, act) == null) {
                this.mAct = act;
            }
        }

        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.mName = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, parcel, i2) == null) {
                parcel.writeString(this.mName);
                parcel.writeParcelable(this.mAct, i2);
            }
        }

        public ReplyContent(Parcel parcel) {
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
            this.mName = parcel.readString();
            this.mAct = (Act) parcel.readParcelable(Act.class.getClassLoader());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1443595002, "Lcom/baidu/android/imsdk/pubaccount/QuickReply;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1443595002, "Lcom/baidu/android/imsdk/pubaccount/QuickReply;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<QuickReply>() { // from class: com.baidu.android.imsdk.pubaccount.QuickReply.1
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
            public QuickReply createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new QuickReply(parcel) : (QuickReply) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public QuickReply[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new QuickReply[i2] : (QuickReply[]) invokeI.objValue;
            }
        };
    }

    public QuickReply() {
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

    public static QuickReply createQuickReply(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            QuickReply quickReply = new QuickReply();
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("custom_menu");
                quickReply.setType(jSONObject.optInt("type"));
                quickReply.setVersionId(jSONObject.getLong("version_id"));
                quickReply.setPaId(jSONObject.getLong("pa_uid"));
                quickReply.setStatus(jSONObject.getLong("status"));
                quickReply.setTimeStamp(jSONObject.getLong("ts"));
                quickReply.setRefreshTime(jSONObject.getLong("menu_refresh_ts"));
                quickReply.setMenuName(jSONObject.getString("name"));
                quickReply.setPaName(jSONObject.optString("src"));
                JSONArray jSONArray = jSONObject.getJSONArray("button_list");
                ArrayList<ReplyContent> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    ReplyContent replyContent = new ReplyContent();
                    replyContent.setName(jSONObject2.getString("name"));
                    if (jSONObject2.has("act")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("act");
                        Act act = new Act();
                        act.setType(jSONObject3.getInt("act_type"));
                        act.setValue(jSONObject3.getString("value"));
                        act.setCallBack(jSONObject3.getInt("is_callback"));
                        act.setCallBackKey(jSONObject3.getString(DuPaBManualMsg.B_CALLBACK_KEY));
                        replyContent.setAct(act);
                    }
                    arrayList.add(replyContent);
                }
                quickReply.setButtonList(arrayList);
                return quickReply;
            } catch (JSONException e2) {
                LogUtils.e(TAG, "create quickReply error " + e2.getMessage());
                return null;
            }
        }
        return (QuickReply) invokeL.objValue;
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

    public ArrayList<ReplyContent> getButtonList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mButtonList : (ArrayList) invokeV.objValue;
    }

    public String getMenuName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMenuName : (String) invokeV.objValue;
    }

    public long getPaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPaId : invokeV.longValue;
    }

    public String getPaName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPaName : (String) invokeV.objValue;
    }

    public long getRefreshTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRefreshTime : invokeV.longValue;
    }

    public long getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mStatus : invokeV.longValue;
    }

    public long getTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mTimeStamp : invokeV.longValue;
    }

    public long getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mType : invokeV.longValue;
    }

    public long getVersionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mVersionId : invokeV.longValue;
    }

    public void setButtonList(ArrayList<ReplyContent> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.mButtonList = arrayList;
        }
    }

    public void setMenuName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mMenuName = str;
        }
    }

    public void setPaId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.mPaId = j;
        }
    }

    public void setPaName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mPaName = str;
        }
    }

    public void setRefreshTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.mRefreshTime = j;
        }
    }

    public void setStatus(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.mStatus = j;
        }
    }

    public void setTimeStamp(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.mTimeStamp = j;
        }
    }

    public void setType(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.mType = j;
        }
    }

    public void setVersionId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.mVersionId = j;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, parcel, i2) == null) {
            parcel.writeLong(this.mType);
            parcel.writeLong(this.mVersionId);
            parcel.writeLong(this.mPaId);
            parcel.writeLong(this.mStatus);
            parcel.writeLong(this.mTimeStamp);
            parcel.writeLong(this.mRefreshTime);
            parcel.writeString(this.mMenuName);
            parcel.writeString(this.mPaName);
            parcel.writeTypedList(this.mButtonList);
        }
    }

    public QuickReply(Parcel parcel) {
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
        this.mType = parcel.readLong();
        this.mVersionId = parcel.readLong();
        this.mPaId = parcel.readLong();
        this.mStatus = parcel.readLong();
        this.mTimeStamp = parcel.readLong();
        this.mRefreshTime = parcel.readLong();
        this.mMenuName = parcel.readString();
        this.mPaName = parcel.readString();
        this.mButtonList = parcel.createTypedArrayList(ReplyContent.CREATOR);
    }
}
