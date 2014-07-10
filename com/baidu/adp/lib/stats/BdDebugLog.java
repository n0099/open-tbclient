package com.baidu.adp.lib.stats;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BdDebugLog extends BdNormalStatBase {
    private static final long serialVersionUID = -5136155551965080815L;

    public BdDebugLog(Context context, String str, boolean z) {
        super(context, str, z);
        this.mMaxMemCount = 500;
        this.mFilePrefixString = "dbg";
        this.mFileSuffixString = ".log";
    }

    @Override // com.baidu.adp.lib.stats.BdNormalStatBase, com.baidu.adp.lib.stats.BdStatBase
    public void uploadSucc(ArrayList<q> arrayList) {
        super.uploadSucc(arrayList);
        p a = d.b().a();
        if (a != null) {
            a.b(this.mLastUploadTime);
        }
    }
}
