package com.baidu.live.tieba.horizonallist.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.live.tieba.horizonallist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC0178a {
        protected View view;

        public abstract boolean isHardwareAccelerated();

        public abstract void postOnAnimation(Runnable runnable);

        public abstract void setScrollX(int i);

        protected AbstractC0178a(View view) {
            this.view = view;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends AbstractC0178a {
        public b(View view) {
            super(view);
        }

        @Override // com.baidu.live.tieba.horizonallist.a.a.AbstractC0178a
        public void postOnAnimation(Runnable runnable) {
            this.view.post(runnable);
        }

        @Override // com.baidu.live.tieba.horizonallist.a.a.AbstractC0178a
        public void setScrollX(int i) {
            this.view.scrollTo(i, this.view.getScrollY());
        }

        @Override // com.baidu.live.tieba.horizonallist.a.a.AbstractC0178a
        public boolean isHardwareAccelerated() {
            return false;
        }
    }

    public static final AbstractC0178a Q(View view) {
        return Build.VERSION.SDK_INT >= 14 ? new com.baidu.live.tieba.horizonallist.a.b.a(view) : new b(view);
    }
}
