package com.baidu.h.b.a;

import android.content.Context;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.h.a.b.c;
import com.baidu.h.a.b.d;
/* loaded from: classes10.dex */
public class b implements d {
    private Context mContext;

    public b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.baidu.h.a.b.d
    public c c(Context context, String str, String str2, boolean z) {
        return new a(context, BIMManager.getConversation(this.mContext, str, z, BIMManager.CATEGORY.STUDIO, str2, 2));
    }

    @Override // com.baidu.h.a.b.d
    public void a(final com.baidu.h.a.b.a aVar) {
        BIMManager.registerConnectListener(new IConnectListener() { // from class: com.baidu.h.b.a.b.1
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                if (aVar != null) {
                    aVar.onResult(i);
                }
            }
        });
    }

    @Override // com.baidu.h.a.b.d
    public void unregisterConnectListener() {
        BIMManager.unregisterConnectListener();
    }

    @Override // com.baidu.h.a.b.d
    public void ZP() {
        BIMManager.tryConnection(this.mContext);
    }
}
