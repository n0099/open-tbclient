package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class StateSet {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<ConstraintSet> mConstraintSetMap;
    public ConstraintsChangedListener mConstraintsChangedListener;
    public int mCurrentConstraintNumber;
    public int mCurrentStateId;
    public ConstraintSet mDefaultConstraintSet;
    public int mDefaultState;
    public SparseArray<State> mStateList;

    /* loaded from: classes.dex */
    public static class State {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mConstraintID;
        public int mId;
        public boolean mIsLayout;
        public ArrayList<Variant> mVariants;

        public State(Context context, XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, xmlPullParser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mVariants = new ArrayList<>();
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R.styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void add(Variant variant) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, variant) == null) {
                this.mVariants.add(variant);
            }
        }

        public int findMatch(float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                for (int i2 = 0; i2 < this.mVariants.size(); i2++) {
                    if (this.mVariants.get(i2).match(f2, f3)) {
                        return i2;
                    }
                }
                return -1;
            }
            return invokeCommon.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class Variant {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mConstraintID;
        public int mId;
        public boolean mIsLayout;
        public float mMaxHeight;
        public float mMaxWidth;
        public float mMinHeight;
        public float mMinWidth;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, xmlPullParser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean match(float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (Float.isNaN(this.mMinWidth) || f2 >= this.mMinWidth) {
                    if (Float.isNaN(this.mMinHeight) || f3 >= this.mMinHeight) {
                        if (Float.isNaN(this.mMaxWidth) || f2 <= this.mMaxWidth) {
                            return Float.isNaN(this.mMaxHeight) || f3 <= this.mMaxHeight;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, xmlPullParser};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDefaultState = -1;
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray<>();
        this.mConstraintSetMap = new SparseArray<>();
        this.mConstraintsChangedListener = null;
        load(context, xmlPullParser);
    }

    private void load(Context context, XmlPullParser xmlPullParser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, xmlPullParser) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.StateSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.StateSet_defaultState) {
                    this.mDefaultState = obtainStyledAttributes.getResourceId(index, this.mDefaultState);
                }
            }
            obtainStyledAttributes.recycle();
            State state = null;
            try {
                int eventType = xmlPullParser.getEventType();
                while (eventType != 1) {
                    if (eventType == 0) {
                        xmlPullParser.getName();
                    } else if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        char c2 = 65535;
                        switch (name.hashCode()) {
                            case 80204913:
                                if (name.equals("State")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 1301459538:
                                if (name.equals("LayoutDescription")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                        }
                        if (c2 != 0 && c2 != 1) {
                            if (c2 == 2) {
                                state = new State(context, xmlPullParser);
                                this.mStateList.put(state.mId, state);
                            } else if (c2 != 3) {
                                String str = "unknown tag " + name;
                            } else {
                                Variant variant = new Variant(context, xmlPullParser);
                                if (state != null) {
                                    state.add(variant);
                                }
                            }
                        }
                    } else if (eventType != 3) {
                        continue;
                    } else if ("StateSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                    eventType = xmlPullParser.next();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (XmlPullParserException e3) {
                e3.printStackTrace();
            }
        }
    }

    public int convertToConstraintSet(int i2, int i3, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            State state = this.mStateList.get(i3);
            if (state == null) {
                return i3;
            }
            if (f2 != -1.0f && f3 != -1.0f) {
                Variant variant = null;
                Iterator<Variant> it = state.mVariants.iterator();
                while (it.hasNext()) {
                    Variant next = it.next();
                    if (next.match(f2, f3)) {
                        if (i2 == next.mConstraintID) {
                            return i2;
                        }
                        variant = next;
                    }
                }
                if (variant != null) {
                    return variant.mConstraintID;
                }
                return state.mConstraintID;
            } else if (state.mConstraintID == i2) {
                return i2;
            } else {
                Iterator<Variant> it2 = state.mVariants.iterator();
                while (it2.hasNext()) {
                    if (i2 == it2.next().mConstraintID) {
                        return i2;
                    }
                }
                return state.mConstraintID;
            }
        }
        return invokeCommon.intValue;
    }

    public boolean needsToChange(int i2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int i3 = this.mCurrentStateId;
            if (i3 != i2) {
                return true;
            }
            State valueAt = i2 == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i3);
            int i4 = this.mCurrentConstraintNumber;
            return (i4 == -1 || !valueAt.mVariants.get(i4).match(f2, f3)) && this.mCurrentConstraintNumber != valueAt.findMatch(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, constraintsChangedListener) == null) {
            this.mConstraintsChangedListener = constraintsChangedListener;
        }
    }

    public int stateGetConstraintID(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(1048579, this, i2, i3, i4)) == null) ? updateConstraints(-1, i2, i3, i4) : invokeIII.intValue;
    }

    public int updateConstraints(int i2, int i3, float f2, float f3) {
        InterceptResult invokeCommon;
        State state;
        int findMatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (i2 != i3) {
                State state2 = this.mStateList.get(i3);
                if (state2 == null) {
                    return -1;
                }
                int findMatch2 = state2.findMatch(f2, f3);
                return findMatch2 == -1 ? state2.mConstraintID : state2.mVariants.get(findMatch2).mConstraintID;
            }
            if (i3 == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(this.mCurrentStateId);
            }
            if (state == null) {
                return -1;
            }
            return ((this.mCurrentConstraintNumber == -1 || !state.mVariants.get(i2).match(f2, f3)) && i2 != (findMatch = state.findMatch(f2, f3))) ? findMatch == -1 ? state.mConstraintID : state.mVariants.get(findMatch).mConstraintID : i2;
        }
        return invokeCommon.intValue;
    }
}
