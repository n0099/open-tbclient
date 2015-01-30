package com.baidu.adp.lib.stats;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BdPerformanceLog extends BdNormalStatBase {
    private static final long serialVersionUID = 354211057549327560L;

    public BdPerformanceLog(Context context, String str, boolean z) {
        super(context, str, z);
        this.mMaxMemCount = 50;
        this.mFilePrefixString = "pf";
        this.mFileSuffixString = ".log";
    }

    @Override // com.baidu.adp.lib.stats.BdNormalStatBase, com.baidu.adp.lib.stats.BdStatBase
    public void uploadSucc(ArrayList<s> arrayList) {
        super.uploadSucc(arrayList);
        r eo = f.eq().eo();
        if (eo != null) {
            eo.j(this.mLastUploadTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.stats.BdStatBase
    public int getLogFilesMaxSize() {
        return 31457280;
    }
}
