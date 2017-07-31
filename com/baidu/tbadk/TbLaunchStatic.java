package com.baidu.tbadk;

import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.GroupMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.coreExtra.share.d;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
import com.baidu.tieba.im.c;
import com.baidu.tieba.im.chat.GroupMsgImageActivity;
import com.baidu.tieba.im.d.a.e;
import com.baidu.tieba.im.d.a.f;
import com.baidu.tieba.im.d.a.g;
import com.baidu.tieba.im.message.ResponseAddGroupUserMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.wxapi.WXEntryActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbLaunchStatic {
    static {
        initRegisterIntent();
        initRegisterTask();
        initRegisterListeners();
    }

    private static void initRegisterIntent() {
        TbadkApplication.getInst().RegisterIntent(GroupMsgImageActivityConfig.class, GroupMsgImageActivity.class);
        TbadkCoreApplication.getInst().RegisterOrUpdateIntent(WXEntryActivityConfig.class, WXEntryActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ChangeSystemPhotoActivityConfig.class, ChangeSystemPhotoActivity.class);
    }

    private static void initRegisterTask() {
        c.b(202004, ResponseDelSystemMessage.class, false);
        c.b(103112, ResponseRemoveMembersMessage.class, false);
        c.b(202001, ResponseCommitGroupMessage.class, false);
        c.b(103111, ResponseAddGroupUserMessage.class, false);
        c.b(103105, ResponseUpgradeMemberGroupMessage.class, false);
        c.b(103008, ResponseUserPermissionMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c.b(103102, ResponseUpdateGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c.b(103104, ResponseDismissGroupMessage.class, false);
        c.b(CmdConfigCustom.CMD_LOAD_DRAFT_GROUP, e.class);
        c.b(CmdConfigCustom.CMD_LOAD_HISTORY_GROUP, g.class);
        c.b(CmdConfigCustom.CMD_SAVE_DRAFT_GROUP, f.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new CustomMessageTask.CustomRunnable<ShareDialogConfig>() { // from class: com.baidu.tbadk.TbLaunchStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ShareDialogConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof ShareDialogConfig)) {
                    ShareDialogConfig data = customMessage.getData();
                    d dVar = new d(data.getContext(), data.isLandscape);
                    dVar.a(data.shareItem, data.showLocation);
                    if (data.mtjStatistics != null) {
                        dVar.b(data.mtjStatistics);
                    }
                    if (data.isSetCopyLink) {
                        dVar.setIsCopyLink(data.isCopyLink);
                    }
                    if (data.copyLinkListener != null) {
                        dVar.setCopyLinkListener(data.copyLinkListener);
                    }
                    if (data.onDismissListener != null) {
                        dVar.a(data.onDismissListener);
                    }
                    if (data.textViewList != null && data.textViewList.size() > 0) {
                        Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = data.textViewList.iterator();
                        while (it.hasNext()) {
                            Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                            TextView I = dVar.I(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue());
                            if (data.isInsertBack) {
                                dVar.a(I, dVar.AY(), (View.OnClickListener) ((Pair) next.second).second);
                            } else {
                                dVar.a(I, (View.OnClickListener) ((Pair) next.second).second);
                            }
                        }
                    }
                    dVar.show();
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void initRegisterListeners() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.TbLaunchStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    long j = b.getInstance().getLong("clear_redundance_files_time", 0L);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - j > 86400000) {
                        PluginPackageManager.jE().jU();
                        b.getInstance().putLong("clear_redundance_files_time", currentTimeMillis);
                    }
                }
            }
        });
    }
}
