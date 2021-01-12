package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Ack;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Crash;
import com.baidu.android.imsdk.upload.action.track.Db;
import com.baidu.android.imsdk.upload.action.track.Msg;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.android.imsdk.upload.action.track.Ui;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes3.dex */
public class IMTrack {

    /* loaded from: classes3.dex */
    public static final class UiBuilder {
        public static final String CATEGORY_CLICK = "category_click";
        public static final String CATEGORY_MI = "category_mi";
        public static final String CATEGORY_SHOW = "category_show";
        private Context context;
        private Ui ui = new Ui();

        public UiBuilder(Context context) {
            this.context = context;
            this.ui.category = "";
            this.ui.page = "";
            this.ui.startTime = -1L;
            this.ui.endTime = -1L;
            this.ui.duration = -1L;
            this.ui.ext = "";
            this.ui.aliasId = -1L;
        }

        public UiBuilder category(String str) {
            this.ui.category = str;
            return this;
        }

        public UiBuilder page(String str) {
            this.ui.page = str;
            return this;
        }

        public UiBuilder startTime(long j) {
            this.ui.startTime = j;
            return this;
        }

        public UiBuilder endTime(long j) {
            this.ui.endTime = j;
            return this;
        }

        public UiBuilder duration(long j) {
            this.ui.duration = j;
            return this;
        }

        public UiBuilder ext(String str) {
            this.ui.ext = str;
            return this;
        }

        public UiBuilder aliasId(long j) {
            this.ui.aliasId = j;
            return this;
        }

        public void build() {
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.UI, this.ui);
        }
    }

    /* loaded from: classes3.dex */
    public static final class CrashBuilder {
        public static final int CRASH_TYPE_CATCH = 201001;
        public static final int CRASH_TYPE_DEFAULT = 201002;
        private Context context;
        private Crash crash = new Crash();

        public CrashBuilder(Context context) {
            this.context = context;
            this.crash.exception = "";
            this.crash.timestamp = System.currentTimeMillis();
            this.crash.ext = "";
            this.crash.aliasId = 201001L;
        }

        public CrashBuilder exception(String str) {
            this.crash.exception = str;
            return this;
        }

        public CrashBuilder ext(String str) {
            this.crash.ext = str;
            return this;
        }

        public CrashBuilder aliasId(long j) {
            this.crash.aliasId = j;
            return this;
        }

        public void build() {
            if (!TextUtils.isEmpty(this.crash.exception)) {
                IMTrack.reportTracker(this.context, IMPushPb.ActionType.CRASH, this.crash);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class DbBuilder {
        public static final String ACTION_ADD = "add";
        public static final String ACTION_DELETE = "delete";
        public static final String ACTION_MIGRATE = "migrate";
        public static final String ACTION_QUERY = "query";
        public static final String ACTION_UPDATE = "update";
        private Context context;
        private Db db = new Db();

        public DbBuilder(Context context) {
            this.context = context;
            this.db.table = "";
            this.db.className = "";
            this.db.method = "";
            this.db.action = "";
            this.db.startTime = -1L;
            this.db.endTime = -1L;
            this.db.duration = -1L;
            this.db.ext = "";
            this.db.aliasId = -1L;
        }

        public DbBuilder table(String str) {
            this.db.table = str;
            return this;
        }

        public DbBuilder className(String str) {
            this.db.className = str;
            return this;
        }

        public DbBuilder method(String str) {
            this.db.method = str;
            return this;
        }

        public DbBuilder action(String str) {
            this.db.action = str;
            return this;
        }

        public DbBuilder startTime(long j) {
            this.db.startTime = j;
            return this;
        }

        public DbBuilder endTime(long j) {
            this.db.endTime = j;
            return this;
        }

        public DbBuilder duration(long j) {
            this.db.duration = j;
            return this;
        }

        public DbBuilder ext(String str) {
            this.db.ext = str;
            return this;
        }

        public DbBuilder aliasId(long j) {
            this.db.aliasId = j;
            return this;
        }

        public void build() {
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.DB, this.db);
        }
    }

    /* loaded from: classes3.dex */
    public static final class ConnectionBuilder {
        public static final int CONN_TYPE_SOCKET_CONNECTION_ENV_FAIL = 401203;
        public static final int CONN_TYPE_SOCKET_CONNECTION_EXCEPTION = 401205;
        public static final int CONN_TYPE_SOCKET_CONNECTION_OK = 401201;
        public static final int CONN_TYPE_SOCKET_CONNECTION_STOP = 401202;
        public static final int CONN_TYPE_SOCKET_CONNECTION_TIMEOUT = 401204;
        public static final int CONN_TYPE_SOCKET_RETRY_5_FAIL = 401206;
        private Connection connection = new Connection();
        private Context context;

        public ConnectionBuilder(Context context) {
            this.context = context;
            this.connection.startTime = -1L;
            this.connection.stopTime = -1L;
            this.connection.reason = "";
            this.connection.retryTime = -1L;
            this.connection.retryCount = -1L;
            this.connection.ext = "";
            this.connection.aliasId = -1L;
        }

        public ConnectionBuilder startTime(long j) {
            this.connection.startTime = j;
            return this;
        }

        public ConnectionBuilder stopTime(long j) {
            this.connection.stopTime = j;
            return this;
        }

        public ConnectionBuilder reason(String str) {
            this.connection.reason = str;
            return this;
        }

        public ConnectionBuilder retryTime(long j) {
            this.connection.retryTime = j;
            return this;
        }

        public ConnectionBuilder retryCount(long j) {
            this.connection.retryCount = j;
            return this;
        }

        public ConnectionBuilder ext(String str) {
            this.connection.ext = str;
            return this;
        }

        public ConnectionBuilder aliasId(long j) {
            this.connection.aliasId = j;
            return this;
        }

        public void build() {
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.CONNECTION, this.connection);
        }
    }

    /* loaded from: classes3.dex */
    public static final class RequestBuilder {
        public static final int REQUEST_INIT = 501100;
        public static final int REQUEST_JOIN = 501112;
        public static final int REQUEST_JOIN_CALLBACK = 501113;
        public static final int REQUEST_LOGIN = 501101;
        private Context context;
        private Request request = new Request();

        public RequestBuilder(Context context) {
            this.context = context;
            this.request.method = "";
            this.request.requestId = "";
            this.request.timestamp = -1L;
            this.request.responseTime = -1L;
            this.request.errorCode = -1L;
            this.request.ext = "";
            this.request.aliasId = -1L;
        }

        public RequestBuilder method(String str) {
            this.request.method = str;
            return this;
        }

        public RequestBuilder requestId(String str) {
            this.request.requestId = str;
            return this;
        }

        public RequestBuilder requestTime(long j) {
            this.request.timestamp = j;
            return this;
        }

        public RequestBuilder responseTime(long j) {
            this.request.responseTime = j;
            return this;
        }

        public RequestBuilder errorCode(long j) {
            this.request.errorCode = j;
            return this;
        }

        public RequestBuilder ext(String str) {
            this.request.ext = str;
            return this;
        }

        public RequestBuilder aliasId(long j) {
            this.request.aliasId = j;
            return this;
        }

        public void build() {
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.REQUEST, this.request);
        }
    }

    /* loaded from: classes3.dex */
    public static final class AckBuilder {
        public static final String PROXY_TYPE = "proxy";
        public static final String PUSH_TYPE = "push";
        private Ack ack = new Ack();
        private Context context;

        public AckBuilder(Context context) {
            this.context = context;
            this.ack.type = "";
            this.ack.value = "";
            this.ack.timestamp = -1L;
            this.ack.ext = "";
            this.ack.aliasId = -1L;
        }

        public AckBuilder type(String str) {
            this.ack.type = str;
            return this;
        }

        public AckBuilder value(String str) {
            this.ack.value = str;
            return this;
        }

        public AckBuilder timestamp(long j) {
            this.ack.timestamp = j;
            return this;
        }

        public AckBuilder ext(String str) {
            this.ack.ext = str;
            return this;
        }

        public AckBuilder aliasId(long j) {
            this.ack.aliasId = j;
            return this;
        }

        public void build() {
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.ACK, this.ack);
        }
    }

    /* loaded from: classes3.dex */
    public static final class MsgBuilder {
        private Context context;
        private Msg msg = new Msg();

        public MsgBuilder(Context context) {
            this.context = context;
            this.msg.msgCount = -1L;
            this.msg.roomId = "";
            this.msg.duration = -1L;
            this.msg.startMsgId = -1L;
            this.msg.endMsgId = -1L;
            this.msg.ext = "";
            this.msg.aliasId = -1L;
        }

        public MsgBuilder msgCount(long j) {
            this.msg.msgCount = j;
            return this;
        }

        public MsgBuilder roomId(String str) {
            this.msg.roomId = str;
            return this;
        }

        public MsgBuilder duration(long j) {
            this.msg.duration = j;
            return this;
        }

        public MsgBuilder startMsgId(long j) {
            this.msg.startMsgId = j;
            return this;
        }

        public MsgBuilder endMsgId(long j) {
            this.msg.endMsgId = j;
            return this;
        }

        public MsgBuilder ext(String str) {
            this.msg.ext = str;
            return this;
        }

        public MsgBuilder aliasId(long j) {
            this.msg.aliasId = j;
            return this;
        }

        public void build() {
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.MSG, this.msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportTracker(Context context, final IMPushPb.ActionType actionType, final Object obj) {
        final Context applicationContext = context.getApplicationContext();
        if (Utility.isUploadIMTrack(applicationContext)) {
            TaskManager.getInstance(applicationContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.upload.action.IMTrack.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (IMTrackDatabase.myLock) {
                        switch (AnonymousClass2.$SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.this.ordinal()]) {
                            case 1:
                                IMTrackDatabase.getInstance(applicationContext).insertUi((Ui) obj);
                                break;
                            case 2:
                                IMTrackDatabase.getInstance(applicationContext).insertCrash((Crash) obj);
                                break;
                            case 3:
                                IMTrackDatabase.getInstance(applicationContext).insertDb((Db) obj);
                                break;
                            case 4:
                                IMTrackDatabase.getInstance(applicationContext).insertConnection((Connection) obj);
                                break;
                            case 5:
                                IMTrackDatabase.getInstance(applicationContext).insertRequest((Request) obj);
                                break;
                            case 6:
                                IMTrackDatabase.getInstance(applicationContext).insertAck((Ack) obj);
                                break;
                            case 7:
                                IMTrackDatabase.getInstance(applicationContext).insertMsg((Msg) obj);
                                break;
                        }
                    }
                }
            });
        }
    }

    /* renamed from: com.baidu.android.imsdk.upload.action.IMTrack$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType = new int[IMPushPb.ActionType.values().length];

        static {
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.UI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.CRASH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.DB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.CONNECTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.REQUEST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.ACK.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.MSG.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }
}
