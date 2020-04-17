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
    private GridView bZV;
    private a bZW;
    private TextView bZX;
    private TextView bZY;
    private TextView bZZ;
    private ActivityResultDispatcher bzm;
    private RelativeLayout caa;
    private TextView cab;
    private View cac;
    private View cad;
    private HeightListView cae;
    private LoadingLayout caf;
    private b cag;
    private boolean cah = false;
    private boolean cai = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> caj = new ArrayList<>();
    private AdapterView.OnItemClickListener cak = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.cah && !SwanAppAlbumActivity.this.cai) {
                SwanAppAlbumActivity.this.afp();
            }
            SwanAppAlbumActivity.this.bZX.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.caj.get(i)).gU());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.caj.get(i)).cbP;
            SwanAppAlbumActivity.this.bZW.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.caa.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.caa.setVisibility(0);
            }
        }
    };

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.bzm = new ActivityResultDispatcher(this, 1);
        ai.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        af.S(this);
        afl();
        initView();
        initData();
    }

    private void afl() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = r.safeGetBundleExtra(getIntent(), "launchParams");
            d.caX = r.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = r.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = r.c(safeGetBundleExtra, "isFrontCamera", false);
            d.cbE = r.a(safeGetBundleExtra, "maxDuration", 60);
            d.cbC = r.a(safeGetBundleExtra, "count", 9);
            String safeGetString = r.safeGetString(safeGetBundleExtra, "mode");
            d.bZN = r.c(safeGetBundleExtra, "compressed", true);
            d.cbD = r.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.cbF = r.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.cbC < 1 || d.cbC > 9) {
                d.cbC = 9;
            }
        }
    }

    private void initView() {
        this.bZV = (GridView) findViewById(a.f.album_gridview);
        this.bZX = (TextView) findViewById(a.f.album_name);
        this.bZY = (TextView) findViewById(a.f.album_select_done);
        this.bZZ = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.caa = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.cac = findViewById(a.f.album_name_list_layout);
        this.cad = findViewById(a.f.album_name_list_container);
        this.cae = (HeightListView) findViewById(a.f.album_name_list);
        this.caf = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.cab = (TextView) findViewById(a.f.album_left_cancel);
        this.cae.setListViewHeight(af.dip2px(this, 400.0f));
        this.bZX.setOnClickListener(this);
        this.cab.setOnClickListener(this);
        this.bZY.setOnClickListener(this);
        this.bZZ.setOnClickListener(this);
        this.cac.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.cah && !SwanAppAlbumActivity.this.cai) {
                    SwanAppAlbumActivity.this.afp();
                    return true;
                }
                return true;
            }
        });
        this.caa.setVisibility(0);
        this.bZX.setText(d.ag(this, d.caX));
    }

    private void initData() {
        if (this.cag == null || this.cag.getStatus() != AsyncTask.Status.RUNNING) {
            this.caf.ff(true);
            this.cag = new b(d.caX, new com.baidu.swan.apps.media.chooser.c.d() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
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
            this.cag.execute(new Void[0]);
        }
    }

    private void afm() {
        this.bZW = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.bZV.setAdapter((ListAdapter) this.bZW);
        this.bZW.setData(this.caj.get(0).cbP);
        this.bZW.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void ft(int i) {
                SwanAppAlbumActivity.this.afo();
            }
        });
    }

    private void afn() {
        this.cae.setAdapter((ListAdapter) new com.baidu.swan.apps.media.chooser.adapter.b(this, d.caX, this.caj));
        this.cae.setOnItemClickListener(this.cak);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.caf.ff(false);
        this.caj = (ArrayList) obj;
        if (this.caj.size() > 0 && this.caj.get(0) != null) {
            if (this.caj.get(0).afG() == null || this.caj.get(0).afG().size() == 0) {
                this.caa.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.bZX.setCompoundDrawables(null, null, drawable, null);
            this.bZX.setCompoundDrawablePadding(af.dip2px(this, 4.0f));
        } else {
            this.caa.setVisibility(8);
        }
        this.bZY.setVisibility(0);
        afo();
        afn();
        afm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afo() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.bZY.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.bZZ.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.bZY.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.bZY.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.bZZ.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.bZY.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bZX) {
            if (this.caj != null && this.caj.size() > 1 && !this.cai) {
                if (this.cah) {
                    afp();
                } else {
                    afq();
                }
            }
        } else if (view == this.bZY) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.bZN);
            bundle.putString("swanAppId", d.cbD);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.afJ());
            bundle.putString("swanTmpPath", d.cbF);
            d.c(this, bundle);
        } else if (view == this.cab) {
            finish();
        } else if (view == this.bZZ && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afp() {
        if (this.cah) {
            this.cai = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0227a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.cad.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.cah = false;
                    SwanAppAlbumActivity.this.cai = false;
                    SwanAppAlbumActivity.this.cac.setVisibility(8);
                    SwanAppAlbumActivity.this.cad.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.bZX.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void afq() {
        if (!this.cah) {
            this.cac.setVisibility(0);
            this.cad.setVisibility(0);
            this.cai = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0227a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.cad.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.cah = true;
                    SwanAppAlbumActivity.this.cai = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.bZX.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.bzm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.bZW != null) {
                        this.bZW.notifyDataSetChanged();
                    }
                    afo();
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
        overridePendingTransition(0, a.C0227a.swanapp_album_slide_bottom_out);
    }
}
