package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.HashMap;
/* loaded from: classes.dex */
public class DesignTool implements ProxyInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "DesignTool";
    public static final HashMap<Pair<Integer, Integer>, String> allAttributes;
    public static final HashMap<String, String> allMargins;
    public transient /* synthetic */ FieldHolder $fh;
    public String mLastEndState;
    public int mLastEndStateId;
    public String mLastStartState;
    public int mLastStartStateId;
    public final MotionLayout mMotionLayout;
    public MotionScene mSceneCache;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-104952987, "Landroidx/constraintlayout/motion/widget/DesignTool;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-104952987, "Landroidx/constraintlayout/motion/widget/DesignTool;");
                return;
            }
        }
        allAttributes = new HashMap<>();
        allMargins = new HashMap<>();
        allAttributes.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        allAttributes.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        allAttributes.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        allAttributes.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        allAttributes.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        allAttributes.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        allAttributes.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        allAttributes.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        allAttributes.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        allAttributes.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        allAttributes.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        allAttributes.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        allAttributes.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        allMargins.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        allMargins.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        allMargins.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        allMargins.put("layout_constraintTop_toTopOf", "layout_marginTop");
        allMargins.put("layout_constraintStart_toStartOf", "layout_marginStart");
        allMargins.put("layout_constraintStart_toEndOf", "layout_marginStart");
        allMargins.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        allMargins.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        allMargins.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        allMargins.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        allMargins.put("layout_constraintRight_toRightOf", "layout_marginRight");
        allMargins.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout motionLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {motionLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLastStartState = null;
        this.mLastEndState = null;
        this.mLastStartStateId = -1;
        this.mLastEndStateId = -1;
        this.mMotionLayout = motionLayout;
    }

    public static void Connect(int i, ConstraintSet constraintSet, View view2, HashMap<String, String> hashMap, int i2, int i3) {
        String str;
        String str2;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), constraintSet, view2, hashMap, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && (str2 = hashMap.get((str = allAttributes.get(Pair.create(Integer.valueOf(i2), Integer.valueOf(i3)))))) != null) {
            String str3 = allMargins.get(str);
            if (str3 != null) {
                i4 = GetPxFromDp(i, hashMap.get(str3));
            } else {
                i4 = 0;
            }
            constraintSet.connect(view2.getId(), i2, Integer.parseInt(str2), i3, i4);
        }
    }

    public static int GetPxFromDp(int i, String str) {
        InterceptResult invokeIL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, str)) == null) {
            if (str == null || (indexOf = str.indexOf(100)) == -1) {
                return 0;
            }
            return (int) ((Integer.valueOf(str.substring(0, indexOf)).intValue() * i) / 160.0f);
        }
        return invokeIL.intValue;
    }

    public void setTransition(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null) {
                motionLayout.mScene = this.mSceneCache;
            }
            int lookUpConstraintId = this.mMotionLayout.lookUpConstraintId(str);
            int lookUpConstraintId2 = this.mMotionLayout.lookUpConstraintId(str2);
            this.mMotionLayout.setTransition(lookUpConstraintId, lookUpConstraintId2);
            this.mLastStartStateId = lookUpConstraintId;
            this.mLastEndStateId = lookUpConstraintId2;
            this.mLastStartState = str;
            this.mLastEndState = str2;
        }
    }

    public static void SetAbsolutePositions(int i, ConstraintSet constraintSet, View view2, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), constraintSet, view2, hashMap}) == null) {
            String str = hashMap.get("layout_editor_absoluteX");
            if (str != null) {
                constraintSet.setEditorAbsoluteX(view2.getId(), GetPxFromDp(i, str));
            }
            String str2 = hashMap.get("layout_editor_absoluteY");
            if (str2 != null) {
                constraintSet.setEditorAbsoluteY(view2.getId(), GetPxFromDp(i, str2));
            }
        }
    }

    public static void SetBias(ConstraintSet constraintSet, View view2, HashMap<String, String> hashMap, int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65541, null, constraintSet, view2, hashMap, i) == null) {
            if (i == 1) {
                str = "layout_constraintVertical_bias";
            } else {
                str = "layout_constraintHorizontal_bias";
            }
            String str2 = hashMap.get(str);
            if (str2 != null) {
                if (i == 0) {
                    constraintSet.setHorizontalBias(view2.getId(), Float.parseFloat(str2));
                } else if (i == 1) {
                    constraintSet.setVerticalBias(view2.getId(), Float.parseFloat(str2));
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(Object obj, int i, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{obj, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return this.mMotionLayout.mFrameArrayList.get((View) obj).getKeyFrameParameter(i, f, f2);
        }
        return invokeCommon.floatValue;
    }

    public static void SetDimensions(int i, ConstraintSet constraintSet, View view2, HashMap<String, String> hashMap, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), constraintSet, view2, hashMap, Integer.valueOf(i2)}) == null) {
            if (i2 == 1) {
                str = "layout_height";
            } else {
                str = "layout_width";
            }
            String str2 = hashMap.get(str);
            if (str2 != null) {
                int i3 = -2;
                if (!str2.equalsIgnoreCase("wrap_content")) {
                    i3 = GetPxFromDp(i, str2);
                }
                if (i2 == 0) {
                    constraintSet.constrainWidth(view2.getId(), i3);
                } else {
                    constraintSet.constrainHeight(view2.getId(), i3);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int i, String str, Object obj, float[] fArr, int i2, float[] fArr2, int i3) {
        InterceptResult invokeCommon;
        MotionController motionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, fArr, Integer.valueOf(i2), fArr2, Integer.valueOf(i3)})) == null) {
            View view2 = (View) obj;
            if (i != 0) {
                MotionLayout motionLayout = this.mMotionLayout;
                if (motionLayout.mScene == null || view2 == null || (motionController = motionLayout.mFrameArrayList.get(view2)) == null) {
                    return -1;
                }
            } else {
                motionController = null;
            }
            if (i == 0) {
                return 1;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return -1;
                    }
                    int duration = this.mMotionLayout.mScene.getDuration() / 16;
                    return motionController.getAttributeValues(str, fArr2, i3);
                }
                int duration2 = this.mMotionLayout.mScene.getDuration() / 16;
                motionController.buildKeyFrames(fArr2, null);
                return duration2;
            }
            int duration3 = this.mMotionLayout.mScene.getDuration() / 16;
            motionController.buildPath(fArr2, duration3);
            return duration3;
        }
        return invokeCommon.intValue;
    }

    public void disableAutoTransition(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.mMotionLayout.disableAutoTransition(z);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f) == null) {
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null) {
                motionLayout.mScene = this.mSceneCache;
            }
            this.mMotionLayout.setProgress(f);
            this.mMotionLayout.evaluate(true);
            this.mMotionLayout.requestLayout();
            this.mMotionLayout.invalidate();
        }
    }

    public void dumpConstraintSet(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null) {
                motionLayout.mScene = this.mSceneCache;
            }
            int lookUpConstraintId = this.mMotionLayout.lookUpConstraintId(str);
            PrintStream printStream = System.out;
            printStream.println(" dumping  " + str + " (" + lookUpConstraintId + SmallTailInfo.EMOTION_SUFFIX);
            try {
                this.mMotionLayout.mScene.getConstraintSet(lookUpConstraintId).dump(this.mMotionLayout.mScene, new int[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getAnimationKeyFrames(Object obj, float[] fArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, obj, fArr)) == null) {
            MotionScene motionScene = this.mMotionLayout.mScene;
            if (motionScene == null) {
                return -1;
            }
            int duration = motionScene.getDuration() / 16;
            MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
            if (motionController == null) {
                return 0;
            }
            motionController.buildKeyFrames(fArr, null);
            return duration;
        }
        return invokeLL.intValue;
    }

    public void getAnimationRectangles(Object obj, float[] fArr) {
        MotionScene motionScene;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, obj, fArr) != null) || (motionScene = this.mMotionLayout.mScene) == null) {
            return;
        }
        int duration = motionScene.getDuration() / 16;
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return;
        }
        motionController.buildRectangles(fArr, duration);
    }

    public void setViewDebug(Object obj, int i) {
        MotionController motionController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048602, this, obj, i) == null) && (motionController = this.mMotionLayout.mFrameArrayList.get(obj)) != null) {
            motionController.setDrawPath(i);
            this.mMotionLayout.invalidate();
        }
    }

    public int getAnimationPath(Object obj, float[] fArr, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, obj, fArr, i)) == null) {
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null) {
                return -1;
            }
            MotionController motionController = motionLayout.mFrameArrayList.get(obj);
            if (motionController == null) {
                return 0;
            }
            motionController.buildPath(fArr, i);
            return i;
        }
        return invokeLLI.intValue;
    }

    public int getKeyFrameInfo(Object obj, int i, int[] iArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, obj, i, iArr)) == null) {
            MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) obj);
            if (motionController == null) {
                return 0;
            }
            return motionController.getKeyFrameInfo(i, iArr);
        }
        return invokeLIL.intValue;
    }

    public int getKeyFramePositions(Object obj, int[] iArr, float[] fArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, obj, iArr, fArr)) == null) {
            MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) obj);
            if (motionController == null) {
                return 0;
            }
            return motionController.getkeyFramePositions(iArr, fArr);
        }
        return invokeLLL.intValue;
    }

    public Object getKeyframe(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048586, this, i, i2, i3)) == null) {
            MotionLayout motionLayout = this.mMotionLayout;
            MotionScene motionScene = motionLayout.mScene;
            if (motionScene == null) {
                return null;
            }
            return motionScene.getKeyFrame(motionLayout.getContext(), i, i2, i3);
        }
        return invokeIII.objValue;
    }

    public void setKeyframe(Object obj, String str, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048598, this, obj, str, obj2) == null) && (obj instanceof Key)) {
            ((Key) obj).setValue(str, obj2);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
        }
    }

    public String getEndState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int endState = this.mMotionLayout.getEndState();
            if (this.mLastEndStateId == endState) {
                return this.mLastEndState;
            }
            String constraintSetNames = this.mMotionLayout.getConstraintSetNames(endState);
            if (constraintSetNames != null) {
                this.mLastEndState = constraintSetNames;
                this.mLastEndStateId = endState;
            }
            return constraintSetNames;
        }
        return (String) invokeV.objValue;
    }

    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mMotionLayout.getProgress();
        }
        return invokeV.floatValue;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public long getTransitionTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mMotionLayout.getTransitionTimeMs();
        }
        return invokeV.longValue;
    }

    public boolean isInTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.mLastStartState != null && this.mLastEndState != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Object getKeyframe(Object obj, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, obj, i, i2)) == null) {
            if (this.mMotionLayout.mScene == null) {
                return null;
            }
            int id = ((View) obj).getId();
            MotionLayout motionLayout = this.mMotionLayout;
            return motionLayout.mScene.getKeyFrame(motionLayout.getContext(), i, id, i2);
        }
        return invokeLII.objValue;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Object getKeyframeAtLocation(Object obj, float f, float f2) {
        InterceptResult invokeCommon;
        MotionController motionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{obj, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            View view2 = (View) obj;
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null) {
                return -1;
            }
            if (view2 == null || (motionController = motionLayout.mFrameArrayList.get(view2)) == null) {
                return null;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            return motionController.getPositionKeyframe(viewGroup.getWidth(), viewGroup.getHeight(), f, f2);
        }
        return invokeCommon.objValue;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Boolean getPositionKeyframe(Object obj, Object obj2, float f, float f2, String[] strArr, float[] fArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{obj, obj2, Float.valueOf(f), Float.valueOf(f2), strArr, fArr})) == null) {
            if (obj instanceof KeyPositionBase) {
                View view2 = (View) obj2;
                this.mMotionLayout.mFrameArrayList.get(view2).positionKeyframe(view2, (KeyPositionBase) obj, f, f2, strArr, fArr);
                this.mMotionLayout.rebuildScene();
                this.mMotionLayout.mInTransition = true;
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeCommon.objValue;
    }

    public String getStartState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int startState = this.mMotionLayout.getStartState();
            if (this.mLastStartStateId == startState) {
                return this.mLastStartState;
            }
            String constraintSetNames = this.mMotionLayout.getConstraintSetNames(startState);
            if (constraintSetNames != null) {
                this.mLastStartState = constraintSetNames;
                this.mLastStartStateId = startState;
            }
            return this.mMotionLayout.getConstraintSetNames(startState);
        }
        return (String) invokeV.objValue;
    }

    public String getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.mLastStartState != null && this.mLastEndState != null) {
                float progress = getProgress();
                if (progress <= 0.01f) {
                    return this.mLastStartState;
                }
                if (progress >= 0.99f) {
                    return this.mLastEndState;
                }
            }
            return this.mLastStartState;
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setAttributes(int i, String str, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), str, obj, obj2}) == null) {
            View view2 = (View) obj;
            HashMap hashMap = (HashMap) obj2;
            int lookUpConstraintId = this.mMotionLayout.lookUpConstraintId(str);
            ConstraintSet constraintSet = this.mMotionLayout.mScene.getConstraintSet(lookUpConstraintId);
            if (constraintSet == null) {
                return;
            }
            constraintSet.clear(view2.getId());
            SetDimensions(i, constraintSet, view2, hashMap, 0);
            SetDimensions(i, constraintSet, view2, hashMap, 1);
            Connect(i, constraintSet, view2, hashMap, 6, 6);
            Connect(i, constraintSet, view2, hashMap, 6, 7);
            Connect(i, constraintSet, view2, hashMap, 7, 7);
            Connect(i, constraintSet, view2, hashMap, 7, 6);
            Connect(i, constraintSet, view2, hashMap, 1, 1);
            Connect(i, constraintSet, view2, hashMap, 1, 2);
            Connect(i, constraintSet, view2, hashMap, 2, 2);
            Connect(i, constraintSet, view2, hashMap, 2, 1);
            Connect(i, constraintSet, view2, hashMap, 3, 3);
            Connect(i, constraintSet, view2, hashMap, 3, 4);
            Connect(i, constraintSet, view2, hashMap, 4, 3);
            Connect(i, constraintSet, view2, hashMap, 4, 4);
            Connect(i, constraintSet, view2, hashMap, 5, 5);
            SetBias(constraintSet, view2, hashMap, 0);
            SetBias(constraintSet, view2, hashMap, 1);
            SetAbsolutePositions(i, constraintSet, view2, hashMap);
            this.mMotionLayout.updateState(lookUpConstraintId, constraintSet);
            this.mMotionLayout.requestLayout();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setKeyFrame(Object obj, int i, String str, Object obj2) {
        MotionScene motionScene;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048596, this, obj, i, str, obj2) == null) && (motionScene = this.mMotionLayout.mScene) != null) {
            motionScene.setKeyframe((View) obj, i, str, obj2);
            MotionLayout motionLayout = this.mMotionLayout;
            motionLayout.mTransitionGoalPosition = i / 100.0f;
            motionLayout.mTransitionLastPosition = 0.0f;
            motionLayout.rebuildScene();
            this.mMotionLayout.evaluate(true);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(Object obj, int i, int i2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{obj, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)})) == null) {
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene != null) {
                MotionController motionController = motionLayout.mFrameArrayList.get(obj);
                MotionLayout motionLayout2 = this.mMotionLayout;
                int i3 = (int) (motionLayout2.mTransitionPosition * 100.0f);
                if (motionController != null) {
                    View view2 = (View) obj;
                    if (motionLayout2.mScene.hasKeyFramePosition(view2, i3)) {
                        float keyFrameParameter = motionController.getKeyFrameParameter(2, f, f2);
                        float keyFrameParameter2 = motionController.getKeyFrameParameter(5, f, f2);
                        this.mMotionLayout.mScene.setKeyframe(view2, i3, "motion:percentX", Float.valueOf(keyFrameParameter));
                        this.mMotionLayout.mScene.setKeyframe(view2, i3, "motion:percentY", Float.valueOf(keyFrameParameter2));
                        this.mMotionLayout.rebuildScene();
                        this.mMotionLayout.evaluate(true);
                        this.mMotionLayout.invalidate();
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void setState(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            if (str == null) {
                str = "motion_base";
            }
            if (this.mLastStartState == str) {
                return;
            }
            this.mLastStartState = str;
            this.mLastEndState = null;
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null) {
                motionLayout.mScene = this.mSceneCache;
            }
            if (str != null) {
                i = this.mMotionLayout.lookUpConstraintId(str);
            } else {
                i = R.id.motion_base;
            }
            this.mLastStartStateId = i;
            if (i != 0) {
                if (i == this.mMotionLayout.getStartState()) {
                    this.mMotionLayout.setProgress(0.0f);
                } else if (i == this.mMotionLayout.getEndState()) {
                    this.mMotionLayout.setProgress(1.0f);
                } else {
                    this.mMotionLayout.transitionToState(i);
                    this.mMotionLayout.setProgress(1.0f);
                }
            }
            this.mMotionLayout.requestLayout();
        }
    }
}
