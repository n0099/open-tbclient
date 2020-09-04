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
    private ActivityResultDispatcher bRD;
    private View czA;
    private HeightListView czB;
    private LoadingLayout czC;
    private boolean czD = false;
    private boolean czE = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> czF = new ArrayList<>();
    private AdapterView.OnItemClickListener czG = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.czD && !SwanAppAlbumActivity.this.czE) {
                SwanAppAlbumActivity.this.asN();
            }
            SwanAppAlbumActivity.this.czu.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.czF.get(i)).iL());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.czF.get(i)).cBi;
            SwanAppAlbumActivity.this.czt.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.czx.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.czx.setVisibility(0);
            }
        }
    };
    private GridView czs;
    private com.baidu.swan.apps.media.chooser.adapter.a czt;
    private TextView czu;
    private TextView czv;
    private TextView czw;
    private RelativeLayout czx;
    private TextView czy;
    private View czz;
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.bRD = new ActivityResultDispatcher(this, 1);
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
            d.cuC = u.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = u.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = u.c(safeGetBundleExtra, "isFrontCamera", false);
            d.cAX = u.a(safeGetBundleExtra, "maxDuration", 60);
            d.cAV = u.a(safeGetBundleExtra, "count", 9);
            String safeGetString = u.safeGetString(safeGetBundleExtra, "mode");
            d.czk = u.c(safeGetBundleExtra, "compressed", true);
            d.cAW = u.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.cAY = u.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.cAV < 1 || d.cAV > 9) {
                d.cAV = 9;
            }
        }
    }

    private void initView() {
        this.czs = (GridView) findViewById(a.f.album_gridview);
        this.czu = (TextView) findViewById(a.f.album_name);
        this.czv = (TextView) findViewById(a.f.album_select_done);
        this.czw = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.czx = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.czz = findViewById(a.f.album_name_list_layout);
        this.czA = findViewById(a.f.album_name_list_container);
        this.czB = (HeightListView) findViewById(a.f.album_name_list);
        this.czC = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.czy = (TextView) findViewById(a.f.album_left_cancel);
        this.czB.setListViewHeight(ah.dip2px(this, 400.0f));
        this.czu.setOnClickListener(this);
        this.czy.setOnClickListener(this);
        this.czv.setOnClickListener(this);
        this.czw.setOnClickListener(this);
        this.czz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.czD && !SwanAppAlbumActivity.this.czE) {
                    SwanAppAlbumActivity.this.asN();
                    return true;
                }
                return true;
            }
        });
        this.czx.setVisibility(0);
        this.czu.setText(d.X(this, d.cuC));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.czC.gi(true);
        p.postOnComputation(new com.baidu.swan.apps.media.chooser.d.a(d.cuC, this.mHandler), "loadAlbumTask");
    }

    private void asK() {
        this.czt = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.czs.setAdapter((ListAdapter) this.czt);
        this.czt.setData(this.czF.get(0).cBi);
        this.czt.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void ii(int i) {
                SwanAppAlbumActivity.this.asM();
            }
        });
    }

    private void asL() {
        this.czB.setAdapter((ListAdapter) new b(this, d.cuC, this.czF));
        this.czB.setOnItemClickListener(this.czG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.czC.gi(false);
        this.czF = (ArrayList) obj;
        if (this.czF.size() > 0 && this.czF.get(0) != null) {
            if (this.czF.get(0).ate() == null || this.czF.get(0).ate().size() == 0) {
                this.czx.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.czu.setCompoundDrawables(null, null, drawable, null);
            this.czu.setCompoundDrawablePadding(ah.dip2px(this, 4.0f));
        } else {
            this.czx.setVisibility(8);
        }
        this.czv.setVisibility(0);
        asM();
        asL();
        asK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asM() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.czv.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.czw.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.czv.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.czv.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.czw.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.czv.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.czu) {
            if (this.czF != null && this.czF.size() > 1 && !this.czE) {
                if (this.czD) {
                    asN();
                } else {
                    asO();
                }
            }
        } else if (view == this.czv) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.czk);
            bundle.putString("swanAppId", d.cAW);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.ath());
            bundle.putString("swanTmpPath", d.cAY);
            d.c(this, bundle);
        } else if (view == this.czy) {
            finish();
        } else if (view == this.czw && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asN() {
        if (this.czD) {
            this.czE = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0331a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.czA.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.czD = false;
                    SwanAppAlbumActivity.this.czE = false;
                    SwanAppAlbumActivity.this.czz.setVisibility(8);
                    SwanAppAlbumActivity.this.czA.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.czu.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void asO() {
        if (!this.czD) {
            this.czz.setVisibility(0);
            this.czA.setVisibility(0);
            this.czE = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0331a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.czA.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.czD = true;
                    SwanAppAlbumActivity.this.czE = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.czu.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.bRD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.czt != null) {
                        this.czt.notifyDataSetChanged();
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
