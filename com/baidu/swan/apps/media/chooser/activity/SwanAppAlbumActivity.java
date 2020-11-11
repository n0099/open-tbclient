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
/* loaded from: classes10.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private ActivityResultDispatcher cuo;
    private GridView dbO;
    private com.baidu.swan.apps.media.chooser.adapter.a dbP;
    private TextView dbQ;
    private TextView dbR;
    private TextView dbS;
    private RelativeLayout dbT;
    private TextView dbU;
    private View dbV;
    private View dbW;
    private HeightListView dbX;
    private LoadingLayout dbY;
    private boolean dbZ = false;
    private boolean dca = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> dcb = new ArrayList<>();
    private AdapterView.OnItemClickListener dcc = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.dbZ && !SwanAppAlbumActivity.this.dca) {
                SwanAppAlbumActivity.this.aAB();
            }
            SwanAppAlbumActivity.this.dbQ.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.dcb.get(i)).iN());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.dcb.get(i)).ddF;
            SwanAppAlbumActivity.this.dbP.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.dbT.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.dbT.setVisibility(0);
            }
        }
    };
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.cuo = new ActivityResultDispatcher(this, 1);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ah.S(this);
        aAx();
        initView();
        initData();
    }

    private void aAx() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            d.cWY = u.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = u.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = u.c(safeGetBundleExtra, "isFrontCamera", false);
            d.ddt = u.a(safeGetBundleExtra, "maxDuration", 60);
            d.ddr = u.a(safeGetBundleExtra, "count", 9);
            String safeGetString = u.safeGetString(safeGetBundleExtra, UbcStatConstant.KEY_CONTENT_EXT_MODE);
            d.dbG = u.c(safeGetBundleExtra, "compressed", true);
            d.dds = u.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.ddv = u.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.ddr < 1 || d.ddr > 9) {
                d.ddr = 9;
            }
        }
    }

    private void initView() {
        this.dbO = (GridView) findViewById(a.f.album_gridview);
        this.dbQ = (TextView) findViewById(a.f.album_name);
        this.dbR = (TextView) findViewById(a.f.album_select_done);
        this.dbS = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.dbT = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.dbV = findViewById(a.f.album_name_list_layout);
        this.dbW = findViewById(a.f.album_name_list_container);
        this.dbX = (HeightListView) findViewById(a.f.album_name_list);
        this.dbY = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.dbU = (TextView) findViewById(a.f.album_left_cancel);
        this.dbX.setListViewHeight(ah.dip2px(this, 400.0f));
        this.dbQ.setOnClickListener(this);
        this.dbU.setOnClickListener(this);
        this.dbR.setOnClickListener(this);
        this.dbS.setOnClickListener(this);
        this.dbV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.dbZ && !SwanAppAlbumActivity.this.dca) {
                    SwanAppAlbumActivity.this.aAB();
                    return true;
                }
                return true;
            }
        });
        this.dbT.setVisibility(0);
        this.dbQ.setText(d.ae(this, d.cWY));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.dbY.gY(true);
        p.postOnComputation(new com.baidu.swan.apps.media.chooser.d.a(d.cWY, this.mHandler), "loadAlbumTask");
    }

    private void aAy() {
        this.dbP = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.dbO.setAdapter((ListAdapter) this.dbP);
        this.dbP.setData(this.dcb.get(0).ddF);
        this.dbP.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void jk(int i) {
                SwanAppAlbumActivity.this.aAA();
            }
        });
    }

    private void aAz() {
        this.dbX.setAdapter((ListAdapter) new b(this, d.cWY, this.dcb));
        this.dbX.setOnItemClickListener(this.dcc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.dbY.gY(false);
        this.dcb = (ArrayList) obj;
        if (this.dcb.size() > 0 && this.dcb.get(0) != null) {
            if (this.dcb.get(0).aAS() == null || this.dcb.get(0).aAS().size() == 0) {
                this.dbT.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.dbQ.setCompoundDrawables(null, null, drawable, null);
            this.dbQ.setCompoundDrawablePadding(ah.dip2px(this, 4.0f));
        } else {
            this.dbT.setVisibility(8);
        }
        this.dbR.setVisibility(0);
        aAA();
        aAz();
        aAy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAA() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.dbR.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.dbS.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.dbR.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.dbR.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.dbS.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.dbR.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dbQ) {
            if (this.dcb != null && this.dcb.size() > 1 && !this.dca) {
                if (this.dbZ) {
                    aAB();
                } else {
                    aAC();
                }
            }
        } else if (view == this.dbR) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.dbG);
            bundle.putString("swanAppId", d.dds);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aAV());
            bundle.putString("swanTmpPath", d.ddv);
            d.c(this, bundle);
        } else if (view == this.dbU) {
            finish();
        } else if (view == this.dbS && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAB() {
        if (this.dbZ) {
            this.dca = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0369a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.dbW.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.dbZ = false;
                    SwanAppAlbumActivity.this.dca = false;
                    SwanAppAlbumActivity.this.dbV.setVisibility(8);
                    SwanAppAlbumActivity.this.dbW.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.dbQ.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void aAC() {
        if (!this.dbZ) {
            this.dbV.setVisibility(0);
            this.dbW.setVisibility(0);
            this.dca = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0369a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.dbW.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.dbZ = true;
                    SwanAppAlbumActivity.this.dca = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.dbQ.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.cuo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.dbP != null) {
                        this.dbP.notifyDataSetChanged();
                    }
                    aAA();
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
        overridePendingTransition(0, a.C0369a.swanapp_album_slide_bottom_out);
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
