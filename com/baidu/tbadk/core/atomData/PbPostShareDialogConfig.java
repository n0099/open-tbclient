package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.pb.data.n;
/* loaded from: classes.dex */
public class PbPostShareDialogConfig extends ShareDialogConfig {
    private n mPbPostData;

    public PbPostShareDialogConfig(Context context, ShareItem shareItem, boolean z, n nVar) {
        super(context, shareItem, z);
        this.mPbPostData = nVar;
    }

    public n getPbPostData() {
        return this.mPbPostData;
    }
}
