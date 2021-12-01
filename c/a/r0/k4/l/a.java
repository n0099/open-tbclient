package c.a.r0.k4.l;

import android.text.TextUtils;
import c.a.r0.w0.c.d.a;
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
/* loaded from: classes6.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CloudMusicListModel a;

    /* renamed from: b  reason: collision with root package name */
    public final f f18959b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f18960c;

    /* renamed from: c.a.r0.k4.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1120a implements c.a.r0.k4.l.j.a<CloudMusicData.MusicTagList> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1120a(a aVar) {
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.k4.l.j.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicTagList) == null) {
                this.a.f18959b.displayLoadingMore(false);
                if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    this.a.f18959b.displayNoDataView(false);
                    this.a.f18959b.showMusicListData(musicTagList);
                } else {
                    this.a.f18959b.displayNoDataView(true);
                }
                if (musicTagList.page.has_more == 0) {
                    this.a.f18959b.displayNoMore();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18961b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f18962c;

        /* renamed from: c.a.r0.k4.l.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1121a implements MusicPlayer.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f18963b;

            public C1121a(b bVar, String str) {
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
                this.f18963b = bVar;
                this.a = str;
            }

            @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f18963b.f18962c.f18960c.f();
                    if (this.a.startsWith("/")) {
                        File file = new File(this.a);
                        if (file.exists()) {
                            file.delete();
                        }
                        c.a.r0.w0.c.d.a.h().e();
                        b bVar = this.f18963b;
                        bVar.f18962c.a(bVar.a, bVar.f18961b);
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
            this.f18962c = aVar;
            this.a = musicList;
            this.f18961b = i2;
        }

        @Override // c.a.r0.w0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f18962c.f18959b.downloadError(this.f18961b);
            }
        }

        @Override // c.a.r0.w0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f18962c.f18959b.downloadCancel(this.f18961b);
            }
        }

        @Override // c.a.r0.w0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f18962c.f18960c.e(str, this.a, new C1121a(this, str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements MusicPlayer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f18964b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f18965c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f18966d;

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
            this.f18966d = aVar;
            this.a = str;
            this.f18964b = musicList;
            this.f18965c = i2;
        }

        @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18966d.f18960c.f();
                if (this.a.startsWith("/")) {
                    File file = new File(this.a);
                    if (file.exists()) {
                        file.delete();
                    }
                    c.a.r0.w0.c.d.a.h().e();
                    this.f18966d.a(this.f18964b, this.f18965c);
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
        this.a = cloudMusicListModel;
        this.f18959b = fVar;
        fVar.setPresenter(this);
        this.f18960c = MusicPlayer.c();
    }

    @Override // c.a.r0.k4.l.e
    public void a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, musicList, i2) == null) || musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = c.a.r0.w0.c.d.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f18959b.showMusicLoading(i2);
            c.a.r0.w0.c.d.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(this, musicList, i2));
            return;
        }
        this.f18960c.e(g2, musicList, new c(this, g2, musicList, i2));
    }

    @Override // c.a.r0.k4.l.e
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.A();
        }
    }

    @Override // c.a.r0.k4.l.e
    public void c(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, musicTagList) == null) {
            if (ListUtils.isEmpty(musicTagList.music_list)) {
                this.f18959b.displayNoDataView(true);
            } else {
                this.f18959b.displayNoDataView(false);
                this.f18959b.showMusicListData(musicTagList);
            }
            if (musicTagList.page.has_more == 0) {
                this.f18959b.displayNoMore();
            }
        }
    }

    @Override // c.a.r0.k4.l.e
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.cancelLoadData();
        }
    }

    @Override // c.a.r0.k4.l.e
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f18959b.displayLoadingMore(true);
            this.a.y(i2, new C1120a(this));
        }
    }
}
