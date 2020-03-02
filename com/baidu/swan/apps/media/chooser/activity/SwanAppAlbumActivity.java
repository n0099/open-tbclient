package com.baidu.swan.apps.media.chooser.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.media.chooser.adapter.a;
import com.baidu.swan.apps.media.chooser.b.c;
import com.baidu.swan.apps.media.chooser.b.d;
import com.baidu.swan.apps.media.chooser.c.e;
import com.baidu.swan.apps.media.chooser.d.b;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.view.HeightListView;
import com.baidu.swan.apps.view.LoadingLayout;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private a bBC;
    private TextView bBD;
    private TextView bBE;
    private TextView bBF;
    private View bBG;
    private View bBH;
    private HeightListView bBI;
    private LoadingLayout bBJ;
    private b bBK;
    private ActivityResultDispatcher baK;
    private RelativeLayout mBottomPreviewLayout;
    private TextView mBottomPreviewTv;
    private GridView mGridView;
    private boolean mIsOpenedList = false;
    private boolean bBL = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> bBM = new ArrayList<>();
    private AdapterView.OnItemClickListener bBN = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.mIsOpenedList && !SwanAppAlbumActivity.this.bBL) {
                SwanAppAlbumActivity.this.startHideAnimation();
            }
            SwanAppAlbumActivity.this.bBD.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.bBM.get(i)).bx());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.bBM.get(i)).bDf;
            SwanAppAlbumActivity.this.bBC.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.mBottomPreviewLayout.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.mBottomPreviewLayout.setVisibility(0);
            }
        }
    };

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.baK = new ActivityResultDispatcher(this, 1);
        ai.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        af.W(this);
        Xr();
        initView();
        initData();
    }

    private void Xr() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = r.safeGetBundleExtra(getIntent(), "launchParams");
            d.bCq = r.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = r.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = r.c(safeGetBundleExtra, "isFrontCamera", false);
            d.bCU = r.a(safeGetBundleExtra, "maxDuration", 60);
            d.mMaxSelected = r.a(safeGetBundleExtra, "count", 9);
            String safeGetString = r.safeGetString(safeGetBundleExtra, "mode");
            d.bBu = r.c(safeGetBundleExtra, "compressed", true);
            d.bCT = r.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.bCV = r.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.mMaxSelected < 1 || d.mMaxSelected > 9) {
                d.mMaxSelected = 9;
            }
        }
    }

    private void initView() {
        this.mGridView = (GridView) findViewById(a.f.album_gridview);
        this.bBD = (TextView) findViewById(a.f.album_name);
        this.bBE = (TextView) findViewById(a.f.album_select_done);
        this.mBottomPreviewTv = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.mBottomPreviewLayout = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.bBG = findViewById(a.f.album_name_list_layout);
        this.bBH = findViewById(a.f.album_name_list_container);
        this.bBI = (HeightListView) findViewById(a.f.album_name_list);
        this.bBJ = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.bBF = (TextView) findViewById(a.f.album_left_cancel);
        this.bBI.setListViewHeight(af.dip2px(this, 400.0f));
        this.bBD.setOnClickListener(this);
        this.bBF.setOnClickListener(this);
        this.bBE.setOnClickListener(this);
        this.mBottomPreviewTv.setOnClickListener(this);
        this.bBG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.mIsOpenedList && !SwanAppAlbumActivity.this.bBL) {
                    SwanAppAlbumActivity.this.startHideAnimation();
                    return true;
                }
                return true;
            }
        });
        this.mBottomPreviewLayout.setVisibility(0);
        this.bBD.setText(d.am(this, d.bCq));
    }

    private void initData() {
        if (this.bBK == null || this.bBK.getStatus() != AsyncTask.Status.RUNNING) {
            this.bBJ.showLoading(true);
            this.bBK = new b(d.bCq, new com.baidu.swan.apps.media.chooser.c.d() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
                @Override // com.baidu.swan.apps.media.chooser.c.d
                public void onResult(boolean z, String str, Object obj) {
                    if (c.DEBUG) {
                        Log.d(getClass().getSimpleName(), "LoadAlbumTask onResult : " + z);
                    }
                    if (z && (obj instanceof ArrayList)) {
                        SwanAppAlbumActivity.this.notifyUi(obj);
                    }
                }
            });
            this.bBK.execute(new Void[0]);
        }
    }

    private void initImageAdapter() {
        this.bBC = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.mGridView.setAdapter((ListAdapter) this.bBC);
        this.bBC.setData(this.bBM.get(0).bDf);
        this.bBC.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void selectChanged(int i) {
                SwanAppAlbumActivity.this.changeNumberUi();
            }
        });
    }

    private void Xs() {
        this.bBI.setAdapter((ListAdapter) new com.baidu.swan.apps.media.chooser.adapter.b(this, d.bCq, this.bBM));
        this.bBI.setOnItemClickListener(this.bBN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.bBJ.showLoading(false);
        this.bBM = (ArrayList) obj;
        if (this.bBM.size() > 0 && this.bBM.get(0) != null) {
            if (this.bBM.get(0).XG() == null || this.bBM.get(0).XG().size() == 0) {
                this.mBottomPreviewLayout.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.bBD.setCompoundDrawables(null, null, drawable, null);
            this.bBD.setCompoundDrawablePadding(af.dip2px(this, 4.0f));
        } else {
            this.mBottomPreviewLayout.setVisibility(8);
        }
        this.bBE.setVisibility(0);
        changeNumberUi();
        Xs();
        initImageAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeNumberUi() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.bBE.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.mBottomPreviewTv.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.bBE.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.bBE.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.mBottomPreviewTv.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.bBE.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bBD) {
            if (this.bBM != null && this.bBM.size() > 1 && !this.bBL) {
                if (this.mIsOpenedList) {
                    startHideAnimation();
                } else {
                    startShowAnimation();
                }
            }
        } else if (view == this.bBE) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.bBu);
            bundle.putString("swanAppId", d.bCT);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.XJ());
            bundle.putString("swanTmpPath", d.bCV);
            d.c(this, bundle);
        } else if (view == this.bBF) {
            finish();
        } else if (view == this.mBottomPreviewTv && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startHideAnimation() {
        if (this.mIsOpenedList) {
            this.bBL = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0197a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.bBH.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.mIsOpenedList = false;
                    SwanAppAlbumActivity.this.bBL = false;
                    SwanAppAlbumActivity.this.bBG.setVisibility(8);
                    SwanAppAlbumActivity.this.bBH.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.bBD.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void startShowAnimation() {
        if (!this.mIsOpenedList) {
            this.bBG.setVisibility(0);
            this.bBH.setVisibility(0);
            this.bBL = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0197a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.bBH.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.mIsOpenedList = true;
                    SwanAppAlbumActivity.this.bBL = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.bBD.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.baK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.bBC != null) {
                        this.bBC.notifyDataSetChanged();
                    }
                    changeNumberUi();
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
        com.baidu.swan.apps.media.chooser.b.e.clear();
        d.clear();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, a.C0197a.swanapp_album_slide_bottom_out);
    }
}
