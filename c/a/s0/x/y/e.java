package c.a.s0.x.y;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.s.q.d2;
import c.a.s0.s.s.a;
import c.a.s0.t.c.m0;
import c.a.s0.t.c.w;
import c.a.t0.w3.a0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class e extends c.a.s0.x.e implements a0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewWriteModel.g A;
    public c.a.s0.x.y.c B;
    public c.a.s0.x.y.b C;
    public boolean D;
    public TextWatcher E;
    public c.a.s0.x.y.f F;
    public int G;
    public EditorTools H;
    public boolean I;
    public LocationModel.e J;
    public LocationModel.f K;
    public final NewWriteModel.g L;
    public final c.a.d.a.e M;

    /* renamed from: f  reason: collision with root package name */
    public WriteImagesInfo f14583f;

    /* renamed from: g  reason: collision with root package name */
    public String f14584g;

    /* renamed from: h  reason: collision with root package name */
    public SpanGroupManager f14585h;

    /* renamed from: i  reason: collision with root package name */
    public VoiceData$VoiceModel f14586i;

    /* renamed from: j  reason: collision with root package name */
    public String f14587j;

    /* renamed from: k  reason: collision with root package name */
    public LocationModel f14588k;
    public NewWriteModel l;
    public ImageModel m;
    public DataModel<?> n;
    public ForumData o;
    public d2 p;
    public String q;
    public TbPageContext r;
    public String s;
    public String t;
    public String u;
    public long v;
    public String w;
    public int x;
    public VideoInfo y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r.showToast(R.string.no_network_guide);
                this.a.b0(0, false, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.a.b0(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.I) {
                    TbPageContext tbPageContext = this.a.r;
                    if (StringUtils.isNull(str)) {
                        str = this.a.a().getContext().getString(R.string.location_fail);
                    }
                    tbPageContext.showToast(str);
                }
                this.a.b0(0, false, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements LocationModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b0(0, false, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.b0(2, true, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.s.g0.b.j().t("key_post_thread_has_request_location", true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14589e;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14589e = eVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f14589e.b0(0, true, null);
                aVar.dismiss();
            }
        }
    }

    /* renamed from: c.a.s0.x.y.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0896e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14590e;

        public C0896e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14590e = eVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (l.z()) {
                    this.f14590e.b0(1, true, null);
                    this.f14590e.f14588k.L();
                } else {
                    this.f14590e.J.a();
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public f(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.a.l.Z();
                }
                if (z) {
                    this.a.Y(true);
                    WriteData Z = this.a.l.Z();
                    this.a.S();
                    a0.v(this.a.q, null);
                    if (Z == null) {
                        return;
                    }
                    if (Z.getType() == 2) {
                        a0.m(Z.getThreadId(), this.a);
                    }
                } else if (writeData != null && m0Var != null && !TextUtils.isEmpty(m0Var.d())) {
                    writeData.setVcodeMD5(m0Var.b());
                    writeData.setVcodeUrl(m0Var.c());
                    writeData.setVcodeExtra(m0Var.a());
                    if (this.a.p != null) {
                        writeData.setBaijiahaoData(this.a.p.L());
                    }
                    if (c.a.s0.f1.a.b(m0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.r.getPageActivity(), 12006, writeData, false, m0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.r.getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.r.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
                e eVar = this.a;
                eVar.G(eVar.l.Z());
                NewWriteModel.g gVar = this.a.A;
                if (gVar != null) {
                    gVar.callback(z, postWriteCallBackData, m0Var, writeData, antiData);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends BdAsyncTask<Void, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                FileHelper.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + this.a.f14587j));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.a.l.g0(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(EditorTools editorTools) {
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
        this.f14583f = new WriteImagesInfo();
        this.f14584g = "";
        this.l = null;
        this.m = null;
        this.q = null;
        this.s = null;
        this.x = 0;
        this.D = false;
        this.G = 0;
        this.I = true;
        this.J = new a(this);
        this.K = new b(this);
        this.L = new f(this);
        this.M = new h(this);
        this.H = editorTools;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.r.getPageActivity())));
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f14583f;
            return (writeImagesInfo == null || (chosedFiles = writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (StringUtils.isNull(this.f14584g)) {
                WriteImagesInfo writeImagesInfo = this.f14583f;
                if (writeImagesInfo == null || writeImagesInfo.size() <= 0) {
                    VoiceData$VoiceModel voiceData$VoiceModel = this.f14586i;
                    if (voiceData$VoiceModel == null || StringUtils.isNull(voiceData$VoiceModel.getId())) {
                        VideoInfo videoInfo = this.y;
                        return videoInfo != null && videoInfo.isAvaliable();
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VoiceData$VoiceModel voiceData$VoiceModel = this.f14586i;
            return (voiceData$VoiceModel == null || TextUtils.isEmpty(voiceData$VoiceModel.voiceId) || this.f14586i.duration <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.I = false;
        }
    }

    public void F(TbPageContext tbPageContext, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, tbPageContext, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
            this.l = newWriteModel;
            newWriteModel.l0(this.L);
            ImageModel imageModel = new ImageModel(tbPageContext);
            this.m = imageModel;
            imageModel.setLoadDataCallBack(this.M);
            LocationModel locationModel = new LocationModel(tbPageContext);
            this.f14588k = locationModel;
            locationModel.O(this.J);
            this.f14588k.P(this.K);
            if (bundle != null) {
                this.f14583f.parseJson(bundle.getString("write_images"));
                this.f14587j = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            WriteImagesInfo writeImagesInfo = this.f14583f;
            if (writeImagesInfo != null) {
                writeImagesInfo.setMaxImagesAllowed(this.z ? 1 : 9);
            }
            if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
                a().sendAction(new c.a.s0.x.a(2, 12, " "));
            }
            if (!this.f14588k.z() && a() != null) {
                a().sendAction(new c.a.s0.x.a(20, 8, null));
            }
            WriteImagesInfo writeImagesInfo2 = this.f14583f;
            if (writeImagesInfo2 == null || writeImagesInfo2.getChosedFiles() == null || this.f14583f.getChosedFiles().size() <= 0) {
                return;
            }
            EditorTools a2 = a();
            a2.sendAction(new c.a.s0.x.a(2, 10, this.f14583f.getChosedFiles().size() + ""));
        }
    }

    public void G(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) || writeData == null) {
            return;
        }
        this.f14583f = new WriteImagesInfo();
        if (writeData.getWriteImagesInfo() != null) {
            this.f14583f.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.f14583f;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.f14583f.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.sendAction(new c.a.s0.x.a(2, 10, this.f14583f.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.f14583f;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().sendAction(new c.a.s0.x.a(2, 10, null));
        }
        String content = writeData.getContent();
        this.f14584g = content;
        a0(content);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void H(int i2, int i3, Intent intent) {
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i3 != -1) {
                if (i2 == 12001) {
                    n();
                } else if (i2 == 12002) {
                    if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        return;
                    }
                    this.f14583f.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                } else if (i2 != 12006) {
                } else {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                    NewWriteModel.g gVar = this.A;
                    if (gVar != null) {
                        gVar.callback(false, postWriteCallBackData2, null, this.l.Z(), null);
                    }
                }
            } else if (i2 == 11001) {
                L(null, null);
            } else if (i2 == 12006) {
                WriteData Z = this.l.Z();
                PostWriteCallBackData postWriteCallBackData3 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (Z != null) {
                    Z.deleteUploadedTempImages();
                }
                this.l.setWriteData(null);
                this.l.g0(false);
                this.f14586i = null;
                this.y = null;
                if (!TextUtils.isEmpty(this.q)) {
                    a0.v(this.q, null);
                }
                Y(true);
                NewWriteModel.g gVar2 = this.A;
                if (gVar2 != null) {
                    gVar2.callback(true, postWriteCallBackData3, null, Z, null);
                }
            } else if (i2 == 12012) {
                u(intent);
            } else if (i2 == 13010) {
                if (a() == null) {
                    return;
                }
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.parseFromIntent(intent);
                if (videoInfo.isAvaliable()) {
                    this.y = videoInfo;
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.XIAOYING_DURATION);
                    statisticItem.param("duration", this.y.getVideoDuration());
                    TiebaStatic.log(statisticItem);
                    c0();
                    a().sendAction(new c.a.s0.x.a(28, 20, this.y));
                    a().sendAction(new c.a.s0.x.a(28, -1, this.y));
                }
            } else if (i2 == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            } else if (i2 == 25004) {
                if (intent != null) {
                    W(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                }
            } else if (i2 == 11025) {
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.r.getPageActivity(), 12004, true);
                if (x() != null) {
                    atListActivityConfig.setSelectedAtList(x().u());
                }
                d2 d2Var = this.p;
                if (d2Var != null) {
                    atListActivityConfig.setFromTid(d2Var.v1());
                    atListActivityConfig.setFromFid(String.valueOf(this.p.U()));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                d2 d2Var2 = this.p;
                if (d2Var2 != null) {
                    statisticItem2.addParam("tid", d2Var2.v1());
                    statisticItem2.addParam("fid", this.p.U());
                }
                TiebaStatic.log(statisticItem2);
            } else if (i2 == 11026) {
                AtListActivityConfig atListActivityConfig2 = new AtListActivityConfig(this.r.getPageActivity(), 12005, true);
                if (x() != null) {
                    atListActivityConfig2.setSelectedAtList(x().u());
                }
                d2 d2Var3 = this.p;
                if (d2Var3 != null) {
                    atListActivityConfig2.setFromTid(d2Var3.v1());
                    atListActivityConfig2.setFromFid(String.valueOf(this.p.U()));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig2));
                StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem3.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                d2 d2Var4 = this.p;
                if (d2Var4 != null) {
                    statisticItem3.addParam("tid", d2Var4.v1());
                    statisticItem3.addParam("fid", this.p.U());
                }
                TiebaStatic.log(statisticItem3);
            } else if (i2 == 12009 || i2 == 12010) {
                if (i2 == 12010) {
                    r(intent);
                }
            } else {
                switch (i2) {
                    case TaskResponseData.ERROR_NO_TASK_OFFLINE_03 /* 12002 */:
                        if (intent == null) {
                            return;
                        }
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            r(intent);
                        } else {
                            q(intent);
                        }
                        a().invalidate();
                        return;
                    case 12003:
                        if (intent == null) {
                            return;
                        }
                        if (intent.getBooleanExtra("delete", false)) {
                            X();
                            this.l.g0(false);
                            return;
                        }
                        this.m.B(intent.getStringExtra("file_name"));
                        return;
                    case 12004:
                        if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) == null) {
                            return;
                        }
                        V(parcelableArrayListExtra);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.l.cancelLoadData();
            this.m.cancelLoadData();
            this.f14588k.cancelLoadData();
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (PermissionUtil.checkLocationForGoogle(this.r.getPageActivity()) && z) {
                v0();
            } else {
                PermissionUtil.requestLocation(this.r.getPageActivity(), 0, new c(this));
            }
        }
    }

    public void K(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            WriteImagesInfo writeImagesInfo = this.f14583f;
            if (writeImagesInfo != null) {
                bundle.putString("write_images", writeImagesInfo.toJsonString());
            }
            bundle.putString(WriteActivityConfig.PHOTO_NAME, this.f14587j);
        }
    }

    public void L(String str, WriteData writeData) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, writeData) == null) {
            if (this.l.Z() == null) {
                WriteData D = this.n.D(str);
                if (D != null && (d2Var = this.p) != null) {
                    D.setBaijiahaoData(d2Var.L());
                }
                this.l.setWriteData(D);
            }
            if (this.l.Z() == null) {
                return;
            }
            this.l.setSpanGroupManager(this.f14585h);
            boolean z = true;
            if (this.D) {
                this.l.Z().setCanNoForum(true);
                if (this.o != null) {
                    this.l.Z().setVForumId(this.o.getId());
                    this.l.Z().setVForumName(this.o.getName());
                }
            } else {
                this.l.Z().setCanNoForum(false);
                this.l.Z().setVForumId("");
                this.l.Z().setVForumName("");
            }
            this.l.Z().setIsBJHPost(this.z);
            this.l.Z().setWriteImagesInfo(this.f14583f);
            this.l.Z().setVideoInfo(this.y);
            this.l.g0(this.f14583f.size() > 0);
            WriteData Z = this.l.Z();
            LocationModel locationModel = this.f14588k;
            Z.setHasLocationData((locationModel == null || !locationModel.z()) ? false : false);
            if (str == null) {
                this.l.Z().setContent(this.f14584g);
            }
            VoiceData$VoiceModel voiceData$VoiceModel = this.f14586i;
            if (voiceData$VoiceModel != null) {
                if (voiceData$VoiceModel.getId() != null) {
                    this.l.Z().setVoice(this.f14586i.getId());
                    this.l.Z().setVoiceDuringTime(this.f14586i.duration);
                } else {
                    this.l.Z().setVoice(null);
                    this.l.Z().setVoiceDuringTime(-1);
                }
            } else {
                this.l.Z().setVoice(null);
                this.l.Z().setVoiceDuringTime(-1);
            }
            if (!this.l.W()) {
                this.r.showToast(R.string.write_img_limit);
                return;
            }
            c.a.s0.x.y.b bVar = this.C;
            if (bVar == null || !bVar.a()) {
                c.a.s0.x.y.c cVar = this.B;
                if (cVar != null) {
                    cVar.a();
                }
                p(this.l.Z());
                o();
                if (!this.l.p0()) {
                }
            }
        }
    }

    public void M(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, antiData) == null) || antiData == null) {
            return;
        }
        this.s = antiData.getVoice_message();
    }

    public void N(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, forumData, userData) == null) {
            this.o = forumData;
        }
    }

    public void O(MetaData metaData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, metaData, str, str2) == null) || a() == null || metaData == null) {
            return;
        }
        this.v = metaData.getUserIdLong();
        this.t = metaData.getUserName();
        this.u = metaData.getName_show();
        this.q = str;
        this.w = str2;
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            boolean g2 = c.a.s0.s.g0.b.j().g("key_post_thread_has_request_location", false);
            if (this.z || this.f14588k == null || c.a.t0.w3.o0.b.a().d() || !this.f14588k.E(this.r.getPageActivity()) || !TbadkCoreApplication.getInst().getLocationShared() || !g2) {
                return;
            }
            this.f14588k.I();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f14588k.z()) {
                if (this.f14588k.D()) {
                    this.J.b(c.a.t0.w3.o0.b.a().b());
                    return;
                }
                if (n.C()) {
                    this.f14588k.I();
                }
                b0(0, true, null);
                return;
            }
            b0(0, false, null);
        }
    }

    public void R() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (editorTools = this.H) == null) {
            return;
        }
        editorTools.resetChangeToLauncher();
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.l.setWriteData(null);
            this.l.g0(false);
            this.f14586i = null;
            this.y = null;
            this.f14583f.clear();
        }
    }

    public void T() {
        c.a.s0.x.y.f fVar;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (fVar = this.F) == null || (textWatcher = this.E) == null) {
            return;
        }
        fVar.i(textWatcher);
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            WriteData Z = this.l.Z();
            if (Z == null) {
                Z = new WriteData(1);
                Z.setThreadId(str);
                Z.setWriteImagesInfo(this.f14583f);
            }
            Z.setContent(this.f14584g);
            Z.setVideoInfo(this.y);
            Z.setVoiceModel(this.f14586i);
            a0.v(str, Z);
        }
    }

    public final void V(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.s0.x.a(17, 27, arrayList));
    }

    public void W(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.s0.x.a(44, 27, str));
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.s0.x.a(13, -1, null));
    }

    public final void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || a() == null) {
            return;
        }
        if (z) {
            a().sendAction(new c.a.s0.x.a(2, 10, null));
            a().sendAction(new c.a.s0.x.a(2, 6, null));
        }
        a().sendAction(new c.a.s0.x.a(9, -1, Boolean.valueOf(z)));
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || StringUtils.isNull(this.t)) {
            return;
        }
        long j2 = this.v;
        if (j2 <= 0) {
            return;
        }
        if (String.valueOf(j2).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            n.L(this.r.getPageActivity(), R.string.can_not_send_gift_to_yourself);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.r.getPageActivity(), this.v, this.t, this.u, GiftTabActivityConfig.FROM_PB, c.a.d.f.m.b.g(this.q, 0L), c.a.d.f.m.b.g(this.w, 0L))));
    }

    public final void a0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, str) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.s0.x.a(6, 27, str));
    }

    public final void b0(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.x = i2;
            if (a() != null) {
                a().sendAction(new c.a.s0.x.a(19, 27, new c.a.s0.x.w.a(i2, z, str)));
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.s0.x.a(2, 19, " "));
    }

    public void d0(c.a.s0.x.y.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bVar) == null) {
            this.C = bVar;
        }
    }

    public void e0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, tbPageContext) == null) {
            this.r = tbPageContext;
        }
    }

    public void f0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().findLauncherById(5)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.G = i2;
        }
    }

    public TbPageContext getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.r : (TbPageContext) invokeV.objValue;
    }

    public void h(w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, wVar) == null) || wVar == null) {
            return;
        }
        if (wVar.getType() == EmotionGroupType.BIG_EMOTION || wVar.getType() == EmotionGroupType.USER_COLLECT) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setImageType(1);
            imageFileInfo.setFilePath(wVar.c());
            imageFileInfo.width = wVar.g();
            imageFileInfo.height = wVar.b();
            this.f14583f.addChooseFile(imageFileInfo);
            this.f14583f.updateQuality();
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.D = z;
        }
    }

    public void i(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, textWatcher) == null) {
            k();
            c.a.s0.x.y.f fVar = this.F;
            if (fVar == null || textWatcher == null) {
                return;
            }
            fVar.f(textWatcher);
        }
    }

    public void i0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().findLauncherById(23)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            if (this.F == null && a() != null) {
                this.F = (c.a.s0.x.y.f) a().findToolById(27);
            }
            c.a.s0.x.y.f fVar = this.F;
            if (fVar != null) {
                fVar.g(i2);
            }
        }
    }

    public void j0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, dataModel) == null) {
            this.n = dataModel;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && this.F == null && a() != null) {
            this.F = (c.a.s0.x.y.f) a().findToolById(27);
        }
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            if (this.F == null && a() != null) {
                this.F = (c.a.s0.x.y.f) a().findToolById(27);
            }
            c.a.s0.x.y.f fVar = this.F;
            if (fVar != null) {
                fVar.k(str);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            WriteImagesInfo writeImagesInfo = this.f14583f;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.f14583f.clear();
            }
            VideoInfo videoInfo = this.y;
            if (videoInfo != null && videoInfo.isAvaliable()) {
                this.y = null;
            }
            a().sendAction(new c.a.s0.x.a(2, 19, null));
            t0(null);
            a().sendAction(new c.a.s0.x.a(2, 6, null));
            a().sendAction(new c.a.s0.x.a(33, 6, null));
            if (!StringUtils.isNull(this.f14584g)) {
                this.f14584g = "";
            }
            a0("");
            this.l.setWriteData(null);
            this.l.g0(false);
        }
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            if (this.F == null && a() != null) {
                this.F = (c.a.s0.x.y.f) a().findToolById(27);
            }
            c.a.s0.x.y.f fVar = this.F;
            if (fVar != null) {
                fVar.l(i2);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.y = null;
        }
    }

    public void m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.f14584g = str;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            new g(this).execute(new Void[0]);
        }
    }

    public void n0(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, gVar) == null) {
            this.A = gVar;
        }
    }

    public final void o() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || this.p == null || (dataModel = this.n) == null || !dataModel.F()) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_COMMENT);
        statisticItem.addParam("obj_locate", 1);
        if (this.p.I2()) {
            statisticItem.addParam("obj_type", 3);
        } else if (this.p.H2()) {
            statisticItem.addParam("obj_type", 2);
        } else {
            statisticItem.addParam("obj_type", 1);
        }
        statisticItem.addParam("tid", this.p.v1());
        statisticItem.addParam(TiebaStatic.Params.FID_1, this.p.U());
        statisticItem.addParam(TiebaStatic.Params.FID_2, this.n.getFromForumId());
        TiebaStatic.log(statisticItem);
        c.a.s0.d.a.a(c.a.s0.d.a.f12575f, c.a.s0.d.a.f12572c, this.n.B(), this.n.C(), this.n.A(), this.p.U1);
    }

    public void o0(c.a.s0.x.y.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, cVar) == null) {
            this.B = cVar;
        }
    }

    @Override // c.a.t0.w3.a0.e
    public void onDraftLoaded(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, writeData) == null) || writeData == null) {
            return;
        }
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            if (this.y == null) {
                this.y = new VideoInfo();
            }
            this.y.copy(writeData.getVideoInfo());
            c0();
            a().sendAction(new c.a.s0.x.a(39, -1, this.y));
        }
        if (writeData.getWriteImagesInfo() != null && this.f14583f.size() == 0) {
            this.f14583f.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.f14583f;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.f14583f.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.sendAction(new c.a.s0.x.a(2, 10, this.f14583f.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.f14583f;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().sendAction(new c.a.s0.x.a(2, 10, null));
        }
        if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
            if (this.f14586i == null) {
                this.f14586i = new VoiceData$VoiceModel();
            }
            this.f14586i.copy(writeData.getVoiceModel());
        }
        if (!m.isEmpty(writeData.getContent()) && m.isEmpty(this.f14584g)) {
            String content = writeData.getContent();
            this.f14584g = content;
            a0(content);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void p(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, writeData) == null) || writeData == null) {
            return;
        }
        int i2 = 0;
        if (!TextUtils.isEmpty(writeData.getContent())) {
            int i3 = 0;
            while (TbPatternsCompat.EMOTION_PATTERRN.matcher(writeData.getContent()).find()) {
                i3++;
            }
            if (i3 > 0 && this.G > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMALL_EMOTION_NUM);
                statisticItem.param("obj_type", i3);
                statisticItem.param("obj_source", this.G);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", writeData.getThreadId());
                TiebaStatic.log(statisticItem);
            }
        }
        if (writeData.getWriteImagesInfo() == null || ListUtils.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
            return;
        }
        for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
            if (imageFileInfo.getImageType() == 1) {
                i2++;
            }
        }
        if (i2 <= 0 || this.G <= 0) {
            return;
        }
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
        statisticItem2.param("obj_type", i2);
        statisticItem2.param("obj_source", this.G);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("tid", writeData.getThreadId());
        TiebaStatic.log(statisticItem2);
    }

    public void p0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048628, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().findLauncherById(2)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public final void q(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, intent) == null) {
            w(intent, true);
        }
    }

    public void q0(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, spanGroupManager) == null) {
            this.f14585h = spanGroupManager;
        }
    }

    public final void r(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, intent) == null) {
            this.f14587j = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.f14587j;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, n.d(this.r.getPageActivity(), n.k(this.r.getPageActivity())), n.d(this.r.getPageActivity(), n.i(this.r.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, this.f14587j, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception unused) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.f14583f.addChooseFile(imageFileInfo);
            this.f14583f.updateQuality();
            z(false, null);
        }
    }

    public void r0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, d2Var) == null) {
            this.p = d2Var;
            if (a() == null || this.p == null) {
                return;
            }
            a().setFid(this.p.U());
            a().setTid(this.p.v1());
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            a0.m(str, this);
        }
    }

    public void s0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.q = str;
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.x : invokeV.intValue;
    }

    public void t0(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, voiceData$VoiceModel) == null) {
            this.f14586i = voiceData$VoiceModel;
        }
    }

    public final void u(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, intent) == null) {
            w(intent, false);
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.r.getPageActivity());
            aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new C0896e(this)).setNegativeButton(R.string.cancel, new d(this)).create(this.r);
            aVar.show();
        }
    }

    public c.a.s0.x.y.f v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (this.F == null && a() != null) {
                this.F = (c.a.s0.x.y.f) a().findToolById(27);
            }
            return this.F;
        }
        return (c.a.s0.x.y.f) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (!this.f14588k.E(this.r.getPageActivity())) {
                this.r.showToast(R.string.location_system_permission_prompt);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                u0();
            } else if (this.f14588k.D()) {
                A();
            } else {
                this.f14588k.N(false);
                b0(1, true, null);
                this.f14588k.I();
            }
        }
    }

    public final void w(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048641, this, intent, z) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.f14583f.parseJson(stringExtra);
        this.f14583f.updateQuality();
        if (this.f14583f.getChosedFiles() != null) {
            z(false, null);
        }
    }

    public SpanGroupManager x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.f14585h : (SpanGroupManager) invokeV.objValue;
    }

    public WriteImagesInfo y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.f14583f : (WriteImagesInfo) invokeV.objValue;
    }

    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048644, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(0);
            pbEditorData.setContent(this.f14584g);
            pbEditorData.setWriteImagesInfo(this.f14583f);
            pbEditorData.setVoiceModel(this.f14586i);
            PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
            ForumData forumData = this.o;
            if (forumData != null) {
                threadData.setForumId(forumData.getId());
                threadData.setForumName(this.o.getName());
                threadData.setFirstDir(this.o.getFirst_class());
                threadData.setSecondDir(this.o.getSecond_class());
            }
            threadData.setAuthorId(this.v);
            threadData.setAuthorName(this.t);
            threadData.setAuthorNameShow(this.u);
            threadData.setPostId(this.w);
            threadData.setThreadId(this.q);
            threadData.isBJH = this.z;
            pbEditorData.setThreadData(threadData);
            pbEditorData.setDisableVoiceMessage(this.s);
            pbEditorData.setOpenVoiceRecordButton(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.r.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }
}
