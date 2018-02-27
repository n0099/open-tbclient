package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapperGingerbread;
/* loaded from: classes2.dex */
class h extends g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Drawable drawable) {
        super(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(DrawableWrapperGingerbread.DrawableWrapperState drawableWrapperState, Resources resources) {
        super(drawableWrapperState, resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.wy.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.wy.isAutoMirrored();
    }

    @Override // android.support.v4.graphics.drawable.g, android.support.v4.graphics.drawable.DrawableWrapperGingerbread
    DrawableWrapperGingerbread.DrawableWrapperState dg() {
        return new a(this.wx, null);
    }

    /* loaded from: classes2.dex */
    private static class a extends DrawableWrapperGingerbread.DrawableWrapperState {
        a(DrawableWrapperGingerbread.DrawableWrapperState drawableWrapperState, Resources resources) {
            super(drawableWrapperState, resources);
        }

        @Override // android.support.v4.graphics.drawable.DrawableWrapperGingerbread.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new h(this, resources);
        }
    }
}
