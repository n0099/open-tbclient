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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.s;
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
    private ActivityResultDispatcher bGT;
    private GridView ckE;
    private a ckF;
    private TextView ckG;
    private TextView ckH;
    private TextView ckI;
    private RelativeLayout ckJ;
    private TextView ckK;
    private View ckL;
    private View ckM;
    private HeightListView ckN;
    private LoadingLayout ckO;
    private b ckP;
    private boolean ckQ = false;
    private boolean ckR = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> ckS = new ArrayList<>();
    private AdapterView.OnItemClickListener ckT = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.ckQ && !SwanAppAlbumActivity.this.ckR) {
                SwanAppAlbumActivity.this.aiD();
            }
            SwanAppAlbumActivity.this.ckG.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.ckS.get(i)).gU());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.ckS.get(i)).cmz;
            SwanAppAlbumActivity.this.ckF.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.ckJ.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.ckJ.setVisibility(0);
            }
        }
    };

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = aj.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.bGT = new ActivityResultDispatcher(this, 1);
        aj.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ag.Q(this);
        aiz();
        initView();
        initData();
    }

    private void aiz() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = s.safeGetBundleExtra(getIntent(), "launchParams");
            d.clG = s.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = s.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = s.c(safeGetBundleExtra, "isFrontCamera", false);
            d.cmo = s.a(safeGetBundleExtra, "maxDuration", 60);
            d.cmm = s.a(safeGetBundleExtra, "count", 9);
            String safeGetString = s.safeGetString(safeGetBundleExtra, "mode");
            d.ckw = s.c(safeGetBundleExtra, "compressed", true);
            d.cmn = s.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.cmp = s.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.cmm < 1 || d.cmm > 9) {
                d.cmm = 9;
            }
        }
    }

    private void initView() {
        this.ckE = (GridView) findViewById(a.f.album_gridview);
        this.ckG = (TextView) findViewById(a.f.album_name);
        this.ckH = (TextView) findViewById(a.f.album_select_done);
        this.ckI = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.ckJ = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.ckL = findViewById(a.f.album_name_list_layout);
        this.ckM = findViewById(a.f.album_name_list_container);
        this.ckN = (HeightListView) findViewById(a.f.album_name_list);
        this.ckO = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.ckK = (TextView) findViewById(a.f.album_left_cancel);
        this.ckN.setListViewHeight(ag.dip2px(this, 400.0f));
        this.ckG.setOnClickListener(this);
        this.ckK.setOnClickListener(this);
        this.ckH.setOnClickListener(this);
        this.ckI.setOnClickListener(this);
        this.ckL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.ckQ && !SwanAppAlbumActivity.this.ckR) {
                    SwanAppAlbumActivity.this.aiD();
                    return true;
                }
                return true;
            }
        });
        this.ckJ.setVisibility(0);
        this.ckG.setText(d.U(this, d.clG));
    }

    private void initData() {
        if (this.ckP == null || this.ckP.getStatus() != AsyncTask.Status.RUNNING) {
            this.ckO.fA(true);
            this.ckP = new b(d.clG, new com.baidu.swan.apps.media.chooser.c.d() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
                @Override // com.baidu.swan.apps.media.chooser.c.d
                public void a(boolean z, String str, Object obj) {
                    if (c.DEBUG) {
                        Log.d(getClass().getSimpleName(), "LoadAlbumTask onResult : " + z);
                    }
                    if (z && (obj instanceof ArrayList)) {
                        SwanAppAlbumActivity.this.notifyUi(obj);
                    }
                }
            });
            this.ckP.execute(new Void[0]);
        }
    }

    private void aiA() {
        this.ckF = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.ckE.setAdapter((ListAdapter) this.ckF);
        this.ckF.setData(this.ckS.get(0).cmz);
        this.ckF.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void fH(int i) {
                SwanAppAlbumActivity.this.aiC();
            }
        });
    }

    private void aiB() {
        this.ckN.setAdapter((ListAdapter) new com.baidu.swan.apps.media.chooser.adapter.b(this, d.clG, this.ckS));
        this.ckN.setOnItemClickListener(this.ckT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.ckO.fA(false);
        this.ckS = (ArrayList) obj;
        if (this.ckS.size() > 0 && this.ckS.get(0) != null) {
            if (this.ckS.get(0).aiU() == null || this.ckS.get(0).aiU().size() == 0) {
                this.ckJ.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.ckG.setCompoundDrawables(null, null, drawable, null);
            this.ckG.setCompoundDrawablePadding(ag.dip2px(this, 4.0f));
        } else {
            this.ckJ.setVisibility(8);
        }
        this.ckH.setVisibility(0);
        aiC();
        aiB();
        aiA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiC() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.ckH.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.ckI.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.ckH.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.ckH.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.ckI.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.ckH.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ckG) {
            if (this.ckS != null && this.ckS.size() > 1 && !this.ckR) {
                if (this.ckQ) {
                    aiD();
                } else {
                    aiE();
                }
            }
        } else if (view == this.ckH) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.ckw);
            bundle.putString("swanAppId", d.cmn);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aiX());
            bundle.putString("swanTmpPath", d.cmp);
            d.c(this, bundle);
        } else if (view == this.ckK) {
            finish();
        } else if (view == this.ckI && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiD() {
        if (this.ckQ) {
            this.ckR = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0281a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.ckM.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.ckQ = false;
                    SwanAppAlbumActivity.this.ckR = false;
                    SwanAppAlbumActivity.this.ckL.setVisibility(8);
                    SwanAppAlbumActivity.this.ckM.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.ckG.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void aiE() {
        if (!this.ckQ) {
            this.ckL.setVisibility(0);
            this.ckM.setVisibility(0);
            this.ckR = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0281a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.ckM.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.ckQ = true;
                    SwanAppAlbumActivity.this.ckR = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.ckG.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.bGT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.ckF != null) {
                        this.ckF.notifyDataSetChanged();
                    }
                    aiC();
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
        overridePendingTransition(0, a.C0281a.swanapp_album_slide_bottom_out);
    }
}
