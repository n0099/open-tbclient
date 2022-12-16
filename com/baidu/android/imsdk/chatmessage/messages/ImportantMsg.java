package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.important.ImportantBottom;
import com.baidu.android.imsdk.chatmessage.messages.important.ImportantEntity;
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
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImportantMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<ImportantMsg> CREATOR;
    public static final String TAG = "ImportantMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAdditionTitle;
    public ImportantBottom mBottom;
    public String mDescription;
    public ArrayList<ImportantEntity> mEntities;
    public String mTitle;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(84275104, "Lcom/baidu/android/imsdk/chatmessage/messages/ImportantMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(84275104, "Lcom/baidu/android/imsdk/chatmessage/messages/ImportantMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<ImportantMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.ImportantMsg.1
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
            public ImportantMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new ImportantMsg(parcel);
                }
                return (ImportantMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ImportantMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new ImportantMsg[i];
                }
                return (ImportantMsg[]) invokeI.objValue;
            }
        };
    }

    public String getAdditionTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAdditionTitle;
        }
        return (String) invokeV.objValue;
    }

    public ImportantBottom getBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBottom;
        }
        return (ImportantBottom) invokeV.objValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mDescription;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<ImportantEntity> getEntities() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mEntities;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public ImportantMsg() {
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
        this.mTitle = "你有一条新消息";
        this.mAdditionTitle = "";
        this.mEntities = null;
        this.mDescription = "";
        this.mBottom = null;
        setMsgType(57);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportantMsg(Parcel parcel) {
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
        this.mTitle = "你有一条新消息";
        this.mAdditionTitle = "";
        this.mEntities = null;
        this.mDescription = "";
        this.mBottom = null;
        this.mTitle = parcel.readString();
        this.mAdditionTitle = parcel.readString();
        this.mEntities = parcel.createTypedArrayList(ImportantEntity.CREATOR);
        this.mDescription = parcel.readString();
        this.mBottom = (ImportantBottom) parcel.readParcelable(ImportantBottom.class.getClassLoader());
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mAdditionTitle);
            parcel.writeTypedList(this.mEntities);
            parcel.writeString(this.mDescription);
            parcel.writeParcelable(this.mBottom, i);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String jsonContent = getJsonContent();
            if (TextUtils.isEmpty(jsonContent)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(jsonContent);
                String optString = jSONObject.optString("title");
                this.mTitle = optString;
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                this.mAdditionTitle = jSONObject.optString("addition_title");
                JSONArray optJSONArray = jSONObject.optJSONArray("entities");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.mEntities = new ArrayList<>();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null) {
                            ImportantEntity importantEntity = new ImportantEntity();
                            int optInt = jSONObject2.optInt("entity_type");
                            String optString2 = jSONObject2.optString("sub_title");
                            String optString3 = jSONObject2.optString("sub_title_link");
                            String optString4 = jSONObject2.optString("sub_description");
                            if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2)) {
                                importantEntity.mType = optInt;
                                importantEntity.mSubTitle = optString2;
                                importantEntity.mSubTitleLink = optString3;
                                importantEntity.mSubDescription = optString4;
                                this.mEntities.add(importantEntity);
                            }
                        }
                    }
                }
                this.mDescription = jSONObject.optString("description");
                JSONObject optJSONObject = jSONObject.optJSONObject("bottom");
                if (optJSONObject != null) {
                    String optString5 = optJSONObject.optString("desc");
                    String optString6 = optJSONObject.optString("link");
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                        ImportantBottom importantBottom = new ImportantBottom();
                        this.mBottom = importantBottom;
                        importantBottom.mBottomDesc = optString5;
                        importantBottom.mBottomLink = optString6;
                    }
                }
                return true;
            } catch (Exception e) {
                LogUtils.e(TAG, "parse json err!", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
