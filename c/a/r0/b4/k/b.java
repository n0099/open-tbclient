package c.a.r0.b4.k;

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
    public final CloudMusicModel f16293a;

    /* renamed from: b  reason: collision with root package name */
    public final d f16294b;

    /* loaded from: classes3.dex */
    public class a implements c.a.r0.b4.k.j.a<CloudMusicData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16295a;

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
            this.f16295a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b4.k.j.a
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cloudMusicData) == null) {
                this.f16295a.f16294b.displayLoading(false);
                if (cloudMusicData != null) {
                    this.f16295a.f16294b.displayNoDataView(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        this.f16295a.f16294b.displayNoDataView(true);
                        return;
                    } else {
                        this.f16295a.f16294b.showCloudMusicWithTagData(cloudMusicData);
                        return;
                    }
                }
                this.f16295a.f16294b.displayNoDataView(true);
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
        this.f16293a = cloudMusicModel;
        this.f16294b = dVar;
        dVar.setPresenter(this);
    }

    @Override // c.a.r0.b4.k.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16294b.displayLoading(true);
            this.f16293a.x(new a(this));
        }
    }

    @Override // c.a.r0.b4.k.c
    public void cancelLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16293a.cancelLoadData();
        }
    }
}
