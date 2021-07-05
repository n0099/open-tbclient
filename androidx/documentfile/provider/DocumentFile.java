package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public abstract class DocumentFile {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DocumentFile";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final DocumentFile mParent;

    public DocumentFile(@Nullable DocumentFile documentFile) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {documentFile};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mParent = documentFile;
    }

    @NonNull
    public static DocumentFile fromFile(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) ? new RawDocumentFile(null, file) : (DocumentFile) invokeL.objValue;
    }

    @Nullable
    public static DocumentFile fromSingleUri(@NonNull Context context, @NonNull Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, uri)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new SingleDocumentFile(null, context, uri);
            }
            return null;
        }
        return (DocumentFile) invokeLL.objValue;
    }

    @Nullable
    public static DocumentFile fromTreeUri(@NonNull Context context, @NonNull Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, uri)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new TreeDocumentFile(null, context, DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri)));
            }
            return null;
        }
        return (DocumentFile) invokeLL.objValue;
    }

    public static boolean isDocumentUri(@NonNull Context context, @Nullable Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, context, uri)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return DocumentsContract.isDocumentUri(context, uri);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    @Nullable
    public abstract DocumentFile createDirectory(@NonNull String str);

    @Nullable
    public abstract DocumentFile createFile(@NonNull String str, @NonNull String str2);

    public abstract boolean delete();

    public abstract boolean exists();

    @Nullable
    public DocumentFile findFile(@NonNull String str) {
        InterceptResult invokeL;
        DocumentFile[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            for (DocumentFile documentFile : listFiles()) {
                if (str.equals(documentFile.getName())) {
                    return documentFile;
                }
            }
            return null;
        }
        return (DocumentFile) invokeL.objValue;
    }

    @Nullable
    public abstract String getName();

    @Nullable
    public DocumentFile getParentFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mParent : (DocumentFile) invokeV.objValue;
    }

    @Nullable
    public abstract String getType();

    @NonNull
    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    @NonNull
    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(@NonNull String str);
}
