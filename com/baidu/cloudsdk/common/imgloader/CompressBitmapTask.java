package com.baidu.cloudsdk.common.imgloader;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class CompressBitmapTask extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public ICompressBitmapListener mListener;

    /* loaded from: classes.dex */
    public interface ICompressBitmapListener {
        void onComplete(ByteArrayOutputStream byteArrayOutputStream);
    }

    public CompressBitmapTask(Context context, ICompressBitmapListener iCompressBitmapListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iCompressBitmapListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mListener = iCompressBitmapListener;
    }

    private InputStream getInputStreamFromUri(Uri uri) {
        InterceptResult invokeL;
        InputStream openInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, uri)) == null) {
            try {
                if (uri.getScheme() == null) {
                    openInputStream = new FileInputStream(new File(uri.toString()));
                } else if ((!uri.getScheme().equalsIgnoreCase("content") && !uri.getScheme().equalsIgnoreCase("file")) || this.mContext == null) {
                    return null;
                } else {
                    openInputStream = this.mContext.getContentResolver().openInputStream(uri);
                }
                return openInputStream;
            } catch (IOException e) {
                Log.e("CompressBitmap", "IOexception");
                e.printStackTrace();
                return null;
            }
        }
        return (InputStream) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public ByteArrayOutputStream doInBackground(Uri... uriArr) {
        InterceptResult invokeL;
        InputStream inputStreamFromUri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uriArr)) == null) {
            if (uriArr[0] != null && (inputStreamFromUri = getInputStreamFromUri(uriArr[0])) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    try {
                        int read = inputStreamFromUri.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                inputStreamFromUri.close();
                return byteArrayOutputStream;
            }
            return null;
        }
        return (ByteArrayOutputStream) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public void onPostExecute(ByteArrayOutputStream byteArrayOutputStream) {
        ICompressBitmapListener iCompressBitmapListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteArrayOutputStream) == null) && (iCompressBitmapListener = this.mListener) != null) {
            iCompressBitmapListener.onComplete(byteArrayOutputStream);
        }
    }
}
