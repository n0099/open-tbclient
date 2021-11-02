package b.a.r0.c4.k;

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
    public final CloudMusicListModel f15454a;

    /* renamed from: b  reason: collision with root package name */
    public final f f15455b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f15456c;

    /* renamed from: b.a.r0.c4.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0780a implements b.a.r0.c4.k.j.a<CloudMusicData.MusicTagList> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f15457a;

        public C0780a(a aVar) {
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
            this.f15457a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.c4.k.j.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicTagList) == null) {
                this.f15457a.f15455b.displayLoadingMore(false);
                if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    this.f15457a.f15455b.displayNoDataView(false);
                    this.f15457a.f15455b.showMusicListData(musicTagList);
                } else {
                    this.f15457a.f15455b.displayNoDataView(true);
                }
                if (musicTagList.page.has_more == 0) {
                    this.f15457a.f15455b.displayNoMore();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f15458a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f15459b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f15460c;

        /* renamed from: b.a.r0.c4.k.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0781a implements MusicPlayer.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f15461a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f15462b;

            public C0781a(b bVar, String str) {
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
                this.f15462b = bVar;
                this.f15461a = str;
            }

            @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f15462b.f15460c.f15456c.f();
                    if (this.f15461a.startsWith("/")) {
                        File file = new File(this.f15461a);
                        if (file.exists()) {
                            file.delete();
                        }
                        b.a.r0.q0.c.d.a.h().e();
                        b bVar = this.f15462b;
                        bVar.f15460c.a(bVar.f15458a, bVar.f15459b);
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
            this.f15460c = aVar;
            this.f15458a = musicList;
            this.f15459b = i2;
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f15460c.f15455b.downloadError(this.f15459b);
            }
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f15460c.f15455b.downloadCancel(this.f15459b);
            }
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f15460c.f15456c.e(str, this.f15458a, new C0781a(this, str));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MusicPlayer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f15463a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f15464b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f15465c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f15466d;

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
            this.f15466d = aVar;
            this.f15463a = str;
            this.f15464b = musicList;
            this.f15465c = i2;
        }

        @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15466d.f15456c.f();
                if (this.f15463a.startsWith("/")) {
                    File file = new File(this.f15463a);
                    if (file.exists()) {
                        file.delete();
                    }
                    b.a.r0.q0.c.d.a.h().e();
                    this.f15466d.a(this.f15464b, this.f15465c);
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
        this.f15454a = cloudMusicListModel;
        this.f15455b = fVar;
        fVar.setPresenter(this);
        this.f15456c = MusicPlayer.c();
    }

    @Override // b.a.r0.c4.k.e
    public void a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, musicList, i2) == null) || musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = b.a.r0.q0.c.d.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f15455b.showMusicLoading(i2);
            b.a.r0.q0.c.d.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(this, musicList, i2));
            return;
        }
        this.f15456c.e(g2, musicList, new c(this, g2, musicList, i2));
    }

    @Override // b.a.r0.c4.k.e
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f15454a.A();
        }
    }

    @Override // b.a.r0.c4.k.e
    public void c(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, musicTagList) == null) {
            if (ListUtils.isEmpty(musicTagList.music_list)) {
                this.f15455b.displayNoDataView(true);
            } else {
                this.f15455b.displayNoDataView(false);
                this.f15455b.showMusicListData(musicTagList);
            }
            if (musicTagList.page.has_more == 0) {
                this.f15455b.displayNoMore();
            }
        }
    }

    @Override // b.a.r0.c4.k.e
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15454a.cancelLoadData();
        }
    }

    @Override // b.a.r0.c4.k.e
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f15455b.displayLoadingMore(true);
            this.f15454a.y(i2, new C0780a(this));
        }
    }
}
