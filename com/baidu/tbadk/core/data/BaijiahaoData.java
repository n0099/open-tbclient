package com.baidu.tbadk.core.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Baijiahao;
/* loaded from: classes5.dex */
public class BaijiahaoData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UGC_TYPE_ARTICLE = 1;
    public static final int UGC_TYPE_FEED_PIC = 3;
    public static final int UGC_TYPE_FEED_VIDEO = 4;
    public static final int UGC_TYPE_VIDEO = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String forwardUrl;
    public String oriUgcNid;
    public String oriUgcTid;
    public int oriUgcType;
    public String oriUgcVid;

    public BaijiahaoData() {
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.oriUgcNid = jSONObject.optString("ori_ugc_nid");
        this.oriUgcTid = jSONObject.optString("ori_ugc_tid");
        this.oriUgcType = jSONObject.optInt(TiebaStatic.Params.UGC_TYPE);
        this.oriUgcVid = jSONObject.optString("ori_ugc_vid");
        this.forwardUrl = jSONObject.optString("forward_url");
    }

    public void parseProto(Baijiahao baijiahao) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baijiahao) == null) || baijiahao == null) {
            return;
        }
        this.oriUgcNid = baijiahao.ori_ugc_nid;
        this.oriUgcTid = baijiahao.ori_ugc_tid;
        this.oriUgcType = baijiahao.ori_ugc_type.intValue();
        this.oriUgcVid = baijiahao.ori_ugc_vid;
        this.forwardUrl = baijiahao.forward_url;
    }
}
