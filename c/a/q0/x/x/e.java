package c.a.q0.x.x;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import c.a.q0.s.s.a;
import c.a.q0.t.c.l0;
import c.a.q0.t.c.v;
import c.a.r0.k3.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
import com.baidu.tbadk.core.util.UtilHelper;
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
/* loaded from: classes3.dex */
public class e extends c.a.q0.x.e implements z.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewWriteModel.g A;
    public c.a.q0.x.x.c B;
    public c.a.q0.x.x.b C;
    public boolean D;
    public TextWatcher E;
    public c.a.q0.x.x.f F;
    public int G;
    public EditorTools H;
    public boolean I;
    public LocationModel.e J;
    public LocationModel.f K;
    public final NewWriteModel.g L;
    public final c.a.e.a.e M;

    /* renamed from: f  reason: collision with root package name */
    public WriteImagesInfo f15175f;

    /* renamed from: g  reason: collision with root package name */
    public String f15176g;

    /* renamed from: h  reason: collision with root package name */
    public SpanGroupManager f15177h;

    /* renamed from: i  reason: collision with root package name */
    public VoiceData$VoiceModel f15178i;

    /* renamed from: j  reason: collision with root package name */
    public String f15179j;
    public LocationModel k;
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

    /* loaded from: classes3.dex */
    public class a implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f15180a;

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
            this.f15180a = eVar;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15180a.r.showToast(R.string.no_network_guide);
                this.f15180a.d0(0, false, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.f15180a.d0(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.f15180a.I) {
                    TbPageContext tbPageContext = this.f15180a.r;
                    if (StringUtils.isNull(str)) {
                        str = this.f15180a.a().getContext().getString(R.string.location_fail);
                    }
                    tbPageContext.showToast(str);
                }
                this.f15180a.d0(0, false, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements LocationModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f15181a;

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
            this.f15181a = eVar;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15181a.d0(0, false, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f15181a.d0(2, true, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15182e;

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
                    return;
                }
            }
            this.f15182e = eVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f15182e.d0(0, true, null);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f15183e;

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
            this.f15183e = eVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (c.a.e.e.p.j.z()) {
                    this.f15183e.d0(1, true, null);
                    this.f15183e.k.K();
                } else {
                    this.f15183e.J.a();
                }
                aVar.dismiss();
            }
        }
    }

    /* renamed from: c.a.q0.x.x.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0720e implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f15184a;

        public C0720e(e eVar) {
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
            this.f15184a = eVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.f15184a.l.X();
                }
                if (z) {
                    this.f15184a.a0(true);
                    WriteData X = this.f15184a.l.X();
                    this.f15184a.U();
                    z.s(this.f15184a.q, null);
                    if (X == null) {
                        return;
                    }
                    if (X.getType() == 2) {
                        z.k(X.getThreadId(), this.f15184a);
                    }
                } else if (writeData != null && l0Var != null && !TextUtils.isEmpty(l0Var.d())) {
                    writeData.setVcodeMD5(l0Var.b());
                    writeData.setVcodeUrl(l0Var.c());
                    writeData.setVcodeExtra(l0Var.a());
                    if (this.f15184a.p != null) {
                        writeData.setBaijiahaoData(this.f15184a.p.L());
                    }
                    if (c.a.q0.e1.a.b(l0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f15184a.r.getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, false, l0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f15184a.r.getPageActivity(), writeData, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f15184a.r.getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
                }
                e eVar = this.f15184a;
                eVar.I(eVar.l.X());
                NewWriteModel.g gVar = this.f15184a.A;
                if (gVar != null) {
                    gVar.callback(z, postWriteCallBackData, l0Var, writeData, antiData);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends BdAsyncTask<Void, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f15185a;

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
            this.f15185a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                FileHelper.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + this.f15185a.f15179j));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f15186a;

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
            this.f15186a = eVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.f15186a.l.d0(true);
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
        this.f15175f = new WriteImagesInfo();
        this.f15176g = "";
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
        this.L = new C0720e(this);
        this.M = new g(this);
        this.H = editorTools;
    }

    public WriteImagesInfo A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15175f : (WriteImagesInfo) invokeV.objValue;
    }

    public void B(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(0);
            pbEditorData.setContent(this.f15176g);
            pbEditorData.setWriteImagesInfo(this.f15175f);
            pbEditorData.setVoiceModel(this.f15178i);
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

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.r.getPageActivity())));
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f15175f;
            return (writeImagesInfo == null || (chosedFiles = writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (StringUtils.isNull(this.f15176g)) {
                WriteImagesInfo writeImagesInfo = this.f15175f;
                if (writeImagesInfo == null || writeImagesInfo.size() <= 0) {
                    VoiceData$VoiceModel voiceData$VoiceModel = this.f15178i;
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

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            VoiceData$VoiceModel voiceData$VoiceModel = this.f15178i;
            return (voiceData$VoiceModel == null || TextUtils.isEmpty(voiceData$VoiceModel.voiceId) || this.f15178i.duration <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.I = false;
        }
    }

    public void H(TbPageContext tbPageContext, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, tbPageContext, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
            this.l = newWriteModel;
            newWriteModel.h0(this.L);
            ImageModel imageModel = new ImageModel(tbPageContext);
            this.m = imageModel;
            imageModel.setLoadDataCallBack(this.M);
            LocationModel locationModel = new LocationModel(tbPageContext);
            this.k = locationModel;
            locationModel.N(this.J);
            this.k.O(this.K);
            if (bundle != null) {
                this.f15175f.parseJson(bundle.getString("write_images"));
                this.f15179j = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            WriteImagesInfo writeImagesInfo = this.f15175f;
            if (writeImagesInfo != null) {
                writeImagesInfo.setMaxImagesAllowed(this.z ? 1 : 9);
            }
            if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
                a().sendAction(new c.a.q0.x.a(2, 12, " "));
            }
            if (!this.k.z() && a() != null) {
                a().sendAction(new c.a.q0.x.a(20, 8, null));
            }
            WriteImagesInfo writeImagesInfo2 = this.f15175f;
            if (writeImagesInfo2 == null || writeImagesInfo2.getChosedFiles() == null || this.f15175f.getChosedFiles().size() <= 0) {
                return;
            }
            EditorTools a2 = a();
            a2.sendAction(new c.a.q0.x.a(2, 10, this.f15175f.getChosedFiles().size() + ""));
        }
    }

    public void I(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, writeData) == null) || writeData == null) {
            return;
        }
        this.f15175f = new WriteImagesInfo();
        if (writeData.getWriteImagesInfo() != null) {
            this.f15175f.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.f15175f;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.f15175f.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.sendAction(new c.a.q0.x.a(2, 10, this.f15175f.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.f15175f;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().sendAction(new c.a.q0.x.a(2, 10, null));
        }
        String content = writeData.getContent();
        this.f15176g = content;
        c0(content);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void J(int i2, int i3, Intent intent) {
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i3 != -1) {
                if (i2 == 12001) {
                    n();
                } else if (i2 == 12002) {
                    if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        return;
                    }
                    this.f15175f.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                } else if (i2 != 12006) {
                } else {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                    NewWriteModel.g gVar = this.A;
                    if (gVar != null) {
                        gVar.callback(false, postWriteCallBackData2, null, this.l.X(), null);
                    }
                }
            } else if (i2 == 11001) {
                N(null, null);
            } else if (i2 == 12006) {
                WriteData X = this.l.X();
                PostWriteCallBackData postWriteCallBackData3 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (X != null) {
                    X.deleteUploadedTempImages();
                }
                this.l.setWriteData(null);
                this.l.d0(false);
                this.f15178i = null;
                this.y = null;
                if (!TextUtils.isEmpty(this.q)) {
                    z.s(this.q, null);
                }
                a0(true);
                NewWriteModel.g gVar2 = this.A;
                if (gVar2 != null) {
                    gVar2.callback(true, postWriteCallBackData3, null, X, null);
                }
            } else if (i2 == 12012) {
                v(intent);
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
                    e0();
                    a().sendAction(new c.a.q0.x.a(28, 20, this.y));
                    a().sendAction(new c.a.q0.x.a(28, -1, this.y));
                }
            } else if (i2 == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            } else if (i2 == 25004) {
                if (intent != null) {
                    Y(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                }
            } else if (i2 == 11025) {
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.r.getPageActivity(), 12004, true);
                if (y() != null) {
                    atListActivityConfig.setSelectedAtList(y().w());
                }
                d2 d2Var = this.p;
                if (d2Var != null) {
                    atListActivityConfig.setFromTid(d2Var.s1());
                    atListActivityConfig.setFromFid(String.valueOf(this.p.T()));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                d2 d2Var2 = this.p;
                if (d2Var2 != null) {
                    statisticItem2.addParam("tid", d2Var2.s1());
                    statisticItem2.addParam("fid", this.p.T());
                }
                TiebaStatic.log(statisticItem2);
            } else if (i2 == 11026) {
                AtListActivityConfig atListActivityConfig2 = new AtListActivityConfig(this.r.getPageActivity(), CyberPlayerManager.MEDIA_INFO_WEAK_NETWORK_BEST_RANK, true);
                if (y() != null) {
                    atListActivityConfig2.setSelectedAtList(y().w());
                }
                d2 d2Var3 = this.p;
                if (d2Var3 != null) {
                    atListActivityConfig2.setFromTid(d2Var3.s1());
                    atListActivityConfig2.setFromFid(String.valueOf(this.p.T()));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig2));
                StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem3.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                d2 d2Var4 = this.p;
                if (d2Var4 != null) {
                    statisticItem3.addParam("tid", d2Var4.s1());
                    statisticItem3.addParam("fid", this.p.T());
                }
                TiebaStatic.log(statisticItem3);
            } else if (i2 == 12009 || i2 == 12010) {
                if (i2 == 12010) {
                    r(intent);
                }
            } else {
                switch (i2) {
                    case 12002:
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
                            Z();
                            this.l.d0(false);
                            return;
                        }
                        this.m.B(intent.getStringExtra("file_name"));
                        return;
                    case 12004:
                        if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) == null) {
                            return;
                        }
                        X(parcelableArrayListExtra);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.l.cancelLoadData();
            this.m.cancelLoadData();
            this.k.cancelLoadData();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!PermissionUtil.checkLocationForGoogle(this.r.getPageActivity())) {
                PermissionUtil.reuqestLocation(this.r.getPageActivity(), 0);
            } else {
                x0();
            }
        }
    }

    public void M(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            WriteImagesInfo writeImagesInfo = this.f15175f;
            if (writeImagesInfo != null) {
                bundle.putString("write_images", writeImagesInfo.toJsonString());
            }
            bundle.putString(WriteActivityConfig.PHOTO_NAME, this.f15179j);
        }
    }

    public void N(String str, WriteData writeData) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, writeData) == null) {
            if (this.l.X() == null) {
                WriteData D = this.n.D(str);
                if (D != null && (d2Var = this.p) != null) {
                    D.setBaijiahaoData(d2Var.L());
                }
                this.l.setWriteData(D);
            }
            if (this.l.X() == null) {
                return;
            }
            this.l.setSpanGroupManager(this.f15177h);
            boolean z = true;
            if (this.D) {
                this.l.X().setCanNoForum(true);
                if (this.o != null) {
                    this.l.X().setVForumId(this.o.getId());
                    this.l.X().setVForumName(this.o.getName());
                }
            } else {
                this.l.X().setCanNoForum(false);
                this.l.X().setVForumId("");
                this.l.X().setVForumName("");
            }
            this.l.X().setIsBJHPost(this.z);
            this.l.X().setWriteImagesInfo(this.f15175f);
            this.l.X().setVideoInfo(this.y);
            this.l.d0(this.f15175f.size() > 0);
            WriteData X = this.l.X();
            LocationModel locationModel = this.k;
            X.setHasLocationData((locationModel == null || !locationModel.z()) ? false : false);
            if (str == null) {
                this.l.X().setContent(this.f15176g);
            }
            VoiceData$VoiceModel voiceData$VoiceModel = this.f15178i;
            if (voiceData$VoiceModel != null) {
                if (voiceData$VoiceModel.getId() != null) {
                    this.l.X().setVoice(this.f15178i.getId());
                    this.l.X().setVoiceDuringTime(this.f15178i.duration);
                } else {
                    this.l.X().setVoice(null);
                    this.l.X().setVoiceDuringTime(-1);
                }
            } else {
                this.l.X().setVoice(null);
                this.l.X().setVoiceDuringTime(-1);
            }
            if (!this.l.U()) {
                this.r.showToast(R.string.write_img_limit);
                return;
            }
            c.a.q0.x.x.b bVar = this.C;
            if (bVar == null || !bVar.a()) {
                c.a.q0.x.x.c cVar = this.B;
                if (cVar != null) {
                    cVar.a();
                }
                p(this.l.X());
                o();
                if (!this.l.l0()) {
                }
            }
        }
    }

    public void O(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, antiData) == null) || antiData == null) {
            return;
        }
        this.s = antiData.getVoice_message();
    }

    public void P(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, forumData, userData) == null) {
            this.o = forumData;
        }
    }

    public void Q(MetaData metaData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048592, this, metaData, str, str2) == null) || a() == null || metaData == null) {
            return;
        }
        this.v = metaData.getUserIdLong();
        this.t = metaData.getUserName();
        this.u = metaData.getName_show();
        this.q = str;
        this.w = str2;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.z || this.k == null || c.a.r0.k3.n0.b.a().d() || !UtilHelper.isSystemLocationProviderEnabled(this.r.getPageActivity()) || !TbadkCoreApplication.getInst().getLocationShared()) {
            return;
        }
        this.k.H();
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.k.z()) {
                if (this.k.D()) {
                    this.J.b(c.a.r0.k3.n0.b.a().b());
                    return;
                }
                if (l.D()) {
                    this.k.H();
                }
                d0(0, true, null);
                return;
            }
            d0(0, false, null);
        }
    }

    public void T() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (editorTools = this.H) == null) {
            return;
        }
        editorTools.resetChangeToLauncher();
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.l.setWriteData(null);
            this.l.d0(false);
            this.f15178i = null;
            this.y = null;
            this.f15175f.clear();
        }
    }

    public void V() {
        c.a.q0.x.x.f fVar;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (fVar = this.F) == null || (textWatcher = this.E) == null) {
            return;
        }
        fVar.j(textWatcher);
    }

    public void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            WriteData X = this.l.X();
            if (X == null) {
                X = new WriteData(1);
                X.setThreadId(str);
                X.setWriteImagesInfo(this.f15175f);
            }
            X.setContent(this.f15176g);
            X.setVideoInfo(this.y);
            X.setVoiceModel(this.f15178i);
            z.s(str, X);
        }
    }

    public final void X(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, arrayList) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.q0.x.a(17, 27, arrayList));
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.q0.x.a(44, 27, str));
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.q0.x.a(13, -1, null));
    }

    public final void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || a() == null) {
            return;
        }
        if (z) {
            a().sendAction(new c.a.q0.x.a(2, 10, null));
            a().sendAction(new c.a.q0.x.a(2, 6, null));
        }
        a().sendAction(new c.a.q0.x.a(9, -1, Boolean.valueOf(z)));
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || StringUtils.isNull(this.t)) {
            return;
        }
        long j2 = this.v;
        if (j2 <= 0) {
            return;
        }
        if (String.valueOf(j2).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            l.L(this.r.getPageActivity(), R.string.can_not_send_gift_to_yourself);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.r.getPageActivity(), this.v, this.t, this.u, GiftTabActivityConfig.FROM_PB, c.a.e.e.m.b.g(this.q, 0L), c.a.e.e.m.b.g(this.w, 0L))));
    }

    public final void c0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.q0.x.a(6, 27, str));
    }

    public final void d0(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.x = i2;
            if (a() != null) {
                a().sendAction(new c.a.q0.x.a(19, 27, new c.a.q0.x.v.a(i2, z, str)));
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || a() == null) {
            return;
        }
        a().sendAction(new c.a.q0.x.a(2, 19, " "));
    }

    public void f0(c.a.q0.x.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bVar) == null) {
            this.C = bVar;
        }
    }

    public void g0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, tbPageContext) == null) {
            this.r = tbPageContext;
        }
    }

    public void h(v vVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, vVar) == null) || vVar == null) {
            return;
        }
        if (vVar.f() == EmotionGroupType.BIG_EMOTION || vVar.f() == EmotionGroupType.USER_COLLECT) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setImageType(1);
            imageFileInfo.setFilePath(vVar.c());
            imageFileInfo.width = vVar.h();
            imageFileInfo.height = vVar.b();
            this.f15175f.addChooseFile(imageFileInfo);
            this.f15175f.updateQuality();
        }
    }

    public void h0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().findLauncherById(5)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public void i(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, textWatcher) == null) {
            k();
            c.a.q0.x.x.f fVar = this.F;
            if (fVar == null || textWatcher == null) {
                return;
            }
            fVar.g(textWatcher);
        }
    }

    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.G = i2;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            if (this.F == null && a() != null) {
                this.F = (c.a.q0.x.x.f) a().findToolById(27);
            }
            c.a.q0.x.x.f fVar = this.F;
            if (fVar != null) {
                fVar.h(i2);
            }
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.D = z;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && this.F == null && a() != null) {
            this.F = (c.a.q0.x.x.f) a().findToolById(27);
        }
    }

    public void k0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048616, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().findLauncherById(23)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            WriteImagesInfo writeImagesInfo = this.f15175f;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.f15175f.clear();
            }
            VideoInfo videoInfo = this.y;
            if (videoInfo != null && videoInfo.isAvaliable()) {
                this.y = null;
            }
            a().sendAction(new c.a.q0.x.a(2, 19, null));
            v0(null);
            a().sendAction(new c.a.q0.x.a(2, 6, null));
            a().sendAction(new c.a.q0.x.a(33, 6, null));
            if (!StringUtils.isNull(this.f15176g)) {
                this.f15176g = "";
            }
            c0("");
            this.l.setWriteData(null);
            this.l.d0(false);
        }
    }

    public void l0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, dataModel) == null) {
            this.n = dataModel;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.y = null;
        }
    }

    public void m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            if (this.F == null && a() != null) {
                this.F = (c.a.q0.x.x.f) a().findToolById(27);
            }
            c.a.q0.x.x.f fVar = this.F;
            if (fVar != null) {
                fVar.l(str);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            new f(this).execute(new Void[0]);
        }
    }

    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            if (this.F == null && a() != null) {
                this.F = (c.a.q0.x.x.f) a().findToolById(27);
            }
            c.a.q0.x.x.f fVar = this.F;
            if (fVar != null) {
                fVar.m(i2);
            }
        }
    }

    public final void o() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || this.p == null || (dataModel = this.n) == null || !dataModel.F()) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_COMMENT);
        statisticItem.addParam("obj_locate", 1);
        if (this.p.F2()) {
            statisticItem.addParam("obj_type", 3);
        } else if (this.p.E2()) {
            statisticItem.addParam("obj_type", 2);
        } else {
            statisticItem.addParam("obj_type", 1);
        }
        statisticItem.addParam("tid", this.p.s1());
        statisticItem.addParam(TiebaStatic.Params.FID_1, this.p.T());
        statisticItem.addParam(TiebaStatic.Params.FID_2, this.n.getFromForumId());
        TiebaStatic.log(statisticItem);
        c.a.q0.d.a.a(c.a.q0.d.a.f12832f, c.a.q0.d.a.f12829c, this.n.B(), this.n.C(), this.n.A(), this.p.T1);
    }

    public void o0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.f15176g = str;
        }
    }

    @Override // c.a.r0.k3.z.e
    public void onDraftLoaded(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, writeData) == null) || writeData == null) {
            return;
        }
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            if (this.y == null) {
                this.y = new VideoInfo();
            }
            this.y.copy(writeData.getVideoInfo());
            e0();
            a().sendAction(new c.a.q0.x.a(39, -1, this.y));
        }
        if (writeData.getWriteImagesInfo() != null && this.f15175f.size() == 0) {
            this.f15175f.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.f15175f;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.f15175f.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.sendAction(new c.a.q0.x.a(2, 10, this.f15175f.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.f15175f;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().sendAction(new c.a.q0.x.a(2, 10, null));
        }
        if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
            if (this.f15178i == null) {
                this.f15178i = new VoiceData$VoiceModel();
            }
            this.f15178i.copy(writeData.getVoiceModel());
        }
        if (!k.isEmpty(writeData.getContent()) && k.isEmpty(this.f15176g)) {
            String content = writeData.getContent();
            this.f15176g = content;
            c0(content);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void p(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, writeData) == null) || writeData == null) {
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

    public void p0(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, gVar) == null) {
            this.A = gVar;
        }
    }

    public final void q(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, intent) == null) {
            x(intent, true);
        }
    }

    public void q0(c.a.q0.x.x.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, cVar) == null) {
            this.B = cVar;
        }
    }

    public final void r(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, intent) == null) {
            this.f15179j = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.f15179j;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.e(this.r.getPageActivity(), l.k(this.r.getPageActivity())), l.e(this.r.getPageActivity(), l.i(this.r.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, this.f15179j, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception unused) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.f15175f.addChooseFile(imageFileInfo);
            this.f15175f.updateQuality();
            B(false, null);
        }
    }

    public void r0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048631, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().findLauncherById(2)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public TbPageContext s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.r : (TbPageContext) invokeV.objValue;
    }

    public void s0(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, spanGroupManager) == null) {
            this.f15177h = spanGroupManager;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            z.k(str, this);
        }
    }

    public void t0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, d2Var) == null) {
            this.p = d2Var;
            if (a() == null || this.p == null) {
                return;
            }
            a().setFid(this.p.T());
            a().setTid(this.p.s1());
        }
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.x : invokeV.intValue;
    }

    public void u0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.q = str;
        }
    }

    public final void v(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, intent) == null) {
            x(intent, false);
        }
    }

    public void v0(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, voiceData$VoiceModel) == null) {
            this.f15178i = voiceData$VoiceModel;
        }
    }

    public c.a.q0.x.x.f w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (this.F == null && a() != null) {
                this.F = (c.a.q0.x.x.f) a().findToolById(27);
            }
            return this.F;
        }
        return (c.a.q0.x.x.f) invokeV.objValue;
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.r.getPageActivity());
            aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new d(this)).setNegativeButton(R.string.cancel, new c(this)).create(this.r);
            aVar.show();
        }
    }

    public final void x(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048642, this, intent, z) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.f15175f.parseJson(stringExtra);
        this.f15175f.updateQuality();
        if (this.f15175f.getChosedFiles() != null) {
            B(false, null);
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            if (!UtilHelper.isSystemLocationProviderEnabled(this.r.getPageActivity())) {
                this.r.showToast(R.string.location_system_permission_prompt);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                w0();
            } else if (this.k.D()) {
                C();
            } else {
                this.k.M(false);
                d0(1, true, null);
                this.k.H();
            }
        }
    }

    public SpanGroupManager y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.f15177h : (SpanGroupManager) invokeV.objValue;
    }

    public VideoInfo z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.y : (VideoInfo) invokeV.objValue;
    }
}
