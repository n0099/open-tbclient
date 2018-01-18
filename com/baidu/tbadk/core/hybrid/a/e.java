package com.baidu.tbadk.core.hybrid.a;

import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends o {
    private m aSf;

    public e(m mVar) {
        super(mVar);
        this.aSf = mVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.o
    public String vJ() {
        return "TBHY_COMMON_SHOW_SHARE_DIALOG";
    }

    @p(Bi = false, value = "showShareDialog")
    protected void showShareDialog(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("content");
            String optString3 = jSONObject.optString("imgUrl");
            String optString4 = jSONObject.optString("shareUrl");
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = optString;
            dVar.content = optString2;
            if (optString3 == null) {
                dVar.bje = null;
            } else {
                dVar.bje = Uri.parse(optString3);
            }
            dVar.linkUrl = optString4;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.aSf.getContext(), dVar, true);
            shareDialogConfig.setIsSupportNightMode(true);
            shareDialogConfig.setIsCopyLink(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
