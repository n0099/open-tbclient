package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/graphics/Shader;", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "transform", "(Landroid/graphics/Shader;Lkotlin/Function1;)V", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class ShaderKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void transform(Shader shader, Function1<? super Matrix, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, shader, function1) == null) {
            Matrix matrix = new Matrix();
            shader.getLocalMatrix(matrix);
            function1.invoke(matrix);
            shader.setLocalMatrix(matrix);
        }
    }
}
