package b.a.r0.d4.k;

import android.text.TextUtils;
import b.a.r0.q0.c.d.a;
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
/* loaded from: classes4.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f17086a;

    /* renamed from: b  reason: collision with root package name */
    public final f f17087b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f17088c;

    /* renamed from: b.a.r0.d4.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0857a implements b.a.r0.d4.k.j.a<CloudMusicData.MusicTagList> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17089a;

        public C0857a(a aVar) {
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
            this.f17089a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.d4.k.j.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicTagList) == null) {
                this.f17089a.f17087b.displayLoadingMore(false);
                if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    this.f17089a.f17087b.displayNoDataView(false);
                    this.f17089a.f17087b.showMusicListData(musicTagList);
                } else {
                    this.f17089a.f17087b.displayNoDataView(true);
                }
                if (musicTagList.page.has_more == 0) {
                    this.f17089a.f17087b.displayNoMore();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f17090a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f17091b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f17092c;

        /* renamed from: b.a.r0.d4.k.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0858a implements MusicPlayer.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17093a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f17094b;

            public C0858a(b bVar, String str) {
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
                this.f17094b = bVar;
                this.f17093a = str;
            }

            @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17094b.f17092c.f17088c.f();
                    if (this.f17093a.startsWith("/")) {
                        File file = new File(this.f17093a);
                        if (file.exists()) {
                            file.delete();
                        }
                        b.a.r0.q0.c.d.a.h().e();
                        b bVar = this.f17094b;
                        bVar.f17092c.a(bVar.f17090a, bVar.f17091b);
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
            this.f17092c = aVar;
            this.f17090a = musicList;
            this.f17091b = i2;
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f17092c.f17087b.downloadError(this.f17091b);
            }
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f17092c.f17087b.downloadCancel(this.f17091b);
            }
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f17092c.f17088c.e(str, this.f17090a, new C0858a(this, str));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MusicPlayer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17095a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f17096b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f17097c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f17098d;

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
            this.f17098d = aVar;
            this.f17095a = str;
            this.f17096b = musicList;
            this.f17097c = i2;
        }

        @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17098d.f17088c.f();
                if (this.f17095a.startsWith("/")) {
                    File file = new File(this.f17095a);
                    if (file.exists()) {
                        file.delete();
                    }
                    b.a.r0.q0.c.d.a.h().e();
                    this.f17098d.a(this.f17096b, this.f17097c);
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
        this.f17086a = cloudMusicListModel;
        this.f17087b = fVar;
        fVar.setPresenter(this);
        this.f17088c = MusicPlayer.c();
    }

    @Override // b.a.r0.d4.k.e
    public void a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, musicList, i2) == null) || musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = b.a.r0.q0.c.d.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f17087b.showMusicLoading(i2);
            b.a.r0.q0.c.d.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(this, musicList, i2));
            return;
        }
        this.f17088c.e(g2, musicList, new c(this, g2, musicList, i2));
    }

    @Override // b.a.r0.d4.k.e
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f17086a.A();
        }
    }

    @Override // b.a.r0.d4.k.e
    public void c(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, musicTagList) == null) {
            if (ListUtils.isEmpty(musicTagList.music_list)) {
                this.f17087b.displayNoDataView(true);
            } else {
                this.f17087b.displayNoDataView(false);
                this.f17087b.showMusicListData(musicTagList);
            }
            if (musicTagList.page.has_more == 0) {
                this.f17087b.displayNoMore();
            }
        }
    }

    @Override // b.a.r0.d4.k.e
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17086a.cancelLoadData();
        }
    }

    @Override // b.a.r0.d4.k.e
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f17087b.displayLoadingMore(true);
            this.f17086a.y(i2, new C0857a(this));
        }
    }
}
