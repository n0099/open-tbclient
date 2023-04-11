package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.NetWorkState;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.util.httpNet.HttpResponse;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.switchs.NetDeleteSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
import com.baidu.tieba.hf;
import com.baidu.tieba.hi;
import com.baidu.tieba.jf;
import com.baidu.tieba.kf;
import com.baidu.tieba.mf;
import com.baidu.tieba.of;
import com.baidu.tieba.pi;
import com.baidu.tieba.uf;
import com.baidu.tieba.ur5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class NetWorkCoreByBdHttp implements INetWorkCore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFERSIZE = 1024;
    public static int MAX_DATA_LENG = 2097152;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public uf manager;
    public final HttpNetContext netContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1220900749, "Lcom/baidu/tbadk/core/util/NetWorkCoreByBdHttp;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1220900749, "Lcom/baidu/tbadk/core/util/NetWorkCoreByBdHttp;");
        }
    }

    private int getMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i)) == null) {
            if (i != 1) {
                if (i == 2) {
                    return 2;
                }
                if (i == 3) {
                    return 3;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public NetWorkCoreByBdHttp(HttpNetContext httpNetContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpNetContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.manager = new uf();
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.netContext = httpNetContext;
        uf.u(ur5.b());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void addPerformanceData(long j, long j2, int i) {
        uf ufVar;
        hf f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) != null) || this.netContext == null || (ufVar = this.manager) == null || (f = ufVar.f()) == null) {
            return;
        }
        long g = f.g();
        long i2 = f.i();
        long f2 = f.f();
        long h = f.h();
        long e = f.e();
        long j3 = g - j;
        long j4 = i2 - g;
        int j5 = f.j();
        long j6 = h - i2;
        long j7 = f2 - i2;
        long j8 = h - f2;
        long j9 = e - h;
        if (e <= 0) {
            j9 = 0;
        }
        HashMap<String, String> performance = this.netContext.getPerformance();
        performance.put("startTime", String.valueOf(System.currentTimeMillis()));
        performance.put("netConTime", String.valueOf(j3));
        performance.put("netRWTime", String.valueOf(j6));
        performance.put("firstByteTime", String.valueOf(j7));
        performance.put("allDataReadTime", String.valueOf(j8));
        performance.put("dataDeCompressTime", String.valueOf(j9));
        performance.put("httpRetryNum", String.valueOf(j5));
        performance.put("httpRetryCostTime", String.valueOf(j4));
        performance.put("dataParseTime", String.valueOf(j2 - e));
        performance.put("isHttp", "1");
        performance.put("httpSize", String.valueOf(i));
        performance.put(StatConstants.KEY_EXT_ERR_CODE, String.valueOf(this.netContext.getResponse().mNetErrorCode));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        if (r2 < r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getAddPostIndex(ArrayList<BasicNameValuePair> arrayList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, arrayList, str)) == null) {
            if (arrayList == null || str == null) {
                return -1;
            }
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                int compareTo = str.compareTo(arrayList.get(i).getName());
                if (compareTo < 0) {
                    i2 = i;
                    break;
                } else if (compareTo == 0) {
                    return -1;
                } else {
                    i2 = i;
                    i++;
                }
            }
        } else {
            return invokeLL.intValue;
        }
    }

    private LinkedList<BasicNameValuePair> getExtendHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.netContext != null) {
                LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
                if (!TextUtils.isEmpty(this.netContext.getRequest().mSeqId)) {
                    linkedList.add(new BasicNameValuePair("sid", this.netContext.getRequest().mSeqId));
                }
                if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.netContext.getRequest().mNetType)) {
                    linkedList.add(new BasicNameValuePair("net", this.netContext.getRequest().mNetType));
                }
                return linkedList;
            }
            return null;
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String getNetString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            byte[] netData = getNetData();
            String str2 = null;
            if (netData == null || this.netContext.getResponse().mNetErrorCode != 200) {
                return null;
            }
            try {
                HttpRequest request = this.netContext.getRequest();
                if (TextUtils.isEmpty(this.netContext.getRequest().charSet)) {
                    str = "UTF-8";
                } else {
                    str = this.netContext.getRequest().charSet;
                }
                request.charSet = str;
                String str3 = new String(netData, 0, netData.length, this.netContext.getRequest().charSet);
                try {
                    parseServerCode(str3);
                    return str3;
                } catch (Exception e) {
                    e = e;
                    str2 = str3;
                    BdLog.e(e.getMessage());
                    return str2;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    str2 = str3;
                    BdLog.e(e.getMessage());
                    return str2;
                }
            } catch (Exception e3) {
                e = e3;
            } catch (OutOfMemoryError e4) {
                e = e4;
            }
        } else {
            return (String) invokeV.objValue;
        }
    }

    private void initNetWork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mContext = null;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void cancelNetConnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.manager.c();
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public ArrayList<BasicNameValuePair> getPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.netContext.getRequest().mPostData;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public boolean isCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.manager.j();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setCancel() {
        uf ufVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (ufVar = this.manager) != null) {
            ufVar.m();
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            addPostData(new BasicNameValuePair(str, str2));
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr) == null) {
            if (this.netContext.getRequest().mFileData == null) {
                this.netContext.getRequest().mFileData = new HashMap<>();
            }
            this.netContext.getRequest().mFileData.put(str, bArr);
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, basicNameValuePair) == null) && basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.netContext.getRequest().mPostData == null) {
                this.netContext.getRequest().mPostData = new ArrayList<>();
            }
            int addPostIndex = getAddPostIndex(this.netContext.getRequest().mPostData, basicNameValuePair.getName());
            int size = this.netContext.getRequest().mPostData.size();
            if (addPostIndex >= 0 && addPostIndex < size) {
                if (basicNameValuePair.getName().equals(this.netContext.getRequest().mPostData.get(addPostIndex).getName())) {
                    this.netContext.getRequest().mPostData.set(addPostIndex, basicNameValuePair);
                } else {
                    this.netContext.getRequest().mPostData.add(addPostIndex, basicNameValuePair);
                }
            } else if (addPostIndex == size) {
                this.netContext.getRequest().mPostData.add(addPostIndex, basicNameValuePair);
            }
        }
    }

    public void parseServerCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.netContext.getResponse().mServerErrorCode = -1;
            try {
                if (str != null) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(str);
                    this.netContext.getResponse().mServerErrorCode = errorData.getError_code();
                    if (this.netContext.getResponse().mServerErrorCode == -1) {
                        this.netContext.getResponse().mErrorString = this.mContext.getString(R.string.obfuscated_res_0x7f0f05ec);
                    } else if (this.netContext.getResponse().mServerErrorCode != 0) {
                        this.netContext.getResponse().mErrorString = errorData.getError_msg();
                    }
                } else {
                    this.netContext.getResponse().mErrorString = this.mContext.getString(R.string.obfuscated_res_0x7f0f05ec);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.netContext.getResponse().mErrorString = this.mContext.getString(R.string.obfuscated_res_0x7f0f05ec);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e8, code lost:
        if (r9 > 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ea, code lost:
        r0 = r0.d().get(r9 - 1);
        r10.append("-netErrorCode-");
        r10.append(r8);
        r10.append("-exception-");
        r10.append(r0.h);
        r10.append("-url-");
        r10.append(r0.s);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x010c, code lost:
        r23.dispatchMessage(r23.obtainMessage(-1, r8, -1, r10.toString()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0168, code lost:
        if (r9 > 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01d0, code lost:
        if (r9 > 0) goto L29;
     */
    @Override // com.baidu.tbadk.core.util.INetWorkCore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        kf e;
        int i4;
        int size;
        StringBuilder sb;
        kf e2;
        File CreateFileIfNotFoundInCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, handler, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            boolean z2 = false;
            try {
                try {
                } catch (Exception e3) {
                    this.netContext.getResponse().mNetErrorCode = -10;
                    HttpResponse response = this.netContext.getResponse();
                    response.mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b) + " detailException:" + e3.getMessage();
                    BdLog.e(e3.getMessage());
                    if (!z2 && (e = this.manager.e()) != null && e.d() != null && handler != null) {
                        i4 = e.c().c;
                        size = e.d().size();
                        sb = new StringBuilder();
                    }
                } catch (OutOfMemoryError e4) {
                    this.netContext.getResponse().mNetErrorCode = -15;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0b8c);
                    BdLog.e(e4.getMessage());
                    if (!z2 && (e = this.manager.e()) != null && e.d() != null && handler != null) {
                        i4 = e.c().c;
                        size = e.d().size();
                        sb = new StringBuilder();
                    }
                }
                if (this.manager.j()) {
                    kf e5 = this.manager.e();
                    if (e5 != null && e5.d() != null && handler != null) {
                        int i5 = e5.c().c;
                        int size2 = e5.d().size();
                        StringBuilder sb2 = new StringBuilder();
                        if (size2 > 0) {
                            jf jfVar = e5.d().get(size2 - 1);
                            sb2.append("-netErrorCode-");
                            sb2.append(i5);
                            sb2.append("-exception-");
                            sb2.append(jfVar.h);
                            sb2.append("-url-");
                            sb2.append(jfVar.s);
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, sb2.toString()));
                    }
                    return false;
                }
                if (z) {
                    CreateFileIfNotFoundInCache = new File(str);
                } else {
                    CreateFileIfNotFoundInCache = FileHelper.CreateFileIfNotFoundInCache(str);
                }
                z2 = this.manager.d(this.netContext.getRequest().mUrl, CreateFileIfNotFoundInCache.getAbsolutePath(), false, i2, i3, -1, -1, getExtendHeader(), new of(this, handler, i) { // from class: com.baidu.tbadk.core.util.NetWorkCoreByBdHttp.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public int lastLength;
                    public int notify_num;
                    public int notify_tmp;
                    public final /* synthetic */ NetWorkCoreByBdHttp this$0;
                    public final /* synthetic */ Handler val$handler;
                    public final /* synthetic */ int val$what;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, handler, Integer.valueOf(i)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i6 = newInitContext.flag;
                            if ((i6 & 1) != 0) {
                                int i7 = i6 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$handler = handler;
                        this.val$what = i;
                        this.notify_num = 0;
                        this.notify_tmp = 0;
                        this.lastLength = 0;
                    }

                    @Override // com.baidu.tieba.of
                    public void onProgress(int i6, int i7) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeII(1048576, this, i6, i7) == null) {
                            if (i7 > 0) {
                                this.notify_num = i7 / 50;
                            }
                            int i8 = this.notify_tmp + (i6 - this.lastLength);
                            this.notify_tmp = i8;
                            this.lastLength = i6;
                            if (this.val$handler != null) {
                                if (i8 > this.notify_num || i6 == i7) {
                                    this.notify_tmp = 0;
                                    Handler handler2 = this.val$handler;
                                    handler2.sendMessage(handler2.obtainMessage(this.val$what, i6, i7));
                                }
                            }
                        }
                    }
                }, true, false, this.netContext.getRequest().mCanHttpsDownToHttp);
                this.netContext.getResponse().mNetErrorCode = this.manager.e().c().b;
                if (!z2 && (e = this.manager.e()) != null && e.d() != null && handler != null) {
                    i4 = e.c().c;
                    size = e.d().size();
                    sb = new StringBuilder();
                }
                return z2;
            } catch (Throwable th) {
                if (!z2 && (e2 = this.manager.e()) != null && e2.d() != null && handler != null) {
                    int i6 = e2.c().c;
                    int size3 = e2.d().size();
                    StringBuilder sb3 = new StringBuilder();
                    if (size3 > 0) {
                        jf jfVar2 = e2.d().get(size3 - 1);
                        sb3.append("-netErrorCode-");
                        sb3.append(i6);
                        sb3.append("-exception-");
                        sb3.append(jfVar2.h);
                        sb3.append("-url-");
                        sb3.append(jfVar2.s);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, sb3.toString()));
                }
                throw th;
            }
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x051d A[RETURN] */
    @Override // com.baidu.tbadk.core.util.INetWorkCore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
        InterceptResult invokeV;
        Exception exc;
        mf mfVar;
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        OutOfMemoryError outOfMemoryError;
        BdHttpCancelException bdHttpCancelException;
        String str;
        String str2;
        boolean z;
        int size;
        String str3;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            uf.t(TbadkCoreApplication.getCurrentAccount());
            int i2 = -1;
            try {
                if (this.netContext.getRequest().mPostData != null && this.netContext.getRequest().mPostData.size() > 0 && !this.netContext.getRequest().mIsFromCDN) {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.netContext.getRequest().mUrl);
                    if (this.netContext.getRequest().mUrl.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.netContext.getRequest().mUrl.endsWith("?") && !this.netContext.getRequest().mUrl.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i3 = 0; i3 < this.netContext.getRequest().mPostData.size(); i3++) {
                        if (i3 != 0) {
                            sb.append("&");
                        }
                        sb.append(this.netContext.getRequest().mPostData.get(i3).getName());
                        sb.append("=");
                        sb.append(hi.getUrlEncode(this.netContext.getRequest().mPostData.get(i3).getValue()));
                    }
                    str = sb.toString();
                } else {
                    str = this.netContext.getRequest().mUrl;
                }
                str2 = str;
                TbConfig.getDebugSwitch();
                if ((this.netContext.getRequest().mRequestGzip && !this.netContext.getRequest().mIsBDImage) || this.netContext.getRequest().mIsFromCDN) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (BdHttpCancelException e) {
                bdHttpCancelException = e;
                mfVar = null;
            } catch (OutOfMemoryError e2) {
                outOfMemoryError = e2;
                mfVar = null;
            } catch (SocketException e3) {
                socketException = e3;
                mfVar = null;
            } catch (SocketTimeoutException e4) {
                socketTimeoutException = e4;
                mfVar = null;
            } catch (Exception e5) {
                exc = e5;
                mfVar = null;
            }
            if (!this.manager.j()) {
                long time = new Date().getTime();
                this.manager.h(str2, z, 5, -1, -1);
                kf e6 = this.manager.e();
                if (e6 == null) {
                    return null;
                }
                mfVar = e6.c();
                if (e6 != null) {
                    try {
                        if (e6.d() != null && (size = e6.d().size()) > 0) {
                            this.netContext.getStat().stat = e6.d().get(size - 1);
                        }
                    } catch (BdHttpCancelException e7) {
                        bdHttpCancelException = e7;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                        HttpResponse response = this.netContext.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb2.append("|retryCount:");
                        if (this.netContext.getStat().stat != null) {
                            i2 = this.netContext.getStat().stat.e;
                        }
                        sb2.append(i2);
                        sb2.append("|");
                        sb2.append(BdHttpCancelException.class);
                        sb2.append("|");
                        sb2.append(bdHttpCancelException.getMessage());
                        sb2.append(Log.getStackTraceString(bdHttpCancelException));
                        response.mException = sb2.toString();
                        this.netContext.getResponse().mNetErrorCode = -14;
                        if (mfVar != null) {
                        }
                    } catch (OutOfMemoryError e8) {
                        outOfMemoryError = e8;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0b8c);
                        HttpResponse response2 = this.netContext.getResponse();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb3.append("|retryCount:");
                        if (this.netContext.getStat().stat != null) {
                            i2 = this.netContext.getStat().stat.e;
                        }
                        sb3.append(i2);
                        sb3.append("|");
                        sb3.append(outOfMemoryError.getClass());
                        sb3.append("|");
                        sb3.append(outOfMemoryError.getMessage());
                        sb3.append(Log.getStackTraceString(outOfMemoryError));
                        response2.mException = sb3.toString();
                        this.netContext.getResponse().mNetErrorCode = -15;
                        BdLog.e(outOfMemoryError.getMessage());
                        if (mfVar != null) {
                        }
                    } catch (SocketException e9) {
                        socketException = e9;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                        HttpResponse response3 = this.netContext.getResponse();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb4.append("|retryCount:");
                        if (this.netContext.getStat().stat != null) {
                            i2 = this.netContext.getStat().stat.e;
                        }
                        sb4.append(i2);
                        sb4.append("|");
                        sb4.append(socketException.getClass());
                        sb4.append("|");
                        sb4.append(socketException.getMessage());
                        sb4.append(Log.getStackTraceString(socketException));
                        response3.mException = sb4.toString();
                        this.netContext.getResponse().mNetErrorCode = -12;
                        if (mfVar != null) {
                        }
                    } catch (SocketTimeoutException e10) {
                        socketTimeoutException = e10;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                        HttpResponse response4 = this.netContext.getResponse();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb5.append("|retryCount:");
                        if (this.netContext.getStat().stat != null) {
                            i2 = this.netContext.getStat().stat.e;
                        }
                        sb5.append(i2);
                        sb5.append("|");
                        sb5.append(socketTimeoutException.getClass());
                        sb5.append("|");
                        sb5.append(socketTimeoutException.getMessage());
                        sb5.append(Log.getStackTraceString(socketTimeoutException));
                        response4.mException = sb5.toString();
                        this.netContext.getResponse().mNetErrorCode = -13;
                        if (mfVar != null) {
                        }
                    } catch (Exception e11) {
                        exc = e11;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b) + " detailException:" + exc.getMessage();
                        HttpResponse response5 = this.netContext.getResponse();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb6.append("|retryCount:");
                        if (this.netContext.getStat().stat != null) {
                            i2 = this.netContext.getStat().stat.e;
                        }
                        sb6.append(i2);
                        sb6.append("|");
                        sb6.append(exc.getClass());
                        sb6.append("|");
                        sb6.append(exc.getMessage());
                        sb6.append(Log.getStackTraceString(exc));
                        response5.mException = sb6.toString();
                        this.netContext.getResponse().mNetErrorCode = -10;
                        BdLog.e(exc.getMessage());
                        if (mfVar != null) {
                        }
                    }
                }
                if (mfVar == null) {
                    return null;
                }
                this.netContext.getResponse().mNetErrorCode = mfVar.b;
                if (this.netContext.getResponse().mNetErrorCode != 200) {
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                    if (this.netContext.getStat().stat != null && !TextUtils.isEmpty(this.netContext.getStat().stat.h)) {
                        this.netContext.getResponse().mException = this.netContext.getStat().stat.h;
                    } else {
                        HttpResponse response6 = this.netContext.getResponse();
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb7.append("|retryCount:");
                        if (this.netContext.getStat().stat == null) {
                            i = -1;
                        } else {
                            i = this.netContext.getStat().stat.e;
                        }
                        sb7.append(i);
                        response6.mException = sb7.toString();
                    }
                    return null;
                }
                if (TbadkCoreApplication.getInst().isMainProcess(true) && (str3 = mfVar.f) != null) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > MAX_DATA_LENG) {
                            this.netContext.getResponse().mNetErrorCode = -11;
                            return null;
                        }
                        int i4 = parseInt * 10;
                        if (i4 > 0 && !TbImageMemoryCache.s().q(i4)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.netContext.getRequest().mUrl + "], size:" + i4);
                            this.netContext.getResponse().mNetErrorCode = -16;
                            return null;
                        }
                    } catch (Throwable unused) {
                    }
                }
                NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                statisticsData.mMode = getMode(BdNetTypeUtil.netType());
                statisticsData.mSize = this.netContext.getStat().stat.b;
                statisticsData.mTime = new Date().getTime() - time;
                statisticsData.mTimesNum = this.netContext.getStat().stat.e;
                statisticsData.mMethod = 2;
                NetWorkState.addStatisticsData(statisticsData);
                NetWorkState.mErrorNums.set(this.netContext.getStat().stat.e);
                if (mfVar != null) {
                    return null;
                }
                return mfVar.i;
            }
            throw new BdHttpCancelException();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String postMultiNetData() {
        InterceptResult invokeV;
        Exception exc;
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        OutOfMemoryError outOfMemoryError;
        BdHttpCancelException bdHttpCancelException;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = null;
            long j = 0;
            int i3 = 0;
            try {
            } catch (BdHttpCancelException e) {
                bdHttpCancelException = e;
            } catch (OutOfMemoryError e2) {
                outOfMemoryError = e2;
            } catch (SocketException e3) {
                socketException = e3;
            } catch (SocketTimeoutException e4) {
                socketTimeoutException = e4;
            } catch (Exception e5) {
                exc = e5;
            }
            if (!this.manager.j()) {
                mf l = this.manager.l(this.netContext.getRequest().mUrl, this.netContext.getRequest().mRequestGzip, this.netContext.getRequest().mPostData, this.netContext.getRequest().mFileData, 5, -1, getExtendHeader());
                this.netContext.getResponse().mNetErrorCode = l.b;
                this.netContext.getResponse().mHeader = l.h;
                if (this.netContext.getResponse().mNetErrorCode != 200) {
                    if (!TextUtils.isEmpty(l.g)) {
                        this.netContext.getResponse().mException = l.g;
                    } else {
                        HttpResponse response = this.netContext.getResponse();
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb.append("|retryCount:");
                        if (this.netContext.getStat().stat == null) {
                            i2 = -1;
                        } else {
                            i2 = this.netContext.getStat().stat.e;
                        }
                        sb.append(i2);
                        response.mException = sb.toString();
                    }
                    return null;
                } else if (!this.manager.j()) {
                    String str2 = new String(l.i, "UTF-8");
                    try {
                        parseServerCode(str2);
                        i3 = l.i.length;
                        j = System.currentTimeMillis();
                    } catch (BdHttpCancelException e6) {
                        bdHttpCancelException = e6;
                        str = str2;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                        HttpResponse response2 = this.netContext.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb2.append("|retryCount:");
                        if (this.netContext.getStat().stat == null) {
                            i = -1;
                        } else {
                            i = this.netContext.getStat().stat.e;
                        }
                        sb2.append(i);
                        sb2.append("|");
                        sb2.append(bdHttpCancelException.getClass());
                        sb2.append("|");
                        sb2.append(bdHttpCancelException.getMessage());
                        sb2.append(Log.getStackTraceString(bdHttpCancelException));
                        response2.mException = sb2.toString();
                        this.netContext.getResponse().mNetErrorCode = -14;
                        str2 = str;
                        addPerformanceData(currentTimeMillis, j, i3);
                        return str2;
                    } catch (Exception e7) {
                        exc = e7;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -10;
                        HttpResponse response3 = this.netContext.getResponse();
                        response3.mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b) + " detailException:" + exc.getMessage();
                        HttpResponse response4 = this.netContext.getResponse();
                        response4.mException = exc.getMessage() + Log.getStackTraceString(exc);
                        BdLog.e(exc.getMessage());
                        str2 = str;
                        addPerformanceData(currentTimeMillis, j, i3);
                        return str2;
                    } catch (OutOfMemoryError e8) {
                        outOfMemoryError = e8;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -15;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0b8c);
                        HttpResponse response5 = this.netContext.getResponse();
                        response5.mException = outOfMemoryError.getMessage() + Log.getStackTraceString(outOfMemoryError);
                        BdLog.e(outOfMemoryError.getMessage());
                        str2 = str;
                        addPerformanceData(currentTimeMillis, j, i3);
                        return str2;
                    } catch (SocketException e9) {
                        socketException = e9;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -12;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                        HttpResponse response6 = this.netContext.getResponse();
                        response6.mException = socketException.getMessage() + Log.getStackTraceString(socketException);
                        str2 = str;
                        addPerformanceData(currentTimeMillis, j, i3);
                        return str2;
                    } catch (SocketTimeoutException e10) {
                        socketTimeoutException = e10;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -13;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                        HttpResponse response7 = this.netContext.getResponse();
                        response7.mException = socketTimeoutException.getMessage() + Log.getStackTraceString(socketTimeoutException);
                        str2 = str;
                        addPerformanceData(currentTimeMillis, j, i3);
                        return str2;
                    }
                    addPerformanceData(currentTimeMillis, j, i3);
                    return str2;
                } else {
                    throw new BdHttpCancelException();
                }
            }
            throw new BdHttpCancelException();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String postNetData() {
        InterceptResult invokeV;
        Throwable th;
        Exception exc;
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        OutOfMemoryError outOfMemoryError;
        int i;
        int i2;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder(1024);
            int i3 = 0;
            for (int i4 = 0; this.netContext.getRequest().mPostData != null && i4 < this.netContext.getRequest().mPostData.size(); i4++) {
                BasicNameValuePair basicNameValuePair = this.netContext.getRequest().mPostData.get(i4);
                if (basicNameValuePair != null && basicNameValuePair.getValue() != null) {
                    String name = basicNameValuePair.getName();
                    String value = basicNameValuePair.getValue();
                    sb.append(name);
                    sb.append("=");
                    sb.append(value);
                }
            }
            if (this.netContext.getRequest().mIsBaiduServer) {
                sb.append("tiebaclient!!!");
                addPostData("sign", pi.c(sb.toString()));
                if (this.netContext.getRequest().mNeedSig) {
                    addPostData(FunAdSdk.PLATFORM_SIG, StringU.b(sb.toString()));
                }
            }
            String str = null;
            long j = 0;
            try {
            } catch (BdHttpCancelException e) {
                e = e;
            } catch (OutOfMemoryError e2) {
                outOfMemoryError = e2;
            } catch (SocketException e3) {
                socketException = e3;
            } catch (SocketTimeoutException e4) {
                socketTimeoutException = e4;
            } catch (Exception e5) {
                exc = e5;
            } catch (Throwable th2) {
                th = th2;
            }
            if (this.manager.j()) {
                return null;
            }
            if (this.manager.k(this.netContext.getRequest().mUrl, this.netContext.getRequest().mPostData, this.netContext.getRequest().mRequestGzip, 5, -1, getExtendHeader()) != null) {
                kf e6 = this.manager.e();
                if (e6 == null) {
                    return null;
                }
                mf c = e6.c();
                if (e6 != null && e6.d() != null && (size = e6.d().size()) > 0) {
                    this.netContext.getStat().stat = e6.d().get(size - 1);
                }
                this.netContext.getResponse().mNetErrorCode = c.b;
                this.netContext.getResponse().mErrorString = c.g;
                this.netContext.getResponse().mException = c.g;
                this.netContext.getResponse().mHeader = c.h;
                if (this.netContext.getResponse().mNetErrorCode != 200) {
                    if (this.netContext.getStat().stat != null && !TextUtils.isEmpty(this.netContext.getStat().stat.h)) {
                        this.netContext.getResponse().mException = this.netContext.getStat().stat.h;
                    } else {
                        HttpResponse response = this.netContext.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb2.append("|retryCount:");
                        if (this.netContext.getStat().stat == null) {
                            i2 = -1;
                        } else {
                            i2 = this.netContext.getStat().stat.e;
                        }
                        sb2.append(i2);
                        response.mException = sb2.toString();
                    }
                    return null;
                } else if (this.manager.j()) {
                    return null;
                } else {
                    String str2 = new String(c.i, IMAudioTransRequest.CHARSET);
                    try {
                        if (this.netContext.getRequest().mIsBaiduServer && this.netContext.getRequest().mIsJson) {
                            parseServerCode(str2);
                        }
                        i3 = c.i.length;
                        j = System.currentTimeMillis();
                        NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                        statisticsData.mMode = getMode(BdNetTypeUtil.netType());
                        statisticsData.mSize = this.netContext.getStat().stat.b;
                        statisticsData.mTime = this.netContext.getStat().stat.f;
                        statisticsData.mTimesNum = this.netContext.getStat().stat.e;
                        statisticsData.mMethod = 1;
                        NetWorkState.addStatisticsData(statisticsData);
                        NetWorkState.mErrorNums.set(this.netContext.getStat().stat.e);
                        str = str2;
                    } catch (BdHttpCancelException e7) {
                        e = e7;
                        str = str2;
                        BdHttpCancelException bdHttpCancelException = e;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                        HttpResponse response2 = this.netContext.getResponse();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb3.append("|retryCount:");
                        if (this.netContext.getStat().stat == null) {
                            i = -1;
                        } else {
                            i = this.netContext.getStat().stat.e;
                        }
                        sb3.append(i);
                        sb3.append("|");
                        sb3.append(BdHttpCancelException.class);
                        sb3.append("|");
                        sb3.append(bdHttpCancelException.getMessage());
                        sb3.append(Log.getStackTraceString(bdHttpCancelException));
                        response2.mException = sb3.toString();
                        this.netContext.getResponse().mNetErrorCode = -14;
                        addPerformanceData(currentTimeMillis, j, i3);
                        return str;
                    } catch (OutOfMemoryError e8) {
                        outOfMemoryError = e8;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -15;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0b8c);
                        BdLog.e(outOfMemoryError.getMessage());
                        addPerformanceData(currentTimeMillis, j, i3);
                        return str;
                    } catch (SocketException e9) {
                        socketException = e9;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -12;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                        BdLog.e(socketException.getMessage());
                        addPerformanceData(currentTimeMillis, j, i3);
                        return str;
                    } catch (SocketTimeoutException e10) {
                        socketTimeoutException = e10;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -13;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                        BdLog.e(socketTimeoutException.getMessage());
                        addPerformanceData(currentTimeMillis, j, i3);
                        return str;
                    } catch (Exception e11) {
                        exc = e11;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -10;
                        HttpResponse response3 = this.netContext.getResponse();
                        response3.mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b) + " detailException:" + exc.getMessage();
                        BdLog.e(exc.getMessage());
                        addPerformanceData(currentTimeMillis, j, i3);
                        return str;
                    } catch (Throwable th3) {
                        th = th3;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -10;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                        BdLog.e(th.getMessage());
                        addPerformanceData(currentTimeMillis, j, i3);
                        return str;
                    }
                    addPerformanceData(currentTimeMillis, j, i3);
                    return str;
                }
            }
            throw new BdHttpCancelException();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, arrayList) == null) {
            if (this.netContext.getRequest().mPostData != null) {
                this.netContext.getRequest().mPostData.clear();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                addPostData(arrayList.get(i));
            }
        }
    }
}
