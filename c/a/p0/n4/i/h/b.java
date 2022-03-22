package c.a.p0.n4.i.h;

import android.text.TextUtils;
import c.a.p0.n4.i.d.b;
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
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements c.a.p0.n4.i.b, b.c, c.a.p0.l0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.n4.b f16685b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.n4.i.d.a f16686c;

    /* renamed from: d  reason: collision with root package name */
    public SelectMusicModel f16687d;

    /* renamed from: e  reason: collision with root package name */
    public String f16688e;

    public b(c.a.p0.n4.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16685b = bVar;
        this.a = bVar.a;
    }

    public final void a(String str) {
        c.a.p0.n4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (bVar = this.f16685b) == null) {
            return;
        }
        if (bVar.b()) {
            this.f16685b.c();
            this.f16685b = null;
            return;
        }
        this.f16688e = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f16688e);
        videoInfo.setThumbPath(this.f16685b.f16587c);
        c.a.p0.n4.b bVar2 = this.f16685b;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void b() {
        c.a.p0.n4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f16685b) == null) {
            return;
        }
        if (bVar.b()) {
            this.f16685b.c();
            this.f16685b = null;
            return;
        }
        if (StringUtils.isNull(this.f16685b.f16588d)) {
            c.a.p0.n4.b bVar2 = this.f16685b;
            if (!bVar2.f16589e) {
                onSaveMusicVideo(bVar2.f16586b, -4399, "");
                return;
            }
        }
        if (this.f16687d == null) {
            this.f16687d = new SelectMusicModel(this.a.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f16687d;
        c.a.p0.n4.b bVar3 = this.f16685b;
        selectMusicModel.B(bVar3.f16586b, bVar3.f16588d, c.a.p0.n4.c.f16597f + "video_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION, !bVar3.f16589e);
    }

    @Override // c.a.p0.l0.b
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.n4.b bVar = this.f16685b;
            if (bVar != null) {
                bVar.i(true);
            }
            c.a.p0.n4.i.d.a aVar = this.f16686c;
            if (aVar == null || !aVar.f()) {
                return;
            }
            this.f16686c.e();
        }
    }

    @Override // c.a.p0.n4.i.d.b.c
    public void onGenFilterVideoFail(int i, String str) {
        c.a.p0.n4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (bVar = this.f16685b) == null) {
            return;
        }
        bVar.d(i, str);
    }

    @Override // c.a.p0.n4.i.d.b.c
    public void onGenFilterVideoRecordError(int i, String str) {
        c.a.p0.n4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (bVar = this.f16685b) == null) {
            return;
        }
        bVar.d(i, str);
    }

    @Override // c.a.p0.n4.i.d.b.c
    public void onGenFilterVideoSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            c.a.p0.n4.b bVar = this.f16685b;
            if (bVar != null) {
                bVar.e();
            }
            a(str);
        }
    }

    @Override // c.a.p0.n4.i.b
    public void onSaveMusicVideo(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, str2) == null) {
            c.a.p0.n4.b bVar = this.f16685b;
            if (bVar != null && bVar.b()) {
                this.f16685b.c();
                this.f16685b = null;
            } else if (TextUtils.isEmpty(str)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0ac5);
                c.a.p0.n4.b bVar2 = this.f16685b;
                if (bVar2 != null) {
                    bVar2.g(i, str2);
                }
            } else {
                c.a.p0.n4.b bVar3 = this.f16685b;
                if (bVar3 != null) {
                    bVar3.h();
                }
                if (!StringUtils.isNull(this.f16685b.f16590f)) {
                    if (!StringHelper.equals(str, this.f16685b.f16586b)) {
                        this.f16685b.f16591g = str;
                    }
                    if (this.f16686c == null) {
                        c.a.p0.n4.i.d.a aVar = new c.a.p0.n4.i.d.a(this.a.getActivity());
                        this.f16686c = aVar;
                        aVar.i(this);
                    }
                    this.f16686c.g(str, this.f16685b.f16590f);
                    return;
                }
                c.a.p0.n4.b bVar4 = this.f16685b;
                if (bVar4 != null) {
                    bVar4.e();
                }
                a(str);
            }
        }
    }

    @Override // c.a.p0.n4.i.b
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
        }
    }
}
