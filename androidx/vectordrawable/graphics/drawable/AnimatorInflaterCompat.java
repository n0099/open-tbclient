package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.annotation.AnimatorRes;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.mobads.container.util.AdIconUtil;
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
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class AnimatorInflaterCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DBG_ANIMATOR_INFLATER = false;
    public static final int MAX_NUM_POINTS = 100;
    public static final String TAG = "AnimatorInflater";
    public static final int TOGETHER = 0;
    public static final int VALUE_TYPE_COLOR = 3;
    public static final int VALUE_TYPE_FLOAT = 0;
    public static final int VALUE_TYPE_INT = 1;
    public static final int VALUE_TYPE_PATH = 2;
    public static final int VALUE_TYPE_UNDEFINED = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PathParser.PathDataNode[] mNodeArray;

        public PathDataEvaluator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public PathDataEvaluator(PathParser.PathDataNode[] pathDataNodeArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pathDataNodeArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mNodeArray = pathDataNodeArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        public PathParser.PathDataNode[] evaluate(float f2, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), pathDataNodeArr, pathDataNodeArr2})) == null) {
                if (PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
                    if (!PathParser.canMorph(this.mNodeArray, pathDataNodeArr)) {
                        this.mNodeArray = PathParser.deepCopyNodes(pathDataNodeArr);
                    }
                    for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
                        this.mNodeArray[i2].interpolatePathDataNode(pathDataNodeArr[i2], pathDataNodeArr2[i2], f2);
                    }
                    return this.mNodeArray;
                }
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            return (PathParser.PathDataNode[]) invokeCommon.objValue;
        }
    }

    public AnimatorInflaterCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f2) throws XmlPullParserException, IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, resources, theme, xmlPullParser, Float.valueOf(f2)})) == null) ? createAnimatorFromXml(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f2) : (Animator) invokeCommon.objValue;
    }

    public static Keyframe createNewKeyframe(Keyframe keyframe, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, keyframe, f2)) == null) {
            if (keyframe.getType() == Float.TYPE) {
                return Keyframe.ofFloat(f2);
            }
            if (keyframe.getType() == Integer.TYPE) {
                return Keyframe.ofInt(f2);
            }
            return Keyframe.ofObject(f2);
        }
        return (Keyframe) invokeLF.objValue;
    }

    public static void distributeKeyframes(Keyframe[] keyframeArr, float f2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{keyframeArr, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            float f3 = f2 / ((i3 - i2) + 2);
            while (i2 <= i3) {
                keyframeArr[i2].setFraction(keyframeArr[i2 - 1].getFraction() + f3);
                i2++;
            }
        }
    }

    public static void dumpKeyframes(Object[] objArr, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, objArr, str) == null) || objArr == null || objArr.length == 0) {
            return;
        }
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Keyframe keyframe = (Keyframe) objArr[i2];
            StringBuilder sb = new StringBuilder();
            sb.append("Keyframe ");
            sb.append(i2);
            sb.append(": fraction ");
            float fraction = keyframe.getFraction();
            Object obj = StringUtil.NULL_STRING;
            sb.append(fraction < 0.0f ? StringUtil.NULL_STRING : Float.valueOf(keyframe.getFraction()));
            sb.append(", , value : ");
            if (keyframe.hasValue()) {
                obj = keyframe.getValue();
            }
            sb.append(obj);
            sb.toString();
        }
    }

    public static PropertyValuesHolder getPVH(TypedArray typedArray, int i2, int i3, int i4, String str) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        int i7;
        float f2;
        PropertyValuesHolder ofFloat;
        float f3;
        float f4;
        PropertyValuesHolder ofObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{typedArray, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str})) == null) {
            TypedValue peekValue = typedArray.peekValue(i3);
            boolean z = peekValue != null;
            int i8 = z ? peekValue.type : 0;
            TypedValue peekValue2 = typedArray.peekValue(i4);
            boolean z2 = peekValue2 != null;
            int i9 = z2 ? peekValue2.type : 0;
            if (i2 == 4) {
                i2 = ((z && isColorType(i8)) || (z2 && isColorType(i9))) ? 3 : 0;
            }
            boolean z3 = i2 == 0;
            PropertyValuesHolder propertyValuesHolder = null;
            if (i2 == 2) {
                String string = typedArray.getString(i3);
                String string2 = typedArray.getString(i4);
                PathParser.PathDataNode[] createNodesFromPathData = PathParser.createNodesFromPathData(string);
                PathParser.PathDataNode[] createNodesFromPathData2 = PathParser.createNodesFromPathData(string2);
                if (createNodesFromPathData == null && createNodesFromPathData2 == null) {
                    return null;
                }
                if (createNodesFromPathData == null) {
                    if (createNodesFromPathData2 != null) {
                        return PropertyValuesHolder.ofObject(str, new PathDataEvaluator(), createNodesFromPathData2);
                    }
                    return null;
                }
                PathDataEvaluator pathDataEvaluator = new PathDataEvaluator();
                if (createNodesFromPathData2 != null) {
                    if (PathParser.canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                        ofObject = PropertyValuesHolder.ofObject(str, pathDataEvaluator, createNodesFromPathData, createNodesFromPathData2);
                    } else {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                } else {
                    ofObject = PropertyValuesHolder.ofObject(str, pathDataEvaluator, createNodesFromPathData);
                }
                return ofObject;
            }
            ArgbEvaluator argbEvaluator = i2 == 3 ? ArgbEvaluator.getInstance() : null;
            if (z3) {
                if (z) {
                    if (i8 == 5) {
                        f3 = typedArray.getDimension(i3, 0.0f);
                    } else {
                        f3 = typedArray.getFloat(i3, 0.0f);
                    }
                    if (z2) {
                        if (i9 == 5) {
                            f4 = typedArray.getDimension(i4, 0.0f);
                        } else {
                            f4 = typedArray.getFloat(i4, 0.0f);
                        }
                        ofFloat = PropertyValuesHolder.ofFloat(str, f3, f4);
                    } else {
                        ofFloat = PropertyValuesHolder.ofFloat(str, f3);
                    }
                } else {
                    if (i9 == 5) {
                        f2 = typedArray.getDimension(i4, 0.0f);
                    } else {
                        f2 = typedArray.getFloat(i4, 0.0f);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, f2);
                }
                propertyValuesHolder = ofFloat;
            } else if (z) {
                if (i8 == 5) {
                    i6 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (isColorType(i8)) {
                    i6 = typedArray.getColor(i3, 0);
                } else {
                    i6 = typedArray.getInt(i3, 0);
                }
                if (z2) {
                    if (i9 == 5) {
                        i7 = (int) typedArray.getDimension(i4, 0.0f);
                    } else if (isColorType(i9)) {
                        i7 = typedArray.getColor(i4, 0);
                    } else {
                        i7 = typedArray.getInt(i4, 0);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, i6, i7);
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, i6);
                }
            } else if (z2) {
                if (i9 == 5) {
                    i5 = (int) typedArray.getDimension(i4, 0.0f);
                } else if (isColorType(i9)) {
                    i5 = typedArray.getColor(i4, 0);
                } else {
                    i5 = typedArray.getInt(i4, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5);
            }
            if (propertyValuesHolder == null || argbEvaluator == null) {
                return propertyValuesHolder;
            }
            propertyValuesHolder.setEvaluator(argbEvaluator);
            return propertyValuesHolder;
        }
        return (PropertyValuesHolder) invokeCommon.objValue;
    }

    public static int inferValueTypeFromValues(TypedArray typedArray, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, typedArray, i2, i3)) == null) {
            TypedValue peekValue = typedArray.peekValue(i2);
            boolean z = peekValue != null;
            int i4 = z ? peekValue.type : 0;
            TypedValue peekValue2 = typedArray.peekValue(i3);
            boolean z2 = peekValue2 != null;
            return ((z && isColorType(i4)) || (z2 && isColorType(z2 ? peekValue2.type : 0))) ? 3 : 0;
        }
        return invokeLII.intValue;
    }

    public static int inferValueTypeOfKeyframe(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, resources, theme, attributeSet, xmlPullParser)) == null) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_KEYFRAME);
            int i2 = 0;
            TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
            if ((peekNamedValue != null) && isColorType(peekNamedValue.type)) {
                i2 = 3;
            }
            obtainAttributes.recycle();
            return i2;
        }
        return invokeLLLL.intValue;
    }

    public static boolean isColorType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? i2 >= 28 && i2 <= 31 : invokeI.booleanValue;
    }

    public static Animator loadAnimator(Context context, @AnimatorRes int i2) throws Resources.NotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, context, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return AnimatorInflater.loadAnimator(context, i2);
            }
            return loadAnimator(context, context.getResources(), context.getTheme(), i2);
        }
        return (Animator) invokeLI.objValue;
    }

    public static Keyframe loadKeyframe(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i2, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        InterceptResult invokeCommon;
        Keyframe ofInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{context, resources, theme, attributeSet, Integer.valueOf(i2), xmlPullParser})) == null) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_KEYFRAME);
            float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "fraction", 3, -1.0f);
            TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
            boolean z = peekNamedValue != null;
            if (i2 == 4) {
                i2 = (z && isColorType(peekNamedValue.type)) ? 3 : 0;
            }
            if (z) {
                if (i2 != 0) {
                    ofInt = (i2 == 1 || i2 == 3) ? Keyframe.ofInt(namedFloat, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "value", 0, 0)) : null;
                } else {
                    ofInt = Keyframe.ofFloat(namedFloat, TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "value", 0, 0.0f));
                }
            } else if (i2 == 0) {
                ofInt = Keyframe.ofFloat(namedFloat);
            } else {
                ofInt = Keyframe.ofInt(namedFloat);
            }
            int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 1, 0);
            if (namedResourceId > 0) {
                ofInt.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
            }
            obtainAttributes.recycle();
            return ofInt;
        }
        return (Keyframe) invokeCommon.objValue;
    }

    public static ObjectAnimator loadObjectAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{context, resources, theme, attributeSet, Float.valueOf(f2), xmlPullParser})) == null) {
            ObjectAnimator objectAnimator = new ObjectAnimator();
            loadAnimator(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
            return objectAnimator;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public static PropertyValuesHolder loadPvh(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i2) throws XmlPullParserException, IOException {
        InterceptResult invokeCommon;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, resources, theme, xmlPullParser, str, Integer.valueOf(i2)})) == null) {
            PropertyValuesHolder propertyValuesHolder = null;
            ArrayList arrayList = null;
            while (true) {
                int next = xmlPullParser.next();
                if (next == 3 || next == 1) {
                    break;
                } else if (xmlPullParser.getName().equals("keyframe")) {
                    if (i2 == 4) {
                        i2 = inferValueTypeOfKeyframe(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                    }
                    Keyframe loadKeyframe = loadKeyframe(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i2, xmlPullParser);
                    if (loadKeyframe != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(loadKeyframe);
                    }
                    xmlPullParser.next();
                }
            }
            if (arrayList != null && (size = arrayList.size()) > 0) {
                Keyframe keyframe = (Keyframe) arrayList.get(0);
                Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
                float fraction = keyframe2.getFraction();
                if (fraction < 1.0f) {
                    if (fraction < 0.0f) {
                        keyframe2.setFraction(1.0f);
                    } else {
                        arrayList.add(arrayList.size(), createNewKeyframe(keyframe2, 1.0f));
                        size++;
                    }
                }
                float fraction2 = keyframe.getFraction();
                if (fraction2 != 0.0f) {
                    if (fraction2 < 0.0f) {
                        keyframe.setFraction(0.0f);
                    } else {
                        arrayList.add(0, createNewKeyframe(keyframe, 0.0f));
                        size++;
                    }
                }
                Keyframe[] keyframeArr = new Keyframe[size];
                arrayList.toArray(keyframeArr);
                for (int i3 = 0; i3 < size; i3++) {
                    Keyframe keyframe3 = keyframeArr[i3];
                    if (keyframe3.getFraction() < 0.0f) {
                        if (i3 == 0) {
                            keyframe3.setFraction(0.0f);
                        } else {
                            int i4 = size - 1;
                            if (i3 == i4) {
                                keyframe3.setFraction(1.0f);
                            } else {
                                int i5 = i3;
                                for (int i6 = i3 + 1; i6 < i4 && keyframeArr[i6].getFraction() < 0.0f; i6++) {
                                    i5 = i6;
                                }
                                distributeKeyframes(keyframeArr, keyframeArr[i5 + 1].getFraction() - keyframeArr[i3 - 1].getFraction(), i3, i5);
                            }
                        }
                    }
                }
                propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                if (i2 == 3) {
                    propertyValuesHolder.setEvaluator(ArgbEvaluator.getInstance());
                }
            }
            return propertyValuesHolder;
        }
        return (PropertyValuesHolder) invokeCommon.objValue;
    }

    public static PropertyValuesHolder[] loadValues(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        InterceptResult invokeLLLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65553, null, context, resources, theme, xmlPullParser, attributeSet)) == null) {
            PropertyValuesHolder[] propertyValuesHolderArr = null;
            ArrayList arrayList = null;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 3 || eventType == 1) {
                    break;
                } else if (eventType != 2) {
                    xmlPullParser.next();
                } else {
                    if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
                        String namedString = TypedArrayUtils.getNamedString(obtainAttributes, xmlPullParser, "propertyName", 3);
                        int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "valueType", 2, 4);
                        PropertyValuesHolder loadPvh = loadPvh(context, resources, theme, xmlPullParser, namedString, namedInt);
                        if (loadPvh == null) {
                            loadPvh = getPVH(obtainAttributes, namedInt, 0, 1, namedString);
                        }
                        if (loadPvh != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(loadPvh);
                        }
                        obtainAttributes.recycle();
                    }
                    xmlPullParser.next();
                }
            }
            if (arrayList != null) {
                int size = arrayList.size();
                propertyValuesHolderArr = new PropertyValuesHolder[size];
                for (i2 = 0; i2 < size; i2++) {
                    propertyValuesHolderArr[i2] = (PropertyValuesHolder) arrayList.get(i2);
                }
            }
            return propertyValuesHolderArr;
        }
        return (PropertyValuesHolder[]) invokeLLLLL.objValue;
    }

    public static void parseAnimatorFromTypeArray(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f2, XmlPullParser xmlPullParser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{valueAnimator, typedArray, typedArray2, Float.valueOf(f2), xmlPullParser}) == null) {
            long namedInt = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "duration", 1, 300);
            long namedInt2 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "startOffset", 2, 0);
            int namedInt3 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "valueType", 7, 4);
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "valueFrom") && TypedArrayUtils.hasAttribute(xmlPullParser, "valueTo")) {
                if (namedInt3 == 4) {
                    namedInt3 = inferValueTypeFromValues(typedArray, 5, 6);
                }
                PropertyValuesHolder pvh = getPVH(typedArray, namedInt3, 5, 6, "");
                if (pvh != null) {
                    valueAnimator.setValues(pvh);
                }
            }
            valueAnimator.setDuration(namedInt);
            valueAnimator.setStartDelay(namedInt2);
            valueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatCount", 3, 0));
            valueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatMode", 4, 1));
            if (typedArray2 != null) {
                setupObjectAnimator(valueAnimator, typedArray2, namedInt3, f2, xmlPullParser);
            }
        }
    }

    public static void setupObjectAnimator(ValueAnimator valueAnimator, TypedArray typedArray, int i2, float f2, XmlPullParser xmlPullParser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{valueAnimator, typedArray, Integer.valueOf(i2), Float.valueOf(f2), xmlPullParser}) == null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
            String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 1);
            if (namedString != null) {
                String namedString2 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyXName", 2);
                String namedString3 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyYName", 3);
                if (i2 != 2) {
                }
                if (namedString2 == null && namedString3 == null) {
                    throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                setupPathMotion(PathParser.createPathFromPathData(namedString), objectAnimator, f2 * 0.5f, namedString2, namedString3);
                return;
            }
            objectAnimator.setPropertyName(TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyName", 0));
        }
    }

    public static void setupPathMotion(Path path, ObjectAnimator objectAnimator, float f2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{path, objectAnimator, Float.valueOf(f2), str, str2}) == null) {
            PathMeasure pathMeasure = new PathMeasure(path, false);
            ArrayList arrayList = new ArrayList();
            float f3 = 0.0f;
            arrayList.add(Float.valueOf(0.0f));
            float f4 = 0.0f;
            do {
                f4 += pathMeasure.getLength();
                arrayList.add(Float.valueOf(f4));
            } while (pathMeasure.nextContour());
            PathMeasure pathMeasure2 = new PathMeasure(path, false);
            int min = Math.min(100, ((int) (f4 / f2)) + 1);
            float[] fArr = new float[min];
            float[] fArr2 = new float[min];
            float[] fArr3 = new float[2];
            float f5 = f4 / (min - 1);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= min) {
                    break;
                }
                pathMeasure2.getPosTan(f3 - ((Float) arrayList.get(i3)).floatValue(), fArr3, null);
                fArr[i2] = fArr3[0];
                fArr2[i2] = fArr3[1];
                f3 += f5;
                int i4 = i3 + 1;
                if (i4 < arrayList.size() && f3 > ((Float) arrayList.get(i4)).floatValue()) {
                    pathMeasure2.nextContour();
                    i3 = i4;
                }
                i2++;
            }
            PropertyValuesHolder ofFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
            PropertyValuesHolder ofFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
            if (ofFloat == null) {
                objectAnimator.setValues(ofFloat2);
            } else if (ofFloat2 == null) {
                objectAnimator.setValues(ofFloat);
            } else {
                objectAnimator.setValues(ofFloat, ofFloat2);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: android.animation.AnimatorSet */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i2, float f2) throws XmlPullParserException, IOException {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, resources, theme, xmlPullParser, attributeSet, animatorSet, Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            int depth = xmlPullParser.getDepth();
            ValueAnimator valueAnimator = null;
            ArrayList arrayList = null;
            while (true) {
                int next = xmlPullParser.next();
                i3 = 0;
                if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                    if (next == 2) {
                        String name = xmlPullParser.getName();
                        if (name.equals("objectAnimator")) {
                            valueAnimator = loadObjectAnimator(context, resources, theme, attributeSet, f2, xmlPullParser);
                        } else if (name.equals(ShaderParams.VALUE_TYPE_ANIMATOR)) {
                            valueAnimator = loadAnimator(context, resources, theme, attributeSet, null, f2, xmlPullParser);
                        } else {
                            if (name.equals("set")) {
                                AnimatorSet animatorSet2 = new AnimatorSet();
                                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATOR_SET);
                                createAnimatorFromXml(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "ordering", 0, 0), f2);
                                obtainAttributes.recycle();
                                valueAnimator = animatorSet2;
                            } else if (name.equals("propertyValuesHolder")) {
                                PropertyValuesHolder[] loadValues = loadValues(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                                if (loadValues != null && (valueAnimator instanceof ValueAnimator)) {
                                    valueAnimator.setValues(loadValues);
                                }
                                i3 = 1;
                            } else {
                                throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                            }
                            if (animatorSet != null && i3 == 0) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(valueAnimator);
                            }
                        }
                        if (animatorSet != null) {
                            if (arrayList == null) {
                            }
                            arrayList.add(valueAnimator);
                        }
                    }
                }
            }
            if (animatorSet != null && arrayList != null) {
                Animator[] animatorArr = new Animator[arrayList.size()];
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    animatorArr[i3] = (Animator) it.next();
                    i3++;
                }
                if (i2 == 0) {
                    animatorSet.playTogether(animatorArr);
                } else {
                    animatorSet.playSequentially(animatorArr);
                }
            }
            return valueAnimator;
        }
        return (Animator) invokeCommon.objValue;
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, @AnimatorRes int i2) throws Resources.NotFoundException {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65547, null, context, resources, theme, i2)) == null) ? loadAnimator(context, resources, theme, i2, 1.0f) : (Animator) invokeLLLI.objValue;
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, @AnimatorRes int i2, float f2) throws Resources.NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{context, resources, theme, Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            XmlResourceParser xmlResourceParser = null;
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i2);
                    return createAnimatorFromXml(context, resources, theme, xmlResourceParser, f2);
                } catch (IOException e2) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                    notFoundException.initCause(e2);
                    throw notFoundException;
                } catch (XmlPullParserException e3) {
                    Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                    notFoundException2.initCause(e3);
                    throw notFoundException2;
                }
            } finally {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        }
        return (Animator) invokeCommon.objValue;
    }

    public static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, resources, theme, attributeSet, valueAnimator, Float.valueOf(f2), xmlPullParser})) == null) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATOR);
            TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
            if (valueAnimator == null) {
                valueAnimator = new ValueAnimator();
            }
            parseAnimatorFromTypeArray(valueAnimator, obtainAttributes, obtainAttributes2, f2, xmlPullParser);
            int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 0, 0);
            if (namedResourceId > 0) {
                valueAnimator.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
            }
            obtainAttributes.recycle();
            if (obtainAttributes2 != null) {
                obtainAttributes2.recycle();
            }
            return valueAnimator;
        }
        return (ValueAnimator) invokeCommon.objValue;
    }
}
