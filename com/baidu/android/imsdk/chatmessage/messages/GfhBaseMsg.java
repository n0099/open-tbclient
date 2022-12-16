package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.text.TextUtils;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhHeader;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhKeyValue;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhLink;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhOperation;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class GfhBaseMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GfhHeader header;
    public String hints;
    public List<GfhKeyValue> keys;
    public List<GfhLink> links;
    public List<GfhOperation> operate;
    public String text;
    public String url;

    public abstract void parseSpecificJson(JSONObject jSONObject);

    public GfhBaseMsg() {
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

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GfhBaseMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.url = parcel.readString();
        this.header = (GfhHeader) parcel.readParcelable(GfhHeader.class.getClassLoader());
        this.operate = parcel.createTypedArrayList(GfhOperation.CREATOR);
        this.text = parcel.readString();
        this.keys = parcel.createTypedArrayList(GfhKeyValue.CREATOR);
        this.hints = parcel.readString();
        this.links = parcel.createTypedArrayList(GfhLink.CREATOR);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.mjsonContent)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.mjsonContent);
                JSONObject optJSONObject = jSONObject.optJSONObject("header");
                if (optJSONObject != null) {
                    GfhHeader gfhHeader = new GfhHeader();
                    this.header = gfhHeader;
                    gfhHeader.logo = optJSONObject.optString("logo");
                    this.header.name = optJSONObject.optString("name");
                    this.header.desc = optJSONObject.optString("desc");
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("operate");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.operate = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null) {
                            GfhOperation gfhOperation = new GfhOperation();
                            gfhOperation.type = jSONObject2.optInt("type");
                            this.operate.add(gfhOperation);
                        }
                    }
                }
                this.text = jSONObject.optString("text");
                JSONArray optJSONArray2 = jSONObject.optJSONArray(SavedStateHandle.KEYS);
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.keys = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = (JSONObject) optJSONArray2.opt(i2);
                        if (jSONObject3 != null) {
                            GfhKeyValue gfhKeyValue = new GfhKeyValue();
                            gfhKeyValue.title = jSONObject3.optString("title");
                            gfhKeyValue.value = jSONObject3.optString("value");
                            gfhKeyValue.type = jSONObject3.optString("type");
                            this.keys.add(gfhKeyValue);
                        }
                    }
                }
                this.hints = jSONObject.optString("hints");
                JSONArray optJSONArray3 = jSONObject.optJSONArray("links");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    this.links = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        JSONObject jSONObject4 = (JSONObject) optJSONArray3.opt(i3);
                        if (jSONObject4 != null) {
                            GfhLink gfhLink = new GfhLink();
                            gfhLink.text = jSONObject4.optString("text");
                            gfhLink.url = jSONObject4.optString("url");
                            this.links.add(gfhLink);
                        }
                    }
                }
                this.url = jSONObject.optString("url");
                parseSpecificJson(jSONObject);
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.url);
            parcel.writeParcelable(this.header, i);
            parcel.writeTypedList(this.operate);
            parcel.writeString(this.text);
            parcel.writeTypedList(this.keys);
            parcel.writeString(this.hints);
            parcel.writeTypedList(this.links);
        }
    }
}
