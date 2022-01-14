package c.a.t0.o1.k.b.e;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.s.s.a;
import c.a.s0.t.c.n0;
import c.a.t0.w3.a0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends c.a.s0.x.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f20706f;

    /* renamed from: g  reason: collision with root package name */
    public String f20707g;

    /* renamed from: h  reason: collision with root package name */
    public long f20708h;

    /* renamed from: i  reason: collision with root package name */
    public NewWriteModel f20709i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.x.y.c f20710j;
    public c.a.s0.x.y.b k;
    public NewWriteModel.g l;
    public String m;
    public c.a.t0.o1.k.b.e.c n;
    public WriteImagesInfo o;
    public ImageModel p;
    public String q;
    public NewWriteModel.g r;
    public AntiHelper.k s;
    public final c.a.d.a.e t;

    /* renamed from: c.a.t0.o1.k.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1293a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1293a(a aVar) {
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
            this.a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, n0 n0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, n0Var, writeData, antiData}) == null) {
                if (this.a.l != null) {
                    this.a.l.callback(z, postWriteCallBackData, n0Var, writeData, antiData);
                }
                if (z) {
                    this.a.f20707g = null;
                    this.a.B(true);
                }
                int i2 = -1;
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (z) {
                    this.a.f20709i.setWriteData(null);
                    this.a.f20709i.g0(false);
                    this.a.o.clear();
                    this.a.j();
                    this.a.a().sendAction(new c.a.s0.x.a(2, 10, null));
                } else if (i2 != 230277 && i2 != 230278 && i2 != 340016 && i2 != 1990032 && !AntiHelper.m(i2, str)) {
                    if (n0Var != null && writeData != null && !StringUtils.isNull(n0Var.c())) {
                        writeData.setVcodeMD5(n0Var.b());
                        writeData.setVcodeUrl(n0Var.c());
                        writeData.setVcodeExtra(n0Var.a());
                        if (c.a.s0.f1.a.b(n0Var.d())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getContext().getPageActivity(), 12006, writeData, false, n0Var.d())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getContext().getPageActivity(), writeData, 12006)));
                        }
                    } else if (postWriteCallBackData != null && i2 == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.f20706f.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                    } else if (i2 == 238010 || c.a.t0.g4.a.c(i2)) {
                    } else {
                        this.a.getContext().showToast(str);
                    }
                } else {
                    this.a.J(i2, str);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
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
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
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
                }
            }
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.a.f20709i.g0(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a0.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20711e;

        public e(a aVar) {
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
            this.f20711e = aVar;
        }

        @Override // c.a.t0.w3.a0.f
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || writeData == null) {
                return;
            }
            if (writeData.getWriteImagesInfo() != null && this.f20711e.o.size() == 0) {
                this.f20711e.o.copyFrom(writeData.getWriteImagesInfo());
                if (this.f20711e.o != null && this.f20711e.o.getChosedFiles() != null && this.f20711e.o.getChosedFiles().size() > 0) {
                    EditorTools a = this.f20711e.a();
                    a.sendAction(new c.a.s0.x.a(2, 10, this.f20711e.o.getChosedFiles().size() + ""));
                }
            }
            if (this.f20711e.o == null || this.f20711e.o.size() == 0) {
                this.f20711e.a().sendAction(new c.a.s0.x.a(2, 10, null));
            }
            if (m.isEmpty(writeData.getContent()) || !m.isEmpty(this.f20711e.f20707g)) {
                return;
            }
            this.f20711e.f20707g = writeData.getContent();
            a aVar = this.f20711e;
            aVar.C(aVar.f20707g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20707g = "";
        this.m = null;
        this.o = new WriteImagesInfo();
        this.p = null;
        this.r = new C1293a(this);
        this.s = new b(this);
        this.t = new d(this);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.s0.x.a(13, -1, null));
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.s0.x.a(9, -1, Boolean.valueOf(z)));
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.s0.x.a(6, 29, str));
    }

    public void D(c.a.s0.x.y.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void E(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            this.f20706f = tbPageContext;
        }
    }

    public void F(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.l = gVar;
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f20707g = str;
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    public void I(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.f20708h = j2;
        }
    }

    public void J(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(this.f20706f.getPageActivity(), str, i2, this.s) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
                }
            } else if (i2 != 230277 && i2 != 230278) {
                getContext().showToast(str);
            } else {
                K(str);
            }
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(getContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new c(this));
            aVar.create(getContext()).show();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            H(true);
            a().display();
        }
    }

    public TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f20706f : (TbPageContext) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            a0.A(String.valueOf(this.f20708h), null);
        }
    }

    public final void k(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            p(intent, true);
        }
    }

    public final void l(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, intent) == null) {
            this.q = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.q;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, n.d(this.f20706f.getPageActivity(), n.k(this.f20706f.getPageActivity())), n.d(this.f20706f.getPageActivity(), n.i(this.f20706f.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, this.q, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception unused) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.o.addChooseFile(imageFileInfo);
            this.o.updateQuality();
            if (this.o.getChosedFiles() != null) {
                s();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a0.q(String.valueOf(this.f20708h), new e(this));
        }
    }

    public c.a.t0.o1.k.b.e.c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.n == null && a() != null) {
                this.n = (c.a.t0.o1.k.b.e.c) a().findToolById(29);
            }
            return this.n;
        }
        return (c.a.t0.o1.k.b.e.c) invokeV.objValue;
    }

    public final void o(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            p(intent, false);
        }
    }

    public final void p(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048595, this, intent, z) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.o.parseJson(stringExtra);
        this.o.updateQuality();
        if (this.o.getChosedFiles() != null) {
            s();
        }
    }

    public WriteImagesInfo q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.o : (WriteImagesInfo) invokeV.objValue;
    }

    public long r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f20708h : invokeV.longValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (!WriteActivityConfig.isAsyncWriting() || this.f20708h <= 0) {
                WriteActivityConfig.newInstance(this.f20706f.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.f20708h)).setFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL).setCallFrom("1").setContent(this.f20707g).setWriteImagesInfo(this.o).send();
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            H(false);
            a().hide();
        }
    }

    public void u(BaseActivity baseActivity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048600, this, baseActivity, bundle) == null) || baseActivity == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(baseActivity);
        this.f20709i = newWriteModel;
        newWriteModel.l0(this.r);
        ImageModel imageModel = new ImageModel(baseActivity.getPageContext());
        this.p = imageModel;
        imageModel.setLoadDataCallBack(this.t);
        if (bundle != null) {
            this.o.parseJson(bundle.getString("write_images"));
            this.q = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        WriteImagesInfo writeImagesInfo = this.o;
        if (writeImagesInfo != null) {
            writeImagesInfo.setMaxImagesAllowed(9);
        }
        WriteImagesInfo writeImagesInfo2 = this.o;
        if (writeImagesInfo2 == null || writeImagesInfo2.getChosedFiles() == null || this.o.getChosedFiles().size() <= 0) {
            return;
        }
        EditorTools a = a();
        a.sendAction(new c.a.s0.x.a(2, 10, this.o.getChosedFiles().size() + ""));
    }

    public void v(int i2, int i3, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048601, this, i2, i3, intent) == null) {
            PostWriteCallBackData postWriteCallBackData2 = null;
            if (i3 != -1) {
                if (i3 == 0 && i2 == 12006) {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData2 = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData3 = postWriteCallBackData2;
                    NewWriteModel.g gVar = this.l;
                    if (gVar != null) {
                        gVar.callback(false, postWriteCallBackData3, null, this.f20709i.Z(), null);
                    }
                }
            } else if (i2 == 12006) {
                PostWriteCallBackData postWriteCallBackData4 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (this.l != null) {
                    this.f20707g = null;
                    B(true);
                    this.f20709i.setWriteData(null);
                    this.f20709i.g0(false);
                    this.o.clear();
                    j();
                    a().sendAction(new c.a.s0.x.a(2, 10, null));
                    this.l.callback(true, postWriteCallBackData4, null, this.f20709i.Z(), null);
                }
            } else if (i2 == 12012) {
                o(intent);
            } else if (i2 == 13003) {
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e2) {
                        BdLog.e(e2);
                        postWriteCallBackData = null;
                    }
                    this.r.callback(true, postWriteCallBackData, null, null, null);
                }
            } else if (i2 == 24007) {
                if (intent.getIntExtra("extra_share_status", 2) == 1) {
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    statisticItem.param("obj_locate", 6);
                    if (shareItem != null) {
                        statisticItem.param("tid", shareItem.K);
                    }
                    statisticItem.param("pid", intent.getStringExtra("pid"));
                    TiebaStatic.log(statisticItem);
                }
            } else if (i2 == 12009 || i2 == 12010) {
                if (i2 == 12010) {
                    l(intent);
                }
            } else {
                switch (i2) {
                    case TaskResponseData.ERROR_NO_TASK_OFFLINE_03 /* 12002 */:
                        if (intent == null) {
                            return;
                        }
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            l(intent);
                        } else {
                            k(intent);
                        }
                        a().invalidate();
                        return;
                    case 12003:
                        if (intent == null) {
                            return;
                        }
                        if (intent.getBooleanExtra("delete", false)) {
                            A();
                            this.f20709i.g0(false);
                            return;
                        }
                        this.p.B(intent.getStringExtra("file_name"));
                        return;
                    case 12004:
                        if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) == null) {
                            return;
                        }
                        z(parcelableArrayListExtra);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f20709i.cancelLoadData();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.f20709i.Z() == null) {
                this.f20709i.setWriteData(new WriteData());
            }
            if (this.f20709i.Z() == null) {
                return;
            }
            this.f20709i.Z().setForumId("0");
            this.f20709i.Z().setType(9);
            this.f20709i.Z().setEntranceType(1);
            this.f20709i.Z().setCanNoForum(true);
            this.f20709i.Z().setTransmitForumData("[]");
            this.f20709i.Z().setCallFrom("1");
            this.f20709i.Z().setTopicId(String.valueOf(this.f20708h));
            this.f20709i.Z().setContent(this.f20707g);
            this.f20709i.Z().setIsNoTitle(true);
            this.f20709i.Z().setTitle("");
            this.f20709i.Z().setVoice(null);
            this.f20709i.Z().setVoiceDuringTime(-1);
            if (!this.f20709i.W()) {
                getContext().showToast(R.string.write_img_limit);
                return;
            }
            c.a.s0.x.y.b bVar = this.k;
            if (bVar == null || !bVar.a()) {
                c.a.s0.x.y.c cVar = this.f20710j;
                if (cVar != null) {
                    cVar.a();
                }
                if (!this.f20709i.p0()) {
                }
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            WriteData writeData = new WriteData(2);
            writeData.setContent(this.f20707g);
            writeData.setTopicId(String.valueOf(this.f20708h));
            writeData.setWriteImagesInfo(this.o);
            a0.A(String.valueOf(this.f20708h), writeData);
        }
    }

    public final void z(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, arrayList) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.s0.x.a(17, 29, arrayList));
    }
}
