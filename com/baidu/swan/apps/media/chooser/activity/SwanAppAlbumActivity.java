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
/* loaded from: classes3.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private ActivityResultDispatcher bTD;
    private View cBA;
    private View cBB;
    private HeightListView cBC;
    private LoadingLayout cBD;
    private boolean cBE = false;
    private boolean cBF = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> cBG = new ArrayList<>();
    private AdapterView.OnItemClickListener cBH = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.cBE && !SwanAppAlbumActivity.this.cBF) {
                SwanAppAlbumActivity.this.atw();
            }
            SwanAppAlbumActivity.this.cBv.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.cBG.get(i)).iM());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.cBG.get(i)).cDi;
            SwanAppAlbumActivity.this.cBu.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.cBy.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.cBy.setVisibility(0);
            }
        }
    };
    private GridView cBt;
    private com.baidu.swan.apps.media.chooser.adapter.a cBu;
    private TextView cBv;
    private TextView cBw;
    private TextView cBx;
    private RelativeLayout cBy;
    private TextView cBz;
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.bTD = new ActivityResultDispatcher(this, 1);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ah.R(this);
        ats();
        initView();
        initData();
    }

    private void ats() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            d.cwD = u.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = u.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = u.c(safeGetBundleExtra, "isFrontCamera", false);
            d.cCX = u.a(safeGetBundleExtra, "maxDuration", 60);
            d.cCV = u.a(safeGetBundleExtra, "count", 9);
            String safeGetString = u.safeGetString(safeGetBundleExtra, "mode");
            d.cBl = u.c(safeGetBundleExtra, "compressed", true);
            d.cCW = u.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.cCY = u.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.cCV < 1 || d.cCV > 9) {
                d.cCV = 9;
            }
        }
    }

    private void initView() {
        this.cBt = (GridView) findViewById(a.f.album_gridview);
        this.cBv = (TextView) findViewById(a.f.album_name);
        this.cBw = (TextView) findViewById(a.f.album_select_done);
        this.cBx = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.cBy = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.cBA = findViewById(a.f.album_name_list_layout);
        this.cBB = findViewById(a.f.album_name_list_container);
        this.cBC = (HeightListView) findViewById(a.f.album_name_list);
        this.cBD = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.cBz = (TextView) findViewById(a.f.album_left_cancel);
        this.cBC.setListViewHeight(ah.dip2px(this, 400.0f));
        this.cBv.setOnClickListener(this);
        this.cBz.setOnClickListener(this);
        this.cBw.setOnClickListener(this);
        this.cBx.setOnClickListener(this);
        this.cBA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.cBE && !SwanAppAlbumActivity.this.cBF) {
                    SwanAppAlbumActivity.this.atw();
                    return true;
                }
                return true;
            }
        });
        this.cBy.setVisibility(0);
        this.cBv.setText(d.aa(this, d.cwD));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.cBD.gg(true);
        p.postOnComputation(new com.baidu.swan.apps.media.chooser.d.a(d.cwD, this.mHandler), "loadAlbumTask");
    }

    private void att() {
        this.cBu = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.cBt.setAdapter((ListAdapter) this.cBu);
        this.cBu.setData(this.cBG.get(0).cDi);
        this.cBu.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void is(int i) {
                SwanAppAlbumActivity.this.atv();
            }
        });
    }

    private void atu() {
        this.cBC.setAdapter((ListAdapter) new b(this, d.cwD, this.cBG));
        this.cBC.setOnItemClickListener(this.cBH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.cBD.gg(false);
        this.cBG = (ArrayList) obj;
        if (this.cBG.size() > 0 && this.cBG.get(0) != null) {
            if (this.cBG.get(0).atN() == null || this.cBG.get(0).atN().size() == 0) {
                this.cBy.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.cBv.setCompoundDrawables(null, null, drawable, null);
            this.cBv.setCompoundDrawablePadding(ah.dip2px(this, 4.0f));
        } else {
            this.cBy.setVisibility(8);
        }
        this.cBw.setVisibility(0);
        atv();
        atu();
        att();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atv() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.cBw.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.cBx.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.cBw.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.cBw.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.cBx.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.cBw.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cBv) {
            if (this.cBG != null && this.cBG.size() > 1 && !this.cBF) {
                if (this.cBE) {
                    atw();
                } else {
                    atx();
                }
            }
        } else if (view == this.cBw) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.cBl);
            bundle.putString("swanAppId", d.cCW);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.atQ());
            bundle.putString("swanTmpPath", d.cCY);
            d.c(this, bundle);
        } else if (view == this.cBz) {
            finish();
        } else if (view == this.cBx && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atw() {
        if (this.cBE) {
            this.cBF = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0326a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.cBB.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.cBE = false;
                    SwanAppAlbumActivity.this.cBF = false;
                    SwanAppAlbumActivity.this.cBA.setVisibility(8);
                    SwanAppAlbumActivity.this.cBB.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.cBv.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void atx() {
        if (!this.cBE) {
            this.cBA.setVisibility(0);
            this.cBB.setVisibility(0);
            this.cBF = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0326a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.cBB.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.cBE = true;
                    SwanAppAlbumActivity.this.cBF = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.cBv.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.bTD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.cBu != null) {
                        this.cBu.notifyDataSetChanged();
                    }
                    atv();
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
        overridePendingTransition(0, a.C0326a.swanapp_album_slide_bottom_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
