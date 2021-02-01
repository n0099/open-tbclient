package com.baidu.live.tbadk.data;
/* loaded from: classes11.dex */
public class ShareEntity {
    public static final int ALA_PREPARE_SHARE_QQ = 4;
    public static final int ALA_PREPARE_SHARE_SINA_WEIBO = 1;
    public static final int ALA_PREPARE_SHARE_WEIXIN = 2;
    public static final int ALA_PREPARE_SHARE_WEIXIN_CIRCLE = 3;
    public String content;
    public String imageUrl;
    public String linkUrl;
    public long liveId;
    public String sharePicType;
    public int shareType;
    public String title;
    public String type;
    public long userId;
    public String userName;

    public boolean sharePanel() {
        return this.shareType == 0;
    }

    public boolean shareToQQ() {
        return this.shareType == 4;
    }

    public boolean shareToSinaWeibo() {
        return this.shareType == 1;
    }

    public boolean shareToWeixinCircle() {
        return this.shareType == 3;
    }

    public boolean shareToWeixin() {
        return this.shareType == 2;
    }
}
