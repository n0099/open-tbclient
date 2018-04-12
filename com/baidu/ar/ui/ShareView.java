package com.baidu.ar.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ar.bean.ARConfiguration;
import com.baidu.ar.external.a.a.e;
import com.baidu.ar.i.a.a;
import com.baidu.ar.i.a.d;
import com.baidu.ar.ui.rotateview.Orientation;
import com.baidu.ar.ui.rotateview.RotateImageView;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.o;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShareView extends FrameLayout {
    boolean a;
    public int b;
    Activity c;
    private RotateViewGroup d;
    private FrameLayout e;
    private ImageView f;
    private RotateImageView g;
    private RotateImageView h;
    private RotateImageView i;
    private Timer j;
    private TimerTask k;
    private TextView l;
    private LoadingView m;
    private b n;
    private boolean o;
    private TextureVideoView p;
    private LinearLayout q;
    private RoundProgressBar r;
    private Button s;
    private ARConfiguration t;
    private d u;
    private c v;
    private String w;
    private com.baidu.ar.i.a.a x;
    private a y;
    private File z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0030a {
        ShareView a;

        a(ShareView shareView) {
            this.a = shareView;
        }

        @Override // com.baidu.ar.i.a.a.InterfaceC0030a
        public void a() {
            if (this.a != null) {
                this.a.n();
            }
        }

        @Override // com.baidu.ar.i.a.a.InterfaceC0030a
        public void b() {
            if (this.a != null) {
                this.a.o();
            }
        }

        public void c() {
            this.a = null;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void a(String str, String str2, String str3, Bitmap bitmap, String str4, String str5, boolean z, boolean z2, e eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c implements com.baidu.ar.i.a.c {
        ShareView a;

        c(ShareView shareView) {
            this.a = shareView;
        }

        @Override // com.baidu.ar.i.a.c
        public void a() {
            if (this.a != null) {
                this.a.k();
            }
        }

        @Override // com.baidu.ar.i.a.c
        public void a(int i) {
            if (this.a == null || this.a.b != 1) {
                return;
            }
            this.a.r.setProgress(i);
        }

        @Override // com.baidu.ar.i.a.c
        public void a(int i, String str) {
            if (this.a != null) {
                this.a.b(str);
            }
        }

        public void b() {
            this.a = null;
        }

        @Override // com.baidu.ar.i.a.c
        public void b(int i, String str) {
            if (this.a != null) {
                this.a.l();
            }
        }
    }

    public ShareView(Context context) {
        super(context);
        this.o = false;
        this.a = false;
        this.b = 0;
        this.c = (Activity) context;
        i();
    }

    public ShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = false;
        this.a = false;
        this.b = 0;
        this.c = (Activity) context;
        i();
    }

    public ShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = false;
        this.a = false;
        this.b = 0;
        this.c = (Activity) context;
        i();
    }

    public static void a(View view2) {
        Bitmap bitmap;
        if (view2 != null && (view2 instanceof ImageView)) {
            Drawable drawable = ((ImageView) view2).getDrawable();
            if (!(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            ((ImageView) view2).setImageBitmap(null);
            bitmap.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.l.setText(str);
        if (this.l.getVisibility() == 0) {
            return;
        }
        this.l.setVisibility(0);
        this.j = new Timer();
        this.k = new TimerTask() { // from class: com.baidu.ar.ui.ShareView.6
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ShareView.this.post(new Runnable() { // from class: com.baidu.ar.ui.ShareView.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ShareView.this.l.setVisibility(8);
                    }
                });
            }
        };
        this.j.schedule(this.k, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        e();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(ImagesInvalidReceiver.SUCCESS) || !jSONObject.optBoolean(ImagesInvalidReceiver.SUCCESS)) {
                l();
                return;
            }
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
            String optString = jSONObject2.optString("title");
            String optString2 = jSONObject2.optString("description");
            String concat = Constants.URL_TRACK_AR_PREFIX.concat(jSONObject2.optString(PbChosenActivityConfig.KEY_SHARE_URL));
            String optString3 = jSONObject2.optString("pic_url");
            if (this.n != null) {
                this.n.a(optString, optString2, concat, null, "", optString3, true, false, null);
            }
            this.w = str;
        } catch (Exception e) {
            if (Constants.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void i() {
        setClickable(true);
        this.w = null;
        this.o = false;
        Res.inflate("bdar_layout_share", this, true);
        this.l = (TextView) findViewById(Res.id("bdar_share_view_tip"));
        this.m = (LoadingView) findViewById(Res.id("bdar_share_loading"));
        this.d = (RotateViewGroup) findViewById(Res.id("bdar_gui_share_rotate_group"));
        this.e = (FrameLayout) findViewById(Res.id("bdar_gui_share_content_group"));
        this.e.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.ui.ShareView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f = (ImageView) findViewById(Res.id("bdar_gui_share_img"));
        this.g = (RotateImageView) findViewById(Res.id("bdar_gui_titlebar_share_back"));
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.ShareView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ShareView.this.n != null) {
                    ShareView.this.g.setEnabled(false);
                    ShareView.this.n.a();
                }
            }
        });
        this.h = (RotateImageView) findViewById(Res.id("bdar_gui_share_icon"));
        this.h.setEnabled(false);
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.ShareView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ShareView.this.l.isShown()) {
                    ShareView.this.l.setVisibility(8);
                    if (ShareView.this.j != null) {
                        ShareView.this.j.cancel();
                        ShareView.this.j.purge();
                        ShareView.this.j = null;
                    }
                    if (ShareView.this.k != null) {
                        ShareView.this.k.cancel();
                        ShareView.this.k = null;
                    }
                }
                if (!TextUtils.isEmpty(ShareView.this.w)) {
                    ShareView.this.b(ShareView.this.w);
                    return;
                }
                ShareView.this.h.setEnabled(false);
                ShareView.this.j();
            }
        });
        this.i = (RotateImageView) findViewById(Res.id("bdar_gui_titlebar_share_save"));
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.ShareView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!ShareView.this.o) {
                    if (ShareView.this.b != 2) {
                        if (ShareView.this.b == 1) {
                            ShareView.this.i.setEnabled(false);
                            if (ShareView.this.m != null) {
                                ShareView.this.m.setMsg(Res.getString("bdar_video_saving"));
                                ShareView.this.m.show();
                            }
                            ShareView.this.m();
                            return;
                        }
                        return;
                    }
                    Drawable drawable = ShareView.this.f.getDrawable();
                    if (drawable == null || !(drawable instanceof BitmapDrawable)) {
                        return;
                    }
                    ShareView.this.z = o.a(((BitmapDrawable) drawable).getBitmap());
                    ShareView.this.o = true;
                    ShareView.this.a(Res.getString("bdar_save_finish"));
                } else if (ShareView.this.b == 2) {
                    if (ShareView.this.z != null && ShareView.this.z.exists()) {
                        ShareView.this.a(Res.getString("bdar_save_finish"));
                        return;
                    }
                    Drawable drawable2 = ShareView.this.f.getDrawable();
                    if (drawable2 == null || !(drawable2 instanceof BitmapDrawable)) {
                        ShareView.this.o = false;
                        ShareView.this.z = null;
                        ShareView.this.a(Res.getString("bdar_save_fail"));
                        return;
                    }
                    ShareView.this.z = o.a(((BitmapDrawable) drawable2).getBitmap());
                    ShareView.this.o = true;
                    ShareView.this.a(Res.getString("bdar_save_finish"));
                } else if (ShareView.this.b == 1) {
                    File file = new File(o.e());
                    if (!file.exists() || !file.isFile()) {
                        ShareView.this.z = null;
                        ShareView.this.a(Res.getString("bdar_save_fail"));
                    } else if (ShareView.this.z != null && ShareView.this.z.exists()) {
                        ShareView.this.a(Res.getString("bdar_save_finish"));
                    } else {
                        ShareView.this.i.setEnabled(false);
                        if (ShareView.this.m != null) {
                            ShareView.this.m.setMsg(Res.getString("bdar_video_saving"));
                            ShareView.this.m.show();
                        }
                        ShareView.this.m();
                    }
                }
            }
        });
        this.p = (TextureVideoView) findViewById(Res.id("bdar_gui_share_video"));
        this.q = (LinearLayout) findViewById(Res.id("bdar_video_upload_loading_group"));
        this.r = (RoundProgressBar) this.q.findViewById(Res.id("bdar_video_upload_progress"));
        this.r.setTextSize(o.a(getContext(), 18.0f));
        this.r.setRoundWidth(o.a(getContext(), 3.3f));
        this.r.setCricleColor(0);
        this.r.setCricleProgressColor(Color.parseColor("#b20073ff"));
        this.s = (Button) this.q.findViewById(Res.id("bdar_video_upload_cancel"));
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.ShareView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ShareView.this.e();
                if (ShareView.this.u != null) {
                    ShareView.this.u.cancel(true);
                }
                if (ShareView.this.v != null) {
                    ShareView.this.v.b();
                    ShareView.this.v = null;
                }
            }
        });
        switch (o.a()) {
            case -90:
                g();
                return;
            case 0:
                f();
                return;
            case 90:
                h();
                return;
            default:
                f();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        String str;
        String str2 = null;
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.AR_KEY, this.t.getARKey());
        hashMap.put(Constants.AR_PUBLISH_ID, ARConfiguration.getPublishID());
        hashMap.put("sign", ARConfiguration.getSignature());
        hashMap.put("timestamp", ARConfiguration.getTimestamp() + "");
        String str3 = Constants.URL_TRACK_AR_PREFIX + Constants.URL_AR_QUERY_SERVICE + Constants.URL_TRACK_AR_SHARE;
        String c2 = o.c();
        if (this.b == 2) {
            str = "img";
            c2 = o.c();
        } else if (this.b == 1) {
            str = "video";
            c2 = o.e();
            str2 = o.c();
        } else {
            str = null;
        }
        this.v = new c(this);
        this.u = new d(c2, str2, str3, hashMap, str, this.v);
        this.u.execute(str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.b == 2) {
            this.m.setVisibility(0);
        } else if (this.b == 1) {
            this.q.setVisibility(0);
            this.r.setProgress(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.w = null;
        e();
        com.baidu.ar.ui.c a2 = com.baidu.ar.ui.c.a(this.c, this.c, Res.getString("bdar_upload_error"), 0);
        a2.b(2);
        a2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.y == null) {
            this.y = new a(this);
        }
        if (this.x == null) {
            this.x = new com.baidu.ar.i.a.a(this.y);
        }
        String d = o.d();
        this.z = new File(d);
        this.x.execute(o.e(), d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        o.a(getContext(), this.z);
        if (this.m != null) {
            this.m.dismiss();
        }
        this.i.setEnabled(true);
        this.o = true;
        a(Res.getString("bdar_save_finish"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.m != null) {
            this.m.dismiss();
        }
        this.i.setEnabled(true);
        this.o = false;
        this.z = null;
        a(Res.getString("bdar_save_fail"));
    }

    public void a() {
        if (this.h != null) {
            this.h.setEnabled(true);
        }
    }

    public void b() {
        if (this.p != null && this.p.getVisibility() == 0) {
            this.p.a();
        }
        a();
        if (this.i != null) {
            this.i.setEnabled(true);
        }
    }

    public void c() {
        if (this.u != null) {
            this.u.cancel(true);
            this.u = null;
        }
        if (this.v != null) {
            this.v.b();
            this.v = null;
        }
        if (this.l != null) {
            this.l.setVisibility(8);
        }
        if (this.j != null) {
            this.j.cancel();
            this.j.purge();
            this.j = null;
        }
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        if (this.p != null && this.p.getVisibility() == 0) {
            this.p.c();
        }
        if (this.x != null) {
            this.x.cancel(true);
            this.x = null;
        }
        if (this.y != null) {
            this.y.c();
            this.y = null;
        }
        e();
    }

    public void d() {
        this.o = false;
        this.w = null;
        if (this.f != null) {
            a(this.f);
        }
        String c2 = o.c();
        if (!TextUtils.isEmpty(c2)) {
            File file = new File(c2);
            if (file.exists()) {
                file.delete();
            }
        }
        if (this.p != null) {
            this.p.e();
        }
        e();
        this.z = null;
    }

    public void e() {
        this.m.setVisibility(8);
        this.q.setVisibility(8);
        this.h.setEnabled(true);
    }

    public void f() {
        com.baidu.ar.c.a(this.g, Orientation.PORTRAIT, true);
        com.baidu.ar.c.a(this.i, Orientation.PORTRAIT, true);
        com.baidu.ar.c.a(this.h, Orientation.PORTRAIT, true);
        if (this.d != null) {
            this.d.setAngle(0);
            if (this.a) {
                this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    public void g() {
        com.baidu.ar.c.a(this.g, Orientation.LANDSCAPE, true);
        com.baidu.ar.c.a(this.i, Orientation.LANDSCAPE, true);
        com.baidu.ar.c.a(this.h, Orientation.LANDSCAPE, true);
        if (this.d != null) {
            this.d.setAngle(-90);
            if (this.a) {
                this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
    }

    public void h() {
        com.baidu.ar.c.a(this.g, Orientation.LANDSCAPE_REVERSE, true);
        com.baidu.ar.c.a(this.i, Orientation.LANDSCAPE_REVERSE, true);
        com.baidu.ar.c.a(this.h, Orientation.LANDSCAPE_REVERSE, true);
        if (this.d != null) {
            this.d.setAngle(90);
            if (this.a) {
                this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
    }

    public void setARConfig(ARConfiguration aRConfiguration) {
        this.t = aRConfiguration;
    }

    public void setOnShareClickListener(b bVar) {
        this.n = bVar;
    }

    public void setSaveFinished(boolean z) {
        this.o = z;
    }

    public void setShareBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.b = 2;
            this.h.setEnabled(true);
            this.f.setImageBitmap(bitmap);
            this.f.setVisibility(0);
            this.a = bitmap.getWidth() > bitmap.getHeight();
            if (o.a() == 90 || o.a() == -90) {
                if (this.a) {
                    this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
            } else if (this.a) {
                this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    public void setVideoPath(String str) {
        if (this.p != null) {
            this.b = 1;
            this.p.setVisibility(0);
            com.baidu.ar.util.b.d("bdar: play video!");
            this.p.setVideoPath(str);
            this.p.b();
        }
    }
}
