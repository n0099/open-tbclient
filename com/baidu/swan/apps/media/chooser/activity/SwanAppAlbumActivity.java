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
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.view.HeightListView;
import com.baidu.swan.apps.view.LoadingLayout;
import d.a.h0.a.g;
import d.a.h0.a.h;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.a.i2.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppAlbumActivity extends SwanAppBaseActivity implements View.OnClickListener, ActivityResultDispatcherHolder {
    public static final int MSG_LOAD_FINISHED = 0;
    public static final int REQUEST_CODE_RESULT_DISPATCHER = 1;
    public static final String TAG = "SwanAppAlbumActivity";
    public d.a.h0.a.b1.d.b.a mAdapter;
    public View mAlbumNameListContainer;
    public View mAlbumNameListLayout;
    public HeightListView mAlbumNameListView;
    public TextView mAlbumNameTv;
    public RelativeLayout mBottomPreviewLayout;
    public TextView mBottomPreviewTv;
    public TextView mCancelTv;
    public LoadingLayout mEmptyView;
    public GridView mGridView;
    public Handler mHandler;
    public ActivityResultDispatcher mResultDispatcher;
    public TextView mSelectDoneTv;
    public boolean mIsOpenedList = false;
    public boolean mIsAnimationRunning = false;
    public ArrayList<d.a.h0.a.b1.d.e.a> mGroupImages = new ArrayList<>();
    public AdapterView.OnItemClickListener mAlbumNameClickListener = new e();

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!SwanAppAlbumActivity.this.mIsOpenedList || SwanAppAlbumActivity.this.mIsAnimationRunning) {
                return true;
            }
            SwanAppAlbumActivity.this.startHideAnimation();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.b1.d.d.e {
        public b() {
        }

        @Override // d.a.h0.a.b1.d.d.e
        public void a(int i2) {
            SwanAppAlbumActivity.this.changeNumberUi();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwanAppAlbumActivity.this.mIsOpenedList = false;
            SwanAppAlbumActivity.this.mIsAnimationRunning = false;
            SwanAppAlbumActivity.this.mAlbumNameListLayout.setVisibility(8);
            SwanAppAlbumActivity.this.mAlbumNameListContainer.setVisibility(8);
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(d.a.h0.a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            SwanAppAlbumActivity.this.mAlbumNameTv.setCompoundDrawables(null, null, drawable, null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwanAppAlbumActivity.this.mIsOpenedList = true;
            SwanAppAlbumActivity.this.mIsAnimationRunning = false;
            Drawable drawable = SwanAppAlbumActivity.this.getResources().getDrawable(d.a.h0.a.e.swanapp_album_down_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            SwanAppAlbumActivity.this.mAlbumNameTv.setCompoundDrawables(null, null, drawable, null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (SwanAppAlbumActivity.this.mIsOpenedList && !SwanAppAlbumActivity.this.mIsAnimationRunning) {
                SwanAppAlbumActivity.this.startHideAnimation();
            }
            SwanAppAlbumActivity.this.mAlbumNameTv.setText(((d.a.h0.a.b1.d.e.a) SwanAppAlbumActivity.this.mGroupImages.get(i2)).c());
            ArrayList<MediaModel> arrayList = ((d.a.h0.a.b1.d.e.a) SwanAppAlbumActivity.this.mGroupImages.get(i2)).f41446h;
            SwanAppAlbumActivity.this.mAdapter.x(arrayList);
            if (arrayList.size() == 0) {
                SwanAppAlbumActivity.this.mBottomPreviewLayout.setVisibility(8);
            } else {
                SwanAppAlbumActivity.this.mBottomPreviewLayout.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<SwanAppAlbumActivity> f11801a;

        public f(SwanAppAlbumActivity swanAppAlbumActivity) {
            this.f11801a = new WeakReference<>(swanAppAlbumActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            SwanAppAlbumActivity swanAppAlbumActivity = this.f11801a.get();
            if (swanAppAlbumActivity == null || swanAppAlbumActivity.isFinishing() || message.what != 0) {
                return;
            }
            d.a.h0.a.c0.c.a(SwanAppAlbumActivity.TAG, "LoadAlbumTask finished");
            Object obj = message.obj;
            if (obj instanceof ArrayList) {
                swanAppAlbumActivity.notifyUi(obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeNumberUi() {
        if (d.a.h0.a.b1.d.c.e.d() > 0) {
            this.mSelectDoneTv.setTextColor(getResources().getColor(d.a.h0.a.c.swanapp_album_select_done_color));
            this.mBottomPreviewTv.setTextColor(getResources().getColor(d.a.h0.a.c.swanapp_album_bottom_preview_color));
            this.mSelectDoneTv.setText(getResources().getString(h.swanapp_album_selected_done_num, Integer.valueOf(d.a.h0.a.b1.d.c.e.d())));
            return;
        }
        this.mSelectDoneTv.setTextColor(getResources().getColor(d.a.h0.a.c.swanapp_album_select_done_unable_color));
        this.mBottomPreviewTv.setTextColor(getResources().getColor(d.a.h0.a.c.swanapp_album_bottom_preview_unable_color));
        this.mSelectDoneTv.setText(getString(h.swanapp_album_selected_done));
    }

    private void getIntentData() {
        if (getIntent() == null) {
            return;
        }
        Bundle e2 = u.e(getIntent(), "launchParams");
        d.a.h0.a.b1.d.c.d.f41427b = u.g(e2, "launchType");
        d.a.h0.a.b1.d.c.d.f41433h = u.c(e2, "isShowCamera", true);
        d.a.h0.a.b1.d.c.d.f41434i = u.c(e2, "isFrontCamera", false);
        d.a.h0.a.b1.d.c.d.f41432g = u.f(e2, "maxDuration", 60);
        d.a.h0.a.b1.d.c.d.f41428c = u.f(e2, "count", 9);
        String g2 = u.g(e2, "mode");
        d.a.h0.a.b1.d.c.d.f41430e = u.c(e2, "compressed", true);
        d.a.h0.a.b1.d.c.d.f41431f = u.g(e2, "swanAppId");
        if (!TextUtils.isEmpty(g2)) {
            d.a.h0.a.b1.d.c.d.f41429d = g2;
        }
        d.a.h0.a.b1.d.c.d.j = u.g(e2, "swanTmpPath");
        int i2 = d.a.h0.a.b1.d.c.d.f41428c;
        if (i2 < 1 || i2 > 9) {
            d.a.h0.a.b1.d.c.d.f41428c = 9;
        }
    }

    private void initAlbumNameAdapter() {
        this.mAlbumNameListView.setAdapter((ListAdapter) new d.a.h0.a.b1.d.b.b(this, d.a.h0.a.b1.d.c.d.f41427b, this.mGroupImages));
        this.mAlbumNameListView.setOnItemClickListener(this.mAlbumNameClickListener);
    }

    private void initData() {
        this.mHandler = new f(this);
        this.mEmptyView.b(true);
        p.j(new d.a.h0.a.b1.d.f.a(d.a.h0.a.b1.d.c.d.f41427b, this.mHandler), "loadAlbumTask");
    }

    private void initImageAdapter() {
        d.a.h0.a.b1.d.b.a aVar = new d.a.h0.a.b1.d.b.a(this);
        this.mAdapter = aVar;
        this.mGridView.setAdapter((ListAdapter) aVar);
        this.mAdapter.x(this.mGroupImages.get(0).f41446h);
        this.mAdapter.z(new b());
    }

    private void initView() {
        this.mGridView = (GridView) findViewById(d.a.h0.a.f.album_gridview);
        this.mAlbumNameTv = (TextView) findViewById(d.a.h0.a.f.album_name);
        this.mSelectDoneTv = (TextView) findViewById(d.a.h0.a.f.album_select_done);
        this.mBottomPreviewTv = (TextView) findViewById(d.a.h0.a.f.album_bottom_preview_tv);
        this.mBottomPreviewLayout = (RelativeLayout) findViewById(d.a.h0.a.f.album_bottom_preview_container);
        this.mAlbumNameListLayout = findViewById(d.a.h0.a.f.album_name_list_layout);
        this.mAlbumNameListContainer = findViewById(d.a.h0.a.f.album_name_list_container);
        this.mAlbumNameListView = (HeightListView) findViewById(d.a.h0.a.f.album_name_list);
        this.mEmptyView = (LoadingLayout) findViewById(d.a.h0.a.f.album_content_loading);
        this.mCancelTv = (TextView) findViewById(d.a.h0.a.f.album_left_cancel);
        this.mAlbumNameListView.setListViewHeight(h0.e(this, 400.0f));
        this.mAlbumNameTv.setOnClickListener(this);
        this.mCancelTv.setOnClickListener(this);
        this.mSelectDoneTv.setOnClickListener(this);
        this.mBottomPreviewTv.setOnClickListener(this);
        this.mAlbumNameListLayout.setOnTouchListener(new a());
        this.mBottomPreviewLayout.setVisibility(0);
        this.mAlbumNameTv.setText(d.a.h0.a.b1.d.c.d.b(this, d.a.h0.a.b1.d.c.d.f41427b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUi(Object obj) {
        this.mEmptyView.b(false);
        ArrayList<d.a.h0.a.b1.d.e.a> arrayList = (ArrayList) obj;
        this.mGroupImages = arrayList;
        if (arrayList.size() > 0 && this.mGroupImages.get(0) != null) {
            if (this.mGroupImages.get(0).f() == null || this.mGroupImages.get(0).f().size() == 0) {
                this.mBottomPreviewLayout.setVisibility(8);
            }
            Drawable drawable = getResources().getDrawable(d.a.h0.a.e.swanapp_album_up_triangle);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mAlbumNameTv.setCompoundDrawables(null, null, drawable, null);
            this.mAlbumNameTv.setCompoundDrawablePadding(h0.e(this, 4.0f));
        } else {
            this.mBottomPreviewLayout.setVisibility(8);
        }
        this.mSelectDoneTv.setVisibility(0);
        changeNumberUi();
        initAlbumNameAdapter();
        initImageAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startHideAnimation() {
        if (this.mIsOpenedList) {
            this.mIsAnimationRunning = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, d.a.h0.a.a.swanapp_album_floating_layer_out_animation);
            new LayoutAnimationController(loadAnimation).setOrder(0);
            this.mAlbumNameListContainer.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new c());
        }
    }

    private void startShowAnimation() {
        if (this.mIsOpenedList) {
            return;
        }
        this.mAlbumNameListLayout.setVisibility(0);
        this.mAlbumNameListContainer.setVisibility(0);
        this.mIsAnimationRunning = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(this, d.a.h0.a.a.swanapp_album_floating_layer_in_animation);
        new LayoutAnimationController(loadAnimation).setOrder(0);
        this.mAlbumNameListContainer.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new d());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, d.a.h0.a.a.swanapp_album_slide_bottom_out);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.mResultDispatcher;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (getResultDispatcher().notifyActivityResult(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
        if (i2 == 32770 && i3 == -1) {
            if (intent != null ? intent.getBooleanExtra("isRefresh", false) : false) {
                d.a.h0.a.b1.d.b.a aVar = this.mAdapter;
                if (aVar != null) {
                    aVar.notifyDataSetChanged();
                }
                changeNumberUi();
                return;
            }
            setResult(-1, intent);
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mAlbumNameTv) {
            ArrayList<d.a.h0.a.b1.d.e.a> arrayList = this.mGroupImages;
            if (arrayList == null || arrayList.size() <= 1 || this.mIsAnimationRunning) {
                return;
            }
            if (this.mIsOpenedList) {
                startHideAnimation();
            } else {
                startShowAnimation();
            }
        } else if (view == this.mSelectDoneTv) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.a.h0.a.b1.d.c.d.f41430e);
            bundle.putString("swanAppId", d.a.h0.a.b1.d.c.d.f41431f);
            bundle.putParcelableArrayList("mediaModels", d.a.h0.a.b1.d.c.e.e());
            bundle.putString("swanTmpPath", d.a.h0.a.b1.d.c.d.j);
            d.a.h0.a.b1.d.c.d.g(this, bundle);
        } else if (view == this.mCancelTv) {
            finish();
        } else if (view != this.mBottomPreviewTv || d.a.h0.a.b1.d.c.e.d() <= 0) {
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putString("previewFrom", "bottomPreview");
            bundle2.putInt("previewPosition", 0);
            d.a.h0.a.b1.d.c.d.k(this, bundle2);
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, d.a.h0.m.a.a.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int V = k0.V(this);
        super.onCreate(bundle);
        this.mResultDispatcher = new ActivityResultDispatcher(this, 1);
        k0.h(this, V);
        setContentView(g.swanapp_album_layout);
        h0.a(this);
        getIntentData();
        initView();
        initData();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(0);
            this.mHandler = null;
        }
        d.a.h0.a.b1.d.c.e.a();
        d.a.h0.a.b1.d.c.d.a();
    }
}
