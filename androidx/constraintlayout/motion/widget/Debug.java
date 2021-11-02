package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
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
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
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

    public static String getCallFrom(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i2 + 2];
            return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeI.objValue;
    }

    public static String getLoc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
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

    public static String getName(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view)) == null) {
            try {
                return view.getContext().getResources().getResourceEntryName(view.getId());
            } catch (Exception unused) {
                return RomUtils.UNKNOWN;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getState(MotionLayout motionLayout, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, motionLayout, i2)) == null) ? i2 == -1 ? "UNDEFINED" : motionLayout.getContext().getResources().getResourceEntryName(i2) : (String) invokeLI.objValue;
    }

    public static void logStack(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65549, null, str, str2, i2) == null) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int min = Math.min(i2, stackTrace.length - 1);
            String str3 = " ";
            for (int i3 = 1; i3 <= min; i3++) {
                StackTraceElement stackTraceElement = stackTrace[i3];
                str3 = str3 + " ";
                String str4 = str2 + str3 + (".(" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ") " + stackTrace[i3].getMethodName()) + str3;
            }
        }
    }

    public static void printStack(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, str, i2) == null) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int min = Math.min(i2, stackTrace.length - 1);
            String str2 = " ";
            for (int i3 = 1; i3 <= min; i3++) {
                StackTraceElement stackTraceElement = stackTrace[i3];
                str2 = str2 + " ";
                PrintStream printStream = System.out;
                printStream.println(str + str2 + (".(" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ") ") + str2);
            }
        }
    }

    public static String getName(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i2)) == null) {
            if (i2 != -1) {
                try {
                    return context.getResources().getResourceEntryName(i2);
                } catch (Exception unused) {
                    return "?" + i2;
                }
            }
            return RomUtils.UNKNOWN;
        }
        return (String) invokeLI.objValue;
    }

    public static String getName(Context context, int[] iArr) {
        String str;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, iArr)) == null) {
            try {
                String str2 = iArr.length + PreferencesUtil.LEFT_MOUNT;
                int i2 = 0;
                while (i2 < iArr.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(i2 == 0 ? "" : " ");
                    String sb2 = sb.toString();
                    try {
                        str = context.getResources().getResourceEntryName(iArr[i2]);
                    } catch (Resources.NotFoundException unused) {
                        str = "? " + iArr[i2] + " ";
                    }
                    str2 = sb2 + str;
                    i2++;
                }
                return str2 + PreferencesUtil.RIGHT_MOUNT;
            } catch (Exception e2) {
                e2.toString();
                return RomUtils.UNKNOWN;
            }
        }
        return (String) invokeLL.objValue;
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
}
