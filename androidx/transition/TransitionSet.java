package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TransitionSet extends Transition {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLAG_CHANGE_EPICENTER = 8;
    public static final int FLAG_CHANGE_INTERPOLATOR = 1;
    public static final int FLAG_CHANGE_PATH_MOTION = 4;
    public static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int mChangeFlags;
    public int mCurrentListeners;
    public boolean mPlayTogether;
    public boolean mStarted;
    public ArrayList<Transition> mTransitions;

    /* loaded from: classes.dex */
    public static class TransitionSetListener extends TransitionListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TransitionSet mTransitionSet;

        public TransitionSetListener(TransitionSet transitionSet) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transitionSet};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTransitionSet = transitionSet;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, transition) == null) {
                TransitionSet transitionSet = this.mTransitionSet;
                int i = transitionSet.mCurrentListeners - 1;
                transitionSet.mCurrentListeners = i;
                if (i == 0) {
                    transitionSet.mStarted = false;
                    transitionSet.end();
                }
                transition.removeListener(this);
            }
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition) == null) {
                TransitionSet transitionSet = this.mTransitionSet;
                if (!transitionSet.mStarted) {
                    transitionSet.start();
                    this.mTransitionSet.mStarted = true;
                }
            }
        }
    }

    public TransitionSet() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.cancel();
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).cancel();
            }
        }
    }

    public int getOrdering() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return !this.mPlayTogether ? 1 : 0;
        }
        return invokeV.intValue;
    }

    public int getTransitionCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mTransitions.size();
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    private void addTransitionInternal(@NonNull Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, transition) == null) {
            this.mTransitions.add(transition);
            transition.mParent = this;
        }
    }

    @Override // androidx.transition.Transition
    public void capturePropagationValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, transitionValues) == null) {
            super.capturePropagationValues(transitionValues);
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).capturePropagationValues(transitionValues);
            }
        }
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, viewGroup) == null) {
            super.forceToEnd(viewGroup);
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).forceToEnd(viewGroup);
            }
        }
    }

    @Nullable
    public Transition getTransitionAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            if (i >= 0 && i < this.mTransitions.size()) {
                return this.mTransitions.get(i);
            }
            return null;
        }
        return (Transition) invokeI.objValue;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            super.pause(view2);
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).pause(view2);
            }
        }
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition transition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, transition)) == null) {
            this.mTransitions.remove(transition);
            transition.mParent = null;
            return this;
        }
        return (TransitionSet) invokeL.objValue;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
            super.resume(view2);
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).resume(view2);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setCanRemoveViews(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            super.setCanRemoveViews(z);
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).setCanRemoveViews(z);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, epicenterCallback) == null) {
            super.setEpicenterCallback(epicenterCallback);
            this.mChangeFlags |= 8;
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).setEpicenterCallback(epicenterCallback);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation transitionPropagation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, transitionPropagation) == null) {
            super.setPropagation(transitionPropagation);
            this.mChangeFlags |= 2;
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).setPropagation(transitionPropagation);
            }
        }
    }

    private void setupStartEndListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            TransitionSetListener transitionSetListener = new TransitionSetListener(this);
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                it.next().addListener(transitionSetListener);
            }
            this.mCurrentListeners = this.mTransitions.size();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public Transition mo5clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            TransitionSet transitionSet = (TransitionSet) super.mo5clone();
            transitionSet.mTransitions = new ArrayList<>();
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                transitionSet.addTransitionInternal(this.mTransitions.get(i).mo5clone());
            }
            return transitionSet;
        }
        return (Transition) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addListener(@NonNull Transition.TransitionListener transitionListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transitionListener)) == null) {
            return (TransitionSet) super.addListener(transitionListener);
        }
        return (TransitionSet) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeListener(@NonNull Transition.TransitionListener transitionListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, transitionListener)) == null) {
            return (TransitionSet) super.removeListener(transitionListener);
        }
        return (TransitionSet) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    public TransitionSet setSceneRoot(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, viewGroup)) == null) {
            super.setSceneRoot(viewGroup);
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).setSceneRoot(viewGroup);
            }
            return this;
        }
        return (TransitionSet) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setStartDelay(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048628, this, j)) == null) {
            return (TransitionSet) super.setStartDelay(j);
        }
        return (TransitionSet) invokeJ.objValue;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@NonNull Class cls) {
        return addTarget((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@NonNull Class cls) {
        return removeTarget((Class<?>) cls);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@IdRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            for (int i2 = 0; i2 < this.mTransitions.size(); i2++) {
                this.mTransitions.get(i2).addTarget(i);
            }
            return (TransitionSet) super.addTarget(i);
        }
        return (TransitionSet) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@IdRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
            for (int i2 = 0; i2 < this.mTransitions.size(); i2++) {
                this.mTransitions.get(i2).removeTarget(i);
            }
            return (TransitionSet) super.removeTarget(i);
        }
        return (TransitionSet) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                this.mTransitions.get(i).addTarget(view2);
            }
            return (TransitionSet) super.addTarget(view2);
        }
        return (TransitionSet) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, view2)) == null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                this.mTransitions.get(i).removeTarget(view2);
            }
            return (TransitionSet) super.removeTarget(view2);
        }
        return (TransitionSet) invokeL.objValue;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                this.mTransitions.get(i).addTarget(cls);
            }
            return (TransitionSet) super.addTarget(cls);
        }
        return (TransitionSet) invokeL.objValue;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, cls)) == null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                this.mTransitions.get(i).removeTarget(cls);
            }
            return (TransitionSet) super.removeTarget(cls);
        }
        return (TransitionSet) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                this.mTransitions.get(i).addTarget(str);
            }
            return (TransitionSet) super.addTarget(str);
        }
        return (TransitionSet) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                this.mTransitions.get(i).removeTarget(str);
            }
            return (TransitionSet) super.removeTarget(str);
        }
        return (TransitionSet) invokeL.objValue;
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition transition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, transition)) == null) {
            addTransitionInternal(transition);
            long j = this.mDuration;
            if (j >= 0) {
                transition.setDuration(j);
            }
            if ((this.mChangeFlags & 1) != 0) {
                transition.setInterpolator(getInterpolator());
            }
            if ((this.mChangeFlags & 2) != 0) {
                transition.setPropagation(getPropagation());
            }
            if ((this.mChangeFlags & 4) != 0) {
                transition.setPathMotion(getPathMotion());
            }
            if ((this.mChangeFlags & 8) != 0) {
                transition.setEpicenterCallback(getEpicenterCallback());
            }
            return this;
        }
        return (TransitionSet) invokeL.objValue;
    }

    @Override // androidx.transition.Transition
    public String toString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            String transition = super.toString(str);
            for (int i = 0; i < this.mTransitions.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(transition);
                sb.append("\n");
                sb.append(this.mTransitions.get(i).toString(str + GlideException.IndentedAppendable.INDENT));
                transition = sb.toString();
            }
            return transition;
        }
        return (String) invokeL.objValue;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, transitionValues) == null) && isValidTarget(transitionValues.f1051view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.f1051view)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, transitionValues) == null) && isValidTarget(transitionValues.f1051view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.f1051view)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setDuration(long j) {
        InterceptResult invokeJ;
        ArrayList<Transition> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048618, this, j)) == null) {
            super.setDuration(j);
            if (this.mDuration >= 0 && (arrayList = this.mTransitions) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    this.mTransitions.get(i).setDuration(j);
                }
            }
            return this;
        }
        return (TransitionSet) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, timeInterpolator)) == null) {
            this.mChangeFlags |= 1;
            ArrayList<Transition> arrayList = this.mTransitions;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    this.mTransitions.get(i).setInterpolator(timeInterpolator);
                }
            }
            return (TransitionSet) super.setInterpolator(timeInterpolator);
        }
        return (TransitionSet) invokeL.objValue;
    }

    @NonNull
    public TransitionSet setOrdering(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i)) == null) {
            if (i != 0) {
                if (i == 1) {
                    this.mPlayTogether = false;
                } else {
                    throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
                }
            } else {
                this.mPlayTogether = true;
            }
            return this;
        }
        return (TransitionSet) invokeI.objValue;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, pathMotion) == null) {
            super.setPathMotion(pathMotion);
            this.mChangeFlags |= 4;
            if (this.mTransitions != null) {
                for (int i = 0; i < this.mTransitions.size(); i++) {
                    this.mTransitions.get(i).setPathMotion(pathMotion);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2) == null) {
            long startDelay = getStartDelay();
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                Transition transition = this.mTransitions.get(i);
                if (startDelay > 0 && (this.mPlayTogether || i == 0)) {
                    long startDelay2 = transition.getStartDelay();
                    if (startDelay2 > 0) {
                        transition.setStartDelay(startDelay2 + startDelay);
                    } else {
                        transition.setStartDelay(startDelay);
                    }
                }
                transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
            }
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            for (int i2 = 0; i2 < this.mTransitions.size(); i2++) {
                this.mTransitions.get(i2).excludeTarget(i, z);
            }
            return super.excludeTarget(i, z);
        }
        return (Transition) invokeCommon.objValue;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048595, this, view2, z)) == null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                this.mTransitions.get(i).excludeTarget(view2, z);
            }
            return super.excludeTarget(view2, z);
        }
        return (Transition) invokeLZ.objValue;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048596, this, cls, z)) == null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                this.mTransitions.get(i).excludeTarget(cls, z);
            }
            return super.excludeTarget(cls, z);
        }
        return (Transition) invokeLZ.objValue;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048597, this, str, z)) == null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                this.mTransitions.get(i).excludeTarget(str, z);
            }
            return super.excludeTarget(str, z);
        }
        return (Transition) invokeLZ.objValue;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.mTransitions.isEmpty()) {
                start();
                end();
                return;
            }
            setupStartEndListeners();
            if (!this.mPlayTogether) {
                for (int i = 1; i < this.mTransitions.size(); i++) {
                    this.mTransitions.get(i - 1).addListener(new TransitionListenerAdapter(this, this.mTransitions.get(i)) { // from class: androidx.transition.TransitionSet.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TransitionSet this$0;
                        public final /* synthetic */ Transition val$nextTransition;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$nextTransition = r7;
                        }

                        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                        public void onTransitionEnd(@NonNull Transition transition) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                                this.val$nextTransition.runAnimators();
                                transition.removeListener(this);
                            }
                        }
                    });
                }
                Transition transition = this.mTransitions.get(0);
                if (transition != null) {
                    transition.runAnimators();
                    return;
                }
                return;
            }
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                it.next().runAnimators();
            }
        }
    }
}
