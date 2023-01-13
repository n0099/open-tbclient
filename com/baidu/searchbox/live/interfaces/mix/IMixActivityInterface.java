package com.baidu.searchbox.live.interfaces.mix;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.lifecycle.Lifecycle;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\"\u0010\fJ\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b#\u0010\u000eJ)\u0010(\u001a\u00020'2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010%H&¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u001aH&¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b-\u0010\u000eJ7\u00102\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120.2\u0006\u00101\u001a\u000200H&¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b4\u0010\u000eJ\u0017\u00105\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b5\u0010\u000eJ\u0017\u00106\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b6\u0010\u000eJ#\u0010;\u001a\u0004\u0018\u00010:2\u0006\u00107\u001a\u00020\u00122\b\u00109\u001a\u0004\u0018\u000108H&¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020=H&¢\u0006\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Lkotlin/Any;", "Landroid/content/Context;", "newBase", "", "attachBaseContext", "(Landroid/content/Context;)V", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "beforeCreate", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "finish", "(Landroid/app/Activity;)V", "Landroidx/lifecycle/Lifecycle;", "getLifeCycle", "()Landroidx/lifecycle/Lifecycle;", "", "templateId", "Lcom/baidu/searchbox/live/interfaces/mix/IMixShellInterface;", "getShell", "(Landroid/app/Activity;Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/mix/IMixShellInterface;", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/app/Activity;Landroid/content/res/Configuration;)V", "onCreate", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(Landroid/app/Activity;ILandroid/view/KeyEvent;)Z", IntentData.KEY, "onNewIntent", "(Landroid/app/Activity;Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(Landroid/app/Activity;I[Ljava/lang/String;[I)V", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "key", "", "ext", "Lorg/json/JSONObject;", "setMixEventDispatcher", "(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;", "Lcom/baidu/searchbox/live/interfaces/mix/MixInvokeAbility;", "ability", "setMixInvokeAbility", "(Lcom/baidu/searchbox/live/interfaces/mix/MixInvokeAbility;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface IMixActivityInterface {
    void attachBaseContext(Context context);

    void beforeCreate(Activity activity, Bundle bundle);

    void finish(Activity activity);

    Lifecycle getLifeCycle();

    IMixShellInterface getShell(Activity activity, String str);

    void onActivityResult(Activity activity, int i, int i2, Intent intent);

    void onConfigurationChanged(Activity activity, Configuration configuration);

    void onCreate(Activity activity, Bundle bundle);

    void onDestroy(Activity activity);

    boolean onKeyDown(Activity activity, int i, KeyEvent keyEvent);

    void onNewIntent(Activity activity, Intent intent);

    void onPause(Activity activity);

    void onRequestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr);

    void onResume(Activity activity);

    void onStart(Activity activity);

    void onStop(Activity activity);

    JSONObject setMixEventDispatcher(String str, Object obj);

    void setMixInvokeAbility(MixInvokeAbility mixInvokeAbility);
}
