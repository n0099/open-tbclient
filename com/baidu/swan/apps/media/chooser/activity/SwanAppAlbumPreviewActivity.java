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
/* loaded from: classes10.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements View.OnClickListener, a, g, DragView.a {
    private static final boolean DEBUG = b.DEBUG;
    private DragView bxH;
    private RecyclerView bxI;
    private View bxJ;
    private TextView bxK;
    private TextView bxL;
    private d bxM;
    private SwanAppAlbumPreviewAdapter bxN;
    private c bxO;
    private ArrayList<MediaModel> bxQ;
    private View mBottomView;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mPhotoHeader;
    private View mRootView;
    private ImageView mSelectImg;
    private View mSelectView;
    private ViewPager mViewPager;
    private boolean bxP = true;
    private boolean mBarShowing = true;
    private boolean mAnimation = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.Vi();
            SwanAppAlbumPreviewActivity.this.Vh();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.bxN.Vp();
        }
    };

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ai.fixedOrientation(this, releaseFixedOrientation);
        Ve();
        this.bxM = new d(this);
        this.bxM.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = r.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = r.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = r.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.bxQ = new ArrayList<>();
                this.bxQ.addAll(e.Vt());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.bxQ = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.bxQ = com.baidu.swan.apps.media.chooser.b.d.Vs();
            }
            if (this.bxQ == null) {
                this.bxQ = new ArrayList<>();
            }
        }
        initView();
        Vh();
        Vf();
        Vd();
    }

    private void Vd() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.bxK.setVisibility(8);
            this.mBottomView.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void Ve() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.bxH = (DragView) findViewById(a.f.drag_view);
        this.bxH.setOnCloseListener(this);
        this.bxH.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.mSelectImg = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.bxJ = findViewById(a.f.album_preview_back_layout);
        this.mSelectView = findViewById(a.f.album_preview_select_view);
        this.bxK = (TextView) findViewById(a.f.album_preview_done);
        this.bxL = (TextView) findViewById(a.f.album_preview_select);
        this.mBottomView = findViewById(a.f.album_preview_bottom);
        this.mPhotoHeader = findViewById(a.f.album_preview_header);
        this.bxJ.setOnClickListener(this);
        this.bxK.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.pageChangeListener);
        this.bxN = new SwanAppAlbumPreviewAdapter(this, this.bxQ);
        this.mViewPager.setAdapter(this.bxN);
        this.bxN.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.mSelectView.setOnClickListener(this);
        this.bxK.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.bxK.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.bxK.setText(string);
    }

    private void Vf() {
        ArrayList<MediaModel> Vt;
        this.bxI = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.bxI.setLayoutManager(linearLayoutManager);
        this.bxO = new c(this);
        this.bxI.setAdapter(this.bxO);
        if (e.Vt() == null) {
            Vt = null;
        } else {
            Vt = e.Vt();
        }
        this.bxO.l(Vt);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.bxO));
        itemTouchHelper.attachToRecyclerView(this.bxI);
        final com.baidu.swan.apps.media.chooser.b.a a = a(this.mViewPager);
        this.bxI.addOnItemTouchListener(new f(this.bxI) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.bxQ != null) {
                    MediaModel fb = SwanAppAlbumPreviewActivity.this.bxO.fb(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.bxQ.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.bxQ.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.bxQ.get(i)).equals(fb)) {
                            a.cM(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a.cM(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> Vq = SwanAppAlbumPreviewActivity.this.bxO.Vq();
                if (viewHolder.getLayoutPosition() >= 0 && Vq != null && viewHolder.getLayoutPosition() != Vq.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        Vg();
        Vi();
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
    public void aa(int i, int i2) {
        if (this.bxQ != null && this.mIndex < this.bxQ.size()) {
            this.bxL.setText(a(this.bxQ.get(this.mIndex)));
        }
    }

    private void Vg() {
        ArrayList<MediaModel> Vt = e.Vt();
        ViewGroup.LayoutParams layoutParams = this.mBottomView.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (Vt != null && Vt.size() > 0) {
            this.bxI.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.bxI.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh() {
        if (this.bxQ != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.bxQ.size()) {
                mediaModel = this.bxQ.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.bxL.setVisibility(0);
                    this.bxL.setText(a(this.bxQ.get(this.mIndex)));
                    this.bxL.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.bxL.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.mSelectImg.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.mSelectImg.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vi() {
        final int b;
        if (this.bxO != null && this.mIndex < this.bxQ.size() && (b = this.bxO.b(this.bxQ.get(this.mIndex))) >= 0) {
            if (b + 1 < this.bxO.getItemCount()) {
                this.bxI.smoothScrollToPosition(b + 1);
            } else {
                this.bxI.smoothScrollToPosition(b);
            }
            this.bxI.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.bxI.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.bxI.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.bxJ) {
            backDown();
            finish();
        } else if (this.bxQ != null && this.mIndex < this.bxQ.size()) {
            MediaModel mediaModel = this.bxQ.get(this.mIndex);
            if (view == this.mSelectView) {
                if (e.g(mediaModel)) {
                    this.bxO.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.bxO.l(null);
                    }
                    this.bxL.setVisibility(8);
                    this.mSelectImg.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.bxK.setText(string);
                    Vg();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.mMaxSelected) {
                    com.baidu.swan.apps.media.chooser.b.d.iT(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.Vu(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.q(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.bxO.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.bxO.Vq() == null) {
                        this.bxO.l(e.Vt());
                    }
                    this.bxI.smoothScrollToPosition(selectedCount2);
                    this.bxL.setVisibility(0);
                    this.bxL.setText(a(mediaModel));
                    this.bxL.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.bxK.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.bxK.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    Vg();
                }
            } else if (view == this.bxK) {
                if (e.getSelectedCount() == 0 && this.bxQ != null && this.bxQ.size() > 0 && this.mIndex < this.bxQ.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.bxm);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.byL);
                bundle.putParcelableArrayList("mediaModels", e.Vt());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.byN);
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
        if (this.bxN != null) {
            this.bxN.destroy();
            this.bxN = null;
        }
        this.bxO = null;
        this.bxM = null;
        if (this.bxQ != null) {
            this.bxQ = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void clickContainer() {
        if (!this.mAnimation && this.mBarShowing) {
            Vj();
        } else if (!this.mAnimation) {
            Vk();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void Vj() {
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
    public void Vk() {
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
        overridePendingTransition(a.C0187a.swanapp_album_preview_enter, a.C0187a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClosing(int i) {
        eY(i);
        eZ(i);
        if (i != 0 && this.bxP) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.bxH.setBackground(new ColorDrawable(0));
            if (this.bxN != null) {
                this.bxN.ab(this.mIndex, a.c.aiapps_transparent);
            }
            this.bxP = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.bxH.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.bxN != null) {
                this.bxN.ab(this.mIndex, a.c.aiapps_black);
            }
            this.bxP = true;
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

    private void eY(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.mBottomView != null) {
            this.mBottomView.setAlpha(1.0f - f);
        }
        if (this.mPhotoHeader != null) {
            this.mPhotoHeader.setAlpha(1.0f - f);
        }
    }

    private void eZ(int i) {
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
