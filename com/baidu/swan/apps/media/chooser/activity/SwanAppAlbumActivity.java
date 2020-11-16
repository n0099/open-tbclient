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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
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
/* loaded from: classes7.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private ActivityResultDispatcher csC;
    private GridView dae;
    private com.baidu.swan.apps.media.chooser.adapter.a daf;
    private TextView dag;
    private TextView dah;
    private TextView dai;
    private RelativeLayout daj;
    private TextView dak;
    private View dal;
    private View dam;
    private HeightListView dan;
    private LoadingLayout dao;
    private boolean dap = false;
    private boolean daq = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> dar = new ArrayList<>();
    private AdapterView.OnItemClickListener das = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.dap && !SwanAppAlbumActivity.this.daq) {
                SwanAppAlbumActivity.this.azT();
            }
            SwanAppAlbumActivity.this.dag.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.dar.get(i)).iN());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.dar.get(i)).dbV;
            SwanAppAlbumActivity.this.daf.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.daj.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.daj.setVisibility(0);
            }
        }
    };
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.csC = new ActivityResultDispatcher(this, 1);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ah.R(this);
        azP();
        initView();
        initData();
    }

    private void azP() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            d.cVo = u.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = u.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = u.c(safeGetBundleExtra, "isFrontCamera", false);
            d.dbK = u.a(safeGetBundleExtra, "maxDuration", 60);
            d.dbI = u.a(safeGetBundleExtra, "count", 9);
            String safeGetString = u.safeGetString(safeGetBundleExtra, UbcStatConstant.KEY_CONTENT_EXT_MODE);
            d.cZW = u.c(safeGetBundleExtra, "compressed", true);
            d.dbJ = u.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.dbL = u.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.dbI < 1 || d.dbI > 9) {
                d.dbI = 9;
            }
        }
    }

    private void initView() {
        this.dae = (GridView) findViewById(a.f.album_gridview);
        this.dag = (TextView) findViewById(a.f.album_name);
        this.dah = (TextView) findViewById(a.f.album_select_done);
        this.dai = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.daj = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.dal = findViewById(a.f.album_name_list_layout);
        this.dam = findViewById(a.f.album_name_list_container);
        this.dan = (HeightListView) findViewById(a.f.album_name_list);
        this.dao = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.dak = (TextView) findViewById(a.f.album_left_cancel);
        this.dan.setListViewHeight(ah.dip2px(this, 400.0f));
        this.dag.setOnClickListener(this);
        this.dak.setOnClickListener(this);
        this.dah.setOnClickListener(this);
        this.dai.setOnClickListener(this);
        this.dal.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.dap && !SwanAppAlbumActivity.this.daq) {
                    SwanAppAlbumActivity.this.azT();
                    return true;
                }
                return true;
            }
        });
        this.daj.setVisibility(0);
        this.dag.setText(d.ab(this, d.cVo));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.dao.hb(true);
        p.postOnComputation(new com.baidu.swan.apps.media.chooser.d.a(d.cVo, this.mHandler), "loadAlbumTask");
    }

    private void azQ() {
        this.daf = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.dae.setAdapter((ListAdapter) this.daf);
        this.daf.setData(this.dar.get(0).dbV);
        this.daf.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void jg(int i) {
                SwanAppAlbumActivity.this.azS();
            }
        });
    }

    private void azR() {
        this.dan.setAdapter((ListAdapter) new b(this, d.cVo, this.dar));
        this.dan.setOnItemClickListener(this.das);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.dao.hb(false);
        this.dar = (ArrayList) obj;
        if (this.dar.size() > 0 && this.dar.get(0) != null) {
            if (this.dar.get(0).aAk() == null || this.dar.get(0).aAk().size() == 0) {
                this.daj.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.dag.setCompoundDrawables(null, null, drawable, null);
            this.dag.setCompoundDrawablePadding(ah.dip2px(this, 4.0f));
        } else {
            this.daj.setVisibility(8);
        }
        this.dah.setVisibility(0);
        azS();
        azR();
        azQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azS() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.dah.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.dai.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.dah.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.dah.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.dai.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.dah.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dag) {
            if (this.dar != null && this.dar.size() > 1 && !this.daq) {
                if (this.dap) {
                    azT();
                } else {
                    azU();
                }
            }
        } else if (view == this.dah) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.cZW);
            bundle.putString("swanAppId", d.dbJ);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aAn());
            bundle.putString("swanTmpPath", d.dbL);
            d.c(this, bundle);
        } else if (view == this.dak) {
            finish();
        } else if (view == this.dai && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azT() {
        if (this.dap) {
            this.daq = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0367a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.dam.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.dap = false;
                    SwanAppAlbumActivity.this.daq = false;
                    SwanAppAlbumActivity.this.dal.setVisibility(8);
                    SwanAppAlbumActivity.this.dam.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.dag.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void azU() {
        if (!this.dap) {
            this.dal.setVisibility(0);
            this.dam.setVisibility(0);
            this.daq = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0367a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.dam.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.dap = true;
                    SwanAppAlbumActivity.this.daq = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.dag.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.csC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.daf != null) {
                        this.daf.notifyDataSetChanged();
                    }
                    azS();
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
        overridePendingTransition(0, a.C0367a.swanapp_album_slide_bottom_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
