package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class ConstraintLayoutStates {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    public transient /* synthetic */ FieldHolder $fh;
    public final ConstraintLayout mConstraintLayout;
    public SparseArray<ConstraintSet> mConstraintSetMap;
    public ConstraintsChangedListener mConstraintsChangedListener;
    public int mCurrentConstraintNumber;
    public int mCurrentStateId;
    public ConstraintSet mDefaultConstraintSet;
    public SparseArray<State> mStateList;

    /* loaded from: classes.dex */
    public static class State {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mConstraintID;
        public ConstraintSet mConstraintSet;
        public int mId;
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
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
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
        public ConstraintSet mConstraintSet;
        public int mId;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
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

    public ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, constraintLayout, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray<>();
        this.mConstraintSetMap = new SparseArray<>();
        this.mConstraintsChangedListener = null;
        this.mConstraintLayout = constraintLayout;
        load(context, i2);
    }

    private void load(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, this, context, i2) == null) {
            XmlResourceParser xml = context.getResources().getXml(i2);
            State state = null;
            try {
                for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                    if (eventType == 0) {
                        xml.getName();
                        continue;
                    } else if (eventType != 2) {
                        continue;
                    } else {
                        String name = xml.getName();
                        char c2 = 65535;
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals(ConstraintSet.TAG)) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 80204913:
                                if (name.equals("State")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 1657696882:
                                if (name.equals("layoutDescription")) {
                                    c2 = 0;
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
                                state = new State(context, xml);
                                this.mStateList.put(state.mId, state);
                                continue;
                            } else if (c2 == 3) {
                                Variant variant = new Variant(context, xml);
                                if (state != null) {
                                    state.add(variant);
                                    continue;
                                } else {
                                    continue;
                                }
                            } else if (c2 != 4) {
                                String str = "unknown tag " + name;
                                continue;
                            } else {
                                parseConstraintSet(context, xml);
                                continue;
                            }
                        }
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (XmlPullParserException e3) {
                e3.printStackTrace();
            }
        }
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, xmlPullParser) == null) {
            ConstraintSet constraintSet = new ConstraintSet();
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i2 = 0; i2 < attributeCount; i2++) {
                if ("id".equals(xmlPullParser.getAttributeName(i2))) {
                    String attributeValue = xmlPullParser.getAttributeValue(i2);
                    int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                    if (identifier == -1 && attributeValue != null && attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    }
                    constraintSet.load(context, xmlPullParser);
                    this.mConstraintSetMap.put(identifier, constraintSet);
                    return;
                }
            }
        }
    }

    public boolean needsToChange(int i2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
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
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, constraintsChangedListener) == null) {
            this.mConstraintsChangedListener = constraintsChangedListener;
        }
    }

    public void updateConstraints(int i2, float f2, float f3) {
        ConstraintSet constraintSet;
        int i3;
        State state;
        int findMatch;
        ConstraintSet constraintSet2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            int i5 = this.mCurrentStateId;
            if (i5 == i2) {
                if (i2 == -1) {
                    state = this.mStateList.valueAt(0);
                } else {
                    state = this.mStateList.get(i5);
                }
                int i6 = this.mCurrentConstraintNumber;
                if ((i6 == -1 || !state.mVariants.get(i6).match(f2, f3)) && this.mCurrentConstraintNumber != (findMatch = state.findMatch(f2, f3))) {
                    if (findMatch == -1) {
                        constraintSet2 = this.mDefaultConstraintSet;
                    } else {
                        constraintSet2 = state.mVariants.get(findMatch).mConstraintSet;
                    }
                    if (findMatch == -1) {
                        i4 = state.mConstraintID;
                    } else {
                        i4 = state.mVariants.get(findMatch).mConstraintID;
                    }
                    if (constraintSet2 == null) {
                        return;
                    }
                    this.mCurrentConstraintNumber = findMatch;
                    ConstraintsChangedListener constraintsChangedListener = this.mConstraintsChangedListener;
                    if (constraintsChangedListener != null) {
                        constraintsChangedListener.preLayoutChange(-1, i4);
                    }
                    constraintSet2.applyTo(this.mConstraintLayout);
                    ConstraintsChangedListener constraintsChangedListener2 = this.mConstraintsChangedListener;
                    if (constraintsChangedListener2 != null) {
                        constraintsChangedListener2.postLayoutChange(-1, i4);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mCurrentStateId = i2;
            State state2 = this.mStateList.get(i2);
            int findMatch2 = state2.findMatch(f2, f3);
            if (findMatch2 == -1) {
                constraintSet = state2.mConstraintSet;
            } else {
                constraintSet = state2.mVariants.get(findMatch2).mConstraintSet;
            }
            if (findMatch2 == -1) {
                i3 = state2.mConstraintID;
            } else {
                i3 = state2.mVariants.get(findMatch2).mConstraintID;
            }
            if (constraintSet == null) {
                String str = "NO Constraint set found ! id=" + i2 + ", dim =" + f2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f3;
                return;
            }
            this.mCurrentConstraintNumber = findMatch2;
            ConstraintsChangedListener constraintsChangedListener3 = this.mConstraintsChangedListener;
            if (constraintsChangedListener3 != null) {
                constraintsChangedListener3.preLayoutChange(i2, i3);
            }
            constraintSet.applyTo(this.mConstraintLayout);
            ConstraintsChangedListener constraintsChangedListener4 = this.mConstraintsChangedListener;
            if (constraintsChangedListener4 != null) {
                constraintsChangedListener4.postLayoutChange(i2, i3);
            }
        }
    }
}
