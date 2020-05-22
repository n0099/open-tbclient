package com.baidu.live.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.c.a.d.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.widget.HeartSurfaceView;
import com.baidu.live.y.a;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements com.baidu.c.a.d.a {
    private int bkT;
    private int bkU;

    @Override // com.baidu.c.a.d.a
    public void a(final Activity activity, a.InterfaceC0096a interfaceC0096a) {
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        this.bkT = inst.getResources().getDimensionPixelSize(a.C0188a.like_explosion_size);
        this.bkU = inst.getResources().getDimensionPixelSize(a.C0188a.like_heart_size);
        final HeartSurfaceView heartSurfaceView = new HeartSurfaceView(inst);
        heartSurfaceView.setZOrderOnTop(true);
        heartSurfaceView.getHolder().setFormat(-3);
        interfaceC0096a.b(0, heartSurfaceView);
        final a.b bVar = new a.b() { // from class: com.baidu.live.widget.a.1
            @Override // com.baidu.c.a.d.a.b
            public void L(final int i, final int i2) {
                if (a.isDestroyed(activity)) {
                    activity.runOnUiThread(new Runnable() { // from class: com.baidu.live.widget.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(activity, heartSurfaceView, i, i2);
                        }
                    });
                }
            }
        };
        heartSurfaceView.setAnimateEndListener(new HeartSurfaceView.b() { // from class: com.baidu.live.widget.a.2
            @Override // com.baidu.live.widget.HeartSurfaceView.b
            public void K(int i, int i2) {
                bVar.L(i, i2);
            }
        });
    }

    @Override // com.baidu.c.a.d.a
    public void e(View view, int i) {
        if (view instanceof HeartSurfaceView) {
            view.setVisibility(0);
            ((HeartSurfaceView) view).addHeart(i);
        }
    }

    private void a(a.InterfaceC0096a interfaceC0096a) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(TbadkCoreApplication.getInst());
        lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        lottieAnimationView.setAnimation("live/liveshow_video_like_explosion.json");
        interfaceC0096a.b(0, lottieAnimationView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, Animator.AnimatorListener animatorListener) {
        if (view instanceof LottieAnimationView) {
            ((LottieAnimationView) view).addAnimatorListener(animatorListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(View view) {
        if (view instanceof LottieAnimationView) {
            ((LottieAnimationView) view).playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelativeLayout.LayoutParams a(ViewGroup viewGroup, View view, int i, int i2) {
        int i3 = (this.bkT - this.bkU) / 2;
        int left = (view.getLeft() + i) - i3;
        int top2 = (view.getTop() + i2) - i3;
        int width = viewGroup.getWidth() - (this.bkT + left);
        int height = viewGroup.getHeight() - (this.bkT + top2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.bkT, this.bkT);
        layoutParams.setMargins(left, top2, width, height);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Activity activity, final View view, final int i, final int i2) {
        a(new a.InterfaceC0096a() { // from class: com.baidu.live.widget.a.3
            @Override // com.baidu.c.a.d.a.InterfaceC0096a
            public void b(int i3, final View view2) {
                if (i3 == 0 && view != null && view.getParent() != null && view2 != null) {
                    view2.setTag("LottieAnimationView");
                    final ViewGroup viewGroup = (ViewGroup) view.getParent();
                    a.this.p(viewGroup);
                    RelativeLayout.LayoutParams a = a.this.a(viewGroup, view, i, i2);
                    view2.setLayoutParams(a);
                    viewGroup.addView(view2, a);
                    view2.setVisibility(0);
                    a.this.Y(view2);
                    a.this.a(view2, new AnimatorListenerAdapter() { // from class: com.baidu.live.widget.a.3.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (a.isDestroyed(activity) && viewGroup != null) {
                                view2.setVisibility(8);
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getTag() != null && childAt.getTag().equals("LottieAnimationView") && childAt.getVisibility() == 8) {
                    arrayList.add(childAt);
                }
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                viewGroup.removeView((View) arrayList.get(size));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDestroyed(Activity activity) {
        return Build.VERSION.SDK_INT <= 16 ? (activity == null || activity.isFinishing()) ? false : true : (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }
}
