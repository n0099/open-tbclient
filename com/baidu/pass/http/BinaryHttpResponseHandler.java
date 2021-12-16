package com.baidu.pass.http;

import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"};
    }

    @Override // com.baidu.pass.http.HttpResponseHandler
    public void a(int i2, HashMap<String, String> hashMap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, hashMap, bArr) == null) {
            if (hashMap != null && hashMap.get("Content-Type") != null) {
                String str = hashMap.get("Content-Type");
                String[] strArr = this.a;
                int length = strArr.length;
                boolean z = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (strArr[i3].equalsIgnoreCase(str)) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    b(new HttpErrorException(i2, "Content-Type not allowed!"), null);
                    return;
                } else {
                    onSuccess(i2, bArr);
                    return;
                }
            }
            b(new HttpErrorException(i2, "None or more than one Content-Type Header found!"), null);
        }
    }

    @Override // com.baidu.pass.http.HttpResponseHandler
    public void c(int i2, HashMap<String, String> hashMap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, hashMap, bArr) == null) {
            if (this.executCallbackInChildThread) {
                a(i2, hashMap, bArr);
            } else {
                sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i2), hashMap, bArr}));
            }
        }
    }

    public void onSuccess(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bArr) == null) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
