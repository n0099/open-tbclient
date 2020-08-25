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
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.u;
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
/* loaded from: classes8.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements View.OnClickListener, a, g, DragView.a {
    private static final boolean DEBUG = b.DEBUG;
    private ArrayList<MediaModel> ahU;
    private DragView czE;
    private RecyclerView czF;
    private ImageView czG;
    private View czH;
    private View czI;
    private TextView czJ;
    private TextView czK;
    private View czL;
    private View czM;
    private d czN;
    private SwanAppAlbumPreviewAdapter czO;
    private c czP;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean czQ = true;
    private boolean czR = true;
    private boolean czS = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener czT = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.asU();
            SwanAppAlbumPreviewActivity.this.asT();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.czO.atd();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        asQ();
        this.czN = new d(this);
        this.czN.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = u.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = u.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.ahU = new ArrayList<>();
                this.ahU.addAll(e.ath());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.ahU = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.ahU = com.baidu.swan.apps.media.chooser.b.d.atg();
            }
            if (this.ahU == null) {
                this.ahU = new ArrayList<>();
            }
        }
        initView();
        asT();
        asR();
        asP();
    }

    private void asP() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.czJ.setVisibility(8);
            this.czL.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void asQ() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.czE = (DragView) findViewById(a.f.drag_view);
        this.czE.setOnCloseListener(this);
        this.czE.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.czG = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.czI = findViewById(a.f.album_preview_back_layout);
        this.czH = findViewById(a.f.album_preview_select_view);
        this.czJ = (TextView) findViewById(a.f.album_preview_done);
        this.czK = (TextView) findViewById(a.f.album_preview_select);
        this.czL = findViewById(a.f.album_preview_bottom);
        this.czM = findViewById(a.f.album_preview_header);
        this.czI.setOnClickListener(this);
        this.czJ.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.czT);
        this.czO = new SwanAppAlbumPreviewAdapter(this, this.ahU);
        this.mViewPager.setAdapter(this.czO);
        this.czO.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.czH.setOnClickListener(this);
        this.czJ.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.czJ.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.czJ.setText(string);
    }

    private void asR() {
        ArrayList<MediaModel> ath;
        this.czF = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.czF.setLayoutManager(linearLayoutManager);
        this.czP = new c(this);
        this.czF.setAdapter(this.czP);
        if (e.ath() == null) {
            ath = null;
        } else {
            ath = e.ath();
        }
        this.czP.s(ath);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.czP));
        itemTouchHelper.attachToRecyclerView(this.czF);
        final com.baidu.swan.apps.media.chooser.b.a a = a(this.mViewPager);
        this.czF.addOnItemTouchListener(new f(this.czF) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.ahU != null) {
                    MediaModel in = SwanAppAlbumPreviewActivity.this.czP.in(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.ahU.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.ahU.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.ahU.get(i)).equals(in)) {
                            a.eK(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a.eK(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> ate = SwanAppAlbumPreviewActivity.this.czP.ate();
                if (viewHolder.getLayoutPosition() >= 0 && ate != null && viewHolder.getLayoutPosition() != ate.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        asS();
        asU();
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
    public void an(int i, int i2) {
        if (this.ahU != null && this.mIndex < this.ahU.size()) {
            this.czK.setText(a(this.ahU.get(this.mIndex)));
        }
    }

    private void asS() {
        ArrayList<MediaModel> ath = e.ath();
        ViewGroup.LayoutParams layoutParams = this.czL.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (ath != null && ath.size() > 0) {
            this.czF.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.czF.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asT() {
        if (this.ahU != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.ahU.size()) {
                mediaModel = this.ahU.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.czK.setVisibility(0);
                    this.czK.setText(a(this.ahU.get(this.mIndex)));
                    this.czK.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.czK.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.czG.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.czG.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asU() {
        final int b;
        if (this.czP != null && this.mIndex < this.ahU.size() && (b = this.czP.b(this.ahU.get(this.mIndex))) >= 0) {
            if (b + 1 < this.czP.getItemCount()) {
                this.czF.smoothScrollToPosition(b + 1);
            } else {
                this.czF.smoothScrollToPosition(b);
            }
            this.czF.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.czF.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.czF.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.czI) {
            asV();
            finish();
        } else if (this.ahU != null && this.mIndex < this.ahU.size()) {
            MediaModel mediaModel = this.ahU.get(this.mIndex);
            if (view == this.czH) {
                if (e.g(mediaModel)) {
                    this.czP.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.czP.s(null);
                    }
                    this.czK.setVisibility(8);
                    this.czG.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.czJ.setText(string);
                    asS();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.cAR) {
                    com.baidu.swan.apps.media.chooser.b.d.op(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.ati(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.k(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.czP.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.czP.ate() == null) {
                        this.czP.s(e.ath());
                    }
                    this.czF.smoothScrollToPosition(selectedCount2);
                    this.czK.setVisibility(0);
                    this.czK.setText(a(mediaModel));
                    this.czK.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.czJ.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.czJ.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    asS();
                }
            } else if (view == this.czJ) {
                if (e.getSelectedCount() == 0 && this.ahU != null && this.ahU.size() > 0 && this.mIndex < this.ahU.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.czg);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.cAS);
                bundle.putParcelableArrayList("mediaModels", e.ath());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.cAU);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            asV();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void asV() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.czO != null) {
            this.czO.destroy();
            this.czO = null;
        }
        this.czP = null;
        this.czN = null;
        if (this.ahU != null) {
            this.ahU = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void asW() {
        if (!this.czS && this.czR) {
            asX();
        } else if (!this.czS) {
            asY();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void asX() {
        if (this.czR) {
            this.czS = true;
            float y = this.czM.getY();
            float y2 = this.czL.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.czM, "y", y, y - this.czM.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.czS = false;
                    SwanAppAlbumPreviewActivity.this.czR = SwanAppAlbumPreviewActivity.this.czR ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.czL, "y", y2, y2 + this.czL.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void asY() {
        if (!this.czR) {
            this.czS = true;
            float y = this.czM.getY();
            float y2 = this.czL.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.czM, "y", y, y + this.czM.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.czS = false;
                    SwanAppAlbumPreviewActivity.this.czR = SwanAppAlbumPreviewActivity.this.czR ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.czL, "y", y2, y2 - this.czL.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0331a.swanapp_album_preview_enter, a.C0331a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void ij(int i) {
        ik(i);
        il(i);
        if (i != 0 && this.czQ) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.czE.setBackground(new ColorDrawable(0));
            if (this.czO != null) {
                this.czO.ao(this.mIndex, a.c.aiapps_transparent);
            }
            this.czQ = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.czE.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.czO != null) {
                this.czO.ao(this.mIndex, a.c.aiapps_black);
            }
            this.czQ = true;
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void z(MotionEvent motionEvent) {
    }

    public void c(Drawable drawable) {
        if (this.mRootView != null) {
            this.mRootView.setBackground(drawable);
        }
    }

    private void ik(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.czL != null) {
            this.czL.setAlpha(1.0f - f);
        }
        if (this.czM != null) {
            this.czM.setAlpha(1.0f - f);
        }
    }

    private void il(int i) {
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
