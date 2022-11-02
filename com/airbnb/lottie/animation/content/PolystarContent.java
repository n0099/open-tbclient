package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;
/* loaded from: classes.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    public static final float POLYGON_MAGIC_NUMBER = 0.25f;
    public static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    public final boolean hidden;
    @Nullable
    public final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    @Nullable
    public final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    public boolean isPathValid;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    public final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    public final BaseKeyframeAnimation<?, Float> pointsAnimation;
    public final BaseKeyframeAnimation<?, PointF> positionAnimation;
    public final BaseKeyframeAnimation<?, Float> rotationAnimation;
    public final PolystarShape.Type type;
    public final Path path = new Path();
    public CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable;
        this.name = polystarShape.getName();
        this.type = polystarShape.getType();
        this.hidden = polystarShape.isHidden();
        this.pointsAnimation = polystarShape.getPoints().createAnimation();
        this.positionAnimation = polystarShape.getPosition().createAnimation();
        this.rotationAnimation = polystarShape.getRotation().createAnimation();
        this.outerRadiusAnimation = polystarShape.getOuterRadius().createAnimation();
        this.outerRoundednessAnimation = polystarShape.getOuterRoundedness().createAnimation();
        if (this.type == PolystarShape.Type.STAR) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(this.pointsAnimation);
        baseLayer.addAnimation(this.positionAnimation);
        baseLayer.addAnimation(this.rotationAnimation);
        baseLayer.addAnimation(this.outerRadiusAnimation);
        baseLayer.addAnimation(this.outerRoundednessAnimation);
        if (this.type == PolystarShape.Type.STAR) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        this.pointsAnimation.addUpdateListener(this);
        this.positionAnimation.addUpdateListener(this);
        this.rotationAnimation.addUpdateListener(this);
        this.outerRadiusAnimation.addUpdateListener(this);
        this.outerRoundednessAnimation.addUpdateListener(this);
        if (this.type == PolystarShape.Type.STAR) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    private void createPolygonPath() {
        double floatValue;
        double d;
        double d2;
        double d3;
        int i;
        int floor = (int) Math.floor(this.pointsAnimation.getValue().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        if (baseKeyframeAnimation == null) {
            floatValue = 0.0d;
        } else {
            floatValue = baseKeyframeAnimation.getValue().floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d4 = floor;
        float floatValue2 = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float floatValue3 = this.outerRadiusAnimation.getValue().floatValue();
        double d5 = floatValue3;
        float cos = (float) (Math.cos(radians) * d5);
        float sin = (float) (Math.sin(radians) * d5);
        this.path.moveTo(cos, sin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double ceil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < ceil) {
            float cos2 = (float) (Math.cos(d7) * d5);
            double d8 = ceil;
            float sin2 = (float) (d5 * Math.sin(d7));
            if (floatValue2 != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                d3 = d6;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f = floatValue3 * floatValue2 * 0.25f;
                this.path.cubicTo(cos - (cos3 * f), sin - (((float) Math.sin(atan2)) * f), cos2 + (((float) Math.cos(atan22)) * f), sin2 + (f * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d = d7;
                d2 = d5;
                d3 = d6;
                i = i2;
                this.path.lineTo(cos2, sin2);
            }
            d7 = d + d3;
            i2 = i + 1;
            sin = sin2;
            cos = cos2;
            ceil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF value = this.positionAnimation.getValue();
        this.path.offset(value.x, value.y);
        this.path.close();
    }

    private void createStarPath() {
        double floatValue;
        float f;
        float f2;
        double d;
        int i;
        double d2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        double d3;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float floatValue2 = this.pointsAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        if (baseKeyframeAnimation == null) {
            floatValue = 0.0d;
        } else {
            floatValue = baseKeyframeAnimation.getValue().floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d4 = floatValue2;
        float f17 = (float) (6.283185307179586d / d4);
        float f18 = f17 / 2.0f;
        float f19 = floatValue2 - ((int) floatValue2);
        int i2 = (f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f19) * f18;
        }
        float floatValue3 = this.outerRadiusAnimation.getValue().floatValue();
        float floatValue4 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.innerRoundednessAnimation;
        if (baseKeyframeAnimation2 != null) {
            f = baseKeyframeAnimation2.getValue().floatValue() / 100.0f;
        } else {
            f = 0.0f;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.outerRoundednessAnimation;
        if (baseKeyframeAnimation3 != null) {
            f2 = baseKeyframeAnimation3.getValue().floatValue() / 100.0f;
        } else {
            f2 = 0.0f;
        }
        if (i2 != 0) {
            f5 = ((floatValue3 - floatValue4) * f19) + floatValue4;
            i = i2;
            double d5 = f5;
            d = d4;
            f3 = (float) (d5 * Math.cos(radians));
            f4 = (float) (d5 * Math.sin(radians));
            this.path.moveTo(f3, f4);
            d2 = radians + ((f17 * f19) / 2.0f);
        } else {
            d = d4;
            i = i2;
            double d6 = floatValue3;
            float cos = (float) (Math.cos(radians) * d6);
            float sin = (float) (d6 * Math.sin(radians));
            this.path.moveTo(cos, sin);
            d2 = radians + f18;
            f3 = cos;
            f4 = sin;
            f5 = 0.0f;
        }
        double ceil = Math.ceil(d) * 2.0d;
        int i3 = 0;
        boolean z = false;
        while (true) {
            double d7 = i3;
            if (d7 < ceil) {
                if (z) {
                    f6 = floatValue3;
                } else {
                    f6 = floatValue4;
                }
                int i4 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
                if (i4 != 0 && d7 == ceil - 2.0d) {
                    f7 = f17;
                    f8 = (f17 * f19) / 2.0f;
                } else {
                    f7 = f17;
                    f8 = f18;
                }
                if (i4 != 0 && d7 == ceil - 1.0d) {
                    f9 = f18;
                    d3 = d7;
                    f10 = f5;
                } else {
                    f9 = f18;
                    d3 = d7;
                    f10 = f6;
                }
                double d8 = f10;
                double d9 = ceil;
                float cos2 = (float) (d8 * Math.cos(d2));
                float sin2 = (float) (d8 * Math.sin(d2));
                if (f == 0.0f && f2 == 0.0f) {
                    this.path.lineTo(cos2, sin2);
                    f11 = f;
                    f12 = f5;
                } else {
                    f11 = f;
                    f12 = f5;
                    double atan2 = (float) (Math.atan2(f4, f3) - 1.5707963267948966d);
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    if (z) {
                        f13 = f11;
                    } else {
                        f13 = f2;
                    }
                    if (z) {
                        f14 = f2;
                    } else {
                        f14 = f11;
                    }
                    if (z) {
                        f15 = floatValue4;
                    } else {
                        f15 = floatValue3;
                    }
                    if (z) {
                        f16 = floatValue3;
                    } else {
                        f16 = floatValue4;
                    }
                    float f20 = f15 * f13 * 0.47829f;
                    float f21 = cos3 * f20;
                    float f22 = f20 * sin3;
                    float f23 = f16 * f14 * 0.47829f;
                    float f24 = cos4 * f23;
                    float f25 = f23 * sin4;
                    if (i != 0) {
                        if (i3 == 0) {
                            f21 *= f19;
                            f22 *= f19;
                        } else if (d3 == d9 - 1.0d) {
                            f24 *= f19;
                            f25 *= f19;
                        }
                    }
                    this.path.cubicTo(f3 - f21, f4 - f22, cos2 + f24, sin2 + f25, cos2, sin2);
                }
                d2 += f8;
                z = !z;
                i3++;
                f3 = cos2;
                f4 = sin2;
                f = f11;
                f5 = f12;
                f18 = f9;
                f17 = f7;
                ceil = d9;
            } else {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.innerRadiusAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.innerRoundednessAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        int i = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (i != 1) {
            if (i == 2) {
                createPolygonPath();
            }
        } else {
            createStarPath();
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.addTrimPath(trimPathContent);
                    trimPathContent.addListener(this);
                }
            }
        }
    }
}
