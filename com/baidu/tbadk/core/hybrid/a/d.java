package com.baidu.tbadk.core.hybrid.a;

import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends n {
    private l bHm;

    public d(l lVar) {
        super(lVar);
        this.bHm = lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String VG() {
        return "TBHY_COMMON_SHOW_SHARE_DIALOG";
    }

    @o(abG = false, value = "showShareDialog")
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
                dVar.imageUri = null;
            } else {
                dVar.imageUri = Uri.parse(optString3);
            }
            dVar.linkUrl = optString4;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.bHm.getContext(), dVar, true);
            shareDialogConfig.setIsSupportNightMode(true);
            shareDialogConfig.setIsCopyLink(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
