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
/* loaded from: classes25.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements View.OnClickListener, a, g, DragView.a {
    private static final boolean DEBUG = b.DEBUG;
    private ArrayList<MediaModel> ajO;
    private TextView dhA;
    private View dhB;
    private View dhC;
    private d dhD;
    private SwanAppAlbumPreviewAdapter dhE;
    private c dhF;
    private DragView dhu;
    private RecyclerView dhv;
    private ImageView dhw;
    private View dhx;
    private View dhy;
    private TextView dhz;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean dhG = true;
    private boolean dhH = true;
    private boolean dhI = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener dhJ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.aDj();
            SwanAppAlbumPreviewActivity.this.aDi();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.dhE.aDs();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        aDf();
        this.dhD = new d(this);
        this.dhD.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = u.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = u.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.ajO = new ArrayList<>();
                this.ajO.addAll(e.aDw());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.ajO = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.ajO = com.baidu.swan.apps.media.chooser.b.d.aDv();
            }
            if (this.ajO == null) {
                this.ajO = new ArrayList<>();
            }
        }
        initView();
        aDi();
        aDg();
        aDe();
    }

    private void aDe() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.dhz.setVisibility(8);
            this.dhB.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void aDf() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.dhu = (DragView) findViewById(a.f.drag_view);
        this.dhu.setOnCloseListener(this);
        this.dhu.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.dhw = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.dhy = findViewById(a.f.album_preview_back_layout);
        this.dhx = findViewById(a.f.album_preview_select_view);
        this.dhz = (TextView) findViewById(a.f.album_preview_done);
        this.dhA = (TextView) findViewById(a.f.album_preview_select);
        this.dhB = findViewById(a.f.album_preview_bottom);
        this.dhC = findViewById(a.f.album_preview_header);
        this.dhy.setOnClickListener(this);
        this.dhz.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.dhJ);
        this.dhE = new SwanAppAlbumPreviewAdapter(this, this.ajO);
        this.mViewPager.setAdapter(this.dhE);
        this.dhE.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.dhx.setOnClickListener(this);
        this.dhz.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.dhz.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.dhz.setText(string);
    }

    private void aDg() {
        ArrayList<MediaModel> aDw;
        this.dhv = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.dhv.setLayoutManager(linearLayoutManager);
        this.dhF = new c(this);
        this.dhv.setAdapter(this.dhF);
        if (e.aDw() == null) {
            aDw = null;
        } else {
            aDw = e.aDw();
        }
        this.dhF.s(aDw);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.dhF));
        itemTouchHelper.attachToRecyclerView(this.dhv);
        final com.baidu.swan.apps.media.chooser.b.a a2 = a(this.mViewPager);
        this.dhv.addOnItemTouchListener(new f(this.dhv) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.ajO != null) {
                    MediaModel jJ = SwanAppAlbumPreviewActivity.this.dhF.jJ(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.ajO.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.ajO.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.ajO.get(i)).equals(jJ)) {
                            a2.fT(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a2.fT(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> aDt = SwanAppAlbumPreviewActivity.this.dhF.aDt();
                if (viewHolder.getLayoutPosition() >= 0 && aDt != null && viewHolder.getLayoutPosition() != aDt.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        aDh();
        aDj();
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
    public void ap(int i, int i2) {
        if (this.ajO != null && this.mIndex < this.ajO.size()) {
            this.dhA.setText(a(this.ajO.get(this.mIndex)));
        }
    }

    private void aDh() {
        ArrayList<MediaModel> aDw = e.aDw();
        ViewGroup.LayoutParams layoutParams = this.dhB.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (aDw != null && aDw.size() > 0) {
            this.dhv.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.dhv.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDi() {
        if (this.ajO != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.ajO.size()) {
                mediaModel = this.ajO.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.dhA.setVisibility(0);
                    this.dhA.setText(a(this.ajO.get(this.mIndex)));
                    this.dhA.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.dhA.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.dhw.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.dhw.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDj() {
        final int b;
        if (this.dhF != null && this.mIndex < this.ajO.size() && (b = this.dhF.b(this.ajO.get(this.mIndex))) >= 0) {
            if (b + 1 < this.dhF.getItemCount()) {
                this.dhv.smoothScrollToPosition(b + 1);
            } else {
                this.dhv.smoothScrollToPosition(b);
            }
            this.dhv.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.dhv.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.dhv.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.dhy) {
            aDk();
            finish();
        } else if (this.ajO != null && this.mIndex < this.ajO.size()) {
            MediaModel mediaModel = this.ajO.get(this.mIndex);
            if (view == this.dhx) {
                if (e.g(mediaModel)) {
                    this.dhF.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.dhF.s(null);
                    }
                    this.dhA.setVisibility(8);
                    this.dhw.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.dhz.setText(string);
                    aDh();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.diJ) {
                    com.baidu.swan.apps.media.chooser.b.d.qD(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.aDx(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.t(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.dhF.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.dhF.aDt() == null) {
                        this.dhF.s(e.aDw());
                    }
                    this.dhv.smoothScrollToPosition(selectedCount2);
                    this.dhA.setVisibility(0);
                    this.dhA.setText(a(mediaModel));
                    this.dhA.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.dhz.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.dhz.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    aDh();
                }
            } else if (view == this.dhz) {
                if (e.getSelectedCount() == 0 && this.ajO != null && this.ajO.size() > 0 && this.mIndex < this.ajO.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.dgW);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.diK);
                bundle.putParcelableArrayList("mediaModels", e.aDw());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.diM);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aDk();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aDk() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dhE != null) {
            this.dhE.destroy();
            this.dhE = null;
        }
        this.dhF = null;
        this.dhD = null;
        if (this.ajO != null) {
            this.ajO = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aDl() {
        if (!this.dhI && this.dhH) {
            aDm();
        } else if (!this.dhI) {
            aDn();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aDm() {
        if (this.dhH) {
            this.dhI = true;
            float y = this.dhC.getY();
            float y2 = this.dhB.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dhC, "y", y, y - this.dhC.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.dhI = false;
                    SwanAppAlbumPreviewActivity.this.dhH = SwanAppAlbumPreviewActivity.this.dhH ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dhB, "y", y2, y2 + this.dhB.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void aDn() {
        if (!this.dhH) {
            this.dhI = true;
            float y = this.dhC.getY();
            float y2 = this.dhB.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dhC, "y", y, y + this.dhC.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.dhI = false;
                    SwanAppAlbumPreviewActivity.this.dhH = SwanAppAlbumPreviewActivity.this.dhH ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dhB, "y", y2, y2 - this.dhB.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0379a.swanapp_album_preview_enter, a.C0379a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void jF(int i) {
        jG(i);
        jH(i);
        if (i != 0 && this.dhG) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.dhu.setBackground(new ColorDrawable(0));
            if (this.dhE != null) {
                this.dhE.aq(this.mIndex, a.c.aiapps_transparent);
            }
            this.dhG = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.dhu.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.dhE != null) {
                this.dhE.aq(this.mIndex, a.c.aiapps_black);
            }
            this.dhG = true;
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

    private void jG(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.dhB != null) {
            this.dhB.setAlpha(1.0f - f);
        }
        if (this.dhC != null) {
            this.dhC.setAlpha(1.0f - f);
        }
    }

    private void jH(int i) {
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
