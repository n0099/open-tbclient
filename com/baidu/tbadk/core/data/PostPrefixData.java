package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.FrsPage.PostPrefix;
/* loaded from: classes4.dex */
public class PostPrefixData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6807267689393049879L;
    public transient /* synthetic */ FieldHolder $fh;
    public String implicitTitle;
    public ArrayList<String> prefixs;

    public PostPrefixData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.prefixs = new ArrayList<>();
    }

    public void addPreFix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.prefixs.add(str);
        }
    }

    public String getImplicitTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.implicitTitle : (String) invokeV.objValue;
    }

    public ArrayList<String> getPrefixs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.prefixs : (ArrayList) invokeV.objValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("mode", 0);
        if (optInt == 0) {
            String optString = jSONObject.optString("text");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.prefixs.add(optString);
        } else if (optInt == 1) {
            String optString2 = jSONObject.optString("text");
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            String optString3 = jSONObject.optString("type");
            if (!TextUtils.isEmpty(optString3)) {
                String[] split = optString3.split(" ");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!TextUtils.isEmpty(split[i2].trim())) {
                        this.prefixs.add(optString2.replace("#type#", split[i2]));
                    }
                }
                return;
            }
            this.prefixs.add(optString2);
        }
    }

    public void parserProtobuf(PostPrefix postPrefix) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, postPrefix) == null) || postPrefix == null) {
            return;
        }
        int intValue = postPrefix.mode.intValue();
        if (intValue == 0) {
            String str = postPrefix.text;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.prefixs.add(str);
        } else if (intValue == 1) {
            String str2 = postPrefix.text;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String str3 = postPrefix.type;
            if (!TextUtils.isEmpty(str3)) {
                String[] split = str3.split(" ");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!TextUtils.isEmpty(split[i2].trim())) {
                        this.prefixs.add(str2.replace("#type#", split[i2]));
                    }
                }
                return;
            }
            this.prefixs.add(str2);
        }
    }

    public void setImplicitTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.implicitTitle = str;
        }
    }

    public void parserProtobuf(tbclient.PostPrefix postPrefix) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, postPrefix) == null) || postPrefix == null) {
            return;
        }
        int intValue = postPrefix.mode.intValue();
        if (intValue == 0) {
            String str = postPrefix.text;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.prefixs.add(str);
        } else if (intValue == 1) {
            String str2 = postPrefix.text;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String str3 = postPrefix.type;
            if (!TextUtils.isEmpty(str3)) {
                String[] split = str3.split(" ");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!TextUtils.isEmpty(split[i2].trim())) {
                        this.prefixs.add(str2.replace("#type#", split[i2]));
                    }
                }
                return;
            }
            this.prefixs.add(str2);
        }
    }
}
