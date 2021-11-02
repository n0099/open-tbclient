package b.a.q0.t.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<ImMessageCenterPojo> f13902a;

    /* renamed from: b  reason: collision with root package name */
    public int f13903b;

    /* renamed from: c  reason: collision with root package name */
    public int f13904c;

    /* renamed from: d  reason: collision with root package name */
    public int f13905d;

    /* renamed from: e  reason: collision with root package name */
    public int f13906e;

    /* renamed from: f  reason: collision with root package name */
    public int f13907f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13908g;

    /* renamed from: h  reason: collision with root package name */
    public int f13909h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13910i;
    public final CustomMessageListener j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13911a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13911a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001120) {
                this.f13911a.p(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016002) {
                this.f13911a.o(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.f13911a.m(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.f13911a.q(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.f13911a.n(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016010) {
                this.f13911a.s();
            } else if (customResponsedMessage.getCmd() == 2016011) {
                this.f13911a.r();
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13902a = new LinkedList<>();
        this.f13903b = 0;
        this.f13904c = 0;
        this.f13905d = 0;
        this.f13906e = 0;
        this.f13907f = 0;
        this.f13908g = false;
        this.f13909h = 0;
        this.f13910i = false;
        this.j = new a(this, 0);
    }

    public static c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (k == null) {
                synchronized (c.class) {
                    if (k == null) {
                        k = new c();
                    }
                }
            }
            return k;
        }
        return (c) invokeV.objValue;
    }

    public final void h(List<ImMessageCenterPojo> list) {
        int unread_count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        int i2 = 0;
        boolean z = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            ImMessageCenterPojo imMessageCenterPojo = list.get(i3);
            if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
                if (imMessageCenterPojo.getCustomGroupType() != -4 && imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -7) {
                    if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        if (d.d().n()) {
                            GroupSettingItemData a2 = b.a.r0.l1.t.b.k().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (a2 != null) {
                                if (a2.isAcceptNotify()) {
                                    unread_count = imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                unread_count = imMessageCenterPojo.getUnread_count();
                            }
                            i2 += unread_count;
                        }
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        if (d.d().p()) {
                            PersonalSettingItemData a3 = b.a.r0.l1.t.e.j().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (a3 != null) {
                                if (a3.isAcceptNotify()) {
                                    unread_count = imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                unread_count = imMessageCenterPojo.getUnread_count();
                            }
                            i2 += unread_count;
                        }
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        if (imMessageCenterPojo.getUserType() == 4) {
                            if (d.d().p()) {
                                unread_count = imMessageCenterPojo.getUnread_count();
                                i2 += unread_count;
                            }
                        }
                    } else if (imMessageCenterPojo.getCustomGroupType() != -8) {
                    }
                }
                z = true;
            }
        }
        if (d.d().e() == 0) {
            i2 = 0;
        }
        boolean z2 = i2 > 0 ? z : false;
        this.f13909h = i2;
        this.f13910i = z2;
    }

    public final void i(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            boolean z = i2 > 0 || i3 > 0 || i4 > 0 || i5 > 0;
            int i6 = (i2 <= 0 || !d.d().w()) ? 0 : i2 + 0;
            if (i3 > 0 && d.d().o()) {
                i6 += i3;
            }
            if (i4 > 0 && d.d().t()) {
                i6 += i4;
            }
            if (i5 > 0 && d.d().r()) {
                i6 += i5;
            }
            if (d.d().e() == 0) {
                i6 = 0;
            }
            this.f13908g = i6 > 0 ? z : false;
            this.f13907f = i6;
            this.f13903b = i2;
            this.f13904c = i3;
            this.f13905d = i4;
            this.f13906e = i5;
        }
    }

    public final boolean j(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && ((!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || !TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) && imMessageCenterPojo.getLast_content_time() != 0)) {
                if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    return !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name());
                } else if (imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4) {
                    return true;
                } else {
                    if ((imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4) || imMessageCenterPojo.getCustomGroupType() == -8 || imMessageCenterPojo.getCustomGroupType() == -7) {
                        return true;
                    }
                    if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
                        return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            u();
            MessageManager.getInstance().registerStickyMode(2921002);
            MessageManager.getInstance().registerListener(2001120, this.j);
            MessageManager.getInstance().registerListener(2016002, this.j);
            MessageManager.getInstance().registerListener(2016004, this.j);
            MessageManager.getInstance().registerListener(2016001, this.j);
            MessageManager.getInstance().registerListener(2016007, this.j);
            MessageManager.getInstance().registerListener(2016011, this.j);
            MessageManager.getInstance().registerListener(2016010, this.j);
        }
    }

    public final void m(CustomResponsedMessage<?> customResponsedMessage) {
        MemoryChangedMessage memoryChangedMessage;
        ImMessageCenterPojo data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof MemoryChangedMessage) || (data = (memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage).getData()) == null || TextUtils.isEmpty(data.getGid())) {
            return;
        }
        if (memoryChangedMessage.getType() == 1) {
            t(this.f13902a, data);
            if (j(data)) {
                this.f13902a.add(data);
            }
        } else if (memoryChangedMessage.getType() == 2) {
            t(this.f13902a, data);
        }
        h(this.f13902a);
        v();
    }

    public final void n(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) {
            this.f13902a.clear();
            h(this.f13902a);
            v();
        }
    }

    public final void o(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void p(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
            return;
        }
        NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
        i(newsNotifyMessage.getMsgAgree(), newsNotifyMessage.getMsgAtme(), newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgFans());
        v();
    }

    public final void q(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 1 || data == null) {
                return;
            }
            this.f13902a.clear();
            for (ImMessageCenterPojo imMessageCenterPojo : data) {
                if (imMessageCenterPojo != null && j(imMessageCenterPojo)) {
                    this.f13902a.add(imMessageCenterPojo);
                }
            }
            h(this.f13902a);
            v();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            i(this.f13903b, this.f13904c, this.f13905d, this.f13906e);
            h(this.f13902a);
            v();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            i(this.f13903b, this.f13904c, this.f13905d, this.f13906e);
            h(this.f13902a);
            v();
        }
    }

    public final void t(LinkedList<ImMessageCenterPojo> linkedList, ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, linkedList, imMessageCenterPojo) == null) || linkedList == null || linkedList.size() <= 0 || imMessageCenterPojo == null) {
            return;
        }
        Iterator<ImMessageCenterPojo> it = linkedList.iterator();
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next != null && next.getGid() == imMessageCenterPojo.getGid()) {
                it.remove();
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f13902a.clear();
            this.f13903b = 0;
            this.f13904c = 0;
            this.f13905d = 0;
            this.f13906e = 0;
            this.f13907f = 0;
            this.f13908g = false;
            this.f13909h = 0;
            this.f13910i = false;
            this.f13909h = 0;
            this.f13910i = false;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
            newsRemindMessage.setMsgAgreeCount(this.f13903b);
            newsRemindMessage.setMsgAtCount(this.f13904c);
            newsRemindMessage.setMsgReplyCount(this.f13905d);
            newsRemindMessage.setMsgFansCount(this.f13906e);
            newsRemindMessage.setMsgCount(this.f13907f);
            newsRemindMessage.setHasMsgRemind(this.f13908g);
            newsRemindMessage.setChatCount(this.f13909h);
            newsRemindMessage.setHasChatRemind(this.f13910i);
            MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
        }
    }
}
