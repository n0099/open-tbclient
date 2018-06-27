package com.baidu.ar.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.external.ShareResultListener;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.task.CopyFileTask;
import com.baidu.ar.task.OnFileUploadListener;
import com.baidu.ar.task.UploadFileTask;
import com.baidu.ar.ui.a.a;
import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.ui.rotateview.RotateViewUtils;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.NetworkUtil;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.UiUtils;
import com.baidu.ar.util.UrlUtils;
import com.baidu.ar.util.Utils;
import com.baidu.ar.utils.AppUtils;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShareView extends FrameLayout {
    private static long d = 300;
    private Dialog A;
    private ImageView B;
    private int C;
    private d D;
    private ToastCustom E;
    boolean a;
    public int b;
    Activity c;
    private long e;
    private RotateViewGroup f;
    private ImageView g;
    private RotateImageView h;
    private RotateImageView i;
    private RotateImageView j;
    private Timer k;
    private TimerTask l;
    private TextView m;
    private LoadingView n;
    private b o;
    private boolean p;
    private TextureVideoView q;
    private LinearLayout r;
    private RoundProgressBar s;
    private Button t;
    private UploadFileTask u;
    private c v;
    private String w;
    private CopyFileTask x;
    private a y;
    private File z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements CopyFileTask.OnCopyFileListener {
        ShareView a;

        a(ShareView shareView) {
            this.a = shareView;
        }

        public void a() {
            this.a = null;
        }

        @Override // com.baidu.ar.task.CopyFileTask.OnCopyFileListener
        public void onFail() {
            if (this.a != null) {
                this.a.p();
            }
        }

        @Override // com.baidu.ar.task.CopyFileTask.OnCopyFileListener
        public void onSuccess() {
            if (this.a != null) {
                this.a.o();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void a(String str, String str2, String str3, Bitmap bitmap, String str4, String str5, boolean z, boolean z2, ShareResultListener shareResultListener, int i);
    }

    /* loaded from: classes3.dex */
    private static class c implements OnFileUploadListener {
        ShareView a;

        c(ShareView shareView) {
            this.a = shareView;
        }

        public void a() {
            this.a = null;
        }

        @Override // com.baidu.ar.task.OnFileUploadListener
        public void onFailure(int i, String str) {
            if (this.a != null) {
                this.a.m();
            }
        }

        @Override // com.baidu.ar.task.OnFileUploadListener
        public void onProgressUpdate(int i) {
            if (this.a == null || this.a.b != 1) {
                return;
            }
            this.a.s.setProgress(i);
        }

        @Override // com.baidu.ar.task.OnFileUploadListener
        public void onStartUpload() {
            if (this.a != null) {
                this.a.l();
            }
        }

        @Override // com.baidu.ar.task.OnFileUploadListener
        public void onSuccess(int i, String str) {
            if (this.a != null) {
                this.a.b(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class d implements MediaPlayer.OnPreparedListener {
        ShareView a;

        d(ShareView shareView) {
            this.a = shareView;
        }

        public void a() {
            this.a = null;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                if (this.a != null) {
                    final ImageView imageView = this.a.B;
                    imageView.postDelayed(new Runnable() { // from class: com.baidu.ar.ui.ShareView.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap;
                            Drawable drawable = imageView.getDrawable();
                            imageView.setImageBitmap(null);
                            if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            imageView.setVisibility(8);
                        }
                    }, 500L);
                }
                StatisticHelper.getInstance().statisticInfo(StatisticConstants.ONCLICK_CAPTURE_VIDEO_DURATION, String.valueOf(mediaPlayer.getDuration()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ShareView(Context context) {
        super(context);
        this.e = 0L;
        this.p = false;
        this.a = false;
        this.b = 0;
        this.C = 0;
        a(context);
    }

    public ShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0L;
        this.p = false;
        this.a = false;
        this.b = 0;
        this.C = 0;
        a(context);
    }

    public ShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0L;
        this.p = false;
        this.a = false;
        this.b = 0;
        this.C = 0;
        a(context);
    }

    private void a(Context context) {
        if (context instanceof Activity) {
            this.c = (Activity) context;
        }
        setClickable(true);
        this.w = null;
        this.p = false;
        Res.inflate("bdar_layout_share", this, true);
        this.m = (TextView) findViewById(Res.id("bdar_share_view_tip"));
        this.n = (LoadingView) findViewById(Res.id("bdar_share_loading"));
        this.f = (RotateViewGroup) findViewById(Res.id("bdar_gui_share_rotate_group"));
        ((FrameLayout) findViewById(Res.id("bdar_gui_share_content_group"))).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.ui.ShareView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.g = (ImageView) findViewById(Res.id("bdar_gui_share_img"));
        this.h = (RotateImageView) findViewById(Res.id("bdar_gui_titlebar_share_back"));
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.ShareView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ShareView.this.o != null) {
                    ShareView.this.h.setEnabled(false);
                    ShareView.this.o.a();
                }
            }
        });
        this.i = (RotateImageView) findViewById(Res.id("bdar_gui_share_icon"));
        this.i.setEnabled(false);
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.ShareView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NetworkUtil.isNetworkConnected(ShareView.this.getContext())) {
                    ShareView.this.a(Res.getString("bdar_dialog_network_prompt_title"));
                    return;
                }
                if (ShareView.this.b == 2) {
                    StatisticHelper.getInstance().statisticInfo("share");
                } else if (ShareView.this.b == 1) {
                    StatisticHelper.getInstance().statisticInfo(StatisticConstants.ONCLICK_CAPTURE_VIDEO_SHARE);
                }
                if (ShareView.this.m.isShown()) {
                    ShareView.this.m.setVisibility(8);
                    ShareView.this.q();
                }
                if (!TextUtils.isEmpty(ShareView.this.w)) {
                    ShareView.this.b(ShareView.this.w);
                    return;
                }
                ShareView.this.i.setEnabled(false);
                ShareView.this.k();
            }
        });
        this.j = (RotateImageView) findViewById(Res.id("bdar_gui_titlebar_share_save"));
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.ShareView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ShareView.this.g()) {
                    if (!ShareView.this.p) {
                        if (ShareView.this.b == 2) {
                            Drawable drawable = ShareView.this.g.getDrawable();
                            if (drawable == null || !(drawable instanceof BitmapDrawable)) {
                                return;
                            }
                            ShareView.this.z = Utils.saveBitmap(((BitmapDrawable) drawable).getBitmap());
                            Utils.broadcastMediaAdded(ShareView.this.getContext(), ShareView.this.z);
                            ShareView.this.p = true;
                            ShareView.this.a(Res.getString("bdar_save_finish"));
                            StatisticHelper.getInstance().statisticInfo(StatisticConstants.ONCLICK_CAPTURE_SCREEN_SAVE);
                        } else if (ShareView.this.b == 1) {
                            ShareView.this.j.setEnabled(false);
                            if (!Utils.checkSDCardSizeAvailable(200)) {
                                ShareView.this.a(Res.getString("bdar_storage_space_is_almost_full"), Res.getString("bdar_manage_storage"));
                                return;
                            }
                            if (ShareView.this.n != null) {
                                ShareView.this.n.setMsg(Res.getString("bdar_video_saving"));
                                ShareView.this.n.show();
                            }
                            StatisticHelper.getInstance().statisticInfo(StatisticConstants.ONCLICK_CAPTURE_VIDEO_SAVE);
                            ShareView.this.n();
                        }
                    } else if (ShareView.this.b == 2) {
                        if (ShareView.this.z != null && ShareView.this.z.exists()) {
                            ShareView.this.a(Res.getString("bdar_save_finish"));
                            return;
                        }
                        Drawable drawable2 = ShareView.this.g.getDrawable();
                        if (drawable2 == null || !(drawable2 instanceof BitmapDrawable)) {
                            ShareView.this.p = false;
                            ShareView.this.z = null;
                            ShareView.this.a(Res.getString("bdar_save_fail"));
                            return;
                        }
                        StatisticHelper.getInstance().statisticInfo(StatisticConstants.ONCLICK_CAPTURE_SCREEN_SAVE);
                        ShareView.this.z = Utils.saveBitmap(((BitmapDrawable) drawable2).getBitmap());
                        Utils.broadcastMediaAdded(ShareView.this.getContext(), ShareView.this.z);
                        ShareView.this.p = true;
                        ShareView.this.a(Res.getString("bdar_save_finish"));
                    } else if (ShareView.this.b == 1) {
                        File file = new File(Utils.getHideVideoUrl());
                        if (!file.exists() || !file.isFile()) {
                            ShareView.this.z = null;
                            ShareView.this.a(Res.getString("bdar_save_fail"));
                        } else if (ShareView.this.z != null && ShareView.this.z.exists()) {
                            ShareView.this.a(Res.getString("bdar_save_finish"));
                        } else {
                            ShareView.this.j.setEnabled(false);
                            if (!Utils.checkSDCardSizeAvailable(200)) {
                                ShareView.this.a(Res.getString("bdar_storage_space_is_almost_full"), Res.getString("bdar_manage_storage"));
                                return;
                            }
                            if (ShareView.this.n != null) {
                                ShareView.this.n.setMsg(Res.getString("bdar_video_saving"));
                                ShareView.this.n.show();
                            }
                            StatisticHelper.getInstance().statisticInfo(StatisticConstants.ONCLICK_CAPTURE_VIDEO_SAVE);
                            ShareView.this.n();
                        }
                    }
                }
            }
        });
        this.q = (TextureVideoView) findViewById(Res.id("bdar_gui_share_video"));
        this.D = new d(this);
        this.q.setOnPreparedListener(this.D);
        this.B = (ImageView) findViewById(Res.id("bdar_gui_share_video_mask"));
        this.r = (LinearLayout) findViewById(Res.id("bdar_video_upload_loading_group"));
        this.s = (RoundProgressBar) this.r.findViewById(Res.id("bdar_video_upload_progress"));
        this.s.setTextSize(Utils.dipToPx(getContext(), 18.0f));
        this.s.setRoundWidth(Utils.dipToPx(getContext(), 3.3f));
        this.s.setCricleColor(0);
        this.s.setCricleProgressColor(Color.parseColor("#b20073ff"));
        this.t = (Button) this.r.findViewById(Res.id("bdar_video_upload_cancel"));
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.ShareView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShareView.this.e();
                if (ShareView.this.u != null) {
                    ShareView.this.u.cancel(true);
                }
                if (ShareView.this.v != null) {
                    ShareView.this.v.a();
                    ShareView.this.v = null;
                }
            }
        });
        a(OrientationManager.getGlobalOrientation());
    }

    public static void a(View view) {
        Bitmap bitmap;
        if (view != null && (view instanceof ImageView)) {
            Drawable drawable = ((ImageView) view).getDrawable();
            if (!(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            ((ImageView) view).setImageBitmap(null);
            bitmap.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.m.setText(str);
        if (this.m.getVisibility() == 0) {
            return;
        }
        this.m.setVisibility(0);
        this.k = new Timer();
        this.l = new TimerTask() { // from class: com.baidu.ar.ui.ShareView.7
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.ShareView.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ShareView.this.m.setVisibility(8);
                    }
                });
            }
        };
        this.k.schedule(this.l, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        a.C0048a c0048a = new a.C0048a(this.c);
        c0048a.a((CharSequence) str);
        c0048a.a(str2);
        c0048a.a(Res.getString("bdar_go_setting"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.ShareView.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AppUtils.openDetailSettings(ShareView.this.c);
            }
        });
        c0048a.b(Res.getString("bdar_cancel"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.ShareView.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ShareView.this.f();
                ShareView.this.j.setEnabled(true);
            }
        });
        this.A = c0048a.a();
        this.A.setCanceledOnTouchOutside(false);
        this.A.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.ar.ui.ShareView.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    dialogInterface.dismiss();
                    ShareView.this.j.setEnabled(true);
                    return true;
                }
                return false;
            }
        });
        UiUtils.showDialogSafely(this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        e();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (ARConfig.isAipAuth()) {
                JSONObject jSONObject2 = new JSONObject(str);
                if (jSONObject2.has("data")) {
                    jSONObject = new JSONObject(jSONObject2.getString("data"));
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            if (!jSONObject.has("success") || !jSONObject.optBoolean("success")) {
                m();
                return;
            }
            JSONObject jSONObject3 = new JSONObject(jSONObject.optString("data"));
            String optString = jSONObject3.optString("title");
            String optString2 = jSONObject3.optString(SocialConstants.PARAM_COMMENT);
            String concat = UrlUtils.URL_AR_PREFIX.concat(jSONObject3.optString(PbChosenActivityConfig.KEY_SHARE_URL));
            String optString3 = jSONObject3.optString("pic_url");
            String optString4 = jSONObject3.optString("thumbnail");
            if (this.o != null) {
                this.o.a(optString, optString2, concat, null, optString3, optString4, true, false, null, this.b);
            }
            this.w = str;
        } catch (Exception e) {
            ARLog.e("share error");
            if (Constants.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void h() {
        if (this.f != null) {
            if (this.a) {
                this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
        setMaskScaleType(-this.C);
    }

    private void i() {
        if (this.f != null) {
            if (this.a) {
                this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
        setMaskScaleType((-90) - this.C);
    }

    private void j() {
        if (this.f != null) {
            if (this.a) {
                this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
        setMaskScaleType(90 - this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.ShareView.8
            @Override // java.lang.Runnable
            public void run() {
                String str;
                String shareUrl = UrlUtils.getShareUrl();
                HashMap hashMap = new HashMap();
                hashMap.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
                hashMap.put(HttpConstants.IS_AIP, ARConfig.getIsAip());
                hashMap.put("ar_key", ARConfig.getARKey());
                hashMap.put("sign", ARConfig.getSignature());
                hashMap.put(HttpConstants.TIMESTAMP, String.valueOf(ARConfig.getTimestamp()));
                String hidePictureUrl = Utils.getHidePictureUrl();
                if (ShareView.this.b == 2) {
                    str = SocialConstants.PARAM_IMG_URL;
                    hidePictureUrl = Utils.getHidePictureUrl();
                } else if (ShareView.this.b == 1) {
                    str = "video";
                    hidePictureUrl = Utils.getHideVideoUrl();
                } else {
                    str = null;
                }
                ShareView.this.v = new c(ShareView.this);
                ShareView.this.u = new UploadFileTask(hidePictureUrl, null, shareUrl, hashMap, str, ShareView.this.v);
                ShareView.this.u.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, shareUrl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.b == 2) {
            this.n.setVisibility(0);
        } else if (this.b == 1) {
            this.r.setVisibility(0);
            this.s.setProgress(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.w = null;
        e();
        this.E = new ToastCustom(this.c.getApplicationContext());
        this.E.makeText(Res.getString("bdar_upload_error"), 0);
        this.E.requestOrientation(OrientationManager.getGlobalOrientation());
        this.E.setGravity(2);
        this.E.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.y == null) {
            this.y = new a(this);
        }
        if (this.x == null) {
            this.x = new CopyFileTask(this.y);
        }
        String generateVideoName = Utils.generateVideoName();
        this.z = new File(generateVideoName);
        this.x.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Utils.getHideVideoUrl(), generateVideoName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Utils.broadcastMediaAdded(getContext(), this.z);
        if (this.n != null) {
            this.n.dismiss();
        }
        this.j.setEnabled(true);
        this.p = true;
        a(Res.getString("bdar_save_finish"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.n != null) {
            this.n.dismiss();
        }
        this.j.setEnabled(true);
        this.p = false;
        this.z = null;
        a(Res.getString("bdar_save_fail"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.k != null) {
            this.k.cancel();
            this.k.purge();
            this.k = null;
        }
        if (this.l != null) {
            this.l.cancel();
            this.l = null;
        }
    }

    private void setMaskScaleType(int i) {
        if (this.B == null || this.B.getVisibility() != 0) {
            return;
        }
        if (Math.abs(i / 90) % 2 == 1) {
            this.B.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.B.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void a() {
        if (this.i != null) {
            this.i.setEnabled(true);
        }
    }

    public void a(Orientation orientation) {
        RotateViewUtils.requestOrientation(this.h, orientation, true);
        RotateViewUtils.requestOrientation(this.j, orientation, true);
        RotateViewUtils.requestOrientation(this.i, orientation, true);
        if (this.E != null) {
            this.E.requestOrientation(orientation);
        }
        if (orientation == Orientation.PORTRAIT) {
            h();
        } else if (orientation == Orientation.LANDSCAPE) {
            j();
        } else if (orientation == Orientation.LANDSCAPE_REVERSE) {
            i();
        }
        b(orientation);
    }

    public void b() {
        if (this.q != null && this.q.getVisibility() == 0) {
            this.q.a();
        }
        a();
        if (this.j != null) {
            this.j.setEnabled(true);
        }
    }

    public void b(Orientation orientation) {
        if (!SystemInfoUtil.isScreenOrientationLandscape(this.c)) {
            RotateViewUtils.requestOrientation(this.f, orientation);
        } else if (orientation == Orientation.PORTRAIT) {
            RotateViewUtils.requestOrientation(this.f, Orientation.LANDSCAPE);
        } else if (orientation == Orientation.LANDSCAPE) {
            this.f.setAngle(SubsamplingScaleImageView.ORIENTATION_180);
        } else if (orientation == Orientation.LANDSCAPE_REVERSE) {
            if (this.a) {
                this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            this.f.setAngle(0);
        } else if (orientation != Orientation.PORTRAIT_REVERSE) {
            RotateViewUtils.requestOrientation(this.f, Orientation.LANDSCAPE);
        } else {
            if (this.a) {
                this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            this.f.setAngle(90);
        }
    }

    public void c() {
        if (this.u != null) {
            this.u.cancel(true);
            this.u = null;
        }
        if (this.v != null) {
            this.v.a();
            this.v = null;
        }
        if (this.m != null) {
            this.m.setVisibility(8);
        }
        q();
        if (this.q != null && this.q.getVisibility() == 0) {
            this.q.c();
        }
        if (this.x != null) {
            this.x.cancel(true);
            this.x = null;
        }
        if (this.y != null) {
            this.y.a();
            this.y = null;
        }
        e();
    }

    public void d() {
        this.p = false;
        this.w = null;
        if (this.g != null) {
            a(this.g);
        }
        String hidePictureUrl = Utils.getHidePictureUrl();
        if (!TextUtils.isEmpty(hidePictureUrl)) {
            File file = new File(hidePictureUrl);
            if (file.exists()) {
                file.delete();
            }
        }
        if (this.q != null) {
            this.q.e();
        }
        e();
        this.z = null;
        if (this.o != null) {
            this.o = null;
        }
        q();
        if (this.D != null) {
            this.D.a();
        }
    }

    public void e() {
        this.n.setVisibility(8);
        this.r.setVisibility(8);
        this.i.setEnabled(true);
    }

    protected void f() {
        if (this.A == null || !this.A.isShowing()) {
            return;
        }
        this.A.dismiss();
        this.A = null;
    }

    protected boolean g() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.e < d) {
            return false;
        }
        this.e = currentTimeMillis;
        return true;
    }

    public void setOnShareClickListener(b bVar) {
        this.o = bVar;
    }

    public void setSaveFinished(boolean z) {
        this.p = z;
    }

    public void setShareBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.b = 2;
            this.i.setEnabled(true);
            this.g.setImageBitmap(bitmap);
            this.g.setVisibility(0);
            this.a = bitmap.getWidth() > bitmap.getHeight();
            if (OrientationManager.getGlobalOrientation() == Orientation.LANDSCAPE || OrientationManager.getGlobalOrientation() == Orientation.LANDSCAPE_REVERSE) {
                if (this.a) {
                    this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
            } else if (this.a) {
                this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
        b(OrientationManager.getGlobalOrientation());
    }

    public void setVideoMask(Bitmap bitmap) {
        if (this.B == null || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.B.setImageBitmap(bitmap);
        this.B.setVisibility(0);
        this.C = OrientationManager.getGlobalOrientation().getDegree();
        setMaskScaleType(0);
    }

    public void setVideoPath(String str) {
        if (this.q != null) {
            this.b = 1;
            this.q.setVisibility(0);
            ARLog.d("bdar: play video!");
            this.q.setVideoPath(str);
            this.q.b();
        }
    }
}
