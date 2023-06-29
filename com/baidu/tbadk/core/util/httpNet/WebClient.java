package com.baidu.tbadk.core.util.httpNet;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.UseHttpAutoRetrySwitch;
import com.baidu.tieba.ag;
import com.baidu.tieba.bg;
import com.baidu.tieba.ej;
import com.baidu.tieba.pg;
import com.baidu.tieba.r95;
import com.baidu.tieba.wf;
import com.baidu.tieba.yf;
import com.baidu.tieba.zf;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes4.dex */
public class WebClient implements pg.a {
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
    public volatile wf mBdHttpManager2;
    public zf mContext;
    public boolean mIsRequestSuccess;
    public HashMap<String, String> mPostList;
    public bg mResponse;
    public yf mStat;
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

    public boolean isMobileProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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
        this.mResponse = new bg();
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
                    yf yfVar = this.mContext.d().get(i);
                    stringBuffer.append(" index: ");
                    stringBuffer.append(i);
                    stringBuffer.append("exception:");
                    stringBuffer.append(yfVar.h);
                    stringBuffer.append("retry:");
                    stringBuffer.append(yfVar.e);
                    stringBuffer.append("connectTime:");
                    stringBuffer.append(yfVar.c);
                    stringBuffer.append("downloadSize:");
                    stringBuffer.append(yfVar.b);
                    stringBuffer.append("rspTime:");
                    stringBuffer.append(yfVar.d);
                    stringBuffer.append("dnsTime:");
                    stringBuffer.append(yfVar.g);
                    stringBuffer.append("responsedCode:");
                    stringBuffer.append(yfVar.i);
                    stringBuffer.append("allCostTime:");
                    stringBuffer.append(yfVar.f);
                    stringBuffer.append("executeStatus:");
                    stringBuffer.append(yfVar.j);
                }
                if (exc != null) {
                    stringBuffer.append("webclient exception");
                    stringBuffer.append("class");
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
        boolean z;
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
                    zf zfVar = new zf();
                    this.mContext = zfVar;
                    zfVar.b().s(str);
                    this.mContext.b().n(UseHttpAutoRetrySwitch.isOn());
                    ag b = this.mContext.b();
                    b.a("User-Agent", "tieba image flow version : " + TbConfig.getVersion() + " cuid : " + TbadkCoreApplication.getInst().getCuidGalaxy2());
                    if (this.mPostList != null) {
                        for (Map.Entry<String, String> entry : this.mPostList.entrySet()) {
                            this.mContext.b().b(entry.getKey(), entry.getValue());
                        }
                    }
                    this.mBdHttpManager2 = new wf(this.mContext);
                    this.mBdHttpManager2.d(RETRYCOUNT, 0, 0);
                    bg c = this.mContext.c();
                    this.mResponse = c;
                    if (c != null && c.h != null && (list = c.h.get(Headers.CACHE_CONTROL)) != null && list.size() > 0) {
                        if (!"no-cache".equals(list.get(0))) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.needCache = z;
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
                    yf a = this.mContext.a();
                    this.mStat = a;
                    if (a != null) {
                        StringBuilder sb = new StringBuilder();
                        yf yfVar = this.mStat;
                        sb.append(yfVar.h);
                        sb.append(stringBuffer.toString());
                        yfVar.h = sb.toString();
                        StringBuilder sb2 = new StringBuilder();
                        yf yfVar2 = this.mStat;
                        sb2.append(yfVar2.h);
                        sb2.append("_responseCode:");
                        sb2.append(this.responseCode);
                        yfVar2.h = sb2.toString();
                    }
                    return bArr;
                } catch (Exception e) {
                    stringBuffer.append("httpmanagererr_" + e.getClass() + "_" + e.getMessage());
                    yf a2 = this.mContext.a();
                    this.mStat = a2;
                    if (a2 == null) {
                        return null;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    yf yfVar3 = this.mStat;
                    sb3.append(yfVar3.h);
                    sb3.append(stringBuffer.toString());
                    yfVar3.h = sb3.toString();
                    StringBuilder sb4 = new StringBuilder();
                    yf yfVar4 = this.mStat;
                    sb4.append(yfVar4.h);
                    sb4.append("_responseCode:");
                    sb4.append(this.responseCode);
                    yfVar4.h = sb4.toString();
                    return null;
                }
            } catch (Throwable th) {
                yf a3 = this.mContext.a();
                this.mStat = a3;
                if (a3 != null) {
                    StringBuilder sb5 = new StringBuilder();
                    yf yfVar5 = this.mStat;
                    sb5.append(yfVar5.h);
                    sb5.append(stringBuffer.toString());
                    yfVar5.h = sb5.toString();
                    StringBuilder sb6 = new StringBuilder();
                    yf yfVar6 = this.mStat;
                    sb6.append(yfVar6.h);
                    sb6.append("_responseCode:");
                    sb6.append(this.responseCode);
                    yfVar6.h = sb6.toString();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mIsRequestSuccess;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pg.a
    public void cancel() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.mBdHttpManager2 != null) {
            this.mBdHttpManager2.b();
        }
    }

    public bg getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mResponse;
        }
        return (bg) invokeV.objValue;
    }

    public boolean needCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (r95.p().q("image_no_cache_switch", 0) != 1) {
                return true;
            }
            return this.needCache;
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

    public byte[] downloadCommonBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return downloadBytesInternal(str);
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] downloadImageBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return downloadImageBytes(str, false);
        }
        return (byte[]) invokeL.objValue;
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
                if (this.mContext != null && this.mContext.c().h != null) {
                    List<String> list = this.mContext.c().h.get("imgsrc");
                    if (list != null && list.size() > 0 && (str2 = list.get(0)) != null && str2.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
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
                } else {
                    z2 = false;
                }
                if (this.mIsRequestSuccess && ((z || z2) && new String(downloadBytesInternal, 0, 23).equalsIgnoreCase(IMAGESECRET))) {
                    downloadBytesInternal = copyOfRange(downloadBytesInternal, 23, downloadBytesInternal.length);
                }
                if (downloadBytesInternal.length == 4262 && "E9FA8E3AF5271BBFA7BDDBCAD1E8BE5B".equals(ej.d(downloadBytesInternal))) {
                    TiebaStatic.log(new StatisticItem("image_time_err").addParam("obj_source", str).addParam("obj_param1", TbadkCoreApplication.getInst().getCurrentActivity() + "").addParam(TiebaStatic.Params.OBJ_PARAM2, System.currentTimeMillis()));
                }
                return downloadBytesInternal;
            } catch (Exception e) {
                this.exception += "BDIMAGE DECODE ERROR" + e.getMessage();
                return null;
            }
        }
        return (byte[]) invokeLZ.objValue;
    }
}
