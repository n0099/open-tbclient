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
/* loaded from: classes9.dex */
public class SwanAppAlbumPreviewActivity extends SwanAppBaseActivity implements View.OnClickListener, a, f, DragView.a {
    private static final boolean DEBUG = b.DEBUG;
    private ViewPager Ze;
    private ArrayList<MediaModel> ajo;
    private DragView djN;
    private RecyclerView djO;
    private ImageView djP;
    private View djQ;
    private View djR;
    private TextView djS;
    private TextView djT;
    private View djU;
    private View djV;
    private d djW;
    private SwanAppAlbumPreviewAdapter djX;
    private SwanAppThumbnailAdapter djY;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private boolean djZ = true;
    private boolean dka = true;
    private boolean dkb = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener dkc = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.aBg();
            SwanAppAlbumPreviewActivity.this.aBf();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.djX.aBp();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        aBc();
        this.djW = new d(this);
        this.djW.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle b2 = u.b(getIntent(), "launchParams");
            this.mIndex = u.a(b2, "previewPosition", 0);
            this.mFrom = u.h(b2, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.ajo = new ArrayList<>();
                this.ajo.addAll(e.aBt());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.ajo = b2 == null ? null : b2.getParcelableArrayList("mediaModels");
            } else {
                this.ajo = com.baidu.swan.apps.media.chooser.b.d.aBs();
            }
            if (this.ajo == null) {
                this.ajo = new ArrayList<>();
            }
        }
        initView();
        aBf();
        aBd();
        aBb();
    }

    private void aBb() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.djS.setVisibility(8);
            this.djU.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void aBc() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.djN = (DragView) findViewById(a.f.drag_view);
        this.djN.setOnCloseListener(this);
        this.djN.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.Ze = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.djP = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.djR = findViewById(a.f.album_preview_back_layout);
        this.djQ = findViewById(a.f.album_preview_select_view);
        this.djS = (TextView) findViewById(a.f.album_preview_done);
        this.djT = (TextView) findViewById(a.f.album_preview_select);
        this.djU = findViewById(a.f.album_preview_bottom);
        this.djV = findViewById(a.f.album_preview_header);
        this.djR.setOnClickListener(this);
        this.djS.setOnClickListener(this);
        this.Ze.setOnPageChangeListener(this.dkc);
        this.djX = new SwanAppAlbumPreviewAdapter(this, this.ajo);
        this.Ze.setAdapter(this.djX);
        this.djX.a(this);
        this.Ze.setCurrentItem(this.mIndex);
        this.djQ.setOnClickListener(this);
        this.djS.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.djS.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.aBu() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.aBu() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.djS.setText(string);
    }

    private void aBd() {
        ArrayList<MediaModel> aBt;
        this.djO = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.djO.setLayoutManager(linearLayoutManager);
        this.djY = new SwanAppThumbnailAdapter(this);
        this.djO.setAdapter(this.djY);
        if (e.aBt() == null) {
            aBt = null;
        } else {
            aBt = e.aBt();
        }
        this.djY.n(aBt);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwanAppThumbnailTouchCallback(this, this.djY));
        itemTouchHelper.attachToRecyclerView(this.djO);
        final com.baidu.swan.apps.media.chooser.b.a a2 = a(this.Ze);
        this.djO.addOnItemTouchListener(new SwanAppThumbnailClickListener(this.djO) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.ajo != null) {
                    MediaModel ib = SwanAppAlbumPreviewActivity.this.djY.ib(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.ajo.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.ajo.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.ajo.get(i)).equals(ib)) {
                            a2.ga(true);
                            SwanAppAlbumPreviewActivity.this.Ze.setCurrentItem(i);
                            a2.ga(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> aBq = SwanAppAlbumPreviewActivity.this.djY.aBq();
                if (viewHolder.getLayoutPosition() >= 0 && aBq != null && viewHolder.getLayoutPosition() != aBq.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        aBe();
        aBg();
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
    public void ah(int i, int i2) {
        if (this.ajo != null && this.mIndex < this.ajo.size()) {
            this.djT.setText(a(this.ajo.get(this.mIndex)));
        }
    }

    private void aBe() {
        ArrayList<MediaModel> aBt = e.aBt();
        ViewGroup.LayoutParams layoutParams = this.djU.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (aBt != null && aBt.size() > 0) {
            this.djO.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.djO.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBf() {
        if (this.ajo != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.ajo.size()) {
                mediaModel = this.ajo.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.djT.setVisibility(0);
                    this.djT.setText(a(this.ajo.get(this.mIndex)));
                    this.djT.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.djT.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.djP.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.djP.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBg() {
        final int b2;
        if (this.djY != null && this.mIndex < this.ajo.size() && (b2 = this.djY.b(this.ajo.get(this.mIndex))) >= 0) {
            if (b2 + 1 < this.djY.getItemCount()) {
                this.djO.smoothScrollToPosition(b2 + 1);
            } else {
                this.djO.smoothScrollToPosition(b2);
            }
            this.djO.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b2 > 0) {
                        SwanAppAlbumPreviewActivity.this.djO.smoothScrollToPosition(b2 - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.djO.smoothScrollToPosition(b2);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.djR) {
            aBh();
            finish();
        } else if (this.ajo != null && this.mIndex < this.ajo.size()) {
            MediaModel mediaModel = this.ajo.get(this.mIndex);
            if (view == this.djQ) {
                if (e.g(mediaModel)) {
                    this.djY.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.aBu() == 0) {
                        this.djY.n(null);
                    }
                    this.djT.setVisibility(8);
                    this.djP.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.aBu() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.aBu() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.djS.setText(string);
                    aBe();
                    return;
                }
                int aBu = e.aBu();
                if (aBu == com.baidu.swan.apps.media.chooser.b.d.dld) {
                    com.baidu.swan.apps.media.chooser.b.d.pD(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (aBu > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.aBv(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.u(this, a.h.swanapp_album_select_single).aIs();
                } else {
                    int aBu2 = e.aBu();
                    this.djY.notifyItemInserted(aBu2);
                    e.e(mediaModel);
                    if (this.djY.aBq() == null) {
                        this.djY.n(e.aBt());
                    }
                    this.djO.smoothScrollToPosition(aBu2);
                    this.djT.setVisibility(0);
                    this.djT.setText(a(mediaModel));
                    this.djT.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.djS.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.aBu() + ")");
                    this.djS.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    aBe();
                }
            } else if (view == this.djS) {
                if (e.aBu() == 0 && this.ajo != null && this.ajo.size() > 0 && this.mIndex < this.ajo.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.djp);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.dle);
                bundle.putParcelableArrayList("mediaModels", e.aBt());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.dlh);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aBh();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aBh() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.djX != null) {
            this.djX.destroy();
            this.djX = null;
        }
        this.djY = null;
        this.djW = null;
        if (this.ajo != null) {
            this.ajo = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.listener.a
    public void aBi() {
        if (!this.dkb && this.dka) {
            aBj();
        } else if (!this.dkb) {
            aBk();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.listener.a
    public void aBj() {
        if (this.dka) {
            this.dkb = true;
            float y = this.djV.getY();
            float y2 = this.djU.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.djV, "y", y, y - this.djV.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.dkb = false;
                    SwanAppAlbumPreviewActivity.this.dka = SwanAppAlbumPreviewActivity.this.dka ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.djU, "y", y2, y2 + this.djU.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.listener.a
    public void aBk() {
        if (!this.dka) {
            this.dkb = true;
            float y = this.djV.getY();
            float y2 = this.djU.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.djV, "y", y, y + this.djV.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.dkb = false;
                    SwanAppAlbumPreviewActivity.this.dka = SwanAppAlbumPreviewActivity.this.dka ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.djU, "y", y2, y2 - this.djU.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0352a.swanapp_album_preview_enter, a.C0352a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void hX(int i) {
        hY(i);
        hZ(i);
        if (i != 0 && this.djZ) {
            h(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.djN.setBackground(new ColorDrawable(0));
            if (this.djX != null) {
                this.djX.ai(this.mIndex, a.c.aiapps_transparent);
            }
            this.djZ = false;
        }
        if (i == 0) {
            h(new ColorDrawable(0));
            this.djN.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.djX != null) {
                this.djX.ai(this.mIndex, a.c.aiapps_black);
            }
            this.djZ = true;
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

    private void hY(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.djU != null) {
            this.djU.setAlpha(1.0f - f);
        }
        if (this.djV != null) {
            this.djV.setAlpha(1.0f - f);
        }
    }

    private void hZ(int i) {
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
