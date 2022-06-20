package com.baidu.tbadk.core.util.httpNet;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.UseHttpAutoRetrySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import com.repackage.hg;
import com.repackage.ht4;
import com.repackage.of;
import com.repackage.qf;
import com.repackage.rf;
import com.repackage.sf;
import com.repackage.tf;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes3.dex */
public class WebClient implements hg.a {
    public static /* synthetic */ Interceptable $ic = null;
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
    public volatile of mBdHttpManager2;
    public rf mContext;
    public boolean mIsRequestSuccess;
    public HashMap<String, String> mPostList;
    public tf mResponse;
    public qf mStat;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBdHttpManager2 = null;
        this.mPostList = null;
        this.mResponse = new tf();
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
                for (int i = 0; i < this.mContext.d().size(); i++) {
                    qf qfVar = this.mContext.d().get(i);
                    stringBuffer.append(" index: ");
                    stringBuffer.append(i);
                    stringBuffer.append("exception:");
                    stringBuffer.append(qfVar.h);
                    stringBuffer.append("retry:");
                    stringBuffer.append(qfVar.e);
                    stringBuffer.append("connectTime:");
                    stringBuffer.append(qfVar.c);
                    stringBuffer.append("downloadSize:");
                    stringBuffer.append(qfVar.b);
                    stringBuffer.append("rspTime:");
                    stringBuffer.append(qfVar.d);
                    stringBuffer.append("dnsTime:");
                    stringBuffer.append(qfVar.g);
                    stringBuffer.append("responsedCode:");
                    stringBuffer.append(qfVar.i);
                    stringBuffer.append("allCostTime:");
                    stringBuffer.append(qfVar.f);
                    stringBuffer.append("executeStatus:");
                    stringBuffer.append(qfVar.j);
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

    public static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i, i2)) == null) {
            int i3 = i2 - i;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
                return bArr2;
            }
            throw new IllegalArgumentException(i + " > " + i2);
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
                    rf rfVar = new rf();
                    this.mContext = rfVar;
                    rfVar.b().v(str);
                    this.mContext.b().p(UseHttpAutoRetrySwitch.isOn());
                    sf b = this.mContext.b();
                    b.a("User-Agent", "tieba image flow version : " + TbConfig.getVersion() + " cuid : " + TbadkCoreApplication.getInst().getCuidGalaxy2());
                    if (this.mPostList != null) {
                        for (Map.Entry<String, String> entry : this.mPostList.entrySet()) {
                            this.mContext.b().b(entry.getKey(), entry.getValue());
                        }
                    }
                    this.mBdHttpManager2 = new of(this.mContext);
                    this.mBdHttpManager2.d(RETRYCOUNT, 0, 0);
                    tf c = this.mContext.c();
                    this.mResponse = c;
                    if (c != null && c.h != null && (list = c.h.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                        this.needCache = !"no-cache".equals(list.get(0));
                    }
                    byte[] bArr = this.mContext.c().i;
                    this.responseCode = this.mContext.c().b;
                    this.errorCode = this.mContext.c().c;
                    this.mIsRequestSuccess = this.mContext.c().b();
                    if (bArr != null) {
                        this.dataSize = bArr.length;
                    } else {
                        this.dataSize = 0;
                    }
                    if (this.mContext.c().d != null && this.mContext.c().d.toLowerCase().contains("gzip")) {
                        this.isGzip = true;
                    }
                    if (!this.mIsRequestSuccess) {
                        buildException(str, null);
                    }
                    qf a = this.mContext.a();
                    this.mStat = a;
                    if (a != null) {
                        StringBuilder sb = new StringBuilder();
                        qf qfVar = this.mStat;
                        sb.append(qfVar.h);
                        sb.append(stringBuffer.toString());
                        qfVar.h = sb.toString();
                        StringBuilder sb2 = new StringBuilder();
                        qf qfVar2 = this.mStat;
                        sb2.append(qfVar2.h);
                        sb2.append("_responseCode:");
                        sb2.append(this.responseCode);
                        qfVar2.h = sb2.toString();
                    }
                    return bArr;
                } catch (Exception e) {
                    stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                    qf a2 = this.mContext.a();
                    this.mStat = a2;
                    if (a2 != null) {
                        StringBuilder sb3 = new StringBuilder();
                        qf qfVar3 = this.mStat;
                        sb3.append(qfVar3.h);
                        sb3.append(stringBuffer.toString());
                        qfVar3.h = sb3.toString();
                        StringBuilder sb4 = new StringBuilder();
                        qf qfVar4 = this.mStat;
                        sb4.append(qfVar4.h);
                        sb4.append("_responseCode:");
                        sb4.append(this.responseCode);
                        qfVar4.h = sb4.toString();
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th) {
                qf a3 = this.mContext.a();
                this.mStat = a3;
                if (a3 != null) {
                    StringBuilder sb5 = new StringBuilder();
                    qf qfVar5 = this.mStat;
                    sb5.append(qfVar5.h);
                    sb5.append(stringBuffer.toString());
                    qfVar5.h = sb5.toString();
                    StringBuilder sb6 = new StringBuilder();
                    qf qfVar6 = this.mStat;
                    sb6.append(qfVar6.h);
                    sb6.append("_responseCode:");
                    sb6.append(this.responseCode);
                    qfVar6.h = sb6.toString();
                }
                throw th;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    private boolean isSwitchNetLib() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (!this.mResponse.a && ((i = this.errorCode) == -12 || i == -18 || i == -19)) {
                int i2 = clientFailedCnt + 1;
                clientFailedCnt = i2;
                if (i2 >= 5) {
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

    @Override // com.repackage.hg.a
    public void cancel() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.mBdHttpManager2 == null) {
            return;
        }
        this.mBdHttpManager2.b();
    }

    public byte[] downloadCommonBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? downloadBytesInternal(str) : (byte[]) invokeL.objValue;
    }

    public byte[] downloadImageBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? downloadImageBytes(str, false) : (byte[]) invokeL.objValue;
    }

    public tf getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mResponse : (tf) invokeV.objValue;
    }

    public boolean isMobileProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean needCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (ht4.k().l("image_no_cache_switch", 0) == 1) {
                return this.needCache;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void resetStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mStat = null;
            this.exception = "";
            this.mIsRequestSuccess = false;
            this.responseCode = -1;
            this.dataSize = -1;
            this.isGif = false;
            this.isGzip = false;
        }
    }

    public byte[] downloadImageBytes(String str, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            this.needCache = true;
            try {
                byte[] downloadBytesInternal = downloadBytesInternal(str);
                int i = afterSwitchNetLibReqCnt + 1;
                afterSwitchNetLibReqCnt = i;
                if (i <= 2 && this.responseCode != 200) {
                    if (i == 1) {
                        afterSwitchNetLibFirstReqErrCode = this.errorCode;
                    }
                    afterSwitchNetLibReqFailedCnt++;
                }
                if (afterSwitchNetLibReqCnt == 2) {
                    ImageLogger.eventStatForHttpSwitch("A2T", afterSwitchNetLibFirstReqErrCode, this.errorCode, afterSwitchNetLibReqFailedCnt);
                }
                if (isSwitchNetLib()) {
                    afterSwitchNetLibReqFailedCnt = 0;
                    afterSwitchNetLibReqCnt = 0;
                    afterSwitchNetLibFirstReqErrCode = 0;
                }
                if (downloadBytesInternal == null) {
                    return null;
                }
                if (this.mContext == null || this.mContext.c().h == null) {
                    z2 = false;
                } else {
                    List<String> list = this.mContext.c().h.get("imgsrc");
                    z2 = list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0;
                    List<String> list2 = this.mContext.c().h.get("Src-Content-Type");
                    if (list2 != null && list2.size() > 0) {
                        if ("image/gif".equalsIgnoreCase(list2.get(0))) {
                            this.isGif = true;
                        } else {
                            this.isGif = false;
                        }
                    }
                    List<String> list3 = this.mContext.c().h.get("Error-Message");
                    if (list3 != null && list3.size() > 0) {
                        String str3 = list3.get(0);
                        if (!TextUtils.isEmpty(str3) && !str3.equalsIgnoreCase("OK")) {
                            this.isCrackPic = true;
                        }
                        this.isCrackPic = false;
                    }
                }
                return this.mIsRequestSuccess ? ((z || z2) && new String(downloadBytesInternal, 0, 23).equalsIgnoreCase(IMAGESECRET)) ? copyOfRange(downloadBytesInternal, 23, downloadBytesInternal.length) : downloadBytesInternal : downloadBytesInternal;
            } catch (Exception e) {
                this.exception += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        return (byte[]) invokeLZ.objValue;
    }
}
