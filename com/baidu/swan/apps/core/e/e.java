package com.baidu.swan.apps.core.e;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class e {
    private static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
    private a aMo;
    private Context mContext;
    private View mCustomView;
    private FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;

    /* loaded from: classes2.dex */
    public interface a {
        void FX();
    }

    public e(Context context) {
        this.mContext = context;
    }

    public void a(View view, int i, a aVar) {
        Context context = this.mContext;
        Activity activity = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        if (activity != null) {
            if (this.mCustomView != null) {
                aVar.FX();
                return;
            }
            this.mOriginalOrientation = activity.getRequestedOrientation();
            this.mFullscreenContainer = new b(activity);
            this.mFullscreenContainer.addView(view, COVER_SCREEN_PARAMS);
            ((FrameLayout) activity.getWindow().getDecorView()).addView(this.mFullscreenContainer, COVER_SCREEN_PARAMS);
            this.mCustomView = view;
            e(activity, true);
            this.aMo = aVar;
            activity.setRequestedOrientation(i);
        }
    }

    public void hideCustomView() {
        if (this.mCustomView != null) {
            Context context = this.mContext;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                e(activity, false);
                ((FrameLayout) activity.getWindow().getDecorView()).removeView(this.mFullscreenContainer);
                this.mFullscreenContainer = null;
                this.mCustomView = null;
                this.aMo.FX();
                activity.setRequestedOrientation(this.mOriginalOrientation);
            }
        }
    }

    public void e(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    /* loaded from: classes2.dex */
    static class b extends FrameLayout {
        public b(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }
}
