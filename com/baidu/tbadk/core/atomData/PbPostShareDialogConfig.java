package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import d.a.n0.e2.h.m;
/* loaded from: classes3.dex */
public class PbPostShareDialogConfig extends ShareDialogConfig {
    public m mPbPostData;

    public PbPostShareDialogConfig(Context context, ShareItem shareItem, boolean z, m mVar) {
        super(context, shareItem, z);
        this.mPbPostData = mVar;
    }

    public m getPbPostData() {
        return this.mPbPostData;
    }
}
