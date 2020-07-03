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
import com.baidu.swan.apps.media.chooser.b.c;
import com.baidu.swan.apps.media.chooser.b.d;
import com.baidu.swan.apps.media.chooser.c.e;
import com.baidu.swan.apps.media.chooser.d.b;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.a;
import com.baidu.swan.apps.view.HeightListView;
import com.baidu.swan.apps.view.LoadingLayout;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private ActivityResultDispatcher bLH;
    private TextView cpA;
    private View cpB;
    private View cpC;
    private HeightListView cpD;
    private LoadingLayout cpE;
    private b cpF;
    private boolean cpG = false;
    private boolean cpH = false;
    private ArrayList<a> cpI = new ArrayList<>();
    private AdapterView.OnItemClickListener cpJ = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.cpG && !SwanAppAlbumActivity.this.cpH) {
                SwanAppAlbumActivity.this.ajJ();
            }
            SwanAppAlbumActivity.this.cpw.setText(((a) SwanAppAlbumActivity.this.cpI.get(i)).hk());
            ArrayList<MediaModel> arrayList = ((a) SwanAppAlbumActivity.this.cpI.get(i)).crn;
            SwanAppAlbumActivity.this.cpv.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.cpz.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.cpz.setVisibility(0);
            }
        }
    };
    private GridView cpt;
    private com.baidu.swan.apps.media.chooser.adapter.a cpv;
    private TextView cpw;
    private TextView cpx;
    private TextView cpy;
    private RelativeLayout cpz;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = aj.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.bLH = new ActivityResultDispatcher(this, 1);
        aj.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ag.Q(this);
        ajF();
        initView();
        initData();
    }

    private void ajF() {
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = s.safeGetBundleExtra(getIntent(), "launchParams");
            d.cqu = s.safeGetString(safeGetBundleExtra, "launchType");
            d.mIsShowCamera = s.c(safeGetBundleExtra, "isShowCamera", true);
            d.mIsFrontCamera = s.c(safeGetBundleExtra, "isFrontCamera", false);
            d.crb = s.a(safeGetBundleExtra, "maxDuration", 60);
            d.cqZ = s.a(safeGetBundleExtra, "count", 9);
            String safeGetString = s.safeGetString(safeGetBundleExtra, "mode");
            d.cpl = s.c(safeGetBundleExtra, "compressed", true);
            d.cra = s.safeGetString(safeGetBundleExtra, "swanAppId");
            if (!TextUtils.isEmpty(safeGetString)) {
                d.mMode = safeGetString;
            }
            d.crd = s.safeGetString(safeGetBundleExtra, "swanTmpPath");
            if (d.cqZ < 1 || d.cqZ > 9) {
                d.cqZ = 9;
            }
        }
    }

    private void initView() {
        this.cpt = (GridView) findViewById(a.f.album_gridview);
        this.cpw = (TextView) findViewById(a.f.album_name);
        this.cpx = (TextView) findViewById(a.f.album_select_done);
        this.cpy = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.cpz = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.cpB = findViewById(a.f.album_name_list_layout);
        this.cpC = findViewById(a.f.album_name_list_container);
        this.cpD = (HeightListView) findViewById(a.f.album_name_list);
        this.cpE = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.cpA = (TextView) findViewById(a.f.album_left_cancel);
        this.cpD.setListViewHeight(ag.dip2px(this, 400.0f));
        this.cpw.setOnClickListener(this);
        this.cpA.setOnClickListener(this);
        this.cpx.setOnClickListener(this);
        this.cpy.setOnClickListener(this);
        this.cpB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.cpG && !SwanAppAlbumActivity.this.cpH) {
                    SwanAppAlbumActivity.this.ajJ();
                    return true;
                }
                return true;
            }
        });
        this.cpz.setVisibility(0);
        this.cpw.setText(d.U(this, d.cqu));
    }

    private void initData() {
        if (this.cpF == null || this.cpF.getStatus() != AsyncTask.Status.RUNNING) {
            this.cpE.fF(true);
            this.cpF = new b(d.cqu, new com.baidu.swan.apps.media.chooser.c.d() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
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
            this.cpF.execute(new Void[0]);
        }
    }

    private void ajG() {
        this.cpv = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.cpt.setAdapter((ListAdapter) this.cpv);
        this.cpv.setData(this.cpI.get(0).crn);
        this.cpv.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
            @Override // com.baidu.swan.apps.media.chooser.c.e
            public void fU(int i) {
                SwanAppAlbumActivity.this.ajI();
            }
        });
    }

    private void ajH() {
        this.cpD.setAdapter((ListAdapter) new com.baidu.swan.apps.media.chooser.adapter.b(this, d.cqu, this.cpI));
        this.cpD.setOnItemClickListener(this.cpJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.cpE.fF(false);
        this.cpI = (ArrayList) obj;
        if (this.cpI.size() > 0 && this.cpI.get(0) != null) {
            if (this.cpI.get(0).aka() == null || this.cpI.get(0).aka().size() == 0) {
                this.cpz.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.cpw.setCompoundDrawables(null, null, drawable, null);
            this.cpw.setCompoundDrawablePadding(ag.dip2px(this, 4.0f));
        } else {
            this.cpz.setVisibility(8);
        }
        this.cpx.setVisibility(0);
        ajI();
        ajH();
        ajG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajI() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            this.cpx.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.cpy.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.cpx.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.getSelectedCount())));
            return;
        }
        this.cpx.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.cpy.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.cpx.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cpw) {
            if (this.cpI != null && this.cpI.size() > 1 && !this.cpH) {
                if (this.cpG) {
                    ajJ();
                } else {
                    ajK();
                }
            }
        } else if (view == this.cpx) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.cpl);
            bundle.putString("swanAppId", d.cra);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.akd());
            bundle.putString("swanTmpPath", d.crd);
            d.c(this, bundle);
        } else if (view == this.cpA) {
            finish();
        } else if (view == this.cpy && com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajJ() {
        if (this.cpG) {
            this.cpH = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0287a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.cpC.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.cpG = false;
                    SwanAppAlbumActivity.this.cpH = false;
                    SwanAppAlbumActivity.this.cpB.setVisibility(8);
                    SwanAppAlbumActivity.this.cpC.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.cpw.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void ajK() {
        if (!this.cpG) {
            this.cpB.setVisibility(0);
            this.cpC.setVisibility(0);
            this.cpH = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0287a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.cpC.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.cpG = true;
                    SwanAppAlbumActivity.this.cpH = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.cpw.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.bLH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.cpv != null) {
                        this.cpv.notifyDataSetChanged();
                    }
                    ajI();
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
        overridePendingTransition(0, a.C0287a.swanapp_album_slide_bottom_out);
    }
}
