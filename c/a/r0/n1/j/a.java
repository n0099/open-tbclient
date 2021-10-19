package c.a.r0.n1.j;

import c.a.e.e.p.k;
import c.a.q0.t.c.v;
import c.a.q0.x.x.e;
import c.a.r0.k3.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean N;
    public String O;
    public String P;
    public String Q;
    public PermissionJudgePolicy R;

    /* renamed from: c.a.r0.n1.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1049a implements c.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22444e;

        public C1049a(a aVar) {
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
            this.f22444e = aVar;
        }

        @Override // c.a.q0.x.b
        public void onAction(c.a.q0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f15111c;
                if (obj instanceof v) {
                    if (((v) obj).f() == EmotionGroupType.BIG_EMOTION || ((v) aVar.f15111c).f() == EmotionGroupType.USER_COLLECT) {
                        if (this.f22444e.R == null) {
                            this.f22444e.R = new PermissionJudgePolicy();
                        }
                        this.f22444e.R.clearRequestPermissionList();
                        this.f22444e.R.appendRequestPermission(this.f22444e.r.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f22444e.R.startRequestPermission(this.f22444e.r.getPageActivity())) {
                            return;
                        }
                        this.f22444e.h((v) aVar.f15111c);
                        this.f22444e.B(false, null);
                    }
                }
            }
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
        editorTools.setActionListener(24, new C1049a(this));
    }

    @Override // c.a.q0.x.x.e
    public void B(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(this.N ? 1 : 0);
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
            threadData.setPostId(this.O);
            threadData.setThreadId(this.q);
            threadData.isBJH = this.z;
            pbEditorData.setThreadData(threadData);
            pbEditorData.setDisableVoiceMessage(this.s);
            pbEditorData.setOpenVoiceRecordButton(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.r.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }

    public WriteData C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteData writeData = new WriteData();
            if (this.o != null) {
                if (this.D && !this.N) {
                    writeData.setCanNoForum(true);
                    writeData.setVForumId(this.o.getId());
                    writeData.setVForumName(this.o.getName());
                    writeData.setForumId("0");
                    writeData.setForumName("");
                } else {
                    writeData.setCanNoForum(false);
                    writeData.setVForumId("");
                    writeData.setVForumName("");
                    writeData.setForumId(this.o.getId());
                    writeData.setForumName(this.o.getName());
                }
            }
            writeData.setThreadId(this.q);
            if (!this.N) {
                writeData.setType(1);
            } else {
                writeData.setType(2);
                writeData.setFloor(this.O);
                writeData.setFloorNum(0);
                writeData.setReplyId(this.P);
                writeData.setRepostId(this.O);
            }
            return writeData;
        }
        return (WriteData) invokeV.objValue;
    }

    @Override // c.a.q0.x.x.e
    public void N(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, writeData) == null) {
            if (this.l.X() == null) {
                this.l.setWriteData(C0());
            }
            if (this.l.X() == null) {
                return;
            }
            this.l.setSpanGroupManager(this.f15177h);
            this.l.X().setIsBJHPost(this.z);
            this.l.X().setWriteImagesInfo(this.f15175f);
            boolean z = true;
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
            if ((bVar == null || !bVar.a()) && !this.l.l0()) {
            }
        }
    }

    @Override // c.a.q0.x.x.e
    public void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            WriteData X = this.l.X();
            if (X == null) {
                X = new WriteData(this.N ? 2 : 1);
                X.setThreadId(str);
                X.setWriteImagesInfo(this.f15175f);
            }
            if (!k.isEmpty(this.Q)) {
                X.setFromForumId(this.Q);
            }
            X.setContent(this.f15176g);
            X.setVoiceModel(this.f15178i);
            if (this.N) {
                X.setReplyId(this.P);
                X.setThreadId(this.O);
                z.t(this.O, X);
                return;
            }
            z.s(str, X);
        }
    }

    @Override // c.a.q0.x.x.e
    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (this.N) {
                z.l(this.O, this);
            } else {
                z.k(str, this);
            }
        }
    }
}
