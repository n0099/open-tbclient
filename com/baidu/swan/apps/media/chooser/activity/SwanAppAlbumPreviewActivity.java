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
/* loaded from: classes11.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements View.OnClickListener, a, g, DragView.a {
    private static final boolean DEBUG = b.DEBUG;
    private DragView bBP;
    private RecyclerView bBQ;
    private View bBR;
    private TextView bBS;
    private TextView bBT;
    private d bBU;
    private SwanAppAlbumPreviewAdapter bBV;
    private c bBW;
    private ArrayList<MediaModel> bBY;
    private View mBottomView;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mPhotoHeader;
    private View mRootView;
    private ImageView mSelectImg;
    private View mSelectView;
    private ViewPager mViewPager;
    private boolean bBX = true;
    private boolean mBarShowing = true;
    private boolean mAnimation = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.Xy();
            SwanAppAlbumPreviewActivity.this.Xx();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.bBV.XF();
        }
    };

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ai.fixedOrientation(this, releaseFixedOrientation);
        Xu();
        this.bBU = new d(this);
        this.bBU.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = r.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = r.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = r.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.bBY = new ArrayList<>();
                this.bBY.addAll(e.XJ());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.bBY = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.bBY = com.baidu.swan.apps.media.chooser.b.d.XI();
            }
            if (this.bBY == null) {
                this.bBY = new ArrayList<>();
            }
        }
        initView();
        Xx();
        Xv();
        Xt();
    }

    private void Xt() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.bBS.setVisibility(8);
            this.mBottomView.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void Xu() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.bBP = (DragView) findViewById(a.f.drag_view);
        this.bBP.setOnCloseListener(this);
        this.bBP.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.mSelectImg = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.bBR = findViewById(a.f.album_preview_back_layout);
        this.mSelectView = findViewById(a.f.album_preview_select_view);
        this.bBS = (TextView) findViewById(a.f.album_preview_done);
        this.bBT = (TextView) findViewById(a.f.album_preview_select);
        this.mBottomView = findViewById(a.f.album_preview_bottom);
        this.mPhotoHeader = findViewById(a.f.album_preview_header);
        this.bBR.setOnClickListener(this);
        this.bBS.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.pageChangeListener);
        this.bBV = new SwanAppAlbumPreviewAdapter(this, this.bBY);
        this.mViewPager.setAdapter(this.bBV);
        this.bBV.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.mSelectView.setOnClickListener(this);
        this.bBS.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.bBS.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.bBS.setText(string);
    }

    private void Xv() {
        ArrayList<MediaModel> XJ;
        this.bBQ = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.bBQ.setLayoutManager(linearLayoutManager);
        this.bBW = new c(this);
        this.bBQ.setAdapter(this.bBW);
        if (e.XJ() == null) {
            XJ = null;
        } else {
            XJ = e.XJ();
        }
        this.bBW.n(XJ);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.bBW));
        itemTouchHelper.attachToRecyclerView(this.bBQ);
        final com.baidu.swan.apps.media.chooser.b.a a = a(this.mViewPager);
        this.bBQ.addOnItemTouchListener(new f(this.bBQ) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.bBY != null) {
                    MediaModel fr = SwanAppAlbumPreviewActivity.this.bBW.fr(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.bBY.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.bBY.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.bBY.get(i)).equals(fr)) {
                            a.cT(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a.cT(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> XG = SwanAppAlbumPreviewActivity.this.bBW.XG();
                if (viewHolder.getLayoutPosition() >= 0 && XG != null && viewHolder.getLayoutPosition() != XG.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        Xw();
        Xy();
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
        if (this.bBY != null && this.mIndex < this.bBY.size()) {
            this.bBT.setText(a(this.bBY.get(this.mIndex)));
        }
    }

    private void Xw() {
        ArrayList<MediaModel> XJ = e.XJ();
        ViewGroup.LayoutParams layoutParams = this.mBottomView.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (XJ != null && XJ.size() > 0) {
            this.bBQ.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.bBQ.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xx() {
        if (this.bBY != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.bBY.size()) {
                mediaModel = this.bBY.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.bBT.setVisibility(0);
                    this.bBT.setText(a(this.bBY.get(this.mIndex)));
                    this.bBT.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.bBT.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.mSelectImg.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.mSelectImg.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xy() {
        final int b;
        if (this.bBW != null && this.mIndex < this.bBY.size() && (b = this.bBW.b(this.bBY.get(this.mIndex))) >= 0) {
            if (b + 1 < this.bBW.getItemCount()) {
                this.bBQ.smoothScrollToPosition(b + 1);
            } else {
                this.bBQ.smoothScrollToPosition(b);
            }
            this.bBQ.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.bBQ.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.bBQ.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.bBR) {
            backDown();
            finish();
        } else if (this.bBY != null && this.mIndex < this.bBY.size()) {
            MediaModel mediaModel = this.bBY.get(this.mIndex);
            if (view == this.mSelectView) {
                if (e.g(mediaModel)) {
                    this.bBW.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.bBW.n(null);
                    }
                    this.bBT.setVisibility(8);
                    this.mSelectImg.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.bBS.setText(string);
                    Xw();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.mMaxSelected) {
                    com.baidu.swan.apps.media.chooser.b.d.ji(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.XK(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.q(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.bBW.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.bBW.XG() == null) {
                        this.bBW.n(e.XJ());
                    }
                    this.bBQ.smoothScrollToPosition(selectedCount2);
                    this.bBT.setVisibility(0);
                    this.bBT.setText(a(mediaModel));
                    this.bBT.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.bBS.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.bBS.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    Xw();
                }
            } else if (view == this.bBS) {
                if (e.getSelectedCount() == 0 && this.bBY != null && this.bBY.size() > 0 && this.mIndex < this.bBY.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.bBu);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.bCT);
                bundle.putParcelableArrayList("mediaModels", e.XJ());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.bCV);
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
        if (this.bBV != null) {
            this.bBV.destroy();
            this.bBV = null;
        }
        this.bBW = null;
        this.bBU = null;
        if (this.bBY != null) {
            this.bBY = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void clickContainer() {
        if (!this.mAnimation && this.mBarShowing) {
            Xz();
        } else if (!this.mAnimation) {
            XA();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void Xz() {
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
    public void XA() {
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
        overridePendingTransition(a.C0197a.swanapp_album_preview_enter, a.C0197a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClosing(int i) {
        fo(i);
        fp(i);
        if (i != 0 && this.bBX) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.bBP.setBackground(new ColorDrawable(0));
            if (this.bBV != null) {
                this.bBV.ab(this.mIndex, a.c.aiapps_transparent);
            }
            this.bBX = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.bBP.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.bBV != null) {
                this.bBV.ab(this.mIndex, a.c.aiapps_black);
            }
            this.bBX = true;
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

    private void fo(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.mBottomView != null) {
            this.mBottomView.setAlpha(1.0f - f);
        }
        if (this.mPhotoHeader != null) {
            this.mPhotoHeader.setAlpha(1.0f - f);
        }
    }

    private void fp(int i) {
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
