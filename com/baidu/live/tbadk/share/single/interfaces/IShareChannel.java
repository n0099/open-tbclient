package com.baidu.live.tbadk.share.single.interfaces;

import com.baidu.live.tbadk.data.ShareEntity;
/* loaded from: classes11.dex */
public interface IShareChannel {
    void shareToQQ(ShareEntity shareEntity, IShareCallback iShareCallback);

    void shareToSinaWeibo(ShareEntity shareEntity, IShareCallback iShareCallback);

    void shareToWeixin(ShareEntity shareEntity, IShareCallback iShareCallback);

    void shareToWeixinCircle(ShareEntity shareEntity, IShareCallback iShareCallback);
}
