package c.a.p0.x.g;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<AdDownloadData> a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<c.a.p0.x.g.g.a> f20601b;

    /* renamed from: c  reason: collision with root package name */
    public int f20602c;

    /* renamed from: d  reason: collision with root package name */
    public int f20603d;

    /* renamed from: e  reason: collision with root package name */
    public long f20604e;

    public d(c.a.p0.x.g.g.a aVar, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, adDownloadData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new WeakReference<>(adDownloadData);
        this.f20601b = new WeakReference<>(aVar);
        this.f20603d = c.a.p0.a.h().b();
        this.f20602c = c.a.p0.a.h().c();
        this.f20604e = c.a.p0.a.h().a();
        d(adDownloadData.getContentLength());
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
            Message message = new Message();
            message.what = 1;
            sendMessageDelayed(message, 1000L);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            sendMessageDelayed(obtain, (this.f20602c * 1000) / this.f20603d);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeMessages(1);
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || j <= 1) {
            return;
        }
        long j2 = this.f20604e;
        if (j2 > 0) {
            this.f20602c = (int) (((((float) j) * this.f20603d) / 100.0f) / ((float) j2));
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
            super.handleMessage(message);
            if (message.what != 1) {
                c();
                if (c.a.o0.r.e.e()) {
                    Log.d("AdFakeProgressHandler", "fake stop is not WHAT_UPDATE_PROGRESS");
                    return;
                }
                return;
            }
            AdDownloadData adDownloadData = this.a.get();
            c.a.p0.x.g.g.a aVar = this.f20601b.get();
            if (adDownloadData != null && aVar != null) {
                if (this.f20603d <= 0) {
                    adDownloadData.setFakePercent(0);
                    c();
                    if (c.a.o0.r.e.e()) {
                        Log.d("AdFakeProgressHandler", "fake stop ：开关关闭");
                        return;
                    }
                    return;
                } else if (!l.z()) {
                    c();
                    if (c.a.o0.r.e.e()) {
                        Log.d("AdFakeProgressHandler", "fake stop ：检测无网络");
                        return;
                    }
                    return;
                } else if (adDownloadData.getCurrentState() != DownloadStatus.STATUS_DOWNLOADING) {
                    c();
                    if (c.a.o0.r.e.e()) {
                        Log.d("AdFakeProgressHandler", "fake stop ：非正在下载状态:" + adDownloadData.getCurrentState());
                        return;
                    }
                    return;
                } else {
                    int fakePercent = adDownloadData.getFakePercent();
                    if (fakePercent >= this.f20603d) {
                        c();
                        if (c.a.o0.r.e.e()) {
                            Log.d("AdFakeProgressHandler", "fake stop ：假进度达到最大值.");
                            return;
                        }
                        return;
                    }
                    int i = fakePercent + 1;
                    adDownloadData.setFakePercent(i);
                    if (i < adDownloadData.getPercent()) {
                        if (c.a.o0.r.e.e()) {
                            Log.d("AdFakeProgressHandler", "fake log ：真实进度超过假进度.");
                        }
                    } else {
                        aVar.j(i);
                    }
                    b();
                    return;
                }
            }
            c();
            if (c.a.o0.r.e.e()) {
                StringBuilder sb = new StringBuilder();
                sb.append("fake stop ：回收");
                sb.append(adDownloadData == null);
                sb.append(" ");
                sb.append(aVar == null);
                sb.append(" ");
                sb.append(aVar == null);
                Log.d("AdFakeProgressHandler", sb.toString());
            }
        }
    }
}
