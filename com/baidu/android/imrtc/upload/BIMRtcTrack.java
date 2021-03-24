package com.baidu.android.imrtc.upload;

import android.content.Context;
import com.baidu.android.imrtc.utils.TaskManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Request;
/* loaded from: classes2.dex */
public class BIMRtcTrack {

    /* renamed from: com.baidu.android.imrtc.upload.BIMRtcTrack$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType;

        static {
            int[] iArr = new int[IMPushPb.ActionType.values().length];
            $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType = iArr;
            try {
                iArr[IMPushPb.ActionType.REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class RequestBuilder {
        public static final int REQUEST_BIM_RTC = 501210;
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
            BIMRtcTrack.reportTracker(this.context, IMPushPb.ActionType.REQUEST, this.request);
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

    public static void reportTracker(Context context, final IMPushPb.ActionType actionType, final Object obj) {
        final Context applicationContext = context.getApplicationContext();
        TaskManager.getInstance().submitForNetWork(new Runnable() { // from class: com.baidu.android.imrtc.upload.BIMRtcTrack.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BIMRtcTrackDatabase.myLock) {
                    if (AnonymousClass2.$SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.this.ordinal()] == 1) {
                        BIMRtcTrackDatabase.getInstance(applicationContext).insertRequest((Request) obj);
                    }
                }
            }
        });
    }
}
