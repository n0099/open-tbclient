package com;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareDialog;
/* loaded from: classes.dex */
public class ab extends CloudBatchShareHandler {
    private MediaType a;

    public ab(Context context, String str, MediaType mediaType) {
        super(context, str, null);
        this.mClientId = str;
        this.a = mediaType;
    }

    private void a(ShareContent shareContent, SessionManager.Session session, IBaiduListener iBaiduListener) {
        MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
        multipartRequestParams.put("access_token", session.getAccessToken());
        doShare(shareContent, multipartRequestParams, iBaiduListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler
    public String getShareUploadUrl() {
        return "/api/2.0/share/upload";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler
    public String getShareUrl() {
        return "/api/2.0/share";
    }

    @Override // com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler, com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        SessionManager sessionManager = SessionManager.getInstance(this.mContext);
        SessionManager.Session session = sessionManager.get(this.a.toString());
        if (session != null && !session.isExpired()) {
            if (!z) {
                a(shareContent, session, iBaiduListener);
                return;
            }
            this.mShareDialog = new ShareDialog(this.mContext, shareContent, this.a, iBaiduListener);
            this.mShareDialog.show();
            this.mShareDialog.setOnDismissListener(new b(this));
            return;
        }
        if (session != null) {
            sessionManager.remove(this.a.toString());
        }
        c cVar = new c(this, iBaiduListener, shareContent, z);
        Bundle bundle = new Bundle();
        bundle.putString(SocialConstants.PARAM_CLIENT_ID, this.mClientId);
        bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, this.a.toString());
        Intent intent = new Intent(this.mContext, SocialOAuthActivity.class);
        intent.addFlags(268435456);
        intent.putExtras(bundle);
        SocialOAuthActivity.setListener(cVar);
        this.mContext.getApplicationContext().startActivity(intent);
    }
}
