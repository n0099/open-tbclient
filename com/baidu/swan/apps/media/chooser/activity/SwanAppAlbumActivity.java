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
    private a bBO;
    private TextView bBP;
    private TextView bBQ;
    private TextView bBR;
    private View bBS;
    private View bBT;
    private HeightListView bBU;
    private LoadingLayout bBV;
    private b bBW;
    private ActivityResultDispatcher baY;
    private RelativeLayout mBottomPreviewLayout;
    private TextView mBottomPreviewTv;
    private GridView mGridView;
    private boolean mIsOpenedList = false;
    private boolean bBX = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> bBY = new ArrayList<>();
    private AdapterView.OnItemClickListener bBZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.mIsOpenedList && !SwanAppAlbumActivity.this.bBX) {
                SwanAppAlbumActivity.this.startHideAnimation();
            }
            SwanAppAlbumActivity.this.bBP.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.bBY.get(i)).bx());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.bBY.get(i)).bDr;
            SwanAppAlbumActivity.this.bBO.setData(arrayList);
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
        this.baY = new ActivityResultDispatcher(this, 1);
        ai.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        af.W(this);
        Xu();
        initView();
        initData();
    }

    private void Xu() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = r.safeGetBundleExtra(getIntent(), "launchParams");
            d.bCC = r.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = r.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = r.c(safeGetBundleExtra, "isFrontCamera", false);
            d.bDg = r.a(safeGetBundleExtra, "maxDuration", 60);
            d.mMaxSelected = r.a(safeGetBundleExtra, "count", 9);
            String safeGetString = r.safeGetString(safeGetBundleExtra, "mode");
            d.bBG = r.c(safeGetBundleExtra, "compressed", true);
            d.bDf = r.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.bDh = r.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.mMaxSelected < 1 || d.mMaxSelected > 9) {
                d.mMaxSelected = 9;
            }
        }
    }

    private void initView() {
        this.mGridView = (GridView) findViewById(a.f.album_gridview);
        this.bBP = (TextView) findViewById(a.f.album_name);
        this.bBQ = (TextView) findViewById(a.f.album_select_done);
        this.mBottomPreviewTv = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.mBottomPreviewLayout = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.bBS = findViewById(a.f.album_name_list_layout);
        this.bBT = findViewById(a.f.album_name_list_container);
        this.bBU = (HeightListView) findViewById(a.f.album_name_list);
        this.bBV = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.bBR = (TextView) findViewById(a.f.album_left_cancel);
        this.bBU.setListViewHeight(af.dip2px(this, 400.0f));
        this.bBP.setOnClickListener(this);
        this.bBR.setOnClickListener(this);
        this.bBQ.setOnClickListener(this);
        this.mBottomPreviewTv.setOnClickListener(this);
        this.bBS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.mIsOpenedList && !SwanAppAlbumActivity.this.bBX) {
                    SwanAppAlbumActivity.this.startHideAnimation();
                    return true;
                }
                return true;
            }
        });
        this.mBottomPreviewLayout.setVisibility(0);
        this.bBP.setText(d.am(this, d.bCC));
    }

    private void initData() {
        if (this.bBW == null || this.bBW.getStatus() != AsyncTask.Status.RUNNING) {
            this.bBV.showLoading(true);
            this.bBW = new b(d.bCC, new com.baidu.swan.apps.media.chooser.c.d() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
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
            this.bBW.execute(new Void[0]);
        }
    }

    private void initImageAdapter() {
        this.bBO = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.mGridView.setAdapter((ListAdapter) this.bBO);
        this.bBO.setData(this.bBY.get(0).bDr);
        this.bBO.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void selectChanged(int i) {
                SwanAppAlbumActivity.this.changeNumberUi();
            }
        });
    }

    private void Xv() {
        this.bBU.setAdapter((ListAdapter) new com.baidu.swan.apps.media.chooser.adapter.b(this, d.bCC, this.bBY));
        this.bBU.setOnItemClickListener(this.bBZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.bBV.showLoading(false);
        this.bBY = (ArrayList) obj;
        if (this.bBY.size() > 0 && this.bBY.get(0) != null) {
            if (this.bBY.get(0).XJ() == null || this.bBY.get(0).XJ().size() == 0) {
                this.mBottomPreviewLayout.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.bBP.setCompoundDrawables(null, null, drawable, null);
            this.bBP.setCompoundDrawablePadding(af.dip2px(this, 4.0f));
        } else {
            this.mBottomPreviewLayout.setVisibility(8);
        }
        this.bBQ.setVisibility(0);
        changeNumberUi();
        Xv();
        initImageAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeNumberUi() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.bBQ.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.mBottomPreviewTv.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.bBQ.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.bBQ.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.mBottomPreviewTv.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.bBQ.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bBP) {
            if (this.bBY != null && this.bBY.size() > 1 && !this.bBX) {
                if (this.mIsOpenedList) {
                    startHideAnimation();
                } else {
                    startShowAnimation();
                }
            }
        } else if (view == this.bBQ) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.bBG);
            bundle.putString("swanAppId", d.bDf);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.XM());
            bundle.putString("swanTmpPath", d.bDh);
            d.c(this, bundle);
        } else if (view == this.bBR) {
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
            this.bBX = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0197a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.bBT.startAnimation(loadAnimation);
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
                    SwanAppAlbumActivity.this.bBX = false;
                    SwanAppAlbumActivity.this.bBS.setVisibility(8);
                    SwanAppAlbumActivity.this.bBT.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.bBP.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void startShowAnimation() {
        if (!this.mIsOpenedList) {
            this.bBS.setVisibility(0);
            this.bBT.setVisibility(0);
            this.bBX = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0197a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.bBT.startAnimation(loadAnimation);
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
                    SwanAppAlbumActivity.this.bBX = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.bBP.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.baY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.bBO != null) {
                        this.bBO.notifyDataSetChanged();
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
