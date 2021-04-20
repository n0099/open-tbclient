package com.baidu.tbadk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.chat.GroupMsgImageActivity;
import com.baidu.tieba.im.message.ResponseAddGroupUserMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.wxapi.WXEntryActivity;
import d.b.h0.r.d0.b;
import d.b.i0.e1.c;
import d.b.i0.e1.v.a.d;
import d.b.i0.e1.v.a.e;
import d.b.i0.e1.v.a.f;
/* loaded from: classes3.dex */
public class TbLaunchStatic {
    public static String Tag = "tag";

    static {
        initRegisterIntent();
        initRegisterTask();
        initRegisterListeners();
    }

    public static void initRegisterIntent() {
        TbadkApplication.getInst().RegisterIntent(GroupMsgImageActivityConfig.class, GroupMsgImageActivity.class);
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(WXEntryActivityConfig.class, WXEntryActivity.class);
    }

    public static void initRegisterListeners() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.TbLaunchStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    long l = b.j().l("clear_redundance_files_time", 0L);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - l > 86400000) {
                        PluginPackageManager.O().C();
                        b.j().w("clear_redundance_files_time", currentTimeMillis);
                    }
                }
            }
        });
    }

    public static void initRegisterTask() {
        c.b(202004, ResponseDelSystemMessage.class, false);
        c.b(103112, ResponseRemoveMembersMessage.class, false);
        c.b(202001, ResponseCommitGroupMessage.class, false);
        c.b(103111, ResponseAddGroupUserMessage.class, false);
        c.b(103105, ResponseUpgradeMemberGroupMessage.class, false);
        c.b(103008, ResponseUserPermissionMessage.class, false).f(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c.b(103102, ResponseUpdateGroupMessage.class, false).f(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c.b(103104, ResponseDismissGroupMessage.class, false);
        c.a(2001142, d.class);
        c.a(2001145, f.class);
        c.a(2001148, e.class);
    }
}
