package com.baidu.live.tieba.horizonallist.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.baidu.live.tieba.horizonallist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC0187a {
        protected View view;

        public abstract boolean isHardwareAccelerated();

        public abstract void postOnAnimation(Runnable runnable);

        public abstract void setScrollX(int i);

        protected AbstractC0187a(View view) {
            this.view = view;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends AbstractC0187a {
        public b(View view) {
            super(view);
        }

        @Override // com.baidu.live.tieba.horizonallist.a.a.AbstractC0187a
        public void postOnAnimation(Runnable runnable) {
            this.view.post(runnable);
        }

        @Override // com.baidu.live.tieba.horizonallist.a.a.AbstractC0187a
        public void setScrollX(int i) {
            this.view.scrollTo(i, this.view.getScrollY());
        }

        @Override // com.baidu.live.tieba.horizonallist.a.a.AbstractC0187a
        public boolean isHardwareAccelerated() {
            return false;
        }
    }

    public static final AbstractC0187a V(View view) {
        return Build.VERSION.SDK_INT >= 14 ? new com.baidu.live.tieba.horizonallist.a.b.a(view) : new b(view);
    }
}
