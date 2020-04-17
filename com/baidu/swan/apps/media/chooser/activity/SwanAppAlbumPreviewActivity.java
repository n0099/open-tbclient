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
    private ArrayList<MediaModel> caB;
    private DragView cam;
    private RecyclerView can;
    private ImageView cao;
    private View cap;
    private View caq;
    private TextView car;
    private TextView cas;
    private View cat;
    private View cau;
    private d cav;
    private SwanAppAlbumPreviewAdapter caw;
    private c cax;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean cay = true;
    private boolean caz = true;
    private boolean caA = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener caC = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.afw();
            SwanAppAlbumPreviewActivity.this.afv();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.caw.afF();
        }
    };

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ai.fixedOrientation(this, releaseFixedOrientation);
        afs();
        this.cav = new d(this);
        this.cav.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = r.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = r.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = r.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.caB = new ArrayList<>();
                this.caB.addAll(e.afJ());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.caB = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.caB = com.baidu.swan.apps.media.chooser.b.d.afI();
            }
            if (this.caB == null) {
                this.caB = new ArrayList<>();
            }
        }
        initView();
        afv();
        aft();
        afr();
    }

    private void afr() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.car.setVisibility(8);
            this.cat.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void afs() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.cam = (DragView) findViewById(a.f.drag_view);
        this.cam.setOnCloseListener(this);
        this.cam.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.cao = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.caq = findViewById(a.f.album_preview_back_layout);
        this.cap = findViewById(a.f.album_preview_select_view);
        this.car = (TextView) findViewById(a.f.album_preview_done);
        this.cas = (TextView) findViewById(a.f.album_preview_select);
        this.cat = findViewById(a.f.album_preview_bottom);
        this.cau = findViewById(a.f.album_preview_header);
        this.caq.setOnClickListener(this);
        this.car.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.caC);
        this.caw = new SwanAppAlbumPreviewAdapter(this, this.caB);
        this.mViewPager.setAdapter(this.caw);
        this.caw.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.cap.setOnClickListener(this);
        this.car.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.car.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.car.setText(string);
    }

    private void aft() {
        ArrayList<MediaModel> afJ;
        this.can = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.can.setLayoutManager(linearLayoutManager);
        this.cax = new c(this);
        this.can.setAdapter(this.cax);
        if (e.afJ() == null) {
            afJ = null;
        } else {
            afJ = e.afJ();
        }
        this.cax.n(afJ);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.cax));
        itemTouchHelper.attachToRecyclerView(this.can);
        final com.baidu.swan.apps.media.chooser.b.a a = a(this.mViewPager);
        this.can.addOnItemTouchListener(new f(this.can) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.caB != null) {
                    MediaModel fy = SwanAppAlbumPreviewActivity.this.cax.fy(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.caB.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.caB.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.caB.get(i)).equals(fy)) {
                            a.dQ(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a.dQ(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> afG = SwanAppAlbumPreviewActivity.this.cax.afG();
                if (viewHolder.getLayoutPosition() >= 0 && afG != null && viewHolder.getLayoutPosition() != afG.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        afu();
        afw();
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
    public void ad(int i, int i2) {
        if (this.caB != null && this.mIndex < this.caB.size()) {
            this.cas.setText(a(this.caB.get(this.mIndex)));
        }
    }

    private void afu() {
        ArrayList<MediaModel> afJ = e.afJ();
        ViewGroup.LayoutParams layoutParams = this.cat.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (afJ != null && afJ.size() > 0) {
            this.can.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.can.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afv() {
        if (this.caB != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.caB.size()) {
                mediaModel = this.caB.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.cas.setVisibility(0);
                    this.cas.setText(a(this.caB.get(this.mIndex)));
                    this.cas.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.cas.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.cao.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.cao.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afw() {
        final int b;
        if (this.cax != null && this.mIndex < this.caB.size() && (b = this.cax.b(this.caB.get(this.mIndex))) >= 0) {
            if (b + 1 < this.cax.getItemCount()) {
                this.can.smoothScrollToPosition(b + 1);
            } else {
                this.can.smoothScrollToPosition(b);
            }
            this.can.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.can.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.can.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.caq) {
            afx();
            finish();
        } else if (this.caB != null && this.mIndex < this.caB.size()) {
            MediaModel mediaModel = this.caB.get(this.mIndex);
            if (view == this.cap) {
                if (e.g(mediaModel)) {
                    this.cax.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.cax.n(null);
                    }
                    this.cas.setVisibility(8);
                    this.cao.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.car.setText(string);
                    afu();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.cbC) {
                    com.baidu.swan.apps.media.chooser.b.d.ku(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.afK(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.k(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.cax.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.cax.afG() == null) {
                        this.cax.n(e.afJ());
                    }
                    this.can.smoothScrollToPosition(selectedCount2);
                    this.cas.setVisibility(0);
                    this.cas.setText(a(mediaModel));
                    this.cas.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.car.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.car.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    afu();
                }
            } else if (view == this.car) {
                if (e.getSelectedCount() == 0 && this.caB != null && this.caB.size() > 0 && this.mIndex < this.caB.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.bZN);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.cbD);
                bundle.putParcelableArrayList("mediaModels", e.afJ());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.cbF);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            afx();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void afx() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.caw != null) {
            this.caw.destroy();
            this.caw = null;
        }
        this.cax = null;
        this.cav = null;
        if (this.caB != null) {
            this.caB = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void afy() {
        if (!this.caA && this.caz) {
            afz();
        } else if (!this.caA) {
            afA();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void afz() {
        if (this.caz) {
            this.caA = true;
            float y = this.cau.getY();
            float y2 = this.cat.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cau, "y", y, y - this.cau.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.caA = false;
                    SwanAppAlbumPreviewActivity.this.caz = SwanAppAlbumPreviewActivity.this.caz ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cat, "y", y2, y2 + this.cat.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void afA() {
        if (!this.caz) {
            this.caA = true;
            float y = this.cau.getY();
            float y2 = this.cat.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cau, "y", y, y + this.cau.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.caA = false;
                    SwanAppAlbumPreviewActivity.this.caz = SwanAppAlbumPreviewActivity.this.caz ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cat, "y", y2, y2 - this.cat.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0227a.swanapp_album_preview_enter, a.C0227a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void fu(int i) {
        fv(i);
        fw(i);
        if (i != 0 && this.cay) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.cam.setBackground(new ColorDrawable(0));
            if (this.caw != null) {
                this.caw.ae(this.mIndex, a.c.aiapps_transparent);
            }
            this.cay = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.cam.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.caw != null) {
                this.caw.ae(this.mIndex, a.c.aiapps_black);
            }
            this.cay = true;
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void k(MotionEvent motionEvent) {
    }

    public void c(Drawable drawable) {
        if (this.mRootView != null) {
            this.mRootView.setBackground(drawable);
        }
    }

    private void fv(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.cat != null) {
            this.cat.setAlpha(1.0f - f);
        }
        if (this.cau != null) {
            this.cau.setAlpha(1.0f - f);
        }
    }

    private void fw(int i) {
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
