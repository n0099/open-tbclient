package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import java.io.PrintStream;
import java.util.HashMap;
/* loaded from: classes.dex */
public class DesignTool implements ProxyInterface {
    public static final boolean DEBUG = false;
    public static final String TAG = "DesignTool";
    public static final HashMap<Pair<Integer, Integer>, String> allAttributes = new HashMap<>();
    public static final HashMap<String, String> allMargins = new HashMap<>();
    public final MotionLayout mMotionLayout;
    public MotionScene mSceneCache;
    public String mLastStartState = null;
    public String mLastEndState = null;
    public int mLastStartStateId = -1;
    public int mLastEndStateId = -1;

    static {
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
        this.mMotionLayout = motionLayout;
    }

    public void disableAutoTransition(boolean z) {
        this.mMotionLayout.disableAutoTransition(z);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float f) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        this.mMotionLayout.setProgress(f);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public static void Connect(int i, ConstraintSet constraintSet, View view2, HashMap<String, String> hashMap, int i2, int i3) {
        int i4;
        String str = allAttributes.get(Pair.create(Integer.valueOf(i2), Integer.valueOf(i3)));
        String str2 = hashMap.get(str);
        if (str2 != null) {
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
        int indexOf;
        if (str == null || (indexOf = str.indexOf(100)) == -1) {
            return 0;
        }
        return (int) ((Integer.valueOf(str.substring(0, indexOf)).intValue() * i) / 160.0f);
    }

    public int getAnimationKeyFrames(Object obj, float[] fArr) {
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

    public void getAnimationRectangles(Object obj, float[] fArr) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene == null) {
            return;
        }
        int duration = motionScene.getDuration() / 16;
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return;
        }
        motionController.buildRectangles(fArr, duration);
    }

    public void setTransition(String str, String str2) {
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

    public void setViewDebug(Object obj, int i) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController != null) {
            motionController.setDrawPath(i);
            this.mMotionLayout.invalidate();
        }
    }

    public static void SetAbsolutePositions(int i, ConstraintSet constraintSet, View view2, HashMap<String, String> hashMap) {
        String str = hashMap.get("layout_editor_absoluteX");
        if (str != null) {
            constraintSet.setEditorAbsoluteX(view2.getId(), GetPxFromDp(i, str));
        }
        String str2 = hashMap.get("layout_editor_absoluteY");
        if (str2 != null) {
            constraintSet.setEditorAbsoluteY(view2.getId(), GetPxFromDp(i, str2));
        }
    }

    public static void SetBias(ConstraintSet constraintSet, View view2, HashMap<String, String> hashMap, int i) {
        String str;
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

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(Object obj, int i, float f, float f2) {
        return this.mMotionLayout.mFrameArrayList.get((View) obj).getKeyFrameParameter(i, f, f2);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setKeyFrame(Object obj, int i, String str, Object obj2) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene != null) {
            motionScene.setKeyframe((View) obj, i, str, obj2);
            MotionLayout motionLayout = this.mMotionLayout;
            motionLayout.mTransitionGoalPosition = i / 100.0f;
            motionLayout.mTransitionLastPosition = 0.0f;
            motionLayout.rebuildScene();
            this.mMotionLayout.evaluate(true);
        }
    }

    public static void SetDimensions(int i, ConstraintSet constraintSet, View view2, HashMap<String, String> hashMap, int i2) {
        String str;
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

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int i, String str, Object obj, float[] fArr, int i2, float[] fArr2, int i3) {
        MotionController motionController;
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

    public void dumpConstraintSet(String str) {
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

    public void setState(String str) {
        int i;
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
            i = R.id.obfuscated_res_0x7f09180a;
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

    public int getAnimationPath(Object obj, float[] fArr, int i) {
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

    public int getKeyFrameInfo(Object obj, int i, int[] iArr) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFrameInfo(i, iArr);
    }

    public int getKeyFramePositions(Object obj, int[] iArr, float[] fArr) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getkeyFramePositions(iArr, fArr);
    }

    public Object getKeyframe(int i, int i2, int i3) {
        MotionLayout motionLayout = this.mMotionLayout;
        MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getKeyFrame(motionLayout.getContext(), i, i2, i3);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Object getKeyframeAtLocation(Object obj, float f, float f2) {
        MotionController motionController;
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

    public void setKeyframe(Object obj, String str, Object obj2) {
        if (obj instanceof Key) {
            ((Key) obj).setValue(str, obj2);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
        }
    }

    public String getEndState() {
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

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getStartState() {
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

    public String getState() {
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

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        if (this.mLastStartState != null && this.mLastEndState != null) {
            return true;
        }
        return false;
    }

    public Object getKeyframe(Object obj, int i, int i2) {
        if (this.mMotionLayout.mScene == null) {
            return null;
        }
        int id = ((View) obj).getId();
        MotionLayout motionLayout = this.mMotionLayout;
        return motionLayout.mScene.getKeyFrame(motionLayout.getContext(), i, id, i2);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Boolean getPositionKeyframe(Object obj, Object obj2, float f, float f2, String[] strArr, float[] fArr) {
        if (obj instanceof KeyPositionBase) {
            View view2 = (View) obj2;
            this.mMotionLayout.mFrameArrayList.get(view2).positionKeyframe(view2, (KeyPositionBase) obj, f, f2, strArr, fArr);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setAttributes(int i, String str, Object obj, Object obj2) {
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

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(Object obj, int i, int i2, float f, float f2) {
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
}
