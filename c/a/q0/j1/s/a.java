package c.a.q0.j1.s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.b1.h0;
import c.a.p0.b1.k0;
import c.a.p0.c0.a;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f21000h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Long f21001i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile long f21002j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<ChatMessage> f21003a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, c.a.p0.c0.a<ChatMessage>> f21004b;

    /* renamed from: c  reason: collision with root package name */
    public a.d f21005c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.j1.s.d f21006d;

    /* renamed from: e  reason: collision with root package name */
    public VoiceSendModel f21007e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<a.b<ChatMessage>> f21008f;

    /* renamed from: g  reason: collision with root package name */
    public VoiceSendModel.b f21009g;

    /* renamed from: c.a.q0.j1.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0977a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21010a;

        /* renamed from: c.a.q0.j1.s.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0978a extends h0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f21011a;

            public C0978a(C0977a c0977a, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0977a, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21011a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.p0.b1.h0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.q0.j1.h.c.h().o(this.f21011a.getGroupId(), String.valueOf(this.f21011a.getRecordId()), String.valueOf(this.f21011a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* renamed from: c.a.q0.j1.s.a$a$b */
        /* loaded from: classes3.dex */
        public class b implements c.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f21012a;

            public b(C0977a c0977a, CommonGroupChatMessage commonGroupChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0977a, commonGroupChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21012a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f21012a);
                }
            }
        }

        /* renamed from: c.a.q0.j1.s.a$a$c */
        /* loaded from: classes3.dex */
        public class c extends h0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f21013a;

            public c(C0977a c0977a, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0977a, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21013a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.p0.b1.h0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.q0.j1.h.m.t().s(this.f21013a.getUserId(), this.f21013a.getToUserId(), String.valueOf(this.f21013a.getRecordId()), String.valueOf(this.f21013a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* renamed from: c.a.q0.j1.s.a$a$d */
        /* loaded from: classes3.dex */
        public class d implements c.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f21014a;

            public d(C0977a c0977a, PersonalChatMessage personalChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0977a, personalChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21014a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f21014a);
                }
            }
        }

        /* renamed from: c.a.q0.j1.s.a$a$e */
        /* loaded from: classes3.dex */
        public class e extends h0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f21015a;

            public e(C0977a c0977a, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0977a, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21015a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.p0.b1.h0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.q0.j1.h.l.t().s(this.f21015a.getUserId(), this.f21015a.getToUserId(), String.valueOf(this.f21015a.getRecordId()), String.valueOf(this.f21015a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* renamed from: c.a.q0.j1.s.a$a$f */
        /* loaded from: classes3.dex */
        public class f implements c.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f21016a;

            public f(C0977a c0977a, OfficialChatMessage officialChatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0977a, officialChatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21016a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f21016a);
                }
            }
        }

        public C0977a(a aVar) {
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
            this.f21010a = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0095, code lost:
            c.a.p0.s.z.a.a("im", r0.getClientLogID(), r0.getCmd(), "up_pic_ret", r13.error_code, r13.error_msg, new java.lang.Object[0]);
         */
        @Override // c.a.p0.c0.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void a(String str, ImageUploadResult imageUploadResult) {
            c.a.p0.c0.a aVar;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, imageUploadResult) == null) {
                synchronized (this) {
                    synchronized (a.class) {
                        aVar = (c.a.p0.c0.a) this.f21010a.f21004b.remove(str);
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
                        c.a.p0.s.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", 0, null, new Object[0]);
                        String str2 = null;
                        String str3 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                        if (imageUploadResult.picInfo.smallPic != null) {
                            str2 = imageUploadResult.picInfo.smallPic.picUrl;
                            i3 = imageUploadResult.picInfo.smallPic.width;
                            i2 = imageUploadResult.picInfo.smallPic.height;
                            this.f21010a.s(str, str2);
                        } else {
                            i2 = 0;
                        }
                        chatMessage.setContent(a.f(str3, str2, i3, i2));
                        a.j().t(chatMessage);
                        if (this.f21010a.f21006d != null) {
                            this.f21010a.f21006d.a(1);
                        }
                    }
                    c.a.p0.s.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        k0.c(new C0978a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
                    } else if (chatMessage instanceof PersonalChatMessage) {
                        PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        k0.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        k0.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends h0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f21017a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f21018b;

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
            this.f21017a = commonGroupChatMessage;
            this.f21018b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.p0.b1.h0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.q0.j1.h.c.h().l(this.f21017a.getGroupId(), this.f21018b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.a.p0.b1.n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f21019a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f21020b;

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
            this.f21019a = commonGroupChatMessage;
            this.f21020b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f21019a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.f21019a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.f21019a.getGroupId(), this.f21020b.getCustomGroupType(), this.f21020b, 3)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends h0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f21021a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f21022b;

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
            this.f21021a = personalChatMessage;
            this.f21022b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.p0.b1.h0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.q0.j1.h.m.t().m(c.a.q0.j1.w.c.m(this.f21021a), this.f21022b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements c.a.p0.b1.n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f21023a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f21024b;

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
            this.f21023a = personalChatMessage;
            this.f21024b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f21023a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.f21023a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f21023a.getToUserId()), 2, this.f21024b, 3)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends h0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f21025a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f21026b;

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
            this.f21025a = officialChatMessage;
            this.f21026b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.p0.b1.h0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.q0.j1.h.l.t().m(c.a.q0.j1.w.c.m(this.f21025a), this.f21026b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements c.a.p0.b1.n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f21027a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f21028b;

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
            this.f21027a = officialChatMessage;
            this.f21028b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f21027a.setLogTime(System.currentTimeMillis());
                MessageManager.getInstance().sendMessage(this.f21027a);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f21027a.getToUserId()), 4, this.f21028b, 3)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements VoiceSendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21029a;

        /* renamed from: c.a.q0.j1.s.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0979a extends h0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f21030a;

            public C0979a(h hVar, CommonGroupChatMessage commonGroupChatMessage) {
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
                this.f21030a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.p0.b1.h0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.q0.j1.h.c.h().o(this.f21030a.getGroupId(), String.valueOf(this.f21030a.getRecordId()), String.valueOf(this.f21030a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements c.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommonGroupChatMessage f21031a;

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
                this.f21031a = commonGroupChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f21031a);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c extends h0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f21032a;

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
                this.f21032a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.p0.b1.h0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.q0.j1.h.m.t().s(this.f21032a.getUserId(), this.f21032a.getToUserId(), String.valueOf(this.f21032a.getRecordId()), String.valueOf(this.f21032a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class d implements c.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f21033a;

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
                this.f21033a = personalChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f21033a);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class e extends h0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f21034a;

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
                this.f21034a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.p0.b1.h0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.q0.j1.h.l.t().s(this.f21034a.getUserId(), this.f21034a.getToUserId(), String.valueOf(this.f21034a.getRecordId()), String.valueOf(this.f21034a.getMsgId()), 2)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class f implements c.a.p0.b1.n<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OfficialChatMessage f21035a;

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
                this.f21035a = officialChatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.b1.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    a.m(this.f21035a);
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
            this.f21029a = aVar;
        }

        @Override // com.baidu.tieba.im.sendmessage.VoiceSendModel.b
        public void a(String str, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, chatMessage) == null) {
                try {
                    a.j().q(chatMessage);
                    if (chatMessage != null) {
                        if (str != null && str.length() > 0) {
                            VoiceMsgData n = c.a.q0.j1.w.c.n(chatMessage);
                            if (n != null) {
                                n.setVoice_md5(str);
                                String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
                                chatMessage.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                            }
                            c.a.p0.s.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                            a.j().t(chatMessage);
                            if (this.f21029a.f21006d != null) {
                                this.f21029a.f21006d.a(2);
                                return;
                            }
                            return;
                        }
                        c.a.p0.s.z.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                        if (chatMessage instanceof CommonGroupChatMessage) {
                            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                            k0.c(new C0979a(this, commonGroupChatMessage), new b(this, commonGroupChatMessage));
                        } else if (chatMessage instanceof PersonalChatMessage) {
                            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                            k0.c(new c(this, personalChatMessage), new d(this, personalChatMessage));
                        } else if (chatMessage instanceof OfficialChatMessage) {
                            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                            k0.c(new e(this, officialChatMessage), new f(this, officialChatMessage));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends BdAsyncTask<Void, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21036a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21037b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f21038c;

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
            this.f21038c = aVar;
            this.f21036a = str;
            this.f21037b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? BitmapFactory.decodeFile(this.f21036a) : (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                this.f21038c.r(this.f21037b, new c.a.e.l.d.a(bitmap, false));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends h0<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21039a;

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
            this.f21039a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.h0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.q0.j1.h.c.h().f(this.f21039a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class k implements c.a.p0.b1.n<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.j1.s.c f21040a;

        public k(a aVar, c.a.q0.j1.s.c cVar) {
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
            this.f21040a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
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
                        String f2 = c.a.q0.j1.w.c.f(str3, true);
                        if (f2 != null) {
                            linkedHashMap2.put(str2, f2);
                        }
                        String f3 = c.a.q0.j1.w.c.f(str3, false);
                        if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = f3;
                            imageUrlData.urlType = 10;
                            hashMap.put(f2, imageUrlData);
                        }
                    }
                }
                this.f21040a.a(linkedHashMap2, hashMap);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends h0<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21041a;

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
            this.f21041a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.h0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.q0.j1.h.m.t().f(this.f21041a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class m implements c.a.p0.b1.n<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.j1.s.c f21042a;

        public m(a aVar, c.a.q0.j1.s.c cVar) {
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
            this.f21042a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
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
                        String f2 = c.a.q0.j1.w.c.f(str3, true);
                        if (f2 != null) {
                            linkedHashMap2.put(str2, f2);
                        }
                        String f3 = c.a.q0.j1.w.c.f(str3, false);
                        if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = f3;
                            imageUrlData.urlType = 10;
                            hashMap.put(f2, imageUrlData);
                        }
                    }
                }
                this.f21042a.a(linkedHashMap2, hashMap);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n extends h0<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21043a;

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
            this.f21043a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.h0
        /* renamed from: a */
        public LinkedHashMap<String, String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.q0.j1.h.l.t().f(this.f21043a, 2, null, 1000) : (LinkedHashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class o implements c.a.p0.b1.n<LinkedHashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.j1.s.c f21044a;

        public o(a aVar, c.a.q0.j1.s.c cVar) {
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
            this.f21044a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
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
                        String f2 = c.a.q0.j1.w.c.f(str3, true);
                        if (f2 != null) {
                            linkedHashMap2.put(str2, f2);
                        }
                        String f3 = c.a.q0.j1.w.c.f(str3, false);
                        if (!TextUtils.isEmpty(f3) && !TextUtils.isEmpty(f2)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = f3;
                            imageUrlData.urlType = 10;
                            hashMap.put(f2, imageUrlData);
                        }
                    }
                }
                this.f21044a.a(linkedHashMap2, hashMap);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(26705620, "Lc/a/q0/j1/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(26705620, "Lc/a/q0/j1/s/a;");
                return;
            }
        }
        f21001i = 0L;
        f21002j = 0L;
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
        this.f21003a = new LinkedList<>();
        this.f21004b = new HashMap<>();
        this.f21009g = new h(this);
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
            if (f21000h == null) {
                synchronized (a.class) {
                    if (f21000h == null) {
                        f21000h = new a();
                    }
                }
            }
            return f21000h;
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
            f21002j = j2;
        }
    }

    public static void x(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65547, null, j2) == null) {
            f21001i = Long.valueOf(j2);
        }
    }

    public boolean g(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chatMessage)) == null) {
            HashMap<String, c.a.p0.c0.a<ChatMessage>> hashMap = this.f21004b;
            if (hashMap != null && chatMessage != null) {
                for (Map.Entry<String, c.a.p0.c0.a<ChatMessage>> entry : hashMap.entrySet()) {
                    c.a.p0.c0.a<ChatMessage> value = entry.getValue();
                    if (value != null && value.f() != null) {
                        ChatMessage f2 = value.f();
                        if (chatMessage.getRecordId() != f2.getRecordId()) {
                            continue;
                        } else if (chatMessage.getCustomGroupType() != 2 && chatMessage.getCustomGroupType() != 4) {
                            if (chatMessage.getGroupId() != null && f2.getGroupId() != null && chatMessage.getGroupId().equals(f2.getGroupId())) {
                                WeakReference<a.b<ChatMessage>> weakReference = this.f21008f;
                                if (weakReference != null && weakReference.get() != null) {
                                    value.m(this.f21008f.get());
                                }
                                return true;
                            }
                        } else if (chatMessage.getToUserId() == f2.getToUserId()) {
                            WeakReference<a.b<ChatMessage>> weakReference2 = this.f21008f;
                            if (weakReference2 != null && weakReference2.get() != null) {
                                value.m(this.f21008f.get());
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMessage)) == null) ? i(chatMessage, this.f21003a) != -1 : invokeL.booleanValue;
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
            this.f21007e = voiceSendModel;
            voiceSendModel.x(this.f21009g);
            this.f21005c = new C0977a(this);
        }
    }

    public final void l(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, chatMessage) == null) || chatMessage == null) {
            return;
        }
        this.f21003a.add(chatMessage);
    }

    public void n(String str, c.a.q0.j1.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, cVar) == null) {
            k0.c(new j(this, str), new k(this, cVar));
        }
    }

    public void o(String str, c.a.q0.j1.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, cVar) == null) {
            k0.c(new n(this, str), new o(this, cVar));
        }
    }

    public void p(String str, c.a.q0.j1.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, cVar) == null) {
            k0.c(new l(this, str), new m(this, cVar));
        }
    }

    public final void q(ChatMessage chatMessage) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatMessage) == null) || (i2 = i(chatMessage, this.f21003a)) < 0) {
            return;
        }
        this.f21003a.remove(i2);
    }

    public final void r(String str, c.a.e.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, aVar) == null) {
            c.a.p0.b0.c.k().d(str, aVar);
            c.a.e.e.a.f.c cVar = new c.a.e.e.a.f.c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setData(aVar.n());
            cVar.setGif(false);
            c.a.e.e.a.d.g().a(cVar);
        }
    }

    public final void s(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            c.a.e.l.d.a m2 = c.a.p0.b0.c.k().m(str);
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
                k0.c(new b(this, commonGroupChatMessage, linkedList), new c(this, commonGroupChatMessage, chatMessage));
            } else if (chatMessage instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                k0.c(new d(this, personalChatMessage, linkedList2), new e(this, personalChatMessage, chatMessage));
            } else if (chatMessage instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                k0.c(new f(this, officialChatMessage, linkedList3), new g(this, officialChatMessage, chatMessage));
            }
        }
    }

    public void u(a.b<ChatMessage> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f21008f = new WeakReference<>(bVar);
        }
    }

    public void v(c.a.q0.j1.s.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.f21006d = dVar;
        }
    }

    public void y(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, chatMessage, str) == null) {
            c.a.p0.c0.a<ChatMessage> aVar = this.f21004b.get(str);
            if (aVar == null) {
                aVar = new c.a.p0.c0.a<>(str, "IM");
                aVar.j();
                aVar.i(chatMessage);
                WeakReference<a.b<ChatMessage>> weakReference = this.f21008f;
                if (weakReference != null && weakReference.get() != null) {
                    aVar.m(this.f21008f.get());
                }
                aVar.l(this.f21005c);
                if (chatMessage instanceof CommonGroupChatMessage) {
                    aVar.h(((CommonGroupChatMessage) chatMessage).getGroupId());
                } else if (chatMessage instanceof PersonalChatMessage) {
                    aVar.h(String.valueOf(f21001i));
                } else if (chatMessage instanceof OfficialChatMessage) {
                    aVar.h(String.valueOf(f21002j));
                }
                synchronized (a.class) {
                    this.f21004b.put(str, aVar);
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
            this.f21007e.y(voiceMsgData.getVoice_md5(), chatMessage);
        }
    }
}
