package c.m.a;

import android.content.Context;
import android.widget.VideoView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes3.dex */
public class k3 implements d3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ b1 a;

    public k3(b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = b1Var;
    }

    @Override // c.m.a.d3
    public void a(boolean z) {
        VideoView videoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (videoView = this.a.f23409h) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (c1Var = this.a.f23404c) == null) {
            return;
        }
        c1Var.onClicked();
    }

    @Override // c.m.a.d3
    public void onDisplayed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b1 b1Var = this.a;
            if (b1Var.f23404c != null) {
                VideoView videoView = b1Var.f23409h;
                if (videoView != null) {
                    videoView.start();
                    this.a.a();
                }
                this.a.f23404c.onDisplayed();
            }
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                c1 c1Var = this.a.f23404c;
                if (c1Var != null) {
                    c1Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            b1 b1Var = this.a;
            c1 c1Var2 = b1Var.f23404c;
            if (c1Var2 == null || b1Var.f23406e) {
                return;
            }
            c1Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            p2 p2Var = this.a.f23403b.a;
            if (p2Var != null && p2Var.e()) {
                b1 b1Var = this.a;
                Context context = b1Var.a;
                p2 p2Var2 = b1Var.f23403b.a;
                h2.l(context, (p2Var2 == null || !p2Var2.e()) ? 0L : p2Var2.f23529c.getLo_timeout());
                p2 p2Var3 = this.a.f23403b.a;
                String str = "";
                if (((p2Var3 == null || !p2Var3.e()) ? "" : p2Var3.f23529c.getLoad_type()).equals("video")) {
                    p2 p2Var4 = this.a.f23403b.a;
                    if (p2Var4 != null && p2Var4.e()) {
                        str = p2Var4.f23529c.getLoad();
                    }
                    this.a.c(str);
                    return;
                }
                c1 c1Var = this.a.f23404c;
                if (c1Var != null) {
                    c1Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
