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
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter;
import com.baidu.swan.apps.media.chooser.adapter.SwanAppThumbnailAdapter;
import com.baidu.swan.apps.media.chooser.b.e;
import com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener;
import com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailTouchCallback;
import com.baidu.swan.apps.media.chooser.listener.a;
import com.baidu.swan.apps.media.chooser.listener.f;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.res.ui.d;
import com.baidu.swan.apps.view.DragView;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements View.OnClickListener, a, f, DragView.a {
    private static final boolean DEBUG = b.DEBUG;
    private ViewPager Zi;
    private ArrayList<MediaModel> ajz;
    private RecyclerView dhA;
    private ImageView dhB;
    private View dhC;
    private View dhD;
    private TextView dhE;
    private TextView dhF;
    private View dhG;
    private View dhH;
    private d dhI;
    private SwanAppAlbumPreviewAdapter dhJ;
    private SwanAppThumbnailAdapter dhK;
    private DragView dhz;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private boolean dhL = true;
    private boolean dhM = true;
    private boolean dhN = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener dhO = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.aAI();
            SwanAppAlbumPreviewActivity.this.aAH();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.dhJ.aAR();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        aAE();
        this.dhI = new d(this);
        this.dhI.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle b2 = u.b(getIntent(), "launchParams");
            this.mIndex = u.a(b2, "previewPosition", 0);
            this.mFrom = u.h(b2, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.ajz = new ArrayList<>();
                this.ajz.addAll(e.aAV());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.ajz = b2 == null ? null : b2.getParcelableArrayList("mediaModels");
            } else {
                this.ajz = com.baidu.swan.apps.media.chooser.b.d.aAU();
            }
            if (this.ajz == null) {
                this.ajz = new ArrayList<>();
            }
        }
        initView();
        aAH();
        aAF();
        aAD();
    }

    private void aAD() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.dhE.setVisibility(8);
            this.dhG.setVisibility(8);
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
        this.dhz = (DragView) findViewById(a.f.drag_view);
        this.dhz.setOnCloseListener(this);
        this.dhz.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.Zi = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.dhB = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.dhD = findViewById(a.f.album_preview_back_layout);
        this.dhC = findViewById(a.f.album_preview_select_view);
        this.dhE = (TextView) findViewById(a.f.album_preview_done);
        this.dhF = (TextView) findViewById(a.f.album_preview_select);
        this.dhG = findViewById(a.f.album_preview_bottom);
        this.dhH = findViewById(a.f.album_preview_header);
        this.dhD.setOnClickListener(this);
        this.dhE.setOnClickListener(this);
        this.Zi.setOnPageChangeListener(this.dhO);
        this.dhJ = new SwanAppAlbumPreviewAdapter(this, this.ajz);
        this.Zi.setAdapter(this.dhJ);
        this.dhJ.a(this);
        this.Zi.setCurrentItem(this.mIndex);
        this.dhC.setOnClickListener(this);
        this.dhE.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.dhE.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.aAW() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.aAW() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.dhE.setText(string);
    }

    private void aAF() {
        ArrayList<MediaModel> aAV;
        this.dhA = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
        this.mLineView = findViewById(a.f.album_preview_line);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.1.1
                    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
                    public PointF computeScrollVectorForPosition(int i2) {
                        return super.computeScrollVectorForPosition(i2);
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return (SwanAppAlbumPreviewActivity.this.getResources().getDisplayMetrics().density * 0.3f) / displayMetrics.density;
                    }
                };
                linearSmoothScroller.setTargetPosition(i);
                startSmoothScroll(linearSmoothScroller);
            }
        };
        linearLayoutManager.setOrientation(0);
        this.dhA.setLayoutManager(linearLayoutManager);
        this.dhK = new SwanAppThumbnailAdapter(this);
        this.dhA.setAdapter(this.dhK);
        if (e.aAV() == null) {
            aAV = null;
        } else {
            aAV = e.aAV();
        }
        this.dhK.n(aAV);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwanAppThumbnailTouchCallback(this, this.dhK));
        itemTouchHelper.attachToRecyclerView(this.dhA);
        final com.baidu.swan.apps.media.chooser.b.a a2 = a(this.Zi);
        this.dhA.addOnItemTouchListener(new SwanAppThumbnailClickListener(this.dhA) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.ajz != null) {
                    MediaModel hY = SwanAppAlbumPreviewActivity.this.dhK.hY(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.ajz.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.ajz.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.ajz.get(i)).equals(hY)) {
                            a2.fY(true);
                            SwanAppAlbumPreviewActivity.this.Zi.setCurrentItem(i);
                            a2.fY(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> aAS = SwanAppAlbumPreviewActivity.this.dhK.aAS();
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

    @Override // com.baidu.swan.apps.media.chooser.listener.f
    public void ak(int i, int i2) {
        if (this.ajz != null && this.mIndex < this.ajz.size()) {
            this.dhF.setText(a(this.ajz.get(this.mIndex)));
        }
    }

    private void aAG() {
        ArrayList<MediaModel> aAV = e.aAV();
        ViewGroup.LayoutParams layoutParams = this.dhG.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (aAV != null && aAV.size() > 0) {
            this.dhA.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.dhA.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAH() {
        if (this.ajz != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.ajz.size()) {
                mediaModel = this.ajz.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.dhF.setVisibility(0);
                    this.dhF.setText(a(this.ajz.get(this.mIndex)));
                    this.dhF.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.dhF.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.dhB.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.dhB.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAI() {
        final int b2;
        if (this.dhK != null && this.mIndex < this.ajz.size() && (b2 = this.dhK.b(this.ajz.get(this.mIndex))) >= 0) {
            if (b2 + 1 < this.dhK.getItemCount()) {
                this.dhA.smoothScrollToPosition(b2 + 1);
            } else {
                this.dhA.smoothScrollToPosition(b2);
            }
            this.dhA.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b2 > 0) {
                        SwanAppAlbumPreviewActivity.this.dhA.smoothScrollToPosition(b2 - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.dhA.smoothScrollToPosition(b2);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.dhD) {
            aAJ();
            finish();
        } else if (this.ajz != null && this.mIndex < this.ajz.size()) {
            MediaModel mediaModel = this.ajz.get(this.mIndex);
            if (view == this.dhC) {
                if (e.g(mediaModel)) {
                    this.dhK.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.aAW() == 0) {
                        this.dhK.n(null);
                    }
                    this.dhF.setVisibility(8);
                    this.dhB.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.aAW() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.aAW() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.dhE.setText(string);
                    aAG();
                    return;
                }
                int aAW = e.aAW();
                if (aAW == com.baidu.swan.apps.media.chooser.b.d.diS) {
                    com.baidu.swan.apps.media.chooser.b.d.pl(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (aAW > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.aAX(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.u(this, a.h.swanapp_album_select_single).aHZ();
                } else {
                    int aAW2 = e.aAW();
                    this.dhK.notifyItemInserted(aAW2);
                    e.e(mediaModel);
                    if (this.dhK.aAS() == null) {
                        this.dhK.n(e.aAV());
                    }
                    this.dhA.smoothScrollToPosition(aAW2);
                    this.dhF.setVisibility(0);
                    this.dhF.setText(a(mediaModel));
                    this.dhF.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.dhE.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.aAW() + ")");
                    this.dhE.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    aAG();
                }
            } else if (view == this.dhE) {
                if (e.aAW() == 0 && this.ajz != null && this.ajz.size() > 0 && this.mIndex < this.ajz.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.dhb);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.diT);
                bundle.putParcelableArrayList("mediaModels", e.aAV());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.diW);
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
        if (this.dhJ != null) {
            this.dhJ.destroy();
            this.dhJ = null;
        }
        this.dhK = null;
        this.dhI = null;
        if (this.ajz != null) {
            this.ajz = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.listener.a
    public void aAK() {
        if (!this.dhN && this.dhM) {
            aAL();
        } else if (!this.dhN) {
            aAM();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.listener.a
    public void aAL() {
        if (this.dhM) {
            this.dhN = true;
            float y = this.dhH.getY();
            float y2 = this.dhG.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dhH, "y", y, y - this.dhH.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.dhN = false;
                    SwanAppAlbumPreviewActivity.this.dhM = SwanAppAlbumPreviewActivity.this.dhM ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dhG, "y", y2, y2 + this.dhG.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.listener.a
    public void aAM() {
        if (!this.dhM) {
            this.dhN = true;
            float y = this.dhH.getY();
            float y2 = this.dhG.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dhH, "y", y, y + this.dhH.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.dhN = false;
                    SwanAppAlbumPreviewActivity.this.dhM = SwanAppAlbumPreviewActivity.this.dhM ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dhG, "y", y2, y2 - this.dhG.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0355a.swanapp_album_preview_enter, a.C0355a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void hU(int i) {
        hV(i);
        hW(i);
        if (i != 0 && this.dhL) {
            h(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.dhz.setBackground(new ColorDrawable(0));
            if (this.dhJ != null) {
                this.dhJ.al(this.mIndex, a.c.aiapps_transparent);
            }
            this.dhL = false;
        }
        if (i == 0) {
            h(new ColorDrawable(0));
            this.dhz.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.dhJ != null) {
                this.dhJ.al(this.mIndex, a.c.aiapps_black);
            }
            this.dhL = true;
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void z(MotionEvent motionEvent) {
    }

    public void h(Drawable drawable) {
        if (this.mRootView != null) {
            this.mRootView.setBackground(drawable);
        }
    }

    private void hV(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.dhG != null) {
            this.dhG.setAlpha(1.0f - f);
        }
        if (this.dhH != null) {
            this.dhH.setAlpha(1.0f - f);
        }
    }

    private void hW(int i) {
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
