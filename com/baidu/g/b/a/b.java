package com.baidu.g.b.a;

import android.content.Context;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.g.a.b.c;
import com.baidu.g.a.b.d;
/* loaded from: classes3.dex */
public class b implements d {
    private Context mContext;

    public b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.baidu.g.a.b.d
    public c l(Context context, String str, String str2) {
        return new a(context, BIMManager.getConversation(this.mContext, str, BIMManager.CATEGORY.STUDIO, str2, 2));
    }

    @Override // com.baidu.g.a.b.d
    public void a(final com.baidu.g.a.b.a aVar) {
        BIMManager.registerConnectListener(new IConnectListener() { // from class: com.baidu.g.b.a.b.1
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                if (aVar != null) {
                    aVar.onResult(i);
                }
            }
        });
    }

    @Override // com.baidu.g.a.b.d
    public void unregisterConnectListener() {
        BIMManager.unregisterConnectListener();
    }

    @Override // com.baidu.g.a.b.d
    public void BR() {
        BIMManager.tryConnection(this.mContext);
    }
}
