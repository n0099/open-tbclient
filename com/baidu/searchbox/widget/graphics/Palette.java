package com.baidu.searchbox.widget.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseBooleanArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes7.dex */
public final class Palette {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_CALCULATE_NUMBER_COLORS = 16;
    public static final Filter DEFAULT_FILTER;
    public static final int DEFAULT_RESIZE_BITMAP_AREA = 12544;
    public static final int HEADER_HEIGHT = 2;
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

    /* loaded from: classes7.dex */
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

        @SuppressLint({"BDThrowableCheck"})
        public Builder(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        private int[] getHeaderPixelsFromBitmap(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bitmap)) == null) ? getPixelsFromBitmap(bitmap, 2) : (int[]) invokeL.objValue;
        }

        private int[] getPixelsFromBitmap(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bitmap)) == null) ? getPixelsFromBitmap(bitmap, bitmap.getHeight()) : (int[]) invokeL.objValue;
        }

        private Bitmap scaleBitmapDown(Bitmap bitmap) {
            InterceptResult invokeL;
            int max;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bitmap)) == null) {
                double d2 = -1.0d;
                if (this.mResizeArea > 0) {
                    int width = bitmap.getWidth() * bitmap.getHeight();
                    int i3 = this.mResizeArea;
                    if (width > i3) {
                        d2 = Math.sqrt(i3 / width);
                    }
                } else if (this.mResizeMaxDimension > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i2 = this.mResizeMaxDimension)) {
                    d2 = i2 / max;
                }
                return d2 <= 0.0d ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * d2), (int) Math.ceil(bitmap.getHeight() * d2), false);
            }
            return (Bitmap) invokeL.objValue;
        }

        @NonNull
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

        @NonNull
        public Builder addTarget(@NonNull Target target) {
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

        @NonNull
        public Builder clearFilters() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.mFilters.clear();
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        @NonNull
        public Builder clearRegion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.mRegion = null;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        @NonNull
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

        @NonNull
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
                    int i2 = this.mMaxColors;
                    if (this.mFilters.isEmpty()) {
                        filterArr = null;
                    } else {
                        List<Filter> list2 = this.mFilters;
                        filterArr = (Filter[]) list2.toArray(new Filter[list2.size()]);
                    }
                    ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(pixelsFromBitmap, i2, filterArr);
                    if (scaleBitmapDown != this.mBitmap) {
                        scaleBitmapDown.recycle();
                    }
                    list = colorCutQuantizer.getQuantizedColors();
                } else {
                    list = this.mSwatches;
                }
                Palette palette = new Palette(list, this.mTargets);
                palette.generate();
                return palette;
            }
            return (Palette) invokeV.objValue;
        }

        @NonNull
        public Palette generateHeader() {
            InterceptResult invokeV;
            List<Swatch> list;
            Filter[] filterArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Bitmap bitmap = this.mBitmap;
                if (bitmap != null) {
                    Bitmap scaleBitmapDown = scaleBitmapDown(bitmap);
                    Rect rect = this.mRegion;
                    if (scaleBitmapDown != this.mBitmap && rect != null) {
                        double width = scaleBitmapDown.getWidth() / this.mBitmap.getWidth();
                        rect.left = (int) Math.floor(rect.left * width);
                        rect.top = (int) Math.floor(rect.top * width);
                        rect.right = Math.min((int) Math.ceil(rect.right * width), scaleBitmapDown.getWidth());
                        rect.bottom = 2;
                    }
                    int[] headerPixelsFromBitmap = getHeaderPixelsFromBitmap(scaleBitmapDown);
                    int i2 = this.mMaxColors;
                    if (this.mFilters.isEmpty()) {
                        filterArr = null;
                    } else {
                        List<Filter> list2 = this.mFilters;
                        filterArr = (Filter[]) list2.toArray(new Filter[list2.size()]);
                    }
                    ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(headerPixelsFromBitmap, i2, filterArr);
                    if (scaleBitmapDown != this.mBitmap) {
                        scaleBitmapDown.recycle();
                    }
                    list = colorCutQuantizer.getQuantizedColors();
                } else {
                    list = this.mSwatches;
                }
                Palette palette = new Palette(list, this.mTargets);
                palette.generate();
                return palette;
            }
            return (Palette) invokeV.objValue;
        }

        @NonNull
        public Builder maximumColorCount(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.mMaxColors = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder resizeBitmapArea(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                this.mResizeArea = i2;
                this.mResizeMaxDimension = -1;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        @Deprecated
        public Builder resizeBitmapSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.mResizeMaxDimension = i2;
                this.mResizeArea = -1;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        @SuppressLint({"BDThrowableCheck"})
        public Builder setRegion(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048587, this, i2, i3, i4, i5)) == null) {
                if (this.mBitmap != null) {
                    if (this.mRegion == null) {
                        this.mRegion = new Rect();
                    }
                    this.mRegion.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
                    if (!this.mRegion.intersect(i2, i3, i4, i5)) {
                        throw new IllegalArgumentException("The given region must intersect with the Bitmap's dimensions.");
                    }
                }
                return this;
            }
            return (Builder) invokeIIII.objValue;
        }

        private int[] getPixelsFromBitmap(Bitmap bitmap, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, bitmap, i2)) == null) {
                int width = bitmap.getWidth();
                int[] iArr = new int[width * i2];
                bitmap.getPixels(iArr, 0, width, 0, 0, width, i2);
                Rect rect = this.mRegion;
                if (rect == null) {
                    return iArr;
                }
                int width2 = rect.width();
                int height = this.mRegion.height();
                int[] iArr2 = new int[width2 * height];
                for (int i3 = 0; i3 < height; i3++) {
                    Rect rect2 = this.mRegion;
                    System.arraycopy(iArr, ((rect2.top + i3) * width) + rect2.left, iArr2, i3 * width2, width2);
                }
                return iArr2;
            }
            return (int[]) invokeLI.objValue;
        }

        @SuppressLint({"BDThrowableCheck"})
        public Builder(List<Swatch> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        @NonNull
        @SuppressLint({"BDThrowableCheck"})
        public AsyncTask<Bitmap, Void, Palette> generate(PaletteAsyncListener paletteAsyncListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, paletteAsyncListener)) == null) {
                if (paletteAsyncListener != null) {
                    return new PaletteAsyncTask(this, paletteAsyncListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.mBitmap);
                }
                throw new IllegalArgumentException("listener can not be null");
            }
            return (AsyncTask) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface Filter {
        boolean isAllowed(int i2, float[] fArr);
    }

    /* loaded from: classes7.dex */
    public interface PaletteAsyncListener {
        void onGenerated(Palette palette);
    }

    /* loaded from: classes7.dex */
    public static class PaletteAsyncTask extends AsyncTask<Bitmap, Void, Palette> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Builder mBuilder;
        public PaletteAsyncListener mListener;

        public PaletteAsyncTask(Builder builder, PaletteAsyncListener paletteAsyncListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder, paletteAsyncListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mBuilder = builder;
            this.mListener = paletteAsyncListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public Palette doInBackground(Bitmap... bitmapArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmapArr)) == null) {
                try {
                    if (this.mBuilder != null) {
                        return this.mBuilder.generate();
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return (Palette) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public void onPostExecute(Palette palette) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, palette) == null) {
                this.mListener.onGenerated(palette);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2052791859, "Lcom/baidu/searchbox/widget/graphics/Palette;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2052791859, "Lcom/baidu/searchbox/widget/graphics/Palette;");
                return;
            }
        }
        DEFAULT_FILTER = new Filter() { // from class: com.baidu.searchbox.widget.graphics.Palette.1
            public static /* synthetic */ Interceptable $ic = null;
            public static final float BLACK_MAX_LIGHTNESS = 0.05f;
            public static final float WHITE_MIN_LIGHTNESS = 0.95f;
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

            private boolean isBlack(float[] fArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, fArr)) == null) ? fArr[2] <= 0.05f : invokeL.booleanValue;
            }

            private boolean isNearRedILine(float[] fArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(65538, this, fArr)) == null) ? fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f : invokeL.booleanValue;
            }

            private boolean isWhite(float[] fArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(65539, this, fArr)) == null) ? fArr[2] >= 0.95f : invokeL.booleanValue;
            }

            @Override // com.baidu.searchbox.widget.graphics.Palette.Filter
            public boolean isAllowed(int i2, float[] fArr) {
                InterceptResult invokeIL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeIL = interceptable2.invokeIL(1048576, this, i2, fArr)) == null) ? (isWhite(fArr) || isBlack(fArr) || isNearRedILine(fArr)) ? false : true : invokeIL.booleanValue;
            }
        };
    }

    public Palette(List<Swatch> list, List<Target> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static float[] copyHslValues(Swatch swatch) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, swatch)) == null) {
            float[] fArr = new float[3];
            System.arraycopy(swatch.getHsl(), 0, fArr, 0, 3);
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    private Swatch findDominantSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int size = this.mSwatches.size();
            int i2 = Integer.MIN_VALUE;
            Swatch swatch = null;
            for (int i3 = 0; i3 < size; i3++) {
                Swatch swatch2 = this.mSwatches.get(i3);
                if (swatch2.getPopulation() > i2) {
                    i2 = swatch2.getPopulation();
                    swatch = swatch2;
                }
            }
            return swatch;
        }
        return (Swatch) invokeV.objValue;
    }

    public static Builder from(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bitmap)) == null) ? new Builder(bitmap) : (Builder) invokeL.objValue;
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bitmap)) == null) ? from(bitmap).generate() : (Palette) invokeL.objValue;
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, PaletteAsyncListener paletteAsyncListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bitmap, paletteAsyncListener)) == null) ? from(bitmap).generate(paletteAsyncListener) : (AsyncTask) invokeLL.objValue;
    }

    private float generateScore(Swatch swatch, Target target) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, swatch, target)) == null) {
            float[] hsl = swatch.getHsl();
            Swatch swatch2 = this.mDominantSwatch;
            int population = swatch2 != null ? swatch2.getPopulation() : 1;
            return (target.getSaturationWeight() > 0.0f ? target.getSaturationWeight() * (1.0f - Math.abs(hsl[1] - target.getTargetSaturation())) : 0.0f) + (target.getLightnessWeight() > 0.0f ? target.getLightnessWeight() * (1.0f - Math.abs(hsl[2] - target.getTargetLightness())) : 0.0f) + (target.getPopulationWeight() > 0.0f ? target.getPopulationWeight() * (swatch.getPopulation() / population) : 0.0f);
        }
        return invokeLL.floatValue;
    }

    private Swatch generateScoredTarget(Target target) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, target)) == null) {
            Swatch maxScoredSwatchForTarget = getMaxScoredSwatchForTarget(target);
            if (maxScoredSwatchForTarget != null && target.isExclusive()) {
                this.mUsedColors.append(maxScoredSwatchForTarget.getRgb(), true);
            }
            return maxScoredSwatchForTarget;
        }
        return (Swatch) invokeL.objValue;
    }

    private Swatch getMaxScoredSwatchForTarget(Target target) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, target)) == null) {
            int size = this.mSwatches.size();
            float f2 = 0.0f;
            Swatch swatch = null;
            for (int i2 = 0; i2 < size; i2++) {
                Swatch swatch2 = this.mSwatches.get(i2);
                if (shouldBeScoredForTarget(swatch2, target)) {
                    float generateScore = generateScore(swatch2, target);
                    if (swatch == null || generateScore > f2) {
                        swatch = swatch2;
                        f2 = generateScore;
                    }
                }
            }
            return swatch;
        }
        return (Swatch) invokeL.objValue;
    }

    private boolean shouldBeScoredForTarget(Swatch swatch, Target target) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, swatch, target)) == null) {
            float[] hsl = swatch.getHsl();
            return hsl[1] >= target.getMinimumSaturation() && hsl[1] <= target.getMaximumSaturation() && hsl[2] >= target.getMinimumLightness() && hsl[2] <= target.getMaximumLightness() && !this.mUsedColors.get(swatch.getRgb());
        }
        return invokeLL.booleanValue;
    }

    @ColorInt
    public int getColorForTarget(@NonNull Target target, @ColorInt int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, target, i2)) == null) {
            Swatch swatchForTarget = getSwatchForTarget(target);
            return swatchForTarget != null ? swatchForTarget.getRgb() : i2;
        }
        return invokeLI.intValue;
    }

    @ColorInt
    public int getDarkMutedColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? getColorForTarget(Target.DARK_MUTED, i2) : invokeI.intValue;
    }

    @Nullable
    public Swatch getDarkMutedSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getSwatchForTarget(Target.DARK_MUTED) : (Swatch) invokeV.objValue;
    }

    @ColorInt
    public int getDarkVibrantColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? getColorForTarget(Target.DARK_VIBRANT, i2) : invokeI.intValue;
    }

    @Nullable
    public Swatch getDarkVibrantSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getSwatchForTarget(Target.DARK_VIBRANT) : (Swatch) invokeV.objValue;
    }

    @ColorInt
    public int getDominantColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            Swatch swatch = this.mDominantSwatch;
            return swatch != null ? swatch.getRgb() : i2;
        }
        return invokeI.intValue;
    }

    @Nullable
    public Swatch getDominantSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mDominantSwatch : (Swatch) invokeV.objValue;
    }

    @ColorInt
    public int getLightMutedColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? getColorForTarget(Target.LIGHT_MUTED, i2) : invokeI.intValue;
    }

    @Nullable
    public Swatch getLightMutedSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getSwatchForTarget(Target.LIGHT_MUTED) : (Swatch) invokeV.objValue;
    }

    @ColorInt
    public int getLightVibrantColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? getColorForTarget(Target.LIGHT_VIBRANT, i2) : invokeI.intValue;
    }

    @Nullable
    public Swatch getLightVibrantSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? getSwatchForTarget(Target.LIGHT_VIBRANT) : (Swatch) invokeV.objValue;
    }

    @ColorInt
    public int getMutedColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? getColorForTarget(Target.MUTED, i2) : invokeI.intValue;
    }

    @Nullable
    public Swatch getMutedSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getSwatchForTarget(Target.MUTED) : (Swatch) invokeV.objValue;
    }

    @Nullable
    public Swatch getSwatchForTarget(@NonNull Target target) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, target)) == null) ? this.mSelectedSwatches.get(target) : (Swatch) invokeL.objValue;
    }

    @NonNull
    public List<Swatch> getSwatches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? Collections.unmodifiableList(this.mSwatches) : (List) invokeV.objValue;
    }

    @NonNull
    public List<Target> getTargets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? Collections.unmodifiableList(this.mTargets) : (List) invokeV.objValue;
    }

    @ColorInt
    public int getVibrantColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? getColorForTarget(Target.VIBRANT, i2) : invokeI.intValue;
    }

    @Nullable
    public Swatch getVibrantSwatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? getSwatchForTarget(Target.VIBRANT) : (Swatch) invokeV.objValue;
    }

    public static Palette from(List<Swatch> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, list)) == null) ? new Builder(list).generate() : (Palette) invokeL.objValue;
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, int i2, PaletteAsyncListener paletteAsyncListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65544, null, bitmap, i2, paletteAsyncListener)) == null) ? from(bitmap).maximumColorCount(i2).generate(paletteAsyncListener) : (AsyncTask) invokeLIL.objValue;
    }

    public void generate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int size = this.mTargets.size();
            for (int i2 = 0; i2 < size; i2++) {
                Target target = this.mTargets.get(i2);
                target.normalizeWeights();
                this.mSelectedSwatches.put(target, generateScoredTarget(target));
            }
            this.mUsedColors.clear();
        }
    }

    /* loaded from: classes7.dex */
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

        public Swatch(@ColorInt int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRed = Color.red(i2);
            this.mGreen = Color.green(i2);
            this.mBlue = Color.blue(i2);
            this.mRgb = i2;
            this.mPopulation = i3;
        }

        private void ensureTextColorsGenerated() {
            int alphaComponent;
            int alphaComponent2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.mGeneratedTextColors) {
                return;
            }
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
                return this.mPopulation == swatch.mPopulation && this.mRgb == swatch.mRgb;
            }
            return invokeL.booleanValue;
        }

        @ColorInt
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPopulation : invokeV.intValue;
        }

        @ColorInt
        public int getRgb() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRgb : invokeV.intValue;
        }

        @ColorInt
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.mRgb * 31) + this.mPopulation : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return Swatch.class.getSimpleName() + " [RGB: #" + Integer.toHexString(getRgb()) + "] [HSL: " + Arrays.toString(getHsl()) + "] [Population: " + this.mPopulation + "] [Title Text: #" + Integer.toHexString(getTitleTextColor()) + "] [Body Text: #" + Integer.toHexString(getBodyTextColor()) + ']';
            }
            return (String) invokeV.objValue;
        }

        public Swatch(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mRed = i2;
            this.mGreen = i3;
            this.mBlue = i4;
            this.mRgb = Color.rgb(i2, i3, i4);
            this.mPopulation = i5;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Swatch(float[] fArr, int i2) {
            this(ColorUtils.HSLToColor(fArr), i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fArr, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mHsl = fArr;
        }
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, bitmap, i2)) == null) ? from(bitmap).maximumColorCount(i2).generate() : (Palette) invokeLI.objValue;
    }
}
