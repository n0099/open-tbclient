package com.baidu.ar.steploading;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.h.t;
import com.baidu.ar.ihttp.Downloader;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class c extends com.baidu.ar.e.a<String, Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IProgressCallback qN;
    public ARCaseBundleInfo xx;
    public String xy;
    public a xz;

    public c(ARCaseBundleInfo aRCaseBundleInfo, String str, a aVar, IProgressCallback iProgressCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aRCaseBundleInfo, str, aVar, iProgressCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.xx = aRCaseBundleInfo;
        this.xy = str;
        this.xz = aVar;
        this.qN = iProgressCallback;
    }

    private String a(f fVar) {
        InterceptResult invokeL;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, fVar)) == null) {
            String parent = new File(this.xx.caseDir).getParent();
            if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(fVar.xM)) {
                str = String.format("/temp/%s.zip", fVar.xL);
                sb = new StringBuilder();
                sb.append(parent);
            } else if (!"identity".equalsIgnoreCase(fVar.xM)) {
                return null;
            } else {
                sb = new StringBuilder();
                sb.append(parent);
                sb.append(File.separator);
                str = fVar.xK;
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private boolean a(String str, f fVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, this, str, fVar, i2)) == null) {
            File file = new File(str);
            if (file.exists() && file.length() == i2) {
                if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(fVar.xM)) {
                    return t.a(new File(str), new File(this.xx.caseDir).getParentFile());
                }
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.e.a
    public void a(String str, ICallbackWith<Void> iCallbackWith, IError iError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, iCallbackWith, iError) == null) {
            if (TextUtils.isEmpty(str)) {
                iError.onError(2, "res url is not exists", null);
            } else if ("local".equals(str)) {
                iCallbackWith.run(null);
            } else {
                f aN = this.xz.aN(this.xy);
                if (aN == null) {
                    iError.onError(2, "res is not exists", null);
                    return;
                }
                String a2 = a(aN);
                if (a2 == null) {
                    iError.onError(2, "未知的资源encoding", null);
                    return;
                }
                Downloader downloader = new Downloader(str);
                try {
                    int fileSize = downloader.getFileSize();
                    if (!a(a2, aN, fileSize)) {
                        try {
                            downloader.download(a2, this.qN);
                            if (!a(a2, aN, fileSize)) {
                                iError.onError(2, "download fail", null);
                                return;
                            }
                        } catch (Exception e2) {
                            iError.onError(2, e2.getMessage(), e2);
                            return;
                        }
                    }
                    iCallbackWith.run(null);
                } catch (HttpException e3) {
                    iError.onError(2, e3.getMessage(), e3);
                }
            }
        }
    }

    @Override // com.baidu.ar.e.a
    public void fp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
