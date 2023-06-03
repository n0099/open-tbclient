package com.baidu.searchbox.common.security;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.PermissionStorage;
import com.baidu.tieba.R;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes3.dex */
public class PermissionManager {
    public static final int MODE_ALLOW = 1;
    public static final int MODE_ASK = 0;
    public static final int MODE_REFUSE = 2;
    public static final int MSG_UI_GET_URL = 0;
    public static final int MSG_UI_SHOW_DIALOG = 1;
    public static final int MSG_WORK_PUBLISH_USE_CHOICE = 1;
    public static final int MSG_WORK_QUERY_BD = 0;
    public static final String TAG = "PermissionManager";
    public static volatile PermissionManager sInstance;
    public HandlerThread mHandlerThread;
    public Handler mUiHandler;
    public Handler mWorkHander;
    public static final boolean DEBUG = SecurityConfig.DEBUG;
    public static int URL_PRE_CHECK_RES_WHITE = 0;
    public static int URL_RPE_CHECK_RES_BLACK = 1;
    public static int URL_RPE_CHECK_RES_QUERY_HOST = 2;
    public static int URL_PRE_CHECK_RES_LOCAL = 3;
    public Queue<UrlCheckContext> mUserTipQueue = new LinkedList();
    public boolean mTipDialogShowing = false;
    public List<String> mInternalWhiteHost = new ArrayList();

    /* loaded from: classes3.dex */
    public static abstract class UrlCheckContext {
        public int lastMode;
        public OpItem op;
        public Uri uri;
        public String url;
        public int urlCheckRes;

        public boolean getUrlOnUiThread() {
            return true;
        }

        public abstract void onCheckPermissionFinished(int i);

        public abstract Activity onGetActivity();

        public abstract String onGetUrl();
    }

    /* loaded from: classes3.dex */
    public static class OpItem {
        public final int opId;
        public final int resId;

        public OpItem(int i, int i2) {
            this.opId = i;
            this.resId = i2;
        }

        public static OpItem valueOf(int i, int i2) {
            return new OpItem(i, i2);
        }

        @SuppressLint({"ResourceType"})
        public String getActionName() {
            TypedArray obtainTypedArray = AppRuntime.getAppContext().getResources().obtainTypedArray(this.resId);
            try {
                return obtainTypedArray.getString(1);
            } finally {
                obtainTypedArray.recycle();
            }
        }

        public String getOpName() {
            TypedArray obtainTypedArray = AppRuntime.getAppContext().getResources().obtainTypedArray(this.resId);
            try {
                return obtainTypedArray.getString(0);
            } finally {
                obtainTypedArray.recycle();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class UiHandler extends Handler {
        public UiHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String format;
            int i = message.what;
            if (i != 0) {
                if (i == 1) {
                    final UrlCheckContext urlCheckContext = (UrlCheckContext) message.obj;
                    Activity onGetActivity = urlCheckContext.onGetActivity();
                    if (onGetActivity != null && !onGetActivity.isFinishing()) {
                        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.common.security.PermissionManager.UiHandler.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                if (i2 != -2) {
                                    if (i2 == -1) {
                                        urlCheckContext.lastMode = 1;
                                        PermissionManager.this.mWorkHander.obtainMessage(1, 0, 0, urlCheckContext).sendToTarget();
                                        return;
                                    }
                                    return;
                                }
                                urlCheckContext.lastMode = 2;
                                PermissionManager.this.mWorkHander.obtainMessage(1, 0, 0, urlCheckContext).sendToTarget();
                            }
                        };
                        if (urlCheckContext.urlCheckRes == PermissionManager.URL_PRE_CHECK_RES_LOCAL) {
                            String path = urlCheckContext.uri.getPath();
                            if (path.length() > 60) {
                                path = path.substring(0, 60) + "...";
                            }
                            format = String.format("“%s”%s", path, urlCheckContext.op.getActionName());
                        } else {
                            format = String.format("“%s”%s", urlCheckContext.uri.getHost(), urlCheckContext.op.getActionName());
                        }
                        new BoxAlertDialog.Builder(onGetActivity).setCancelable(false).setTitle(R.string.obfuscated_res_0x7f0f12de).setMessage(format).setPositiveButton(R.string.obfuscated_res_0x7f0f12dc, onClickListener).setNegativeButton(R.string.obfuscated_res_0x7f0f12dd, onClickListener).create().show();
                        return;
                    }
                    urlCheckContext.lastMode = 0;
                    PermissionManager.this.mWorkHander.obtainMessage(1, 0, 0, urlCheckContext).sendToTarget();
                    return;
                }
                return;
            }
            UrlCheckContext urlCheckContext2 = (UrlCheckContext) message.obj;
            urlCheckContext2.url = urlCheckContext2.onGetUrl();
            PermissionManager.this.mWorkHander.obtainMessage(0, 0, 0, urlCheckContext2).sendToTarget();
        }
    }

    /* loaded from: classes3.dex */
    public class WorkHandler extends Handler {
        public WorkHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PermissionStorage.PermissionItem queryPermissionItemByOpAndHost;
            int i = message.what;
            if (i != 0) {
                if (i == 1) {
                    UrlCheckContext urlCheckContext = (UrlCheckContext) message.obj;
                    for (UrlCheckContext urlCheckContext2 : PermissionManager.this.mUserTipQueue) {
                        if (urlCheckContext.url.equals(urlCheckContext2.url) && urlCheckContext.op == urlCheckContext2.op) {
                            urlCheckContext2.lastMode = urlCheckContext.lastMode;
                        }
                    }
                    if (urlCheckContext.urlCheckRes == PermissionManager.URL_RPE_CHECK_RES_QUERY_HOST) {
                        PermissionStorage.PermissionItem permissionItem = new PermissionStorage.PermissionItem();
                        permissionItem.host = urlCheckContext.uri.getHost();
                        permissionItem.mode = urlCheckContext.lastMode;
                        permissionItem.ts = System.currentTimeMillis();
                        permissionItem.op = urlCheckContext.op.opId;
                        PermissionStorage.getInstance().updateOrInsertPermissionItem(permissionItem);
                    }
                    urlCheckContext.onCheckPermissionFinished(urlCheckContext.lastMode);
                    PermissionManager.this.mTipDialogShowing = false;
                    PermissionManager.this.scheduleNextTipLocked();
                    return;
                }
                return;
            }
            UrlCheckContext urlCheckContext3 = (UrlCheckContext) message.obj;
            String str = urlCheckContext3.url;
            if (TextUtils.isEmpty(str)) {
                urlCheckContext3.onCheckPermissionFinished(2);
            }
            Uri parse = Uri.parse(str);
            urlCheckContext3.uri = parse;
            int preCheckUrl = PermissionManager.this.preCheckUrl(parse);
            urlCheckContext3.urlCheckRes = preCheckUrl;
            if (preCheckUrl == PermissionManager.URL_PRE_CHECK_RES_WHITE) {
                urlCheckContext3.onCheckPermissionFinished(1);
            } else if (preCheckUrl == PermissionManager.URL_RPE_CHECK_RES_BLACK) {
                urlCheckContext3.onCheckPermissionFinished(2);
            } else if (preCheckUrl != PermissionManager.URL_PRE_CHECK_RES_LOCAL && preCheckUrl == PermissionManager.URL_RPE_CHECK_RES_QUERY_HOST && (queryPermissionItemByOpAndHost = PermissionStorage.getInstance().queryPermissionItemByOpAndHost(urlCheckContext3.op.opId, parse.getHost())) != null && queryPermissionItemByOpAndHost.mode == 1) {
                urlCheckContext3.onCheckPermissionFinished(1);
            } else {
                PermissionManager.this.mUserTipQueue.add(urlCheckContext3);
                PermissionManager.this.scheduleNextTipLocked();
            }
        }
    }

    public static PermissionManager getInstance() {
        if (sInstance == null) {
            synchronized (PermissionManager.class) {
                if (sInstance == null) {
                    sInstance = new PermissionManager();
                }
            }
        }
        return sInstance;
    }

    public void scheduleNextTipLocked() {
        UrlCheckContext poll;
        if (this.mTipDialogShowing || (poll = this.mUserTipQueue.poll()) == null) {
            return;
        }
        if (poll.lastMode == 1) {
            poll.onCheckPermissionFinished(1);
            scheduleNextTipLocked();
            return;
        }
        this.mTipDialogShowing = true;
        this.mUiHandler.obtainMessage(1, 0, 0, poll).sendToTarget();
    }

    public PermissionManager() {
        HandlerThread handlerThread = new HandlerThread("permission_worker");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mWorkHander = new WorkHandler(this.mHandlerThread.getLooper());
        this.mUiHandler = new UiHandler(Looper.getMainLooper());
        this.mInternalWhiteHost.add(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE);
        this.mInternalWhiteHost.add("nuomi.com");
        this.mInternalWhiteHost.add("hao123.com");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int preCheckUrl(Uri uri) {
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return URL_RPE_CHECK_RES_BLACK;
        }
        String[] strArr = {"http", "https", "file"};
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= 3) {
                break;
            } else if (strArr[i].equalsIgnoreCase(scheme)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            return URL_RPE_CHECK_RES_BLACK;
        }
        if (TextUtils.equals("file", scheme)) {
            if (!TextUtils.isEmpty(uri.getPath())) {
                try {
                    if (new File(uri.getPath()).getCanonicalPath().startsWith(new File(AppRuntime.getAppContext().getFilesDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE).getAbsolutePath())) {
                        if (DEBUG) {
                            Log.d("PermissionManager", "url match local files. ");
                        }
                        return URL_PRE_CHECK_RES_WHITE;
                    }
                    return URL_PRE_CHECK_RES_LOCAL;
                } catch (Exception unused) {
                }
            }
            return URL_RPE_CHECK_RES_BLACK;
        }
        String host = uri.getHost();
        if (TextUtils.isEmpty(host)) {
            return URL_RPE_CHECK_RES_BLACK;
        }
        for (String str : this.mInternalWhiteHost) {
            if (TextUtils.equals(str, host)) {
                if (DEBUG) {
                    Log.d("PermissionManager", "host match baidu origin. ");
                }
                return URL_PRE_CHECK_RES_WHITE;
            }
            if (host.endsWith("." + str)) {
                if (DEBUG) {
                    Log.d("PermissionManager", "host match baidu origin. ");
                }
                return URL_PRE_CHECK_RES_WHITE;
            }
        }
        return URL_RPE_CHECK_RES_QUERY_HOST;
    }

    public void checkPermission(OpItem opItem, UrlCheckContext urlCheckContext) {
        if (opItem != null && urlCheckContext != null) {
            urlCheckContext.op = opItem;
            if (urlCheckContext.getUrlOnUiThread()) {
                this.mUiHandler.obtainMessage(0, 0, 0, urlCheckContext).sendToTarget();
                return;
            }
            urlCheckContext.url = urlCheckContext.onGetUrl();
            this.mWorkHander.obtainMessage(0, 0, 0, urlCheckContext).sendToTarget();
        } else if (!DEBUG) {
        } else {
            throw new IllegalArgumentException("parms cannot be null");
        }
    }
}
