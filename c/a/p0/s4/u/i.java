package c.a.p0.s4.u;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import c.a.p0.s4.u.h;
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
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.tieba.write.write.WriteImageGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<WriteActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f18506b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f18507c;

    /* renamed from: d  reason: collision with root package name */
    public h f18508d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.c0.b f18509e;

    /* renamed from: f  reason: collision with root package name */
    public String f18510f;

    /* renamed from: g  reason: collision with root package name */
    public String f18511g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18512h;
    public h.f i;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // c.a.p0.s4.u.h.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.f18507c == null || this.a.f18507c.getChosedFiles() == null || i < 0 || i >= this.a.f18507c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.a.f18507c.getChosedFiles().remove(i);
            if (remove.isTempFile()) {
                c.a.d.f.a.d.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = this.a;
            iVar.f18508d.f(iVar.f18507c);
            this.a.f18508d.notifyDataSetChanged();
            if (ListUtils.isEmpty(this.a.f18507c.getChosedFiles()) && this.a.a.getOrignalPage() != null) {
                ((WriteActivity) this.a.a.getOrignalPage()).refreshPostButton();
                ((WriteActivity) this.a.a.getOrignalPage()).changeAssociatedItemContainerLayoutParams(false);
                this.a.f18506b.setVisibility(8);
            }
            if (this.a.a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) this.a.a.getPageActivity()).refreshImageLauncher();
                ((WriteActivity) this.a.a.getPageActivity()).refreshVideoLauncher();
            }
        }

        @Override // c.a.p0.s4.u.h.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f18507c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.a.getPageActivity(), this.a.f18507c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.a.f18511g);
            albumFloatActivityConfig.getIntent().putExtra("from", this.a.f18510f);
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

        @Override // c.a.p0.s4.u.h.f
        public void c(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a.f18507c == null || (count = ListUtils.getCount(this.a.f18507c.getChosedFiles())) == 0 || i < 0 || i >= count || (imageInfoAt = this.a.f18507c.getImageInfoAt(i)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            this.a.a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.a.getPageActivity(), 12012, this.a.f18507c, i)));
        }
    }

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18509e = new c.a.o0.c0.b();
        this.f18510f = AlbumActivityConfig.FROM_WRITE;
        this.f18511g = "";
        this.i = new a(this);
        this.a = tbPageContext;
        this.f18506b = (WriteImageGridView) view.findViewById(R.id.obfuscated_res_0x7f0924a0);
        h hVar = new h(view.getContext(), this.f18509e, null, this.i);
        this.f18508d = hVar;
        this.f18506b.setAdapter((ListAdapter) hVar);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18509e.b();
        }
    }

    public GridView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18506b : (GridView) invokeV.objValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f18512h = z;
            l();
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f18508d.g(z);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f18508d.h(z);
        }
    }

    public void k(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, writeImagesInfo, str, str2) == null) {
            this.f18510f = str;
            this.f18511g = str2;
            this.f18507c = writeImagesInfo;
            this.f18508d.f(writeImagesInfo);
            this.f18508d.notifyDataSetChanged();
            l();
        }
    }

    public final void l() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!this.f18512h && (writeImagesInfo = this.f18507c) != null && writeImagesInfo.getChosedFiles() != null) {
                this.f18506b.setVisibility(0);
            } else {
                this.f18506b.setVisibility(8);
            }
        }
    }
}
