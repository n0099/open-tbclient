package com.baidu.tbadk.core.hybrid.a;

import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.coreExtra.c.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends n {
    private l cgF;

    public d(l lVar) {
        super(lVar);
        this.cgF = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String afT() {
        return "TBHY_COMMON_SHOW_SHARE_DIALOG";
    }

    @o(alB = false, value = "showShareDialog")
    protected void showShareDialog(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("content");
            String optString3 = jSONObject.optString("imgUrl");
            String optString4 = jSONObject.optString("shareUrl");
            e eVar = new e();
            eVar.title = optString;
            eVar.content = optString2;
            if (optString3 == null) {
                eVar.imageUri = null;
            } else {
                eVar.imageUri = Uri.parse(optString3);
            }
            eVar.linkUrl = optString4;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.cgF.getContext(), eVar, true);
            shareDialogConfig.setIsSupportNightMode(true);
            shareDialogConfig.setIsCopyLink(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
