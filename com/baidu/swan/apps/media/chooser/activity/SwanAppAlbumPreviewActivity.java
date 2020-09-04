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
    private ArrayList<MediaModel> ahW;
    private DragView czI;
    private RecyclerView czJ;
    private ImageView czK;
    private View czL;
    private View czM;
    private TextView czN;
    private TextView czO;
    private View czP;
    private View czQ;
    private d czR;
    private SwanAppAlbumPreviewAdapter czS;
    private c czT;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean czU = true;
    private boolean czV = true;
    private boolean czW = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener czX = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
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
            SwanAppAlbumPreviewActivity.this.czS.atd();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        asQ();
        this.czR = new d(this);
        this.czR.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = u.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = u.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.ahW = new ArrayList<>();
                this.ahW.addAll(e.ath());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.ahW = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.ahW = com.baidu.swan.apps.media.chooser.b.d.atg();
            }
            if (this.ahW == null) {
                this.ahW = new ArrayList<>();
            }
        }
        initView();
        asT();
        asR();
        asP();
    }

    private void asP() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.czN.setVisibility(8);
            this.czP.setVisibility(8);
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
        this.czI = (DragView) findViewById(a.f.drag_view);
        this.czI.setOnCloseListener(this);
        this.czI.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.czK = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.czM = findViewById(a.f.album_preview_back_layout);
        this.czL = findViewById(a.f.album_preview_select_view);
        this.czN = (TextView) findViewById(a.f.album_preview_done);
        this.czO = (TextView) findViewById(a.f.album_preview_select);
        this.czP = findViewById(a.f.album_preview_bottom);
        this.czQ = findViewById(a.f.album_preview_header);
        this.czM.setOnClickListener(this);
        this.czN.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.czX);
        this.czS = new SwanAppAlbumPreviewAdapter(this, this.ahW);
        this.mViewPager.setAdapter(this.czS);
        this.czS.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.czL.setOnClickListener(this);
        this.czN.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.czN.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.czN.setText(string);
    }

    private void asR() {
        ArrayList<MediaModel> ath;
        this.czJ = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.czJ.setLayoutManager(linearLayoutManager);
        this.czT = new c(this);
        this.czJ.setAdapter(this.czT);
        if (e.ath() == null) {
            ath = null;
        } else {
            ath = e.ath();
        }
        this.czT.s(ath);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.czT));
        itemTouchHelper.attachToRecyclerView(this.czJ);
        final com.baidu.swan.apps.media.chooser.b.a a = a(this.mViewPager);
        this.czJ.addOnItemTouchListener(new f(this.czJ) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.ahW != null) {
                    MediaModel in = SwanAppAlbumPreviewActivity.this.czT.in(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.ahW.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.ahW.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.ahW.get(i)).equals(in)) {
                            a.eL(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a.eL(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> ate = SwanAppAlbumPreviewActivity.this.czT.ate();
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
        if (this.ahW != null && this.mIndex < this.ahW.size()) {
            this.czO.setText(a(this.ahW.get(this.mIndex)));
        }
    }

    private void asS() {
        ArrayList<MediaModel> ath = e.ath();
        ViewGroup.LayoutParams layoutParams = this.czP.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (ath != null && ath.size() > 0) {
            this.czJ.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.czJ.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asT() {
        if (this.ahW != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.ahW.size()) {
                mediaModel = this.ahW.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.czO.setVisibility(0);
                    this.czO.setText(a(this.ahW.get(this.mIndex)));
                    this.czO.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.czO.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.czK.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.czK.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asU() {
        final int b;
        if (this.czT != null && this.mIndex < this.ahW.size() && (b = this.czT.b(this.ahW.get(this.mIndex))) >= 0) {
            if (b + 1 < this.czT.getItemCount()) {
                this.czJ.smoothScrollToPosition(b + 1);
            } else {
                this.czJ.smoothScrollToPosition(b);
            }
            this.czJ.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.czJ.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.czJ.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.czM) {
            asV();
            finish();
        } else if (this.ahW != null && this.mIndex < this.ahW.size()) {
            MediaModel mediaModel = this.ahW.get(this.mIndex);
            if (view == this.czL) {
                if (e.g(mediaModel)) {
                    this.czT.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.czT.s(null);
                    }
                    this.czO.setVisibility(8);
                    this.czK.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.czN.setText(string);
                    asS();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.cAV) {
                    com.baidu.swan.apps.media.chooser.b.d.oq(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.ati(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.k(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.czT.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.czT.ate() == null) {
                        this.czT.s(e.ath());
                    }
                    this.czJ.smoothScrollToPosition(selectedCount2);
                    this.czO.setVisibility(0);
                    this.czO.setText(a(mediaModel));
                    this.czO.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.czN.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.czN.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    asS();
                }
            } else if (view == this.czN) {
                if (e.getSelectedCount() == 0 && this.ahW != null && this.ahW.size() > 0 && this.mIndex < this.ahW.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.czk);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.cAW);
                bundle.putParcelableArrayList("mediaModels", e.ath());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.cAY);
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
        if (this.czS != null) {
            this.czS.destroy();
            this.czS = null;
        }
        this.czT = null;
        this.czR = null;
        if (this.ahW != null) {
            this.ahW = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void asW() {
        if (!this.czW && this.czV) {
            asX();
        } else if (!this.czW) {
            asY();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void asX() {
        if (this.czV) {
            this.czW = true;
            float y = this.czQ.getY();
            float y2 = this.czP.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.czQ, "y", y, y - this.czQ.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.czW = false;
                    SwanAppAlbumPreviewActivity.this.czV = SwanAppAlbumPreviewActivity.this.czV ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.czP, "y", y2, y2 + this.czP.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void asY() {
        if (!this.czV) {
            this.czW = true;
            float y = this.czQ.getY();
            float y2 = this.czP.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.czQ, "y", y, y + this.czQ.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.czW = false;
                    SwanAppAlbumPreviewActivity.this.czV = SwanAppAlbumPreviewActivity.this.czV ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.czP, "y", y2, y2 - this.czP.getHeight());
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
        if (i != 0 && this.czU) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.czI.setBackground(new ColorDrawable(0));
            if (this.czS != null) {
                this.czS.ao(this.mIndex, a.c.aiapps_transparent);
            }
            this.czU = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.czI.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.czS != null) {
                this.czS.ao(this.mIndex, a.c.aiapps_black);
            }
            this.czU = true;
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
        if (this.czP != null) {
            this.czP.setAlpha(1.0f - f);
        }
        if (this.czQ != null) {
            this.czQ.setAlpha(1.0f - f);
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
