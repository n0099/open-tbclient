package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class FansGroupAtMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<FansGroupAtMsg> CREATOR;
    public static final String TAG = "FansGroupAtMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<AtData> mAtDataList;
    public String mText;

    /* loaded from: classes6.dex */
    public static class AtData implements Parcelable, NoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<AtData> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String mAtText;
        public String mAtType;
        public String mAtUser;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1889588859, "Lcom/baidu/android/imsdk/chatmessage/messages/FansGroupAtMsg$AtData;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1889588859, "Lcom/baidu/android/imsdk/chatmessage/messages/FansGroupAtMsg$AtData;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<AtData>() { // from class: com.baidu.android.imsdk.chatmessage.messages.FansGroupAtMsg.AtData.1
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
                public AtData createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new AtData(parcel) : (AtData) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public AtData[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new AtData[i2] : (AtData[]) invokeI.objValue;
                }
            };
        }

        public AtData() {
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

        public String getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAtText : (String) invokeV.objValue;
        }

        public String getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAtType : (String) invokeV.objValue;
        }

        public String getUser() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAtUser : (String) invokeV.objValue;
        }

        public void setText(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.mAtText = str;
            }
        }

        public void setType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.mAtType = str;
            }
        }

        public void setUser(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.mAtUser = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i2) == null) {
                parcel.writeString(this.mAtType);
                parcel.writeString(this.mAtUser);
                parcel.writeString(this.mAtText);
            }
        }

        public AtData(Parcel parcel) {
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
            this.mAtType = parcel.readString();
            this.mAtUser = parcel.readString();
            this.mAtText = parcel.readString();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1729441360, "Lcom/baidu/android/imsdk/chatmessage/messages/FansGroupAtMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1729441360, "Lcom/baidu/android/imsdk/chatmessage/messages/FansGroupAtMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<FansGroupAtMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.FansGroupAtMsg.1
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
            public FansGroupAtMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new FansGroupAtMsg(parcel) : (FansGroupAtMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public FansGroupAtMsg[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new FansGroupAtMsg[i2] : (FansGroupAtMsg[]) invokeI.objValue;
            }
        };
    }

    public FansGroupAtMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mText = "";
        setMsgType(40);
        setCategory(1);
        setChatType(57);
    }

    public ArrayList<AtData> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAtDataList : (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mText : (String) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mText : (String) invokeV.objValue;
    }

    public boolean isGroupAtUserById(String str) {
        InterceptResult invokeL;
        ArrayList<AtData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!isMsgRead() && (arrayList = this.mAtDataList) != null && arrayList.size() != 0 && !TextUtils.isEmpty(str)) {
                Iterator<AtData> it = this.mAtDataList.iterator();
                while (it.hasNext()) {
                    AtData next = it.next();
                    String type = next.getType();
                    String user = next.getUser();
                    LogUtils.d(TAG, "userId: " + str + ", atData_user: " + user);
                    if (TextUtils.equals(type, IMConstants.AT_DATA_TYPE_GROUP_ALL)) {
                        return true;
                    }
                    if (TextUtils.equals(type, IMConstants.AT_DATA_TYPE_USER) && TextUtils.equals(user, str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String jsonContent = getJsonContent();
            if (TextUtils.isEmpty(jsonContent)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(jsonContent);
                this.mText = jSONObject.optString("text");
                JSONArray optJSONArray = jSONObject.optJSONArray("at_data");
                int length = optJSONArray.length();
                if (length > 0) {
                    this.mAtDataList = new ArrayList<>(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        String optString = jSONObject2.optString("at_type", "");
                        String optString2 = jSONObject2.optString("at_user", "");
                        String optString3 = jSONObject2.optString("text", "");
                        AtData atData = new AtData();
                        atData.setType(optString);
                        atData.setUser(optString2);
                        atData.setText(optString3);
                        this.mAtDataList.add(atData);
                        LogUtils.d(TAG, "at data " + i2 + " type: " + optString + ", user: " + optString2 + ", text: " + optString3);
                    }
                }
                return true;
            } catch (JSONException e2) {
                LogUtils.e(TAG, "parse json err!", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void setDataList(ArrayList<AtData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.mAtDataList = arrayList;
        }
    }

    public boolean setJsonContent(String str, ArrayList<AtData> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, arrayList)) == null) {
            if (TextUtils.isEmpty(str) || arrayList == null) {
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("text", str);
                JSONArray jSONArray = new JSONArray();
                if (arrayList.size() > 0) {
                    Iterator<AtData> it = arrayList.iterator();
                    while (it.hasNext()) {
                        AtData next = it.next();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("at_type", next.getType());
                        jSONObject2.put("at_user", next.getUser());
                        jSONObject2.put("text", next.getText());
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("at_data", jSONArray);
                return setMsgContent(jSONObject.toString());
            } catch (Exception unused) {
                LogUtils.e(TAG, "content error!");
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mText = str;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.mText);
            ArrayList<AtData> arrayList = this.mAtDataList;
            int size = arrayList != null ? arrayList.size() : 0;
            parcel.writeInt(size);
            if (size > 0) {
                parcel.writeTypedList(this.mAtDataList);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FansGroupAtMsg(Parcel parcel) {
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
        this.mText = "";
        this.mText = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            ArrayList<AtData> arrayList = new ArrayList<>(readInt);
            this.mAtDataList = arrayList;
            parcel.readTypedList(arrayList, AtData.CREATOR);
        }
    }
}
