package c.a.u0.n4.i.h;

import android.text.TextUtils;
import c.a.u0.n4.i.d.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements c.a.u0.n4.i.b, b.c, c.a.u0.k0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f19896e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.u0.n4.b f19897f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.u0.n4.i.d.a f19898g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f19899h;

    /* renamed from: i  reason: collision with root package name */
    public String f19900i;

    public b(c.a.u0.n4.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19897f = bVar;
        this.f19896e = bVar.a;
    }

    public final void a(String str) {
        c.a.u0.n4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f19897f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f19897f.c();
            this.f19897f = null;
            return;
        }
        this.f19900i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f19900i);
        videoInfo.setThumbPath(this.f19897f.f19774c);
        c.a.u0.n4.b bVar2 = this.f19897f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void b() {
        c.a.u0.n4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f19897f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f19897f.c();
            this.f19897f = null;
            return;
        }
        if (StringUtils.isNull(this.f19897f.f19775d)) {
            c.a.u0.n4.b bVar2 = this.f19897f;
            if (!bVar2.f19776e) {
                onSaveMusicVideo(bVar2.f19773b, -4399, "");
                return;
            }
        }
        if (this.f19899h == null) {
            this.f19899h = new SelectMusicModel(this.f19896e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f19899h;
        c.a.u0.n4.b bVar3 = this.f19897f;
        selectMusicModel.z(bVar3.f19773b, bVar3.f19775d, c.a.u0.n4.c.f19784f + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f19776e);
    }

    @Override // c.a.u0.k0.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.u0.n4.b bVar = this.f19897f;
            if (bVar != null) {
                bVar.i(true);
            }
            c.a.u0.n4.i.d.a aVar = this.f19898g;
            if (aVar == null || !aVar.f()) {
                return;
            }
            this.f19898g.e();
        }
    }

    @Override // c.a.u0.n4.i.d.b.c
    public void onGenFilterVideoFail(int i2, String str) {
        c.a.u0.n4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (bVar = this.f19897f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.u0.n4.i.d.b.c
    public void onGenFilterVideoRecordError(int i2, String str) {
        c.a.u0.n4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (bVar = this.f19897f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.u0.n4.i.d.b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            c.a.u0.n4.b bVar = this.f19897f;
            if (bVar != null) {
                bVar.e();
            }
            a(str);
        }
    }

    @Override // c.a.u0.n4.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) {
            c.a.u0.n4.b bVar = this.f19897f;
            if (bVar != null && bVar.b()) {
                this.f19897f.c();
                this.f19897f = null;
            } else if (TextUtils.isEmpty(str)) {
                this.f19896e.showToast(R.string.mixing_fail);
                c.a.u0.n4.b bVar2 = this.f19897f;
                if (bVar2 != null) {
                    bVar2.g(i2, str2);
                }
            } else {
                c.a.u0.n4.b bVar3 = this.f19897f;
                if (bVar3 != null) {
                    bVar3.h();
                }
                if (!StringUtils.isNull(this.f19897f.f19777f)) {
                    if (!StringHelper.equals(str, this.f19897f.f19773b)) {
                        this.f19897f.f19778g = str;
                    }
                    if (this.f19898g == null) {
                        c.a.u0.n4.i.d.a aVar = new c.a.u0.n4.i.d.a(this.f19896e.getActivity());
                        this.f19898g = aVar;
                        aVar.i(this);
                    }
                    this.f19898g.g(str, this.f19897f.f19777f);
                    return;
                }
                c.a.u0.n4.b bVar4 = this.f19897f;
                if (bVar4 != null) {
                    bVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // c.a.u0.n4.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
