package com.baidu.swan.apps.publisher;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c.a.p0.a.c;
import c.a.p0.a.h;
import c.a.p0.a.k;
import c.a.p0.a.z1.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ReplyEditorParams implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<ReplyEditorParams> CREATOR;
    public static final List<String> DEFAULT_LIST;
    public static final String MODULE_EMOJI = "emoji";
    public static final String MODULE_PICTURE = "image";
    public transient /* synthetic */ FieldHolder $fh;
    public final String callback;
    public final String contentHint;
    public final String emojiPath;
    public final String sendText;
    public final int sendTextBgColor;
    public final int sendTextColor;
    public List<String> showList;

    /* loaded from: classes9.dex */
    public static class a implements Parcelable.Creator<ReplyEditorParams> {
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
        public ReplyEditorParams createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new ReplyEditorParams(parcel) : (ReplyEditorParams) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ReplyEditorParams[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new ReplyEditorParams[i2] : (ReplyEditorParams[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2070827934, "Lcom/baidu/swan/apps/publisher/ReplyEditorParams;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2070827934, "Lcom/baidu/swan/apps/publisher/ReplyEditorParams;");
                return;
            }
        }
        DEFAULT_LIST = Collections.emptyList();
        CREATOR = new a();
    }

    public ReplyEditorParams(String str, String str2, String str3, String str4, int i2, int i3, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3), list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.contentHint = str;
        this.emojiPath = str2;
        this.callback = str3;
        this.sendText = str4;
        this.sendTextColor = i2;
        this.sendTextBgColor = i3;
        this.showList = list;
    }

    public static ReplyEditorParams fromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(DEFAULT_LIST);
            JSONArray optJSONArray = jSONObject.optJSONArray("moduleList");
            if (optJSONArray != null) {
                arrayList.clear();
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    String optString = optJSONArray.optString(i4);
                    if (optString != null && !arrayList.contains(optString)) {
                        arrayList.add(optString);
                    }
                }
            }
            String c2 = b.c(jSONObject, "sendText", "发表");
            if (c2.length() > 2) {
                c2 = c2.substring(0, 2);
            }
            String str = c2;
            try {
                i2 = SwanAppConfigData.t(b.c(jSONObject, "sendTextColor", "#FFFFFF"));
            } catch (Exception e2) {
                if (k.a) {
                    e2.printStackTrace();
                }
                i2 = -1;
            }
            Application c3 = c.a.p0.a.c1.a.c();
            String c4 = b.c(jSONObject, "sendBackgroundColor", "#3388FF");
            int color = c3.getResources().getColor(c.swanapp_publish_btn_enable_color);
            try {
                i3 = SwanAppConfigData.t(c4);
            } catch (Exception e3) {
                if (k.a) {
                    e3.printStackTrace();
                }
                i3 = color;
            }
            String d2 = b.d(jSONObject.optString("contentPlaceholder", c3.getResources().getString(h.swanapp_reply_editor_place_holder)), 20, "...");
            String optString2 = jSONObject.optString("emojiPath");
            if (TextUtils.isEmpty(optString2)) {
                arrayList.remove(MODULE_EMOJI);
            }
            return new ReplyEditorParams(d2, optString2, jSONObject.optString("cb"), str, i2, i3, arrayList);
        }
        return (ReplyEditorParams) invokeL.objValue;
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

    public boolean supportEmoji() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<String> list = this.showList;
            return list != null && list.contains(MODULE_EMOJI);
        }
        return invokeV.booleanValue;
    }

    public boolean supportNoModule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<String> list = this.showList;
            return list == null || list.isEmpty() || !(this.showList.contains(MODULE_EMOJI) || this.showList.contains("image"));
        }
        return invokeV.booleanValue;
    }

    public boolean supportPicture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<String> list = this.showList;
            return list != null && list.contains("image");
        }
        return invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, parcel, i2) == null) {
            parcel.writeString(this.contentHint);
            parcel.writeString(this.sendText);
            parcel.writeInt(this.sendTextColor);
            parcel.writeInt(this.sendTextBgColor);
            parcel.writeString(this.emojiPath);
            parcel.writeString(this.callback);
            parcel.writeStringList(this.showList);
        }
    }

    public ReplyEditorParams(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.contentHint = parcel.readString();
        this.sendText = parcel.readString();
        this.sendTextColor = parcel.readInt();
        this.sendTextBgColor = parcel.readInt();
        this.emojiPath = parcel.readString();
        this.callback = parcel.readString();
        this.showList = parcel.createStringArrayList();
    }
}
