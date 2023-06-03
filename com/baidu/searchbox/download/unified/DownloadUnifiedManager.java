package com.baidu.searchbox.download.unified;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.callback.FileDownloadListener;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.unified.EventActionForResume;
import com.baidu.searchbox.download.unified.EventActionForStart;
import com.baidu.searchbox.download.unified.EventCallback;
import com.baidu.searchbox.download.unified.db.DBHelper;
import com.baidu.searchbox.downloads.DownloadMessageSender;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.w20;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class DownloadUnifiedManager {
    public static DownloadUnifiedManager mInstance;

    public static DownloadUnifiedManager getInstance() {
        if (mInstance == null) {
            synchronized (DownloadUnifiedManager.class) {
                if (mInstance == null) {
                    mInstance = new DownloadUnifiedManager();
                }
            }
        }
        return mInstance;
    }

    public void queryDownloadInfoDataAsync(final Uri uri, final DownloadInfoDatasCallback downloadInfoDatasCallback) {
        if (uri != null && downloadInfoDatasCallback != null) {
            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.download.unified.DownloadUnifiedManager.3
                @Override // java.lang.Runnable
                public void run() {
                    DownloadInfoData queryDownloadInfoData = DownloadUnifiedManager.this.queryDownloadInfoData(uri);
                    final ArrayList arrayList = new ArrayList();
                    if (queryDownloadInfoData != null) {
                        arrayList.add(queryDownloadInfoData);
                    }
                    UiThreadUtils.getMainHandler().post(new Runnable() { // from class: com.baidu.searchbox.download.unified.DownloadUnifiedManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            downloadInfoDatasCallback.callback(arrayList);
                        }
                    });
                }
            }, "queryDownloadInfoDataAsync");
        }
    }

    private boolean checkParamsForResume(String str, Uri uri, IDownloadListener iDownloadListener, EventControlInfoForResume eventControlInfoForResume, EventCallback eventCallback) {
        if (!TextUtils.isEmpty(str) && str.length() <= 30) {
            if (uri == null) {
                if (eventCallback != null) {
                    eventCallback.callBack(2, new EventCallback.EventBackInfo(104));
                }
                return false;
            }
            return true;
        }
        if (eventCallback != null) {
            eventCallback.callBack(2, new EventCallback.EventBackInfo(101));
        }
        return false;
    }

    private boolean checkParamsForStart(String str, DownloadParams downloadParams, EventControlInfoForStart eventControlInfoForStart, IDownloadListener iDownloadListener, EventCallback eventCallback) {
        if (!TextUtils.isEmpty(str) && str.length() <= 30) {
            if (downloadParams == null) {
                if (eventCallback != null) {
                    eventCallback.callBack(2, new EventCallback.EventBackInfo(102));
                }
                return false;
            } else if (TextUtils.isEmpty(downloadParams.getUrl())) {
                if (eventCallback != null) {
                    eventCallback.callBack(2, new EventCallback.EventBackInfo(103));
                }
                return false;
            } else {
                return true;
            }
        }
        if (eventCallback != null) {
            eventCallback.callBack(2, new EventCallback.EventBackInfo(101));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doEventActinosForStart(final List<EventActionForStart> list) {
        if (list.size() > 0) {
            list.remove(0).action(new IContinue<EventActionForStart>() { // from class: com.baidu.searchbox.download.unified.DownloadUnifiedManager.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.download.unified.IContinue
                public void continueCall(boolean z, final EventActionForStart eventActionForStart) {
                    if (z) {
                        if (list.size() <= 0) {
                            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.download.unified.DownloadUnifiedManager.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    final Uri doDownload = DBHelper.doDownload(eventActionForStart.getSource(), eventActionForStart.getDownloadParams());
                                    UiThreadUtils.getMainHandler().post(new Runnable() { // from class: com.baidu.searchbox.download.unified.DownloadUnifiedManager.4.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IDownloadListener downloadListener = eventActionForStart.getDownloadListener();
                                            EventCallback eventCallback = eventActionForStart.getEventCallback();
                                            if (doDownload != null) {
                                                if (downloadListener != null) {
                                                    DownloadManagerExt.getInstance().registerObserver(AppRuntime.getAppContext(), doDownload, new FileDownloadListener(AppRuntime.getAppContext(), downloadListener));
                                                }
                                                if (eventCallback != null) {
                                                    eventCallback.callBack(1, new EventCallback.EventBackInfo(doDownload));
                                                }
                                                DownloadMessageSender.sendBeginMessage(eventActionForStart.getSource(), eventActionForStart.getDownloadParams());
                                            } else if (eventCallback != null) {
                                                eventCallback.callBack(2, new EventCallback.EventBackInfo(111));
                                            }
                                        }
                                    });
                                }
                            }, "doDownload");
                        } else {
                            DownloadUnifiedManager.this.doEventActinosForStart(list);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doEventActionsForResume(final List<EventActionForResume> list) {
        if (list.size() > 0) {
            list.remove(0).action(new IContinue<EventActionForResume>() { // from class: com.baidu.searchbox.download.unified.DownloadUnifiedManager.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.download.unified.IContinue
                public void continueCall(boolean z, final EventActionForResume eventActionForResume) {
                    if (z) {
                        if (list.size() <= 0) {
                            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.download.unified.DownloadUnifiedManager.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    final Uri downloadUri = eventActionForResume.getDownloadUri();
                                    final int doResumeDownloadForUri = DBHelper.doResumeDownloadForUri(downloadUri);
                                    UiThreadUtils.getMainHandler().post(new Runnable() { // from class: com.baidu.searchbox.download.unified.DownloadUnifiedManager.5.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IDownloadListener downloadListener = eventActionForResume.getDownloadListener();
                                            EventCallback eventCallback = eventActionForResume.getEventCallback();
                                            if (doResumeDownloadForUri > 0) {
                                                if (downloadListener != null) {
                                                    FileDownloadListener fileDownloadListener = new FileDownloadListener(AppRuntime.getAppContext(), downloadListener);
                                                    DownloadManagerExt.getInstance().unregisterObserver(AppRuntime.getAppContext(), downloadUri);
                                                    DownloadManagerExt.getInstance().registerObserver(AppRuntime.getAppContext(), downloadUri, fileDownloadListener);
                                                }
                                                if (eventCallback != null) {
                                                    eventCallback.callBack(1, null);
                                                }
                                            } else if (eventCallback != null) {
                                                eventCallback.callBack(2, new EventCallback.EventBackInfo(112));
                                            }
                                        }
                                    });
                                }
                            }, "doResume");
                        } else {
                            DownloadUnifiedManager.this.doEventActionsForResume(list);
                        }
                    }
                }
            });
        }
    }

    public void deleteDownload(Uri uri) {
        DownloadManagerExt.getInstance().cancelDownload(uri);
        DownloadManagerExt.getInstance().unregisterObserver(AppRuntime.getAppContext(), uri);
    }

    public void deleteDownloadAsync(final Uri uri) {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.download.unified.DownloadUnifiedManager.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadUnifiedManager.this.deleteDownload(uri);
            }
        }, "deleteDownloadAsync");
    }

    public void pauseDownload(Uri uri) {
        DownloadManagerExt.getInstance().pauseDownload(uri);
    }

    public void pauseDownloadAsync(final Uri uri) {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.searchbox.download.unified.DownloadUnifiedManager.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadUnifiedManager.this.pauseDownload(uri);
            }
        }, "pauseDownloadAsync");
    }

    public DownloadInfoData queryDownloadInfoData(Uri uri) {
        return DBHelper.queryDownloadInfoData(uri);
    }

    public void resumeDownload(Context context, String str, Uri uri, IDownloadListener iDownloadListener, EventControlInfoForResume eventControlInfoForResume, EventCallback eventCallback) {
        if (!checkParamsForResume(str, uri, iDownloadListener, eventControlInfoForResume, eventCallback)) {
            return;
        }
        if (eventControlInfoForResume == null) {
            eventControlInfoForResume = new EventControlInfoForResume(true, true);
        }
        ArrayList arrayList = new ArrayList();
        EventControlInfoForResume eventControlInfoForResume2 = eventControlInfoForResume;
        arrayList.add(new EventActionForResume.CheckNetEvent(context, str, uri, iDownloadListener, eventControlInfoForResume2, eventCallback));
        arrayList.add(new EventActionForResume.CheckExternalStoragePermission(context, str, uri, iDownloadListener, eventControlInfoForResume2, eventCallback));
        doEventActionsForResume(arrayList);
    }

    public void startDownload(Context context, String str, DownloadParams downloadParams, IDownloadListener iDownloadListener, EventControlInfoForStart eventControlInfoForStart, EventCallback eventCallback) {
        w20.k(str);
        if (!checkParamsForStart(str, downloadParams, eventControlInfoForStart, iDownloadListener, eventCallback)) {
            return;
        }
        if (eventControlInfoForStart == null) {
            eventControlInfoForStart = new EventControlInfoForStart(true, true, true);
        }
        ArrayList arrayList = new ArrayList();
        EventControlInfoForStart eventControlInfoForStart2 = eventControlInfoForStart;
        arrayList.add(new EventActionForStart.CheckNetEvent(context, str, downloadParams, iDownloadListener, eventControlInfoForStart2, eventCallback));
        arrayList.add(new EventActionForStart.CheckExternalStoragePermission(context, str, downloadParams, iDownloadListener, eventControlInfoForStart2, eventCallback));
        arrayList.add(new EventActionForStart.CheckDuplicateEvent(context, str, downloadParams, iDownloadListener, eventControlInfoForStart2, eventCallback));
        doEventActinosForStart(arrayList);
    }
}
