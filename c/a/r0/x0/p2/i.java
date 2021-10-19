package c.a.r0.x0.p2;

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
    public h f27734a;

    /* renamed from: b  reason: collision with root package name */
    public VideoMiddleModel f27735b;

    /* renamed from: c  reason: collision with root package name */
    public String f27736c;

    /* renamed from: d  reason: collision with root package name */
    public String f27737d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27738e;

    /* renamed from: f  reason: collision with root package name */
    public VideoSerializeVideoThreadInfo f27739f;

    /* renamed from: g  reason: collision with root package name */
    public VideoMiddleModel.b f27740g;

    /* loaded from: classes4.dex */
    public class a implements VideoMiddleModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f27741a;

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
            this.f27741a = iVar;
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f27741a.f27734a == null) {
                return;
            }
            this.f27741a.f27734a.hideLoadingView();
            this.f27741a.f27734a.showMsg(str);
            this.f27741a.f27734a.onLoadFail();
        }

        @Override // com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel.b
        public void b(List<BaseCardInfo> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z) == null) || this.f27741a.f27734a == null) {
                return;
            }
            this.f27741a.f27734a.hideLoadingView();
            this.f27741a.f27738e = z;
            this.f27741a.f27734a.setData(list, z, false);
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
        this.f27740g = new a(this);
        if (hVar instanceof VideoMiddlePageFragment) {
            this.f27734a = hVar;
            hVar.setPresenter(this);
            this.f27735b = new VideoMiddleModel(((VideoMiddlePageFragment) hVar).getPageContext(), this.f27740g);
        }
    }

    public void c() {
        VideoMiddleModel videoMiddleModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoMiddleModel = this.f27735b) == null) {
            return;
        }
        videoMiddleModel.cancelLoadData();
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            VideoMiddleModel videoMiddleModel = this.f27735b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27739f : (VideoSerializeVideoThreadInfo) invokeV.objValue;
    }

    public void f() {
        VideoMiddleModel videoMiddleModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (videoMiddleModel = this.f27735b) != null && this.f27738e) {
            videoMiddleModel.setFrom(this.f27737d);
            this.f27735b.loadData();
        }
    }

    public void g() {
        VideoMiddleModel videoMiddleModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (videoMiddleModel = this.f27735b) == null) {
            return;
        }
        videoMiddleModel.setFrom(this.f27737d);
        this.f27735b.loadData();
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f27737d = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f27736c = str;
            VideoMiddleModel videoMiddleModel = this.f27735b;
            if (videoMiddleModel != null) {
                videoMiddleModel.B(str);
            }
        }
    }

    public void j(String str) {
        VideoMiddleModel videoMiddleModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (videoMiddleModel = this.f27735b) == null) {
            return;
        }
        videoMiddleModel.C(str);
    }

    public void k(String str) {
        VideoMiddleModel videoMiddleModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (videoMiddleModel = this.f27735b) == null) {
            return;
        }
        videoMiddleModel.D(str);
    }

    public void l(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoSerializeVideoThreadInfo) == null) {
            this.f27739f = videoSerializeVideoThreadInfo;
            VideoMiddleModel videoMiddleModel = this.f27735b;
            if (videoMiddleModel != null) {
                videoMiddleModel.E(videoSerializeVideoThreadInfo);
            }
        }
    }
}
