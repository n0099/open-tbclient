package b.a.r0.d4.u;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import b.a.r0.d4.u.h;
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
    public TbPageContext<WriteActivity> f16123a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f16124b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f16125c;

    /* renamed from: d  reason: collision with root package name */
    public h f16126d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.d0.b f16127e;

    /* renamed from: f  reason: collision with root package name */
    public String f16128f;

    /* renamed from: g  reason: collision with root package name */
    public String f16129g;

    /* renamed from: h  reason: collision with root package name */
    public h.f f16130h;

    /* loaded from: classes4.dex */
    public class a implements h.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f16131a;

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
            this.f16131a = iVar;
        }

        @Override // b.a.r0.d4.u.h.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f16131a.f16125c == null || this.f16131a.f16125c.getChosedFiles() == null || i2 < 0 || i2 >= this.f16131a.f16125c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.f16131a.f16125c.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                b.a.e.e.a.d.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = this.f16131a;
            iVar.f16126d.f(iVar.f16125c);
            this.f16131a.f16126d.notifyDataSetChanged();
            if (ListUtils.isEmpty(this.f16131a.f16125c.getChosedFiles()) && this.f16131a.f16123a.getOrignalPage() != null) {
                ((WriteActivity) this.f16131a.f16123a.getOrignalPage()).refreshPostButton();
                ((WriteActivity) this.f16131a.f16123a.getOrignalPage()).changeAssociatedItemContainerLayoutParams(false);
                this.f16131a.f16124b.setVisibility(8);
            }
            if (this.f16131a.f16123a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) this.f16131a.f16123a.getPageActivity()).refreshImageLauncher();
                ((WriteActivity) this.f16131a.f16123a.getPageActivity()).refreshVideoLauncher();
            }
        }

        @Override // b.a.r0.d4.u.h.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16131a.f16125c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f16131a.f16123a.getPageActivity(), this.f16131a.f16125c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f16131a.f16129g);
            albumFloatActivityConfig.getIntent().putExtra("from", this.f16131a.f16128f);
            albumFloatActivityConfig.setRequestCode(12002);
            if (this.f16131a.f16123a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(false);
                albumFloatActivityConfig.setCanSelectOnlyVideo(false);
                albumFloatActivityConfig.setCanEditImage(false);
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) this.f16131a.f16123a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) this.f16131a.f16123a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) this.f16131a.f16123a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) this.f16131a.f16123a.getPageActivity()).mPrefixData, ((WriteActivity) this.f16131a.f16123a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) this.f16131a.f16123a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // b.a.r0.d4.u.h.f
        public void c(int i2) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f16131a.f16125c == null || (count = ListUtils.getCount(this.f16131a.f16125c.getChosedFiles())) == 0 || i2 < 0 || i2 >= count || (imageInfoAt = this.f16131a.f16125c.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            this.f16131a.f16123a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f16131a.f16123a.getPageActivity(), 12012, this.f16131a.f16125c, i2)));
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
        this.f16127e = new b.a.q0.d0.b();
        this.f16128f = AlbumActivityConfig.FROM_WRITE;
        this.f16129g = "";
        this.f16130h = new a(this);
        this.f16123a = tbPageContext;
        this.f16124b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f16127e, null, this.f16130h);
        this.f16126d = hVar;
        this.f16124b.setAdapter((ListAdapter) hVar);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16127e.b();
        }
    }

    public GridView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16124b : (GridView) invokeV.objValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f16126d.g(z);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f16126d.h(z);
        }
    }

    public void j(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, writeImagesInfo, str, str2) == null) {
            this.f16128f = str;
            this.f16129g = str2;
            this.f16125c = writeImagesInfo;
            this.f16126d.f(writeImagesInfo);
            this.f16126d.notifyDataSetChanged();
            WriteImagesInfo writeImagesInfo2 = this.f16125c;
            if (writeImagesInfo2 == null || writeImagesInfo2.getChosedFiles() == null || this.f16124b.getVisibility() != 8) {
                return;
            }
            this.f16124b.setVisibility(0);
        }
    }
}
