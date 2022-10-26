package androidx.palette.graphics;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.palette.graphics.Palette;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/* loaded from: classes.dex */
public final class ColorCutQuantizer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMPONENT_BLUE = -1;
    public static final int COMPONENT_GREEN = -2;
    public static final int COMPONENT_RED = -3;
    public static final String LOG_TAG = "ColorCutQuantizer";
    public static final boolean LOG_TIMINGS = false;
    public static final int QUANTIZE_WORD_MASK = 31;
    public static final int QUANTIZE_WORD_WIDTH = 5;
    public static final Comparator<Vbox> VBOX_COMPARATOR_VOLUME;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] mColors;
    public final Palette.Filter[] mFilters;
    public final int[] mHistogram;
    public final List<Palette.Swatch> mQuantizedColors;
    public final float[] mTempHsl;
    public final TimingLogger mTimingLogger;

    public static int modifyWordWidth(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65542, null, i, i2, i3)) == null) {
            return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
        }
        return invokeIII.intValue;
    }

    public static int quantizedBlue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) ? i & 31 : invokeI.intValue;
    }

    public static int quantizedGreen(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) ? (i >> 5) & 31 : invokeI.intValue;
    }

    public static int quantizedRed(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) ? (i >> 10) & 31 : invokeI.intValue;
    }

    /* loaded from: classes.dex */
    public class Vbox {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mLowerIndex;
        public int mMaxBlue;
        public int mMaxGreen;
        public int mMaxRed;
        public int mMinBlue;
        public int mMinGreen;
        public int mMinRed;
        public int mPopulation;
        public int mUpperIndex;
        public final /* synthetic */ ColorCutQuantizer this$0;

        public Vbox(ColorCutQuantizer colorCutQuantizer, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {colorCutQuantizer, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = colorCutQuantizer;
            this.mLowerIndex = i;
            this.mUpperIndex = i2;
            fitBox();
        }

        public final boolean canSplit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (getColorCount() > 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final int getColorCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return (this.mUpperIndex + 1) - this.mLowerIndex;
            }
            return invokeV.intValue;
        }

        public final int getLongestColorDimension() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int i = this.mMaxRed - this.mMinRed;
                int i2 = this.mMaxGreen - this.mMinGreen;
                int i3 = this.mMaxBlue - this.mMinBlue;
                if (i >= i2 && i >= i3) {
                    return -3;
                }
                if (i2 >= i && i2 >= i3) {
                    return -2;
                }
                return -1;
            }
            return invokeV.intValue;
        }

        public final int getVolume() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return ((this.mMaxRed - this.mMinRed) + 1) * ((this.mMaxGreen - this.mMinGreen) + 1) * ((this.mMaxBlue - this.mMinBlue) + 1);
            }
            return invokeV.intValue;
        }

        public final int findSplitPoint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int longestColorDimension = getLongestColorDimension();
                ColorCutQuantizer colorCutQuantizer = this.this$0;
                int[] iArr = colorCutQuantizer.mColors;
                int[] iArr2 = colorCutQuantizer.mHistogram;
                ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
                Arrays.sort(iArr, this.mLowerIndex, this.mUpperIndex + 1);
                ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
                int i = this.mPopulation / 2;
                int i2 = this.mLowerIndex;
                int i3 = 0;
                while (true) {
                    int i4 = this.mUpperIndex;
                    if (i2 <= i4) {
                        i3 += iArr2[iArr[i2]];
                        if (i3 >= i) {
                            return Math.min(i4 - 1, i2);
                        }
                        i2++;
                    } else {
                        return this.mLowerIndex;
                    }
                }
            } else {
                return invokeV.intValue;
            }
        }

        public final void fitBox() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ColorCutQuantizer colorCutQuantizer = this.this$0;
                int[] iArr = colorCutQuantizer.mColors;
                int[] iArr2 = colorCutQuantizer.mHistogram;
                int i = Integer.MAX_VALUE;
                int i2 = Integer.MAX_VALUE;
                int i3 = Integer.MAX_VALUE;
                int i4 = Integer.MIN_VALUE;
                int i5 = Integer.MIN_VALUE;
                int i6 = Integer.MIN_VALUE;
                int i7 = 0;
                for (int i8 = this.mLowerIndex; i8 <= this.mUpperIndex; i8++) {
                    int i9 = iArr[i8];
                    i7 += iArr2[i9];
                    int quantizedRed = ColorCutQuantizer.quantizedRed(i9);
                    int quantizedGreen = ColorCutQuantizer.quantizedGreen(i9);
                    int quantizedBlue = ColorCutQuantizer.quantizedBlue(i9);
                    if (quantizedRed > i4) {
                        i4 = quantizedRed;
                    }
                    if (quantizedRed < i) {
                        i = quantizedRed;
                    }
                    if (quantizedGreen > i5) {
                        i5 = quantizedGreen;
                    }
                    if (quantizedGreen < i2) {
                        i2 = quantizedGreen;
                    }
                    if (quantizedBlue > i6) {
                        i6 = quantizedBlue;
                    }
                    if (quantizedBlue < i3) {
                        i3 = quantizedBlue;
                    }
                }
                this.mMinRed = i;
                this.mMaxRed = i4;
                this.mMinGreen = i2;
                this.mMaxGreen = i5;
                this.mMinBlue = i3;
                this.mMaxBlue = i6;
                this.mPopulation = i7;
            }
        }

        public final Palette.Swatch getAverageColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                ColorCutQuantizer colorCutQuantizer = this.this$0;
                int[] iArr = colorCutQuantizer.mColors;
                int[] iArr2 = colorCutQuantizer.mHistogram;
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = this.mLowerIndex; i5 <= this.mUpperIndex; i5++) {
                    int i6 = iArr[i5];
                    int i7 = iArr2[i6];
                    i2 += i7;
                    i += ColorCutQuantizer.quantizedRed(i6) * i7;
                    i3 += ColorCutQuantizer.quantizedGreen(i6) * i7;
                    i4 += i7 * ColorCutQuantizer.quantizedBlue(i6);
                }
                float f = i2;
                return new Palette.Swatch(ColorCutQuantizer.approximateToRgb888(Math.round(i / f), Math.round(i3 / f), Math.round(i4 / f)), i2);
            }
            return (Palette.Swatch) invokeV.objValue;
        }

        public final Vbox splitBox() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (canSplit()) {
                    int findSplitPoint = findSplitPoint();
                    Vbox vbox = new Vbox(this.this$0, findSplitPoint + 1, this.mUpperIndex);
                    this.mUpperIndex = findSplitPoint;
                    fitBox();
                    return vbox;
                }
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            return (Vbox) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1974088721, "Landroidx/palette/graphics/ColorCutQuantizer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1974088721, "Landroidx/palette/graphics/ColorCutQuantizer;");
                return;
            }
        }
        VBOX_COMPARATOR_VOLUME = new Comparator<Vbox>() { // from class: androidx.palette.graphics.ColorCutQuantizer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Vbox vbox, Vbox vbox2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, vbox, vbox2)) == null) {
                    return vbox2.getVolume() - vbox.getVolume();
                }
                return invokeLL.intValue;
            }
        };
    }

    public List<Palette.Swatch> getQuantizedColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mQuantizedColors;
        }
        return (List) invokeV.objValue;
    }

    public ColorCutQuantizer(int[] iArr, int i, Palette.Filter[] filterArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, Integer.valueOf(i), filterArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTempHsl = new float[3];
        this.mTimingLogger = null;
        this.mFilters = filterArr;
        int[] iArr2 = new int[32768];
        this.mHistogram = iArr2;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int quantizeFromRgb888 = quantizeFromRgb888(iArr[i4]);
            iArr[i4] = quantizeFromRgb888;
            iArr2[quantizeFromRgb888] = iArr2[quantizeFromRgb888] + 1;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 32768; i6++) {
            if (iArr2[i6] > 0 && shouldIgnoreColor(i6)) {
                iArr2[i6] = 0;
            }
            if (iArr2[i6] > 0) {
                i5++;
            }
        }
        int[] iArr3 = new int[i5];
        this.mColors = iArr3;
        int i7 = 0;
        for (int i8 = 0; i8 < 32768; i8++) {
            if (iArr2[i8] > 0) {
                iArr3[i7] = i8;
                i7++;
            }
        }
        if (i5 <= i) {
            this.mQuantizedColors = new ArrayList();
            for (int i9 = 0; i9 < i5; i9++) {
                int i10 = iArr3[i9];
                this.mQuantizedColors.add(new Palette.Swatch(approximateToRgb888(i10), iArr2[i10]));
            }
            return;
        }
        this.mQuantizedColors = quantizePixels(i);
    }

    public static int approximateToRgb888(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return approximateToRgb888(quantizedRed(i), quantizedGreen(i), quantizedBlue(i));
        }
        return invokeI.intValue;
    }

    private List<Palette.Swatch> quantizePixels(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
            PriorityQueue<Vbox> priorityQueue = new PriorityQueue<>(i, VBOX_COMPARATOR_VOLUME);
            priorityQueue.offer(new Vbox(this, 0, this.mColors.length - 1));
            splitBoxes(priorityQueue, i);
            return generateAverageColors(priorityQueue);
        }
        return (List) invokeI.objValue;
    }

    private boolean shouldIgnoreColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i)) == null) {
            int approximateToRgb888 = approximateToRgb888(i);
            ColorUtils.colorToHSL(approximateToRgb888, this.mTempHsl);
            return shouldIgnoreColor(approximateToRgb888, this.mTempHsl);
        }
        return invokeI.booleanValue;
    }

    public static int approximateToRgb888(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65539, null, i, i2, i3)) == null) {
            return Color.rgb(modifyWordWidth(i, 5, 8), modifyWordWidth(i2, 5, 8), modifyWordWidth(i3, 5, 8));
        }
        return invokeIII.intValue;
    }

    private List<Palette.Swatch> generateAverageColors(Collection<Vbox> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, collection)) == null) {
            ArrayList arrayList = new ArrayList(collection.size());
            for (Vbox vbox : collection) {
                Palette.Swatch averageColor = vbox.getAverageColor();
                if (!shouldIgnoreColor(averageColor)) {
                    arrayList.add(averageColor);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static int quantizeFromRgb888(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            return modifyWordWidth(Color.blue(i), 8, 5) | (modifyWordWidth(Color.red(i), 8, 5) << 10) | (modifyWordWidth(Color.green(i), 8, 5) << 5);
        }
        return invokeI.intValue;
    }

    public static void modifySignificantOctet(int[] iArr, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65541, null, iArr, i, i2, i3) == null) {
            if (i != -2) {
                if (i == -1) {
                    while (i2 <= i3) {
                        int i4 = iArr[i2];
                        iArr[i2] = quantizedRed(i4) | (quantizedBlue(i4) << 10) | (quantizedGreen(i4) << 5);
                        i2++;
                    }
                    return;
                }
                return;
            }
            while (i2 <= i3) {
                int i5 = iArr[i2];
                iArr[i2] = quantizedBlue(i5) | (quantizedGreen(i5) << 10) | (quantizedRed(i5) << 5);
                i2++;
            }
        }
    }

    private boolean shouldIgnoreColor(int i, float[] fArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65549, this, i, fArr)) == null) {
            Palette.Filter[] filterArr = this.mFilters;
            if (filterArr != null && filterArr.length > 0) {
                int length = filterArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (!this.mFilters[i2].isAllowed(i, fArr)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    private void splitBoxes(PriorityQueue<Vbox> priorityQueue, int i) {
        Vbox poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, this, priorityQueue, i) == null) {
            while (priorityQueue.size() < i && (poll = priorityQueue.poll()) != null && poll.canSplit()) {
                priorityQueue.offer(poll.splitBox());
                priorityQueue.offer(poll);
            }
        }
    }

    private boolean shouldIgnoreColor(Palette.Swatch swatch) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, swatch)) == null) {
            return shouldIgnoreColor(swatch.getRgb(), swatch.getHsl());
        }
        return invokeL.booleanValue;
    }
}
