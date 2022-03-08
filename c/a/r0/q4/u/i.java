package c.a.r0.q4.u;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import c.a.r0.q4.u.h;
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
    public WriteImageGridView f21439b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f21440c;

    /* renamed from: d  reason: collision with root package name */
    public h f21441d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.c0.b f21442e;

    /* renamed from: f  reason: collision with root package name */
    public String f21443f;

    /* renamed from: g  reason: collision with root package name */
    public String f21444g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21445h;

    /* renamed from: i  reason: collision with root package name */
    public h.f f21446i;

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

        @Override // c.a.r0.q4.u.h.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.f21440c == null || this.a.f21440c.getChosedFiles() == null || i2 < 0 || i2 >= this.a.f21440c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.a.f21440c.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                c.a.d.f.a.d.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = this.a;
            iVar.f21441d.f(iVar.f21440c);
            this.a.f21441d.notifyDataSetChanged();
            if (ListUtils.isEmpty(this.a.f21440c.getChosedFiles()) && this.a.a.getOrignalPage() != null) {
                ((WriteActivity) this.a.a.getOrignalPage()).refreshPostButton();
                ((WriteActivity) this.a.a.getOrignalPage()).changeAssociatedItemContainerLayoutParams(false);
                this.a.f21439b.setVisibility(8);
            }
            if (this.a.a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) this.a.a.getPageActivity()).refreshImageLauncher();
                ((WriteActivity) this.a.a.getPageActivity()).refreshVideoLauncher();
            }
        }

        @Override // c.a.r0.q4.u.h.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f21440c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.a.getPageActivity(), this.a.f21440c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.a.f21444g);
            albumFloatActivityConfig.getIntent().putExtra("from", this.a.f21443f);
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

        @Override // c.a.r0.q4.u.h.f
        public void c(int i2) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.a.f21440c == null || (count = ListUtils.getCount(this.a.f21440c.getChosedFiles())) == 0 || i2 < 0 || i2 >= count || (imageInfoAt = this.a.f21440c.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            this.a.a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.a.getPageActivity(), 12012, this.a.f21440c, i2)));
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
        this.f21442e = new c.a.q0.c0.b();
        this.f21443f = AlbumActivityConfig.FROM_WRITE;
        this.f21444g = "";
        this.f21446i = new a(this);
        this.a = tbPageContext;
        this.f21439b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f21442e, null, this.f21446i);
        this.f21441d = hVar;
        this.f21439b.setAdapter((ListAdapter) hVar);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21442e.b();
        }
    }

    public GridView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21439b : (GridView) invokeV.objValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f21445h = z;
            l();
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f21441d.g(z);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f21441d.h(z);
        }
    }

    public void k(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, writeImagesInfo, str, str2) == null) {
            this.f21443f = str;
            this.f21444g = str2;
            this.f21440c = writeImagesInfo;
            this.f21441d.f(writeImagesInfo);
            this.f21441d.notifyDataSetChanged();
            l();
        }
    }

    public final void l() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!this.f21445h && (writeImagesInfo = this.f21440c) != null && writeImagesInfo.getChosedFiles() != null) {
                this.f21439b.setVisibility(0);
            } else {
                this.f21439b.setVisibility(8);
            }
        }
    }
}
