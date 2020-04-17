package com.baidu.live.tieba.horizonallist.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.live.tieba.horizonallist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC0124a {
        protected View view;

        public abstract boolean isHardwareAccelerated();

        public abstract void postOnAnimation(Runnable runnable);

        public abstract void setScrollX(int i);

        protected AbstractC0124a(View view) {
            this.view = view;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends AbstractC0124a {
        public b(View view) {
            super(view);
        }

        @Override // com.baidu.live.tieba.horizonallist.a.a.AbstractC0124a
        public void postOnAnimation(Runnable runnable) {
            this.view.post(runnable);
        }

        @Override // com.baidu.live.tieba.horizonallist.a.a.AbstractC0124a
        public void setScrollX(int i) {
            this.view.scrollTo(i, this.view.getScrollY());
        }

        @Override // com.baidu.live.tieba.horizonallist.a.a.AbstractC0124a
        public boolean isHardwareAccelerated() {
            return false;
        }
    }

    public static final AbstractC0124a R(View view) {
        return Build.VERSION.SDK_INT >= 14 ? new com.baidu.live.tieba.horizonallist.a.b.a(view) : new b(view);
    }
}
