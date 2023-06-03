package com.baidu.searchbox.yy.gameassist;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b&\u0018\u0000B\u0007¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/yy/gameassist/PluginLoadCallback;", "", "retCode", "", "retMsg", "", "onFailed", "(ILjava/lang/String;)V", "", "retObject", "loadType", "onResult", "(Ljava/lang/Object;Ljava/lang/String;)V", "<init>", "()V", "lib-gameassist-host_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public abstract class PluginLoadCallback {
    public abstract void onResult(Object obj, String str);

    public void onFailed(int i, String str) {
        YalogKt.yalog("PluginLoadCallback", "onFailed, retCode = " + i + ", retMsg = " + str);
    }
}
