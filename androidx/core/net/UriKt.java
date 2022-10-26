package androidx.core.net;

import android.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\u0004\u001a\u00020\u0000*\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/net/Uri;", "Ljava/io/File;", "toFile", "(Landroid/net/Uri;)Ljava/io/File;", "toUri", "(Ljava/io/File;)Landroid/net/Uri;", "", "(Ljava/lang/String;)Landroid/net/Uri;", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class UriKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final File toFile(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            if (Intrinsics.areEqual(uri.getScheme(), "file")) {
                String path = uri.getPath();
                if (path != null) {
                    return new File(path);
                }
                throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
            }
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
        }
        return (File) invokeL.objValue;
    }

    public static final Uri toUri(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            Uri fromFile = Uri.fromFile(file);
            Intrinsics.checkExpressionValueIsNotNull(fromFile, "Uri.fromFile(this)");
            return fromFile;
        }
        return (Uri) invokeL.objValue;
    }

    public static final Uri toUri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Uri parse = Uri.parse(str);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
            return parse;
        }
        return (Uri) invokeL.objValue;
    }
}
