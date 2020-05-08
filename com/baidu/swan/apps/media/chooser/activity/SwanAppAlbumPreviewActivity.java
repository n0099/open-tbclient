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
    private View caA;
    private d caB;
    private SwanAppAlbumPreviewAdapter caC;
    private c caD;
    private ArrayList<MediaModel> caH;
    private DragView cas;
    private RecyclerView cat;
    private ImageView cau;
    private View cav;
    private View caw;
    private TextView cax;
    private TextView cay;
    private View caz;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean caE = true;
    private boolean caF = true;
    private boolean caG = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener caI = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.afv();
            SwanAppAlbumPreviewActivity.this.afu();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.caC.afE();
        }
    };

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ai.fixedOrientation(this, releaseFixedOrientation);
        afr();
        this.caB = new d(this);
        this.caB.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = r.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = r.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = r.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.caH = new ArrayList<>();
                this.caH.addAll(e.afI());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.caH = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.caH = com.baidu.swan.apps.media.chooser.b.d.afH();
            }
            if (this.caH == null) {
                this.caH = new ArrayList<>();
            }
        }
        initView();
        afu();
        afs();
        afq();
    }

    private void afq() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.cax.setVisibility(8);
            this.caz.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void afr() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.cas = (DragView) findViewById(a.f.drag_view);
        this.cas.setOnCloseListener(this);
        this.cas.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.cau = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.caw = findViewById(a.f.album_preview_back_layout);
        this.cav = findViewById(a.f.album_preview_select_view);
        this.cax = (TextView) findViewById(a.f.album_preview_done);
        this.cay = (TextView) findViewById(a.f.album_preview_select);
        this.caz = findViewById(a.f.album_preview_bottom);
        this.caA = findViewById(a.f.album_preview_header);
        this.caw.setOnClickListener(this);
        this.cax.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.caI);
        this.caC = new SwanAppAlbumPreviewAdapter(this, this.caH);
        this.mViewPager.setAdapter(this.caC);
        this.caC.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.cav.setOnClickListener(this);
        this.cax.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.cax.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.cax.setText(string);
    }

    private void afs() {
        ArrayList<MediaModel> afI;
        this.cat = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.cat.setLayoutManager(linearLayoutManager);
        this.caD = new c(this);
        this.cat.setAdapter(this.caD);
        if (e.afI() == null) {
            afI = null;
        } else {
            afI = e.afI();
        }
        this.caD.n(afI);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.caD));
        itemTouchHelper.attachToRecyclerView(this.cat);
        final com.baidu.swan.apps.media.chooser.b.a a = a(this.mViewPager);
        this.cat.addOnItemTouchListener(new f(this.cat) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.caH != null) {
                    MediaModel fy = SwanAppAlbumPreviewActivity.this.caD.fy(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.caH.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.caH.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.caH.get(i)).equals(fy)) {
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
                ArrayList<MediaModel> afF = SwanAppAlbumPreviewActivity.this.caD.afF();
                if (viewHolder.getLayoutPosition() >= 0 && afF != null && viewHolder.getLayoutPosition() != afF.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        aft();
        afv();
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
        if (this.caH != null && this.mIndex < this.caH.size()) {
            this.cay.setText(a(this.caH.get(this.mIndex)));
        }
    }

    private void aft() {
        ArrayList<MediaModel> afI = e.afI();
        ViewGroup.LayoutParams layoutParams = this.caz.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (afI != null && afI.size() > 0) {
            this.cat.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.cat.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afu() {
        if (this.caH != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.caH.size()) {
                mediaModel = this.caH.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.cay.setVisibility(0);
                    this.cay.setText(a(this.caH.get(this.mIndex)));
                    this.cay.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.cay.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.cau.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.cau.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afv() {
        final int b;
        if (this.caD != null && this.mIndex < this.caH.size() && (b = this.caD.b(this.caH.get(this.mIndex))) >= 0) {
            if (b + 1 < this.caD.getItemCount()) {
                this.cat.smoothScrollToPosition(b + 1);
            } else {
                this.cat.smoothScrollToPosition(b);
            }
            this.cat.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.cat.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.cat.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.caw) {
            afw();
            finish();
        } else if (this.caH != null && this.mIndex < this.caH.size()) {
            MediaModel mediaModel = this.caH.get(this.mIndex);
            if (view == this.cav) {
                if (e.g(mediaModel)) {
                    this.caD.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.caD.n(null);
                    }
                    this.cay.setVisibility(8);
                    this.cau.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.cax.setText(string);
                    aft();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.cbI) {
                    com.baidu.swan.apps.media.chooser.b.d.ku(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.afJ(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.k(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.caD.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.caD.afF() == null) {
                        this.caD.n(e.afI());
                    }
                    this.cat.smoothScrollToPosition(selectedCount2);
                    this.cay.setVisibility(0);
                    this.cay.setText(a(mediaModel));
                    this.cay.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.cax.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.cax.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    aft();
                }
            } else if (view == this.cax) {
                if (e.getSelectedCount() == 0 && this.caH != null && this.caH.size() > 0 && this.mIndex < this.caH.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.bZT);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.cbJ);
                bundle.putParcelableArrayList("mediaModels", e.afI());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.cbL);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            afw();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void afw() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.caC != null) {
            this.caC.destroy();
            this.caC = null;
        }
        this.caD = null;
        this.caB = null;
        if (this.caH != null) {
            this.caH = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void afx() {
        if (!this.caG && this.caF) {
            afy();
        } else if (!this.caG) {
            afz();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void afy() {
        if (this.caF) {
            this.caG = true;
            float y = this.caA.getY();
            float y2 = this.caz.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.caA, "y", y, y - this.caA.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.caG = false;
                    SwanAppAlbumPreviewActivity.this.caF = SwanAppAlbumPreviewActivity.this.caF ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.caz, "y", y2, y2 + this.caz.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void afz() {
        if (!this.caF) {
            this.caG = true;
            float y = this.caA.getY();
            float y2 = this.caz.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.caA, "y", y, y + this.caA.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.caG = false;
                    SwanAppAlbumPreviewActivity.this.caF = SwanAppAlbumPreviewActivity.this.caF ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.caz, "y", y2, y2 - this.caz.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0248a.swanapp_album_preview_enter, a.C0248a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void fu(int i) {
        fv(i);
        fw(i);
        if (i != 0 && this.caE) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.cas.setBackground(new ColorDrawable(0));
            if (this.caC != null) {
                this.caC.ae(this.mIndex, a.c.aiapps_transparent);
            }
            this.caE = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.cas.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.caC != null) {
                this.caC.ae(this.mIndex, a.c.aiapps_black);
            }
            this.caE = true;
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
        if (this.caz != null) {
            this.caz.setAlpha(1.0f - f);
        }
        if (this.caA != null) {
            this.caA.setAlpha(1.0f - f);
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
