package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tieba.kk6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.PbLinkInfo;
/* loaded from: classes4.dex */
public class PbLinkData extends kk6 implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String content1;
    public String content2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.kk6
    public int sort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.sort;
        }
        return invokeV.intValue;
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
                this.content1 = jSONObject.optString(GameGuideConfigInfo.KEY_CONTENT1);
                this.content2 = jSONObject.optString(GameGuideConfigInfo.KEY_CONTENT2);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void parseProto(PbLinkInfo pbLinkInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbLinkInfo) != null) || pbLinkInfo == null) {
            return;
        }
        this.title = pbLinkInfo.title;
        this.linkUrl = pbLinkInfo.to_url;
        this.picUrl = pbLinkInfo.pic_url;
        this.linkFrom = pbLinkInfo.link_from;
        this.extTxt = pbLinkInfo.ext_txt;
        this.sort = pbLinkInfo.sort.intValue();
        this.urlType = pbLinkInfo.url_type.intValue();
        this.content1 = pbLinkInfo.content1;
        this.content2 = pbLinkInfo.content2;
    }
}
