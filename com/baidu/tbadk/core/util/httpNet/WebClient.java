package com.baidu.tbadk.core.util.httpNet;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.j.a.c;
import c.a.d.f.j.a.d;
import c.a.d.f.j.a.e;
import c.a.d.f.j.a.g;
import c.a.d.f.l.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.UseHttpAutoRetrySwitch;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes9.dex */
public class WebClient implements b.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFERSIZE = 1024;
    public static final String IMAGEGIF = "image/gif";
    public static final String IMAGESECRET = "app:tiebaclient;type:0;";
    public static final int MAX_FAILED_CNT = 5;
    public static final int MAX_IMG_STAT_CNT = 2;
    public static int RETRYCOUNT = 5;
    public static int afterSwitchNetLibFirstReqErrCode;
    public static int afterSwitchNetLibReqCnt;
    public static int afterSwitchNetLibReqFailedCnt;
    public static int clientFailedCnt;
    public transient /* synthetic */ FieldHolder $fh;
    public int dataSize;
    public int errorCode;
    public String exception;
    public boolean isCrackPic;
    public boolean isGif;
    public boolean isGzip;
    public volatile c mBdHttpManager2;
    public e mContext;
    public ImgHttpClient mHttpClient;
    public boolean mIsRequestSuccess;
    public HashMap<String, String> mPostList;
    public g mResponse;
    public d mStat;
    public boolean mT2ASwitchFlag;
    public boolean mUseHttpAutoSwitch;
    public boolean mUseHttpClient;
    public boolean needCache;
    public int responseCode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1905532650, "Lcom/baidu/tbadk/core/util/httpNet/WebClient;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1905532650, "Lcom/baidu/tbadk/core/util/httpNet/WebClient;");
        }
    }

    public WebClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBdHttpManager2 = null;
        this.mPostList = null;
        this.mResponse = new g();
        this.isGzip = false;
        this.isGif = false;
        this.exception = "";
        this.mStat = null;
        this.dataSize = -1;
        this.responseCode = -1;
        this.errorCode = -1;
        this.needCache = true;
        this.mIsRequestSuccess = false;
        this.isCrackPic = false;
        this.mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
        this.mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
        this.mT2ASwitchFlag = false;
    }

    private void buildException(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, exc) == null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(" url:");
                stringBuffer.append(str);
                stringBuffer.append("thread_id:");
                stringBuffer.append(Thread.currentThread().getId());
                for (int i2 = 0; i2 < this.mContext.d().size(); i2++) {
                    d dVar = this.mContext.d().get(i2);
                    stringBuffer.append(" index: ");
                    stringBuffer.append(i2);
                    stringBuffer.append("exception:");
                    stringBuffer.append(dVar.f2431h);
                    stringBuffer.append("retry:");
                    stringBuffer.append(dVar.f2428e);
                    stringBuffer.append("connectTime:");
                    stringBuffer.append(dVar.f2426c);
                    stringBuffer.append("downloadSize:");
                    stringBuffer.append(dVar.f2425b);
                    stringBuffer.append("rspTime:");
                    stringBuffer.append(dVar.f2427d);
                    stringBuffer.append("dnsTime:");
                    stringBuffer.append(dVar.f2430g);
                    stringBuffer.append("responsedCode:");
                    stringBuffer.append(dVar.f2432i);
                    stringBuffer.append("allCostTime:");
                    stringBuffer.append(dVar.f2429f);
                    stringBuffer.append("executeStatus:");
                    stringBuffer.append(dVar.f2433j);
                }
                if (exc != null) {
                    stringBuffer.append("webclient exception");
                    stringBuffer.append(DealIntentService.KEY_CLASS);
                    stringBuffer.append(exc.getClass());
                    stringBuffer.append("message");
                    stringBuffer.append(exc.getMessage());
                } else {
                    stringBuffer.append("networkcore exception");
                }
                this.exception = stringBuffer.toString();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.mIsRequestSuccess = false;
                throw th;
            }
            this.mIsRequestSuccess = false;
        }
    }

    public static byte[] copyOfRange(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) {
            int i4 = i3 - i2;
            if (i4 >= 0) {
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i2, bArr2, 0, Math.min(bArr.length - i2, i4));
                return bArr2;
            }
            throw new IllegalArgumentException(i2 + " > " + i3);
        }
        return (byte[]) invokeLII.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT]}, finally: {[IGET, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] downloadBytesInternal(String str) {
        InterceptResult invokeL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                try {
                    resetStatus();
                    if (this.mContext != null) {
                        cancel();
                        this.mBdHttpManager2 = null;
                    }
                    e eVar = new e();
                    this.mContext = eVar;
                    eVar.b().s(str);
                    this.mContext.b().n(UseHttpAutoRetrySwitch.isOn());
                    if (this.mPostList != null) {
                        for (Map.Entry<String, String> entry : this.mPostList.entrySet()) {
                            this.mContext.b().b(entry.getKey(), entry.getValue());
                        }
                    }
                    this.mBdHttpManager2 = new c(this.mContext);
                    this.mBdHttpManager2.e(RETRYCOUNT, 0, 0);
                    g c2 = this.mContext.c();
                    this.mResponse = c2;
                    if (c2 != null && c2.f2449g != null && (list = c2.f2449g.get("Cache-Control")) != null && list.size() > 0) {
                        this.needCache = !"no-cache".equals(list.get(0));
                    }
                    byte[] bArr = this.mContext.c().f2450h;
                    this.responseCode = this.mContext.c().f2444b;
                    this.errorCode = this.mContext.c().f2445c;
                    this.mIsRequestSuccess = this.mContext.c().b();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    if (this.mContext.c().f2446d != null && this.mContext.c().f2446d.toLowerCase().contains("gzip")) {
                        this.isGzip = true;
                    }
                    if (!this.mIsRequestSuccess) {
                        buildException(str, null);
                    }
                    d a = this.mContext.a();
                    this.mStat = a;
                    if (a != null) {
                        StringBuilder sb = new StringBuilder();
                        d dVar = this.mStat;
                        sb.append(dVar.f2431h);
                        sb.append(stringBuffer.toString());
                        dVar.f2431h = sb.toString();
                        StringBuilder sb2 = new StringBuilder();
                        d dVar2 = this.mStat;
                        sb2.append(dVar2.f2431h);
                        sb2.append("_responseCode:");
                        sb2.append(this.responseCode);
                        dVar2.f2431h = sb2.toString();
                    }
                    return bArr;
                } catch (Exception e2) {
                    stringBuffer.append("httpmanagererr_" + e2.getClass() + "_" + e2.getMessage());
                    d a2 = this.mContext.a();
                    this.mStat = a2;
                    if (a2 != null) {
                        StringBuilder sb3 = new StringBuilder();
                        d dVar3 = this.mStat;
                        sb3.append(dVar3.f2431h);
                        sb3.append(stringBuffer.toString());
                        dVar3.f2431h = sb3.toString();
                        StringBuilder sb4 = new StringBuilder();
                        d dVar4 = this.mStat;
                        sb4.append(dVar4.f2431h);
                        sb4.append("_responseCode:");
                        sb4.append(this.responseCode);
                        dVar4.f2431h = sb4.toString();
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                d a3 = this.mContext.a();
                this.mStat = a3;
                if (a3 != null) {
                    StringBuilder sb5 = new StringBuilder();
                    d dVar5 = this.mStat;
                    sb5.append(dVar5.f2431h);
                    sb5.append(stringBuffer.toString());
                    dVar5.f2431h = sb5.toString();
                    StringBuilder sb6 = new StringBuilder();
                    d dVar6 = this.mStat;
                    sb6.append(dVar6.f2431h);
                    sb6.append("_responseCode:");
                    sb6.append(this.responseCode);
                    dVar6.f2431h = sb6.toString();
                }
                throw th;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    private boolean isSwitchNetLib() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (!this.mResponse.a && ((i2 = this.errorCode) == -12 || i2 == -18 || i2 == -19)) {
                int i3 = clientFailedCnt + 1;
                clientFailedCnt = i3;
                if (i3 >= 5) {
                    clientFailedCnt = 0;
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean IsRequestSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIsRequestSuccess : invokeV.booleanValue;
    }

    public void addPostParameter(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, basicNameValuePair) == null) || basicNameValuePair == null) {
            return;
        }
        if (this.mPostList == null) {
            this.mPostList = new HashMap<>();
        }
        this.mPostList.put(basicNameValuePair.getName(), basicNameValuePair.getValue());
    }

    @Override // c.a.d.f.l.b.a
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.mBdHttpManager2 != null) {
                this.mBdHttpManager2.b();
            }
            ImgHttpClient imgHttpClient = this.mHttpClient;
            if (imgHttpClient != null) {
                imgHttpClient.cancel();
                this.mHttpClient = null;
            }
        }
    }

    public byte[] downloadCommonBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? downloadBytesInternal(str) : (byte[]) invokeL.objValue;
    }

    public byte[] downloadImageBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? downloadImageBytes(str, false) : (byte[]) invokeL.objValue;
    }

    public String downloadString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            byte[] downloadBytesInternal = downloadBytesInternal(str);
            try {
                return new String(downloadBytesInternal, 0, downloadBytesInternal.length, this.mContext.c().f2446d);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public g getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mResponse : (g) invokeV.objValue;
    }

    public boolean isMobileProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ImgHttpClient imgHttpClient = this.mHttpClient;
            if (imgHttpClient == null) {
                return false;
            }
            return imgHttpClient.isMobileProxy;
        }
        return invokeV.booleanValue;
    }

    public boolean needCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (c.a.q0.s.e0.b.j().k("image_no_cache_switch", 0) == 1) {
                return this.needCache;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void resetStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mStat = null;
            this.exception = "";
            this.mIsRequestSuccess = false;
            this.responseCode = -1;
            this.dataSize = -1;
            this.isGif = false;
            this.isGzip = false;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IF, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IF] complete} */
    public byte[] downloadImageBytes(String str, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        String str2;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            this.needCache = true;
            int i2 = 0;
            if (this.mUseHttpClient && !UseHttpdnsSdkSwitch.isOn()) {
                StringBuilder sb = new StringBuilder(20);
                try {
                    try {
                        resetStatus();
                        if (this.mHttpClient != null) {
                            cancel();
                        }
                        this.mContext = new e();
                        this.mHttpClient = new ImgHttpClient(this.mContext);
                        this.mContext.b().s(str);
                        if (this.mPostList != null) {
                            for (Map.Entry<String, String> entry : this.mPostList.entrySet()) {
                                this.mContext.b().b(entry.getKey(), entry.getValue());
                            }
                        }
                        this.mHttpClient.getNetDataWithIp(null, null, -1);
                        g c2 = this.mContext.c();
                        this.mResponse = c2;
                        if (c2 != null && c2.f2449g != null && (list = c2.f2449g.get("Cache-Control")) != null && list.size() > 0) {
                            this.needCache = !"no-cache".equals(list.get(0));
                        }
                        byte[] bArr = this.mContext.c().f2450h;
                        this.responseCode = this.mContext.c().f2444b;
                        this.errorCode = this.mContext.c().f2445c;
                        this.mIsRequestSuccess = this.mContext.c().b();
                        if (this.mUseHttpAutoSwitch && true == isSwitchNetLib()) {
                            this.mUseHttpClient = false;
                            TbadkCoreApplication.getInst().setHttpClientOpen(false);
                            afterSwitchNetLibReqFailedCnt = 0;
                            afterSwitchNetLibReqCnt = 0;
                            afterSwitchNetLibFirstReqErrCode = 0;
                        }
                        if (this.mT2ASwitchFlag) {
                            int i3 = afterSwitchNetLibReqCnt + 1;
                            afterSwitchNetLibReqCnt = i3;
                            if (i3 <= 2 && this.responseCode != 200) {
                                afterSwitchNetLibReqFailedCnt++;
                                if (i3 == 1) {
                                    afterSwitchNetLibFirstReqErrCode = this.errorCode;
                                }
                            }
                            if (afterSwitchNetLibReqCnt == 2) {
                                ImageLogger.eventStatForHttpSwitch("T2A", afterSwitchNetLibFirstReqErrCode, this.errorCode, afterSwitchNetLibReqFailedCnt);
                                this.mT2ASwitchFlag = false;
                            }
                        }
                        if (bArr != null) {
                            this.dataSize = bArr.length;
                        } else {
                            this.dataSize = 0;
                        }
                        this.isGif = this.mHttpClient.isGif();
                        this.isCrackPic = this.mHttpClient.isCrackPic();
                        int size = this.mContext.d().size();
                        if (size > 0) {
                            sb.append("_ipsize:");
                            sb.append(size);
                            sb.append("_ips:");
                            while (i2 < size) {
                                if (this.mContext.d().get(i2) != null) {
                                    sb.append(this.mContext.d().get(i2).f2434k);
                                }
                                if (i2 != size - 1) {
                                    sb.append("_");
                                }
                                i2++;
                            }
                        }
                        d a = this.mContext.a();
                        this.mStat = a;
                        if (a != null) {
                            StringBuilder sb2 = new StringBuilder();
                            d dVar = this.mStat;
                            sb2.append(dVar.f2431h);
                            sb2.append(sb.toString());
                            dVar.f2431h = sb2.toString();
                            StringBuilder sb3 = new StringBuilder();
                            d dVar2 = this.mStat;
                            sb3.append(dVar2.f2431h);
                            sb3.append("_responseCode:");
                            sb3.append(this.responseCode);
                            dVar2.f2431h = sb3.toString();
                            StringBuilder sb4 = new StringBuilder();
                            d dVar3 = this.mStat;
                            sb4.append(dVar3.f2431h);
                            sb4.append("_size:");
                            sb4.append(Integer.toString(this.dataSize));
                            dVar3.f2431h = sb4.toString();
                        }
                        return bArr;
                    } catch (Exception e2) {
                        sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                        int size2 = this.mContext.d().size();
                        if (size2 > 0) {
                            sb.append("_ipsize:");
                            sb.append(size2);
                            sb.append("_ips:");
                            while (i2 < size2) {
                                if (this.mContext.d().get(i2) != null) {
                                    sb.append(this.mContext.d().get(i2).f2434k);
                                }
                                if (i2 != size2 - 1) {
                                    sb.append("_");
                                }
                                i2++;
                            }
                        }
                        d a2 = this.mContext.a();
                        this.mStat = a2;
                        if (a2 != null) {
                            StringBuilder sb5 = new StringBuilder();
                            d dVar4 = this.mStat;
                            sb5.append(dVar4.f2431h);
                            sb5.append(sb.toString());
                            dVar4.f2431h = sb5.toString();
                            StringBuilder sb6 = new StringBuilder();
                            d dVar5 = this.mStat;
                            sb6.append(dVar5.f2431h);
                            sb6.append("_responseCode:");
                            sb6.append(this.responseCode);
                            dVar5.f2431h = sb6.toString();
                            StringBuilder sb7 = new StringBuilder();
                            d dVar6 = this.mStat;
                            sb7.append(dVar6.f2431h);
                            sb7.append("_size:");
                            sb7.append(Integer.toString(this.dataSize));
                            dVar6.f2431h = sb7.toString();
                            return null;
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    int size3 = this.mContext.d().size();
                    if (size3 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size3);
                        sb.append("_ips:");
                        while (i2 < size3) {
                            if (this.mContext.d().get(i2) != null) {
                                sb.append(this.mContext.d().get(i2).f2434k);
                            }
                            if (i2 != size3 - 1) {
                                sb.append("_");
                            }
                            i2++;
                        }
                    }
                    d a3 = this.mContext.a();
                    this.mStat = a3;
                    if (a3 != null) {
                        StringBuilder sb8 = new StringBuilder();
                        d dVar7 = this.mStat;
                        sb8.append(dVar7.f2431h);
                        sb8.append(sb.toString());
                        dVar7.f2431h = sb8.toString();
                        StringBuilder sb9 = new StringBuilder();
                        d dVar8 = this.mStat;
                        sb9.append(dVar8.f2431h);
                        sb9.append("_responseCode:");
                        sb9.append(this.responseCode);
                        dVar8.f2431h = sb9.toString();
                        StringBuilder sb10 = new StringBuilder();
                        d dVar9 = this.mStat;
                        sb10.append(dVar9.f2431h);
                        sb10.append("_size:");
                        sb10.append(Integer.toString(this.dataSize));
                        dVar9.f2431h = sb10.toString();
                    }
                    throw th;
                }
            }
            try {
                byte[] downloadBytesInternal = downloadBytesInternal(str);
                int i4 = afterSwitchNetLibReqCnt + 1;
                afterSwitchNetLibReqCnt = i4;
                if (i4 <= 2 && this.responseCode != 200) {
                    if (i4 == 1) {
                        afterSwitchNetLibFirstReqErrCode = this.errorCode;
                    }
                    afterSwitchNetLibReqFailedCnt++;
                }
                if (afterSwitchNetLibReqCnt == 2) {
                    ImageLogger.eventStatForHttpSwitch("A2T", afterSwitchNetLibFirstReqErrCode, this.errorCode, afterSwitchNetLibReqFailedCnt);
                }
                if (isSwitchNetLib()) {
                    this.mUseHttpClient = true;
                    this.mT2ASwitchFlag = true;
                    TbadkCoreApplication.getInst().setHttpClientOpen(true);
                    afterSwitchNetLibReqFailedCnt = 0;
                    afterSwitchNetLibReqCnt = 0;
                    afterSwitchNetLibFirstReqErrCode = 0;
                }
                if (downloadBytesInternal == null) {
                    return null;
                }
                if (this.mContext == null || this.mContext.c().f2449g == null) {
                    z2 = false;
                } else {
                    List<String> list2 = this.mContext.c().f2449g.get("imgsrc");
                    z2 = list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0;
                    List<String> list3 = this.mContext.c().f2449g.get("Src-Content-Type");
                    if (list3 != null && list3.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list4 = this.mContext.c().f2449g.get("Error-Message");
                    if (list4 != null && list4.size() > 0) {
                        String str3 = list4.get(0);
                        if (!TextUtils.isEmpty(str3) && !str3.equalsIgnoreCase(StatHelper.SENSOR_OK)) {
                            this.isCrackPic = true;
                        }
                        this.isCrackPic = false;
                    }
                }
                return this.mIsRequestSuccess ? ((z || z2) && new String(downloadBytesInternal, 0, 23).equalsIgnoreCase(IMAGESECRET)) ? copyOfRange(downloadBytesInternal, 23, downloadBytesInternal.length) : downloadBytesInternal : downloadBytesInternal;
            } catch (Exception e3) {
                this.exception += "BDIMAGE DECODE ERROR" + e3.getMessage();
                return null;
            }
        }
        return (byte[]) invokeLZ.objValue;
    }

    public void addPostParameter(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (this.mPostList == null) {
                this.mPostList = new HashMap<>();
            }
            this.mPostList.put(str, str2);
        }
    }
}
