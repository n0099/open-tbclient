package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.design.widget.p;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public final class Snackbar {
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    static final Handler pL = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: android.support.design.widget.Snackbar.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((Snackbar) message.obj).ce();
                    return true;
                case 1:
                    ((Snackbar) message.obj).I(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    });
    private final AccessibilityManager mAccessibilityManager;
    private final Context mContext;
    private int mDuration;
    private final ViewGroup pM;
    final SnackbarLayout pN;
    private Callback pO;
    final p.a pP = new p.a() { // from class: android.support.design.widget.Snackbar.4
        @Override // android.support.design.widget.p.a
        public void show() {
            Snackbar.pL.sendMessage(Snackbar.pL.obtainMessage(0, Snackbar.this));
        }

        @Override // android.support.design.widget.p.a
        public void K(int i) {
            Snackbar.pL.sendMessage(Snackbar.pL.obtainMessage(1, i, 0, Snackbar.this));
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface Duration {
    }

    /* loaded from: classes2.dex */
    public static abstract class Callback {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        /* loaded from: classes2.dex */
        public @interface DismissEvent {
        }

        public void onDismissed(Snackbar snackbar, int i) {
        }

        public void onShown(Snackbar snackbar) {
        }
    }

    private Snackbar(ViewGroup viewGroup) {
        this.pM = viewGroup;
        this.mContext = viewGroup.getContext();
        r.R(this.mContext);
        this.pN = (SnackbarLayout) LayoutInflater.from(this.mContext).inflate(R.layout.design_layout_snackbar, this.pM, false);
        this.mAccessibilityManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
    }

    public static Snackbar make(View view, CharSequence charSequence, int i) {
        Snackbar snackbar = new Snackbar(D(view));
        snackbar.setText(charSequence);
        snackbar.setDuration(i);
        return snackbar;
    }

    public static Snackbar make(View view, int i, int i2) {
        return make(view, view.getResources().getText(i), i2);
    }

    private static ViewGroup D(View view) {
        ViewGroup viewGroup = null;
        View view2 = view;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup) view2;
                }
                viewGroup = (ViewGroup) view2;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                    continue;
                } else {
                    view2 = null;
                    continue;
                }
            }
            if (view2 == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view2;
    }

    public Snackbar setAction(int i, View.OnClickListener onClickListener) {
        return setAction(this.mContext.getText(i), onClickListener);
    }

    public Snackbar setAction(CharSequence charSequence, final View.OnClickListener onClickListener) {
        Button actionView = this.pN.getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
        } else {
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() { // from class: android.support.design.widget.Snackbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    Snackbar.this.G(1);
                }
            });
        }
        return this;
    }

    public Snackbar setActionTextColor(ColorStateList colorStateList) {
        this.pN.getActionView().setTextColor(colorStateList);
        return this;
    }

    public Snackbar setActionTextColor(int i) {
        this.pN.getActionView().setTextColor(i);
        return this;
    }

    public Snackbar setText(CharSequence charSequence) {
        this.pN.getMessageView().setText(charSequence);
        return this;
    }

    public Snackbar setText(int i) {
        return setText(this.mContext.getText(i));
    }

    public Snackbar setDuration(int i) {
        this.mDuration = i;
        return this;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public View getView() {
        return this.pN;
    }

    public void show() {
        p.ch().a(this.mDuration, this.pP);
    }

    public void dismiss() {
        G(3);
    }

    void G(int i) {
        p.ch().a(this.pP, i);
    }

    public Snackbar setCallback(Callback callback) {
        this.pO = callback;
        return this;
    }

    public boolean isShown() {
        return p.ch().e(this.pP);
    }

    public boolean isShownOrQueued() {
        return p.ch().f(this.pP);
    }

    final void ce() {
        if (this.pN.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.pN.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                a aVar = new a();
                aVar.setStartAlphaSwipeDistance(0.1f);
                aVar.setEndAlphaSwipeDistance(0.6f);
                aVar.setSwipeDirection(0);
                aVar.setListener(new SwipeDismissBehavior.OnDismissListener() { // from class: android.support.design.widget.Snackbar.5
                    @Override // android.support.design.widget.SwipeDismissBehavior.OnDismissListener
                    public void onDismiss(View view) {
                        view.setVisibility(8);
                        Snackbar.this.G(0);
                    }

                    @Override // android.support.design.widget.SwipeDismissBehavior.OnDismissListener
                    public void onDragStateChanged(int i) {
                        switch (i) {
                            case 0:
                                p.ch().d(Snackbar.this.pP);
                                return;
                            case 1:
                            case 2:
                                p.ch().c(Snackbar.this.pP);
                                return;
                            default:
                                return;
                        }
                    }
                });
                layoutParams2.setBehavior(aVar);
                layoutParams2.insetEdge = 80;
            }
            this.pM.addView(this.pN);
        }
        this.pN.setOnAttachStateChangeListener(new SnackbarLayout.a() { // from class: android.support.design.widget.Snackbar.6
            @Override // android.support.design.widget.Snackbar.SnackbarLayout.a
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.support.design.widget.Snackbar.SnackbarLayout.a
            public void onViewDetachedFromWindow(View view) {
                if (Snackbar.this.isShownOrQueued()) {
                    Snackbar.pL.post(new Runnable() { // from class: android.support.design.widget.Snackbar.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Snackbar.this.J(3);
                        }
                    });
                }
            }
        });
        if (ViewCompat.isLaidOut(this.pN)) {
            if (shouldAnimate()) {
                cf();
                return;
            } else {
                cg();
                return;
            }
        }
        this.pN.setOnLayoutChangeListener(new SnackbarLayout.b() { // from class: android.support.design.widget.Snackbar.7
            @Override // android.support.design.widget.Snackbar.SnackbarLayout.b
            public void a(View view, int i, int i2, int i3, int i4) {
                Snackbar.this.pN.setOnLayoutChangeListener(null);
                if (Snackbar.this.shouldAnimate()) {
                    Snackbar.this.cf();
                } else {
                    Snackbar.this.cg();
                }
            }
        });
    }

    void cf() {
        if (Build.VERSION.SDK_INT >= 14) {
            ViewCompat.setTranslationY(this.pN, this.pN.getHeight());
            ViewCompat.animate(this.pN).translationY(0.0f).setInterpolator(android.support.design.widget.a.kB).setDuration(250L).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.design.widget.Snackbar.8
                @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view) {
                    Snackbar.this.pN.m(70, SubsamplingScaleImageView.ORIENTATION_180);
                }

                @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view) {
                    Snackbar.this.cg();
                }
            }).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.pN.getContext(), R.anim.design_snackbar_in);
        loadAnimation.setInterpolator(android.support.design.widget.a.kB);
        loadAnimation.setDuration(250L);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.design.widget.Snackbar.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Snackbar.this.cg();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.pN.startAnimation(loadAnimation);
    }

    private void H(final int i) {
        if (Build.VERSION.SDK_INT >= 14) {
            ViewCompat.animate(this.pN).translationY(this.pN.getHeight()).setInterpolator(android.support.design.widget.a.kB).setDuration(250L).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: android.support.design.widget.Snackbar.10
                @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                public void onAnimationStart(View view) {
                    Snackbar.this.pN.n(0, SubsamplingScaleImageView.ORIENTATION_180);
                }

                @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view) {
                    Snackbar.this.J(i);
                }
            }).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.pN.getContext(), R.anim.design_snackbar_out);
        loadAnimation.setInterpolator(android.support.design.widget.a.kB);
        loadAnimation.setDuration(250L);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.design.widget.Snackbar.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Snackbar.this.J(i);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.pN.startAnimation(loadAnimation);
    }

    final void I(int i) {
        if (shouldAnimate() && this.pN.getVisibility() == 0) {
            H(i);
        } else {
            J(i);
        }
    }

    void cg() {
        p.ch().b(this.pP);
        if (this.pO != null) {
            this.pO.onShown(this);
        }
    }

    void J(int i) {
        p.ch().a(this.pP);
        if (this.pO != null) {
            this.pO.onDismissed(this, i);
        }
        if (Build.VERSION.SDK_INT < 11) {
            this.pN.setVisibility(8);
        }
        ViewParent parent = this.pN.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.pN);
        }
    }

    boolean shouldAnimate() {
        return !this.mAccessibilityManager.isEnabled();
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class SnackbarLayout extends LinearLayout {
        private int mMaxWidth;
        private TextView pU;
        private Button pV;
        private int pW;
        private b pX;
        private a pY;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public interface a {
            void onViewAttachedToWindow(View view);

            void onViewDetachedFromWindow(View view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public interface b {
            void a(View view, int i, int i2, int i3, int i4);
        }

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
            this.pW = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
            if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(R.layout.design_layout_snackbar_include, this);
            ViewCompat.setAccessibilityLiveRegion(this, 1);
            ViewCompat.setImportantForAccessibility(this, 1);
            ViewCompat.setFitsSystemWindows(this, true);
            ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.Snackbar.SnackbarLayout.1
                @Override // android.support.v4.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                    return windowInsetsCompat;
                }
            });
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            this.pU = (TextView) findViewById(R.id.snackbar_text);
            this.pV = (Button) findViewById(R.id.snackbar_action);
        }

        TextView getMessageView() {
            return this.pU;
        }

        Button getActionView() {
            return this.pV;
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            boolean z;
            super.onMeasure(i, i2);
            if (this.mMaxWidth > 0 && getMeasuredWidth() > this.mMaxWidth) {
                i = View.MeasureSpec.makeMeasureSpec(this.mMaxWidth, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
            boolean z2 = this.pU.getLayout().getLineCount() > 1;
            if (z2 && this.pW > 0 && this.pV.getMeasuredWidth() > this.pW) {
                if (c(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    z = true;
                }
                z = false;
            } else {
                if (!z2) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (c(0, dimensionPixelSize, dimensionPixelSize)) {
                    z = true;
                }
                z = false;
            }
            if (z) {
                super.onMeasure(i, i2);
            }
        }

        void m(int i, int i2) {
            ViewCompat.setAlpha(this.pU, 0.0f);
            ViewCompat.animate(this.pU).alpha(1.0f).setDuration(i2).setStartDelay(i).start();
            if (this.pV.getVisibility() == 0) {
                ViewCompat.setAlpha(this.pV, 0.0f);
                ViewCompat.animate(this.pV).alpha(1.0f).setDuration(i2).setStartDelay(i).start();
            }
        }

        void n(int i, int i2) {
            ViewCompat.setAlpha(this.pU, 1.0f);
            ViewCompat.animate(this.pU).alpha(0.0f).setDuration(i2).setStartDelay(i).start();
            if (this.pV.getVisibility() == 0) {
                ViewCompat.setAlpha(this.pV, 1.0f);
                ViewCompat.animate(this.pV).alpha(0.0f).setDuration(i2).setStartDelay(i).start();
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.pX != null) {
                this.pX.a(this, i, i2, i3, i4);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.pY != null) {
                this.pY.onViewAttachedToWindow(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.pY != null) {
                this.pY.onViewDetachedFromWindow(this);
            }
        }

        void setOnLayoutChangeListener(b bVar) {
            this.pX = bVar;
        }

        void setOnAttachStateChangeListener(a aVar) {
            this.pY = aVar;
        }

        private boolean c(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.pU.getPaddingTop() != i2 || this.pU.getPaddingBottom() != i3) {
                b(this.pU, i2, i3);
                return true;
            }
            return z;
        }

        private static void b(View view, int i, int i2) {
            if (ViewCompat.isPaddingRelative(view)) {
                ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i, ViewCompat.getPaddingEnd(view), i2);
            } else {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a extends SwipeDismissBehavior<SnackbarLayout> {
        a() {
        }

        @Override // android.support.design.widget.SwipeDismissBehavior
        public boolean canSwipeDismissView(View view) {
            return view instanceof SnackbarLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.SwipeDismissBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        /* renamed from: a */
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.isPointInChildBounds(snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        p.ch().c(Snackbar.this.pP);
                        break;
                    case 1:
                    case 3:
                        p.ch().d(Snackbar.this.pP);
                        break;
                }
            }
            return super.onInterceptTouchEvent(coordinatorLayout, snackbarLayout, motionEvent);
        }
    }
}
