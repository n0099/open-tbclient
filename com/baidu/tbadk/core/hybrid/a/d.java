package com.baidu.tbadk.core.hybrid.a;

import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.p;
import com.sina.weibo.sdk.constant.WBConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends o {
    private m aTN;

    public d(m mVar) {
        super(mVar);
        this.aTN = mVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.o
    public String ww() {
        return "TBHY_COMMON_SHOW_SHARE_DIALOG";
    }

    @p(BC = false, value = "showShareDialog")
    protected void showShareDialog(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("content");
            String optString3 = jSONObject.optString("imgUrl");
            String optString4 = jSONObject.optString(WBConstants.SDK_WEOYOU_SHAREURL);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = optString;
            dVar.content = optString2;
            if (optString3 == null) {
                dVar.blB = null;
            } else {
                dVar.blB = Uri.parse(optString3);
            }
            dVar.linkUrl = optString4;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.aTN.getContext(), dVar, true);
            shareDialogConfig.setIsSupportNightMode(true);
            shareDialogConfig.setIsCopyLink(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
