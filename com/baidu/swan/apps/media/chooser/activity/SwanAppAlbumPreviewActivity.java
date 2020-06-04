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
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.s;
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
    private DragView ckV;
    private RecyclerView ckW;
    private ImageView ckX;
    private View ckY;
    private View ckZ;
    private TextView cla;
    private TextView clb;
    private View clc;
    private View cld;
    private d cle;
    private SwanAppAlbumPreviewAdapter clf;
    private c clg;
    private ArrayList<MediaModel> clk;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean clh = true;
    private boolean cli = true;
    private boolean clj = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener cll = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.aiK();
            SwanAppAlbumPreviewActivity.this.aiJ();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.clf.aiT();
        }
    };

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = aj.releaseFixedOrientation(this);
        super.onCreate(bundle);
        aj.fixedOrientation(this, releaseFixedOrientation);
        aiG();
        this.cle = new d(this);
        this.cle.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = s.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = s.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = s.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.clk = new ArrayList<>();
                this.clk.addAll(e.aiX());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.clk = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.clk = com.baidu.swan.apps.media.chooser.b.d.aiW();
            }
            if (this.clk == null) {
                this.clk = new ArrayList<>();
            }
        }
        initView();
        aiJ();
        aiH();
        aiF();
    }

    private void aiF() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.cla.setVisibility(8);
            this.clc.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void aiG() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.ckV = (DragView) findViewById(a.f.drag_view);
        this.ckV.setOnCloseListener(this);
        this.ckV.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.ckX = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.ckZ = findViewById(a.f.album_preview_back_layout);
        this.ckY = findViewById(a.f.album_preview_select_view);
        this.cla = (TextView) findViewById(a.f.album_preview_done);
        this.clb = (TextView) findViewById(a.f.album_preview_select);
        this.clc = findViewById(a.f.album_preview_bottom);
        this.cld = findViewById(a.f.album_preview_header);
        this.ckZ.setOnClickListener(this);
        this.cla.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.cll);
        this.clf = new SwanAppAlbumPreviewAdapter(this, this.clk);
        this.mViewPager.setAdapter(this.clf);
        this.clf.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.ckY.setOnClickListener(this);
        this.cla.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.cla.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.cla.setText(string);
    }

    private void aiH() {
        ArrayList<MediaModel> aiX;
        this.ckW = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.ckW.setLayoutManager(linearLayoutManager);
        this.clg = new c(this);
        this.ckW.setAdapter(this.clg);
        if (e.aiX() == null) {
            aiX = null;
        } else {
            aiX = e.aiX();
        }
        this.clg.n(aiX);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.clg));
        itemTouchHelper.attachToRecyclerView(this.ckW);
        final com.baidu.swan.apps.media.chooser.b.a a = a(this.mViewPager);
        this.ckW.addOnItemTouchListener(new f(this.ckW) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.clk != null) {
                    MediaModel fO = SwanAppAlbumPreviewActivity.this.clg.fO(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.clk.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.clk.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.clk.get(i)).equals(fO)) {
                            a.eh(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a.eh(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> aiU = SwanAppAlbumPreviewActivity.this.clg.aiU();
                if (viewHolder.getLayoutPosition() >= 0 && aiU != null && viewHolder.getLayoutPosition() != aiU.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        aiI();
        aiK();
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
    public void ag(int i, int i2) {
        if (this.clk != null && this.mIndex < this.clk.size()) {
            this.clb.setText(a(this.clk.get(this.mIndex)));
        }
    }

    private void aiI() {
        ArrayList<MediaModel> aiX = e.aiX();
        ViewGroup.LayoutParams layoutParams = this.clc.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (aiX != null && aiX.size() > 0) {
            this.ckW.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.ckW.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiJ() {
        if (this.clk != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.clk.size()) {
                mediaModel = this.clk.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.clb.setVisibility(0);
                    this.clb.setText(a(this.clk.get(this.mIndex)));
                    this.clb.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.clb.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.ckX.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.ckX.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiK() {
        final int b;
        if (this.clg != null && this.mIndex < this.clk.size() && (b = this.clg.b(this.clk.get(this.mIndex))) >= 0) {
            if (b + 1 < this.clg.getItemCount()) {
                this.ckW.smoothScrollToPosition(b + 1);
            } else {
                this.ckW.smoothScrollToPosition(b);
            }
            this.ckW.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.ckW.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.ckW.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.ckZ) {
            aiL();
            finish();
        } else if (this.clk != null && this.mIndex < this.clk.size()) {
            MediaModel mediaModel = this.clk.get(this.mIndex);
            if (view == this.ckY) {
                if (e.g(mediaModel)) {
                    this.clg.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.clg.n(null);
                    }
                    this.clb.setVisibility(8);
                    this.ckX.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.cla.setText(string);
                    aiI();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.cmm) {
                    com.baidu.swan.apps.media.chooser.b.d.lH(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.aiY(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.k(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.clg.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.clg.aiU() == null) {
                        this.clg.n(e.aiX());
                    }
                    this.ckW.smoothScrollToPosition(selectedCount2);
                    this.clb.setVisibility(0);
                    this.clb.setText(a(mediaModel));
                    this.clb.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.cla.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.cla.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    aiI();
                }
            } else if (view == this.cla) {
                if (e.getSelectedCount() == 0 && this.clk != null && this.clk.size() > 0 && this.mIndex < this.clk.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.ckw);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.cmn);
                bundle.putParcelableArrayList("mediaModels", e.aiX());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.cmp);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aiL();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aiL() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.clf != null) {
            this.clf.destroy();
            this.clf = null;
        }
        this.clg = null;
        this.cle = null;
        if (this.clk != null) {
            this.clk = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aiM() {
        if (!this.clj && this.cli) {
            aiN();
        } else if (!this.clj) {
            aiO();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aiN() {
        if (this.cli) {
            this.clj = true;
            float y = this.cld.getY();
            float y2 = this.clc.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cld, "y", y, y - this.cld.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.clj = false;
                    SwanAppAlbumPreviewActivity.this.cli = SwanAppAlbumPreviewActivity.this.cli ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.clc, "y", y2, y2 + this.clc.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aiO() {
        if (!this.cli) {
            this.clj = true;
            float y = this.cld.getY();
            float y2 = this.clc.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cld, "y", y, y + this.cld.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.clj = false;
                    SwanAppAlbumPreviewActivity.this.cli = SwanAppAlbumPreviewActivity.this.cli ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.clc, "y", y2, y2 - this.clc.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0281a.swanapp_album_preview_enter, a.C0281a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void fK(int i) {
        fL(i);
        fM(i);
        if (i != 0 && this.clh) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.ckV.setBackground(new ColorDrawable(0));
            if (this.clf != null) {
                this.clf.ah(this.mIndex, a.c.aiapps_transparent);
            }
            this.clh = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.ckV.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.clf != null) {
                this.clf.ah(this.mIndex, a.c.aiapps_black);
            }
            this.clh = true;
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

    private void fL(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.clc != null) {
            this.clc.setAlpha(1.0f - f);
        }
        if (this.cld != null) {
            this.cld.setAlpha(1.0f - f);
        }
    }

    private void fM(int i) {
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
