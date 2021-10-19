package c.a.r0.y3.i.h;

import android.text.TextUtils;
import c.a.r0.y3.i.d.b;
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
/* loaded from: classes4.dex */
public class b implements c.a.r0.y3.i.b, b.c, c.a.r0.f0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f29217e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.y3.b f29218f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.y3.i.d.a f29219g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f29220h;

    /* renamed from: i  reason: collision with root package name */
    public String f29221i;

    public b(c.a.r0.y3.b bVar) {
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
        this.f29218f = bVar;
        this.f29217e = bVar.f29068a;
    }

    public final void a(String str) {
        c.a.r0.y3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f29218f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f29218f.c();
            this.f29218f = null;
            return;
        }
        this.f29221i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f29221i);
        videoInfo.setThumbPath(this.f29218f.f29070c);
        c.a.r0.y3.b bVar2 = this.f29218f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void b() {
        c.a.r0.y3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f29218f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f29218f.c();
            this.f29218f = null;
            return;
        }
        if (StringUtils.isNull(this.f29218f.f29071d)) {
            c.a.r0.y3.b bVar2 = this.f29218f;
            if (!bVar2.f29072e) {
                onSaveMusicVideo(bVar2.f29069b, -4399, "");
                return;
            }
        }
        if (this.f29220h == null) {
            this.f29220h = new SelectMusicModel(this.f29217e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f29220h;
        c.a.r0.y3.b bVar3 = this.f29218f;
        selectMusicModel.z(bVar3.f29069b, bVar3.f29071d, c.a.r0.y3.c.f29081f + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f29072e);
    }

    @Override // c.a.r0.f0.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.y3.b bVar = this.f29218f;
            if (bVar != null) {
                bVar.i(true);
            }
            c.a.r0.y3.i.d.a aVar = this.f29219g;
            if (aVar == null || !aVar.f()) {
                return;
            }
            this.f29219g.e();
        }
    }

    @Override // c.a.r0.y3.i.d.b.c
    public void onGenFilterVideoFail(int i2, String str) {
        c.a.r0.y3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (bVar = this.f29218f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.r0.y3.i.d.b.c
    public void onGenFilterVideoRecordError(int i2, String str) {
        c.a.r0.y3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (bVar = this.f29218f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.r0.y3.i.d.b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            c.a.r0.y3.b bVar = this.f29218f;
            if (bVar != null) {
                bVar.e();
            }
            a(str);
        }
    }

    @Override // c.a.r0.y3.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) {
            c.a.r0.y3.b bVar = this.f29218f;
            if (bVar != null && bVar.b()) {
                this.f29218f.c();
                this.f29218f = null;
            } else if (TextUtils.isEmpty(str)) {
                this.f29217e.showToast(R.string.mixing_fail);
                c.a.r0.y3.b bVar2 = this.f29218f;
                if (bVar2 != null) {
                    bVar2.g(i2, str2);
                }
            } else {
                c.a.r0.y3.b bVar3 = this.f29218f;
                if (bVar3 != null) {
                    bVar3.h();
                }
                if (!StringUtils.isNull(this.f29218f.f29073f)) {
                    if (!StringHelper.equals(str, this.f29218f.f29069b)) {
                        this.f29218f.f29074g = str;
                    }
                    if (this.f29219g == null) {
                        c.a.r0.y3.i.d.a aVar = new c.a.r0.y3.i.d.a(this.f29217e.getActivity());
                        this.f29219g = aVar;
                        aVar.i(this);
                    }
                    this.f29219g.g(str, this.f29218f.f29073f);
                    return;
                }
                c.a.r0.y3.b bVar4 = this.f29218f;
                if (bVar4 != null) {
                    bVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // c.a.r0.y3.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
