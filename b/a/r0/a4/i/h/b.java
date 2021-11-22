package b.a.r0.a4.i.h;

import android.text.TextUtils;
import b.a.r0.a4.i.d.b;
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
public class b implements b.a.r0.a4.i.b, b.c, b.a.r0.f0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f16052e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.a4.b f16053f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.a4.i.d.a f16054g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f16055h;

    /* renamed from: i  reason: collision with root package name */
    public String f16056i;

    public b(b.a.r0.a4.b bVar) {
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
        this.f16053f = bVar;
        this.f16052e = bVar.f15908a;
    }

    public final void a(String str) {
        b.a.r0.a4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f16053f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f16053f.c();
            this.f16053f = null;
            return;
        }
        this.f16056i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f16056i);
        videoInfo.setThumbPath(this.f16053f.f15910c);
        b.a.r0.a4.b bVar2 = this.f16053f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void b() {
        b.a.r0.a4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f16053f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f16053f.c();
            this.f16053f = null;
            return;
        }
        if (StringUtils.isNull(this.f16053f.f15911d)) {
            b.a.r0.a4.b bVar2 = this.f16053f;
            if (!bVar2.f15912e) {
                onSaveMusicVideo(bVar2.f15909b, -4399, "");
                return;
            }
        }
        if (this.f16055h == null) {
            this.f16055h = new SelectMusicModel(this.f16052e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f16055h;
        b.a.r0.a4.b bVar3 = this.f16053f;
        selectMusicModel.z(bVar3.f15909b, bVar3.f15911d, b.a.r0.a4.c.f15921f + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f15912e);
    }

    @Override // b.a.r0.f0.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.r0.a4.b bVar = this.f16053f;
            if (bVar != null) {
                bVar.i(true);
            }
            b.a.r0.a4.i.d.a aVar = this.f16054g;
            if (aVar == null || !aVar.f()) {
                return;
            }
            this.f16054g.e();
        }
    }

    @Override // b.a.r0.a4.i.d.b.c
    public void onGenFilterVideoFail(int i2, String str) {
        b.a.r0.a4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (bVar = this.f16053f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // b.a.r0.a4.i.d.b.c
    public void onGenFilterVideoRecordError(int i2, String str) {
        b.a.r0.a4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (bVar = this.f16053f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // b.a.r0.a4.i.d.b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            b.a.r0.a4.b bVar = this.f16053f;
            if (bVar != null) {
                bVar.e();
            }
            a(str);
        }
    }

    @Override // b.a.r0.a4.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) {
            b.a.r0.a4.b bVar = this.f16053f;
            if (bVar != null && bVar.b()) {
                this.f16053f.c();
                this.f16053f = null;
            } else if (TextUtils.isEmpty(str)) {
                this.f16052e.showToast(R.string.mixing_fail);
                b.a.r0.a4.b bVar2 = this.f16053f;
                if (bVar2 != null) {
                    bVar2.g(i2, str2);
                }
            } else {
                b.a.r0.a4.b bVar3 = this.f16053f;
                if (bVar3 != null) {
                    bVar3.h();
                }
                if (!StringUtils.isNull(this.f16053f.f15913f)) {
                    if (!StringHelper.equals(str, this.f16053f.f15909b)) {
                        this.f16053f.f15914g = str;
                    }
                    if (this.f16054g == null) {
                        b.a.r0.a4.i.d.a aVar = new b.a.r0.a4.i.d.a(this.f16052e.getActivity());
                        this.f16054g = aVar;
                        aVar.i(this);
                    }
                    this.f16054g.g(str, this.f16053f.f15913f);
                    return;
                }
                b.a.r0.a4.b bVar4 = this.f16053f;
                if (bVar4 != null) {
                    bVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // b.a.r0.a4.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
