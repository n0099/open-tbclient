package com.baidu.android.imrtc.upload;

import android.content.Context;
import com.baidu.android.imrtc.utils.TaskManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Request;
/* loaded from: classes5.dex */
public class BIMRtcTrack {

    /* loaded from: classes5.dex */
    public static final class RequestBuilder {
        public static final int REQUEST_BIM_RTC = 501210;
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
            BIMRtcTrack.reportTracker(this.context, IMPushPb.ActionType.REQUEST, this.request);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportTracker(Context context, final IMPushPb.ActionType actionType, final Object obj) {
        final Context applicationContext = context.getApplicationContext();
        TaskManager.getInstance().submitForNetWork(new Runnable() { // from class: com.baidu.android.imrtc.upload.BIMRtcTrack.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BIMRtcTrackDatabase.myLock) {
                    switch (AnonymousClass2.$SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.this.ordinal()]) {
                        case 1:
                            BIMRtcTrackDatabase.getInstance(applicationContext).insertRequest((Request) obj);
                            break;
                    }
                }
            }
        });
    }

    /* renamed from: com.baidu.android.imrtc.upload.BIMRtcTrack$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType = new int[IMPushPb.ActionType.values().length];

        static {
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }
}
