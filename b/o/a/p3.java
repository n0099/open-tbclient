package b.o.a;

import android.content.Context;
import android.widget.VideoView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes6.dex */
public class p3 implements i3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b1 f34268a;

    public p3(b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34268a = b1Var;
    }

    @Override // b.o.a.i3
    public void a(boolean z) {
        VideoView videoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (videoView = this.f34268a.f34091h) == null) {
            return;
        }
        if (!z) {
            videoView.pause();
            return;
        }
        videoView.start();
        this.f34268a.a();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        c1 c1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (c1Var = this.f34268a.f34086c) == null) {
            return;
        }
        c1Var.onClicked();
    }

    @Override // b.o.a.i3
    public void onDisplayed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b1 b1Var = this.f34268a;
            if (b1Var.f34086c != null) {
                VideoView videoView = b1Var.f34091h;
                if (videoView != null) {
                    videoView.start();
                    this.f34268a.a();
                }
                this.f34268a.f34086c.onDisplayed();
            }
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                c1 c1Var = this.f34268a.f34086c;
                if (c1Var != null) {
                    c1Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            b1 b1Var = this.f34268a;
            c1 c1Var2 = b1Var.f34086c;
            if (c1Var2 == null || b1Var.f34088e) {
                return;
            }
            c1Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            u2 u2Var = this.f34268a.f34085b.f34131a;
            if (u2Var != null && u2Var.e()) {
                b1 b1Var = this.f34268a;
                Context context = b1Var.f34084a;
                u2 u2Var2 = b1Var.f34085b.f34131a;
                m2.l(context, (u2Var2 == null || !u2Var2.e()) ? 0L : u2Var2.f34354c.getLo_timeout());
                u2 u2Var3 = this.f34268a.f34085b.f34131a;
                String str = "";
                if (((u2Var3 == null || !u2Var3.e()) ? "" : u2Var3.f34354c.getLoad_type()).equals("video")) {
                    u2 u2Var4 = this.f34268a.f34085b.f34131a;
                    if (u2Var4 != null && u2Var4.e()) {
                        str = u2Var4.f34354c.getLoad();
                    }
                    this.f34268a.c(str);
                    return;
                }
                c1 c1Var = this.f34268a.f34086c;
                if (c1Var != null) {
                    c1Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
