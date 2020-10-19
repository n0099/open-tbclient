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
    private ArrayList<MediaModel> aiJ;
    private DragView cNO;
    private RecyclerView cNP;
    private ImageView cNQ;
    private View cNR;
    private View cNS;
    private TextView cNT;
    private TextView cNU;
    private View cNV;
    private View cNW;
    private d cNX;
    private SwanAppAlbumPreviewAdapter cNY;
    private c cNZ;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean cOa = true;
    private boolean cOb = true;
    private boolean cOc = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener cOd = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.awo();
            SwanAppAlbumPreviewActivity.this.awn();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.cNY.awx();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        awk();
        this.cNX = new d(this);
        this.cNX.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = u.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = u.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.aiJ = new ArrayList<>();
                this.aiJ.addAll(e.awB());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.aiJ = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.aiJ = com.baidu.swan.apps.media.chooser.b.d.awA();
            }
            if (this.aiJ == null) {
                this.aiJ = new ArrayList<>();
            }
        }
        initView();
        awn();
        awl();
        awj();
    }

    private void awj() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.cNT.setVisibility(8);
            this.cNV.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void awk() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.cNO = (DragView) findViewById(a.f.drag_view);
        this.cNO.setOnCloseListener(this);
        this.cNO.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.cNQ = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.cNS = findViewById(a.f.album_preview_back_layout);
        this.cNR = findViewById(a.f.album_preview_select_view);
        this.cNT = (TextView) findViewById(a.f.album_preview_done);
        this.cNU = (TextView) findViewById(a.f.album_preview_select);
        this.cNV = findViewById(a.f.album_preview_bottom);
        this.cNW = findViewById(a.f.album_preview_header);
        this.cNS.setOnClickListener(this);
        this.cNT.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.cOd);
        this.cNY = new SwanAppAlbumPreviewAdapter(this, this.aiJ);
        this.mViewPager.setAdapter(this.cNY);
        this.cNY.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.cNR.setOnClickListener(this);
        this.cNT.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.cNT.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.cNT.setText(string);
    }

    private void awl() {
        ArrayList<MediaModel> awB;
        this.cNP = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.cNP.setLayoutManager(linearLayoutManager);
        this.cNZ = new c(this);
        this.cNP.setAdapter(this.cNZ);
        if (e.awB() == null) {
            awB = null;
        } else {
            awB = e.awB();
        }
        this.cNZ.s(awB);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.cNZ));
        itemTouchHelper.attachToRecyclerView(this.cNP);
        final com.baidu.swan.apps.media.chooser.b.a a2 = a(this.mViewPager);
        this.cNP.addOnItemTouchListener(new f(this.cNP) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.aiJ != null) {
                    MediaModel iU = SwanAppAlbumPreviewActivity.this.cNZ.iU(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.aiJ.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.aiJ.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.aiJ.get(i)).equals(iU)) {
                            a2.ff(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a2.ff(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> awy = SwanAppAlbumPreviewActivity.this.cNZ.awy();
                if (viewHolder.getLayoutPosition() >= 0 && awy != null && viewHolder.getLayoutPosition() != awy.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        awm();
        awo();
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
    public void am(int i, int i2) {
        if (this.aiJ != null && this.mIndex < this.aiJ.size()) {
            this.cNU.setText(a(this.aiJ.get(this.mIndex)));
        }
    }

    private void awm() {
        ArrayList<MediaModel> awB = e.awB();
        ViewGroup.LayoutParams layoutParams = this.cNV.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (awB != null && awB.size() > 0) {
            this.cNP.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.cNP.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awn() {
        if (this.aiJ != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.aiJ.size()) {
                mediaModel = this.aiJ.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.cNU.setVisibility(0);
                    this.cNU.setText(a(this.aiJ.get(this.mIndex)));
                    this.cNU.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.cNU.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.cNQ.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.cNQ.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awo() {
        final int b;
        if (this.cNZ != null && this.mIndex < this.aiJ.size() && (b = this.cNZ.b(this.aiJ.get(this.mIndex))) >= 0) {
            if (b + 1 < this.cNZ.getItemCount()) {
                this.cNP.smoothScrollToPosition(b + 1);
            } else {
                this.cNP.smoothScrollToPosition(b);
            }
            this.cNP.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.cNP.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.cNP.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.cNS) {
            awp();
            finish();
        } else if (this.aiJ != null && this.mIndex < this.aiJ.size()) {
            MediaModel mediaModel = this.aiJ.get(this.mIndex);
            if (view == this.cNR) {
                if (e.g(mediaModel)) {
                    this.cNZ.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.cNZ.s(null);
                    }
                    this.cNU.setVisibility(8);
                    this.cNQ.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.cNT.setText(string);
                    awm();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.cPa) {
                    com.baidu.swan.apps.media.chooser.b.d.pv(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.awC(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.k(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.cNZ.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.cNZ.awy() == null) {
                        this.cNZ.s(e.awB());
                    }
                    this.cNP.smoothScrollToPosition(selectedCount2);
                    this.cNU.setVisibility(0);
                    this.cNU.setText(a(mediaModel));
                    this.cNU.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.cNT.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.cNT.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    awm();
                }
            } else if (view == this.cNT) {
                if (e.getSelectedCount() == 0 && this.aiJ != null && this.aiJ.size() > 0 && this.mIndex < this.aiJ.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.cNq);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.cPb);
                bundle.putParcelableArrayList("mediaModels", e.awB());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.cPd);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            awp();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void awp() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cNY != null) {
            this.cNY.destroy();
            this.cNY = null;
        }
        this.cNZ = null;
        this.cNX = null;
        if (this.aiJ != null) {
            this.aiJ = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void awq() {
        if (!this.cOc && this.cOb) {
            awr();
        } else if (!this.cOc) {
            aws();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void awr() {
        if (this.cOb) {
            this.cOc = true;
            float y = this.cNW.getY();
            float y2 = this.cNV.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cNW, "y", y, y - this.cNW.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.cOc = false;
                    SwanAppAlbumPreviewActivity.this.cOb = SwanAppAlbumPreviewActivity.this.cOb ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cNV, "y", y2, y2 + this.cNV.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aws() {
        if (!this.cOb) {
            this.cOc = true;
            float y = this.cNW.getY();
            float y2 = this.cNV.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cNW, "y", y, y + this.cNW.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.cOc = false;
                    SwanAppAlbumPreviewActivity.this.cOb = SwanAppAlbumPreviewActivity.this.cOb ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cNV, "y", y2, y2 - this.cNV.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0343a.swanapp_album_preview_enter, a.C0343a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void iQ(int i) {
        iR(i);
        iS(i);
        if (i != 0 && this.cOa) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.cNO.setBackground(new ColorDrawable(0));
            if (this.cNY != null) {
                this.cNY.an(this.mIndex, a.c.aiapps_transparent);
            }
            this.cOa = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.cNO.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.cNY != null) {
                this.cNY.an(this.mIndex, a.c.aiapps_black);
            }
            this.cOa = true;
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

    private void iR(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.cNV != null) {
            this.cNV.setAlpha(1.0f - f);
        }
        if (this.cNW != null) {
            this.cNW.setAlpha(1.0f - f);
        }
    }

    private void iS(int i) {
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
