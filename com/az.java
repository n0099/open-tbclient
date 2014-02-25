package com;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import com.ay;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ay.b a;
    final /* synthetic */ ay b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar, ay.b bVar) {
        this.b = ayVar;
        this.a = bVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ay.a aVar;
        ShareMediaItem shareMediaItem = (ShareMediaItem) compoundButton.getTag();
        if (shareMediaItem != null) {
            if (shareMediaItem.isAuthorized()) {
                if (shareMediaItem.isChecked() != z) {
                    shareMediaItem.setChecked(z);
                    aVar = this.b.a;
                    aVar.onCheckStatusChanged(z, shareMediaItem.getMediaType());
                }
                this.a.b.setImageResource(shareMediaItem.isChecked() ? aq.c(this.b.getContext(), "bdsocialshare_" + shareMediaItem.getMediaType().toString()) : aq.c(this.b.getContext(), "bdsocialshare_" + shareMediaItem.getMediaType().toString() + "_gray"));
            } else if (shareMediaItem.isAuthorized() || !z) {
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(SocialConstants.PARAM_CLIENT_ID, SocialShare.getInstance(this.b.getContext()).getClientId());
                bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, shareMediaItem.getMediaType().toString());
                Intent intent = new Intent(this.b.getContext(), SocialOAuthActivity.class);
                intent.addFlags(268435456);
                intent.putExtras(bundle);
                SocialOAuthActivity.setListener(new ba(this, shareMediaItem));
                this.b.getContext().getApplicationContext().startActivity(intent);
            }
        }
    }
}
