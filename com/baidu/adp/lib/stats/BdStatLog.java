package com.baidu.adp.lib.stats;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BdStatLog extends BdNormalStatBase {
    private static final long serialVersionUID = 910754620140826704L;

    public BdStatLog(Context context, String str, boolean z) {
        super(context, str, z);
        this.mMaxMemCount = 10;
        this.mFilePrefixString = "stat";
        this.mFileSuffixString = ".log";
        this.mUseSdCard = false;
        this.mCanTrySuccess = false;
    }

    @Override // com.baidu.adp.lib.stats.BdNormalStatBase, com.baidu.adp.lib.stats.BdStatBase
    public String getPostFileName() {
        return "stat";
    }

    @Override // com.baidu.adp.lib.stats.BdNormalStatBase, com.baidu.adp.lib.stats.BdStatBase
    public void uploadSucc(ArrayList<s> arrayList) {
        super.uploadSucc(arrayList);
        r eo = f.eq().eo();
        if (eo != null) {
            eo.h(this.mLastUploadTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.stats.BdStatBase
    public int getLogFilesMaxSize() {
        return 0;
    }
}
