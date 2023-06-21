package com.baidu.tbadk.core.view.itemcard.download;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.wi;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ItemFetchUrlHttpMsg extends HttpMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DownloadData downloadData;
    public final String pkgName;
    public final BdUniqueId tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemFetchUrlHttpMsg(DownloadData downloadData, ItemData itemData, String str, BdUniqueId bdUniqueId) {
        super(CmdConfigHttp.CMD_ITEM_FETCH_URL);
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadData, itemData, str, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        addParam("screen_width", wi.l(TbadkCoreApplication.getInst().getContext()));
        addParam("screen_length", wi.j(TbadkCoreApplication.getInst().getContext()));
        addParam("os_ver", yi.k());
        addParam("package", itemData.pkgName);
        addParam("query", str);
        if (downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData)) {
            if (((ItemDownloadExtraData) downloadData.getExtra()).shouzhuScene == 4001) {
                i = 5;
            } else {
                i = 6;
            }
            addParam("req_type", i);
        }
        this.downloadData = downloadData;
        this.pkgName = itemData.pkgName;
        this.tag = bdUniqueId;
    }

    public BdUniqueId getButtonTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.tag;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public DownloadData getDownloadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.downloadData;
        }
        return (DownloadData) invokeV.objValue;
    }

    public String getPkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.pkgName;
        }
        return (String) invokeV.objValue;
    }
}
