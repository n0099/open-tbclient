package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class SingleDocumentFile extends DocumentFile {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Uri mUri;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleDocumentFile(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {documentFile, context, uri};
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
        this.mContext = context;
        this.mUri = uri;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return DocumentsContractApi19.canRead(this.mContext, this.mUri);
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return DocumentsContractApi19.exists(this.mContext, this.mUri);
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return DocumentsContractApi19.getName(this.mContext, this.mUri);
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return DocumentsContractApi19.getType(this.mContext, this.mUri);
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mUri;
        }
        return (Uri) invokeV.objValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return DocumentsContractApi19.isFile(this.mContext, this.mUri);
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
        }
        return invokeV.longValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return DocumentsContractApi19.length(this.mContext, this.mUri);
        }
        return invokeV.longValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (DocumentFile[]) invokeV.objValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createDirectory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            throw new UnsupportedOperationException();
        }
        return (DocumentFile) invokeL.objValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            throw new UnsupportedOperationException();
        }
        return (DocumentFile) invokeLL.objValue;
    }
}
