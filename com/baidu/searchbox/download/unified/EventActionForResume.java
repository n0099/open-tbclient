package com.baidu.searchbox.download.unified;

import android.content.Context;
import android.net.Uri;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.unified.EventCallback;
import com.baidu.searchbox.download.unified.db.DBHelper;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadNetworkHelper;
import com.baidu.searchbox.download.util.ExternalStorageCallBack;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.webkit.internal.utils.NetWorkUtils;
/* loaded from: classes3.dex */
public abstract class EventActionForResume {
    public Context context;
    public IDownloadListener downloadListener;
    public Uri downloadUri;
    public EventCallback eventCallback;
    public EventControlInfoForResume eventControlInfoForResume;
    public String source;

    public abstract void action(IContinue<EventActionForResume> iContinue);

    /* loaded from: classes3.dex */
    public static class CheckExternalStoragePermission extends EventActionForResume {
        public CheckExternalStoragePermission(Context context, String str, Uri uri, IDownloadListener iDownloadListener, EventControlInfoForResume eventControlInfoForResume, EventCallback eventCallback) {
            super(context, str, uri, iDownloadListener, eventControlInfoForResume, eventCallback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestSdcardPermission(Context context, String str, final IContinue<EventActionForResume> iContinue) {
            DownloadHelper.requestExternalStoragePermission(context, str, this.eventCallback, new ExternalStorageCallBack() { // from class: com.baidu.searchbox.download.unified.EventActionForResume.CheckExternalStoragePermission.2
                @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
                public void onResult(boolean z) {
                    IContinue iContinue2 = iContinue;
                    if (iContinue2 != null) {
                        iContinue2.continueCall(z, CheckExternalStoragePermission.this);
                    }
                }
            });
        }

        @Override // com.baidu.searchbox.download.unified.EventActionForResume
        public void action(final IContinue<EventActionForResume> iContinue) {
            if (this.eventControlInfoForResume.checkPermission) {
                if (!DownloadHelper.isStoragePermissionGranted()) {
                    ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.download.unified.EventActionForResume.CheckExternalStoragePermission.1
                        @Override // java.lang.Runnable
                        public void run() {
                            final boolean z = !DownloadHelper.isStoragePrivatePath(DBHelper.getDownloadPath(CheckExternalStoragePermission.this.downloadUri));
                            UiThreadUtils.getMainHandler().post(new Runnable() { // from class: com.baidu.searchbox.download.unified.EventActionForResume.CheckExternalStoragePermission.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (z) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        CheckExternalStoragePermission checkExternalStoragePermission = CheckExternalStoragePermission.this;
                                        checkExternalStoragePermission.requestSdcardPermission(checkExternalStoragePermission.context, checkExternalStoragePermission.source, iContinue);
                                        return;
                                    }
                                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                    IContinue iContinue2 = iContinue;
                                    if (iContinue2 != null) {
                                        iContinue2.continueCall(true, CheckExternalStoragePermission.this);
                                    }
                                }
                            });
                        }
                    }, "needRequestStoragePermission");
                } else if (iContinue != null) {
                    iContinue.continueCall(true, this);
                }
            } else if (iContinue != null) {
                iContinue.continueCall(true, this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class CheckNetEvent extends EventActionForResume {
        public CheckNetEvent(Context context, String str, Uri uri, IDownloadListener iDownloadListener, EventControlInfoForResume eventControlInfoForResume, EventCallback eventCallback) {
            super(context, str, uri, iDownloadListener, eventControlInfoForResume, eventCallback);
        }

        @Override // com.baidu.searchbox.download.unified.EventActionForResume
        public void action(final IContinue<EventActionForResume> iContinue) {
            if (this.eventControlInfoForResume.checkNetType) {
                if (NetWorkUtils.getNetTypeIsMobile()) {
                    DownloadNetworkHelper.showNetworkDialog(this.context, new DialogClickCallback() { // from class: com.baidu.searchbox.download.unified.EventActionForResume.CheckNetEvent.1
                        @Override // com.baidu.searchbox.download.unified.DialogClickCallback
                        public void callback(boolean z) {
                            EventCallback eventCallback = CheckNetEvent.this.eventCallback;
                            if (eventCallback != null) {
                                if (z) {
                                    eventCallback.callBack(3, new EventCallback.EventBackInfo(EventCallback.Info.INFO_NET_CHECK_CLICK_YES));
                                } else {
                                    eventCallback.callBack(2, new EventCallback.EventBackInfo(107));
                                }
                            }
                            IContinue iContinue2 = iContinue;
                            if (iContinue2 != null) {
                                iContinue2.continueCall(z, CheckNetEvent.this);
                            }
                        }
                    });
                    EventCallback eventCallback = this.eventCallback;
                    if (eventCallback != null) {
                        eventCallback.callBack(3, new EventCallback.EventBackInfo(EventCallback.Info.INFO_NET_CHECK_SHOW));
                    }
                } else if (iContinue != null) {
                    iContinue.continueCall(true, this);
                }
            } else if (iContinue != null) {
                iContinue.continueCall(true, this);
            }
        }
    }

    public EventActionForResume(Context context, String str, Uri uri, IDownloadListener iDownloadListener, EventControlInfoForResume eventControlInfoForResume, EventCallback eventCallback) {
        this.context = context;
        this.source = str;
        this.downloadUri = uri;
        this.downloadListener = iDownloadListener;
        this.eventControlInfoForResume = eventControlInfoForResume;
        this.eventCallback = eventCallback;
    }

    public IDownloadListener getDownloadListener() {
        return this.downloadListener;
    }

    public Uri getDownloadUri() {
        return this.downloadUri;
    }

    public EventCallback getEventCallback() {
        return this.eventCallback;
    }
}
