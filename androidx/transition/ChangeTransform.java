package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class ChangeTransform extends Transition {
    public static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    public static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    public static final String PROPNAME_PARENT = "android:changeTransform:parent";
    public static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION;
    public boolean mReparent;
    public Matrix mTempMatrix;
    public boolean mUseOverlay;
    public static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
    public static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    public static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    public static final String[] sTransitionProperties = {PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};
    public static final Property<PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations") { // from class: androidx.transition.ChangeTransform.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            pathAnimatorMatrix.setValues(fArr);
        }
    };
    public static final Property<PathAnimatorMatrix, PointF> TRANSLATIONS_PROPERTY = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations") { // from class: androidx.transition.ChangeTransform.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
            pathAnimatorMatrix.setTranslation(pointF);
        }
    };

    /* loaded from: classes.dex */
    public static class GhostListener extends TransitionListenerAdapter {
        public GhostView mGhostView;
        public View mView;

        public GhostListener(View view2, GhostView ghostView) {
            this.mView = view2;
            this.mGhostView = ghostView;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            transition.removeListener(this);
            GhostViewUtils.removeGhost(this.mView);
            this.mView.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0926ec, null);
            this.mView.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091a72, null);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            this.mGhostView.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            this.mGhostView.setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    public static class PathAnimatorMatrix {
        public final Matrix mMatrix = new Matrix();
        public float mTranslationX;
        public float mTranslationY;
        public final float[] mValues;
        public final View mView;

        public PathAnimatorMatrix(View view2, float[] fArr) {
            this.mView = view2;
            float[] fArr2 = (float[]) fArr.clone();
            this.mValues = fArr2;
            this.mTranslationX = fArr2[2];
            this.mTranslationY = fArr2[5];
            setAnimationMatrix();
        }

        private void setAnimationMatrix() {
            float[] fArr = this.mValues;
            fArr[2] = this.mTranslationX;
            fArr[5] = this.mTranslationY;
            this.mMatrix.setValues(fArr);
            ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
        }

        public Matrix getMatrix() {
            return this.mMatrix;
        }

        public void setTranslation(PointF pointF) {
            this.mTranslationX = pointF.x;
            this.mTranslationY = pointF.y;
            setAnimationMatrix();
        }

        public void setValues(float[] fArr) {
            System.arraycopy(fArr, 0, this.mValues, 0, fArr.length);
            setAnimationMatrix();
        }
    }

    /* loaded from: classes.dex */
    public static class Transforms {
        public final float mRotationX;
        public final float mRotationY;
        public final float mRotationZ;
        public final float mScaleX;
        public final float mScaleY;
        public final float mTranslationX;
        public final float mTranslationY;
        public final float mTranslationZ;

        public Transforms(View view2) {
            this.mTranslationX = view2.getTranslationX();
            this.mTranslationY = view2.getTranslationY();
            this.mTranslationZ = ViewCompat.getTranslationZ(view2);
            this.mScaleX = view2.getScaleX();
            this.mScaleY = view2.getScaleY();
            this.mRotationX = view2.getRotationX();
            this.mRotationY = view2.getRotationY();
            this.mRotationZ = view2.getRotation();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Transforms)) {
                return false;
            }
            Transforms transforms = (Transforms) obj;
            if (transforms.mTranslationX != this.mTranslationX || transforms.mTranslationY != this.mTranslationY || transforms.mTranslationZ != this.mTranslationZ || transforms.mScaleX != this.mScaleX || transforms.mScaleY != this.mScaleY || transforms.mRotationX != this.mRotationX || transforms.mRotationY != this.mRotationY || transforms.mRotationZ != this.mRotationZ) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            float f = this.mTranslationX;
            int i8 = 0;
            if (f != 0.0f) {
                i = Float.floatToIntBits(f);
            } else {
                i = 0;
            }
            int i9 = i * 31;
            float f2 = this.mTranslationY;
            if (f2 != 0.0f) {
                i2 = Float.floatToIntBits(f2);
            } else {
                i2 = 0;
            }
            int i10 = (i9 + i2) * 31;
            float f3 = this.mTranslationZ;
            if (f3 != 0.0f) {
                i3 = Float.floatToIntBits(f3);
            } else {
                i3 = 0;
            }
            int i11 = (i10 + i3) * 31;
            float f4 = this.mScaleX;
            if (f4 != 0.0f) {
                i4 = Float.floatToIntBits(f4);
            } else {
                i4 = 0;
            }
            int i12 = (i11 + i4) * 31;
            float f5 = this.mScaleY;
            if (f5 != 0.0f) {
                i5 = Float.floatToIntBits(f5);
            } else {
                i5 = 0;
            }
            int i13 = (i12 + i5) * 31;
            float f6 = this.mRotationX;
            if (f6 != 0.0f) {
                i6 = Float.floatToIntBits(f6);
            } else {
                i6 = 0;
            }
            int i14 = (i13 + i6) * 31;
            float f7 = this.mRotationY;
            if (f7 != 0.0f) {
                i7 = Float.floatToIntBits(f7);
            } else {
                i7 = 0;
            }
            int i15 = (i14 + i7) * 31;
            float f8 = this.mRotationZ;
            if (f8 != 0.0f) {
                i8 = Float.floatToIntBits(f8);
            }
            return i15 + i8;
        }

        public void restore(View view2) {
            ChangeTransform.setTransforms(view2, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
        }
    }

    static {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21) {
            z = true;
        } else {
            z = false;
        }
        SUPPORTS_VIEW_REMOVAL_SUPPRESSION = z;
    }

    public ChangeTransform() {
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
    }

    public boolean getReparent() {
        return this.mReparent;
    }

    public boolean getReparentWithOverlay() {
        return this.mUseOverlay;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_TRANSFORM);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.mUseOverlay = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.mReparent = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r5 == r4.f1028view) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r4 == r5) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean parentsMatch(ViewGroup viewGroup, ViewGroup viewGroup2) {
        boolean z = true;
        if (isValidTarget(viewGroup) && isValidTarget(viewGroup2)) {
            TransitionValues matchedTransitionValues = getMatchedTransitionValues(viewGroup, true);
            if (matchedTransitionValues == null) {
                return false;
            }
        }
    }

    private void captureValues(TransitionValues transitionValues) {
        Matrix matrix;
        View view2 = transitionValues.f1028view;
        if (view2.getVisibility() == 8) {
            return;
        }
        transitionValues.values.put(PROPNAME_PARENT, view2.getParent());
        transitionValues.values.put(PROPNAME_TRANSFORMS, new Transforms(view2));
        Matrix matrix2 = view2.getMatrix();
        if (matrix2 != null && !matrix2.isIdentity()) {
            matrix = new Matrix(matrix2);
        } else {
            matrix = null;
        }
        transitionValues.values.put(PROPNAME_MATRIX, matrix);
        if (this.mReparent) {
            Matrix matrix3 = new Matrix();
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            ViewUtils.transformMatrixToGlobal(viewGroup, matrix3);
            matrix3.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
            transitionValues.values.put(PROPNAME_PARENT_MATRIX, matrix3);
            transitionValues.values.put(PROPNAME_INTERMEDIATE_MATRIX, view2.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0926ec));
            transitionValues.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, view2.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091a72));
        }
    }

    private void createGhostView(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view2 = transitionValues2.f1028view;
        Matrix matrix = new Matrix((Matrix) transitionValues2.values.get(PROPNAME_PARENT_MATRIX));
        ViewUtils.transformMatrixToLocal(viewGroup, matrix);
        GhostView addGhost = GhostViewUtils.addGhost(view2, viewGroup, matrix);
        if (addGhost == null) {
            return;
        }
        addGhost.reserveEndViewTransition((ViewGroup) transitionValues.values.get(PROPNAME_PARENT), transitionValues.f1028view);
        Transition transition = this;
        while (true) {
            Transition transition2 = transition.mParent;
            if (transition2 == null) {
                break;
            }
            transition = transition2;
        }
        transition.addListener(new GhostListener(view2, addGhost));
        if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            View view3 = transitionValues.f1028view;
            if (view3 != transitionValues2.f1028view) {
                ViewUtils.setTransitionAlpha(view3, 0.0f);
            }
            ViewUtils.setTransitionAlpha(view2, 1.0f);
        }
    }

    private ObjectAnimator createTransformAnimator(TransitionValues transitionValues, TransitionValues transitionValues2, final boolean z) {
        Matrix matrix = (Matrix) transitionValues.values.get(PROPNAME_MATRIX);
        Matrix matrix2 = (Matrix) transitionValues2.values.get(PROPNAME_MATRIX);
        if (matrix == null) {
            matrix = MatrixUtils.IDENTITY_MATRIX;
        }
        if (matrix2 == null) {
            matrix2 = MatrixUtils.IDENTITY_MATRIX;
        }
        final Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        final Transforms transforms = (Transforms) transitionValues2.values.get(PROPNAME_TRANSFORMS);
        final View view2 = transitionValues2.f1028view;
        setIdentityTransforms(view2);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        final PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view2, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new FloatArrayEvaluator(new float[9]), fArr, fArr2), PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, getPathMotion().getPath(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeTransform.3
            public boolean mIsCanceled;
            public Matrix mTempMatrix = new Matrix();

            private void setCurrentMatrix(Matrix matrix4) {
                this.mTempMatrix.set(matrix4);
                view2.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0926ec, this.mTempMatrix);
                transforms.restore(view2);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.mIsCanceled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.mIsCanceled) {
                    if (z && ChangeTransform.this.mUseOverlay) {
                        setCurrentMatrix(matrix3);
                    } else {
                        view2.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0926ec, null);
                        view2.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091a72, null);
                    }
                }
                ViewUtils.setAnimationMatrix(view2, null);
                transforms.restore(view2);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator) {
                setCurrentMatrix(pathAnimatorMatrix.getMatrix());
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator) {
                ChangeTransform.setIdentityTransforms(view2);
            }
        };
        ofPropertyValuesHolder.addListener(animatorListenerAdapter);
        AnimatorUtils.addPauseListener(ofPropertyValuesHolder, animatorListenerAdapter);
        return ofPropertyValuesHolder;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        boolean z;
        if (transitionValues != null && transitionValues2 != null && transitionValues.values.containsKey(PROPNAME_PARENT) && transitionValues2.values.containsKey(PROPNAME_PARENT)) {
            ViewGroup viewGroup2 = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
            ViewGroup viewGroup3 = (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
            if (this.mReparent && !parentsMatch(viewGroup2, viewGroup3)) {
                z = true;
            } else {
                z = false;
            }
            Matrix matrix = (Matrix) transitionValues.values.get(PROPNAME_INTERMEDIATE_MATRIX);
            if (matrix != null) {
                transitionValues.values.put(PROPNAME_MATRIX, matrix);
            }
            Matrix matrix2 = (Matrix) transitionValues.values.get(PROPNAME_INTERMEDIATE_PARENT_MATRIX);
            if (matrix2 != null) {
                transitionValues.values.put(PROPNAME_PARENT_MATRIX, matrix2);
            }
            if (z) {
                setMatricesForParent(transitionValues, transitionValues2);
            }
            ObjectAnimator createTransformAnimator = createTransformAnimator(transitionValues, transitionValues2, z);
            if (z && createTransformAnimator != null && this.mUseOverlay) {
                createGhostView(viewGroup, transitionValues, transitionValues2);
            } else if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
                viewGroup2.endViewTransition(transitionValues.f1028view);
            }
            return createTransformAnimator;
        }
        return null;
    }

    public static void setIdentityTransforms(View view2) {
        setTransforms(view2, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
        if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            ((ViewGroup) transitionValues.f1028view.getParent()).startViewTransition(transitionValues.f1028view);
        }
    }

    public void setReparent(boolean z) {
        this.mReparent = z;
    }

    public void setReparentWithOverlay(boolean z) {
        this.mUseOverlay = z;
    }

    private void setMatricesForParent(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = (Matrix) transitionValues2.values.get(PROPNAME_PARENT_MATRIX);
        transitionValues2.f1028view.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091a72, matrix);
        Matrix matrix2 = this.mTempMatrix;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) transitionValues.values.get(PROPNAME_MATRIX);
        if (matrix3 == null) {
            matrix3 = new Matrix();
            transitionValues.values.put(PROPNAME_MATRIX, matrix3);
        }
        matrix3.postConcat((Matrix) transitionValues.values.get(PROPNAME_PARENT_MATRIX));
        matrix3.postConcat(matrix2);
    }

    public static void setTransforms(View view2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view2.setTranslationX(f);
        view2.setTranslationY(f2);
        ViewCompat.setTranslationZ(view2, f3);
        view2.setScaleX(f4);
        view2.setScaleY(f5);
        view2.setRotationX(f6);
        view2.setRotationY(f7);
        view2.setRotation(f8);
    }
}
