package com.baidu.searchbox.live.interfaces.player;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/IDuMediaInstallListener;", "Lkotlin/Any;", "", "installType", "errorType", "", "detail", "", "onInstallError", "(IILjava/lang/String;)V", "progress", "onInstallProgress", "(II)V", "coreVer", "onInstallSuccess", "(ILjava/lang/String;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IDuMediaInstallListener {
    void onInstallError(int i, int i2, String str);

    void onInstallProgress(int i, int i2);

    void onInstallSuccess(int i, String str);
}
