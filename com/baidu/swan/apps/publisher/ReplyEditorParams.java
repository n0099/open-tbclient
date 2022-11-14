package com.baidu.swan.apps.publisher;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.i13;
import com.baidu.tieba.mn2;
import com.baidu.tieba.pk1;
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
/* loaded from: classes3.dex */
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

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<ReplyEditorParams> {
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
        public ReplyEditorParams createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new ReplyEditorParams(parcel);
            }
            return (ReplyEditorParams) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ReplyEditorParams[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new ReplyEditorParams[i];
            }
            return (ReplyEditorParams[]) invokeI.objValue;
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

    public boolean supportEmoji() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<String> list = this.showList;
            if (list != null && list.contains("emoji")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean supportPicture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<String> list = this.showList;
            if (list != null && list.contains("image")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ReplyEditorParams(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public ReplyEditorParams(String str, String str2, String str3, String str4, int i, int i2, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.contentHint = str;
        this.emojiPath = str2;
        this.callback = str3;
        this.sendText = str4;
        this.sendTextColor = i;
        this.sendTextBgColor = i2;
        this.showList = list;
    }

    public static ReplyEditorParams fromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(DEFAULT_LIST);
            JSONArray optJSONArray = jSONObject.optJSONArray("moduleList");
            if (optJSONArray != null) {
                arrayList.clear();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    String optString = optJSONArray.optString(i3);
                    if (optString != null && !arrayList.contains(optString)) {
                        arrayList.add(optString);
                    }
                }
            }
            String c = i13.c(jSONObject, "sendText", "发表");
            if (c.length() > 2) {
                c = c.substring(0, 2);
            }
            String str = c;
            try {
                i = SwanAppConfigData.t(i13.c(jSONObject, "sendTextColor", "#FFFFFF"));
            } catch (Exception e) {
                if (pk1.a) {
                    e.printStackTrace();
                }
                i = -1;
            }
            Application c2 = mn2.c();
            String c3 = i13.c(jSONObject, "sendBackgroundColor", "#3388FF");
            int color = c2.getResources().getColor(R.color.obfuscated_res_0x7f060abe);
            try {
                i2 = SwanAppConfigData.t(c3);
            } catch (Exception e2) {
                if (pk1.a) {
                    e2.printStackTrace();
                }
                i2 = color;
            }
            String d = i13.d(jSONObject.optString("contentPlaceholder", c2.getResources().getString(R.string.obfuscated_res_0x7f0f1344)), 20, StringHelper.STRING_MORE);
            String optString2 = jSONObject.optString("emojiPath");
            if (TextUtils.isEmpty(optString2)) {
                arrayList.remove("emoji");
            }
            return new ReplyEditorParams(d, optString2, jSONObject.optString("cb"), str, i, i2, arrayList);
        }
        return (ReplyEditorParams) invokeL.objValue;
    }

    public boolean supportNoModule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<String> list = this.showList;
            if (list != null && !list.isEmpty() && (this.showList.contains("emoji") || this.showList.contains("image"))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, parcel, i) == null) {
            parcel.writeString(this.contentHint);
            parcel.writeString(this.sendText);
            parcel.writeInt(this.sendTextColor);
            parcel.writeInt(this.sendTextBgColor);
            parcel.writeString(this.emojiPath);
            parcel.writeString(this.callback);
            parcel.writeStringList(this.showList);
        }
    }
}
