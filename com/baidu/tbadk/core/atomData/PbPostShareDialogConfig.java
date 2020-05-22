package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.pb.data.k;
/* loaded from: classes.dex */
public class PbPostShareDialogConfig extends ShareDialogConfig {
    private k mPbPostData;

    public PbPostShareDialogConfig(Context context, ShareItem shareItem, boolean z, k kVar) {
        super(context, shareItem, z);
        this.mPbPostData = kVar;
    }

    public k getPbPostData() {
        return this.mPbPostData;
    }
}
