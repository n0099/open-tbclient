package com.baidu.ar.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.baidu.ar.ARFragment;
import com.baidu.ar.base.RequestController;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.msghandler.DownloadMsgHandler;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.task.DownLoaderTask;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.Debug;
import com.baidu.ar.util.NetworkUtil;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.UiUtils;
import com.baidu.ar.util.Utils;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class n implements com.baidu.ar.c.e {
    private ARFragment a;
    private Dialog b;
    private Dialog c;
    private Dialog d;
    private Timer e;
    private TimerTask f;
    private Timer g;
    private TimerTask h;
    private a i;

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        RequestController a;

        a(RequestController requestController) {
            this.a = requestController;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.a != null) {
                    this.a.startRequest();
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.NET_NO_WIFI);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public n(ARFragment aRFragment) {
        this.a = aRFragment;
    }

    private void a(DialogInterface.OnClickListener onClickListener) {
        FragmentActivity activity;
        if (this.c == null) {
            if (this.a == null || (activity = this.a.getActivity()) == null) {
                return;
            }
            this.c = g.a(activity, onClickListener, new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    n.this.a.quit();
                }
            });
        }
        Debug.print("mNetworkErrorDialog:" + this.c);
        UiUtils.showDialogSafely(this.c);
    }

    private void a(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        FragmentActivity activity;
        if (this.c == null) {
            if (this.a == null || (activity = this.a.getActivity()) == null) {
                return;
            }
            if (onClickListener2 == null) {
                onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        n.this.a.quit();
                    }
                };
            }
            this.c = g.d(activity, onClickListener, onClickListener2);
        }
        UiUtils.showDialogSafely(this.c);
    }

    private void f() {
        if (this.g != null) {
            this.g.cancel();
            this.g.purge();
            this.g = null;
        }
        if (this.h != null) {
            this.h.cancel();
            this.h = null;
        }
    }

    private void g() {
        final FragmentActivity activity;
        if (this.b == null) {
            if (this.a == null || (activity = this.a.getActivity()) == null) {
                return;
            }
            this.b = g.c(activity, new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.15
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    activity.finish();
                    Utils.enterMarket(activity);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    activity.finish();
                }
            });
        }
        UiUtils.showDialogSafely(this.b);
    }

    private void h() {
        if (this.e != null) {
            this.e.cancel();
            this.e.purge();
            this.e = null;
        }
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
        }
    }

    private void h(final RequestController requestController) {
        h();
        this.e = new Timer();
        if (this.f == null) {
            this.f = new TimerTask() { // from class: com.baidu.ar.ui.n.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    DownLoaderTask downloadTask = requestController.getDownloadTask();
                    if (downloadTask != null) {
                        ARLog.d("timer timeout!");
                        AsyncTask.Status status = downloadTask.getStatus();
                        if (status == AsyncTask.Status.RUNNING || status == AsyncTask.Status.PENDING) {
                            ARLog.d("timer download timeout!");
                            downloadTask.setPause(true);
                            n.this.a.getHostUI().hideLoadingView();
                            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.n.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    n.this.i(requestController);
                                }
                            });
                        }
                    }
                }
            };
        }
        this.e.schedule(this.f, i());
    }

    private long i() {
        FragmentActivity activity = this.a.getActivity();
        if (NetworkUtil.isWifiNetworkConnected(activity)) {
            return 15000L;
        }
        if (NetworkUtil.isMobileNetworkConnected(activity)) {
            switch (NetworkUtil.getActiveNetworkType(activity)) {
                case 2:
                    return 20000L;
                case 3:
                    return 20000L;
                case 4:
                    return 15000L;
                default:
                    return 20000L;
            }
        }
        return 20000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final RequestController requestController) {
        FragmentActivity activity;
        if (this.d == null) {
            if (this.a == null || (activity = this.a.getActivity()) == null) {
                return;
            }
            this.d = g.b(activity, new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DownLoaderTask downloadTask = requestController.getDownloadTask();
                    if (downloadTask != null) {
                        AsyncTask.Status status = downloadTask.getStatus();
                        if (status == AsyncTask.Status.RUNNING || status == AsyncTask.Status.PENDING) {
                            n.this.a.getHostUI().showLoadingView();
                            downloadTask.setPause(false);
                        }
                    }
                }
            }, new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    n.this.a.quit();
                }
            });
        }
        UiUtils.showDialogSafely(this.d);
    }

    @Override // com.baidu.ar.c.e
    public void a() {
        this.a.getHostUI().showLoadingView();
    }

    @Override // com.baidu.ar.c.e
    public void a(final RequestController requestController) {
        this.a.getHostUI().hideLoadingView();
        a(new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                requestController.start();
            }
        });
    }

    @Override // com.baidu.ar.c.e
    public void a(ARResource aRResource) {
        this.a.getHostUI().hideLoadingView();
        String redirectUrl = aRResource != null ? aRResource.getRedirectUrl() : "";
        if (TextUtils.isEmpty(redirectUrl)) {
            redirectUrl = Res.getString("bdar_blacklist_default_url");
        }
        if (ARConfig.isBox()) {
            this.a.getARCallback().executeCommand(this.a.getActivity().getApplicationContext(), redirectUrl);
        } else {
            this.a.getARCallback().nonsupport(redirectUrl);
        }
        if (ARConfig.isBox()) {
            this.a.quit();
        }
    }

    @Override // com.baidu.ar.c.e
    public void a(final DownloadMsgHandler downloadMsgHandler) {
        a(new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (downloadMsgHandler != null) {
                    downloadMsgHandler.retryDownloadBatch();
                }
            }
        }, new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (downloadMsgHandler != null) {
                    downloadMsgHandler.cancelDownloadBatch();
                }
                n.this.a.quit();
            }
        });
    }

    @Override // com.baidu.ar.c.e
    public void a(String str) {
        this.a.getHostUI().hideLoadingView();
        if (this.a.getActivity() != null) {
            new ToastCustom(this.a.getActivity().getApplicationContext()).makeText(str, 0, 2).show();
        }
    }

    @Override // com.baidu.ar.c.e
    public void b() {
        this.a.getHostUI().showLoadingView();
    }

    @Override // com.baidu.ar.c.e
    public void b(final RequestController requestController) {
        this.a.getHostUI().hideLoadingView();
        a(new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                requestController.start();
            }
        });
    }

    @Override // com.baidu.ar.c.e
    public void b(String str) {
        this.a.getHostUI().hideLoadingView();
        if (ARConfig.isBox()) {
            g();
        } else if (this.a.getActivity() != null) {
            new ToastCustom(this.a.getActivity().getApplicationContext()).makeText(str, 0, 2).show();
        }
    }

    @Override // com.baidu.ar.c.e
    public void c() {
        h();
        f();
    }

    @Override // com.baidu.ar.c.e
    public void c(final RequestController requestController) {
        this.a.getHostUI().hideLoadingView();
        a(new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                requestController.startDownload();
                n.this.a.getHostUI().showLoadingView();
            }
        }, (DialogInterface.OnClickListener) null);
    }

    public void d() {
        h();
        f();
    }

    @Override // com.baidu.ar.c.e
    public void d(final RequestController requestController) {
        this.a.getHostUI().hideLoadingView();
        a(new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                requestController.downloadCodeResource();
            }
        });
    }

    public void e() {
        UiUtils.dismissDialog(this.d);
        UiUtils.dismissDialog(this.c);
    }

    @Override // com.baidu.ar.c.e
    public void e(RequestController requestController) {
        h(requestController);
    }

    @Override // com.baidu.ar.c.e
    public void f(final RequestController requestController) {
        h();
        f();
        this.a.getHostUI().hideLoadingView();
        a(new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.n.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                requestController.downloadArResource();
                n.this.a.getHostUI().showLoadingView();
            }
        }, (DialogInterface.OnClickListener) null);
    }

    @Override // com.baidu.ar.c.e
    public void g(RequestController requestController) {
        this.a.getHostUI().hideLoadingView();
        if (this.a.getActivity() != null) {
            new ToastCustom(this.a.getActivity().getApplicationContext()).makeText(Res.getString("bdar_non_wifi_tips"), 0, 2).show();
        }
        f();
        this.i = new a(requestController);
        this.h = new TimerTask() { // from class: com.baidu.ar.ui.n.8
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                UiThreadUtil.runOnUiThread(n.this.i);
            }
        };
        this.g = new Timer();
        this.g.schedule(this.h, 2500L);
    }
}
