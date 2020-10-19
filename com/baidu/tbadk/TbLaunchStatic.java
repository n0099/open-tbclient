package com.baidu.tbadk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.im.c;
import com.baidu.tieba.im.c.a.e;
import com.baidu.tieba.im.c.a.f;
import com.baidu.tieba.im.c.a.g;
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
/* loaded from: classes21.dex */
public class TbLaunchStatic {
    public static String Tag = "tag";

    static {
        initRegisterIntent();
        initRegisterTask();
        initRegisterListeners();
    }

    private static void initRegisterIntent() {
        TbadkApplication.getInst().RegisterIntent(GroupMsgImageActivityConfig.class, GroupMsgImageActivity.class);
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(WXEntryActivityConfig.class, WXEntryActivity.class);
    }

    private static void initRegisterTask() {
        c.b(CmdConfigSocket.CMD_DELETE_GROUP_MSG, ResponseDelSystemMessage.class, false);
        c.b(CmdConfigSocket.CMD_REMOVE_MEMBERS, ResponseRemoveMembersMessage.class, false);
        c.b(CmdConfigSocket.CMD_GROUP_CHAT_MSG, ResponseCommitGroupMessage.class, false);
        c.b(CmdConfigSocket.CMD_ADD_GROUP_USER, ResponseAddGroupUserMessage.class, false);
        c.b(CmdConfigSocket.CMD_UPGRADE_MEMBER_GROUP, ResponseUpgradeMemberGroupMessage.class, false);
        c.b(CmdConfigSocket.CMD_GET_USER_PERMISSION, ResponseUserPermissionMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c.b(CmdConfigSocket.CMD_UPDATE_GROUP, ResponseUpdateGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c.b(CmdConfigSocket.CMD_DISSMISS_GROUP, ResponseDismissGroupMessage.class, false);
        c.b(CmdConfigCustom.CMD_LOAD_DRAFT_GROUP, e.class);
        c.b(CmdConfigCustom.CMD_LOAD_HISTORY_GROUP, g.class);
        c.b(CmdConfigCustom.CMD_SAVE_DRAFT_GROUP, f.class);
    }

    private static void initRegisterListeners() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.TbLaunchStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    long j = b.blO().getLong(SharedPrefConfig.CLEAR_REDUNDANCE_FILES_TIME, 0L);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - j > 86400000) {
                        PluginPackageManager.pT().qj();
                        b.blO().putLong(SharedPrefConfig.CLEAR_REDUNDANCE_FILES_TIME, currentTimeMillis);
                    }
                }
            }
        });
    }
}
