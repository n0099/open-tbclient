package com.baidu.swan.apps.media.chooser.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
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
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter;
import com.baidu.swan.apps.media.chooser.adapter.c;
import com.baidu.swan.apps.media.chooser.b.e;
import com.baidu.swan.apps.media.chooser.c.a;
import com.baidu.swan.apps.media.chooser.c.f;
import com.baidu.swan.apps.media.chooser.c.g;
import com.baidu.swan.apps.media.chooser.c.h;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.res.ui.d;
import com.baidu.swan.apps.view.DragView;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements View.OnClickListener, a, g, DragView.a {
    private static final boolean DEBUG = b.DEBUG;
    private DragView bwU;
    private RecyclerView bwV;
    private View bwW;
    private TextView bwX;
    private TextView bwY;
    private d bwZ;
    private SwanAppAlbumPreviewAdapter bxa;
    private c bxb;
    private ArrayList<MediaModel> bxd;
    private View mBottomView;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mPhotoHeader;
    private View mRootView;
    private ImageView mSelectImg;
    private View mSelectView;
    private ViewPager mViewPager;
    private boolean bxc = true;
    private boolean mBarShowing = true;
    private boolean mAnimation = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.UL();
            SwanAppAlbumPreviewActivity.this.UK();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.bxa.US();
        }
    };

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ai.fixedOrientation(this, releaseFixedOrientation);
        UH();
        this.bwZ = new d(this);
        this.bwZ.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = r.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = r.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = r.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.bxd = new ArrayList<>();
                this.bxd.addAll(e.UW());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.bxd = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.bxd = com.baidu.swan.apps.media.chooser.b.d.UV();
            }
            if (this.bxd == null) {
                this.bxd = new ArrayList<>();
            }
        }
        initView();
        UK();
        UI();
        UG();
    }

    private void UG() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.bwX.setVisibility(8);
            this.mBottomView.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void UH() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.bwU = (DragView) findViewById(a.f.drag_view);
        this.bwU.setOnCloseListener(this);
        this.bwU.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.mSelectImg = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.bwW = findViewById(a.f.album_preview_back_layout);
        this.mSelectView = findViewById(a.f.album_preview_select_view);
        this.bwX = (TextView) findViewById(a.f.album_preview_done);
        this.bwY = (TextView) findViewById(a.f.album_preview_select);
        this.mBottomView = findViewById(a.f.album_preview_bottom);
        this.mPhotoHeader = findViewById(a.f.album_preview_header);
        this.bwW.setOnClickListener(this);
        this.bwX.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.pageChangeListener);
        this.bxa = new SwanAppAlbumPreviewAdapter(this, this.bxd);
        this.mViewPager.setAdapter(this.bxa);
        this.bxa.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.mSelectView.setOnClickListener(this);
        this.bwX.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.bwX.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.bwX.setText(string);
    }

    private void UI() {
        ArrayList<MediaModel> UW;
        this.bwV = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
        this.mLineView = findViewById(a.f.album_preview_line);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.1
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.1.1
                    @Override // android.support.v7.widget.LinearSmoothScroller
                    public PointF computeScrollVectorForPosition(int i2) {
                        return super.computeScrollVectorForPosition(i2);
                    }

                    @Override // android.support.v7.widget.LinearSmoothScroller
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return (SwanAppAlbumPreviewActivity.this.getResources().getDisplayMetrics().density * 0.3f) / displayMetrics.density;
                    }
                };
                linearSmoothScroller.setTargetPosition(i);
                startSmoothScroll(linearSmoothScroller);
            }
        };
        linearLayoutManager.setOrientation(0);
        this.bwV.setLayoutManager(linearLayoutManager);
        this.bxb = new c(this);
        this.bwV.setAdapter(this.bxb);
        if (e.UW() == null) {
            UW = null;
        } else {
            UW = e.UW();
        }
        this.bxb.l(UW);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.bxb));
        itemTouchHelper.attachToRecyclerView(this.bwV);
        final com.baidu.swan.apps.media.chooser.b.a a = a(this.mViewPager);
        this.bwV.addOnItemTouchListener(new f(this.bwV) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.bxd != null) {
                    MediaModel fa = SwanAppAlbumPreviewActivity.this.bxb.fa(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.bxd.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.bxd.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.bxd.get(i)).equals(fa)) {
                            a.cH(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a.cH(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> UT = SwanAppAlbumPreviewActivity.this.bxb.UT();
                if (viewHolder.getLayoutPosition() >= 0 && UT != null && viewHolder.getLayoutPosition() != UT.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        UJ();
        UL();
    }

    private com.baidu.swan.apps.media.chooser.b.a a(ViewPager viewPager) {
        com.baidu.swan.apps.media.chooser.b.a aVar = new com.baidu.swan.apps.media.chooser.b.a(viewPager.getContext());
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, aVar);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return aVar;
    }

    @Override // com.baidu.swan.apps.media.chooser.c.g
    public void W(int i, int i2) {
        if (this.bxd != null && this.mIndex < this.bxd.size()) {
            this.bwY.setText(a(this.bxd.get(this.mIndex)));
        }
    }

    private void UJ() {
        ArrayList<MediaModel> UW = e.UW();
        ViewGroup.LayoutParams layoutParams = this.mBottomView.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (UW != null && UW.size() > 0) {
            this.bwV.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.bwV.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UK() {
        if (this.bxd != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.bxd.size()) {
                mediaModel = this.bxd.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.bwY.setVisibility(0);
                    this.bwY.setText(a(this.bxd.get(this.mIndex)));
                    this.bwY.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.bwY.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.mSelectImg.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.mSelectImg.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UL() {
        final int b;
        if (this.bxb != null && this.mIndex < this.bxd.size() && (b = this.bxb.b(this.bxd.get(this.mIndex))) >= 0) {
            if (b + 1 < this.bxb.getItemCount()) {
                this.bwV.smoothScrollToPosition(b + 1);
            } else {
                this.bwV.smoothScrollToPosition(b);
            }
            this.bwV.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.bwV.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.bwV.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.bwW) {
            backDown();
            finish();
        } else if (this.bxd != null && this.mIndex < this.bxd.size()) {
            MediaModel mediaModel = this.bxd.get(this.mIndex);
            if (view == this.mSelectView) {
                if (e.g(mediaModel)) {
                    this.bxb.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.bxb.l(null);
                    }
                    this.bwY.setVisibility(8);
                    this.mSelectImg.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.bwX.setText(string);
                    UJ();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.mMaxSelected) {
                    com.baidu.swan.apps.media.chooser.b.d.iQ(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.UX(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.q(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.bxb.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.bxb.UT() == null) {
                        this.bxb.l(e.UW());
                    }
                    this.bwV.smoothScrollToPosition(selectedCount2);
                    this.bwY.setVisibility(0);
                    this.bwY.setText(a(mediaModel));
                    this.bwY.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.bwX.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.bwX.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    UJ();
                }
            } else if (view == this.bwX) {
                if (e.getSelectedCount() == 0 && this.bxd != null && this.bxd.size() > 0 && this.mIndex < this.bxd.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.bwz);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.bxY);
                bundle.putParcelableArrayList("mediaModels", e.UW());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.bya);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            backDown();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void backDown() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bxa != null) {
            this.bxa.destroy();
            this.bxa = null;
        }
        this.bxb = null;
        this.bwZ = null;
        if (this.bxd != null) {
            this.bxd = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void clickContainer() {
        if (!this.mAnimation && this.mBarShowing) {
            UM();
        } else if (!this.mAnimation) {
            UN();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void UM() {
        if (this.mBarShowing) {
            this.mAnimation = true;
            float y = this.mPhotoHeader.getY();
            float y2 = this.mBottomView.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mPhotoHeader, "y", y, y - this.mPhotoHeader.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.mAnimation = false;
                    SwanAppAlbumPreviewActivity.this.mBarShowing = SwanAppAlbumPreviewActivity.this.mBarShowing ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mBottomView, "y", y2, y2 + this.mBottomView.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void UN() {
        if (!this.mBarShowing) {
            this.mAnimation = true;
            float y = this.mPhotoHeader.getY();
            float y2 = this.mBottomView.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mPhotoHeader, "y", y, y + this.mPhotoHeader.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.mAnimation = false;
                    SwanAppAlbumPreviewActivity.this.mBarShowing = SwanAppAlbumPreviewActivity.this.mBarShowing ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mBottomView, "y", y2, y2 - this.mBottomView.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0185a.swanapp_album_preview_enter, a.C0185a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClosing(int i) {
        eX(i);
        eY(i);
        if (i != 0 && this.bxc) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.bwU.setBackground(new ColorDrawable(0));
            if (this.bxa != null) {
                this.bxa.X(this.mIndex, a.c.aiapps_transparent);
            }
            this.bxc = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.bwU.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.bxa != null) {
                this.bxa.X(this.mIndex, a.c.aiapps_black);
            }
            this.bxc = true;
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onDragViewTouchEvent(MotionEvent motionEvent) {
    }

    public void c(Drawable drawable) {
        if (this.mRootView != null) {
            this.mRootView.setBackground(drawable);
        }
    }

    private void eX(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.mBottomView != null) {
            this.mBottomView.setAlpha(1.0f - f);
        }
        if (this.mPhotoHeader != null) {
            this.mPhotoHeader.setAlpha(1.0f - f);
        }
    }

    private void eY(int i) {
        int i2;
        int abs = Math.abs(i);
        if (abs >= 0 && abs < 300.0f) {
            i2 = (int) (255.0f - ((abs / 300.0f) * 20.0f));
        } else if (abs >= 300.0f) {
            i2 = (int) (235 - (((abs - 300.0f) / 900.0f) * 235));
        } else {
            i2 = 0;
        }
        Drawable mutate = this.mRootView.getBackground().mutate();
        if (i2 < 0) {
            i2 = 0;
        }
        mutate.setAlpha(i2);
    }

    private String a(MediaModel mediaModel) {
        return String.valueOf(e.d(mediaModel) + 1);
    }
}
