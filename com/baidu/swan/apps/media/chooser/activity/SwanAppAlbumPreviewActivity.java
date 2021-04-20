package com.baidu.swan.apps.media.chooser.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter;
import com.baidu.swan.apps.media.chooser.adapter.SwanAppThumbnailAdapter;
import com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener;
import com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailTouchCallback;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.view.DragView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.google.protobuf.CodedInputStream;
import d.b.g0.a.g;
import d.b.g0.a.h;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.u;
import d.b.g0.a.k;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements DragView.b, View.OnClickListener, d.b.g0.a.b1.d.d.a, d.b.g0.a.b1.d.d.f {
    public static final boolean DEBUG = k.f45443a;
    public SwanAppAlbumPreviewAdapter mAdapter;
    public View mBackTv;
    public View mBottomView;
    public TextView mDoneTv;
    public DragView mDragView;
    public String mFrom;
    public int mIndex;
    public View mLineView;
    public ArrayList<MediaModel> mList;
    public View mPhotoHeader;
    public View mRootView;
    public ImageView mSelectImg;
    public TextView mSelectNumTv;
    public View mSelectView;
    public SwanAppThumbnailAdapter mThumbnailAdapter;
    public RecyclerView mThumbnailView;
    public d.b.g0.a.q1.a.d mTintManager;
    public ViewPager mViewPager;
    public boolean mDragActionOver = true;
    public boolean mBarShowing = true;
    public boolean mAnimation = false;
    public int mDuration = 200;
    public ViewPager.OnPageChangeListener pageChangeListener = new c();

    /* loaded from: classes2.dex */
    public class a extends LinearLayoutManager {

        /* renamed from: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0170a extends LinearSmoothScroller {
            public C0170a(Context context) {
                super(context);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return (SwanAppAlbumPreviewActivity.this.getResources().getDisplayMetrics().density * 0.3f) / displayMetrics.density;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i) {
                return super.computeScrollVectorForPosition(i);
            }
        }

        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            C0170a c0170a = new C0170a(recyclerView.getContext());
            c0170a.setTargetPosition(i);
            startSmoothScroll(c0170a);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends SwanAppThumbnailClickListener {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.b1.d.c.a f11958c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ItemTouchHelper f11959d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecyclerView recyclerView, d.b.g0.a.b1.d.c.a aVar, ItemTouchHelper itemTouchHelper) {
            super(recyclerView);
            this.f11958c = aVar;
            this.f11959d = itemTouchHelper;
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void b(RecyclerView.ViewHolder viewHolder) {
            if (SwanAppAlbumPreviewActivity.this.mList == null) {
                return;
            }
            MediaModel g2 = SwanAppAlbumPreviewActivity.this.mThumbnailAdapter.g(viewHolder.getAdapterPosition());
            int size = SwanAppAlbumPreviewActivity.this.mList.size();
            for (int i = 0; i < size; i++) {
                if (SwanAppAlbumPreviewActivity.this.mList.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.mList.get(i)).equals(g2)) {
                    this.f11958c.a(true);
                    SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                    this.f11958c.a(false);
                    return;
                }
            }
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void c(RecyclerView.ViewHolder viewHolder) {
            ArrayList<MediaModel> m = SwanAppAlbumPreviewActivity.this.mThumbnailAdapter.m();
            if (viewHolder.getLayoutPosition() < 0 || m == null || viewHolder.getLayoutPosition() == m.size()) {
                return;
            }
            this.f11959d.startDrag(viewHolder);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.mAdapter.o();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.smoothScrollToPosition();
            SwanAppAlbumPreviewActivity.this.setBottomSelectBtn();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f11962e;

        public d(int i) {
            this.f11962e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11962e > 0) {
                SwanAppAlbumPreviewActivity.this.mThumbnailView.smoothScrollToPosition(this.f11962e - 1);
            } else {
                SwanAppAlbumPreviewActivity.this.mThumbnailView.smoothScrollToPosition(this.f11962e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwanAppAlbumPreviewActivity.this.mAnimation = false;
            SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity = SwanAppAlbumPreviewActivity.this;
            swanAppAlbumPreviewActivity.mBarShowing = !swanAppAlbumPreviewActivity.mBarShowing;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Animator.AnimatorListener {
        public f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwanAppAlbumPreviewActivity.this.mAnimation = false;
            SwanAppAlbumPreviewActivity swanAppAlbumPreviewActivity = SwanAppAlbumPreviewActivity.this;
            swanAppAlbumPreviewActivity.mBarShowing = !swanAppAlbumPreviewActivity.mBarShowing;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    private void adjustViewStatus() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.mDoneTv.setVisibility(8);
            this.mBottomView.setVisibility(8);
        }
    }

    private void backDown() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    private d.b.g0.a.b1.d.c.a getNoDurationScroller(ViewPager viewPager) {
        d.b.g0.a.b1.d.c.a aVar = new d.b.g0.a.b1.d.c.a(viewPager.getContext());
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, aVar);
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return aVar;
    }

    private String getSelectNum(MediaModel mediaModel) {
        return String.valueOf(d.b.g0.a.b1.d.c.e.c(mediaModel) + 1);
    }

    private void initBottomThumbnailView() {
        this.mThumbnailView = (RecyclerView) findViewById(d.b.g0.a.f.thumbnail_drag_view);
        this.mLineView = findViewById(d.b.g0.a.f.album_preview_line);
        a aVar = new a(this);
        aVar.setOrientation(0);
        this.mThumbnailView.setLayoutManager(aVar);
        SwanAppThumbnailAdapter swanAppThumbnailAdapter = new SwanAppThumbnailAdapter(this);
        this.mThumbnailAdapter = swanAppThumbnailAdapter;
        this.mThumbnailView.setAdapter(swanAppThumbnailAdapter);
        this.mThumbnailAdapter.q(d.b.g0.a.b1.d.c.e.e() == null ? null : d.b.g0.a.b1.d.c.e.e());
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwanAppThumbnailTouchCallback(this, this.mThumbnailAdapter));
        itemTouchHelper.attachToRecyclerView(this.mThumbnailView);
        d.b.g0.a.b1.d.c.a noDurationScroller = getNoDurationScroller(this.mViewPager);
        RecyclerView recyclerView = this.mThumbnailView;
        recyclerView.addOnItemTouchListener(new b(recyclerView, noDurationScroller, itemTouchHelper));
        updateThumbnailView();
        smoothScrollToPosition();
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(d.b.g0.a.f.album_preview_content);
        DragView dragView = (DragView) findViewById(d.b.g0.a.f.drag_view);
        this.mDragView = dragView;
        dragView.setOnCloseListener(this);
        this.mDragView.setBackgroundColor(getResources().getColor(d.b.g0.a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(d.b.g0.a.f.album_preview_viewpager);
        this.mSelectImg = (ImageView) findViewById(d.b.g0.a.f.album_preview_select_checkbox);
        this.mBackTv = findViewById(d.b.g0.a.f.album_preview_back_layout);
        this.mSelectView = findViewById(d.b.g0.a.f.album_preview_select_view);
        this.mDoneTv = (TextView) findViewById(d.b.g0.a.f.album_preview_done);
        this.mSelectNumTv = (TextView) findViewById(d.b.g0.a.f.album_preview_select);
        this.mBottomView = findViewById(d.b.g0.a.f.album_preview_bottom);
        this.mPhotoHeader = findViewById(d.b.g0.a.f.album_preview_header);
        this.mBackTv.setOnClickListener(this);
        this.mDoneTv.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.pageChangeListener);
        SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = new SwanAppAlbumPreviewAdapter(this, this.mList);
        this.mAdapter = swanAppAlbumPreviewAdapter;
        this.mViewPager.setAdapter(swanAppAlbumPreviewAdapter);
        this.mAdapter.u(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.mSelectView.setOnClickListener(this);
        this.mDoneTv.setBackgroundResource(d.b.g0.a.e.swanapp_album_preview_done_bg);
        this.mDoneTv.setTextColor(getResources().getColor(d.b.g0.a.c.swanapp_album_preview_select_done_color));
        if (d.b.g0.a.b1.d.c.e.d() != 0) {
            string = getString(h.swanapp_album_selected_done) + "(" + d.b.g0.a.b1.d.c.e.d() + SmallTailInfo.EMOTION_SUFFIX;
        } else {
            string = getString(h.swanapp_album_selected_done);
        }
        this.mDoneTv.setText(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBackGroundAlpha(int i) {
        int i2;
        int abs = Math.abs(i);
        if (abs >= 0) {
            float f2 = abs;
            if (f2 < 300.0f) {
                i2 = (int) (255.0f - ((f2 / 300.0f) * 20.0f));
                this.mRootView.getBackground().mutate().setAlpha(i2 >= 0 ? i2 : 0);
            }
        }
        float f3 = abs;
        if (f3 >= 300.0f) {
            float f4 = 235;
            i2 = (int) (f4 - (((f3 - 300.0f) / 900.0f) * f4));
        } else {
            i2 = 0;
        }
        this.mRootView.getBackground().mutate().setAlpha(i2 >= 0 ? i2 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBottomSelectBtn() {
        ArrayList<MediaModel> arrayList = this.mList;
        if (arrayList == null) {
            return;
        }
        MediaModel mediaModel = this.mIndex < arrayList.size() ? this.mList.get(this.mIndex) : null;
        if (mediaModel == null) {
            return;
        }
        if (d.b.g0.a.b1.d.c.e.g(mediaModel)) {
            this.mSelectNumTv.setVisibility(0);
            this.mSelectNumTv.setText(getSelectNum(this.mList.get(this.mIndex)));
            this.mSelectNumTv.setBackgroundResource(d.b.g0.a.e.swanapp_album_preview_select_bg);
            return;
        }
        this.mSelectNumTv.setVisibility(8);
        if (d.b.g0.a.b1.d.c.d.f(d.b.g0.a.b1.d.c.d.f43825d, mediaModel)) {
            this.mSelectImg.setImageResource(d.b.g0.a.e.swanapp_album_preview_unselect_unable);
        } else {
            this.mSelectImg.setImageResource(d.b.g0.a.e.swanapp_album_preview_unselect);
        }
    }

    private void setOtherViewAlpha(int i) {
        float f2 = i == 0 ? 0.0f : 1.0f;
        View view = this.mBottomView;
        if (view != null) {
            view.setAlpha(1.0f - f2);
        }
        View view2 = this.mPhotoHeader;
        if (view2 != null) {
            view2.setAlpha(1.0f - f2);
        }
    }

    @TargetApi(19)
    private void setTranslucentStatus() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScrollToPosition() {
        int p;
        if (this.mThumbnailAdapter == null || this.mIndex >= this.mList.size() || (p = this.mThumbnailAdapter.p(this.mList.get(this.mIndex))) < 0) {
            return;
        }
        int i = p + 1;
        if (i < this.mThumbnailAdapter.getItemCount()) {
            this.mThumbnailView.smoothScrollToPosition(i);
        } else {
            this.mThumbnailView.smoothScrollToPosition(p);
        }
        this.mThumbnailView.postDelayed(new d(p), 300L);
    }

    private void updateThumbnailView() {
        ArrayList<MediaModel> e2 = d.b.g0.a.b1.d.c.e.e();
        ViewGroup.LayoutParams layoutParams = this.mBottomView.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.b.g0.a.d.swanapp_preview_bottom_height);
        if (e2 != null && e2.size() > 0) {
            this.mThumbnailView.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.mThumbnailView.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(d.b.g0.a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(d.b.g0.a.d.swanapp_preview_drag_view_height);
    }

    @Override // d.b.g0.a.b1.d.d.a
    public void clickContainer() {
        if (!this.mAnimation && this.mBarShowing) {
            hideBar();
        } else if (this.mAnimation) {
        } else {
            showBar();
        }
    }

    @Override // d.b.g0.a.b1.d.d.a
    public void hideBar() {
        if (this.mBarShowing) {
            this.mAnimation = true;
            float y = this.mPhotoHeader.getY();
            float y2 = this.mBottomView.getY();
            View view = this.mPhotoHeader;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "y", y, y - view.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new e());
            ofFloat.start();
            View view2 = this.mBottomView;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "y", y2, y2 + view2.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ArrayList<MediaModel> arrayList;
        String string;
        if (view == this.mBackTv) {
            backDown();
            finish();
            return;
        }
        ArrayList<MediaModel> arrayList2 = this.mList;
        if (arrayList2 == null || this.mIndex >= arrayList2.size()) {
            return;
        }
        MediaModel mediaModel = this.mList.get(this.mIndex);
        if (view == this.mSelectView) {
            if (d.b.g0.a.b1.d.c.e.f(mediaModel)) {
                this.mThumbnailAdapter.notifyItemRemoved(d.b.g0.a.b1.d.c.e.c(mediaModel));
                d.b.g0.a.b1.d.c.e.h(mediaModel);
                if (d.b.g0.a.b1.d.c.e.d() == 0) {
                    this.mThumbnailAdapter.q(null);
                }
                this.mSelectNumTv.setVisibility(8);
                this.mSelectImg.setImageResource(d.b.g0.a.e.swanapp_album_preview_unselect);
                if (d.b.g0.a.b1.d.c.e.d() > 0) {
                    string = getString(h.swanapp_album_selected_done) + "(" + d.b.g0.a.b1.d.c.e.d() + SmallTailInfo.EMOTION_SUFFIX;
                } else {
                    string = getString(h.swanapp_album_selected_done);
                }
                this.mDoneTv.setText(string);
                updateThumbnailView();
                return;
            }
            int d2 = d.b.g0.a.b1.d.c.e.d();
            if (d2 == d.b.g0.a.b1.d.c.d.f43824c) {
                d.b.g0.a.b1.d.c.d.j(d.b.g0.a.b1.d.c.d.f43825d);
            } else if (d2 > 0 && TextUtils.equals(d.b.g0.a.b1.d.c.d.f43825d, "single") && !TextUtils.equals(d.b.g0.a.b1.d.c.e.b(), mediaModel.e())) {
                d.b.g0.a.q1.b.f.d.e(this, h.swanapp_album_select_single).C();
            } else {
                int d3 = d.b.g0.a.b1.d.c.e.d();
                this.mThumbnailAdapter.notifyItemInserted(d3);
                d.b.g0.a.b1.d.c.e.i(mediaModel);
                if (this.mThumbnailAdapter.m() == null) {
                    this.mThumbnailAdapter.q(d.b.g0.a.b1.d.c.e.e());
                }
                this.mThumbnailView.smoothScrollToPosition(d3);
                this.mSelectNumTv.setVisibility(0);
                this.mSelectNumTv.setText(getSelectNum(mediaModel));
                this.mSelectNumTv.setBackgroundResource(d.b.g0.a.e.swanapp_album_preview_select_bg);
                this.mDoneTv.setText(getString(h.swanapp_album_selected_done) + "(" + d.b.g0.a.b1.d.c.e.d() + SmallTailInfo.EMOTION_SUFFIX);
                this.mDoneTv.setTextColor(getResources().getColor(d.b.g0.a.c.swanapp_album_preview_select_done_color));
                updateThumbnailView();
            }
        } else if (view == this.mDoneTv) {
            if (d.b.g0.a.b1.d.c.e.d() == 0 && (arrayList = this.mList) != null && arrayList.size() > 0 && this.mIndex < this.mList.size()) {
                d.b.g0.a.b1.d.c.e.i(mediaModel);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.b.g0.a.b1.d.c.d.f43826e);
            bundle.putString("swanAppId", d.b.g0.a.b1.d.c.d.f43827f);
            bundle.putParcelableArrayList("mediaModels", d.b.g0.a.b1.d.c.e.e());
            bundle.putString("swanTmpPath", d.b.g0.a.b1.d.c.d.j);
            d.b.g0.a.b1.d.c.d.g(this, bundle);
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void onClose() {
        finish();
        overridePendingTransition(d.b.g0.a.a.swanapp_album_preview_enter, d.b.g0.a.a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void onClosing(int i) {
        setOtherViewAlpha(i);
        setBackGroundAlpha(i);
        if (i != 0 && this.mDragActionOver) {
            setRootViewBackground(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.mDragView.setBackground(new ColorDrawable(0));
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = this.mAdapter;
            if (swanAppAlbumPreviewAdapter != null) {
                swanAppAlbumPreviewAdapter.s(this.mIndex, d.b.g0.a.c.aiapps_transparent);
            }
            this.mDragActionOver = false;
        }
        if (i == 0) {
            setRootViewBackground(new ColorDrawable(0));
            this.mDragView.setBackgroundColor(getResources().getColor(d.b.g0.a.c.aiapps_black));
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter2 = this.mAdapter;
            if (swanAppAlbumPreviewAdapter2 != null) {
                swanAppAlbumPreviewAdapter2.s(this.mIndex, d.b.g0.a.c.aiapps_black);
            }
            this.mDragActionOver = true;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, d.b.g0.m.a.a.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int V = k0.V(this);
        super.onCreate(bundle);
        k0.h(this, V);
        setTranslucentStatus();
        d.b.g0.a.q1.a.d dVar = new d.b.g0.a.q1.a.d(this);
        this.mTintManager = dVar;
        dVar.b(false);
        getWindow().setFlags(1024, 1024);
        setContentView(g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle e2 = u.e(getIntent(), "launchParams");
            this.mIndex = u.f(e2, "previewPosition", 0);
            String g2 = u.g(e2, "previewFrom");
            this.mFrom = g2;
            if (TextUtils.equals(g2, "bottomPreview")) {
                ArrayList<MediaModel> arrayList = new ArrayList<>();
                this.mList = arrayList;
                arrayList.addAll(d.b.g0.a.b1.d.c.e.e());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.mList = e2 == null ? null : e2.getParcelableArrayList("mediaModels");
            } else {
                this.mList = d.b.g0.a.b1.d.c.d.c();
            }
            if (this.mList == null) {
                this.mList = new ArrayList<>();
            }
        }
        initView();
        setBottomSelectBtn();
        initBottomThumbnailView();
        adjustViewStatus();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = this.mAdapter;
        if (swanAppAlbumPreviewAdapter != null) {
            swanAppAlbumPreviewAdapter.j();
            this.mAdapter = null;
        }
        this.mThumbnailAdapter = null;
        this.mTintManager = null;
        if (this.mList != null) {
            this.mList = null;
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void onDragViewTouchEvent(MotionEvent motionEvent) {
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            backDown();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // d.b.g0.a.b1.d.d.f
    public void onMove(int i, int i2) {
        ArrayList<MediaModel> arrayList = this.mList;
        if (arrayList == null || this.mIndex >= arrayList.size()) {
            return;
        }
        this.mSelectNumTv.setText(getSelectNum(this.mList.get(this.mIndex)));
    }

    public void setRootViewBackground(Drawable drawable) {
        View view = this.mRootView;
        if (view != null) {
            view.setBackground(drawable);
        }
    }

    @Override // d.b.g0.a.b1.d.d.a
    public void showBar() {
        if (this.mBarShowing) {
            return;
        }
        this.mAnimation = true;
        float y = this.mPhotoHeader.getY();
        float y2 = this.mBottomView.getY();
        View view = this.mPhotoHeader;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "y", y, y + view.getHeight());
        ofFloat.setDuration(this.mDuration);
        ofFloat.addListener(new f());
        ofFloat.start();
        View view2 = this.mBottomView;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "y", y2, y2 - view2.getHeight());
        ofFloat2.setDuration(this.mDuration);
        ofFloat2.start();
    }
}
