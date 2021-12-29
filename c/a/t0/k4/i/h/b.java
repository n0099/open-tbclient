package c.a.t0.k4.i.h;

import android.text.TextUtils;
import c.a.t0.k4.i.d.b;
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
/* loaded from: classes7.dex */
public class b implements c.a.t0.k4.i.b, b.c, c.a.t0.k0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f19410e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.k4.b f19411f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.k4.i.d.a f19412g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f19413h;

    /* renamed from: i  reason: collision with root package name */
    public String f19414i;

    public b(c.a.t0.k4.b bVar) {
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
        this.f19411f = bVar;
        this.f19410e = bVar.a;
    }

    public final void a(String str) {
        c.a.t0.k4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f19411f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f19411f.c();
            this.f19411f = null;
            return;
        }
        this.f19414i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f19414i);
        videoInfo.setThumbPath(this.f19411f.f19285c);
        c.a.t0.k4.b bVar2 = this.f19411f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void b() {
        c.a.t0.k4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f19411f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f19411f.c();
            this.f19411f = null;
            return;
        }
        if (StringUtils.isNull(this.f19411f.f19286d)) {
            c.a.t0.k4.b bVar2 = this.f19411f;
            if (!bVar2.f19287e) {
                onSaveMusicVideo(bVar2.f19284b, -4399, "");
                return;
            }
        }
        if (this.f19413h == null) {
            this.f19413h = new SelectMusicModel(this.f19410e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f19413h;
        c.a.t0.k4.b bVar3 = this.f19411f;
        selectMusicModel.z(bVar3.f19284b, bVar3.f19286d, c.a.t0.k4.c.f19295f + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f19287e);
    }

    @Override // c.a.t0.k0.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.t0.k4.b bVar = this.f19411f;
            if (bVar != null) {
                bVar.i(true);
            }
            c.a.t0.k4.i.d.a aVar = this.f19412g;
            if (aVar == null || !aVar.f()) {
                return;
            }
            this.f19412g.e();
        }
    }

    @Override // c.a.t0.k4.i.d.b.c
    public void onGenFilterVideoFail(int i2, String str) {
        c.a.t0.k4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (bVar = this.f19411f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.t0.k4.i.d.b.c
    public void onGenFilterVideoRecordError(int i2, String str) {
        c.a.t0.k4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (bVar = this.f19411f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.t0.k4.i.d.b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            c.a.t0.k4.b bVar = this.f19411f;
            if (bVar != null) {
                bVar.e();
            }
            a(str);
        }
    }

    @Override // c.a.t0.k4.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) {
            c.a.t0.k4.b bVar = this.f19411f;
            if (bVar != null && bVar.b()) {
                this.f19411f.c();
                this.f19411f = null;
            } else if (TextUtils.isEmpty(str)) {
                this.f19410e.showToast(R.string.mixing_fail);
                c.a.t0.k4.b bVar2 = this.f19411f;
                if (bVar2 != null) {
                    bVar2.g(i2, str2);
                }
            } else {
                c.a.t0.k4.b bVar3 = this.f19411f;
                if (bVar3 != null) {
                    bVar3.h();
                }
                if (!StringUtils.isNull(this.f19411f.f19288f)) {
                    if (!StringHelper.equals(str, this.f19411f.f19284b)) {
                        this.f19411f.f19289g = str;
                    }
                    if (this.f19412g == null) {
                        c.a.t0.k4.i.d.a aVar = new c.a.t0.k4.i.d.a(this.f19410e.getActivity());
                        this.f19412g = aVar;
                        aVar.i(this);
                    }
                    this.f19412g.g(str, this.f19411f.f19288f);
                    return;
                }
                c.a.t0.k4.b bVar4 = this.f19411f;
                if (bVar4 != null) {
                    bVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // c.a.t0.k4.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
