package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aY\u0010\f\u001a\u00020\u000b*\u00020\u00002C\b\u0004\u0010\n\u001a=\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\u0002\b\tH\u0087\b¢\u0006\u0004\b\f\u0010\r\u001aY\u0010\u000f\u001a\u00020\u000e*\u00020\u00002C\b\u0004\u0010\n\u001a=\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\u0002\b\tH\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroid/graphics/ImageDecoder$Source;", "Lkotlin/Function3;", "Landroid/graphics/ImageDecoder;", "Landroid/graphics/ImageDecoder$ImageInfo;", "Lkotlin/ParameterName;", "name", "info", "source", "", "Lkotlin/ExtensionFunctionType;", "action", "Landroid/graphics/Bitmap;", "decodeBitmap", "(Landroid/graphics/ImageDecoder$Source;Lkotlin/Function3;)Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "decodeDrawable", "(Landroid/graphics/ImageDecoder$Source;Lkotlin/Function3;)Landroid/graphics/drawable/Drawable;", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class ImageDecoderKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source source, final Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, source, function3)) == null) {
            Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, new ImageDecoder.OnHeaderDecodedListener(function3) { // from class: androidx.core.graphics.ImageDecoderKt$decodeBitmap$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Function3 $action;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$action = function3;
                }

                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, imageDecoder, imageInfo, source2) == null) {
                        this.$action.invoke(imageDecoder, imageInfo, source2);
                    }
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(decodeBitmap, "ImageDecoder.decodeBitma…ction(info, source)\n    }");
            return decodeBitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source source, final Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, source, function3)) == null) {
            Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new ImageDecoder.OnHeaderDecodedListener(function3) { // from class: androidx.core.graphics.ImageDecoderKt$decodeDrawable$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Function3 $action;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$action = function3;
                }

                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, imageDecoder, imageInfo, source2) == null) {
                        this.$action.invoke(imageDecoder, imageInfo, source2);
                    }
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(decodeDrawable, "ImageDecoder.decodeDrawa…ction(info, source)\n    }");
            return decodeDrawable;
        }
        return (Drawable) invokeLL.objValue;
    }
}
