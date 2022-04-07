package com.baidu.sapi2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SapiAccount implements Parcelable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<SapiAccount> CREATOR;
    public static final String SAPI_ACCOUNT_APP = "app";
    public static final String SAPI_ACCOUNT_BDUSS = "bduss";
    public static final String SAPI_ACCOUNT_DISPLAYNAME = "displayname";
    public static final String SAPI_ACCOUNT_EMAIL = "email";
    public static final String SAPI_ACCOUNT_EXTRA = "extra";
    public static final String SAPI_ACCOUNT_FROMTYPE = "fromType";
    public static final String SAPI_ACCOUNT_PHONE = "phone";
    public static final String SAPI_ACCOUNT_PORTRAIT = "portrait";
    public static final String SAPI_ACCOUNT_PTOKEN = "ptoken";
    public static final String SAPI_ACCOUNT_STOKEN = "stoken";
    public static final String SAPI_ACCOUNT_UID = "uid";
    public static final String SAPI_ACCOUNT_USERNAME = "username";
    public transient /* synthetic */ FieldHolder $fh;
    public String app;
    public String bduss;
    @Deprecated
    public String devicetoken;
    public String displayname;
    @Deprecated
    public String email;
    public String extra;
    public String fromType;
    @Deprecated
    public String phone;
    public String portrait;
    public String ptoken;
    @Deprecated
    public String stoken;
    public String uid;
    public String username;

    /* loaded from: classes2.dex */
    public static final class DispersionCertification implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, String> tplStokenMap;

        public DispersionCertification() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.tplStokenMap = new HashMap();
        }

        public static DispersionCertification fromJSONObject(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                DispersionCertification dispersionCertification = new DispersionCertification();
                dispersionCertification.tplStokenMap = getTplStokenMap(jSONObject.optJSONObject("stoken_list"));
                return dispersionCertification;
            }
            return (DispersionCertification) invokeL.objValue;
        }

        public static Map<String, String> getTplStokenMap(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                HashMap hashMap = new HashMap();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String obj = keys.next().toString();
                        hashMap.put(obj, jSONObject.optString(obj));
                    }
                }
                return hashMap;
            }
            return (Map) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ExtraProperty implements NoProguard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EXTRA_ACCOUNT_TYPE = "account_type";
        public static final String EXTRA_IS_GUEST_ACCOUNT = "is_guest_account";
        public static final String EXTRA_IS_SOCIAL_ACCOUNT = "is_social_account";
        public static final String EXTRA_PKG = "pkg";
        public static final String EXTRA_SOCIAL_NICKNAME = "social_nickname";
        public static final String EXTRA_SOCIAL_PORTRAIT = "social_portrait";
        public static final String EXTRA_SOCIAL_TYPE = "social_type";
        public static final String EXTRA_TPL = "tpl";
        public static final String EXTRA_TPL_STOKEN_LIST = "stoken_list";
        public transient /* synthetic */ FieldHolder $fh;
        public DispersionCertification dispersionCertification;
        public String extraAccountType;
        public String extraIsGuestAccount;
        public String extraIsSocialAccount;
        public String extraPkg;
        public String extraSocialPortrait;
        public String extraSocialType;
        public String extraTpl;

        public ExtraProperty() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dispersionCertification = new DispersionCertification();
        }

        public static ExtraProperty fromJSONObject(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                ExtraProperty extraProperty = new ExtraProperty();
                extraProperty.extraAccountType = jSONObject.optString("account_type");
                extraProperty.extraIsSocialAccount = jSONObject.optString(EXTRA_IS_SOCIAL_ACCOUNT);
                extraProperty.extraSocialType = jSONObject.optString("social_type");
                extraProperty.extraSocialPortrait = jSONObject.optString(EXTRA_SOCIAL_PORTRAIT);
                extraProperty.dispersionCertification = DispersionCertification.fromJSONObject(jSONObject);
                extraProperty.extraIsGuestAccount = jSONObject.optString(EXTRA_IS_GUEST_ACCOUNT);
                extraProperty.extraTpl = jSONObject.optString("tpl");
                extraProperty.extraPkg = jSONObject.optString("pkg");
                return extraProperty;
            }
            return (ExtraProperty) invokeL.objValue;
        }

        public JSONObject toJSONObject() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("account_type", this.extraAccountType);
                    jSONObject.put(EXTRA_IS_SOCIAL_ACCOUNT, this.extraIsSocialAccount);
                    jSONObject.put("social_type", this.extraSocialType);
                    jSONObject.put(EXTRA_SOCIAL_PORTRAIT, this.extraSocialPortrait);
                    jSONObject.put("stoken_list", new JSONObject(this.dispersionCertification.tplStokenMap));
                    jSONObject.put(EXTRA_IS_GUEST_ACCOUNT, this.extraIsGuestAccount);
                    jSONObject.put("tpl", this.extraTpl);
                    jSONObject.put("pkg", this.extraPkg);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(139920519, "Lcom/baidu/sapi2/SapiAccount;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(139920519, "Lcom/baidu/sapi2/SapiAccount;");
                return;
            }
        }
        try {
            ShareAccountAccessor.setShareAccountAccessor(new SapiAccountAccessorImpl());
        } catch (Throwable th) {
            Log.e(th);
        }
        CREATOR = new Parcelable.Creator<SapiAccount>() { // from class: com.baidu.sapi2.SapiAccount.1
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
            public SapiAccount createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SapiAccount(parcel) : (SapiAccount) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SapiAccount[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new SapiAccount[i] : (SapiAccount[]) invokeI.objValue;
            }
        };
    }

    public SapiAccount() {
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
        this.fromType = FromType.LOGIN.getValue();
    }

    public static List<SapiAccount> fromJSONArray(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONArray)) == null) {
            if (jSONArray != null && jSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        SapiAccount fromJSONObject = fromJSONObject(jSONArray.getJSONObject(i));
                        if (fromJSONObject != null) {
                            arrayList.add(fromJSONObject);
                        }
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                }
                return arrayList;
            }
            return new ArrayList();
        }
        return (List) invokeL.objValue;
    }

    public static SapiAccount fromJSONObject(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = jSONObject.optString("uid");
            sapiAccount.displayname = jSONObject.optString("displayname");
            sapiAccount.username = jSONObject.optString("username");
            sapiAccount.email = jSONObject.optString("email");
            sapiAccount.phone = jSONObject.optString("phone");
            sapiAccount.bduss = jSONObject.optString("bduss");
            sapiAccount.app = jSONObject.optString("app");
            sapiAccount.ptoken = jSONObject.optString(SAPI_ACCOUNT_PTOKEN);
            sapiAccount.stoken = jSONObject.optString("stoken");
            sapiAccount.extra = jSONObject.optString("extra");
            sapiAccount.portrait = jSONObject.optString("portrait");
            sapiAccount.fromType = jSONObject.optString(SAPI_ACCOUNT_FROMTYPE, FromType.LOGIN.getValue());
            if (isValidAccount(sapiAccount)) {
                return sapiAccount;
            }
            return null;
        }
        return (SapiAccount) invokeL.objValue;
    }

    public static boolean isValidAccount(SapiAccount sapiAccount) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, sapiAccount)) == null) ? (sapiAccount == null || TextUtils.isEmpty(sapiAccount.bduss) || TextUtils.isEmpty(sapiAccount.ptoken) || TextUtils.isEmpty(sapiAccount.uid) || TextUtils.isEmpty(sapiAccount.displayname)) ? false : true : invokeL.booleanValue;
    }

    private boolean isValidPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            Context context = ServiceManager.getInstance().getIsAccountManager().getConfignation().context;
            for (String str : SapiContext.getInstance().getSapiOptions().getAuthorizedPackagesForPtoken()) {
                if (context.getPackageName().matches(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static JSONArray toJSONArray(List<SapiAccount> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (SapiAccount sapiAccount : list) {
                JSONObject jSONObject = sapiAccount.toJSONObject();
                if (jSONObject != null) {
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public void addDispersionCertification(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            putExtra("stoken_list", new JSONObject(map));
        }
    }

    public void addIsGuestAccount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            putExtra(ExtraProperty.EXTRA_IS_GUEST_ACCOUNT, str);
        }
    }

    public void addSocialInfo(SocialType socialType, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, socialType, str, str2) == null) {
            putExtra(ExtraProperty.EXTRA_IS_SOCIAL_ACCOUNT, Boolean.TRUE);
            putExtra("social_type", Integer.valueOf(socialType.getType()));
            putExtra(ExtraProperty.EXTRA_SOCIAL_NICKNAME, str2);
            putExtra(ExtraProperty.EXTRA_SOCIAL_PORTRAIT, str);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            super.clone();
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = this.uid;
            sapiAccount.displayname = this.displayname;
            sapiAccount.username = this.username;
            sapiAccount.email = this.email;
            sapiAccount.phone = this.phone;
            sapiAccount.bduss = this.bduss;
            sapiAccount.ptoken = this.ptoken;
            sapiAccount.stoken = this.stoken;
            sapiAccount.app = this.app;
            sapiAccount.extra = this.extra;
            sapiAccount.portrait = this.portrait;
            sapiAccount.fromType = this.fromType;
            return sapiAccount;
        }
        return invokeV.objValue;
    }

    public void deleteStokens() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                if (TextUtils.isEmpty(this.extra)) {
                    return;
                }
                ExtraProperty fromJSONObject = ExtraProperty.fromJSONObject(new JSONObject(this.extra));
                fromJSONObject.dispersionCertification.tplStokenMap.clear();
                this.extra = fromJSONObject.toJSONObject().toString();
            } catch (JSONException e) {
                Log.e(e);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SapiAccount.class != obj.getClass()) {
                return false;
            }
            String str = this.uid;
            String str2 = ((SapiAccount) obj).uid;
            if (str != null) {
                if (str.equals(str2)) {
                    return true;
                }
            } else if (str2 == null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public AccountType getAccountType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? AccountType.getAccountType(getIntExtra("account_type", AccountType.UNKNOWN.getType())) : (AccountType) invokeV.objValue;
    }

    public boolean getBooleanExtra(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            if (!TextUtils.isEmpty(this.extra)) {
                try {
                    return new JSONObject(this.extra).optBoolean(str, z);
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return z;
        }
        return invokeLZ.booleanValue;
    }

    public String getCompletePortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "https://himg.bdimg.com/sys/portrait/item/" + this.portrait + ".jpg";
        }
        return (String) invokeV.objValue;
    }

    public int getIntExtra(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i)) == null) {
            if (!TextUtils.isEmpty(this.extra)) {
                try {
                    return new JSONObject(this.extra).optInt(str, i);
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public String getPtoken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? isValidPackage() ? this.ptoken : "" : (String) invokeV.objValue;
    }

    public String getShareAccountPkg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? getStringExtra("pkg", null) : (String) invokeV.objValue;
    }

    public String getShareAccountTpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getStringExtra("tpl", "") : (String) invokeV.objValue;
    }

    public String getSocialNickname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getStringExtra(ExtraProperty.EXTRA_SOCIAL_NICKNAME, null) : (String) invokeV.objValue;
    }

    public String getSocialPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getStringExtra(ExtraProperty.EXTRA_SOCIAL_PORTRAIT, null) : (String) invokeV.objValue;
    }

    public SocialType getSocialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? SocialType.getSocialType(getIntExtra("social_type", SocialType.UNKNOWN.getType())) : (SocialType) invokeV.objValue;
    }

    public String getStringExtra(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(this.extra)) {
                try {
                    return new JSONObject(this.extra).optString(str, str2);
                } catch (Exception e) {
                    Log.e(e);
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            String str = this.uid;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isGuestAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? "1".equals(getStringExtra(ExtraProperty.EXTRA_IS_GUEST_ACCOUNT, "0")) : invokeV.booleanValue;
    }

    public boolean isSocialAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? getBooleanExtra(ExtraProperty.EXTRA_IS_SOCIAL_ACCOUNT, false) : invokeV.booleanValue;
    }

    public void putExtra(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, obj) == null) || TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if (TextUtils.isEmpty(this.extra)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, obj);
                this.extra = jSONObject.toString();
                return;
            } catch (JSONException e) {
                Log.e(e);
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject(this.extra);
            jSONObject2.put(str, obj);
            this.extra = jSONObject2.toString();
        } catch (JSONException e2) {
            Log.e(e2);
        }
    }

    public void setAccountPkg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            putExtra("pkg", str);
        }
    }

    public void setPtoken(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, str) == null) && isValidPackage()) {
            this.ptoken = str;
        }
    }

    public JSONObject toJSONObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uid", this.uid);
                jSONObject.put("displayname", this.displayname);
                jSONObject.put("username", this.username);
                jSONObject.put("email", this.email);
                jSONObject.put("phone", this.phone);
                jSONObject.put("bduss", this.bduss);
                jSONObject.put("app", this.app);
                jSONObject.put(SAPI_ACCOUNT_PTOKEN, this.ptoken);
                jSONObject.put("stoken", this.stoken);
                jSONObject.put("extra", this.extra);
                jSONObject.put("portrait", this.portrait);
                jSONObject.put(SAPI_ACCOUNT_FROMTYPE, this.fromType);
                return jSONObject;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return "SapiAccount{uid='" + this.uid + "', displayname='" + this.displayname + "', username='" + this.username + "', email='" + this.email + "', phone='" + this.phone + "', bduss='" + this.bduss + "', app='" + this.app + "', ptoken='" + this.ptoken + "', stoken='" + this.stoken + "', extra='" + this.extra + "', portrait='" + this.portrait + "', fromType='" + this.fromType + "'}";
        }
        return (String) invokeV.objValue;
    }

    public void updatePtoken() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (TextUtils.isEmpty(this.bduss) || TextUtils.isEmpty(this.ptoken)) {
                SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(this.bduss);
                String cookiePtoken = SapiUtils.getCookiePtoken();
                String cookieBduss = SapiUtils.getCookieBduss();
                if (accountFromBduss != null && !TextUtils.isEmpty(accountFromBduss.ptoken)) {
                    this.ptoken = accountFromBduss.ptoken;
                } else if (!this.bduss.equals(cookieBduss) || TextUtils.isEmpty(cookiePtoken)) {
                } else {
                    this.ptoken = cookiePtoken;
                }
            }
        }
    }

    public void updateSession(SapiAccount sapiAccount) {
        ExtraProperty extraProperty;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, sapiAccount) == null) && isValidAccount(sapiAccount) && this.uid.equals(sapiAccount.uid)) {
            this.bduss = sapiAccount.bduss;
            this.ptoken = sapiAccount.ptoken;
            if (TextUtils.isEmpty(sapiAccount.extra)) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(this.extra)) {
                    extraProperty = ExtraProperty.fromJSONObject(new JSONObject(this.extra));
                } else {
                    extraProperty = new ExtraProperty();
                }
                ExtraProperty fromJSONObject = ExtraProperty.fromJSONObject(new JSONObject(sapiAccount.extra));
                extraProperty.dispersionCertification.tplStokenMap = fromJSONObject.dispersionCertification.tplStokenMap;
                extraProperty.extraSocialPortrait = fromJSONObject.extraSocialPortrait;
                extraProperty.extraAccountType = fromJSONObject.extraAccountType;
                extraProperty.extraIsGuestAccount = fromJSONObject.extraIsGuestAccount;
                this.extra = extraProperty.toJSONObject().toString();
            } catch (JSONException e) {
                Log.e(e);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048604, this, parcel, i) == null) {
            parcel.writeString(this.uid);
            parcel.writeString(this.displayname);
            parcel.writeString(this.username);
            parcel.writeString(this.email);
            parcel.writeString(this.phone);
            parcel.writeString(this.bduss);
            parcel.writeString(this.app);
            parcel.writeString(this.ptoken);
            parcel.writeString(this.stoken);
            parcel.writeString(this.devicetoken);
            parcel.writeString(this.extra);
            parcel.writeString(this.portrait);
        }
    }

    public SapiAccount(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.fromType = FromType.LOGIN.getValue();
        this.uid = parcel.readString();
        this.displayname = parcel.readString();
        this.username = parcel.readString();
        this.email = parcel.readString();
        this.phone = parcel.readString();
        this.bduss = parcel.readString();
        this.app = parcel.readString();
        this.ptoken = parcel.readString();
        this.stoken = parcel.readString();
        this.devicetoken = parcel.readString();
        this.extra = parcel.readString();
        this.portrait = parcel.readString();
    }
}
