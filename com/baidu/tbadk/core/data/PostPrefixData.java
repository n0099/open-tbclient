package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsPage.PostPrefix;
/* loaded from: classes4.dex */
public class PostPrefixData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6807267689393049879L;
    public transient /* synthetic */ FieldHolder $fh;
    public String implicitTitle;
    public int mMode;
    public String mText;
    public String mTime;
    public String mType;
    public ArrayList<String> prefixs;

    public PostPrefixData() {
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
        this.prefixs = new ArrayList<>();
    }

    public String getImplicitTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.implicitTitle;
        }
        return (String) invokeV.objValue;
    }

    public int getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mMode;
        }
        return invokeV.intValue;
    }

    public ArrayList<String> getPrefixs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.prefixs;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mText;
        }
        return (String) invokeV.objValue;
    }

    public String getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mTime;
        }
        return (String) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mType;
        }
        return (String) invokeV.objValue;
    }

    public void addPreFix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.prefixs.add(str);
        }
    }

    public void setImplicitTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.implicitTitle = str;
        }
    }

    public void setMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mMode = i;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mText = str;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mTime = str;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mType = str;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("mode", 0);
        if (optInt == 0) {
            String optString = jSONObject.optString("text");
            if (!TextUtils.isEmpty(optString)) {
                this.prefixs.add(optString);
            }
        } else if (optInt == 1) {
            String optString2 = jSONObject.optString("text");
            if (!TextUtils.isEmpty(optString2)) {
                String optString3 = jSONObject.optString("type");
                if (!TextUtils.isEmpty(optString3)) {
                    String[] split = optString3.split(" ");
                    for (int i = 0; i < split.length; i++) {
                        if (!TextUtils.isEmpty(split[i].trim())) {
                            this.prefixs.add(optString2.replace("#type#", split[i]));
                        }
                    }
                    return;
                }
                this.prefixs.add(optString2);
            }
        }
    }

    public void parserProtobuf(PostPrefix postPrefix) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postPrefix) != null) || postPrefix == null) {
            return;
        }
        int intValue = postPrefix.mode.intValue();
        this.mMode = intValue;
        String str = postPrefix.text;
        this.mText = str;
        this.mType = postPrefix.type;
        this.mTime = postPrefix.time;
        if (intValue == 0) {
            if (!TextUtils.isEmpty(str)) {
                this.prefixs.add(str);
            }
        } else if (intValue == 1 && !TextUtils.isEmpty(str)) {
            String str2 = postPrefix.type;
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split(" ");
                for (int i = 0; i < split.length; i++) {
                    if (!TextUtils.isEmpty(split[i].trim())) {
                        this.prefixs.add(str.replace("#type#", split[i]));
                    }
                }
                return;
            }
            this.prefixs.add(str);
        }
    }

    public void parserProtobuf(tbclient.PostPrefix postPrefix) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, postPrefix) != null) || postPrefix == null) {
            return;
        }
        int intValue = postPrefix.mode.intValue();
        this.mMode = intValue;
        String str = postPrefix.text;
        this.mText = str;
        this.mType = postPrefix.type;
        this.mTime = postPrefix.time;
        if (intValue == 0) {
            if (!TextUtils.isEmpty(str)) {
                this.prefixs.add(str);
            }
        } else if (intValue == 1 && !TextUtils.isEmpty(str)) {
            String str2 = postPrefix.type;
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split(" ");
                for (int i = 0; i < split.length; i++) {
                    if (!TextUtils.isEmpty(split[i].trim())) {
                        this.prefixs.add(str.replace("#type#", split[i]));
                    }
                }
                return;
            }
            this.prefixs.add(str);
        }
    }

    public JSONObject toJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mode", this.mMode);
                jSONObject.put("text", this.mText);
                jSONObject.put("type", this.mType);
                jSONObject.put("time", this.mTime);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
