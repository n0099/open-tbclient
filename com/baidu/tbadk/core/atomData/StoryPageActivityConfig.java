package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.story.UserStoryData;
import com.baidu.tieba.story.d;
import com.baidu.tieba.story.f;
import com.baidu.tieba.story.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class StoryPageActivityConfig extends IntentConfig {
    public static final String FROM = "from";
    public static final String INDEX = "index";
    public static final String USER_LIST = "user_list";
    public com.baidu.tieba.story.a mDoneCallback;
    private d mStoryModel;

    /* loaded from: classes.dex */
    public static class a {
        public static int Tc = 1;
        public static int FROM_FRS = 2;
    }

    public StoryPageActivityConfig(Context context) {
        super(context);
    }

    public StoryPageActivityConfig createNormalConfig(ArrayList<MetaData> arrayList, int i, long j, long j2) {
        Intent intent = getIntent();
        intent.putExtra(USER_LIST, arrayList);
        intent.putExtra("index", i);
        intent.putExtra("forum_id", j);
        intent.putExtra("thread_id", j2);
        intent.putExtra("from", getContext().getClass().getSimpleName());
        return this;
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean asynStart() {
        if (this.mDoneCallback != null && (i.X(getContext()) instanceof TbPageContext)) {
            Intent intent = getIntent();
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra(USER_LIST);
            int intExtra = intent.getIntExtra("index", 0);
            long longExtra = intent.getLongExtra("forum_id", -1L);
            long longExtra2 = intent.getLongExtra("thread_id", -1L);
            this.mStoryModel = makeStoryModel(i.X(getContext()));
            if (this.mStoryModel != null) {
                return l.bnU().a(this.mStoryModel, arrayList, intExtra, longExtra, longExtra2, new f() { // from class: com.baidu.tbadk.core.atomData.StoryPageActivityConfig.1
                    @Override // com.baidu.tieba.story.f
                    public void a(int i, String str, MetaData metaData, List<UserStoryData> list) {
                        Class<?> intentClass = TbadkCoreApplication.getInst().getIntentClass(StoryPageActivityConfig.this.getConfig().getClass());
                        if (intentClass != null) {
                            StoryPageActivityConfig.this.savePreLoadData(list);
                            l.bnU().c(metaData);
                            StoryPageActivityConfig.this.getConfig().setComponentClass(intentClass);
                            StoryPageActivityConfig.this.getConfig().run();
                            if (StoryPageActivityConfig.this.mDoneCallback != null) {
                                StoryPageActivityConfig.this.mDoneCallback.a(StoryPageActivityConfig.this.getSelectedUser(), true, "");
                            }
                            StoryPageActivityConfig.this.unRegisterListener();
                        }
                    }
                });
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterListener() {
        e.fQ().post(new Runnable() { // from class: com.baidu.tbadk.core.atomData.StoryPageActivityConfig.2
            @Override // java.lang.Runnable
            public void run() {
                if (StoryPageActivityConfig.this.mStoryModel != null) {
                    StoryPageActivityConfig.this.mStoryModel.onDestory();
                }
            }
        });
    }

    public StoryPageActivityConfig setDoneCallback(com.baidu.tieba.story.a aVar) {
        this.mDoneCallback = aVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IntentConfig getConfig() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePreLoadData(List<UserStoryData> list) {
        if (!v.v(list)) {
            for (UserStoryData userStoryData : list) {
                if (userStoryData != null && userStoryData.storyUser != null) {
                    l.bnU().a(userStoryData.storyUser.getUserIdLong(), userStoryData);
                }
            }
        }
    }

    private d makeStoryModel(com.baidu.adp.base.e<?> eVar) {
        if (this.mStoryModel == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_STORY_FACTORY, com.baidu.tieba.story.e.class);
            if (runTask.getData() == null) {
                return null;
            }
            this.mStoryModel = ((com.baidu.tieba.story.e) runTask.getData()).i(eVar);
        }
        return this.mStoryModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MetaData getSelectedUser() {
        Intent intent = getIntent();
        return (MetaData) v.c((ArrayList) intent.getSerializableExtra(USER_LIST), intent.getIntExtra("index", 0));
    }
}
