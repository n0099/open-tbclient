package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    public final List<Content> contents;
    public final boolean hidden;
    public final LottieDrawable lottieDrawable;
    public final Matrix matrix;
    public final String name;
    public Paint offScreenPaint;
    public RectF offScreenRectF;
    public final Path path;
    @Nullable
    public List<PathContent> pathContents;
    public final RectF rect;
    @Nullable
    public TransformKeyframeAnimation transformAnimation;

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeGroup shapeGroup) {
        this(lottieDrawable, baseLayer, shapeGroup.getName(), shapeGroup.isHidden(), contentsFromModels(lottieDrawable, baseLayer, shapeGroup.getItems()), findTransform(shapeGroup.getItems()));
    }

    public static List<Content> contentsFromModels(LottieDrawable lottieDrawable, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content content = list.get(i2).toContent(lottieDrawable, baseLayer);
            if (content != null) {
                arrayList.add(content);
            }
        }
        return arrayList;
    }

    @Nullable
    public static AnimatableTransform findTransform(List<ContentModel> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            ContentModel contentModel = list.get(i2);
            if (contentModel instanceof AnimatableTransform) {
                return (AnimatableTransform) contentModel;
            }
        }
        return null;
    }

    private boolean hasTwoOrMoreDrawableContent() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.contents.size(); i3++) {
            if ((this.contents.get(i3) instanceof DrawingContent) && (i2 = i2 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.applyValueCallback(t, lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i2) {
        if (this.hidden) {
            return;
        }
        this.matrix.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.preConcat(transformKeyframeAnimation.getMatrix());
            i2 = (int) (((((this.transformAnimation.getOpacity() == null ? 100 : this.transformAnimation.getOpacity().getValue().intValue()) / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        boolean z = this.lottieDrawable.isApplyingOpacityToLayersEnabled() && hasTwoOrMoreDrawableContent() && i2 != 255;
        if (z) {
            this.offScreenRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            getBounds(this.offScreenRectF, this.matrix, true);
            this.offScreenPaint.setAlpha(i2);
            Utils.saveLayerCompat(canvas, this.offScreenRectF, this.offScreenPaint);
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).draw(canvas, this.matrix, i2);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.matrix.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.preConcat(transformKeyframeAnimation.getMatrix());
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).getBounds(this.rect, this.matrix, z);
                rectF.union(this.rect);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        this.matrix.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.set(transformKeyframeAnimation.getMatrix());
        }
        this.path.reset();
        if (this.hidden) {
            return this.path;
        }
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            if (content instanceof PathContent) {
                this.path.addPath(((PathContent) content).getPath(), this.matrix);
            }
        }
        return this.path;
    }

    public List<PathContent> getPathList() {
        if (this.pathContents == null) {
            this.pathContents = new ArrayList();
            for (int i2 = 0; i2 < this.contents.size(); i2++) {
                Content content = this.contents.get(i2);
                if (content instanceof PathContent) {
                    this.pathContents.add((PathContent) content);
                }
            }
        }
        return this.pathContents;
    }

    public Matrix getTransformationMatrix() {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.matches(getName(), i2)) {
            if (!"__container".equals(getName())) {
                keyPath2 = keyPath2.addKey(getName());
                if (keyPath.fullyResolvesTo(getName(), i2)) {
                    list.add(keyPath2.resolve(this));
                }
            }
            if (keyPath.propagateToChildren(getName(), i2)) {
                int incrementDepthBy = i2 + keyPath.incrementDepthBy(getName(), i2);
                for (int i3 = 0; i3 < this.contents.size(); i3++) {
                    Content content = this.contents.get(i3);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).resolveKeyPath(keyPath, incrementDepthBy, list, keyPath2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.contents.size());
        arrayList.addAll(list);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            content.setContents(arrayList, this.contents.subList(0, size));
            arrayList.add(content);
        }
    }

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z, List<Content> list, @Nullable AnimatableTransform animatableTransform) {
        this.offScreenPaint = new LPaint();
        this.offScreenRectF = new RectF();
        this.matrix = new Matrix();
        this.path = new Path();
        this.rect = new RectF();
        this.name = str;
        this.lottieDrawable = lottieDrawable;
        this.hidden = z;
        this.contents = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation createAnimation = animatableTransform.createAnimation();
            this.transformAnimation = createAnimation;
            createAnimation.addAnimationsToLayer(baseLayer);
            this.transformAnimation.addListener(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).absorbContent(list.listIterator(list.size()));
        }
    }
}
