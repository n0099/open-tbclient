package b.a.r0.e4.u;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import b.a.r0.e4.u.h;
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
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f17735a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f17736b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f17737c;

    /* renamed from: d  reason: collision with root package name */
    public h f17738d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.d0.b f17739e;

    /* renamed from: f  reason: collision with root package name */
    public String f17740f;

    /* renamed from: g  reason: collision with root package name */
    public String f17741g;

    /* renamed from: h  reason: collision with root package name */
    public h.f f17742h;

    /* loaded from: classes4.dex */
    public class a implements h.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f17743a;

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
            this.f17743a = iVar;
        }

        @Override // b.a.r0.e4.u.h.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f17743a.f17737c == null || this.f17743a.f17737c.getChosedFiles() == null || i2 < 0 || i2 >= this.f17743a.f17737c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.f17743a.f17737c.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                b.a.e.f.a.d.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = this.f17743a;
            iVar.f17738d.f(iVar.f17737c);
            this.f17743a.f17738d.notifyDataSetChanged();
            if (ListUtils.isEmpty(this.f17743a.f17737c.getChosedFiles()) && this.f17743a.f17735a.getOrignalPage() != null) {
                ((WriteActivity) this.f17743a.f17735a.getOrignalPage()).refreshPostButton();
                ((WriteActivity) this.f17743a.f17735a.getOrignalPage()).changeAssociatedItemContainerLayoutParams(false);
                this.f17743a.f17736b.setVisibility(8);
            }
            if (this.f17743a.f17735a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) this.f17743a.f17735a.getPageActivity()).refreshImageLauncher();
                ((WriteActivity) this.f17743a.f17735a.getPageActivity()).refreshVideoLauncher();
            }
        }

        @Override // b.a.r0.e4.u.h.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17743a.f17737c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f17743a.f17735a.getPageActivity(), this.f17743a.f17737c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f17743a.f17741g);
            albumFloatActivityConfig.getIntent().putExtra("from", this.f17743a.f17740f);
            albumFloatActivityConfig.setRequestCode(12002);
            if (this.f17743a.f17735a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(false);
                albumFloatActivityConfig.setCanSelectOnlyVideo(false);
                albumFloatActivityConfig.setCanEditImage(false);
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) this.f17743a.f17735a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) this.f17743a.f17735a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) this.f17743a.f17735a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) this.f17743a.f17735a.getPageActivity()).mPrefixData, ((WriteActivity) this.f17743a.f17735a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) this.f17743a.f17735a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // b.a.r0.e4.u.h.f
        public void c(int i2) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f17743a.f17737c == null || (count = ListUtils.getCount(this.f17743a.f17737c.getChosedFiles())) == 0 || i2 < 0 || i2 >= count || (imageInfoAt = this.f17743a.f17737c.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            this.f17743a.f17735a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f17743a.f17735a.getPageActivity(), 12012, this.f17743a.f17737c, i2)));
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
        this.f17739e = new b.a.q0.d0.b();
        this.f17740f = AlbumActivityConfig.FROM_WRITE;
        this.f17741g = "";
        this.f17742h = new a(this);
        this.f17735a = tbPageContext;
        this.f17736b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f17739e, null, this.f17742h);
        this.f17738d = hVar;
        this.f17736b.setAdapter((ListAdapter) hVar);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17739e.b();
        }
    }

    public GridView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17736b : (GridView) invokeV.objValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f17738d.g(z);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f17738d.h(z);
        }
    }

    public void j(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, writeImagesInfo, str, str2) == null) {
            this.f17740f = str;
            this.f17741g = str2;
            this.f17737c = writeImagesInfo;
            this.f17738d.f(writeImagesInfo);
            this.f17738d.notifyDataSetChanged();
            WriteImagesInfo writeImagesInfo2 = this.f17737c;
            if (writeImagesInfo2 == null || writeImagesInfo2.getChosedFiles() == null || this.f17736b.getVisibility() != 8) {
                return;
            }
            this.f17736b.setVisibility(0);
        }
    }
}
