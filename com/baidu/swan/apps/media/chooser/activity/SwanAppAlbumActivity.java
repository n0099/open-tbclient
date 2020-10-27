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
/* loaded from: classes10.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private GridView cVU;
    private com.baidu.swan.apps.media.chooser.adapter.a cVV;
    private TextView cVW;
    private TextView cVX;
    private TextView cVY;
    private RelativeLayout cVZ;
    private TextView cWa;
    private View cWb;
    private View cWc;
    private HeightListView cWd;
    private LoadingLayout cWe;
    private boolean cWf = false;
    private boolean cWg = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> cWh = new ArrayList<>();
    private AdapterView.OnItemClickListener cWi = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.cWf && !SwanAppAlbumActivity.this.cWg) {
                SwanAppAlbumActivity.this.ayb();
            }
            SwanAppAlbumActivity.this.cVW.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.cWh.get(i)).iN());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.cWh.get(i)).cXJ;
            SwanAppAlbumActivity.this.cVV.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.cVZ.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.cVZ.setVisibility(0);
            }
        }
    };
    private ActivityResultDispatcher cor;
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.cor = new ActivityResultDispatcher(this, 1);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ah.S(this);
        axX();
        initView();
        initData();
    }

    private void axX() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            d.cRf = u.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = u.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = u.c(safeGetBundleExtra, "isFrontCamera", false);
            d.cXy = u.a(safeGetBundleExtra, "maxDuration", 60);
            d.cXw = u.a(safeGetBundleExtra, "count", 9);
            String safeGetString = u.safeGetString(safeGetBundleExtra, "mode");
            d.cVM = u.c(safeGetBundleExtra, "compressed", true);
            d.cXx = u.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.cXz = u.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.cXw < 1 || d.cXw > 9) {
                d.cXw = 9;
            }
        }
    }

    private void initView() {
        this.cVU = (GridView) findViewById(a.f.album_gridview);
        this.cVW = (TextView) findViewById(a.f.album_name);
        this.cVX = (TextView) findViewById(a.f.album_select_done);
        this.cVY = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.cVZ = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.cWb = findViewById(a.f.album_name_list_layout);
        this.cWc = findViewById(a.f.album_name_list_container);
        this.cWd = (HeightListView) findViewById(a.f.album_name_list);
        this.cWe = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.cWa = (TextView) findViewById(a.f.album_left_cancel);
        this.cWd.setListViewHeight(ah.dip2px(this, 400.0f));
        this.cVW.setOnClickListener(this);
        this.cWa.setOnClickListener(this);
        this.cVX.setOnClickListener(this);
        this.cVY.setOnClickListener(this);
        this.cWb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.cWf && !SwanAppAlbumActivity.this.cWg) {
                    SwanAppAlbumActivity.this.ayb();
                    return true;
                }
                return true;
            }
        });
        this.cVZ.setVisibility(0);
        this.cVW.setText(d.ae(this, d.cRf));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.cWe.gP(true);
        p.postOnComputation(new com.baidu.swan.apps.media.chooser.d.a(d.cRf, this.mHandler), "loadAlbumTask");
    }

    private void axY() {
        this.cVV = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.cVU.setAdapter((ListAdapter) this.cVV);
        this.cVV.setData(this.cWh.get(0).cXJ);
        this.cVV.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void ja(int i) {
                SwanAppAlbumActivity.this.aya();
            }
        });
    }

    private void axZ() {
        this.cWd.setAdapter((ListAdapter) new b(this, d.cRf, this.cWh));
        this.cWd.setOnItemClickListener(this.cWi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.cWe.gP(false);
        this.cWh = (ArrayList) obj;
        if (this.cWh.size() > 0 && this.cWh.get(0) != null) {
            if (this.cWh.get(0).ays() == null || this.cWh.get(0).ays().size() == 0) {
                this.cVZ.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.cVW.setCompoundDrawables(null, null, drawable, null);
            this.cVW.setCompoundDrawablePadding(ah.dip2px(this, 4.0f));
        } else {
            this.cVZ.setVisibility(8);
        }
        this.cVX.setVisibility(0);
        aya();
        axZ();
        axY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aya() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.cVX.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.cVY.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.cVX.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.cVX.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.cVY.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.cVX.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cVW) {
            if (this.cWh != null && this.cWh.size() > 1 && !this.cWg) {
                if (this.cWf) {
                    ayb();
                } else {
                    ayc();
                }
            }
        } else if (view == this.cVX) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.cVM);
            bundle.putString("swanAppId", d.cXx);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.ayv());
            bundle.putString("swanTmpPath", d.cXz);
            d.c(this, bundle);
        } else if (view == this.cWa) {
            finish();
        } else if (view == this.cVY && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayb() {
        if (this.cWf) {
            this.cWg = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0357a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.cWc.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.cWf = false;
                    SwanAppAlbumActivity.this.cWg = false;
                    SwanAppAlbumActivity.this.cWb.setVisibility(8);
                    SwanAppAlbumActivity.this.cWc.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.cVW.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void ayc() {
        if (!this.cWf) {
            this.cWb.setVisibility(0);
            this.cWc.setVisibility(0);
            this.cWg = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0357a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.cWc.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.cWf = true;
                    SwanAppAlbumActivity.this.cWg = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.cVW.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.cor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.cVV != null) {
                        this.cVV.notifyDataSetChanged();
                    }
                    aya();
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
        overridePendingTransition(0, a.C0357a.swanapp_album_slide_bottom_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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
