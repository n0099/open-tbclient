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
    private DragView cWk;
    private RecyclerView cWl;
    private ImageView cWm;
    private View cWn;
    private View cWo;
    private TextView cWp;
    private TextView cWq;
    private View cWr;
    private View cWs;
    private d cWt;
    private SwanAppAlbumPreviewAdapter cWu;
    private c cWv;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean cWw = true;
    private boolean cWx = true;
    private boolean cWy = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener cWz = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.ayi();
            SwanAppAlbumPreviewActivity.this.ayh();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.cWu.ayr();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        aye();
        this.cWt = new d(this);
        this.cWt.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = u.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = u.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.aiK = new ArrayList<>();
                this.aiK.addAll(e.ayv());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.aiK = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.aiK = com.baidu.swan.apps.media.chooser.b.d.ayu();
            }
            if (this.aiK == null) {
                this.aiK = new ArrayList<>();
            }
        }
        initView();
        ayh();
        ayf();
        ayd();
    }

    private void ayd() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.cWp.setVisibility(8);
            this.cWr.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void aye() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.cWk = (DragView) findViewById(a.f.drag_view);
        this.cWk.setOnCloseListener(this);
        this.cWk.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.cWm = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.cWo = findViewById(a.f.album_preview_back_layout);
        this.cWn = findViewById(a.f.album_preview_select_view);
        this.cWp = (TextView) findViewById(a.f.album_preview_done);
        this.cWq = (TextView) findViewById(a.f.album_preview_select);
        this.cWr = findViewById(a.f.album_preview_bottom);
        this.cWs = findViewById(a.f.album_preview_header);
        this.cWo.setOnClickListener(this);
        this.cWp.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.cWz);
        this.cWu = new SwanAppAlbumPreviewAdapter(this, this.aiK);
        this.mViewPager.setAdapter(this.cWu);
        this.cWu.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.cWn.setOnClickListener(this);
        this.cWp.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.cWp.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.cWp.setText(string);
    }

    private void ayf() {
        ArrayList<MediaModel> ayv;
        this.cWl = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.cWl.setLayoutManager(linearLayoutManager);
        this.cWv = new c(this);
        this.cWl.setAdapter(this.cWv);
        if (e.ayv() == null) {
            ayv = null;
        } else {
            ayv = e.ayv();
        }
        this.cWv.s(ayv);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.cWv));
        itemTouchHelper.attachToRecyclerView(this.cWl);
        final com.baidu.swan.apps.media.chooser.b.a a2 = a(this.mViewPager);
        this.cWl.addOnItemTouchListener(new f(this.cWl) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.aiK != null) {
                    MediaModel jf = SwanAppAlbumPreviewActivity.this.cWv.jf(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.aiK.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.aiK.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.aiK.get(i)).equals(jf)) {
                            a2.fs(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a2.fs(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> ays = SwanAppAlbumPreviewActivity.this.cWv.ays();
                if (viewHolder.getLayoutPosition() >= 0 && ays != null && viewHolder.getLayoutPosition() != ays.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        ayg();
        ayi();
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
            this.cWq.setText(a(this.aiK.get(this.mIndex)));
        }
    }

    private void ayg() {
        ArrayList<MediaModel> ayv = e.ayv();
        ViewGroup.LayoutParams layoutParams = this.cWr.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (ayv != null && ayv.size() > 0) {
            this.cWl.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.cWl.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayh() {
        if (this.aiK != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.aiK.size()) {
                mediaModel = this.aiK.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.cWq.setVisibility(0);
                    this.cWq.setText(a(this.aiK.get(this.mIndex)));
                    this.cWq.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.cWq.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.cWm.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.cWm.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayi() {
        final int b;
        if (this.cWv != null && this.mIndex < this.aiK.size() && (b = this.cWv.b(this.aiK.get(this.mIndex))) >= 0) {
            if (b + 1 < this.cWv.getItemCount()) {
                this.cWl.smoothScrollToPosition(b + 1);
            } else {
                this.cWl.smoothScrollToPosition(b);
            }
            this.cWl.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.cWl.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.cWl.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.cWo) {
            ayj();
            finish();
        } else if (this.aiK != null && this.mIndex < this.aiK.size()) {
            MediaModel mediaModel = this.aiK.get(this.mIndex);
            if (view == this.cWn) {
                if (e.g(mediaModel)) {
                    this.cWv.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.cWv.s(null);
                    }
                    this.cWq.setVisibility(8);
                    this.cWm.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.cWp.setText(string);
                    ayg();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.cXw) {
                    com.baidu.swan.apps.media.chooser.b.d.pO(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.ayw(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.k(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.cWv.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.cWv.ays() == null) {
                        this.cWv.s(e.ayv());
                    }
                    this.cWl.smoothScrollToPosition(selectedCount2);
                    this.cWq.setVisibility(0);
                    this.cWq.setText(a(mediaModel));
                    this.cWq.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.cWp.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.cWp.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    ayg();
                }
            } else if (view == this.cWp) {
                if (e.getSelectedCount() == 0 && this.aiK != null && this.aiK.size() > 0 && this.mIndex < this.aiK.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.cVM);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.cXx);
                bundle.putParcelableArrayList("mediaModels", e.ayv());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.cXz);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            ayj();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void ayj() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cWu != null) {
            this.cWu.destroy();
            this.cWu = null;
        }
        this.cWv = null;
        this.cWt = null;
        if (this.aiK != null) {
            this.aiK = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void ayk() {
        if (!this.cWy && this.cWx) {
            ayl();
        } else if (!this.cWy) {
            aym();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void ayl() {
        if (this.cWx) {
            this.cWy = true;
            float y = this.cWs.getY();
            float y2 = this.cWr.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cWs, "y", y, y - this.cWs.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.cWy = false;
                    SwanAppAlbumPreviewActivity.this.cWx = SwanAppAlbumPreviewActivity.this.cWx ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cWr, "y", y2, y2 + this.cWr.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aym() {
        if (!this.cWx) {
            this.cWy = true;
            float y = this.cWs.getY();
            float y2 = this.cWr.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cWs, "y", y, y + this.cWs.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.cWy = false;
                    SwanAppAlbumPreviewActivity.this.cWx = SwanAppAlbumPreviewActivity.this.cWx ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cWr, "y", y2, y2 - this.cWr.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0357a.swanapp_album_preview_enter, a.C0357a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void jb(int i) {
        jc(i);
        jd(i);
        if (i != 0 && this.cWw) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.cWk.setBackground(new ColorDrawable(0));
            if (this.cWu != null) {
                this.cWu.ao(this.mIndex, a.c.aiapps_transparent);
            }
            this.cWw = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.cWk.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.cWu != null) {
                this.cWu.ao(this.mIndex, a.c.aiapps_black);
            }
            this.cWw = true;
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

    private void jc(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.cWr != null) {
            this.cWr.setAlpha(1.0f - f);
        }
        if (this.cWs != null) {
            this.cWs.setAlpha(1.0f - f);
        }
    }

    private void jd(int i) {
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
