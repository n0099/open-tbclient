package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
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
    public final DocumentFile mParent;

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String str);

    public abstract DocumentFile createFile(String str, String str2);

    public abstract boolean delete();

    public abstract boolean exists();

    public abstract String getName();

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String str);

    public DocumentFile(DocumentFile documentFile) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {documentFile};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mParent = documentFile;
    }

    public static DocumentFile fromFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            return new RawDocumentFile(null, file);
        }
        return (DocumentFile) invokeL.objValue;
    }

    public DocumentFile findFile(String str) {
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

    public static DocumentFile fromSingleUri(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, uri)) == null) {
            if (Build.VERSION.SDK_INT < 19) {
                return null;
            }
            return new SingleDocumentFile(null, context, uri);
        }
        return (DocumentFile) invokeLL.objValue;
    }

    public static DocumentFile fromTreeUri(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, uri)) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new TreeDocumentFile(null, context, DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri)));
        }
        return (DocumentFile) invokeLL.objValue;
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, uri)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return DocumentsContract.isDocumentUri(context, uri);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public DocumentFile getParentFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mParent;
        }
        return (DocumentFile) invokeV.objValue;
    }
}
