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
/* loaded from: classes25.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private ActivityResultDispatcher czy;
    private GridView dhe;
    private com.baidu.swan.apps.media.chooser.adapter.a dhf;
    private TextView dhg;
    private TextView dhh;
    private TextView dhi;
    private RelativeLayout dhj;
    private TextView dhk;
    private View dhl;
    private View dhm;
    private HeightListView dhn;
    private LoadingLayout dho;
    private boolean dhp = false;
    private boolean dhq = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> dhr = new ArrayList<>();
    private AdapterView.OnItemClickListener dhs = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.dhp && !SwanAppAlbumActivity.this.dhq) {
                SwanAppAlbumActivity.this.aDc();
            }
            SwanAppAlbumActivity.this.dhg.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.dhr.get(i)).iN());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.dhr.get(i)).diW;
            SwanAppAlbumActivity.this.dhf.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.dhj.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.dhj.setVisibility(0);
            }
        }
    };
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.czy = new ActivityResultDispatcher(this, 1);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ah.R(this);
        aCY();
        initView();
        initData();
    }

    private void aCY() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            d.dck = u.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = u.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = u.c(safeGetBundleExtra, "isFrontCamera", false);
            d.diL = u.a(safeGetBundleExtra, "maxDuration", 60);
            d.diJ = u.a(safeGetBundleExtra, "count", 9);
            String safeGetString = u.safeGetString(safeGetBundleExtra, UbcStatConstant.KEY_CONTENT_EXT_MODE);
            d.dgW = u.c(safeGetBundleExtra, "compressed", true);
            d.diK = u.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.diM = u.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.diJ < 1 || d.diJ > 9) {
                d.diJ = 9;
            }
        }
    }

    private void initView() {
        this.dhe = (GridView) findViewById(a.f.album_gridview);
        this.dhg = (TextView) findViewById(a.f.album_name);
        this.dhh = (TextView) findViewById(a.f.album_select_done);
        this.dhi = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.dhj = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.dhl = findViewById(a.f.album_name_list_layout);
        this.dhm = findViewById(a.f.album_name_list_container);
        this.dhn = (HeightListView) findViewById(a.f.album_name_list);
        this.dho = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.dhk = (TextView) findViewById(a.f.album_left_cancel);
        this.dhn.setListViewHeight(ah.dip2px(this, 400.0f));
        this.dhg.setOnClickListener(this);
        this.dhk.setOnClickListener(this);
        this.dhh.setOnClickListener(this);
        this.dhi.setOnClickListener(this);
        this.dhl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.dhp && !SwanAppAlbumActivity.this.dhq) {
                    SwanAppAlbumActivity.this.aDc();
                    return true;
                }
                return true;
            }
        });
        this.dhj.setVisibility(0);
        this.dhg.setText(d.ae(this, d.dck));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.dho.hq(true);
        p.postOnComputation(new com.baidu.swan.apps.media.chooser.d.a(d.dck, this.mHandler), "loadAlbumTask");
    }

    private void aCZ() {
        this.dhf = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.dhe.setAdapter((ListAdapter) this.dhf);
        this.dhf.setData(this.dhr.get(0).diW);
        this.dhf.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void jE(int i) {
                SwanAppAlbumActivity.this.aDb();
            }
        });
    }

    private void aDa() {
        this.dhn.setAdapter((ListAdapter) new b(this, d.dck, this.dhr));
        this.dhn.setOnItemClickListener(this.dhs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.dho.hq(false);
        this.dhr = (ArrayList) obj;
        if (this.dhr.size() > 0 && this.dhr.get(0) != null) {
            if (this.dhr.get(0).aDt() == null || this.dhr.get(0).aDt().size() == 0) {
                this.dhj.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.dhg.setCompoundDrawables(null, null, drawable, null);
            this.dhg.setCompoundDrawablePadding(ah.dip2px(this, 4.0f));
        } else {
            this.dhj.setVisibility(8);
        }
        this.dhh.setVisibility(0);
        aDb();
        aDa();
        aCZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDb() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.dhh.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.dhi.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.dhh.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.dhh.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.dhi.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.dhh.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dhg) {
            if (this.dhr != null && this.dhr.size() > 1 && !this.dhq) {
                if (this.dhp) {
                    aDc();
                } else {
                    aDd();
                }
            }
        } else if (view == this.dhh) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.dgW);
            bundle.putString("swanAppId", d.diK);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aDw());
            bundle.putString("swanTmpPath", d.diM);
            d.c(this, bundle);
        } else if (view == this.dhk) {
            finish();
        } else if (view == this.dhi && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDc() {
        if (this.dhp) {
            this.dhq = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0379a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.dhm.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.dhp = false;
                    SwanAppAlbumActivity.this.dhq = false;
                    SwanAppAlbumActivity.this.dhl.setVisibility(8);
                    SwanAppAlbumActivity.this.dhm.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.dhg.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void aDd() {
        if (!this.dhp) {
            this.dhl.setVisibility(0);
            this.dhm.setVisibility(0);
            this.dhq = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0379a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.dhm.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.dhp = true;
                    SwanAppAlbumActivity.this.dhq = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.dhg.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.czy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.dhf != null) {
                        this.dhf.notifyDataSetChanged();
                    }
                    aDb();
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
        overridePendingTransition(0, a.C0379a.swanapp_album_slide_bottom_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
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
