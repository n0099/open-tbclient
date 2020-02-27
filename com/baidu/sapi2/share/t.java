package com.baidu.sapi2.share;

import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class t implements ShareStorage.a {
    final /* synthetic */ ShareStorage a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ShareStorage shareStorage) {
        this.a = shareStorage;
    }

    @Override // com.baidu.sapi2.share.ShareStorage.a
    public void a(ShareStorage.StorageModel storageModel) {
        ThreadPoolService.getInstance().run(new TPRunnable(new s(this, storageModel)));
    }
}
