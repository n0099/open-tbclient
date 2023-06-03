package com.baidu.searchbox.player.remote;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class BDPlayerServiceProxyWrapper {
    public static final IPlayerServiceProxy EMPTY = new IPlayerServiceProxy() { // from class: com.baidu.searchbox.player.remote.BDPlayerServiceProxyWrapper.1
        @Override // com.baidu.searchbox.player.remote.BDPlayerServiceProxyWrapper.IPlayerServiceProxy
        public long getNetHandle() {
            return 0L;
        }

        @Override // com.baidu.searchbox.player.remote.BDPlayerServiceProxyWrapper.IPlayerServiceProxy
        public void onServiceBind(Context context, Intent intent) {
        }
    };
    public static volatile IPlayerServiceProxy mHelper;

    /* loaded from: classes4.dex */
    public interface IPlayerServiceProxy {
        long getNetHandle();

        void onServiceBind(Context context, Intent intent);
    }

    /* loaded from: classes4.dex */
    public static class Impl {
        public static IPlayerServiceProxy get() {
            return BDPlayerServiceProxyWrapper.mHelper != null ? BDPlayerServiceProxyWrapper.mHelper : BDPlayerServiceProxyWrapper.EMPTY;
        }
    }

    public void removeHelper() {
        mHelper = null;
    }

    public static void setHelper(@NonNull IPlayerServiceProxy iPlayerServiceProxy) {
        mHelper = iPlayerServiceProxy;
    }
}
