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
/* loaded from: classes9.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private ActivityResultDispatcher aVF;
    private a bwH;
    private TextView bwI;
    private TextView bwJ;
    private TextView bwK;
    private View bwL;
    private View bwM;
    private HeightListView bwN;
    private LoadingLayout bwO;
    private b bwP;
    private RelativeLayout mBottomPreviewLayout;
    private TextView mBottomPreviewTv;
    private GridView mGridView;
    private boolean mIsOpenedList = false;
    private boolean bwQ = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> bwR = new ArrayList<>();
    private AdapterView.OnItemClickListener bwS = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.mIsOpenedList && !SwanAppAlbumActivity.this.bwQ) {
                SwanAppAlbumActivity.this.startHideAnimation();
            }
            SwanAppAlbumActivity.this.bwI.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.bwR.get(i)).bw());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.bwR.get(i)).byk;
            SwanAppAlbumActivity.this.bwH.setData(arrayList);
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
        this.aVF = new ActivityResultDispatcher(this, 1);
        ai.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        af.U(this);
        UE();
        initView();
        initData();
    }

    private void UE() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = r.safeGetBundleExtra(getIntent(), "launchParams");
            d.bxv = r.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = r.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = r.c(safeGetBundleExtra, "isFrontCamera", false);
            d.bxZ = r.a(safeGetBundleExtra, "maxDuration", 60);
            d.mMaxSelected = r.a(safeGetBundleExtra, "count", 9);
            String safeGetString = r.safeGetString(safeGetBundleExtra, "mode");
            d.bwz = r.c(safeGetBundleExtra, "compressed", true);
            d.bxY = r.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.bya = r.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.mMaxSelected < 1 || d.mMaxSelected > 9) {
                d.mMaxSelected = 9;
            }
        }
    }

    private void initView() {
        this.mGridView = (GridView) findViewById(a.f.album_gridview);
        this.bwI = (TextView) findViewById(a.f.album_name);
        this.bwJ = (TextView) findViewById(a.f.album_select_done);
        this.mBottomPreviewTv = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.mBottomPreviewLayout = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.bwL = findViewById(a.f.album_name_list_layout);
        this.bwM = findViewById(a.f.album_name_list_container);
        this.bwN = (HeightListView) findViewById(a.f.album_name_list);
        this.bwO = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.bwK = (TextView) findViewById(a.f.album_left_cancel);
        this.bwN.setListViewHeight(af.dip2px(this, 400.0f));
        this.bwI.setOnClickListener(this);
        this.bwK.setOnClickListener(this);
        this.bwJ.setOnClickListener(this);
        this.mBottomPreviewTv.setOnClickListener(this);
        this.bwL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.mIsOpenedList && !SwanAppAlbumActivity.this.bwQ) {
                    SwanAppAlbumActivity.this.startHideAnimation();
                    return true;
                }
                return true;
            }
        });
        this.mBottomPreviewLayout.setVisibility(0);
        this.bwI.setText(d.ak(this, d.bxv));
    }

    private void initData() {
        if (this.bwP == null || this.bwP.getStatus() != AsyncTask.Status.RUNNING) {
            this.bwO.showLoading(true);
            this.bwP = new b(d.bxv, new com.baidu.swan.apps.media.chooser.c.d() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
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
            this.bwP.execute(new Void[0]);
        }
    }

    private void initImageAdapter() {
        this.bwH = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.mGridView.setAdapter((ListAdapter) this.bwH);
        this.bwH.setData(this.bwR.get(0).byk);
        this.bwH.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void selectChanged(int i) {
                SwanAppAlbumActivity.this.changeNumberUi();
            }
        });
    }

    private void UF() {
        this.bwN.setAdapter((ListAdapter) new com.baidu.swan.apps.media.chooser.adapter.b(this, d.bxv, this.bwR));
        this.bwN.setOnItemClickListener(this.bwS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.bwO.showLoading(false);
        this.bwR = (ArrayList) obj;
        if (this.bwR.size() > 0 && this.bwR.get(0) != null) {
            if (this.bwR.get(0).UT() == null || this.bwR.get(0).UT().size() == 0) {
                this.mBottomPreviewLayout.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.bwI.setCompoundDrawables(null, null, drawable, null);
            this.bwI.setCompoundDrawablePadding(af.dip2px(this, 4.0f));
        } else {
            this.mBottomPreviewLayout.setVisibility(8);
        }
        this.bwJ.setVisibility(0);
        changeNumberUi();
        UF();
        initImageAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeNumberUi() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.bwJ.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.mBottomPreviewTv.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.bwJ.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.bwJ.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.mBottomPreviewTv.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.bwJ.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bwI) {
            if (this.bwR != null && this.bwR.size() > 1 && !this.bwQ) {
                if (this.mIsOpenedList) {
                    startHideAnimation();
                } else {
                    startShowAnimation();
                }
            }
        } else if (view == this.bwJ) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.bwz);
            bundle.putString("swanAppId", d.bxY);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.UW());
            bundle.putString("swanTmpPath", d.bya);
            d.c(this, bundle);
        } else if (view == this.bwK) {
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
            this.bwQ = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0185a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.bwM.startAnimation(loadAnimation);
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
                    SwanAppAlbumActivity.this.bwQ = false;
                    SwanAppAlbumActivity.this.bwL.setVisibility(8);
                    SwanAppAlbumActivity.this.bwM.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.bwI.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void startShowAnimation() {
        if (!this.mIsOpenedList) {
            this.bwL.setVisibility(0);
            this.bwM.setVisibility(0);
            this.bwQ = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0185a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.bwM.startAnimation(loadAnimation);
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
                    SwanAppAlbumActivity.this.bwQ = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.bwI.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.aVF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.bwH != null) {
                        this.bwH.notifyDataSetChanged();
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
        overridePendingTransition(0, a.C0185a.swanapp_album_slide_bottom_out);
    }
}
