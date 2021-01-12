package com.baidu.swan.apps.media.chooser.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import androidx.annotation.NonNull;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.media.chooser.adapter.b;
import com.baidu.swan.apps.media.chooser.b.d;
import com.baidu.swan.apps.media.chooser.listener.e;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.view.HeightListView;
import com.baidu.swan.apps.view.LoadingLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private ActivityResultDispatcher czA;
    private GridView dhj;
    private com.baidu.swan.apps.media.chooser.adapter.a dhk;
    private TextView dhl;
    private TextView dhm;
    private TextView dhn;
    private RelativeLayout dho;
    private TextView dhp;
    private View dhq;
    private View dhr;
    private HeightListView dhs;
    private LoadingLayout dht;
    private boolean dhu = false;
    private boolean dhv = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> dhw = new ArrayList<>();
    private AdapterView.OnItemClickListener dhx = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.dhu && !SwanAppAlbumActivity.this.dhv) {
                SwanAppAlbumActivity.this.aAB();
            }
            SwanAppAlbumActivity.this.dhl.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.dhw.get(i)).il());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.dhw.get(i)).djg;
            SwanAppAlbumActivity.this.dhk.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.dho.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.dho.setVisibility(0);
            }
        }
    };
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.czA = new ActivityResultDispatcher(this, 1);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ah.T(this);
        aAx();
        initView();
        initData();
    }

    private void aAx() {
        if (getIntent() != null) {
            Bundle b2 = u.b(getIntent(), "launchParams");
            d.dcp = u.h(b2, "launchType");
            d.diV = u.c(b2, "isShowCamera", true);
            d.mIsFrontCamera = u.c(b2, "isFrontCamera", false);
            d.diU = u.a(b2, "maxDuration", 60);
            d.diS = u.a(b2, "count", 9);
            String h = u.h(b2, UbcStatConstant.KEY_CONTENT_EXT_MODE);
            d.dhb = u.c(b2, "compressed", true);
            d.diT = u.h(b2, "swanAppId");
            if (!TextUtils.isEmpty(h)) {
                d.mMode = h;
            }
            d.diW = u.h(b2, "swanTmpPath");
            if (d.diS < 1 || d.diS > 9) {
                d.diS = 9;
            }
        }
    }

    private void initView() {
        this.dhj = (GridView) findViewById(a.f.album_gridview);
        this.dhl = (TextView) findViewById(a.f.album_name);
        this.dhm = (TextView) findViewById(a.f.album_select_done);
        this.dhn = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.dho = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.dhq = findViewById(a.f.album_name_list_layout);
        this.dhr = findViewById(a.f.album_name_list_container);
        this.dhs = (HeightListView) findViewById(a.f.album_name_list);
        this.dht = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.dhp = (TextView) findViewById(a.f.album_left_cancel);
        this.dhs.setListViewHeight(ah.dip2px(this, 400.0f));
        this.dhl.setOnClickListener(this);
        this.dhp.setOnClickListener(this);
        this.dhm.setOnClickListener(this);
        this.dhn.setOnClickListener(this);
        this.dhq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.dhu && !SwanAppAlbumActivity.this.dhv) {
                    SwanAppAlbumActivity.this.aAB();
                    return true;
                }
                return true;
            }
        });
        this.dho.setVisibility(0);
        this.dhl.setText(d.ak(this, d.dcp));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.dht.hE(true);
        p.b(new com.baidu.swan.apps.media.chooser.c.a(d.dcp, this.mHandler), "loadAlbumTask");
    }

    private void aAy() {
        this.dhk = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.dhj.setAdapter((ListAdapter) this.dhk);
        this.dhk.setData(this.dhw.get(0).djg);
        this.dhk.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.listener.e
            public void hT(int i) {
                SwanAppAlbumActivity.this.aAA();
            }
        });
    }

    private void aAz() {
        this.dhs.setAdapter((ListAdapter) new b(this, d.dcp, this.dhw));
        this.dhs.setOnItemClickListener(this.dhx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.dht.hE(false);
        this.dhw = (ArrayList) obj;
        if (this.dhw.size() > 0 && this.dhw.get(0) != null) {
            if (this.dhw.get(0).aAS() == null || this.dhw.get(0).aAS().size() == 0) {
                this.dho.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.dhl.setCompoundDrawables(null, null, drawable, null);
            this.dhl.setCompoundDrawablePadding(ah.dip2px(this, 4.0f));
        } else {
            this.dho.setVisibility(8);
        }
        this.dhm.setVisibility(0);
        aAA();
        aAz();
        aAy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAA() {
        if (com.baidu.swan.apps.media.chooser.b.e.aAW() > 0) {
            this.dhm.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.dhn.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.dhm.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.aAW())));
            return;
        }
        this.dhm.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.dhn.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.dhm.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dhl) {
            if (this.dhw != null && this.dhw.size() > 1 && !this.dhv) {
                if (this.dhu) {
                    aAB();
                } else {
                    aAC();
                }
            }
        } else if (view == this.dhm) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.dhb);
            bundle.putString("swanAppId", d.diT);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aAV());
            bundle.putString("swanTmpPath", d.diW);
            d.c(this, bundle);
        } else if (view == this.dhp) {
            finish();
        } else if (view == this.dhn && com.baidu.swan.apps.media.chooser.b.e.aAW() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAB() {
        if (this.dhu) {
            this.dhv = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0355a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.dhr.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.dhu = false;
                    SwanAppAlbumActivity.this.dhv = false;
                    SwanAppAlbumActivity.this.dhq.setVisibility(8);
                    SwanAppAlbumActivity.this.dhr.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.dhl.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void aAC() {
        if (!this.dhu) {
            this.dhq.setVisibility(0);
            this.dhr.setVisibility(0);
            this.dhv = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0355a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.dhr.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.dhu = true;
                    SwanAppAlbumActivity.this.dhv = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.dhl.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.czA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.dhk != null) {
                        this.dhk.notifyDataSetChanged();
                    }
                    aAA();
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
        overridePendingTransition(0, a.C0355a.swanapp_album_slide_bottom_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
