package c.a.t0.j3.f0;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.t;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.INetWorkCore;
import com.baidu.tbadk.core.util.NetWorkState;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.core.util.httpNet.HttpResponse;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.http.BdHttpCancelException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes7.dex */
public class d implements INetWorkCore {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f18759d = 2097152;
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpNetContext a;

    /* renamed from: b  reason: collision with root package name */
    public Context f18760b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.j3.f0.o.d f18761c;

    /* loaded from: classes7.dex */
    public class a implements c.a.t0.j3.f0.o.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f18762b;

        /* renamed from: c  reason: collision with root package name */
        public int f18763c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Handler f18764d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f18765e;

        public a(d dVar, Handler handler, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, handler, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18764d = handler;
            this.f18765e = i2;
            this.a = 0;
            this.f18762b = 0;
            this.f18763c = 0;
        }

        @Override // c.a.t0.j3.f0.o.j
        public void onProgress(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (i3 > 0) {
                    this.a = i3 / 50;
                }
                int i4 = this.f18762b + (i2 - this.f18763c);
                this.f18762b = i4;
                this.f18763c = i2;
                if (this.f18764d != null) {
                    if (i4 > this.a || i2 == i3) {
                        this.f18762b = 0;
                        Handler handler = this.f18764d;
                        handler.sendMessage(handler.obtainMessage(this.f18765e, i2, i3));
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1494972099, "Lc/a/t0/j3/f0/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1494972099, "Lc/a/t0/j3/f0/d;");
        }
    }

    public d(HttpNetContext httpNetContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpNetContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18761c = new c.a.t0.j3.f0.o.d();
        this.f18760b = TbadkCoreApplication.getInst().getApp();
        this.a = httpNetContext;
        c.a.t0.j3.f0.o.d.n("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        c.a.t0.j3.f0.o.d.l((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? c.a.s0.m.a.a : cookie);
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
    public final int a(ArrayList<BasicNameValuePair> arrayList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, arrayList, str)) != null) {
            return invokeLL.intValue;
        }
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            int compareTo = str.compareTo(arrayList.get(i2).getName());
            if (compareTo < 0) {
                i3 = i2;
                break;
            } else if (compareTo == 0) {
                return -1;
            } else {
                i3 = i2;
                i2++;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            addPostData(new BasicNameValuePair(str, str2));
        }
    }

    public final LinkedList<BasicNameValuePair> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a != null) {
                LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
                if (!TextUtils.isEmpty(this.a.getRequest().getNetWorkParam().mSeqId)) {
                    linkedList.add(new BasicNameValuePair("sid", this.a.getRequest().getNetWorkParam().mSeqId));
                }
                if (!TextUtils.isEmpty(this.a.getRequest().getNetWorkParam().mNetType)) {
                    linkedList.add(new BasicNameValuePair("net", this.a.getRequest().getNetWorkParam().mNetType));
                }
                return linkedList;
            }
            return null;
        }
        return (LinkedList) invokeV.objValue;
    }

    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return 2;
                }
                if (i2 == 3) {
                    return 3;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void cancelNetConnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f18761c.c();
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.a.getResponse().mServerErrorCode = -1;
            if (str != null) {
                try {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(str);
                    this.a.getResponse().mServerErrorCode = errorData.getError_code();
                    if (this.a.getResponse().mServerErrorCode == -1) {
                        this.a.getResponse().mErrorString = this.f18760b.getString(R.string.error_unkown_try_again);
                    } else if (this.a.getResponse().mServerErrorCode != 0) {
                        this.a.getResponse().mErrorString = errorData.getError_msg();
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    this.a.getResponse().mErrorString = this.f18760b.getString(R.string.error_unkown_try_again);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public boolean downloadFile(String str, Handler handler, int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        File a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, handler, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
            boolean z2 = false;
            try {
                try {
                } catch (Exception e2) {
                    this.a.getResponse().mNetErrorCode = -10;
                    HttpResponse response = this.a.getResponse();
                    response.mErrorString = this.f18760b.getResources().getString(R.string.neterror) + " detailException:" + e2.getMessage();
                    BdLog.e(e2.getMessage());
                } catch (OutOfMemoryError e3) {
                    this.a.getResponse().mNetErrorCode = -15;
                    this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.memoryerror);
                    BdLog.e(e3.getMessage());
                }
                if (this.f18761c.i()) {
                    return false;
                }
                if (z) {
                    a2 = new File(str);
                } else {
                    a2 = c.a.t0.j3.b.a(str);
                }
                z2 = this.f18761c.d(this.a.getRequest().getNetWorkParam().mUrl, a2.getAbsolutePath(), false, i3, i4, -1, -1, b(), new a(this, handler, i2), true);
                return z2;
            } finally {
                TiebaStatic.net(this.a);
            }
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0537 A[RETURN] */
    @Override // com.baidu.tbadk.core.util.INetWorkCore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
        InterceptResult invokeV;
        Exception exc;
        c.a.t0.j3.f0.o.i iVar;
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        OutOfMemoryError outOfMemoryError;
        BdHttpCancelException bdHttpCancelException;
        String str;
        String str2;
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.t0.j3.f0.o.d.m(TbadkCoreApplication.getCurrentAccount());
            try {
                if (this.a.getRequest().getNetWorkParam().mPostData != null && this.a.getRequest().getNetWorkParam().mPostData.size() > 0 && !this.a.getRequest().mIsFromCDN) {
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(this.a.getRequest().getNetWorkParam().mUrl);
                    if (this.a.getRequest().getNetWorkParam().mUrl.indexOf("?") < 0) {
                        sb.append("?");
                    } else if (!this.a.getRequest().getNetWorkParam().mUrl.endsWith("?") && !this.a.getRequest().getNetWorkParam().mUrl.endsWith("&")) {
                        sb.append("&");
                    }
                    for (int i2 = 0; i2 < this.a.getRequest().getNetWorkParam().mPostData.size(); i2++) {
                        if (i2 != 0) {
                            sb.append("&");
                        }
                        sb.append(this.a.getRequest().getNetWorkParam().mPostData.get(i2).getName());
                        sb.append("=");
                        sb.append(c.a.d.f.p.m.getUrlEncode(this.a.getRequest().getNetWorkParam().mPostData.get(i2).getValue()));
                    }
                    str = sb.toString();
                } else {
                    str = this.a.getRequest().getNetWorkParam().mUrl;
                }
                str2 = str;
                TbConfig.getDebugSwitch();
                z = (this.a.getRequest().getNetWorkParam().mRequestGzip && !this.a.getRequest().getNetWorkParam().mIsBDImage) || this.a.getRequest().mIsFromCDN;
            } catch (BdHttpCancelException e2) {
                bdHttpCancelException = e2;
                iVar = null;
            } catch (OutOfMemoryError e3) {
                outOfMemoryError = e3;
                iVar = null;
            } catch (SocketException e4) {
                socketException = e4;
                iVar = null;
            } catch (SocketTimeoutException e5) {
                socketTimeoutException = e5;
                iVar = null;
            } catch (Exception e6) {
                exc = e6;
                iVar = null;
            }
            if (!this.f18761c.i()) {
                long time = new Date().getTime();
                this.f18761c.g(str2, z, 5, 100, -1, -1, b());
                c.a.t0.j3.f0.o.g f2 = this.f18761c.f();
                if (f2 == null) {
                    return null;
                }
                iVar = f2.b();
                if (f2 != null) {
                    try {
                        if (f2.c() != null) {
                            f2.c().size();
                        }
                    } catch (BdHttpCancelException e7) {
                        bdHttpCancelException = e7;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror);
                        HttpResponse response = this.a.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.a.getResponse().mNetErrorCode);
                        sb2.append("|retryCount:");
                        sb2.append(this.a.getStat().stat != null ? this.a.getStat().stat.f2819e : -1);
                        sb2.append("|");
                        sb2.append(BdHttpCancelException.class);
                        sb2.append("|");
                        sb2.append(bdHttpCancelException.getMessage());
                        response.mException = sb2.toString();
                        this.a.getResponse().mNetErrorCode = -14;
                        if (iVar == null) {
                        }
                    } catch (OutOfMemoryError e8) {
                        outOfMemoryError = e8;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.memoryerror);
                        HttpResponse response2 = this.a.getResponse();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(this.a.getResponse().mNetErrorCode);
                        sb3.append("|retryCount:");
                        sb3.append(this.a.getStat().stat != null ? this.a.getStat().stat.f2819e : -1);
                        sb3.append("|");
                        sb3.append(outOfMemoryError.getClass());
                        sb3.append("|");
                        sb3.append(outOfMemoryError.getMessage());
                        response2.mException = sb3.toString();
                        this.a.getResponse().mNetErrorCode = -15;
                        BdLog.e(outOfMemoryError.getMessage());
                        TiebaStatic.net(this.a);
                        if (iVar == null) {
                        }
                    } catch (SocketException e9) {
                        socketException = e9;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror);
                        HttpResponse response3 = this.a.getResponse();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(this.a.getResponse().mNetErrorCode);
                        sb4.append("|retryCount:");
                        sb4.append(this.a.getStat().stat != null ? this.a.getStat().stat.f2819e : -1);
                        sb4.append("|");
                        sb4.append(socketException.getClass());
                        sb4.append("|");
                        sb4.append(socketException.getMessage());
                        response3.mException = sb4.toString();
                        this.a.getResponse().mNetErrorCode = -12;
                        TiebaStatic.net(this.a);
                        if (iVar == null) {
                        }
                    } catch (SocketTimeoutException e10) {
                        socketTimeoutException = e10;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror);
                        HttpResponse response4 = this.a.getResponse();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(this.a.getResponse().mNetErrorCode);
                        sb5.append("|retryCount:");
                        sb5.append(this.a.getStat().stat != null ? this.a.getStat().stat.f2819e : -1);
                        sb5.append("|");
                        sb5.append(socketTimeoutException.getClass());
                        sb5.append("|");
                        sb5.append(socketTimeoutException.getMessage());
                        response4.mException = sb5.toString();
                        this.a.getResponse().mNetErrorCode = -13;
                        TiebaStatic.net(this.a);
                        if (iVar == null) {
                        }
                    } catch (Exception e11) {
                        exc = e11;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror) + " detailException:" + exc.getMessage();
                        HttpResponse response5 = this.a.getResponse();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(this.a.getResponse().mNetErrorCode);
                        sb6.append("|retryCount:");
                        sb6.append(this.a.getStat().stat != null ? this.a.getStat().stat.f2819e : -1);
                        sb6.append("|");
                        sb6.append(exc.getClass());
                        sb6.append("|");
                        sb6.append(exc.getMessage());
                        response5.mException = sb6.toString();
                        this.a.getResponse().mNetErrorCode = -10;
                        BdLog.e(exc.getMessage());
                        TiebaStatic.net(this.a);
                        if (iVar == null) {
                        }
                    }
                }
                if (iVar == null) {
                    return null;
                }
                this.a.getResponse().mNetErrorCode = iVar.f18837b;
                if (this.a.getResponse().mNetErrorCode != 200) {
                    this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror);
                    if (this.a.getStat().stat != null && !TextUtils.isEmpty(this.a.getStat().stat.f2822h)) {
                        this.a.getResponse().mException = this.a.getStat().stat.f2822h;
                    } else {
                        HttpResponse response6 = this.a.getResponse();
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(this.a.getResponse().mNetErrorCode);
                        sb7.append("|retryCount:");
                        sb7.append(this.a.getStat().stat == null ? -1 : this.a.getStat().stat.f2819e);
                        response6.mException = sb7.toString();
                    }
                    TiebaStatic.net(this.a);
                    return null;
                }
                if (TbadkCoreApplication.getInst().isMainProcess(true) && (str3 = iVar.f18840e) != null) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > f18759d) {
                            this.a.getResponse().mNetErrorCode = -11;
                            TiebaStatic.net(this.a);
                            return null;
                        }
                        int i3 = parseInt * 10;
                        if (i3 > 0) {
                            BdLog.isDebugMode();
                            if (!c.a.s0.c0.c.k().i(i3)) {
                                BdLog.d("Image download cacelled. out of memory. url:[" + this.a.getRequest().getNetWorkParam().mUrl + "], size:" + i3);
                                this.a.getResponse().mNetErrorCode = -16;
                                TiebaStatic.net(this.a);
                                return null;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                statisticsData.mMode = c(c.a.d.f.p.l.I());
                statisticsData.mSize = this.a.getStat().stat.f2816b;
                statisticsData.mTime = new Date().getTime() - time;
                statisticsData.mTimesNum = this.a.getStat().stat.f2819e;
                statisticsData.mMethod = 2;
                NetWorkState.addStatisticsData(statisticsData);
                NetWorkState.mErrorNums.set(this.a.getStat().stat.f2819e);
                TiebaStatic.net(this.a);
                if (iVar == null) {
                    return iVar.f18842g;
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
        if (interceptable != null && (invokeV = interceptable.invokeV(1048586, this)) != null) {
            return (String) invokeV.objValue;
        }
        byte[] netData = getNetData();
        String str = null;
        if (netData == null || this.a.getResponse().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.a.getRequest().getNetWorkParam().charSet = TextUtils.isEmpty(this.a.getRequest().getNetWorkParam().charSet) ? "UTF-8" : this.a.getRequest().getNetWorkParam().charSet;
            String str2 = new String(netData, 0, netData.length, this.a.getRequest().getNetWorkParam().charSet);
            try {
                d(str2);
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.getRequest().getNetWorkParam().mPostData : (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String getSeqId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            HttpNetContext httpNetContext = this.a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f18761c.i() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String postMultiNetData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048590, this)) != null) {
            return (String) invokeV.objValue;
        }
        StringBuilder sb = new StringBuilder(1024);
        for (int i2 = 0; this.a.getRequest().getNetWorkParam().mPostData != null && i2 < this.a.getRequest().getNetWorkParam().mPostData.size(); i2++) {
            BasicNameValuePair basicNameValuePair = this.a.getRequest().getNetWorkParam().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
        }
        if (this.a.getRequest().getNetWorkParam().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", t.c(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        String str = null;
        try {
            if (this.f18761c.i()) {
                return null;
            }
            if (this.f18761c.j(this.a.getRequest().getNetWorkParam().mUrl, this.a.getRequest().getNetWorkParam().mPostData, this.a.getRequest().getNetWorkParam().mRequestGzip, 5, -1, b()) != null) {
                c.a.t0.j3.f0.o.g f2 = this.f18761c.f();
                if (f2 == null) {
                    return null;
                }
                c.a.t0.j3.f0.o.i b2 = f2.b();
                if (f2 != null && f2.c() != null) {
                    f2.c().size();
                }
                this.a.getResponse().mNetErrorCode = b2.f18837b;
                this.a.getResponse().mHeader = b2.f18841f;
                if (this.a.getResponse().mNetErrorCode != 200) {
                    if (this.a.getStat().stat != null && !TextUtils.isEmpty(this.a.getStat().stat.f2822h)) {
                        this.a.getResponse().mException = this.a.getStat().stat.f2822h;
                    } else {
                        HttpResponse response = this.a.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.a.getResponse().mNetErrorCode);
                        sb2.append("|retryCount:");
                        sb2.append(this.a.getStat().stat == null ? -1 : this.a.getStat().stat.f2819e);
                        response.mException = sb2.toString();
                    }
                    TiebaStatic.net(this.a);
                    return null;
                } else if (this.f18761c.i()) {
                    return null;
                } else {
                    String str2 = new String(b2.f18842g, StandardCharsets.UTF_8);
                    try {
                        if (this.a.getRequest().getNetWorkParam().mIsBaiduServer && this.a.getRequest().getNetWorkParam().mIsJson) {
                            d(str2);
                        }
                        NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                        statisticsData.mMode = c(c.a.d.f.p.l.I());
                        statisticsData.mSize = this.a.getStat().stat.f2816b;
                        statisticsData.mTime = this.a.getStat().stat.f2820f;
                        statisticsData.mTimesNum = this.a.getStat().stat.f2819e;
                        statisticsData.mMethod = 1;
                        NetWorkState.addStatisticsData(statisticsData);
                        NetWorkState.mErrorNums.set(this.a.getStat().stat.f2819e);
                        TiebaStatic.net(this.a);
                        return str2;
                    } catch (BdHttpCancelException e2) {
                        e = e2;
                        str = str2;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror);
                        HttpResponse response2 = this.a.getResponse();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(this.a.getResponse().mNetErrorCode);
                        sb3.append("|retryCount:");
                        sb3.append(this.a.getStat().stat != null ? this.a.getStat().stat.f2819e : -1);
                        sb3.append("|");
                        sb3.append(BdHttpCancelException.class);
                        sb3.append("|");
                        sb3.append(e.getMessage());
                        response2.mException = sb3.toString();
                        this.a.getResponse().mNetErrorCode = -14;
                        return str;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -15;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (SocketException e4) {
                        e = e4;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -12;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -13;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (Exception e6) {
                        e = e6;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -10;
                        HttpResponse response3 = this.a.getResponse();
                        response3.mErrorString = this.f18760b.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -10;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    }
                }
            }
            throw new BdHttpCancelException();
        } catch (BdHttpCancelException e7) {
            e = e7;
        } catch (OutOfMemoryError e8) {
            e = e8;
        } catch (SocketException e9) {
            e = e9;
        } catch (SocketTimeoutException e10) {
            e = e10;
        } catch (Exception e11) {
            e = e11;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public String postNetData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048591, this)) != null) {
            return (String) invokeV.objValue;
        }
        StringBuilder sb = new StringBuilder(1024);
        for (int i2 = 0; this.a.getRequest().getNetWorkParam().mPostData != null && i2 < this.a.getRequest().getNetWorkParam().mPostData.size(); i2++) {
            BasicNameValuePair basicNameValuePair = this.a.getRequest().getNetWorkParam().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
        }
        if (this.a.getRequest().getNetWorkParam().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", t.c(sb.toString()));
        }
        TbConfig.getDebugSwitch();
        String str = null;
        try {
            if (this.f18761c.i()) {
                return null;
            }
            if (this.f18761c.j(this.a.getRequest().getNetWorkParam().mUrl, this.a.getRequest().getNetWorkParam().mPostData, this.a.getRequest().getNetWorkParam().mRequestGzip, 5, -1, b()) != null) {
                c.a.t0.j3.f0.o.g f2 = this.f18761c.f();
                if (f2 == null) {
                    return null;
                }
                c.a.t0.j3.f0.o.i b2 = f2.b();
                if (f2 != null && f2.c() != null) {
                    f2.c().size();
                }
                this.a.getResponse().mNetErrorCode = b2.f18837b;
                this.a.getResponse().mHeader = b2.f18841f;
                if (this.a.getResponse().mNetErrorCode != 200) {
                    if (this.a.getStat().stat != null && !TextUtils.isEmpty(this.a.getStat().stat.f2822h)) {
                        this.a.getResponse().mException = this.a.getStat().stat.f2822h;
                    } else {
                        HttpResponse response = this.a.getResponse();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.a.getResponse().mNetErrorCode);
                        sb2.append("|retryCount:");
                        sb2.append(this.a.getStat().stat == null ? -1 : this.a.getStat().stat.f2819e);
                        response.mException = sb2.toString();
                    }
                    TiebaStatic.net(this.a);
                    return null;
                } else if (this.f18761c.i()) {
                    return null;
                } else {
                    String str2 = new String(b2.f18842g, StandardCharsets.UTF_8);
                    try {
                        if (this.a.getRequest().getNetWorkParam().mIsBaiduServer && this.a.getRequest().getNetWorkParam().mIsJson) {
                            d(str2);
                        }
                        NetWorkState.StatisticsData statisticsData = new NetWorkState.StatisticsData();
                        statisticsData.mMode = c(c.a.d.f.p.l.I());
                        statisticsData.mSize = this.a.getStat().stat.f2816b;
                        statisticsData.mTime = this.a.getStat().stat.f2820f;
                        statisticsData.mTimesNum = this.a.getStat().stat.f2819e;
                        statisticsData.mMethod = 1;
                        NetWorkState.addStatisticsData(statisticsData);
                        NetWorkState.mErrorNums.set(this.a.getStat().stat.f2819e);
                        TiebaStatic.net(this.a);
                        return str2;
                    } catch (BdHttpCancelException e2) {
                        e = e2;
                        str = str2;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror);
                        HttpResponse response2 = this.a.getResponse();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(this.a.getResponse().mNetErrorCode);
                        sb3.append("|retryCount:");
                        sb3.append(this.a.getStat().stat != null ? this.a.getStat().stat.f2819e : -1);
                        sb3.append("|");
                        sb3.append(BdHttpCancelException.class);
                        sb3.append("|");
                        sb3.append(e.getMessage());
                        response2.mException = sb3.toString();
                        this.a.getResponse().mNetErrorCode = -14;
                        return str;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -15;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.memoryerror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (SocketException e4) {
                        e = e4;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -12;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -13;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (Exception e6) {
                        e = e6;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -10;
                        HttpResponse response3 = this.a.getResponse();
                        response3.mErrorString = this.f18760b.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                        BdLog.e(e.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        str = str2;
                        this.a.getResponse().mNetErrorCode = -10;
                        this.a.getResponse().mErrorString = this.f18760b.getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        TiebaStatic.net(this.a);
                        return str;
                    }
                }
            }
            throw new BdHttpCancelException();
        } catch (BdHttpCancelException e7) {
            e = e7;
        } catch (OutOfMemoryError e8) {
            e = e8;
        } catch (SocketException e9) {
            e = e9;
        } catch (SocketTimeoutException e10) {
            e = e10;
        } catch (Exception e11) {
            e = e11;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setCancel() {
        c.a.t0.j3.f0.o.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (dVar = this.f18761c) == null) {
            return;
        }
        dVar.k();
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setIsBaiduServer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.a.getRequest().getNetWorkParam().mIsBaiduServer = z;
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, arrayList) == null) {
            if (this.a.getRequest().getNetWorkParam().mPostData != null) {
                this.a.getRequest().getNetWorkParam().mPostData.clear();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                addPostData(arrayList.get(i2));
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, basicNameValuePair) == null) || basicNameValuePair == null || basicNameValuePair.getName() == null) {
            return;
        }
        if (this.a.getRequest().getNetWorkParam().mPostData == null) {
            this.a.getRequest().getNetWorkParam().mPostData = new ArrayList<>();
        }
        int a2 = a(this.a.getRequest().getNetWorkParam().mPostData, basicNameValuePair.getName());
        int size = this.a.getRequest().getNetWorkParam().mPostData.size();
        if (a2 < 0 || a2 >= size) {
            if (a2 == size) {
                this.a.getRequest().getNetWorkParam().mPostData.add(a2, basicNameValuePair);
            }
        } else if (basicNameValuePair.getName().equals(this.a.getRequest().getNetWorkParam().mPostData.get(a2).getName())) {
            this.a.getRequest().getNetWorkParam().mPostData.set(a2, basicNameValuePair);
        } else {
            this.a.getRequest().getNetWorkParam().mPostData.add(a2, basicNameValuePair);
        }
    }

    @Override // com.baidu.tbadk.core.util.INetWorkCore
    public void addPostData(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr) == null) {
            if (this.a.getRequest().getNetWorkParam().mFileData == null) {
                this.a.getRequest().getNetWorkParam().mFileData = new HashMap<>();
            }
            this.a.getRequest().getNetWorkParam().mFileData.put(str, bArr);
        }
    }
}
