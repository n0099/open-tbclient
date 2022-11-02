package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0005H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0006\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0007H\u0087\b¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Icon;", "toAdaptiveIcon", "(Landroid/graphics/Bitmap;)Landroid/graphics/drawable/Icon;", "toIcon", "Landroid/net/Uri;", "(Landroid/net/Uri;)Landroid/graphics/drawable/Icon;", "", "([B)Landroid/graphics/drawable/Icon;", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class IconKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(26)
    public static final Icon toAdaptiveIcon(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bitmap)) == null) {
            Icon createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
            Intrinsics.checkExpressionValueIsNotNull(createWithAdaptiveBitmap, "Icon.createWithAdaptiveBitmap(this)");
            return createWithAdaptiveBitmap;
        }
        return (Icon) invokeL.objValue;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bitmap)) == null) {
            Icon createWithBitmap = Icon.createWithBitmap(bitmap);
            Intrinsics.checkExpressionValueIsNotNull(createWithBitmap, "Icon.createWithBitmap(this)");
            return createWithBitmap;
        }
        return (Icon) invokeL.objValue;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uri)) == null) {
            Icon createWithContentUri = Icon.createWithContentUri(uri);
            Intrinsics.checkExpressionValueIsNotNull(createWithContentUri, "Icon.createWithContentUri(this)");
            return createWithContentUri;
        }
        return (Icon) invokeL.objValue;
    }

    @RequiresApi(26)
    public static final Icon toIcon(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            Icon createWithData = Icon.createWithData(bArr, 0, bArr.length);
            Intrinsics.checkExpressionValueIsNotNull(createWithData, "Icon.createWithData(this, 0, size)");
            return createWithData;
        }
        return (Icon) invokeL.objValue;
    }
}
