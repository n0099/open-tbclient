package com.baidu.searchbox.util;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import kotlin.Metadata;
@Autowired
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/util/TNRuntime;", "", "()V", "mTNContext", "Lcom/baidu/searchbox/util/ITNContext;", "getTNContext", "lib_blc_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
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
