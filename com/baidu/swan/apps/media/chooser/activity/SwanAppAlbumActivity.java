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
    private TextView cNA;
    private TextView cNB;
    private TextView cNC;
    private RelativeLayout cND;
    private TextView cNE;
    private View cNF;
    private View cNG;
    private HeightListView cNH;
    private LoadingLayout cNI;
    private boolean cNJ = false;
    private boolean cNK = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> cNL = new ArrayList<>();
    private AdapterView.OnItemClickListener cNM = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.cNJ && !SwanAppAlbumActivity.this.cNK) {
                SwanAppAlbumActivity.this.awh();
            }
            SwanAppAlbumActivity.this.cNA.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.cNL.get(i)).iN());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.cNL.get(i)).cPn;
            SwanAppAlbumActivity.this.cNz.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.cND.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.cND.setVisibility(0);
            }
        }
    };
    private GridView cNy;
    private com.baidu.swan.apps.media.chooser.adapter.a cNz;
    private ActivityResultDispatcher cfR;
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.cfR = new ActivityResultDispatcher(this, 1);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ah.S(this);
        awd();
        initView();
        initData();
    }

    private void awd() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            d.cIJ = u.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = u.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = u.c(safeGetBundleExtra, "isFrontCamera", false);
            d.cPc = u.a(safeGetBundleExtra, "maxDuration", 60);
            d.cPa = u.a(safeGetBundleExtra, "count", 9);
            String safeGetString = u.safeGetString(safeGetBundleExtra, "mode");
            d.cNq = u.c(safeGetBundleExtra, "compressed", true);
            d.cPb = u.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.cPd = u.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.cPa < 1 || d.cPa > 9) {
                d.cPa = 9;
            }
        }
    }

    private void initView() {
        this.cNy = (GridView) findViewById(a.f.album_gridview);
        this.cNA = (TextView) findViewById(a.f.album_name);
        this.cNB = (TextView) findViewById(a.f.album_select_done);
        this.cNC = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.cND = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.cNF = findViewById(a.f.album_name_list_layout);
        this.cNG = findViewById(a.f.album_name_list_container);
        this.cNH = (HeightListView) findViewById(a.f.album_name_list);
        this.cNI = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.cNE = (TextView) findViewById(a.f.album_left_cancel);
        this.cNH.setListViewHeight(ah.dip2px(this, 400.0f));
        this.cNA.setOnClickListener(this);
        this.cNE.setOnClickListener(this);
        this.cNB.setOnClickListener(this);
        this.cNC.setOnClickListener(this);
        this.cNF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.cNJ && !SwanAppAlbumActivity.this.cNK) {
                    SwanAppAlbumActivity.this.awh();
                    return true;
                }
                return true;
            }
        });
        this.cND.setVisibility(0);
        this.cNA.setText(d.ad(this, d.cIJ));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.cNI.gC(true);
        p.postOnComputation(new com.baidu.swan.apps.media.chooser.d.a(d.cIJ, this.mHandler), "loadAlbumTask");
    }

    private void awe() {
        this.cNz = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.cNy.setAdapter((ListAdapter) this.cNz);
        this.cNz.setData(this.cNL.get(0).cPn);
        this.cNz.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void iP(int i) {
                SwanAppAlbumActivity.this.awg();
            }
        });
    }

    private void awf() {
        this.cNH.setAdapter((ListAdapter) new b(this, d.cIJ, this.cNL));
        this.cNH.setOnItemClickListener(this.cNM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.cNI.gC(false);
        this.cNL = (ArrayList) obj;
        if (this.cNL.size() > 0 && this.cNL.get(0) != null) {
            if (this.cNL.get(0).awy() == null || this.cNL.get(0).awy().size() == 0) {
                this.cND.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.cNA.setCompoundDrawables(null, null, drawable, null);
            this.cNA.setCompoundDrawablePadding(ah.dip2px(this, 4.0f));
        } else {
            this.cND.setVisibility(8);
        }
        this.cNB.setVisibility(0);
        awg();
        awf();
        awe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awg() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.cNB.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.cNC.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.cNB.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.cNB.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.cNC.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.cNB.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cNA) {
            if (this.cNL != null && this.cNL.size() > 1 && !this.cNK) {
                if (this.cNJ) {
                    awh();
                } else {
                    awi();
                }
            }
        } else if (view == this.cNB) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.cNq);
            bundle.putString("swanAppId", d.cPb);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.awB());
            bundle.putString("swanTmpPath", d.cPd);
            d.c(this, bundle);
        } else if (view == this.cNE) {
            finish();
        } else if (view == this.cNC && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awh() {
        if (this.cNJ) {
            this.cNK = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0343a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.cNG.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.cNJ = false;
                    SwanAppAlbumActivity.this.cNK = false;
                    SwanAppAlbumActivity.this.cNF.setVisibility(8);
                    SwanAppAlbumActivity.this.cNG.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.cNA.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void awi() {
        if (!this.cNJ) {
            this.cNF.setVisibility(0);
            this.cNG.setVisibility(0);
            this.cNK = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0343a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.cNG.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.cNJ = true;
                    SwanAppAlbumActivity.this.cNK = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.cNA.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.cfR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.cNz != null) {
                        this.cNz.notifyDataSetChanged();
                    }
                    awg();
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
        overridePendingTransition(0, a.C0343a.swanapp_album_slide_bottom_out);
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
