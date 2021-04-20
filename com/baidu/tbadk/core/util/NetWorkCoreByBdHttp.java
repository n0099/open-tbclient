package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.NetWorkState;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.HttpResponse;
import com.baidu.tbadk.switchs.NetDeleteSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.StringU;
import com.baidu.wallet.router.RouterCallback;
import d.b.c.e.j.a.c;
import d.b.c.e.j.a.d;
import d.b.c.e.j.a.e;
import d.b.c.e.j.a.g;
import d.b.c.e.j.a.h;
import d.b.c.e.j.b.a;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.q;
import d.b.h0.o0.b;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TimerTask;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class NetWorkCoreByBdHttp implements INetWorkCore {
    public static final int BUFFERSIZE = 1024;
    public static int MAX_DATA_LENG = 2097152;
    public Context mContext;
    public a manager = new a();
    public final HttpNetContext netContext;

    /* loaded from: classes3.dex */
    public class CancleTask extends TimerTask {
        public CancleTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                NetWorkCoreByBdHttp.this.cancelNetConnect();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public NetWorkCoreByBdHttp(HttpNetContext httpNetContext) {
        initNetWork();
        this.mContext = TbadkCoreApplication.getInst().getApp();
        this.netContext = httpNetContext;
        a.u("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void addPerformanceData(long j, long j2, int i) {
        a aVar;
        c f2;
        if (this.netContext == null || (aVar = this.manager) == null || (f2 = aVar.f()) == null) {
            return;
        }
        long h2 = f2.h();
        long j3 = f2.j();
        long g2 = f2.g();
        long i2 = f2.i();
        long f3 = f2.f();
        long j4 = h2 - j;
        long j5 = j3 - h2;
        int k = f2.k();
        long j6 = i2 - j3;
        long j7 = g2 - j3;
        long j8 = i2 - g2;
        long j9 = f3 - i2;
        if (f3 <= 0) {
            j9 = 0;
        }
        HashMap<String, String> performance = this.netContext.getPerformance();
        performance.put("startTime", String.valueOf(System.currentTimeMillis()));
        performance.put("netConTime", String.valueOf(j4));
        performance.put("netRWTime", String.valueOf(j6));
        performance.put("firstByteTime", String.valueOf(j7));
        performance.put("allDataReadTime", String.valueOf(j8));
        performance.put("dataDeCompressTime", String.valueOf(j9));
        performance.put("httpRetryNum", String.valueOf(k));
        performance.put("httpRetryCostTime", String.valueOf(j5));
        performance.put("dataParseTime", String.valueOf(j2 - f3));
        performance.put("isHttp", "1");
        performance.put("httpSize", String.valueOf(i));
        performance.put(RouterCallback.KEY_ERROR_CODE, String.valueOf(this.netContext.getResponse().mNetErrorCode));
    }

    private int getAddPostIndex(ArrayList<BasicNameValuePair> arrayList, String str) {
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
        return i >= size ? size : i2;
    }

    private LinkedList<BasicNameValuePair> getExtendHeader() {
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

    private int getMode(int i) {
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

    private void initNetWork() {
        this.mContext = null;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void cancelNetConnect() {
        this.manager.c();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, IGET, INVOKE, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, CHECK_CAST, INVOKE, IGET, INVOKE, IGET, INVOKE, IGET, INVOKE, CONSTRUCTOR, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, IGET, IPUT, IGET, IPUT, IGET, IPUT, IGET, INVOKE, INVOKE, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, INVOKE, IF, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, IF] complete} */
    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        int i4;
        b bVar;
        File CreateFileIfNotFoundInCache;
        boolean z2 = false;
        try {
            try {
            } catch (Exception e2) {
                this.netContext.getResponse().mNetErrorCode = -10;
                HttpResponse response = this.netContext.getResponse();
                response.mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                BdLog.e(e2.getMessage());
                e e3 = this.manager.e();
                if (e3 != null && e3.d() != null && handler != null) {
                    i4 = e3.c().f42296c;
                    int size = e3.d().size();
                    bVar = new b();
                    if (size > 0) {
                        d dVar = e3.d().get(size - 1);
                        bVar.c(i4);
                        bVar.e(this.netContext.getResponse().mNetErrorCode);
                        bVar.d(dVar.f42282h);
                        bVar.b(dVar.q + "_" + dVar.n + "_" + dVar.l + "_" + dVar.m + "_" + dVar.o);
                        bVar.f(dVar.s);
                        bVar.f50787f = dVar.w;
                        bVar.f50788g = dVar.x;
                        bVar.f50789h = dVar.y;
                    }
                }
            } catch (OutOfMemoryError e4) {
                this.netContext.getResponse().mNetErrorCode = -15;
                this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                BdLog.e(e4.getMessage());
                e e5 = this.manager.e();
                if (e5 != null && e5.d() != null && handler != null) {
                    i4 = e5.c().f42296c;
                    int size2 = e5.d().size();
                    bVar = new b();
                    if (size2 > 0) {
                        d dVar2 = e5.d().get(size2 - 1);
                        bVar.c(i4);
                        bVar.e(this.netContext.getResponse().mNetErrorCode);
                        bVar.d(dVar2.f42282h);
                        bVar.b(dVar2.q + "_" + dVar2.n + "_" + dVar2.l + "_" + dVar2.m + "_" + dVar2.o);
                        bVar.f(dVar2.s);
                        bVar.f50787f = dVar2.w;
                        bVar.f50788g = dVar2.x;
                        bVar.f50789h = dVar2.y;
                    }
                }
            }
            if (this.manager.j()) {
                return false;
            }
            if (z) {
                CreateFileIfNotFoundInCache = new File(str);
            } else {
                CreateFileIfNotFoundInCache = FileHelper.CreateFileIfNotFoundInCache(str);
            }
            z2 = this.manager.d(this.netContext.getRequest().getNetWorkParam().mUrl, CreateFileIfNotFoundInCache.getAbsolutePath(), false, i2, i3, -1, -1, getExtendHeader(), new h() { // from class: com.baidu.tbadk.core.util.NetWorkCoreByBdHttp.1
                public int notify_num = 0;
                public int notify_tmp = 0;
                public int lastLength = 0;

                @Override // d.b.c.e.j.a.h
                public void onProgress(int i5, int i6) {
                    if (i6 > 0) {
                        this.notify_num = i6 / 50;
                    }
                    int i7 = this.notify_tmp + (i5 - this.lastLength);
                    this.notify_tmp = i7;
                    this.lastLength = i5;
                    if (handler != null) {
                        if (i7 > this.notify_num || i5 == i6) {
                            this.notify_tmp = 0;
                            Handler handler2 = handler;
                            handler2.sendMessage(handler2.obtainMessage(i, i5, i6));
                        }
                    }
                }
            }, true, false, this.netContext.getRequest().mCanHttpsDownToHttp);
            this.netContext.getResponse().mNetErrorCode = this.manager.e().c().f42295b;
            e e6 = this.manager.e();
            if (e6 != null && e6.d() != null && handler != null) {
                i4 = e6.c().f42296c;
                int size3 = e6.d().size();
                bVar = new b();
                if (size3 > 0) {
                    d dVar3 = e6.d().get(size3 - 1);
                    bVar.c(i4);
                    bVar.e(this.netContext.getResponse().mNetErrorCode);
                    bVar.d(dVar3.f42282h);
                    bVar.b(dVar3.q + "_" + dVar3.n + "_" + dVar3.l + "_" + dVar3.m + "_" + dVar3.o);
                    bVar.f(dVar3.s);
                    bVar.f50787f = dVar3.w;
                    bVar.f50788g = dVar3.x;
                    bVar.f50789h = dVar3.y;
                }
                handler.dispatchMessage(handler.obtainMessage(-1, i4, -1, bVar));
            }
            TiebaStatic.net(this.netContext);
            return z2;
        } finally {
            e e7 = this.manager.e();
            if (e7 != null && e7.d() != null && handler != null) {
                int i5 = e7.c().f42296c;
                int size4 = e7.d().size();
                b bVar2 = new b();
                if (size4 > 0) {
                    d dVar4 = e7.d().get(size4 - 1);
                    bVar2.c(i5);
                    bVar2.e(this.netContext.getResponse().mNetErrorCode);
                    bVar2.d(dVar4.f42282h);
                    bVar2.b(dVar4.q + "_" + dVar4.n + "_" + dVar4.l + "_" + dVar4.m + "_" + dVar4.o);
                    bVar2.f(dVar4.s);
                    bVar2.f50787f = dVar4.w;
                    bVar2.f50788g = dVar4.x;
                    bVar2.f50789h = dVar4.y;
                }
                handler.dispatchMessage(handler.obtainMessage(-1, i5, -1, bVar2));
            }
            TiebaStatic.net(this.netContext);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0561 A[RETURN] */
    @Override // com.baidu.tbadk.core.util.INetWorkCore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
        Exception exc;
        g gVar;
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        OutOfMemoryError outOfMemoryError;
        BdHttpCancelException bdHttpCancelException;
        String str;
        String str2;
        boolean z;
        int size;
        String str3;
        a.t(TbadkCoreApplication.getCurrentAccount());
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
                    sb.append(k.getUrlEncode(this.netContext.getRequest().getNetWorkParam().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.netContext.getRequest().getNetWorkParam().mUrl;
            }
            str2 = str;
            TbConfig.getDebugSwitch();
            z = (this.netContext.getRequest().getNetWorkParam().mRequestGzip && !this.netContext.getRequest().getNetWorkParam().mIsBDImage) || this.netContext.getRequest().mIsFromCDN;
        } catch (BdHttpCancelException e2) {
            bdHttpCancelException = e2;
            gVar = null;
        } catch (OutOfMemoryError e3) {
            outOfMemoryError = e3;
            gVar = null;
        } catch (SocketException e4) {
            socketException = e4;
            gVar = null;
        } catch (SocketTimeoutException e5) {
            socketTimeoutException = e5;
            gVar = null;
        } catch (Exception e6) {
            exc = e6;
            gVar = null;
        }
        if (!this.manager.j()) {
            long time = new Date().getTime();
            this.manager.h(str2, z, 5, 100, -1, -1, getExtendHeader());
            e e7 = this.manager.e();
            if (e7 == null) {
                return null;
            }
            gVar = e7.c();
            if (e7 != null) {
                try {
                    if (e7.d() != null && (size = e7.d().size()) > 0) {
                        this.netContext.getStat().stat = e7.d().get(size - 1);
                    }
                } catch (BdHttpCancelException e8) {
                    bdHttpCancelException = e8;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    HttpResponse response = this.netContext.getResponse();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                    sb2.append("|retryCount:");
                    sb2.append(this.netContext.getStat().stat != null ? this.netContext.getStat().stat.f42279e : -1);
                    sb2.append(FieldBuilder.SE);
                    sb2.append(BdHttpCancelException.class);
                    sb2.append(FieldBuilder.SE);
                    sb2.append(bdHttpCancelException.getMessage());
                    response.mException = sb2.toString();
                    this.netContext.getResponse().mNetErrorCode = -14;
                    if (gVar == null) {
                    }
                } catch (OutOfMemoryError e9) {
                    outOfMemoryError = e9;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    HttpResponse response2 = this.netContext.getResponse();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                    sb3.append("|retryCount:");
                    sb3.append(this.netContext.getStat().stat != null ? this.netContext.getStat().stat.f42279e : -1);
                    sb3.append(FieldBuilder.SE);
                    sb3.append(outOfMemoryError.getClass());
                    sb3.append(FieldBuilder.SE);
                    sb3.append(outOfMemoryError.getMessage());
                    response2.mException = sb3.toString();
                    this.netContext.getResponse().mNetErrorCode = -15;
                    BdLog.e(outOfMemoryError.getMessage());
                    TiebaStatic.net(this.netContext);
                    if (gVar == null) {
                    }
                } catch (SocketException e10) {
                    socketException = e10;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    HttpResponse response3 = this.netContext.getResponse();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                    sb4.append("|retryCount:");
                    sb4.append(this.netContext.getStat().stat != null ? this.netContext.getStat().stat.f42279e : -1);
                    sb4.append(FieldBuilder.SE);
                    sb4.append(socketException.getClass());
                    sb4.append(FieldBuilder.SE);
                    sb4.append(socketException.getMessage());
                    response3.mException = sb4.toString();
                    this.netContext.getResponse().mNetErrorCode = -12;
                    TiebaStatic.net(this.netContext);
                    if (gVar == null) {
                    }
                } catch (SocketTimeoutException e11) {
                    socketTimeoutException = e11;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    HttpResponse response4 = this.netContext.getResponse();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                    sb5.append("|retryCount:");
                    sb5.append(this.netContext.getStat().stat != null ? this.netContext.getStat().stat.f42279e : -1);
                    sb5.append(FieldBuilder.SE);
                    sb5.append(socketTimeoutException.getClass());
                    sb5.append(FieldBuilder.SE);
                    sb5.append(socketTimeoutException.getMessage());
                    response4.mException = sb5.toString();
                    this.netContext.getResponse().mNetErrorCode = -13;
                    TiebaStatic.net(this.netContext);
                    if (gVar == null) {
                    }
                } catch (Exception e12) {
                    exc = e12;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + exc.getMessage();
                    HttpResponse response5 = this.netContext.getResponse();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                    sb6.append("|retryCount:");
                    sb6.append(this.netContext.getStat().stat != null ? this.netContext.getStat().stat.f42279e : -1);
                    sb6.append(FieldBuilder.SE);
                    sb6.append(exc.getClass());
                    sb6.append(FieldBuilder.SE);
                    sb6.append(exc.getMessage());
                    response5.mException = sb6.toString();
                    this.netContext.getResponse().mNetErrorCode = -10;
                    BdLog.e(exc.getMessage());
                    TiebaStatic.net(this.netContext);
                    if (gVar == null) {
                    }
                }
            }
            if (gVar == null) {
                return null;
            }
            this.netContext.getResponse().mNetErrorCode = gVar.f42295b;
            if (this.netContext.getResponse().mNetErrorCode != 200) {
                this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                if (this.netContext.getStat().stat != null && !TextUtils.isEmpty(this.netContext.getStat().stat.f42282h)) {
                    this.netContext.getResponse().mException = this.netContext.getStat().stat.f42282h;
                } else {
                    HttpResponse response6 = this.netContext.getResponse();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                    sb7.append("|retryCount:");
                    sb7.append(this.netContext.getStat().stat == null ? -1 : this.netContext.getStat().stat.f42279e);
                    response6.mException = sb7.toString();
                }
                TiebaStatic.net(this.netContext);
                return null;
            }
            if (TbadkCoreApplication.getInst().isMainProcess(true) && (str3 = gVar.f42299f) != null) {
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
                        if (!d.b.h0.a0.c.k().i(i2)) {
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
            statisticsData.mMode = getMode(j.I());
            statisticsData.mSize = this.netContext.getStat().stat.f42276b;
            statisticsData.mTime = new Date().getTime() - time;
            statisticsData.mTimesNum = this.netContext.getStat().stat.f42279e;
            statisticsData.mMethod = 2;
            NetWorkState.addStatisticsData(statisticsData);
            NetWorkState.mErrorNums.set(this.netContext.getStat().stat.f42279e);
            TiebaStatic.net(this.netContext);
            if (gVar == null) {
                return gVar.f42301h;
            }
            return null;
        }
        throw new BdHttpCancelException();
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String getNetString() {
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
            } catch (Exception e2) {
                e = e2;
                str = str2;
                BdLog.e(e.getMessage());
                return str;
            } catch (OutOfMemoryError e3) {
                e = e3;
                str = str2;
                BdLog.e(e.getMessage());
                return str;
            }
        } catch (Exception e4) {
            e = e4;
        } catch (OutOfMemoryError e5) {
            e = e5;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public ArrayList<BasicNameValuePair> getPostData() {
        return this.netContext.getRequest().getNetWorkParam().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String getSeqId() {
        HttpNetContext httpNetContext = this.netContext;
        if (httpNetContext != null) {
            return httpNetContext.getRequest().getNetWorkParam().mSeqId;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public boolean isCancel() {
        return this.manager.j();
    }

    public void parseServerCode(String str) {
        this.netContext.getResponse().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.netContext.getResponse().mServerErrorCode = errorData.getError_code();
                if (this.netContext.getResponse().mServerErrorCode == -1) {
                    this.netContext.getResponse().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.netContext.getResponse().mServerErrorCode != 0) {
                    this.netContext.getResponse().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                this.netContext.getResponse().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String postMultiNetData() {
        d dVar;
        long currentTimeMillis = System.currentTimeMillis();
        int i = -1;
        int i2 = 0;
        String str = null;
        long j = 0;
        try {
        } catch (BdHttpCancelException e2) {
            e = e2;
        } catch (OutOfMemoryError e3) {
            e = e3;
        } catch (SocketException unused) {
        } catch (SocketTimeoutException unused2) {
        } catch (Exception e4) {
            e = e4;
        }
        if (!this.manager.j()) {
            g l = this.manager.l(this.netContext.getRequest().getNetWorkParam().mUrl, this.netContext.getRequest().getNetWorkParam().mRequestGzip, this.netContext.getRequest().getNetWorkParam().mPostData, this.netContext.getRequest().getNetWorkParam().mFileData, 5, -1, getExtendHeader());
            this.netContext.getResponse().mNetErrorCode = l.f42295b;
            this.netContext.getResponse().mHeader = l.f42300g;
            if (this.netContext.getResponse().mNetErrorCode != 200) {
                e e5 = this.manager.e();
                int size = (e5 == null || e5.d() == null) ? 0 : e5.d().size();
                String str2 = "";
                if (size > 0 && (dVar = e5.d().get(size - 1)) != null) {
                    str2 = dVar.f42282h;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.netContext.getResponse().mException = str2;
                } else {
                    HttpResponse response = this.netContext.getResponse();
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                    sb.append("|retryCount:");
                    sb.append(this.netContext.getStat().stat == null ? -1 : this.netContext.getStat().stat.f42279e);
                    response.mException = sb.toString();
                }
                TiebaStatic.net(this.netContext);
                return null;
            } else if (!this.manager.j()) {
                String str3 = new String(l.f42301h, "UTF-8");
                try {
                    parseServerCode(str3);
                    i2 = l.f42301h.length;
                    j = System.currentTimeMillis();
                    TiebaStatic.net(this.netContext);
                } catch (BdHttpCancelException e6) {
                    e = e6;
                    str = str3;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    HttpResponse response2 = this.netContext.getResponse();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                    sb2.append("|retryCount:");
                    if (this.netContext.getStat().stat != null) {
                        i = this.netContext.getStat().stat.f42279e;
                    }
                    sb2.append(i);
                    sb2.append(FieldBuilder.SE);
                    sb2.append(e.getClass());
                    sb2.append(FieldBuilder.SE);
                    sb2.append(e.getMessage());
                    response2.mException = sb2.toString();
                    this.netContext.getResponse().mNetErrorCode = -14;
                    str3 = str;
                    addPerformanceData(currentTimeMillis, j, i2);
                    return str3;
                } catch (OutOfMemoryError e7) {
                    e = e7;
                    str = str3;
                    this.netContext.getResponse().mNetErrorCode = -15;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.netContext);
                    str3 = str;
                    addPerformanceData(currentTimeMillis, j, i2);
                    return str3;
                } catch (SocketException unused3) {
                    str = str3;
                    this.netContext.getResponse().mNetErrorCode = -12;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.netContext);
                    str3 = str;
                    addPerformanceData(currentTimeMillis, j, i2);
                    return str3;
                } catch (SocketTimeoutException unused4) {
                    str = str3;
                    this.netContext.getResponse().mNetErrorCode = -13;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    TiebaStatic.net(this.netContext);
                    str3 = str;
                    addPerformanceData(currentTimeMillis, j, i2);
                    return str3;
                } catch (Exception e8) {
                    e = e8;
                    str = str3;
                    this.netContext.getResponse().mNetErrorCode = -10;
                    HttpResponse response3 = this.netContext.getResponse();
                    response3.mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.netContext);
                    str3 = str;
                    addPerformanceData(currentTimeMillis, j, i2);
                    return str3;
                }
                addPerformanceData(currentTimeMillis, j, i2);
                return str3;
            } else {
                throw new BdHttpCancelException();
            }
        }
        throw new BdHttpCancelException();
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String postNetData() {
        Throwable th;
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        OutOfMemoryError outOfMemoryError;
        Exception exc;
        BdHttpCancelException bdHttpCancelException;
        int i;
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(1024);
        int i2 = 0;
        for (int i3 = 0; this.netContext.getRequest().getNetWorkParam().mPostData != null && i3 < this.netContext.getRequest().getNetWorkParam().mPostData.size(); i3++) {
            BasicNameValuePair basicNameValuePair = this.netContext.getRequest().getNetWorkParam().mPostData.get(i3);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
        }
        if (this.netContext.getRequest().getNetWorkParam().mIsBaiduServer) {
            sb.append(NetWork.SIGN_SUFFIX);
            addPostData("sign", q.c(sb.toString()));
            if (this.netContext.getRequest().mNeedSig) {
                addPostData("sig", StringU.b(sb.toString()));
            }
        }
        TbConfig.getDebugSwitch();
        String str = null;
        long j = 0;
        try {
        } catch (BdHttpCancelException e2) {
            bdHttpCancelException = e2;
        } catch (Exception e3) {
            exc = e3;
        } catch (OutOfMemoryError e4) {
            outOfMemoryError = e4;
        } catch (SocketException e5) {
            socketException = e5;
        } catch (SocketTimeoutException e6) {
            socketTimeoutException = e6;
        } catch (Throwable th2) {
            th = th2;
        }
        if (this.manager.j()) {
            return null;
        }
        if (this.manager.k(this.netContext.getRequest().getNetWorkParam().mUrl, this.netContext.getRequest().getNetWorkParam().mPostData, this.netContext.getRequest().getNetWorkParam().mRequestGzip, 5, -1, getExtendHeader()) != null) {
            e e7 = this.manager.e();
            if (e7 == null) {
                return null;
            }
            g c2 = e7.c();
            if (e7 != null && e7.d() != null && (size = e7.d().size()) > 0) {
                this.netContext.getStat().stat = e7.d().get(size - 1);
            }
            this.netContext.getResponse().mNetErrorCode = c2.f42295b;
            this.netContext.getResponse().mHeader = c2.f42300g;
            if (this.netContext.getResponse().mNetErrorCode != 200) {
                if (this.netContext.getStat().stat != null && !TextUtils.isEmpty(this.netContext.getStat().stat.f42282h)) {
                    this.netContext.getResponse().mException = this.netContext.getStat().stat.f42282h;
                } else {
                    HttpResponse response = this.netContext.getResponse();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                    sb2.append("|retryCount:");
                    sb2.append(this.netContext.getStat().stat == null ? -1 : this.netContext.getStat().stat.f42279e);
                    response.mException = sb2.toString();
                }
                TiebaStatic.net(this.netContext);
                return null;
            } else if (this.manager.j()) {
                return null;
            } else {
                String str2 = new String(c2.f42301h, "utf-8");
                try {
                    if (this.netContext.getRequest().getNetWorkParam().mIsBaiduServer && this.netContext.getRequest().getNetWorkParam().mIsJson) {
                        parseServerCode(str2);
                    }
                    i2 = c2.f42301h.length;
                    j = System.currentTimeMillis();
                    NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                    statisticsData.mMode = getMode(j.I());
                    statisticsData.mSize = this.netContext.getStat().stat.f42276b;
                    statisticsData.mTime = this.netContext.getStat().stat.f42280f;
                    statisticsData.mTimesNum = this.netContext.getStat().stat.f42279e;
                    statisticsData.mMethod = 1;
                    NetWorkState.addStatisticsData(statisticsData);
                    NetWorkState.mErrorNums.set(this.netContext.getStat().stat.f42279e);
                    TiebaStatic.net(this.netContext);
                    i = i2;
                } catch (BdHttpCancelException e8) {
                    bdHttpCancelException = e8;
                    str = str2;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    HttpResponse response2 = this.netContext.getResponse();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(String.valueOf(this.netContext.getResponse().mNetErrorCode));
                    sb3.append("|retryCount:");
                    sb3.append(this.netContext.getStat().stat != null ? this.netContext.getStat().stat.f42279e : -1);
                    sb3.append(FieldBuilder.SE);
                    sb3.append(BdHttpCancelException.class);
                    sb3.append(FieldBuilder.SE);
                    sb3.append(bdHttpCancelException.getMessage());
                    response2.mException = sb3.toString();
                    this.netContext.getResponse().mNetErrorCode = -14;
                    i = i2;
                    str2 = str;
                    addPerformanceData(currentTimeMillis, j, i);
                    return str2;
                } catch (OutOfMemoryError e9) {
                    outOfMemoryError = e9;
                    str = str2;
                    this.netContext.getResponse().mNetErrorCode = -15;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(outOfMemoryError.getMessage());
                    TiebaStatic.net(this.netContext);
                    i = i2;
                    str2 = str;
                    addPerformanceData(currentTimeMillis, j, i);
                    return str2;
                } catch (SocketException e10) {
                    socketException = e10;
                    str = str2;
                    this.netContext.getResponse().mNetErrorCode = -12;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(socketException.getMessage());
                    TiebaStatic.net(this.netContext);
                    i = i2;
                    str2 = str;
                    addPerformanceData(currentTimeMillis, j, i);
                    return str2;
                } catch (SocketTimeoutException e11) {
                    socketTimeoutException = e11;
                    str = str2;
                    this.netContext.getResponse().mNetErrorCode = -13;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(socketTimeoutException.getMessage());
                    TiebaStatic.net(this.netContext);
                    i = i2;
                    str2 = str;
                    addPerformanceData(currentTimeMillis, j, i);
                    return str2;
                } catch (Exception e12) {
                    exc = e12;
                    str = str2;
                    this.netContext.getResponse().mNetErrorCode = -10;
                    HttpResponse response3 = this.netContext.getResponse();
                    response3.mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + exc.getMessage();
                    BdLog.e(exc.getMessage());
                    TiebaStatic.net(this.netContext);
                    i = i2;
                    str2 = str;
                    addPerformanceData(currentTimeMillis, j, i);
                    return str2;
                } catch (Throwable th3) {
                    th = th3;
                    str = str2;
                    this.netContext.getResponse().mNetErrorCode = -10;
                    this.netContext.getResponse().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.netContext);
                    i = i2;
                    str2 = str;
                    addPerformanceData(currentTimeMillis, j, i);
                    return str2;
                }
                addPerformanceData(currentTimeMillis, j, i);
                return str2;
            }
        }
        throw new BdHttpCancelException();
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setCancel() {
        a aVar = this.manager;
        if (aVar != null) {
            aVar.m();
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setIsBaiduServer(boolean z) {
        this.netContext.getRequest().getNetWorkParam().mIsBaiduServer = z;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.netContext.getRequest().getNetWorkParam().mPostData != null) {
            this.netContext.getRequest().getNetWorkParam().mPostData.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            addPostData(arrayList.get(i));
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(String str, byte[] bArr) {
        if (this.netContext.getRequest().getNetWorkParam().mFileData == null) {
            this.netContext.getRequest().getNetWorkParam().mFileData = new HashMap<>();
        }
        this.netContext.getRequest().getNetWorkParam().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair == null || basicNameValuePair.getName() == null) {
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
