package com.baidu.searchbox.account.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class UserAccountActionItem implements Parcelable, NoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<UserAccountActionItem> CREATOR;
    public static final String KEY_ACTION = "action";
    public static final String KEY_SRC = "src";
    public static final String KEY_SUB_SRC = "subSrc";
    public static final String KEY_TYPE = "type";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAction;
    public String mSrc;
    public String mSubSrc;
    public String mType;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class UserAccountAction {
        public static final /* synthetic */ UserAccountAction[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final UserAccountAction BIND;
        public static final UserAccountAction LOGIN;
        public static final UserAccountAction LOGOUT;
        public transient /* synthetic */ FieldHolder $fh;
        public String mName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1975612869, "Lcom/baidu/searchbox/account/data/UserAccountActionItem$UserAccountAction;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1975612869, "Lcom/baidu/searchbox/account/data/UserAccountActionItem$UserAccountAction;");
                    return;
                }
            }
            LOGIN = new UserAccountAction("LOGIN", 0, "login");
            LOGOUT = new UserAccountAction("LOGOUT", 1, "logout");
            UserAccountAction userAccountAction = new UserAccountAction("BIND", 2, "bind");
            BIND = userAccountAction;
            $VALUES = new UserAccountAction[]{LOGIN, LOGOUT, userAccountAction};
        }

        public UserAccountAction(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mName = str2;
        }

        public static UserAccountAction valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (UserAccountAction) Enum.valueOf(UserAccountAction.class, str) : (UserAccountAction) invokeL.objValue;
        }

        public static UserAccountAction[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (UserAccountAction[]) $VALUES.clone() : (UserAccountAction[]) invokeV.objValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mName : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class UserAccountType {
        public static final /* synthetic */ UserAccountType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final UserAccountType GUEST;
        public static final UserAccountType NATIVE;
        public static final UserAccountType PLUGIN;
        public static final UserAccountType SHARE;
        public static final UserAccountType WEBVIEW;
        public transient /* synthetic */ FieldHolder $fh;
        public String mType;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-100416191, "Lcom/baidu/searchbox/account/data/UserAccountActionItem$UserAccountType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-100416191, "Lcom/baidu/searchbox/account/data/UserAccountActionItem$UserAccountType;");
                    return;
                }
            }
            NATIVE = new UserAccountType(Constant.TYPE_NATIVE, 0, "native");
            PLUGIN = new UserAccountType("PLUGIN", 1, "plugin");
            SHARE = new UserAccountType("SHARE", 2, "share");
            GUEST = new UserAccountType("GUEST", 3, "guest");
            UserAccountType userAccountType = new UserAccountType("WEBVIEW", 4, AlbumActivityConfig.FROM_WEB_VIEW);
            WEBVIEW = userAccountType;
            $VALUES = new UserAccountType[]{NATIVE, PLUGIN, SHARE, GUEST, userAccountType};
        }

        public UserAccountType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mType = str2;
        }

        public static UserAccountType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (UserAccountType) Enum.valueOf(UserAccountType.class, str) : (UserAccountType) invokeL.objValue;
        }

        public static UserAccountType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (UserAccountType[]) $VALUES.clone() : (UserAccountType[]) invokeV.objValue;
        }

        public String getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mType : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2120094791, "Lcom/baidu/searchbox/account/data/UserAccountActionItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2120094791, "Lcom/baidu/searchbox/account/data/UserAccountActionItem;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<UserAccountActionItem>() { // from class: com.baidu.searchbox.account.data.UserAccountActionItem.1
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
            public UserAccountActionItem createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new UserAccountActionItem(parcel) : (UserAccountActionItem) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public UserAccountActionItem[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new UserAccountActionItem[i2] : (UserAccountActionItem[]) invokeI.objValue;
            }
        };
    }

    public UserAccountActionItem(Parcel parcel) {
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
        this.mAction = parcel.readString();
        this.mType = parcel.readString();
        this.mSrc = parcel.readString();
        this.mSubSrc = parcel.readString();
    }

    public JSONObject buildUserStatInfo() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            String str = this.mAction;
            if (str != null) {
                jSONObject.put("action", str);
                if (!TextUtils.isEmpty(this.mType)) {
                    jSONObject.put("type", this.mType);
                }
                if (!TextUtils.isEmpty(this.mSrc)) {
                    if (!TextUtils.isEmpty(this.mSubSrc)) {
                        jSONObject.put("src", this.mSrc + "_" + this.mSubSrc);
                    } else {
                        jSONObject.put("src", this.mSrc);
                    }
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAction : (String) invokeV.objValue;
    }

    public String getSrc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSrc : (String) invokeV.objValue;
    }

    public String getSubSrc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSubSrc : (String) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mType : (String) invokeV.objValue;
    }

    public void setAction(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mAction = str;
        }
    }

    public String toString() {
        JSONObject jSONObject;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                jSONObject = buildUserStatInfo();
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject = null;
            }
            return jSONObject != null ? jSONObject.toString() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, parcel, i2) == null) {
            parcel.writeString(this.mAction);
            parcel.writeString(this.mType);
            parcel.writeString(this.mSrc);
            parcel.writeString(this.mSubSrc);
        }
    }

    public UserAccountActionItem(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        this.mAction = str;
        this.mType = str2;
        this.mSrc = str3;
    }

    public UserAccountActionItem(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
        this.mAction = str;
        this.mType = str2;
        this.mSrc = str3;
        this.mSubSrc = str4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserAccountActionItem(UserAccountAction userAccountAction, String str, String str2) {
        this(userAccountAction.getName(), str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {userAccountAction, str, str2};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserAccountActionItem(UserAccountAction userAccountAction, UserAccountType userAccountType, String str) {
        this(userAccountAction.getName(), userAccountType.getType(), str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {userAccountAction, userAccountType, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserAccountActionItem(UserAccountAction userAccountAction, UserAccountType userAccountType, String str, String str2) {
        this(userAccountAction.getName(), userAccountType.getType(), str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {userAccountAction, userAccountType, str, str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public UserAccountActionItem(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        if (jSONObject != null) {
            if (jSONObject.has("action")) {
                this.mAction = jSONObject.getString("action");
            }
            if (jSONObject.has("type")) {
                this.mType = jSONObject.getString("type");
            }
            if (jSONObject.has("src")) {
                this.mSrc = jSONObject.getString("src");
            }
            if (jSONObject.has(KEY_SUB_SRC)) {
                this.mSubSrc = jSONObject.getString(KEY_SUB_SRC);
                return;
            }
            return;
        }
        throw new JSONException("");
    }
}
