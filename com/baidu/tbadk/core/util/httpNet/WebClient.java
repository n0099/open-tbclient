package com.baidu.tbadk.core.util.httpNet;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.UseHttpAutoRetrySwitch;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import d.b.c.e.j.a.c;
import d.b.c.e.j.a.d;
import d.b.c.e.j.a.e;
import d.b.c.e.j.a.g;
import d.b.c.e.l.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes3.dex */
public class WebClient implements b.a {
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
    public e mContext;
    public ImgHttpClient mHttpClient;
    public volatile c mBdHttpManager2 = null;
    public HashMap<String, String> mPostList = null;
    public g mResponse = new g();
    public boolean isGzip = false;
    public boolean isGif = false;
    public String exception = "";
    public d mStat = null;
    public int dataSize = -1;
    public int responseCode = -1;
    public int errorCode = -1;
    public boolean needCache = true;
    public boolean mIsRequestSuccess = false;
    public boolean isCrackPic = false;
    public boolean mUseHttpClient = TbadkCoreApplication.getInst().isHttpClientOpen();
    public boolean mUseHttpAutoSwitch = TbadkCoreApplication.getInst().isHttpAutoSwitch();
    public boolean mT2ASwitchFlag = false;

    private void buildException(String str, Exception exc) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" url:");
            stringBuffer.append(str);
            stringBuffer.append("thread_id:");
            stringBuffer.append(Thread.currentThread().getId());
            for (int i = 0; i < this.mContext.d().size(); i++) {
                d dVar = this.mContext.d().get(i);
                stringBuffer.append(" index: ");
                stringBuffer.append(i);
                stringBuffer.append("exception:");
                stringBuffer.append(dVar.f42522h);
                stringBuffer.append("retry:");
                stringBuffer.append(dVar.f42519e);
                stringBuffer.append("connectTime:");
                stringBuffer.append(dVar.f42517c);
                stringBuffer.append("downloadSize:");
                stringBuffer.append(dVar.f42516b);
                stringBuffer.append("rspTime:");
                stringBuffer.append(dVar.f42518d);
                stringBuffer.append("dnsTime:");
                stringBuffer.append(dVar.f42521g);
                stringBuffer.append("responsedCode:");
                stringBuffer.append(dVar.i);
                stringBuffer.append("allCostTime:");
                stringBuffer.append(dVar.f42520f);
                stringBuffer.append("executeStatus:");
                stringBuffer.append(dVar.j);
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

    public static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 >= 0) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
            return bArr2;
        }
        throw new IllegalArgumentException(i + " > " + i2);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, IPUT]}, finally: {[IGET, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IPUT, IF] complete} */
    private final byte[] downloadBytesInternal(String str) {
        List<String> list;
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
                if (c2 != null && c2.f42540g != null && (list = c2.f42540g.get("Cache-Control")) != null && list.size() > 0) {
                    this.needCache = !"no-cache".equals(list.get(0));
                }
                byte[] bArr = this.mContext.c().f42541h;
                this.responseCode = this.mContext.c().f42535b;
                this.errorCode = this.mContext.c().f42536c;
                this.mIsRequestSuccess = this.mContext.c().b();
                if (bArr != null) {
                    this.dataSize = bArr.length;
                } else {
                    this.dataSize = 0;
                }
                if (this.mContext.c().f42537d != null && this.mContext.c().f42537d.toLowerCase().contains(AsyncHttpClient.ENCODING_GZIP)) {
                    this.isGzip = true;
                }
                if (!this.mIsRequestSuccess) {
                    buildException(str, null);
                }
                d a2 = this.mContext.a();
                this.mStat = a2;
                if (a2 != null) {
                    StringBuilder sb = new StringBuilder();
                    d dVar = this.mStat;
                    sb.append(dVar.f42522h);
                    sb.append(stringBuffer.toString());
                    dVar.f42522h = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    d dVar2 = this.mStat;
                    sb2.append(dVar2.f42522h);
                    sb2.append("_responseCode:");
                    sb2.append(this.responseCode);
                    dVar2.f42522h = sb2.toString();
                }
                return bArr;
            } catch (Exception e2) {
                stringBuffer.append("httpmanagererr_" + e2.getClass() + "_" + e2.getMessage());
                d a3 = this.mContext.a();
                this.mStat = a3;
                if (a3 != null) {
                    StringBuilder sb3 = new StringBuilder();
                    d dVar3 = this.mStat;
                    sb3.append(dVar3.f42522h);
                    sb3.append(stringBuffer.toString());
                    dVar3.f42522h = sb3.toString();
                    StringBuilder sb4 = new StringBuilder();
                    d dVar4 = this.mStat;
                    sb4.append(dVar4.f42522h);
                    sb4.append("_responseCode:");
                    sb4.append(this.responseCode);
                    dVar4.f42522h = sb4.toString();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            d a4 = this.mContext.a();
            this.mStat = a4;
            if (a4 != null) {
                StringBuilder sb5 = new StringBuilder();
                d dVar5 = this.mStat;
                sb5.append(dVar5.f42522h);
                sb5.append(stringBuffer.toString());
                dVar5.f42522h = sb5.toString();
                StringBuilder sb6 = new StringBuilder();
                d dVar6 = this.mStat;
                sb6.append(dVar6.f42522h);
                sb6.append("_responseCode:");
                sb6.append(this.responseCode);
                dVar6.f42522h = sb6.toString();
            }
            throw th;
        }
    }

    private boolean isSwitchNetLib() {
        int i;
        if (!this.mResponse.f42534a && ((i = this.errorCode) == -12 || i == -18 || i == -19)) {
            int i2 = clientFailedCnt + 1;
            clientFailedCnt = i2;
            if (i2 >= 5) {
                clientFailedCnt = 0;
                return true;
            }
        }
        return false;
    }

    public boolean IsRequestSuccess() {
        return this.mIsRequestSuccess;
    }

    public void addPostParameter(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair == null) {
            return;
        }
        if (this.mPostList == null) {
            this.mPostList = new HashMap<>();
        }
        this.mPostList.put(basicNameValuePair.getName(), basicNameValuePair.getValue());
    }

    @Override // d.b.c.e.l.b.a
    public void cancel() {
        if (this.mBdHttpManager2 != null) {
            this.mBdHttpManager2.b();
        }
        ImgHttpClient imgHttpClient = this.mHttpClient;
        if (imgHttpClient != null) {
            imgHttpClient.cancel();
            this.mHttpClient = null;
        }
    }

    public byte[] downloadCommonBytes(String str) {
        return downloadBytesInternal(str);
    }

    public byte[] downloadImageBytes(String str) {
        return downloadImageBytes(str, false);
    }

    public String downloadString(String str) {
        byte[] downloadBytesInternal = downloadBytesInternal(str);
        try {
            return new String(downloadBytesInternal, 0, downloadBytesInternal.length, this.mContext.c().f42537d);
        } catch (Exception unused) {
            return null;
        }
    }

    public g getResponse() {
        return this.mResponse;
    }

    public boolean isMobileProxy() {
        ImgHttpClient imgHttpClient = this.mHttpClient;
        if (imgHttpClient == null) {
            return false;
        }
        return imgHttpClient.isMobileProxy;
    }

    public boolean needCache() {
        if (d.b.i0.r.d0.b.j().k("image_no_cache_switch", 0) == 1) {
            return this.needCache;
        }
        return true;
    }

    public void resetStatus() {
        this.mStat = null;
        this.exception = "";
        this.mIsRequestSuccess = false;
        this.responseCode = -1;
        this.dataSize = -1;
        this.isGif = false;
        this.isGzip = false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, ARITH, INVOKE, ARITH, IF, ARITH, IGET, INVOKE, INVOKE, CHECK_CAST, IGET, INVOKE, ARITH, INVOKE, ARITH, IF, ARITH, IF, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IF, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IPUT, CONSTRUCTOR, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IPUT, IF, IGET, INVOKE, IPUT, IF] complete} */
    public byte[] downloadImageBytes(String str, boolean z) {
        boolean z2;
        String str2;
        List<String> list;
        this.needCache = true;
        int i = 0;
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
                    if (c2 != null && c2.f42540g != null && (list = c2.f42540g.get("Cache-Control")) != null && list.size() > 0) {
                        this.needCache = !"no-cache".equals(list.get(0));
                    }
                    byte[] bArr = this.mContext.c().f42541h;
                    this.responseCode = this.mContext.c().f42535b;
                    this.errorCode = this.mContext.c().f42536c;
                    this.mIsRequestSuccess = this.mContext.c().b();
                    if (this.mUseHttpAutoSwitch && true == isSwitchNetLib()) {
                        this.mUseHttpClient = false;
                        TbadkCoreApplication.getInst().setHttpClientOpen(false);
                        afterSwitchNetLibReqFailedCnt = 0;
                        afterSwitchNetLibReqCnt = 0;
                        afterSwitchNetLibFirstReqErrCode = 0;
                    }
                    if (this.mT2ASwitchFlag) {
                        int i2 = afterSwitchNetLibReqCnt + 1;
                        afterSwitchNetLibReqCnt = i2;
                        if (i2 <= 2 && this.responseCode != 200) {
                            afterSwitchNetLibReqFailedCnt++;
                            if (i2 == 1) {
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
                        while (i < size) {
                            if (this.mContext.d().get(i) != null) {
                                sb.append(this.mContext.d().get(i).k);
                            }
                            if (i != size - 1) {
                                sb.append("_");
                            }
                            i++;
                        }
                    }
                    d a2 = this.mContext.a();
                    this.mStat = a2;
                    if (a2 != null) {
                        StringBuilder sb2 = new StringBuilder();
                        d dVar = this.mStat;
                        sb2.append(dVar.f42522h);
                        sb2.append(sb.toString());
                        dVar.f42522h = sb2.toString();
                        StringBuilder sb3 = new StringBuilder();
                        d dVar2 = this.mStat;
                        sb3.append(dVar2.f42522h);
                        sb3.append("_responseCode:");
                        sb3.append(this.responseCode);
                        dVar2.f42522h = sb3.toString();
                        StringBuilder sb4 = new StringBuilder();
                        d dVar3 = this.mStat;
                        sb4.append(dVar3.f42522h);
                        sb4.append("_size:");
                        sb4.append(Integer.toString(this.dataSize));
                        dVar3.f42522h = sb4.toString();
                    }
                    return bArr;
                } catch (Exception e2) {
                    sb.append("_httpclienterr_" + e2.getClass() + "_" + e2.getMessage());
                    int size2 = this.mContext.d().size();
                    if (size2 > 0) {
                        sb.append("_ipsize:");
                        sb.append(size2);
                        sb.append("_ips:");
                        while (i < size2) {
                            if (this.mContext.d().get(i) != null) {
                                sb.append(this.mContext.d().get(i).k);
                            }
                            if (i != size2 - 1) {
                                sb.append("_");
                            }
                            i++;
                        }
                    }
                    d a3 = this.mContext.a();
                    this.mStat = a3;
                    if (a3 != null) {
                        StringBuilder sb5 = new StringBuilder();
                        d dVar4 = this.mStat;
                        sb5.append(dVar4.f42522h);
                        sb5.append(sb.toString());
                        dVar4.f42522h = sb5.toString();
                        StringBuilder sb6 = new StringBuilder();
                        d dVar5 = this.mStat;
                        sb6.append(dVar5.f42522h);
                        sb6.append("_responseCode:");
                        sb6.append(this.responseCode);
                        dVar5.f42522h = sb6.toString();
                        StringBuilder sb7 = new StringBuilder();
                        d dVar6 = this.mStat;
                        sb7.append(dVar6.f42522h);
                        sb7.append("_size:");
                        sb7.append(Integer.toString(this.dataSize));
                        dVar6.f42522h = sb7.toString();
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
                    while (i < size3) {
                        if (this.mContext.d().get(i) != null) {
                            sb.append(this.mContext.d().get(i).k);
                        }
                        if (i != size3 - 1) {
                            sb.append("_");
                        }
                        i++;
                    }
                }
                d a4 = this.mContext.a();
                this.mStat = a4;
                if (a4 != null) {
                    StringBuilder sb8 = new StringBuilder();
                    d dVar7 = this.mStat;
                    sb8.append(dVar7.f42522h);
                    sb8.append(sb.toString());
                    dVar7.f42522h = sb8.toString();
                    StringBuilder sb9 = new StringBuilder();
                    d dVar8 = this.mStat;
                    sb9.append(dVar8.f42522h);
                    sb9.append("_responseCode:");
                    sb9.append(this.responseCode);
                    dVar8.f42522h = sb9.toString();
                    StringBuilder sb10 = new StringBuilder();
                    d dVar9 = this.mStat;
                    sb10.append(dVar9.f42522h);
                    sb10.append("_size:");
                    sb10.append(Integer.toString(this.dataSize));
                    dVar9.f42522h = sb10.toString();
                }
                throw th;
            }
        }
        try {
            byte[] downloadBytesInternal = downloadBytesInternal(str);
            int i3 = afterSwitchNetLibReqCnt + 1;
            afterSwitchNetLibReqCnt = i3;
            if (i3 <= 2 && this.responseCode != 200) {
                if (i3 == 1) {
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
            if (this.mContext == null || this.mContext.c().f42540g == null) {
                z2 = false;
            } else {
                List<String> list2 = this.mContext.c().f42540g.get("imgsrc");
                z2 = list2 != null && list2.size() > 0 && (str2 = list2.get(0)) != null && str2.length() > 0;
                List<String> list3 = this.mContext.c().f42540g.get("Src-Content-Type");
                if (list3 != null && list3.size() > 0) {
                    if ("image/gif".equalsIgnoreCase(list3.get(0))) {
                        this.isGif = true;
                    } else {
                        this.isGif = false;
                    }
                }
                List<String> list4 = this.mContext.c().f42540g.get("Error-Message");
                if (list4 != null && list4.size() > 0) {
                    String str3 = list4.get(0);
                    if (!TextUtils.isEmpty(str3) && !str3.equalsIgnoreCase("OK")) {
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

    public void addPostParameter(String str, String str2) {
        if (this.mPostList == null) {
            this.mPostList = new HashMap<>();
        }
        this.mPostList.put(str, str2);
    }
}
