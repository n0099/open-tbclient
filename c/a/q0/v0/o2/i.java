package c.a.q0.v0.o2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageFragment;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class i implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f26872a;

    /* renamed from: b  reason: collision with root package name */
    public VideoMiddleModel f26873b;

    /* renamed from: c  reason: collision with root package name */
    public String f26874c;

    /* renamed from: d  reason: collision with root package name */
    public String f26875d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26876e;

    /* renamed from: f  reason: collision with root package name */
    public VideoSerializeVideoThreadInfo f26877f;

    /* renamed from: g  reason: collision with root package name */
    public VideoMiddleModel.b f26878g;

    /* loaded from: classes4.dex */
    public class a implements VideoMiddleModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f26879a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26879a = iVar;
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f26879a.f26872a == null) {
                return;
            }
            this.f26879a.f26872a.hideLoadingView();
            this.f26879a.f26872a.showMsg(str);
            this.f26879a.f26872a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void b(List<BaseCardInfo> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) || this.f26879a.f26872a == null) {
                return;
            }
            this.f26879a.f26872a.hideLoadingView();
            this.f26879a.f26876e = z;
            this.f26879a.f26872a.setData(list, z, false);
        }
    }

    public i(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26878g = new a(this);
        if (hVar instanceof VideoMiddlePageFragment) {
            this.f26872a = hVar;
            hVar.setPresenter(this);
            this.f26873b = new VideoMiddleModel(((VideoMiddlePageFragment) hVar).getPageContext(), this.f26878g);
        }
    }

    public void c() {
        VideoMiddleModel videoMiddleModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoMiddleModel = this.f26873b) == null) {
            return;
        }
        videoMiddleModel.cancelLoadData();
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            VideoMiddleModel videoMiddleModel = this.f26873b;
            if (videoMiddleModel != null) {
                return videoMiddleModel.A();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public VideoSerializeVideoThreadInfo e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26877f : (VideoSerializeVideoThreadInfo) invokeV.objValue;
    }

    public void f() {
        VideoMiddleModel videoMiddleModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (videoMiddleModel = this.f26873b) != null && this.f26876e) {
            videoMiddleModel.setFrom(this.f26875d);
            this.f26873b.LoadData();
        }
    }

    public void g() {
        VideoMiddleModel videoMiddleModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (videoMiddleModel = this.f26873b) == null) {
            return;
        }
        videoMiddleModel.setFrom(this.f26875d);
        this.f26873b.LoadData();
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f26875d = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f26874c = str;
            VideoMiddleModel videoMiddleModel = this.f26873b;
            if (videoMiddleModel != null) {
                videoMiddleModel.B(str);
            }
        }
    }

    public void j(String str) {
        VideoMiddleModel videoMiddleModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (videoMiddleModel = this.f26873b) == null) {
            return;
        }
        videoMiddleModel.C(str);
    }

    public void k(String str) {
        VideoMiddleModel videoMiddleModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (videoMiddleModel = this.f26873b) == null) {
            return;
        }
        videoMiddleModel.D(str);
    }

    public void l(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoSerializeVideoThreadInfo) == null) {
            this.f26877f = videoSerializeVideoThreadInfo;
            VideoMiddleModel videoMiddleModel = this.f26873b;
            if (videoMiddleModel != null) {
                videoMiddleModel.E(videoSerializeVideoThreadInfo);
            }
        }
    }
}
