package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.content.Context;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
/* loaded from: classes.dex */
public class ShareMediaItem {
    private MediaType a;
    private boolean b = false;
    private boolean c = false;
    private String d;
    private int e;

    private ShareMediaItem(Context context, MediaType mediaType) {
        this.a = mediaType;
    }

    public static ShareMediaItem create(Context context, MediaType mediaType) {
        Validator.notNull(context, "context");
        Validator.notNull(mediaType, "mediaType");
        switch (mediaType) {
            case SINAWEIBO:
                ShareMediaItem shareMediaItem = new ShareMediaItem(context, mediaType);
                shareMediaItem.setLimitCount(SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN);
                return shareMediaItem;
            case QQWEIBO:
                ShareMediaItem shareMediaItem2 = new ShareMediaItem(context, mediaType);
                shareMediaItem2.setLimitCount(SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN);
                return shareMediaItem2;
            case RENREN:
                ShareMediaItem shareMediaItem3 = new ShareMediaItem(context, mediaType);
                shareMediaItem3.setLimitCount(140);
                return shareMediaItem3;
            case KAIXIN:
                ShareMediaItem shareMediaItem4 = new ShareMediaItem(context, mediaType);
                shareMediaItem4.setLimitCount(140);
                return shareMediaItem4;
            case QZONE:
                ShareMediaItem shareMediaItem5 = new ShareMediaItem(context, mediaType);
                shareMediaItem5.setLimitCount(80);
                return shareMediaItem5;
            default:
                return null;
        }
    }

    public int getLimitCount() {
        return this.e;
    }

    public MediaType getMediaType() {
        return this.a;
    }

    public String getUserName() {
        return this.d;
    }

    public boolean isAuthorized() {
        return this.b;
    }

    public boolean isChecked() {
        return this.c;
    }

    public void setAuthorized(boolean z) {
        this.b = z;
    }

    public void setChecked(boolean z) {
        this.c = z;
    }

    public void setLimitCount(int i) {
        this.e = i;
    }

    public void setUserName(String str) {
        this.d = str;
    }
}
