package com.baidu.android.util.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.language.bm.Rule;
@Deprecated
/* loaded from: classes.dex */
public class BitmapClip {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.util.media.BitmapClip$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$util$media$BitmapClip$ClipType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2009688549, "Lcom/baidu/android/util/media/BitmapClip$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2009688549, "Lcom/baidu/android/util/media/BitmapClip$1;");
                    return;
                }
            }
            int[] iArr = new int[ClipType.values().length];
            $SwitchMap$com$baidu$android$util$media$BitmapClip$ClipType = iArr;
            try {
                iArr[ClipType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$util$media$BitmapClip$ClipType[ClipType.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$android$util$media$BitmapClip$ClipType[ClipType.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$android$util$media$BitmapClip$ClipType[ClipType.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$android$util$media$BitmapClip$ClipType[ClipType.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$android$util$media$BitmapClip$ClipType[ClipType.LEFT_DIAGONAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$android$util$media$BitmapClip$ClipType[ClipType.RIGHT_DIAGONAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class ClipType {
        public static final /* synthetic */ ClipType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ClipType ALL;
        public static final ClipType BOTTOM;
        public static final ClipType LEFT;
        public static final ClipType LEFT_DIAGONAL;
        public static final ClipType RIGHT;
        public static final ClipType RIGHT_DIAGONAL;
        public static final ClipType TOP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-247825770, "Lcom/baidu/android/util/media/BitmapClip$ClipType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-247825770, "Lcom/baidu/android/util/media/BitmapClip$ClipType;");
                    return;
                }
            }
            ALL = new ClipType(Rule.ALL, 0);
            LEFT = new ClipType("LEFT", 1);
            TOP = new ClipType("TOP", 2);
            RIGHT = new ClipType("RIGHT", 3);
            BOTTOM = new ClipType("BOTTOM", 4);
            LEFT_DIAGONAL = new ClipType("LEFT_DIAGONAL", 5);
            ClipType clipType = new ClipType("RIGHT_DIAGONAL", 6);
            RIGHT_DIAGONAL = clipType;
            $VALUES = new ClipType[]{ALL, LEFT, TOP, RIGHT, BOTTOM, LEFT_DIAGONAL, clipType};
        }

        public ClipType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ClipType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ClipType) Enum.valueOf(ClipType.class, str);
            }
            return (ClipType) invokeL.objValue;
        }

        public static ClipType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ClipType[]) $VALUES.clone();
            }
            return (ClipType[]) invokeV.objValue;
        }
    }

    public BitmapClip() {
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

    public static Bitmap clip(ClipType clipType, Bitmap bitmap, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, clipType, bitmap, i)) == null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawARGB(0, 0, 0, 0);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setColor(-16777216);
                switch (AnonymousClass1.$SwitchMap$com$baidu$android$util$media$BitmapClip$ClipType[clipType.ordinal()]) {
                    case 1:
                        clipAll(canvas, paint, i, width, height);
                        break;
                    case 2:
                        clipLeft(canvas, paint, i, width, height);
                        break;
                    case 3:
                        clipTop(canvas, paint, i, width, height);
                        break;
                    case 4:
                        clipRight(canvas, paint, i, width, height);
                        break;
                    case 5:
                        clipBottom(canvas, paint, i, width, height);
                        break;
                    case 6:
                        clipLeftDiagonal(canvas, paint, i, width, height);
                        break;
                    case 7:
                        clipRightDiagonal(canvas, paint, i, width, height);
                        break;
                    default:
                        clipAll(canvas, paint, i, width, height);
                        break;
                }
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                Rect rect = new Rect(0, 0, width, height);
                canvas.drawBitmap(bitmap, rect, rect, paint);
                return createBitmap;
            } catch (Exception unused) {
                return bitmap;
            }
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static void clipAll(Canvas canvas, Paint paint, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            float f = i;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, i2, i3), f, f, paint);
        }
    }

    public static void clipBottom(Canvas canvas, Paint paint, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            canvas.drawRect(new Rect(0, 0, i2, i3 - i), paint);
            float f = i;
            canvas.drawRoundRect(new RectF(0.0f, i3 - (i * 2), i2, i3), f, f, paint);
        }
    }

    public static void clipLeft(Canvas canvas, Paint paint, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            canvas.drawRect(new Rect(i, 0, i2, i3), paint);
            float f = i;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, i * 2, i3), f, f, paint);
        }
    }

    public static void clipLeftDiagonal(Canvas canvas, Paint paint, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            int i4 = i3 - i;
            canvas.drawRect(new Rect(i, 0, i2, i4), paint);
            int i5 = i2 - i;
            canvas.drawRect(new Rect(0, i, i5, i3), paint);
            float f = i;
            canvas.drawCircle(f, f, f, paint);
            canvas.drawCircle(i5, i4, f, paint);
        }
    }

    public static void clipRight(Canvas canvas, Paint paint, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            canvas.drawRect(new Rect(0, 0, i2 - i, i3), paint);
            float f = i;
            canvas.drawRoundRect(new RectF(i2 - (i * 2), 0.0f, i2, i3), f, f, paint);
        }
    }

    public static void clipRightDiagonal(Canvas canvas, Paint paint, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            int i4 = i2 - i;
            int i5 = i3 - i;
            canvas.drawRect(new Rect(0, 0, i4, i5), paint);
            canvas.drawRect(new Rect(i, i, i2, i3), paint);
            float f = i;
            canvas.drawCircle(i4, f, f, paint);
            canvas.drawCircle(f, i5, f, paint);
        }
    }

    public static void clipTop(Canvas canvas, Paint paint, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            canvas.drawRect(new Rect(0, i, i2, i3), paint);
            float f = i;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, i2, i * 2), f, f, paint);
        }
    }
}
