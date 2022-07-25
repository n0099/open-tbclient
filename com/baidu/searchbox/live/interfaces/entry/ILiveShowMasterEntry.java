package com.baidu.searchbox.live.interfaces.entry;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001:\u0001\u0017J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0011J'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/entry/ILiveShowMasterEntry;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "params", "", "createLiveRoom", "(Landroid/content/Context;Ljava/lang/String;)V", "", "isArSdkLoaded", "()Z", "Lcom/baidu/searchbox/live/interfaces/entry/ILiveShowMasterEntry$ArSdkLoadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "loadArSdk", "(Lcom/baidu/searchbox/live/interfaces/entry/ILiveShowMasterEntry$ArSdkLoadCallback;)V", "openAdminListPage", "(Landroid/content/Context;)V", "openForbiddenListPage", "userId", "certifyStatus", "openRealAuthPage", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "ArSdkLoadCallback", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ILiveShowMasterEntry {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/entry/ILiveShowMasterEntry$ArSdkLoadCallback;", "Lkotlin/Any;", "", "total", "progress", "", "onProgress", "(II)V", "", TiebaStatic.LogFields.RESULT, "", "msg", "onResult", "(ZLjava/lang/String;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface ArSdkLoadCallback {
        void onProgress(int i, int i2);

        void onResult(boolean z, String str);
    }

    void createLiveRoom(Context context, String str);

    boolean isArSdkLoaded();

    void loadArSdk(ArSdkLoadCallback arSdkLoadCallback);

    void openAdminListPage(Context context);

    void openForbiddenListPage(Context context);

    void openRealAuthPage(Context context, String str, String str2);
}
