package com.baidu.tbadk.core.hybrid.a;

import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends n {
    private l dwN;

    public d(l lVar) {
        super(lVar);
        this.dwN = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String aHL() {
        return "TBHY_COMMON_SHOW_SHARE_DIALOG";
    }

    @o(aNH = false, value = "showShareDialog")
    protected void showShareDialog(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("content");
            String optString3 = jSONObject.optString("imgUrl");
            String optString4 = jSONObject.optString("shareUrl");
            ShareItem shareItem = new ShareItem();
            shareItem.title = optString;
            shareItem.content = optString2;
            if (optString3 == null) {
                shareItem.imageUri = null;
            } else {
                shareItem.imageUri = Uri.parse(optString3);
            }
            shareItem.linkUrl = optString4;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.dwN.getContext(), shareItem, true);
            shareDialogConfig.setIsSupportNightMode(true);
            shareDialogConfig.setIsCopyLink(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
