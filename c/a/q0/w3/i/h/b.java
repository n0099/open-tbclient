package c.a.q0.w3.i.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.w3.i.d.b;
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
public class b implements c.a.q0.w3.i.b, b.c, c.a.q0.e0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f28334e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.w3.b f28335f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.w3.i.d.a f28336g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f28337h;

    /* renamed from: i  reason: collision with root package name */
    public String f28338i;

    public b(c.a.q0.w3.b bVar) {
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
        this.f28335f = bVar;
        this.f28334e = bVar.f28185a;
    }

    public final void a(String str) {
        c.a.q0.w3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f28335f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f28335f.c();
            this.f28335f = null;
            return;
        }
        this.f28338i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f28338i);
        videoInfo.setThumbPath(this.f28335f.f28187c);
        c.a.q0.w3.b bVar2 = this.f28335f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void b() {
        c.a.q0.w3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f28335f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f28335f.c();
            this.f28335f = null;
            return;
        }
        if (StringUtils.isNull(this.f28335f.f28188d)) {
            c.a.q0.w3.b bVar2 = this.f28335f;
            if (!bVar2.f28189e) {
                onSaveMusicVideo(bVar2.f28186b, -4399, "");
                return;
            }
        }
        if (this.f28337h == null) {
            this.f28337h = new SelectMusicModel(this.f28334e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f28337h;
        c.a.q0.w3.b bVar3 = this.f28335f;
        selectMusicModel.z(bVar3.f28186b, bVar3.f28188d, c.a.q0.w3.c.f28198f + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f28189e);
    }

    @Override // c.a.q0.e0.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.w3.b bVar = this.f28335f;
            if (bVar != null) {
                bVar.i(true);
            }
            c.a.q0.w3.i.d.a aVar = this.f28336g;
            if (aVar == null || !aVar.f()) {
                return;
            }
            this.f28336g.e();
        }
    }

    @Override // c.a.q0.w3.i.d.b.c
    public void onGenFilterVideoFail(int i2, String str) {
        c.a.q0.w3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (bVar = this.f28335f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.q0.w3.i.d.b.c
    public void onGenFilterVideoRecordError(int i2, String str) {
        c.a.q0.w3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (bVar = this.f28335f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.q0.w3.i.d.b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            c.a.q0.w3.b bVar = this.f28335f;
            if (bVar != null) {
                bVar.e();
            }
            a(str);
        }
    }

    @Override // c.a.q0.w3.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) {
            c.a.q0.w3.b bVar = this.f28335f;
            if (bVar != null && bVar.b()) {
                this.f28335f.c();
                this.f28335f = null;
            } else if (TextUtils.isEmpty(str)) {
                this.f28334e.showToast(R.string.mixing_fail);
                c.a.q0.w3.b bVar2 = this.f28335f;
                if (bVar2 != null) {
                    bVar2.g(i2, str2);
                }
            } else {
                c.a.q0.w3.b bVar3 = this.f28335f;
                if (bVar3 != null) {
                    bVar3.h();
                }
                if (!StringUtils.isNull(this.f28335f.f28190f)) {
                    if (!StringHelper.equals(str, this.f28335f.f28186b)) {
                        this.f28335f.f28191g = str;
                    }
                    if (this.f28336g == null) {
                        c.a.q0.w3.i.d.a aVar = new c.a.q0.w3.i.d.a(this.f28334e.getActivity());
                        this.f28336g = aVar;
                        aVar.i(this);
                    }
                    this.f28336g.g(str, this.f28335f.f28190f);
                    return;
                }
                c.a.q0.w3.b bVar4 = this.f28335f;
                if (bVar4 != null) {
                    bVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // c.a.q0.w3.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    @Override // c.a.q0.e0.b
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b();
        }
    }
}
