package com.baidu.searchbox.live.interfaces.mix;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.lifecycle.Lifecycle;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b$\u0010\fJ\u0017\u0010%\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b%\u0010\u0010J)\u0010*\u001a\u00020)2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010'H&¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u001cH&¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b/\u0010\u0010J7\u00104\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u0014002\u0006\u00103\u001a\u000202H&¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b6\u0010\u0010J\u0017\u00107\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b7\u0010\u0010J\u0017\u00108\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b8\u0010\u0010J#\u0010=\u001a\u0004\u0018\u00010<2\u0006\u00109\u001a\u00020\u00142\b\u0010;\u001a\u0004\u0018\u00010:H&¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020?H&¢\u0006\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "Lkotlin/Any;", "Landroid/content/Context;", "newBase", "", "attachBaseContext", "(Landroid/content/Context;)V", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "beforeCreate", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "dispatchFinishLifecycle", "()V", "finish", "(Landroid/app/Activity;)V", "Landroidx/lifecycle/Lifecycle;", "getLifeCycle", "()Landroidx/lifecycle/Lifecycle;", "", "templateId", "Lcom/baidu/searchbox/live/interfaces/mix/IMixShellInterface;", "getShell", "(Landroid/app/Activity;Ljava/lang/String;)Lcom/baidu/searchbox/live/interfaces/mix/IMixShellInterface;", "", AiBotChatDispatcher.AI_SINGLE_REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/app/Activity;Landroid/content/res/Configuration;)V", "onCreate", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(Landroid/app/Activity;ILandroid/view/KeyEvent;)Z", "intent", "onNewIntent", "(Landroid/app/Activity;Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(Landroid/app/Activity;I[Ljava/lang/String;[I)V", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "key", "", "ext", "Lorg/json/JSONObject;", "setMixEventDispatcher", "(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;", "Lcom/baidu/searchbox/live/interfaces/mix/MixInvokeAbility;", "ability", "setMixInvokeAbility", "(Lcom/baidu/searchbox/live/interfaces/mix/MixInvokeAbility;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IMixActivityInterface {
    void attachBaseContext(Context context);

    void beforeCreate(Activity activity, Bundle bundle);

    void dispatchFinishLifecycle();

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
