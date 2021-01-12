package com.baidu.lcp.sdk.a;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.lcp.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0149a {
        private Connection connection = new Connection();
        private Context context;

        public C0149a(Context context) {
            this.context = context;
            this.connection.startTime = -1L;
            this.connection.stopTime = -1L;
            this.connection.reason = "";
            this.connection.retryTime = -1L;
            this.connection.retryCount = -1L;
            this.connection.ext = "";
            this.connection.aliasId = -1L;
        }

        public C0149a S(long j) {
            this.connection.startTime = j;
            return this;
        }

        public C0149a T(long j) {
            this.connection.stopTime = j;
            return this;
        }

        public C0149a ed(String str) {
            this.connection.reason = str;
            return this;
        }

        public C0149a U(long j) {
            this.connection.retryCount = j;
            return this;
        }

        public C0149a ee(String str) {
            this.connection.ext = str;
            return this;
        }

        public C0149a V(long j) {
            this.connection.aliasId = j;
            return this;
        }

        public void build() {
            a.reportTracker(this.context, IMPushPb.ActionType.CONNECTION, this.connection);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        private Context context;
        private Request request = new Request();

        public b(Context context) {
            this.context = context;
            this.request.method = "";
            this.request.requestId = "";
            this.request.timestamp = -1L;
            this.request.responseTime = -1L;
            this.request.errorCode = -1L;
            this.request.ext = "";
            this.request.aliasId = -1L;
        }

        public b ef(String str) {
            this.request.method = str;
            return this;
        }

        public b eg(String str) {
            this.request.requestId = str;
            return this;
        }

        public b W(long j) {
            this.request.timestamp = j;
            return this;
        }

        public b X(long j) {
            this.request.responseTime = j;
            return this;
        }

        public b Y(long j) {
            this.request.errorCode = j;
            return this;
        }

        public b eh(String str) {
            this.request.ext = str;
            return this;
        }

        public b Z(long j) {
            this.request.aliasId = j;
            return this;
        }

        public void build() {
            a.reportTracker(this.context, IMPushPb.ActionType.REQUEST, this.request);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportTracker(Context context, final IMPushPb.ActionType actionType, final Object obj) {
        final Context applicationContext = context.getApplicationContext();
        if (d.aw(applicationContext)) {
            com.baidu.lcp.sdk.c.a.aF(applicationContext).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.$SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.this.ordinal()]) {
                        case 1:
                            c.a(applicationContext, (Connection) obj);
                            return;
                        case 2:
                            c.a(applicationContext, (Request) obj);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    /* renamed from: com.baidu.lcp.sdk.a.a$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType = new int[IMPushPb.ActionType.values().length];

        static {
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }
}
