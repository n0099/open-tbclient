package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.NetWorkState;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.HttpResponse;
import com.baidu.tbadk.switchs.NetDeleteSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.repackage.ag;
import com.repackage.h35;
import com.repackage.lf;
import com.repackage.mi;
import com.repackage.nf;
import com.repackage.ni;
import com.repackage.of;
import com.repackage.qf;
import com.repackage.rf;
import com.repackage.ui;
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
    public ag manager;
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
        this.manager = new ag();
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.netContext = httpNetContext;
        ag.u("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void addPerformanceData(long j, long j2, int i) {
        ag agVar;
        lf f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) || this.netContext == null || (agVar = this.manager) == null || (f = agVar.f()) == null) {
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
        performance.put(FetchLog.START_TIME, String.valueOf(System.currentTimeMillis()));
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
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65539, this, arrayList, str)) != null) {
            return invokeLL.intValue;
        }
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
    }

    private LinkedList<BasicNameValuePair> getExtendHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.netContext != null) {
                LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
                if (!TextUtils.isEmpty(this.netContext.getRequest().getNetWorkParam().mSeqId)) {
                    linkedList.add(new BasicNameValuePair("sid", this.netContext.getRequest().getNetWorkParam().mSeqId));
                }
                if (!NetDeleteSwitch.isOn() && !TextUtils.isEmpty(this.netContext.getRequest().getNetWorkParam().mNetType)) {
                    linkedList.add(new BasicNameValuePair("net", this.netContext.getRequest().getNetWorkParam().mNetType));
                }
                return linkedList;
            }
            return null;
        }
        return (LinkedList) invokeV.objValue;
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

    private void initNetWork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mContext = null;
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
    public void cancelNetConnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.manager.c();
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        of e;
        int i4;
        StringBuilder sb;
        of e2;
        of e3;
        File CreateFileIfNotFoundInCache;
        of e4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, handler, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            boolean z2 = false;
            try {
                try {
                } catch (Exception e5) {
                    this.netContext.getResponse().mNetErrorCode = -10;
                    HttpResponse response = this.netContext.getResponse();
                    response.mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17) + " detailException:" + e5.getMessage();
                    BdLog.e(e5.getMessage());
                    if (!z2 && (e2 = this.manager.e()) != null && e2.d() != null && handler != null) {
                        i4 = e2.c().c;
                        int size = e2.d().size();
                        sb = new StringBuilder();
                        if (size > 0) {
                            nf nfVar = e2.d().get(size - 1);
                            sb.append("-netErrorCode-");
                            sb.append(i4);
                            sb.append("-exception-");
                            sb.append(nfVar.h);
                            sb.append("-url-");
                            sb.append(nfVar.s);
                        }
                    }
                } catch (OutOfMemoryError e6) {
                    this.netContext.getResponse().mNetErrorCode = -15;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0ab4);
                    BdLog.e(e6.getMessage());
                    if (!z2 && (e = this.manager.e()) != null && e.d() != null && handler != null) {
                        i4 = e.c().c;
                        int size2 = e.d().size();
                        sb = new StringBuilder();
                        if (size2 > 0) {
                            nf nfVar2 = e.d().get(size2 - 1);
                            sb.append("-netErrorCode-");
                            sb.append(i4);
                            sb.append("-exception-");
                            sb.append(nfVar2.h);
                            sb.append("-url-");
                            sb.append(nfVar2.s);
                        }
                    }
                }
                if (this.manager.j()) {
                    of e7 = this.manager.e();
                    if (e7 != null && e7.d() != null && handler != null) {
                        int i5 = e7.c().c;
                        int size3 = e7.d().size();
                        StringBuilder sb2 = new StringBuilder();
                        if (size3 > 0) {
                            nf nfVar3 = e7.d().get(size3 - 1);
                            sb2.append("-netErrorCode-");
                            sb2.append(i5);
                            sb2.append("-exception-");
                            sb2.append(nfVar3.h);
                            sb2.append("-url-");
                            sb2.append(nfVar3.s);
                        }
                        handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, sb2.toString()));
                    }
                    TiebaStatic.net(this.netContext);
                    return false;
                }
                if (z) {
                    CreateFileIfNotFoundInCache = new File(str);
                } else {
                    CreateFileIfNotFoundInCache = FileHelper.CreateFileIfNotFoundInCache(str);
                }
                z2 = this.manager.d(this.netContext.getRequest().getNetWorkParam().mUrl, CreateFileIfNotFoundInCache.getAbsolutePath(), false, i2, i3, -1, -1, getExtendHeader(), new rf(this, handler, i) { // from class: com.baidu.tbadk.core.util.NetWorkCoreByBdHttp.1
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

                    @Override // com.repackage.rf
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
                if (!z2 && (e4 = this.manager.e()) != null && e4.d() != null && handler != null) {
                    i4 = e4.c().c;
                    int size4 = e4.d().size();
                    sb = new StringBuilder();
                    if (size4 > 0) {
                        nf nfVar4 = e4.d().get(size4 - 1);
                        sb.append("-netErrorCode-");
                        sb.append(i4);
                        sb.append("-exception-");
                        sb.append(nfVar4.h);
                        sb.append("-url-");
                        sb.append(nfVar4.s);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, sb.toString()));
                }
                TiebaStatic.net(this.netContext);
                return z2;
            } catch (Throwable th) {
                if (!z2 && (e3 = this.manager.e()) != null && e3.d() != null && handler != null) {
                    int i6 = e3.c().c;
                    int size5 = e3.d().size();
                    StringBuilder sb3 = new StringBuilder();
                    if (size5 > 0) {
                        nf nfVar5 = e3.d().get(size5 - 1);
                        sb3.append("-netErrorCode-");
                        sb3.append(i6);
                        sb3.append("-exception-");
                        sb3.append(nfVar5.h);
                        sb3.append("-url-");
                        sb3.append(nfVar5.s);
                    }
                    handler.dispatchMessage(handler.obtainMessage(-1, i6, -1, sb3.toString()));
                }
                TiebaStatic.net(this.netContext);
                throw th;
            }
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0560 A[RETURN] */
    @Override // com.baidu.tbadk.core.util.INetWorkCore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
        InterceptResult invokeV;
        OutOfMemoryError outOfMemoryError;
        qf qfVar;
        Exception exc;
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        BdHttpCancelException bdHttpCancelException;
        String str;
        String str2;
        boolean z;
        int size;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ag.t(TbadkCoreApplication.getCurrentAccount());
            try {
                if (this.netContext.getRequest().getNetWorkParam().mPostData != null && this.netContext.getRequest().getNetWorkParam().mPostData.size() > 0 && !this.netContext.getRequest().mIsFromCDN) {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.netContext.getRequest().getNetWorkParam().mUrl);
                    if (this.netContext.getRequest().getNetWorkParam().mUrl.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.netContext.getRequest().getNetWorkParam().mUrl.endsWith("?") && !this.netContext.getRequest().getNetWorkParam().mUrl.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i = 0; i < this.netContext.getRequest().getNetWorkParam().mPostData.size(); i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(this.netContext.getRequest().getNetWorkParam().mPostData.get(i).getName());
                        sb.append("=");
                        sb.append(ni.getUrlEncode(this.netContext.getRequest().getNetWorkParam().mPostData.get(i).getValue()));
                    }
                    str = sb.toString();
                } else {
                    str = this.netContext.getRequest().getNetWorkParam().mUrl;
                }
                str2 = str;
                TbConfig.getDebugSwitch();
                z = (this.netContext.getRequest().getNetWorkParam().mRequestGzip && !this.netContext.getRequest().getNetWorkParam().mIsBDImage) || this.netContext.getRequest().mIsFromCDN;
            } catch (BdHttpCancelException e) {
                bdHttpCancelException = e;
                qfVar = null;
            } catch (SocketException e2) {
                socketException = e2;
                qfVar = null;
            } catch (SocketTimeoutException e3) {
                socketTimeoutException = e3;
                qfVar = null;
            } catch (Exception e4) {
                exc = e4;
                qfVar = null;
            } catch (OutOfMemoryError e5) {
                outOfMemoryError = e5;
                qfVar = null;
            }
            if (!this.manager.j()) {
                long time = new Date().getTime();
                this.manager.h(str2, z, 5, 100, -1, -1, getExtendHeader());
                of e6 = this.manager.e();
                if (e6 == null) {
                    return null;
                }
                qfVar = e6.c();
                if (e6 != null) {
                    try {
                        if (e6.d() != null && (size = e6.d().size()) > 0) {
                            this.netContext.getStat().stat = e6.d().get(size - 1);
                        }
                    } catch (BdHttpCancelException e7) {
                        bdHttpCancelException = e7;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        HttpResponse response = this.netContext.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb2.append("|retryCount:");
                        sb2.append(this.netContext.getStat().stat != null ? this.netContext.getStat().stat.e : -1);
                        sb2.append("|");
                        sb2.append(BdHttpCancelException.class);
                        sb2.append("|");
                        sb2.append(bdHttpCancelException.getMessage());
                        response.mException = sb2.toString();
                        this.netContext.getResponse().mNetErrorCode = -14;
                        if (qfVar == null) {
                        }
                    } catch (Exception e8) {
                        exc = e8;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17) + " detailException:" + exc.getMessage();
                        HttpResponse response2 = this.netContext.getResponse();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb3.append("|retryCount:");
                        sb3.append(this.netContext.getStat().stat != null ? this.netContext.getStat().stat.e : -1);
                        sb3.append("|");
                        sb3.append(exc.getClass());
                        sb3.append("|");
                        sb3.append(exc.getMessage());
                        response2.mException = sb3.toString();
                        this.netContext.getResponse().mNetErrorCode = -10;
                        BdLog.e(exc.getMessage());
                        TiebaStatic.net(this.netContext);
                        if (qfVar == null) {
                        }
                    } catch (OutOfMemoryError e9) {
                        outOfMemoryError = e9;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0ab4);
                        HttpResponse response3 = this.netContext.getResponse();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb4.append("|retryCount:");
                        sb4.append(this.netContext.getStat().stat != null ? this.netContext.getStat().stat.e : -1);
                        sb4.append("|");
                        sb4.append(outOfMemoryError.getClass());
                        sb4.append("|");
                        sb4.append(outOfMemoryError.getMessage());
                        response3.mException = sb4.toString();
                        this.netContext.getResponse().mNetErrorCode = -15;
                        BdLog.e(outOfMemoryError.getMessage());
                        TiebaStatic.net(this.netContext);
                        if (qfVar == null) {
                        }
                    } catch (SocketException e10) {
                        socketException = e10;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        HttpResponse response4 = this.netContext.getResponse();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb5.append("|retryCount:");
                        sb5.append(this.netContext.getStat().stat != null ? this.netContext.getStat().stat.e : -1);
                        sb5.append("|");
                        sb5.append(socketException.getClass());
                        sb5.append("|");
                        sb5.append(socketException.getMessage());
                        response4.mException = sb5.toString();
                        this.netContext.getResponse().mNetErrorCode = -12;
                        TiebaStatic.net(this.netContext);
                        if (qfVar == null) {
                        }
                    } catch (SocketTimeoutException e11) {
                        socketTimeoutException = e11;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        HttpResponse response5 = this.netContext.getResponse();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb6.append("|retryCount:");
                        sb6.append(this.netContext.getStat().stat != null ? this.netContext.getStat().stat.e : -1);
                        sb6.append("|");
                        sb6.append(socketTimeoutException.getClass());
                        sb6.append("|");
                        sb6.append(socketTimeoutException.getMessage());
                        response5.mException = sb6.toString();
                        this.netContext.getResponse().mNetErrorCode = -13;
                        TiebaStatic.net(this.netContext);
                        if (qfVar == null) {
                        }
                    }
                }
                if (qfVar == null) {
                    return null;
                }
                this.netContext.getResponse().mNetErrorCode = qfVar.b;
                if (this.netContext.getResponse().mNetErrorCode != 200) {
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                    if (this.netContext.getStat().stat != null && !TextUtils.isEmpty(this.netContext.getStat().stat.h)) {
                        this.netContext.getResponse().mException = this.netContext.getStat().stat.h;
                    } else {
                        HttpResponse response6 = this.netContext.getResponse();
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb7.append("|retryCount:");
                        sb7.append(this.netContext.getStat().stat == null ? -1 : this.netContext.getStat().stat.e);
                        response6.mException = sb7.toString();
                    }
                    TiebaStatic.net(this.netContext);
                    return null;
                }
                if (TbadkCoreApplication.getInst().isMainProcess(true) && (str3 = qfVar.f) != null) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > MAX_DATA_LENG) {
                            this.netContext.getResponse().mNetErrorCode = -11;
                            TiebaStatic.net(this.netContext);
                            return null;
                        }
                        int i2 = parseInt * 10;
                        if (i2 > 0) {
                            BdLog.isDebugMode();
                            if (!h35.k().i(i2)) {
                                BdLog.d("Image download cacelled. out of memory. url:[" + this.netContext.getRequest().getNetWorkParam().mUrl + "], size:" + i2);
                                this.netContext.getResponse().mNetErrorCode = -16;
                                TiebaStatic.net(this.netContext);
                                return null;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                statisticsData.mMode = getMode(mi.I());
                statisticsData.mSize = this.netContext.getStat().stat.b;
                statisticsData.mTime = new Date().getTime() - time;
                statisticsData.mTimesNum = this.netContext.getStat().stat.e;
                statisticsData.mMethod = 2;
                NetWorkState.addStatisticsData(statisticsData);
                NetWorkState.mErrorNums.set(this.netContext.getStat().stat.e);
                TiebaStatic.net(this.netContext);
                if (qfVar == null) {
                    return qfVar.i;
                }
                return null;
            }
            throw new BdHttpCancelException();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String getNetString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048582, this)) != null) {
            return (String) invokeV.objValue;
        }
        byte[] netData = getNetData();
        String str = null;
        if (netData == null || this.netContext.getResponse().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.netContext.getRequest().getNetWorkParam().charSet = TextUtils.isEmpty(this.netContext.getRequest().getNetWorkParam().charSet) ? "UTF-8" : this.netContext.getRequest().getNetWorkParam().charSet;
            String str2 = new String(netData, 0, netData.length, this.netContext.getRequest().getNetWorkParam().charSet);
            try {
                parseServerCode(str2);
                return str2;
            } catch (Exception e) {
                e = e;
                str = str2;
                BdLog.e(e.getMessage());
                return str;
            } catch (OutOfMemoryError e2) {
                e = e2;
                str = str2;
                BdLog.e(e.getMessage());
                return str;
            }
        } catch (Exception e3) {
            e = e3;
        } catch (OutOfMemoryError e4) {
            e = e4;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public ArrayList<BasicNameValuePair> getPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.netContext.getRequest().getNetWorkParam().mPostData : (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String getSeqId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HttpNetContext httpNetContext = this.netContext;
            if (httpNetContext != null) {
                return httpNetContext.getRequest().getNetWorkParam().mSeqId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public boolean isCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.manager.j() : invokeV.booleanValue;
    }

    public void parseServerCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.netContext.getResponse().mServerErrorCode = -1;
            try {
                if (str != null) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(str);
                    this.netContext.getResponse().mServerErrorCode = errorData.getError_code();
                    if (this.netContext.getResponse().mServerErrorCode == -1) {
                        this.netContext.getResponse().mErrorString = this.mContext.getString(R.string.obfuscated_res_0x7f0f059f);
                    } else if (this.netContext.getResponse().mServerErrorCode != 0) {
                        this.netContext.getResponse().mErrorString = errorData.getError_msg();
                    }
                } else {
                    this.netContext.getResponse().mErrorString = this.mContext.getString(R.string.obfuscated_res_0x7f0f059f);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.netContext.getResponse().mErrorString = this.mContext.getString(R.string.obfuscated_res_0x7f0f059f);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String postMultiNetData() {
        InterceptResult invokeV;
        Exception exc;
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        OutOfMemoryError outOfMemoryError;
        BdHttpCancelException bdHttpCancelException;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = null;
            long j = 0;
            int i = 0;
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
                qf l = this.manager.l(this.netContext.getRequest().getNetWorkParam().mUrl, this.netContext.getRequest().getNetWorkParam().mRequestGzip, this.netContext.getRequest().getNetWorkParam().mPostData, this.netContext.getRequest().getNetWorkParam().mFileData, 5, -1, getExtendHeader());
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
                        sb.append(this.netContext.getStat().stat == null ? -1 : this.netContext.getStat().stat.e);
                        response.mException = sb.toString();
                    }
                    TiebaStatic.net(this.netContext);
                    return null;
                } else if (!this.manager.j()) {
                    String str2 = new String(l.i, "UTF-8");
                    try {
                        parseServerCode(str2);
                        i = l.i.length;
                        j = System.currentTimeMillis();
                        TiebaStatic.net(this.netContext);
                    } catch (BdHttpCancelException e6) {
                        bdHttpCancelException = e6;
                        str = str2;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        HttpResponse response2 = this.netContext.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb2.append("|retryCount:");
                        sb2.append(this.netContext.getStat().stat == null ? -1 : this.netContext.getStat().stat.e);
                        sb2.append("|");
                        sb2.append(bdHttpCancelException.getClass());
                        sb2.append("|");
                        sb2.append(bdHttpCancelException.getMessage());
                        response2.mException = sb2.toString();
                        this.netContext.getResponse().mNetErrorCode = -14;
                        str2 = str;
                        addPerformanceData(currentTimeMillis, j, i);
                        return str2;
                    } catch (OutOfMemoryError e7) {
                        outOfMemoryError = e7;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -15;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0ab4);
                        this.netContext.getResponse().mException = outOfMemoryError.getMessage();
                        BdLog.e(outOfMemoryError.getMessage());
                        TiebaStatic.net(this.netContext);
                        str2 = str;
                        addPerformanceData(currentTimeMillis, j, i);
                        return str2;
                    } catch (SocketException e8) {
                        socketException = e8;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -12;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        this.netContext.getResponse().mException = socketException.getMessage();
                        TiebaStatic.net(this.netContext);
                        str2 = str;
                        addPerformanceData(currentTimeMillis, j, i);
                        return str2;
                    } catch (SocketTimeoutException e9) {
                        socketTimeoutException = e9;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -13;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        this.netContext.getResponse().mException = socketTimeoutException.getMessage();
                        TiebaStatic.net(this.netContext);
                        str2 = str;
                        addPerformanceData(currentTimeMillis, j, i);
                        return str2;
                    } catch (Exception e10) {
                        exc = e10;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -10;
                        HttpResponse response3 = this.netContext.getResponse();
                        response3.mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17) + " detailException:" + exc.getMessage();
                        this.netContext.getResponse().mException = exc.getMessage();
                        BdLog.e(exc.getMessage());
                        TiebaStatic.net(this.netContext);
                        str2 = str;
                        addPerformanceData(currentTimeMillis, j, i);
                        return str2;
                    }
                    addPerformanceData(currentTimeMillis, j, i);
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
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder(1024);
            int i = 0;
            for (int i2 = 0; this.netContext.getRequest().getNetWorkParam().mPostData != null && i2 < this.netContext.getRequest().getNetWorkParam().mPostData.size(); i2++) {
                BasicNameValuePair basicNameValuePair = this.netContext.getRequest().getNetWorkParam().mPostData.get(i2);
                if (basicNameValuePair != null && basicNameValuePair.getValue() != null) {
                    String name = basicNameValuePair.getName();
                    String value = basicNameValuePair.getValue();
                    sb.append(name);
                    sb.append("=");
                    sb.append(value);
                }
            }
            if (this.netContext.getRequest().getNetWorkParam().mIsBaiduServer) {
                sb.append("tiebaclient!!!");
                addPostData("sign", ui.c(sb.toString()));
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
            if (this.manager.k(this.netContext.getRequest().getNetWorkParam().mUrl, this.netContext.getRequest().getNetWorkParam().mPostData, this.netContext.getRequest().getNetWorkParam().mRequestGzip, 5, -1, getExtendHeader()) != null) {
                of e6 = this.manager.e();
                if (e6 == null) {
                    return null;
                }
                qf c = e6.c();
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
                        sb2.append(this.netContext.getStat().stat == null ? -1 : this.netContext.getStat().stat.e);
                        response.mException = sb2.toString();
                    }
                    TiebaStatic.net(this.netContext);
                    return null;
                } else if (this.manager.j()) {
                    return null;
                } else {
                    String str2 = new String(c.i, IMAudioTransRequest.CHARSET);
                    try {
                        if (this.netContext.getRequest().getNetWorkParam().mIsBaiduServer && this.netContext.getRequest().getNetWorkParam().mIsJson) {
                            parseServerCode(str2);
                        }
                        i = c.i.length;
                        j = System.currentTimeMillis();
                        NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                        statisticsData.mMode = getMode(mi.I());
                        statisticsData.mSize = this.netContext.getStat().stat.b;
                        statisticsData.mTime = this.netContext.getStat().stat.f;
                        statisticsData.mTimesNum = this.netContext.getStat().stat.e;
                        statisticsData.mMethod = 1;
                        NetWorkState.addStatisticsData(statisticsData);
                        NetWorkState.mErrorNums.set(this.netContext.getStat().stat.e);
                        TiebaStatic.net(this.netContext);
                        str = str2;
                    } catch (BdHttpCancelException e7) {
                        e = e7;
                        str = str2;
                        BdHttpCancelException bdHttpCancelException = e;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        HttpResponse response2 = this.netContext.getResponse();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                        sb3.append("|retryCount:");
                        sb3.append(this.netContext.getStat().stat == null ? -1 : this.netContext.getStat().stat.e);
                        sb3.append("|");
                        sb3.append(BdHttpCancelException.class);
                        sb3.append("|");
                        sb3.append(bdHttpCancelException.getMessage());
                        response2.mException = sb3.toString();
                        this.netContext.getResponse().mNetErrorCode = -14;
                        addPerformanceData(currentTimeMillis, j, i);
                        return str;
                    } catch (OutOfMemoryError e8) {
                        outOfMemoryError = e8;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -15;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0ab4);
                        BdLog.e(outOfMemoryError.getMessage());
                        TiebaStatic.net(this.netContext);
                        addPerformanceData(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketException e9) {
                        socketException = e9;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -12;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(socketException.getMessage());
                        TiebaStatic.net(this.netContext);
                        addPerformanceData(currentTimeMillis, j, i);
                        return str;
                    } catch (SocketTimeoutException e10) {
                        socketTimeoutException = e10;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -13;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(socketTimeoutException.getMessage());
                        TiebaStatic.net(this.netContext);
                        addPerformanceData(currentTimeMillis, j, i);
                        return str;
                    } catch (Exception e11) {
                        exc = e11;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -10;
                        HttpResponse response3 = this.netContext.getResponse();
                        response3.mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17) + " detailException:" + exc.getMessage();
                        BdLog.e(exc.getMessage());
                        TiebaStatic.net(this.netContext);
                        addPerformanceData(currentTimeMillis, j, i);
                        return str;
                    } catch (Throwable th3) {
                        th = th3;
                        str = str2;
                        this.netContext.getResponse().mNetErrorCode = -10;
                        this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.netContext);
                        addPerformanceData(currentTimeMillis, j, i);
                        return str;
                    }
                    addPerformanceData(currentTimeMillis, j, i);
                    return str;
                }
            }
            throw new BdHttpCancelException();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setCancel() {
        ag agVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (agVar = this.manager) == null) {
            return;
        }
        agVar.m();
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setIsBaiduServer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.netContext.getRequest().getNetWorkParam().mIsBaiduServer = z;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, arrayList) == null) {
            if (this.netContext.getRequest().getNetWorkParam().mPostData != null) {
                this.netContext.getRequest().getNetWorkParam().mPostData.clear();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                addPostData(arrayList.get(i));
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr) == null) {
            if (this.netContext.getRequest().getNetWorkParam().mFileData == null) {
                this.netContext.getRequest().getNetWorkParam().mFileData = new HashMap<>();
            }
            this.netContext.getRequest().getNetWorkParam().mFileData.put(str, bArr);
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, basicNameValuePair) == null) || basicNameValuePair == null || basicNameValuePair.getName() == null) {
            return;
        }
        if (this.netContext.getRequest().getNetWorkParam().mPostData == null) {
            this.netContext.getRequest().getNetWorkParam().mPostData = new ArrayList<>();
        }
        int addPostIndex = getAddPostIndex(this.netContext.getRequest().getNetWorkParam().mPostData, basicNameValuePair.getName());
        int size = this.netContext.getRequest().getNetWorkParam().mPostData.size();
        if (addPostIndex < 0 || addPostIndex >= size) {
            if (addPostIndex == size) {
                this.netContext.getRequest().getNetWorkParam().mPostData.add(addPostIndex, basicNameValuePair);
            }
        } else if (basicNameValuePair.getName().equals(this.netContext.getRequest().getNetWorkParam().mPostData.get(addPostIndex).getName())) {
            this.netContext.getRequest().getNetWorkParam().mPostData.set(addPostIndex, basicNameValuePair);
        } else {
            this.netContext.getRequest().getNetWorkParam().mPostData.add(addPostIndex, basicNameValuePair);
        }
    }
}
