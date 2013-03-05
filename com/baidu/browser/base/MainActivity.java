package com.baidu.browser.base;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.browser.Browser;
import com.baidu.zeus.NotificationProxy;
/* loaded from: classes.dex */
public class MainActivity extends BaseActivity {
    private static final int ARG_BROWSER_RESTART = 1;
    private static final boolean DEBUG = false;
    private static final int DELAY_START_TIME = 200;
    private static final String KEY_FRAGMENT_STATE = "KEY_FRAGMENT_STATE";
    private static final String KEY_LAUNCH_STATE = "KEY_LAUNCH_COUNT";
    private static final int MSG_POST_START = 1;
    private static final int MSG_POST_START_DONE = 2;
    private static final int MSG_START = 3;
    private static final int MSG_SWITCH_TO_BROWSER = 5;
    private static final int MSG_SWITCH_TO_HOME = 4;
    private static final int STATE_CREATE_SHORTCUT = 0;
    private static final int STATE_INTRODUCTION = 1;
    private static final int STATE_NORMAL = 2;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Fragment mBackupFragment;
    private View mBrowserView;
    private Fragment mCurrentFragment;
    private boolean mHoldRunning;
    private View mHomeView;
    private boolean mIntroductionMode;
    private View.OnClickListener mIntroductionCloseListener = new View.OnClickListener() { // from class: com.baidu.browser.base.MainActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.init(null);
        }
    };
    private Handler mHandler = new Handler() { // from class: com.baidu.browser.base.MainActivity.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    sendEmptyMessage(2);
                    return;
                case 2:
                    sendEmptyMessageDelayed(3, 200L);
                    return;
                case 3:
                    MainActivity.this.askForShortcuts(false);
                    return;
                case 4:
                    MainActivity.this.switchToHome(message.peekData());
                    MainActivity.this.askForShortcuts(false);
                    return;
                case 5:
                    MainActivity.this.switchToBrowser(message.peekData(), message.arg1 == 1);
                    MainActivity.this.askForShortcuts(false);
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum FragmentState {
        BROWSER_STATE,
        HOME_STATE;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static FragmentState[] valuesCustom() {
            FragmentState[] valuesCustom = values();
            int length = valuesCustom.length;
            FragmentState[] fragmentStateArr = new FragmentState[length];
            System.arraycopy(valuesCustom, 0, fragmentStateArr, 0, length);
            return fragmentStateArr;
        }
    }

    @Override // com.baidu.browser.base.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if ("android.intent.action.MAIN".equals(getIntent().getAction())) {
            if (getLaunchState() == 1) {
                setLaunchState(2);
                startIntroduction();
                return;
            }
            init(bundle);
            return;
        }
        init(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init(Bundle bundle) {
        getWindow().clearFlags(NotificationProxy.MAX_URL_LENGTH);
        setContentView(getResources().getIdentifier("browser_main", "layout", getPackageName()));
        this.mHomeView = findViewById(getResources().getIdentifier("home_panel", "id", getPackageName()));
        if (bundle != null) {
            String string = bundle.getString(KEY_FRAGMENT_STATE);
            Message obtainMessage = this.mHandler.obtainMessage();
            if (FragmentState.BROWSER_STATE.name().equals(string)) {
                obtainMessage.what = 5;
            } else {
                obtainMessage.what = 4;
            }
            obtainMessage.setData(bundle);
            this.mHandler.sendMessage(obtainMessage);
        } else if (this.mCurrentFragment == null) {
            String action = getIntent().getAction();
            if (IntentConstants.ACTION_BROWSER.equals(action)) {
                this.mBrowserView = Browser.getInstance(this).getRootView();
                this.mHomeView.setVisibility(8);
                addBrowserView();
                this.mCurrentFragment = Browser.getInstance(this);
            } else if (TextUtils.equals(IntentConstants.ACTION_VIEW, action) || TextUtils.equals(IntentConstants.ACTION_SEARCH, action) || TextUtils.equals(IntentConstants.ACTION_VOICE_SEARCH_RESULTS, action)) {
                switchToBrowser(bundle, false);
            } else {
                Browser browser = Browser.getInstance(this);
                this.mBrowserView = browser.getRootView();
                this.mHomeView.setVisibility(8);
                addBrowserView();
                this.mCurrentFragment = browser;
                this.mHandler.sendEmptyMessage(1);
            }
        }
        if (this.mIntroductionMode) {
            initFloatSearchBoxLayout();
        }
        if (!this.mHoldRunning && this.mCurrentFragment != null) {
            if (this.mIntroductionMode) {
                this.mCurrentFragment.resume(bundle);
            } else {
                this.mCurrentFragment.onCreate(bundle);
            }
        }
        this.mIntroductionMode = false;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (!this.mHoldRunning && this.mCurrentFragment != null) {
            bundle.putString(KEY_FRAGMENT_STATE, FragmentState.BROWSER_STATE.name());
            this.mCurrentFragment.onSaveInstanceState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mHomeView = findViewById(getResources().getIdentifier("browser_home_panel", "layout", getPackageName()));
        this.mBrowserView = ((Browser) this.mCurrentFragment).getRootView();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mHoldRunning || this.mCurrentFragment == null || !this.mCurrentFragment.onKeyDown(i, keyEvent)) {
            switch (i) {
                case 4:
                    if (this.mIntroductionMode) {
                        this.mIntroductionCloseListener.onClick(null);
                        return true;
                    }
                    break;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.browser.base.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        initFloatSearchBoxLayout();
        if (!this.mHoldRunning && this.mCurrentFragment != null && !this.mCurrentFragment.isInForeground()) {
            this.mCurrentFragment.onResume();
        }
        this.mHoldRunning = false;
    }

    private void initFloatSearchBoxLayout() {
    }

    protected void finalize() {
        super.finalize();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (!this.mHoldRunning && this.mCurrentFragment != null && !this.mCurrentFragment.isInForeground()) {
            this.mCurrentFragment.onRestart();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (!this.mHoldRunning && this.mCurrentFragment != null && !this.mCurrentFragment.isInForeground()) {
            this.mCurrentFragment.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.browser.base.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(3);
            this.mHandler.removeMessages(4);
            this.mHandler.removeMessages(5);
        }
        if (this.mCurrentFragment != null) {
            this.mCurrentFragment.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.browser.base.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mCurrentFragment != null) {
            this.mCurrentFragment.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.browser.base.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mCurrentFragment != null) {
            this.mCurrentFragment.finish();
        }
        if (this.mBackupFragment != null) {
            this.mBackupFragment.finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        if (this.mCurrentFragment != null) {
            this.mCurrentFragment.onLowMemory();
        }
        if (this.mBackupFragment != null) {
            this.mBackupFragment.onLowMemory();
        }
        super.onLowMemory();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        String action = intent.getAction();
        if (IntentConstants.ACTION_BROWSER.equals(action) || TextUtils.equals(IntentConstants.ACTION_VIEW, action) || TextUtils.equals(IntentConstants.ACTION_SEARCH, action) || TextUtils.equals(IntentConstants.ACTION_VOICE_SEARCH_RESULTS, action)) {
            this.mHoldRunning = true;
            Message obtainMessage = this.mHandler.obtainMessage(5);
            obtainMessage.arg1 = 1;
            this.mHandler.sendMessage(obtainMessage);
        } else if (IntentConstants.ACTION_HOME.equals(intent.getAction())) {
            this.mHoldRunning = true;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
        } else if (!this.mHoldRunning && this.mCurrentFragment != null) {
            this.mCurrentFragment.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!this.mHoldRunning && this.mCurrentFragment != null) {
            this.mCurrentFragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (this.mHoldRunning || this.mCurrentFragment == null || !this.mCurrentFragment.onMenuItemSelected(i, menuItem)) {
            return super.onMenuItemSelected(i, menuItem);
        }
        return true;
    }

    public Browser getBrowser() {
        if (this.mCurrentFragment instanceof Browser) {
            return (Browser) this.mCurrentFragment;
        }
        if (!(this.mBackupFragment instanceof Browser)) {
            return null;
        }
        return (Browser) this.mBackupFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToBrowser(Bundle bundle, boolean z) {
        Browser browser = getBrowser();
        if (z || browser == null) {
            clearBrowser(browser);
            browser = Browser.getInstance(this);
            this.mBrowserView = browser.getRootView();
        }
        if (this.mCurrentFragment instanceof Browser) {
            if (this.mCurrentFragment != browser) {
                this.mCurrentFragment = browser;
            }
        } else {
            this.mCurrentFragment = browser;
        }
        this.mHomeView.setVisibility(8);
        addBrowserView();
        this.mCurrentFragment.resume(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToHome(Bundle bundle) {
    }

    private void clearBrowser(Browser browser) {
        if (browser != null) {
            browser.finish();
        }
        clearBrowserView();
    }

    private void clearBrowserView() {
        ViewGroup viewGroup;
        if (this.mBrowserView != null && (viewGroup = (ViewGroup) this.mBrowserView.getParent()) != null) {
            viewGroup.removeView(this.mBrowserView);
        }
    }

    private void addBrowserView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(getResources().getIdentifier("MainRoot", "id", getPackageName()));
        if (this.mBrowserView.getParent() != viewGroup) {
            viewGroup.addView(this.mBrowserView, this.mHomeView.getLayoutParams());
        }
    }

    private int getLaunchState() {
        return getPreferences(0).getInt(KEY_LAUNCH_STATE, 0);
    }

    private void setLaunchState(int i) {
        SharedPreferences.Editor edit = getPreferences(0).edit();
        edit.putInt(KEY_LAUNCH_STATE, i);
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void askForShortcuts(boolean z) {
    }

    private boolean haveShortcuts() {
        String str = "com.android.launcher.settings";
        if (Build.VERSION.SDK_INT >= 8) {
            str = "com.android.launcher2.settings";
        }
        Cursor query = getContentResolver().query(Uri.parse("content://" + str + "/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{getString(getResources().getIdentifier("browser_app_name", "string", getPackageName())).trim()}, null);
        return query != null && query.getCount() > 0;
    }

    private void addShortcut() {
    }

    private void deleteShortcuts() {
    }

    private void startIntroduction() {
    }
}
