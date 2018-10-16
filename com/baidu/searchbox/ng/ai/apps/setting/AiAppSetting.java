package com.baidu.searchbox.ng.ai.apps.setting;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.network.update.node.AiAppsAccreditNode;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.runtime.Ability;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.AiAppComponent;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.TaskResult;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.TaskState;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.request.Authorize;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.request.LoginRequest;
import com.baidu.searchbox.ng.ai.apps.storage.AiAppSharedPrefsWrapper;
import com.baidu.searchbox.ng.ai.apps.util.task.Task;
import com.baidu.searchbox.ng.ai.apps.util.task.TaskQueue;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class AiAppSetting extends AiAppComponent implements Ability, SettingDef {
    public static final boolean DEBUG = false;
    public static final String KEY_INSTALLED_DEBUG_BUNDLE_MD5 = "installed_debug_bundle_md5";
    public static final String KEY_SWAN_JS_MD5 = "installed_swan_js_md5";
    public static final String LOG_TAG = "AiAppSetting";
    private static final String PREFIX = "aiapp_setting_";
    private final Map<String, Authorize> mAuthorizePool;
    public final TaskQueue mAuthorizeQueue;
    private final Set<SettingCallback> mCallbacks;
    private AiAppSharedPrefsWrapper mPref;
    public final String name;
    public final String prefName;

    /* loaded from: classes2.dex */
    public interface SettingCallback {
        void onSettingFinish();
    }

    public AiAppSetting(AiApp aiApp) {
        super(aiApp);
        this.mCallbacks = new HashSet();
        this.mAuthorizePool = new HashMap();
        this.mAuthorizeQueue = new TaskQueue();
        this.name = aiApp.id;
        this.prefName = PREFIX + this.name;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public boolean available() {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public boolean enable() {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public void disable() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public boolean enabled() {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.AiAppComponent
    public void onDestory() {
        super.onDestory();
        clearCallbacks();
        this.mAuthorizePool.clear();
    }

    public void onActivityResume(Activity activity) {
    }

    private AiAppSharedPrefsWrapper getPref() {
        if (this.mPref == null) {
            this.mPref = new AiAppSharedPrefsWrapper(this.prefName);
        }
        return this.mPref;
    }

    public void clear() {
        getPref().edit().clear().apply();
    }

    public void putBoolean(String str, boolean z) {
        getPref().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        getPref().putString(str, str2);
    }

    public void putStringSet(String str, Set<String> set) {
        AiAppSharedPrefsWrapper pref = getPref();
        pref.remove(str);
        pref.putStringSet(str, set);
    }

    public boolean has(String str) {
        return this.mPref.contains(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return getPref().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return getPref().getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return getPref().getStringSet(str, set);
    }

    public Map<String, ?> get() {
        return getPref().getAll();
    }

    public void checkOrAuthorize(final Activity activity, final String str, final TypedCallback<Boolean> typedCallback) {
        checkAuthorize(str, new TypedCallback<ScopeInfo>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(ScopeInfo scopeInfo) {
                if (scopeInfo == null || scopeInfo.forbidden) {
                    AiAppSetting.this.notifyResultCallback(typedCallback, false);
                } else if (scopeInfo.tipStatus != 0) {
                    AiAppSetting.this.notifyResultCallback(typedCallback, Boolean.valueOf(scopeInfo.tipStatus > 0));
                } else {
                    AiAppSetting.this.authorize(activity, str, new TypedCallback<TaskResult<Authorize.Result>>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                        public void onCallback(TaskResult<Authorize.Result> taskResult) {
                            AiAppSetting.this.notifyResultCallback(typedCallback, Boolean.valueOf(taskResult != null && taskResult.isOk() && taskResult.mData.permit));
                        }
                    });
                }
            }
        });
    }

    public void checkAuthorize(String str, final TypedCallback<ScopeInfo> typedCallback) {
        if (TextUtils.isEmpty(str)) {
            notifyResultCallback(typedCallback, null);
        } else {
            AiAppsAccreditNode.getAccreditListData(str, new TypedCallback<ScopeInfo>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(ScopeInfo scopeInfo) {
                    AiAppSetting.this.notifyResultCallback(typedCallback, scopeInfo);
                }
            });
        }
    }

    public void authorize(Activity activity, TypedCallback<TaskResult<Authorize.Result>> typedCallback) {
        authorize(activity, null, true, true, typedCallback);
    }

    public void authorize(Activity activity, String str, TypedCallback<TaskResult<Authorize.Result>> typedCallback) {
        authorize(activity, str, true, false, typedCallback);
    }

    public void authorize(Activity activity, String str, boolean z, boolean z2, TypedCallback<TaskResult<Authorize.Result>> typedCallback) {
        preformAuthorize(activity, str, z, z2, typedCallback);
    }

    private void preformAuthorize(Activity activity, final String str, boolean z, boolean z2, TypedCallback<TaskResult<Authorize.Result>> typedCallback) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        Authorize authorize = this.mAuthorizePool.get(str);
        if (authorize != null && TaskState.FINISHED != authorize.getStatus()) {
            authorize.regCallback(typedCallback);
            return;
        }
        final Authorize authorize2 = new Authorize(activity, z, str, z2);
        this.mAuthorizePool.put(str, authorize2);
        authorize2.regCallback(typedCallback).regCallback(new TypedCallback<TaskResult<Authorize.Result>>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(TaskResult<Authorize.Result> taskResult) {
                AiAppSetting.this.mAuthorizePool.remove(str);
            }
        });
        this.mAuthorizeQueue.offer(new Task() { // from class: com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.4
            @Override // java.lang.Runnable
            public void run() {
                authorize2.regCallback(new TypedCallback<TaskResult<Authorize.Result>>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                    public void onCallback(TaskResult<Authorize.Result> taskResult) {
                        finish();
                    }
                });
                authorize2.call();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void notifyResultCallback(TypedCallback<ResulT> typedCallback, final ResulT result) {
        notifyCallback(typedCallback, new Callbacker<TypedCallback<ResulT>>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.Callbacker
            public void exec(TypedCallback<ResulT> typedCallback2) {
                typedCallback2.onCallback(result);
            }
        });
    }

    public boolean startSettingFragment() {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.aiapps_open_fragment_failed_toast).showToast();
            return false;
        }
        aiAppsFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_NAVIGATE_TO).setCustomAnimations(AiAppsFragmentManager.ANIM_ENTER, AiAppsFragmentManager.ANIM_HOLD).pushFragment(AiAppsFragmentManager.SETTING, null).commit();
        return true;
    }

    public synchronized void regCallback(SettingCallback settingCallback) {
        this.mCallbacks.add(settingCallback);
    }

    public synchronized void unregCallback(SettingCallback settingCallback) {
        this.mCallbacks.remove(settingCallback);
    }

    public synchronized void clearCallbacks() {
        this.mCallbacks.clear();
    }

    public synchronized void clearAuthorizeAndCallback() {
        this.mAuthorizePool.clear();
        this.mAuthorizeQueue.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void notifyCallbacks(Collection<CallBackT> collection, Callbacker<CallBackT> callbacker) {
        for (CallBackT callbackt : collection) {
            notifyCallback(callbackt, callbacker);
        }
    }

    public synchronized <CallBackT> void notifyCallback(final CallBackT callbackt, final Callbacker<CallBackT> callbacker) {
        postToMain(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.6
            @Override // java.lang.Runnable
            public void run() {
                callbacker.exec(callbackt);
            }
        });
    }

    public void notifySettingFinish() {
        notifyCallbacks(this.mCallbacks, new Callbacker<SettingCallback>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.Callbacker
            public void exec(SettingCallback settingCallback) {
                settingCallback.onSettingFinish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class Callbacker<CallBackT> {
        abstract void exec(CallBackT callbackt);

        private Callbacker() {
        }
    }

    private static void postToMain(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void login(final Activity activity, final TypedCallback<TaskResult<LoginRequest.Result>> typedCallback) {
        this.mAuthorizeQueue.offer(new Task() { // from class: com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.8
            @Override // java.lang.Runnable
            public void run() {
                new LoginRequest(activity).regCallback(typedCallback).regCallback(new TypedCallback<TaskResult<LoginRequest.Result>>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.AiAppSetting.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                    public void onCallback(TaskResult<LoginRequest.Result> taskResult) {
                        finish();
                    }
                }).call();
            }
        });
    }
}
