package com.baidu.tbadk.core.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMUserExtraData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_AUTH_DESC = "auth_desc";
    public static final String KEY_AUTH_TYPE = "auth_type";
    public static final String KEY_BAZHU_DESC = "bazhu_desc";
    public static final String KEY_BAZHU_LEVEL = "bazhu_level";
    public static final String KEY_BAZHU_SHOW_OUTSIDE = "bazhu_show_outside";
    public static final String KEY_GOD_STATUS = "god_status";
    public static final String KEY_IS_BAZHU = "is_bazhu";
    public static final String KEY_IS_BUSINESS_ACCOUNT = "is_business_account";
    public static final String KEY_IS_GOD = "is_god";
    public static final String KEY_IS_ORIGINAL_AUTHOR = "is_original_author";
    public transient /* synthetic */ FieldHolder $fh;
    public String authDesc;
    public int authType;
    public String bazhuDesc;
    public String bazhuLevel;
    public int bazhuShowOutSide;
    public int godStatus;
    public int isBazhu;
    public int isBusinessAccount;
    public int isGod;
    public int isOriginalAuthor;

    public IMUserExtraData() {
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
        this.authDesc = "";
        this.bazhuDesc = "";
        this.bazhuLevel = "";
    }

    public void parseJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.isBusinessAccount = jSONObject.optInt(KEY_IS_BUSINESS_ACCOUNT, 0);
                this.authDesc = jSONObject.optString(KEY_AUTH_DESC);
                this.authType = jSONObject.optInt(KEY_AUTH_TYPE, 0);
                this.isOriginalAuthor = jSONObject.optInt(KEY_IS_ORIGINAL_AUTHOR, 0);
                this.godStatus = jSONObject.optInt(KEY_GOD_STATUS, 0);
                this.isGod = jSONObject.optInt(KEY_IS_GOD, 0);
                this.bazhuDesc = jSONObject.optString(KEY_BAZHU_DESC);
                this.bazhuLevel = jSONObject.optString(KEY_BAZHU_LEVEL);
                this.bazhuShowOutSide = jSONObject.optInt("bazhu_show_outside", 0);
                this.isBazhu = jSONObject.optInt("is_bazhu", 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void setUserData(com.baidu.tbadk.data.UserData userData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, userData) != null) || userData == null) {
            return;
        }
        if (userData.getBusinessAccountData() != null) {
            this.isBusinessAccount = userData.getBusinessAccountData().isBusinessAccount ? 1 : 0;
        }
        if (userData.getCreatorInfo() != null) {
            this.authDesc = userData.getCreatorInfo().authDesc;
        }
        this.authType = userData.getAuthType();
        this.isOriginalAuthor = userData.getIsOriginalAuthor();
        if (userData.getNewGodData() != null) {
            this.godStatus = userData.getNewGodData().getStatus();
        }
        this.isGod = userData.isGod() ? 1 : 0;
        if (userData.getBazhuGradeData() != null) {
            this.bazhuDesc = userData.getBazhuGradeData().getDesc();
            this.bazhuLevel = userData.getBazhuGradeData().getLevel();
        }
        if (userData.getPrivSetsData() != null) {
            this.bazhuShowOutSide = userData.getPrivSetsData().getBazhuShowOutside();
        }
        this.isBazhu = userData.getIsBaZhu();
    }

    public String toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_IS_BUSINESS_ACCOUNT, this.isBusinessAccount);
                jSONObject.put(KEY_AUTH_DESC, this.authDesc);
                jSONObject.put(KEY_AUTH_TYPE, this.authType);
                jSONObject.put(KEY_IS_ORIGINAL_AUTHOR, this.isOriginalAuthor);
                jSONObject.put(KEY_GOD_STATUS, this.godStatus);
                jSONObject.put(KEY_IS_GOD, this.isGod);
                jSONObject.put(KEY_BAZHU_DESC, this.bazhuDesc);
                jSONObject.put(KEY_BAZHU_LEVEL, this.bazhuLevel);
                jSONObject.put("bazhu_show_outside", this.bazhuShowOutSide);
                jSONObject.put("is_bazhu", this.isBazhu);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
