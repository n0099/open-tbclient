package c.a.r0.t1.j;

import c.a.d.f.p.k;
import c.a.q0.t.c.w;
import c.a.q0.x.x.e;
import c.a.r0.t3.a0;
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
/* loaded from: classes6.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean N;
    public String O;
    public String P;
    public String Q;
    public PermissionJudgePolicy R;

    /* renamed from: c.a.r0.t1.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1361a implements c.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23609e;

        public C1361a(a aVar) {
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
            this.f23609e = aVar;
        }

        @Override // c.a.q0.x.b
        public void onAction(c.a.q0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f13679c;
                if (obj instanceof w) {
                    if (((w) obj).getType() == EmotionGroupType.BIG_EMOTION || ((w) aVar.f13679c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.f23609e.R == null) {
                            this.f23609e.R = new PermissionJudgePolicy();
                        }
                        this.f23609e.R.clearRequestPermissionList();
                        this.f23609e.R.appendRequestPermission(this.f23609e.r.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f23609e.R.startRequestPermission(this.f23609e.r.getPageActivity())) {
                            return;
                        }
                        this.f23609e.h((w) aVar.f13679c);
                        this.f23609e.z(false, null);
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
        editorTools.setActionListener(24, new C1361a(this));
    }

    public WriteData A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
    public void L(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, writeData) == null) {
            if (this.l.Y() == null) {
                this.l.setWriteData(A0());
            }
            if (this.l.Y() == null) {
                return;
            }
            this.l.setSpanGroupManager(this.f13735h);
            this.l.Y().setIsBJHPost(this.z);
            this.l.Y().setWriteImagesInfo(this.f13733f);
            boolean z = true;
            this.l.e0(this.f13733f.size() > 0);
            WriteData Y = this.l.Y();
            LocationModel locationModel = this.f13738k;
            Y.setHasLocationData((locationModel == null || !locationModel.z()) ? false : false);
            if (str == null) {
                this.l.Y().setContent(this.f13734g);
            }
            VoiceData$VoiceModel voiceData$VoiceModel = this.f13736i;
            if (voiceData$VoiceModel != null) {
                if (voiceData$VoiceModel.getId() != null) {
                    this.l.Y().setVoice(this.f13736i.getId());
                    this.l.Y().setVoiceDuringTime(this.f13736i.duration);
                } else {
                    this.l.Y().setVoice(null);
                    this.l.Y().setVoiceDuringTime(-1);
                }
            } else {
                this.l.Y().setVoice(null);
                this.l.Y().setVoiceDuringTime(-1);
            }
            if (!this.l.V()) {
                this.r.showToast(R.string.write_img_limit);
                return;
            }
            c.a.q0.x.x.b bVar = this.C;
            if ((bVar == null || !bVar.a()) && !this.l.n0()) {
            }
        }
    }

    @Override // c.a.q0.x.x.e
    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            WriteData Y = this.l.Y();
            if (Y == null) {
                Y = new WriteData(this.N ? 2 : 1);
                Y.setThreadId(str);
                Y.setWriteImagesInfo(this.f13733f);
            }
            if (!k.isEmpty(this.Q)) {
                Y.setFromForumId(this.Q);
            }
            Y.setContent(this.f13734g);
            Y.setVoiceModel(this.f13736i);
            if (this.N) {
                Y.setReplyId(this.P);
                Y.setThreadId(this.O);
                a0.t(this.O, Y);
                return;
            }
            a0.s(str, Y);
        }
    }

    @Override // c.a.q0.x.x.e
    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (this.N) {
                a0.l(this.O, this);
            } else {
                a0.k(str, this);
            }
        }
    }

    @Override // c.a.q0.x.x.e
    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(this.N ? 1 : 0);
            pbEditorData.setContent(this.f13734g);
            pbEditorData.setWriteImagesInfo(this.f13733f);
            pbEditorData.setVoiceModel(this.f13736i);
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
}
