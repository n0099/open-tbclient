package c.a.q0.b4.u;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import c.a.q0.b4.u.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.tieba.write.write.WriteImageGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f16439a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f16440b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f16441c;

    /* renamed from: d  reason: collision with root package name */
    public h f16442d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.c0.b f16443e;

    /* renamed from: f  reason: collision with root package name */
    public String f16444f;

    /* renamed from: g  reason: collision with root package name */
    public String f16445g;

    /* renamed from: h  reason: collision with root package name */
    public h.f f16446h;

    /* loaded from: classes3.dex */
    public class a implements h.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f16447a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16447a = iVar;
        }

        @Override // c.a.q0.b4.u.h.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f16447a.f16441c == null || this.f16447a.f16441c.getChosedFiles() == null || i2 < 0 || i2 >= this.f16447a.f16441c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.f16447a.f16441c.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                c.a.e.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = this.f16447a;
            iVar.f16442d.f(iVar.f16441c);
            this.f16447a.f16442d.notifyDataSetChanged();
            if (ListUtils.isEmpty(this.f16447a.f16441c.getChosedFiles()) && this.f16447a.f16439a.getOrignalPage() != null) {
                ((WriteActivity) this.f16447a.f16439a.getOrignalPage()).refreshPostButton();
            }
            if (this.f16447a.f16439a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) this.f16447a.f16439a.getPageActivity()).refreshImageLauncher();
                ((WriteActivity) this.f16447a.f16439a.getPageActivity()).refreshVideoLauncher();
            }
        }

        @Override // c.a.q0.b4.u.h.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16447a.f16441c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f16447a.f16439a.getPageActivity(), this.f16447a.f16441c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f16447a.f16445g);
            albumFloatActivityConfig.getIntent().putExtra("from", this.f16447a.f16444f);
            albumFloatActivityConfig.setRequestCode(12002);
            if (this.f16447a.f16439a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(false);
                albumFloatActivityConfig.setCanSelectOnlyVideo(false);
                albumFloatActivityConfig.setCanEditImage(false);
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) this.f16447a.f16439a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) this.f16447a.f16439a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) this.f16447a.f16439a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) this.f16447a.f16439a.getPageActivity()).mPrefixData, ((WriteActivity) this.f16447a.f16439a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) this.f16447a.f16439a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // c.a.q0.b4.u.h.f
        public void c(int i2) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f16447a.f16441c == null || (count = ListUtils.getCount(this.f16447a.f16441c.getChosedFiles())) == 0 || i2 < 0 || i2 >= count || (imageInfoAt = this.f16447a.f16441c.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            this.f16447a.f16439a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f16447a.f16439a.getPageActivity(), 12012, this.f16447a.f16441c, i2)));
        }
    }

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16443e = new c.a.p0.c0.b();
        this.f16444f = AlbumActivityConfig.FROM_WRITE;
        this.f16445g = "";
        this.f16446h = new a(this);
        this.f16439a = tbPageContext;
        this.f16440b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f16443e, null, this.f16446h);
        this.f16442d = hVar;
        this.f16440b.setAdapter((ListAdapter) hVar);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16443e.b();
        }
    }

    public GridView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16440b : (GridView) invokeV.objValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f16442d.g(z);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f16442d.h(z);
        }
    }

    public void i(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, writeImagesInfo, str, str2) == null) {
            this.f16444f = str;
            this.f16445g = str2;
            this.f16441c = writeImagesInfo;
            this.f16442d.f(writeImagesInfo);
            this.f16442d.notifyDataSetChanged();
        }
    }
}
