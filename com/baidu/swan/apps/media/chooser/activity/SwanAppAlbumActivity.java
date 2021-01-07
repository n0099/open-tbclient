package com.baidu.swan.apps.media.chooser.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.media.chooser.adapter.b;
import com.baidu.swan.apps.media.chooser.b.d;
import com.baidu.swan.apps.media.chooser.listener.e;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.view.HeightListView;
import com.baidu.swan.apps.view.LoadingLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private ActivityResultDispatcher cEm;
    private GridView dlY;
    private com.baidu.swan.apps.media.chooser.adapter.a dlZ;
    private TextView dma;
    private TextView dmb;
    private TextView dmc;
    private RelativeLayout dmd;
    private TextView dme;
    private View dmf;
    private View dmg;
    private HeightListView dmh;
    private LoadingLayout dmi;
    private boolean dmj = false;
    private boolean dmk = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> dml = new ArrayList<>();
    private AdapterView.OnItemClickListener dmm = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.dmj && !SwanAppAlbumActivity.this.dmk) {
                SwanAppAlbumActivity.this.aEv();
            }
            SwanAppAlbumActivity.this.dma.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.dml.get(i)).il());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.dml.get(i)).dnT;
            SwanAppAlbumActivity.this.dlZ.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.dmd.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.dmd.setVisibility(0);
            }
        }
    };
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.cEm = new ActivityResultDispatcher(this, 1);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ah.T(this);
        aEr();
        initView();
        initData();
    }

    private void aEr() {
        if (getIntent() != null) {
            Bundle b2 = u.b(getIntent(), "launchParams");
            d.dhe = u.h(b2, "launchType");
            d.dnI = u.c(b2, "isShowCamera", true);
            d.mIsFrontCamera = u.c(b2, "isFrontCamera", false);
            d.dnH = u.a(b2, "maxDuration", 60);
            d.dnF = u.a(b2, "count", 9);
            String h = u.h(b2, UbcStatConstant.KEY_CONTENT_EXT_MODE);
            d.dlQ = u.c(b2, "compressed", true);
            d.dnG = u.h(b2, "swanAppId");
            if (!TextUtils.isEmpty(h)) {
                d.mMode = h;
            }
            d.dnJ = u.h(b2, "swanTmpPath");
            if (d.dnF < 1 || d.dnF > 9) {
                d.dnF = 9;
            }
        }
    }

    private void initView() {
        this.dlY = (GridView) findViewById(a.f.album_gridview);
        this.dma = (TextView) findViewById(a.f.album_name);
        this.dmb = (TextView) findViewById(a.f.album_select_done);
        this.dmc = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.dmd = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.dmf = findViewById(a.f.album_name_list_layout);
        this.dmg = findViewById(a.f.album_name_list_container);
        this.dmh = (HeightListView) findViewById(a.f.album_name_list);
        this.dmi = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.dme = (TextView) findViewById(a.f.album_left_cancel);
        this.dmh.setListViewHeight(ah.dip2px(this, 400.0f));
        this.dma.setOnClickListener(this);
        this.dme.setOnClickListener(this);
        this.dmb.setOnClickListener(this);
        this.dmc.setOnClickListener(this);
        this.dmf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.dmj && !SwanAppAlbumActivity.this.dmk) {
                    SwanAppAlbumActivity.this.aEv();
                    return true;
                }
                return true;
            }
        });
        this.dmd.setVisibility(0);
        this.dma.setText(d.ak(this, d.dhe));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.dmi.hI(true);
        p.b(new com.baidu.swan.apps.media.chooser.c.a(d.dhe, this.mHandler), "loadAlbumTask");
    }

    private void aEs() {
        this.dlZ = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.dlY.setAdapter((ListAdapter) this.dlZ);
        this.dlZ.setData(this.dml.get(0).dnT);
        this.dlZ.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.listener.e
            public void jz(int i) {
                SwanAppAlbumActivity.this.aEu();
            }
        });
    }

    private void aEt() {
        this.dmh.setAdapter((ListAdapter) new b(this, d.dhe, this.dml));
        this.dmh.setOnItemClickListener(this.dmm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.dmi.hI(false);
        this.dml = (ArrayList) obj;
        if (this.dml.size() > 0 && this.dml.get(0) != null) {
            if (this.dml.get(0).aEM() == null || this.dml.get(0).aEM().size() == 0) {
                this.dmd.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.dma.setCompoundDrawables(null, null, drawable, null);
            this.dma.setCompoundDrawablePadding(ah.dip2px(this, 4.0f));
        } else {
            this.dmd.setVisibility(8);
        }
        this.dmb.setVisibility(0);
        aEu();
        aEt();
        aEs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEu() {
        if (com.baidu.swan.apps.media.chooser.b.e.aEQ() > 0) {
            this.dmb.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.dmc.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.dmb.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.aEQ())));
            return;
        }
        this.dmb.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.dmc.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.dmb.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dma) {
            if (this.dml != null && this.dml.size() > 1 && !this.dmk) {
                if (this.dmj) {
                    aEv();
                } else {
                    aEw();
                }
            }
        } else if (view == this.dmb) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.dlQ);
            bundle.putString("swanAppId", d.dnG);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aEP());
            bundle.putString("swanTmpPath", d.dnJ);
            d.c(this, bundle);
        } else if (view == this.dme) {
            finish();
        } else if (view == this.dmc && com.baidu.swan.apps.media.chooser.b.e.aEQ() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEv() {
        if (this.dmj) {
            this.dmk = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0372a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.dmg.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.dmj = false;
                    SwanAppAlbumActivity.this.dmk = false;
                    SwanAppAlbumActivity.this.dmf.setVisibility(8);
                    SwanAppAlbumActivity.this.dmg.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.dma.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void aEw() {
        if (!this.dmj) {
            this.dmf.setVisibility(0);
            this.dmg.setVisibility(0);
            this.dmk = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0372a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.dmg.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.dmj = true;
                    SwanAppAlbumActivity.this.dmk = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.dma.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.cEm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.dlZ != null) {
                        this.dlZ.notifyDataSetChanged();
                    }
                    aEu();
                    return;
                }
                setResult(-1, intent);
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mHandler != null) {
            this.mHandler.removeMessages(0);
            this.mHandler = null;
        }
        com.baidu.swan.apps.media.chooser.b.e.clear();
        d.clear();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, a.C0372a.swanapp_album_slide_bottom_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a extends Handler {
        private WeakReference<SwanAppAlbumActivity> mActivityReference;

        a(SwanAppAlbumActivity swanAppAlbumActivity) {
            this.mActivityReference = new WeakReference<>(swanAppAlbumActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            SwanAppAlbumActivity swanAppAlbumActivity = this.mActivityReference.get();
            if (swanAppAlbumActivity != null && !swanAppAlbumActivity.isFinishing() && message.what == 0) {
                c.d("SwanAppAlbumActivity", "LoadAlbumTask finished");
                if (message.obj instanceof ArrayList) {
                    swanAppAlbumActivity.notifyUi(message.obj);
                }
            }
        }
    }
}
