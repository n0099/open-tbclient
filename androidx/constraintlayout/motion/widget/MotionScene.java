package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class MotionScene {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANTICIPATE = 4;
    public static final int BOUNCE = 5;
    public static final boolean DEBUG = false;
    public static final int EASE_IN = 1;
    public static final int EASE_IN_OUT = 0;
    public static final int EASE_OUT = 2;
    public static final int INTERPOLATOR_REFRENCE_ID = -2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    public static final int LINEAR = 3;
    public static final int SPLINE_STRING = -1;
    public static final String TAG = "MotionScene";
    public static final int TRANSITION_BACKWARD = 0;
    public static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean DEBUG_DESKTOP;
    public ArrayList<Transition> mAbstractTransitionList;
    public HashMap<String, Integer> mConstraintSetIdMap;
    public SparseArray<ConstraintSet> mConstraintSetMap;
    public Transition mCurrentTransition;
    public int mDefaultDuration;
    public Transition mDefaultTransition;
    public SparseIntArray mDeriveMap;
    public boolean mDisableAutoTransition;
    public boolean mIgnoreTouch;
    public MotionEvent mLastTouchDown;
    public float mLastTouchX;
    public float mLastTouchY;
    public int mLayoutDuringTransition;
    public final MotionLayout mMotionLayout;
    public boolean mMotionOutsideRegion;
    public boolean mRtl;
    public StateSet mStateSet;
    public ArrayList<Transition> mTransitionList;
    public MotionLayout.MotionTracker mVelocityTracker;

    public MotionScene(MotionLayout motionLayout) {
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
        this.mStateSet = null;
        this.mCurrentTransition = null;
        this.mDisableAutoTransition = false;
        this.mTransitionList = new ArrayList<>();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = new ArrayList<>();
        this.mConstraintSetMap = new SparseArray<>();
        this.mConstraintSetIdMap = new HashMap<>();
        this.mDeriveMap = new SparseIntArray();
        this.DEBUG_DESKTOP = false;
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mIgnoreTouch = false;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = motionLayout;
    }

    private int getId(Context context, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, context, str)) == null) {
            if (str.contains("/")) {
                i = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
                if (this.DEBUG_DESKTOP) {
                    PrintStream printStream = System.out;
                    printStream.println("id getMap res = " + i);
                }
            } else {
                i = -1;
            }
            if (i == -1) {
                if (str != null && str.length() > 1) {
                    return Integer.parseInt(str.substring(1));
                }
                Log.e(TAG, "error in parsing id");
                return i;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    private int getIndex(Transition transition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, transition)) == null) {
            int i = transition.mId;
            if (i != -1) {
                for (int i2 = 0; i2 < this.mTransitionList.size(); i2++) {
                    if (this.mTransitionList.get(i2).mId == i) {
                        return i2;
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException("The transition must have an id");
        }
        return invokeL.intValue;
    }

    private int getRealID(int i) {
        InterceptResult invokeI;
        int stateGetConstraintID;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
            StateSet stateSet = this.mStateSet;
            return (stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i, -1, -1)) == -1) ? i : stateGetConstraintID;
        }
        return invokeI.intValue;
    }

    private boolean hasCycleDependency(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i)) == null) {
            int i2 = this.mDeriveMap.get(i);
            int size = this.mDeriveMap.size();
            while (i2 > 0) {
                if (i2 == i) {
                    return true;
                }
                int i3 = size - 1;
                if (size < 0) {
                    return true;
                }
                i2 = this.mDeriveMap.get(i2);
                size = i3;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private boolean isProcessingTouch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.mVelocityTracker != null : invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void load(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLI(65547, this, context, i) != null) {
            return;
        }
        XmlResourceParser xml = context.getResources().getXml(i);
        Transition transition = null;
        try {
            int eventType = xml.getEventType();
            while (true) {
                char c = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    if (this.DEBUG_DESKTOP) {
                        PrintStream printStream = System.out;
                        printStream.println("parsing = " + name);
                    }
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals(ConstraintSet.TAG)) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case 269306229:
                            if (name.equals(androidx.transition.Transition.LOG_TAG)) {
                                break;
                            }
                            c = 65535;
                            break;
                        case 312750793:
                            if (name.equals("OnClick")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 327855227:
                            if (name.equals("OnSwipe")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 793277014:
                            if (name.equals(TAG)) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            parseMotionSceneTags(context, xml);
                            continue;
                        case 1:
                            ArrayList<Transition> arrayList = this.mTransitionList;
                            Transition transition2 = new Transition(this, context, xml);
                            arrayList.add(transition2);
                            if (this.mCurrentTransition == null && !transition2.mIsAbstract) {
                                this.mCurrentTransition = transition2;
                                if (transition2 != null && transition2.mTouchResponse != null) {
                                    this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
                                }
                            }
                            if (transition2.mIsAbstract) {
                                if (transition2.mConstraintSetEnd == -1) {
                                    this.mDefaultTransition = transition2;
                                } else {
                                    this.mAbstractTransitionList.add(transition2);
                                }
                                this.mTransitionList.remove(transition2);
                            }
                            transition = transition2;
                            continue;
                        case 2:
                            if (transition == null) {
                                String resourceEntryName = context.getResources().getResourceEntryName(i);
                                int lineNumber = xml.getLineNumber();
                                Log.v(TAG, " OnSwipe (" + resourceEntryName + ".xml:" + lineNumber + SmallTailInfo.EMOTION_SUFFIX);
                            }
                            transition.mTouchResponse = new TouchResponse(context, this.mMotionLayout, xml);
                            continue;
                        case 3:
                            transition.addOnClick(context, xml);
                            continue;
                        case 4:
                            this.mStateSet = new StateSet(context, xml);
                            continue;
                        case 5:
                            parseConstraintSet(context, xml);
                            continue;
                        case 6:
                            transition.mKeyFramesList.add(new KeyFrames(context, xml));
                            continue;
                        default:
                            Log.v(TAG, "WARNING UNKNOWN ATTRIBUTE " + name);
                            continue;
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, context, xmlPullParser) == null) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.setForceId(false);
            int attributeCount = xmlPullParser.getAttributeCount();
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < attributeCount; i3++) {
                String attributeName = xmlPullParser.getAttributeName(i3);
                String attributeValue = xmlPullParser.getAttributeValue(i3);
                if (this.DEBUG_DESKTOP) {
                    PrintStream printStream = System.out;
                    printStream.println("id string = " + attributeValue);
                }
                int hashCode = attributeName.hashCode();
                if (hashCode != -1496482599) {
                    if (hashCode == 3355 && attributeName.equals("id")) {
                        c = 0;
                    }
                    c = 65535;
                } else {
                    if (attributeName.equals("deriveConstraintsFrom")) {
                        c = 1;
                    }
                    c = 65535;
                }
                if (c == 0) {
                    i = getId(context, attributeValue);
                    this.mConstraintSetIdMap.put(stripID(attributeValue), Integer.valueOf(i));
                } else if (c == 1) {
                    i2 = getId(context, attributeValue);
                }
            }
            if (i != -1) {
                if (this.mMotionLayout.mDebugPath != 0) {
                    constraintSet.setValidateOnParse(true);
                }
                constraintSet.load(context, xmlPullParser);
                if (i2 != -1) {
                    this.mDeriveMap.put(i, i2);
                }
                this.mConstraintSetMap.put(i, constraintSet);
            }
        }
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, context, xmlPullParser) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.MotionScene);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.MotionScene_defaultDuration) {
                    this.mDefaultDuration = obtainStyledAttributes.getInt(index, this.mDefaultDuration);
                } else if (index == R$styleable.MotionScene_layoutDuringTransition) {
                    this.mLayoutDuringTransition = obtainStyledAttributes.getInteger(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void readConstraintChain(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65550, this, i) == null) || (i2 = this.mDeriveMap.get(i)) <= 0) {
            return;
        }
        readConstraintChain(this.mDeriveMap.get(i));
        ConstraintSet constraintSet = this.mConstraintSetMap.get(i);
        ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i2);
        if (constraintSet2 == null) {
            Log.e(TAG, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), i2));
            return;
        }
        constraintSet.readFallback(constraintSet2);
        this.mDeriveMap.put(i, -1);
    }

    public static String stripID(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (str == null) {
                return "";
            }
            int indexOf = str.indexOf(47);
            return indexOf < 0 ? str : str.substring(indexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, motionLayout, i) == null) {
            Iterator<Transition> it = this.mTransitionList.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.mOnClicks.size() > 0) {
                    Iterator it2 = next.mOnClicks.iterator();
                    while (it2.hasNext()) {
                        ((Transition.TransitionOnClick) it2.next()).removeOnClickListeners(motionLayout);
                    }
                }
            }
            Iterator<Transition> it3 = this.mAbstractTransitionList.iterator();
            while (it3.hasNext()) {
                Transition next2 = it3.next();
                if (next2.mOnClicks.size() > 0) {
                    Iterator it4 = next2.mOnClicks.iterator();
                    while (it4.hasNext()) {
                        ((Transition.TransitionOnClick) it4.next()).removeOnClickListeners(motionLayout);
                    }
                }
            }
            Iterator<Transition> it5 = this.mTransitionList.iterator();
            while (it5.hasNext()) {
                Transition next3 = it5.next();
                if (next3.mOnClicks.size() > 0) {
                    Iterator it6 = next3.mOnClicks.iterator();
                    while (it6.hasNext()) {
                        ((Transition.TransitionOnClick) it6.next()).addOnClickListeners(motionLayout, i, next3);
                    }
                }
            }
            Iterator<Transition> it7 = this.mAbstractTransitionList.iterator();
            while (it7.hasNext()) {
                Transition next4 = it7.next();
                if (next4.mOnClicks.size() > 0) {
                    Iterator it8 = next4.mOnClicks.iterator();
                    while (it8.hasNext()) {
                        ((Transition.TransitionOnClick) it8.next()).addOnClickListeners(motionLayout, i, next4);
                    }
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition) == null) {
            int index = getIndex(transition);
            if (index == -1) {
                this.mTransitionList.add(transition);
            } else {
                this.mTransitionList.set(index, transition);
            }
        }
    }

    public boolean autoTransition(MotionLayout motionLayout, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, motionLayout, i)) == null) {
            if (isProcessingTouch() || this.mDisableAutoTransition) {
                return false;
            }
            Iterator<Transition> it = this.mTransitionList.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.mAutoTransition != 0 && this.mCurrentTransition != next) {
                    if (i != next.mConstraintSetStart || (next.mAutoTransition != 4 && next.mAutoTransition != 2)) {
                        if (i == next.mConstraintSetEnd && (next.mAutoTransition == 3 || next.mAutoTransition == 1)) {
                            motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                            motionLayout.setTransition(next);
                            if (next.mAutoTransition == 3) {
                                motionLayout.transitionToStart();
                                motionLayout.setState(MotionLayout.TransitionState.SETUP);
                                motionLayout.setState(MotionLayout.TransitionState.MOVING);
                            } else {
                                motionLayout.setProgress(0.0f);
                                motionLayout.evaluate(true);
                                motionLayout.setState(MotionLayout.TransitionState.SETUP);
                                motionLayout.setState(MotionLayout.TransitionState.MOVING);
                                motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                                motionLayout.onNewStateAttachHandlers();
                            }
                            return true;
                        }
                    } else {
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        motionLayout.setTransition(next);
                        if (next.mAutoTransition == 4) {
                            motionLayout.transitionToEnd();
                            motionLayout.setState(MotionLayout.TransitionState.SETUP);
                            motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        } else {
                            motionLayout.setProgress(1.0f);
                            motionLayout.evaluate(true);
                            motionLayout.setState(MotionLayout.TransitionState.SETUP);
                            motionLayout.setState(MotionLayout.TransitionState.MOVING);
                            motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                            motionLayout.onNewStateAttachHandlers();
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public Transition bestTransitionFor(int i, float f, float f2, MotionEvent motionEvent) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), motionEvent})) == null) {
            if (i != -1) {
                List<Transition> transitionsWithState = getTransitionsWithState(i);
                float f3 = 0.0f;
                Transition transition = null;
                RectF rectF = new RectF();
                for (Transition transition2 : transitionsWithState) {
                    if (!transition2.mDisable && transition2.mTouchResponse != null) {
                        transition2.mTouchResponse.setRTL(this.mRtl);
                        RectF touchRegion = transition2.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                        if (touchRegion == null || motionEvent == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) {
                            RectF touchRegion2 = transition2.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                            if (touchRegion2 == null || motionEvent == null || touchRegion2.contains(motionEvent.getX(), motionEvent.getY())) {
                                float dot = transition2.mTouchResponse.dot(f, f2) * (transition2.mConstraintSetEnd == i ? -1.0f : 1.1f);
                                if (dot > f3) {
                                    transition = transition2;
                                    f3 = dot;
                                }
                            }
                        }
                    }
                }
                return transition;
            }
            return this.mCurrentTransition;
        }
        return (Transition) invokeCommon.objValue;
    }

    public void disableAutoTransition(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mDisableAutoTransition = z;
        }
    }

    public int gatPathMotionArc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition != null) {
                return transition.mPathMotionArc;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str)) == null) {
            if (this.DEBUG_DESKTOP) {
                PrintStream printStream = System.out;
                printStream.println("id " + str);
                PrintStream printStream2 = System.out;
                printStream2.println("size " + this.mConstraintSetMap.size());
            }
            for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
                int keyAt = this.mConstraintSetMap.keyAt(i);
                String resourceName = context.getResources().getResourceName(keyAt);
                if (this.DEBUG_DESKTOP) {
                    PrintStream printStream3 = System.out;
                    printStream3.println("Id for <" + i + "> is <" + resourceName + "> looking for <" + str + ">");
                }
                if (str.equals(resourceName)) {
                    return this.mConstraintSetMap.get(keyAt);
                }
            }
            return null;
        }
        return (ConstraintSet) invokeLL.objValue;
    }

    public int[] getConstraintSetIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int size = this.mConstraintSetMap.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = this.mConstraintSetMap.keyAt(i);
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mTransitionList : (ArrayList) invokeV.objValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition != null) {
                return transition.mDuration;
            }
            return this.mDefaultDuration;
        }
        return invokeV.intValue;
    }

    public int getEndId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition == null) {
                return -1;
            }
            return transition.mConstraintSetEnd;
        }
        return invokeV.intValue;
    }

    public Interpolator getInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i = this.mCurrentTransition.mDefaultInterpolator;
            if (i != -2) {
                if (i != -1) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 4) {
                                    if (i != 5) {
                                        return null;
                                    }
                                    return new BounceInterpolator();
                                }
                                return new AnticipateInterpolator();
                            }
                            return new DecelerateInterpolator();
                        }
                        return new AccelerateInterpolator();
                    }
                    return new AccelerateDecelerateInterpolator();
                }
                return new Interpolator(this, Easing.getInterpolator(this.mCurrentTransition.mDefaultInterpolatorString)) { // from class: androidx.constraintlayout.motion.widget.MotionScene.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MotionScene this$0;
                    public final /* synthetic */ Easing val$easing;

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
                        this.val$easing = r7;
                    }

                    @Override // android.animation.TimeInterpolator
                    public float getInterpolation(float f) {
                        InterceptResult invokeF;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeF = interceptable2.invokeF(1048576, this, f)) == null) ? (float) this.val$easing.get(f) : invokeF.floatValue;
                    }
                };
            }
            return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.mCurrentTransition.mDefaultInterpolatorID);
        }
        return (Interpolator) invokeV.objValue;
    }

    public Key getKeyFrame(Context context, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048590, this, context, i, i2, i3)) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition == null) {
                return null;
            }
            Iterator it = transition.mKeyFramesList.iterator();
            while (it.hasNext()) {
                KeyFrames keyFrames = (KeyFrames) it.next();
                for (Integer num : keyFrames.getKeys()) {
                    if (i2 == num.intValue()) {
                        Iterator<Key> it2 = keyFrames.getKeyFramesForView(num.intValue()).iterator();
                        while (it2.hasNext()) {
                            Key next = it2.next();
                            if (next.mFramePosition == i3 && next.mType == i) {
                                return next;
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return (Key) invokeLIII.objValue;
    }

    public void getKeyFrames(MotionController motionController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, motionController) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition != null) {
                Iterator it = transition.mKeyFramesList.iterator();
                while (it.hasNext()) {
                    ((KeyFrames) it.next()).addFrames(motionController);
                }
                return;
            }
            Transition transition2 = this.mDefaultTransition;
            if (transition2 != null) {
                Iterator it2 = transition2.mKeyFramesList.iterator();
                while (it2.hasNext()) {
                    ((KeyFrames) it2.next()).addFrames(motionController);
                }
            }
        }
    }

    public float getMaxAcceleration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition == null || transition.mTouchResponse == null) {
                return 0.0f;
            }
            return this.mCurrentTransition.mTouchResponse.getMaxAcceleration();
        }
        return invokeV.floatValue;
    }

    public float getMaxVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition == null || transition.mTouchResponse == null) {
                return 0.0f;
            }
            return this.mCurrentTransition.mTouchResponse.getMaxVelocity();
        }
        return invokeV.floatValue;
    }

    public boolean getMoveWhenScrollAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition == null || transition.mTouchResponse == null) {
                return false;
            }
            return this.mCurrentTransition.mTouchResponse.getMoveWhenScrollAtTop();
        }
        return invokeV.booleanValue;
    }

    public float getPathPercent(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, view2, i)) == null) {
            return 0.0f;
        }
        return invokeLI.floatValue;
    }

    public float getProgressDirection(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition == null || transition.mTouchResponse == null) {
                return 0.0f;
            }
            return this.mCurrentTransition.mTouchResponse.getProgressDirection(f, f2);
        }
        return invokeCommon.floatValue;
    }

    public float getStaggered() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition != null) {
                return transition.mStagger;
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public int getStartId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition == null) {
                return -1;
            }
            return transition.mConstraintSetStart;
        }
        return invokeV.intValue;
    }

    public Transition getTransitionById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            Iterator<Transition> it = this.mTransitionList.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.mId == i) {
                    return next;
                }
            }
            return null;
        }
        return (Transition) invokeI.objValue;
    }

    public int getTransitionDirection(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            Iterator<Transition> it = this.mTransitionList.iterator();
            while (it.hasNext()) {
                if (it.next().mConstraintSetStart == i) {
                    return 0;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public List<Transition> getTransitionsWithState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            int realID = getRealID(i);
            ArrayList arrayList = new ArrayList();
            Iterator<Transition> it = this.mTransitionList.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.mConstraintSetStart == realID || next.mConstraintSetEnd == realID) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public boolean hasKeyFramePosition(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, view2, i)) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition == null) {
                return false;
            }
            Iterator it = transition.mKeyFramesList.iterator();
            while (it.hasNext()) {
                Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view2.getId()).iterator();
                while (it2.hasNext()) {
                    if (it2.next().mFramePosition == i) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public int lookUpConstraintId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? this.mConstraintSetIdMap.get(str).intValue() : invokeL.intValue;
    }

    public String lookUpConstraintName(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            for (Map.Entry<String, Integer> entry : this.mConstraintSetIdMap.entrySet()) {
                if (entry.getValue().intValue() == i) {
                    return entry.getKey();
                }
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
        }
    }

    public void processScrollMove(float f, float f2) {
        Transition transition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || (transition = this.mCurrentTransition) == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.scrollMove(f, f2);
    }

    public void processScrollUp(float f, float f2) {
        Transition transition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || (transition = this.mCurrentTransition) == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.scrollUp(f, f2);
    }

    public void processTouchEvent(MotionEvent motionEvent, int i, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048608, this, motionEvent, i, motionLayout) == null) {
            RectF rectF = new RectF();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            if (i != -1) {
                int action = motionEvent.getAction();
                boolean z = false;
                if (action != 0) {
                    if (action == 2 && !this.mIgnoreTouch) {
                        float rawY = motionEvent.getRawY() - this.mLastTouchY;
                        float rawX = motionEvent.getRawX() - this.mLastTouchX;
                        if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.mLastTouchDown) == null) {
                            return;
                        }
                        Transition bestTransitionFor = bestTransitionFor(i, rawX, rawY, motionEvent2);
                        if (bestTransitionFor != null) {
                            motionLayout.setTransition(bestTransitionFor);
                            RectF touchRegion = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                            if (touchRegion != null && !touchRegion.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                                z = true;
                            }
                            this.mMotionOutsideRegion = z;
                            this.mCurrentTransition.mTouchResponse.setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                        }
                    }
                } else {
                    this.mLastTouchX = motionEvent.getRawX();
                    this.mLastTouchY = motionEvent.getRawY();
                    this.mLastTouchDown = motionEvent;
                    this.mIgnoreTouch = false;
                    if (this.mCurrentTransition.mTouchResponse != null) {
                        RectF limitBoundsTo = this.mCurrentTransition.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF);
                        if (limitBoundsTo == null || limitBoundsTo.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            RectF touchRegion2 = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                            if (touchRegion2 != null && !touchRegion2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                                this.mMotionOutsideRegion = true;
                            } else {
                                this.mMotionOutsideRegion = false;
                            }
                            this.mCurrentTransition.mTouchResponse.setDown(this.mLastTouchX, this.mLastTouchY);
                            return;
                        }
                        this.mLastTouchDown = null;
                        this.mIgnoreTouch = true;
                        return;
                    }
                    return;
                }
            }
            if (this.mIgnoreTouch) {
                return;
            }
            Transition transition = this.mCurrentTransition;
            if (transition != null && transition.mTouchResponse != null && !this.mMotionOutsideRegion) {
                this.mCurrentTransition.mTouchResponse.processTouchEvent(motionEvent, this.mVelocityTracker, i, this);
            }
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
            if (motionEvent.getAction() != 1 || (motionTracker = this.mVelocityTracker) == null) {
                return;
            }
            motionTracker.recycle();
            this.mVelocityTracker = null;
            int i2 = motionLayout.mCurrentState;
            if (i2 != -1) {
                autoTransition(motionLayout, i2);
            }
        }
    }

    public void readFallback(MotionLayout motionLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, motionLayout) == null) {
            for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
                int keyAt = this.mConstraintSetMap.keyAt(i);
                if (hasCycleDependency(keyAt)) {
                    Log.e(TAG, "Cannot be derived from yourself");
                    return;
                }
                readConstraintChain(keyAt);
            }
            for (int i2 = 0; i2 < this.mConstraintSetMap.size(); i2++) {
                this.mConstraintSetMap.valueAt(i2).readFallback(motionLayout);
            }
        }
    }

    public void removeTransition(Transition transition) {
        int index;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, transition) == null) || (index = getIndex(transition)) == -1) {
            return;
        }
        this.mTransitionList.remove(index);
    }

    public void setConstraintSet(int i, ConstraintSet constraintSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048611, this, i, constraintSet) == null) {
            this.mConstraintSetMap.put(i, constraintSet);
        }
    }

    public void setDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            Transition transition = this.mCurrentTransition;
            if (transition != null) {
                transition.setDuration(i);
            } else {
                this.mDefaultDuration = i;
            }
        }
    }

    public void setKeyframe(View view2, int i, String str, Object obj) {
        Transition transition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048613, this, view2, i, str, obj) == null) || (transition = this.mCurrentTransition) == null) {
            return;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view2.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().mFramePosition == i) {
                    int i2 = ((obj != null ? ((Float) obj).floatValue() : 0.0f) > 0.0f ? 1 : ((obj != null ? ((Float) obj).floatValue() : 0.0f) == 0.0f ? 0 : -1));
                    str.equalsIgnoreCase("app:PerpendicularPath_percent");
                }
            }
        }
    }

    public void setRtl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.mRtl = z;
            Transition transition = this.mCurrentTransition;
            if (transition == null || transition.mTouchResponse == null) {
                return;
            }
            this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (r2 != (-1)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTransition(int i, int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048615, this, i, i2) == null) {
            StateSet stateSet = this.mStateSet;
            if (stateSet != null) {
                i3 = stateSet.stateGetConstraintID(i, -1, -1);
                if (i3 == -1) {
                    i3 = i;
                }
                i4 = this.mStateSet.stateGetConstraintID(i2, -1, -1);
            } else {
                i3 = i;
            }
            i4 = i2;
            Iterator<Transition> it = this.mTransitionList.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if ((next.mConstraintSetEnd == i4 && next.mConstraintSetStart == i3) || (next.mConstraintSetEnd == i2 && next.mConstraintSetStart == i)) {
                    this.mCurrentTransition = next;
                    if (next == null || next.mTouchResponse == null) {
                        return;
                    }
                    this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
                    return;
                }
            }
            Transition transition = this.mDefaultTransition;
            Iterator<Transition> it2 = this.mAbstractTransitionList.iterator();
            while (it2.hasNext()) {
                Transition next2 = it2.next();
                if (next2.mConstraintSetEnd == i2) {
                    transition = next2;
                }
            }
            Transition transition2 = new Transition(this, transition);
            transition2.mConstraintSetStart = i3;
            transition2.mConstraintSetEnd = i4;
            if (i3 != -1) {
                this.mTransitionList.add(transition2);
            }
            this.mCurrentTransition = transition2;
        }
    }

    public void setupTouch() {
        Transition transition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (transition = this.mCurrentTransition) == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setupTouch();
    }

    public boolean supportTouch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            Iterator<Transition> it = this.mTransitionList.iterator();
            while (it.hasNext()) {
                if (it.next().mTouchResponse != null) {
                    return true;
                }
            }
            Transition transition = this.mCurrentTransition;
            return (transition == null || transition.mTouchResponse == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, motionLayout)) == null) ? motionLayout == this.mMotionLayout && motionLayout.mScene == this : invokeL.booleanValue;
    }

    public ConstraintSet getConstraintSet(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? getConstraintSet(i, -1, -1) : (ConstraintSet) invokeI.objValue;
    }

    public ConstraintSet getConstraintSet(int i, int i2, int i3) {
        InterceptResult invokeIII;
        int stateGetConstraintID;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048583, this, i, i2, i3)) == null) {
            if (this.DEBUG_DESKTOP) {
                PrintStream printStream = System.out;
                printStream.println("id " + i);
                PrintStream printStream2 = System.out;
                printStream2.println("size " + this.mConstraintSetMap.size());
            }
            StateSet stateSet = this.mStateSet;
            if (stateSet != null && (stateGetConstraintID = stateSet.stateGetConstraintID(i, i2, i3)) != -1) {
                i = stateGetConstraintID;
            }
            if (this.mConstraintSetMap.get(i) == null) {
                Log.e(TAG, "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), i) + " In MotionScene");
                SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
                return sparseArray.get(sparseArray.keyAt(0));
            }
            return this.mConstraintSetMap.get(i);
        }
        return (ConstraintSet) invokeIII.objValue;
    }

    public MotionScene(Context context, MotionLayout motionLayout, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, motionLayout, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStateSet = null;
        this.mCurrentTransition = null;
        this.mDisableAutoTransition = false;
        this.mTransitionList = new ArrayList<>();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = new ArrayList<>();
        this.mConstraintSetMap = new SparseArray<>();
        this.mConstraintSetIdMap = new HashMap<>();
        this.mDeriveMap = new SparseIntArray();
        this.DEBUG_DESKTOP = false;
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mIgnoreTouch = false;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = motionLayout;
        load(context, i);
        this.mConstraintSetMap.put(R$id.motion_base, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(R$id.motion_base));
    }

    public void setTransition(Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, transition) == null) {
            this.mCurrentTransition = transition;
            if (transition == null || transition.mTouchResponse == null) {
                return;
            }
            this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
        }
    }

    /* loaded from: classes.dex */
    public static class Transition {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        public static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public int mAutoTransition;
        public int mConstraintSetEnd;
        public int mConstraintSetStart;
        public int mDefaultInterpolator;
        public int mDefaultInterpolatorID;
        public String mDefaultInterpolatorString;
        public boolean mDisable;
        public int mDuration;
        public int mId;
        public boolean mIsAbstract;
        public ArrayList<KeyFrames> mKeyFramesList;
        public int mLayoutDuringTransition;
        public final MotionScene mMotionScene;
        public ArrayList<TransitionOnClick> mOnClicks;
        public int mPathMotionArc;
        public float mStagger;
        public TouchResponse mTouchResponse;
        public int mTransitionFlags;

        /* loaded from: classes.dex */
        public static class TransitionOnClick implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            public transient /* synthetic */ FieldHolder $fh;
            public int mMode;
            public int mTargetId;
            public final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, transition, xmlPullParser};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i3 = 0; i3 < indexCount; i3++) {
                    int index = obtainStyledAttributes.getIndex(i3);
                    if (index == R$styleable.OnClick_targetId) {
                        this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    } else if (index == R$styleable.OnClick_clickAction) {
                        this.mMode = obtainStyledAttributes.getInt(index, this.mMode);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r6v4, types: [android.view.View] */
            public void addOnClickListeners(MotionLayout motionLayout, int i, Transition transition) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, motionLayout, i, transition) == null) {
                    int i2 = this.mTargetId;
                    MotionLayout motionLayout2 = motionLayout;
                    if (i2 != -1) {
                        motionLayout2 = motionLayout.findViewById(i2);
                    }
                    if (motionLayout2 != null) {
                        int i3 = transition.mConstraintSetStart;
                        int i4 = transition.mConstraintSetEnd;
                        if (i3 == -1) {
                            motionLayout2.setOnClickListener(this);
                            return;
                        }
                        boolean z = true;
                        if ((((this.mMode & 1) != 0 && i == i3) | ((this.mMode & 1) != 0 && i == i3) | ((this.mMode & 256) != 0 && i == i3) | ((this.mMode & 16) != 0 && i == i4)) || (((this.mMode & 4096) == 0 || i != i4) ? false : false)) {
                            motionLayout2.setOnClickListener(this);
                            return;
                        }
                        return;
                    }
                    Log.e(MotionScene.TAG, "OnClick could not find id " + this.mTargetId);
                }
            }

            public boolean isTransitionViable(Transition transition, MotionLayout motionLayout) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition, motionLayout)) == null) {
                    Transition transition2 = this.mTransition;
                    if (transition2 == transition) {
                        return true;
                    }
                    int i = transition2.mConstraintSetEnd;
                    int i2 = this.mTransition.mConstraintSetStart;
                    if (i2 == -1) {
                        return motionLayout.mCurrentState != i;
                    }
                    int i3 = motionLayout.mCurrentState;
                    return i3 == i2 || i3 == i;
                }
                return invokeLL.booleanValue;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                    MotionLayout motionLayout = this.mTransition.mMotionScene.mMotionLayout;
                    if (motionLayout.isInteractionEnabled()) {
                        if (this.mTransition.mConstraintSetStart != -1) {
                            Transition transition = this.mTransition.mMotionScene.mCurrentTransition;
                            int i = this.mMode;
                            boolean z = false;
                            boolean z2 = ((i & 1) == 0 && (i & 256) == 0) ? false : true;
                            int i2 = this.mMode;
                            boolean z3 = ((i2 & 16) == 0 && (i2 & 4096) == 0) ? false : true;
                            if (z2 && z3) {
                                Transition transition2 = this.mTransition.mMotionScene.mCurrentTransition;
                                Transition transition3 = this.mTransition;
                                if (transition2 != transition3) {
                                    motionLayout.setTransition(transition3);
                                }
                                if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                                    z = z2;
                                    z3 = false;
                                }
                            } else {
                                z = z2;
                            }
                            if (isTransitionViable(transition, motionLayout)) {
                                if (z && (this.mMode & 1) != 0) {
                                    motionLayout.setTransition(this.mTransition);
                                    motionLayout.transitionToEnd();
                                    return;
                                } else if (z3 && (this.mMode & 16) != 0) {
                                    motionLayout.setTransition(this.mTransition);
                                    motionLayout.transitionToStart();
                                    return;
                                } else if (z && (this.mMode & 256) != 0) {
                                    motionLayout.setTransition(this.mTransition);
                                    motionLayout.setProgress(1.0f);
                                    return;
                                } else if (!z3 || (this.mMode & 4096) == 0) {
                                    return;
                                } else {
                                    motionLayout.setTransition(this.mTransition);
                                    motionLayout.setProgress(0.0f);
                                    return;
                                }
                            }
                            return;
                        }
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.transitionToState(this.mTransition.mConstraintSetEnd);
                            return;
                        }
                        Transition transition4 = new Transition(this.mTransition.mMotionScene, this.mTransition);
                        transition4.mConstraintSetStart = currentState;
                        transition4.mConstraintSetEnd = this.mTransition.mConstraintSetEnd;
                        motionLayout.setTransition(transition4);
                        motionLayout.transitionToEnd();
                    }
                }
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                int i;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, motionLayout) == null) || (i = this.mTargetId) == -1) {
                    return;
                }
                View findViewById = motionLayout.findViewById(i);
                if (findViewById == null) {
                    Log.e(MotionScene.TAG, " (*)  could not find id " + this.mTargetId);
                    return;
                }
                findViewById.setOnClickListener(null);
            }
        }

        public Transition(MotionScene motionScene, Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {motionScene, transition};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = motionScene;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65558, this, motionScene, context, typedArray) == null) {
                int indexCount = typedArray.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = typedArray.getIndex(i);
                    if (index == R$styleable.Transition_constraintSetEnd) {
                        this.mConstraintSetEnd = typedArray.getResourceId(index, this.mConstraintSetEnd);
                        if (TtmlNode.TAG_LAYOUT.equals(context.getResources().getResourceTypeName(this.mConstraintSetEnd))) {
                            ConstraintSet constraintSet = new ConstraintSet();
                            constraintSet.load(context, this.mConstraintSetEnd);
                            motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, constraintSet);
                        }
                    } else if (index == R$styleable.Transition_constraintSetStart) {
                        this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                        if (TtmlNode.TAG_LAYOUT.equals(context.getResources().getResourceTypeName(this.mConstraintSetStart))) {
                            ConstraintSet constraintSet2 = new ConstraintSet();
                            constraintSet2.load(context, this.mConstraintSetStart);
                            motionScene.mConstraintSetMap.append(this.mConstraintSetStart, constraintSet2);
                        }
                    } else if (index == R$styleable.Transition_motionInterpolator) {
                        int i2 = typedArray.peekValue(index).type;
                        if (i2 == 1) {
                            int resourceId = typedArray.getResourceId(index, -1);
                            this.mDefaultInterpolatorID = resourceId;
                            if (resourceId != -1) {
                                this.mDefaultInterpolator = -2;
                            }
                        } else if (i2 == 3) {
                            String string = typedArray.getString(index);
                            this.mDefaultInterpolatorString = string;
                            if (string.indexOf("/") > 0) {
                                this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                                this.mDefaultInterpolator = -2;
                            } else {
                                this.mDefaultInterpolator = -1;
                            }
                        } else {
                            this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                        }
                    } else if (index == R$styleable.Transition_duration) {
                        this.mDuration = typedArray.getInt(index, this.mDuration);
                    } else if (index == R$styleable.Transition_staggered) {
                        this.mStagger = typedArray.getFloat(index, this.mStagger);
                    } else if (index == R$styleable.Transition_autoTransition) {
                        this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                    } else if (index == R$styleable.Transition_android_id) {
                        this.mId = typedArray.getResourceId(index, this.mId);
                    } else if (index == R$styleable.Transition_transitionDisable) {
                        this.mDisable = typedArray.getBoolean(index, this.mDisable);
                    } else if (index == R$styleable.Transition_pathMotionArc) {
                        this.mPathMotionArc = typedArray.getInteger(index, -1);
                    } else if (index == R$styleable.Transition_layoutDuringTransition) {
                        this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                    } else if (index == R$styleable.Transition_transitionFlags) {
                        this.mTransitionFlags = typedArray.getInteger(index, 0);
                    }
                }
                if (this.mConstraintSetStart == -1) {
                    this.mIsAbstract = true;
                }
            }
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65559, this, motionScene, context, attributeSet) == null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transition);
                fill(motionScene, context, obtainStyledAttributes);
                obtainStyledAttributes.recycle();
            }
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, xmlPullParser) == null) {
                this.mOnClicks.add(new TransitionOnClick(context, this, xmlPullParser));
            }
        }

        public String debugString(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                String resourceEntryName = this.mConstraintSetStart == -1 ? StringUtil.NULL_STRING : context.getResources().getResourceEntryName(this.mConstraintSetStart);
                if (this.mConstraintSetEnd == -1) {
                    return resourceEntryName + " -> null";
                }
                return resourceEntryName + LoadErrorCode.TOKEN_NEXT + context.getResources().getResourceEntryName(this.mConstraintSetEnd);
            }
            return (String) invokeL.objValue;
        }

        public int getAutoTransition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAutoTransition : invokeV.intValue;
        }

        public int getDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDuration : invokeV.intValue;
        }

        public int getEndConstraintSetId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mConstraintSetEnd : invokeV.intValue;
        }

        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mId : invokeV.intValue;
        }

        public List<KeyFrames> getKeyFrameList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mKeyFramesList : (List) invokeV.objValue;
        }

        public int getLayoutDuringTransition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mLayoutDuringTransition : invokeV.intValue;
        }

        public List<TransitionOnClick> getOnClickList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mOnClicks : (List) invokeV.objValue;
        }

        public int getPathMotionArc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mPathMotionArc : invokeV.intValue;
        }

        public float getStagger() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mStagger : invokeV.floatValue;
        }

        public int getStartConstraintSetId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mConstraintSetStart : invokeV.intValue;
        }

        public TouchResponse getTouchResponse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mTouchResponse : (TouchResponse) invokeV.objValue;
        }

        public boolean isEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? !this.mDisable : invokeV.booleanValue;
        }

        public boolean isTransitionFlag(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) ? (i & this.mTransitionFlags) != 0 : invokeI.booleanValue;
        }

        public void setAutoTransition(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
                this.mAutoTransition = i;
            }
        }

        public void setDuration(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
                this.mDuration = i;
            }
        }

        public void setEnable(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
                this.mDisable = !z;
            }
        }

        public void setPathMotionArc(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
                this.mPathMotionArc = i;
            }
        }

        public void setStagger(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048595, this, f) == null) {
                this.mStagger = f;
            }
        }

        public Transition(int i, MotionScene motionScene, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), motionScene, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = i;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i2;
            this.mConstraintSetEnd = i3;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        public Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {motionScene, context, xmlPullParser};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}
