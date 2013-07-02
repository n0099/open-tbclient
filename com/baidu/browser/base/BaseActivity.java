package com.baidu.browser.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class BaseActivity extends Activity {
    private static final boolean DEBUG = false;
    private static final int DELAY_FOR_BROADCAST = 1000;
    private static final int DELAY_FOR_CANCEL_ALARM = 5000;
    private static final int MSG_CANCEL_ALARM = 1;
    private static final String TAG = "BaseActivity";
    private static LinkedList mActivityStack = new LinkedList();
    private static int mLiveActivityNum = 0;
    private static boolean sEmptyKillApp = true;
    private static boolean sIsFirstIn;
    private Handler mBaseHandler = new Handler() { // from class: com.baidu.browser.base.BaseActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        mLiveActivityNum++;
        if (isFirstIn()) {
            this.mBaseHandler.sendEmptyMessageDelayed(1, 5000L);
            setFirstIn(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        mLiveActivityNum--;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (!isAppInForeground()) {
            setFirstIn(true);
            if (this.mBaseHandler.hasMessages(1)) {
                this.mBaseHandler.removeMessages(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addToTask(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        removeFromTask(this);
    }

    protected void buildWorkspaceWindow(int[] iArr, View.OnClickListener onClickListener, Bundle bundle) {
    }

    public static void addToTask(Activity activity) {
        mActivityStack.remove(activity);
        mActivityStack.add(activity);
    }

    public static void removeFromTask(Activity activity) {
        mActivityStack.remove(activity);
        if (mActivityStack.isEmpty()) {
            if (sEmptyKillApp) {
                quitApp(activity.getApplicationContext());
            } else {
                sEmptyKillApp = true;
            }
        }
    }

    public static void clearTaskExceptMain() {
        Iterator it = mActivityStack.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) it.next();
            if (!(activity instanceof MainActivity)) {
                activity.finish();
            }
        }
    }

    public static void clearTask() {
        if (!mActivityStack.isEmpty()) {
            sEmptyKillApp = false;
        }
        Iterator it = mActivityStack.iterator();
        while (it.hasNext()) {
            ((Activity) it.next()).finish();
        }
    }

    public static void clearTaskExcept(Activity activity) {
        Iterator it = mActivityStack.iterator();
        while (it.hasNext()) {
            Activity activity2 = (Activity) it.next();
            if (activity2 != activity) {
                activity2.finish();
            }
        }
    }

    public static void quitApp(Context context) {
    }

    public static boolean isAppInForeground() {
        return mLiveActivityNum > 0;
    }

    public static boolean isFirstIn() {
        return sIsFirstIn;
    }

    public static void setFirstIn(boolean z) {
        sIsFirstIn = z;
    }
}
