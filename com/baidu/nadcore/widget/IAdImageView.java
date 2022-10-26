package com.baidu.nadcore.widget;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes2.dex */
public interface IAdImageView {
    public static final ImageView.ScaleType[] k0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public final class ImageScaleType {
        public static final /* synthetic */ ImageScaleType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ImageScaleType CENTER;
        public static final ImageScaleType CENTER_CROP;
        public static final ImageScaleType CENTER_INSIDE;
        public static final ImageScaleType FIT_CENTER;
        public static final ImageScaleType FIT_END;
        public static final ImageScaleType FIT_START;
        public static final ImageScaleType FIT_XY;
        public static final ImageScaleType MATRIX;
        public static final ImageScaleType NONE;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeInt;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1406716032, "Lcom/baidu/nadcore/widget/IAdImageView$ImageScaleType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1406716032, "Lcom/baidu/nadcore/widget/IAdImageView$ImageScaleType;");
                    return;
                }
            }
            NONE = new ImageScaleType(HlsPlaylistParser.METHOD_NONE, 0, -1);
            MATRIX = new ImageScaleType("MATRIX", 1, 0);
            FIT_XY = new ImageScaleType("FIT_XY", 2, 1);
            FIT_START = new ImageScaleType("FIT_START", 3, 2);
            FIT_CENTER = new ImageScaleType("FIT_CENTER", 4, 3);
            FIT_END = new ImageScaleType("FIT_END", 5, 4);
            CENTER = new ImageScaleType("CENTER", 6, 5);
            CENTER_CROP = new ImageScaleType("CENTER_CROP", 7, 6);
            ImageScaleType imageScaleType = new ImageScaleType("CENTER_INSIDE", 8, 7);
            CENTER_INSIDE = imageScaleType;
            $VALUES = new ImageScaleType[]{NONE, MATRIX, FIT_XY, FIT_START, FIT_CENTER, FIT_END, CENTER, CENTER_CROP, imageScaleType};
        }

        public ImageScaleType(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.nativeInt = i2;
        }

        public static ImageScaleType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ImageScaleType) Enum.valueOf(ImageScaleType.class, str);
            }
            return (ImageScaleType) invokeL.objValue;
        }

        public static ImageScaleType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ImageScaleType[]) $VALUES.clone();
            }
            return (ImageScaleType[]) invokeV.objValue;
        }
    }
}
