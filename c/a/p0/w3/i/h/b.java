package c.a.p0.w3.i.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.w3.i.d.b;
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
public class b implements c.a.p0.w3.i.b, b.c, c.a.p0.e0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f27995e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.w3.b f27996f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.w3.i.d.a f27997g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f27998h;

    /* renamed from: i  reason: collision with root package name */
    public String f27999i;

    public b(c.a.p0.w3.b bVar) {
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
        this.f27996f = bVar;
        this.f27995e = bVar.f27846a;
    }

    public final void a(String str) {
        c.a.p0.w3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f27996f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f27996f.c();
            this.f27996f = null;
            return;
        }
        this.f27999i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f27999i);
        videoInfo.setThumbPath(this.f27996f.f27848c);
        c.a.p0.w3.b bVar2 = this.f27996f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void b() {
        c.a.p0.w3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f27996f) == null) {
            return;
        }
        if (bVar.b()) {
            this.f27996f.c();
            this.f27996f = null;
            return;
        }
        if (StringUtils.isNull(this.f27996f.f27849d)) {
            c.a.p0.w3.b bVar2 = this.f27996f;
            if (!bVar2.f27850e) {
                onSaveMusicVideo(bVar2.f27847b, -4399, "");
                return;
            }
        }
        if (this.f27998h == null) {
            this.f27998h = new SelectMusicModel(this.f27995e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f27998h;
        c.a.p0.w3.b bVar3 = this.f27996f;
        selectMusicModel.z(bVar3.f27847b, bVar3.f27849d, c.a.p0.w3.c.f27859f + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f27850e);
    }

    @Override // c.a.p0.e0.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.w3.b bVar = this.f27996f;
            if (bVar != null) {
                bVar.i(true);
            }
            c.a.p0.w3.i.d.a aVar = this.f27997g;
            if (aVar == null || !aVar.f()) {
                return;
            }
            this.f27997g.e();
        }
    }

    @Override // c.a.p0.w3.i.d.b.c
    public void onGenFilterVideoFail(int i2, String str) {
        c.a.p0.w3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (bVar = this.f27996f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.p0.w3.i.d.b.c
    public void onGenFilterVideoRecordError(int i2, String str) {
        c.a.p0.w3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || (bVar = this.f27996f) == null) {
            return;
        }
        bVar.d(i2, str);
    }

    @Override // c.a.p0.w3.i.d.b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            c.a.p0.w3.b bVar = this.f27996f;
            if (bVar != null) {
                bVar.e();
            }
            a(str);
        }
    }

    @Override // c.a.p0.w3.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) {
            c.a.p0.w3.b bVar = this.f27996f;
            if (bVar != null && bVar.b()) {
                this.f27996f.c();
                this.f27996f = null;
            } else if (TextUtils.isEmpty(str)) {
                this.f27995e.showToast(R.string.mixing_fail);
                c.a.p0.w3.b bVar2 = this.f27996f;
                if (bVar2 != null) {
                    bVar2.g(i2, str2);
                }
            } else {
                c.a.p0.w3.b bVar3 = this.f27996f;
                if (bVar3 != null) {
                    bVar3.h();
                }
                if (!StringUtils.isNull(this.f27996f.f27851f)) {
                    if (!StringHelper.equals(str, this.f27996f.f27847b)) {
                        this.f27996f.f27852g = str;
                    }
                    if (this.f27997g == null) {
                        c.a.p0.w3.i.d.a aVar = new c.a.p0.w3.i.d.a(this.f27995e.getActivity());
                        this.f27997g = aVar;
                        aVar.i(this);
                    }
                    this.f27997g.g(str, this.f27996f.f27851f);
                    return;
                }
                c.a.p0.w3.b bVar4 = this.f27996f;
                if (bVar4 != null) {
                    bVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // c.a.p0.w3.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }

    @Override // c.a.p0.e0.b
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b();
        }
    }
}
