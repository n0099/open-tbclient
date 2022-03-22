package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RawDocumentFile extends DocumentFile {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File mFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawDocumentFile(@Nullable DocumentFile documentFile, File file) {
        super(documentFile);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {documentFile, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((DocumentFile) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFile = file;
    }

    public static boolean deleteContents(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            File[] listFiles = file.listFiles();
            boolean z = true;
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        z &= deleteContents(file2);
                    }
                    if (!file2.delete()) {
                        Log.w("DocumentFile", "Failed to delete " + file2);
                        z = false;
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static String getTypeForName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf >= 0) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1).toLowerCase());
                return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
            }
            return "application/octet-stream";
        }
        return (String) invokeL.objValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mFile.canRead() : invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFile.canWrite() : invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createDirectory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            File file = new File(this.mFile, str);
            if (file.isDirectory() || file.mkdir()) {
                return new RawDocumentFile(this, file);
            }
            return null;
        }
        return (DocumentFile) invokeL.objValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
            if (extensionFromMimeType != null) {
                str2 = str2 + "." + extensionFromMimeType;
            }
            File file = new File(this.mFile, str2);
            try {
                file.createNewFile();
                return new RawDocumentFile(this, file);
            } catch (IOException e2) {
                Log.w("DocumentFile", "Failed to createFile: " + e2);
                return null;
            }
        }
        return (DocumentFile) invokeLL.objValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            deleteContents(this.mFile);
            return this.mFile.delete();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFile.exists() : invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mFile.getName() : (String) invokeV.objValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mFile.isDirectory()) {
                return null;
            }
            return getTypeForName(this.mFile.getName());
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Uri.fromFile(this.mFile) : (Uri) invokeV.objValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mFile.isDirectory() : invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mFile.isFile() : invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mFile.lastModified() : invokeV.longValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mFile.length() : invokeV.longValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ArrayList arrayList = new ArrayList();
            File[] listFiles = this.mFile.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    arrayList.add(new RawDocumentFile(this, file));
                }
            }
            return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
        }
        return (DocumentFile[]) invokeV.objValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            File file = new File(this.mFile.getParentFile(), str);
            if (this.mFile.renameTo(file)) {
                this.mFile = file;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
