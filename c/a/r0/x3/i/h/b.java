package c.a.r0.x3.i.h;

import android.text.TextUtils;
import c.a.r0.x3.i.d.b;
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
public class b implements c.a.r0.x3.i.b, b.c, c.a.r0.e0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f29021e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.x3.b f29022f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.x3.i.d.a f29023g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f29024h;

    /* renamed from: i  reason: collision with root package name */
    public String f29025i;

    public b(c.a.r0.x3.b bVar) {
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
        this.f29022f = bVar;
        this.f29021e = bVar.f28872a;
    }

    public final void a(String str) {
        c.a.r0.x3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f29022f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f29022f.c();
            this.f29022f = null;
            return;
        }
        this.f29025i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f29025i);
        videoInfo.setThumbPath(this.f29022f.f28874c);
        c.a.r0.x3.b bVar2 = this.f29022f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void b() {
        c.a.r0.x3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f29022f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f29022f.c();
            this.f29022f = null;
            return;
        }
        if (StringUtils.isNull(this.f29022f.f28875d)) {
            c.a.r0.x3.b bVar2 = this.f29022f;
            if (!bVar2.f28876e) {
                onSaveMusicVideo(bVar2.f28873b, -4399, "");
                return;
            }
        }
        if (this.f29024h == null) {
            this.f29024h = new SelectMusicModel(this.f29021e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f29024h;
        c.a.r0.x3.b bVar3 = this.f29022f;
        selectMusicModel.z(bVar3.f28873b, bVar3.f28875d, c.a.r0.x3.c.f28885f + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f28876e);
    }

    @Override // c.a.r0.e0.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.x3.b bVar = this.f29022f;
            if (bVar != null) {
                bVar.i(true);
            }
            c.a.r0.x3.i.d.a aVar = this.f29023g;
            if (aVar == null || !aVar.f()) {
                return;
            }
            this.f29023g.e();
        }
    }

    @Override // c.a.r0.x3.i.d.b.c
    public void onGenFilterVideoFail(int i2, String str) {
        c.a.r0.x3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (bVar = this.f29022f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.r0.x3.i.d.b.c
    public void onGenFilterVideoRecordError(int i2, String str) {
        c.a.r0.x3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (bVar = this.f29022f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.r0.x3.i.d.b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            c.a.r0.x3.b bVar = this.f29022f;
            if (bVar != null) {
                bVar.e();
            }
            a(str);
        }
    }

    @Override // c.a.r0.x3.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) {
            c.a.r0.x3.b bVar = this.f29022f;
            if (bVar != null && bVar.b()) {
                this.f29022f.c();
                this.f29022f = null;
            } else if (TextUtils.isEmpty(str)) {
                this.f29021e.showToast(R.string.mixing_fail);
                c.a.r0.x3.b bVar2 = this.f29022f;
                if (bVar2 != null) {
                    bVar2.g(i2, str2);
                }
            } else {
                c.a.r0.x3.b bVar3 = this.f29022f;
                if (bVar3 != null) {
                    bVar3.h();
                }
                if (!StringUtils.isNull(this.f29022f.f28877f)) {
                    if (!StringHelper.equals(str, this.f29022f.f28873b)) {
                        this.f29022f.f28878g = str;
                    }
                    if (this.f29023g == null) {
                        c.a.r0.x3.i.d.a aVar = new c.a.r0.x3.i.d.a(this.f29021e.getActivity());
                        this.f29023g = aVar;
                        aVar.i(this);
                    }
                    this.f29023g.g(str, this.f29022f.f28877f);
                    return;
                }
                c.a.r0.x3.b bVar4 = this.f29022f;
                if (bVar4 != null) {
                    bVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // c.a.r0.x3.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
