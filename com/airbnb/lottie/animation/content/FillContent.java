package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    public final BaseKeyframeAnimation colorAnimation;
    public BaseKeyframeAnimation colorFilterAnimation;
    public final boolean hidden;
    public final BaseLayer layer;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final BaseKeyframeAnimation opacityAnimation;
    public final Path path = new Path();
    public final Paint paint = new LPaint(1);
    public final List paths = new ArrayList();

    public FillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeFill shapeFill) {
        this.layer = baseLayer;
        this.name = shapeFill.getName();
        this.hidden = shapeFill.isHidden();
        this.lottieDrawable = lottieDrawable;
        if (shapeFill.getColor() != null && shapeFill.getOpacity() != null) {
            this.path.setFillType(shapeFill.getFillType());
            BaseKeyframeAnimation createAnimation = shapeFill.getColor().createAnimation();
            this.colorAnimation = createAnimation;
            createAnimation.addUpdateListener(this);
            baseLayer.addAnimation(this.colorAnimation);
            BaseKeyframeAnimation createAnimation2 = shapeFill.getOpacity().createAnimation();
            this.opacityAnimation = createAnimation2;
            createAnimation2.addUpdateListener(this);
            baseLayer.addAnimation(this.opacityAnimation);
            return;
        }
        this.colorAnimation = null;
        this.opacityAnimation = null;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        if (this.hidden) {
            return;
        }
        L.beginSection("FillContent#draw");
        this.paint.setColor(((ColorKeyframeAnimation) this.colorAnimation).getIntValue());
        this.paint.setAlpha(MiscUtils.clamp((int) ((((i / 255.0f) * ((Integer) this.opacityAnimation.getValue()).intValue()) / 100.0f) * 255.0f), 0, 255));
        BaseKeyframeAnimation baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter((ColorFilter) baseKeyframeAnimation.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.paths.size(); i2++) {
            this.path.addPath(((PathContent) this.paths.get(i2)).getPath(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        L.endSection("FillContent#draw");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void addValueCallback(Object obj, LottieValueCallback lottieValueCallback) {
        if (obj == LottieProperty.COLOR) {
            this.colorAnimation.setValueCallback(lottieValueCallback);
        } else if (obj == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback);
        } else if (obj == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.layer.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.colorFilterAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorFilterAnimation);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.path.reset();
        for (int i = 0; i < this.paths.size(); i++) {
            this.path.addPath(((PathContent) this.paths.get(i)).getPath(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List list, List list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content content = (Content) list2.get(i);
            if (content instanceof PathContent) {
                this.paths.add((PathContent) content);
            }
        }
    }
}
