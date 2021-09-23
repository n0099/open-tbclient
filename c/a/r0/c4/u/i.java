package c.a.r0.c4.u;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import c.a.r0.c4.u.h;
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
    public TbPageContext<WriteActivity> f16968a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f16969b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f16970c;

    /* renamed from: d  reason: collision with root package name */
    public h f16971d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.d0.b f16972e;

    /* renamed from: f  reason: collision with root package name */
    public String f16973f;

    /* renamed from: g  reason: collision with root package name */
    public String f16974g;

    /* renamed from: h  reason: collision with root package name */
    public h.f f16975h;

    /* loaded from: classes3.dex */
    public class a implements h.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f16976a;

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
            this.f16976a = iVar;
        }

        @Override // c.a.r0.c4.u.h.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f16976a.f16970c == null || this.f16976a.f16970c.getChosedFiles() == null || i2 < 0 || i2 >= this.f16976a.f16970c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.f16976a.f16970c.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                c.a.e.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = this.f16976a;
            iVar.f16971d.f(iVar.f16970c);
            this.f16976a.f16971d.notifyDataSetChanged();
            if (ListUtils.isEmpty(this.f16976a.f16970c.getChosedFiles()) && this.f16976a.f16968a.getOrignalPage() != null) {
                ((WriteActivity) this.f16976a.f16968a.getOrignalPage()).refreshPostButton();
            }
            if (this.f16976a.f16968a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) this.f16976a.f16968a.getPageActivity()).refreshImageLauncher();
                ((WriteActivity) this.f16976a.f16968a.getPageActivity()).refreshVideoLauncher();
            }
        }

        @Override // c.a.r0.c4.u.h.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16976a.f16970c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f16976a.f16968a.getPageActivity(), this.f16976a.f16970c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f16976a.f16974g);
            albumFloatActivityConfig.getIntent().putExtra("from", this.f16976a.f16973f);
            albumFloatActivityConfig.setRequestCode(12002);
            if (this.f16976a.f16968a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(false);
                albumFloatActivityConfig.setCanSelectOnlyVideo(false);
                albumFloatActivityConfig.setCanEditImage(false);
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) this.f16976a.f16968a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) this.f16976a.f16968a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) this.f16976a.f16968a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) this.f16976a.f16968a.getPageActivity()).mPrefixData, ((WriteActivity) this.f16976a.f16968a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) this.f16976a.f16968a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // c.a.r0.c4.u.h.f
        public void c(int i2) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f16976a.f16970c == null || (count = ListUtils.getCount(this.f16976a.f16970c.getChosedFiles())) == 0 || i2 < 0 || i2 >= count || (imageInfoAt = this.f16976a.f16970c.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            this.f16976a.f16968a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f16976a.f16968a.getPageActivity(), 12012, this.f16976a.f16970c, i2)));
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
        this.f16972e = new c.a.q0.d0.b();
        this.f16973f = AlbumActivityConfig.FROM_WRITE;
        this.f16974g = "";
        this.f16975h = new a(this);
        this.f16968a = tbPageContext;
        this.f16969b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f16972e, null, this.f16975h);
        this.f16971d = hVar;
        this.f16969b.setAdapter((ListAdapter) hVar);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16972e.b();
        }
    }

    public GridView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16969b : (GridView) invokeV.objValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f16971d.g(z);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f16971d.h(z);
        }
    }

    public void i(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, writeImagesInfo, str, str2) == null) {
            this.f16973f = str;
            this.f16974g = str2;
            this.f16970c = writeImagesInfo;
            this.f16971d.f(writeImagesInfo);
            this.f16971d.notifyDataSetChanged();
        }
    }
}
