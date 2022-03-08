package c.a.r0.u1.j;

import c.a.d.f.p.m;
import c.a.q0.s.c.u;
import c.a.q0.w.y.e;
import c.a.r0.y3.b0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
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
/* loaded from: classes2.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean N;
    public String O;
    public String P;
    public String Q;
    public PermissionJudgePolicy R;

    /* renamed from: c.a.r0.u1.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1432a implements c.a.q0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22939e;

        public C1432a(a aVar) {
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
            this.f22939e = aVar;
        }

        @Override // c.a.q0.w.b
        public void onAction(c.a.q0.w.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f13989c;
                if (obj instanceof u) {
                    if (((u) obj).getType() == EmotionGroupType.BIG_EMOTION || ((u) aVar.f13989c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.f22939e.R == null) {
                            this.f22939e.R = new PermissionJudgePolicy();
                        }
                        this.f22939e.R.clearRequestPermissionList();
                        this.f22939e.R.appendRequestPermission(this.f22939e.r.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f22939e.R.startRequestPermission(this.f22939e.r.getPageActivity())) {
                            return;
                        }
                        this.f22939e.h((u) aVar.f13989c);
                        this.f22939e.z(false, null);
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
        editorTools.setActionListener(24, new C1432a(this));
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

    @Override // c.a.q0.w.y.e
    public void L(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, writeData) == null) {
            if (this.l.Z() == null) {
                this.l.setWriteData(A0());
            }
            if (this.l.Z() == null) {
                return;
            }
            this.l.setSpanGroupManager(this.f14052h);
            this.l.Z().setIsBJHPost(this.z);
            this.l.Z().setWriteImagesInfo(this.f14050f);
            boolean z = true;
            this.l.g0(this.f14050f.size() > 0);
            WriteData Z = this.l.Z();
            LocationModel locationModel = this.k;
            Z.setHasLocationData((locationModel == null || !locationModel.z()) ? false : false);
            if (str == null) {
                this.l.Z().setContent(this.f14051g);
            }
            VoiceData.VoiceModel voiceModel = this.f14053i;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.l.Z().setVoice(this.f14053i.getId());
                    this.l.Z().setVoiceDuringTime(this.f14053i.duration);
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
            c.a.q0.w.y.b bVar = this.C;
            if ((bVar == null || !bVar.a()) && !this.l.p0()) {
            }
        }
    }

    @Override // c.a.q0.w.y.e
    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            WriteData Z = this.l.Z();
            if (Z == null) {
                Z = new WriteData(this.N ? 2 : 1);
                Z.setThreadId(str);
                Z.setWriteImagesInfo(this.f14050f);
            }
            if (!m.isEmpty(this.Q)) {
                Z.setFromForumId(this.Q);
            }
            Z.setContent(this.f14051g);
            Z.setVoiceModel(this.f14053i);
            if (this.N) {
                Z.setReplyId(this.P);
                Z.setThreadId(this.O);
                b0.z(this.O, Z);
                return;
            }
            b0.y(str, Z);
        }
    }

    @Override // c.a.q0.w.y.e
    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (this.N) {
                b0.p(this.O, this);
            } else {
                b0.o(str, this);
            }
        }
    }

    @Override // c.a.q0.w.y.e
    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(this.N ? 1 : 0);
            pbEditorData.setContent(this.f14051g);
            pbEditorData.setWriteImagesInfo(this.f14050f);
            pbEditorData.setVoiceModel(this.f14053i);
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
