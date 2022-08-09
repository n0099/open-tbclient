package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mVariants = new ArrayList<>();
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R$styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
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

        public int findMatch(float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
                for (int i = 0; i < this.mVariants.size(); i++) {
                    if (this.mVariants.get(i).match(f, f2)) {
                        return i;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean match(float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (Float.isNaN(this.mMinWidth) || f >= this.mMinWidth) {
                    if (Float.isNaN(this.mMinHeight) || f2 >= this.mMinHeight) {
                        if (Float.isNaN(this.mMaxWidth) || f <= this.mMaxWidth) {
                            return Float.isNaN(this.mMaxHeight) || f2 <= this.mMaxHeight;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.StateSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.StateSet_defaultState) {
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
                        char c = 65535;
                        switch (name.hashCode()) {
                            case 80204913:
                                if (name.equals("State")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 1301459538:
                                if (name.equals("LayoutDescription")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    c = 3;
                                    break;
                                }
                                break;
                        }
                        if (c != 0 && c != 1) {
                            if (c == 2) {
                                state = new State(context, xmlPullParser);
                                this.mStateList.put(state.mId, state);
                            } else if (c != 3) {
                                Log.v("ConstraintLayoutStates", "unknown tag " + name);
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
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
    }

    public int convertToConstraintSet(int i, int i2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)})) == null) {
            State state = this.mStateList.get(i2);
            if (state == null) {
                return i2;
            }
            if (f != -1.0f && f2 != -1.0f) {
                Variant variant = null;
                Iterator<Variant> it = state.mVariants.iterator();
                while (it.hasNext()) {
                    Variant next = it.next();
                    if (next.match(f, f2)) {
                        if (i == next.mConstraintID) {
                            return i;
                        }
                        variant = next;
                    }
                }
                if (variant != null) {
                    return variant.mConstraintID;
                }
                return state.mConstraintID;
            } else if (state.mConstraintID == i) {
                return i;
            } else {
                Iterator<Variant> it2 = state.mVariants.iterator();
                while (it2.hasNext()) {
                    if (i == it2.next().mConstraintID) {
                        return i;
                    }
                }
                return state.mConstraintID;
            }
        }
        return invokeCommon.intValue;
    }

    public boolean needsToChange(int i, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)})) == null) {
            int i2 = this.mCurrentStateId;
            if (i2 != i) {
                return true;
            }
            State valueAt = i == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i2);
            int i3 = this.mCurrentConstraintNumber;
            return (i3 == -1 || !valueAt.mVariants.get(i3).match(f, f2)) && this.mCurrentConstraintNumber != valueAt.findMatch(f, f2);
        }
        return invokeCommon.booleanValue;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, constraintsChangedListener) == null) {
            this.mConstraintsChangedListener = constraintsChangedListener;
        }
    }

    public int stateGetConstraintID(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(1048579, this, i, i2, i3)) == null) ? updateConstraints(-1, i, i2, i3) : invokeIII.intValue;
    }

    public int updateConstraints(int i, int i2, float f, float f2) {
        InterceptResult invokeCommon;
        State state;
        int findMatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (i != i2) {
                State state2 = this.mStateList.get(i2);
                if (state2 == null) {
                    return -1;
                }
                int findMatch2 = state2.findMatch(f, f2);
                return findMatch2 == -1 ? state2.mConstraintID : state2.mVariants.get(findMatch2).mConstraintID;
            }
            if (i2 == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(this.mCurrentStateId);
            }
            if (state == null) {
                return -1;
            }
            return ((this.mCurrentConstraintNumber == -1 || !state.mVariants.get(i).match(f, f2)) && i != (findMatch = state.findMatch(f, f2))) ? findMatch == -1 ? state.mConstraintID : state.mVariants.get(findMatch).mConstraintID : i;
        }
        return invokeCommon.intValue;
    }
}
