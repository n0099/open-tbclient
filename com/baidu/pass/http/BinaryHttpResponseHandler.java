package com.baidu.pass.http;

import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class BinaryHttpResponseHandler extends HttpResponseHandler implements com.baidu.pass.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinaryHttpResponseHandler(Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"};
    }

    @Override // com.baidu.pass.http.HttpResponseHandler
    public void a(int i, HashMap<String, String> hashMap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, hashMap, bArr) == null) {
            if (hashMap != null && hashMap.get("Content-Type") != null) {
                String str = hashMap.get("Content-Type");
                String[] strArr = this.a;
                int length = strArr.length;
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (strArr[i2].equalsIgnoreCase(str)) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    b(new HttpErrorException(i, "Content-Type not allowed!"), null);
                    return;
                } else {
                    onSuccess(i, bArr);
                    return;
                }
            }
            b(new HttpErrorException(i, "None or more than one Content-Type Header found!"), null);
        }
    }

    @Override // com.baidu.pass.http.HttpResponseHandler
    public void c(int i, HashMap<String, String> hashMap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, hashMap, bArr) == null) {
            if (this.executCallbackInChildThread) {
                a(i, hashMap, bArr);
            } else {
                sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), hashMap, bArr}));
            }
        }
    }

    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BinaryHttpResponseHandler(Looper looper, String[] strArr) {
        this(looper, strArr, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper, strArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Looper) objArr2[0], (String[]) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinaryHttpResponseHandler(Looper looper, String[] strArr, boolean z) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper, strArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"};
        this.a = strArr;
        this.executCallbackInChildThread = z;
    }
}
