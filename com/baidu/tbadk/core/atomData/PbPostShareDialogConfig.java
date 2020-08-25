package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.pb.data.m;
/* loaded from: classes2.dex */
public class PbPostShareDialogConfig extends ShareDialogConfig {
    private m mPbPostData;

    public PbPostShareDialogConfig(Context context, ShareItem shareItem, boolean z, m mVar) {
        super(context, shareItem, z);
        this.mPbPostData = mVar;
    }

    public m getPbPostData() {
        return this.mPbPostData;
    }
}
