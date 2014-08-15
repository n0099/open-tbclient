package com.baidu.adp.lib.stats;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BdErrorLog extends BdNormalStatBase {
    private static final long serialVersionUID = -1354410718428154428L;

    public BdErrorLog(Context context, String str, boolean z) {
        super(context, str, z);
        this.mMaxMemCount = 50;
        this.mFilePrefixString = "err";
        this.mFileSuffixString = ".log";
    }

    @Override // com.baidu.adp.lib.stats.BdNormalStatBase, com.baidu.adp.lib.stats.BdStatBase
    public void uploadSucc(ArrayList<s> arrayList) {
        super.uploadSucc(arrayList);
        r a = f.c().a();
        if (a != null) {
            a.c(this.mLastUploadTime);
        }
    }
}
