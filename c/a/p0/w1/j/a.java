package c.a.p0.w1.j;

import c.a.d.f.p.m;
import c.a.o0.s.c.u;
import c.a.o0.w.y.e;
import c.a.p0.a4.b0;
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
    public boolean J;
    public String K;
    public String L;
    public String M;
    public PermissionJudgePolicy N;

    /* renamed from: c.a.p0.w1.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1487a implements c.a.o0.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1487a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.w.b
        public void onAction(c.a.o0.w.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f11499c;
                if (obj instanceof u) {
                    if (((u) obj).getType() == EmotionGroupType.BIG_EMOTION || ((u) aVar.f11499c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.a.N == null) {
                            this.a.N = new PermissionJudgePolicy();
                        }
                        this.a.N.clearRequestPermissionList();
                        this.a.N.appendRequestPermission(this.a.n.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.N.startRequestPermission(this.a.n.getPageActivity())) {
                            return;
                        }
                        this.a.h((u) aVar.f11499c);
                        this.a.z(false, null);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        editorTools.setActionListener(24, new C1487a(this));
    }

    public WriteData A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WriteData writeData = new WriteData();
            if (this.k != null) {
                if (this.z && !this.J) {
                    writeData.setCanNoForum(true);
                    writeData.setVForumId(this.k.getId());
                    writeData.setVForumName(this.k.getName());
                    writeData.setForumId("0");
                    writeData.setForumName("");
                } else {
                    writeData.setCanNoForum(false);
                    writeData.setVForumId("");
                    writeData.setVForumName("");
                    writeData.setForumId(this.k.getId());
                    writeData.setForumName(this.k.getName());
                }
            }
            writeData.setThreadId(this.m);
            if (!this.J) {
                writeData.setType(1);
            } else {
                writeData.setType(2);
                writeData.setFloor(this.K);
                writeData.setFloorNum(0);
                writeData.setReplyId(this.L);
                writeData.setRepostId(this.K);
            }
            return writeData;
        }
        return (WriteData) invokeV.objValue;
    }

    @Override // c.a.o0.w.y.e
    public void L(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, writeData) == null) {
            if (this.f11557h.b0() == null) {
                this.f11557h.setWriteData(A0());
            }
            if (this.f11557h.b0() == null) {
                return;
            }
            this.f11557h.setSpanGroupManager(this.f11553d);
            this.f11557h.b0().setIsBJHPost(this.v);
            this.f11557h.b0().setWriteImagesInfo(this.f11551b);
            boolean z = true;
            this.f11557h.i0(this.f11551b.size() > 0);
            WriteData b0 = this.f11557h.b0();
            LocationModel locationModel = this.f11556g;
            b0.setHasLocationData((locationModel == null || !locationModel.B()) ? false : false);
            if (str == null) {
                this.f11557h.b0().setContent(this.f11552c);
            }
            VoiceData.VoiceModel voiceModel = this.f11554e;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.f11557h.b0().setVoice(this.f11554e.getId());
                    this.f11557h.b0().setVoiceDuringTime(this.f11554e.duration);
                } else {
                    this.f11557h.b0().setVoice(null);
                    this.f11557h.b0().setVoiceDuringTime(-1);
                }
            } else {
                this.f11557h.b0().setVoice(null);
                this.f11557h.b0().setVoiceDuringTime(-1);
            }
            if (!this.f11557h.Y()) {
                this.n.showToast(R.string.obfuscated_res_0x7f0f1580);
                return;
            }
            c.a.o0.w.y.b bVar = this.y;
            if ((bVar == null || !bVar.a()) && !this.f11557h.r0()) {
            }
        }
    }

    @Override // c.a.o0.w.y.e
    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            WriteData b0 = this.f11557h.b0();
            if (b0 == null) {
                b0 = new WriteData(this.J ? 2 : 1);
                b0.setThreadId(str);
                b0.setWriteImagesInfo(this.f11551b);
            }
            if (!m.isEmpty(this.M)) {
                b0.setFromForumId(this.M);
            }
            b0.setContent(this.f11552c);
            b0.setVoiceModel(this.f11554e);
            if (this.J) {
                b0.setReplyId(this.L);
                b0.setThreadId(this.K);
                b0.z(this.K, b0);
                return;
            }
            b0.y(str, b0);
        }
    }

    @Override // c.a.o0.w.y.e
    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (this.J) {
                b0.p(this.K, this);
            } else {
                b0.o(str, this);
            }
        }
    }

    @Override // c.a.o0.w.y.e
    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(this.J ? 1 : 0);
            pbEditorData.setContent(this.f11552c);
            pbEditorData.setWriteImagesInfo(this.f11551b);
            pbEditorData.setVoiceModel(this.f11554e);
            PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
            ForumData forumData = this.k;
            if (forumData != null) {
                threadData.setForumId(forumData.getId());
                threadData.setForumName(this.k.getName());
                threadData.setFirstDir(this.k.getFirst_class());
                threadData.setSecondDir(this.k.getSecond_class());
            }
            threadData.setAuthorId(this.r);
            threadData.setAuthorName(this.p);
            threadData.setAuthorNameShow(this.q);
            threadData.setPostId(this.K);
            threadData.setThreadId(this.m);
            threadData.isBJH = this.v;
            pbEditorData.setThreadData(threadData);
            pbEditorData.setDisableVoiceMessage(this.o);
            pbEditorData.setOpenVoiceRecordButton(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.n.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }
}
