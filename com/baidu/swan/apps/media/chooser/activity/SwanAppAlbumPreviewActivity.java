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
    private DragView bCb;
    private RecyclerView bCc;
    private View bCd;
    private TextView bCe;
    private TextView bCf;
    private d bCg;
    private SwanAppAlbumPreviewAdapter bCh;
    private c bCi;
    private ArrayList<MediaModel> bCk;
    private View mBottomView;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mPhotoHeader;
    private View mRootView;
    private ImageView mSelectImg;
    private View mSelectView;
    private ViewPager mViewPager;
    private boolean bCj = true;
    private boolean mBarShowing = true;
    private boolean mAnimation = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.XB();
            SwanAppAlbumPreviewActivity.this.XA();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.bCh.XI();
        }
    };

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ai.fixedOrientation(this, releaseFixedOrientation);
        Xx();
        this.bCg = new d(this);
        this.bCg.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = r.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = r.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = r.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.bCk = new ArrayList<>();
                this.bCk.addAll(e.XM());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.bCk = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.bCk = com.baidu.swan.apps.media.chooser.b.d.XL();
            }
            if (this.bCk == null) {
                this.bCk = new ArrayList<>();
            }
        }
        initView();
        XA();
        Xy();
        Xw();
    }

    private void Xw() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.bCe.setVisibility(8);
            this.mBottomView.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void Xx() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.bCb = (DragView) findViewById(a.f.drag_view);
        this.bCb.setOnCloseListener(this);
        this.bCb.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.mSelectImg = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.bCd = findViewById(a.f.album_preview_back_layout);
        this.mSelectView = findViewById(a.f.album_preview_select_view);
        this.bCe = (TextView) findViewById(a.f.album_preview_done);
        this.bCf = (TextView) findViewById(a.f.album_preview_select);
        this.mBottomView = findViewById(a.f.album_preview_bottom);
        this.mPhotoHeader = findViewById(a.f.album_preview_header);
        this.bCd.setOnClickListener(this);
        this.bCe.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.pageChangeListener);
        this.bCh = new SwanAppAlbumPreviewAdapter(this, this.bCk);
        this.mViewPager.setAdapter(this.bCh);
        this.bCh.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.mSelectView.setOnClickListener(this);
        this.bCe.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.bCe.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.bCe.setText(string);
    }

    private void Xy() {
        ArrayList<MediaModel> XM;
        this.bCc = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.bCc.setLayoutManager(linearLayoutManager);
        this.bCi = new c(this);
        this.bCc.setAdapter(this.bCi);
        if (e.XM() == null) {
            XM = null;
        } else {
            XM = e.XM();
        }
        this.bCi.n(XM);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.bCi));
        itemTouchHelper.attachToRecyclerView(this.bCc);
        final com.baidu.swan.apps.media.chooser.b.a a = a(this.mViewPager);
        this.bCc.addOnItemTouchListener(new f(this.bCc) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.bCk != null) {
                    MediaModel fr = SwanAppAlbumPreviewActivity.this.bCi.fr(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.bCk.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.bCk.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.bCk.get(i)).equals(fr)) {
                            a.cU(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a.cU(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> XJ = SwanAppAlbumPreviewActivity.this.bCi.XJ();
                if (viewHolder.getLayoutPosition() >= 0 && XJ != null && viewHolder.getLayoutPosition() != XJ.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        Xz();
        XB();
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
        if (this.bCk != null && this.mIndex < this.bCk.size()) {
            this.bCf.setText(a(this.bCk.get(this.mIndex)));
        }
    }

    private void Xz() {
        ArrayList<MediaModel> XM = e.XM();
        ViewGroup.LayoutParams layoutParams = this.mBottomView.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (XM != null && XM.size() > 0) {
            this.bCc.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.bCc.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XA() {
        if (this.bCk != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.bCk.size()) {
                mediaModel = this.bCk.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.bCf.setVisibility(0);
                    this.bCf.setText(a(this.bCk.get(this.mIndex)));
                    this.bCf.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.bCf.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.mSelectImg.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.mSelectImg.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XB() {
        final int b;
        if (this.bCi != null && this.mIndex < this.bCk.size() && (b = this.bCi.b(this.bCk.get(this.mIndex))) >= 0) {
            if (b + 1 < this.bCi.getItemCount()) {
                this.bCc.smoothScrollToPosition(b + 1);
            } else {
                this.bCc.smoothScrollToPosition(b);
            }
            this.bCc.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.bCc.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.bCc.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.bCd) {
            backDown();
            finish();
        } else if (this.bCk != null && this.mIndex < this.bCk.size()) {
            MediaModel mediaModel = this.bCk.get(this.mIndex);
            if (view == this.mSelectView) {
                if (e.g(mediaModel)) {
                    this.bCi.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.bCi.n(null);
                    }
                    this.bCf.setVisibility(8);
                    this.mSelectImg.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.bCe.setText(string);
                    Xz();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.mMaxSelected) {
                    com.baidu.swan.apps.media.chooser.b.d.jh(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.XN(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.q(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.bCi.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.bCi.XJ() == null) {
                        this.bCi.n(e.XM());
                    }
                    this.bCc.smoothScrollToPosition(selectedCount2);
                    this.bCf.setVisibility(0);
                    this.bCf.setText(a(mediaModel));
                    this.bCf.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.bCe.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.bCe.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    Xz();
                }
            } else if (view == this.bCe) {
                if (e.getSelectedCount() == 0 && this.bCk != null && this.bCk.size() > 0 && this.mIndex < this.bCk.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.bBG);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.bDf);
                bundle.putParcelableArrayList("mediaModels", e.XM());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.bDh);
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
        if (this.bCh != null) {
            this.bCh.destroy();
            this.bCh = null;
        }
        this.bCi = null;
        this.bCg = null;
        if (this.bCk != null) {
            this.bCk = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void clickContainer() {
        if (!this.mAnimation && this.mBarShowing) {
            XC();
        } else if (!this.mAnimation) {
            XD();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void XC() {
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
    public void XD() {
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
        if (i != 0 && this.bCj) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.bCb.setBackground(new ColorDrawable(0));
            if (this.bCh != null) {
                this.bCh.ab(this.mIndex, a.c.aiapps_transparent);
            }
            this.bCj = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.bCb.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.bCh != null) {
                this.bCh.ab(this.mIndex, a.c.aiapps_black);
            }
            this.bCj = true;
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
