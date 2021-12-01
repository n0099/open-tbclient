package c.a.r0.r1.h;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.pojo.OldUserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LinkedList<ImMessageCenterPojo> linkedList, ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, linkedList, imMessageCenterPojo) == null) || linkedList == null || imMessageCenterPojo == null) {
            return;
        }
        int i2 = 0;
        int size = linkedList.size();
        while (i2 < size) {
            ImMessageCenterPojo imMessageCenterPojo2 = linkedList.get(i2);
            if (imMessageCenterPojo2 != null && imMessageCenterPojo.getLast_content_time() > imMessageCenterPojo2.getLast_content_time()) {
                break;
            }
            i2++;
        }
        linkedList.add(i2, imMessageCenterPojo);
    }

    public static void b() {
        LinkedList<ImMessageCenterPojo> e2;
        long j2;
        String str;
        ImMessageCenterPojo imMessageCenterPojo;
        ImMessageCenterPojo fromCommonMsg;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (e2 = j.f().e()) == null || e2.size() == 0) {
            return;
        }
        BdLog.i("upgradeData");
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        long j3 = 0;
        int i2 = 0;
        for (String str2 : m.t().h()) {
            if (!TextUtils.isEmpty(str2)) {
                long i3 = m.t().i(str2);
                if (j3 < i3) {
                    j3 = i3;
                }
                CommonMsgPojo j4 = m.t().j(str2);
                if (j4 != null && (fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(j4)) != null) {
                    if (fromCommonMsg.getIsFriend() == 0 && fromCommonMsg.getUnread_count() > 0) {
                        i2 = 1;
                    }
                    fromCommonMsg.setUnread_count(m.t().l(str2));
                    a(linkedList, fromCommonMsg);
                }
            }
        }
        int i4 = 0;
        for (String str3 : l.t().h()) {
            if (!TextUtils.isEmpty(str3)) {
                long i5 = l.t().i(str3);
                if (j3 < i5) {
                    j3 = i5;
                }
                CommonMsgPojo j5 = l.t().j(str3);
                if (j5 != null) {
                    j5.checkRidAndSelf();
                    ImMessageCenterPojo fromCommonMsg2 = ImMessageCenterPojo.fromCommonMsg(j5);
                    if (fromCommonMsg2 != null) {
                        int l = l.t().l(str3);
                        fromCommonMsg2.setUnread_count(l);
                        if (l > 0) {
                            i4 = 1;
                        }
                        a(linkedList2, fromCommonMsg2);
                    }
                }
            }
        }
        Iterator<ImMessageCenterPojo> it = e2.iterator();
        ImMessageCenterPojo imMessageCenterPojo2 = null;
        ImMessageCenterPojo imMessageCenterPojo3 = null;
        ImMessageCenterPojo imMessageCenterPojo4 = null;
        ImMessageCenterPojo imMessageCenterPojo5 = null;
        ImMessageCenterPojo imMessageCenterPojo6 = null;
        ImMessageCenterPojo imMessageCenterPojo7 = null;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next != null && next.getGid() != null) {
                if (next.getGid().equals(TbEnum.CustomGroupId.OFFICIAL_MERGE)) {
                    imMessageCenterPojo2 = next;
                } else if (next.getGid().equals(TbEnum.CustomGroupId.STRANGE_MERGE)) {
                    imMessageCenterPojo3 = next;
                } else if (next.getCustomGroupType() == 0 && next.getGroup_name() != null && next.getGroup_name().equals("系统消息群")) {
                    imMessageCenterPojo4 = next;
                } else if (next.getGid().equals("9") && next.getCustomGroupType() == 5) {
                    imMessageCenterPojo5 = next;
                } else if (next.getGid().equals("10") && next.getCustomGroupType() == 6) {
                    imMessageCenterPojo6 = next;
                } else if (next.getGroup_name() != null && next.getGroup_name().equals("我的私聊") && next.getCustomGroupType() == 2) {
                    imMessageCenterPojo7 = next;
                }
            }
        }
        if (imMessageCenterPojo2 == null) {
            imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
            imMessageCenterPojo2.setCustomGroupType(-8);
            imMessageCenterPojo2.setIs_hidden(1);
            imMessageCenterPojo2.setUnread_count(0);
        } else {
            imMessageCenterPojo2.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
            imMessageCenterPojo2.setCustomGroupType(-8);
            imMessageCenterPojo2.setUnread_count(i4);
            e2.remove(imMessageCenterPojo2);
        }
        if (linkedList2.size() > 0) {
            imMessageCenterPojo2.setLast_content(((ImMessageCenterPojo) linkedList2.get(0)).getLast_content());
            j2 = j3;
            imMessageCenterPojo2.setLast_content_time(((ImMessageCenterPojo) linkedList2.get(0)).getLast_content_time());
            imMessageCenterPojo2.setLast_rid(((ImMessageCenterPojo) linkedList2.get(0)).getLast_rid());
            imMessageCenterPojo2.setLast_user_name(((ImMessageCenterPojo) linkedList2.get(0)).getLast_user_name());
        } else {
            j2 = j3;
        }
        j.f().m(imMessageCenterPojo2, 2);
        if (linkedList2.size() > 0) {
            Iterator it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                ImMessageCenterPojo imMessageCenterPojo8 = (ImMessageCenterPojo) it2.next();
                imMessageCenterPojo8.setCustomGroupType(4);
                Iterator<ImMessageCenterPojo> it3 = e2.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        ImMessageCenterPojo next2 = it3.next();
                        if (next2.getGid() != null && next2.getGid().equals(imMessageCenterPojo8.getGid())) {
                            imMessageCenterPojo8.setIs_hidden(next2.getIs_hidden());
                            break;
                        }
                    }
                }
                j.f().m(imMessageCenterPojo8, 2);
            }
        }
        if (linkedList.size() > 0) {
            Iterator it4 = linkedList.iterator();
            while (it4.hasNext()) {
                ImMessageCenterPojo imMessageCenterPojo9 = (ImMessageCenterPojo) it4.next();
                imMessageCenterPojo9.setCustomGroupType(2);
                Iterator<ImMessageCenterPojo> it5 = e2.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        ImMessageCenterPojo next3 = it5.next();
                        if (next3.getGid() != null && next3.getGid().equals(imMessageCenterPojo9.getGid())) {
                            imMessageCenterPojo9.setIs_hidden(next3.getIs_hidden());
                            break;
                        }
                    }
                }
                j.f().m(imMessageCenterPojo9, 2);
            }
        }
        if (imMessageCenterPojo3 == null) {
            imMessageCenterPojo3 = new ImMessageCenterPojo();
            imMessageCenterPojo3.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
            imMessageCenterPojo3.setCustomGroupType(-7);
            imMessageCenterPojo3.setIs_hidden(1);
            imMessageCenterPojo3.setUnread_count(0);
        } else {
            imMessageCenterPojo3.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
            imMessageCenterPojo3.setCustomGroupType(-7);
            imMessageCenterPojo3.setUnread_count(i2);
            e2.remove(imMessageCenterPojo3);
        }
        if (linkedList.size() > 0) {
            Iterator it6 = linkedList.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    imMessageCenterPojo = null;
                    break;
                }
                ImMessageCenterPojo imMessageCenterPojo10 = (ImMessageCenterPojo) it6.next();
                if (imMessageCenterPojo10.getIsFriend() == 0) {
                    imMessageCenterPojo = imMessageCenterPojo10;
                    break;
                }
            }
            if (imMessageCenterPojo != null) {
                imMessageCenterPojo3.setLast_content(imMessageCenterPojo.getLast_content());
                imMessageCenterPojo3.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                imMessageCenterPojo3.setLast_rid(imMessageCenterPojo.getLast_rid());
                imMessageCenterPojo3.setLast_user_name(imMessageCenterPojo.getLast_user_name());
            }
        }
        j.f().m(imMessageCenterPojo3, 2);
        if (imMessageCenterPojo4 == null) {
            imMessageCenterPojo4 = new ImMessageCenterPojo();
        } else {
            j.f().c(imMessageCenterPojo4.getGid(), 0);
        }
        imMessageCenterPojo4.setCustomGroupType(-2);
        imMessageCenterPojo4.setIs_hidden(1);
        imMessageCenterPojo4.setPulled_msgId(c.h().i(imMessageCenterPojo4.getGid()));
        j.f().m(imMessageCenterPojo4, 2);
        if (imMessageCenterPojo5 == null) {
            imMessageCenterPojo5 = new ImMessageCenterPojo();
        }
        imMessageCenterPojo5.setCustomGroupType(5);
        imMessageCenterPojo5.setIs_hidden(1);
        imMessageCenterPojo5.setPulled_msgId(c.h().i(imMessageCenterPojo5.getGid()));
        j.f().m(imMessageCenterPojo5, 2);
        if (imMessageCenterPojo6 == null) {
            imMessageCenterPojo6 = new ImMessageCenterPojo();
        }
        imMessageCenterPojo6.setCustomGroupType(6);
        imMessageCenterPojo6.setIs_hidden(1);
        imMessageCenterPojo6.setPulled_msgId(c.h().i(imMessageCenterPojo6.getGid()));
        j.f().m(imMessageCenterPojo6, 2);
        if (imMessageCenterPojo7 == null) {
            imMessageCenterPojo7 = new ImMessageCenterPojo();
        } else {
            j.f().c(imMessageCenterPojo7.getGid(), 2);
        }
        ImMessageCenterPojo imMessageCenterPojo11 = imMessageCenterPojo7;
        imMessageCenterPojo11.setCustomGroupType(-1);
        imMessageCenterPojo11.setIs_hidden(1);
        imMessageCenterPojo11.setPulled_msgId(j2);
        j.f().m(imMessageCenterPojo11, 2);
        ImMessageCenterPojo imMessageCenterPojo12 = new ImMessageCenterPojo();
        imMessageCenterPojo12.setGid(TbEnum.CustomGroupId.GROUP_UPDATE);
        imMessageCenterPojo12.setCustomGroupType(-3);
        imMessageCenterPojo12.setIs_hidden(!c.a.q0.s.e0.b.j().g("is_show_updates", true));
        imMessageCenterPojo12.setUnread_count(d.f().g("group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change", 1));
        LinkedList<GroupNewsPojo> c2 = d.f().c(0L, 1, 0, "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change");
        if (c2 != null && c2.size() > 0) {
            imMessageCenterPojo12.setLast_content(c2.get(0).getContent());
            imMessageCenterPojo12.setLast_content_time(c2.get(0).getTime());
        }
        j.f().m(imMessageCenterPojo12, 2);
        ImMessageCenterPojo imMessageCenterPojo13 = new ImMessageCenterPojo();
        imMessageCenterPojo13.setGid(TbEnum.CustomGroupId.GROUP_VALIDATION);
        imMessageCenterPojo13.setCustomGroupType(-4);
        imMessageCenterPojo13.setIs_hidden(!c.a.q0.s.e0.b.j().g("is_show_validate", true));
        imMessageCenterPojo13.setUnread_count(d.f().g("apply_join_group", 1));
        LinkedList<GroupNewsPojo> c3 = d.f().c(0L, 1, 0, "apply_join_group");
        if (c3 != null && c3.size() > 0) {
            imMessageCenterPojo13.setLast_content(c3.get(0).getContent());
            imMessageCenterPojo13.setLast_content_time(c3.get(0).getTime());
        }
        j.f().m(imMessageCenterPojo13, 2);
        Iterator<ImMessageCenterPojo> it7 = e2.iterator();
        while (it7.hasNext()) {
            ImMessageCenterPojo next4 = it7.next();
            if (next4 != null && next4.getGid() != null && next4.getCustomGroupType() == 1) {
                next4.setUnread_count(c.h().k(next4.getGid()));
                next4.setPulled_msgId(c.h().i(next4.getGid()));
                CommonMsgPojo j6 = c.h().j(next4.getGid());
                if (j6 != null) {
                    j6.checkRidAndSelf();
                    String u = c.a.r0.r1.w.c.u(j6.getMsg_type(), j6.getContent());
                    UserData userData = new UserData();
                    try {
                        userData = (UserData) OrmObject.objectWithJsonStr(j6.getUser_info(), UserData.class);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    if (userData != null) {
                        if (c.a.d.f.p.k.isEmpty(userData.getUserId())) {
                            OldUserData oldUserData = new OldUserData();
                            try {
                                oldUserData = (OldUserData) OrmObject.objectWithJsonStr(j6.getUser_info(), OldUserData.class);
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            if (oldUserData != null) {
                                oldUserData.setToUserData(userData);
                            }
                        }
                        str = userData.getName_show();
                    } else {
                        str = "";
                    }
                    next4.setLast_content(u);
                    next4.setLast_user_name(str);
                    next4.setLast_rid(j6.getRid());
                    next4.setLast_content_time(j6.getCreate_time() * 1000);
                }
                j.f().m(next4, 2);
            }
        }
        h.d().c("delete from tb_message_center where custom_group_type is null or custom_group_type=0 or gid in (0,2,3,6,11,12)");
    }
}
