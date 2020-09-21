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
/* loaded from: classes3.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements View.OnClickListener, a, g, DragView.a {
    private static final boolean DEBUG = b.DEBUG;
    private ArrayList<MediaModel> air;
    private DragView cBJ;
    private RecyclerView cBK;
    private ImageView cBL;
    private View cBM;
    private View cBN;
    private TextView cBO;
    private TextView cBP;
    private View cBQ;
    private View cBR;
    private d cBS;
    private SwanAppAlbumPreviewAdapter cBT;
    private c cBU;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private ViewPager mViewPager;
    private boolean cBV = true;
    private boolean cBW = true;
    private boolean cBX = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener cBY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.atD();
            SwanAppAlbumPreviewActivity.this.atC();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.cBT.atM();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        atz();
        this.cBS = new d(this);
        this.cBS.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle safeGetBundleExtra = u.safeGetBundleExtra(getIntent(), "launchParams");
            this.mIndex = u.a(safeGetBundleExtra, "previewPosition", 0);
            this.mFrom = u.safeGetString(safeGetBundleExtra, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.air = new ArrayList<>();
                this.air.addAll(e.atQ());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.air = safeGetBundleExtra == null ? null : safeGetBundleExtra.getParcelableArrayList("mediaModels");
            } else {
                this.air = com.baidu.swan.apps.media.chooser.b.d.atP();
            }
            if (this.air == null) {
                this.air = new ArrayList<>();
            }
        }
        initView();
        atC();
        atA();
        aty();
    }

    private void aty() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.cBO.setVisibility(8);
            this.cBQ.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void atz() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.cBJ = (DragView) findViewById(a.f.drag_view);
        this.cBJ.setOnCloseListener(this);
        this.cBJ.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.mViewPager = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.cBL = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.cBN = findViewById(a.f.album_preview_back_layout);
        this.cBM = findViewById(a.f.album_preview_select_view);
        this.cBO = (TextView) findViewById(a.f.album_preview_done);
        this.cBP = (TextView) findViewById(a.f.album_preview_select);
        this.cBQ = findViewById(a.f.album_preview_bottom);
        this.cBR = findViewById(a.f.album_preview_header);
        this.cBN.setOnClickListener(this);
        this.cBO.setOnClickListener(this);
        this.mViewPager.setOnPageChangeListener(this.cBY);
        this.cBT = new SwanAppAlbumPreviewAdapter(this, this.air);
        this.mViewPager.setAdapter(this.cBT);
        this.cBT.a(this);
        this.mViewPager.setCurrentItem(this.mIndex);
        this.cBM.setOnClickListener(this);
        this.cBO.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.cBO.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.getSelectedCount() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.cBO.setText(string);
    }

    private void atA() {
        ArrayList<MediaModel> atQ;
        this.cBK = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.cBK.setLayoutManager(linearLayoutManager);
        this.cBU = new c(this);
        this.cBK.setAdapter(this.cBU);
        if (e.atQ() == null) {
            atQ = null;
        } else {
            atQ = e.atQ();
        }
        this.cBU.s(atQ);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new h(this, this.cBU));
        itemTouchHelper.attachToRecyclerView(this.cBK);
        final com.baidu.swan.apps.media.chooser.b.a a = a(this.mViewPager);
        this.cBK.addOnItemTouchListener(new f(this.cBK) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.air != null) {
                    MediaModel ix = SwanAppAlbumPreviewActivity.this.cBU.ix(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.air.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.air.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.air.get(i)).equals(ix)) {
                            a.eJ(true);
                            SwanAppAlbumPreviewActivity.this.mViewPager.setCurrentItem(i);
                            a.eJ(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.c.f
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> atN = SwanAppAlbumPreviewActivity.this.cBU.atN();
                if (viewHolder.getLayoutPosition() >= 0 && atN != null && viewHolder.getLayoutPosition() != atN.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        atB();
        atD();
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
        if (this.air != null && this.mIndex < this.air.size()) {
            this.cBP.setText(a(this.air.get(this.mIndex)));
        }
    }

    private void atB() {
        ArrayList<MediaModel> atQ = e.atQ();
        ViewGroup.LayoutParams layoutParams = this.cBQ.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (atQ != null && atQ.size() > 0) {
            this.cBK.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.cBK.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atC() {
        if (this.air != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.air.size()) {
                mediaModel = this.air.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.cBP.setVisibility(0);
                    this.cBP.setText(a(this.air.get(this.mIndex)));
                    this.cBP.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.cBP.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.cBL.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.cBL.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atD() {
        final int b;
        if (this.cBU != null && this.mIndex < this.air.size() && (b = this.cBU.b(this.air.get(this.mIndex))) >= 0) {
            if (b + 1 < this.cBU.getItemCount()) {
                this.cBK.smoothScrollToPosition(b + 1);
            } else {
                this.cBK.smoothScrollToPosition(b);
            }
            this.cBK.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.cBK.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.cBK.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.cBN) {
            atE();
            finish();
        } else if (this.air != null && this.mIndex < this.air.size()) {
            MediaModel mediaModel = this.air.get(this.mIndex);
            if (view == this.cBM) {
                if (e.g(mediaModel)) {
                    this.cBU.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.getSelectedCount() == 0) {
                        this.cBU.s(null);
                    }
                    this.cBP.setVisibility(8);
                    this.cBL.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.getSelectedCount() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.cBO.setText(string);
                    atB();
                    return;
                }
                int selectedCount = e.getSelectedCount();
                if (selectedCount == com.baidu.swan.apps.media.chooser.b.d.cCV) {
                    com.baidu.swan.apps.media.chooser.b.d.oJ(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (selectedCount > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.atR(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.k(this, a.h.swanapp_album_select_single).showToast();
                } else {
                    int selectedCount2 = e.getSelectedCount();
                    this.cBU.notifyItemInserted(selectedCount2);
                    e.e(mediaModel);
                    if (this.cBU.atN() == null) {
                        this.cBU.s(e.atQ());
                    }
                    this.cBK.smoothScrollToPosition(selectedCount2);
                    this.cBP.setVisibility(0);
                    this.cBP.setText(a(mediaModel));
                    this.cBP.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.cBO.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.getSelectedCount() + ")");
                    this.cBO.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    atB();
                }
            } else if (view == this.cBO) {
                if (e.getSelectedCount() == 0 && this.air != null && this.air.size() > 0 && this.mIndex < this.air.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.cBl);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.cCW);
                bundle.putParcelableArrayList("mediaModels", e.atQ());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.cCY);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            atE();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void atE() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cBT != null) {
            this.cBT.destroy();
            this.cBT = null;
        }
        this.cBU = null;
        this.cBS = null;
        if (this.air != null) {
            this.air = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void atF() {
        if (!this.cBX && this.cBW) {
            atG();
        } else if (!this.cBX) {
            atH();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void atG() {
        if (this.cBW) {
            this.cBX = true;
            float y = this.cBR.getY();
            float y2 = this.cBQ.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cBR, "y", y, y - this.cBR.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.cBX = false;
                    SwanAppAlbumPreviewActivity.this.cBW = SwanAppAlbumPreviewActivity.this.cBW ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cBQ, "y", y2, y2 + this.cBQ.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.c.a
    public void atH() {
        if (!this.cBW) {
            this.cBX = true;
            float y = this.cBR.getY();
            float y2 = this.cBQ.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cBR, "y", y, y + this.cBR.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.cBX = false;
                    SwanAppAlbumPreviewActivity.this.cBW = SwanAppAlbumPreviewActivity.this.cBW ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cBQ, "y", y2, y2 - this.cBQ.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0326a.swanapp_album_preview_enter, a.C0326a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void it(int i) {
        iu(i);
        iv(i);
        if (i != 0 && this.cBV) {
            c(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.cBJ.setBackground(new ColorDrawable(0));
            if (this.cBT != null) {
                this.cBT.ao(this.mIndex, a.c.aiapps_transparent);
            }
            this.cBV = false;
        }
        if (i == 0) {
            c(new ColorDrawable(0));
            this.cBJ.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.cBT != null) {
                this.cBT.ao(this.mIndex, a.c.aiapps_black);
            }
            this.cBV = true;
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

    private void iu(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.cBQ != null) {
            this.cBQ.setAlpha(1.0f - f);
        }
        if (this.cBR != null) {
            this.cBR.setAlpha(1.0f - f);
        }
    }

    private void iv(int i) {
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
