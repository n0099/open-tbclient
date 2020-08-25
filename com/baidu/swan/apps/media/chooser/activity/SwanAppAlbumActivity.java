package com.baidu.swan.apps.media.chooser.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
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
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.media.chooser.adapter.b;
import com.baidu.swan.apps.media.chooser.b.d;
import com.baidu.swan.apps.media.chooser.c.e;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.view.HeightListView;
import com.baidu.swan.apps.view.LoadingLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private ActivityResultDispatcher bRz;
    private GridView czo;
    private com.baidu.swan.apps.media.chooser.adapter.a czp;
    private TextView czq;
    private TextView czr;
    private TextView czs;
    private RelativeLayout czt;
    private TextView czu;
    private View czv;
    private View czw;
    private HeightListView czx;
    private LoadingLayout czy;
    private Handler mHandler;
    private boolean czz = false;
    private boolean czA = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> czB = new ArrayList<>();
    private AdapterView.OnItemClickListener czC = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.czz && !SwanAppAlbumActivity.this.czA) {
                SwanAppAlbumActivity.this.asN();
            }
            SwanAppAlbumActivity.this.czq.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.czB.get(i)).iL());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.czB.get(i)).cBe;
            SwanAppAlbumActivity.this.czp.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.czt.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.czt.setVisibility(0);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.bRz = new ActivityResultDispatcher(this, 1);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ah.P(this);
        asJ();
        initView();
        initData();
    }

    private void asJ() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            d.cuy = u.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = u.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = u.c(safeGetBundleExtra, "isFrontCamera", false);
            d.cAT = u.a(safeGetBundleExtra, "maxDuration", 60);
            d.cAR = u.a(safeGetBundleExtra, "count", 9);
            String safeGetString = u.safeGetString(safeGetBundleExtra, "mode");
            d.czg = u.c(safeGetBundleExtra, "compressed", true);
            d.cAS = u.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.cAU = u.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.cAR < 1 || d.cAR > 9) {
                d.cAR = 9;
            }
        }
    }

    private void initView() {
        this.czo = (GridView) findViewById(a.f.album_gridview);
        this.czq = (TextView) findViewById(a.f.album_name);
        this.czr = (TextView) findViewById(a.f.album_select_done);
        this.czs = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.czt = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.czv = findViewById(a.f.album_name_list_layout);
        this.czw = findViewById(a.f.album_name_list_container);
        this.czx = (HeightListView) findViewById(a.f.album_name_list);
        this.czy = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.czu = (TextView) findViewById(a.f.album_left_cancel);
        this.czx.setListViewHeight(ah.dip2px(this, 400.0f));
        this.czq.setOnClickListener(this);
        this.czu.setOnClickListener(this);
        this.czr.setOnClickListener(this);
        this.czs.setOnClickListener(this);
        this.czv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.czz && !SwanAppAlbumActivity.this.czA) {
                    SwanAppAlbumActivity.this.asN();
                    return true;
                }
                return true;
            }
        });
        this.czt.setVisibility(0);
        this.czq.setText(d.X(this, d.cuy));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.czy.gh(true);
        p.postOnComputation(new com.baidu.swan.apps.media.chooser.d.a(d.cuy, this.mHandler), "loadAlbumTask");
    }

    private void asK() {
        this.czp = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.czo.setAdapter((ListAdapter) this.czp);
        this.czp.setData(this.czB.get(0).cBe);
        this.czp.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void ii(int i) {
                SwanAppAlbumActivity.this.asM();
            }
        });
    }

    private void asL() {
        this.czx.setAdapter((ListAdapter) new b(this, d.cuy, this.czB));
        this.czx.setOnItemClickListener(this.czC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.czy.gh(false);
        this.czB = (ArrayList) obj;
        if (this.czB.size() > 0 && this.czB.get(0) != null) {
            if (this.czB.get(0).ate() == null || this.czB.get(0).ate().size() == 0) {
                this.czt.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.czq.setCompoundDrawables(null, null, drawable, null);
            this.czq.setCompoundDrawablePadding(ah.dip2px(this, 4.0f));
        } else {
            this.czt.setVisibility(8);
        }
        this.czr.setVisibility(0);
        asM();
        asL();
        asK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asM() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.czr.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.czs.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.czr.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.czr.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.czs.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.czr.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.czq) {
            if (this.czB != null && this.czB.size() > 1 && !this.czA) {
                if (this.czz) {
                    asN();
                } else {
                    asO();
                }
            }
        } else if (view == this.czr) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.czg);
            bundle.putString("swanAppId", d.cAS);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.ath());
            bundle.putString("swanTmpPath", d.cAU);
            d.c(this, bundle);
        } else if (view == this.czu) {
            finish();
        } else if (view == this.czs && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asN() {
        if (this.czz) {
            this.czA = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0331a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.czw.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.czz = false;
                    SwanAppAlbumActivity.this.czA = false;
                    SwanAppAlbumActivity.this.czv.setVisibility(8);
                    SwanAppAlbumActivity.this.czw.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.czq.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void asO() {
        if (!this.czz) {
            this.czv.setVisibility(0);
            this.czw.setVisibility(0);
            this.czA = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0331a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.czw.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.czz = true;
                    SwanAppAlbumActivity.this.czA = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.czq.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.bRz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.czp != null) {
                        this.czp.notifyDataSetChanged();
                    }
                    asM();
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
        overridePendingTransition(0, a.C0331a.swanapp_album_slide_bottom_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
