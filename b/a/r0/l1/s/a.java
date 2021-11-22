package b.a.r0.l1.s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.c1.i0;
import b.a.q0.c1.l0;
import b.a.q0.c1.q;
import b.a.q0.d0.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.im.data.PicMessageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.sendmessage.VoiceSendModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f21867h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Long f21868i;
    public static volatile long j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<ChatMessage> f21869a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, b.a.q0.d0.a<ChatMessage>> f21870b;

    /* renamed from: c  reason: collision with root package name */
    public a.d f21871c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.l1.s.d f21872d;

    /* renamed from: e  reason: collision with root package name */
    public VoiceSendModel f21873e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<a.b<ChatMessage>> f21874f;

    /* renamed from: g  reason: collision with root package name */
    public VoiceSendModel.b f21875g;

    /* renamed from: b.a.r0.l1.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1079a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21876a;

        /* renamed from: b.a.r0.l1.s.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1080a extends i0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f21877a;

            public C1080a(C1079a c1079a, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1079a, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21877a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // b.a.q0.c1.i0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(b.a.r0.l1.h.c.h().o(this.f21877a.getGroupId(), String.valueOf(this.f21877a.getRecordId()), String.valueOf(this.f21877a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* renamed from: b.a.r0.l1.s.a$a$b */
        /* loaded from: classes5.dex */
        public class b implements q<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f21878a;

            public b(C1079a c1079a, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1079a, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21878a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.q0.c1.q
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f21878a);
                }
            }
        }

        /* renamed from: b.a.r0.l1.s.a$a$c */
        /* loaded from: classes5.dex */
        public class c extends i0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f21879a;

            public c(C1079a c1079a, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1079a, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21879a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // b.a.q0.c1.i0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(b.a.r0.l1.h.m.t().s(this.f21879a.getUserId(), this.f21879a.getToUserId(), String.valueOf(this.f21879a.getRecordId()), String.valueOf(this.f21879a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* renamed from: b.a.r0.l1.s.a$a$d */
        /* loaded from: classes5.dex */
        public class d implements q<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f21880a;

            public d(C1079a c1079a, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1079a, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21880a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.q0.c1.q
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f21880a);
                }
            }
        }

        /* renamed from: b.a.r0.l1.s.a$a$e */
        /* loaded from: classes5.dex */
        public class e extends i0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f21881a;

            public e(C1079a c1079a, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1079a, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21881a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // b.a.q0.c1.i0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(b.a.r0.l1.h.l.t().s(this.f21881a.getUserId(), this.f21881a.getToUserId(), String.valueOf(this.f21881a.getRecordId()), String.valueOf(this.f21881a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* renamed from: b.a.r0.l1.s.a$a$f */
        /* loaded from: classes5.dex */
        public class f implements q<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f21882a;

            public f(C1079a c1079a, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1079a, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21882a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.q0.c1.q
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f21882a);
                }
            }
        }

        public C1079a(a aVar) {
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
            this.f21876a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0094, code lost:
            b.a.q0.s.a0.a.a("im", r0.getClientLogID(), r0.getCmd(), "up_pic_ret", r13.error_code, r13.error_msg, new java.lang.Object[0]);
         */
        @Override // b.a.q0.d0.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void a(String str, ImageUploadResult imageUploadResult) {
            b.a.q0.d0.a aVar;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, imageUploadResult) == null) {
                synchronized (this) {
                    synchronized (a.class) {
                        aVar = (b.a.q0.d0.a) this.f21876a.f21870b.remove(str);
                    }
                    if (aVar == null) {
                        return;
                    }
                    ChatMessage chatMessage = (ChatMessage) aVar.f();
                    if (chatMessage == null) {
                        return;
                    }
                    int i3 = 0;
                    if (imageUploadResult != null && imageUploadResult.error_code == 0 && imageUploadResult.picInfo != null) {
                        b.a.q0.s.a0.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", 0, null, new Object[0]);
                        String str2 = null;
                        String str3 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                        if (imageUploadResult.picInfo.smallPic != null) {
                            str2 = imageUploadResult.picInfo.smallPic.picUrl;
                            i3 = imageUploadResult.picInfo.smallPic.width;
                            i2 = imageUploadResult.picInfo.smallPic.height;
                            this.f21876a.s(str, str2);
                        } else {
                            i2 = 0;
                        }
                        chatMessage.setContent(a.f(str3, str2, i3, i2));
                        a.j().t(chatMessage);
                        if (this.f21876a.f21872d != null) {
                            this.f21876a.f21872d.a(1);
                        }
                    }
                    b.a.q0.s.a0.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        l0.c(new C1080a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
                    } else if (chatMessage instanceof PersonalChatMessage) {
                        PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        l0.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        l0.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends i0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f21883a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f21884b;

        public b(a aVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, commonGroupChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21883a = commonGroupChatMessage;
            this.f21884b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // b.a.q0.c1.i0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(b.a.r0.l1.h.c.h().l(this.f21883a.getGroupId(), this.f21884b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f21885a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f21886b;

        public c(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, commonGroupChatMessage, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21885a = commonGroupChatMessage;
            this.f21886b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f21885a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.f21885a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.f21885a.getGroupId(), this.f21886b.getCustomGroupType(), this.f21886b, 3)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends i0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f21887a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f21888b;

        public d(a aVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, personalChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21887a = personalChatMessage;
            this.f21888b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // b.a.q0.c1.i0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(b.a.r0.l1.h.m.t().m(b.a.r0.l1.w.c.m(this.f21887a), this.f21888b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f21889a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f21890b;

        public e(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, personalChatMessage, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21889a = personalChatMessage;
            this.f21890b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f21889a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.f21889a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f21889a.getToUserId()), 2, this.f21890b, 3)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends i0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f21891a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f21892b;

        public f(a aVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, officialChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21891a = officialChatMessage;
            this.f21892b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // b.a.q0.c1.i0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(b.a.r0.l1.h.l.t().m(b.a.r0.l1.w.c.m(this.f21891a), this.f21892b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f21893a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f21894b;

        public g(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, officialChatMessage, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21893a = officialChatMessage;
            this.f21894b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f21893a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.f21893a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f21893a.getToUserId()), 4, this.f21894b, 3)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements VoiceSendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21895a;

        /* renamed from: b.a.r0.l1.s.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1081a extends i0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f21896a;

            public C1081a(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21896a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // b.a.q0.c1.i0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(b.a.r0.l1.h.c.h().o(this.f21896a.getGroupId(), String.valueOf(this.f21896a.getRecordId()), String.valueOf(this.f21896a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements q<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f21897a;

            public b(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21897a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.q0.c1.q
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f21897a);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c extends i0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f21898a;

            public c(h hVar, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21898a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // b.a.q0.c1.i0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(b.a.r0.l1.h.m.t().s(this.f21898a.getUserId(), this.f21898a.getToUserId(), String.valueOf(this.f21898a.getRecordId()), String.valueOf(this.f21898a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class d implements q<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f21899a;

            public d(h hVar, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21899a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.q0.c1.q
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f21899a);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class e extends i0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f21900a;

            public e(h hVar, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21900a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // b.a.q0.c1.i0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(b.a.r0.l1.h.l.t().s(this.f21900a.getUserId(), this.f21900a.getToUserId(), String.valueOf(this.f21900a.getRecordId()), String.valueOf(this.f21900a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class f implements q<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f21901a;

            public f(h hVar, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21901a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.q0.c1.q
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f21901a);
                }
            }
        }

        public h(a aVar) {
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
            this.f21895a = aVar;
        }

        @Override // com.baidu.tieba.im.sendmessage.VoiceSendModel.b
        public void a(String str, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, chatMessage) == null) {
                try {
                    a.j().q(chatMessage);
                    if (chatMessage != null) {
                        if (str != null && str.length() > 0) {
                            VoiceMsgData n = b.a.r0.l1.w.c.n(chatMessage);
                            if (n != null) {
                                n.setVoice_md5(str);
                                String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
                                chatMessage.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                            }
                            b.a.q0.s.a0.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                            a.j().t(chatMessage);
                            if (this.f21895a.f21872d != null) {
                                this.f21895a.f21872d.a(2);
                                return;
                            }
                            return;
                        }
                        b.a.q0.s.a0.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                        if (chatMessage instanceof CommonGroupChatMessage) {
                            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                            l0.c(new C1081a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
                        } else if (chatMessage instanceof PersonalChatMessage) {
                            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                            l0.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
                        } else if (chatMessage instanceof OfficialChatMessage) {
                            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                            l0.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends BdAsyncTask<Void, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21902a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21903b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f21904c;

        public i(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21904c = aVar;
            this.f21902a = str;
            this.f21903b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? BitmapFactory.decodeFile(this.f21902a) : (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                this.f21904c.r(this.f21903b, new b.a.e.m.d.a(bitmap, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends i0<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21905a;

        public j(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21905a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.i0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.r0.l1.h.c.h().f(this.f21905a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements q<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.l1.s.c f21906a;

        public k(a aVar, b.a.r0.l1.s.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21906a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedHashMap) == null) {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (String str : linkedHashMap.keySet()) {
                        arrayList.add(str);
                    }
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        String str3 = linkedHashMap.get(str2);
                        String f2 = b.a.r0.l1.w.c.f(str3, true);
                        if (f2 != null) {
                            linkedHashMap2.put(str2, f2);
                        }
                        String f3 = b.a.r0.l1.w.c.f(str3, false);
                        if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = f3;
                            imageUrlData.urlType = 10;
                            hashMap.put(f2, imageUrlData);
                        }
                    }
                }
                this.f21906a.a(linkedHashMap2, hashMap);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends i0<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21907a;

        public l(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21907a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.i0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.r0.l1.h.m.t().f(this.f21907a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class m implements q<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.l1.s.c f21908a;

        public m(a aVar, b.a.r0.l1.s.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21908a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedHashMap) == null) {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (String str : linkedHashMap.keySet()) {
                        arrayList.add(str);
                    }
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        String str3 = linkedHashMap.get(str2);
                        String f2 = b.a.r0.l1.w.c.f(str3, true);
                        if (f2 != null) {
                            linkedHashMap2.put(str2, f2);
                        }
                        String f3 = b.a.r0.l1.w.c.f(str3, false);
                        if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = f3;
                            imageUrlData.urlType = 10;
                            hashMap.put(f2, imageUrlData);
                        }
                    }
                }
                this.f21908a.a(linkedHashMap2, hashMap);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends i0<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21909a;

        public n(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21909a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.i0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.r0.l1.h.l.t().f(this.f21909a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class o implements q<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.l1.s.c f21910a;

        public o(a aVar, b.a.r0.l1.s.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21910a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedHashMap) == null) {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (String str : linkedHashMap.keySet()) {
                        arrayList.add(str);
                    }
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        String str3 = linkedHashMap.get(str2);
                        String f2 = b.a.r0.l1.w.c.f(str3, true);
                        if (f2 != null) {
                            linkedHashMap2.put(str2, f2);
                        }
                        String f3 = b.a.r0.l1.w.c.f(str3, false);
                        if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = f3;
                            imageUrlData.urlType = 10;
                            hashMap.put(f2, imageUrlData);
                        }
                    }
                }
                this.f21910a.a(linkedHashMap2, hashMap);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2110758102, "Lb/a/r0/l1/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2110758102, "Lb/a/r0/l1/s/a;");
                return;
            }
        }
        f21868i = 0L;
        j = 0L;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21869a = new LinkedList<>();
        this.f21870b = new HashMap<>();
        this.f21875g = new h(this);
        k();
    }

    public static String f(String str, String str2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65543, null, str, str2, i2, i3)) == null) {
            PicMessageData picMessageData = new PicMessageData();
            picMessageData.src = str2;
            picMessageData.big_src = str;
            picMessageData.type = "3";
            if (i2 > 0) {
                picMessageData.bsize = i2 + "," + i3;
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(OrmObject.jsonWithObject(picMessageData));
            return jSONArray.toString();
        }
        return (String) invokeLLII.objValue;
    }

    public static a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f21867h == null) {
                synchronized (a.class) {
                    if (f21867h == null) {
                        f21867h = new a();
                    }
                }
            }
            return f21867h;
        }
        return (a) invokeV.objValue;
    }

    public static void m(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, chatMessage) == null) {
            String groupId = chatMessage.getGroupId();
            if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                groupId = String.valueOf(chatMessage.getToUserId());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(groupId, chatMessage.getCustomGroupType(), chatMessage, 3)));
        }
    }

    public static void w(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65546, null, j2) == null) {
            j = j2;
        }
    }

    public static void x(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65547, null, j2) == null) {
            f21868i = Long.valueOf(j2);
        }
    }

    public boolean g(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chatMessage)) == null) {
            HashMap<String, b.a.q0.d0.a<ChatMessage>> hashMap = this.f21870b;
            if (hashMap != null && chatMessage != null) {
                for (Map.Entry<String, b.a.q0.d0.a<ChatMessage>> entry : hashMap.entrySet()) {
                    b.a.q0.d0.a<ChatMessage> value = entry.getValue();
                    if (value != null && value.f() != null) {
                        ChatMessage f2 = value.f();
                        if (chatMessage.getRecordId() != f2.getRecordId()) {
                            continue;
                        } else if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                            if (chatMessage.getGroupId() != null && f2.getGroupId() != null && chatMessage.getGroupId().equals(f2.getGroupId())) {
                                WeakReference<a.b<ChatMessage>> weakReference = this.f21874f;
                                if (weakReference != null && weakReference.get() != null) {
                                    value.m(this.f21874f.get());
                                }
                                return true;
                            }
                        } else if (chatMessage.getToUserId() == f2.getToUserId()) {
                            WeakReference<a.b<ChatMessage>> weakReference2 = this.f21874f;
                            if (weakReference2 != null && weakReference2.get() != null) {
                                value.m(this.f21874f.get());
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean h(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMessage)) == null) ? i(chatMessage, this.f21869a) != -1 : invokeL.booleanValue;
    }

    public final int i(ChatMessage chatMessage, LinkedList<ChatMessage> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, chatMessage, linkedList)) == null) {
            if (chatMessage == null || linkedList == null || linkedList.size() == 0) {
                return -1;
            }
            int size = linkedList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ChatMessage chatMessage2 = linkedList.get(i2);
                if (chatMessage2 != null && chatMessage.getRecordId() == chatMessage2.getRecordId()) {
                    if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                        if (chatMessage.getGroupId() != null && chatMessage2.getGroupId() != null && chatMessage.getGroupId().equals(chatMessage2.getGroupId())) {
                            return i2;
                        }
                    } else if (chatMessage.getToUserId() == chatMessage2.getToUserId()) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            VoiceSendModel voiceSendModel = new VoiceSendModel(null);
            this.f21873e = voiceSendModel;
            voiceSendModel.x(this.f21875g);
            this.f21871c = new C1079a(this);
        }
    }

    public final void l(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, chatMessage) == null) || chatMessage == null) {
            return;
        }
        this.f21869a.add(chatMessage);
    }

    public void n(String str, b.a.r0.l1.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, cVar) == null) {
            l0.c(new j(this, str), new k(this, cVar));
        }
    }

    public void o(String str, b.a.r0.l1.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, cVar) == null) {
            l0.c(new n(this, str), new o(this, cVar));
        }
    }

    public void p(String str, b.a.r0.l1.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, cVar) == null) {
            l0.c(new l(this, str), new m(this, cVar));
        }
    }

    public final void q(ChatMessage chatMessage) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatMessage) == null) || (i2 = i(chatMessage, this.f21869a)) < 0) {
            return;
        }
        this.f21869a.remove(i2);
    }

    public final void r(String str, b.a.e.m.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, aVar) == null) {
            b.a.q0.c0.c.k().d(str, aVar);
            b.a.e.f.a.f.c cVar = new b.a.e.f.a.f.c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setData(aVar.n());
            cVar.setGif(false);
            b.a.e.f.a.d.f().a(cVar);
        }
    }

    public final void s(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            b.a.e.m.d.a m2 = b.a.q0.c0.c.k().m(str);
            String str3 = str2 + 10;
            if (m2 != null && m2.w()) {
                r(str3, m2);
            } else {
                new i(this, str, str3).execute(new Void[0]);
            }
        }
    }

    public void t(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, chatMessage) == null) {
            if (chatMessage instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                l0.c(new b(this, commonGroupChatMessage, linkedList), new c(this, commonGroupChatMessage, chatMessage));
            } else if (chatMessage instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                l0.c(new d(this, personalChatMessage, linkedList2), new e(this, personalChatMessage, chatMessage));
            } else if (chatMessage instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                l0.c(new f(this, officialChatMessage, linkedList3), new g(this, officialChatMessage, chatMessage));
            }
        }
    }

    public void u(a.b<ChatMessage> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f21874f = new WeakReference<>(bVar);
        }
    }

    public void v(b.a.r0.l1.s.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.f21872d = dVar;
        }
    }

    public void y(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, chatMessage, str) == null) {
            b.a.q0.d0.a<ChatMessage> aVar = this.f21870b.get(str);
            if (aVar == null) {
                aVar = new b.a.q0.d0.a<>(str, "IM");
                aVar.j();
                aVar.i(chatMessage);
                WeakReference<a.b<ChatMessage>> weakReference = this.f21874f;
                if (weakReference != null && weakReference.get() != null) {
                    aVar.m(this.f21874f.get());
                }
                aVar.l(this.f21871c);
                if (chatMessage instanceof CommonGroupChatMessage) {
                    aVar.h(((CommonGroupChatMessage) chatMessage).getGroupId());
                } else if (chatMessage instanceof PersonalChatMessage) {
                    aVar.h(String.valueOf(f21868i));
                } else if (chatMessage instanceof OfficialChatMessage) {
                    aVar.h(String.valueOf(j));
                }
                synchronized (a.class) {
                    this.f21870b.put(str, aVar);
                }
            }
            chatMessage.setLogTime(System.currentTimeMillis());
            m(chatMessage);
            aVar.g(false);
        }
    }

    public void z(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, voiceMsgData, chatMessage) == null) {
            l(chatMessage);
            if (chatMessage != null) {
                chatMessage.getClientLogID();
                chatMessage.getCmd();
            }
            this.f21873e.y(voiceMsgData.getVoice_md5(), chatMessage);
        }
    }
}
