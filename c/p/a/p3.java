package c.p.a;

import android.content.Context;
import android.widget.VideoView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes7.dex */
public class p3 implements i3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ b1 a;

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
        this.a = b1Var;
    }

    @Override // c.p.a.i3
    public void a(boolean z) {
        VideoView videoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (videoView = this.a.f30750h) == null) {
            return;
        }
        if (!z) {
            videoView.pause();
            return;
        }
        videoView.start();
        this.a.a();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        c1 c1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (c1Var = this.a.f30745c) == null) {
            return;
        }
        c1Var.onClicked();
    }

    @Override // c.p.a.i3
    public void onDisplayed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b1 b1Var = this.a;
            if (b1Var.f30745c != null) {
                VideoView videoView = b1Var.f30750h;
                if (videoView != null) {
                    videoView.start();
                    this.a.a();
                }
                this.a.f30745c.onDisplayed();
            }
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                c1 c1Var = this.a.f30745c;
                if (c1Var != null) {
                    c1Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            b1 b1Var = this.a;
            c1 c1Var2 = b1Var.f30745c;
            if (c1Var2 == null || b1Var.f30747e) {
                return;
            }
            c1Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            u2 u2Var = this.a.f30744b.a;
            if (u2Var != null && u2Var.e()) {
                b1 b1Var = this.a;
                Context context = b1Var.a;
                u2 u2Var2 = b1Var.f30744b.a;
                m2.l(context, (u2Var2 == null || !u2Var2.e()) ? 0L : u2Var2.f30959c.getLo_timeout());
                u2 u2Var3 = this.a.f30744b.a;
                String str = "";
                if (((u2Var3 == null || !u2Var3.e()) ? "" : u2Var3.f30959c.getLoad_type()).equals("video")) {
                    u2 u2Var4 = this.a.f30744b.a;
                    if (u2Var4 != null && u2Var4.e()) {
                        str = u2Var4.f30959c.getLoad();
                    }
                    this.a.c(str);
                    return;
                }
                c1 c1Var = this.a.f30745c;
                if (c1Var != null) {
                    c1Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
