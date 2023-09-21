package com.baidu.searchbox.download.unified;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.unified.EventCallback;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadNetworkHelper;
import com.baidu.searchbox.download.util.DuplicateHelper;
import com.baidu.searchbox.download.util.ExternalStorageCallBack;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.a20;
import com.baidu.webkit.internal.utils.NetWorkUtils;
/* loaded from: classes3.dex */
public abstract class EventActionForStart {
    public Context context;
    public IDownloadListener downloadListener;
    public DownloadParams downloadParams;
    public EventCallback eventCallback;
    public EventControlInfoForStart eventControlInfoForStart;
    public String source;

    public abstract void action(IContinue<EventActionForStart> iContinue);

    /* loaded from: classes3.dex */
    public static class CheckDuplicateEvent extends EventActionForStart {

        /* renamed from: com.baidu.searchbox.download.unified.EventActionForStart$CheckDuplicateEvent$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public class AnonymousClass1 implements Runnable {
            public final /* synthetic */ IContinue val$iContinue;

            public AnonymousClass1(IContinue iContinue) {
                this.val$iContinue = iContinue;
            }

            @Override // java.lang.Runnable
            public void run() {
                final boolean isDuplicateUrl = DuplicateHelper.isDuplicateUrl(AppRuntime.getAppContext(), CheckDuplicateEvent.this.downloadParams.getUrl(), null);
                UiThreadUtils.getMainHandler().post(new Runnable() { // from class: com.baidu.searchbox.download.unified.EventActionForStart.CheckDuplicateEvent.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (isDuplicateUrl) {
                            DuplicateHelper.showDuplicateDialog(CheckDuplicateEvent.this.context, new DialogClickCallback() { // from class: com.baidu.searchbox.download.unified.EventActionForStart.CheckDuplicateEvent.1.1.1
                                @Override // com.baidu.searchbox.download.unified.DialogClickCallback
                                public void callback(boolean z) {
                                    EventCallback eventCallback = CheckDuplicateEvent.this.eventCallback;
                                    if (eventCallback != null) {
                                        if (z) {
                                            eventCallback.callBack(3, new EventCallback.EventBackInfo(EventCallback.Info.INFO_DUPLICATE_CLICK_YES));
                                        } else {
                                            eventCallback.callBack(2, new EventCallback.EventBackInfo(108));
                                        }
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    IContinue iContinue = anonymousClass1.val$iContinue;
                                    if (iContinue != null) {
                                        iContinue.continueCall(z, CheckDuplicateEvent.this);
                                    }
                                }
                            });
                            EventCallback eventCallback = CheckDuplicateEvent.this.eventCallback;
                            if (eventCallback != null) {
                                eventCallback.callBack(3, new EventCallback.EventBackInfo(EventCallback.Info.INFO_DUPLICATE_SHOW));
                                return;
                            }
                            return;
                        }
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        IContinue iContinue = anonymousClass1.val$iContinue;
                        if (iContinue != null) {
                            iContinue.continueCall(true, CheckDuplicateEvent.this);
                        }
                    }
                });
            }
        }

        public CheckDuplicateEvent(Context context, String str, DownloadParams downloadParams, IDownloadListener iDownloadListener, EventControlInfoForStart eventControlInfoForStart, EventCallback eventCallback) {
            super(context, str, downloadParams, iDownloadListener, eventControlInfoForStart, eventCallback);
        }

        @Override // com.baidu.searchbox.download.unified.EventActionForStart
        public void action(IContinue<EventActionForStart> iContinue) {
            if (this.eventControlInfoForStart.checkDuplicate) {
                ExecutorUtilsExt.postOnSerial(new AnonymousClass1(iContinue), "checkDuplicateDownload");
            } else if (iContinue != null) {
                iContinue.continueCall(true, this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class CheckExternalStoragePermission extends EventActionForStart {
        public CheckExternalStoragePermission(Context context, String str, DownloadParams downloadParams, IDownloadListener iDownloadListener, EventControlInfoForStart eventControlInfoForStart, EventCallback eventCallback) {
            super(context, str, downloadParams, iDownloadListener, eventControlInfoForStart, eventCallback);
        }

        private void requestSdcardPermission(Context context, String str, final IContinue<EventActionForStart> iContinue) {
            DownloadHelper.requestExternalStoragePermission(context, str, this.eventCallback, new ExternalStorageCallBack() { // from class: com.baidu.searchbox.download.unified.EventActionForStart.CheckExternalStoragePermission.1
                @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
                public void onResult(boolean z) {
                    IContinue iContinue2 = iContinue;
                    if (iContinue2 != null) {
                        iContinue2.continueCall(z, CheckExternalStoragePermission.this);
                    }
                }
            });
        }

        @Override // com.baidu.searchbox.download.unified.EventActionForStart
        public void action(IContinue<EventActionForStart> iContinue) {
            EventCallback eventCallback;
            EventCallback eventCallback2;
            if (this.eventControlInfoForStart.checkPermission) {
                if (!DownloadHelper.isStoragePermissionGranted()) {
                    a20.n(false, this.source);
                    if (this.downloadParams.getDestination() == 4) {
                        String filePathHint = this.downloadParams.getFilePathHint();
                        if (TextUtils.isEmpty(filePathHint) && (eventCallback2 = this.eventCallback) != null) {
                            eventCallback2.callBack(2, new EventCallback.EventBackInfo(105));
                            if (iContinue != null) {
                                iContinue.continueCall(false, this);
                                return;
                            }
                            return;
                        } else if (!filePathHint.startsWith("file://") && (eventCallback = this.eventCallback) != null) {
                            eventCallback.callBack(2, new EventCallback.EventBackInfo(106));
                            if (iContinue != null) {
                                iContinue.continueCall(false, this);
                                return;
                            }
                            return;
                        } else if (!DownloadHelper.isStoragePrivatePath(filePathHint)) {
                            requestSdcardPermission(this.context, this.source, iContinue);
                            return;
                        } else if (iContinue != null) {
                            iContinue.continueCall(true, this);
                            return;
                        } else {
                            return;
                        }
                    } else if (DownloadHelper.getDownloadDirectoryUserSet() != null) {
                        if (!DownloadHelper.isStoragePrivatePath(DownloadHelper.getDownloadDirectoryUserSet().getAbsolutePath())) {
                            requestSdcardPermission(this.context, this.source, iContinue);
                            return;
                        } else if (iContinue != null) {
                            iContinue.continueCall(true, this);
                            return;
                        } else {
                            return;
                        }
                    } else if (DestinationControlUtil.isSdcardPublic(this.source)) {
                        requestSdcardPermission(this.context, this.source, iContinue);
                        return;
                    } else if (iContinue != null) {
                        iContinue.continueCall(true, this);
                        return;
                    } else {
                        return;
                    }
                }
                a20.n(true, this.source);
                if (iContinue != null) {
                    iContinue.continueCall(true, this);
                }
            } else if (iContinue != null) {
                iContinue.continueCall(true, this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class CheckNetEvent extends EventActionForStart {
        public CheckNetEvent(Context context, String str, DownloadParams downloadParams, IDownloadListener iDownloadListener, EventControlInfoForStart eventControlInfoForStart, EventCallback eventCallback) {
            super(context, str, downloadParams, iDownloadListener, eventControlInfoForStart, eventCallback);
        }

        @Override // com.baidu.searchbox.download.unified.EventActionForStart
        public void action(final IContinue<EventActionForStart> iContinue) {
            if (this.eventControlInfoForStart.checkNetType) {
                if (NetWorkUtils.getNetTypeIsMobile()) {
                    DownloadNetworkHelper.showNetworkDialog(this.context, new DialogClickCallback() { // from class: com.baidu.searchbox.download.unified.EventActionForStart.CheckNetEvent.1
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

    public EventActionForStart(Context context, String str, DownloadParams downloadParams, IDownloadListener iDownloadListener, EventControlInfoForStart eventControlInfoForStart, EventCallback eventCallback) {
        this.context = context;
        this.source = str;
        this.downloadParams = downloadParams;
        this.downloadListener = iDownloadListener;
        this.eventControlInfoForStart = eventControlInfoForStart;
        this.eventCallback = eventCallback;
    }

    public IDownloadListener getDownloadListener() {
        return this.downloadListener;
    }

    public DownloadParams getDownloadParams() {
        return this.downloadParams;
    }

    public EventCallback getEventCallback() {
        return this.eventCallback;
    }

    public String getSource() {
        return this.source;
    }
}
