package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class ConstraintAttribute {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TransitionLayout";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mBooleanValue;
    public int mColorValue;
    public float mFloatValue;
    public int mIntegerValue;
    public String mName;
    public String mStringValue;
    public AttributeType mType;

    /* renamed from: androidx.constraintlayout.widget.ConstraintAttribute$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1804600244, "Landroidx/constraintlayout/widget/ConstraintAttribute$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1804600244, "Landroidx/constraintlayout/widget/ConstraintAttribute$1;");
                    return;
                }
            }
            int[] iArr = new int[AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = iArr;
            try {
                iArr[AttributeType.COLOR_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.INT_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.FLOAT_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.STRING_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.BOOLEAN_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.DIMENSION_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class AttributeType {
        public static final /* synthetic */ AttributeType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AttributeType BOOLEAN_TYPE;
        public static final AttributeType COLOR_DRAWABLE_TYPE;
        public static final AttributeType COLOR_TYPE;
        public static final AttributeType DIMENSION_TYPE;
        public static final AttributeType FLOAT_TYPE;
        public static final AttributeType INT_TYPE;
        public static final AttributeType STRING_TYPE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1247518279, "Landroidx/constraintlayout/widget/ConstraintAttribute$AttributeType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1247518279, "Landroidx/constraintlayout/widget/ConstraintAttribute$AttributeType;");
                    return;
                }
            }
            INT_TYPE = new AttributeType("INT_TYPE", 0);
            FLOAT_TYPE = new AttributeType("FLOAT_TYPE", 1);
            COLOR_TYPE = new AttributeType("COLOR_TYPE", 2);
            COLOR_DRAWABLE_TYPE = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            STRING_TYPE = new AttributeType("STRING_TYPE", 4);
            BOOLEAN_TYPE = new AttributeType("BOOLEAN_TYPE", 5);
            AttributeType attributeType = new AttributeType("DIMENSION_TYPE", 6);
            DIMENSION_TYPE = attributeType;
            $VALUES = new AttributeType[]{INT_TYPE, FLOAT_TYPE, COLOR_TYPE, COLOR_DRAWABLE_TYPE, STRING_TYPE, BOOLEAN_TYPE, attributeType};
        }

        public AttributeType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AttributeType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AttributeType) Enum.valueOf(AttributeType.class, str) : (AttributeType) invokeL.objValue;
        }

        public static AttributeType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AttributeType[]) $VALUES.clone() : (AttributeType[]) invokeV.objValue;
        }
    }

    public ConstraintAttribute(String str, AttributeType attributeType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, attributeType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mName = str;
        this.mType = attributeType;
    }

    public static int clamp(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            int i3 = (i2 & (~(i2 >> 31))) + UIMsg.m_AppUI.V_WM_ADDLISTUPDATE;
            return (i3 & (i3 >> 31)) + 255;
        }
        return invokeI.intValue;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> hashMap, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hashMap, view)) == null) {
            HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
            Class<?> cls = view.getClass();
            for (String str : hashMap.keySet()) {
                ConstraintAttribute constraintAttribute = hashMap.get(str);
                try {
                    if (str.equals("BackgroundColor")) {
                        hashMap2.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                    } else {
                        hashMap2.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, new Class[0]).invoke(view, new Object[0])));
                    }
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
            }
            return hashMap2;
        }
        return (HashMap) invokeLL.objValue;
    }

    public static void parse(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        AttributeType attributeType;
        Object string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, xmlPullParser, hashMap) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.CustomAttribute);
            int indexCount = obtainStyledAttributes.getIndexCount();
            String str = null;
            Object obj = null;
            AttributeType attributeType2 = null;
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.CustomAttribute_attributeName) {
                    str = obtainStyledAttributes.getString(index);
                    if (str != null && str.length() > 0) {
                        str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                    }
                } else if (index == R.styleable.CustomAttribute_customBoolean) {
                    obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                    attributeType2 = AttributeType.BOOLEAN_TYPE;
                } else {
                    if (index == R.styleable.CustomAttribute_customColorValue) {
                        attributeType = AttributeType.COLOR_TYPE;
                        string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                    } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                        attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                        string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                    } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                        attributeType = AttributeType.DIMENSION_TYPE;
                        string = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                    } else if (index == R.styleable.CustomAttribute_customDimension) {
                        attributeType = AttributeType.DIMENSION_TYPE;
                        string = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                    } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                        attributeType = AttributeType.FLOAT_TYPE;
                        string = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                    } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                        attributeType = AttributeType.INT_TYPE;
                        string = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                    } else if (index == R.styleable.CustomAttribute_customStringValue) {
                        attributeType = AttributeType.STRING_TYPE;
                        string = obtainStyledAttributes.getString(index);
                    }
                    Object obj2 = string;
                    attributeType2 = attributeType;
                    obj = obj2;
                }
            }
            if (str != null && obj != null) {
                hashMap.put(str, new ConstraintAttribute(str, attributeType2, obj));
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static void setAttributes(View view, HashMap<String, ConstraintAttribute> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, view, hashMap) == null) {
            Class<?> cls = view.getClass();
            for (String str : hashMap.keySet()) {
                ConstraintAttribute constraintAttribute = hashMap.get(str);
                String str2 = "set" + str;
                try {
                    switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[constraintAttribute.mType.ordinal()]) {
                        case 1:
                            cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.mColorValue));
                            break;
                        case 2:
                            Method method = cls.getMethod(str2, Drawable.class);
                            ColorDrawable colorDrawable = new ColorDrawable();
                            colorDrawable.setColor(constraintAttribute.mColorValue);
                            method.invoke(view, colorDrawable);
                            break;
                        case 3:
                            cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.mIntegerValue));
                            break;
                        case 4:
                            cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.mFloatValue));
                            break;
                        case 5:
                            cls.getMethod(str2, CharSequence.class).invoke(view, constraintAttribute.mStringValue);
                            break;
                        case 6:
                            cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.mBooleanValue));
                            break;
                        case 7:
                            cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.mFloatValue));
                            break;
                    }
                } catch (IllegalAccessException e2) {
                    String str3 = " Custom Attribute \"" + str + "\" not found on " + cls.getName();
                    e2.printStackTrace();
                } catch (NoSuchMethodException e3) {
                    e3.getMessage();
                    String str4 = " Custom Attribute \"" + str + "\" not found on " + cls.getName();
                    String str5 = cls.getName() + " must have a method " + str2;
                } catch (InvocationTargetException e4) {
                    String str6 = " Custom Attribute \"" + str + "\" not found on " + cls.getName();
                    e4.printStackTrace();
                }
            }
        }
    }

    public boolean diff(ConstraintAttribute constraintAttribute) {
        InterceptResult invokeL;
        AttributeType attributeType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, constraintAttribute)) == null) {
            if (constraintAttribute == null || (attributeType = this.mType) != constraintAttribute.mType) {
                return false;
            }
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[attributeType.ordinal()]) {
                case 1:
                case 2:
                    return this.mColorValue == constraintAttribute.mColorValue;
                case 3:
                    return this.mIntegerValue == constraintAttribute.mIntegerValue;
                case 4:
                    return this.mFloatValue == constraintAttribute.mFloatValue;
                case 5:
                    return this.mIntegerValue == constraintAttribute.mIntegerValue;
                case 6:
                    return this.mBooleanValue == constraintAttribute.mBooleanValue;
                case 7:
                    return this.mFloatValue == constraintAttribute.mFloatValue;
                default:
                    return false;
            }
        }
        return invokeL.booleanValue;
    }

    public AttributeType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mType : (AttributeType) invokeV.objValue;
    }

    public float getValueToInterpolate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
                case 1:
                case 2:
                    throw new RuntimeException("Color does not have a single color to interpolate");
                case 3:
                    return this.mIntegerValue;
                case 4:
                    return this.mFloatValue;
                case 5:
                    throw new RuntimeException("Cannot interpolate String");
                case 6:
                    return this.mBooleanValue ? 1.0f : 0.0f;
                case 7:
                    return this.mFloatValue;
                default:
                    return Float.NaN;
            }
        }
        return invokeV.floatValue;
    }

    public void getValuesToInterpolate(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fArr) == null) {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
                case 1:
                case 2:
                    int i2 = this.mColorValue;
                    float pow = (float) Math.pow(((i2 >> 16) & 255) / 255.0f, 2.2d);
                    float pow2 = (float) Math.pow(((i2 >> 8) & 255) / 255.0f, 2.2d);
                    fArr[0] = pow;
                    fArr[1] = pow2;
                    fArr[2] = (float) Math.pow((i2 & 255) / 255.0f, 2.2d);
                    fArr[3] = ((i2 >> 24) & 255) / 255.0f;
                    return;
                case 3:
                    fArr[0] = this.mIntegerValue;
                    return;
                case 4:
                    fArr[0] = this.mFloatValue;
                    return;
                case 5:
                    throw new RuntimeException("Color does not have a single color to interpolate");
                case 6:
                    fArr[0] = this.mBooleanValue ? 1.0f : 0.0f;
                    return;
                case 7:
                    fArr[0] = this.mFloatValue;
                    return;
                default:
                    return;
            }
        }
    }

    public int noOfInterpValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
            return (i2 == 1 || i2 == 2) ? 4 : 1;
        }
        return invokeV.intValue;
    }

    public void setColorValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mColorValue = i2;
        }
    }

    public void setFloatValue(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.mFloatValue = f2;
        }
    }

    public void setIntValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mIntegerValue = i2;
        }
    }

    public void setInterpolatedValue(View view, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, fArr) == null) {
            Class<?> cls = view.getClass();
            String str = "set" + this.mName;
            try {
                boolean z = true;
                switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
                    case 1:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf((clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                        return;
                    case 2:
                        Method method = cls.getMethod(str, Drawable.class);
                        int clamp = clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f));
                        int clamp2 = clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f));
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor((clamp << 16) | (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp2 << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                        method.invoke(view, colorDrawable);
                        return;
                    case 3:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf((int) fArr[0]));
                        return;
                    case 4:
                        cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                        return;
                    case 5:
                        throw new RuntimeException("unable to interpolate strings " + this.mName);
                    case 6:
                        Method method2 = cls.getMethod(str, Boolean.TYPE);
                        Object[] objArr = new Object[1];
                        if (fArr[0] <= 0.5f) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        method2.invoke(view, objArr);
                        return;
                    case 7:
                        cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e2) {
                String str2 = "cannot access method " + str + "on View \"" + Debug.getName(view) + "\"";
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                String str3 = "no method " + str + "on View \"" + Debug.getName(view) + "\"";
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void setStringValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mStringValue = str;
        }
    }

    public void setValue(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fArr) == null) {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
                case 1:
                case 2:
                    int HSVToColor = Color.HSVToColor(fArr);
                    this.mColorValue = HSVToColor;
                    this.mColorValue = (clamp((int) (fArr[3] * 255.0f)) << 24) | (HSVToColor & 16777215);
                    return;
                case 3:
                    this.mIntegerValue = (int) fArr[0];
                    return;
                case 4:
                    this.mFloatValue = fArr[0];
                    return;
                case 5:
                    throw new RuntimeException("Color does not have a single color to interpolate");
                case 6:
                    this.mBooleanValue = ((double) fArr[0]) > 0.5d;
                    return;
                case 7:
                    this.mFloatValue = fArr[0];
                    return;
                default:
                    return;
            }
        }
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, attributeType, obj};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mName = str;
        this.mType = attributeType;
        setValue(obj);
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {constraintAttribute, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mName = constraintAttribute.mName;
        this.mType = constraintAttribute.mType;
        setValue(obj);
    }

    public void setValue(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, obj) == null) {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
                case 1:
                case 2:
                    this.mColorValue = ((Integer) obj).intValue();
                    return;
                case 3:
                    this.mIntegerValue = ((Integer) obj).intValue();
                    return;
                case 4:
                    this.mFloatValue = ((Float) obj).floatValue();
                    return;
                case 5:
                    this.mStringValue = (String) obj;
                    return;
                case 6:
                    this.mBooleanValue = ((Boolean) obj).booleanValue();
                    return;
                case 7:
                    this.mFloatValue = ((Float) obj).floatValue();
                    return;
                default:
                    return;
            }
        }
    }
}
