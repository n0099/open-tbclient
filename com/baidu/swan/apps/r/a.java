package com.baidu.swan.apps.r;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.r.d;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public abstract class a<W extends d> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @NonNull
    public abstract String Tv();

    public abstract void a(@NonNull ZeusPlugin.Command command, @NonNull W w);

    public void a(@NonNull ZeusPlugin.Command command) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull W w, @Nullable String str, @Nullable String str2, boolean z) {
        if (DEBUG) {
            String str3 = ("【" + w.Tx() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + w.hashCode() + "】\t") + "【" + str + "】";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + "\t【" + str2 + "】";
            }
            if (z) {
                Log.d("【InlineCommand】", str3);
            } else {
                Log.v("【InlineCommand】", str3);
            }
        }
    }
}
