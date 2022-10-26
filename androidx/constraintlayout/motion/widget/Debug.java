package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class Debug {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Debug() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams layoutParams, String str) {
        Field[] fields;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, layoutParams, str) == null) {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
            String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + str + GlideException.IndentedAppendable.INDENT;
            System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + str2 + GlideException.IndentedAppendable.INDENT + layoutParams.getClass().getName());
            for (Field field : layoutParams.getClass().getFields()) {
                try {
                    Object obj = field.get(layoutParams);
                    String name = field.getName();
                    if (name.contains("To") && !obj.toString().equals("-1")) {
                        System.out.println(str2 + "       " + name + " " + obj);
                    }
                } catch (IllegalAccessException unused) {
                }
            }
            System.out.println(" <<<<<<<<<<<<<<<<< dump " + str2);
        }
    }

    public static void dumpLayoutParams(ViewGroup viewGroup, String str) {
        Field[] fields;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, viewGroup, str) == null) {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
            String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + str + GlideException.IndentedAppendable.INDENT;
            int childCount = viewGroup.getChildCount();
            System.out.println(str + " children " + childCount);
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                System.out.println(str2 + "     " + getName(childAt));
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                for (Field field : layoutParams.getClass().getFields()) {
                    try {
                        Object obj = field.get(layoutParams);
                        if (field.getName().contains("To") && !obj.toString().equals("-1")) {
                            System.out.println(str2 + "       " + field.getName() + " " + obj);
                        }
                    } catch (IllegalAccessException unused) {
                    }
                }
            }
        }
    }

    public static void dumpPoc(Object obj) {
        Field[] fields;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, obj) == null) {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
            String str = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + SmallTailInfo.EMOTION_SUFFIX;
            Class<?> cls = obj.getClass();
            System.out.println(str + "------------- " + cls.getName() + " --------------------");
            for (Field field : cls.getFields()) {
                try {
                    Object obj2 = field.get(obj);
                    if (field.getName().startsWith("layout_constraint") && ((!(obj2 instanceof Integer) || !obj2.toString().equals("-1")) && ((!(obj2 instanceof Integer) || !obj2.toString().equals("0")) && ((!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) && (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")))))) {
                        System.out.println(str + "    " + field.getName() + " " + obj2);
                    }
                } catch (IllegalAccessException unused) {
                }
            }
            System.out.println(str + "------------- " + cls.getSimpleName() + " --------------------");
        }
    }

    public static String getActionType(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Field[] fields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, motionEvent)) == null) {
            int action = motionEvent.getAction();
            for (Field field : MotionEvent.class.getFields()) {
                try {
                    if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt(null) == action) {
                        return field.getName();
                    }
                } catch (IllegalAccessException unused) {
                }
            }
            return "---";
        }
        return (String) invokeL.objValue;
    }

    public static String getCallFrom(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i + 2];
            return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeI.objValue;
    }

    public static String getLoc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
            return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
        }
        return (String) invokeV.objValue;
    }

    public static String getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
            return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public static String getLocation2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
            return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public static String getName(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i)) == null) {
            if (i != -1) {
                try {
                    return context.getResources().getResourceEntryName(i);
                } catch (Exception unused) {
                    return "?" + i;
                }
            }
            return RomUtils.UNKNOWN;
        }
        return (String) invokeLI.objValue;
    }

    public static String getName(Context context, int[] iArr) {
        String str;
        String str2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, iArr)) == null) {
            try {
                String str3 = iArr.length + PreferencesUtil.LEFT_MOUNT;
                for (int i = 0; i < iArr.length; i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str3);
                    if (i != 0) {
                        str = " ";
                    } else {
                        str = "";
                    }
                    sb.append(str);
                    String sb2 = sb.toString();
                    try {
                        str2 = context.getResources().getResourceEntryName(iArr[i]);
                    } catch (Resources.NotFoundException unused) {
                        str2 = "? " + iArr[i] + " ";
                    }
                    str3 = sb2 + str2;
                }
                return str3 + PreferencesUtil.RIGHT_MOUNT;
            } catch (Exception e) {
                Log.v("DEBUG", e.toString());
                return RomUtils.UNKNOWN;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void printStack(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, str, i) == null) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int min = Math.min(i, stackTrace.length - 1);
            String str2 = " ";
            for (int i2 = 1; i2 <= min; i2++) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                str2 = str2 + " ";
                PrintStream printStream = System.out;
                printStream.println(str + str2 + (".(" + stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber() + ") ") + str2);
            }
        }
    }

    public static String getName(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view2)) == null) {
            try {
                return view2.getContext().getResources().getResourceEntryName(view2.getId());
            } catch (Exception unused) {
                return RomUtils.UNKNOWN;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getState(MotionLayout motionLayout, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, motionLayout, i)) == null) {
            if (i == -1) {
                return "UNDEFINED";
            }
            return motionLayout.getContext().getResources().getResourceEntryName(i);
        }
        return (String) invokeLI.objValue;
    }

    public static void logStack(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65549, null, str, str2, i) == null) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int min = Math.min(i, stackTrace.length - 1);
            String str3 = " ";
            for (int i2 = 1; i2 <= min; i2++) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                str3 = str3 + " ";
                Log.v(str, str2 + str3 + (".(" + stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber() + ") " + stackTrace[i2].getMethodName()) + str3);
            }
        }
    }
}
