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
/* loaded from: classes2.dex */
public class IMTrack {

    /* renamed from: com.baidu.android.imsdk.upload.action.IMTrack$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType;

        static {
            int[] iArr = new int[IMPushPb.ActionType.values().length];
            $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType = iArr;
            try {
                iArr[IMPushPb.ActionType.UI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.CRASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.DB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.CONNECTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.REQUEST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.ACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.MSG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class AckBuilder {
        public static final String PROXY_TYPE = "proxy";
        public static final String PUSH_TYPE = "push";
        public Ack ack;
        public Context context;

        public AckBuilder(Context context) {
            Ack ack = new Ack();
            this.ack = ack;
            this.context = context;
            ack.type = "";
            ack.value = "";
            ack.timestamp = -1L;
            ack.ext = "";
            ack.aliasId = -1L;
        }

        public AckBuilder aliasId(long j) {
            this.ack.aliasId = j;
            return this;
        }

        public void build() {
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.ACK, this.ack);
        }

        public AckBuilder ext(String str) {
            this.ack.ext = str;
            return this;
        }

        public AckBuilder timestamp(long j) {
            this.ack.timestamp = j;
            return this;
        }

        public AckBuilder type(String str) {
            this.ack.type = str;
            return this;
        }

        public AckBuilder value(String str) {
            this.ack.value = str;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ConnectionBuilder {
        public static final int CONN_TYPE_SOCKET_CONNECTION_ENV_FAIL = 401203;
        public static final int CONN_TYPE_SOCKET_CONNECTION_EXCEPTION = 401205;
        public static final int CONN_TYPE_SOCKET_CONNECTION_OK = 401201;
        public static final int CONN_TYPE_SOCKET_CONNECTION_STOP = 401202;
        public static final int CONN_TYPE_SOCKET_CONNECTION_TIMEOUT = 401204;
        public static final int CONN_TYPE_SOCKET_RETRY_5_FAIL = 401206;
        public Connection connection;
        public Context context;

        public ConnectionBuilder(Context context) {
            Connection connection = new Connection();
            this.connection = connection;
            this.context = context;
            connection.startTime = -1L;
            connection.stopTime = -1L;
            connection.reason = "";
            connection.retryTime = -1L;
            connection.retryCount = -1L;
            connection.ext = "";
            connection.aliasId = -1L;
        }

        public ConnectionBuilder aliasId(long j) {
            this.connection.aliasId = j;
            return this;
        }

        public void build() {
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.CONNECTION, this.connection);
        }

        public ConnectionBuilder ext(String str) {
            this.connection.ext = str;
            return this;
        }

        public ConnectionBuilder reason(String str) {
            this.connection.reason = str;
            return this;
        }

        public ConnectionBuilder retryCount(long j) {
            this.connection.retryCount = j;
            return this;
        }

        public ConnectionBuilder retryTime(long j) {
            this.connection.retryTime = j;
            return this;
        }

        public ConnectionBuilder startTime(long j) {
            this.connection.startTime = j;
            return this;
        }

        public ConnectionBuilder stopTime(long j) {
            this.connection.stopTime = j;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class CrashBuilder {
        public static final int CRASH_TYPE_CATCH = 201001;
        public static final int CRASH_TYPE_DEFAULT = 201002;
        public Context context;
        public Crash crash;

        public CrashBuilder(Context context) {
            Crash crash = new Crash();
            this.crash = crash;
            this.context = context;
            crash.exception = "";
            crash.timestamp = System.currentTimeMillis();
            Crash crash2 = this.crash;
            crash2.ext = "";
            crash2.aliasId = 201001L;
        }

        public CrashBuilder aliasId(long j) {
            this.crash.aliasId = j;
            return this;
        }

        public void build() {
            if (TextUtils.isEmpty(this.crash.exception)) {
                return;
            }
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.CRASH, this.crash);
        }

        public CrashBuilder exception(String str) {
            this.crash.exception = str;
            return this;
        }

        public CrashBuilder ext(String str) {
            this.crash.ext = str;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class DbBuilder {
        public static final String ACTION_ADD = "add";
        public static final String ACTION_DELETE = "delete";
        public static final String ACTION_MIGRATE = "migrate";
        public static final String ACTION_QUERY = "query";
        public static final String ACTION_UPDATE = "update";
        public Context context;
        public Db db;

        public DbBuilder(Context context) {
            Db db = new Db();
            this.db = db;
            this.context = context;
            db.table = "";
            db.className = "";
            db.method = "";
            db.action = "";
            db.startTime = -1L;
            db.endTime = -1L;
            db.duration = -1L;
            db.ext = "";
            db.aliasId = -1L;
        }

        public DbBuilder action(String str) {
            this.db.action = str;
            return this;
        }

        public DbBuilder aliasId(long j) {
            this.db.aliasId = j;
            return this;
        }

        public void build() {
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.DB, this.db);
        }

        public DbBuilder className(String str) {
            this.db.className = str;
            return this;
        }

        public DbBuilder duration(long j) {
            this.db.duration = j;
            return this;
        }

        public DbBuilder endTime(long j) {
            this.db.endTime = j;
            return this;
        }

        public DbBuilder ext(String str) {
            this.db.ext = str;
            return this;
        }

        public DbBuilder method(String str) {
            this.db.method = str;
            return this;
        }

        public DbBuilder startTime(long j) {
            this.db.startTime = j;
            return this;
        }

        public DbBuilder table(String str) {
            this.db.table = str;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class MsgBuilder {
        public Context context;
        public Msg msg;

        public MsgBuilder(Context context) {
            Msg msg = new Msg();
            this.msg = msg;
            this.context = context;
            msg.msgCount = -1L;
            msg.roomId = "";
            msg.duration = -1L;
            msg.startMsgId = -1L;
            msg.endMsgId = -1L;
            msg.ext = "";
            msg.aliasId = -1L;
        }

        public MsgBuilder aliasId(long j) {
            this.msg.aliasId = j;
            return this;
        }

        public void build() {
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.MSG, this.msg);
        }

        public MsgBuilder duration(long j) {
            this.msg.duration = j;
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

        public MsgBuilder msgCount(long j) {
            this.msg.msgCount = j;
            return this;
        }

        public MsgBuilder roomId(String str) {
            this.msg.roomId = str;
            return this;
        }

        public MsgBuilder startMsgId(long j) {
            this.msg.startMsgId = j;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class RequestBuilder {
        public static final int REQUEST_INIT = 501100;
        public static final int REQUEST_JOIN = 501112;
        public static final int REQUEST_JOIN_CALLBACK = 501113;
        public static final int REQUEST_LOGIN = 501101;
        public Context context;
        public Request request;

        public RequestBuilder(Context context) {
            Request request = new Request();
            this.request = request;
            this.context = context;
            request.method = "";
            request.requestId = "";
            request.timestamp = -1L;
            request.responseTime = -1L;
            request.errorCode = -1L;
            request.ext = "";
            request.aliasId = -1L;
        }

        public RequestBuilder aliasId(long j) {
            this.request.aliasId = j;
            return this;
        }

        public void build() {
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.REQUEST, this.request);
        }

        public RequestBuilder errorCode(long j) {
            this.request.errorCode = j;
            return this;
        }

        public RequestBuilder ext(String str) {
            this.request.ext = str;
            return this;
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
    }

    /* loaded from: classes2.dex */
    public static final class UiBuilder {
        public static final String CATEGORY_CLICK = "category_click";
        public static final String CATEGORY_MI = "category_mi";
        public static final String CATEGORY_SHOW = "category_show";
        public Context context;
        public Ui ui;

        public UiBuilder(Context context) {
            Ui ui = new Ui();
            this.ui = ui;
            this.context = context;
            ui.category = "";
            ui.page = "";
            ui.startTime = -1L;
            ui.endTime = -1L;
            ui.duration = -1L;
            ui.ext = "";
            ui.aliasId = -1L;
        }

        public UiBuilder aliasId(long j) {
            this.ui.aliasId = j;
            return this;
        }

        public void build() {
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.UI, this.ui);
        }

        public UiBuilder category(String str) {
            this.ui.category = str;
            return this;
        }

        public UiBuilder duration(long j) {
            this.ui.duration = j;
            return this;
        }

        public UiBuilder endTime(long j) {
            this.ui.endTime = j;
            return this;
        }

        public UiBuilder ext(String str) {
            this.ui.ext = str;
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
    }

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
}
