package c.a.r0.w0.q1.e;

import android.graphics.drawable.ShapeDrawable;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.w0.q1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1294a extends ShapeDrawable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f27634a;

        /* renamed from: b  reason: collision with root package name */
        public int f27635b;

        public C1294a(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27634a = i4;
            this.f27635b = i5;
            setDither(false);
            getPaint().setColor(i2);
            setIntrinsicWidth(i3);
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                super.setBounds(i2, i3 + this.f27634a, i4, i5 + this.f27635b);
            }
        }
    }

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return 0L;
            }
            try {
                Date parse = new SimpleDateFormat("yyyy.MM.dd").parse(str);
                return (parse != null ? parse.getTime() : 0L) / 1000;
            } catch (ParseException e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static int b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) {
            if (j2 < 0) {
                return -1;
            }
            return (int) (j2 / 86400);
        }
        return invokeJ.intValue;
    }

    public static void c(int i2, int i3, EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65538, null, i2, i3, editText) == null) {
            try {
                Method declaredMethod = TextView.class.getDeclaredMethod("createEditorIfNeeded", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(editText, new Object[0]);
                Field declaredField = TextView.class.getDeclaredField("mEditor");
                Field declaredField2 = Class.forName("android.widget.Editor").getDeclaredField("mCursorDrawable");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(declaredField.get(editText));
                Array.set(obj, 0, new C1294a(SkinManager.getColor(R.color.CAM_X0302), UtilHelper.getDimenPixelSize(R.dimen.tbds5), i2, i3));
                Array.set(obj, 1, new C1294a(SkinManager.getColor(R.color.CAM_X0302), UtilHelper.getDimenPixelSize(R.dimen.tbds5), i2, i3));
            } catch (Exception unused) {
            }
        }
    }

    public static String d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return "一";
                case 2:
                    return "二";
                case 3:
                    return "三";
                case 4:
                    return "四";
                case 5:
                    return "五";
                case 6:
                    return "六";
                case 7:
                    return "七";
                case 8:
                    return "八";
                case 9:
                    return "九";
                case 10:
                    return "十";
                case 11:
                    return "十一";
                case 12:
                    return "十二";
                case 13:
                    return "十三";
                case 14:
                    return "十四";
                case 15:
                    return "十五";
                case 16:
                    return "十六";
                case 17:
                    return "十七";
                case 18:
                    return "十八";
                case 19:
                    return "十九";
                case 20:
                    return "二十";
                default:
                    return "";
            }
        }
        return (String) invokeI.objValue;
    }
}
