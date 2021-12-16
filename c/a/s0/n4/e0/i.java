package c.a.s0.n4.e0;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import c.a.s0.n4.e0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.tieba.write.write.WriteImageGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<WriteActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f20261b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f20262c;

    /* renamed from: d  reason: collision with root package name */
    public h f20263d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.d0.b f20264e;

    /* renamed from: f  reason: collision with root package name */
    public String f20265f;

    /* renamed from: g  reason: collision with root package name */
    public String f20266g;

    /* renamed from: h  reason: collision with root package name */
    public h.f f20267h;

    /* loaded from: classes7.dex */
    public class a implements h.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

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
            this.a = iVar;
        }

        @Override // c.a.s0.n4.e0.h.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.f20262c == null || this.a.f20262c.getChosedFiles() == null || i2 < 0 || i2 >= this.a.f20262c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.a.f20262c.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                c.a.d.f.a.d.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = this.a;
            iVar.f20263d.f(iVar.f20262c);
            this.a.f20263d.notifyDataSetChanged();
            if (ListUtils.isEmpty(this.a.f20262c.getChosedFiles()) && this.a.a.getOrignalPage() != null) {
                ((WriteActivity) this.a.a.getOrignalPage()).refreshPostButton();
                ((WriteActivity) this.a.a.getOrignalPage()).changeAssociatedItemContainerLayoutParams(false);
                this.a.f20261b.setVisibility(8);
            }
            if (this.a.a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) this.a.a.getPageActivity()).refreshImageLauncher();
                ((WriteActivity) this.a.a.getPageActivity()).refreshVideoLauncher();
            }
        }

        @Override // c.a.s0.n4.e0.h.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f20262c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.a.getPageActivity(), this.a.f20262c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.a.f20266g);
            albumFloatActivityConfig.getIntent().putExtra("from", this.a.f20265f);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            if (this.a.a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(false);
                albumFloatActivityConfig.setCanSelectOnlyVideo(false);
                albumFloatActivityConfig.setCanEditImage(false);
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) this.a.a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) this.a.a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) this.a.a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) this.a.a.getPageActivity()).mPrefixData, ((WriteActivity) this.a.a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) this.a.a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // c.a.s0.n4.e0.h.f
        public void c(int i2) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.a.f20262c == null || (count = ListUtils.getCount(this.a.f20262c.getChosedFiles())) == 0 || i2 < 0 || i2 >= count || (imageInfoAt = this.a.f20262c.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            this.a.a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.a.getPageActivity(), 12012, this.a.f20262c, i2)));
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
        this.f20264e = new c.a.r0.d0.b();
        this.f20265f = AlbumActivityConfig.FROM_WRITE;
        this.f20266g = "";
        this.f20267h = new a(this);
        this.a = tbPageContext;
        this.f20261b = (WriteImageGridView) view.findViewById(c.a.s0.n4.g.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f20264e, null, this.f20267h);
        this.f20263d = hVar;
        this.f20261b.setAdapter((ListAdapter) hVar);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f20264e.b();
        }
    }

    public GridView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20261b : (GridView) invokeV.objValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f20263d.g(z);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f20263d.h(z);
        }
    }

    public void j(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, writeImagesInfo, str, str2) == null) {
            this.f20265f = str;
            this.f20266g = str2;
            this.f20262c = writeImagesInfo;
            this.f20263d.f(writeImagesInfo);
            this.f20263d.notifyDataSetChanged();
            WriteImagesInfo writeImagesInfo2 = this.f20262c;
            if (writeImagesInfo2 == null || writeImagesInfo2.getChosedFiles() == null || this.f20261b.getVisibility() != 8) {
                return;
            }
            this.f20261b.setVisibility(0);
        }
    }
}
