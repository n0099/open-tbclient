package c.a.r0.c4.k;

import android.text.TextUtils;
import c.a.r0.q0.c.d.a;
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
    public final CloudMusicListModel f16442a;

    /* renamed from: b  reason: collision with root package name */
    public final f f16443b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f16444c;

    /* renamed from: c.a.r0.c4.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0785a implements c.a.r0.c4.k.j.a<CloudMusicData.MusicTagList> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16445a;

        public C0785a(a aVar) {
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
            this.f16445a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.c4.k.j.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicTagList) == null) {
                this.f16445a.f16443b.displayLoadingMore(false);
                if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    this.f16445a.f16443b.displayNoDataView(false);
                    this.f16445a.f16443b.showMusicListData(musicTagList);
                } else {
                    this.f16445a.f16443b.displayNoDataView(true);
                }
                if (musicTagList.page.has_more == 0) {
                    this.f16445a.f16443b.displayNoMore();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f16446a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16447b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f16448c;

        /* renamed from: c.a.r0.c4.k.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0786a implements MusicPlayer.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f16449a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f16450b;

            public C0786a(b bVar, String str) {
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
                this.f16450b = bVar;
                this.f16449a = str;
            }

            @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16450b.f16448c.f16444c.f();
                    if (this.f16449a.startsWith("/")) {
                        File file = new File(this.f16449a);
                        if (file.exists()) {
                            file.delete();
                        }
                        c.a.r0.q0.c.d.a.h().e();
                        b bVar = this.f16450b;
                        bVar.f16448c.a(bVar.f16446a, bVar.f16447b);
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
            this.f16448c = aVar;
            this.f16446a = musicList;
            this.f16447b = i2;
        }

        @Override // c.a.r0.q0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f16448c.f16443b.downloadError(this.f16447b);
            }
        }

        @Override // c.a.r0.q0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f16448c.f16443b.downloadCancel(this.f16447b);
            }
        }

        @Override // c.a.r0.q0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f16448c.f16444c.e(str, this.f16446a, new C0786a(this, str));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MusicPlayer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16451a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f16452b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f16453c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f16454d;

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
            this.f16454d = aVar;
            this.f16451a = str;
            this.f16452b = musicList;
            this.f16453c = i2;
        }

        @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16454d.f16444c.f();
                if (this.f16451a.startsWith("/")) {
                    File file = new File(this.f16451a);
                    if (file.exists()) {
                        file.delete();
                    }
                    c.a.r0.q0.c.d.a.h().e();
                    this.f16454d.a(this.f16452b, this.f16453c);
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
        this.f16442a = cloudMusicListModel;
        this.f16443b = fVar;
        fVar.setPresenter(this);
        this.f16444c = MusicPlayer.c();
    }

    @Override // c.a.r0.c4.k.e
    public void a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, musicList, i2) == null) || musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = c.a.r0.q0.c.d.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f16443b.showMusicLoading(i2);
            c.a.r0.q0.c.d.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(this, musicList, i2));
            return;
        }
        this.f16444c.e(g2, musicList, new c(this, g2, musicList, i2));
    }

    @Override // c.a.r0.c4.k.e
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16442a.A();
        }
    }

    @Override // c.a.r0.c4.k.e
    public void c(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, musicTagList) == null) {
            if (ListUtils.isEmpty(musicTagList.music_list)) {
                this.f16443b.displayNoDataView(true);
            } else {
                this.f16443b.displayNoDataView(false);
                this.f16443b.showMusicListData(musicTagList);
            }
            if (musicTagList.page.has_more == 0) {
                this.f16443b.displayNoMore();
            }
        }
    }

    @Override // c.a.r0.c4.k.e
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16442a.cancelLoadData();
        }
    }

    @Override // c.a.r0.c4.k.e
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f16443b.displayLoadingMore(true);
            this.f16442a.y(i2, new C0785a(this));
        }
    }
}
