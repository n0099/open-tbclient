package c.a.s0.j4.i.h;

import android.text.TextUtils;
import c.a.s0.j4.i.d.b;
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
public class b implements c.a.s0.j4.i.b, b.c, c.a.s0.k0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f18676e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.j4.b f18677f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.j4.i.d.a f18678g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f18679h;

    /* renamed from: i  reason: collision with root package name */
    public String f18680i;

    public b(c.a.s0.j4.b bVar) {
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
        this.f18677f = bVar;
        this.f18676e = bVar.a;
    }

    public final void a(String str) {
        c.a.s0.j4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f18677f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f18677f.c();
            this.f18677f = null;
            return;
        }
        this.f18680i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f18680i);
        videoInfo.setThumbPath(this.f18677f.f18551c);
        c.a.s0.j4.b bVar2 = this.f18677f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void b() {
        c.a.s0.j4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f18677f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f18677f.c();
            this.f18677f = null;
            return;
        }
        if (StringUtils.isNull(this.f18677f.f18552d)) {
            c.a.s0.j4.b bVar2 = this.f18677f;
            if (!bVar2.f18553e) {
                onSaveMusicVideo(bVar2.f18550b, -4399, "");
                return;
            }
        }
        if (this.f18679h == null) {
            this.f18679h = new SelectMusicModel(this.f18676e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f18679h;
        c.a.s0.j4.b bVar3 = this.f18677f;
        selectMusicModel.z(bVar3.f18550b, bVar3.f18552d, c.a.s0.j4.c.f18561f + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f18553e);
    }

    @Override // c.a.s0.k0.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.j4.b bVar = this.f18677f;
            if (bVar != null) {
                bVar.i(true);
            }
            c.a.s0.j4.i.d.a aVar = this.f18678g;
            if (aVar == null || !aVar.f()) {
                return;
            }
            this.f18678g.e();
        }
    }

    @Override // c.a.s0.j4.i.d.b.c
    public void onGenFilterVideoFail(int i2, String str) {
        c.a.s0.j4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (bVar = this.f18677f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.s0.j4.i.d.b.c
    public void onGenFilterVideoRecordError(int i2, String str) {
        c.a.s0.j4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (bVar = this.f18677f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.s0.j4.i.d.b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            c.a.s0.j4.b bVar = this.f18677f;
            if (bVar != null) {
                bVar.e();
            }
            a(str);
        }
    }

    @Override // c.a.s0.j4.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) {
            c.a.s0.j4.b bVar = this.f18677f;
            if (bVar != null && bVar.b()) {
                this.f18677f.c();
                this.f18677f = null;
            } else if (TextUtils.isEmpty(str)) {
                this.f18676e.showToast(R.string.mixing_fail);
                c.a.s0.j4.b bVar2 = this.f18677f;
                if (bVar2 != null) {
                    bVar2.g(i2, str2);
                }
            } else {
                c.a.s0.j4.b bVar3 = this.f18677f;
                if (bVar3 != null) {
                    bVar3.h();
                }
                if (!StringUtils.isNull(this.f18677f.f18554f)) {
                    if (!StringHelper.equals(str, this.f18677f.f18550b)) {
                        this.f18677f.f18555g = str;
                    }
                    if (this.f18678g == null) {
                        c.a.s0.j4.i.d.a aVar = new c.a.s0.j4.i.d.a(this.f18676e.getActivity());
                        this.f18678g = aVar;
                        aVar.i(this);
                    }
                    this.f18678g.g(str, this.f18677f.f18554f);
                    return;
                }
                c.a.s0.j4.b bVar4 = this.f18677f;
                if (bVar4 != null) {
                    bVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // c.a.s0.j4.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
