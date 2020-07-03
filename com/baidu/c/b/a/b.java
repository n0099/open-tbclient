package com.baidu.c.b.a;

import android.content.Context;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.c.a.b.c;
import com.baidu.c.a.b.d;
/* loaded from: classes6.dex */
public class b implements d {
    private Context mContext;

    public b(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.baidu.c.a.b.d
    public c n(Context context, String str, String str2) {
        return new a(context, BIMManager.getConversation(this.mContext, str, BIMManager.CATEGORY.STUDIO, str2, 2));
    }

    @Override // com.baidu.c.a.b.d
    public void a(final com.baidu.c.a.b.a aVar) {
        BIMManager.registerConnectListener(new IConnectListener() { // from class: com.baidu.c.b.a.b.1
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                if (aVar != null) {
                    aVar.onResult(i);
                }
            }
        });
    }

    @Override // com.baidu.c.a.b.d
    public void unregisterConnectListener() {
        BIMManager.unregisterConnectListener();
    }

    @Override // com.baidu.c.a.b.d
    public void KW() {
        BIMManager.tryConnection(this.mContext);
    }
}
