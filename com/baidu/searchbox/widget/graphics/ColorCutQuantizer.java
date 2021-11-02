package com.baidu.searchbox.widget.graphics;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.TimingLogger;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.widget.graphics.Palette;
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
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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

        public Vbox(ColorCutQuantizer colorCutQuantizer, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {colorCutQuantizer, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = colorCutQuantizer;
            this.mLowerIndex = i2;
            this.mUpperIndex = i3;
            fitBox();
        }

        public final boolean canSplit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getColorCount() > 1 : invokeV.booleanValue;
        }

        public final int findSplitPoint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return invokeV.intValue;
            }
            int longestColorDimension = getLongestColorDimension();
            ColorCutQuantizer colorCutQuantizer = this.this$0;
            int[] iArr = colorCutQuantizer.mColors;
            int[] iArr2 = colorCutQuantizer.mHistogram;
            ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
            Arrays.sort(iArr, this.mLowerIndex, this.mUpperIndex + 1);
            ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
            int i2 = this.mPopulation / 2;
            int i3 = this.mLowerIndex;
            int i4 = 0;
            while (true) {
                int i5 = this.mUpperIndex;
                if (i3 <= i5) {
                    i4 += iArr2[iArr[i3]];
                    if (i4 >= i2) {
                        return Math.min(i5 - 1, i3);
                    }
                    i3++;
                } else {
                    return this.mLowerIndex;
                }
            }
        }

        public final void fitBox() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ColorCutQuantizer colorCutQuantizer = this.this$0;
                int[] iArr = colorCutQuantizer.mColors;
                int[] iArr2 = colorCutQuantizer.mHistogram;
                int i2 = Integer.MAX_VALUE;
                int i3 = Integer.MAX_VALUE;
                int i4 = Integer.MAX_VALUE;
                int i5 = Integer.MIN_VALUE;
                int i6 = Integer.MIN_VALUE;
                int i7 = Integer.MIN_VALUE;
                int i8 = 0;
                for (int i9 = this.mLowerIndex; i9 <= this.mUpperIndex; i9++) {
                    int i10 = iArr[i9];
                    i8 += iArr2[i10];
                    int quantizedRed = ColorCutQuantizer.quantizedRed(i10);
                    int quantizedGreen = ColorCutQuantizer.quantizedGreen(i10);
                    int quantizedBlue = ColorCutQuantizer.quantizedBlue(i10);
                    if (quantizedRed > i5) {
                        i5 = quantizedRed;
                    }
                    if (quantizedRed < i2) {
                        i2 = quantizedRed;
                    }
                    if (quantizedGreen > i6) {
                        i6 = quantizedGreen;
                    }
                    if (quantizedGreen < i3) {
                        i3 = quantizedGreen;
                    }
                    if (quantizedBlue > i7) {
                        i7 = quantizedBlue;
                    }
                    if (quantizedBlue < i4) {
                        i4 = quantizedBlue;
                    }
                }
                this.mMinRed = i2;
                this.mMaxRed = i5;
                this.mMinGreen = i3;
                this.mMaxGreen = i6;
                this.mMinBlue = i4;
                this.mMaxBlue = i7;
                this.mPopulation = i8;
            }
        }

        public final Palette.Swatch getAverageColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                ColorCutQuantizer colorCutQuantizer = this.this$0;
                int[] iArr = colorCutQuantizer.mColors;
                int[] iArr2 = colorCutQuantizer.mHistogram;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                for (int i6 = this.mLowerIndex; i6 <= this.mUpperIndex; i6++) {
                    int i7 = iArr[i6];
                    int i8 = iArr2[i7];
                    i3 += i8;
                    i2 += ColorCutQuantizer.quantizedRed(i7) * i8;
                    i4 += ColorCutQuantizer.quantizedGreen(i7) * i8;
                    i5 += i8 * ColorCutQuantizer.quantizedBlue(i7);
                }
                float f2 = i3;
                return new Palette.Swatch(ColorCutQuantizer.approximateToRgb888(Math.round(i2 / f2), Math.round(i4 / f2), Math.round(i5 / f2)), i3);
            }
            return (Palette.Swatch) invokeV.objValue;
        }

        public final int getColorCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.mUpperIndex + 1) - this.mLowerIndex : invokeV.intValue;
        }

        public final int getLongestColorDimension() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int i2 = this.mMaxRed - this.mMinRed;
                int i3 = this.mMaxGreen - this.mMinGreen;
                int i4 = this.mMaxBlue - this.mMinBlue;
                if (i2 < i3 || i2 < i4) {
                    return (i3 < i2 || i3 < i4) ? -1 : -2;
                }
                return -3;
            }
            return invokeV.intValue;
        }

        public final int getVolume() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ((this.mMaxRed - this.mMinRed) + 1) * ((this.mMaxGreen - this.mMinGreen) + 1) * ((this.mMaxBlue - this.mMinBlue) + 1) : invokeV.intValue;
        }

        @SuppressLint({"BDThrowableCheck"})
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(343744908, "Lcom/baidu/searchbox/widget/graphics/ColorCutQuantizer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(343744908, "Lcom/baidu/searchbox/widget/graphics/ColorCutQuantizer;");
                return;
            }
        }
        VBOX_COMPARATOR_VOLUME = new Comparator<Vbox>() { // from class: com.baidu.searchbox.widget.graphics.ColorCutQuantizer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, vbox, vbox2)) == null) ? vbox2.getVolume() - vbox.getVolume() : invokeLL.intValue;
            }
        };
    }

    public ColorCutQuantizer(int[] iArr, int i2, Palette.Filter[] filterArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, Integer.valueOf(i2), filterArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int quantizeFromRgb888 = quantizeFromRgb888(iArr[i5]);
            iArr[i5] = quantizeFromRgb888;
            iArr2[quantizeFromRgb888] = iArr2[quantizeFromRgb888] + 1;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < 32768; i7++) {
            if (iArr2[i7] > 0 && shouldIgnoreColor(i7)) {
                iArr2[i7] = 0;
            }
            if (iArr2[i7] > 0) {
                i6++;
            }
        }
        int[] iArr3 = new int[i6];
        this.mColors = iArr3;
        int i8 = 0;
        for (int i9 = 0; i9 < 32768; i9++) {
            if (iArr2[i9] > 0) {
                iArr3[i8] = i9;
                i8++;
            }
        }
        if (i6 <= i2) {
            this.mQuantizedColors = new ArrayList();
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = iArr3[i10];
                this.mQuantizedColors.add(new Palette.Swatch(approximateToRgb888(i11), iArr2[i11]));
            }
            return;
        }
        this.mQuantizedColors = quantizePixels(i2);
    }

    public static int approximateToRgb888(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65539, null, i2, i3, i4)) == null) ? Color.rgb(modifyWordWidth(i2, 5, 8), modifyWordWidth(i3, 5, 8), modifyWordWidth(i4, 5, 8)) : invokeIII.intValue;
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

    public static void modifySignificantOctet(int[] iArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(AdIconUtil.AD_TEXT_ID, null, iArr, i2, i3, i4) == null) {
            if (i2 == -2) {
                while (i3 <= i4) {
                    int i5 = iArr[i3];
                    iArr[i3] = quantizedBlue(i5) | (quantizedGreen(i5) << 10) | (quantizedRed(i5) << 5);
                    i3++;
                }
            } else if (i2 != -1) {
            } else {
                while (i3 <= i4) {
                    int i6 = iArr[i3];
                    iArr[i3] = quantizedRed(i6) | (quantizedBlue(i6) << 10) | (quantizedGreen(i6) << 5);
                    i3++;
                }
            }
        }
    }

    public static int modifyWordWidth(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3, i4)) == null) {
            return (i4 > i3 ? i2 << (i4 - i3) : i2 >> (i3 - i4)) & ((1 << i4) - 1);
        }
        return invokeIII.intValue;
    }

    public static int quantizeFromRgb888(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? modifyWordWidth(Color.blue(i2), 8, 5) | (modifyWordWidth(Color.red(i2), 8, 5) << 10) | (modifyWordWidth(Color.green(i2), 8, 5) << 5) : invokeI.intValue;
    }

    private List<Palette.Swatch> quantizePixels(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) {
            PriorityQueue<Vbox> priorityQueue = new PriorityQueue<>(i2, VBOX_COMPARATOR_VOLUME);
            priorityQueue.offer(new Vbox(this, 0, this.mColors.length - 1));
            splitBoxes(priorityQueue, i2);
            return generateAverageColors(priorityQueue);
        }
        return (List) invokeI.objValue;
    }

    public static int quantizedBlue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? i2 & 31 : invokeI.intValue;
    }

    public static int quantizedGreen(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? (i2 >> 5) & 31 : invokeI.intValue;
    }

    public static int quantizedRed(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? (i2 >> 10) & 31 : invokeI.intValue;
    }

    private boolean shouldIgnoreColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i2)) == null) {
            int approximateToRgb888 = approximateToRgb888(i2);
            ColorUtils.colorToHSL(approximateToRgb888, this.mTempHsl);
            return shouldIgnoreColor(approximateToRgb888, this.mTempHsl);
        }
        return invokeI.booleanValue;
    }

    private void splitBoxes(PriorityQueue<Vbox> priorityQueue, int i2) {
        Vbox poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, this, priorityQueue, i2) == null) {
            while (priorityQueue.size() < i2 && (poll = priorityQueue.poll()) != null && poll.canSplit()) {
                priorityQueue.offer(poll.splitBox());
                priorityQueue.offer(poll);
            }
        }
    }

    public List<Palette.Swatch> getQuantizedColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mQuantizedColors : (List) invokeV.objValue;
    }

    private boolean shouldIgnoreColor(Palette.Swatch swatch) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, this, swatch)) == null) ? shouldIgnoreColor(swatch.getRgb(), swatch.getHsl()) : invokeL.booleanValue;
    }

    public static int approximateToRgb888(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? approximateToRgb888(quantizedRed(i2), quantizedGreen(i2), quantizedBlue(i2)) : invokeI.intValue;
    }

    private boolean shouldIgnoreColor(int i2, float[] fArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65549, this, i2, fArr)) == null) {
            Palette.Filter[] filterArr = this.mFilters;
            if (filterArr != null && filterArr.length > 0) {
                int length = filterArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    if (!this.mFilters[i3].isAllowed(i2, fArr)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }
}
