package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class Palette {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_CALCULATE_NUMBER_COLORS = 16;
    public static final Filter DEFAULT_FILTER;
    public static final int DEFAULT_RESIZE_BITMAP_AREA = 12544;
    public static final String LOG_TAG = "Palette";
    public static final boolean LOG_TIMINGS = false;
    public static final float MIN_CONTRAST_BODY_TEXT = 4.5f;
    public static final float MIN_CONTRAST_TITLE_TEXT = 3.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public final Swatch mDominantSwatch;
    public final Map<Target, Swatch> mSelectedSwatches;
    public final List<Swatch> mSwatches;
    public final List<Target> mTargets;
    public final SparseBooleanArray mUsedColors;

    /* loaded from: classes.dex */
    public interface Filter {
        boolean isAllowed(int i, float[] fArr);
    }

    /* loaded from: classes.dex */
    public interface PaletteAsyncListener {
        void onGenerated(Palette palette);
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Bitmap mBitmap;
        public final List<Filter> mFilters;
        public int mMaxColors;
        public Rect mRegion;
        public int mResizeArea;
        public int mResizeMaxDimension;
        public final List<Swatch> mSwatches;
        public final List<Target> mTargets;

        public Builder(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTargets = new ArrayList();
            this.mMaxColors = 16;
            this.mResizeArea = Palette.DEFAULT_RESIZE_BITMAP_AREA;
            this.mResizeMaxDimension = -1;
            this.mFilters = new ArrayList();
            if (bitmap != null && !bitmap.isRecycled()) {
                this.mFilters.add(Palette.DEFAULT_FILTER);
                this.mBitmap = bitmap;
                this.mSwatches = null;
                this.mTargets.add(Target.LIGHT_VIBRANT);
                this.mTargets.add(Target.VIBRANT);
                this.mTargets.add(Target.DARK_VIBRANT);
                this.mTargets.add(Target.LIGHT_MUTED);
                this.mTargets.add(Target.MUTED);
                this.mTargets.add(Target.DARK_MUTED);
                return;
            }
            throw new IllegalArgumentException("Bitmap is not valid");
        }

        private Bitmap scaleBitmapDown(Bitmap bitmap) {
            InterceptResult invokeL;
            int max;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bitmap)) == null) {
                double d = -1.0d;
                if (this.mResizeArea > 0) {
                    int width = bitmap.getWidth() * bitmap.getHeight();
                    int i2 = this.mResizeArea;
                    if (width > i2) {
                        d = Math.sqrt(i2 / width);
                    }
                } else if (this.mResizeMaxDimension > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i = this.mResizeMaxDimension)) {
                    d = i / max;
                }
                if (d <= 0.0d) {
                    return bitmap;
                }
                return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * d), (int) Math.ceil(bitmap.getHeight() * d), false);
            }
            return (Bitmap) invokeL.objValue;
        }

        public Builder(List<Swatch> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTargets = new ArrayList();
            this.mMaxColors = 16;
            this.mResizeArea = Palette.DEFAULT_RESIZE_BITMAP_AREA;
            this.mResizeMaxDimension = -1;
            this.mFilters = new ArrayList();
            if (list != null && !list.isEmpty()) {
                this.mFilters.add(Palette.DEFAULT_FILTER);
                this.mSwatches = list;
                this.mBitmap = null;
                return;
            }
            throw new IllegalArgumentException("List of Swatches is not valid");
        }

        private int[] getPixelsFromBitmap(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bitmap)) == null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int[] iArr = new int[width * height];
                bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                Rect rect = this.mRegion;
                if (rect == null) {
                    return iArr;
                }
                int width2 = rect.width();
                int height2 = this.mRegion.height();
                int[] iArr2 = new int[width2 * height2];
                for (int i = 0; i < height2; i++) {
                    Rect rect2 = this.mRegion;
                    System.arraycopy(iArr, ((rect2.top + i) * width) + rect2.left, iArr2, i * width2, width2);
                }
                return iArr2;
            }
            return (int[]) invokeL.objValue;
        }

        public Builder addFilter(Filter filter) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, filter)) == null) {
                if (filter != null) {
                    this.mFilters.add(filter);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addTarget(Target target) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, target)) == null) {
                if (!this.mTargets.contains(target)) {
                    this.mTargets.add(target);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public AsyncTask<Bitmap, Void, Palette> generate(PaletteAsyncListener paletteAsyncListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, paletteAsyncListener)) == null) {
                if (paletteAsyncListener != null) {
                    return new AsyncTask<Bitmap, Void, Palette>(this, paletteAsyncListener) { // from class: androidx.palette.graphics.Palette.Builder.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Builder this$0;
                        public final /* synthetic */ PaletteAsyncListener val$listener;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, paletteAsyncListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$listener = paletteAsyncListener;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.os.AsyncTask
                        public Palette doInBackground(Bitmap... bitmapArr) {
                            InterceptResult invokeL2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, bitmapArr)) == null) {
                                try {
                                    return this.this$0.generate();
                                } catch (Exception e) {
                                    Log.e(Palette.LOG_TAG, "Exception thrown during async generate", e);
                                    return null;
                                }
                            }
                            return (Palette) invokeL2.objValue;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.os.AsyncTask
                        public void onPostExecute(Palette palette) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, palette) == null) {
                                this.val$listener.onGenerated(palette);
                            }
                        }
                    }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.mBitmap);
                }
                throw new IllegalArgumentException("listener can not be null");
            }
            return (AsyncTask) invokeL.objValue;
        }

        public Builder maximumColorCount(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.mMaxColors = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder resizeBitmapArea(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.mResizeArea = i;
                this.mResizeMaxDimension = -1;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @Deprecated
        public Builder resizeBitmapSize(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                this.mResizeMaxDimension = i;
                this.mResizeArea = -1;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder clearFilters() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.mFilters.clear();
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder clearRegion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.mRegion = null;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder clearTargets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                List<Target> list = this.mTargets;
                if (list != null) {
                    list.clear();
                }
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Palette generate() {
            InterceptResult invokeV;
            List<Swatch> list;
            Filter[] filterArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Bitmap bitmap = this.mBitmap;
                if (bitmap != null) {
                    Bitmap scaleBitmapDown = scaleBitmapDown(bitmap);
                    Rect rect = this.mRegion;
                    if (scaleBitmapDown != this.mBitmap && rect != null) {
                        double width = scaleBitmapDown.getWidth() / this.mBitmap.getWidth();
                        rect.left = (int) Math.floor(rect.left * width);
                        rect.top = (int) Math.floor(rect.top * width);
                        rect.right = Math.min((int) Math.ceil(rect.right * width), scaleBitmapDown.getWidth());
                        rect.bottom = Math.min((int) Math.ceil(rect.bottom * width), scaleBitmapDown.getHeight());
                    }
                    int[] pixelsFromBitmap = getPixelsFromBitmap(scaleBitmapDown);
                    int i = this.mMaxColors;
                    if (this.mFilters.isEmpty()) {
                        filterArr = null;
                    } else {
                        List<Filter> list2 = this.mFilters;
                        filterArr = (Filter[]) list2.toArray(new Filter[list2.size()]);
                    }
                    ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(pixelsFromBitmap, i, filterArr);
                    if (scaleBitmapDown != this.mBitmap) {
                        scaleBitmapDown.recycle();
                    }
                    list = colorCutQuantizer.getQuantizedColors();
                } else {
                    list = this.mSwatches;
                    if (list == null) {
                        throw new AssertionError();
                    }
                }
                Palette palette = new Palette(list, this.mTargets);
                palette.generate();
                return palette;
            }
            return (Palette) invokeV.objValue;
        }

        public Builder setRegion(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048586, this, i, i2, i3, i4)) == null) {
                if (this.mBitmap != null) {
                    if (this.mRegion == null) {
                        this.mRegion = new Rect();
                    }
                    this.mRegion.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
                    if (!this.mRegion.intersect(i, i2, i3, i4)) {
                        throw new IllegalArgumentException("The given region must intersect with the Bitmap's dimensions.");
                    }
                }
                return this;
            }
            return (Builder) invokeIIII.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class Swatch {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mBlue;
        public int mBodyTextColor;
        public boolean mGeneratedTextColors;
        public final int mGreen;
        public float[] mHsl;
        public final int mPopulation;
        public final int mRed;
        public final int mRgb;
        public int mTitleTextColor;

        public Swatch(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRed = Color.red(i);
            this.mGreen = Color.green(i);
            this.mBlue = Color.blue(i);
            this.mRgb = i;
            this.mPopulation = i2;
        }

        public Swatch(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mRed = i;
            this.mGreen = i2;
            this.mBlue = i3;
            this.mRgb = Color.rgb(i, i2, i3);
            this.mPopulation = i4;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Swatch(float[] fArr, int i) {
            this(ColorUtils.HSLToColor(fArr), i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fArr, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mHsl = fArr;
        }

        private void ensureTextColorsGenerated() {
            int alphaComponent;
            int alphaComponent2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65539, this) == null) && !this.mGeneratedTextColors) {
                int calculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, 4.5f);
                int calculateMinimumAlpha2 = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, 3.0f);
                if (calculateMinimumAlpha != -1 && calculateMinimumAlpha2 != -1) {
                    this.mBodyTextColor = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
                    this.mTitleTextColor = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
                    this.mGeneratedTextColors = true;
                    return;
                }
                int calculateMinimumAlpha3 = ColorUtils.calculateMinimumAlpha(-16777216, this.mRgb, 4.5f);
                int calculateMinimumAlpha4 = ColorUtils.calculateMinimumAlpha(-16777216, this.mRgb, 3.0f);
                if (calculateMinimumAlpha3 != -1 && calculateMinimumAlpha4 != -1) {
                    this.mBodyTextColor = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha3);
                    this.mTitleTextColor = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha4);
                    this.mGeneratedTextColors = true;
                    return;
                }
                if (calculateMinimumAlpha != -1) {
                    alphaComponent = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
                } else {
                    alphaComponent = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha3);
                }
                this.mBodyTextColor = alphaComponent;
                if (calculateMinimumAlpha2 != -1) {
                    alphaComponent2 = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
                } else {
                    alphaComponent2 = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha4);
                }
                this.mTitleTextColor = alphaComponent2;
                this.mGeneratedTextColors = true;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return Swatch.class.getSimpleName() + " [RGB: #" + Integer.toHexString(getRgb()) + "] [HSL: " + Arrays.toString(getHsl()) + "] [Population: " + this.mPopulation + "] [Title Text: #" + Integer.toHexString(getTitleTextColor()) + "] [Body Text: #" + Integer.toHexString(getBodyTextColor()) + ']';
            }
            return (String) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Swatch.class != obj.getClass()) {
                    return false;
                }
                Swatch swatch = (Swatch) obj;
                if (this.mPopulation == swatch.mPopulation && this.mRgb == swatch.mRgb) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int getBodyTextColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ensureTextColorsGenerated();
                return this.mBodyTextColor;
            }
            return invokeV.intValue;
        }

        public float[] getHsl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.mHsl == null) {
                    this.mHsl = new float[3];
                }
                ColorUtils.RGBToHSL(this.mRed, this.mGreen, this.mBlue, this.mHsl);
                return this.mHsl;
            }
            return (float[]) invokeV.objValue;
        }

        public int getPopulation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mPopulation;
            }
            return invokeV.intValue;
        }

        public int getRgb() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mRgb;
            }
            return invokeV.intValue;
        }

        public int getTitleTextColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                ensureTextColorsGenerated();
                return this.mTitleTextColor;
            }
            return invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return (this.mRgb * 31) + this.mPopulation;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-66070442, "Landroidx/palette/graphics/Palette;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-66070442, "Landroidx/palette/graphics/Palette;");
                return;
            }
        }
        DEFAULT_FILTER = new Filter() { // from class: androidx.palette.graphics.Palette.1
            public static /* synthetic */ Interceptable $ic = null;
            public static final float BLACK_MAX_LIGHTNESS = 0.05f;
            public static final float WHITE_MIN_LIGHTNESS = 0.95f;
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

            private boolean isBlack(float[] fArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, fArr)) == null) {
                    if (fArr[2] <= 0.05f) {
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            private boolean isNearRedILine(float[] fArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(65538, this, fArr)) == null) {
                    if (fArr[0] < 10.0f || fArr[0] > 37.0f || fArr[1] > 0.82f) {
                        return false;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }

            private boolean isWhite(float[] fArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(65539, this, fArr)) == null) {
                    if (fArr[2] >= 0.95f) {
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // androidx.palette.graphics.Palette.Filter
            public boolean isAllowed(int i, float[] fArr) {
                InterceptResult invokeIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIL = interceptable2.invokeIL(1048576, this, i, fArr)) == null) {
                    if (!isWhite(fArr) && !isBlack(fArr) && !isNearRedILine(fArr)) {
                        return true;
                    }
                    return false;
                }
                return invokeIL.booleanValue;
            }
        };
    }

    public Swatch getDarkMutedSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getSwatchForTarget(Target.DARK_MUTED);
        }
        return (Swatch) invokeV.objValue;
    }

    public Swatch getDarkVibrantSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return getSwatchForTarget(Target.DARK_VIBRANT);
        }
        return (Swatch) invokeV.objValue;
    }

    public Swatch getDominantSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mDominantSwatch;
        }
        return (Swatch) invokeV.objValue;
    }

    public Swatch getLightMutedSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return getSwatchForTarget(Target.LIGHT_MUTED);
        }
        return (Swatch) invokeV.objValue;
    }

    public Swatch getLightVibrantSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return getSwatchForTarget(Target.LIGHT_VIBRANT);
        }
        return (Swatch) invokeV.objValue;
    }

    public Swatch getMutedSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return getSwatchForTarget(Target.MUTED);
        }
        return (Swatch) invokeV.objValue;
    }

    public List<Swatch> getSwatches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return Collections.unmodifiableList(this.mSwatches);
        }
        return (List) invokeV.objValue;
    }

    public List<Target> getTargets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return Collections.unmodifiableList(this.mTargets);
        }
        return (List) invokeV.objValue;
    }

    public Swatch getVibrantSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return getSwatchForTarget(Target.VIBRANT);
        }
        return (Swatch) invokeV.objValue;
    }

    public Palette(List<Swatch> list, List<Target> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSwatches = list;
        this.mTargets = list2;
        this.mUsedColors = new SparseBooleanArray();
        this.mSelectedSwatches = new ArrayMap();
        this.mDominantSwatch = findDominantSwatch();
    }

    private boolean shouldBeScoredForTarget(Swatch swatch, Target target) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, swatch, target)) == null) {
            float[] hsl = swatch.getHsl();
            if (hsl[1] >= target.getMinimumSaturation() && hsl[1] <= target.getMaximumSaturation() && hsl[2] >= target.getMinimumLightness() && hsl[2] <= target.getMaximumLightness() && !this.mUsedColors.get(swatch.getRgb())) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private Swatch findDominantSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int size = this.mSwatches.size();
            int i = Integer.MIN_VALUE;
            Swatch swatch = null;
            for (int i2 = 0; i2 < size; i2++) {
                Swatch swatch2 = this.mSwatches.get(i2);
                if (swatch2.getPopulation() > i) {
                    i = swatch2.getPopulation();
                    swatch = swatch2;
                }
            }
            return swatch;
        }
        return (Swatch) invokeV.objValue;
    }

    public void generate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int size = this.mTargets.size();
            for (int i = 0; i < size; i++) {
                Target target = this.mTargets.get(i);
                target.normalizeWeights();
                this.mSelectedSwatches.put(target, generateScoredTarget(target));
            }
            this.mUsedColors.clear();
        }
    }

    public static Builder from(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bitmap)) == null) {
            return new Builder(bitmap);
        }
        return (Builder) invokeL.objValue;
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bitmap)) == null) {
            return from(bitmap).generate();
        }
        return (Palette) invokeL.objValue;
    }

    private Swatch generateScoredTarget(Target target) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, target)) == null) {
            Swatch maxScoredSwatchForTarget = getMaxScoredSwatchForTarget(target);
            if (maxScoredSwatchForTarget != null && target.isExclusive()) {
                this.mUsedColors.append(maxScoredSwatchForTarget.getRgb(), true);
            }
            return maxScoredSwatchForTarget;
        }
        return (Swatch) invokeL.objValue;
    }

    public int getDarkMutedColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return getColorForTarget(Target.DARK_MUTED, i);
        }
        return invokeI.intValue;
    }

    public int getDarkVibrantColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return getColorForTarget(Target.DARK_VIBRANT, i);
        }
        return invokeI.intValue;
    }

    public int getDominantColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            Swatch swatch = this.mDominantSwatch;
            if (swatch != null) {
                return swatch.getRgb();
            }
            return i;
        }
        return invokeI.intValue;
    }

    public int getLightMutedColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return getColorForTarget(Target.LIGHT_MUTED, i);
        }
        return invokeI.intValue;
    }

    public int getLightVibrantColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            return getColorForTarget(Target.LIGHT_VIBRANT, i);
        }
        return invokeI.intValue;
    }

    public int getMutedColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            return getColorForTarget(Target.MUTED, i);
        }
        return invokeI.intValue;
    }

    public Swatch getSwatchForTarget(Target target) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, target)) == null) {
            return this.mSelectedSwatches.get(target);
        }
        return (Swatch) invokeL.objValue;
    }

    public int getVibrantColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            return getColorForTarget(Target.VIBRANT, i);
        }
        return invokeI.intValue;
    }

    public static Palette from(List<Swatch> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            return new Builder(list).generate();
        }
        return (Palette) invokeL.objValue;
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, bitmap, i)) == null) {
            return from(bitmap).maximumColorCount(i).generate();
        }
        return (Palette) invokeLI.objValue;
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, PaletteAsyncListener paletteAsyncListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, bitmap, paletteAsyncListener)) == null) {
            return from(bitmap).generate(paletteAsyncListener);
        }
        return (AsyncTask) invokeLL.objValue;
    }

    public int getColorForTarget(Target target, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, target, i)) == null) {
            Swatch swatchForTarget = getSwatchForTarget(target);
            if (swatchForTarget != null) {
                return swatchForTarget.getRgb();
            }
            return i;
        }
        return invokeLI.intValue;
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, int i, PaletteAsyncListener paletteAsyncListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, bitmap, i, paletteAsyncListener)) == null) {
            return from(bitmap).maximumColorCount(i).generate(paletteAsyncListener);
        }
        return (AsyncTask) invokeLIL.objValue;
    }

    private float generateScore(Swatch swatch, Target target) {
        InterceptResult invokeLL;
        int i;
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, swatch, target)) == null) {
            float[] hsl = swatch.getHsl();
            Swatch swatch2 = this.mDominantSwatch;
            if (swatch2 != null) {
                i = swatch2.getPopulation();
            } else {
                i = 1;
            }
            float f3 = 0.0f;
            if (target.getSaturationWeight() > 0.0f) {
                f = target.getSaturationWeight() * (1.0f - Math.abs(hsl[1] - target.getTargetSaturation()));
            } else {
                f = 0.0f;
            }
            if (target.getLightnessWeight() > 0.0f) {
                f2 = target.getLightnessWeight() * (1.0f - Math.abs(hsl[2] - target.getTargetLightness()));
            } else {
                f2 = 0.0f;
            }
            if (target.getPopulationWeight() > 0.0f) {
                f3 = target.getPopulationWeight() * (swatch.getPopulation() / i);
            }
            return f + f2 + f3;
        }
        return invokeLL.floatValue;
    }

    private Swatch getMaxScoredSwatchForTarget(Target target) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, target)) == null) {
            int size = this.mSwatches.size();
            float f = 0.0f;
            Swatch swatch = null;
            for (int i = 0; i < size; i++) {
                Swatch swatch2 = this.mSwatches.get(i);
                if (shouldBeScoredForTarget(swatch2, target)) {
                    float generateScore = generateScore(swatch2, target);
                    if (swatch == null || generateScore > f) {
                        swatch = swatch2;
                        f = generateScore;
                    }
                }
            }
            return swatch;
        }
        return (Swatch) invokeL.objValue;
    }
}
