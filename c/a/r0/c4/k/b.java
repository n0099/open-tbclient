package c.a.r0.c4.k;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicModel f16455a;

    /* renamed from: b  reason: collision with root package name */
    public final d f16456b;

    /* loaded from: classes3.dex */
    public class a implements c.a.r0.c4.k.j.a<CloudMusicData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16457a;

        public a(b bVar) {
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
            this.f16457a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.c4.k.j.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cloudMusicData) == null) {
                this.f16457a.f16456b.displayLoading(false);
                if (cloudMusicData != null) {
                    this.f16457a.f16456b.displayNoDataView(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        this.f16457a.f16456b.displayNoDataView(true);
                        return;
                    } else {
                        this.f16457a.f16456b.showCloudMusicWithTagData(cloudMusicData);
                        return;
                    }
                }
                this.f16457a.f16456b.displayNoDataView(true);
            }
        }
    }

    public b(CloudMusicModel cloudMusicModel, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cloudMusicModel, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16455a = cloudMusicModel;
        this.f16456b = dVar;
        dVar.setPresenter(this);
    }

    @Override // c.a.r0.c4.k.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16456b.displayLoading(true);
            this.f16455a.x(new a(this));
        }
    }

    @Override // c.a.r0.c4.k.c
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16455a.cancelLoadData();
        }
    }
}
