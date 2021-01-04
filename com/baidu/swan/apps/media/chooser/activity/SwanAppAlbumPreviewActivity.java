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
    private ViewPager Zk;
    private ArrayList<MediaModel> akq;
    private DragView dmo;
    private RecyclerView dmp;
    private ImageView dmq;
    private View dmr;
    private View dms;
    private TextView dmt;
    private TextView dmu;
    private View dmv;
    private View dmw;
    private d dmx;
    private SwanAppAlbumPreviewAdapter dmy;
    private SwanAppThumbnailAdapter dmz;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private boolean dmA = true;
    private boolean dmB = true;
    private boolean dmC = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener dmD = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.aEB();
            SwanAppAlbumPreviewActivity.this.aEA();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.dmy.aEK();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        aEx();
        this.dmx = new d(this);
        this.dmx.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle b2 = u.b(getIntent(), "launchParams");
            this.mIndex = u.a(b2, "previewPosition", 0);
            this.mFrom = u.h(b2, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.akq = new ArrayList<>();
                this.akq.addAll(e.aEO());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.akq = b2 == null ? null : b2.getParcelableArrayList("mediaModels");
            } else {
                this.akq = com.baidu.swan.apps.media.chooser.b.d.aEN();
            }
            if (this.akq == null) {
                this.akq = new ArrayList<>();
            }
        }
        initView();
        aEA();
        aEy();
        aEw();
    }

    private void aEw() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.dmt.setVisibility(8);
            this.dmv.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void aEx() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.dmo = (DragView) findViewById(a.f.drag_view);
        this.dmo.setOnCloseListener(this);
        this.dmo.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.Zk = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.dmq = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.dms = findViewById(a.f.album_preview_back_layout);
        this.dmr = findViewById(a.f.album_preview_select_view);
        this.dmt = (TextView) findViewById(a.f.album_preview_done);
        this.dmu = (TextView) findViewById(a.f.album_preview_select);
        this.dmv = findViewById(a.f.album_preview_bottom);
        this.dmw = findViewById(a.f.album_preview_header);
        this.dms.setOnClickListener(this);
        this.dmt.setOnClickListener(this);
        this.Zk.setOnPageChangeListener(this.dmD);
        this.dmy = new SwanAppAlbumPreviewAdapter(this, this.akq);
        this.Zk.setAdapter(this.dmy);
        this.dmy.a(this);
        this.Zk.setCurrentItem(this.mIndex);
        this.dmr.setOnClickListener(this);
        this.dmt.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.dmt.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.aEP() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.aEP() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.dmt.setText(string);
    }

    private void aEy() {
        ArrayList<MediaModel> aEO;
        this.dmp = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.dmp.setLayoutManager(linearLayoutManager);
        this.dmz = new SwanAppThumbnailAdapter(this);
        this.dmp.setAdapter(this.dmz);
        if (e.aEO() == null) {
            aEO = null;
        } else {
            aEO = e.aEO();
        }
        this.dmz.s(aEO);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwanAppThumbnailTouchCallback(this, this.dmz));
        itemTouchHelper.attachToRecyclerView(this.dmp);
        final com.baidu.swan.apps.media.chooser.b.a a2 = a(this.Zk);
        this.dmp.addOnItemTouchListener(new SwanAppThumbnailClickListener(this.dmp) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.akq != null) {
                    MediaModel jE = SwanAppAlbumPreviewActivity.this.dmz.jE(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.akq.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.akq.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.akq.get(i)).equals(jE)) {
                            a2.gc(true);
                            SwanAppAlbumPreviewActivity.this.Zk.setCurrentItem(i);
                            a2.gc(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> aEL = SwanAppAlbumPreviewActivity.this.dmz.aEL();
                if (viewHolder.getLayoutPosition() >= 0 && aEL != null && viewHolder.getLayoutPosition() != aEL.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        aEz();
        aEB();
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
        if (this.akq != null && this.mIndex < this.akq.size()) {
            this.dmu.setText(a(this.akq.get(this.mIndex)));
        }
    }

    private void aEz() {
        ArrayList<MediaModel> aEO = e.aEO();
        ViewGroup.LayoutParams layoutParams = this.dmv.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (aEO != null && aEO.size() > 0) {
            this.dmp.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.dmp.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEA() {
        if (this.akq != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.akq.size()) {
                mediaModel = this.akq.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.dmu.setVisibility(0);
                    this.dmu.setText(a(this.akq.get(this.mIndex)));
                    this.dmu.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.dmu.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.dmq.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.dmq.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEB() {
        final int b2;
        if (this.dmz != null && this.mIndex < this.akq.size() && (b2 = this.dmz.b(this.akq.get(this.mIndex))) >= 0) {
            if (b2 + 1 < this.dmz.getItemCount()) {
                this.dmp.smoothScrollToPosition(b2 + 1);
            } else {
                this.dmp.smoothScrollToPosition(b2);
            }
            this.dmp.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b2 > 0) {
                        SwanAppAlbumPreviewActivity.this.dmp.smoothScrollToPosition(b2 - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.dmp.smoothScrollToPosition(b2);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.dms) {
            aEC();
            finish();
        } else if (this.akq != null && this.mIndex < this.akq.size()) {
            MediaModel mediaModel = this.akq.get(this.mIndex);
            if (view == this.dmr) {
                if (e.g(mediaModel)) {
                    this.dmz.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.aEP() == 0) {
                        this.dmz.s(null);
                    }
                    this.dmu.setVisibility(8);
                    this.dmq.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.aEP() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.aEP() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.dmt.setText(string);
                    aEz();
                    return;
                }
                int aEP = e.aEP();
                if (aEP == com.baidu.swan.apps.media.chooser.b.d.dnF) {
                    com.baidu.swan.apps.media.chooser.b.d.qw(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (aEP > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.aEQ(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.u(this, a.h.swanapp_album_select_single).aLS();
                } else {
                    int aEP2 = e.aEP();
                    this.dmz.notifyItemInserted(aEP2);
                    e.e(mediaModel);
                    if (this.dmz.aEL() == null) {
                        this.dmz.s(e.aEO());
                    }
                    this.dmp.smoothScrollToPosition(aEP2);
                    this.dmu.setVisibility(0);
                    this.dmu.setText(a(mediaModel));
                    this.dmu.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.dmt.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.aEP() + ")");
                    this.dmt.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    aEz();
                }
            } else if (view == this.dmt) {
                if (e.aEP() == 0 && this.akq != null && this.akq.size() > 0 && this.mIndex < this.akq.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.dlQ);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.dnG);
                bundle.putParcelableArrayList("mediaModels", e.aEO());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.dnJ);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aEC();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aEC() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dmy != null) {
            this.dmy.destroy();
            this.dmy = null;
        }
        this.dmz = null;
        this.dmx = null;
        if (this.akq != null) {
            this.akq = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.listener.a
    public void aED() {
        if (!this.dmC && this.dmB) {
            aEE();
        } else if (!this.dmC) {
            aEF();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.listener.a
    public void aEE() {
        if (this.dmB) {
            this.dmC = true;
            float y = this.dmw.getY();
            float y2 = this.dmv.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dmw, "y", y, y - this.dmw.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.dmC = false;
                    SwanAppAlbumPreviewActivity.this.dmB = SwanAppAlbumPreviewActivity.this.dmB ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dmv, "y", y2, y2 + this.dmv.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.listener.a
    public void aEF() {
        if (!this.dmB) {
            this.dmC = true;
            float y = this.dmw.getY();
            float y2 = this.dmv.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dmw, "y", y, y + this.dmw.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.dmC = false;
                    SwanAppAlbumPreviewActivity.this.dmB = SwanAppAlbumPreviewActivity.this.dmB ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dmv, "y", y2, y2 - this.dmv.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0372a.swanapp_album_preview_enter, a.C0372a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void jA(int i) {
        jB(i);
        jC(i);
        if (i != 0 && this.dmA) {
            h(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.dmo.setBackground(new ColorDrawable(0));
            if (this.dmy != null) {
                this.dmy.al(this.mIndex, a.c.aiapps_transparent);
            }
            this.dmA = false;
        }
        if (i == 0) {
            h(new ColorDrawable(0));
            this.dmo.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.dmy != null) {
                this.dmy.al(this.mIndex, a.c.aiapps_black);
            }
            this.dmA = true;
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

    private void jB(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.dmv != null) {
            this.dmv.setAlpha(1.0f - f);
        }
        if (this.dmw != null) {
            this.dmw.setAlpha(1.0f - f);
        }
    }

    private void jC(int i) {
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
