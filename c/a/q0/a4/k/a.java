package c.a.q0.a4.k;

import android.text.TextUtils;
import c.a.q0.o0.c.d.a;
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
    public final CloudMusicListModel f15737a;

    /* renamed from: b  reason: collision with root package name */
    public final f f15738b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f15739c;

    /* renamed from: c.a.q0.a4.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0743a implements c.a.q0.a4.k.j.a<CloudMusicData.MusicTagList> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f15740a;

        public C0743a(a aVar) {
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
            this.f15740a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a4.k.j.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicTagList) == null) {
                this.f15740a.f15738b.displayLoadingMore(false);
                if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                    this.f15740a.f15738b.displayNoDataView(false);
                    this.f15740a.f15738b.showMusicListData(musicTagList);
                } else {
                    this.f15740a.f15738b.displayNoDataView(true);
                }
                if (musicTagList.page.has_more == 0) {
                    this.f15740a.f15738b.displayNoMore();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f15741a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f15742b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f15743c;

        /* renamed from: c.a.q0.a4.k.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0744a implements MusicPlayer.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f15744a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f15745b;

            public C0744a(b bVar, String str) {
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
                this.f15745b = bVar;
                this.f15744a = str;
            }

            @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f15745b.f15743c.f15739c.f();
                    if (this.f15744a.startsWith("/")) {
                        File file = new File(this.f15744a);
                        if (file.exists()) {
                            file.delete();
                        }
                        c.a.q0.o0.c.d.a.h().e();
                        b bVar = this.f15745b;
                        bVar.f15743c.a(bVar.f15741a, bVar.f15742b);
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
            this.f15743c = aVar;
            this.f15741a = musicList;
            this.f15742b = i2;
        }

        @Override // c.a.q0.o0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f15743c.f15738b.downloadError(this.f15742b);
            }
        }

        @Override // c.a.q0.o0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f15743c.f15738b.downloadCancel(this.f15742b);
            }
        }

        @Override // c.a.q0.o0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f15743c.f15739c.e(str, this.f15741a, new C0744a(this, str));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MusicPlayer.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f15746a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f15747b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f15748c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f15749d;

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
            this.f15749d = aVar;
            this.f15746a = str;
            this.f15747b = musicList;
            this.f15748c = i2;
        }

        @Override // com.baidu.tieba.view.cloudmusic.MusicPlayer.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15749d.f15739c.f();
                if (this.f15746a.startsWith("/")) {
                    File file = new File(this.f15746a);
                    if (file.exists()) {
                        file.delete();
                    }
                    c.a.q0.o0.c.d.a.h().e();
                    this.f15749d.a(this.f15747b, this.f15748c);
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
        this.f15737a = cloudMusicListModel;
        this.f15738b = fVar;
        fVar.setPresenter(this);
        this.f15739c = MusicPlayer.c();
    }

    @Override // c.a.q0.a4.k.e
    public void a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, musicList, i2) == null) || musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = c.a.q0.o0.c.d.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f15738b.showMusicLoading(i2);
            c.a.q0.o0.c.d.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(this, musicList, i2));
            return;
        }
        this.f15739c.e(g2, musicList, new c(this, g2, musicList, i2));
    }

    @Override // c.a.q0.a4.k.e
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f15737a.A();
        }
    }

    @Override // c.a.q0.a4.k.e
    public void c(CloudMusicData.MusicTagList musicTagList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, musicTagList) == null) {
            if (ListUtils.isEmpty(musicTagList.music_list)) {
                this.f15738b.displayNoDataView(true);
            } else {
                this.f15738b.displayNoDataView(false);
                this.f15738b.showMusicListData(musicTagList);
            }
            if (musicTagList.page.has_more == 0) {
                this.f15738b.displayNoMore();
            }
        }
    }

    @Override // c.a.q0.a4.k.e
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15737a.cancelLoadData();
        }
    }

    @Override // c.a.q0.a4.k.e
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f15738b.displayLoadingMore(true);
            this.f15737a.y(i2, new C0743a(this));
        }
    }
}
