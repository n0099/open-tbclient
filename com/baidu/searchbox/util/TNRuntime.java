package com.baidu.searchbox.util;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import kotlin.Metadata;
@Autowired
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/util/TNRuntime;", "Lcom/baidu/searchbox/util/ITNContext;", "getTNContext", "()Lcom/baidu/searchbox/util/ITNContext;", "mTNContext", "Lcom/baidu/searchbox/util/ITNContext;", "<init>", "()V", "lib_blc_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class TNRuntime {
    public static final TNRuntime INSTANCE = new TNRuntime();
    public static final ITNContext mTNContext = new ITNContext() { // from class: com.baidu.searchbox.util.TNRuntime$mTNContext$1
        @Override // com.baidu.searchbox.util.ITNContext
        public boolean isNeedReloadTN() {
            return false;
        }
    };

    @Inject(force = false)
    public final ITNContext getTNContext() {
        return mTNContext;
    }
}
