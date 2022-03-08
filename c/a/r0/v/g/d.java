package c.a.r0.v.g;

import android.os.Handler;
import android.os.Message;
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
    public WeakReference<c.a.r0.v.g.g.a> f24174b;

    /* renamed from: c  reason: collision with root package name */
    public int f24175c;

    /* renamed from: d  reason: collision with root package name */
    public int f24176d;

    /* renamed from: e  reason: collision with root package name */
    public long f24177e;

    public d(c.a.r0.v.g.g.a aVar, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, adDownloadData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new WeakReference<>(adDownloadData);
        this.f24174b = new WeakReference<>(aVar);
        this.f24176d = c.a.r0.a.h().b();
        this.f24175c = c.a.r0.a.h().c();
        this.f24177e = c.a.r0.a.h().a();
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
            sendMessageDelayed(obtain, (this.f24175c * 1000) / this.f24176d);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeMessages(1);
        }
    }

    public void d(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) || j2 <= 1) {
            return;
        }
        long j3 = this.f24177e;
        if (j3 > 0) {
            this.f24175c = (int) (((((float) j2) * this.f24176d) / 100.0f) / ((float) j3));
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
            super.handleMessage(message);
            if (message.what != 1) {
                c();
                c.a.q0.r.e.e();
                return;
            }
            AdDownloadData adDownloadData = this.a.get();
            c.a.r0.v.g.g.a aVar = this.f24174b.get();
            if (adDownloadData != null && aVar != null) {
                if (this.f24176d <= 0) {
                    adDownloadData.setFakePercent(0);
                    c();
                    c.a.q0.r.e.e();
                    return;
                } else if (!l.z()) {
                    c();
                    c.a.q0.r.e.e();
                    return;
                } else if (adDownloadData.getCurrentState() != DownloadStatus.STATUS_DOWNLOADING) {
                    c();
                    if (c.a.q0.r.e.e()) {
                        String str = "fake stop ：非正在下载状态:" + adDownloadData.getCurrentState();
                        return;
                    }
                    return;
                } else {
                    int fakePercent = adDownloadData.getFakePercent();
                    if (fakePercent >= this.f24176d) {
                        c();
                        c.a.q0.r.e.e();
                        return;
                    }
                    int i2 = fakePercent + 1;
                    adDownloadData.setFakePercent(i2);
                    if (i2 < adDownloadData.getPercent()) {
                        c.a.q0.r.e.e();
                    } else {
                        aVar.i(i2);
                    }
                    b();
                    return;
                }
            }
            c();
            if (c.a.q0.r.e.e()) {
                StringBuilder sb = new StringBuilder();
                sb.append("fake stop ：回收");
                sb.append(adDownloadData == null);
                sb.append(" ");
                sb.append(aVar == null);
                sb.append(" ");
                sb.append(aVar == null);
                sb.toString();
            }
        }
    }
}
