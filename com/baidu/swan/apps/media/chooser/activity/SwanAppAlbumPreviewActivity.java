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
import d.a.l0.a.g;
import d.a.l0.a.h;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.v;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements DragView.b, View.OnClickListener, d.a.l0.a.i1.d.d.a, d.a.l0.a.i1.d.d.f {
    public static final boolean DEBUG = k.f46875a;
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
    public d.a.l0.a.z1.a.c mTintManager;
    public ViewPager mViewPager;
    public boolean mDragActionOver = true;
    public boolean mBarShowing = true;
    public boolean mAnimation = false;
    public int mDuration = 200;
    public ViewPager.OnPageChangeListener pageChangeListener = new c();

    /* loaded from: classes3.dex */
    public class a extends LinearLayoutManager {

        /* renamed from: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0153a extends LinearSmoothScroller {
            public C0153a(Context context) {
                super(context);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return (SwanAppAlbumPreviewActivity.this.getResources().getDisplayMetrics().density * 0.3f) / displayMetrics.density;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i2) {
                return super.computeScrollVectorForPosition(i2);
            }
        }

        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
            C0153a c0153a = new C0153a(recyclerView.getContext());
            c0153a.setTargetPosition(i2);
            startSmoothScroll(c0153a);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends SwanAppThumbnailClickListener {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.i1.d.c.a f10935c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ItemTouchHelper f10936d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RecyclerView recyclerView, d.a.l0.a.i1.d.c.a aVar, ItemTouchHelper itemTouchHelper) {
            super(recyclerView);
            this.f10935c = aVar;
            this.f10936d = itemTouchHelper;
        }

        @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
        public void b(RecyclerView.ViewHolder viewHolder) {
            if (SwanAppAlbumPreviewActivity.this.mList == null) {
                return;
            }
            MediaModel g2 = SwanAppAlbumPreviewActivity.this.mThumbnailAdapter.g(viewHolder.getAdapterPosition());
            int size = SwanAppAlbumPreviewActivity.this.mList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (SwanAppAlbumPreviewActivity.this.mList.get(i2) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.mList.get(i2)).equals(g2)) {
                    this.f10935c.a(true);
                    SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i2);
                    this.f10935c.a(false);
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
            this.f10936d.startDrag(viewHolder);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            SwanAppAlbumPreviewActivity.this.mAdapter.q();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            SwanAppAlbumPreviewActivity.this.mIndex = i2;
            SwanAppAlbumPreviewActivity.this.smoothScrollToPosition();
            SwanAppAlbumPreviewActivity.this.setBottomSelectBtn();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f10939e;

        public d(int i2) {
            this.f10939e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10939e > 0) {
                SwanAppAlbumPreviewActivity.this.mThumbnailView.smoothScrollToPosition(this.f10939e - 1);
            } else {
                SwanAppAlbumPreviewActivity.this.mThumbnailView.smoothScrollToPosition(this.f10939e);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    private d.a.l0.a.i1.d.c.a getNoDurationScroller(ViewPager viewPager) {
        d.a.l0.a.i1.d.c.a aVar = new d.a.l0.a.i1.d.c.a(viewPager.getContext());
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
        return String.valueOf(d.a.l0.a.i1.d.c.e.c(mediaModel) + 1);
    }

    private void initBottomThumbnailView() {
        this.mThumbnailView = (RecyclerView) findViewById(d.a.l0.a.f.thumbnail_drag_view);
        this.mLineView = findViewById(d.a.l0.a.f.album_preview_line);
        a aVar = new a(this);
        aVar.setOrientation(0);
        this.mThumbnailView.setLayoutManager(aVar);
        SwanAppThumbnailAdapter swanAppThumbnailAdapter = new SwanAppThumbnailAdapter(this);
        this.mThumbnailAdapter = swanAppThumbnailAdapter;
        this.mThumbnailView.setAdapter(swanAppThumbnailAdapter);
        this.mThumbnailAdapter.q(d.a.l0.a.i1.d.c.e.e() == null ? null : d.a.l0.a.i1.d.c.e.e());
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwanAppThumbnailTouchCallback(this, this.mThumbnailAdapter));
        itemTouchHelper.attachToRecyclerView(this.mThumbnailView);
        d.a.l0.a.i1.d.c.a noDurationScroller = getNoDurationScroller(this.mViewPager);
        RecyclerView recyclerView = this.mThumbnailView;
        recyclerView.addOnItemTouchListener(new b(recyclerView, noDurationScroller, itemTouchHelper));
        updateThumbnailView();
        smoothScrollToPosition();
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(d.a.l0.a.f.album_preview_content);
        DragView dragView = (DragView) findViewById(d.a.l0.a.f.drag_view);
        this.mDragView = dragView;
        dragView.setOnCloseListener(this);
        this.mDragView.setBackgroundColor(-16777216);
        this.mViewPager = (ViewPager) findViewById(d.a.l0.a.f.album_preview_viewpager);
        this.mSelectImg = (ImageView) findViewById(d.a.l0.a.f.album_preview_select_checkbox);
        this.mBackTv = findViewById(d.a.l0.a.f.album_preview_back_layout);
        this.mSelectView = findViewById(d.a.l0.a.f.album_preview_select_view);
        this.mDoneTv = (TextView) findViewById(d.a.l0.a.f.album_preview_done);
        this.mSelectNumTv = (TextView) findViewById(d.a.l0.a.f.album_preview_select);
        this.mBottomView = findViewById(d.a.l0.a.f.album_preview_bottom);
        this.mPhotoHeader = findViewById(d.a.l0.a.f.album_preview_header);
        this.mBackTv.setOnClickListener(this);
        this.mDoneTv.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.pageChangeListener);
        SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = new SwanAppAlbumPreviewAdapter(this, this.mList);
        this.mAdapter = swanAppAlbumPreviewAdapter;
        this.mViewPager.setAdapter(swanAppAlbumPreviewAdapter);
        this.mAdapter.v(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.mSelectView.setOnClickListener(this);
        this.mDoneTv.setBackgroundResource(d.a.l0.a.e.swanapp_album_preview_done_bg);
        this.mDoneTv.setTextColor(getResources().getColor(d.a.l0.a.c.swanapp_album_preview_select_done_color));
        if (d.a.l0.a.i1.d.c.e.d() != 0) {
            string = getString(h.swanapp_completion_text) + "(" + d.a.l0.a.i1.d.c.e.d() + SmallTailInfo.EMOTION_SUFFIX;
        } else {
            string = getString(h.swanapp_completion_text);
        }
        this.mDoneTv.setText(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setBackGroundAlpha(int i2) {
        int i3;
        int abs = Math.abs(i2);
        if (abs >= 0) {
            float f2 = abs;
            if (f2 < 300.0f) {
                i3 = (int) (255.0f - ((f2 / 300.0f) * 20.0f));
                this.mRootView.getBackground().mutate().setAlpha(i3 >= 0 ? i3 : 0);
            }
        }
        float f3 = abs;
        if (f3 >= 300.0f) {
            float f4 = 235;
            i3 = (int) (f4 - (((f3 - 300.0f) / 900.0f) * f4));
        } else {
            i3 = 0;
        }
        this.mRootView.getBackground().mutate().setAlpha(i3 >= 0 ? i3 : 0);
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
        if (d.a.l0.a.i1.d.c.e.g(mediaModel)) {
            this.mSelectNumTv.setVisibility(0);
            this.mSelectNumTv.setText(getSelectNum(this.mList.get(this.mIndex)));
            this.mSelectNumTv.setBackgroundResource(d.a.l0.a.e.swanapp_album_preview_select_bg);
            return;
        }
        this.mSelectNumTv.setVisibility(8);
        if (d.a.l0.a.i1.d.c.d.f(d.a.l0.a.i1.d.c.d.f46546d, mediaModel)) {
            this.mSelectImg.setImageResource(d.a.l0.a.e.swanapp_album_preview_unselect_unable);
        } else {
            this.mSelectImg.setImageResource(d.a.l0.a.e.swanapp_album_preview_unselect);
        }
    }

    private void setOtherViewAlpha(int i2) {
        float f2 = i2 == 0 ? 0.0f : 1.0f;
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
        int i2 = p + 1;
        if (i2 < this.mThumbnailAdapter.getItemCount()) {
            this.mThumbnailView.smoothScrollToPosition(i2);
        } else {
            this.mThumbnailView.smoothScrollToPosition(p);
        }
        this.mThumbnailView.postDelayed(new d(p), 300L);
    }

    private void updateThumbnailView() {
        ArrayList<MediaModel> e2 = d.a.l0.a.i1.d.c.e.e();
        ViewGroup.LayoutParams layoutParams = this.mBottomView.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.a.l0.a.d.swanapp_preview_bottom_height);
        if (e2 != null && e2.size() > 0) {
            this.mThumbnailView.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.mThumbnailView.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(d.a.l0.a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(d.a.l0.a.d.swanapp_preview_drag_view_height);
    }

    @Override // d.a.l0.a.i1.d.d.a
    public void clickContainer() {
        if (!this.mAnimation && this.mBarShowing) {
            hideBar();
        } else if (this.mAnimation) {
        } else {
            showBar();
        }
    }

    @Override // d.a.l0.a.i1.d.d.a
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
            if (d.a.l0.a.i1.d.c.e.f(mediaModel)) {
                this.mThumbnailAdapter.notifyItemRemoved(d.a.l0.a.i1.d.c.e.c(mediaModel));
                d.a.l0.a.i1.d.c.e.h(mediaModel);
                if (d.a.l0.a.i1.d.c.e.d() == 0) {
                    this.mThumbnailAdapter.q(null);
                }
                this.mSelectNumTv.setVisibility(8);
                this.mSelectImg.setImageResource(d.a.l0.a.e.swanapp_album_preview_unselect);
                if (d.a.l0.a.i1.d.c.e.d() > 0) {
                    string = getString(h.swanapp_completion_text) + "(" + d.a.l0.a.i1.d.c.e.d() + SmallTailInfo.EMOTION_SUFFIX;
                } else {
                    string = getString(h.swanapp_completion_text);
                }
                this.mDoneTv.setText(string);
                updateThumbnailView();
                return;
            }
            int d2 = d.a.l0.a.i1.d.c.e.d();
            if (d2 == d.a.l0.a.i1.d.c.d.f46545c) {
                d.a.l0.a.i1.d.c.d.j(d.a.l0.a.i1.d.c.d.f46546d);
            } else if (d2 > 0 && TextUtils.equals(d.a.l0.a.i1.d.c.d.f46546d, "single") && !TextUtils.equals(d.a.l0.a.i1.d.c.e.b(), mediaModel.e())) {
                d.a.l0.a.z1.b.f.e.f(this, h.swanapp_album_select_single).F();
            } else if (mediaModel.c() > 52428800 && TextUtils.equals(mediaModel.e(), "image")) {
                d.a.l0.a.z1.b.f.e.f(this, h.swanapp_album_photo_too_big).F();
            } else {
                int d3 = d.a.l0.a.i1.d.c.e.d();
                this.mThumbnailAdapter.notifyItemInserted(d3);
                d.a.l0.a.i1.d.c.e.i(mediaModel);
                if (this.mThumbnailAdapter.m() == null) {
                    this.mThumbnailAdapter.q(d.a.l0.a.i1.d.c.e.e());
                }
                this.mThumbnailView.smoothScrollToPosition(d3);
                this.mSelectNumTv.setVisibility(0);
                this.mSelectNumTv.setText(getSelectNum(mediaModel));
                this.mSelectNumTv.setBackgroundResource(d.a.l0.a.e.swanapp_album_preview_select_bg);
                this.mDoneTv.setText(getString(h.swanapp_completion_text) + "(" + d.a.l0.a.i1.d.c.e.d() + SmallTailInfo.EMOTION_SUFFIX);
                this.mDoneTv.setTextColor(getResources().getColor(d.a.l0.a.c.swanapp_album_preview_select_done_color));
                updateThumbnailView();
            }
        } else if (view == this.mDoneTv) {
            if (d.a.l0.a.i1.d.c.e.d() == 0 && (arrayList = this.mList) != null && arrayList.size() > 0 && this.mIndex < this.mList.size()) {
                d.a.l0.a.i1.d.c.e.i(mediaModel);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.a.l0.a.i1.d.c.d.f46547e);
            bundle.putString("swanAppId", d.a.l0.a.i1.d.c.d.f46548f);
            bundle.putParcelableArrayList("mediaModels", d.a.l0.a.i1.d.c.e.e());
            bundle.putString("swanTmpPath", d.a.l0.a.i1.d.c.d.j);
            d.a.l0.a.i1.d.c.d.g(this, bundle);
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void onClose() {
        finish();
        overridePendingTransition(d.a.l0.a.a.swanapp_album_preview_enter, d.a.l0.a.a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.b
    public void onClosing(int i2) {
        setOtherViewAlpha(i2);
        setBackGroundAlpha(i2);
        if (i2 != 0 && this.mDragActionOver) {
            setRootViewBackground(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.mDragView.setBackground(new ColorDrawable(0));
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter = this.mAdapter;
            if (swanAppAlbumPreviewAdapter != null) {
                swanAppAlbumPreviewAdapter.u(this.mIndex, 0);
            }
            this.mDragActionOver = false;
        }
        if (i2 == 0) {
            setRootViewBackground(new ColorDrawable(0));
            this.mDragView.setBackgroundColor(-16777216);
            SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter2 = this.mAdapter;
            if (swanAppAlbumPreviewAdapter2 != null) {
                swanAppAlbumPreviewAdapter2.u(this.mIndex, -16777216);
            }
            this.mDragActionOver = true;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, d.a.l0.o.a.a.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int Z = q0.Z(this);
        super.onCreate(bundle);
        q0.g(this, Z);
        setTranslucentStatus();
        d.a.l0.a.z1.a.c cVar = new d.a.l0.a.z1.a.c(this);
        this.mTintManager = cVar;
        cVar.b(false);
        getWindow().setFlags(1024, 1024);
        setContentView(g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle e2 = v.e(getIntent(), "launchParams");
            this.mIndex = v.f(e2, "previewPosition", 0);
            String g2 = v.g(e2, "previewFrom");
            this.mFrom = g2;
            if (TextUtils.equals(g2, "bottomPreview")) {
                ArrayList<MediaModel> arrayList = new ArrayList<>();
                this.mList = arrayList;
                arrayList.addAll(d.a.l0.a.i1.d.c.e.e());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.mList = e2 == null ? null : e2.getParcelableArrayList("mediaModels");
            } else {
                this.mList = d.a.l0.a.i1.d.c.d.c();
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
            swanAppAlbumPreviewAdapter.k();
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
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            backDown();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // d.a.l0.a.i1.d.d.f
    public void onMove(int i2, int i3) {
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

    @Override // d.a.l0.a.i1.d.d.a
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
