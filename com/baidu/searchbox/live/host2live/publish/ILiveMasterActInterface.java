package com.baidu.searchbox.live.host2live.publish;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\bJ\u001f\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b!\u0010\"J!\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010$H&¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0004H&¢\u0006\u0004\b(\u0010\bJ-\u0010-\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020$0)2\u0006\u0010,\u001a\u00020+H&¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0004H&¢\u0006\u0004\b/\u0010\bJ\u000f\u00100\u001a\u00020\u0004H&¢\u0006\u0004\b0\u0010\bJ\u000f\u00101\u001a\u00020\u0004H&¢\u0006\u0004\b1\u0010\b¨\u00062"}, d2 = {"Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterActInterface;", "Lkotlin/Any;", "Landroid/content/Context;", "newBase", "", "attachBaseContext", "(Landroid/content/Context;)V", "finish", "()V", "context", "Landroid/view/View;", "getLiveMasterView", "(Landroid/content/Context;)Landroid/view/View;", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "show", "", "scheme", "onLiveTabInitCreate", "(ZLjava/lang/String;)V", MissionEvent.MESSAGE_PAUSE, "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface ILiveMasterActInterface {
    void attachBaseContext(Context context);

    void finish();

    View getLiveMasterView(Context context);

    void onActivityResult(int i, int i2, Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onCreate(Bundle bundle);

    void onDestroy();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onLiveTabInitCreate(boolean z, String str);

    void onPause();

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onResume();

    void onStart();

    void onStop();
}
