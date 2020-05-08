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
    private ActivityResultDispatcher bzr;
    private GridView cab;
    private a cac;
    private TextView cad;
    private TextView cae;
    private TextView caf;
    private RelativeLayout cag;
    private TextView cah;
    private View cai;
    private View caj;
    private HeightListView cak;
    private LoadingLayout cal;
    private b cam;
    private boolean can = false;
    private boolean cao = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> cap = new ArrayList<>();
    private AdapterView.OnItemClickListener caq = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.can && !SwanAppAlbumActivity.this.cao) {
                SwanAppAlbumActivity.this.afo();
            }
            SwanAppAlbumActivity.this.cad.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.cap.get(i)).gU());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.cap.get(i)).cbV;
            SwanAppAlbumActivity.this.cac.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.cag.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.cag.setVisibility(0);
            }
        }
    };

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.bzr = new ActivityResultDispatcher(this, 1);
        ai.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        af.S(this);
        afk();
        initView();
        initData();
    }

    private void afk() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = r.safeGetBundleExtra(getIntent(), "launchParams");
            d.cbd = r.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = r.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = r.c(safeGetBundleExtra, "isFrontCamera", false);
            d.cbK = r.a(safeGetBundleExtra, "maxDuration", 60);
            d.cbI = r.a(safeGetBundleExtra, "count", 9);
            String safeGetString = r.safeGetString(safeGetBundleExtra, "mode");
            d.bZT = r.c(safeGetBundleExtra, "compressed", true);
            d.cbJ = r.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.cbL = r.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.cbI < 1 || d.cbI > 9) {
                d.cbI = 9;
            }
        }
    }

    private void initView() {
        this.cab = (GridView) findViewById(a.f.album_gridview);
        this.cad = (TextView) findViewById(a.f.album_name);
        this.cae = (TextView) findViewById(a.f.album_select_done);
        this.caf = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.cag = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.cai = findViewById(a.f.album_name_list_layout);
        this.caj = findViewById(a.f.album_name_list_container);
        this.cak = (HeightListView) findViewById(a.f.album_name_list);
        this.cal = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.cah = (TextView) findViewById(a.f.album_left_cancel);
        this.cak.setListViewHeight(af.dip2px(this, 400.0f));
        this.cad.setOnClickListener(this);
        this.cah.setOnClickListener(this);
        this.cae.setOnClickListener(this);
        this.caf.setOnClickListener(this);
        this.cai.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.can && !SwanAppAlbumActivity.this.cao) {
                    SwanAppAlbumActivity.this.afo();
                    return true;
                }
                return true;
            }
        });
        this.cag.setVisibility(0);
        this.cad.setText(d.U(this, d.cbd));
    }

    private void initData() {
        if (this.cam == null || this.cam.getStatus() != AsyncTask.Status.RUNNING) {
            this.cal.ff(true);
            this.cam = new b(d.cbd, new com.baidu.swan.apps.media.chooser.c.d() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
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
            this.cam.execute(new Void[0]);
        }
    }

    private void afl() {
        this.cac = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.cab.setAdapter((ListAdapter) this.cac);
        this.cac.setData(this.cap.get(0).cbV);
        this.cac.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void ft(int i) {
                SwanAppAlbumActivity.this.afn();
            }
        });
    }

    private void afm() {
        this.cak.setAdapter((ListAdapter) new com.baidu.swan.apps.media.chooser.adapter.b(this, d.cbd, this.cap));
        this.cak.setOnItemClickListener(this.caq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.cal.ff(false);
        this.cap = (ArrayList) obj;
        if (this.cap.size() > 0 && this.cap.get(0) != null) {
            if (this.cap.get(0).afF() == null || this.cap.get(0).afF().size() == 0) {
                this.cag.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.cad.setCompoundDrawables(null, null, drawable, null);
            this.cad.setCompoundDrawablePadding(af.dip2px(this, 4.0f));
        } else {
            this.cag.setVisibility(8);
        }
        this.cae.setVisibility(0);
        afn();
        afm();
        afl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afn() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.cae.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.caf.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.cae.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.cae.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.caf.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.cae.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cad) {
            if (this.cap != null && this.cap.size() > 1 && !this.cao) {
                if (this.can) {
                    afo();
                } else {
                    afp();
                }
            }
        } else if (view == this.cae) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.bZT);
            bundle.putString("swanAppId", d.cbJ);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.afI());
            bundle.putString("swanTmpPath", d.cbL);
            d.c(this, bundle);
        } else if (view == this.cah) {
            finish();
        } else if (view == this.caf && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afo() {
        if (this.can) {
            this.cao = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0248a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.caj.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.can = false;
                    SwanAppAlbumActivity.this.cao = false;
                    SwanAppAlbumActivity.this.cai.setVisibility(8);
                    SwanAppAlbumActivity.this.caj.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.cad.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void afp() {
        if (!this.can) {
            this.cai.setVisibility(0);
            this.caj.setVisibility(0);
            this.cao = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0248a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.caj.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.can = true;
                    SwanAppAlbumActivity.this.cao = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.cad.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.bzr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.cac != null) {
                        this.cac.notifyDataSetChanged();
                    }
                    afn();
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
        overridePendingTransition(0, a.C0248a.swanapp_album_slide_bottom_out);
    }
}
