package b.a.r0.j0.g;

import b.a.r0.j0.b.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.heytap.mcssdk.mode.CommandMessage;
import tbclient.ApkDetail;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b bVar) {
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, bVar) == null) || bVar == null || (itemData = bVar.f19630e) == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_UPLOAD_DOWNLOAD_INFO);
        httpMessage.addParam("item_id", itemData.itemId);
        httpMessage.addParam("app_name", itemData.mTitle);
        httpMessage.addParam("source_type", bVar.f19631f);
        httpMessage.addParam("icon_url", itemData.mIconUrl);
        httpMessage.addParam("score", Double.valueOf(itemData.mScore));
        httpMessage.addParam(CommandMessage.TYPE_TAGS, itemData.mTags);
        httpMessage.addParam("apk_name", itemData.pkgName);
        ApkDetail apkDetail = itemData.apkDetail;
        if (apkDetail != null) {
            httpMessage.addParam("developer", apkDetail.developer);
            httpMessage.addParam("privacy_url", itemData.apkDetail.privacy_url);
            httpMessage.addParam("authority_url", itemData.apkDetail.authority_url);
            httpMessage.addParam("version", itemData.apkDetail.version);
            httpMessage.addParam("version_code", itemData.apkDetail.version_code);
        }
        MessageManager.getInstance().sendMessageFromBackground(httpMessage);
    }
}
