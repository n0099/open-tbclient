package com.baidu.ar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.ar.ARPermissionManager;
import com.baidu.ar.TakePictureCallback;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.bean.FunctionType;
import com.baidu.ar.external.ShareResultListener;
import com.baidu.ar.permissions.PermissionAction;
import com.baidu.ar.recorder.MovieRecorderCallback;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.ui.ShareView;
import com.baidu.ar.ui.a.a;
import com.baidu.ar.ui.view.a;
import com.baidu.ar.util.MediaUtils;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.UiUtils;
import com.baidu.ar.util.Utils;
import com.baidu.ar.util.ViewUtils;
import com.baidu.ar.util.sputil.SPUtils;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes3.dex */
public class CaptureUI implements a.InterfaceC0053a {
    private static final String b = CaptureUI.class.getSimpleName();
    private com.baidu.ar.b c;
    private c d;
    private ARResource e;
    private ViewGroup f;
    private Activity g;
    private Context h;
    private a k;
    private ShareView l;
    private p o;
    private com.baidu.ar.ui.view.a p;
    private boolean i = false;
    private boolean j = false;
    private RecordAction m = RecordAction.INITIAL_STATE;
    private String n = "";
    protected boolean a = false;
    private boolean q = true;
    private boolean r = false;
    private TakePictureCallback s = new TakePictureCallback() { // from class: com.baidu.ar.ui.CaptureUI.1
        @Override // com.baidu.ar.TakePictureCallback
        public void onPictureTake(final boolean z, final String str) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.CaptureUI.1.1
                @Override // java.lang.Runnable
                public void run() {
                    CaptureUI.this.i = false;
                    CaptureUI.this.p.b(true);
                    CaptureUI.this.p.a(0);
                    ViewUtils.setViewEnabled(CaptureUI.this.d.t.b(), true);
                    if (z) {
                        if (CaptureUI.this.d.q == null || CaptureUI.this.d.q.getARCaptureResultCallback() == null) {
                            CaptureUI.this.a(BitmapFactory.decodeFile(str));
                            return;
                        }
                        CaptureUI.this.d.q.getARCaptureResultCallback().onPictureTaken(str);
                        CaptureUI.this.c.l().a(false);
                    }
                }
            });
        }
    };
    private MovieRecorderCallback t = new MovieRecorderCallback() { // from class: com.baidu.ar.ui.CaptureUI.2
        @Override // com.baidu.ar.recorder.MovieRecorderCallback
        public void onRecorderComplete(final boolean z, final String str) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.CaptureUI.2.3
                @Override // java.lang.Runnable
                public void run() {
                    CaptureUI.this.n = str;
                    if (z && CaptureUI.this.a) {
                        CaptureUI.this.c(false);
                    }
                    CaptureUI.this.j = false;
                }
            });
        }

        @Override // com.baidu.ar.recorder.MovieRecorderCallback
        public void onRecorderError(int i) {
            CaptureUI.this.j = false;
        }

        @Override // com.baidu.ar.recorder.MovieRecorderCallback
        public void onRecorderProcess(final int i) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.CaptureUI.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (CaptureUI.this.p.b(i)) {
                        CaptureUI.this.a(RecordAction.GO_TO_SHARE_VIEW);
                    }
                }
            });
        }

        @Override // com.baidu.ar.recorder.MovieRecorderCallback
        public void onRecorderStart(final boolean z) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.CaptureUI.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!z || !CaptureUI.this.a) {
                        CaptureUI.this.p.c();
                        CaptureUI.this.j = false;
                        return;
                    }
                    CaptureUI.this.p.b();
                    CaptureUI.this.d.v.b(true);
                    CaptureUI.this.d.u.b(true);
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.ONCLICK_CAPTURE_VIDEO);
                }
            });
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum RecordAction {
        INITIAL_STATE,
        NOTHING,
        GO_TO_SHARE_VIEW,
        CUSTOM
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends AsyncTask<Object, Integer, Bitmap> {
        private WeakReference<CaptureUI> a;
        private boolean b;

        a(CaptureUI captureUI, boolean z) {
            this.a = new WeakReference<>(captureUI);
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(Object... objArr) {
            String str = (String) objArr[0];
            Long l = (Long) objArr[1];
            Integer num = (Integer) objArr[2];
            return MediaUtils.getFrameAtTime(str, l != null ? l.longValue() : 0L, num != null ? num.intValue() : 2);
        }

        public void a() {
            if (this.a != null) {
                this.a.clear();
                this.a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                if (this.a != null && this.a.get() != null) {
                    this.a.get().a((Bitmap) null);
                    if (this.a.get().l != null) {
                        this.a.get().l.a();
                        this.a.get().l.setVideoMask(bitmap);
                    }
                }
            } else if (this.b) {
                ArBridge.getInstance().onResumeByUser();
            }
            if (this.a != null && this.a.get() != null) {
                this.a.get().c.h().getHostUI().hideLoadingView();
                this.a.get().p.a(0);
                ViewUtils.setViewEnabled(this.a.get().d.u.a(), true);
                ViewUtils.setViewEnabled(this.a.get().d.v.a(), true);
                ViewUtils.setViewEnabled(this.a.get().d.w.b(), true);
                ViewUtils.setViewEnabled(this.a.get().d.t.b(), true);
                ViewUtils.setViewEnabled(this.a.get().d.w.b(), true);
            }
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CaptureUI(Activity activity, View view, com.baidu.ar.b bVar, c cVar, ARResource aRResource) {
        this.g = activity;
        this.h = activity.getApplicationContext();
        this.f = (ViewGroup) view;
        this.c = bVar;
        this.d = cVar;
        this.e = aRResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        if (this.l != null) {
            return;
        }
        this.c.h().getHostUI().closeFlash();
        ArBridge.getInstance().onPauseByUser();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.l = new ShareView(this.g);
        if (bitmap != null) {
            this.l.setShareBitmap(bitmap);
        } else {
            this.l.setVideoPath(Utils.getHideVideoUrl());
        }
        this.c.k().addView(this.l, layoutParams);
        this.l.setOnShareClickListener(new ShareView.b() { // from class: com.baidu.ar.ui.CaptureUI.3
            @Override // com.baidu.ar.ui.ShareView.b
            public void a() {
                CaptureUI.this.k();
            }

            @Override // com.baidu.ar.ui.ShareView.b
            public void a(String str, String str2, String str3, Bitmap bitmap2, String str4, String str5, boolean z, boolean z2, ShareResultListener shareResultListener, int i) {
                if (CaptureUI.this.c.a() != null) {
                    if (ARConfig.isBox()) {
                        CaptureUI.this.c.a().shareSyncForPlugin(CaptureUI.this.h, str, str2, str3, bitmap2, str4, str5, z, z2, shareResultListener);
                        StatisticHelper.getInstance().statisticInfo("share", StatisticConstants.HOST_PLATFORM_BOX);
                        return;
                    }
                    CaptureUI.this.c.a().share(str, str2, str3, str4, i);
                    StatisticHelper.getInstance().statisticInfo("share", StatisticConstants.HOST_PLATFORM_OPEN_SDK);
                }
            }
        });
        if (this.o != null) {
            this.o.a(true);
        }
        if (this.d != null) {
            this.d.v();
            this.d.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecordAction recordAction) {
        b(false);
        this.p.d();
        this.m = recordAction;
        if (this.m != RecordAction.NOTHING && !this.p.h()) {
            this.m = RecordAction.NOTHING;
        }
        if (this.m == RecordAction.GO_TO_SHARE_VIEW) {
            if (this.d.q != null && this.d.q.getARCaptureResultCallback() != null) {
                this.m = RecordAction.CUSTOM;
            }
            this.c.h().getHostUI().showLoadingView(Res.getString("bdar_record_completing"));
            ViewUtils.setViewEnabled(this.d.u.a(), false);
            ViewUtils.setViewEnabled(this.d.v.a(), false);
            ViewUtils.setViewEnabled(this.d.w.b(), false);
            ViewUtils.setViewEnabled(this.d.t.b(), false);
        } else if (this.m == RecordAction.NOTHING) {
            this.c.h().getHostUI().hideLoadingView();
            this.c.l().a(false);
            this.p.a(0);
            this.p.b(true);
            ViewUtils.setViewEnabled(this.d.t.b(), true);
        }
        this.c.i().stopRecord();
    }

    private void b(boolean z) {
        this.d.u.b(z);
        this.d.t.b(z);
        this.d.v.b(z);
        this.d.w.b(z);
        d(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(boolean z) {
        if (this.m == RecordAction.INITIAL_STATE) {
            return false;
        }
        if (this.m != RecordAction.GO_TO_SHARE_VIEW) {
            this.c.h().getHostUI().hideLoadingView();
            if (this.m == RecordAction.CUSTOM) {
                this.d.q.getARCaptureResultCallback().onVideoTaken(this.n);
                this.p.a(0);
                this.c.l().a(false);
                this.p.b(true);
            }
            this.m = RecordAction.INITIAL_STATE;
            return false;
        }
        this.m = RecordAction.INITIAL_STATE;
        if (Utils.checkHideVideoUrlValid()) {
            this.k = new a(this, z);
            this.k.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Utils.getHideVideoUrl(), 0L, 2);
            return true;
        }
        ToastCustom toastCustom = new ToastCustom(this.h);
        toastCustom.makeText(Res.getString("bdar_record_error"), 1);
        toastCustom.setGravity(2);
        toastCustom.show();
        return false;
    }

    private void d(boolean z) {
        this.r = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ViewUtils.setViewEnabled(this.d.t.b(), false);
        this.j = true;
        this.c.i().startRecord(Utils.getHideVideoUrl(), ErrDef.Feature.WEIGHT, this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.l != null) {
            this.l.c();
            this.l.d();
            this.c.k().removeView(this.l);
            this.l = null;
            if (this.d != null) {
                this.d.v();
            }
        }
        ArBridge.getInstance().onResumeByUser();
        if (this.o != null) {
            this.o.a(false);
        }
        this.c.l().a(false);
        if (this.p != null) {
            this.p.b(true);
        }
        ViewUtils.setViewEnabled(this.d.u.a(), true);
        if (!this.c.h().getActivity().getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            ViewUtils.setViewEnabled(this.d.v.a(), true);
        }
        ViewUtils.setViewEnabled(this.d.w.b(), true);
        ViewUtils.setViewEnabled(this.d.t.b(), true);
        if (this.d != null) {
            this.d.x();
        }
    }

    private void l() {
        if (ARConfig.isBox()) {
            n();
        } else if (this.e.isShowAudioDialog()) {
            m();
        } else {
            n();
        }
        SPUtils.setAudioDialogShown(this.c.h().getActivity());
    }

    private void m() {
        a.C0051a c0051a = new a.C0051a(this.c.h().getActivity());
        c0051a.a((CharSequence) Res.getString("bdar_audio_permission_dialog_title"));
        c0051a.a(SystemInfoUtil.getAppName(this.c.h().getActivity()) + Res.getString("bdar_audio_permission_dialog_context"));
        c0051a.a(Res.getString("bdar_ok"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.CaptureUI.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                CaptureUI.this.n();
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.AUDIO_DIALOG_YES);
            }
        });
        c0051a.b(Res.getString("bdar_cancel"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.CaptureUI.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                CaptureUI.this.j();
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.AUDIO_DIALOG_NO);
            }
        });
        com.baidu.ar.ui.a.a a2 = c0051a.a();
        a2.setCanceledOnTouchOutside(false);
        a2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.ar.ui.CaptureUI.6
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    dialogInterface.dismiss();
                    CaptureUI.this.j();
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.AUDIO_DIALOG_NO);
                    return true;
                }
                return false;
            }
        });
        UiUtils.showDialogSafely(a2);
        StatisticHelper.getInstance().statisticInfo(StatisticConstants.AUDIO_APP_DIALOG_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.c.h().getARPermissionManager().request("android.permission.RECORD_AUDIO", new PermissionAction() { // from class: com.baidu.ar.ui.CaptureUI.7
            @Override // com.baidu.ar.permissions.PermissionAction
            public void onDenied() {
                CaptureUI.this.j();
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.AUDIO_NO_PERMISSION);
            }

            @Override // com.baidu.ar.permissions.PermissionAction
            public void onGranted() {
                CaptureUI.this.j();
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.AUDIO_HAS_PERMISSION);
            }
        });
    }

    private void o() {
        if (this.p != null) {
            this.p.f();
        }
    }

    public void a() {
        this.p = new com.baidu.ar.ui.view.a(this.h, (RelativeLayout) this.f.findViewById(Res.id("bdar_capture_container")));
        this.p.a((a.InterfaceC0053a) this);
        Map<FunctionType, Boolean> functionMap = this.e != null ? this.e.getFunctionMap() : null;
        this.p.a(functionMap == null || !functionMap.containsKey(FunctionType.VIDEO) || functionMap.get(FunctionType.VIDEO).booleanValue());
        o();
    }

    public void a(Orientation orientation) {
        if (this.p != null) {
            this.p.a(orientation);
        }
        if (this.l != null) {
            this.l.a(orientation);
        }
    }

    public void a(p pVar) {
        this.o = pVar;
    }

    public void a(boolean z) {
        if (this.r) {
            return;
        }
        this.q = z;
        if (this.q) {
            i();
        } else {
            o();
        }
    }

    public void b() {
        this.a = true;
        if (this.l != null) {
            this.l.b();
        } else if (!c(true)) {
            ArBridge.getInstance().onResumeByUser();
        }
        if (this.p != null) {
            this.p.g();
        }
    }

    public void c() {
        this.a = false;
        if (this.l != null) {
            this.l.c();
        }
        if (this.j) {
            a(RecordAction.GO_TO_SHARE_VIEW);
            this.j = false;
        }
    }

    public void d() {
        if (this.k != null) {
            this.k.cancel(true);
            this.k.a();
            this.k = null;
        }
    }

    public boolean e() {
        if (this.d.g()) {
            if (this.l != null && this.l.isShown()) {
                k();
                return true;
            } else if (this.j) {
                this.c.l().a(false);
                a(RecordAction.NOTHING);
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.ar.ui.view.a.InterfaceC0053a
    public void f() {
        if (this.d.g() && !this.i) {
            this.i = true;
            this.p.a();
            this.c.l().a(true);
            this.c.i().takePicture(Utils.getHidePictureUrl(), this.s);
            StatisticHelper.getInstance().statisticInfo(StatisticConstants.ONCLICK_CAPTURE_SCREEN);
            ViewUtils.setViewEnabled(this.d.t.b(), false);
            ViewUtils.setViewEnabled(this.d.w.b(), false);
        }
    }

    @Override // com.baidu.ar.ui.view.a.InterfaceC0053a
    public void g() {
        if (this.j) {
            return;
        }
        this.p.a();
        this.c.l().a(true);
        b(true);
        FragmentActivity activity = this.c.h().getActivity();
        if (ARPermissionManager.hasAudioPermission(activity) || SPUtils.hasAudioDialogShown(activity)) {
            j();
        } else {
            l();
        }
    }

    @Override // com.baidu.ar.ui.view.a.InterfaceC0053a
    public void h() {
        a(RecordAction.GO_TO_SHARE_VIEW);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        if (this.p != null) {
            this.p.e();
        }
    }
}
