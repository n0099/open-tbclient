package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.TwZhiBoAnti;
/* loaded from: classes3.dex */
public class TwzhiboAnti implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR = 0;
    public static final int OK = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int canShowPBHeadline;
    public int can_add_live_post;
    public int can_del_live_post;

    public TwzhiboAnti() {
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
        this.can_add_live_post = 0;
        this.can_del_live_post = 0;
        this.canShowPBHeadline = 0;
    }

    public int getCanShowPBHeadline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.canShowPBHeadline : invokeV.intValue;
    }

    public int getCan_add_live_post() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.can_add_live_post : invokeV.intValue;
    }

    public int getCan_del_live_post() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.can_del_live_post : invokeV.intValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserProtobuf(TwZhiBoAnti twZhiBoAnti) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, twZhiBoAnti) == null) || twZhiBoAnti == null) {
            return;
        }
        this.can_add_live_post = twZhiBoAnti.can_add_live_post.intValue();
        this.can_del_live_post = twZhiBoAnti.can_del_live_post.intValue();
        this.canShowPBHeadline = twZhiBoAnti.can_show_pb_headline.intValue();
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.can_add_live_post = jSONObject.optInt("can_add_live_post", 0);
            this.can_del_live_post = jSONObject.optInt("can_del_live_post", 0);
            this.canShowPBHeadline = jSONObject.optInt("can_show_pb_headline", 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
