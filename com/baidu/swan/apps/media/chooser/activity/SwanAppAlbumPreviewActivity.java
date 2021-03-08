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
    private ViewPager aaw;
    private ArrayList<MediaModel> akG;
    private DragView dlo;
    private RecyclerView dlp;
    private ImageView dlq;
    private View dlr;
    private View dls;
    private TextView dlt;
    private TextView dlu;
    private View dlv;
    private View dlw;
    private d dlx;
    private SwanAppAlbumPreviewAdapter dly;
    private SwanAppThumbnailAdapter dlz;
    private String mFrom;
    private int mIndex;
    private View mLineView;
    private View mRootView;
    private boolean dlA = true;
    private boolean dlB = true;
    private boolean dlC = false;
    private int mDuration = 200;
    private ViewPager.OnPageChangeListener dlD = new ViewPager.OnPageChangeListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwanAppAlbumPreviewActivity.this.mIndex = i;
            SwanAppAlbumPreviewActivity.this.aBj();
            SwanAppAlbumPreviewActivity.this.aBi();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            SwanAppAlbumPreviewActivity.this.dly.aBs();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        aBf();
        this.dlx = new d(this);
        this.dlx.setStatusBarTintEnabled(false);
        getWindow().setFlags(1024, 1024);
        setContentView(a.g.swanapp_album_preview_layout);
        if (getIntent() != null) {
            Bundle b = u.b(getIntent(), "launchParams");
            this.mIndex = u.a(b, "previewPosition", 0);
            this.mFrom = u.h(b, "previewFrom");
            if (TextUtils.equals(this.mFrom, "bottomPreview")) {
                this.akG = new ArrayList<>();
                this.akG.addAll(e.aBw());
            } else if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                this.akG = b == null ? null : b.getParcelableArrayList("mediaModels");
            } else {
                this.akG = com.baidu.swan.apps.media.chooser.b.d.aBv();
            }
            if (this.akG == null) {
                this.akG = new ArrayList<>();
            }
        }
        initView();
        aBi();
        aBg();
        aBe();
    }

    private void aBe() {
        if (TextUtils.equals(this.mFrom, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
            this.dlt.setVisibility(8);
            this.dlv.setVisibility(8);
        }
    }

    @TargetApi(19)
    private void aBf() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 67108864;
        window.setAttributes(attributes);
    }

    private void initView() {
        String string;
        this.mRootView = findViewById(a.f.album_preview_content);
        this.dlo = (DragView) findViewById(a.f.drag_view);
        this.dlo.setOnCloseListener(this);
        this.dlo.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
        this.aaw = (ViewPager) findViewById(a.f.album_preview_viewpager);
        this.dlq = (ImageView) findViewById(a.f.album_preview_select_checkbox);
        this.dls = findViewById(a.f.album_preview_back_layout);
        this.dlr = findViewById(a.f.album_preview_select_view);
        this.dlt = (TextView) findViewById(a.f.album_preview_done);
        this.dlu = (TextView) findViewById(a.f.album_preview_select);
        this.dlv = findViewById(a.f.album_preview_bottom);
        this.dlw = findViewById(a.f.album_preview_header);
        this.dls.setOnClickListener(this);
        this.dlt.setOnClickListener(this);
        this.aaw.setOnPageChangeListener(this.dlD);
        this.dly = new SwanAppAlbumPreviewAdapter(this, this.akG);
        this.aaw.setAdapter(this.dly);
        this.dly.a(this);
        this.aaw.setCurrentItem(this.mIndex);
        this.dlr.setOnClickListener(this);
        this.dlt.setBackgroundResource(a.e.swanapp_album_preview_done_bg);
        this.dlt.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
        if (e.aBx() != 0) {
            string = getString(a.h.swanapp_album_selected_done) + "(" + e.aBx() + ")";
        } else {
            string = getString(a.h.swanapp_album_selected_done);
        }
        this.dlt.setText(string);
    }

    private void aBg() {
        ArrayList<MediaModel> aBw;
        this.dlp = (RecyclerView) findViewById(a.f.thumbnail_drag_view);
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
        this.dlp.setLayoutManager(linearLayoutManager);
        this.dlz = new SwanAppThumbnailAdapter(this);
        this.dlp.setAdapter(this.dlz);
        if (e.aBw() == null) {
            aBw = null;
        } else {
            aBw = e.aBw();
        }
        this.dlz.n(aBw);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwanAppThumbnailTouchCallback(this, this.dlz));
        itemTouchHelper.attachToRecyclerView(this.dlp);
        final com.baidu.swan.apps.media.chooser.b.a a2 = a(this.aaw);
        this.dlp.addOnItemTouchListener(new SwanAppThumbnailClickListener(this.dlp) { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.2
            @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
            public void a(RecyclerView.ViewHolder viewHolder) {
                if (SwanAppAlbumPreviewActivity.this.akG != null) {
                    MediaModel ic = SwanAppAlbumPreviewActivity.this.dlz.ic(viewHolder.getAdapterPosition());
                    int size = SwanAppAlbumPreviewActivity.this.akG.size();
                    for (int i = 0; i < size; i++) {
                        if (SwanAppAlbumPreviewActivity.this.akG.get(i) != null && ((MediaModel) SwanAppAlbumPreviewActivity.this.akG.get(i)).equals(ic)) {
                            a2.ga(true);
                            SwanAppAlbumPreviewActivity.this.aaw.setCurrentItem(i);
                            a2.ga(false);
                            return;
                        }
                    }
                }
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.SwanAppThumbnailClickListener
            public void b(RecyclerView.ViewHolder viewHolder) {
                ArrayList<MediaModel> aBt = SwanAppAlbumPreviewActivity.this.dlz.aBt();
                if (viewHolder.getLayoutPosition() >= 0 && aBt != null && viewHolder.getLayoutPosition() != aBt.size()) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        aBh();
        aBj();
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
        if (this.akG != null && this.mIndex < this.akG.size()) {
            this.dlu.setText(a(this.akG.get(this.mIndex)));
        }
    }

    private void aBh() {
        ArrayList<MediaModel> aBw = e.aBw();
        ViewGroup.LayoutParams layoutParams = this.dlv.getLayoutParams();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.swanapp_preview_bottom_height);
        if (aBw != null && aBw.size() > 0) {
            this.dlp.setVisibility(0);
            this.mLineView.setVisibility(0);
            layoutParams.height = dimensionPixelSize;
            return;
        }
        this.dlp.setVisibility(8);
        this.mLineView.setVisibility(8);
        layoutParams.height = (dimensionPixelSize - getResources().getDimensionPixelSize(a.d.swanapp_album_line)) - getResources().getDimensionPixelSize(a.d.swanapp_preview_drag_view_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBi() {
        if (this.akG != null) {
            MediaModel mediaModel = null;
            if (this.mIndex < this.akG.size()) {
                mediaModel = this.akG.get(this.mIndex);
            }
            if (mediaModel != null) {
                if (e.c(mediaModel)) {
                    this.dlu.setVisibility(0);
                    this.dlu.setText(a(this.akG.get(this.mIndex)));
                    this.dlu.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    return;
                }
                this.dlu.setVisibility(8);
                if (com.baidu.swan.apps.media.chooser.b.d.a(com.baidu.swan.apps.media.chooser.b.d.mMode, mediaModel)) {
                    this.dlq.setImageResource(a.e.swanapp_album_preview_unselect_unable);
                } else {
                    this.dlq.setImageResource(a.e.swanapp_album_preview_unselect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBj() {
        final int b;
        if (this.dlz != null && this.mIndex < this.akG.size() && (b = this.dlz.b(this.akG.get(this.mIndex))) >= 0) {
            if (b + 1 < this.dlz.getItemCount()) {
                this.dlp.smoothScrollToPosition(b + 1);
            } else {
                this.dlp.smoothScrollToPosition(b);
            }
            this.dlp.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b > 0) {
                        SwanAppAlbumPreviewActivity.this.dlp.smoothScrollToPosition(b - 1);
                    } else {
                        SwanAppAlbumPreviewActivity.this.dlp.smoothScrollToPosition(b);
                    }
                }
            }, 300L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        if (view == this.dls) {
            aBk();
            finish();
        } else if (this.akG != null && this.mIndex < this.akG.size()) {
            MediaModel mediaModel = this.akG.get(this.mIndex);
            if (view == this.dlr) {
                if (e.g(mediaModel)) {
                    this.dlz.notifyItemRemoved(e.d(mediaModel));
                    e.f(mediaModel);
                    if (e.aBx() == 0) {
                        this.dlz.n(null);
                    }
                    this.dlu.setVisibility(8);
                    this.dlq.setImageResource(a.e.swanapp_album_preview_unselect);
                    if (e.aBx() > 0) {
                        string = getString(a.h.swanapp_album_selected_done) + "(" + e.aBx() + ")";
                    } else {
                        string = getString(a.h.swanapp_album_selected_done);
                    }
                    this.dlt.setText(string);
                    aBh();
                    return;
                }
                int aBx = e.aBx();
                if (aBx == com.baidu.swan.apps.media.chooser.b.d.dmE) {
                    com.baidu.swan.apps.media.chooser.b.d.pK(com.baidu.swan.apps.media.chooser.b.d.mMode);
                } else if (aBx > 0 && TextUtils.equals(com.baidu.swan.apps.media.chooser.b.d.mMode, "single") && !TextUtils.equals(e.aBy(), mediaModel.getType())) {
                    com.baidu.swan.apps.res.widget.b.d.u(this, a.h.swanapp_album_select_single).aIv();
                } else {
                    int aBx2 = e.aBx();
                    this.dlz.notifyItemInserted(aBx2);
                    e.e(mediaModel);
                    if (this.dlz.aBt() == null) {
                        this.dlz.n(e.aBw());
                    }
                    this.dlp.smoothScrollToPosition(aBx2);
                    this.dlu.setVisibility(0);
                    this.dlu.setText(a(mediaModel));
                    this.dlu.setBackgroundResource(a.e.swanapp_album_preview_select_bg);
                    this.dlt.setText(getString(a.h.swanapp_album_selected_done) + "(" + e.aBx() + ")");
                    this.dlt.setTextColor(getResources().getColor(a.c.swanapp_album_preview_select_done_color));
                    aBh();
                }
            } else if (view == this.dlt) {
                if (e.aBx() == 0 && this.akG != null && this.akG.size() > 0 && this.mIndex < this.akG.size()) {
                    e.e(mediaModel);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", com.baidu.swan.apps.media.chooser.b.d.dkQ);
                bundle.putString("swanAppId", com.baidu.swan.apps.media.chooser.b.d.dmF);
                bundle.putParcelableArrayList("mediaModels", e.aBw());
                bundle.putString("swanTmpPath", com.baidu.swan.apps.media.chooser.b.d.dmI);
                com.baidu.swan.apps.media.chooser.b.d.c(this, bundle);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aBk();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aBk() {
        Intent intent = new Intent();
        intent.putExtra("isRefresh", true);
        setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dly != null) {
            this.dly.destroy();
            this.dly = null;
        }
        this.dlz = null;
        this.dlx = null;
        if (this.akG != null) {
            this.akG = null;
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.listener.a
    public void aBl() {
        if (!this.dlC && this.dlB) {
            aBm();
        } else if (!this.dlC) {
            aBn();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.listener.a
    public void aBm() {
        if (this.dlB) {
            this.dlC = true;
            float y = this.dlw.getY();
            float y2 = this.dlv.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dlw, "y", y, y - this.dlw.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.dlC = false;
                    SwanAppAlbumPreviewActivity.this.dlB = SwanAppAlbumPreviewActivity.this.dlB ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dlv, "y", y2, y2 + this.dlv.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.media.chooser.listener.a
    public void aBn() {
        if (!this.dlB) {
            this.dlC = true;
            float y = this.dlw.getY();
            float y2 = this.dlv.getY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dlw, "y", y, y + this.dlw.getHeight());
            ofFloat.setDuration(this.mDuration);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwanAppAlbumPreviewActivity.this.dlC = false;
                    SwanAppAlbumPreviewActivity.this.dlB = SwanAppAlbumPreviewActivity.this.dlB ? false : true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dlv, "y", y2, y2 - this.dlv.getHeight());
            ofFloat2.setDuration(this.mDuration);
            ofFloat2.start();
        }
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void onClose() {
        finish();
        overridePendingTransition(a.C0358a.swanapp_album_preview_enter, a.C0358a.aiapps_hold);
    }

    @Override // com.baidu.swan.apps.view.DragView.a
    public void hY(int i) {
        hZ(i);
        ia(i);
        if (i != 0 && this.dlA) {
            h(new ColorDrawable(Color.parseColor("#1a1a1a")));
            this.dlo.setBackground(new ColorDrawable(0));
            if (this.dly != null) {
                this.dly.ai(this.mIndex, a.c.aiapps_transparent);
            }
            this.dlA = false;
        }
        if (i == 0) {
            h(new ColorDrawable(0));
            this.dlo.setBackgroundColor(getResources().getColor(a.c.aiapps_black));
            if (this.dly != null) {
                this.dly.ai(this.mIndex, a.c.aiapps_black);
            }
            this.dlA = true;
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

    private void hZ(int i) {
        float f = i == 0 ? 0.0f : 1.0f;
        if (this.dlv != null) {
            this.dlv.setAlpha(1.0f - f);
        }
        if (this.dlw != null) {
            this.dlw.setAlpha(1.0f - f);
        }
    }

    private void ia(int i) {
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
