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
/* loaded from: classes7.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements View.OnClickListener, a, g, DragView.a {
    private static final boolean DEBUG = b.DEBUG;
    private ArrayList<MediaModel> aiP;
    private View daA;
    private TextView daB;
    private TextView daC;
    private View daD;
    private View daE;
    private d daF;
    private SwanAppAlbumPreviewAdapter daG;
    private c daH;
    private DragView dav;
    private RecyclerView daw;
    private ImageView dax;
    private View daz;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean daI = true;
    private boolean daJ = true;
    private boolean daK = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener daL = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.aAa();
            SwanAppAlbumPreviewActivity.this.azZ();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.daG.aAj();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        azW();
        this.daF = new d(this);
        this.daF.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = u.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = u.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.aiP = new ArrayList<>();
                this.aiP.addAll(e.aAn());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.aiP = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.aiP = com.baidu.swan.apps.media.chooser.b.d.aAm();
            }
            if (this.aiP == null) {
                this.aiP = new ArrayList<>();
            }
        }
        initView();
        azZ();
        azX();
        azV();
    }

    private void azV() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.daB.setVisibility(8);
            this.daD.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void azW() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.dav = (DragView) findViewById(a.f.drag_view);
        this.dav.setOnCloseListener(this);
        this.dav.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.dax = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.daA = findViewById(a.f.album_preview_back_layout);
        this.daz = findViewById(a.f.album_preview_select_view);
        this.daB = (TextView) findViewById(a.f.album_preview_done);
        this.daC = (TextView) findViewById(a.f.album_preview_select);
        this.daD = findViewById(a.f.album_preview_bottom);
        this.daE = findViewById(a.f.album_preview_header);
        this.daA.setOnClickListener(this);
        this.daB.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.daL);
        this.daG = new SwanAppAlbumPreviewAdapter(this, this.aiP);
        this.mViewPager.setAdapter(this.daG);
        this.daG.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.daz.setOnClickListener(this);
        this.daB.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.daB.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.daB.setText(string);
    }

    private void azX() {
        ArrayList<MediaModel> aAn;
        this.daw = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.daw.setLayoutManager(linearLayoutManager);
        this.daH = new c(this);
        this.daw.setAdapter(this.daH);
        if (e.aAn() == null) {
            aAn = null;
        } else {
            aAn = e.aAn();
        }
        this.daH.s(aAn);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.daH));
        itemTouchHelper.attachToRecyclerView(this.daw);
        final com.baidu.swan.apps.media.chooser.b.a a2 = a(this.mViewPager);
        this.daw.addOnItemTouchListener(new f(this.daw) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.aiP != null) {
                    MediaModel jl = SwanAppAlbumPreviewActivity.this.daH.jl(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.aiP.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.aiP.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.aiP.get(i)).equals(jl)) {
                            a2.fE(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a2.fE(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> aAk = SwanAppAlbumPreviewActivity.this.daH.aAk();
                if (viewHolder.getLayoutPosition() >= 0 && aAk != null && viewHolder.getLayoutPosition() != aAk.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        azY();
        aAa();
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
        if (this.aiP != null && this.mIndex < this.aiP.size()) {
            this.daC.setText(a(this.aiP.get(this.mIndex)));
        }
    }

    private void azY() {
        ArrayList<MediaModel> aAn = e.aAn();
        ViewGroup.LayoutParams layoutParams = this.daD.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (aAn != null && aAn.size() > 0) {
            this.daw.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.daw.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azZ() {
        if (this.aiP != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.aiP.size()) {
                mediaModel = this.aiP.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.daC.setVisibility(0);
                    this.daC.setText(a(this.aiP.get(this.mIndex)));
                    this.daC.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.daC.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.dax.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.dax.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAa() {
        final int b;
        if (this.daH != null && this.mIndex < this.aiP.size() && (b = this.daH.b(this.aiP.get(this.mIndex))) >= 0) {
            if (b + 1 < this.daH.getItemCount()) {
                this.daw.smoothScrollToPosition(b + 1);
            } else {
                this.daw.smoothScrollToPosition(b);
            }
            this.daw.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.daw.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.daw.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.daA) {
            aAb();
            finish();
        } else if (this.aiP != null && this.mIndex < this.aiP.size()) {
            MediaModel mediaModel = this.aiP.get(this.mIndex);
            if (view == this.daz) {
                if (e.g(mediaModel)) {
                    this.daH.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.daH.s(null);
                    }
                    this.daC.setVisibility(8);
                    this.dax.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.daB.setText(string);
                    azY();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.dbI) {
                    com.baidu.swan.apps.media.chooser.b.d.pW(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.aAo(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.k(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.daH.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.daH.aAk() == null) {
                        this.daH.s(e.aAn());
                    }
                    this.daw.smoothScrollToPosition(selectedCount2);
                    this.daC.setVisibility(0);
                    this.daC.setText(a(mediaModel));
                    this.daC.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.daB.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.daB.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    azY();
                }
            } else if (view == this.daB) {
                if (e.getSelectedCount() == 0 && this.aiP != null && this.aiP.size() > 0 && this.mIndex < this.aiP.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.cZW);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.dbJ);
                bundle.putParcelableArrayList("mediaModels", e.aAn());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.dbL);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aAb();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aAb() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.daG != null) {
            this.daG.destroy();
            this.daG = null;
        }
        this.daH = null;
        this.daF = null;
        if (this.aiP != null) {
            this.aiP = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aAc() {
        if (!this.daK && this.daJ) {
            aAd();
        } else if (!this.daK) {
            aAe();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aAd() {
        if (this.daJ) {
            this.daK = true;
            float y = this.daE.getY();
            float y2 = this.daD.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.daE, "y", y, y - this.daE.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.daK = false;
                    SwanAppAlbumPreviewActivity.this.daJ = SwanAppAlbumPreviewActivity.this.daJ ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.daD, "y", y2, y2 + this.daD.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aAe() {
        if (!this.daJ) {
            this.daK = true;
            float y = this.daE.getY();
            float y2 = this.daD.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.daE, "y", y, y + this.daE.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.daK = false;
                    SwanAppAlbumPreviewActivity.this.daJ = SwanAppAlbumPreviewActivity.this.daJ ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.daD, "y", y2, y2 - this.daD.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0367a.swanapp_album_preview_enter, a.C0367a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void jh(int i) {
        ji(i);
        jj(i);
        if (i != 0 && this.daI) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.dav.setBackground(new ColorDrawable(0));
            if (this.daG != null) {
                this.daG.ao(this.mIndex, a.c.aiapps_transparent);
            }
            this.daI = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.dav.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.daG != null) {
                this.daG.ao(this.mIndex, a.c.aiapps_black);
            }
            this.daI = true;
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

    private void ji(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.daD != null) {
            this.daD.setAlpha(1.0f - f);
        }
        if (this.daE != null) {
            this.daE.setAlpha(1.0f - f);
        }
    }

    private void jj(int i) {
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
