package com.baidu.tbadk.core.data;

import c.a.u0.g0.d0.c;
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
import tbclient.PbGoodsInfo;
/* loaded from: classes11.dex */
public class PbGoodsData extends c implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String goodsUrlH5;
    public String linkFrom;
    public String linkUrl;
    public String picUrl;
    public String price;
    public int sort;
    public String title;

    public PbGoodsData() {
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
                this.title = jSONObject.optString("goods_title");
                this.picUrl = jSONObject.optString("goods_image");
                this.price = jSONObject.optString("goods_price");
                this.linkUrl = jSONObject.optString("goods_url");
                this.sort = jSONObject.optInt(QuickPersistConfigConst.KEY_SPLASH_SORT);
                this.linkFrom = jSONObject.optString("goods_from");
                this.goodsUrlH5 = jSONObject.optString("goods_url_h5");
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public void parseProto(PbGoodsInfo pbGoodsInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbGoodsInfo) == null) || pbGoodsInfo == null) {
            return;
        }
        this.title = pbGoodsInfo.goods_title;
        this.picUrl = pbGoodsInfo.goods_image;
        this.price = pbGoodsInfo.goods_price;
        this.linkUrl = pbGoodsInfo.goods_url;
        this.sort = pbGoodsInfo.sort.intValue();
        this.linkFrom = pbGoodsInfo.goods_from;
        this.goodsUrlH5 = pbGoodsInfo.goods_url_h5;
    }

    @Override // c.a.u0.g0.d0.c
    public int sort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.sort : invokeV.intValue;
    }
}
