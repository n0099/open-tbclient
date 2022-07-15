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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class ChangeTransform extends Transition {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Property<PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY;
    public static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    public static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    public static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
    public static final String PROPNAME_PARENT = "android:changeTransform:parent";
    public static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    public static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    public static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION;
    public static final Property<PathAnimatorMatrix, PointF> TRANSLATIONS_PROPERTY;
    public static final String[] sTransitionProperties;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mReparent;
    public Matrix mTempMatrix;
    public boolean mUseOverlay;

    /* loaded from: classes.dex */
    public static class GhostListener extends TransitionListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public GhostView mGhostView;
        public View mView;

        public GhostListener(View view2, GhostView ghostView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, ghostView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mView = view2;
            this.mGhostView = ghostView;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, transition) == null) {
                transition.removeListener(this);
                GhostViewUtils.removeGhost(this.mView);
                this.mView.setTag(R$id.transition_transform, null);
                this.mView.setTag(R$id.parent_matrix, null);
            }
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition) == null) {
                this.mGhostView.setVisibility(4);
            }
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, transition) == null) {
                this.mGhostView.setVisibility(0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PathAnimatorMatrix {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Matrix mMatrix;
        public float mTranslationX;
        public float mTranslationY;
        public final float[] mValues;
        public final View mView;

        public PathAnimatorMatrix(View view2, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMatrix = new Matrix();
            this.mView = view2;
            float[] fArr2 = (float[]) fArr.clone();
            this.mValues = fArr2;
            this.mTranslationX = fArr2[2];
            this.mTranslationY = fArr2[5];
            setAnimationMatrix();
        }

        private void setAnimationMatrix() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                float[] fArr = this.mValues;
                fArr[2] = this.mTranslationX;
                fArr[5] = this.mTranslationY;
                this.mMatrix.setValues(fArr);
                ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
            }
        }

        public Matrix getMatrix() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mMatrix : (Matrix) invokeV.objValue;
        }

        public void setTranslation(PointF pointF) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pointF) == null) {
                this.mTranslationX = pointF.x;
                this.mTranslationY = pointF.y;
                setAnimationMatrix();
            }
        }

        public void setValues(float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fArr) == null) {
                System.arraycopy(fArr, 0, this.mValues, 0, fArr.length);
                setAnimationMatrix();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Transforms {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final float mRotationX;
        public final float mRotationY;
        public final float mRotationZ;
        public final float mScaleX;
        public final float mScaleY;
        public final float mTranslationX;
        public final float mTranslationY;
        public final float mTranslationZ;

        public Transforms(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof Transforms) {
                    Transforms transforms = (Transforms) obj;
                    return transforms.mTranslationX == this.mTranslationX && transforms.mTranslationY == this.mTranslationY && transforms.mTranslationZ == this.mTranslationZ && transforms.mScaleX == this.mScaleX && transforms.mScaleY == this.mScaleY && transforms.mRotationX == this.mRotationX && transforms.mRotationY == this.mRotationY && transforms.mRotationZ == this.mRotationZ;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                float f = this.mTranslationX;
                int floatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
                float f2 = this.mTranslationY;
                int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
                float f3 = this.mTranslationZ;
                int floatToIntBits3 = (floatToIntBits2 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
                float f4 = this.mScaleX;
                int floatToIntBits4 = (floatToIntBits3 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
                float f5 = this.mScaleY;
                int floatToIntBits5 = (floatToIntBits4 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
                float f6 = this.mRotationX;
                int floatToIntBits6 = (floatToIntBits5 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
                float f7 = this.mRotationY;
                int floatToIntBits7 = (floatToIntBits6 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
                float f8 = this.mRotationZ;
                return floatToIntBits7 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0);
            }
            return invokeV.intValue;
        }

        public void restore(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                ChangeTransform.setTransforms(view2, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-866674465, "Landroidx/transition/ChangeTransform;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-866674465, "Landroidx/transition/ChangeTransform;");
                return;
            }
        }
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};
        NON_TRANSLATIONS_PROPERTY = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations") { // from class: androidx.transition.ChangeTransform.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pathAnimatorMatrix)) == null) {
                    return null;
                }
                return (float[]) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pathAnimatorMatrix, fArr) == null) {
                    pathAnimatorMatrix.setValues(fArr);
                }
            }
        };
        TRANSLATIONS_PROPERTY = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations") { // from class: androidx.transition.ChangeTransform.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, pathAnimatorMatrix)) == null) {
                    return null;
                }
                return (PointF) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pathAnimatorMatrix, pointF) == null) {
                    pathAnimatorMatrix.setTranslation(pointF);
                }
            }
        };
        SUPPORTS_VIEW_REMOVAL_SUPPRESSION = Build.VERSION.SDK_INT >= 21;
    }

    public ChangeTransform() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
    }

    private void captureValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, transitionValues) == null) {
            View view2 = transitionValues.f1747view;
            if (view2.getVisibility() == 8) {
                return;
            }
            transitionValues.values.put(PROPNAME_PARENT, view2.getParent());
            transitionValues.values.put(PROPNAME_TRANSFORMS, new Transforms(view2));
            Matrix matrix = view2.getMatrix();
            transitionValues.values.put(PROPNAME_MATRIX, (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
            if (this.mReparent) {
                Matrix matrix2 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                ViewUtils.transformMatrixToGlobal(viewGroup, matrix2);
                matrix2.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
                transitionValues.values.put(PROPNAME_PARENT_MATRIX, matrix2);
                transitionValues.values.put(PROPNAME_INTERMEDIATE_MATRIX, view2.getTag(R$id.transition_transform));
                transitionValues.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, view2.getTag(R$id.parent_matrix));
            }
        }
    }

    private void createGhostView(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, viewGroup, transitionValues, transitionValues2) == null) {
            View view2 = transitionValues2.f1747view;
            Matrix matrix = new Matrix((Matrix) transitionValues2.values.get(PROPNAME_PARENT_MATRIX));
            ViewUtils.transformMatrixToLocal(viewGroup, matrix);
            GhostView addGhost = GhostViewUtils.addGhost(view2, viewGroup, matrix);
            if (addGhost == null) {
                return;
            }
            addGhost.reserveEndViewTransition((ViewGroup) transitionValues.values.get(PROPNAME_PARENT), transitionValues.f1747view);
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
                View view3 = transitionValues.f1747view;
                if (view3 != transitionValues2.f1747view) {
                    ViewUtils.setTransitionAlpha(view3, 0.0f);
                }
                ViewUtils.setTransitionAlpha(view2, 1.0f);
            }
        }
    }

    private ObjectAnimator createTransformAnimator(TransitionValues transitionValues, TransitionValues transitionValues2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, this, transitionValues, transitionValues2, z)) == null) {
            Matrix matrix = (Matrix) transitionValues.values.get(PROPNAME_MATRIX);
            Matrix matrix2 = (Matrix) transitionValues2.values.get(PROPNAME_MATRIX);
            if (matrix == null) {
                matrix = MatrixUtils.IDENTITY_MATRIX;
            }
            if (matrix2 == null) {
                matrix2 = MatrixUtils.IDENTITY_MATRIX;
            }
            Matrix matrix3 = matrix2;
            if (matrix.equals(matrix3)) {
                return null;
            }
            Transforms transforms = (Transforms) transitionValues2.values.get(PROPNAME_TRANSFORMS);
            View view2 = transitionValues2.f1747view;
            setIdentityTransforms(view2);
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            float[] fArr2 = new float[9];
            matrix3.getValues(fArr2);
            PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view2, fArr);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new FloatArrayEvaluator(new float[9]), fArr, fArr2), PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, getPathMotion().getPath(fArr[2], fArr[5], fArr2[2], fArr2[5])));
            AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(this, z, matrix3, view2, transforms, pathAnimatorMatrix) { // from class: androidx.transition.ChangeTransform.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public boolean mIsCanceled;
                public Matrix mTempMatrix;
                public final /* synthetic */ ChangeTransform this$0;
                public final /* synthetic */ Matrix val$finalEndMatrix;
                public final /* synthetic */ boolean val$handleParentChange;
                public final /* synthetic */ PathAnimatorMatrix val$pathAnimatorMatrix;
                public final /* synthetic */ Transforms val$transforms;
                public final /* synthetic */ View val$view;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), matrix3, view2, transforms, pathAnimatorMatrix};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handleParentChange = z;
                    this.val$finalEndMatrix = matrix3;
                    this.val$view = view2;
                    this.val$transforms = transforms;
                    this.val$pathAnimatorMatrix = pathAnimatorMatrix;
                    this.mTempMatrix = new Matrix();
                }

                private void setCurrentMatrix(Matrix matrix4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65537, this, matrix4) == null) {
                        this.mTempMatrix.set(matrix4);
                        this.val$view.setTag(R$id.transition_transform, this.mTempMatrix);
                        this.val$transforms.restore(this.val$view);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.mIsCanceled = true;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        if (!this.mIsCanceled) {
                            if (this.val$handleParentChange && this.this$0.mUseOverlay) {
                                setCurrentMatrix(this.val$finalEndMatrix);
                            } else {
                                this.val$view.setTag(R$id.transition_transform, null);
                                this.val$view.setTag(R$id.parent_matrix, null);
                            }
                        }
                        ViewUtils.setAnimationMatrix(this.val$view, null);
                        this.val$transforms.restore(this.val$view);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
                public void onAnimationPause(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                        setCurrentMatrix(this.val$pathAnimatorMatrix.getMatrix());
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
                public void onAnimationResume(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                        ChangeTransform.setIdentityTransforms(this.val$view);
                    }
                }
            };
            ofPropertyValuesHolder.addListener(animatorListenerAdapter);
            AnimatorUtils.addPauseListener(ofPropertyValuesHolder, animatorListenerAdapter);
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeLLZ.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
        if (r6 == r5.f1747view) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r5 == r6) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0023, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean parentsMatch(ViewGroup viewGroup, ViewGroup viewGroup2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65542, this, viewGroup, viewGroup2)) != null) {
            return invokeLL.booleanValue;
        }
        boolean z = true;
        if (isValidTarget(viewGroup) && isValidTarget(viewGroup2)) {
            TransitionValues matchedTransitionValues = getMatchedTransitionValues(viewGroup, true);
            if (matchedTransitionValues == null) {
                return false;
            }
        }
    }

    public static void setIdentityTransforms(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, view2) == null) {
            setTransforms(view2, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void setMatricesForParent(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, transitionValues, transitionValues2) == null) {
            Matrix matrix = (Matrix) transitionValues2.values.get(PROPNAME_PARENT_MATRIX);
            transitionValues2.f1747view.setTag(R$id.parent_matrix, matrix);
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
    }

    public static void setTransforms(View view2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8)}) == null) {
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

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, transitionValues) == null) {
            captureValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transitionValues) == null) {
            captureValues(transitionValues);
            if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
                return;
            }
            ((ViewGroup) transitionValues.f1747view.getParent()).startViewTransition(transitionValues.f1747view);
        }
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, transitionValues, transitionValues2)) == null) {
            if (transitionValues == null || transitionValues2 == null || !transitionValues.values.containsKey(PROPNAME_PARENT) || !transitionValues2.values.containsKey(PROPNAME_PARENT)) {
                return null;
            }
            ViewGroup viewGroup2 = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
            boolean z = this.mReparent && !parentsMatch(viewGroup2, (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT));
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
                viewGroup2.endViewTransition(transitionValues.f1747view);
            }
            return createTransformAnimator;
        }
        return (Animator) invokeLLL.objValue;
    }

    public boolean getReparent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mReparent : invokeV.booleanValue;
    }

    public boolean getReparentWithOverlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mUseOverlay : invokeV.booleanValue;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? sTransitionProperties : (String[]) invokeV.objValue;
    }

    public void setReparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mReparent = z;
        }
    }

    public void setReparentWithOverlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mUseOverlay = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mUseOverlay = true;
        this.mReparent = true;
        this.mTempMatrix = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_TRANSFORM);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.mUseOverlay = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.mReparent = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }
}
