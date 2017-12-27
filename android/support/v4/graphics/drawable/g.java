package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapperGingerbread;
/* loaded from: classes2.dex */
class g extends DrawableWrapperGingerbread {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Drawable drawable) {
        super(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(DrawableWrapperGingerbread.DrawableWrapperState drawableWrapperState, Resources resources) {
        super(drawableWrapperState, resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.wz.jumpToCurrentState();
    }

    @Override // android.support.v4.graphics.drawable.DrawableWrapperGingerbread
    DrawableWrapperGingerbread.DrawableWrapperState dg() {
        return new a(this.wy, null);
    }

    /* loaded from: classes2.dex */
    private static class a extends DrawableWrapperGingerbread.DrawableWrapperState {
        a(DrawableWrapperGingerbread.DrawableWrapperState drawableWrapperState, Resources resources) {
            super(drawableWrapperState, resources);
        }

        @Override // android.support.v4.graphics.drawable.DrawableWrapperGingerbread.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new g(this, resources);
        }
    }
}
