package com.baidu.searchbox.player.remote;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes3.dex */
public class BDPlayerServiceProxyWrapper {
    private static IPlayerServiceProxy EMPTY = new IPlayerServiceProxy() { // from class: com.baidu.searchbox.player.remote.BDPlayerServiceProxyWrapper.1
        @Override // com.baidu.searchbox.player.remote.BDPlayerServiceProxyWrapper.IPlayerServiceProxy
        public void onServiceBind(Context context) {
        }

        @Override // com.baidu.searchbox.player.remote.BDPlayerServiceProxyWrapper.IPlayerServiceProxy
        public long getNetHandle() {
            return 0L;
        }
    };
    private static volatile IPlayerServiceProxy mHelper;

    /* loaded from: classes3.dex */
    public interface IPlayerServiceProxy {
        long getNetHandle();

        void onServiceBind(Context context);
    }

    @PublicMethod
    public static void setHelper(@NonNull IPlayerServiceProxy iPlayerServiceProxy) {
        mHelper = iPlayerServiceProxy;
    }

    @PublicMethod
    public void removeHelper() {
        mHelper = null;
    }

    /* loaded from: classes3.dex */
    static class Impl {
        Impl() {
        }

        public static IPlayerServiceProxy get() {
            return BDPlayerServiceProxyWrapper.mHelper != null ? BDPlayerServiceProxyWrapper.mHelper : BDPlayerServiceProxyWrapper.EMPTY;
        }
    }
}
