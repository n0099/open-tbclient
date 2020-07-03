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
    private ArrayList<MediaModel> agU;
    private DragView cpL;
    private RecyclerView cpM;
    private ImageView cpN;
    private View cpO;
    private View cpP;
    private TextView cpQ;
    private TextView cpR;
    private View cpS;
    private View cpT;
    private d cpU;
    private SwanAppAlbumPreviewAdapter cpV;
    private c cpW;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean cpX = true;
    private boolean cpY = true;
    private boolean cpZ = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener cqa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.ajQ();
            SwanAppAlbumPreviewActivity.this.ajP();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.cpV.ajZ();
        }
    };

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = aj.releaseFixedOrientation(this);
        super.onCreate(bundle);
        aj.fixedOrientation(this, releaseFixedOrientation);
        ajM();
        this.cpU = new d(this);
        this.cpU.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = s.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = s.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = s.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.agU = new ArrayList<>();
                this.agU.addAll(e.akd());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.agU = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.agU = com.baidu.swan.apps.media.chooser.b.d.akc();
            }
            if (this.agU == null) {
                this.agU = new ArrayList<>();
            }
        }
        initView();
        ajP();
        ajN();
        ajL();
    }

    private void ajL() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.cpQ.setVisibility(8);
            this.cpS.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void ajM() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.cpL = (DragView) findViewById(a.f.drag_view);
        this.cpL.setOnCloseListener(this);
        this.cpL.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.cpN = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.cpP = findViewById(a.f.album_preview_back_layout);
        this.cpO = findViewById(a.f.album_preview_select_view);
        this.cpQ = (TextView) findViewById(a.f.album_preview_done);
        this.cpR = (TextView) findViewById(a.f.album_preview_select);
        this.cpS = findViewById(a.f.album_preview_bottom);
        this.cpT = findViewById(a.f.album_preview_header);
        this.cpP.setOnClickListener(this);
        this.cpQ.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.cqa);
        this.cpV = new SwanAppAlbumPreviewAdapter(this, this.agU);
        this.mViewPager.setAdapter(this.cpV);
        this.cpV.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.cpO.setOnClickListener(this);
        this.cpQ.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.cpQ.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.cpQ.setText(string);
    }

    private void ajN() {
        ArrayList<MediaModel> akd;
        this.cpM = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.cpM.setLayoutManager(linearLayoutManager);
        this.cpW = new c(this);
        this.cpM.setAdapter(this.cpW);
        if (e.akd() == null) {
            akd = null;
        } else {
            akd = e.akd();
        }
        this.cpW.n(akd);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.cpW));
        itemTouchHelper.attachToRecyclerView(this.cpM);
        final com.baidu.swan.apps.media.chooser.b.a a = a(this.mViewPager);
        this.cpM.addOnItemTouchListener(new f(this.cpM) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.agU != null) {
                    MediaModel fZ = SwanAppAlbumPreviewActivity.this.cpW.fZ(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.agU.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.agU.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.agU.get(i)).equals(fZ)) {
                            a.em(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a.em(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> aka = SwanAppAlbumPreviewActivity.this.cpW.aka();
                if (viewHolder.getLayoutPosition() >= 0 && aka != null && viewHolder.getLayoutPosition() != aka.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        ajO();
        ajQ();
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
        if (this.agU != null && this.mIndex < this.agU.size()) {
            this.cpR.setText(a(this.agU.get(this.mIndex)));
        }
    }

    private void ajO() {
        ArrayList<MediaModel> akd = e.akd();
        ViewGroup.LayoutParams layoutParams = this.cpS.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (akd != null && akd.size() > 0) {
            this.cpM.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.cpM.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajP() {
        if (this.agU != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.agU.size()) {
                mediaModel = this.agU.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.cpR.setVisibility(0);
                    this.cpR.setText(a(this.agU.get(this.mIndex)));
                    this.cpR.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.cpR.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.cpN.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.cpN.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajQ() {
        final int b;
        if (this.cpW != null && this.mIndex < this.agU.size() && (b = this.cpW.b(this.agU.get(this.mIndex))) >= 0) {
            if (b + 1 < this.cpW.getItemCount()) {
                this.cpM.smoothScrollToPosition(b + 1);
            } else {
                this.cpM.smoothScrollToPosition(b);
            }
            this.cpM.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.cpM.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.cpM.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.cpP) {
            ajR();
            finish();
        } else if (this.agU != null && this.mIndex < this.agU.size()) {
            MediaModel mediaModel = this.agU.get(this.mIndex);
            if (view == this.cpO) {
                if (e.g(mediaModel)) {
                    this.cpW.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.cpW.n(null);
                    }
                    this.cpR.setVisibility(8);
                    this.cpN.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.cpQ.setText(string);
                    ajO();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.cqZ) {
                    com.baidu.swan.apps.media.chooser.b.d.lP(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.ake(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.k(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.cpW.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.cpW.aka() == null) {
                        this.cpW.n(e.akd());
                    }
                    this.cpM.smoothScrollToPosition(selectedCount2);
                    this.cpR.setVisibility(0);
                    this.cpR.setText(a(mediaModel));
                    this.cpR.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.cpQ.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.cpQ.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    ajO();
                }
            } else if (view == this.cpQ) {
                if (e.getSelectedCount() == 0 && this.agU != null && this.agU.size() > 0 && this.mIndex < this.agU.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.cpl);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.cra);
                bundle.putParcelableArrayList("mediaModels", e.akd());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.crd);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            ajR();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void ajR() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cpV != null) {
            this.cpV.destroy();
            this.cpV = null;
        }
        this.cpW = null;
        this.cpU = null;
        if (this.agU != null) {
            this.agU = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void ajS() {
        if (!this.cpZ && this.cpY) {
            ajT();
        } else if (!this.cpZ) {
            ajU();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void ajT() {
        if (this.cpY) {
            this.cpZ = true;
            float y = this.cpT.getY();
            float y2 = this.cpS.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cpT, "y", y, y - this.cpT.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.cpZ = false;
                    SwanAppAlbumPreviewActivity.this.cpY = SwanAppAlbumPreviewActivity.this.cpY ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cpS, "y", y2, y2 + this.cpS.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void ajU() {
        if (!this.cpY) {
            this.cpZ = true;
            float y = this.cpT.getY();
            float y2 = this.cpS.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cpT, "y", y, y + this.cpT.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.cpZ = false;
                    SwanAppAlbumPreviewActivity.this.cpY = SwanAppAlbumPreviewActivity.this.cpY ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cpS, "y", y2, y2 - this.cpS.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0287a.swanapp_album_preview_enter, a.C0287a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void fV(int i) {
        fW(i);
        fX(i);
        if (i != 0 && this.cpX) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.cpL.setBackground(new ColorDrawable(0));
            if (this.cpV != null) {
                this.cpV.aj(this.mIndex, a.c.aiapps_transparent);
            }
            this.cpX = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.cpL.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.cpV != null) {
                this.cpV.aj(this.mIndex, a.c.aiapps_black);
            }
            this.cpX = true;
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

    private void fW(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.cpS != null) {
            this.cpS.setAlpha(1.0f - f);
        }
        if (this.cpT != null) {
            this.cpT.setAlpha(1.0f - f);
        }
    }

    private void fX(int i) {
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
