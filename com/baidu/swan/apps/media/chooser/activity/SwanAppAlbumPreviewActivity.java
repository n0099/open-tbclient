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
/* loaded from: classes10.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements View.OnClickListener, a, g, DragView.a {
    private static final boolean DEBUG = b.DEBUG;
    private ArrayList<MediaModel> aiK;
    private DragView dce;
    private RecyclerView dcf;
    private ImageView dcg;
    private View dch;
    private View dci;
    private TextView dcj;
    private TextView dck;
    private View dcl;
    private View dcm;
    private d dcn;
    private SwanAppAlbumPreviewAdapter dco;
    private c dcp;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean dcq = true;
    private boolean dcr = true;
    private boolean dcs = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener dct = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.aAI();
            SwanAppAlbumPreviewActivity.this.aAH();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.dco.aAR();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        aAE();
        this.dcn = new d(this);
        this.dcn.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = u.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = u.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.aiK = new ArrayList<>();
                this.aiK.addAll(e.aAV());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.aiK = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.aiK = com.baidu.swan.apps.media.chooser.b.d.aAU();
            }
            if (this.aiK == null) {
                this.aiK = new ArrayList<>();
            }
        }
        initView();
        aAH();
        aAF();
        aAD();
    }

    private void aAD() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.dcj.setVisibility(8);
            this.dcl.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void aAE() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.dce = (DragView) findViewById(a.f.drag_view);
        this.dce.setOnCloseListener(this);
        this.dce.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.dcg = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.dci = findViewById(a.f.album_preview_back_layout);
        this.dch = findViewById(a.f.album_preview_select_view);
        this.dcj = (TextView) findViewById(a.f.album_preview_done);
        this.dck = (TextView) findViewById(a.f.album_preview_select);
        this.dcl = findViewById(a.f.album_preview_bottom);
        this.dcm = findViewById(a.f.album_preview_header);
        this.dci.setOnClickListener(this);
        this.dcj.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.dct);
        this.dco = new SwanAppAlbumPreviewAdapter(this, this.aiK);
        this.mViewPager.setAdapter(this.dco);
        this.dco.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.dch.setOnClickListener(this);
        this.dcj.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.dcj.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.dcj.setText(string);
    }

    private void aAF() {
        ArrayList<MediaModel> aAV;
        this.dcf = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.dcf.setLayoutManager(linearLayoutManager);
        this.dcp = new c(this);
        this.dcf.setAdapter(this.dcp);
        if (e.aAV() == null) {
            aAV = null;
        } else {
            aAV = e.aAV();
        }
        this.dcp.s(aAV);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.dcp));
        itemTouchHelper.attachToRecyclerView(this.dcf);
        final com.baidu.swan.apps.media.chooser.b.a a2 = a(this.mViewPager);
        this.dcf.addOnItemTouchListener(new f(this.dcf) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.aiK != null) {
                    MediaModel jp = SwanAppAlbumPreviewActivity.this.dcp.jp(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.aiK.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.aiK.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.aiK.get(i)).equals(jp)) {
                            a2.fB(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a2.fB(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> aAS = SwanAppAlbumPreviewActivity.this.dcp.aAS();
                if (viewHolder.getLayoutPosition() >= 0 && aAS != null && viewHolder.getLayoutPosition() != aAS.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        aAG();
        aAI();
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
        if (this.aiK != null && this.mIndex < this.aiK.size()) {
            this.dck.setText(a(this.aiK.get(this.mIndex)));
        }
    }

    private void aAG() {
        ArrayList<MediaModel> aAV = e.aAV();
        ViewGroup.LayoutParams layoutParams = this.dcl.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (aAV != null && aAV.size() > 0) {
            this.dcf.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.dcf.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAH() {
        if (this.aiK != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.aiK.size()) {
                mediaModel = this.aiK.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.dck.setVisibility(0);
                    this.dck.setText(a(this.aiK.get(this.mIndex)));
                    this.dck.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.dck.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.dcg.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.dcg.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAI() {
        final int b;
        if (this.dcp != null && this.mIndex < this.aiK.size() && (b = this.dcp.b(this.aiK.get(this.mIndex))) >= 0) {
            if (b + 1 < this.dcp.getItemCount()) {
                this.dcf.smoothScrollToPosition(b + 1);
            } else {
                this.dcf.smoothScrollToPosition(b);
            }
            this.dcf.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.dcf.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.dcf.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.dci) {
            aAJ();
            finish();
        } else if (this.aiK != null && this.mIndex < this.aiK.size()) {
            MediaModel mediaModel = this.aiK.get(this.mIndex);
            if (view == this.dch) {
                if (e.g(mediaModel)) {
                    this.dcp.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.dcp.s(null);
                    }
                    this.dck.setVisibility(8);
                    this.dcg.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.dcj.setText(string);
                    aAG();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.ddr) {
                    com.baidu.swan.apps.media.chooser.b.d.qc(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.aAW(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.k(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.dcp.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.dcp.aAS() == null) {
                        this.dcp.s(e.aAV());
                    }
                    this.dcf.smoothScrollToPosition(selectedCount2);
                    this.dck.setVisibility(0);
                    this.dck.setText(a(mediaModel));
                    this.dck.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.dcj.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.dcj.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    aAG();
                }
            } else if (view == this.dcj) {
                if (e.getSelectedCount() == 0 && this.aiK != null && this.aiK.size() > 0 && this.mIndex < this.aiK.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.dbG);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.dds);
                bundle.putParcelableArrayList("mediaModels", e.aAV());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.ddv);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aAJ();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aAJ() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dco != null) {
            this.dco.destroy();
            this.dco = null;
        }
        this.dcp = null;
        this.dcn = null;
        if (this.aiK != null) {
            this.aiK = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aAK() {
        if (!this.dcs && this.dcr) {
            aAL();
        } else if (!this.dcs) {
            aAM();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aAL() {
        if (this.dcr) {
            this.dcs = true;
            float y = this.dcm.getY();
            float y2 = this.dcl.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dcm, "y", y, y - this.dcm.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.dcs = false;
                    SwanAppAlbumPreviewActivity.this.dcr = SwanAppAlbumPreviewActivity.this.dcr ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dcl, "y", y2, y2 + this.dcl.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aAM() {
        if (!this.dcr) {
            this.dcs = true;
            float y = this.dcm.getY();
            float y2 = this.dcl.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dcm, "y", y, y + this.dcm.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.dcs = false;
                    SwanAppAlbumPreviewActivity.this.dcr = SwanAppAlbumPreviewActivity.this.dcr ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dcl, "y", y2, y2 - this.dcl.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0369a.swanapp_album_preview_enter, a.C0369a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void jl(int i) {
        jm(i);
        jn(i);
        if (i != 0 && this.dcq) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.dce.setBackground(new ColorDrawable(0));
            if (this.dco != null) {
                this.dco.ao(this.mIndex, a.c.aiapps_transparent);
            }
            this.dcq = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.dce.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.dco != null) {
                this.dco.ao(this.mIndex, a.c.aiapps_black);
            }
            this.dcq = true;
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

    private void jm(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.dcl != null) {
            this.dcl.setAlpha(1.0f - f);
        }
        if (this.dcm != null) {
            this.dcm.setAlpha(1.0f - f);
        }
    }

    private void jn(int i) {
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
