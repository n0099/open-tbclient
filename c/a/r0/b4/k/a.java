package c.a.r0.b4.k;

import android.text.TextUtils;
import c.a.r0.p0.c.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.view.cloudmusic.MusicPlayer;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f16280a;

    /* renamed from: b  reason: collision with root package name */
    public final f f16281b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f16282c;

    /* renamed from: c.a.r0.b4.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0777a implements c.a.r0.b4.k.j.a<CloudMusicData.MusicTagList> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16283a;

        public C0777a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16283a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b4.k.j.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicTagList) == null) {
                this.f16283a.f16281b.displayLoadingMore(false);
                if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    this.f16283a.f16281b.displayNoDataView(false);
                    this.f16283a.f16281b.showMusicListData(musicTagList);
                } else {
                    this.f16283a.f16281b.displayNoDataView(true);
                }
                if (musicTagList.page.has_more == 0) {
                    this.f16283a.f16281b.displayNoMore();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f16284a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16285b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f16286c;

        /* renamed from: c.a.r0.b4.k.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0778a implements MusicPlayer.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f16287a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f16288b;

            public C0778a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16288b = bVar;
                this.f16287a = str;
            }

            @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16288b.f16286c.f16282c.f();
                    if (this.f16287a.startsWith("/")) {
                        File file = new File(this.f16287a);
                        if (file.exists()) {
                            file.delete();
                        }
                        c.a.r0.p0.c.d.a.h().e();
                        b bVar = this.f16288b;
                        bVar.f16286c.a(bVar.f16284a, bVar.f16285b);
                    }
                }
            }
        }

        public b(a aVar, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, musicList, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16286c = aVar;
            this.f16284a = musicList;
            this.f16285b = i2;
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f16286c.f16281b.downloadError(this.f16285b);
            }
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f16286c.f16281b.downloadCancel(this.f16285b);
            }
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f16286c.f16282c.e(str, this.f16284a, new C0778a(this, str));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MusicPlayer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16289a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f16290b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f16291c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f16292d;

        public c(a aVar, String str, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, musicList, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16292d = aVar;
            this.f16289a = str;
            this.f16290b = musicList;
            this.f16291c = i2;
        }

        @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16292d.f16282c.f();
                if (this.f16289a.startsWith("/")) {
                    File file = new File(this.f16289a);
                    if (file.exists()) {
                        file.delete();
                    }
                    c.a.r0.p0.c.d.a.h().e();
                    this.f16292d.a(this.f16290b, this.f16291c);
                }
            }
        }
    }

    public a(CloudMusicListModel cloudMusicListModel, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cloudMusicListModel, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16280a = cloudMusicListModel;
        this.f16281b = fVar;
        fVar.setPresenter(this);
        this.f16282c = MusicPlayer.c();
    }

    @Override // c.a.r0.b4.k.e
    public void a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, musicList, i2) == null) || musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = c.a.r0.p0.c.d.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f16281b.showMusicLoading(i2);
            c.a.r0.p0.c.d.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(this, musicList, i2));
            return;
        }
        this.f16282c.e(g2, musicList, new c(this, g2, musicList, i2));
    }

    @Override // c.a.r0.b4.k.e
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16280a.A();
        }
    }

    @Override // c.a.r0.b4.k.e
    public void c(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, musicTagList) == null) {
            if (ListUtils.isEmpty(musicTagList.music_list)) {
                this.f16281b.displayNoDataView(true);
            } else {
                this.f16281b.displayNoDataView(false);
                this.f16281b.showMusicListData(musicTagList);
            }
            if (musicTagList.page.has_more == 0) {
                this.f16281b.displayNoMore();
            }
        }
    }

    @Override // c.a.r0.b4.k.e
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16280a.cancelLoadData();
        }
    }

    @Override // c.a.r0.b4.k.e
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f16281b.displayLoadingMore(true);
            this.f16280a.y(i2, new C0777a(this));
        }
    }
}
