package com.baidu.tbadk.core.data;

import c.a.q0.a0.d0.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PbLinkInfo;
/* loaded from: classes6.dex */
public class PbLinkData extends c implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String extTxt;
    public String linkFrom;
    public String linkUrl;
    public String picUrl;
    public int sort;
    public String title;
    public int urlType;

    public PbLinkData() {
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

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            try {
                this.title = jSONObject.optString("title");
                this.linkUrl = jSONObject.optString("to_url");
                this.picUrl = jSONObject.optString("pic_url");
                this.linkFrom = jSONObject.optString("link_from");
                this.extTxt = jSONObject.optString("ext_txt");
                this.sort = jSONObject.optInt(QuickPersistConfigConst.KEY_SPLASH_SORT);
                this.urlType = jSONObject.optInt("url_type");
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public void parseProto(PbLinkInfo pbLinkInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbLinkInfo) == null) || pbLinkInfo == null) {
            return;
        }
        this.title = pbLinkInfo.title;
        this.linkUrl = pbLinkInfo.to_url;
        this.picUrl = pbLinkInfo.pic_url;
        this.linkFrom = pbLinkInfo.link_from;
        this.extTxt = pbLinkInfo.ext_txt;
        this.sort = pbLinkInfo.sort.intValue();
        this.urlType = pbLinkInfo.url_type.intValue();
    }

    @Override // c.a.q0.a0.d0.c
    public int sort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.sort : invokeV.intValue;
    }
}
