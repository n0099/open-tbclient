package com.baidu.searchbox.ugc.bridge;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
/* loaded from: classes11.dex */
public interface IUgcHostInterface<T> {
    public static final IUgcHostInterface EMPTY = new IUgcHostInterface() { // from class: com.baidu.searchbox.ugc.bridge.IUgcHostInterface.1
        @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
        public Object newCookieManagerInstance(boolean z, boolean z2) {
            return null;
        }

        @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
        public void postInterruptedEventToApp() {
        }

        @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
        public void setUgcRNInitData(Activity activity, String str) {
        }

        @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
        public boolean getNightModeSwitcherState() {
            return false;
        }

        @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
        @Nullable
        public Context getRnActivity(Context context) {
            return null;
        }

        @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
        public boolean isPermissionGroupGranted(Context context, String[] strArr) {
            return false;
        }

        @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
        public void requestPermissionsDialog(String str, Context context, String[] strArr, RequestPermissionCallBack requestPermissionCallBack) {
            requestPermissionCallBack.isAllAgree(true);
        }

        @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
        public void openVideoPublisherActivity(Context context, UgcSchemeModel ugcSchemeModel) {
        }

        @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
        public String processUrl(String str) {
            return null;
        }
    };
    public static final String LOG_TAG = "IUgcHostInterface";

    /* loaded from: classes11.dex */
    public interface RequestPermissionCallBack {
        void isAllAgree(Boolean bool);

        void isShow(String str, Boolean bool);

        void requestResult(String str, Boolean bool);
    }

    boolean getNightModeSwitcherState();

    @Nullable
    Context getRnActivity(Context context);

    boolean isPermissionGroupGranted(Context context, String[] strArr);

    T newCookieManagerInstance(boolean z, boolean z2);

    void openVideoPublisherActivity(Context context, UgcSchemeModel ugcSchemeModel);

    void postInterruptedEventToApp();

    String processUrl(String str);

    void requestPermissionsDialog(String str, Context context, String[] strArr, RequestPermissionCallBack requestPermissionCallBack);

    void setUgcRNInitData(Activity activity, String str);

    /* loaded from: classes11.dex */
    public static final class Impl {
        private static IUgcHostInterface sUgcHostImpl = UgcRuntime.getUgcInterface();

        private Impl() {
        }

        @NonNull
        public static IUgcHostInterface get() {
            if (sUgcHostImpl == null) {
                Log.w(IUgcHostInterface.LOG_TAG, "Fetch IUgcHostInterface implementation failed, IUgcHostInterface.EMPTY applied");
                sUgcHostImpl = IUgcHostInterface.EMPTY;
            }
            return sUgcHostImpl;
        }
    }
}
