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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.aq.u;
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
    private ActivityResultDispatcher bMd;
    private com.baidu.swan.apps.media.chooser.adapter.a crA;
    private TextView crB;
    private TextView crC;
    private TextView crD;
    private RelativeLayout crE;
    private TextView crF;
    private View crG;
    private View crH;
    private HeightListView crI;
    private LoadingLayout crJ;
    private boolean crK = false;
    private boolean crL = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> crM = new ArrayList<>();
    private AdapterView.OnItemClickListener crN = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.crK && !SwanAppAlbumActivity.this.crL) {
                SwanAppAlbumActivity.this.akZ();
            }
            SwanAppAlbumActivity.this.crB.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.crM.get(i)).hk());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.crM.get(i)).ctq;
            SwanAppAlbumActivity.this.crA.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.crE.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.crE.setVisibility(0);
            }
        }
    };
    private GridView crz;
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = al.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.bMd = new ActivityResultDispatcher(this, 1);
        al.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ai.R(this);
        akV();
        initView();
        initData();
    }

    private void akV() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            d.csy = u.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = u.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = u.c(safeGetBundleExtra, "isFrontCamera", false);
            d.ctf = u.a(safeGetBundleExtra, "maxDuration", 60);
            d.ctd = u.a(safeGetBundleExtra, "count", 9);
            String safeGetString = u.safeGetString(safeGetBundleExtra, "mode");
            d.crr = u.c(safeGetBundleExtra, "compressed", true);
            d.cte = u.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.ctg = u.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.ctd < 1 || d.ctd > 9) {
                d.ctd = 9;
            }
        }
    }

    private void initView() {
        this.crz = (GridView) findViewById(a.f.album_gridview);
        this.crB = (TextView) findViewById(a.f.album_name);
        this.crC = (TextView) findViewById(a.f.album_select_done);
        this.crD = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.crE = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.crG = findViewById(a.f.album_name_list_layout);
        this.crH = findViewById(a.f.album_name_list_container);
        this.crI = (HeightListView) findViewById(a.f.album_name_list);
        this.crJ = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.crF = (TextView) findViewById(a.f.album_left_cancel);
        this.crI.setListViewHeight(ai.dip2px(this, 400.0f));
        this.crB.setOnClickListener(this);
        this.crF.setOnClickListener(this);
        this.crC.setOnClickListener(this);
        this.crD.setOnClickListener(this);
        this.crG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.crK && !SwanAppAlbumActivity.this.crL) {
                    SwanAppAlbumActivity.this.akZ();
                    return true;
                }
                return true;
            }
        });
        this.crE.setVisibility(0);
        this.crB.setText(d.U(this, d.csy));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.crJ.fO(true);
        p.postOnComputation(new com.baidu.swan.apps.media.chooser.d.a(d.csy, this.mHandler), "loadAlbumTask");
    }

    private void akW() {
        this.crA = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.crz.setAdapter((ListAdapter) this.crA);
        this.crA.setData(this.crM.get(0).ctq);
        this.crA.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void ge(int i) {
                SwanAppAlbumActivity.this.akY();
            }
        });
    }

    private void akX() {
        this.crI.setAdapter((ListAdapter) new b(this, d.csy, this.crM));
        this.crI.setOnItemClickListener(this.crN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.crJ.fO(false);
        this.crM = (ArrayList) obj;
        if (this.crM.size() > 0 && this.crM.get(0) != null) {
            if (this.crM.get(0).alq() == null || this.crM.get(0).alq().size() == 0) {
                this.crE.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.crB.setCompoundDrawables(null, null, drawable, null);
            this.crB.setCompoundDrawablePadding(ai.dip2px(this, 4.0f));
        } else {
            this.crE.setVisibility(8);
        }
        this.crC.setVisibility(0);
        akY();
        akX();
        akW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.crC.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.crD.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.crC.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.crC.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.crD.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.crC.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.crB) {
            if (this.crM != null && this.crM.size() > 1 && !this.crL) {
                if (this.crK) {
                    akZ();
                } else {
                    ala();
                }
            }
        } else if (view == this.crC) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.crr);
            bundle.putString("swanAppId", d.cte);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.alt());
            bundle.putString("swanTmpPath", d.ctg);
            d.c(this, bundle);
        } else if (view == this.crF) {
            finish();
        } else if (view == this.crD && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akZ() {
        if (this.crK) {
            this.crL = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0290a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.crH.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.crK = false;
                    SwanAppAlbumActivity.this.crL = false;
                    SwanAppAlbumActivity.this.crG.setVisibility(8);
                    SwanAppAlbumActivity.this.crH.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.crB.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void ala() {
        if (!this.crK) {
            this.crG.setVisibility(0);
            this.crH.setVisibility(0);
            this.crL = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0290a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.crH.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.crK = true;
                    SwanAppAlbumActivity.this.crL = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.crB.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.bMd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.crA != null) {
                        this.crA.notifyDataSetChanged();
                    }
                    akY();
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
        overridePendingTransition(0, a.C0290a.swanapp_album_slide_bottom_out);
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
