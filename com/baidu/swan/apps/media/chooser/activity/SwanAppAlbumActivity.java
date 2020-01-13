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
/* loaded from: classes10.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private ActivityResultDispatcher aWx;
    private HeightListView bxA;
    private LoadingLayout bxB;
    private b bxC;
    private a bxu;
    private TextView bxv;
    private TextView bxw;
    private TextView bxx;
    private View bxy;
    private View bxz;
    private RelativeLayout mBottomPreviewLayout;
    private TextView mBottomPreviewTv;
    private GridView mGridView;
    private boolean mIsOpenedList = false;
    private boolean bxD = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> bxE = new ArrayList<>();
    private AdapterView.OnItemClickListener bxF = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.mIsOpenedList && !SwanAppAlbumActivity.this.bxD) {
                SwanAppAlbumActivity.this.startHideAnimation();
            }
            SwanAppAlbumActivity.this.bxv.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.bxE.get(i)).bw());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.bxE.get(i)).byX;
            SwanAppAlbumActivity.this.bxu.setData(arrayList);
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
        this.aWx = new ActivityResultDispatcher(this, 1);
        ai.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        af.V(this);
        Vb();
        initView();
        initData();
    }

    private void Vb() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = r.safeGetBundleExtra(getIntent(), "launchParams");
            d.byi = r.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = r.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = r.c(safeGetBundleExtra, "isFrontCamera", false);
            d.byM = r.a(safeGetBundleExtra, "maxDuration", 60);
            d.mMaxSelected = r.a(safeGetBundleExtra, "count", 9);
            String safeGetString = r.safeGetString(safeGetBundleExtra, "mode");
            d.bxm = r.c(safeGetBundleExtra, "compressed", true);
            d.byL = r.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.byN = r.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.mMaxSelected < 1 || d.mMaxSelected > 9) {
                d.mMaxSelected = 9;
            }
        }
    }

    private void initView() {
        this.mGridView = (GridView) findViewById(a.f.album_gridview);
        this.bxv = (TextView) findViewById(a.f.album_name);
        this.bxw = (TextView) findViewById(a.f.album_select_done);
        this.mBottomPreviewTv = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.mBottomPreviewLayout = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.bxy = findViewById(a.f.album_name_list_layout);
        this.bxz = findViewById(a.f.album_name_list_container);
        this.bxA = (HeightListView) findViewById(a.f.album_name_list);
        this.bxB = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.bxx = (TextView) findViewById(a.f.album_left_cancel);
        this.bxA.setListViewHeight(af.dip2px(this, 400.0f));
        this.bxv.setOnClickListener(this);
        this.bxx.setOnClickListener(this);
        this.bxw.setOnClickListener(this);
        this.mBottomPreviewTv.setOnClickListener(this);
        this.bxy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.mIsOpenedList && !SwanAppAlbumActivity.this.bxD) {
                    SwanAppAlbumActivity.this.startHideAnimation();
                    return true;
                }
                return true;
            }
        });
        this.mBottomPreviewLayout.setVisibility(0);
        this.bxv.setText(d.am(this, d.byi));
    }

    private void initData() {
        if (this.bxC == null || this.bxC.getStatus() != AsyncTask.Status.RUNNING) {
            this.bxB.showLoading(true);
            this.bxC = new b(d.byi, new com.baidu.swan.apps.media.chooser.c.d() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
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
            this.bxC.execute(new Void[0]);
        }
    }

    private void initImageAdapter() {
        this.bxu = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.mGridView.setAdapter((ListAdapter) this.bxu);
        this.bxu.setData(this.bxE.get(0).byX);
        this.bxu.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void selectChanged(int i) {
                SwanAppAlbumActivity.this.changeNumberUi();
            }
        });
    }

    private void Vc() {
        this.bxA.setAdapter((ListAdapter) new com.baidu.swan.apps.media.chooser.adapter.b(this, d.byi, this.bxE));
        this.bxA.setOnItemClickListener(this.bxF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.bxB.showLoading(false);
        this.bxE = (ArrayList) obj;
        if (this.bxE.size() > 0 && this.bxE.get(0) != null) {
            if (this.bxE.get(0).Vq() == null || this.bxE.get(0).Vq().size() == 0) {
                this.mBottomPreviewLayout.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.bxv.setCompoundDrawables(null, null, drawable, null);
            this.bxv.setCompoundDrawablePadding(af.dip2px(this, 4.0f));
        } else {
            this.mBottomPreviewLayout.setVisibility(8);
        }
        this.bxw.setVisibility(0);
        changeNumberUi();
        Vc();
        initImageAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeNumberUi() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.bxw.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.mBottomPreviewTv.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.bxw.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.bxw.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.mBottomPreviewTv.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.bxw.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bxv) {
            if (this.bxE != null && this.bxE.size() > 1 && !this.bxD) {
                if (this.mIsOpenedList) {
                    startHideAnimation();
                } else {
                    startShowAnimation();
                }
            }
        } else if (view == this.bxw) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.bxm);
            bundle.putString("swanAppId", d.byL);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.Vt());
            bundle.putString("swanTmpPath", d.byN);
            d.c(this, bundle);
        } else if (view == this.bxx) {
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
            this.bxD = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0187a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.bxz.startAnimation(loadAnimation);
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
                    SwanAppAlbumActivity.this.bxD = false;
                    SwanAppAlbumActivity.this.bxy.setVisibility(8);
                    SwanAppAlbumActivity.this.bxz.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.bxv.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void startShowAnimation() {
        if (!this.mIsOpenedList) {
            this.bxy.setVisibility(0);
            this.bxz.setVisibility(0);
            this.bxD = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0187a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.bxz.startAnimation(loadAnimation);
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
                    SwanAppAlbumActivity.this.bxD = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.bxv.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.aWx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.bxu != null) {
                        this.bxu.notifyDataSetChanged();
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
        overridePendingTransition(0, a.C0187a.swanapp_album_slide_bottom_out);
    }
}
