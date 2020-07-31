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
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.u;
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
/* loaded from: classes7.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements View.OnClickListener, a, g, DragView.a {
    private static final boolean DEBUG = b.DEBUG;
    private ArrayList<MediaModel> agL;
    private DragView crP;
    private RecyclerView crQ;
    private ImageView crR;
    private View crS;
    private View crT;
    private TextView crU;
    private TextView crV;
    private View crW;
    private View crX;
    private d crY;
    private SwanAppAlbumPreviewAdapter crZ;
    private c csa;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean csb = true;
    private boolean csc = true;
    private boolean csd = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener cse = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.alg();
            SwanAppAlbumPreviewActivity.this.alf();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.crZ.alp();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = al.releaseFixedOrientation(this);
        super.onCreate(bundle);
        al.fixedOrientation(this, releaseFixedOrientation);
        alc();
        this.crY = new d(this);
        this.crY.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = u.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = u.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.agL = new ArrayList<>();
                this.agL.addAll(e.alt());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.agL = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.agL = com.baidu.swan.apps.media.chooser.b.d.als();
            }
            if (this.agL == null) {
                this.agL = new ArrayList<>();
            }
        }
        initView();
        alf();
        ald();
        alb();
    }

    private void alb() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.crU.setVisibility(8);
            this.crW.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void alc() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.crP = (DragView) findViewById(a.f.drag_view);
        this.crP.setOnCloseListener(this);
        this.crP.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.crR = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.crT = findViewById(a.f.album_preview_back_layout);
        this.crS = findViewById(a.f.album_preview_select_view);
        this.crU = (TextView) findViewById(a.f.album_preview_done);
        this.crV = (TextView) findViewById(a.f.album_preview_select);
        this.crW = findViewById(a.f.album_preview_bottom);
        this.crX = findViewById(a.f.album_preview_header);
        this.crT.setOnClickListener(this);
        this.crU.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.cse);
        this.crZ = new SwanAppAlbumPreviewAdapter(this, this.agL);
        this.mViewPager.setAdapter(this.crZ);
        this.crZ.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.crS.setOnClickListener(this);
        this.crU.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.crU.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.crU.setText(string);
    }

    private void ald() {
        ArrayList<MediaModel> alt;
        this.crQ = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.crQ.setLayoutManager(linearLayoutManager);
        this.csa = new c(this);
        this.crQ.setAdapter(this.csa);
        if (e.alt() == null) {
            alt = null;
        } else {
            alt = e.alt();
        }
        this.csa.n(alt);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.csa));
        itemTouchHelper.attachToRecyclerView(this.crQ);
        final com.baidu.swan.apps.media.chooser.b.a a = a(this.mViewPager);
        this.crQ.addOnItemTouchListener(new f(this.crQ) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.agL != null) {
                    MediaModel gj = SwanAppAlbumPreviewActivity.this.csa.gj(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.agL.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.agL.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.agL.get(i)).equals(gj)) {
                            a.eu(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a.eu(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> alq = SwanAppAlbumPreviewActivity.this.csa.alq();
                if (viewHolder.getLayoutPosition() >= 0 && alq != null && viewHolder.getLayoutPosition() != alq.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        ale();
        alg();
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
    public void ai(int i, int i2) {
        if (this.agL != null && this.mIndex < this.agL.size()) {
            this.crV.setText(a(this.agL.get(this.mIndex)));
        }
    }

    private void ale() {
        ArrayList<MediaModel> alt = e.alt();
        ViewGroup.LayoutParams layoutParams = this.crW.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (alt != null && alt.size() > 0) {
            this.crQ.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.crQ.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alf() {
        if (this.agL != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.agL.size()) {
                mediaModel = this.agL.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.crV.setVisibility(0);
                    this.crV.setText(a(this.agL.get(this.mIndex)));
                    this.crV.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.crV.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.crR.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.crR.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alg() {
        final int b;
        if (this.csa != null && this.mIndex < this.agL.size() && (b = this.csa.b(this.agL.get(this.mIndex))) >= 0) {
            if (b + 1 < this.csa.getItemCount()) {
                this.crQ.smoothScrollToPosition(b + 1);
            } else {
                this.crQ.smoothScrollToPosition(b);
            }
            this.crQ.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.crQ.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.crQ.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.crT) {
            alh();
            finish();
        } else if (this.agL != null && this.mIndex < this.agL.size()) {
            MediaModel mediaModel = this.agL.get(this.mIndex);
            if (view == this.crS) {
                if (e.g(mediaModel)) {
                    this.csa.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.csa.n(null);
                    }
                    this.crV.setVisibility(8);
                    this.crR.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.crU.setText(string);
                    ale();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.ctd) {
                    com.baidu.swan.apps.media.chooser.b.d.mq(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.alu(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.k(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.csa.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.csa.alq() == null) {
                        this.csa.n(e.alt());
                    }
                    this.crQ.smoothScrollToPosition(selectedCount2);
                    this.crV.setVisibility(0);
                    this.crV.setText(a(mediaModel));
                    this.crV.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.crU.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.crU.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    ale();
                }
            } else if (view == this.crU) {
                if (e.getSelectedCount() == 0 && this.agL != null && this.agL.size() > 0 && this.mIndex < this.agL.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.crr);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.cte);
                bundle.putParcelableArrayList("mediaModels", e.alt());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.ctg);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            alh();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void alh() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.crZ != null) {
            this.crZ.destroy();
            this.crZ = null;
        }
        this.csa = null;
        this.crY = null;
        if (this.agL != null) {
            this.agL = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void ali() {
        if (!this.csd && this.csc) {
            alj();
        } else if (!this.csd) {
            alk();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void alj() {
        if (this.csc) {
            this.csd = true;
            float y = this.crX.getY();
            float y2 = this.crW.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.crX, "y", y, y - this.crX.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.csd = false;
                    SwanAppAlbumPreviewActivity.this.csc = SwanAppAlbumPreviewActivity.this.csc ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.crW, "y", y2, y2 + this.crW.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void alk() {
        if (!this.csc) {
            this.csd = true;
            float y = this.crX.getY();
            float y2 = this.crW.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.crX, "y", y, y + this.crX.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.csd = false;
                    SwanAppAlbumPreviewActivity.this.csc = SwanAppAlbumPreviewActivity.this.csc ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.crW, "y", y2, y2 - this.crW.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0290a.swanapp_album_preview_enter, a.C0290a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void gf(int i) {
        gg(i);
        gh(i);
        if (i != 0 && this.csb) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.crP.setBackground(new ColorDrawable(0));
            if (this.crZ != null) {
                this.crZ.aj(this.mIndex, a.c.aiapps_transparent);
            }
            this.csb = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.crP.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.crZ != null) {
                this.crZ.aj(this.mIndex, a.c.aiapps_black);
            }
            this.csb = true;
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

    private void gg(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.crW != null) {
            this.crW.setAlpha(1.0f - f);
        }
        if (this.crX != null) {
            this.crX.setAlpha(1.0f - f);
        }
    }

    private void gh(int i) {
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
