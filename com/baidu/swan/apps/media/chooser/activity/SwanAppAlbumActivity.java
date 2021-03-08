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
    private ActivityResultDispatcher cDw;
    private GridView dkY;
    private com.baidu.swan.apps.media.chooser.adapter.a dkZ;
    private TextView dla;
    private TextView dlb;
    private TextView dlc;
    private RelativeLayout dld;
    private TextView dle;
    private View dlf;
    private View dlg;
    private HeightListView dlh;
    private LoadingLayout dli;
    private boolean dlj = false;
    private boolean dlk = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> dll = new ArrayList<>();
    private AdapterView.OnItemClickListener dlm = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.dlj && !SwanAppAlbumActivity.this.dlk) {
                SwanAppAlbumActivity.this.aBc();
            }
            SwanAppAlbumActivity.this.dla.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.dll.get(i)).ik());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.dll.get(i)).dmS;
            SwanAppAlbumActivity.this.dkZ.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.dld.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.dld.setVisibility(0);
            }
        }
    };
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.cDw = new ActivityResultDispatcher(this, 1);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ah.N(this);
        aAY();
        initView();
        initData();
    }

    private void aAY() {
        if (getIntent() != null) {
            Bundle b = u.b(getIntent(), "launchParams");
            d.dge = u.h(b, "launchType");
            d.dmH = u.c(b, "isShowCamera", true);
            d.mIsFrontCamera = u.c(b, "isFrontCamera", false);
            d.dmG = u.a(b, "maxDuration", 60);
            d.dmE = u.a(b, "count", 9);
            String h = u.h(b, UbcStatConstant.KEY_CONTENT_EXT_MODE);
            d.dkQ = u.c(b, "compressed", true);
            d.dmF = u.h(b, "swanAppId");
            if (!TextUtils.isEmpty(h)) {
                d.mMode = h;
            }
            d.dmI = u.h(b, "swanTmpPath");
            if (d.dmE < 1 || d.dmE > 9) {
                d.dmE = 9;
            }
        }
    }

    private void initView() {
        this.dkY = (GridView) findViewById(a.f.album_gridview);
        this.dla = (TextView) findViewById(a.f.album_name);
        this.dlb = (TextView) findViewById(a.f.album_select_done);
        this.dlc = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.dld = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.dlf = findViewById(a.f.album_name_list_layout);
        this.dlg = findViewById(a.f.album_name_list_container);
        this.dlh = (HeightListView) findViewById(a.f.album_name_list);
        this.dli = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.dle = (TextView) findViewById(a.f.album_left_cancel);
        this.dlh.setListViewHeight(ah.dip2px(this, 400.0f));
        this.dla.setOnClickListener(this);
        this.dle.setOnClickListener(this);
        this.dlb.setOnClickListener(this);
        this.dlc.setOnClickListener(this);
        this.dlf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.dlj && !SwanAppAlbumActivity.this.dlk) {
                    SwanAppAlbumActivity.this.aBc();
                    return true;
                }
                return true;
            }
        });
        this.dld.setVisibility(0);
        this.dla.setText(d.ai(this, d.dge));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.dli.hG(true);
        p.b(new com.baidu.swan.apps.media.chooser.c.a(d.dge, this.mHandler), "loadAlbumTask");
    }

    private void aAZ() {
        this.dkZ = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.dkY.setAdapter((ListAdapter) this.dkZ);
        this.dkZ.setData(this.dll.get(0).dmS);
        this.dkZ.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.listener.e
            public void hX(int i) {
                SwanAppAlbumActivity.this.aBb();
            }
        });
    }

    private void aBa() {
        this.dlh.setAdapter((ListAdapter) new b(this, d.dge, this.dll));
        this.dlh.setOnItemClickListener(this.dlm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.dli.hG(false);
        this.dll = (ArrayList) obj;
        if (this.dll.size() > 0 && this.dll.get(0) != null) {
            if (this.dll.get(0).aBt() == null || this.dll.get(0).aBt().size() == 0) {
                this.dld.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.dla.setCompoundDrawables(null, null, drawable, null);
            this.dla.setCompoundDrawablePadding(ah.dip2px(this, 4.0f));
        } else {
            this.dld.setVisibility(8);
        }
        this.dlb.setVisibility(0);
        aBb();
        aBa();
        aAZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBb() {
        if (com.baidu.swan.apps.media.chooser.b.e.aBx() > 0) {
            this.dlb.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.dlc.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.dlb.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.aBx())));
            return;
        }
        this.dlb.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.dlc.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.dlb.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dla) {
            if (this.dll != null && this.dll.size() > 1 && !this.dlk) {
                if (this.dlj) {
                    aBc();
                } else {
                    aBd();
                }
            }
        } else if (view == this.dlb) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.dkQ);
            bundle.putString("swanAppId", d.dmF);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aBw());
            bundle.putString("swanTmpPath", d.dmI);
            d.c(this, bundle);
        } else if (view == this.dle) {
            finish();
        } else if (view == this.dlc && com.baidu.swan.apps.media.chooser.b.e.aBx() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBc() {
        if (this.dlj) {
            this.dlk = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0358a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.dlg.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.dlj = false;
                    SwanAppAlbumActivity.this.dlk = false;
                    SwanAppAlbumActivity.this.dlf.setVisibility(8);
                    SwanAppAlbumActivity.this.dlg.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.dla.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void aBd() {
        if (!this.dlj) {
            this.dlf.setVisibility(0);
            this.dlg.setVisibility(0);
            this.dlk = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0358a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.dlg.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.dlj = true;
                    SwanAppAlbumActivity.this.dlk = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.dla.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.cDw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.dkZ != null) {
                        this.dkZ.notifyDataSetChanged();
                    }
                    aBb();
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
        overridePendingTransition(0, a.C0358a.swanapp_album_slide_bottom_out);
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
