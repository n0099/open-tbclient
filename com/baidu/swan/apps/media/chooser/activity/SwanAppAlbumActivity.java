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
/* loaded from: classes9.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    private ActivityResultDispatcher cBW;
    private TextView djA;
    private TextView djB;
    private RelativeLayout djC;
    private TextView djD;
    private View djE;
    private View djF;
    private HeightListView djG;
    private LoadingLayout djH;
    private boolean djI = false;
    private boolean djJ = false;
    private ArrayList<com.baidu.swan.apps.media.chooser.model.a> djK = new ArrayList<>();
    private AdapterView.OnItemClickListener djL = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SwanAppAlbumActivity.this.djI && !SwanAppAlbumActivity.this.djJ) {
                SwanAppAlbumActivity.this.aAZ();
            }
            SwanAppAlbumActivity.this.djz.setText(((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.djK.get(i)).ik());
            ArrayList<MediaModel> arrayList = ((com.baidu.swan.apps.media.chooser.model.a) SwanAppAlbumActivity.this.djK.get(i)).dlr;
            SwanAppAlbumActivity.this.djy.setData(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.djC.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.djC.setVisibility(0);
            }
        }
    };
    private GridView djx;
    private com.baidu.swan.apps.media.chooser.adapter.a djy;
    private TextView djz;
    private Handler mHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        this.cBW = new ActivityResultDispatcher(this, 1);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.swanapp_album_layout);
        ah.N(this);
        aAV();
        initView();
        initData();
    }

    private void aAV() {
        if (getIntent() != null) {
            Bundle b2 = u.b(getIntent(), "launchParams");
            d.deD = u.h(b2, "launchType");
            d.dlg = u.c(b2, "isShowCamera", true);
            d.mIsFrontCamera = u.c(b2, "isFrontCamera", false);
            d.dlf = u.a(b2, "maxDuration", 60);
            d.dld = u.a(b2, "count", 9);
            String h = u.h(b2, UbcStatConstant.KEY_CONTENT_EXT_MODE);
            d.djp = u.c(b2, "compressed", true);
            d.dle = u.h(b2, "swanAppId");
            if (!TextUtils.isEmpty(h)) {
                d.mMode = h;
            }
            d.dlh = u.h(b2, "swanTmpPath");
            if (d.dld < 1 || d.dld > 9) {
                d.dld = 9;
            }
        }
    }

    private void initView() {
        this.djx = (GridView) findViewById(a.f.album_gridview);
        this.djz = (TextView) findViewById(a.f.album_name);
        this.djA = (TextView) findViewById(a.f.album_select_done);
        this.djB = (TextView) findViewById(a.f.album_bottom_preview_tv);
        this.djC = (RelativeLayout) findViewById(a.f.album_bottom_preview_container);
        this.djE = findViewById(a.f.album_name_list_layout);
        this.djF = findViewById(a.f.album_name_list_container);
        this.djG = (HeightListView) findViewById(a.f.album_name_list);
        this.djH = (LoadingLayout) findViewById(a.f.album_content_loading);
        this.djD = (TextView) findViewById(a.f.album_left_cancel);
        this.djG.setListViewHeight(ah.dip2px(this, 400.0f));
        this.djz.setOnClickListener(this);
        this.djD.setOnClickListener(this);
        this.djA.setOnClickListener(this);
        this.djB.setOnClickListener(this);
        this.djE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (SwanAppAlbumActivity.this.djI && !SwanAppAlbumActivity.this.djJ) {
                    SwanAppAlbumActivity.this.aAZ();
                    return true;
                }
                return true;
            }
        });
        this.djC.setVisibility(0);
        this.djz.setText(d.ai(this, d.deD));
    }

    private void initData() {
        this.mHandler = new a(this);
        this.djH.hG(true);
        p.b(new com.baidu.swan.apps.media.chooser.c.a(d.deD, this.mHandler), "loadAlbumTask");
    }

    private void aAW() {
        this.djy = new com.baidu.swan.apps.media.chooser.adapter.a(this);
        this.djx.setAdapter((ListAdapter) this.djy);
        this.djy.setData(this.djK.get(0).dlr);
        this.djy.a(new e() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.2
            @Override // com.baidu.swan.apps.media.chooser.listener.e
            public void hW(int i) {
                SwanAppAlbumActivity.this.aAY();
            }
        });
    }

    private void aAX() {
        this.djG.setAdapter((ListAdapter) new b(this, d.deD, this.djK));
        this.djG.setOnItemClickListener(this.djL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.djH.hG(false);
        this.djK = (ArrayList) obj;
        if (this.djK.size() > 0 && this.djK.get(0) != null) {
            if (this.djK.get(0).aBq() == null || this.djK.get(0).aBq().size() == 0) {
                this.djC.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.djz.setCompoundDrawables(null, null, drawable, null);
            this.djz.setCompoundDrawablePadding(ah.dip2px(this, 4.0f));
        } else {
            this.djC.setVisibility(8);
        }
        this.djA.setVisibility(0);
        aAY();
        aAX();
        aAW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAY() {
        if (com.baidu.swan.apps.media.chooser.b.e.aBu() > 0) {
            this.djA.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_color));
            this.djB.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_color));
            this.djA.setText(getResources().getString(a.h.swanapp_album_selected_done_num, Integer.valueOf(com.baidu.swan.apps.media.chooser.b.e.aBu())));
            return;
        }
        this.djA.setTextColor(getResources().getColor(a.c.swanapp_album_select_done_unable_color));
        this.djB.setTextColor(getResources().getColor(a.c.swanapp_album_bottom_preview_unable_color));
        this.djA.setText(getString(a.h.swanapp_album_selected_done));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.djz) {
            if (this.djK != null && this.djK.size() > 1 && !this.djJ) {
                if (this.djI) {
                    aAZ();
                } else {
                    aBa();
                }
            }
        } else if (view == this.djA) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.djp);
            bundle.putString("swanAppId", d.dle);
            bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aBt());
            bundle.putString("swanTmpPath", d.dlh);
            d.c(this, bundle);
        } else if (view == this.djD) {
            finish();
        } else if (view == this.djB && com.baidu.swan.apps.media.chooser.b.e.aBu() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.b(this, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAZ() {
        if (this.djI) {
            this.djJ = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0352a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.djF.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.djI = false;
                    SwanAppAlbumActivity.this.djJ = false;
                    SwanAppAlbumActivity.this.djE.setVisibility(8);
                    SwanAppAlbumActivity.this.djF.setVisibility(8);
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_up_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.djz.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    private void aBa() {
        if (!this.djI) {
            this.djE.setVisibility(0);
            this.djF.setVisibility(0);
            this.djJ = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0352a.swanapp_album_floating_layer_in_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.djF.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SwanAppAlbumActivity.this.djI = true;
                    SwanAppAlbumActivity.this.djJ = false;
                    Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(a.e.swanapp_album_down_triangle);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    SwanAppAlbumActivity.this.djz.setCompoundDrawables(null, null, drawable, null);
                }
            });
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.cBW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            if (i == 32770 && i2 == -1) {
                if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                    if (this.djy != null) {
                        this.djy.notifyDataSetChanged();
                    }
                    aAY();
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
        overridePendingTransition(0, a.C0352a.swanapp_album_slide_bottom_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
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
