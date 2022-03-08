package c.a.b0.j.f;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.b0.j.d.a a;

    /* renamed from: b  reason: collision with root package name */
    public float f1656b;

    public e(@NonNull c.a.b0.j.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1656b = -1.0f;
        this.a = aVar;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
            long j2 = this.a.o.f1623d;
            if (j2 <= 0) {
                return;
            }
            this.f1656b = (((float) j2) * 0.595f) / 768000.0f;
            Message message = new Message();
            message.what = 1;
            sendMessage(message);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Message message = new Message();
            message.what = 1;
            sendMessageDelayed(message, (this.f1656b / 59.500004f) * 1000.0f);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeMessages(1);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            super.handleMessage(message);
            if (message.what != 1) {
                c();
                return;
            }
            c.a.b0.j.d.a aVar = this.a;
            if (aVar.o.f1625f == 1) {
                return;
            }
            if (aVar.f1613c != AdDownloadStatus.DOWNLOADING) {
                c();
                return;
            }
            float f2 = aVar.f1620j;
            if (f2 >= 0.595f) {
                c();
                return;
            }
            aVar.f1620j = Math.max(aVar.f1619i, f2) + 0.01f;
            c.a.b0.j.a.a.b().d(AdDownloadAction.PROGRESS_UPDATE, this.a);
            b();
        }
    }
}
