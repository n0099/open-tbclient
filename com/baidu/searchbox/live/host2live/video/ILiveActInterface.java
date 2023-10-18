package com.baidu.searchbox.live.host2live.video;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010 \u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\tH&¢\u0006\u0004\b\"\u0010\u000b¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "Lkotlin/Any;", "", "scheme", "", CriusAttrConstants.POSITION, "Lcom/baidu/searchbox/live/host2live/video/ILiveItem;", "getLiveItem", "(Ljava/lang/String;I)Lcom/baidu/searchbox/live/host2live/video/ILiveItem;", "", "init", "()V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "release", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface ILiveActInterface {
    ILiveItem getLiveItem(String str, int i);

    void init();

    void onActivityResult(int i, int i2, Intent intent);

    void onConfigurationChanged(Configuration configuration);

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void release();
}
