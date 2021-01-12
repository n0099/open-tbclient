package com.baidu.swan.apps.inlinewidget;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.inlinewidget.d;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public abstract class a<W extends d> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public abstract void a(@NonNull ZeusPlugin.Command command, @NonNull W w);

    @NonNull
    public abstract String avy();

    public void a(@NonNull ZeusPlugin.Command command) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull W w, @Nullable String str, @Nullable String str2, boolean z) {
        if (DEBUG) {
            String str3 = ("【" + w.avA() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + w.hashCode() + "】\t") + "【" + str + "】";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + "\t【" + str2 + "】";
            }
            if (z) {
                com.baidu.swan.apps.console.c.i("【InlineCommand】", str3);
            } else {
                Log.v("【InlineCommand】", str3);
            }
        }
    }
}
